 /*
    Copyright (C) 2019 Modelon AB

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

#ifndef _JMI_EVALUATOR_UTIL_H
#define _JMI_EVALUATOR_UTIL_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "jmi.h"
#include "jmi_dyn_mem.h"
#include "ModelicaUtilities.h"
#include <fcntl.h>

#ifdef _WIN32
    #include <windows.h>
#else
    #define _GNU_SOURCE
    #define __stdcall 
    #include <dlfcn.h>
    #ifdef __APPLE__
        #include <limits.h>
    #else
        #include <linux/limits.h>
        #include <limits.h>
    #endif
#endif

#define ERROR_LOAD_DLL 3
#define ERROR_LOAD_FUNCTION 4
#define ERROR_OUTPUT_ARGS_NOT_SPECIFIED 5
#define ERROR_INPUT_ARGS_NOT_SPECIFIED 6
#define ERROR_NOT_SUPPORTED_INPUT_ARGS 7
#define ERROR_NOT_SUPPORTED_OUTPUT_ARGS 8

#define ERROR_LOAD_DLL_MSG "Error loading the DLL\n"
#define ERROR_LOAD_FUNCTION_MSG "Error loading the function\n"
#define ERROR_OUTPUT_ARGS_NOT_SPECIFIED_MSG "Error, the output arguments are not specified\n"
#define ERROR_INPUT_ARGS_NOT_SPECIFIED_MSG "Error, the input arguments are not specified\n"
#define ERROR_NOT_SUPPORTED_INPUT_ARGS_MSG "Error, the listed input arguments are not supported\n"
#define ERROR_NOT_SUPPORTED_OUTPUT_ARGS_MSG "Error, the listed output arguments are not supported\n"


/* Manual debugging */
#define JMCEVAL_DEBUG 0
#define JMCEVAL_DBGP(x) if (JMCEVAL_DEBUG) { printf(x); fflush(stdout);}

/* Format specifier when printing jmi_real_t */
#define JMCEVAL_realFormat "%.16f"

/* Parses ND dimensions into dimension buffer d*/
#define JMCEVAL_parseArrayDims(ND) \
    for (di = 0; di < ND; di++) { scanf("%d",&d[di]); }

double JMCEVAL_parseReal();
void JMCEVAL_printReal(double x);
char* JMCEVAL_parseString();
void JMCEVAL_printString(const char* str);
void JMCEVAL_setup();
int JMCEVAL_cont(const char* word);
void JMCEVAL_check(const char* str);
void JMCEVAL_failed();
void _jmi_global_log(int warning, const char* name, const char* fmt, const char* value);
void _jmi_throw();
int JMCEVAL_try();
void* _jmi_global_calloc(size_t n, size_t s);
jmi_dynamic_function_memory_t* jmi_dynamic_function_memory();
void _jmi_dynamic_function_pool_destroy();

#define JMCEVAL_parseInteger()  JMCEVAL_parseReal()
#define JMCEVAL_parseBoolean()  JMCEVAL_parseInteger()
#define JMCEVAL_parseEnum()     JMCEVAL_parseInteger()
#define JMCEVAL_printInteger(X) JMCEVAL_printReal(X)
#define JMCEVAL_printBoolean(X) JMCEVAL_printInteger(X)
#define JMCEVAL_printEnum(X)    JMCEVAL_printInteger(X)
#define JMCEVAL_parse(TYPE, X)  X = JMCEVAL_parse##TYPE()
#define JMCEVAL_print(TYPE, X)  JMCEVAL_print##TYPE(X)

/* Parse/print arrays */
#define JMCEVAL_parseArray(TYPE,ARR) for (vi = 1; vi <= ARR->num_elems; vi++) { JMCEVAL_parse(TYPE, jmi_array_ref_1(ARR,vi)); }
#define JMCEVAL_printArray(TYPE,ARR) for (vi = 1; vi <= ARR->num_elems; vi++) { JMCEVAL_print(TYPE, jmi_array_val_1(ARR,vi)); }

#endif /* _JMI_EVALUATOR_UTIL_H */
