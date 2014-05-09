/*
    Copyright (C) 2013 Modelon AB

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

#include "stdio.h"
#include "fmi2_me.h"
#include "fmi2_cs.h"

const char* fmi2_get_types_platform() {
    return fmiTypesPlatform;
}

const char* fmi2_get_version() {
    return fmiVersion;
}

fmiStatus fmi2_set_debug_logging(fmiComponent    c,
                                 fmiBoolean      loggingOn, 
                                 size_t          nCategories, 
                                 const fmiString categories[]) {

    fmi2_me_t* self = (fmi2_me_t*)c;
    int i, max_log_level, tmp_log_level;
    if (c == NULL) {
		return fmiFatal;
    }

    max_log_level = 0;
    for (i = 0; i < nCategories; i++) {
        if (strcmp(categories[i], "logLevel1")) {
            tmp_log_level = 1;
        } else if (strcmp(categories[i], "logLevel2")) {
            tmp_log_level = 2;
        } else if (strcmp(categories[i], "logLevel3")) {
            tmp_log_level = 3;
        } else if (strcmp(categories[i], "logLevel4")) {
            tmp_log_level = 4;
        } else if (strcmp(categories[i], "logLevel5")) {
            tmp_log_level = 5;
        } else if (strcmp(categories[i], "logLevel6")) {
            tmp_log_level = 6;
        } else {
            jmi_log_node(self->jmi.log, logError, "Error", "The log category '%s' is not allowed", categories[i]);
            return fmiError;
        }

        if (tmp_log_level > max_log_level) {
            max_log_level = tmp_log_level;
        }
    }
    
    self->jmi.jmi_callbacks.log_options.logging_on_flag = loggingOn;
    self->jmi.jmi_callbacks.log_options.log_level = max_log_level;
    return fmiOK;
}

fmiComponent fmi2_instantiate(fmiString instanceName,
                              fmiType   fmuType, 
                              fmiString fmuGUID, 
                              fmiString fmuResourceLocation, 
                              const fmiCallbackFunctions* functions, 
                              fmiBoolean                  visible,
                              fmiBoolean                  loggingOn) {
    
    fmiComponent component;
    fmiInteger   retval;
    
    if(!functions->allocateMemory || !functions->freeMemory || !functions->logger) {
         if(functions->logger) {
             /* We have to use the raw logger callback here; the logger in the jmi_t struct is not yet initialized. */
             functions->logger(0, instanceName, fmiError, "ERROR", "Memory management functions allocateMemory/freeMemory are required.");
         }
         return NULL;
    }
    
    /*Allocate memory for the correct struct. */
    if (fmuType == fmiModelExchange) {
        component = (fmiComponent)functions->allocateMemory(1, sizeof(fmi2_me_t));
        if(!component) return NULL;

        retval = fmi2_me_instantiate(component, instanceName, fmuType, fmuGUID, 
                                     fmuResourceLocation, functions, visible,
                                     loggingOn);
        if (retval != fmiOK) {
            functions->freeMemory(component);
            return NULL;
        }

    } else if (fmuType == fmiCoSimulation) {
        component = (fmiComponent)functions->allocateMemory(1, sizeof(fmi2_cs_t));
        if(!component) return NULL;

        retval = fmi2_cs_instantiate(component, instanceName, fmuType, fmuGUID, 
                                     fmuResourceLocation, functions, visible,
                                     loggingOn);
        if (retval != fmiOK) {
            functions->freeMemory(component);
            return NULL;
		}
    } else {
		/* We have to use the raw logger callback here; the logger in the jmi_t struct is not yet initialized. */
        functions->logger(0, instanceName, fmiError, "ERROR", "Valid choises for fmuType are fmiModelExchange and fmiCoSimulation");
        component = NULL;
	}
    
    return component;
}

static fmiStatus category_to_fmiStatus(jmi_log_category_t c) {
    switch (c) {
    case logError:   return fmiError;
    case logWarning: return fmiWarning;
    case logInfo:    return fmiOK;
    default:         return fmiError;
    }
}

static const char *category_to_fmiCategory(jmi_log_category_t c) {
    switch (c) {
    case logError:   return "ERROR";
    case logWarning: return "WARNING";
    case logInfo:    return "INFO";
    default:         return "UNKNOWN CATEGORY";
    }
}

