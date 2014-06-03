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
#include <assert.h>

#include "jmi_brent_solver.h"
#include "jmi_block_solver_impl.h"

#include "jmi_brent_search.h"

/* Interface to the residual function that is compatible with Brent search.
   @param y - input - function argument
   @param f - output - residual value
   @param problem_data - solver object propagated as opaques data
*/
int brentf(realtype y, realtype* f, void* problem_data) {
    jmi_block_solver_t *block = (jmi_block_solver_t*)problem_data;
    int ret = 0;
    
    /* Increment function calls counter */
    block->nb_fevals++;

    /* Check that arguments are valid */
    if ((y- y) != 0) {
        jmi_log_node(block->log, logWarning, "Warning", "Not a number in arguments to <block: %d>", block->id);
        return -1;
    }

    /*Evaluate the residual*/
    ret = block->F(block->problem_data,&y,f,JMI_BLOCK_EVALUATE);
    if (ret) {
        jmi_log_node(block->log, logWarning, "Warning", "<errorCode: %d> returned from <block: %d>", ret, block->id);
        return ret;
    }
    /* Check that outputs are valid */    
    {
        realtype v = *f;
        if (v- v != 0) {
            jmi_log_node(block->log, logWarning, "Warning", "Not a number in output from <block: %d>", block->id);
            ret = 1;
        }
    }
    return ret;
}


/* Initialize solver structures 

block->options->use_Brent_in_1d_flag
solver->kin_stol = block->options->min_tol;
*/


int jmi_brent_solver_new(jmi_brent_solver_t** solver_ptr, jmi_block_solver_t* block) {
    jmi_brent_solver_t* solver;
    int flag = 0;
    
    solver = (jmi_brent_solver_t*)calloc(1,sizeof(jmi_brent_solver_t));
    if (!solver) return -1;
         
    *solver_ptr = solver;
    return flag;
}

void jmi_brent_solver_delete(jmi_block_solver_t* block) {
    jmi_brent_solver_t* solver = block->solver;
    
    /*Deallocate struct */
    free(solver);
    block->solver = 0;
}

void jmi_brent_solver_print_solve_start(jmi_block_solver_t * block,
                                         jmi_log_node_t *destnode) {
    if ((block->callbacks->log_options.log_level >= 5)) {
        jmi_log_t *log = block->log;
        *destnode = jmi_log_enter_fmt(log, logInfo, "BrentSolve", 
                                      "Brent solver invoked for <block:%d>", block->id);
        jmi_log_vrefs(log, *destnode, logInfo, "variables", 'r', block->value_references, block->n);
        jmi_log_reals(log, *destnode, logInfo, "max", block->max, block->n);
        jmi_log_reals(log, *destnode, logInfo, "min", block->min, block->n);
        jmi_log_reals(log, *destnode, logInfo, "nominal", block->nominal, block->n);
        jmi_log_reals(log, *destnode, logInfo, "initial_guess", block->x, block->n);        
    }
}

const char* jmi_brent_flag_to_name(int flag) {
    switch(flag) {
    case JMI_BRENT_MEM_FAIL: return "BRENT_MEM_FAIL";
    case JMI_BRENT_ILL_INPUT: return "BRENT_ILL_INPUT";
    case JMI_BRENT_SYSFUNC_FAIL: return "BRENT_SYSFUNC_FAIL";
    case JMI_BRENT_FIRST_SYSFUNC_ERR: return "JMI_BRENT_FIRST_SYSFUNC_ERR";
    case JMI_BRENT_REPTD_SYSFUNC_ERR: return "JMI_BRENT_REPTD_SYSFUNC_ERR";
    case JMI_BRENT_ROOT_BRACKETING_FAILED: return "BRENT_ROOT_BRACKETING_FAILED";
    case JMI_BRENT_FAILED: return "BRENT_FAILED";
    case JMI_BRENT_SUCCESS: return "BRENT_SUCCESS";
    default: return "BRENT_ERROR";
    }
}

