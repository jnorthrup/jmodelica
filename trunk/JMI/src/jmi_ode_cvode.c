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

#include <cvode/cvode.h>             /* main integrator header file */
#include <cvode/cvode_dense.h>       /* use CVDENSE linear solver */
#include <nvector/nvector_serial.h>  /* serial N_Vector types, fct. and macros */
#include <sundials/sundials_types.h> /* definition of realtype */
#include <sundials/sundials_math.h>  /* contains the macros ABS, SQR, and EXP*/
#include "jmi_ode_solver.h"
#include "jmi_ode_cvode.h"
#include "jmi_log.h"
#include "fmi1_cs.h"
#include "fmi1_me.h"

int cv_rhs(realtype t, N_Vector yy, N_Vector yydot, void *problem_data){
    realtype *y, *ydot;
    int flag;
    jmi_ode_solver_t *solver = (jmi_ode_solver_t*)problem_data;
    fmi1_cs_t* fmi1_cs = solver->fmi1_cs;

    y = NV_DATA_S(yy); /*y is now a vector of realtype*/
    ydot = NV_DATA_S(yydot); /*ydot is now a vector of realtype*/

    flag = fmi1_cs_rhs_fcn(fmi1_cs, t, y, ydot);
    if(flag != 0) {
        jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logWarning, "Warning", "<Evaluating the derivatives failed (recoverable error). "
                     "Returned with> warningFlag: %d", flag);
        return 1; /* Recoverable failure */
    }
    
    if (fmi1_cs->n_real_x == 0){
        ydot[0] = 0.0;
    }

    return CV_SUCCESS;
}

int cv_root(realtype t, N_Vector yy, realtype *gout,  void* problem_data){
    realtype *y;
    int flag;
    jmi_ode_solver_t *solver = (jmi_ode_solver_t*)problem_data;
    fmi1_cs_t* fmi1_cs = solver->fmi1_cs;

    y = NV_DATA_S(yy); /*y is now a vector of realtype*/

    flag = fmi1_cs_root_fcn(fmi1_cs, t, y, gout);    
    if(flag != 0) {
        jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logError, "Error", "<Evaluating the event indicators failed. "
                     "Returned with> error_flag: %d", flag);
        return -1; /* Failure */
    }
    
    return CV_SUCCESS;
}

void cv_err(int error_code, const char *module,const char *function, char *msg, void *problem_data){
    jmi_ode_solver_t *solver = (jmi_ode_solver_t*)problem_data;
    fmi1_cs_t* fmi1_cs = solver->fmi1_cs;
    
    if (error_code == CV_WARNING){
        jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logWarning, "Warning", "<Warning from> function: %s, msg: %s", function, msg);
    } else {
        jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logError, "Error", "<Error from> function: %s, msg: %s", function, msg);
    }        
}