void fmi2_me_emit_log(jmi_callbacks_t* jmi_callbacks, jmi_log_category_t category, jmi_log_category_t severest_category, char* message) {

    fmi2_me_t* c = (fmi2_me_t*)(jmi_callbacks->model_data);
    
    if(c){
        if(c->fmi_functions->logger)
            c->fmi_functions->logger(c,jmi_callbacks->instance_name, 
                                     category_to_fmiStatus(category),
                                     category_to_fmiCategory(severest_category),
                                     "%s", message); /* prevent interpretation of message as format string */
    } else {
        switch (category) {
            case logError:
                fprintf(stderr, "<!-- ERROR:   --> %s\n", message);
            break;
            case logWarning:
                fprintf(stderr, "<!-- WARNING: --> %s\n", message);
            break;
            case logInfo:
                fprintf(stdout, "%s\n", message);
            break;
        }
    }
}

BOOL fmi2_me_is_log_category_emitted(jmi_callbacks_t* cb, jmi_log_category_t category) {

    jmi_callbacks_t* jmi_callbacks = cb;
    fmi2_me_t * self = (fmi2_me_t *)cb->model_data;
    if ((self != NULL) && !jmi_callbacks->log_options.logging_on_flag) {
        return FALSE;
    }
    
    switch (category) {
        case logError:   break;
        case logWarning: if(cb->log_options.log_level < 3) return FALSE; break;
        case logInfo:    if(cb->log_options.log_level < 4) return FALSE; break;
    }
    return TRUE;
}

void fmi2_free_instance(fmiComponent c)  {
    /* Dispose the given model instance and deallocated all the allocated memory and other resources 
     * that have been allocated by the functions of the Model Exchange Interface for instance "c".*/
    fmiCallbackFreeMemory fmi_free;
    
    if (c) {
        fmi_free = ((fmi2_me_t*)c)->fmi_functions->freeMemory;
        
        if (((fmi2_me_t*)c)->fmu_type == fmiModelExchange) {
            fmi2_me_free_instance(c);
            fmi_free(((fmi2_me_t*)c));
        } else if (((fmi2_me_t*)c)->fmu_type == fmiCoSimulation) {
            fmi2_cs_free_instance(c);
            fmi_free(((fmi2_cs_t*)c));
        }
    }
}

fmiStatus fmi2_setup_experiment(fmiComponent c, 
                                fmiBoolean   toleranceDefined, 
                                fmiReal      tolerance, 
                                fmiReal      startTime, 
                                fmiBoolean   stopTimeDefined, 
                                fmiReal      stopTime) {
    fmiStatus retval;

	if (c == NULL) {
		return fmiFatal;
    }
    
    jmi_setup_experiment(&((fmi2_me_t*)c)->jmi, toleranceDefined, tolerance);
    
    retval = fmi2_set_time(c, startTime);
    
    if (((fmi2_me_t*)c)->fmu_type == fmiCoSimulation) {
        jmi_init_ode_problem(((fmi2_cs_t*)c)->ode_problem, startTime, fmi2_cs_rhs_fcn,
                             fmi2_cs_root_fcn, fmi2_cs_completed_integrator_step);
    }
    
    return retval;
}

fmiStatus fmi2_enter_initialization_mode(fmiComponent c) {
    fmiInteger retval;
    jmi_ode_problem_t* ode_problem;
    jmi_t* jmi;
    jmi_ode_method_t ode_method;
    jmi_real_t ode_step_size;
    jmi_real_t ode_rel_tol;

	if (c == NULL) {
		return fmiFatal;
    }
    
    if (((fmi2_me_t *)c)->fmi_mode != instantiatedMode) {
        jmi_log_comment(((fmi2_me_t *)c)->jmi.log, logError, "Can only enter initialization mode after instantiating the model.");
        return fmiError;
    }
    jmi = &((fmi2_me_t*)c)->jmi;
    
    retval = jmi_initialize(jmi);
    if (retval != 0) {
        return fmiError;
    }
    
    ((fmi2_me_t *)c) -> fmi_mode = initializationMode;
    
    if (((fmi2_me_t *)c) -> fmu_type == fmiCoSimulation) {
        ode_problem = ((fmi2_cs_t *)c) -> ode_problem; 
        /*Get the states, event indicators and the nominals for the ODE problem. Initialization. */
        fmi2_get_continuous_states(ode_problem->fmix_me, ode_problem->states, ode_problem->n_real_x);
        fmi2_get_event_indicators(ode_problem->fmix_me, ode_problem->event_indicators, ode_problem->n_sw);
        fmi2_get_event_indicators(ode_problem->fmix_me, ode_problem->event_indicators_previous, ode_problem->n_sw);
        fmi2_get_nominals_of_continuous_states(ode_problem->fmix_me, ode_problem->nominal, ode_problem->n_real_x);
        
        
        /* These options for the solver need to be found in a better way. */
        ode_method    = jmi->options.cs_solver;
        ode_step_size = jmi->options.cs_step_size;
        ode_rel_tol   = jmi->options.cs_rel_tol;
        
        /* Create solver */
        retval = jmi_new_ode_solver(ode_problem, ode_method, ode_step_size, ode_rel_tol);
        if (retval != fmiOK) { 
            return fmiError;
        }
    }
    
    return fmiOK;
}

