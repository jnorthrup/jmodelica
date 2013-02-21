/*
    Copyright (C) 2009 Modelon AB

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License version 3 as published
    by the Free Software Foundation, or optionally, under the terms of the
    Common Public License version 1.0 as published by IBM.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License, or the Common Public License, for more details.

    You should have received copies of the GNU General Public License
    and the Common Public License along with this program.  If not,
    see <http://www.gnu.org/licenses/> or
    <http://www.ibm.com/developerworks/library/os-cpl.html/> respectively.
*/

#include <sundials/sundials_math.h>
#include <sundials/sundials_direct.h>
#include <nvector/nvector_serial.h>
#include <kinsol/kinsol_direct.h>
#include <kinsol/kinsol_impl.h>

/* #include <kinsol_jmod_impl.h>
#include <kinpinv.h>  */

#include "jmi.h"
#include "fmi.h"
#include "jmi_kinsol_solver.h"
#include "jmi_block_residual.h"
#include "jmi_util.h"

#include "jmi_brent_search.h"

/* RCONST from SUNDIALS and defines a compatible type, usually double precision */
#define ONE RCONST(1.0)
#define Ith(v,i)    NV_Ith_S(v,i)

static int jmi_kin_lsolve(struct KINMemRec * kin_mem, N_Vector x, N_Vector b, realtype *res_norm);
static void jmi_update_f_scale(jmi_block_residual_t *block);
static int jmi_kin_lsetup(struct KINMemRec * kin_mem);

int kin_dF(int N, N_Vector u, N_Vector fu, DlsMat J, jmi_block_residual_t * block, N_Vector tmp1, N_Vector tmp2);

/* Interface to the residual function that is compatible with Brent search */
int brentf(realtype y, realtype* f, void* problem_data) {
	jmi_block_residual_t *block = problem_data;
    int ret = 0;
    
    /* Increment function calls counter */
    block->nb_fevals++;

    /* Check that arguments are valid */
    if ((y- y) != 0) {
       jmi_log_warning(block->jmi, "Not a number in arguments to equation block %d", block->index);
       return -1;
	}

	/*Evaluate the residual*/
	ret = block->F(block->jmi,&y,f,JMI_BLOCK_EVALUATE);
    if(ret) {
        jmi_log_warning(block->jmi, "Error code returned from equation block %d", block->index);
        return ret;
    }
    /* Check that outputs are valid */    
    {
        realtype v = *f;
        if (v- v != 0) {
           jmi_log_warning(block->jmi, "Not a number in output from equation block %d", block->index);
           ret = 1;
        }
	}
	return ret;
}

/*Kinsol function wrapper*/
int kin_f(N_Vector yy, N_Vector ff, void *problem_data){
	
	realtype *y, *f;
	jmi_block_residual_t *block = problem_data;
	int i,n, ret;
    block->nb_fevals++;
	y = NV_DATA_S(yy); /*y is now a vector of realtype*/
	f = NV_DATA_S(ff); /*f is now a vector of realtype*/


	/* Test if input is OK (no -1.#IND) */
	n = NV_LENGTH_S(yy);
	for (i=0;i<n;i++) {
	  /* Unrecoverable error*/
          if (Ith(yy,i)- Ith(yy,i) != 0) {
              jmi_log_warning(block->jmi, "Not a number in arguments to equarion block %d", block->index);
              return -1;
          }
	}

	/*Evaluate the residual*/
	ret = block->F(block->jmi,y,f,JMI_BLOCK_EVALUATE);
    if(ret) {
        jmi_log_warning(block->jmi, "Error code returned from equation block %d", block->index);
        return ret;
    }

	/* Test if output is OK (no -1.#IND) */
	n = NV_LENGTH_S(ff);
	for (i=0;i<n;i++) {
        double v = Ith(ff,i);
	  /* Recoverable error*/
        if (v- v != 0) {
           jmi_log_warning(block->jmi, "Not a number in output [%d] from equation block %d", i, block->index);
           ret = 1;
#if 0           
           block->F(block->jmi,y,f,JMI_BLOCK_EVALUATE);
#endif
          }
	}
    /* record information for Brent search */
    if(!ret && (block->n == 1) && block->jmi->options.use_Brent_in_1d_flag) {
        double yv = y[0];
        double fv = f[0];
        jmi_kinsol_solver_t* solver = block->solver;
        if(fv <= 0) {
            if(solver->f_neg_max_1d < fv) {
                solver->f_neg_max_1d = fv;
                solver->y_neg_max_1d = yv;
            }    
        }
        else {
            if(solver->f_pos_min_1d > fv) {
                solver->f_pos_min_1d = fv;
                solver->y_pos_min_1d = yv;
            }    
        }
    }

	/*
    realtype* y = NV_DATA_S(yy); */ /*y is now a vector of realtype*/
	/* printf("f = N.array([\n");
	for (i=0;i<n;i++) {
		printf("%12.12f\n",y[i]);
	}
	printf("]);\n");
*/
	return ret; /*Success*/
	/*return 1;  //Recoverable error*/
	/*return -1; //Unrecoverable error*/
}

/* Wrapper function to Jacobian evaluation as needed by standard KINSOL solvers */
int kin_dF(int N, N_Vector u, N_Vector fu, DlsMat J, jmi_block_residual_t * block, N_Vector tmp1, N_Vector tmp2){
    jmi_kinsol_solver_t* solver = block->solver;        
    struct KINMemRec * kin_mem = solver->kin_mem;    
	int i, j, ret = 0;
    realtype curtime = *(jmi_get_t(block->jmi));
    solver->kin_jac_update_time = curtime;
    block->nb_jevals++;
    
    if(!block->dF) {
        /* Use (almost) standard finite differences */
        realtype inc, inc_inv, ujsaved, ujscale, sign;
        realtype *tmp2_data, *u_data, *uscale_data;
        N_Vector ftemp, jthCol;
            
        /* Save pointer to the array in tmp2 */
        tmp2_data = N_VGetArrayPointer(tmp2);
      
        /* Rename work vectors for readibility */
        ftemp = tmp1; 
        jthCol = tmp2;
      
        /* Obtain pointers to the data for u and uscale */
        u_data   = N_VGetArrayPointer(u);
        uscale_data = N_VGetArrayPointer(solver->kin_y_scale);
      
        /* This is the only for loop for 0..N-1 in KINSOL */
      
        for (j = 0; j < N; j++) {
          realtype sqrt_relfunc = kin_mem->kin_sqrt_relfunc;
            
          /* Generate the jth col of Jac(u) */      
          N_VSetArrayPointer(DENSE_COL(J,j), jthCol);
      
          ujsaved = u_data[j];
          ujscale = ONE/uscale_data[j];
          sign = (ujsaved >= 0) ? 1 : -1;
          inc = MAX(ABS(ujsaved), ujscale)*sign;
          if(sqrt_relfunc > 0) 
              inc *= sqrt_relfunc;
          u_data[j] += inc;
      
          ret = kin_f(u, ftemp, block);
          if(ret > 0) {
              /* try to recover by stepping in the opposite direction */
              inc = -inc;
              u_data[j] = ujsaved + inc;
          
              ret = kin_f(u, ftemp, block);
          }
          if (ret != 0) break; 
      
          u_data[j] = ujsaved;
      
          inc_inv = ONE/inc;
          N_VLinearSum(inc_inv, ftemp, -inc_inv, fu, jthCol);      
        }
      
        /* Restore original array pointer in tmp2 */
        N_VSetArrayPointer(tmp2_data, tmp2);      
    }
	else {
        /* utilize directional derivatives to calculate Jacobian */
		for(i = 0; i < N; i++){ 
 			block->x[i] = Ith(u,i);
		}

		/*printf("x[0]: %f\n Jac: ", block->x[0]);*/
		for(i = 0; i < N; i++){
			block->dx[i] = 1;
			ret |= block->dF(block->jmi,block->x,block->dx,block->res,block->dres,JMI_BLOCK_EVALUATE);
			for(j = 0; j < N; j++){
				realtype dres = block->dres[j];
				(J->data)[i*N+j] = dres;
				/*printf(" %f, ", block->dres[j]);*/
			}
			J->cols[i] = &(J->data)[i*N];
			block->dx[i] = 0;
		}
	}

	if((block->jmi->options.nle_solver_log_level > 2) && (block->jmi->options.debug_log)) {
		char* buf = block->message_buffer ;
		for(i = 0; i < N; i++){
			buf[0] = 0;
			sprintf(buf+strlen(buf),"Block:;%d;;;Jacobian:;",block->index);
			for(j = 0; j < N; j++){
				sprintf(buf+strlen(buf),"%30.16e;",(J->data)[i+j*N]);
			}
			fprintf(block->jmi->options.debug_log, "%s\n",buf);
			fflush(block->jmi->options.debug_log);
		}
	}

	if((block->jmi->options.log_level >= 6)) {
		char* buf = block->message_buffer ;
		for(i = 0; i < N; i++){
			buf[0] = 0;
			sprintf(buf+strlen(buf),"[NLE_JAC]Block:;%d;;;Jacobian:;",block->index);
			for(j = 0; j < N; j++){
				sprintf(buf+strlen(buf),"%30.16e;",(J->data)[i+j*N]);
			}
			jmi_log(block->jmi,logInfo,buf);
		}

	}

	return ret;
}

