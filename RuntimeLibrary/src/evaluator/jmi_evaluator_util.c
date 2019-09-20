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

#include "jmi_evaluator_util.h"

/* Parse/print basic types */
double JMCEVAL_parseReal() {
    /* Char buffer when reading jmi_real_t. This is necessary
       since "%lf" is not allowed in c89. */
    char buff[32];
    JMCEVAL_DBGP("Parse number: "); 
    scanf("%s",buff);
    return strtod(buff, 0);
}

void JMCEVAL_printReal(double x) {
    printf(JMCEVAL_realFormat, x); \
    printf("\n"); \
    fflush(stdout); \
}

char* JMCEVAL_parseString() {
    int d[1];
    char* str;
    size_t si,di;
    JMCEVAL_parseArrayDims(1);
    getchar();
    str = ModelicaAllocateString(d[0]);
    JMCEVAL_DBGP("Parse string: ");
    for (si = 0; si < d[0]; si++) str[si] = getchar();
    str[d[0]] = '\0';
    return str;
}

void JMCEVAL_printString(const char* str) {
    printf("%u\n%s\n", (unsigned)strlen(str), str);
    fflush(stdout);
}

void JMCEVAL_setup() {
#ifdef _WIN32
    /* Prevent win from translating \n to \r\n */
    _setmode(fileno(stdout), _O_BINARY);
#endif
}

int JMCEVAL_cont(const char* word) {
    char l[10];
    char* s = fgets(l, 10, stdin);
    if (strlen(s) == 1) {
        s = fgets(l, 10, stdin); /* Extra call to fix stray newline */
    }
    if (s == NULL) {
        exit(2);
    }
    if (strlen(s) == strlen(word)) {
        return strncmp(l, word, strlen(word)) == 0;
    }
    return 0;
}

void JMCEVAL_check(const char* str) {
    printf("%s\n",str);
    fflush(stdout);
}

void JMCEVAL_failed() {
    JMCEVAL_check("ABORT");
}

void _jmi_global_log(int warning, const char* name, const char* fmt, const char* value) {
    printf("LOG\n");
    JMCEVAL_printInteger((double)warning);
    JMCEVAL_printString(name);
    JMCEVAL_printString(fmt);
    JMCEVAL_printString(value);
}

jmp_buf jmceval_try_location;

int JMCEVAL_try() {
    return setjmp(jmceval_try_location) == 0;
}

void _jmi_throw() {
    longjmp(jmceval_try_location, 1);
}

jmi_dynamic_function_memory_t* dyn_fcn_mem = NULL;

jmi_dynamic_function_memory_t* jmi_dynamic_function_memory() {
    if (dyn_fcn_mem == NULL) { dyn_fcn_mem = jmi_dynamic_function_pool_create(1024*1024); }
    return dyn_fcn_mem;
}

void* _jmi_global_calloc(size_t n, size_t s) {
    return jmi_dynamic_function_pool_direct_alloc(dyn_fcn_mem, n*s, 1);
}