int jmi_ode_cvode_solve(jmi_ode_solver_t* solver, realtype time_final, int initialize){
    int flag = 0,retval = 0;
    jmi_ode_cvode_t* integrator = (jmi_ode_cvode_t*)solver->integrator;
    fmi1_cs_t* fmi1_cs = solver->fmi1_cs;
    realtype tret,*y;
    realtype time;
    fmiBoolean step_event = fmiFalse;
    
    if (initialize==JMI_TRUE){
        if (fmi1_cs->n_real_x > 0) {
            y = NV_DATA_S(integrator->y_work);
            flag = fmi1_me_get_continuous_states(fmi1_cs->fmi1_me, (fmiReal*)y, fmi1_cs->n_real_x);
            if (flag != fmiOK) {
                return JMI_ODE_ERROR;
            }
        }
        flag = fmi1_cs_get_time((fmiComponent)fmi1_cs, &time);
        if (flag != fmiOK) {
                return JMI_ODE_ERROR;
        }
        flag = CVodeReInit(integrator->cvode_mem, time, integrator->y_work);
        if (flag<0){
            jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logError, "Error", "<Failed to re-initialize the solver. "
                         "Returned with> error_flag: %d", flag);
            return JMI_ODE_ERROR;
        }
    }
    
    /* Dont integrate past t_stop */
    flag = CVodeSetStopTime(integrator->cvode_mem, time_final);
    if (flag < 0){
        jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logError, "Error", "<Failed to specify the stop time. "
                     "Returned with> error_flag: %d", flag);
        return JMI_ODE_ERROR;
    }
    
    /*
    flag = CVode(integrator->cvode_mem, time_final, integrator->y_work, &tret, CV_NORMAL);
    if(flag<0){
        jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logError, "Error", "Failed to calculate the next step. "
                     "Returned with> error_flag: %d", flag);
        return JMI_ODE_ERROR;
    }
    */
    
    flag = CV_SUCCESS;
    while (flag == CV_SUCCESS) {
        
        /* Perform a step */
        flag = CVode(integrator->cvode_mem, time_final, integrator->y_work, &tret, CV_ONE_STEP);
        if(flag<0){
            jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logError, "Error", "Failed to calculate the next step. "
                     "Returned with> error_flag: %d", flag);
            return JMI_ODE_ERROR;
        }
        
        /* After each step call completed integrator step */
        retval = fmi1_cs_completed_integrator_step((fmiComponent)fmi1_cs, &step_event);
        if (retval != fmiOK) {
            jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logError, "Error", "Failed to complete an integrator step. "
                     "Returned with> error_flag: %d", retval);
            return JMI_ODE_ERROR;
        }
        
        if (step_event == fmiTrue) {
            jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logInfo, "STEPEvent", "<An event was detected at> t:%g", tret);
            return JMI_ODE_EVENT;
        }
        
    }
    
    /*
    flag = fmi1_cs_get_time((fmiComponent)fmi1_cs, &time);
    if (flag != fmiOK) {
        return JMI_ODE_ERROR;
    }
    if (time != tret) {
        flag = fmi1_cs_rhs_fcn(fmi1_cs, tret, NV_DATA_S(integrator->y_work), fmi1_cs->states_derivative);
        if(flag != 0) {
            jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logWarning, "Warning", "<Evaluating the derivatives failed (recoverable error). "
                     "Returned with> warningFlag: %d", flag);
            return JMI_ODE_ERROR;
        }
        printf("Difference at time %g\n",tret);
    }
    */
    
    if (flag == CV_ROOT_RETURN){
        jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logInfo, "CVODEEvent", "<An event was detected at> t:%g", tret);
        return JMI_ODE_EVENT;
    }
    return JMI_ODE_OK;
}