void kin_err(int err_code, const char *module, const char *function, char *msg, void *eh_data){
	    jmi_log_category_t category;
        char buffer[8000];
        jmi_block_residual_t *block = eh_data;
        jmi_t *jmi = block->jmi;
        jmi_kinsol_solver_t* solver = block->solver;        
        realtype fnorm, snorm;
        KINGetFuncNorm(solver->kin_mem, &fnorm);
        KINGetStepLength(solver->kin_mem, &snorm);

        if( ((block->n == 1) && block->jmi->options.use_Brent_in_1d_flag) /* Brent search will be used to find the root if possible -> no error */
            || (fnorm < solver->kin_stol)) { /* In some cases KINSOL actually converges but returns an error anyway. Just ignore. */
            return;
        }

        if ((err_code > 0) || !block->init) { /*Warning*/
            category = logWarning;
        } else if (err_code < 0){ /*Error*/
            category = logError;
        }

        sprintf(buffer, "[KINSOL_ERROR]Error occured in %s at time %3.2fs when solving block %d: ", function, *(jmi_get_t(jmi)), block->index);
        jmi_log(block->jmi, category, buffer);
        jmi_log(block->jmi, category, msg);
        sprintf(buffer, "[KINSOL_ERROR]Current function norm: %g, scaled step length: %g, tolerance: %g", fnorm, snorm, solver->kin_stol);
        jmi_log(block->jmi, category, buffer);
        
/*
  {
        int i,j;
      jmi_simple_newton_jac(block);

        jmi_log(block->jmi, category, buffer);

        buffer[0] = 0;
        for(i=0; i<block->n; i++) {
       		sprintf(buffer + strlen(buffer), "%12.12f ", block->x[i]);
         }
        jmi_log(block->jmi, category, buffer);

		block->F(block->jmi,block->x,block->res,JMI_BLOCK_EVALUATE);

        buffer[0] = 0;
        for(i=0; i<block->n; i++) {
       		sprintf(buffer + strlen(buffer), "%12.12f ", block->res[i]);
         }
        jmi_log(block->jmi, category, buffer);

        buffer[0] = 0;
        for(i=0; i<block->n; i++) {
        	for(j=0; j<block->n; j++) {
        		sprintf(buffer + strlen(buffer), "%12.12f ", block->jac[j*(block->n) + i]);
        	}
        	sprintf(buffer + strlen(buffer), "\n");
        }
        jmi_log(block->jmi, category, buffer);
    }
*/
}

void kin_info(const char *module, const char *function, char *msg, void *eh_data){
        int i,j;
	    long int nniters;
        jmi_block_residual_t *block = eh_data;
        char* buf = block->message_buffer;
    	jmi_kinsol_solver_t* solver = block->solver;
        struct KINMemRec* kin_mem = solver->kin_mem;
        realtype* residual_scaling_factors = N_VGetArrayPointer(solver->kin_f_scale);

        /* Get the number of iterations */
    	KINGetNumNonlinSolvIters(kin_mem, &nniters);

    	/* Only output an iteration under certain conditions:
    	 *  1. nle_solver_log > 2
    	 *  2. The calling function is either KINSolInit or KINSol
    	 *  3. The message string starts with "nni"
    	 *
    	 *  This approach gives one printout per iteration
    	 */
    	if ((block->jmi->options.nle_solver_log_level > 2) && (block->jmi->options.debug_log) &&
    			(((strcmp("KINSolInit",function)==0) | (strcmp("KINSol",function)==0)) & (strncmp("nni",msg,3)==0))) {
    		sprintf(buf,"Block:;%d;Iteration:;%d;IVs:;",block->index,nniters);
    		j = strlen(buf);
    		for (i=0;i<block->n;i++){
    			realtype* u = N_VGetArrayPointer(kin_mem->kin_uu);
    			int len;
    			char cur[60];
    			sprintf(cur, "%30.16E;",u[i]);
    			len = strlen(cur);
    			memcpy(buf + j, cur, len);
    			j += len;
    		}
    		buf[j]=0;
    		/* jmi_log(block->jmi, logInfo, buf); */
    		fprintf(block->jmi->options.debug_log, "%s\n",buf);
    		fflush(block->jmi->options.debug_log);

    		sprintf(buf,"Block:;%d;Scaled norm:;%30.16E;Residuals:;",block->index, kin_mem->kin_fnorm);
    		j = strlen(buf);
    		for (i=0;i<block->n;i++){
    			realtype* f = N_VGetArrayPointer(kin_mem->kin_fval);
    			int len;
    			char cur[60];
    			sprintf(cur, "%30.16E;",f[i]*residual_scaling_factors[i]);
    			len = strlen(cur);
    			memcpy(buf + j, cur, len);
    			j += len;
    		}
    		buf[j]=0;
    		fprintf(block->jmi->options.debug_log, "%s\n",buf);
    		fflush(block->jmi->options.debug_log);
    	}

    	if ((block->jmi->options.log_level >= 5) &&
    			(((strcmp("KINSolInit",function)==0) |
    					(strcmp("KINSol",function)==0)) & (strncmp("nni",msg,3)==0))) {
    		sprintf(buf,"[NLE_ITERS]Block:;%d;Iteration:;%d;IVs:;",block->index,nniters);
    		j = strlen(buf);
    		for (i=0;i<block->n;i++){
    			realtype* u = N_VGetArrayPointer(kin_mem->kin_uu);
    			int len;
    			char cur[60];
    			sprintf(cur, "%30.16E;",u[i]);
    			len = strlen(cur);
    			memcpy(buf + j, cur, len);
    			j += len;
    		}
    		buf[j]=0;
    		jmi_log(block->jmi, logInfo, buf);

    		sprintf(buf,"[NLE_ITERS]Block:;%d;Scaled norm:;%30.16E;Residuals:;",block->index, kin_mem->kin_fnorm);
    		j = strlen(buf);
    		for (i=0;i<block->n;i++){
    			realtype* f = N_VGetArrayPointer(kin_mem->kin_fval);
    			int len;
    			char cur[60];
    			sprintf(cur, "%30.16E;",f[i]*residual_scaling_factors[i]);
    			len = strlen(cur);
    			memcpy(buf + j, cur, len);
    			j += len;
    		}
    		buf[j]=0;
    		jmi_log(block->jmi, logInfo, buf);
    	}
    	sprintf(buf,"[KINSOL_INFO]Calling function: %s, Message: %s",function,msg);
    	jmi_log(block->jmi, logInfo, buf);
}