void jmi_brent_solver_print_solve_end(jmi_block_solver_t * block, const jmi_log_node_t *node, int flag) {
    /* jmi_brent_solver_t* solver = block->solver; */

    /* NB: must match the condition in jmi_kinsol_solver_print_solve_start exactly! */
    if ((block->callbacks->log_options.log_level >= 5)) {
        jmi_log_t *log = block->log;
        const char *flagname = jmi_brent_flag_to_name(flag);
        if (flagname != NULL) jmi_log_fmt(log, *node, logInfo, "Brent solver finished with <exit_flag:%s>", flagname);
        else jmi_log_fmt(log, *node, logInfo, "Brent solver finished with unrecognized <brent_exit_flag:%d>", flag);
        jmi_log_leave(log, *node);
    }
}

/* Initialize solver structures */
/* just a placeholder in case more init is needed*/
static int jmi_brent_init(jmi_block_solver_t * block) {
    return 0;
}


static int jmi_brent_improve_bracket(jmi_block_solver_t * block, 
                                     double* x_cur, double* f_cur,
                                     double* x_bracket, double* f_bracket)
{
    int flag;
    jmi_brent_solver_t* solver = (jmi_brent_solver_t*)block->solver;
    jmi_log_t *log = block->log;

    if (block->callbacks->log_options.log_level > 4) {
         jmi_log_node(log, logInfo, "Info", "Trying to bracket the root with <iv: %g>", x_bracket[0]);
    }

    flag =  brentf(*x_bracket, f_bracket, block); /* evaluate residual */
    if (flag) {
        /* report error */
        return -1;
    }
    if (f_bracket[0] > DBL_MIN) { 
        if (f_cur[0] > 0) {  
            /* check if improve the bracketing (no sign change) */
            if (f_bracket[0] < f_cur[0]) {
                if (block->callbacks->log_options.log_level > 4) {
                    jmi_log_node(log, logInfo, "Info", "improving backeting in <block: %d> with <iv: %g> <residual: %g>", 
                        x_bracket[0], f_bracket[0]);
                }
                f_cur[0] = f_bracket[0];
                x_cur[0] = x_bracket[0];
            }
        }
        else  { /* sign change - bracketing done */
            solver->f_pos_min = f_bracket[0];
            solver->y_pos_min = x_bracket[0];
            solver->f_neg_max = f_cur[0];
            solver->y_neg_max = x_cur[0];
            return 1;
        }
    }
    else if (f_bracket[0] < -DBL_MIN) { 
        if (f_cur[0] < 0) {  
            /* check if improve the bracketing (no sign change) */
            if (f_bracket[0] > f_cur[0]) {
                f_cur[0] = f_bracket[0];
                x_cur[0] = x_bracket[0];
            }
        }
        else  { /* sign change - bracketing done */
            solver->f_neg_max = f_bracket[0];
            solver->y_neg_max = x_bracket[0];
            solver->f_pos_min = f_cur[0];
            solver->y_pos_min = x_cur[0];
            return 1;
        }
    }
    else {
        f_cur[0] = f_bracket[0];
        x_cur[0] = x_bracket[0];
        jmi_log_node(log, logInfo, "Info", "Got zero residual while bracketing in <block: %d>", block->id);
        return 2;
    }
    return 0; /* will need more bracketing */
}