fmiStatus fmi2_exit_initialization_mode(fmiComponent c) {
	if (c == NULL) {
		return fmiFatal;
    }

    if (((fmi2_me_t *)c)->fmi_mode != initializationMode) {
        jmi_log_comment(((fmi2_me_t *)c)->jmi.log, logError, "Can only exit initialization mode when being in initialization mode.");
        return fmiError;
    }
    if (((fmi2_me_t *)c)->fmu_type == fmiModelExchange) {
        ((fmi2_me_t *)c)->fmi_mode = eventMode;
    } else if (((fmi2_me_t *)c)->fmu_type == fmiCoSimulation) {
        ((fmi2_me_t *)c)->fmi_mode = slaveInitialized;
		((fmi2_cs_t *)c)->event_info.newDiscreteStatesNeeded = fmiTrue; /* To start event iteration after initialization. */
    }
    return fmiOK;
}

fmiStatus fmi2_terminate(fmiComponent c) {
    /* Release all resources that have been allocated since fmi_initialize has been called. */
    if (c == NULL) {
		return fmiFatal;
    }
    
    jmi_terminate(&((fmi2_me_t *)c)->jmi);
    
    return fmiOK;
}

fmiStatus fmi2_reset(fmiComponent c) {
	/* Resets the FMU by deleting the jmi struct. */
    if (c == NULL) {
		return fmiFatal;
    }

    jmi_delete(&((fmi2_me_t*)c)->jmi);
    
    return fmiOK;
}

fmiStatus fmi2_get_real(fmiComponent c, const fmiValueReference vr[],
                        size_t nvr, fmiReal value[]) {
    fmiInteger retval;
    int i;
    
    if (c == NULL) {
		return fmiFatal;
    }

    retval = jmi_get_real(&((fmi2_me_t *)c)->jmi, vr, nvr, value);
    if (retval != 0) {
        return fmiError;
    }
    
    /* Negate the values of the retrieved "negate alias" variables. */
    for (i = 0; i < nvr; i++) {
        if (is_negated(vr[i])) {
            value[i] = -value[i];
        }
    }

    return fmiOK;
}

fmiStatus fmi2_get_integer(fmiComponent c, const fmiValueReference vr[],
                           size_t nvr, fmiInteger value[]) {
    fmiInteger retval;
    
    if (c == NULL) {
		return fmiFatal;
    }

    retval = jmi_get_integer(&((fmi2_me_t *)c)->jmi, vr, nvr, value);
    if (retval != 0) {
        return fmiError;
    }

    return fmiOK;
}

fmiStatus fmi2_get_boolean(fmiComponent c, const fmiValueReference vr[],
                           size_t nvr, fmiBoolean value[]) {
    fmiInteger retval;
    jmi_boolean* jmi_boolean_values = (jmi_boolean*)calloc(nvr, sizeof(char));
    int i;
    
    if (c == NULL) {
		return fmiFatal;
    }

    retval = jmi_get_boolean(&((fmi2_me_t *)c)->jmi, vr, nvr, jmi_boolean_values);
    if (retval != 0) {
        return fmiError;
    }
    
    for (i = 0; i < nvr; i++) {
        value[i] = jmi_boolean_values[i];
    }
    free(jmi_boolean_values);

    return fmiOK;
}

fmiStatus fmi2_get_string(fmiComponent c, const fmiValueReference vr[],
                          size_t nvr, fmiString value[]) {
    fmiInteger retval;
    
    if (c == NULL) {
		return fmiFatal;
    }

    retval = jmi_get_string(&((fmi2_me_t *)c)->jmi, vr, nvr, value);
    if (retval != 0) {
        return fmiError;
    }

    /* Strings not yet supported. */
    return fmiWarning;
}