void jmi_kinsol_error_handling(jmi_t* jmi, int flag){
 	if (flag != 0){
        jmi_log_error(jmi,"KINSOL returned with error flag: %s", KINGetReturnFlagName(flag));
    }
}

/* initialize data on bounds */
static int jmi_kinsol_init_bounds(jmi_block_residual_t * block) {
    jmi_kinsol_solver_t* solver = block->solver;
    
    int i,num_bounds = 0;
    
    if(!block->jmi->options.enforce_bounds_flag) {
        solver->num_bounds = 0;
        return 0;
    }
    
    for(i=0; i < block->n; ++i) {
        if(block->max[i] != BIG_REAL) num_bounds++;
        if(block->min[i] != -BIG_REAL) num_bounds++;
    }
    
    solver->num_bounds = num_bounds;
    if(!num_bounds) return 0;
    solver->bound_vindex = (int*)calloc(num_bounds, sizeof(int));
    solver->bound_kind  = (int*)calloc(num_bounds, sizeof(int));
    solver->bounds = (realtype*)calloc(num_bounds, sizeof(realtype));
    solver->active_bounds = (realtype*)calloc(block->n, sizeof(realtype));
    num_bounds = 0;

    for(i=0; i < block->n; ++i) {
        if(block->max[i] != BIG_REAL) {
            solver->bound_vindex[num_bounds] = i;
            solver->bound_kind[num_bounds] = 1;
            solver->bounds[num_bounds] = block->max[i];
            num_bounds++;
        }
        if(block->min[i] != -BIG_REAL) {
            solver->bound_vindex[num_bounds] = i;
            solver->bound_kind[num_bounds] = -1;
            solver->bounds[num_bounds] = block->min[i];
            num_bounds++;
        }
    }
	
    return 0;
}

static int jmi_kinsol_init(jmi_block_residual_t * block) {
    jmi_kinsol_solver_t* solver = block->solver;
    jmi_t * jmi = block->jmi;
    int ef;
    struct KINMemRec * kin_mem = solver->kin_mem; 

    KINSetPrintLevel(solver->kin_mem, (jmi->options.log_level<=3)? jmi->options.log_level: 3);
    
    /* set tolerances */
    if((block->n > 1) || !jmi->options.use_Brent_in_1d_flag) {
        solver->kin_stol = jmi->fmi->fmi_newton_tolerance;
        if(solver->kin_stol < jmi->options.nle_solver_min_tol) {
            solver->kin_stol = jmi->options.nle_solver_min_tol;
        }
    }
    else
        solver->kin_stol = jmi->options.nle_solver_min_tol;
    
    solver->kin_ftol = jmi->fmi->fmi_newton_tolerance;

    KINSetScaledStepTol(solver->kin_mem, solver->kin_stol);
    KINSetFuncNormTol(solver->kin_mem, solver->kin_ftol);
    if(jmi->options.use_automatic_scaling_flag)
    {
        /* 
            Set variable scaling based on nominal values.          
        */
        int i;
        for(i=0;i< block->n;++i){
            double nominal = RAbs(block->nominal[i]);
            if(nominal != 1.0) {
                if(nominal == 0.0)
                    nominal = 1/solver->kin_ftol;
                else
                    nominal = 1/nominal;
                Ith(solver->kin_y_scale,i)=nominal;
            }
        }
    }

    jmi_kinsol_init_bounds(block);
    
    /* evaluate the function at initial */
    ef =  kin_f(solver->kin_y, kin_mem->kin_fval, block);
    if(ef) {
        jmi_log_error(jmi, "Residual function evaluation failed at initial point for non-linear block %d", block->index);
    }
	kin_mem->kin_uscale = solver->kin_y_scale;
    
    if(jmi_kin_lsetup(kin_mem)) {
        ef = 1;
        jmi_log_error(jmi, "Jacobian evaluation failed at initial point for non-linear block %d", block->index);
    }
    return ef;


}

