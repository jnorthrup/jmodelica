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

#include <time.h>
#include <string.h>
#include <stdlib.h>

#include <sundials/sundials_math.h>
#include <sundials/sundials_direct.h>
#include <nvector/nvector_serial.h>
#include <kinsol/kinsol_direct.h>
#include <kinsol/kinsol_impl.h>

#include "jmi_kinsol_solver.h"
#include "jmi_block_solver_impl.h"
#include "jmi_block_solver.h"

#include "jmi_brent_search.h"
/* RCONST from SUNDIALS and defines a compatible type, usually double precision */
#define ONE RCONST(1.0)
#define Ith(v,i)    NV_Ith_S(v,i)
#define UROUND 1e-15

#define JMI_LIMIT_VALUE 1e30

/* KINSOL callback for linear system solve */
static int jmi_kin_lsolve(struct KINMemRec * kin_mem, N_Vector x, N_Vector b, realtype *res_norm);

/* KINSOL callback for setting up linear solver (jacobian update and decomposition) */
static int jmi_kin_lsetup(struct KINMemRec * kin_mem);

/* Update residual scales based on jacobian information */
static void jmi_update_f_scale(jmi_block_solver_t *block);

/* Calculate matrix vector product vv = M*v or vv = M^T*v */
static void jmi_kinsol_calc_Mv(DlsMat M, int transpose, N_Vector v, N_Vector vv) {
    realtype **m = M->cols;
    realtype*  vd = N_VGetArrayPointer(v);
    realtype*  vvd = N_VGetArrayPointer(vv);
    long int N = M->N;
    long int i,j;

    if(transpose) {
        for (i=0;i<N;i++) {
            vvd[i] = 0;
            for (j=0;j<N;j++){
                vvd[i] += m[i][j] * vd[j];
            }
        }
    } else {
        for (i=0;i<N;i++) {
            vvd[i] = 0;
        }
        for (i=0;i<N;i++) {
            for (j=0;j<N;j++){
                vvd[j] += m[i][j] * vd[i];
            }
        }
    }
}


/* Calculate Transpose(v1)*diag(w)*diag(w)*v2.
   w can be NULL in which case it is set to identity */
static realtype jmi_kinsol_calc_v1twwv2(N_Vector v1, N_Vector v2, N_Vector w) {
    long int i, N;
    realtype sum, prodi;

    sum = 0.0;

    N  = NV_LENGTH_S(v1);

    if( v1 == v2) {
        N_Vector v = v1;
        realtype *vd;
        vd = NV_DATA_S(v);
        if ( w != 0) {
            realtype *wd;
            wd = NV_DATA_S(w);
            for (i = 0; i < N; i++) {
                prodi = vd[i]*wd[i];
                sum += SQR(prodi);
            }
        } else {
            for (i = 0; i < N; i++) {
                prodi = vd[i];
                sum += SQR(prodi);
            }
        }
    } else {
        realtype *vd1, *vd2;
        vd1 = NV_DATA_S(v1);
        vd2 = NV_DATA_S(v2);
        if ( w != 0) {
            realtype *wd;
            wd = NV_DATA_S(w);
            for (i = 0; i < N; i++) {
                prodi = vd1[i]*wd[i]*wd[i]*vd2[i];
                sum += prodi;
            }
        } else {
            for (i = 0; i < N; i++) {
                prodi = vd1[i]*vd2[i];
                sum += prodi;
            }
        }
    }
    return(sum);
}


/* Kinsol Jacobian function wrapper */
int kin_dF(int N, N_Vector u, N_Vector fu, DlsMat J, jmi_block_solver_t * block, N_Vector tmp1, N_Vector tmp2);

/*Kinsol function wrapper
    @param yy - Input - function argument
    @param ff - Output - residuals
    @param problem_data - solver object propagated as opaque data
*/
int kin_f(N_Vector yy, N_Vector ff, void *problem_data){
#ifdef JMI_PROFILE_RUNTIME 
    clock_t t;
#endif
    realtype *y, *f;
    jmi_block_solver_t *block = problem_data;
    jmi_kinsol_solver_t* solver = block->solver;
    jmi_log_t *log = block->log;
    int n, ret;
    block->nb_fevals++;
    y = NV_DATA_S(yy); /*y is now a vector of realtype*/
    f = NV_DATA_S(ff); /*f is now a vector of realtype*/
#ifdef JMI_PROFILE_RUNTIME 
    if (block->n > 1) {
        t = clock();
    }
#endif
    n = NV_LENGTH_S(yy);
    ret = jmi_check_and_log_illegal_iv_input(block, y, n);
    /* Test if input is OK (no -1.#IND) */
    
    if(ret == -1) return ret;

    /*Evaluate the residual*/
    ret = block->F(block->problem_data,y,f,JMI_BLOCK_EVALUATE);
    
    if(ret) {
        jmi_log_node_t node = jmi_log_enter_fmt(block->log, logWarning, "ErrOutput", "<errorCode: %d> returned from function evaluation in <block: %s>", 
            ret, block->label);
        if (block->callbacks->log_options.log_level >= 3) {
            jmi_log_reals(log, node, logWarning, "ivs", y, block->n);
        }
        jmi_log_leave(log, node);

        /* Always treat this as a recoverable error */
        return 1;
    }

    /* Test if output is OK (no -1.#IND) */
    n = NV_LENGTH_S(ff);
    ret = jmi_check_and_log_illegal_residual_output(block, f, y, solver->residual_heuristic_nominal ,n);
    
    /* record information for Brent search */
    if(!ret && (block->n == 1) && block->options->use_Brent_in_1d_flag) {
        double yv = y[0];
        double fv = f[0];
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
 #ifdef JMI_PROFILE_RUNTIME 
    if (block->n > 1) {
        block->time_f += ((double)clock() - t) / CLOCKS_PER_SEC;
    }
#endif
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

static void kin_reset_char_log(jmi_kinsol_solver_t* solver) {
    solver->char_log_length = 0;
    solver->char_log[0] = 0;
}

static void kin_char_log(jmi_kinsol_solver_t* solver, char c) {
    if (solver->char_log_length < JMI_KINSOL_SOLVER_MAX_CHAR_LOG_LENGTH) {
        solver->char_log[solver->char_log_length] = c;
        solver->char_log_length++;
        solver->char_log[solver->char_log_length] = 0;
    } else {
        solver->char_log[JMI_KINSOL_SOLVER_MAX_CHAR_LOG_LENGTH-1] = '?';
    }
}
/* Wrapper function to Jacobian evaluation as needed by standard KINSOL solvers */
int kin_dF(int N, N_Vector u, N_Vector fu, DlsMat J, jmi_block_solver_t * block, N_Vector tmp1, N_Vector tmp2){
 #ifdef JMI_PROFILE_RUNTIME 
    clock_t t;
#endif
    jmi_kinsol_solver_t* solver = (jmi_kinsol_solver_t*)block->solver;        
    struct KINMemRec * kin_mem = (struct KINMemRec *)solver->kin_mem;    
    int i, j, ret = 0;
    realtype curtime = block->cur_time;
    realtype *jac_fd = NULL;
    solver->kin_jac_update_time = curtime;
    block->nb_jevals++;
 #ifdef JMI_PROFILE_RUNTIME 
    if (block->n > 1) {
        t = clock();
    }
#endif

    kin_char_log(solver, 'J');
    if((block->callbacks->log_options.log_level >= 6)) {
        char message[256];
        sprintf(message, "Updating Jacobian (evaluations: %d)", (int)block->nb_jevals);
        jmi_log_node(block->log, logInfo, "Progress", "<source:%s><block:%s><message:%s>",
                     "jmi_kinsol_solver", block->label, message);
    }

    if (!block->dF || block->options->block_jacobian_check) {
        /* Use (almost) standard finite differences */
        realtype inc, inc_inv, ujsaved, ujscale, sign;
        realtype *tmp2_data, *u_data, *uscale_data;
        N_Vector ftemp, jthCol;
            
        /* Save pointer to the array in tmp2 */
        tmp2_data = N_VGetArrayPointer(tmp2);
        
        /* Make sure that the residual values are up to date */
        ret = kin_f(u, fu, block);
        if(ret != 0) {
            return ret;
        }

        /* Rename work vectors for readibility */
        ftemp = tmp1; 
        jthCol = tmp2;
      
        /* Obtain pointers to the data for u and uscale */
        u_data   = N_VGetArrayPointer(u);
        uscale_data = N_VGetArrayPointer(solver->kin_y_scale);
      
        /* This is the only for loop for 0..N-1 in KINSOL */
      
        for (j = 0; j < N; j++) {
          realtype sqrt_relfunc = kin_mem->kin_sqrt_relfunc;
            
      
          ujsaved = u_data[j];
          ujscale = ONE/uscale_data[j];
          sign = (ujsaved >= 0) ? 1 : -1;
          inc = MAX(ABS(ujsaved), ujscale)*sign;
          if(sqrt_relfunc > 0) 
              inc *= sqrt_relfunc;
          u_data[j] += inc;
          /* make sure we're inside bounds*/
          if((u_data[j] > block->max[j]) || (u_data[j] < block->min[j])) {
              inc = -inc;
              u_data[j] = ujsaved + inc;
          }
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
          /* Generate the jth col of Jac(u) */
          N_VSetArrayPointer(DENSE_COL(J, j), jthCol);
          N_VLinearSum(inc_inv, ftemp, -inc_inv, fu, jthCol);
          /* Restore original array pointer in tmp2 */
          N_VSetArrayPointer(tmp2_data, tmp2);
        }
      
        /* Evaluate the residual with the original u vector to avoid that the initial guess 
           for the final IV is pertubated when the iterations start*/
        /*ret = kin_f(u, ftemp, block);*/

       
        if (block->options->block_jacobian_check) {
            jac_fd = (realtype*) calloc(N * N, sizeof(realtype));
            for (i = 0; i < N * N; i++) {
                jac_fd[i] = J->data[i];
            }
        }
    }
    if (block->dF) {
        /* utilize directional derivatives to calculate Jacobian */
        for(i = 0; i < N; i++){ 
            block->x[i] = Ith(u,i);
        }
        for(i = 0; i < N; i++){
            block->dx[i] = 1;
            ret |= block->dF(block->problem_data,block->x,block->dx,block->res,block->dres,JMI_BLOCK_EVALUATE);
            for(j = 0; j < N; j++){
                realtype dres = block->dres[j];
                (J->data)[i*N+j] = dres;
            }
            J->cols[i] = &(J->data)[i*N];
            block->dx[i] = 0;
        }       
    }
    
    if (block->options->block_jacobian_check) {
        /* compare analytical and finite differences Jacobians */
        if (block->dF) {
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
                    realtype fd_val = jac_fd[i * N + j];
                    realtype a_val = J->data[i * N + j];
                    realtype rel_error = RAbs(a_val - fd_val) / (RAbs(fd_val) + 1);
                    if (rel_error >= block->options->block_jacobian_check_tol) {
                        jmi_log_node(block->log, logError, "JacobianCheck",
                                     "<j: %d, i: %d, analytic: %e, finiteDifference: %e, relativeError: %e>", 
                                     j, i, a_val, fd_val, rel_error);
                    }
                }
            }
        } else {
            jmi_log_node(block->log, logError, "JacobianCheck", 
                         "No block jacobian specified, unable to do jacobian check");
        }
        free(jac_fd);
    }

    if((block->callbacks->log_options.log_level >= 4)) {
        jmi_log_node_t node = jmi_log_enter_fmt(block->log, logInfo, "JacobianUpdated", "<block:%s>", block->label);
        if (block->callbacks->log_options.log_level >= 6) {
            jmi_log_real_matrix(block->log, node, logInfo, "jacobian", J->data, N, N);
        }
        jmi_log_leave(block->log, node);
    }
 #ifdef JMI_PROFILE_RUNTIME 
    if (block->n > 1) {
        block->time_df += ((double)clock() - t) / CLOCKS_PER_SEC;
    }
#endif
    return ret;
}

static void jmi_kinsol_linesearch_nonconv_error_message(jmi_block_solver_t * block) {
    jmi_kinsol_solver_t* solver = block->solver;
    jmi_log_node_t node = jmi_log_enter(block->log, logError, "KinsolError");
    realtype fnorm, snorm;
    KINGetFuncNorm(solver->kin_mem, &fnorm);
    KINGetStepLength(solver->kin_mem, &snorm);
    
    jmi_log_fmt(block->log, node, logError, "Error occured in <function: %s> at <t: %f> when solving <block: %s>",
        "KINSol", block->cur_time, block->label);
    jmi_log_fmt(block->log, node, logError, "<msg: %s>", "The line search algorithm was unable to find an iterate sufficiently distinct from the current iterate.");
    jmi_log_fmt(block->log, node, logError, "<functionNorm: %g, scaledStepLength: %g, tolerance: %g>",
                fnorm, snorm, solver->kin_stol);
    jmi_log_leave(block->log, node);
}

