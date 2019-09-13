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

/* Builtins */
extern const char* ModelicaStrings_substring(const char*, int, int);
extern const char* ModelicaStrings_length(const char*);
extern const char* ModelicaStrings_skipWhiteSpace(const char*, int);

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

/* Record definitions */
typedef struct R_ddddddddddd_ R_ddddddddddd;
struct R_ddddddddddd_ {
    double member_0;
    double member_1;
    double member_2;
    double member_3;
    double member_4;
    double member_5;
    double member_6;
    double member_7;
    double member_8;
    double member_9;
    double member_10;
};
JMI_ARRAY_TYPE(R_ddddddddddd, R_ddddddddddd_a)


/* Parses ND dimensions into dimension buffer d*/
#define JMCEVAL_parseArrayDims(ND) \
    for (di = 0; di < ND; di++) { scanf("%d",&d[di]); }

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

/* Used by ModelicaUtilities */
void jmi_global_log(int warning, const char* name, const char* fmt, const char* value)
{
    printf("LOG\n");
    JMCEVAL_printInteger((double)warning);
    JMCEVAL_printString(name);
    JMCEVAL_printString(fmt);
    JMCEVAL_printString(value);
}

jmp_buf jmceval_try_location;

#define JMCEVAL_try() (setjmp(jmceval_try_location) == 0)

void jmi_throw()
{
    longjmp(jmceval_try_location, 1);
}

jmi_dynamic_function_memory_t* dyn_fcn_mem = NULL;

jmi_dynamic_function_memory_t* jmi_dynamic_function_memory() {
    if (dyn_fcn_mem == NULL) { dyn_fcn_mem = jmi_dynamic_function_pool_create(1024*1024); }
    return dyn_fcn_mem;
}