/* Limit the maximum step to be within bounds. Do projection if needed. */
static void jmi_kinsol_limit_step(struct KINMemRec * kin_mem, N_Vector x, N_Vector b) {
    jmi_block_residual_t *block = (jmi_block_residual_t *)kin_mem->kin_user_data;
    jmi_kinsol_solver_t* solver = (jmi_kinsol_solver_t*)block->solver;	
    char* buf = block->message_buffer;
    realtype xnorm;        /* step norm */
    realtype min_step_ratio; /* fraction of the Newton step that is still over minimal step*/
    realtype max_step_ratio; /* maximum step length ratio limited by bounds */

    realtype* xxd = N_VGetArrayPointer(x);
    realtype* xd = N_VGetArrayPointer(b);
    booleantype activeBounds = FALSE;
    int i;

#define MAX_NETON_STEP_RATIO 10.0

	xnorm = N_VWL2Norm(x, kin_mem->kin_uscale);
    
    if((solver->num_bounds == 0) || (xnorm == 0.0)) 
    {
	    /* make sure full newton step can be taken */
        realtype maxstep = MAX_NETON_STEP_RATIO * xnorm;
#if 0
        if(maxstep > kin_mem->kin_mxnewtstep)
#endif
            kin_mem->kin_mxnewtstep = maxstep;
		return;
	}

	/*  scale the step up so that step multiplier is 1.0 at the beginning*/
	N_VScale(MAX_NETON_STEP_RATIO, x, b);
    
    /* minimal/maximal allowed step multiplier */
	max_step_ratio = 1.0;
    min_step_ratio = 0.01; /* solver->kin_stol / xnorm; */

    for(i = 0; i < solver->num_bounds; ++i) {
        int index = solver->bound_vindex[i]; /* variable index */
        int kind = solver->bound_kind[i];   /* min or max */
        realtype ui =  NV_Ith_S(kin_mem->kin_uu,index);  /* current variable value */
        realtype pi = xd[index];            /* solved step length for the variable*/
        realtype bound = solver->bounds[i]; 
		realtype pbi = (bound - ui)*(1 - UNIT_ROUNDOFF);  /* distance to the bound */
        realtype step_ratio_i;
        if(    ((kind == 1)&& (pbi >= pi))
			|| ((kind == -1)&& (pbi <= pi)))
            continue; /* will not cross the bound */

        step_ratio_i =pbi/pi;   /* step ration to bound */
        if(step_ratio_i < min_step_ratio) {
			/* this bound is active (we need to follow it) */
            activeBounds = TRUE;
            xxd[index] = 0;
            solver->active_bounds[index] = (kind == 1)? pbi:-pbi ; /* distance to the bound */

        }
        else
            max_step_ratio = MIN(max_step_ratio, step_ratio_i);          /* reduce the step */
    }
    
	if (block->jmi->options.log_level >= 5 && activeBounds) {
		/* Print min values */
		char* buf = block->message_buffer ;
		sprintf(buf,"[NLE_BOUNDS]Block:;%d;Active;Bounds:;;",block->index);
		for (i=0; i < solver->num_bounds; i++) {
			int index = solver->bound_vindex[i]; /* variable index */
			if (solver->active_bounds[index] != 0) {
				if (solver->bound_kind[i] == 1) {
					sprintf(buf+strlen(buf),"max ");
				} else {
					sprintf(buf+strlen(buf),"min ");
				}
				sprintf(buf+strlen(buf),"#r%d#;",block->value_references[index]);
			}
		}
		jmi_log(block->jmi, logInfo, buf);
		
	}

	max_step_ratio *= MAX_NETON_STEP_RATIO * (1 - UNIT_ROUNDOFF);
    
    if((max_step_ratio < 1) || activeBounds) {
        kin_mem->kin_ncscmx = 0; /* allow for more steps of kin_mxnewtstep length in this case */
    }

	if(!activeBounds) {
		/* bounds do not affect the base-line algorithm, only limit the step */
		kin_mem->kin_mxnewtstep = max_step_ratio * xnorm ;
		return;
	}

	/* Update the x to be the maximum vector within bounds */ 
	for(i = 0; i < block->n; ++i) {
		realtype bnd = solver->active_bounds[i];
        if(bnd != 0.0) {
			xd[i] = bnd;
            solver->active_bounds[i] = 0;
        }
		else if(max_step_ratio < 1.0) {
            xd[i] = xxd[i] * max_step_ratio;
		}
        else xd[i] = xxd[i];
    }
	if(max_step_ratio < 1.0) {
		/* reduce the norms of Jp. This is only approximate since active bounds are not accounted for.*/
		kin_mem->kin_sfdotJp *= max_step_ratio;
		kin_mem->kin_sJpnorm *= max_step_ratio;
	}
	/* The maximum newton step leads to the bound	*/
    N_VScale(1.0, b, x);
	kin_mem->kin_mxnewtstep =  N_VWL2Norm(x, kin_mem->kin_uscale)*(1 - UNIT_ROUNDOFF);
}

/* Form regualrized matrix Transpose(J).J */
static void jmi_kinsol_reg_matrix(jmi_block_residual_t * block) {
    jmi_kinsol_solver_t* solver = block->solver;
    /*    jmi_t * jmi = block->jmi; */
    int i,j,k;
    realtype **JTJ_c =  solver->JTJ->cols;
    realtype **jac = solver->J->cols;
    int N = block->n;
    
    /* Add the regularization parameter on the diagonal.
    TODO: consider using scales of X instead of 1.0 for regularization
      */

    for (i=0;i<N;i++) {
        /*Calculate value at RTR(i,i) */
        JTJ_c[i][i] = 1;
        for (k=0;k<N;k++) JTJ_c[i][i] += jac[i][k]*jac[i][k];
        for (j=i+1;j<N;j++){
            
            /*Calculate value at RTR(i,j) */
            JTJ_c[j][i] = 0;
            for (k=0;k<N;k++) JTJ_c[j][i] += jac[j][k]*jac[i][k];
            JTJ_c[i][j] = JTJ_c[j][i];
        }
    }
}

static int jmi_kin_lsetup(struct KINMemRec * kin_mem) {
    jmi_block_residual_t *block = kin_mem->kin_user_data;
    jmi_kinsol_solver_t* solver = block->solver;
    jmi_t * jmi = block->jmi;
    
    int info;
    int N = block->n;
      
    int ret;
    SetToZero(solver->J);

    /* Evaluate Jacobian */
    ret = kin_dF(N, solver->kin_y, kin_mem->kin_fval, solver->J, block, kin_mem->kin_vtemp1, kin_mem->kin_vtemp2);
    
    if(ret != 0 ) return ret;
    
    DenseCopy(solver->J, solver->J_LU);

    /* Equillibrate if corresponding option is set */
    if((N>1) && block->jmi->options.use_jacobian_scaling_flag) {
        int info;
        double rowcnd, colcnd, amax;
        dgeequ_(&N, &N, solver->J_LU->data, &N, solver->rScale, solver->cScale, 
                &rowcnd, &colcnd, &amax, &info);
        if(info == 0) {
            dlaqge_(&N, &N, solver->J_LU->data, &N, solver->rScale, solver->cScale, 
                    &rowcnd, &colcnd, &amax, &solver->equed);
        }
        else
            solver->equed = 'N';
    }
    
    /* Perform factorization to detect if there is a singular Jacobian */
    dgetrf_(  &N, &N, solver->J_LU->data, &N, solver->lapack_ipiv, &info);
    
    if(info != 0 ) {
        solver->J_is_singular_flag = 1;
        jmi_log_warning(jmi, "[NLE_LIN_SETUP]Singular Jacobian detected when factorizing in linear solver. Will try to regularize the equations in block %d", block->index);
        jmi_kinsol_reg_matrix(block);
        dgetrf_(  &N, &N, solver->JTJ->data, &N, solver->lapack_ipiv, &info);
    }
    else {
        solver->J_is_singular_flag = 0;        
    }
    
    if(solver->force_new_J_flag ) {
        solver->force_new_J_flag = 0;
		if(jmi->options.rescale_after_singular_jac_flag)
			jmi_update_f_scale(block);
    }    
        
    return 0;
        
}

static int jmi_kin_lsolve(struct KINMemRec * kin_mem, N_Vector x, N_Vector b, realtype *res_norm) {
    jmi_block_residual_t *block = kin_mem->kin_user_data;
    jmi_kinsol_solver_t* solver = block->solver;
    realtype*  bd = N_VGetArrayPointer(b);
    realtype*  xd = N_VGetArrayPointer(x);
    int N = block->n;
    char trans = 'N';
    int ret, i;
    
    if(solver->force_new_J_flag) {        
        return 1;
    }
    
    /*
      Taken directly from SUNDIALS:
 
        Compute the terms Jpnorm and sfdotJp for use in the global strategy
       routines and in KINForcingTerm. Both of these terms are subsequently
       corrected if the step is reduced by constraints or the line search.
  
       sJpnorm is the norm of the scaled product (scaled by fscale) of
       the current Jacobian matrix J and the step vector p.
  
       sfdotJp is the dot product of the scaled f vector and the scaled
       vector J*p, where the scaling uses fscale. */
  
  
    kin_mem->kin_sJpnorm = N_VWL2Norm(b,solver->kin_f_scale);
    N_VProd(b, solver->kin_f_scale, x);
    N_VProd(x, solver->kin_f_scale, x);
    
    kin_mem->kin_sfdotJp = N_VDotProd(kin_mem->kin_fval, x);

    if((solver->equed == 'R') || (solver->equed == 'B')) {
		for(i = 0; i < N; i++) {
			bd[i] *= solver->rScale[i];
		}
	}
    if(solver->J_is_singular_flag) {
        /* solve the regularized problem */
        
        realtype** jac = solver->J->cols;
        int i,j;
        for (i=0;i<N;i++){
            xd[i] = 0;
            for (j=0;j<N;j++) xd[i] += jac[i][j]*bd[j];
         }
        /* Back-solve and get solution in x */
        trans = 'N'; /* No transposition */
        i = 1;
        dgetrs_(&trans, &N, &i, solver->JTJ->data, &N, solver->lapack_ipiv, xd, &N, &ret);
        solver->force_new_J_flag = 1;
    }
    else {
        N_VScale(ONE, b, x);
        i = 1;
        dgetrs_(&trans, &N, &i, solver->J_LU->data, &N, solver->lapack_ipiv, xd, &N, &ret);        
    }
    
    if(ret) return ret;
    
	if((solver->equed == 'C') || (solver->equed == 'B')) {
		int i;
		realtype* xd = N_VGetArrayPointer(x);
		for(i = 0; i < block->n; i++) {
			xd[i] *= solver->cScale[i];
		}
	}

	jmi_kinsol_limit_step(kin_mem, x, b);
    
    return 0;        
}