static void jmi_kinsol_small_step_nonconv_error_message(jmi_block_solver_t * block) {
    jmi_kinsol_solver_t* solver = block->solver;
    jmi_log_node_t node = jmi_log_enter(block->log, logError, "KinsolError");
    realtype fnorm, snorm;
    KINGetFuncNorm(solver->kin_mem, &fnorm);
    KINGetStepLength(solver->kin_mem, &snorm);
    
    jmi_log_fmt(block->log, node, logError, "Error occured in <function: %s> at <t: %f> when solving <block: %s>",
        "KINSol", block->cur_time, block->label);
    jmi_log_fmt(block->log, node, logError, "<msg: %s>", "Step norm criterion is satisfied but residual norm is above the tolerance.");
    jmi_log_fmt(block->log, node, logError, "<functionNorm: %g, scaledStepLength: %g, tolerance: %g>",
                fnorm, snorm, solver->kin_stol);
    jmi_log_leave(block->log, node);
}

/* Logging callback for KINSOL used to report on errors during solution */
void kin_err(int err_code, const char *module, const char *function, char *msg, void *eh_data){
    jmi_log_category_t category = logWarning;
    jmi_block_solver_t *block = eh_data;
    jmi_kinsol_solver_t* solver = block->solver;
    realtype fnorm, snorm;
    KINGetFuncNorm(solver->kin_mem, &fnorm);
    KINGetStepLength(solver->kin_mem, &snorm);
    
    if((block->n == 1) && block->options->use_Brent_in_1d_flag)  /* Brent search will be used to find the root if possible -> no error */
            /* || (fnorm < solver->kin_stol)): In some cases KINSOL actually converges but returns an error anyway. Need to be double checked! */
    {
        return;
    }
    
    if ((err_code > 0) || !block->init) { /*Warning*/
        category = logWarning;
    } else if (err_code < 0){ /*Error*/
        category = logError;
    }
    
    if (err_code != KIN_LINESEARCH_NONCONV) /* If the error is LINSEARCH_NONCONV it might not be an error depending 
                                               in on the fnorm, so post-pone this error message in these cases */
    {
        jmi_log_node_t node = jmi_log_enter(block->log, category, "KinsolError");
        jmi_log_fmt(block->log, node, category, "Error occured in <function: %s> at <t: %f> when solving <block: %s>",
            function, block->cur_time, block->label);
        jmi_log_fmt(block->log, node, category, "<msg: %s>", msg);
        jmi_log_fmt(block->log, node, category, "<functionNorm: %g, scaledStepLength: %g, tolerance: %g>",
                    fnorm, snorm, solver->kin_stol);
        jmi_log_leave(block->log, node);

        if(block->options->check_jac_cond_flag) {
            char norm = 'I';
            double Jnorm = 1.0, Jcond = 1.0;
            int i, info, N = block->n;
            realtype tol = solver->kin_stol;
            realtype *scale_ptr = N_VGetArrayPointer(solver->kin_f_scale);
            for(i = 0; i < N; i++){
                int j;
                realtype* scaled_col_ptr = DENSE_COL(solver->J_scale, i);
                realtype* col_ptr = DENSE_COL(solver->J, i);
                realtype xscale = RAbs(block->nominal[i]);
                realtype x = RAbs(block->x[i]);
                if(x < xscale) x = xscale;
                if(x < tol) x = tol;
                for(j = 0; j < N; j++){
                    scaled_col_ptr[j] = col_ptr[j] * x *scale_ptr[j];
                }
            }
            dgetrf_(  &N, &N, solver->J_scale->data, &N, solver->lapack_iwork, &info);
            if(info > 0) {
                jmi_log_node(block->log, logWarning, "SingularJacobian",
                    "Singular Jacobian detected when checking condition number in <block:%s>. Solver may fail to converge.", block->label);
            }
            else {
                dgecon_(&norm, &N, solver->J_scale->data, &N, &Jnorm, &Jcond, solver->lapack_work, solver->lapack_iwork,&info);       

                if(tol * Jcond < UNIT_ROUNDOFF) {
                    jmi_log_node_t node = jmi_log_enter_fmt(block->log, logWarning, "IllConditionedJacobian",
                        "<JacobianInverseConditionEstimate:%E> Solver may fail to converge in <block: %s>.", Jcond, block->label);
                    if (block->callbacks->log_options.log_level >= 4) {
                        jmi_log_reals(block->log, node, logWarning, "ivs", N_VGetArrayPointer(solver->kin_y), block->n);
                    }
                    jmi_log_leave(block->log, node);

                }
                else {
                    jmi_log_node(block->log, logInfo, "JacobianCondition",
                        "<JacobianInverseConditionEstimate:%E>", Jcond);
                }
            }
        }
    }

    /* todo: remove? */
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

static void jmi_kinsol_print_progress(jmi_block_solver_t *block, int logResidualOnlyFlag) {
    jmi_kinsol_solver_t* solver = (jmi_kinsol_solver_t*)block->solver;
    jmi_log_t *log = block->log;
    struct KINMemRec* kin_mem = (struct KINMemRec*)solver->kin_mem;
    long nniters;
    char message[256];

    if (block->callbacks->log_options.log_level < 4) return;
    KINGetNumNonlinSolvIters(kin_mem, &nniters);
    /* Only print header first iteration */
    if (nniters == 0) {
        jmi_log_node(log, logInfo, "Progress", "<source:%s><message:%s><isheader:%d>",
            "jmi_kinsol_solver",
            "iter       res_norm      max_res: ind   nlb  nab   lambda_max: ind      lambda",
            1);
    }
    if(logResidualOnlyFlag) {
        /* last log in the solve trace - use (nniter+1)*/
        nniters = nniters + 1;
    }
    if (nniters > 0) {
        int nwritten = 0;
        /* Keep the progress message on a single line by using jmi_log_enter_, jmi_log_fmt_ etc. */
        jmi_log_node_t node = jmi_log_enter_(log, logInfo, "Progress");
        
        nwritten = sprintf(message, "%4d%-4s%11.4e % 11.4e:%4d", (int)nniters, solver->char_log,
            solver->last_fnorm, solver->last_max_residual, solver->last_max_residual_index+1);
        kin_reset_char_log(solver);
        if(!logResidualOnlyFlag) {
            char*  buffer = message + nwritten;
            if (solver->last_bounding_index >= 0) {
                if(solver->range_most_limiting) {
                    sprintf(buffer, "  %4d %4d  %11.4e:%4dr %11.4e",
                        solver->last_num_limiting_bounds, solver->last_num_active_bounds,
                        solver->lambda_max, solver->last_bounding_index+1, solver->lambda);
                }
                else {
                    sprintf(buffer, "  %4d %4d  %11.4e:%4d  %11.4e",
                        solver->last_num_limiting_bounds, solver->last_num_active_bounds,
                        solver->lambda_max, solver->last_bounding_index+1, solver->lambda);
                }
            }
            else {
                sprintf(buffer, "  %4d %4d  %11.4e       %11.4e",
                    solver->last_num_limiting_bounds, solver->last_num_active_bounds,
                    solver->lambda_max, solver->lambda);
            }

        }
        jmi_log_fmt_(log, node, logInfo, "<source:%s><block:%s><message:%s>",
            "jmi_kinsol_solver", block->label, message);
        jmi_log_leave(log, node);
    }
    return;
}

/* Logging callback used by KINSOL to report progress att higher log levels */
void kin_info(const char *module, const char *function, char *msg, void *eh_data){
    int i;
    jmi_block_solver_t *block = eh_data;
    jmi_kinsol_solver_t* solver = block->solver;
    struct KINMemRec* kin_mem = solver->kin_mem;
    realtype* residual_scaling_factors = N_VGetArrayPointer(solver->kin_f_scale);
    jmi_log_t *log = block->log;

    
    /* Only output an iteration under certain conditions:
         *  1. nle_solver_log > 2
         *  2. The calling function is either KINSolInit or KINSol
         *  3. The message string starts with "nni"
         *
         *  This approach gives one printout per iteration
         */

    if (block->callbacks->log_options.log_level >= 4)
    {
        jmi_log_node_t topnode = jmi_log_enter(log, logInfo, "KinsolInfo");
        jmi_log_fmt(log, topnode, logInfo, "<calling_function:%s>", function);
        jmi_log_fmt(log, topnode, logInfo, "<message:%s>", msg);
        
        if (strcmp("KINStop",function)==0) {
            solver->iterationProgressFlag = 1;
        } else if ((((strcmp("KINSolInit",function)==0) ||
              (strcmp("KINSol",function)==0)) && (strncmp("nni",msg,3)==0))) {
            realtype* f = N_VGetArrayPointer(kin_mem->kin_fval);
            long int nniters;

            int max_index = 0;
            realtype max_residual = 0;

            /* Get the number of iterations */
            KINGetNumNonlinSolvIters(kin_mem, &nniters);
    
            if (block->callbacks->log_options.log_level >= 5 && nniters > 0) {
                if(solver->iterationProgressFlag) {
                    jmi_log_reals(log, topnode, logInfo, "actual_step", N_VGetArrayPointer(kin_mem->kin_pp), block->n);
                } else {
                    jmi_log_node_t node= jmi_log_enter_vector_(log, topnode, logInfo, "actual_step");
                    for( i=0; i<block->n; i++) {
                        jmi_log_real_(log, 0.0);
                    }
                    jmi_log_leave(log, node);
                }
            }
            
            jmi_log_fmt(log, topnode, logInfo, "<iteration_index:%I>", (int)nniters);
            if(solver->iterationProgressFlag) 
                jmi_log_fmt(log, topnode, logInfo, "<scaled_step_norm:%E>", N_VWL2Norm(kin_mem->kin_pp, kin_mem->kin_uscale));       
            else
                jmi_log_fmt(log, topnode, logInfo, "<scaled_step_norm:%E>", 0.0);

            {
                /* Extract lambda_max and lambda for logging */
                realtype lambda_max = 0.0;
                realtype lambda = 0.0;

                if (nniters > 0 && solver->last_xnorm > 0 ) {
                    lambda_max = solver->max_step_ratio;
                    if(solver->iterationProgressFlag) {
                        if(solver->sJpnorm == 0) {
                            lambda = 1.0;
                        } else {
                            lambda = kin_mem->kin_sJpnorm / solver->sJpnorm;
                        }
                        if(solver->last_num_active_bounds > 0)
                            lambda *= solver->max_step_ratio;
                    } else {
                        lambda = 0;
                    }
                }
                else {
                    lambda_max = lambda = 0;
                }
                solver->lambda = lambda;
                solver->lambda_max = lambda_max;

                if (solver->use_steepest_descent_flag) kin_char_log(solver, 'd');
                if (solver->J_is_singular_flag) kin_char_log(solver, 'r');

                jmi_kinsol_print_progress(block, 0);
                if (nniters > 0) {
                    jmi_log_fmt(log, topnode, logInfo, "<lambda_max:%E>", lambda_max);
                    jmi_log_fmt(log, topnode, logInfo, "<lambda:%E>", lambda);
                }

            }

            jmi_log_reals(log, topnode, logInfo, "ivs", N_VGetArrayPointer(kin_mem->kin_uu), block->n);
            if(solver->iterationProgressFlag || nniters == 0) {
                jmi_log_fmt(log, topnode, logInfo, "<scaled_residual_norm:%E>", kin_mem->kin_fnorm);
                if (block->callbacks->log_options.log_level >= 5) {
                    jmi_log_node_t node;
                    node = jmi_log_enter_vector_(log, topnode, logInfo, "scaled_residuals");
                    for (i=0;i<block->n;i++) jmi_log_real_(log, f[i]*residual_scaling_factors[i]);
                    jmi_log_leave(log, node);
                }
                if (block->n >= 1) {
                    max_residual = f[0]*residual_scaling_factors[0];
                    for (i=1;i<block->n;i++) {
                        realtype res = f[i]*residual_scaling_factors[i];
                        if (RAbs(res) > RAbs(max_residual)) {
                            max_residual = res;
                            max_index = i;
                        }
                    }
                    jmi_log_fmt(log, topnode, logInfo, "<max_scaled_residual_value:%E>", max_residual);
                    jmi_log_fmt(log, topnode, logInfo, "<max_scaled_residual_index:%I>", max_index);
                }

                solver->last_fnorm = kin_mem->kin_fnorm;
                solver->last_max_residual= max_residual;
                solver->last_max_residual_index = max_index;
            } 

            solver->iterationProgressFlag = 0;
        }
        
        jmi_log_leave(log, topnode);
    }
    
}

/* Print out meaningfull message based on KINSOL return flag */
void jmi_kinsol_error_handling(jmi_block_solver_t * block, int flag){
    if (flag != 0) {
        jmi_log_node(block->log, logError, "KinsolError", "KINSOL returned with <kinsol_flag: %s>", jmi_kinsol_flag_to_name(flag));
    }
}

/* initialize data on bounds */
static int jmi_kinsol_init_bounds(jmi_block_solver_t * block) {
    jmi_kinsol_solver_t* solver = (jmi_kinsol_solver_t*)block->solver;
        
    int i,num_bounds = 0;
    
    if(!block->options->enforce_bounds_flag) {
        solver->num_bounds = 0;
        return 0;
    }
    
    for(i=0; i < block->n; ++i) {
        if(block->max[i] != BIG_REAL) num_bounds++;
        if(block->min[i] != -BIG_REAL) num_bounds++;
    }
    
    solver->num_bounds = num_bounds;
    if(num_bounds) {
        solver->bound_vindex = (int*)calloc(num_bounds, sizeof(int));
        solver->bound_kind  = (int*)calloc(num_bounds, sizeof(int));
        solver->bound_limiting  = (int*)calloc(num_bounds, sizeof(int));
        solver->bounds = (realtype*)calloc(num_bounds, sizeof(realtype));
        solver->active_bounds = (realtype*)calloc(block->n, sizeof(realtype));
        num_bounds = 0;
    }

    for(i=0; i < block->n; ++i) {
        int hasMin = 0, hasMax = 0;
        double range = block->max[i] - block->min[i];

        if(block->max[i] != BIG_REAL) {
            /* upper bound on a variable */
            solver->bound_vindex[num_bounds] = i; /* variable index */
            solver->bound_kind[num_bounds] = 1;
            solver->bounds[num_bounds] = block->max[i];
            num_bounds++;
            hasMax = 1;
        }
        if(block->min[i] != -BIG_REAL) {
            /* lower bound on a variable */
            solver->bound_vindex[num_bounds] = i; /* variable index */
            solver->bound_kind[num_bounds] = -1;
            solver->bounds[num_bounds] = block->min[i];
            num_bounds++;
            hasMin = 1;
        }
        
        if(hasMin && hasMax && (range > 0) /* range limit only of interest when both max & min are present and are of the same sign */
            && (block->max[i] * block->min[i] > 0) ) {
            solver->range_limits[i] = range * block->options->step_limit_factor;
        }
        else {
            solver->range_limits[i] = BIG_REAL;
        }
        if(block->max[i] == block->min[i])
            jmi_log_node(block->log, logWarning, "MinAndMaxEqual", "Min and max equal for <Iter: #r%d#>.", block->value_references[i]);
    }

    return 0;
}

/* Helper to convert log_level used in the logger to print level in KINSOL */
static int get_print_level(jmi_block_solver_t* bs) {
    int log_level = bs->callbacks->log_options.log_level;
    if (log_level <= 2) return 0;
    else if (log_level <= 4) return log_level-2;
    else return 3;
}

/* Initialize solver structures */
static int jmi_kinsol_init(jmi_block_solver_t * block) {
    jmi_kinsol_solver_t* solver = block->solver;
    int ef, i;
    double max_nominal;
    struct KINMemRec * kin_mem = solver->kin_mem; 

    jmi_log_node_t node = jmi_log_enter_fmt(block->log, logInfo, "SolverOptions", "<block:%s>", block->label);
    jmi_log_fmt(block->log, node,logInfo, "Tolerance <tolerance: %g>",block->options->res_tol);
    jmi_log_fmt(block->log, node,logInfo, "Max number of iterations <max_iter: %d>",block->options->max_iter);
    jmi_log_fmt(block->log, node,logInfo, "Step limit <step_limit_factor: %g>",block->options->step_limit_factor);
    if(block->options->experimental_mode != 0)
        jmi_log_fmt(block->log, node,logInfo, "Experimental <experimental_mode: %d>",block->options->experimental_mode);
    jmi_log_fmt(block->log, node, logInfo, " <rescale_after_singular_jac: %d>", block->options->rescale_after_singular_jac_flag);
    jmi_log_fmt(block->log, node, logInfo, " <use_Brent_in_1d: %d>", block->options->use_Brent_in_1d_flag);
    jmi_log_fmt(block->log, node, logInfo, " <check_jac_cond: %d>", block->options->check_jac_cond_flag);
    jmi_log_fmt(block->log, node, logInfo, " <enforce_bounds: %d>", block->options->enforce_bounds_flag);
    jmi_log_fmt(block->log, node, logInfo, " <iteration_variable_scaling: %d>", block->options->iteration_variable_scaling_mode);
    jmi_log_fmt(block->log, node, logInfo, " <residual_equation_scaling: %d>", block->options->residual_equation_scaling_mode);
    jmi_log_fmt(block->log, node, logInfo, " <regularization_tolerance: %g>", block->options->regularization_tolerance);
    jmi_log_fmt(block->log, node, logInfo, " <min_residual_scaling_factor: %g>", block->options->min_residual_scaling_factor);
    jmi_log_fmt(block->log, node, logInfo, " <max_residual_scaling_factor: %g>", block->options->max_residual_scaling_factor);
    jmi_log_fmt(block->log, node, logInfo, " <use_jacobian_equilibration: %d>", block->options->use_jacobian_equilibration_flag);
    jmi_log_fmt(block->log, node, logInfo, " <Brent_ignore_error: %d>", block->options->brent_ignore_error_flag);
    jmi_log_leave(block->log, node);

    KINSetPrintLevel(solver->kin_mem, get_print_level(block));

    /* Test to enable residual monitoring based Jac update */
    KINSetNoResMon(solver->kin_mem,(block->options->experimental_mode & jmi_block_solver_experimental_residual_monitoring)?0:1);

    /* set tolerances */
    if((block->n > 1) || !block->options->use_Brent_in_1d_flag) {
        solver->kin_stol = block->options->res_tol;
        if(solver->kin_stol < block->options->min_tol) {
            solver->kin_stol = block->options->min_tol;
        }
    }
    else
        solver->kin_stol = block->options->min_tol;
    
    solver->kin_ftol = UROUND; /* block->options->res_tol; */
    
    /* If not set, set the default */
    if (block->options->regularization_tolerance == -1){
        solver->kin_reg_tol = 1.0/block->options->res_tol;
    } else {
        solver->kin_reg_tol = block->options->regularization_tolerance;
    }

    KINSetScaledStepTol(solver->kin_mem, solver->kin_stol);
    KINSetFuncNormTol(solver->kin_mem, solver->kin_ftol);
    KINSetNumMaxIters(solver->kin_mem, block->options->max_iter);
    
    /* Allow long steps */
    max_nominal = 1;
    for(i=0;i< block->n;++i){
        double nom = RAbs(block->nominal[i]);
        if (nom > max_nominal) {
            max_nominal = RAbs(block->nominal[i]);
        }
    }
    solver->max_nw_step = block->options->step_limit_factor*max_nominal;
    KINSetMaxNewtonStep(solver->kin_mem, solver->max_nw_step);
    
    if(block->options->iteration_variable_scaling_mode)
    {
        /* 
            Set variable scaling based on nominal values.          
        */
        int i;
        for(i=0;i< block->n;++i){
            double nominal = RAbs(block->nominal[i]);
            if(nominal != 1.0) {
                if(nominal == 0.0)
                    nominal = 1/solver->kin_stol;
                else
                    nominal = 1/nominal;
                Ith(solver->kin_y_scale,i)=nominal;
            }
        }
    }

    solver->last_xnorm = 1.0;
    jmi_kinsol_init_bounds(block);
    
    /* evaluate the function at initial */
    ef =  kin_f(solver->kin_y, kin_mem->kin_fval, block);
    if(ef) {
        if (!block->options->use_nominals_as_fallback_in_init) {
            jmi_log_node(block->log, logError, "Error", "Residual function evaluation failed at initial point for "
                     "<block: %s>", block->label);
        } else {
            int changed_start = 0;
                     
            for (i = 0; i < block->n; i++) {
                if (block->start_set[i] == 0) {
                    changed_start = 1;
                    N_VGetArrayPointer(solver->kin_y)[i] = block->nominal[i] <= block->max[i] ? block->nominal[i] : -block->nominal[i];
                }
            }
            if (changed_start) {
                jmi_log_node(block->log, logWarning, "Warning", "Residual function evaluation failed at initial point for "
                     "<block: %s>", block->label);
                     
                jmi_log_node(block->log, logInfo, "NominalsAsInitialGuess", "Failed to evaluate the residual using the default initial guess. Attempting using the nominal values in <block:%s>", block->label);
            
                ef =  kin_f(solver->kin_y, kin_mem->kin_fval, block);
                if(ef) {
                    jmi_log_node(block->log, logError, "Error", "Residual function evaluation failed at initial point for "
                             "<block: %s>", block->label);
                }
            }
        }
    }
    kin_mem->kin_uscale = solver->kin_y_scale;
    /* evaluate Jacobian at initial */
    if(jmi_kin_lsetup(kin_mem)) {
        ef = 1;
        jmi_log_node(block->log, logError, "Error", "Jacobian evaluation failed at initial point for "
                     "<block: %s>", block->label);
    }
    return ef;
}

/* Limit the maximum step to be within bounds. Do projection if needed. */
static void jmi_kinsol_limit_step(struct KINMemRec * kin_mem, N_Vector x, N_Vector b) {
    jmi_block_solver_t *block = (jmi_block_solver_t *)kin_mem->kin_user_data;
    jmi_kinsol_solver_t* solver = (jmi_kinsol_solver_t*)block->solver;  
    realtype xnorm;        /* step norm */
    realtype min_step_ratio; /* fraction of the Newton step that is still over minimal step*/
    realtype max_step_ratio; /* maximum step length ratio limited by bounds */

    realtype* xxd = N_VGetArrayPointer(x); /* Newton step on input, may be modified if step is projected */
    realtype* xd = N_VGetArrayPointer(b); /* used as a buffer */
    booleantype activeBounds = FALSE;
    booleantype limitingBounds = FALSE;
    booleantype rangeLimited = FALSE;
    int i;
    jmi_log_t *log = block->log;
    jmi_log_node_t outer;
    jmi_log_node_t inner;

    /* MAX_NEWTON_STEP_RATIO is used just to ensure that full Newton step can 
    be taken when no bounds are present. 
    TODO: Consider addionally limiting the Newton step length set
    based on the nominal values of the IVs.
    Consider using block->options->step_limit_factor instead
    */
#define MAX_NEWTON_STEP_RATIO 1.0

    xnorm = N_VWL2Norm(x, kin_mem->kin_uscale); /* scaled L2 norm of the Newton step */
    solver->last_xnorm = xnorm;
    solver->last_bounding_index = -1;
    solver->last_num_limiting_bounds = 0;
    solver->last_num_active_bounds = 0;
    solver->range_most_limiting = FALSE;

    if((!block->options->enforce_bounds_flag) || (xnorm == 0.0)) 
    {
        /* make sure full newton step can be taken */
        realtype maxstep = 2.0 * xnorm;
#if 0
        if(maxstep > kin_mem->kin_mxnewtstep)
#endif
            kin_mem->kin_mxnewtstep = maxstep;
        return;
    }

    /*  Scale the step up so that step multiplier is 1.0 at the beginning.
        The "long" step is now saved into "b", pointed by "xd"
    */
    N_VScale(MAX_NEWTON_STEP_RATIO, x, b);
    
    /* minimal/maximal allowed step multiplier */
    max_step_ratio = 1.0;
    if(block->options->experimental_mode & jmi_block_solver_experimental_active_bounds_threshold)
        min_step_ratio = block->options->active_bounds_threshold;
    else
        min_step_ratio = 2*solver->kin_stol;

    /* 
        Go over the list of bounds and reduce "max_step_ratio"; project if needed
    */
    for(i = 0; i < solver->num_bounds; ++i) {
        int index = solver->bound_vindex[i]; /* variable index */
        int kind = solver->bound_kind[i];   /* min or max */
        realtype ui =  NV_Ith_S(kin_mem->kin_uu,index);  /* current variable value */
        realtype pi = xd[index];            /* solved step length for the variable*/
        realtype bound = solver->bounds[i]; 
        realtype pbi = (bound - ui)*(1 - UNIT_ROUNDOFF);  /* distance to the bound */
        realtype step_ratio_i;        
        int nom_criteria = FALSE;        

        if(    ((kind == 1)&& (pbi >= pi))
            || ((kind == -1)&& (pbi <= pi))) {
            solver->bound_limiting[i] = 0 ;
            continue; /* will not cross the bound */
        }

        solver->bound_limiting[i] = 1 ;
        limitingBounds = TRUE ;
        solver->last_num_limiting_bounds++;
        step_ratio_i =pbi/pi;   /* step ratio to bound */
        if(jmi_block_solver_experimental_nom_in_active_bounds & block->options->experimental_mode) {
            realtype nom_step_ratio_i;
            realtype nom_i = RAbs(block->nominal[index]);
            double eps = solver->kin_stol;
            nom_step_ratio_i = (eps*kind*nom_i+ui-bound)/-pi; /* The fraction delta of the step so that (bound-(ui+pi*delta))*kind=stol*nom */
            if(nom_step_ratio_i < min_step_ratio) {
                nom_criteria = TRUE;
            }
            if( (kind == 1 && ui > bound-eps*nom_i && ui <= bound) ||
                (kind== -1 && ui < bound+eps*nom_i && ui >= bound)) {
                    nom_criteria = TRUE;
            }
            if( (kind == 1 && ui+pi < bound+eps*nom_i) || (kind==-1 && ui+pi > bound-eps*nom_i) ) {
                nom_criteria = TRUE;
            }
        }
        if(step_ratio_i < min_step_ratio || (jmi_block_solver_experimental_nom_in_active_bounds & block->options->experimental_mode && nom_criteria)) {
            /* this bound is active (we need to follow it) */
            activeBounds = TRUE;
            solver->bound_limiting[i] = 2;
            solver->last_num_active_bounds++;
            xxd[index] = 0;
            /* distance to the bound */
            solver->active_bounds[index] = pbi; /*  (kind == 1)? pbi:-pbi ; */
        }
        else {
            if (max_step_ratio > step_ratio_i) {
                /* reduce the step */
                max_step_ratio = step_ratio_i;
                solver->last_bounding_index = index;
                solver->range_most_limiting = FALSE;
            }
        }
    }

    if (block->callbacks->log_options.log_level >= 5) {
        jmi_log_node(log, logInfo, "BoundsMaxStepRatio", "Step ratio after bounds check <lambda_max_bounds: %g>", max_step_ratio);
    }

    /*
        Go over the iteration vars and reduce max_step_ratio
        based on step_limit_factor & range_limits
    */
    if(block->options->step_limit_factor <= 1 ) {
        if (block->callbacks->log_options.log_level >= 5) {
            /* Print variables with long steps */
            outer = jmi_log_enter_(log, logInfo, "StepLimits");
            inner = jmi_log_enter_vector_(log, outer, logInfo, "range");
        }

        for( i=0; i<block->n; i++ ) {
            double range_limit = solver->range_limits[i];
            double step_limit = range_limit;
            realtype pi = RAbs(xxd[i]);            /* abs solved step length for the variable*/
            double nom = RAbs(block->nominal[i]);
            double nom_limit;
            double ui =  RAbs(NV_Ith_S(kin_mem->kin_uu,i));  /* current variable value */
            double step_ratio;
            int activeBound = 0;
            realtype bnd;
            
            if(solver->num_bounds > 0)
                bnd = solver->active_bounds[i];
            else
                bnd = 0.0;

            if(pi == 0.0) {
                /* either projected or zero step */                
                if(bnd != 0.0) { 
                    /* enforce range check to avoid jumping over the full range */
                    pi = RAbs(bnd);                    
                    activeBound = 1;
                }
                else {
                    /* zero step - no range violation possible*/
                    solver->range_limited[i] = 0;
                    if (block->callbacks->log_options.log_level >= 5) {
                        jmi_log_real_(log, BIG_REAL);
                    }
                    continue;
                }
            }

            if(nom < ui) {  /* if nominal is below current - take current*/
                nom = ui; 
            }
            /* step length limit based on max(nominal, |current|)*/
            nom_limit = nom *  block->options->step_limit_factor;
            if(range_limit > nom_limit) { /* if nominal based is tighter than range based update step factor */
                step_limit = nom_limit;
            }

            if (block->callbacks->log_options.log_level >= 5) {
                jmi_log_real_(log, step_limit);
            }

            if( pi < step_limit) {
                solver->range_limited[i] = 0;
                continue;
            }

            solver->range_limited[i] = 1;
            rangeLimited = TRUE;
            
            if(activeBound) {
                if(bnd > 0)
                    solver->active_bounds[i] = step_limit;
                else
                    solver->active_bounds[i] = -step_limit;
            } else {
                step_ratio = step_limit/RAbs(pi);

                if(max_step_ratio > step_ratio) {
                    max_step_ratio = step_ratio;
                    solver->last_bounding_index = i;
                    solver->range_most_limiting = TRUE;
                }
            }
        }

        if (block->callbacks->log_options.log_level >= 5) {
            jmi_log_leave(log, inner);
            jmi_log_leave(log, outer);
            jmi_log_node(block->log, logInfo, "RangeMaxStepRatio", "Step ratio after range check <lambda_max_range: %g>", max_step_ratio);
        }
    }

    /* log the IV ranges that limit the step */
    if (block->callbacks->log_options.log_level >= 5 && rangeLimited) {
        /* Print variables with long steps */
        jmi_log_node_t outer = jmi_log_enter_(log, logInfo, "RangeLimited");
        jmi_log_node_t inner = jmi_log_enter_vector_(log, outer, logInfo, "range");            
        for (i=0; i < block->n; i++) {
            if (solver->range_limited[i]) {
                jmi_log_vref_(log, 'r', block->value_references[i]);
            }
        }
        jmi_log_leave(log, inner);
        jmi_log_leave(log, outer);
    }

    /* log the bounds that limit the step */
    if (block->callbacks->log_options.log_level >= 5 && limitingBounds) {
        /* Print limiting bounds */
        jmi_log_node_t outer = jmi_log_enter_(log, logInfo, "LimitationBounds");
        int kind;
        for (kind=1; kind >= -1; kind -= 2) {
            jmi_log_node_t inner = jmi_log_enter_vector_(log, outer, logInfo, 
                                                         kind==1 ? "max" : "min");            
            for (i=0; i < solver->num_bounds; i++) {
                int index = solver->bound_vindex[i]; /* variable index */
                if (solver->bound_limiting[i] != 0
                    && solver->bound_kind[i] == kind) {
                    jmi_log_vref_(log, 'r', block->value_references[index]);
                }
            }
            jmi_log_leave(log, inner);
        }
        jmi_log_leave(log, outer);
    }
    /* log the active bounds that we are following */
    if (block->callbacks->log_options.log_level >= 5 && activeBounds) {        
        /* Print active bounds*/
        jmi_log_node_t outer = jmi_log_enter_(log, logInfo, "ActiveBounds");
        int kind;
        for (kind=1; kind >= -1; kind -= 2) {
            jmi_log_node_t inner = jmi_log_enter_vector_(log, outer, logInfo, 
                                                         kind==1 ? "max" : "min");            
            for (i=0; i < solver->num_bounds; i++) {
                int index = solver->bound_vindex[i]; /* variable index */
                
                if ((solver->bound_limiting[i] == 2) 
                    && solver->bound_kind[i] == kind) {
                    jmi_log_vref_(log, 'r', block->value_references[index]);
                }
            }
            jmi_log_leave(log, inner);
        }
        jmi_log_leave(log, outer);
    }

    /* 
        Since analysis was done with x = MAX_NEWTON_STEP_RATIO * Newton step
        the actual Newton step ration is also MAX_NEWTON_STEP_RATIO larger
    */
    max_step_ratio *= MAX_NEWTON_STEP_RATIO * (1 - UNIT_ROUNDOFF);
    
    /* If the step is limited by a bound or we're following the bound it
    should be allowed to take the full step length more than 5 times
    which is a fixed check in KINSOL */
    if((max_step_ratio < 1) || activeBounds) {
        kin_mem->kin_ncscmx = 0; /* allow for more steps of kin_mxnewtstep length in this case */
    }

    solver->max_step_ratio = max_step_ratio;
    if(!activeBounds) {
        /* bounds do not affect the base-line algorithm, only limit the step */
        kin_mem->kin_mxnewtstep = max_step_ratio * xnorm ;
        return;
    }

    /* Update the x to be the maximum vector within bounds */ 
    for(i = 0; i < block->n; ++i) {
        realtype bnd = solver->active_bounds[i];
        if(bnd != 0.0) { /* the maximum step should keep us on this active bound */
            xd[i] = bnd;
            solver->active_bounds[i] = 0;
        }
        else if(max_step_ratio < 1.0) { /* update the step length for other vars */
            xd[i] = xxd[i] * max_step_ratio;
        }
        else xd[i] = xxd[i];
    }
    if(max_step_ratio < 1.0) {
        /* reduce the norms of Jp. This is only approximate since active bounds are not accounted for.*/
        kin_mem->kin_sfdotJp *= max_step_ratio;
        kin_mem->kin_sJpnorm *= max_step_ratio;
        solver->sJpnorm = kin_mem->kin_sJpnorm;
    }
    /* The maximum newton step leads to the bound  
    -> store the "x" and set maximum step to be L2 norm of x */
    N_VScale(1.0, b, x);

    xnorm = N_VWL2Norm(x, kin_mem->kin_uscale); /* scaled L2 norm of the Newton step */
    solver->last_xnorm = xnorm*(1 - UNIT_ROUNDOFF);

    kin_mem->kin_mxnewtstep =  solver->last_xnorm;
}

/* Form regularized matrix Transpose(J).J */
static void jmi_kinsol_reg_matrix(jmi_block_solver_t * block) {
    jmi_kinsol_solver_t* solver = block->solver;
    int i,j,k;
    realtype **JTJ_c =  solver->JTJ->cols;
    realtype **jac = solver->J->cols;
    int N = block->n;
    realtype * uscale_data = N_VGetArrayPointer(solver->kin_y_scale);
    realtype * fscale_data = N_VGetArrayPointer(solver->kin_f_scale);    

    for (i=0;i<N;i++) {
        /* Add the regularization parameter on the diagonal.   */        
        JTJ_c[i][i] = uscale_data[i]*uscale_data[i];
        /*Calculate value at RTR(i,i) */
        for (k=0;k<N;k++) JTJ_c[i][i] += jac[i][k]*jac[i][k]*fscale_data[k]*fscale_data[k];
        for (j=i+1;j<N;j++){
            
            /*Calculate value at RTR(i,j) */
            JTJ_c[j][i] = 0;
            for (k=0;k<N;k++) JTJ_c[j][i] += jac[j][k]*jac[i][k]*fscale_data[k]*fscale_data[k];
            JTJ_c[i][j] = JTJ_c[j][i];
        }
    }
}

/* Estimate condition number utilizing dgecon from LAPACK*/
static realtype jmi_calculate_jacobian_condition_number(jmi_block_solver_t * block) {
    jmi_kinsol_solver_t* solver = block->solver;
    char norm = 'I';
    int N = block->n;
    double J_norm = 1.0;
    double J_recip_cond = 1.0;
    int info;

    /* Copy Jacobian to factorization matrix */
    DenseCopy(solver->J, solver->J_LU);
    /* Perform LU factorization to be used with dgecon */
    dgetrf_(&N, &N, solver->J_LU->data, &N, solver->lapack_ipiv, &info);
    if (info != 0 ) {
        /* If matrix i singular, return something very large to be evaluated*/
        return 1e100;
    }

    /* Compute infinity norm of J to be used with dgecon */
    J_norm = dlange_(&norm, &N, &N, solver->J->data, &N, solver->lapack_work);

    /* Compute reciprocal condition number */
    dgecon_(&norm, &N, solver->J_LU->data, &N, &J_norm, &J_recip_cond, solver->lapack_work, solver->lapack_iwork,&info);
    /* To be evaluated - why is this needed? Error handling due to J being used instead of J_LU?
    if(Jcond < 0) Jcond = -Jcond;
    if(Jcond == 0.0) Jcond = 1e-30;
    */
    return 1.0/J_recip_cond;
}

/* Callback from KINSOL called to calculate Jacobian */
static int jmi_kin_lsetup(struct KINMemRec * kin_mem) {
    jmi_block_solver_t *block = kin_mem->kin_user_data;
    jmi_kinsol_solver_t* solver = block->solver;
    
    int info;
    int N = block->n;
      
    int ret;
    SetToZero(solver->J);

    /* Evaluate Jacobian */
    ret = kin_dF(N, solver->kin_y, kin_mem->kin_fval, solver->J, block, kin_mem->kin_vtemp1, kin_mem->kin_vtemp2);
    solver->updated_jacobian_flag = 1; /* The Jacobian is current */
    
    if(ret != 0 ) return ret; /* There was an error in calculation of Jacobian */
    
    if(solver->use_steepest_descent_flag) return ret; /* No further processing when using steepest descent */

    DenseCopy(solver->J, solver->J_LU); /* make at copy of the Jacobian that will be used for LU factorization */

    /* Equillibrate if corresponding option is set */
    if((N>1) && block->options->use_jacobian_equilibration_flag) {
        int info;
        double rowcnd, colcnd, amax;
        dgeequ_(&N, &N, solver->J_LU->data, &N, solver->rScale, solver->cScale, 
                &rowcnd, &colcnd, &amax, &info);
        if(info == 0) {
            dlaqge_(&N, &N, solver->J_LU->data, &N, solver->rScale, solver->cScale, 
                    &rowcnd, &colcnd, &amax, &solver->equed);
        }
        else if(info > 0) {
            solver->equed = 'N';
            if(info <= N)
                jmi_log_node(block->log, logWarning, "ZeroRow", "<Row: %d> of the Jacobian is exactly zero in <block: %s>.", info, block->label);
            else
                jmi_log_node(block->log, logWarning, "ZeroColumn", "<Column: %d> of the Jacobian is exactly zero in <block: %s>.", info-N, block->label);
        }
        else {
            solver->equed = 'N';
        }
    }
    
    /* Perform factorization to detect if there is a singular Jacobian */
    dgetrf_(  &N, &N, solver->J_LU->data, &N, solver->lapack_ipiv, &info);
    
    if(info != 0 ) {
        if (N > 1) {
            if (solver->J_is_singular_flag) { /* If the previous Jacobian update was singular, use minimum norm */
                solver->handling_of_singular_jacobian_flag = JMI_MINIMUM_NORM;
            } else {
                solver->handling_of_singular_jacobian_flag = JMI_REGULARIZATION;
            }
            
            if(block->callbacks->log_options.log_level >= 5) {
                jmi_log_node_t inner_node;
                inner_node = jmi_log_enter_fmt(block->log, logInfo, "SingularJacobian", 
                                    "Singular Jacobian detected when factorizing in linear solver "
                                    "in <block: %s>", block->label);
                jmi_log_leave(block->log, inner_node);
            }

            if (solver->handling_of_singular_jacobian_flag == JMI_REGULARIZATION) {
                jmi_log_t *log = block->log;
                jmi_log_node_t node = jmi_log_enter_fmt(log, logWarning, "Regularization", "Singular Jacobian detected when factorizing in linear solver. "
                             "Will try to regularize the equations in <block: %s>", block->label);
                if (block->callbacks->log_options.log_level >= 3) {
                    jmi_log_reals(log, node, logWarning, "ivs",  N_VGetArrayPointer(solver->kin_y), N);
                }
                jmi_log_leave(log, node);
                
                if(N > 1) {
                    jmi_kinsol_reg_matrix(block);
                    dgetrf_(  &N, &N, solver->JTJ->data, &N, solver->lapack_ipiv, &info);
                }
            } else if (solver->handling_of_singular_jacobian_flag == JMI_MINIMUM_NORM) {
                jmi_log_node(block->log, logWarning, "MinimumNorm", "Singular Jacobian detected when factorizing in linear solver. "
                             "Will try to find the minimum norm solution in <block: %s>", block->label);
                SetToZero(solver->J_sing);
                DenseCopy(solver->J, solver->J_sing);
            } else {
                /* Error */
                return -1;
            }
            
            solver->J_is_singular_flag = 1;
        }
    } else {
        /* if (solver->using_max_min_scaling_flag) {
            realtype cond = jmi_calculate_condition_number(block, solver->J->data);
            jmi_log_node(block->log, logWarning, "JacobianConditioningNumber",
                             "<JacobianConditionEstimate:%E> large values may lead to convergence problems.", cond);
        }
        */
        solver->J_is_singular_flag = 0;
    }
    
    if(solver->force_new_J_flag ) {
        /* If the Jacobian was calculated due to the singularity in the previous point
        update the residual scales if corresponding option is set
       */
        solver->force_new_J_flag = 0;
    }

    if(block->force_rescaling)
        jmi_update_f_scale(block);
    
    return 0;
        
}

/* Callback from KINSOL to solve linear system and calculate the step */
static int jmi_kin_lsolve(struct KINMemRec * kin_mem, N_Vector x, N_Vector b, realtype *res_norm) {
    jmi_block_solver_t *block = kin_mem->kin_user_data;
    jmi_kinsol_solver_t* solver = block->solver;
    realtype*  bd = N_VGetArrayPointer(b); /* residuals */
    realtype*  xd = N_VGetArrayPointer(x); /* iteration vars */
    jmi_log_node_t node;
    
    int N = block->n;
    char trans = 'N';
    int ret = 0, i;
    
    solver->updated_jacobian_flag = 0; /* The Jacobian is no longer current */
    
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
    if((block->callbacks->log_options.log_level >= 6)) {
        node = jmi_log_enter_fmt(block->log, logInfo, "KinsolLinearSolver", "Solving the linear system in <block:%s>", block->label);
    }
  
    kin_mem->kin_sJpnorm = N_VWL2Norm(b,solver->kin_f_scale);
    solver->sJpnorm = kin_mem->kin_sJpnorm;
    N_VProd(b, solver->kin_f_scale, x);
    N_VProd(x, solver->kin_f_scale, x);
    
    kin_mem->kin_sfdotJp = N_VDotProd(kin_mem->kin_fval, x);

    /* if the Jacobian was equilibrated then scale the residuals accordingly */
    if((solver->equed == 'R') || (solver->equed == 'B')) {
        for(i = 0; i < N; i++) {
            bd[i] *= solver->rScale[i];
        }
    }
    if(solver->use_steepest_descent_flag ||block->options->enforce_bounds_flag) {
        /* calculate steepest descent direction */

        /*  gradient = Transpose(J) W*W F, 
            where W is the diagonal matix of residual scaling factors. 
            W*W F is effectively calculated above in "x" as a part of kin_sfdotJp calculation.
         */

        jmi_kinsol_calc_Mv(solver->J, TRUE, x, solver->gradient);
    }
    if(solver->use_steepest_descent_flag) {
        /* Make step in steepest descent direction and not Newton*/
        N_VScale(ONE, solver->gradient, x);

        ret = 0;
    }
    else if(solver->J_is_singular_flag) {
        realtype** jac = solver->J->cols;
        if (N == 1) {
            xd[0] = block->nominal[0] * 0.1 *((bd[0] > 0)?1:-1) * ((jac[0][0] > 0)?1:-1);
            ret = 0;
        } else if (solver->handling_of_singular_jacobian_flag == JMI_REGULARIZATION) {
            /* solve the regularized problem */
            int i,j;
            realtype * fscale_data = N_VGetArrayPointer(solver->kin_f_scale);
            realtype gnorm;/*gradient norm*/

            for (i=0;i<N;i++){
                xd[i] = 0;
                for (j=0;j<N;j++) xd[i] += jac[i][j]*bd[j]*fscale_data[j]*fscale_data[j];
            }

            gnorm = N_VWL2Norm(x, kin_mem->kin_uscale);
            if((block->callbacks->log_options.log_level >= 5)) {
                jmi_log_node(block->log, logInfo, "Gradient", 
                    "Singular point with gradient (<norm:%g>) in <block: %s>.",
                        gnorm, block->label);
            }
            if(gnorm < solver->kin_stol) {
                /*near zero  gradient */
                realtype* uscale_data = N_VGetArrayPointer(solver->kin_y_scale);
                jmi_log_node(block->log, logWarning, "ZeroGradient", 
                    "Singular point with near-zero gradient (<norm:%g>) detected in <block: %s>.",
                        gnorm, block->label);
                       for (i=0;i<N;i++){
                            xd[i] = 0;
                            for (j=0;j<N;j++) xd[i] += bd[j]*fscale_data[j]*fscale_data[j]/uscale_data[j];
                        }
            }

            /* Back-solve and get solution in x */
            trans = 'N'; /* No transposition */
            i = 1;
            dgetrs_(&trans, &N, &i, solver->JTJ->data, &N, solver->lapack_ipiv, xd, &N, &ret);
            solver->force_new_J_flag = 1;
            if(block->options->rescale_after_singular_jac_flag)
                block->force_rescaling = 1;
            
        } else if (solver->handling_of_singular_jacobian_flag == JMI_MINIMUM_NORM) {
            /*
             *   DGELSS - compute the minimum norm solution to	a real 
             *   linear least squares problem
             * 
             * SUBROUTINE DGELSS( M, N, NRHS, A, LDA, B, LDB, S, RCOND, RANK,WORK, LWORK, INFO )
             *
             */
            int nrhs = 1; /* One rhs to solve for */ 
            double rcond = -1.0;
            int rank = 0;
            int iwork = 5*N;
            
            N_VScale(ONE, b, x);

            dgelss_(&N, &N, &nrhs, solver->J_sing->data, &N, xd, &N ,solver->singular_values, &rcond, &rank, solver->dgelss_rwork, &iwork, &ret);
            solver->force_new_J_flag = 1;
            if(block->options->rescale_after_singular_jac_flag)
                block->force_rescaling = 1;
            
            if(block->callbacks->log_options.log_level >= 5) {
                jmi_log_node_t inner_node;
                inner_node =jmi_log_enter_fmt(block->log, logInfo, "MinimumNorm", 
                                "Found the minimum norm solution.");
                jmi_log_reals(block->log, inner_node, logInfo, "singular_values", solver->singular_values, N);
                jmi_log_fmt(block->log, inner_node, logInfo, "<rank:%d>", rank);
                jmi_log_leave(block->log, inner_node);
            }
        }

        /* Evaluate discrete variables after a regularization. */
        if (block->at_event) {
            jmi_log_node_t inner_node;
            if(block->callbacks->log_options.log_level >= 5 && block->log_discrete_variables) {
                inner_node =jmi_log_enter_fmt(block->log, logInfo, "RegularizationDiscreteUpdate", 
                                "Evaluating switches after regularization.");
                jmi_log_fmt(block->log, inner_node, logInfo, "Pre discrete variables");
                block->log_discrete_variables(block->problem_data, inner_node);
            }

            block->F(block->problem_data, block->x, block->res, JMI_BLOCK_EVALUATE | JMI_BLOCK_EVALUATE_NON_REALS);
            
            if(block->callbacks->log_options.log_level >= 5 && block->log_discrete_variables) {
                jmi_log_fmt(block->log, inner_node, logInfo, "Post discrete variables");
                block->log_discrete_variables(block->problem_data, inner_node);
                jmi_log_leave(block->log, inner_node);
            }
        }
    }
    else {
        /* Normal linear system solve (with LU) to get Newton step */
        N_VScale(ONE, b, x);
        i = 1;
        
        if((block->callbacks->log_options.log_level >= 6)) {
            jmi_log_real_matrix(block->log, node, logInfo, "jacobian", solver->J->data, N, N);
            jmi_log_reals(block->log, node, logInfo, "rhs", xd, N);
        }
        
        dgetrs_(&trans, &N, &i, solver->J_LU->data, &N, solver->lapack_ipiv, xd, &N, &ret);
        
        if((block->callbacks->log_options.log_level >= 6)) {
            jmi_log_reals(block->log, node, logInfo, "solution", xd, N);
        }
    }

    if((block->callbacks->log_options.log_level >= 6)) {
        jmi_log_leave(block->log, node);
    }

    if(ret) return ret; /* Break out on error */
    
    if((solver->equed == 'C') || (solver->equed == 'B')) {
        /* scale solution if the Jacobian was equilibrated */
        int i;
        realtype*  gd = N_VGetArrayPointer(solver->gradient);
        for(i = 0; i < block->n; i++) {
            xd[i] *= solver->cScale[i];
            if(solver->use_steepest_descent_flag ||block->options->enforce_bounds_flag) {
                gd[i] *= solver->cScale[i];
            }
        }
    }

    {
        jmi_log_node_t topnode;
        if(block->callbacks->log_options.log_level >= 5) {
            topnode = jmi_log_enter_(block->log,logInfo,"StepDirection");
            jmi_log_reals(block->log, topnode, logInfo, "unbounded_step", xd, block->n);
        }
        jmi_kinsol_limit_step(kin_mem, x, b);

        if(solver->last_num_active_bounds > 0 && (block->options->experimental_mode & jmi_block_solver_experimental_check_descent_direction)) {
            realtype sJpnorm, sfJp, fnorm, g_scale;
            
            /*scalar product of gradient and projected step */
            double xg = jmi_kinsol_calc_v1twwv2(x, solver->gradient, solver->kin_y_scale); 

            if(xg <= 0.0) {
                if(block->callbacks->log_options.log_level >= 5) {
                    double step_factor = solver->last_num_active_bounds > 0? 1.0:solver->max_step_ratio;
                    N_VScale(step_factor, x, b);
                    jmi_log_reals(block->log, topnode, logInfo, "projected_newton_step", bd, block->n);
                    jmi_log_leave(block->log, topnode);
                }
                jmi_log_node(block->log, logWarning, "StepNotDescent", 
                    "Projected Newton step is not descent in <block: %s>, scaled scalar product with gradient <spxg: %g>, trying steepest descent", block->label, xg);
            }
            /*
                sfdotJp = Transpose(F) * Wf*Wf*J*gradient = Transpose(F) * Wf*Wf*J* Transpose(J)* Wf*Wf*F = Transpose(gradient)*gradient
            */
            sfJp = jmi_kinsol_calc_v1twwv2(solver->gradient, solver->gradient, 0);
            KINGetFuncNorm(solver->kin_mem, &fnorm);
            g_scale = fnorm*fnorm/sfJp;
            N_VScale(g_scale, solver->gradient, x);
            sfJp *= g_scale;
            jmi_kinsol_calc_Mv(solver->J, FALSE, solver->gradient, b);
            sJpnorm = N_VWL2Norm(b,solver->kin_f_scale);
            kin_mem->kin_sJpnorm = sJpnorm;
            kin_mem->kin_sfdotJp = sfJp;
            jmi_kinsol_limit_step(kin_mem, x, b);
            xg = jmi_kinsol_calc_v1twwv2(x, solver->gradient, solver->kin_y_scale); 

            if(xg == 0.0) {
                jmi_log_node(block->log, logWarning, "StepIsZero",
                    "Projected steepest descent step is zero in <block: %s>", block->label);
            }
        }
        if(block->callbacks->log_options.log_level >= 5) {
            double step_factor = solver->last_num_active_bounds > 0? 1.0:solver->max_step_ratio;
            N_VScale(step_factor, x, b);
            jmi_log_reals(block->log, topnode, logInfo, "projected_step", bd, block->n);
            jmi_log_leave(block->log, topnode);
        }
    }
    return 0;
}

double* jmi_kinsol_solver_get_f_scales(jmi_kinsol_solver_t* solver) {
    return N_VGetArrayPointer(solver->kin_f_scale);
}

static void jmi_setup_f_residual_scaling(jmi_block_solver_t *block) {
    jmi_block_solver_options_t* bsop = block->options;
    jmi_kinsol_solver_t* solver = block->solver;
    int i, N = block->n;
    realtype* dummy = 0;
    
    /* Read manual scaling from annotations and propagated nominal values for
     * residuals and put them in residual_nominal & scale_ptr*/
    if (bsop->residual_equation_scaling_mode == jmi_residual_scaling_manual ||
        bsop->residual_equation_scaling_mode == jmi_residual_scaling_hybrid)
    {
        block->F(block->problem_data,dummy, solver->residual_nominal, JMI_BLOCK_EQUATION_NOMINAL);
        for (i = 0; i < N; i++) {
            if(solver->residual_nominal[i] != 0.0) {
                if(solver->residual_nominal[i] < 1/bsop->max_residual_scaling_factor) {
                    solver->residual_nominal[i] = 1/bsop->max_residual_scaling_factor;
                    jmi_log_node(block->log, logWarning, "MaxScalingUsed", "Using maximum scaling factor in <block: %s>, "
                        "<equation: %I> since specified residual nominal is too small.", block->label, i);
                }
                else if(solver->residual_nominal[i] > 1/bsop->min_residual_scaling_factor) {
                    solver->residual_nominal[i] = 1/bsop->min_residual_scaling_factor;
                    jmi_log_node(block->log, logWarning, "MinScalingUsed", "Using minimal scaling factor in <block: %s>, "
                        "<equation: %I> since specified residual nominal is too big.", block->label, i);
                }
            }
            else if(bsop->residual_equation_scaling_mode == jmi_residual_scaling_manual) {
                solver->residual_nominal[i] = 1.0;
            }
        }
    }
    
    block->F(block->problem_data,dummy, solver->residual_heuristic_nominal, JMI_BLOCK_EQUATION_NOMINAL_AUTO);
    block->F(block->problem_data,dummy, solver->residual_heuristic_nominal, JMI_BLOCK_EQUATION_NOMINAL);
    for (i = 0; i < N; i++) {
        if (solver->residual_heuristic_nominal[i] == 0.0) {
            /* TODO: This information could be used to see that the system is structually singular */
            solver->residual_heuristic_nominal[i] = 1.0;
        }
    }
}

/* 
    Compute appropriate equation scaling and function tolerance based on Jacobian J,
    nominal values (block->nominal) and current point (block->x).
    Store result in solver->kin_f_scale.
*/
static void jmi_update_f_scale(jmi_block_solver_t *block) {
    jmi_kinsol_solver_t* solver = block->solver; 
    int i, N = block->n;
    realtype tol = solver->kin_stol;
    realtype curtime = block->cur_time;
    realtype* scale_ptr = 0;
    jmi_block_solver_options_t* bsop = block->options;
    int use_scaling_flag = bsop->residual_equation_scaling_mode;


    solver->kin_scale_update_time = curtime;
    block->force_rescaling = 0;
    kin_char_log(solver, 's');
    
    if(bsop->residual_equation_scaling_mode != jmi_residual_scaling_none) {
        /* Zero out the scales initially if we're modify this. */
        N_VConst_Serial(0,solver->kin_f_scale);
    }

    scale_ptr = N_VGetArrayPointer(solver->kin_f_scale);

    /* Form scaled Jacobian as needed for automatic scaling and condition number checking*/
    if (bsop->residual_equation_scaling_mode == jmi_residual_scaling_auto ||
        bsop->residual_equation_scaling_mode == jmi_residual_scaling_hybrid)
    {
        for (i = 0; i < N; i++) {
            int j;
            /* column scaling is formed by max(abs(nominal), abs(actual_value)) */
            realtype xscale = RAbs(block->nominal[i]);
            realtype x = RAbs(block->x[i]);
            realtype* col_ptr;
            realtype* scaled_col_ptr;
            if(x < xscale) x = xscale;
            if(x < tol) x = tol;
            col_ptr = DENSE_COL(solver->J, i);
            scaled_col_ptr = DENSE_COL(solver->J_scale, i);

            /* row scaling is product of Jac entry and column scaling */
            for (j = 0; j < N; j++) {
                realtype dres = col_ptr[j];
                realtype fscale;
                fscale = dres * x;
                scaled_col_ptr[j] = fscale;
                scale_ptr[j] = MAX(scale_ptr[j], RAbs(fscale));
            }
        }
    }

    /* put in manual non-zero scales in hybrid & manual cases */
    if(    (bsop->residual_equation_scaling_mode == jmi_residual_scaling_manual) 
        || (bsop->residual_equation_scaling_mode == jmi_residual_scaling_hybrid))    {
            for(i = 0; i < N; i++) {
                if(solver->residual_nominal[i] != 0) {
                    scale_ptr[i] = solver->residual_nominal[i];
                }
            }
    }

    if(use_scaling_flag) {
        solver->using_max_min_scaling_flag = 0; /* NOT using max/min scaling */
        /* check that scaling factors have reasonable magnitude */
        for(i = 0; i < N; i++) {
            if(scale_ptr[i] < 1/bsop->max_residual_scaling_factor) {
                int j, maxInJacIndex = 0;
                realtype **jac = solver->J_scale->cols;
                realtype maxInJac = RAbs(jac[0][i]); 
                solver->using_max_min_scaling_flag = 1; /* Using maximum scaling, singular Jacobian? */
                for(j = 0; j < N; j++) {
                    if(RAbs(maxInJac) < RAbs(jac[j][i])) {
                        maxInJac = jac[j][i];
                        maxInJacIndex = j;
                    }
                }
                
                scale_ptr[i] = bsop->max_residual_scaling_factor;
                jmi_log_node(block->log, logWarning, "MaxScalingUsed", "Poor scaling in <block: %s>. "
                    "Consider changes in the model. Partial derivative of <equation: %I> with respect to <Iter: #r%d#> is <dRes_dIter: %g> (<dRes_dIter_scaled: %g>).",
                    block->label, i, block->value_references[maxInJacIndex], DENSE_ELEM(solver->J, i, maxInJacIndex) ,maxInJac);
            }
            else if(scale_ptr[i] > 1/bsop->min_residual_scaling_factor) {
                int j, maxInJacIndex = 0;
                realtype **jac = solver->J_scale->cols;
                realtype maxInJac = RAbs(jac[0][i]);
                /* Likely not a problem: solver->using_max_min_scaling_flag = 1; -- Using minimum scaling */
                for(j = 0; j < N; j++) {
                    if(RAbs(maxInJac) < RAbs(jac[j][i])) {
                        maxInJac = jac[j][i];
                        maxInJacIndex = j;
                    }
                }
                
                if (scale_ptr[i] > solver->residual_heuristic_nominal[i]/bsop->min_residual_scaling_factor) {
                    scale_ptr[i] = bsop->min_residual_scaling_factor/solver->residual_heuristic_nominal[i];
                    jmi_log_node(block->log, logWarning, "MinScalingUsed", "Poor scaling in <block: %s>. "
                        "Consider changes in the model. Partial derivative of <equation: %I> with respect to <Iter: #r%d#> is <dRes_dIter: %g> (<dRes_dIter_scaled: %g>).",
                        block->label, i, block->value_references[maxInJacIndex], DENSE_ELEM(solver->J, i, maxInJacIndex) ,maxInJac);
                } else {
                    scale_ptr[i] = 1/scale_ptr[i];
                    jmi_log_node(block->log, logWarning, "MinScalingExceeded", "Poor scaling in <block: %s> but will allow it based on structure of block. "
                        "Consider changes in the model. Partial derivative of <equation: %I> with respect to <Iter: #r%d#> is <dRes_dIter: %g> (<dRes_dIter_scaled: %g>).",
                        block->label, i, block->value_references[maxInJacIndex], DENSE_ELEM(solver->J, i, maxInJacIndex) ,maxInJac);
                }
            }
            else
                scale_ptr[i] = 1/scale_ptr[i];
        }

        if (block->callbacks->log_options.log_level >= 4) {
            jmi_log_node_t outer = jmi_log_enter_fmt(block->log, logInfo, "ResidualScalingUpdated", "<block:%s>", block->label);
            if (block->callbacks->log_options.log_level >= 5) {
                jmi_log_node_t inner = jmi_log_enter_vector_(block->log, outer, logInfo, "scaling");
                realtype* res = scale_ptr;
                for (i=0;i<N;i++) jmi_log_real_(block->log, 1/res[i]);
                jmi_log_leave(block->log, inner);
            }
            jmi_log_leave(block->log, outer);
        }
    }

    if (solver->using_max_min_scaling_flag && !solver->J_is_singular_flag) {
        realtype cond = jmi_calculate_jacobian_condition_number(block);

        jmi_log_node(block->log, logInfo, "Regularization",
            "Calculated condition number in <block: %s>. Regularizing if <cond: %E> is greater than <regtol: %E>", block->label, cond, solver->kin_reg_tol);
        if (cond > solver->kin_reg_tol) {
            if(N > 1 && solver->handling_of_singular_jacobian_flag == JMI_REGULARIZATION) {
                int info;
                jmi_kinsol_reg_matrix(block);
                dgetrf_(  &block->n, &block->n, solver->JTJ->data, &block->n, solver->lapack_ipiv, &info);
            }
            solver->J_is_singular_flag = 1;
        }
    }


    /* estimate condition number of the scaled jacobian 
    and scale function tolerance with it. */
    if((N > 1) && bsop->check_jac_cond_flag){
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
            jmi_log_node(block->log, logWarning, "SingularJacobian",
                "Singular Jacobian detected when checking condition number in <block:%s>. Solver may fail to converge.", block->label);
        }
        else {
            dgecon_(&norm, &N, solver->J_scale->data, &N, &Jnorm, &Jcond, solver->lapack_work, solver->lapack_iwork,&info);       

            if(tol * Jcond < UNIT_ROUNDOFF) {
                jmi_log_node_t node = jmi_log_enter_fmt(block->log, logWarning, "IllConditionedJacobian",
                    "<JacobianInverseConditionEstimate:%E> Solver may fail to converge in <block: %s>.", Jcond, block->label);
                if (block->callbacks->log_options.log_level >= 4) {
                    jmi_log_reals(block->log, node, logWarning, "ivs", N_VGetArrayPointer(solver->kin_y), block->n);
                }
                jmi_log_leave(block->log, node);

            }
            else {
                jmi_log_node(block->log, logInfo, "JacobianCondition",
                    "<JacobianInverseConditionEstimate:%E>", Jcond);
            }
        }
    }
    return;
}