int jmi_ode_cvode_new(jmi_ode_cvode_t** integrator_ptr, jmi_ode_solver_t* solver) {
    jmi_ode_cvode_t* integrator;
    fmi1_cs_t* fmi1_cs = solver->fmi1_cs;
    fmi_t* fmi1_me = (fmi_t*)fmi1_cs->fmi1_me;
    int flag = 0;
    void* cvode_mem;
    jmi_real_t* y;
    fmiReal* nominal;
    fmiReal* atol_nv;
    int i;
    
    integrator = (jmi_ode_cvode_t*)calloc(1,sizeof(jmi_ode_cvode_t));
    if(!integrator){
        jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logError, "Error", "<Failed to allocate the internal CVODE struct.>");
        return -1;
    }
    
    nominal = (fmiReal*)calloc(fmi1_cs->n_real_x, sizeof(fmiReal));
    flag = fmi1_me_get_nominal_continuous_states(fmi1_cs->fmi1_me, nominal, fmi1_cs->n_real_x);
    if (flag != fmiOK) {
        jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logError, "Error", "<Failed to get the nominal states.>");
        return -1;
    }

    /* DEFAULT VALUES NEEDS TO BE IMPROVED*/
    integrator->lmm  = CV_BDF;
    integrator->iter = CV_NEWTON;
    /* integrator->rtol = 1e-4; */
    integrator->rtol = fmi1_me->jmi->options.cs_rel_tol;
    
    if (fmi1_cs->n_real_x > 0) {
        integrator->atol = N_VNew_Serial(fmi1_cs->n_real_x);
    } else {
        integrator->atol = N_VNew_Serial(1);
    }
    atol_nv = NV_DATA_S(integrator->atol);
    
    if (fmi1_cs -> n_real_x > 0) {
        for (i = 0; i < fmi1_cs->n_real_x; i++) {
            atol_nv[i] = 0.01*integrator->rtol*nominal[i];
        }
    }else{
        atol_nv[0] = 0.01*integrator->rtol*1.0;
    }

    cvode_mem = CVodeCreate(integrator->lmm,integrator->iter);
    if(!cvode_mem){
        jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logError, "Error", "<Failed to allocate the CVODE struct.>");
        return -1;
    }

    /* Get the default values for the time and states */
    if (fmi1_cs->n_real_x > 0) {
        integrator->y_work = N_VNew_Serial(fmi1_cs->n_real_x);
        y = NV_DATA_S(integrator->y_work);
        
        flag = fmi1_me_get_continuous_states(fmi1_cs->fmi1_me, (fmiReal*)y, fmi1_cs->n_real_x);
        if (flag != fmiOK) {
            return JMI_ODE_ERROR;
        }
    }else{
        integrator->y_work = 
        N_VNew_Serial(1);
        y = NV_DATA_S(integrator->y_work);
        y[0] = 0.0;
    }
    
    flag = CVodeInit(cvode_mem, cv_rhs, fmi1_cs->time, integrator->y_work);
    if(flag != 0) {
        jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logError, "Error", "<Failed to initialize CVODE. Returned with> error_flag: %d", flag);
        return -1;
    }

    flag = CVodeSVtolerances(cvode_mem, integrator->rtol, integrator->atol);
    if(flag!=0){
        jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logError, "Error", "<Failed to specify the tolerances. Returned with> error_flag: %d", flag);
        return -1;
    }

    if (fmi1_cs->n_real_x > 0) {
        flag = CVDense(cvode_mem, fmi1_cs->n_real_x);
    }else{
        flag = CVDense(cvode_mem, 1);
    }
    if(flag!=0){
        jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logError, "Error", "<Failed to specify the linear solver. Returned with> error_flag: %d", flag);
        return -1;
    }

    flag = CVodeSetUserData(cvode_mem, (void*)solver);
    if(flag!=0){
        jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logError, "Error", "<Failed to specify the user data. Returned with> error_flag: %d", flag);
        return -1;
    }
    
    if (fmi1_cs->n_sw > 0){
        flag = CVodeRootInit(cvode_mem, fmi1_cs->n_sw, cv_root);
        if(flag!=0){
            jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logError, "Error", "<Failed to specify the event indicator function. Returned with> error_flag: %d", flag);
            return -1;
        }
    }
    
    flag = CVodeSetErrHandlerFn(cvode_mem, cv_err, (void*)solver);
    if(flag!=0){
        jmi_log_node(fmi1_cs_get_jmi_t_log(fmi1_cs), logError, "Error", "<Failed to specify the error handling function. Returned with> error_flag: %d", flag);
        return -1;
    }

    integrator->cvode_mem = cvode_mem;    
      
    *integrator_ptr = integrator;
    return 0;
}

void jmi_ode_cvode_delete(jmi_ode_solver_t* solver) {
    
    if((jmi_ode_cvode_t*)(solver->integrator)){
        /*Deallocate work vectors.*/
        N_VDestroy_Serial((((jmi_ode_cvode_t*)(solver->integrator))->y_work));
        N_VDestroy_Serial((((jmi_ode_cvode_t*)(solver->integrator))->atol));
        /*Deallocate CVode */
        CVodeFree(&(((jmi_ode_cvode_t*)(solver->integrator))->cvode_mem));
        
        free((jmi_ode_cvode_t*)(solver->integrator));     
    }
}