/* 
    Compute appropriate equation scaling and function tolerance based on Jacobian J,
    nominal values (block->nominal) and current point (block->x).
    Store result in solver->kin_f_scale.
*/
static void jmi_update_f_scale(jmi_block_residual_t *block) {
	int k;
	realtype* dummy = 0 ;
    jmi_kinsol_solver_t* solver = block->solver; 
    jmi_t* jmi = block->jmi;
    int i, N = block->n;
    realtype tol = solver->kin_stol;
    realtype curtime = *(jmi_get_t(block->jmi));
    realtype* scale_ptr = N_VGetArrayPointer(solver->kin_f_scale);
    realtype* col_ptr;
    realtype* scaled_col_ptr;
    solver->kin_scale_update_time = curtime;  

	/* Determine what kind of scaling to use */
    if(block->jmi->options.use_manual_scaling_flag){
		/* Read manual scaling from annotations and put them in scale_ptr*/		
		block->F(jmi,dummy,scale_ptr,JMI_BLOCK_EQUATION_NOMINAL) ;

	}else{
		/* Automatic scaling, if any*/
		if(!block->jmi->options.use_automatic_scaling_flag) return;

		/* Scale equations by Jacobian rows. */
		N_VConst_Serial(0,solver->kin_f_scale);
		for(i = 0; i < N; i++){
			int j;
			realtype xscale = RAbs(block->nominal[i]);
			realtype x = RAbs(block->x[i]);
			if(x < xscale) x = xscale;
			if(x < tol) x = tol;
			col_ptr = DENSE_COL(solver->J, i);
			scaled_col_ptr = DENSE_COL(solver->J_scale, i);

			for(j = 0; j < N; j++){
				realtype dres = col_ptr[j];
				realtype fscale;
				fscale = dres * x;
				scaled_col_ptr[j] = fscale;
				scale_ptr[j] = MAX(scale_ptr[j], RAbs(fscale));
			}
		}
	}
	for(i = 0; i < N; i++) {
		if(scale_ptr[i] < tol) {
			scale_ptr[i] = 1/tol; /* Singular Jacobian? */
			jmi_log_warning(block->jmi, "Using maximum scaling factor in block %d, equation %d. Consider rescaling in the model or tighter tolerance.", block->index, i);
		}
		else
			scale_ptr[i] = 1/scale_ptr[i];
	}
	solver->kin_ftol = tol;
	
	/* Print scaling factors to log */
	if((block->jmi->options.nle_solver_log_level > 2) && (block->jmi->options.debug_log)) {
		char* buf = block->message_buffer ;
		sprintf(buf,"Block:;%d;Updating;Res;Scaling:;",block->index);
		k = strlen(buf);
		for (i=0;i<N;i++){
			realtype* res = scale_ptr;
			int len;
			char cur[60];
			sprintf(cur, "%30.16E;",1/res[i]);
			len = strlen(cur);
			memcpy(buf + k, cur, len);
			k += len;
		}
		buf[k]=0;
		/* jmi_log(block->jmi, logInfo, buf); */
		fprintf(block->jmi->options.debug_log, "%s\n",buf);
		fflush(block->jmi->options.debug_log);
		/* printf( "%s\n",buf); */
	}

	if (block->jmi->options.log_level >= 5) {
		char* buf = block->message_buffer ;
		sprintf(buf,"[NLE_SCALING]Block:;%d;Updating;Res;Scaling:;",block->index);
		k = strlen(buf);
		for (i=0;i<N;i++){
			realtype* res = scale_ptr;
			int len;
			char cur[60];
			sprintf(cur, "%30.16E;",1/res[i]);
			len = strlen(cur);
			memcpy(buf + k, cur, len);
			k += len;
		}
		buf[k]=0;
		jmi_log(block->jmi, logInfo, buf);
	}

    KINSetFuncNormTol(solver->kin_mem, solver->kin_ftol);
    KINSetScaledStepTol(solver->kin_mem, solver->kin_stol);
	
    /* estimate condition number of the scaled jacobian 
        and scale function tolerance with it. */
    if((N > 1) && block->jmi->options.nle_solver_check_jac_cond_flag){
        realtype* scaled_col_ptr;
        char norm = 'I';
        double Jnorm = 1.0, Jcond = 1.0;
        int info;
        
        for(i = 0; i < N; i++){
            int j;
            scaled_col_ptr = DENSE_COL(solver->J_scale, i);
            for(j = 0; j < N; j++){
                scaled_col_ptr[j] = scaled_col_ptr[j] * scale_ptr[j];
            }
        }
        dgetrf_(  &N, &N, solver->J_scale->data, &N, solver->lapack_iwork, &info);
        if(info > 0) {
            jmi_log_warning(jmi, "[NLE_SCALING]A singular Jacobian detected in block %d. Solver may fail to converge.", block->index);
        }
        else {
            dgecon_(&norm, &N, solver->J_scale->data, &N, &Jnorm, &Jcond, solver->lapack_work, solver->lapack_iwork,&info);       
            
            if(tol * Jcond < UNIT_ROUNDOFF) {
                jmi_log_warning(jmi, "[NLE_SCALING]Jacobian condition number inverse estimate in block %d is %E. Solver may fail to converge.", block->index,Jcond);
            }
            else {
                jmi_log_info(jmi, "[NLE_SCALING]Jacobian condition number inverse estimate in block %d is %E.", block->index, Jcond);
            }
        }
    }
    return;
}