int jmi_kinsol_solver_new(jmi_kinsol_solver_t** solver_ptr, jmi_block_solver_t* block) {
    jmi_kinsol_solver_t* solver;
    int flag, n = block->n;
    
    
    struct KINMemRec * kin_mem = KINCreate();
    if(!kin_mem) return -1;
    solver = (jmi_kinsol_solver_t*)calloc(1,sizeof(jmi_kinsol_solver_t));
    if(!solver ) return -1;
    solver->kin_mem = kin_mem;
#ifdef JMI_PROFILE_RUNTIME 
    block->time_f = 0;
    block->time_df = 0;
#endif
    
    /*Initialize work vectors.*/

    /*Sets the scaling vectors to ones.*/
    /*To be changed. */
    solver->kin_y = N_VMake_Serial(n, block->x);
    solver->kin_y_scale = N_VNew_Serial(n);
    solver->kin_f_scale = N_VNew_Serial(n);
    solver->gradient  = N_VNew_Serial(n);
    solver->residual_nominal = (realtype*)calloc(n+1,sizeof(realtype));
    solver->residual_heuristic_nominal = (realtype*)calloc(n+1,sizeof(realtype));
    solver->kin_scale_update_time = -1.0;
    solver->kin_jac_update_time = -1.0;
    /*NOTE: it'd be nice to use "jmi->newton_tolerance" here
      However, newton_tolerance is not set yet at this point.
    */
    solver->kin_ftol = UROUND; /* block->options->min_tol; */
    solver->kin_stol = block->options->min_tol;
    solver->using_max_min_scaling_flag = 0; /* Not using max/min scaling */
    
    solver->J = NewDenseMat(n ,n);
    solver->JTJ = NewDenseMat(n ,n);
    solver->J_LU = NewDenseMat(n ,n);
    solver->J_scale = NewDenseMat(n ,n);
    solver->J_sing = NewDenseMat(n, n);
    solver->J_SVD_U = NewDenseMat(n, n);
    solver->J_SVD_VT = NewDenseMat(n, n);
    solver->J_is_singular_flag = 0;

    solver->equed = 'N';
    solver->rScale = (realtype*)calloc(n+1,sizeof(realtype));
    solver->cScale = (realtype*)calloc(n+1,sizeof(realtype));
    solver->range_limits = (realtype*)calloc(n+1,sizeof(realtype));
    solver->range_limited = (int*)calloc(n+1,sizeof(int));
    solver->range_most_limiting = 0;

    solver->lapack_work = (realtype*)calloc(4*(n+1),sizeof(realtype));
    solver->lapack_iwork = (int *)calloc(n+2, sizeof(int));
    solver->lapack_ipiv = (int *)calloc(n+2, sizeof(int));

    solver->dgesdd_lwork = 7*n*n+4*n;
    solver->dgesdd_work  = (realtype*)calloc(solver->dgesdd_lwork,sizeof(realtype));
    solver->dgesdd_iwork = (int*)calloc(8*n,sizeof(int));
    
    solver->dgelss_rwork = (realtype*)calloc(5*n,sizeof(realtype));
    solver->singular_values = (realtype*)calloc(n,sizeof(realtype));
    solver->max_step_ratio = 1.0;

    kin_reset_char_log(solver);

    /* Initialize scaling to 1.0 - defaults */
    N_VConst_Serial(1.0,solver->kin_y_scale);

    /* Initial equation scaling is 1.0 */
    N_VConst_Serial(1.0,solver->kin_f_scale);
                
    flag = KINInit(solver->kin_mem, kin_f, solver->kin_y); /*Initialize Kinsol*/
    jmi_kinsol_error_handling(block, flag);
    
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
    jmi_kinsol_error_handling(block, flag);  
    
    /*Stopping tolerance of F -> just a default */
    KINSetFuncNormTol(solver->kin_mem, solver->kin_ftol); 
    
    /*Stepsize tolerance*/
    KINSetScaledStepTol(solver->kin_mem, solver->kin_stol);
    
    /* Max number of iters */
    KINSetNumMaxIters(solver->kin_mem, block->options->max_iter);
    
    /*Verbosity*/
    KINSetPrintLevel(solver->kin_mem, get_print_level(block));
    
    /*Error function*/
    KINSetErrHandlerFn(solver->kin_mem, kin_err, block);
    /*Info function*/
    KINSetInfoHandlerFn(solver->kin_mem, kin_info, block);
    /*  Jacobian can be reused */
    KINSetNoInitSetup(solver->kin_mem, 1);    
    
    /* Struct for storing the Kinsol state */
    solver->saved_state = (jmi_kinsol_solver_reset_t*)calloc(1,sizeof(jmi_kinsol_solver_reset_t));
    solver->saved_state->J = NewDenseMat(n,n);
    solver->saved_state->kin_f_scale = N_VNew_Serial(n);
    solver->saved_state->kin_y_scale = N_VNew_Serial(n);
    solver->saved_state->lapack_ipiv = (int *)calloc(n+2, sizeof(int));
    solver->saved_state->J_is_singular_flag = 0;
    solver->saved_state->handling_of_singular_jacobian_flag = JMI_REGULARIZATION;
    solver->saved_state->mbset = 0;
      
    *solver_ptr = solver;

    return flag;
}