int jmi_brent_solver_solve(jmi_block_solver_t * block){
    int flag;
    jmi_brent_solver_t* solver = (jmi_brent_solver_t*)block->solver;
    double f;
  /*   realtype curtime = block->cur_time;
    long int nniters = 0;
    int flagNonscaled;
    realtype fnorm;
    jmi_log_node_t topnode; */
    jmi_log_t *log = block->log; 


    if (block->init) {
        jmi_brent_init(block);
    }
    else {
        /* Read initial values and bounds for iteration variables from variable vector.
        * This is needed if the user has changed initial guesses in between calls to
        * the solver.
        */
        flag = block->F(block->problem_data,block->x,block->res,JMI_BLOCK_INITIALIZE);
        block->F(block->problem_data,block->min,block->res,JMI_BLOCK_MIN);
        block->F(block->problem_data,block->max,block->res,JMI_BLOCK_MAX);

        if (flag) {        
            jmi_log_node(log, logWarning, "Error", "<errorCode: %d> returned from <block: %d> "
                         "when reading initial guess.", flag, block->id);
            return flag;
        }
    }

    /* evaluate att initial */
    /* evaluate the function at initial */
    flag =  brentf(block->x[0], &f, block);

    if (flag) {
        jmi_log_node(block->log, logError, "Error", "Residual function evaluation failed at initial point for"
                     "<block: %d>", block->id);
        return JMI_BRENT_FIRST_SYSFUNC_ERR;
    }

    /* bracket the root */
    if ((f > DBL_MIN) || ((f < -DBL_MIN))) {
        double x = block->x[0], tmp;
        double lower = x, f_lower = f;
        double upper = x, f_upper = f;
        double lstep = block->nominal[0], ustep = lstep;
        while (1) {
            if (lower > block->min[0] && /* lower is fine as long as we're inside the bounds */
                (
                    ( upper >= block->max[0]) ||  /* prefer lower if upper is outside bounds */
                    ((f_lower < f_upper) && (f > 0)) || /* or lower is "closer" to sign change */
                    ((f_lower >= f_upper) && (f < 0))
                )
                ) {
                /* widen the interval */
                tmp = lower - lstep;  
                if ((tmp < block->min[0]) || (tmp != tmp)) { /* make sure we're inside bounds and not NAN*/
                    tmp = block->min[0];
                }
                lstep = lower - tmp;

                flag = jmi_brent_improve_bracket(block, &x, &f, &tmp, &f_lower);

                 /* modify the step for the next time */
                if (flag < 0) { 
                    /* there was an error - reduce the step */
                    lstep /= 2;
                    jmi_log_node(log, logInfo, "Info", 
                        "Reducing bracketing step in negative direction to <lstep: %g> in <block: %d>", lstep, block->id);
                    if (lstep < UNIT_ROUNDOFF * block->nominal[0]) {
                        jmi_log_node(log, logInfo, "Info", 
                            "Too small bracketing step - modifying lower <bound: %g> on the iteration variable in <block: %d>", lower, block->id);
                        block->min[0] = lower; /* we cannot step further without breaking the function -> update the bound */
                    }
                }
                else {
                    /* increase the step */
                    jmi_log_node(log, logInfo, "Info", 
                        "Increasing bracketing step in negative direction to <lstep: %g> in <block: %d>", lstep, block->id);
                    lstep *= 2;
                    lower = tmp;
                }
            }
            else if (upper < block->max[0]) { /* upper might work otherwise */
                tmp = upper + ustep;
                if ((tmp > block->max[0]) || (tmp != tmp)) {
                    tmp = block->max[0];
                }
                ustep = tmp - upper;

                flag = jmi_brent_improve_bracket(block, &x, &f, &tmp, &f_upper);

                 /* modify the step for the next time */
                if (flag < 0) { 
                    /* there was an error - reduce the step */
                    ustep /= 2;
                    jmi_log_node(log, logInfo, "Info", 
                        "Reducing bracketing step in positive direction to <ustep: %g> in <block: %d>", ustep, block->id);

                    if (ustep < UNIT_ROUNDOFF * block->nominal[0]) {
                        jmi_log_node(log, logInfo, "Info", 
                            "Too small bracketing step - modifying upper <bound: %g> on the iteration variable in <block: %d>", upper, block->id);
                        block->max[0] = upper; /* we cannot step further without breaking the function -> update the bound */
                    }
                }
                else {
                    /* increase the step */
                    jmi_log_node(log, logInfo, "Info", 
                        "Increasing bracketing step in positive direction to <ustep: %g> in <block: %d>", ustep, block->id);
                    ustep *= 2;
                    upper = tmp;
                }
            }
            else {
                jmi_log_node(log, logError, "Error", "Could not bracket the root in <block: %d>", block->id);
                return JMI_BRENT_ROOT_BRACKETING_FAILED;
            }
            if (flag > 0) { 
                break; /* bracketing done*/
            }
        }
        if (flag == 2) {
            /* root found while in bracketing */
            block->x[0] = x;
            return JMI_BRENT_SUCCESS;
        }
    }
    else {
        jmi_log_node(log, logInfo, "Info", "Initial guess has zero residual in <block: %d>", block->id);
        return JMI_BRENT_SUCCESS;
    }
    if (block->callbacks->log_options.log_level > 4) {
        jmi_log_node(log, logInfo, "Info", 
            "Bracketed the root between <iv_neg: %g> and <iv_pos: %g> residuals <res_neg: %g> and <res_pos: %g>", 
             solver->y_neg_max, solver->y_pos_min, solver->f_neg_max, solver->f_pos_min);
    }

    {            
        realtype u, f;
        flag = jmi_brent_search(brentf, solver->y_neg_max,  solver->y_pos_min, 
                                solver->f_neg_max, solver->f_pos_min, 0, &u, &f,block);
        block->x[0] = u;
        
        if (flag) {
            jmi_log_node(log, logError, "Error", "Function evaluation failed while iterating in <block: %d>", block->id);
            return JMI_BRENT_SYSFUNC_FAIL;
        }
    }   
        
    return JMI_BRENT_SUCCESS;
}