int jmi_kinsol_solver_new(jmi_kinsol_solver_t** solver_ptr, jmi_block_residual_t* block) {
    jmi_kinsol_solver_t* solver;
    jmi_t* jmi = block->jmi;
    int flag, n = block->n;
    
    struct KINMemRec * kin_mem = KINCreate();
    if(!kin_mem) return -1;
    solver = (jmi_kinsol_solver_t*)calloc(1,sizeof(jmi_kinsol_solver_t));
    if(!solver ) return -1;
    solver->kin_mem = kin_mem;
    
    /*Initialize work vectors.*/

    /*Sets the scaling vectors to ones.*/
    /*To be changed. */
    solver->kin_y = N_VMake_Serial(n, block->x);
	solver->kin_y_scale = N_VNew_Serial(n);
	solver->kin_f_scale = N_VNew_Serial(n);
    solver->kin_scale_update_time = -1.0;
    solver->kin_jac_update_time = -1.0;
    /*NOTE: it'd be nice to use "jmi->fmi->fmi_newton_tolerance" here
      However, fmi pointer is not set yet at this point.
    */
	solver->kin_ftol = block->jmi->options.nle_solver_min_tol;
	solver->kin_stol = block->jmi->options.nle_solver_min_tol;
    
    solver->J = NewDenseMat(n ,n);
    solver->JTJ = NewDenseMat(n ,n);
    solver->J_LU = NewDenseMat(n ,n);
    solver->J_scale = NewDenseMat(n ,n);

	solver->equed = 'N';
	solver->rScale = (realtype*)calloc(n,sizeof(realtype));
	solver->cScale = (realtype*)calloc(n,sizeof(realtype));

    solver->lapack_work = (realtype*)calloc(4*n,sizeof(realtype));
    solver->lapack_iwork = (int *)calloc(n, sizeof(int));
    solver->lapack_ipiv = (int *)calloc(n, sizeof(int));

    /* Initialize scaling to 1.0 - defaults */
    N_VConst_Serial(1.0,solver->kin_y_scale);

    /* Initial equation scaling is 1.0 */
    N_VConst_Serial(1.0,solver->kin_f_scale);
                
    flag = KINInit(solver->kin_mem, kin_f, solver->kin_y); /*Initialize Kinsol*/
    jmi_kinsol_error_handling(jmi, flag);
    
    /*Attach linear solver*/
    /*Dense Kinsol solver*/
    /*flag = KINDense(solver->kin_mem, block->n);
      jmi_kinsol_error_handling(flag);*/
     
     
   /*Dense Kinsol using regularization*/
    /*    flag = KINPinv(solver->kin_mem, block->n);
    jmi_kinsol_error_handling(jmi, flag);
    KINDlsSetDenseJacFn(solver->kin_mem, (KINDlsDenseJacFn)kin_dF);

    */
    kin_mem->kin_lsetup = jmi_kin_lsetup;
    kin_mem->kin_lsolve = jmi_kin_lsolve;
    kin_mem->kin_setupNonNull = TRUE;
    kin_mem->kin_inexact_ls = FALSE;
    
    /*End linear solver*/
    
    /*Set problem data to Kinsol*/
    flag = KINSetUserData(solver->kin_mem, block);
    jmi_kinsol_error_handling(jmi, flag);  
    
    /*Stopping tolerance of F -> just a default */
    KINSetFuncNormTol(solver->kin_mem, solver->kin_ftol); 
    
    /*Stepsize tolerance*/
    KINSetScaledStepTol(solver->kin_mem, solver->kin_stol);
    
    /* Allow long steps */
    KINSetMaxNewtonStep(solver->kin_mem, 1);
    
    /* Disable residual monitoring (since inexact solution is given sometimes by 
    the linear solver) */
    KINSetNoResMon(solver->kin_mem,1);

    /*Verbosity*/
    KINSetPrintLevel(solver->kin_mem, jmi->options.nle_solver_log_level);
    
    /*Error function*/
    KINSetErrHandlerFn(solver->kin_mem, kin_err, block);
    /*Info function*/
    KINSetInfoHandlerFn(solver->kin_mem, kin_info, block);
    /*  Jacobian can be reused */
    KINSetNoInitSetup(solver->kin_mem, 1);    
      
    *solver_ptr = solver;
    return flag;
}

void jmi_kinsol_solver_delete(jmi_block_residual_t* block) {
    jmi_kinsol_solver_t* solver = block->solver;
    
    /*Deallocate Kinsol work vectors.*/
	N_VDestroy_Serial(solver->kin_y);
	N_VDestroy_Serial(solver->kin_y_scale);
	N_VDestroy_Serial(solver->kin_f_scale);
    DestroyMat(solver->J);
    DestroyMat(solver->JTJ);
    DestroyMat(solver->J_LU);
    DestroyMat(solver->J_scale);
	free(solver->cScale);
	free(solver->rScale);
    free(solver->lapack_work);
    free(solver->lapack_iwork);    
    
    if(solver->num_bounds > 0) {
        free(solver->bound_vindex);
        free(solver->bound_kind);
        free(solver->bounds);
        free(solver->active_bounds);
    }
    
	/*Deallocate Kinsol */
    KINFree(&(solver->kin_mem));
	/*Deallocate struct */
	free(solver);
    block->solver = 0;
}

void jmi_kinsol_solver_print_solve_start(jmi_block_residual_t * block) {
    int j;

    if((block->jmi->options.nle_solver_log_level > 2) && (block->jmi->options.debug_log)) {
		char* buf = block->message_buffer ;
		sprintf(buf,"Block:;%d;Newton solver invoked;;;",block->index);
		for (j=0;j<block->n;j++) {
			sprintf(buf+strlen(buf),"#r%d#;",block->value_references[j]);
		}
		j = strlen(buf);
		buf[j]=0;
		fprintf(block->jmi->options.debug_log, "%s\n",buf);
		sprintf(buf,"[NLE_ITERS]Block:;%d;Max;;;",block->index);
		for (j=0;j<block->n;j++) {
			sprintf(buf+strlen(buf),"%30.16E;",block->max[j]);
		}
		fprintf(block->jmi->options.debug_log, "%s\n",buf);
		sprintf(buf,"[NLE_ITERS]Block:;%d;Min;;;",block->index);
		for (j=0;j<block->n;j++) {
			sprintf(buf+strlen(buf),"%30.16E;",block->min[j]);
		}
		fprintf(block->jmi->options.debug_log, "%s\n",buf);
		fflush(block->jmi->options.debug_log);
	}

	if((block->jmi->options.log_level >= 5)) {
		char* buf = block->message_buffer ;
		sprintf(buf,"[NLE_ITERS]Block:;%d;Newton solver invoked;;;",block->index);
		for (j=0;j<block->n;j++) {
			sprintf(buf+strlen(buf),"#r%d#;",block->value_references[j]);
		}
		jmi_log(block->jmi, logInfo, buf);
		sprintf(buf,"[NLE_ITERS]Block:;%d;Max;;;",block->index);
		for (j=0;j<block->n;j++) {
			sprintf(buf+strlen(buf),"%30.16E;",block->max[j]);
		}
		jmi_log(block->jmi, logInfo, buf);
		sprintf(buf,"[NLE_ITERS]Block:;%d;Min;;;",block->index);
		for (j=0;j<block->n;j++) {
			sprintf(buf+strlen(buf),"%30.16E;",block->min[j]);
		}
		jmi_log(block->jmi, logInfo, buf);
	}
}