void jmi_kinsol_solver_delete(jmi_block_solver_t* block) {
    jmi_kinsol_solver_t* solver = block->solver;
#ifdef JMI_PROFILE_RUNTIME 
    if (block->n > 1) {
        char message[256];
        sprintf(message, "Time in df: %g, BlockLabel: %s, is_init_block: %d", block->time_df, block->label, block->is_init_block);
        jmi_log_node(block->log, logError, "ACC_TIME_IN_KIN_DF", message);

        sprintf(message, "Time in f: %g, BlockLabel: %s, is_init_block: %d", block->time_f, block->label, block->is_init_block);
        jmi_log_node(block->log, logError, "ACC_TIME_IN_KIN_F", message);

        if (block->options->use_Brent_in_1d_flag) {
            sprintf(message, "Time in brent: %g, BlockLabel: %s", block->time_in_brent, block->label);
            jmi_log_node(block->log, logError, "ACC_TIME_IN_BRENT", message); /**/
        }
    }
#endif

    /*Deallocate Kinsol work vectors.*/
    N_VDestroy_Serial(solver->kin_y);
    N_VDestroy_Serial(solver->kin_y_scale);
    N_VDestroy_Serial(solver->kin_f_scale);
    N_VDestroy_Serial(solver->gradient);
    free(solver->residual_nominal);
    free(solver->residual_heuristic_nominal);
    DestroyMat(solver->J);
    DestroyMat(solver->JTJ);
    DestroyMat(solver->J_LU);
    DestroyMat(solver->J_scale);
    DestroyMat(solver->J_sing);
    DestroyMat(solver->J_SVD_U);
    DestroyMat(solver->J_SVD_VT);
    free(solver->cScale);
    free(solver->rScale);
    free(solver->range_limits);
    free(solver->range_limited);
    free(solver->lapack_work);
    free(solver->lapack_iwork);
    free(solver->lapack_ipiv);
    free(solver->dgelss_rwork);
    free(solver->singular_values);

    free(solver->dgesdd_work);
    free(solver->dgesdd_iwork);
    
    if(solver->num_bounds > 0) {
        free(solver->bound_vindex);
        free(solver->bound_kind);
        free(solver->bound_limiting);
        free(solver->bounds);
        free(solver->active_bounds);
    }
    
    /* Struct for storing the Kinsol state */
    DestroyMat(solver->saved_state->J);
    N_VDestroy_Serial(solver->saved_state->kin_f_scale);
    N_VDestroy_Serial(solver->saved_state->kin_y_scale);
    free(solver->saved_state->lapack_ipiv);
    free(solver->saved_state);

    /*Deallocate Kinsol */
    if(solver->kin_mem)
        KINFree(&(solver->kin_mem));
    /*Deallocate struct */
    free(solver);
    block->solver = 0;
}

