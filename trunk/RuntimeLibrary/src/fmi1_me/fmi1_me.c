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
#ifdef _WIN32
  #include <windows.h>
#else
  #define _GNU_SOURCE
  #include <dlfcn.h>
#endif

#include <stdio.h>
#include <string.h>
#include <time.h>
#include <assert.h>

#include "fmi1_me.h"
#include "jmi.h"
#include "jmi_block_residual.h"
#include "jmi_log.h"
#include "jmi_me.h"

/* Inquire version numbers of header files */
const char* fmi1_me_get_model_types_platform() {
    return fmiModelTypesPlatform;
}
const char* fmi1_me_get_version() {
    return fmiVersion;
}

/* Local helpers for fmi1_me_instantiate_model */
int jmi_find_parent_dir(char* path, const char* dir) {
    int found = 0;
    int dir_level = 3;
    int c_i = strlen(path) - 1;
    
    while(dir_level > 0 && !found) {
        while(c_i > 0 && path[c_i] != '\\' && path[c_i] != '/')
            c_i--;
        if (c_i <= 0)
            break;
        if (strcmp(&path[c_i+1],dir) == 0)
            found = 1;
        path[c_i]= '\0';
        c_i--;
        dir_level--;
    }
    
    return found;
}

union jmi_func_cast {
	void* x;
	char* (*y)();
};

void* jmi_func_to_voidp(char* (*y)()) {
	union jmi_func_cast jfc;
	assert(sizeof(jfc.x)==sizeof(jfc.y));
	jfc.y = y;
	return jfc.x;
}
 
char* jmi_locate_resources(void* (*allocateMemory)(size_t nobj, size_t size)) {
    int found;
    char *resource_dir = "/resources";
    char *binary_dir = "binaries";
    char *res;
    char path[JMI_PATH_MAX];
    char *resolved = path;
    
#ifdef _WIN32
    EXTERN_C IMAGE_DOS_HEADER __ImageBase;
    GetModuleFileName((HINSTANCE)&__ImageBase, path, MAX_PATH);
#else
    Dl_info info;
    dladdr(jmi_func_to_voidp(jmi_locate_resources), &info);
    resolved = realpath(info.dli_fname, path);
    if (!resolved)
        return NULL;
#endif
    
    found = jmi_find_parent_dir(resolved, binary_dir);
    
    if (!found)
        return NULL;
    
    strcat(resolved, resource_dir);
    
    if (!jmi_dir_exists(resolved))
        return NULL;
    
    res = allocateMemory(strlen(resolved)+1,sizeof(char));
    strcpy(res, resolved);
    return res;
}

/* Creation and destruction of model instances and setting debug status */
fmiComponent fmi1_me_instantiate_model(fmiString instanceName, fmiString GUID, fmiCallbackFunctions functions, fmiBoolean loggingOn) {

    fmi1_me_t *component;
    jmi_callbacks_t* cb;
    char* tmpname;
    char* resource_location;
    size_t inst_name_len;

    /* Create jmi struct -> No need  since jmi_init allocates it
     jmi_t* jmi = (jmi_t *)functions.allocateMemory(1, sizeof(jmi_t)); */
    fmiInteger retval;

    if(!functions.allocateMemory || !functions.freeMemory || !functions.logger) {
         if(functions.logger) {
             /* We have to use the raw logger callback here; the logger in the jmi_t struct is not yet initialized. */
             functions.logger(0, instanceName, fmiError, "ERROR", "Memory management functions allocateMemory/freeMemory are required.");
         }
         return 0;
    }
    
    component = (fmi1_me_t *)functions.allocateMemory(1, sizeof(fmi1_me_t));
    if(!component) {
         if(functions.logger) {
             /* We have to use the raw logger callback here; the logger in the jmi_t struct is not yet initialized. */
             functions.logger(0, instanceName, fmiError, "ERROR", "Could not allocate memory for the model instance.");
         }
         return 0;
    }
    component->fmi_functions = functions;
    cb = &component->jmi.jmi_callbacks;

    cb->emit_log = fmi1_me_emit_log;
    cb->is_log_category_emitted = fmi1_me_is_log_category_emitted;
    cb->log_options.logging_on_flag = loggingOn;
    cb->log_options.log_level = 5;
    cb->allocate_memory = functions.allocateMemory;
    cb->free_memory = functions.freeMemory;
    cb->model_name = jmi_get_model_identifier();       /**< \brief Name of the model (corresponds to a fixed compiled unit name) */
    cb->model_data = component;
    cb->instance_name = instanceName;  /* set instance name to use under instantiation (to avoid initial malloc)*/
    
    resource_location = jmi_locate_resources(functions.allocateMemory);
    if (!resource_location)
        functions.logger(0, instanceName, fmiWarning, "Warning", "Could not find resource location.");
    
    retval = jmi_me_init(cb, &component->jmi, GUID, resource_location);
    
    if (retval != 0) {
        functions.freeMemory(component);
        return NULL;
    }

    /* fmiString must be copied in and saved */ 
    inst_name_len = strlen(instanceName)+1;
    tmpname = (char*)(fmi1_me_t *)functions.allocateMemory(inst_name_len, sizeof(char));
    strncpy(tmpname, instanceName, inst_name_len);
    component -> fmi_instance_name = tmpname;
    cb->instance_name = tmpname;  /** reset the pointer to use after instantiate. */

    return component;
}