void jmi_kinsol_solver_print_solve_end(jmi_block_residual_t * block, int flag) {
	long int nniters;
	int j;
	jmi_kinsol_solver_t* solver = block->solver;
	KINGetNumNonlinSolvIters(solver->kin_mem, &nniters);

	if((block->jmi->options.nle_solver_log_level > 2) && (block->jmi->options.debug_log)) {
		char* buf = block->message_buffer ;
		sprintf(buf,"Block:;%d;Newton solver finished with exit flag;",block->index);
                switch (flag)
		{
		case KIN_SUCCESS:
		  sprintf(buf + strlen(buf), "KIN_SUCCESS;");
		  break;
		case KIN_INITIAL_GUESS_OK:
		  sprintf(buf + strlen(buf), "KIN_INITIAL_GUESS_OK;");
		  break;
		case KIN_STEP_LT_STPTOL:
		  sprintf(buf + strlen(buf), "KIN_STEP_LT_STPTOL;");
		  break;
		case KIN_WARNING:
		  sprintf(buf + strlen(buf), "KIN_WARNING;");
		  break;
		case KIN_MEM_NULL:
		  sprintf(buf + strlen(buf), "KIN_MEM_NULL;");
		  break;
		case KIN_ILL_INPUT:
		  sprintf(buf + strlen(buf), "KIN_ILL_INPUT;");
		  break;
		case KIN_NO_MALLOC:
		  sprintf(buf + strlen(buf), "KIN_NO_MALLOC;");
		  break;
		case KIN_MEM_FAIL:
		  sprintf(buf + strlen(buf), "KIN_MEM_FAIL;");
		  break;
		case KIN_LINESEARCH_NONCONV:
		  sprintf(buf + strlen(buf), "KIN_LINESEARCH_NONCONV;");
		  break;
		case KIN_MAXITER_REACHED:
		  sprintf(buf + strlen(buf), "KIN_MAXITER_REACHED;");
		  break;
		case KIN_MXNEWT_5X_EXCEEDED:
		  sprintf(buf + strlen(buf), "KIN_MXNEWT_5X_EXCEEDED;");
		  break;
		case KIN_LINESEARCH_BCFAIL:
		  sprintf(buf + strlen(buf), "KIN_LINESEARCH_BCFAIL;");
		  break;
		case KIN_LINSOLV_NO_RECOVERY:
		  sprintf(buf + strlen(buf), "KIN_LINSOLV_NO_RECOVERY;");
		  break;
		case KIN_LINIT_FAIL:
		  sprintf(buf + strlen(buf), "KIN_LINIT_FAIL;");
		  break;
		case KIN_LSETUP_FAIL:
		  sprintf(buf + strlen(buf), "KIN_LSETUP_FAIL;");
		  break;
		case KIN_LSOLVE_FAIL:
		  sprintf(buf + strlen(buf), "KIN_LSOLVE_FAIL;");
		  break;
		case KIN_SYSFUNC_FAIL:
		  sprintf(buf + strlen(buf), "KIN_SYSFUNC_FAIL;");
		  break;
		case KIN_FIRST_SYSFUNC_ERR:
		  sprintf(buf + strlen(buf), "KIN_FIRST_SYSFUNC_ERR;");
		  break;
		default:
		  sprintf(buf + strlen(buf), "Unknown return flag from Kinsol: %d;",flag);
                }
		j = strlen(buf);
		buf[j]=0;
		fprintf(block->jmi->options.debug_log, "%s\n",buf);
		fflush(block->jmi->options.debug_log);
	}

	if((block->jmi->options.log_level >= 5)) {
		char* buf = block->message_buffer ;
		sprintf(buf,"[NLE_ITERS]Block:;%d;Newton solver finished with exit flag;",block->index);
                switch (flag)
		{
		case KIN_SUCCESS:
		  sprintf(buf + strlen(buf), "KIN_SUCCESS;");
		  break;
		case KIN_INITIAL_GUESS_OK:
		  sprintf(buf + strlen(buf), "KIN_INITIAL_GUESS_OK;");
		  break;
		case KIN_STEP_LT_STPTOL:
		  sprintf(buf + strlen(buf), "KIN_STEP_LT_STPTOL;");
		  break;
		case KIN_WARNING:
		  sprintf(buf + strlen(buf), "KIN_WARNING;");
		  break;
		case KIN_MEM_NULL:
		  sprintf(buf + strlen(buf), "KIN_MEM_NULL;");
		  break;
		case KIN_ILL_INPUT:
		  sprintf(buf + strlen(buf), "KIN_ILL_INPUT;");
		  break;
		case KIN_NO_MALLOC:
		  sprintf(buf + strlen(buf), "KIN_NO_MALLOC;");
		  break;
		case KIN_MEM_FAIL:
		  sprintf(buf + strlen(buf), "KIN_MEM_FAIL;");
		  break;
		case KIN_LINESEARCH_NONCONV:
		  sprintf(buf + strlen(buf), "KIN_LINESEARCH_NONCONV;");
		  break;
		case KIN_MAXITER_REACHED:
		  sprintf(buf + strlen(buf), "KIN_MAXITER_REACHED;");
		  break;
		case KIN_MXNEWT_5X_EXCEEDED:
		  sprintf(buf + strlen(buf), "KIN_MXNEWT_5X_EXCEEDED;");
		  break;
		case KIN_LINESEARCH_BCFAIL:
		  sprintf(buf + strlen(buf), "KIN_LINESEARCH_BCFAIL;");
		  break;
		case KIN_LINSOLV_NO_RECOVERY:
		  sprintf(buf + strlen(buf), "KIN_LINSOLV_NO_RECOVERY;");
		  break;
		case KIN_LINIT_FAIL:
		  sprintf(buf + strlen(buf), "KIN_LINIT_FAIL;");
		  break;
		case KIN_LSETUP_FAIL:
		  sprintf(buf + strlen(buf), "KIN_LSETUP_FAIL;");
		  break;
		case KIN_LSOLVE_FAIL:
		  sprintf(buf + strlen(buf), "KIN_LSOLVE_FAIL;");
		  break;
		case KIN_SYSFUNC_FAIL:
		  sprintf(buf + strlen(buf), "KIN_SYSFUNC_FAIL;");
		  break;
		case KIN_FIRST_SYSFUNC_ERR:
		  sprintf(buf + strlen(buf), "KIN_FIRST_SYSFUNC_ERR;");
		  break;
		default:
		  sprintf(buf + strlen(buf), "Unknown return flag from Kinsol: %d;",flag);
                }
		jmi_log(block->jmi, logInfo, buf);
	}

}