void jmi_kinsol_solver_print_solve_start(jmi_block_solver_t * block,
                                         jmi_log_node_t *destnode) {
    if ((block->callbacks->log_options.log_level >= 4)) {
        jmi_log_t *log = block->log;
        *destnode = jmi_log_enter_fmt(log, logInfo, "NewtonSolve", 
                                      "Newton solver invoked for <block:%s>", block->label);
        if ((block->callbacks->log_options.log_level >= 5)) {
            jmi_kinsol_solver_t* solver = (jmi_kinsol_solver_t*)block->solver;
            jmi_log_vrefs(log, *destnode, logInfo, "variables", 'r', block->value_references, block->n);
            jmi_log_reals(log, *destnode, logInfo, "max", block->max, block->n);
            jmi_log_reals(log, *destnode, logInfo, "min", block->min, block->n);
            jmi_log_reals(log, *destnode, logInfo, "nominal", block->nominal, block->n);
            jmi_log_reals(log, *destnode, logInfo, "initial_guess", block->x, block->n);
            jmi_log_reals(log, *destnode, logInfo, "ranges", solver->range_limits, block->n);
        }
    }
}

const char *jmi_kinsol_flag_to_name(int flag) {
    /*
        char* name = KINGetReturnFlagName(flag);
        KINGetReturnFlagName(flag) allocates memory and may cause memleak
     */

    switch (flag) {
    case KIN_SUCCESS: return "KIN_SUCCESS";
    case KIN_INITIAL_GUESS_OK: return "KIN_INITIAL_GUESS_OK";
    case KIN_STEP_LT_STPTOL: return "KIN_STEP_LT_STPTOL";
    case KIN_WARNING: return "KIN_WARNING";
    case KIN_MEM_NULL: return "KIN_MEM_NULL";
    case KIN_ILL_INPUT: return "KIN_ILL_INPUT";
    case KIN_NO_MALLOC: return "KIN_NO_MALLOC";
    case KIN_MEM_FAIL: return "KIN_MEM_FAIL";
    case KIN_LINESEARCH_NONCONV: return "KIN_LINESEARCH_NONCONV";
    case KIN_MAXITER_REACHED: return "KIN_MAXITER_REACHED";
    case KIN_MXNEWT_5X_EXCEEDED: return "KIN_MXNEWT_5X_EXCEEDED";
    case KIN_LINESEARCH_BCFAIL: return "KIN_LINESEARCH_BCFAIL";
    case KIN_LINSOLV_NO_RECOVERY: return "KIN_LINSOLV_NO_RECOVERY";
    case KIN_LINIT_FAIL: return "KIN_LINIT_FAIL";
    case KIN_LSETUP_FAIL: return "KIN_LSETUP_FAIL";
    case KIN_LSOLVE_FAIL: return "KIN_LSOLVE_FAIL";
    case KIN_SYSFUNC_FAIL: return "KIN_SYSFUNC_FAIL";
    case KIN_FIRST_SYSFUNC_ERR: return "KIN_FIRST_SYSFUNC_ERR";
    default: return "UNKNOWN";
    }
}