void fmi1_me_free_model_instance(fmiComponent c) {
    /* Dispose the given model instance and deallocated all the allocated memory and other resources 
     * that have been allocated by the functions of the Model Exchange Interface for instance "c".*/
    fmi1_me_t* component;
    fmiCallbackFreeMemory fmi_free;
    if (c) {
        component = (fmi1_me_t*)c;
        fmi_free = component -> fmi_functions.freeMemory;

        fmi_free(component->jmi.resource_location);
        /* TODO: Also delete modules */
        jmi_delete(&component->jmi);
        fmi_free((void*)component -> fmi_instance_name);
        fmi_free(component);
    }
}

fmiStatus fmi1_me_set_debug_logging(fmiComponent c, fmiBoolean loggingOn) {
    fmi1_me_t* self = (fmi1_me_t*)c;
    if (c == NULL) {
		return fmiFatal;
    }
    
    self->jmi.jmi_callbacks.log_options.logging_on_flag = loggingOn;
    return fmiOK;
}

/* Providing independent variables and re-initialization of caching */

fmiStatus fmi1_me_set_time(fmiComponent c, fmiReal time) {
    fmiInteger retval;

    if (c == NULL) {
		return fmiFatal;
    }

    retval = jmi_set_time(&((fmi1_me_t*)c)->jmi, time);
    if (retval != 0) {
        return fmiError;
    }
    
    return fmiOK;
}

fmiStatus fmi1_me_set_continuous_states(fmiComponent c, const fmiReal x[], size_t nx) {
    fmiInteger retval;

    if (c == NULL) {
		return fmiFatal;
    }
    
    retval = jmi_set_continuous_states(&((fmi1_me_t*)c)->jmi, x, nx);
    if (retval != 0) {
        return fmiError;
    }

    return fmiOK;
}

fmiStatus fmi1_me_completed_integrator_step(fmiComponent c, fmiBoolean* callEventUpdate) {
    fmi1_me_t* self = (fmi1_me_t*)c;
    jmi_t* jmi = &self->jmi;
    fmiInteger retval;
    fmiReal triggered_event;
    if (c == NULL) {
		return fmiFatal;
    }
    
    retval = jmi_completed_integrator_step(jmi, &triggered_event);
    if (retval != 0) {
        return fmiError;
    }
    
    if (triggered_event == 1.0){
        *callEventUpdate = fmiTrue;
    }else{
        *callEventUpdate = fmiFalse;
    }
    
    return fmiOK;
}