int jmi_brent_search(jmi_brent_func_t f, realtype u_min, realtype u_max, realtype f_min, realtype f_max, realtype tolerance, realtype* u_out, realtype* f_out,void *data) {
    realtype a=u_min; /* left point */
    realtype fa = f_min;
    realtype b=u_max; /* right point */
    realtype fb = f_max;
    realtype c = u_min; /* Intermediate point a <= c <= b */
    realtype fc = f_min;
    realtype e= u_max - u_min;
    realtype d=e;
    realtype m;
    realtype s;
    realtype p;
    realtype q;
    realtype r;
    realtype tol; /* absolute tolerance for the current "b" */
    int flag;
#ifdef DEBUG
    if (fa*fb > 0) {
        return JMI_BRENT_ILL_INPUT;
    }
#endif
    while(1) {
        if (RAbs(fc) < RAbs(fb)) {
            a = b;
            b = c;
            c = a;
            fa = fb;
            fb = fc;
            fc = fa;
        }
        tol = 2*UNIT_ROUNDOFF*RAbs(b) + tolerance;
        m = (c - b)/2;
        
        if ((RAbs(m) <= tol) || (fb == 0.0)) {
            /* root found (interval is small enough) */
            if (RAbs(fb) < RAbs(fc)) {
                *u_out = b;
                *f_out = fb;
            }
            else {
                *u_out = c;
                *f_out = fc;
            }
            return 0;
        }
        /* Find the new point: */
        /* Determine if a bisection is needed */
        if ((RAbs(e) < tol) || ( RAbs(fa) <= RAbs(fb))) {
            e = m;
            d = e;
        }
        else {
            s = fb/fa;
            if (a == c) {
                /* linear interpolation */
                p = 2*m*s;
                q = 1 - s;
            }
            else {
                /* inverse quadratic interpolation */
                q = fa/fc;
                r = fb/fc;
                p = s*(2*m*q*(q - r) - (b - a)*(r - 1));
                q = (q - 1)*(r - 1)*(s - 1);
            }
            if (p > 0) 
                q = -q;
            else
                p = -p;
            s = e;
            e = d;
            
            if ((2*p < 3*m*q - RAbs(tol*q)) && (p < RAbs(0.5*s*q)))
                /* interpolation successful */
                d = p/q;
            else {
                /* use bi-section */
                e = m;
                d = e;
            }
        }
        
        
        /* Best guess value is saved into "a" */
        a = b;
        fa = fb;
        b = b + ((RAbs(d) > tol) ? d : ((m > 0) ? tol: -tol));
        flag = f(b, &fb, data);
        if (flag) {
             if (RAbs(fa) < RAbs(fc)) {
                *u_out = a;
                *f_out = fa;
            }
            else {
                *u_out = c;
                *f_out = fc;
            }
            return flag;
        }

        if (fb * fc  > 0) {
            /* initialize variables */
            c = a;
            fc = fa;
            e = b - a;
            d = e;
        }
    }
}