void jmi_kinsol_solver_print_solve_end(jmi_block_solver_t * block, const jmi_log_node_t *node, int flag) {
    long int nniters;
    jmi_kinsol_solver_t* solver = block->solver;
    
    KINGetNumNonlinSolvIters(solver->kin_mem, &nniters);

    /* NB: must match the condition in jmi_kinsol_solver_print_solve_start exactly! */
    if((block->callbacks->log_options.log_level >= 4)) {
        jmi_log_t *log = block->log;
        const char *flagname = jmi_kinsol_flag_to_name(flag);
        if (flagname != NULL) jmi_log_fmt(log, *node, logInfo, "Newton solver finished with <kinsol_exit_flag:%s>", flagname);
        else jmi_log_fmt(log, *node, logInfo, "Newton solver finished with unrecognized <kinsol_exit_flag:%d>", flag);
        jmi_log_leave(log, *node);
    }
}

static int jmi_kinsol_invoke_kinsol(jmi_block_solver_t *block, int strategy) {
    jmi_kinsol_solver_t* solver = block->solver;
    int flag;
    jmi_log_node_t topnode;
    
    jmi_kinsol_solver_print_solve_start(block, &topnode);
    flag = KINSol(solver->kin_mem, solver->kin_y, strategy, solver->kin_y_scale, solver->kin_f_scale);
    jmi_kinsol_print_progress(block, 1);
    if(flag == KIN_INITIAL_GUESS_OK) {
        flag = KIN_SUCCESS;
        /* If the evaluation of the residuals fails, e.g. due to NaN in the residuals, the Kinsol exits, but the old fnorm
             from a previous solve, possibly converged, is still stored. In such cases Kinsol reports success based on a fnorm
             value from a previous solve - if the previous solve was converged, then also a following faulty solve will be reproted
             as a success. Commenting out this code since it causes problems.*/
    } else if (flag == KIN_LINESEARCH_NONCONV || flag == KIN_STEP_LT_STPTOL) {
        realtype fnorm;
        KINGetFuncNorm(solver->kin_mem, &fnorm);
        if(fnorm <= solver->kin_stol) {
            flag = KIN_SUCCESS;
        } else if (flag == KIN_LINESEARCH_NONCONV) { /* Print the postponed error message */
            jmi_kinsol_linesearch_nonconv_error_message(block);
        } 
        else {
            jmi_kinsol_small_step_nonconv_error_message(block);
        }

        if(block->options->check_jac_cond_flag) {
            int i, info, N = block->n;
            realtype* scale_ptr = N_VGetArrayPointer(solver->kin_f_scale);
            realtype tol = solver->kin_stol;
            for(i = 0; i < N; i++){
                int j;
                realtype* scaled_col_ptr = DENSE_COL(solver->J_scale, i);
                realtype* col_ptr = DENSE_COL(solver->J, i);
                realtype xscale = RAbs(block->nominal[i]);
                realtype x = RAbs(block->x[i]);
                if(x < xscale) x = xscale;
                if(x < tol) x = tol;
                for(j = 0; j < N; j++){
                    scaled_col_ptr[j] = col_ptr[j] * x *scale_ptr[j];
                }
            }

            dgetrf_(  &N, &N, solver->J_scale->data, &N, solver->lapack_iwork, &info);
            if(info > 0) {
                jmi_log_node(block->log, logWarning, "SingularJacobian",
                    "Singular Jacobian detected when checking condition number in <block:%s>. Solver may fail to converge.", block->label);
            }
            else {
                char norm = 'I';
                double Jnorm = 1.0, Jcond = 1.0;
                dgecon_(&norm, &N, solver->J_scale->data, &N, &Jnorm, &Jcond, solver->lapack_work, solver->lapack_iwork,&info);       

                if(tol * Jcond < UNIT_ROUNDOFF) {
                    jmi_log_node_t node = jmi_log_enter_fmt(block->log, logWarning, "IllConditionedJacobian",
                        "<JacobianInverseConditionEstimate:%E> Solver may fail to converge in <block: %s>.", Jcond, block->label);
                    if (block->callbacks->log_options.log_level >= 4) {
                        jmi_log_reals(block->log, node, logWarning, "ivs", N_VGetArrayPointer(solver->kin_y), block->n);
                    }
                    jmi_log_leave(block->log, node);

                }
                else {
                    jmi_log_node(block->log, logInfo, "JacobianCondition",
                        "<JacobianInverseConditionEstimate:%E>", Jcond);
                }
            }
        }
    }
    jmi_kinsol_solver_print_solve_end(block, &topnode, flag);
    return flag;
}