fmiStatus fmi1_me_set_real(fmiComponent c, const fmiValueReference vr[], size_t nvr, const fmiReal value[]) {
    fmi1_me_t* self = (fmi1_me_t*)c;
    jmi_t* jmi = &self->jmi;
    fmiInteger retval;
    
    if (c == NULL) {
		return fmiFatal;
    }
    
    retval = jmi_set_real(jmi, vr, nvr, value);
    if (retval != 0) {
        return fmiError;
    }
    
    return fmiOK;
}

fmiStatus fmi1_me_set_integer (fmiComponent c, const fmiValueReference vr[], size_t nvr, const fmiInteger value[]) {
    fmi1_me_t* self = (fmi1_me_t*)c;
    jmi_t* jmi = &self->jmi;
    fmiInteger retval;
    
    if (c == NULL) {
		return fmiFatal;
    }

    retval = jmi_set_integer(jmi, vr, nvr, value);
    if (retval != 0) {
        return fmiError;
    }
    
    return fmiOK;
}

fmiStatus fmi1_me_set_boolean (fmiComponent c, const fmiValueReference vr[], size_t nvr, const fmiBoolean value[]) {
     fmi1_me_t* self = (fmi1_me_t*)c;
    jmi_t* jmi = &self->jmi;
   fmiInteger retval;
    
    if (c == NULL) {
		return fmiFatal;
    }
    
    retval = jmi_set_boolean(jmi, vr, nvr, value);
    if (retval != 0) {
        return fmiError;
    }
    
    return fmiOK;
}

fmiStatus fmi1_me_set_string(fmiComponent c, const fmiValueReference vr[], size_t nvr, const fmiString value[]) {
     fmi1_me_t* self = (fmi1_me_t*)c;
    jmi_t* jmi = &self->jmi;
   fmiInteger retval;
    
    if (c == NULL) {
		return fmiFatal;
    }
    
    retval = jmi_set_string(jmi, vr, nvr, value);
    if (retval != 0) {
        return fmiError;
    }
    /* Strings not yet supported. */
    return fmiWarning;
}

/* Evaluation of the model equations */

fmiStatus fmi1_me_initialize(fmiComponent c, fmiBoolean toleranceControlled, fmiReal relativeTolerance, fmiEventInfo* eventInfo) {
    fmiInteger retval;
    fmi1_me_t* self = (fmi1_me_t*)c;
    jmi_t* jmi = &self->jmi;
#ifdef JMI_PROFILE_RUNTIME 
	clock_t t;
#endif
    /* For debugging Jacobians */
/*
    int n_states;
    jmi_real_t* jac;
    int j;
*/
    
    if (c == NULL) {
		return fmiFatal;
    }
#ifdef JMI_PROFILE_RUNTIME 
	t = clock();
#endif
    jmi_setup_experiment(jmi, toleranceControlled, relativeTolerance);
	
    retval = jmi_initialize(jmi);
    if (retval != 0) {
        return fmiError;
    }
	
    /* Initialization is now complete, but we also need to handle events
     * at the start of the integration.
     */
    retval = fmi1_me_event_update(c, fmiFalse, eventInfo);
    if(retval == fmiError) {
        jmi_log_comment(jmi->log, logError, "Event iteration failed during the initialization.");
        return fmiError;
    }

#ifdef JMI_PROFILE_RUNTIME 
	{
		char message[256];
		sprintf(message, "Time spent during initialize %f", ((double)clock() - t) / CLOCKS_PER_SEC);
		jmi_log_comment(jmi->log, logError, message);
	}
#endif
    return fmiOK;
}

fmiStatus fmi1_me_get_derivatives(fmiComponent c, fmiReal derivatives[] , size_t nx) {
    fmiInteger retval;
    fmi1_me_t* self = (fmi1_me_t*)c;
    jmi_t* jmi = &self->jmi;
    
    if (c == NULL) {
		return fmiFatal;
    }
    
    retval = jmi_get_derivatives(jmi, derivatives, nx);
    if (retval != 0) {
        return fmiError;
    }
    
    return fmiOK;
}