int jmi_kinsol_solver_solve(jmi_block_residual_t * block){
    int flag;
    jmi_kinsol_solver_t* solver = block->solver;
    realtype curtime = *(jmi_get_t(block->jmi));
    long int nniters = 0;
    int j;
    int flagNonscaled;
    realtype fnorm;

    if(block->n == 1) {
        solver->f_pos_min_1d = BIG_REAL;
        solver->f_neg_max_1d = -BIG_REAL;
    }
    
    if(block->init) {
        jmi_kinsol_init(block);
    }
    
    /* Read initial values for iteration variables from variable vector.
     * This is needed if the user has changed initial guesses in between calls to
     * Kinsol.
     */
    flag = block->F(block->jmi,block->x,block->res,JMI_BLOCK_INITIALIZE);
    if(flag) {
        jmi_log_warning(block->jmi, "Error code returned from equation block %d when reading initial guess.", block->index);
        return flag;
    }

    /* update the scaling only once per time step */
    if(block->init || (block->jmi->options.rescale_each_step_flag && (curtime > solver->kin_scale_update_time))) {
        jmi_update_f_scale(block);
    }
     
    jmi_kinsol_solver_print_solve_start(block);
    flag = KINSol(solver->kin_mem, solver->kin_y, KIN_LINESEARCH, solver->kin_y_scale, solver->kin_f_scale);
    jmi_kinsol_solver_print_solve_end(block,flag);
    if(flag != KIN_SUCCESS) {
    	if(flag == KIN_INITIAL_GUESS_OK) {
            flag = KIN_SUCCESS;
        } /* If the evaluation of the residuals fails, e.g. due to NaN in the residuals, the Kinsol exits, but the old fnorm
    	     from a previous solve, possibly converged, is still stored. In such cases Kinsol reports success based on a fnorm
    	     value from a previous solve - if the previous solve was converged, then also a following faulty solve will be reproted
    	     as a success. Commenting out this code since it causes problems.*/
    	else if (flag == KIN_LINESEARCH_NONCONV) {
    	    realtype fnorm;
            KINGetFuncNorm(solver->kin_mem, &fnorm);
            if(fnorm < solver->kin_stol) {
                flag = KIN_SUCCESS;
                /*jmi_log_warning(block->jmi, "Kinsol returned with the flag KIN_LINESEARCH_NONCONV but the residuals are converged in block %d, continuing", block->index);*/
            }

        }
    }
    /* TODO: Is Brent called even if Kinsol succeeded? Shouldn't this be in an else if?*/
    if((block->n == 1) && block->jmi->options.use_Brent_in_1d_flag) {
    	jmi_log_info(block->jmi,"Trying Brent's method non-linear block %d",block->index);
        if(( solver->f_pos_min_1d != BIG_REAL) &&
                ( solver->f_neg_max_1d != -BIG_REAL)) {
            
            realtype u, f;
            if(!jmi_brent_search(brentf, solver->y_neg_max_1d,  solver->y_pos_min_1d, 
                                 solver->f_neg_max_1d,  solver->f_pos_min_1d, 0, &u, &f,block)) {
                block->x[0] = u;
                flag = KIN_SUCCESS;
            }                
        }
        if(flag != KIN_SUCCESS) {
            jmi_log_error(block->jmi, "Could neither iterate to required accuracy nor bracket the root of 1D equation in non-linear block %d", block->index);
        }
    } /* TODO: This means that the first time scaling is always recomputed - and the solver is called a second time, why? */
    else if(block->init || (flag != KIN_SUCCESS)) {
    	jmi_log_info(block->jmi,"Attempting rescaling in non-linear block %d",block->index);
        /* This is the first call or we're failing: make sure scaling was appropriate*/
    	flagNonscaled = flag;
        /* Get & store debug information */
        KINGetNumNonlinSolvIters(solver->kin_mem, &block->nb_iters);
        if(flagNonscaled < 0) {
            jmi_log_warning(block->jmi, "The equations with initial scaling didn't converge to a solution in non-linear block %d", block->index);
        }
        /* Update the scaling  */
        jmi_update_f_scale(block);
        
        jmi_kinsol_solver_print_solve_start(block);
        flag = KINSol(solver->kin_mem, solver->kin_y, KIN_LINESEARCH, solver->kin_y_scale, solver->kin_f_scale);
        jmi_kinsol_solver_print_solve_end(block,flag);
        if(flag == KIN_INITIAL_GUESS_OK) {
        	flag = KIN_SUCCESS;
        } else if (flag == KIN_LINESEARCH_NONCONV) {
            KINGetFuncNorm(solver->kin_mem, &fnorm);
            if(fnorm <= solver->kin_stol) {
                flag = KIN_SUCCESS;
                /*jmi_log_warning(block->jmi, "Kinsol returned with the flag KIN_LINESEARCH_NONCONV but the residuals are converged in block %d, continuing", block->index);*/
            }
        }
        if(flag != KIN_SUCCESS) {
            if(flagNonscaled == 0)
                jmi_log_error(block->jmi, "The equations with initial scaling solved fine, re-scaled equations failed in block %d", block->index);
            else
                jmi_log_error(block->jmi, "Could not converge after re-scaling equations in block %d", block->index);
#ifdef JMI_KINSOL_PRINT_ON_FAIL
            {
                realtype* x = block->x;
                int i;
                struct KINMemRec * kin_mem = solver->kin_mem;
                
                printf("Could not converge in block %d,KINSOL error:%s,fnorm=%g,stol=%g,ftol=%g:\n"
                       "x = N.array([\n",block->index, KINGetReturnFlagName(flag), fnorm, solver->kin_stol,solver->kin_ftol);
                for (i=0;i<block->n;i++) {
                    printf("%.16e\n",x[i]);
                }
                printf("]);\n");
                printf("x_scale = N.array([\n");
                for (i=0;i<block->n;i++) {
                    printf("%.16e\n",Ith(solver->kin_y_scale,i));
                }
                printf("]);\n");
                printf("f = N.array([\n");
                for (i=0;i<block->n;i++) {
                    printf("%.16e\n",Ith(kin_mem->kin_fval,i));
                }
                printf("]);\n");
                N_VScale( 1+2*UNIT_ROUNDOFF,solver->kin_y,solver->kin_y);
                kin_f(solver->kin_y,kin_mem->kin_fval,block);
                printf("f_inc = N.array([\n");
                for (i=0;i<block->n;i++) {
                    printf("%.16e\n",Ith(kin_mem->kin_fval,i));
                }
                printf("]);\n");
                N_VScale( 1-4*UNIT_ROUNDOFF,solver->kin_y,solver->kin_y);
                kin_f(solver->kin_y,kin_mem->kin_fval,block);
                printf("f_dec = N.array([\n");
                for (i=0;i<block->n;i++) {
                    printf("%.16e\n",Ith(kin_mem->kin_fval,i));
                }
                printf("]);\n");

                printf("f_scale = N.array([\n");
                for (i=0;i<block->n;i++) {
                    printf("%.16e\n",Ith(solver->kin_f_scale,i));
                }
                printf("]);\n");
            }
#endif
        }
    }

    /* Write solution back to model just to make sure. In some cases x was not the last evaluations*/    
    block->F(block->jmi,block->x, NULL, JMI_BLOCK_WRITE_BACK);
    
    /* Get debug information */
    KINGetNumNonlinSolvIters(solver->kin_mem, &nniters);    
     
    /* Store debug information */
    block->nb_iters += nniters;
        
    return flag;
}

int jmi_kinsol_solver_evaluate_jacobian(jmi_block_residual_t* block, jmi_real_t* jacobian) {
    int i,j;
    int n_x;
    int ef;
    n_x = block->n;

	for(i = 0; i < n_x; i++){
		block->dx[i] = 1;
		ef |= block->dF(block->jmi,block->x,block->dx,block->res,block->dres,JMI_BLOCK_EVALUATE);
		for(j = 0; j < n_x; j++){
			jacobian[i*n_x+j] = block->dres[j];
		}
		block->dx[i] = 0;
	}

    return 0;
}

int jmi_kinsol_solver_evaluate_jacobian_factorization(jmi_block_residual_t* block, jmi_real_t* factorization) {
    /*
    int i,j;
    int n_x;
    int ef;
    n_x = block->n;
	for(i = 0; i < n_x; i++){
		block->dx[i] = 1;
		ef |= block->dF(block->jmi,block->x,block->dx,block->res,block->dres,JMI_BLOCK_EVALUATE);
		for(j = 0; j < n_x; j++){
			jacobian[i*n_x+j] = block->dres[j];
		}
		block->dx[i] = 0;
	}
*/
    return 0;
}