fmiStatus fmi2_set_real(fmiComponent c, const fmiValueReference vr[],
                        size_t nvr, const fmiReal value[]) {
    fmiInteger retval;
    fmiReal* negated_value;
    int i;
    
    if (c == NULL) {
		return fmiFatal;
    }
    
    /* Negate the values before setting the "negate alias" variables. */
    negated_value = (fmiReal*)calloc(nvr, sizeof(fmiReal));
    for (i = 0; i < nvr; i++) {
        if (is_negated(vr[i])) {
            negated_value[i] = -value[i];
        } else {
            negated_value[i] = value[i];
        }
    }
    
    retval = jmi_set_real(&((fmi2_me_t *)c)->jmi, vr, nvr, negated_value);
    free(negated_value);
    if (retval != 0) {
        return fmiError;
    }
    
    return fmiOK;
}

fmiStatus fmi2_set_integer(fmiComponent c, const fmiValueReference vr[],
                           size_t nvr, const fmiInteger value[]) {
    fmiInteger retval;
    
    if (c == NULL) {
		return fmiFatal;
    }
    
    retval = jmi_set_integer(&((fmi2_me_t *)c)->jmi, vr, nvr, value);
    if (retval != 0) {
        return fmiError;
    }
    
    return fmiOK;
}

fmiStatus fmi2_set_boolean(fmiComponent c, const fmiValueReference vr[],
                           size_t nvr, const fmiBoolean value[]) {
    fmiInteger retval;
    int i;

	jmi_boolean* jmi_boolean_values = (jmi_boolean*)calloc(nvr, sizeof(char));;
    
    if (c == NULL) {
		return fmiFatal;
    }
    
    for (i = 0; i < nvr; i++) {
        jmi_boolean_values[i] = value[i];
    }
    
    retval = jmi_set_boolean(&((fmi2_me_t *)c)->jmi, vr, nvr, jmi_boolean_values);
    if (retval != 0) {
        return fmiError;
    }

	free(jmi_boolean_values);
    
    return fmiOK;
}

fmiStatus fmi2_set_string(fmiComponent c, const fmiValueReference vr[],
                          size_t nvr, const fmiString value[]) {
    fmiInteger retval;
    
    if (c == NULL) {
		return fmiFatal;
    }
    
    retval = jmi_set_string(&((fmi2_me_t *)c)->jmi, vr, nvr, value);
    if (retval != 0) {
        return fmiError;
    }
    
    /* Strings not yet supported. */
    return fmiWarning;
}

fmiStatus fmi2_get_fmu_state(fmiComponent c, fmiFMUstate* FMUstate) {
    return fmiError;
}

fmiStatus fmi2_set_fmu_state(fmiComponent c, fmiFMUstate FMUstate) {
    return fmiError;
}

fmiStatus fmi2_free_fmu_state(fmiComponent c, fmiFMUstate* FMUstate) {
    return fmiError;
}

fmiStatus fmi2_serialized_fmu_state_size(fmiComponent c, fmiFMUstate FMUstate,
                                         size_t* size) {
    return fmiError;
}

fmiStatus fmi2_serialized_fmu_state(fmiComponent c, fmiFMUstate FMUstate,
                                    fmiByte serializedState[], size_t size) {
    return fmiError;
}

fmiStatus fmi2_de_serialized_fmu_state(fmiComponent c,
                                       const fmiByte serializedState[],
                                       size_t size, fmiFMUstate* FMUstate) {
    return fmiError;
}

fmiStatus fmi2_get_directional_derivative(fmiComponent c,
                const fmiValueReference vUnknown_ref[], size_t nUnknown,
                const fmiValueReference vKnown_ref[],   size_t nKnown,
                const fmiReal dvKnown[], fmiReal dvUnknown[]) {
    fmiInteger retval;
    
    if (c == NULL) {
		return fmiFatal;
    }
    
    retval = jmi_get_directional_derivative(&((fmi2_me_t *)c)->jmi, vUnknown_ref,
                    nUnknown, vKnown_ref, nKnown, dvKnown, dvUnknown);
    if (retval != 0) {
        return fmiError;
    }
    
    return fmiOK;
}

fmiStatus fmi2_enter_event_mode(fmiComponent c) {
	if (c == NULL) {
		return fmiFatal;
    }

    if (((fmi2_me_t *)c)->fmi_mode != continuousTimeMode) {
        jmi_log_comment(((fmi2_me_t *)c)->jmi.log, logError, "Can only enter event mode from continuous time mode.");
        return fmiError;
    }
    
    ((fmi2_me_t *)c) -> fmi_mode = eventMode;
    return fmiOK;
}