fmiStatus fmi1_me_get_event_indicators(fmiComponent c, fmiReal eventIndicators[], size_t ni) {
    fmiInteger retval;
    fmi1_me_t* self = (fmi1_me_t*)c;
    jmi_t* jmi = &self->jmi;
    
    if (c == NULL) {
		return fmiFatal;
    }
    
    retval = jmi_get_event_indicators(jmi, eventIndicators, ni);
    if (retval != 0) {
        return fmiError;
    }
    
    return fmiOK;
}

fmiStatus fmi1_me_get_real(fmiComponent c, const fmiValueReference vr[], size_t nvr, fmiReal value[]) {
    fmiInteger retval;
    fmi1_me_t* self = (fmi1_me_t*)c;
    jmi_t* jmi = &self->jmi;

    if (c == NULL) {
		return fmiFatal;
    }

    retval = jmi_get_real(jmi, vr, nvr, value);
    if (retval != 0) {
        return fmiError;
    }

    return fmiOK;
}

fmiStatus fmi1_me_get_integer(fmiComponent c, const fmiValueReference vr[], size_t nvr, fmiInteger value[]) {
    fmiInteger retval;
    
    if (c == NULL) {
		return fmiFatal;
    }

    retval = jmi_get_integer(&((fmi1_me_t *)c)->jmi, vr, nvr, value);
    if (retval != 0) {
        return fmiError;
    }
    
    return fmiOK;
}

fmiStatus fmi1_me_get_boolean(fmiComponent c, const fmiValueReference vr[], size_t nvr, fmiBoolean value[]) {
    fmiInteger retval;
    
    if (c == NULL) {
		return fmiFatal;
    }

    retval = jmi_get_boolean(&((fmi1_me_t *)c)->jmi, vr, nvr, value);
    if (retval != 0) {
        return fmiError;
    }
    
    return fmiOK;
}

fmiStatus fmi1_me_get_string(fmiComponent c, const fmiValueReference vr[], size_t nvr, fmiString  value[]) {
    fmiInteger retval;
    
    if (c == NULL) {
		return fmiFatal;
    }

    retval = jmi_get_string(&((fmi1_me_t *)c)->jmi, vr, nvr, value);
    if (retval != 0) {
        return fmiError;
    }

    return fmiOK;
}

jmi_t* fmi1_me_get_jmi_t(fmiComponent c) {
    return &((fmi1_me_t*)c)->jmi;
}

fmiStatus fmi1_me_event_update(fmiComponent c, fmiBoolean intermediateResults, fmiEventInfo* eventInfo) {
    fmiInteger retval;
    jmi_event_info_t* event_info;
    
    if (c == NULL) {
		return fmiFatal;
    }
    
    event_info = (jmi_event_info_t*)calloc(1, sizeof(jmi_event_info_t));
    
    retval = jmi_event_iteration(&((fmi1_me_t *)c)->jmi, intermediateResults, event_info);
    if (retval != 0) {
        free(event_info);
        return fmiError;
    }
    
    eventInfo->iterationConverged          = event_info->iteration_converged;
    eventInfo->stateValueReferencesChanged = event_info->state_value_references_changed;
    eventInfo->stateValuesChanged          = event_info->state_values_changed;
    eventInfo->terminateSimulation         = event_info->terminate_simulation;
    eventInfo->upcomingTimeEvent           = event_info->next_event_time_defined;
    eventInfo->nextEventTime               = event_info->next_event_time;
    
    free(event_info);
    
    return fmiOK;
}

fmiStatus fmi1_me_get_continuous_states(fmiComponent c, fmiReal states[], size_t nx) {
    if (c == NULL) {
		return fmiFatal;
    }
    
    memcpy (states, jmi_get_real_x(&((fmi1_me_t *)c)->jmi), nx*sizeof(fmiReal));
    return fmiOK;
}

fmiStatus fmi1_me_get_nominal_continuous_states(fmiComponent c, fmiReal x_nominal[], size_t nx) {
    fmiInteger retval;
    
    if (c == NULL) {
		return fmiFatal;
    }
    
    retval = jmi_get_nominal_continuous_states(&((fmi1_me_t *)c)->jmi, x_nominal, nx);
    if (retval != 0) {
        return fmiError;
    }
    
    return fmiOK;
}