int jmi_kinsol_solver_solve(jmi_block_solver_t * block){
    int flag;
#ifdef JMI_PROFILE_RUNTIME 
    clock_t t = clock();
#endif
    jmi_kinsol_solver_t* solver = block->solver;
    realtype curtime = block->cur_time;
    long int nniters = 0;
    int flagNonscaled;
    jmi_log_t *log = block->log;

    if(block->n == 1) {
       if (block->options->use_Brent_in_1d_flag) {
           return jmi_brent_solver_solve(block);
       }
       solver->f_pos_min_1d = BIG_REAL;
       solver->f_neg_max_1d = -BIG_REAL;
    }
    
    if(block->init) {
        jmi_setup_f_residual_scaling(block);
        flag = jmi_kinsol_init(block);
        if(flag) return flag;
    }
    else {
        if (!(block->at_event) && block->options->experimental_mode & jmi_block_solver_experimental_use_last_integrator_step) {
            flag = jmi_kinsol_restore_state(block);
            
            if (flag) return flag;
        }
        
        /* Read initial values for iteration variables from variable vector.
        * This is needed if the user has changed initial guesses in between calls to
        * Kinsol.
        */
        flag = block->F(block->problem_data,block->x,block->res,JMI_BLOCK_INITIALIZE);
        if(flag) {        
            jmi_log_node(log, logWarning, "ErrorReadingInitialGuess", "<errorCode: %d> returned from <block: %s> "
                         "when reading initial guess.", flag, block->label);
            return flag;
        }
        if(solver->force_new_J_flag ) { /* New Jacobian forced due to solver failure in previous solve call */
            struct KINMemRec * kin_mem = solver->kin_mem; 
            if(jmi_kin_lsetup(kin_mem)) {
                jmi_log_node(block->log, logError, "Error", "Jacobian evaluation failed at initial point for "
                     "<block: %s>", block->label);
                return -1;
            }
        }
    }

    /* update the scaling only once per time step */
    if(block->init || (block->options->rescale_each_step_flag && (curtime > solver->kin_scale_update_time)) || block->force_rescaling) {
        jmi_update_f_scale(block);
    }
    
    if(block->options->experimental_mode & jmi_block_solver_experimental_steepest_descent_first) {
        KINSetNoResMon(solver->kin_mem,0);        
        solver->use_steepest_descent_flag = 1;
    }

    flag = jmi_kinsol_invoke_kinsol(block, KIN_LINESEARCH);
    
    if(block->options->experimental_mode & jmi_block_solver_experimental_steepest_descent_first) {
        KINSetNoResMon(solver->kin_mem,1);
        solver->use_steepest_descent_flag = 0;
    }
    
    /* Brent is called for 1D to get higher accuracy. It is called independently on the KINSOL success */ 
    if((block->n == 1) && block->options->use_Brent_in_1d_flag) {
        jmi_log_node(log, logInfo, "Brent", "Trying Brent's method in <block: %s>", block->label);
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
            jmi_log_node(log, logError, "Error", "Could neither iterate to required accuracy "
                         "nor bracket the root of 1D equation in <block: %s>", block->label);
        }
    } 
    
    if((block->options->experimental_mode & jmi_block_solver_experimental_steepest_descent) &&
        (flag != KIN_SUCCESS)) {
        /* try to solve with steepest descent instead */

        jmi_log_node(log, logInfo, "Progress", "<source:%s><block:%s><message:%s>",
                     "jmi_kinsol_solver", block->label, "Attempting steepest descent iterations");        

        solver->use_steepest_descent_flag = 1;
        
        flag = KINSol(solver->kin_mem, solver->kin_y, KIN_LINESEARCH, solver->kin_y_scale, solver->kin_f_scale);
        if(flag == KIN_INITIAL_GUESS_OK) {
            flag = KIN_SUCCESS;
        }
        
        solver->use_steepest_descent_flag = 0;
    }
    
    /* First time scaling is always recomputed - initial guess may be "far away" and give bad scaling 
       TODO: we should probably rescale after event as well.
       TODO: Not sure if rescaling needs to happen in manual mode. Alternative is to have condition:
       ((block->options->residual_equation_scaling_mode == jmi_residual_scaling_auto ) ||
        (block->options->residual_equation_scaling_mode == jmi_residual_scaling_hybrid )
    */
    if( (block->options->residual_equation_scaling_mode != jmi_residual_scaling_none )
        && (block->init || (flag != KIN_SUCCESS))) {
        jmi_log_node(log, logInfo, "Rescaling", "Attempting rescaling in <block:%s>", block->label);

        flagNonscaled = flag;
        /* Get & store debug information */
        KINGetNumNonlinSolvIters(solver->kin_mem, &block->nb_iters);
        if(flagNonscaled != 0) {
            jmi_log_node(log, logWarning, "NonConverge", "The equations with initial scaling didn't converge to a "
                         "solution in <block: %s>", block->label);
        }
        /* Update the scaling  */
        jmi_update_f_scale(block);
        
        /* For the second solve set tight tolerance on the step and specified tolerance on the residual */
        KINSetScaledStepTol(solver->kin_mem, solver->kin_ftol);
        KINSetFuncNormTol(solver->kin_mem, solver->kin_stol);
        flag = jmi_kinsol_invoke_kinsol(block, KIN_LINESEARCH);
        KINSetScaledStepTol(solver->kin_mem, solver->kin_stol);
        KINSetFuncNormTol(solver->kin_mem, solver->kin_ftol);
        
        if(flag != KIN_SUCCESS) {
            /* If Kinsol failed, force a new Jacobian and new rescaling in the next try. */
            solver->force_new_J_flag = 1;
            block->force_rescaling = 1;            

            if (flagNonscaled == 0) {
                jmi_log_node(log, logError, "Error", "The equations with initial scaling solved fine, "
                             "re-scaled equations failed in <block: %s>", block->label); 
            } else {
                if (block->init && block->options->use_nominals_as_fallback_in_init) { /* Try perturbing the initial guess if bounded. */
                    int i = 0;
                    int changed_start = 0;
                    for (i = 0; i < block->n; i++) {
                        if (block->start_set[i] == 0) { /* If start is not set */
                            changed_start = 1;
                            N_VGetArrayPointer(solver->kin_y)[i] = block->nominal[i] <= block->max[i] ? block->nominal[i] : -block->nominal[i];
                        }
                    }
                    if (changed_start) {
                        jmi_log_node(log, logInfo, "NominalsAsInitialGuess", "Failed to compute a solution using the default initial guess. Attempting using the nominal values in <block:%s>", block->label);
                    
                        flag = jmi_kinsol_invoke_kinsol(block, KIN_LINESEARCH);
                    }
                }
                if (flag != KIN_SUCCESS) {
                    jmi_log_node(log, logError, "Error", "Could not converge after re-scaling equations in <block: %s>",
                                 block->label);
                }
            }
#ifdef JMI_KINSOL_PRINT_ON_FAIL
            {
                realtype* x = block->x;
                int i;
                struct KINMemRec * kin_mem = solver->kin_mem;
                
                printf("Could not converge in block %s,KINSOL error:%s,fnorm=%g,stol=%g,ftol=%g:\n"
                       "x = N.array([\n",block->label, jmi_kinsol_flag_to_name(flag), fnorm, solver->kin_stol,solver->kin_ftol);
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
    block->F(block->problem_data,block->x, NULL, JMI_BLOCK_WRITE_BACK);
    
    /* Get debug information */
    KINGetNumNonlinSolvIters(solver->kin_mem, &nniters);    
     
    /* Store debug information */
    block->nb_iters += nniters;
#ifdef JMI_PROFILE_RUNTIME
    {
        char message[256];
        sprintf(message, "Time in kinsol.solve: %g, label: %s, is_init_block: %d, block size: %d", ((double) clock() - t)/CLOCKS_PER_SEC, block->label, block->is_init_block, block->n);
        jmi_log_node(block->log, logError, "ACC_TIME_IN_KINSOL_SOLVE", message);
    }
#endif
        
    return flag;
}

int jmi_kinsol_restore_state(jmi_block_solver_t* block) {
    int flag = 0;
    jmi_kinsol_solver_t* solver = block->solver;
    jmi_log_t *log = block->log;
    
    flag = block->F(block->problem_data,block->last_accepted_x, NULL, JMI_BLOCK_WRITE_BACK);
    if(flag) {        
        jmi_log_node(log, logError, "ErrorSettingInitialGuess", "<errorCode: %d> returned from <block: %s> "
                     "when setting the initial guess.", flag, block->label);
        return flag;
    }
    
    if (solver->saved_state->J_is_singular_flag) {
        if (solver->saved_state->handling_of_singular_jacobian_flag == JMI_REGULARIZATION) {
            DenseCopy(solver->saved_state->J, solver->JTJ);
        } else if (solver->saved_state->handling_of_singular_jacobian_flag == JMI_MINIMUM_NORM) {
            DenseCopy(solver->saved_state->J, solver->J_sing);
        }
    } else {
            DenseCopy(solver->saved_state->J, solver->J_LU);
    }
        
    solver->J_is_singular_flag = solver->saved_state->J_is_singular_flag;
    ((struct KINMemRec *)solver->kin_mem)->kin_nnilset = ((struct KINMemRec *)solver->kin_mem)->kin_nni - solver->saved_state->mbset;
    memcpy(N_VGetArrayPointer(solver->kin_f_scale), N_VGetArrayPointer(solver->saved_state->kin_f_scale), block->n*sizeof(realtype));
    memcpy(N_VGetArrayPointer(solver->kin_y_scale), N_VGetArrayPointer(solver->saved_state->kin_y_scale), block->n*sizeof(realtype));
    memcpy(solver->lapack_ipiv, solver->saved_state->lapack_ipiv, (block->n+2)*sizeof(int)); 
    
    return flag;
}

int jmi_kinsol_completed_integrator_step(jmi_block_solver_t* block) {
    if(block->n == 1 && 
       block->options->use_Brent_in_1d_flag && 
       block->options->experimental_mode & jmi_block_solver_experimental_use_last_integrator_step) {
           return jmi_brent_completed_integrator_step(block);
    } else if (block->options->experimental_mode & jmi_block_solver_experimental_use_last_integrator_step) {
        /* Kinsol specific handling of a completed step */
        int flag;
        jmi_kinsol_solver_t* solver = block->solver;
        
        flag = block->F(block->problem_data,block->last_accepted_x,block->res,JMI_BLOCK_INITIALIZE);
        if (flag) {
            jmi_log_node(block->log, logError, "ReadLastIterationVariables",
                         "Failed to read the iteration variables, <errorCode: %d> in <block: %s>", flag, block->label);
            return flag;
        }
        if (solver->J_is_singular_flag) {
            if (solver->handling_of_singular_jacobian_flag == JMI_REGULARIZATION) {
                DenseCopy(solver->JTJ, solver->saved_state->J);
            } else if (solver->handling_of_singular_jacobian_flag == JMI_MINIMUM_NORM) {
                DenseCopy(solver->J_sing, solver->saved_state->J);
            }
        } else {
            DenseCopy(solver->J_LU, solver->saved_state->J);
        }
        solver->saved_state->handling_of_singular_jacobian_flag = solver->handling_of_singular_jacobian_flag;
        solver->saved_state->J_is_singular_flag = solver->J_is_singular_flag;
        solver->saved_state->mbset = ((struct KINMemRec *)solver->kin_mem)->kin_nni - ((struct KINMemRec *)solver->kin_mem)->kin_nnilset;
        memcpy(N_VGetArrayPointer(solver->saved_state->kin_f_scale),N_VGetArrayPointer(solver->kin_f_scale), block->n*sizeof(realtype));
        memcpy(N_VGetArrayPointer(solver->saved_state->kin_y_scale),N_VGetArrayPointer(solver->kin_y_scale), block->n*sizeof(realtype));
        memcpy(solver->saved_state->lapack_ipiv, solver->lapack_ipiv, (block->n+2)*sizeof(int)); 
    }
    return 0;
}