void* jmi_global_calloc(size_t n, size_t s)
{
    return jmi_dynamic_function_pool_direct_alloc(dyn_fcn_mem, n*s, 1);
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

typedef const char* (__stdcall *f_s_sii)(const char*, int, int);
typedef double (__stdcall *f_d_dd)(double, double);
typedef double (__stdcall *f_d_i)(int);
typedef double(__stdcall *f_d_idd)(int, double, double);
typedef int (__stdcall *f_i_ii)(int, int);
typedef int (__stdcall *f_i_s)(const char*);
typedef int (__stdcall *f_i_si)(const char*, int);
typedef void(__stdcall *f___iddpR_ddddddddddd_)(int, double, double, R_ddddddddddd**);
typedef void(__stdcall *f___ddpd)(double, double, double*);
typedef void (*generic_funcptr)(void);

void jmi_call_void_fcn_ddpd(generic_funcptr fcn) { 
    JMI_DEF(REA, arg_0)
    JMI_DEF(REA, arg_1)
    JMI_DEF(REA, arg_2)

    JMCEVAL_parse(Real, arg_0);
    JMCEVAL_parse(Real, arg_1);
    JMCEVAL_parse(Real, arg_2);
    
    JMCEVAL_check("CALC");
    if (JMCEVAL_try()) {
        /* Calc phase */
        ((f___ddpd)fcn)(arg_0, arg_1, &arg_2);

        JMCEVAL_check("DONE");
        JMCEVAL_print(Real, arg_2);
    }
    else {
        JMCEVAL_failed();
    }
}

void jmi_call_void_fcn_iddpR_ddddddddddd_(generic_funcptr fcn) {
    JMI_DEF(INT, arg_0)
    JMI_DEF(INT_EXT, tmp_0)    
    JMI_DEF(REA, arg_1)
    JMI_DEF(REA, arg_2)
    JMI_RECORD_STATIC(R_ddddddddddd, arg_3)

    JMCEVAL_parse(Integer, arg_0);
    JMCEVAL_parse(Real, arg_1);
    JMCEVAL_parse(Real, arg_2);
    JMCEVAL_parse(Real, arg_3->member_0);
    JMCEVAL_parse(Real, arg_3->member_1);
    JMCEVAL_parse(Real, arg_3->member_2);
    JMCEVAL_parse(Real, arg_3->member_3);
    JMCEVAL_parse(Real, arg_3->member_4);
    JMCEVAL_parse(Real, arg_3->member_5);
    JMCEVAL_parse(Real, arg_3->member_6);
    JMCEVAL_parse(Real, arg_3->member_7);
    JMCEVAL_parse(Real, arg_3->member_8);
    JMCEVAL_parse(Real, arg_3->member_9);
    JMCEVAL_parse(Real, arg_3->member_10);

    JMCEVAL_check("CALC");
    if (JMCEVAL_try()) {
        /* Calc phase */
        tmp_0 = (int)arg_0;
        ((f___iddpR_ddddddddddd_)fcn)(tmp_0, arg_1, arg_2, arg_3);


        JMCEVAL_check("DONE");
        JMCEVAL_print(Real, arg_3->member_0);
        JMCEVAL_print(Real, arg_3->member_1);
        JMCEVAL_print(Real, arg_3->member_2);
        JMCEVAL_print(Real, arg_3->member_3);
        JMCEVAL_print(Real, arg_3->member_4);
        JMCEVAL_print(Real, arg_3->member_5);
        JMCEVAL_print(Real, arg_3->member_6);
        JMCEVAL_print(Real, arg_3->member_7);
        JMCEVAL_print(Real, arg_3->member_8);
        JMCEVAL_print(Real, arg_3->member_9);
        JMCEVAL_print(Real, arg_3->member_10);
    }
    else {
        JMCEVAL_failed();
    }
}

void jmi_call_double_fcn_dd(generic_funcptr fcn, double *out) {
    JMI_DEF(REA, arg_0)
    JMI_DEF(REA, arg_1)

    JMCEVAL_parse(Real, arg_0);
    JMCEVAL_parse(Real, arg_1);

    JMCEVAL_check("CALC");
    if (JMCEVAL_try()) {
        /* Calc phase */
        *out = ((f_d_dd)fcn)(arg_0, arg_1);
    } else {
        JMCEVAL_failed();
    }
}

void jmi_call_double_fcn_i(generic_funcptr fcn, double *out) {
    JMI_DEF(INT, arg_0)
    JMI_DEF(INT_EXT, tmp_1)

    JMCEVAL_parse(Integer, arg_0);

    JMCEVAL_check("CALC");
    if (JMCEVAL_try()) {
        /* Calc phase */
        tmp_1 = (int)arg_0;
        *out = ((f_d_i)fcn)(tmp_1);
    } else {
        JMCEVAL_failed();
    }
}

void jmi_call_double_fcn_idd(generic_funcptr fcn, double *out) {
    JMI_DEF(INT, arg_0)
    JMI_DEF(INT_EXT, tmp_0)
    JMI_DEF(REA, arg_1)
    JMI_DEF(REA, arg_2)

    JMCEVAL_parse(Integer, arg_0);
    JMCEVAL_parse(Real, arg_1);
    JMCEVAL_parse(Real, arg_2);

    JMCEVAL_check("CALC");
    if (JMCEVAL_try()) {
        /* Calc phase */
        tmp_0 = (int)arg_0;
        *out = ((f_d_idd)fcn)(tmp_0, arg_1, arg_2);
    }
    else {
        JMCEVAL_failed();
    }
}

void jmi_call_double_fcn(generic_funcptr fcn, const char* inputs) {
    JMI_DEF(REA, d_output)
    JMCEVAL_parse(Real, d_output);

    if (strcmp(inputs, "d,d,") == 0) {
        jmi_call_double_fcn_dd(fcn, &d_output);
    } else if (strcmp(inputs, "i,") == 0) {
        jmi_call_double_fcn_i(fcn, &d_output);
    } else if (strcmp(inputs, "i,d,d,") == 0) {
        jmi_call_double_fcn_idd(fcn, &d_output);
    } else {
        printf(ERROR_NOT_SUPPORTED_INPUT_ARGS_MSG);
        exit(ERROR_NOT_SUPPORTED_INPUT_ARGS);
    }

    JMCEVAL_check("DONE");
    JMCEVAL_print(Real, d_output);
}

void jmi_call_integer_fcn_s(generic_funcptr fcn, double *out) {
    JMI_DEF(STR, arg_0)

    JMCEVAL_parse(String, arg_0);

    JMCEVAL_check("CALC");
    if (JMCEVAL_try()) {
        /* Calc phase */
        *out = ((f_i_s)fcn)(arg_0);
    }
    else {
        JMCEVAL_failed();
    }
}

void jmi_call_integer_fcn_si(generic_funcptr fcn, double *out) {
    JMI_DEF(STR, arg_0)
    JMI_DEF(INT, arg_1)
    JMI_DEF(INT_EXT, tmp_1)

    JMCEVAL_parse(String, arg_0);
    JMCEVAL_parse(Integer, arg_1);

    JMCEVAL_check("CALC");
    if (JMCEVAL_try()) {
        /* Calc phase */
        tmp_1 = (int)arg_1;
        *out = ((f_i_si)fcn)(arg_0, tmp_1);
    }
    else {
        JMCEVAL_failed();
    }
}

void jmi_call_integer_fcn(generic_funcptr fcn, const char* inputs) {
    JMI_DEF(INT, i_output)
    JMCEVAL_parse(Integer, i_output);

    if (strcmp(inputs, "s,") == 0) {
        jmi_call_integer_fcn_s(fcn, &i_output);
    } else if (strcmp(inputs, "s,i,") == 0) {
        jmi_call_integer_fcn_si(fcn, &i_output);
    } else {
        printf(ERROR_NOT_SUPPORTED_INPUT_ARGS_MSG);
        exit(ERROR_NOT_SUPPORTED_INPUT_ARGS);
    }

    JMCEVAL_check("DONE");
    JMCEVAL_print(Integer, i_output);
}

void jmi_call_string_fcn_sii(generic_funcptr fcn, char **out) {
    JMI_DEF(STR, arg_0)
    JMI_DEF(INT, arg_1)
    JMI_DEF(INT, arg_2)
    JMI_DEF(INT_EXT, tmp_1)
    JMI_DEF(INT_EXT, tmp_2)

    JMCEVAL_parse(String, arg_0);
    JMCEVAL_parse(Integer, arg_1);
    JMCEVAL_parse(Integer, arg_2);

    JMCEVAL_check("CALC");
    if (JMCEVAL_try()) {
        /* Calc phase */
        tmp_1 = (int)arg_1;
        tmp_2 = (int)arg_2;
        *out = ((f_s_sii)fcn)(arg_0, tmp_1, tmp_2);
    } else {
        JMCEVAL_failed();
    }
}

void jmi_call_string_fcn(generic_funcptr fcn, const char* inputs) {
    JMI_DEF(STR, s_output)
    JMCEVAL_parse(String, s_output);

    if (strcmp(inputs, "s,i,i,") == 0) {
        jmi_call_string_fcn_sii(fcn, &s_output);
    } else {
        printf(ERROR_NOT_SUPPORTED_INPUT_ARGS_MSG);
        exit(ERROR_NOT_SUPPORTED_INPUT_ARGS);
    }

    JMCEVAL_check("DONE");
    JMCEVAL_print(String, s_output);
}

void jmi_call_void_fcn(generic_funcptr fcn, const char* inputs) {

    if (strcmp(inputs, "i,d,d,*R[d,d,d,d,d,d,d,d,d,d,d,],") == 0) {
        jmi_call_void_fcn_iddpR_ddddddddddd_(fcn);
    } else if (strcmp(inputs, "d,d,*d,") == 0) {
        jmi_call_void_fcn_ddpd(fcn);
    } else {
        printf(ERROR_NOT_SUPPORTED_INPUT_ARGS_MSG);
        exit(ERROR_NOT_SUPPORTED_INPUT_ARGS);
    }
}

/* Main */
int main(int argc, const char* argv[])
{
    /* Size buffer for reading array dimensions */
    int d[25];
    
    /* Indices for parsing/printing vars, dimensions */
    size_t vi,di;

    /* Function ptr that holds the specific function */
    generic_funcptr funci = NULL;

    const char *output_args = NULL;
    const char *input_args = NULL;

    /* Builtins */
    if (strcmp(argv[2], "ModelicaStrings_substring") == 0) {
        funci = (generic_funcptr)ModelicaStrings_substring;
    } else if (strcmp(argv[2], "ModelicaStrings_length") == 0) {
        funci = (generic_funcptr)ModelicaStrings_length;
    } else if (strcmp(argv[2], "ModelicaStrings_skipWhiteSpace") == 0) {
        funci = (generic_funcptr)ModelicaStrings_skipWhiteSpace;
    }

    if (funci == NULL) {
        #ifdef _WIN32
            HINSTANCE dll = LoadLibrary(argv[1]);
        
            if (!dll) {
                DWORD error_code = GetLastError();
                printf(ERROR_LOAD_DLL_MSG);
                printf("error code: %d\n", error_code);
                exit(ERROR_LOAD_DLL);
            }

            funci = (generic_funcptr)GetProcAddress(dll, argv[2]);
            if (!funci) {
                printf(ERROR_LOAD_FUNCTION_MSG);
                exit(ERROR_LOAD_FUNCTION);
            }
        #else
            void *so = dlopen(argv[1], RTLD_LOCAL | RTLD_LAZY);
            
            if (!so) {
                printf(ERROR_LOAD_DLL_MSG);
                exit(ERROR_LOAD_DLL);
            }
            
            funci = (generic_funcptr)dlsym(so, argv[2]);
            if (!funci) {
                printf(ERROR_LOAD_FUNCTION_MSG);
                exit(ERROR_LOAD_FUNCTION);
            }
        #endif
    }

    output_args = argv[3];
    if (output_args == NULL) { 
        printf(ERROR_OUTPUT_ARGS_NOT_SPECIFIED_MSG);
        exit(ERROR_OUTPUT_ARGS_NOT_SPECIFIED); 
    }

    input_args  = argv[4];
    if (input_args == NULL) { 
        printf(ERROR_INPUT_ARGS_NOT_SPECIFIED_MSG);
        exit(ERROR_INPUT_ARGS_NOT_SPECIFIED); 
    }

    JMCEVAL_setup(); /* This needs to happen first */

    JMCEVAL_check("START");
    if (JMCEVAL_try()) {
        JMI_DYNAMIC_INIT()
        /* Init phase */

        JMI_DYNAMIC_FREE()
    } else {
        JMCEVAL_failed();
    }
    
    JMCEVAL_check("READY");
    while (JMCEVAL_cont("EVAL\n")) {
        JMI_DYNAMIC_INIT()

        if (strcmp(output_args, "d") == 0) {
            jmi_call_double_fcn(funci, input_args);
        } else if (strcmp(output_args, "s") == 0) {
            jmi_call_string_fcn(funci, input_args);
        } else if (strcmp(output_args, "i") == 0) {
            jmi_call_integer_fcn(funci, input_args);
        } else if (strcmp(output_args, "void") == 0) {
            jmi_call_void_fcn(funci, input_args);
        } else {
            printf(ERROR_NOT_SUPPORTED_OUTPUT_ARGS_MSG);
            exit(ERROR_NOT_SUPPORTED_OUTPUT_ARGS);
        }

        JMI_DYNAMIC_FREE()
        JMCEVAL_check("READY");
    }

    if (JMCEVAL_try()) {
        /* End phase */


    } else {
        JMCEVAL_failed();
    }
    jmi_dynamic_function_pool_destroy(dyn_fcn_mem);
    JMCEVAL_check("END");
    return 0;
}