fmiStatus fmi1_me_get_state_value_references(fmiComponent c, fmiValueReference vrx[], size_t nx) {
    fmiInteger offset;
    fmiValueReference i;
    
    if (c == NULL) {
		return fmiFatal;
    }
        
    offset = ((fmi1_me_t *)c)->jmi.offs_real_x;
    
    for(i = 0; i<nx; i = i + 1) {
        vrx[i] = offset + i;
    }
    return fmiOK;
}

fmiStatus fmi1_me_terminate(fmiComponent c) {
    /* Release all resources that have been allocated since fmi_initialize has been called. */
    int retval = jmi_update_and_terminate(&((fmi1_me_t *)c)->jmi);
    if (retval != 0) {
        return fmiError;
    }

    return fmiOK;
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

void fmi1_me_emit_log(jmi_callbacks_t* jmi_callbacks, jmi_log_category_t category, jmi_log_category_t severest_category, char* message) {

    fmi1_me_t* c = (fmi1_me_t*)(jmi_callbacks->model_data);
  
    if(c){
        if(c->fmi_functions.logger)
            c->fmi_functions.logger(c,jmi_callbacks->instance_name, 
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

BOOL fmi1_me_is_log_category_emitted(jmi_callbacks_t* cb, jmi_log_category_t category) {

    jmi_callbacks_t* jmi_callbacks = cb;
    fmi1_me_t * self = (fmi1_me_t *)cb->model_data;
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

fmiStatus fmi1_me_extract_debug_info(fmiComponent c) {
    fmiInteger nniters;
/*    fmiReal avg_nniters; */
    fmi1_me_t* fmi1_me = ((fmi1_me_t*)c);
    jmi_t* jmi = &fmi1_me->jmi;
    jmi_block_residual_t* block;
    int i;
    jmi_log_node_t topnode = jmi_log_enter(jmi->log, logInfo, "FMIDebugInfo");
    
    /* Extract debug information from initialization*/
    for (i = 0; i < jmi->n_dae_init_blocks; i++) {
        block = jmi->dae_init_block_residuals[i];
        nniters = block->nb_iters;

        /* Test if block is solved by KINSOL */
        if (nniters > 0) {
            /* Output to logger */
            jmi_log_node_t node = jmi_log_enter(jmi->log, logInfo, "initialization");
            jmi_log_fmt(jmi->log, node, logInfo, "<block: %s, size: %d, nniters: %d, nbcalls: %d, njevals: %d, nfevals: %d>", 
                        block->label, block->n, (int)nniters, (int)block->nb_calls, (int)block->nb_jevals, (int)block->nb_fevals);
            jmi_log_fmt(jmi->log, node, logInfo, "<time_spent: %f>", block->time_spent);
            jmi_log_leave(jmi->log, node);
        }
    }

    /* Extract debug information from DAE blocks */
    for (i = 0; i < jmi->n_dae_blocks; i++) {
        block = jmi->dae_block_residuals[i];
        nniters = block->nb_iters;

        /* Test if block is solved by KINSOL */
        if (nniters > 0) {
            /* Output to logger */
            /* NB: Exactly the same code as above. Todo: factor out? */
            jmi_log_node_t node = jmi_log_enter(jmi->log, logInfo, "dae_blocks");
            jmi_log_fmt(jmi->log, node, logInfo, "<block: %s, size: %d, nniters: %d, nbcalls: %d, njevals: %d, nfevals: %d>", 
                        block->label, block->n, (int)nniters, (int)block->nb_calls, (int)block->nb_jevals, (int)block->nb_fevals);
            jmi_log_fmt(jmi->log, node, logInfo, "<time_spent: %f>", block->time_spent);
            jmi_log_leave(jmi->log, node);            
        }
    }
    /*
        for (i=0; i < jmi->n_dae_blocks;i=i+1){
            jmi_delete_block_residual(jmi->dae_block_residuals[i]);
    }*/

    jmi_log_leave(jmi->log, topnode);

    return fmiOK;
}