fmiStatus fmi2_new_discrete_state(fmiComponent  c, fmiEventInfo* fmiEventInfo) {
    fmiInteger retval;
    jmi_event_info_t* event_info;
    
    if (c == NULL) {
		return fmiFatal;
    }
    
    event_info = (jmi_event_info_t*)calloc(1, sizeof(jmi_event_info_t));

    event_info->iteration_converged        = !fmiEventInfo->newDiscreteStatesNeeded;
    event_info->terminate_simulation       =  fmiEventInfo->terminateSimulation;
    event_info->nominals_of_states_changed =  fmiEventInfo->nominalsOfContinuousStatesChanged;
    event_info->state_values_changed       =  fmiEventInfo->valuesOfContinuousStatesChanged;
    event_info->next_event_time_defined    =  fmiEventInfo->nextEventTimeDefined;
    event_info->next_event_time            =  fmiEventInfo->nextEventTime;
    
    retval = jmi_event_iteration(&((fmi2_me_t *)c)->jmi, TRUE, event_info);
    if (retval != 0) {
        return fmiError;
    }
    
    fmiEventInfo->newDiscreteStatesNeeded           = !event_info->iteration_converged;
    fmiEventInfo->terminateSimulation               =  event_info->terminate_simulation;
    fmiEventInfo->nominalsOfContinuousStatesChanged =  event_info->nominals_of_states_changed;
    fmiEventInfo->valuesOfContinuousStatesChanged   =  event_info->state_values_changed;
    fmiEventInfo->nextEventTimeDefined              =  event_info->next_event_time_defined;
    fmiEventInfo->nextEventTime                     =  event_info->next_event_time;
    
    free(event_info);
    
    return fmiOK;
}

fmiStatus fmi2_enter_continuous_time_mode(fmiComponent c) {
	if (c == NULL) {
		return fmiFatal;
    }

    if (((fmi2_me_t *)c)->fmi_mode != eventMode) {
        jmi_log_comment(((fmi2_me_t *)c)->jmi.log, logError, "Can only enter continuous time mode from event mode.");
        return fmiError;
    }
    
    ((fmi2_me_t *)c) -> fmi_mode = continuousTimeMode;
    return fmiOK;
}

fmiStatus fmi2_completed_integrator_step(fmiComponent c,
                                         fmiBoolean   noSetFMUStatePriorToCurrentPoint, 
                                         fmiBoolean*  enterEventMode, 
                                         fmiBoolean*  terminateSimulation) {
    if (c == NULL) {
		return fmiFatal;
    }
    
    *enterEventMode = fmiFalse;
    *terminateSimulation = fmiFalse; /* TODO: Should be able to use the stopTime to determine if the simulations should stop? */
    return fmiOK;
}

fmiStatus fmi2_set_time(fmiComponent c, fmiReal time) {
    if (c == NULL) {
		return fmiFatal;
    }
    
    *(jmi_get_t(&((fmi2_me_t *)c)->jmi)) = time;
    ((fmi2_me_t *)c)->jmi.recomputeVariables = 1;
    return fmiOK;
}

fmiStatus fmi2_set_continuous_states(fmiComponent c, const fmiReal x[],
                                     size_t nx) {
    if (c == NULL) {
		return fmiFatal;
    }
    
    memcpy (jmi_get_real_x(&((fmi2_me_t *)c)->jmi), x, nx*sizeof(fmiReal));
    ((fmi2_me_t *)c)->jmi.recomputeVariables = 1;
    return fmiOK;
}

fmiStatus fmi2_get_derivatives(fmiComponent c, fmiReal derivatives[], size_t nx) {
    fmiInteger retval;
    
    if (c == NULL) {
		return fmiFatal;
    }
    
    retval = jmi_get_derivatives(&((fmi2_me_t *)c)->jmi, derivatives, nx);
    if (retval != 0) {
        return fmiError;
    }
    
    return fmiOK;
}

fmiStatus fmi2_get_event_indicators(fmiComponent c, 
                                    fmiReal eventIndicators[], size_t ni) {
    fmiInteger retval;
    
    if (c == NULL) {
		return fmiFatal;
    }
    
    retval = jmi_get_event_indicators(&((fmi2_me_t *)c)->jmi, eventIndicators, ni);
    if (retval != 0) {
        return fmiError;
    }
    
    return fmiOK;
}

