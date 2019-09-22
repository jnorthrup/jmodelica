#include "jmi_evaluator_util.h"

/* Must be defined here in order to override the methods from jmi_global.c */
void jmi_global_log(int warning, const char* name, const char* fmt, const char* value) {
    _jmi_global_log(warning, name, fmt, value);
}
void jmi_throw() {
    _jmi_throw();
}
void* jmi_global_calloc(size_t n, size_t s) {
    return _jmi_global_calloc(n,s);
}

/* Builtins */
extern const char* ModelicaStrings_substring(const char*, int, int);
extern int ModelicaStrings_length(const char*);
extern int ModelicaStrings_skipWhiteSpace(const char*, int);
extern int ModelicaStrings_compare(const char*, const char*, int);

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

#define JMI_EVAL_CALLING_CONVENTION

typedef const char* (JMI_EVAL_CALLING_CONVENTION *f_s_sii)(const char*, int, int);
typedef double (JMI_EVAL_CALLING_CONVENTION *f_d_dd)(double, double);
typedef double (JMI_EVAL_CALLING_CONVENTION *f_d_i)(int);
typedef double(JMI_EVAL_CALLING_CONVENTION *f_d_idd)(int, double, double);
typedef int (JMI_EVAL_CALLING_CONVENTION *f_i_ii)(int, int);
typedef int (JMI_EVAL_CALLING_CONVENTION *f_i_s)(const char*);
typedef int (JMI_EVAL_CALLING_CONVENTION *f_i_si)(const char*, int);
typedef int (JMI_EVAL_CALLING_CONVENTION *f_i_ssi)(const char*, const char*, int);
typedef void(JMI_EVAL_CALLING_CONVENTION *f___iddpR_ddddddddddd_)(int, double, double, R_ddddddddddd**);
typedef void(JMI_EVAL_CALLING_CONVENTION *f___ddpd)(double, double, double*);
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

void jmi_call_integer_fcn_s(generic_funcptr fcn, int *out) {
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

void jmi_call_integer_fcn_si(generic_funcptr fcn, int *out) {
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

void jmi_call_integer_fcn_ssi(generic_funcptr fcn, int *out) {
    JMI_DEF(STR, arg_0)
    JMI_DEF(STR, arg_1)
    JMI_DEF(INT, arg_2)
    JMI_DEF(INT_EXT, tmp_2)

    JMCEVAL_parse(String, arg_0);
    JMCEVAL_parse(String, arg_1);
    JMCEVAL_parse(Integer, arg_2);

    JMCEVAL_check("CALC");
    if (JMCEVAL_try()) {
        /* Calc phase */
        tmp_2 = (int)arg_2;
        *out = ((f_i_ssi)fcn)(arg_0, arg_1, tmp_2);
    }
    else {
        JMCEVAL_failed();
    }
}

void jmi_call_integer_fcn(generic_funcptr fcn, const char* inputs) {
    JMI_DEF(INT, i_output)
    JMI_DEF(INT_EXT, tmp_output)
    JMCEVAL_parse(Integer, i_output);
    
    tmp_output = (int)i_output;

    if (strcmp(inputs, "s,") == 0) {
        jmi_call_integer_fcn_s(fcn, &tmp_output);
    } else if (strcmp(inputs, "s,i,") == 0) {
        jmi_call_integer_fcn_si(fcn, &tmp_output);
    } else if (strcmp(inputs, "s,s,i,") == 0) {
        jmi_call_integer_fcn_ssi(fcn, &tmp_output);
    } else {
        printf(ERROR_NOT_SUPPORTED_INPUT_ARGS_MSG);
        exit(ERROR_NOT_SUPPORTED_INPUT_ARGS);
    }
    
    i_output = (double)tmp_output;

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
    } else if (strcmp(argv[2], "ModelicaStrings_compare") == 0) {
        funci = (generic_funcptr)ModelicaStrings_compare;
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
    JMCEVAL_check("END");
    return 0;
}