fmiStatus fmi2_get_continuous_states(fmiComponent c, fmiReal x[], size_t nx) {
    if (c == NULL) {
		return fmiFatal;
    }
    
    memcpy (x, jmi_get_real_x(&((fmi2_me_t *)c)->jmi), nx*sizeof(fmiReal));
    return fmiOK;
}

fmiStatus fmi2_get_nominals_of_continuous_states(fmiComponent c, 
                                                 fmiReal x_nominal[], 
                                                 size_t nx) {
    fmiInteger retval;
    
    if (c == NULL) {
		return fmiFatal;
    }
    
    retval = jmi_get_nominal_continuous_states(&((fmi2_me_t *)c)->jmi, x_nominal, nx);
    if (retval != 0) {
        return fmiError;
    }
    
    return fmiOK;
}

/* Local helper for fmi2_me_instantiate. */
int uri_to_path(char *path, const char* uri) {
    char* scheme   = "file://";
    int scheme_len = strlen(scheme);
    int uri_len    = strlen(uri);
    int len;
    
    if (strncmp(uri, scheme, scheme_len))
        return 1;
        
    if (uri[scheme_len] != '/' && uri[scheme_len] != '\\')
        return 1;
    
#ifdef _WIN32
    scheme_len++;
#endif
    
    len = uri_len - scheme_len;
    if (len <= 0)
        return 1;
    
    strcpy(path, &uri[scheme_len]);
    
    if (path[len-1] == '/' && path[len-1] == '\\') {
        path[len-1] = '\0';
    }
    
    return 0;
}

/* Helper method for fmi2_instatiate. */
fmiStatus fmi2_me_instantiate(fmiComponent c,
                              fmiString    instanceName,
                              fmiType      fmuType, 
                              fmiString    fmuGUID, 
                              fmiString    fmuResourceLocation, 
                              const fmiCallbackFunctions* functions, 
                              fmiBoolean                  visible,
                              fmiBoolean                  loggingOn) {
    fmiInteger retval;
    char* tmpname;
    char* resource_location;
    size_t inst_name_len;
    
    fmi2_me_t* fmi2_me = (fmi2_me_t*)c;
	jmi_callbacks_t* cb = &fmi2_me->jmi.jmi_callbacks;

	inst_name_len = strlen(instanceName)+1;
    tmpname = (char*)(fmi2_me_t *)functions->allocateMemory(inst_name_len, sizeof(char));
    strncpy(tmpname, instanceName, inst_name_len);

    cb->emit_log                    = fmi2_me_emit_log;
    cb->is_log_category_emitted     = fmi2_me_is_log_category_emitted;
    cb->log_options.logging_on_flag = loggingOn;
    cb->log_options.log_level       = 5; /* must be high to let the messages during initialization go through */
    cb->allocate_memory             = functions->allocateMemory;
    cb->free_memory                 = functions->freeMemory;
    cb->model_name                  = jmi_get_model_identifier();    /**< \brief Name of the model (corresponds to a fixed compiled unit name) */
    cb->instance_name               = tmpname;                       /**< \brief Name of this model instance. */
    cb->model_data                  = fmi2_me;
    
    resource_location = (char*)(fmi2_me_t *)functions->allocateMemory(strlen(fmuResourceLocation), sizeof(char));
    retval = uri_to_path(resource_location, fmuResourceLocation);
    if (retval) {
        functions->logger(0, instanceName, fmiError, "ERROR", "Invalid fmuResourceLocation <URI:%s>. Expected format: 'file:///absolute/path/resources'", fmuResourceLocation);
        functions->freeMemory(resource_location);
        return fmiError;
    }
    
    fmi2_me->fmi_instance_name = tmpname;
    fmi2_me->fmi_functions     = functions;
    fmi2_me->fmu_type          = fmuType;
    fmi2_me->fmi_mode          = instantiatedMode;
    
    retval = jmi_me_init(cb, &fmi2_me->jmi, fmuGUID, resource_location);
          
    if (retval != 0) {
        return fmiError;
    }
    
    return fmiOK;
}

/* Helper method for fmi2_free_instance. */
void fmi2_me_free_instance(fmiComponent c) {
    fmi2_me_t* fmi2_me = (fmi2_me_t*)c;
    fmiCallbackFreeMemory fmi_free = fmi2_me->fmi_functions->freeMemory;

    fmi_free(fmi2_me->jmi.resource_location);
    jmi_delete(&fmi2_me->jmi);
    fmi_free((void*)fmi2_me -> fmi_instance_name);
}
