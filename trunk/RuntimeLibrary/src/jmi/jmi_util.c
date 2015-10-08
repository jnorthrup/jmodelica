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

#include <stdarg.h>
#ifdef _WIN32
    #include <win32_dirent.h>
#else
    #include <dirent.h>
#endif
#include "jmi.h"
#include "jmi_log.h"
#include "jmi_global.h"
#include <stdio.h>
#include <assert.h>

void jmi_min_time_event(jmi_time_event_t* event, int def, int phase, jmi_ad_var_t time) {
    if (JMI_TRUE == LOG_EXP_OR(LOG_EXP_OR(LOG_EXP_NOT(AD_WRAP_LITERAL(event->defined)), SURELY_GT_ZERO(event->time - time)), LOG_EXP_AND(ALMOST_ZERO(event->time - time), SURELY_GT_ZERO(event->phase - phase)))) {
        event->defined = def;
        event->phase = phase;
        event->time = time;
    }
}

void jmi_internal_error(jmi_t *jmi, const char msg[]) {
    jmi_log_node(jmi->log, logError, "Error", "Internal error <msg:%s>", msg);
    jmi_throw();
    jmi_log_node(jmi->log, logError, "Error", "Could not throw an exception after internal error", msg);
}

/* Helper function for logging warnings from the "_equation"- and "_function"-functions below */
void static jmi_log_func_or_eq(jmi_t *jmi, const char cathegory_name[], const char func_name[], const char msg[], const char val[]) {
    if (func_name != NULL) {
        char buf[64];
        sprintf(buf, "%s%s", cathegory_name, "InFunc");
        jmi_log_node(jmi->log, logWarning, buf, "<func: %s, exp: %s, val:%s>", func_name, msg, val);
    } else {
        jmi_log_node(jmi->log, logWarning, cathegory_name, "<exp:%s, val: %s>", msg, val);
    }
}

int jmi_check_nan(jmi_t *jmi, jmi_real_t* val, size_t n_val, jmi_int_t* index_of_nan) {
    int i = 0;
    for (i = 0; i < n_val; i++) {
        if ( val[i] - val[i] != 0) {
            *index_of_nan = i;
            return JMI_ERROR;
        }
    }
    return JMI_OK;
}

void jmi_inf_log(jmi_t *jmi, const char func_name[], const char msg[], jmi_real_t res, jmi_real_t x) {
    if (((res - res) != 0)) {
        if (jmi == NULL) jmi = jmi_get_current();
        
        if (res > 0) {
            /* res is +inf */
            char val[64];
            sprintf(val, "%.14E", x);
            jmi_log_func_or_eq(jmi, "RangeError", func_name, msg, val);
        } else if (res < 0){
            /* res is -inf */
            char val[64];
            sprintf(val, "%.14E", x);
            jmi_log_func_or_eq(jmi, "RangeError", func_name, msg, val);
        }
    }
}

/*Some of these functions return types are a temporary remnant of CppAD*/
jmi_ad_var_t static jmi_divide(jmi_t *jmi, const char func_name[], jmi_ad_var_t num, jmi_ad_var_t den, const char msg[]) {
    if (den == 0) {
        char val[64];
        sprintf(val, "%.14E, %.14E", num, den);
        
        if (jmi == NULL) jmi = jmi_get_current();
        jmi_log_func_or_eq(jmi, "DivideByZero", func_name, msg, val);
    }
    
    return num/den;
}

jmi_ad_var_t jmi_divide_function(const char func_name[], jmi_ad_var_t num, jmi_ad_var_t den, const char msg[]) {
    return jmi_divide(NULL, func_name, num, den, msg);
}

jmi_ad_var_t jmi_divide_equation(jmi_t *jmi, jmi_ad_var_t num, jmi_ad_var_t den, const char msg[]) {
    return jmi_divide(jmi, NULL, num, den, msg);
}

jmi_ad_var_t static jmi_pow(jmi_t *jmi, const char func_name[], jmi_ad_var_t x, jmi_ad_var_t y, const char msg[]) {

    jmi_ad_var_t to_return = pow(x, y);
    
    if ((to_return - to_return) != 0) {
        /* The returned value is not a number */
        if (jmi == NULL) jmi = jmi_get_current();
    
        /* Check that the inputs are in the domain of the function*/
        if (x > 0 || (x == 0 && y > 0) || (x < 0 && (int)y == y)) {
            /* Range problem, will return JMI_INF or -JMI_INF */
            char val[64];
            sprintf(val, "%.14E, %.14E", x, y);
            jmi_log_func_or_eq(jmi, "RangeError", func_name, msg, val);
        } else if (x == 0 && y < 0) {
            /* Pole error */
            char val[64];
            sprintf(val, "%.14E, %.14E", x, y);
            jmi_log_func_or_eq(jmi, "DivideByZero", func_name, msg, val);
        }
    }
    /* jmi_inf_log(jmi, func_name, msg, to_return); */
    return to_return;
}

jmi_ad_var_t jmi_pow_function(const char func_name[], jmi_ad_var_t x, jmi_ad_var_t y, const char msg[]) {
    return jmi_pow(NULL, func_name, x, y, msg);
}

jmi_ad_var_t jmi_pow_equation(jmi_t *jmi, jmi_ad_var_t x, jmi_ad_var_t y, const char msg[]) {
    return jmi_pow(jmi, NULL, x, y, msg);
}

jmi_ad_var_t static jmi_exp(jmi_t *jmi, const char func_name[], jmi_ad_var_t x, const char msg[]) {

    jmi_ad_var_t to_return = exp(x);
    jmi_inf_log(jmi, func_name, msg, to_return, x);
    return to_return;
}

jmi_ad_var_t jmi_exp_function(const char func_name[], jmi_ad_var_t x, const char msg[]) {
    return jmi_exp(NULL, func_name, x, msg);
}

jmi_ad_var_t jmi_exp_equation(jmi_t *jmi, jmi_ad_var_t x, const char msg[]) {
    return jmi_exp(jmi, NULL, x, msg);
}

jmi_ad_var_t static jmi_log(jmi_t *jmi, const char func_name[], jmi_ad_var_t x, const char msg[]) {

    jmi_ad_var_t to_return = log(x);
    
    if ((to_return - to_return) != 0) {
        /* The returned value is not a number */
        if (jmi == NULL) jmi = jmi_get_current();
        
        if (x == 0) {
            /* Pole problem, will return -JMI_INF */
            char val[64];
            sprintf(val, "%.14E", x);
            jmi_log_func_or_eq(jmi, "LogarithmOfZero", func_name, msg, val);
        } else if (x > 0) {
            /* Range problem, will return JMI_INF */
            char val[64];
            sprintf(val, "%.14E", x);
            jmi_log_func_or_eq(jmi, "LogarithmOfInf", func_name, msg, val);
        }
    }
    return to_return;
}

jmi_ad_var_t jmi_log_function(const char func_name[], jmi_ad_var_t x, const char msg[]) {
    return jmi_log(NULL, func_name, x, msg);
}

jmi_ad_var_t jmi_log_equation(jmi_t *jmi, jmi_ad_var_t x, const char msg[]) {
    return jmi_log(jmi, NULL, x, msg);
}

jmi_ad_var_t static jmi_log10(jmi_t *jmi, const char func_name[], jmi_ad_var_t x, const char msg[]) {

    jmi_ad_var_t to_return = log10(x);
    
    if ((to_return - to_return) != 0) {
        /* The returned value is not a number */
        if (jmi == NULL) jmi = jmi_get_current();
        
        if (x == 0) {
            /* Pole problem, will return -JMI_INF */
            char val[64];
            sprintf(val, "%.14E", x);
            jmi_log_func_or_eq(jmi, "LogarithmOfZero", func_name, msg, val);
        } else if (x > 0) {
            /* Infinity problem, will return JMI_INF */
            char val[64];
            sprintf(val, "%.14E", x);
            jmi_log_func_or_eq(jmi, "LogarithmOfInf", func_name, msg, val);
        }
    }
    return to_return;
}

jmi_ad_var_t jmi_log10_function(const char func_name[], jmi_ad_var_t x, const char msg[]) {
    return jmi_log10(NULL, func_name, x, msg);
}

jmi_ad_var_t jmi_log10_equation(jmi_t *jmi, jmi_ad_var_t x, const char msg[]) {
    return jmi_log10(jmi, NULL, x, msg);
}

jmi_ad_var_t static jmi_sinh(jmi_t *jmi, const char func_name[], jmi_ad_var_t x, const char msg[]) {

    jmi_ad_var_t to_return = sinh(x);
    jmi_inf_log(jmi, func_name, msg, to_return, x);
    return to_return;
}

jmi_ad_var_t jmi_sinh_function(const char func_name[], jmi_ad_var_t x, const char msg[]) {
    return jmi_sinh(NULL, func_name, x, msg);
}

jmi_ad_var_t jmi_sinh_equation(jmi_t *jmi, jmi_ad_var_t x, const char msg[]) {
    return jmi_sinh(jmi, NULL, x, msg);
}

jmi_ad_var_t static jmi_cosh(jmi_t *jmi, const char func_name[], jmi_ad_var_t x, const char msg[]) {

    jmi_ad_var_t to_return = cosh(x);
    jmi_inf_log(jmi, func_name, msg, to_return, x);
    return to_return;
}

jmi_ad_var_t jmi_cosh_function(const char func_name[], jmi_ad_var_t x, const char msg[]) {
    return jmi_cosh(NULL, func_name, x, msg);
}

jmi_ad_var_t jmi_cosh_equation(jmi_t *jmi, jmi_ad_var_t x, const char msg[]) {
    return jmi_cosh(jmi, NULL, x, msg);
}

jmi_ad_var_t static jmi_tan(jmi_t *jmi, const char func_name[], jmi_ad_var_t x, const char msg[]) {

    jmi_ad_var_t to_return = tan(x);
    jmi_inf_log(jmi, func_name, msg, to_return, x);
    return to_return;
}

jmi_ad_var_t jmi_tan_function(const char func_name[], jmi_ad_var_t x, const char msg[]) {
    return jmi_tan(NULL, func_name, x, msg);
}

jmi_ad_var_t jmi_tan_equation(jmi_t *jmi, jmi_ad_var_t x, const char msg[]) {
    return jmi_tan(jmi, NULL, x, msg);
}

void jmi_flag_termination(jmi_t *jmi, const char* msg) {
    jmi->model_terminate = 1;
    /* TODO: This is an informative message, not a warning, but is rather important. Change once log level is made separate from message category. */
    jmi_log_node(jmi->log, logWarning, "SimulationTerminated", "<msg:%s>", msg);
}

jmi_ad_var_t jmi_abs(jmi_ad_var_t v) {
    return COND_EXP_GE(v, AD_WRAP_LITERAL(0), v, -v);
}

jmi_ad_var_t jmi_sign(jmi_ad_var_t v) {
    return COND_EXP_GT(v, AD_WRAP_LITERAL(0), AD_WRAP_LITERAL(1), 
        COND_EXP_LT(v, AD_WRAP_LITERAL(0), AD_WRAP_LITERAL(-1), AD_WRAP_LITERAL(0)));
}

jmi_ad_var_t jmi_min(jmi_ad_var_t x, jmi_ad_var_t y) {
    return COND_EXP_LT(x, y, x ,y);
}

jmi_ad_var_t jmi_max(jmi_ad_var_t x, jmi_ad_var_t y) {
    return COND_EXP_GT(x, y, x ,y);
}

jmi_real_t jmi_dround(jmi_real_t x) {
        return (x >= 0)? floor(x + 0.5) : floor(x - 0.5);
}

jmi_real_t jmi_dremainder(jmi_real_t x, jmi_real_t y) {
        jmi_real_t res = fmod(x,y);
        return (jmi_abs(res-y)<JMI_ALMOST_EPS)? res-y : res;
}


int jmi_func_new(jmi_func_t** jmi_func, jmi_residual_func_t F, int n_eq_F, jmi_jacobian_func_t sym_dF,
        int sym_dF_n_nz, int* sym_dF_row, int* sym_dF_col,jmi_directional_der_residual_func_t cad_dir_dF,
        int cad_dF_n_nz, int* cad_dF_row, int* cad_dF_col) {

    int i;
    /*jmi_color_info* c_i_temp;*/
    
    jmi_func_t* func = (jmi_func_t*)calloc(1,sizeof(jmi_func_t));
    *jmi_func = func;

    func->n_eq_F = n_eq_F;
    func->F = F;
    func->sym_dF = sym_dF;
    func->cad_dir_dF = cad_dir_dF;

    func->sym_dF_n_nz = sym_dF_n_nz;
    func->sym_dF_row = (int*)calloc(sym_dF_n_nz,sizeof(int));
    func->sym_dF_col = (int*)calloc(sym_dF_n_nz,sizeof(int));

    for (i=0;i<sym_dF_n_nz;i++) {
        func->sym_dF_row[i] = sym_dF_row[i];
        func->sym_dF_col[i] = sym_dF_col[i];
    }

    func->cad_dF_n_nz = cad_dF_n_nz;
    func->cad_dF_row = (int*)calloc(cad_dF_n_nz,sizeof(int));
    func->cad_dF_col = (int*)calloc(cad_dF_n_nz,sizeof(int));

    for (i=0;i<cad_dF_n_nz;i++) {
        func->cad_dF_row[i] = cad_dF_row[i];
        func->cad_dF_col[i] = cad_dF_col[i];
        /* printf("* %d %d \n",func->cad_dF_row[i], func->cad_dF_col[i]);*/
    }
    
    func->coloring_counter = 0;
    func->coloring_done = (int*)calloc(64, sizeof(int));
    func->c_info = (jmi_color_info**)calloc(64, sizeof(jmi_color_info*));
    
    for(i = 0; i < 64; i++){
        func->coloring_done[i] = 0;
        func->c_info[i] = (jmi_color_info*)malloc(sizeof(jmi_color_info));
    }

    return 0;
}

int jmi_func_delete(jmi_func_t *func) {
    int i;
    int flag = 0;

    free(func->sym_dF_row);
    free(func->sym_dF_col);
    free(func->cad_dF_row);
    free(func->cad_dF_col);
    for(i = 0; i < 64; i++){
        if(func->coloring_done[i] == 1){
            flag = jmi_delete_color_info(func->c_info[i]);
        }
        free(func->c_info[i]);
    }
    free(func->c_info);
    free(func->coloring_done);
    free(func);
    return flag;
}

/* Convenience function to evaluate the Jacobian of the function contained in a
 jmi_func_t. */
int jmi_func_sym_dF(jmi_t *jmi,jmi_func_t *func, int sparsity,
        int independent_vars, int* mask, jmi_real_t* jac) {
    int return_status;
    int depth;

    if (func->sym_dF==NULL) {
        return -1;
    }
    depth = jmi_prepare_try(jmi);
    if (jmi_try(jmi,depth))
        return_status = -1;
    else
        return_status = func->sym_dF(jmi, sparsity, independent_vars, mask, jac);
    jmi_finalize_try(jmi, depth);
    return return_status;

}

/* Convenience function for accessing the number of non-zeros in the (symbolic)
 Jacobian. */
int jmi_func_sym_dF_n_nz(jmi_t *jmi, jmi_func_t *func, int* n_nz) {
    if (func->sym_dF==NULL) {
        *n_nz = 0;
        return -1;
    }
    *n_nz = func->sym_dF_n_nz;
    return 0;
}

/* Convenience function of accessing the non-zeros in the Jacobian */
int jmi_func_sym_dF_nz_indices(jmi_t *jmi, jmi_func_t *func, int independent_vars,
                           int *mask,int *row, int *col) {
    int i;
    int index;
    
    if (func->sym_dF==NULL) {
        return -1;
    }

/*  int col_index = 0;*/           /* Column index of the new Jacobian*/
/*  int col_index_old = 0;*/       /* Temporary variable to keep track of when to increase col_index*/
    index = 0;                 /* Index in the row/col vectors of the new Jacobian */

    /* Iterate over all non-zero indices */
    for (i=0;i<func->sym_dF_n_nz;i++) {
/*      printf("%d %d\n",i,jmi_check_Jacobian_column_index(jmi, independent_vars, mask, func->dF_col[i]-1)); */
        /* Check if this particular entry should be included */
        if (jmi_check_Jacobian_column_index(jmi, independent_vars, mask, func->sym_dF_col[i]-1) == 1 ) {
                /* Copy indices */
                row[index] = func->sym_dF_row[i];
                col[index] = jmi_map_Jacobian_column_index(jmi,independent_vars,mask,func->sym_dF_col[i]-1) + 1;
                index++;
        }
    }

    return 0;

}

/* Convenience function for computing the dimensions of the Jacobian. */
int jmi_func_sym_dF_dim(jmi_t *jmi, jmi_func_t *func, int sparsity, int independent_vars, int *mask,
        int *dF_n_cols, int *dF_n_nz) {
    int i;
    
    *dF_n_cols = 0;
    *dF_n_nz = 0;

    if (func->sym_dF==NULL) {
        return -1;
    }

    for (i=0;i<jmi->n_z;i++) {
        if (jmi_check_Jacobian_column_index(jmi, independent_vars, mask, i) == 1 ) {
            (*dF_n_cols)++;
        }
    }

    if (sparsity == JMI_DER_SPARSE) {
        for (i=0;i<func->sym_dF_n_nz;i++) {
/*          printf(">>>>>>>>>>>>>>>>>>\n"); */
            /* Check if this particular entry should be included */
            if (jmi_check_Jacobian_column_index(jmi, independent_vars, mask, func->sym_dF_col[i]-1) == 1 ) {
                (*dF_n_nz)++;
            }
        }
    } else {
        *dF_n_nz = *dF_n_cols*func->n_eq_F;
    }

    return 0;

}

int jmi_func_sym_directional_dF(jmi_t *jmi, jmi_func_t *func, jmi_real_t *res,
             jmi_real_t *dF, jmi_real_t* dv) {
        return -1;  
}

int jmi_func_cad_dF(jmi_t *jmi,jmi_func_t *func, int sparsity,
        int independent_vars, int* mask, jmi_real_t* jac) {
    
    int i;
    int j;
    int k;
    int l;
    int flag = 0;
    int c_index;
    
    int dF_n_cols;
    int dF_n_nz;
    int n_colors;
    int dF_n_eq = 0;
    
    int max_columns;
    int *row_offs;
    int *dF_row;
    int *dF_col;
    int *dF_col_independent_ind;
    int *offs;
    int *sparse_repr;
    int *map_info;
    int *map_off;
    jmi_real_t *res;
    jmi_real_t *dF;
    jmi_real_t *dv;
    jmi_color_info* c_i;


    max_columns  = func->cad_dF_col[func->cad_dF_n_nz-1]+1;

    /*Get number of columns and number of non-zeros, for the specific value of the independent_vars flag*/  
    jmi_func_cad_dF_dim(jmi, func, sparsity, independent_vars, mask, &dF_n_cols, &dF_n_nz);

    row_offs = (int*)calloc(dF_n_cols, sizeof(int));
    dF_row = (int*)calloc(dF_n_nz, sizeof(int));
    dF_col = (int*)calloc(dF_n_nz, sizeof(int));
    dF_col_independent_ind = (int*)calloc(dF_n_nz,sizeof(int));

    /*Get vectors with new row and column indices, depending on independent_vars*/  
    jmi_func_cad_dF_nz_indices(jmi, func, independent_vars, mask, dF_row, dF_col);
    
    /*The difference between dF_col_independent_ind and dF_col is that in dF_col_independent_ind,
    the old indices are given, for those variables that are present (In dF_col the indices are shifted)*/ 
    jmi_func_cad_dF_get_independent_ind(jmi, func, independent_vars, dF_col_independent_ind); 
    
    /*Set offset vector, which contains information about on which index a new column starts*/
    j = 0;
    for(i = 0; i < dF_n_nz; i++){
        if(dF_col[i] == j){
            row_offs[j] = i;
            j++;
        }
    }
    
    /*Here is a hack to handle JMI_DER_P_OPT as 32 instead of the orgingal value 8192. Then the 
    bitmask value can be used as storage index of the graph coloring result*/   
    c_index = 0;
    if(independent_vars & JMI_DER_P_OPT){
        c_index+=32;
    }
    c_index+=independent_vars>>4;
    
    /*If no graph coloring result is stored for the value of independent_vars, the run graph coloring algorithm and
    store the result, coloring done contains information if the result is stored or not. func->c_info contains the 
    graph coloring result. c_i is a struct that contains one specific graph coloring result*/
    if(func->coloring_done[c_index] != 1){
        func->coloring_done[c_index] = 1;
        flag = jmi_new_color_info(&c_i, dF_n_cols, dF_n_nz);
        jmi_dae_cad_color_graph(jmi, func, dF_n_cols, dF_n_nz, &dF_row[0], &dF_col[0], c_i->sparse_repr, c_i->offs, &n_colors, c_i->map_info, c_i->map_off);
        c_i->n_colors = n_colors;
        func->c_info[c_index] = c_i;
    } else{
        c_i = func->c_info[c_index];
    }

    /*Extract graph coloring information:
    sparse_repr is a vector containg a several numbers of sub vectors, for which every 
    vector contains the indices that corresponds to one color.
    offs is an offset vector used to know where each subvector in sparse_repr starts.
    map_info contains several vectors (One vector for each color), every vector contains the row indices which
    corresponds to none zeros.
    map_off is an offset vector that corresponds to map_info.
    n_colors is the number of colors used.*/
      
    sparse_repr = c_i->sparse_repr;
    offs = c_i->offs;
    map_info = c_i->map_info;
    map_off = c_i->map_off;
    n_colors = c_i->n_colors;

    /*Extract number of equations*/
    for(i = 0; i < func->cad_dF_n_nz;i++){
        if(func->cad_dF_row[i] > dF_n_eq){
            dF_n_eq = func->cad_dF_row[i];
        }
    }
    dF_n_eq++;
    
    res = (jmi_real_t*)calloc(dF_n_eq, sizeof(jmi_real_t));
    dF = (jmi_real_t*)calloc(dF_n_eq, sizeof(jmi_real_t));
    dv = (jmi_real_t*)calloc(max_columns, sizeof(jmi_real_t));
    for(i = 0; i < max_columns;i++){
        dv[i] = 0;
    }
    for(i = 0; i < dF_n_eq;i++){
        dF[i] = 0;
        res[i] = 0;
    }
    
    if(sparsity & JMI_DER_SPARSE){
        for(i = 0; i < dF_n_nz; i++){
            jac[i] = 0;
        }
    } else if(sparsity & JMI_DER_DENSE_COL_MAJOR){
        for(i = 0; i < dF_n_eq*dF_n_cols; i++){
            jac[i] = 0;
        }
    } else if(sparsity & JMI_DER_DENSE_ROW_MAJOR){
        for(i = 0; i < dF_n_eq*dF_n_cols; i++){
            jac[i] = 0;
        }
    } else{
        return -1;
    }
    
    /*For every color...*/
    for(i = 0; i < n_colors; i++){
        
        /*max_1: how many columns corresponds to the color?*/
        int max_1 = 0;
        
        if(i != n_colors-1){
            max_1 = offs[i+1];
        }else{
            max_1 = dF_n_cols;
        }
        
        /*The seed vector dv is set to 1 on indices that corresponds to the color*/
        for(j = offs[i]; j < max_1;j++){
            dv[dF_col_independent_ind[row_offs[sparse_repr[j]]]] = 1;
        }
        
        /*Evaluate directional derivative*/
        jmi_func_cad_directional_dF(jmi, jmi->dae->F, res, dF, dv);
        
        /*For every column that corresponds to one color...*/
        for(j = offs[i]; j < max_1;j++){
            
            /*max_2: End index of the column*/
            int max_2 = 0;  
            if(j != dF_n_cols - 1){
                max_2 = map_off[j+1];
            } else{
                max_2 = dF_n_nz;
            }
            
            /*For every non zero element in the column...*/ 
            for(k = map_off[j]; k < max_2; k++){
                /*Extract column and row index for this jacobian element this_value*/
                int this_column = sparse_repr[j];
                int this_row = map_info[k];
                jmi_real_t this_value = dF[map_info[k]];
                
                /*insert Jacobian value on correct index depending on sparsity representation*/
                if(sparsity & JMI_DER_SPARSE){
                    l = row_offs[this_column];
                    while(dF_row[l] != this_row){
                        l++;
                    }
                    jac[l] = this_value;
                } else if(sparsity & JMI_DER_DENSE_COL_MAJOR){
                    jac[dF_n_eq*this_column+this_row] = this_value;
                } else if(sparsity & JMI_DER_DENSE_ROW_MAJOR){
                    jac[dF_n_cols*this_row+this_column] = this_value;
                } else{
                    return -1;
                }
            }
        }
        /*Reset seed vector*/
        for(j = offs[i]; j < max_1;j++){
            dv[dF_col_independent_ind[row_offs[sparse_repr[j]]]] = 0;
        }
    }
    
    free(res);
    free(dF);
    free(dv);
    free(row_offs);
    free(dF_row);
    free(dF_col);
    free(dF_col_independent_ind);
    return flag;
}


int jmi_func_cad_dF_n_nz(jmi_t *jmi, jmi_func_t *func, int* n_nz) {
    *n_nz = func->cad_dF_n_nz;
    return 0;
}

/*Returns the row (row) and column (col) indices, the infrastructure of p_opt 
variables is not complete so this implemention might not work correctly for those*/
int jmi_func_cad_dF_nz_indices(jmi_t *jmi, jmi_func_t *func, int independent_vars,
                           int *mask,int *row, int *col) {
    
    int n_dx = jmi->n_real_dx;
    int n_x = jmi->n_real_x;
    int n_u = jmi->n_real_u;
    int n_w = jmi->n_real_w;
    int n_t = 0;
    int max_n_nz = func->cad_dF_n_nz;
    
    int aim = 0;
    int offs = 0;
    int i = 0;
    int j = 0;
    

    if(JMI_DER_T & independent_vars){
        n_t = 1;
    }

    aim+=n_dx;
    while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
        if(JMI_DER_DX & independent_vars){  
            col[j] = func->cad_dF_col[i]-offs;
            row[j] = func->cad_dF_row[i];
            j++;
            if(i != max_n_nz-1){
                if(func->cad_dF_col[i]+1<func->cad_dF_col[i+1]){
                    offs+=func->cad_dF_col[i+1]-(func->cad_dF_col[i]+1);
                }
            }
        }
        i++;
    }
    if(!(JMI_DER_DX & independent_vars)){   
        offs+=n_dx;
    }
    aim+=n_x;
    while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
        if(JMI_DER_X & independent_vars){
            col[j] = func->cad_dF_col[i]-offs;
            row[j] = func->cad_dF_row[i];
            j++;
            if(i != max_n_nz-1){
                if(func->cad_dF_col[i]+1<func->cad_dF_col[i+1]){
                    offs+=func->cad_dF_col[i+1]-(func->cad_dF_col[i]+1);
                }
            }
        }
        i++;
    }
    if(!(JMI_DER_X & independent_vars)){    
        offs+=n_x;
    }
    
    aim+=n_u;
    while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
        if(JMI_DER_U & independent_vars){
            col[j] = func->cad_dF_col[i]-offs;
            row[j] = func->cad_dF_row[i];
            j++;
            if(i != max_n_nz-1){
                if(func->cad_dF_col[i]+1<func->cad_dF_col[i+1]){
                    offs+=func->cad_dF_col[i+1]-(func->cad_dF_col[i]+1);
                }
            }
        }
        i++;
    }
    if(!(JMI_DER_U & independent_vars)){    
        offs+=n_u;
    }
    aim+=n_w;
    
    while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
        if(JMI_DER_W & independent_vars){   
            col[j] = func->cad_dF_col[i]-offs;
            row[j] = func->cad_dF_row[i];
            j++;
            if(i != max_n_nz-1){
                if(func->cad_dF_col[i]+1<func->cad_dF_col[i+1]){
                    offs+=func->cad_dF_col[i+1]-(func->cad_dF_col[i]+1);
                }
            }
        }
        i++;
    }
    if(!(JMI_DER_W & independent_vars)){    
        offs+=n_w;
    }
    aim+=n_t;
    while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
        if(JMI_DER_T & independent_vars){   
            col[j] = func->cad_dF_col[i]-offs;
            row[j] = func->cad_dF_row[i];
            j++;        
        }
        i++;
    }
    return 0;
}

/*Returns the number of non-zeros dF_n_nz and the number of columns dF_n_cols, 
the infrastructure of p_opt variables is not complete so this implemention might 
not work correctly for those*/
int jmi_func_cad_dF_dim(jmi_t *jmi, jmi_func_t *func, int sparsity, int independent_vars, int *mask,
        int *dF_n_cols, int *dF_n_nz) {
    
    int n_dx = jmi->n_real_dx;
    int n_x = jmi->n_real_x;
    int n_u = jmi->n_real_u;
    int n_w = jmi->n_real_w;
    int n_t = 0;

    int n_cols = 0;
    
    int max_n_nz = func->cad_dF_n_nz;
    
    int aim = 0;
    int i = 0;
    int j = 0;

    if(JMI_DER_T & independent_vars){
        n_t = 1;
    }
    
    aim+=n_dx;
    while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
        if(JMI_DER_DX & independent_vars){  
            j++;
            if(i != max_n_nz-1){
                if(func->cad_dF_col[i]<func->cad_dF_col[i+1]){
                    n_cols++;
                }
            } else{
                n_cols++;
            }
        }
        i++;
    }
    aim+=n_x;
    while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
        if(JMI_DER_X & independent_vars){
            j++;
            if(i != max_n_nz-1){
                if(func->cad_dF_col[i]<func->cad_dF_col[i+1]){
                    n_cols++;
                }
            } else{
                n_cols++;
            }
        }
        i++;
    }
    aim+=n_u;
    while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
        if(JMI_DER_U & independent_vars){
            j++;
            if(i != max_n_nz-1){
                if(func->cad_dF_col[i]<func->cad_dF_col[i+1]){
                    n_cols++;
                }
            } else{
                n_cols++;
            }
        }
        i++;
    }
    aim+=n_w;
    while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
        if(JMI_DER_W & independent_vars){   
            j++;
            if(i != max_n_nz-1){
                if(func->cad_dF_col[i]<func->cad_dF_col[i+1]){
                    n_cols++;
                }
            } else{
                n_cols++;
            }   
        }
        i++;
    }
    aim+=n_t;
    while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
        if(JMI_DER_T & independent_vars){   
            j++;
            if(i != max_n_nz-1){
                if(func->cad_dF_col[i]<func->cad_dF_col[i+1]){
                    n_cols++;
                }
            } else{
                n_cols++;
            }       
        }
        i++;
    }
    
    *dF_n_cols = n_cols;
    *dF_n_nz = j;
    return 0;
}

/*Evaluates the Jacobian using finite differences, this code is not secured and has only been used
for debugging purposes*/
int jmi_func_fd_dF(jmi_t *jmi,jmi_func_t *func, int sparsity,
        int independent_vars, int* mask, jmi_real_t* jac) {
    int i;
    int j;
    int k;
    
    int dF_n_cols;
    int dF_n_nz;
    int dF_n_eq;
    int max_columns;
    
    int *row_offs;
    int *dF_row;
    int *dF_col;
    int *dF_col_independent_ind;

    jmi_real_t *res;
    jmi_real_t *dF;
    jmi_real_t *dv;


    dF_n_eq = 0;
    max_columns = func->cad_dF_col[func->cad_dF_n_nz-1]+1;
    
    jmi_func_cad_dF_dim(jmi, func, sparsity, independent_vars, mask, &dF_n_cols, &dF_n_nz);
    
    row_offs = (int*)calloc(dF_n_cols, sizeof(int));
    dF_row = (int*)calloc(dF_n_nz, sizeof(int));
    dF_col = (int*)calloc(dF_n_nz, sizeof(int));
    dF_col_independent_ind = (int*)calloc(dF_n_nz,sizeof(int));

    jmi_func_cad_dF_nz_indices(jmi, func, independent_vars, mask, dF_row, dF_col);
    jmi_func_cad_dF_get_independent_ind(jmi, func, independent_vars, dF_col_independent_ind); 
    
    j = 0;
    for(i = 0; i < dF_n_nz; i++){
        if(dF_col[i] == j){
            row_offs[j] = i;
            j++;
        }
    }
    for(i = 0; i < func->cad_dF_n_nz;i++){
        if(func->cad_dF_row[i] > dF_n_eq){
            dF_n_eq = func->cad_dF_row[i];
        }
    }
    dF_n_eq++;
    
    res = (jmi_real_t*)calloc(dF_n_eq, sizeof(jmi_real_t));
    dF = (jmi_real_t*)calloc(dF_n_eq, sizeof(jmi_real_t));
    dv = (jmi_real_t*)calloc(max_columns, sizeof(jmi_real_t));
    for(i = 0; i < max_columns;i++){
        dv[i] = 0;
    }
    
    if(sparsity & JMI_DER_SPARSE){
        for(i = 0; i < dF_n_nz; i++){
            jac[i] = 0;
        }
    } else if(sparsity & JMI_DER_DENSE_COL_MAJOR){
        for(i = 0; i < dF_n_eq*dF_n_cols; i++){
            jac[i] = 0;
        }
    } else if(sparsity & JMI_DER_DENSE_ROW_MAJOR){
        for(i = 0; i < dF_n_eq*dF_n_cols; i++){
            jac[i] = 0;
        }
    } else{
        return -1;
    }
    
    
    for(i = 0; i < dF_n_cols; i++){
        dv[dF_col_independent_ind[row_offs[i]]] = 1.0;
        jmi_func_fd_directional_dF(jmi, func, res, dF, dv); 
        for(j = 0; j < dF_n_eq; j++){
            int this_column = i;
            int this_row = j;
            jmi_real_t this_value = dF[j];
                
            if(sparsity & JMI_DER_SPARSE){
                if(this_value != 0){
                    k = row_offs[this_column];
                    while(dF_row[k] != this_row){
                        k++;
                    }
                    jac[k] = this_value;
                }
            } else if(sparsity & JMI_DER_DENSE_COL_MAJOR){
                jac[dF_n_eq*this_column+this_row] = this_value;
            } else if(sparsity & JMI_DER_DENSE_ROW_MAJOR){
                jac[dF_n_cols*this_row+this_column] = this_value;
            } else{
                return -1;
            }
        }   
        dv[dF_col_independent_ind[row_offs[i]]] = 0;
    }
    free(res);
    free(dF);
    free(dv);
    free(row_offs);
    free(dF_row);
    free(dF_col);
    free(dF_col_independent_ind);
    return 0;
}

int jmi_func_fd_dF_n_nz(jmi_t *jmi, jmi_func_t *func, int* n_nz) {
    *n_nz = func->cad_dF_n_nz;
    return 0;
}

int jmi_func_fd_dF_nz_indices(jmi_t *jmi, jmi_func_t *func, int independent_vars,
                           int *mask,int *row, int *col) {
    jmi_func_cad_dF_nz_indices(jmi, func, independent_vars, mask, row, col);
    return 0;
}

int jmi_func_fd_dF_dim(jmi_t *jmi, jmi_func_t *func, int sparsity, int independent_vars, int *mask,
        int *dF_n_cols, int *dF_n_nz) {
    jmi_func_cad_dF_dim(jmi, func, sparsity, independent_vars, mask, dF_n_cols, dF_n_nz);
    return 0;
}

/*This implementation is not secured, it has only been used for debugging purposes*/
int jmi_func_fd_directional_dF(jmi_t *jmi, jmi_func_t *func, jmi_real_t *res,
             jmi_real_t *dF, jmi_real_t* dv) {
    jmi_dae_directional_FD_dF(jmi, func, res, dF, dv);
    return 0;
}

int jmi_copy_pre_values(jmi_t *jmi) {
    int i;
    jmi_real_t* z;
    z = jmi_get_z(jmi);
    for (i=jmi->offs_real_dx;i<jmi->offs_t;i++) {
        z[i - jmi->offs_real_dx + jmi->offs_pre_real_dx] = z[i];
    }
    for (i=jmi->offs_real_d;i<jmi->offs_pre_real_dx;i++) {
        z[i - jmi->offs_real_d + jmi->offs_pre_real_d] = z[i];
    }
    return 0;
}

int jmi_dae_init(jmi_t* jmi,
        jmi_residual_func_t F, int n_eq_F, jmi_jacobian_func_t sym_dF,
        int sym_dF_n_nz, int* sym_dF_row, int* sym_dF_col,
        jmi_directional_der_residual_func_t cad_dir_dF,
        int cad_dF_n_nz, int* cad_dF_row, int* cad_dF_col,
        int cad_A_n_nz, int* cad_A_row, int* cad_A_col,
        int cad_B_n_nz, int* cad_B_row, int* cad_B_col,
        int cad_C_n_nz, int* cad_C_row, int* cad_C_col,
        int cad_D_n_nz, int* cad_D_row, int* cad_D_col,
        jmi_residual_func_t R, int n_eq_R, jmi_jacobian_func_t dR,
        int dR_n_nz, int* dR_row, int* dR_col,
        jmi_generic_func_t ode_derivatives,
        jmi_generic_func_t ode_derivatives_dir_der,
        jmi_generic_func_t ode_outputs,
        jmi_generic_func_t ode_initialize,
        jmi_generic_func_t ode_guards,
        jmi_generic_func_t ode_guards_init,
        jmi_next_time_event_func_t ode_next_time_event) {
    
    jmi_func_t* jf_F;
    jmi_func_t* jf_R;
    
    /* Create jmi_dae struct */
    jmi_dae_t* dae = (jmi_dae_t*) calloc(1, sizeof(jmi_dae_t));
    jmi->dae = dae;
    
    jmi_func_new(&jf_F, F, n_eq_F, sym_dF, sym_dF_n_nz, sym_dF_row, sym_dF_col, cad_dir_dF,
            cad_dF_n_nz, cad_dF_row, cad_dF_col);

    jmi->dae->F = jf_F;

    jmi_func_new(&jf_R,R,n_eq_R,dR,dR_n_nz,dR_row, dR_col,NULL, 0, NULL, NULL);
    jmi->dae->R = jf_R;
    
    jmi->dae->ode_derivatives = ode_derivatives;
    jmi->dae->ode_derivatives_dir_der = ode_derivatives_dir_der;
    jmi->dae->ode_outputs = ode_outputs;
    jmi->dae->ode_initialize = ode_initialize;
    jmi->dae->ode_guards = ode_guards;
    jmi->dae->ode_guards_init = ode_guards_init;
    jmi->dae->ode_next_time_event = ode_next_time_event;

    if (cad_A_n_nz>0 && (cad_A_n_nz < ((double)jmi->n_real_dx)*jmi->n_real_dx*0.8)) {
        jmi_new_simple_color_info(&(jmi->color_info_A),
            jmi->n_real_dx, jmi->n_real_dx, cad_A_n_nz,
            cad_A_row, cad_A_col, 0, 0);
        compute_cpr_groups(jmi->color_info_A);
    } else {
        jmi->color_info_A = NULL;
    }

    if (cad_B_n_nz>0) {
        jmi_new_simple_color_info(&(jmi->color_info_B),
            jmi->n_real_dx, jmi->n_real_dx, cad_B_n_nz,
            cad_A_row, cad_B_col, 0, 0);
        compute_cpr_groups(jmi->color_info_B);
    } else {
        jmi->color_info_B = NULL;
    }

    if (cad_C_n_nz>0) {
        jmi_new_simple_color_info(&(jmi->color_info_C),
            jmi->n_real_dx, jmi->n_real_dx, cad_A_n_nz,
            cad_C_row, cad_C_col, 0, 0);
        compute_cpr_groups(jmi->color_info_C);
    } else {
        jmi->color_info_C = NULL;
    }

    if (cad_D_n_nz>0) {
        jmi_new_simple_color_info(&(jmi->color_info_D),
            jmi->n_real_dx, jmi->n_real_dx, cad_D_n_nz,
            cad_D_row, cad_D_col, 0, 0);
        compute_cpr_groups(jmi->color_info_D);
    } else {
        jmi->color_info_D = NULL;
    }

    return 0;
}

int jmi_new_simple_color_info(jmi_simple_color_info_t** c_info, int n_cols, int n_cols_in_grouping, int n_nz,
        int* rows, int* cols, int col_offset, int one_indexing) {
    int i,j;
    int ind;
    int n_col_el;
    jmi_simple_color_info_t* c_i_temp = (jmi_simple_color_info_t*)calloc(1,sizeof(jmi_simple_color_info_t));
    (*c_info) = c_i_temp;
    c_i_temp->col_offset = col_offset;
    c_i_temp->n_nz = n_nz;
    c_i_temp->n_cols = n_cols;
    c_i_temp->n_cols_in_grouping = n_cols_in_grouping;
    c_i_temp->col_n_nz = (int*)calloc(n_cols,sizeof(int));
    c_i_temp->rows = (int*)calloc(n_nz,sizeof(int));
    c_i_temp->cols = (int*)calloc(n_nz,sizeof(int));
    c_i_temp->col_start_index = (int*)calloc(n_cols,sizeof(int));

    /* Make sure indices are stored in column major format */
    ind = 0;
    c_i_temp->col_start_index[0] = 0;
    for (i=0;i<n_cols;i++) {
        n_col_el = 0;
        for (j=0;j<n_nz;j++) {
            if (cols[j]-one_indexing == i) {
                c_i_temp->rows[ind] = rows[j];
                c_i_temp->cols[ind] = cols[j];
                ind++;
                n_col_el++;
            }
        }
        c_i_temp->col_n_nz[i] = n_col_el;
        if (i<n_cols-1) {
            c_i_temp->col_start_index[i+1] = ind;
        }
    }
/*
    printf("**** New color struct ****\n");
    printf("n_cols: %d\n", n_cols);
    printf("n_cols_in_grouping: %d\n", n_cols_in_grouping);
    printf("n_nz: %d\n", n_nz);
    printf("col_offset: %d\n", col_offset);
    printf("one_indexing: %d\n", one_indexing);
    printf("*** Sorted incidence\n");

    for (i=0;i<n_nz;i++) {
        printf("%d, %d\n", c_i_temp->rows[i], c_i_temp->cols[i]);
    }

    printf("* Original incidence\n");
    for (i=0;i<n_nz;i++) {
        printf("%d, %d\n", rows[i], cols[i]);
    }

    printf("* Column starts\n");
    for (i=0;i<n_cols;i++) {
        printf("%d\n", c_i_temp->col_start_index[i]);
    }
*/
    c_i_temp->group_cols = (int*)calloc(n_cols,sizeof(int));
    c_i_temp->n_cols_in_group = (int*)calloc(n_cols,sizeof(int));
    c_i_temp->group_start_index = (int*)calloc(n_nz+1,sizeof(int));
    c_i_temp->n_groups = 0;
    return 0;
}

void jmi_delete_simple_color_info(jmi_simple_color_info_t **c_info_ptr) {
    jmi_simple_color_info_t *c_info = *c_info_ptr;
    if(!c_info) return;
    
    free(c_info->cols);
    free(c_info->rows);
    free(c_info->col_n_nz);
    free(c_info->group_cols);
    free(c_info->col_start_index);
    free(c_info->n_cols_in_group);
    free(c_info->group_start_index);
    free(c_info);
    *c_info_ptr = 0;
}

/*Initiate struct containing graph coloring results*/
int jmi_new_color_info(jmi_color_info** c_info, int dF_n_cols, int dF_n_nz){
    jmi_color_info* c_i_temp = (jmi_color_info*)calloc(1,sizeof(jmi_color_info));
    (*c_info) = c_i_temp;
    c_i_temp->offs = (int*)calloc(dF_n_cols, sizeof(int));
    c_i_temp->sparse_repr = (int*)calloc(dF_n_cols, sizeof(int));
    c_i_temp->map_info = (int*)calloc(dF_n_nz, sizeof(int));
    c_i_temp->map_off = (int*)calloc(dF_n_cols, sizeof(int));
    return 0;
}

int jmi_delete_color_info(jmi_color_info *c_i){
    free(c_i->offs);
    free(c_i->sparse_repr);
    free(c_i->map_info);
    free(c_i->map_off);
    return 0;
}

int jmi_init_init(jmi_t* jmi, jmi_residual_func_t F0, int n_eq_F0,
        jmi_jacobian_func_t dF0,
        int dF0_n_nz, int* dF0_row, int* dF0_col,
        jmi_residual_func_t F1, int n_eq_F1,
        jmi_jacobian_func_t dF1,
        int dF1_n_nz, int* dF1_row, int* dF1_col,
        jmi_residual_func_t Fp, int n_eq_Fp,
        jmi_jacobian_func_t dFp,
        int dFp_n_nz, int* dFp_row, int* dFp_col,
        jmi_generic_func_t eval_parameters,
        jmi_residual_func_t R0, int n_eq_R0,
        jmi_jacobian_func_t dR0,
        int dR0_n_nz, int* dR0_row, int* dR0_col) {
    jmi_func_t* jf_F0;
    jmi_func_t* jf_F1;
    jmi_func_t* jf_Fp;
    jmi_func_t* jf_R0;
    
    /* Create jmi_init struct */
    jmi_init_t* init = (jmi_init_t*)calloc(1,sizeof(jmi_init_t));
    jmi->init = init;

    jmi_func_new(&jf_F0,F0,n_eq_F0,dF0,dF0_n_nz,dF0_row, dF0_col, NULL, 0, NULL, NULL);
    jmi->init->F0 = jf_F0;

    jmi_func_new(&jf_F1,F1,n_eq_F1,dF1,dF1_n_nz,dF1_row, dF1_col, NULL, 0, NULL, NULL);
    jmi->init->F1 = jf_F1;

    jmi_func_new(&jf_Fp,Fp,n_eq_Fp,dFp,dFp_n_nz,dFp_row, dFp_col, NULL, 0, NULL, NULL);
    jmi->init->Fp = jf_Fp;

    jmi->init->eval_parameters = eval_parameters;

    jmi_func_new(&jf_R0,R0,n_eq_R0,dFp,dR0_n_nz,dR0_row, dR0_col, NULL, 0, NULL, NULL);
    jmi->init->R0 = jf_R0;

    return 0;
}

void jmi_delete_init(jmi_init_t** pinit) {
        jmi_init_t* init = *pinit;

        jmi_func_delete(init->F0);

        jmi_func_delete(init->F1);

        jmi_func_delete(init->Fp);

        jmi_func_delete(init->R0);

        free(init);

        *pinit = 0;
}

int jmi_variable_type(jmi_t *jmi, int col_index) {
    
    if (col_index>=jmi->offs_real_ci && col_index<jmi->offs_real_cd) {
        return JMI_DER_CI;
    } else if (col_index >= jmi->offs_real_cd && col_index < jmi->offs_real_pi) {
        return JMI_DER_CD;
    } else if (col_index>=jmi->offs_real_pi && col_index<jmi->offs_real_pd) {
        return JMI_DER_PI;
    } else if (col_index>=jmi->offs_real_pd && col_index<jmi->offs_real_dx) {
        return JMI_DER_PD;
    } else if (col_index>=jmi->offs_real_dx && col_index<jmi->offs_real_x) {
        return JMI_DER_DX;
    } else if (col_index>=jmi->offs_real_x && col_index<jmi->offs_real_u) {
        return JMI_DER_X;
    } else if (col_index>=jmi->offs_real_u && col_index<jmi->offs_real_w) {
        return JMI_DER_U;
    } else if (col_index>=jmi->offs_real_w && col_index<jmi->offs_t) {
        return JMI_DER_W;
    } else if (col_index==jmi->offs_t) {
        return JMI_DER_T;
    }

    return -1;
}

int jmi_check_Jacobian_column_index(jmi_t *jmi, int independent_vars, int *mask, int col_index) {

    /*printf("%d\n",jmi->n_z);*/
    /*printf("<<< %d %d\n", col_index, mask[col_index]);*/
    /*printf("<< %d %d\n", independent_vars, jmi_variable_type(jmi, col_index));*/
    int vt = 0;
    if (mask[col_index] == 0) {
        return 0;
    } else {
        vt = jmi_variable_type(jmi,col_index);
        if (vt!=-1 && (independent_vars & vt)) {
            return 1;
        } else {
            return 0;
        }
    }
}

int jmi_map_Jacobian_column_index(jmi_t *jmi, int independent_vars, int *mask, int col_index) {

/*  printf("jmi_map_Jacobian_column_index start: %d\n",col_index);*/
    int new_col_index = 0;
    int i = 0;

    for (i=0; i<col_index; i++) {
/*      printf("****************** 1 \n");*/
        if (jmi_check_Jacobian_column_index(jmi, independent_vars, mask, i)==1) {
            new_col_index++;
        }
/*      printf("****************** 2 \n");*/
    }

/*  printf("jmi_map_Jacobian_column_index end: %d\n",new_col_index);*/

    return new_col_index;
}

int jmi_variable_type_spec(jmi_t *jmi, int independent_vars,
               int *mask, int col_index) {

  int spec_jac_index = 0;
  int i = 0;
  for(i=0;i<jmi->n_z;i++) {
    if (jmi_check_Jacobian_column_index(jmi,independent_vars,mask,i)==1) {
      spec_jac_index++;
    }
    if (col_index==spec_jac_index) {
      return jmi_variable_type(jmi,i);
    }
  }
  return -1;
}

int jmi_dae_get_sizes(jmi_t* jmi, int* n_eq_F, int* n_eq_R) {
    if (jmi->dae == NULL) {
        return -1;
    }
    *n_eq_F = jmi->dae->F->n_eq_F;
    *n_eq_R = jmi->dae->R->n_eq_F;
    return 0;
}

int jmi_init_get_sizes(jmi_t* jmi, int* n_eq_F0, int* n_eq_F1, int* n_eq_Fp,
        int* n_eq_R0) {
    if (jmi->init == NULL) {
        return -1;
    }
    *n_eq_F0 = jmi->init->F0->n_eq_F;
    *n_eq_F1 = jmi->init->F1->n_eq_F;
    *n_eq_Fp = jmi->init->Fp->n_eq_F;
    *n_eq_R0 = jmi->init->R0->n_eq_F;
    return 0;
}

jmi_real_t* jmi_get_z(jmi_t* jmi) {
    return *(jmi->z);
}

jmi_real_t* jmi_get_z_last(jmi_t* jmi) {
    return *(jmi->z_last);
}

jmi_real_t* jmi_get_real_ci(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_real_ci;
}

jmi_real_t* jmi_get_real_cd(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_real_cd;
}

jmi_real_t* jmi_get_real_pi(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_real_pi;
}

jmi_real_t* jmi_get_real_pd(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_real_pd;
}

jmi_real_t* jmi_get_integer_ci(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_integer_ci;
}

jmi_real_t* jmi_get_integer_cd(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_integer_cd;
}

jmi_real_t* jmi_get_integer_pi(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_integer_pi;
}

jmi_real_t* jmi_get_integer_pd(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_integer_pd;
}

jmi_real_t* jmi_get_boolean_ci(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_boolean_ci;
}

jmi_real_t* jmi_get_boolean_cd(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_boolean_cd;
}

jmi_real_t* jmi_get_boolean_pi(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_boolean_pi;
}

jmi_real_t* jmi_get_boolean_pd(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_boolean_pd;
}

jmi_real_t* jmi_get_real_dx(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_real_dx;
}

jmi_real_t* jmi_get_real_x(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_real_x;
}

jmi_real_t* jmi_get_real_u(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_real_u;
}

jmi_real_t* jmi_get_real_w(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_real_w;
}

jmi_real_t* jmi_get_t(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_t;
}

jmi_real_t* jmi_get_real_d(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_real_d;
}

jmi_real_t* jmi_get_integer_d(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_integer_d;
}

jmi_real_t* jmi_get_integer_u(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_integer_u;
}

jmi_real_t* jmi_get_boolean_d(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_boolean_d;
}

jmi_real_t* jmi_get_boolean_u(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_boolean_u;
}

int jmi_get_output_vrefs(jmi_t *jmi, int *output_vrefs) {
    int i;
    for (i=0;i<jmi->n_outputs;i++) {
        output_vrefs[i] = jmi->output_vrefs[i];
    }
    return 0;
}

jmi_real_t* jmi_get_sw(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_sw;
}

jmi_real_t* jmi_get_state_sw(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_state_sw;
}

jmi_real_t* jmi_get_time_sw(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_time_sw;
}

jmi_real_t* jmi_get_sw_init(jmi_t* jmi) {
    return *(jmi->z) + jmi->offs_sw_init;
}

jmi_real_t* jmi_get_variable_scaling_factors(jmi_t* jmi) {
    return jmi->variable_scaling_factors;
}

int jmi_get_scaling_method(jmi_t* jmi) {
    return jmi->scaling_method;
}

void jmi_print_summary(jmi_t *jmi) {
    printf("Number of interactive constants:               %d\n",jmi->n_real_ci);
    printf("Number of dependent constants:                 %d\n",jmi->n_real_cd);
    printf("Number of interactive parameters:              %d\n",jmi->n_real_pi);
    printf("Number of dependent parameters:                %d\n",jmi->n_real_pd);
    printf("Number of derivatives:                         %d\n",jmi->n_real_dx);
    printf("Number of states:                              %d\n",jmi->n_real_x);
    printf("Number of inputs:                              %d\n",jmi->n_real_u);
    printf("Number of algebraics:                          %d\n",jmi->n_real_w);
    printf("Number of switching functions in DAE:          %d\n",jmi->n_sw);
    printf("Number of switching functions in DAE init:     %d\n",jmi->n_sw_init);
    if (jmi->dae != NULL) {
        printf("DAE interface:\n");
        printf("  Number of DAE equations:                     %d\n",jmi->dae->F->n_eq_F);
    } else {
        printf("No DAE functions available");
    }
    if (jmi->init != NULL) {
        printf("Initialization interface:\n");
        printf("  Number of F0 equations:                      %d\n",jmi->init->F0->n_eq_F);
        printf("  Number of F1 equations:                      %d\n",jmi->init->F1->n_eq_F);
    } else {
        printf("No Initialization functions available");
    }
}

void jmi_lin_interpolate(jmi_real_t x, jmi_real_t *z , int n ,int m,
        jmi_real_t *y) {

    int i;
    int el = 0;

    /* Check if before interval */
    if (x <= z[0]) {
        for (i=0;i<m-1;i++) {
/*          printf("%d: %f\n",i+1,z[n*(i+1)]);*/
            y[i] = z[n*(i+1)];
        }
        return;
    }
    /* Check after interval */
    if (x >= z[n-1]) {
        for (i=0;i<m-1;i++) {
            y[i] = z[n*(i+2)-1];
        }
        return;
    }

    /* Find correct element */
    while(x >= z[el]) {
        el++;
    }
    el--;

/*  printf(">> %d\n",el);*/

    /* Compute interpolated values. */
    for (i=0;i<m-1;i++) {
        y[i] = (x-z[el])*(z[n*(i+1) + el + 1] - z[n*(i+1) + el])/(z[el+1]-z[el]) +
           z[n*(i+1) + el];
    }

}

int jmi_dae_derivative_checker(jmi_t* jmi, int sparsity, int independent_vars, int screen_use, int *mask){
    return jmi_util_dae_derivative_checker(jmi, jmi->dae->F, sparsity, independent_vars, screen_use, mask);
}

int jmi_with_cad_derivatives(jmi_t* jmi)
{
  return (jmi->dae->F->cad_dF_row[0]==-1)? 0: 1;
}

void jmi_init_runtime_options(jmi_t *jmi, jmi_options_t* op) {
    jmi_block_solver_init_default_options(&op->block_solver_options);

    op->nle_solver_default_tol = 1e-10;      /**< \brief Default tolerance for the equation block solver */
    op->nle_solver_tol_factor = 0.0001;   /**< \brief Tolerance safety factor for the non-linear equation block solver. */
    op->events_default_tol = 1e-10;       /**< \brief Default tolerance for the event iterations. */        
    op->events_tol_factor = 0.0001;       /**< \brief Tolerance safety factor for the event iterations. */
    op->cs_solver = JMI_ODE_CVODE;        /** < \brief Option for changing the internal CS solver. */
    op->cs_rel_tol = 1e-6;                /** < \brief Default tolerance for the adaptive solvers in the CS case. */
    op->cs_step_size = 1e-3;              /** < \brief Default step-size for the non-adaptive solvers in the CS case. */   

    op->log_options = &jmi->jmi_callbacks.log_options;
}

int jmi_get_index_from_value_ref(int vref) {
    /* Translate a ValueReference into variable index in z-vector. */
    return vref & VREF_INDEX_MASK;
}

int jmi_get_type_from_value_ref(int vref) {
    /* Translate a ValueReference into variable type in z-vector. */
    return vref & VREF_TYPE_MASK;
}

int jmi_get_value_ref_from_index(int index, jmi_int_t type) {
    /* Translates an index together with a type to a value reference */
    int valueref = -1;
    
    if (type == JMI_REAL) {
        valueref = REAL_TYPE_MASK+index;
    }else if (type == JMI_INTEGER) {
        valueref = INT_TYPE_MASK+index;
    }else if (type == JMI_BOOLEAN) {
        valueref = BOOL_TYPE_MASK+index;
    }
    
    return valueref;
}

/*This function has been used during debugging*/
int jmi_dae_directional_FD_dF(jmi_t* jmi, jmi_func_t *func, jmi_real_t *res, jmi_real_t* dF, jmi_real_t* dv) {
    jmi_real_t h = 0.0001;
    
    int n_eq = 0;
    int n_eq_R = 0;
    int i;
    int offs;

    jmi_real_t* dx;
    jmi_real_t* x;
    jmi_real_t* u;
    jmi_real_t* w;
    jmi_real_t* t;

    jmi_real_t* res1;
    jmi_real_t* res2;

    
    dx = jmi_get_real_dx(jmi);
    x = jmi_get_real_x(jmi);
    u = jmi_get_real_u(jmi);
    w = jmi_get_real_w(jmi);
    t = jmi_get_t(jmi);
    

    jmi_dae_get_sizes(jmi, &n_eq, &n_eq_R);
    
    res1 = (jmi_real_t*)calloc(n_eq,sizeof(jmi_real_t));
    res2 = (jmi_real_t*)calloc(n_eq,sizeof(jmi_real_t));
    
    
    
    offs = 0;
    for (i=0;i<jmi->n_real_dx;i++) {
        dx[i] = dx[i] + dv[i+offs]*h;       
    }
    offs += jmi->n_real_dx;
    for (i=0;i<jmi->n_real_x;i++) {
        x[i] = x[i] + dv[i+offs]*h;
    }
    offs+=jmi->n_real_x;
    for (i=0;i<jmi->n_real_u;i++) {
        u[i] = u[i] + dv[i+offs]*h;
    }
    offs+=jmi->n_real_u;
    for (i=0;i<jmi->n_real_w;i++) {
        w[i] = w[i] + dv[i+offs]*h;
    }
    offs+=jmi->n_real_w;
    *t = *t + dv[offs]*h;
    
    jmi_func_F(jmi,jmi->dae->F, res1);
    
    for (i=0;i<jmi->n_real_dx;i++) {
        dx[i] = dx[i] - 2*dv[i]*h;
    }
    offs = jmi->n_real_dx;
    for (i=0;i<jmi->n_real_x;i++) {
        x[i] = x[i] - 2*dv[i+offs]*h;
    }
    offs+=jmi->n_real_x;
    for (i=0;i<jmi->n_real_u;i++) {
        u[i] = u[i] - 2*dv[i+offs]*h;
    }
    offs+=jmi->n_real_u;
    for (i=0;i<jmi->n_real_w;i++) {
        w[i] = w[i] - 2*dv[i+offs]*h;
    }
    offs+=jmi->n_real_w;
    *t = *t - 2*dv[offs]*h;
    
    jmi_func_F(jmi, jmi->dae->F, res2);
    
    for (i=0;i<jmi->n_real_dx;i++) {
        dx[i] = dx[i] + dv[i]*h;
    }
    offs = jmi->n_real_dx;
    for (i=0;i<jmi->n_real_x;i++) {
        x[i] = x[i] + dv[i+offs]*h;
    }
    offs+=jmi->n_real_x;
    for (i=0;i<jmi->n_real_u;i++) {
        u[i] = u[i] + dv[i+offs]*h;
    }
    offs+=jmi->n_real_u;
    for (i=0;i<jmi->n_real_w;i++) {
        w[i] = w[i] + dv[i+offs]*h;
    }
    offs+=jmi->n_real_w;
    *t = *t + dv[offs]*h;
    
    for(i=0;i< n_eq;i++){
        dF[i] = (res1[i] -  res2[i])/(2*h);
    }
    
    free(res1);
    free(res2);
    
    return 0;
}

/*Performs graph coloring, sse documentation in function jmi_func_cad_df
for a description of the output parameter*/
int jmi_dae_cad_color_graph(jmi_t *jmi, jmi_func_t *func, int n_col, int n_nz, int *row, int *col, int *sparse_repr, int *offs, int *n_colors, int *map_info, int *map_off){
    int i;
    int j;
    int n_color = 0;
    
    int *inc_length =   (int*)calloc(n_col, sizeof(int));
    int *color      =   (int*)calloc(n_col, sizeof(int));
    int *numb_col   =   (int*)calloc(n_col, sizeof(int));
    int *row_off    =   (int*)calloc(n_col, sizeof(int));
    int **incidence_v;
    
    /*inc_length number of connections for every node (One column corresponds to one node)*/
    jmi_dae_cad_get_connection_length(n_col ,n_nz,row,col, inc_length);
    
    func->coloring_counter++;
    
    incidence_v = (int**)calloc(n_col, sizeof(int*));
    for(i = 0; i<n_col; i++){
        incidence_v[i] = (int*)calloc(inc_length[i], sizeof(int)); 
    }
    
    /*Creates a matrix that contains all connections for every node*/
    jmi_dae_cad_get_connections(n_col, n_nz,row,col, incidence_v, inc_length );
    
    /*Performs the graph coloring*/
    jmi_dae_cad_first_fit( n_col, incidence_v, inc_length, color, numb_col);

    /*Total number of colors*/
    for(i = 0; i < n_col;i++){
        if(n_color < color[i]){
            n_color = color[i];
        }
    }
    n_color++;
     
    j = 0;
    for(i = 0; i < n_nz; i++){
        if(col[i] == j){
            row_off[j] = i;
            j++;
        }
    }
    
    offs[0] = 0;
    for(i = 1; i < n_color; i++){
        offs[i] = numb_col[i-1] + offs[i-1];
    }
    for(i = 0; i< n_col; i++){
        sparse_repr[i] = -1;
    }
    
    /*Sets up the sparse_repr, map_info and map_off vectors*/ 
    jmi_dae_cad_get_compression_info(n_nz, row, row_off, n_col, color, sparse_repr, offs, numb_col, map_info, map_off);
    
    for(i = 0; i < n_col; i++){
        free(incidence_v[i]);
    }
    free(incidence_v);
    free(color);
    free(inc_length);
    free(numb_col);
    free(row_off);
    *n_colors = n_color;
    return 0;
}

int jmi_dae_cad_get_compression_info(int n_nz, int *row, int *row_off, int n_col, int *color, int *sparse_repr, int *offs, int *numb_color, int *map_info, int *map_off){
    int i;
    int j;
    int c;
    for(i = 0; i<n_col; i++){
        c = color[i];
        j = 0;
        while(j<numb_color[c]&&sparse_repr[offs[c]+j] != -1){
            j++;
        }
        sparse_repr[offs[c]+j] = i;
        if(i !=n_col-1){
            map_off[offs[c] + j] = row_off[i+1]-row_off[i];
        } else{
            map_off[offs[c] + j] = n_nz-row_off[i];
        }
    }
    
    map_off[n_col-1] = n_nz - map_off[n_col-1];
    
    for(i = n_col-2; i >= 0; i--){
        map_off[i] = map_off[i+1]-map_off[i];
    }
    
    for(i = 0; i < n_col-1; i++){
        for(j = map_off[i]; j < map_off[i+1]; j++){
            map_info[j] = row[row_off[sparse_repr[i]]+j - map_off[i]];                  
        }
    }
    
    for(j = map_off[n_col-1]; j < n_nz; j++){
        map_info[j] = row[row_off[sparse_repr[n_col-1]]+j - map_off[n_col-1]];
    }
    return 0;
}
    
int jmi_dae_cad_first_fit( int n_col, int **inc_vec, int *inc_length, int *color, int *numb_col){
    int i;
    int j;
    int max_col = 0;
    int *col_set  = (int*)calloc(n_col, sizeof(int));
    
    for(i = 0; i < n_col; i++){
        color[i] = 0;
        col_set[i] = 0;
        numb_col[i] = 0;
    }
    
    for(i = 0; i < n_col; i++){
        for(j = 0; j < inc_length[i]; j++){
            if(color[inc_vec[i][j]] != 0){
                col_set[color[inc_vec[i][j]]-1] = 1;
            }
        }
        j = 0;
        while(col_set[j] == 1 && j < n_col){
            j++;
        }
        color[i] = j+1;
        numb_col[j]++;
        if(max_col < j+1){
            max_col = j+1;
        }
        for(j = 0; j < max_col; j++){
            col_set[j] = 0;
        }
    }
    for(i = 0; i < n_col; i++){
        color[i]--;
    }
    free(col_set);
    return 0;
}
        
int jmi_dae_cad_get_connection_length( int n_col, int n_nz, int *row, int *col, int *inc_length){
    int i;
    int j;
    int k;
    int c;
    
    int *offs = (int*)calloc(n_col+1, sizeof(int));
    
    j=0;
    for(i = 0; i<n_nz;i++){
        if(j == col[i]){
            offs[j] = i;
            j++;
        }
    }
    offs[j] = n_nz;
    for(i = 0; i<n_col; i++){
        c=0;
        for(j = 0; j < n_nz; j++){
            for(k = offs[i]; k < offs[i+1]; k++){
                if(row[j]== row[k]){
                    c++;
                    k = offs[i+1];
                    j =offs[col[j]+1]-1;
                }
            }
        }
        inc_length[i] = c;
    }
    free(offs);
    return 0;
}

int jmi_dae_cad_get_connections( int n_col, int n_nz, int *row, int *col, int **inc_vec, int *inc_length){
    int i;
    int j;
    int k;
    int c;

    int *offs = (int*)calloc(n_col+1, sizeof(int));
    
    j=0;
    for(i = 0; i<n_nz;i++){
        if(j == col[i]){
            offs[j] = i;
            j++;
        }
    }
    offs[j] = n_nz;
    
    for(i = 0; i<n_col; i++){
        c = 0;
        for(j = 0; j < n_nz; j++){
            for(k = offs[i]; k < offs[i+1]; k++){
                if(row[j]== row[k]){
                    inc_vec[i][c] = col[j];
                    c++;
                    k = offs[i+1];
                    j =offs[col[j]+1]-1;
                }
            }   
        }
    }
    free(offs);
    return 0;
}

void compute_cpr_groups(jmi_simple_color_info_t *color_info) {
    int n_cols_in_group; /* Counter for the number of columns in a group */
    int n_selected_cols; /* Total number of columns added to groups */

    int i,j,k,l,compatible;

    int n_c_g = color_info->n_cols_in_grouping;
    int offs_c_g = color_info->col_offset;

    int* selected_groups = (int*)calloc(n_c_g,sizeof(int));
    for (i=0;i<n_c_g;i++) {
        selected_groups[i] = 0;
    }

    /*clock_t start = clock();*/

    /*
    printf("**********\n");
    for (i=0;i<n_c_g;i++) {
        for (j=0;j<func->ad->dF_z_col_n_nz[i+offs_c_g];j++) {
            printf(" - %d %d\n", i+offs_c_g,func->ad->dF_z_row[func->ad->dF_z_col_start_index[i+offs_c_g]+j]);
        }
    }


    printf("n_cols_in_grouping=%d\n",n_c_g);
*/

    color_info->n_groups = 0;
    color_info->group_start_index[0] = 0;
    n_cols_in_group = 0;
    n_selected_cols = 0;
    /* Loop until all column have been added to a graph */
    while(n_selected_cols<n_c_g) {
        /*printf("Starting sweep, n_groups = %d\n",color_info->n_groups);*/
        /* Reset group column counter */
        n_cols_in_group = 0;
        /* Loop over all colums and add the ones that are i) compatible
         and ii) have not been selected */
        for(i=0;i<n_c_g;i++) {
            /*printf("About to check, col = %d\n",i+offs_c_g);*/
            /* If the column has not been added to a group... */
            if (selected_groups[i]!=1) {
                /*printf("Col %d has not been selected\n",i+offs_c_g);*/
                /* ...make compatibility check */
                compatible = 1;
                /* Loop over all columns that have been added to group */
                for (j=color_info->group_start_index[color_info->n_groups];
                        j<color_info->group_start_index[color_info->n_groups] +
                        n_cols_in_group;j++) {

                    /*printf("a row index: %d\n", color_info->col_start_index[color_info->group_cols[j]]);
                    printf("b row index: %d\n", color_info->col_start_index[i + offs_c_g]);
                    printf("qew: %d, %d\n", i, offs_c_g);*/
                    int* col_a_row_ind = &color_info->rows[color_info->col_start_index[color_info->group_cols[j]]];
                    int* col_b_row_ind = &color_info->rows[color_info->col_start_index[i + offs_c_g]];
                    int col_a_n_nz = color_info->col_n_nz[color_info->group_cols[j]];
                    int col_b_n_nz = color_info->col_n_nz[i+offs_c_g];

                    /*printf("Checking col %d, n_nz=%d, against %d, n_n_z=%d (in group)\n",
                            i+offs_c_g,col_b_n_nz,color_info->group_cols[j],col_a_n_nz);*/

                    for (k=0;k<col_a_n_nz;k++) {
                        for (l=0;l<col_b_n_nz;l++) {
                            /*printf(" ** %d %d\n",col_a_row_ind[k],col_b_row_ind[l]);*/
                            if (col_a_row_ind[k] == col_b_row_ind[l]) {
                                compatible = 0;
                                break;
                            }
                        }
                    }
                }
                if (compatible==1) {
                    /*printf("Col %d added to group\n",i+offs_c_g);*/
                    selected_groups[i] = 1;
                    color_info->group_cols[n_selected_cols] = i + offs_c_g;
                    n_selected_cols++;
                    n_cols_in_group++;
                } else {
                    /*printf("Col %d incompatible\n",i+offs_c_g);*/
                }
            } else {
                   /* printf("Col %d has already been selected\n",i+offs_c_g);*/
            }
        }
        color_info->n_groups++;
        color_info->group_start_index[color_info->n_groups] =
                color_info->group_start_index[color_info->n_groups - 1] + n_cols_in_group;
        color_info->n_cols_in_group[color_info->n_groups - 1] = n_cols_in_group;
        /*printf("End iteration over cols, col = %d, n_cols_in_group = %d\n",i,n_cols_in_group);*/
    }

    free(selected_groups);
    /*
    printf("Computed CPR groups: %d groups computed from %d columns\n",color_info->n_groups,color_info->n_cols_in_grouping);
    for (i=0;i<color_info->n_groups;i++) {
        for (j=0;j<color_info->n_cols_in_group[i];j++) {
            printf(" >> %d %d\n",i,color_info->group_cols[color_info->group_start_index[i]+j]);
        }
    }*/

}

int jmi_util_dae_derivative_checker(jmi_t *jmi,jmi_func_t *func, int sparsity,
        int independent_vars, int screen_use, int *mask){
    
        int i = 0;

        jmi_real_t tol = 0.001;
        
        int dF_n_cols;
        int dF_n_nz;
        int dF_n_eq = 0;
        int* dF_row;
        int* dF_col;
        int passed;
        int failed;
        

        jmi_func_cad_dF_dim(jmi, jmi->dae->F, i, independent_vars, mask, &dF_n_cols, &dF_n_nz);
        
        dF_row = (int*)calloc(dF_n_nz, sizeof(int));
        dF_col = (int*)calloc(dF_n_nz, sizeof(int));
        jmi_func_cad_dF_nz_indices(jmi, jmi->dae->F, independent_vars, mask, dF_row, dF_col);
        
        for(i = 0; i < dF_n_nz;i++){
            if(dF_row[i] > dF_n_eq){
                dF_n_eq = dF_row[i];
            }
        }
        dF_n_eq++;
        
        passed = 0;
        failed = 0;
        
        if(sparsity & JMI_DER_SPARSE){
            jmi_real_t *jac_cad = (jmi_real_t*)calloc(dF_n_nz, sizeof(jmi_real_t));
            jmi_real_t *jac_fd;
            jmi_func_cad_dF(jmi,jmi->dae->F, sparsity, independent_vars, mask, jac_cad);        
            jac_fd = (jmi_real_t*)calloc(dF_n_nz, sizeof(jmi_real_t));
            jmi_func_fd_dF(jmi,jmi->dae->F, sparsity, independent_vars, mask, jac_fd);
            for(i = 0; i < dF_n_nz; i++){
                if(jac_fd[i] != 0 && jac_cad[i] != 0){
                    jmi_real_t rel_tol;
                    rel_tol = 1.0 - jac_fd[i]/jac_cad[i];
                    if((rel_tol < tol) && (rel_tol > -tol)){
                        passed++;
                    } else{
                        if(screen_use & JMI_DER_CHECK_SCREEN_ON){
                            printf("\nFAILED\trow: %d,\t col: %d,\n", dF_row[i], dF_col[i]);
                            printf("cad: %.4f,\t fd: %.4f,\t rel_tol: %.7f\t\n ", jac_cad[i], jac_fd[i], rel_tol);
                            failed++;
                        } else if(screen_use & JMI_DER_CHECK_SCREEN_OFF){
                            printf("\nEvaluation error found, derivative check failed\n");
                            return -1;
                        } else{
                            printf("\nNo such flag\n");
                            return -1;
                        }
                    }
                }else{
                    jmi_real_t abs_tol;
                    abs_tol = jac_cad[i]-jac_fd[i];
                    if((abs_tol < tol) && (abs_tol > -tol)){
                        passed++;
                    } else{
                        if(screen_use & JMI_DER_CHECK_SCREEN_ON){
                            printf("\nFAILED\trow: %d,\t col: %d,\n", dF_row[i], dF_col[i]);
                            printf("cad: %.4f,\t fd: %.4f,\t abs_tol: %.7f\t\n", jac_cad[i], jac_fd[i], abs_tol);
                            failed++;
                        } else if(screen_use & JMI_DER_CHECK_SCREEN_OFF){
                            printf("\nEvaluation error found, derivative check failed\n");
                            return -1;
                        } else{
                            printf("\nNo such flag\n");
                            return -1;
                        }
                    }
                }
            }
            free(jac_cad);
            free(jac_fd);
            
        } else if(sparsity & JMI_DER_DENSE_COL_MAJOR){
            jmi_real_t *jac_cad = (jmi_real_t*)calloc(dF_n_cols*dF_n_eq, sizeof(jmi_real_t));
            jmi_real_t *jac_fd;
            jmi_func_cad_dF(jmi,jmi->dae->F, sparsity, independent_vars, mask, jac_cad);    
            jac_fd = (jmi_real_t*)calloc(dF_n_cols*dF_n_eq, sizeof(jmi_real_t));
            jmi_func_fd_dF(jmi,jmi->dae->F, sparsity, independent_vars, mask, jac_fd);
            for(i = 0; i < dF_n_cols*dF_n_eq; i++){
                if(jac_fd[i] != 0 && jac_cad[i] != 0){
                    jmi_real_t rel_tol;
                    rel_tol = 1.0 - jac_fd[i]/jac_cad[i];           
                    if((rel_tol < tol) && (rel_tol > -tol)){
                        passed++;
                    } else{
                        if(screen_use & JMI_DER_CHECK_SCREEN_ON){
                            printf("\nFAILED\trow: %d,\t col: %d,\n", i % dF_n_eq, (i - (i % dF_n_eq))/dF_n_eq);
                            printf("cad: %.4f,\t fd: %.4f,\t rel_tol: %.7f\n", jac_cad[i], jac_fd[i], rel_tol);
                            failed++;
                        } else if(screen_use & JMI_DER_CHECK_SCREEN_OFF){
                            printf("\nEvaluation error found, derivative check failed\n");
                            return -1;
                        } else{
                            printf("\nNo such flag\n");
                            return -1;
                        }
                    }
                }else{
                    jmi_real_t abs_tol;
                    abs_tol = jac_cad[i]-jac_fd[i];
                    if((abs_tol < tol) && (abs_tol > -tol)){
                        passed++;
                    } else{
                        if(screen_use & JMI_DER_CHECK_SCREEN_ON){
                            printf("\nFAILED\trow: %d,\t col: %d,\n", i % dF_n_eq, (i - (i % dF_n_eq))/dF_n_eq);
                            printf("cad: %.4f,\t fd: %.4f,\t abs_tol: %.7f\n", jac_cad[i], jac_fd[i], abs_tol);
                            failed++;
                        } else if(screen_use & JMI_DER_CHECK_SCREEN_OFF){
                            printf("\nEvaluation error found, derivative check failed\n");
                            return -1;
                        } else{
                            printf("\nNo such flag\n");
                            return -1;
                        }
                    }
                }
            }
            free(jac_cad);
            free(jac_fd);
            
        } else if(sparsity & JMI_DER_DENSE_ROW_MAJOR){
            jmi_real_t *jac_cad = (jmi_real_t*)calloc(dF_n_cols*dF_n_eq, sizeof(jmi_real_t));
            jmi_real_t *jac_fd;
            jmi_func_cad_dF(jmi,jmi->dae->F, sparsity, independent_vars, mask, jac_cad);    
            jac_fd = (jmi_real_t*)calloc(dF_n_cols*dF_n_eq, sizeof(jmi_real_t));
            jmi_func_fd_dF(jmi,jmi->dae->F, sparsity, independent_vars, mask, jac_fd);
            for(i = 0; i < dF_n_cols*dF_n_eq; i++){
                if(jac_fd[i] != 0 || jac_cad[i] != 0){
                    jmi_real_t rel_tol;
                    rel_tol = 1.0 - jac_fd[i]/jac_cad[i];   
                    if((rel_tol < tol) && (rel_tol > -tol)){
                        passed++;
                    } else{
                        if(screen_use & JMI_DER_CHECK_SCREEN_ON){
                            printf("\nFAILED\trow: %d,\t col: %d,\n", (i - (i % dF_n_cols))/dF_n_cols, i % dF_n_cols);
                            printf("cad: %.4f,\t fd: %.4f,\t rel_tol: %.7f\n", jac_cad[i], jac_fd[i], rel_tol);
                            failed++;
                        } else if(screen_use & JMI_DER_CHECK_SCREEN_OFF){
                            printf("\nEvaluation error found, derivative check failed\n");
                            return -1;
                        } else{
                            printf("\nNo such flag\n");
                            return -1;
                        }
                    }
                }
                else{
                    jmi_real_t abs_tol;
                    abs_tol = jac_cad[i]-jac_fd[i];
                    if((abs_tol < tol) && (abs_tol > -tol)){
                        passed++;
                    } else{
                        if(screen_use & JMI_DER_CHECK_SCREEN_ON){
                            printf("\nFAILED\trow: %d,\t col: %d,\n", (i - (i % dF_n_cols))/dF_n_cols, i % dF_n_cols);
                            printf("cad: %.4f,\t fd: %.4f,\t abs_tol: %.7f\n", jac_cad[i], jac_fd[i], abs_tol);
                            failed++;
                        } else if(screen_use & JMI_DER_CHECK_SCREEN_OFF){
                            printf("\nEvaluation error found, derivative check failed\n");
                            return -1;
                        } else{
                            printf("\nNo such flag\n");
                            return -1;
                        }
                    }
                }
            }
            free(jac_cad);
            free(jac_fd);
        } else{
            return -1;
        }
        if(screen_use & JMI_DER_CHECK_SCREEN_ON){
            printf("\nPASSED: %d\tFAILED: %d\n\n", passed, failed);
        }
        free(dF_row);
        free(dF_col);
        return 0;
}

int jmi_func_cad_dF_get_independent_ind(jmi_t *jmi, jmi_func_t *func, int independent_vars, int *col_independent_ind) {
    
    int n_dx = jmi->n_real_dx;
    int n_x = jmi->n_real_x;
    int n_u = jmi->n_real_u;
    int n_w = jmi->n_real_w;
    int n_t = 0;

    int max_n_nz = func->cad_dF_n_nz;
    
    int aim = 0;
    int i = 0;
    int j = 0;

    if(JMI_DER_T & independent_vars){
        n_t = 1;
    }
    
    aim+=n_dx;
    while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
        if(JMI_DER_DX & independent_vars){  
            col_independent_ind[j] = func->cad_dF_col[i];
            j++;
        }
        i++;
    }
    aim+=n_x;
    while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
        if(JMI_DER_X & independent_vars){
            col_independent_ind[j] = func->cad_dF_col[i];
            j++;
        }
        i++;
    }
    aim+=n_u;
    while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
        if(JMI_DER_U & independent_vars){
            col_independent_ind[j] = func->cad_dF_col[i];
            j++;
        }
        i++;
    }
    aim+=n_w;
    while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
        if(JMI_DER_W & independent_vars){   
            col_independent_ind[j] = func->cad_dF_col[i];
            j++;        
        }
        i++;
    }   
    aim+=n_t;
    while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
        if(JMI_DER_T & independent_vars){   
            col_independent_ind[j] = func->cad_dF_col[i];
            j++;        
        }
        i++;
    }
    return 0;
}

int jmi_compare_switches(jmi_real_t* sw_pre, jmi_real_t* sw_post, jmi_int_t size){
    int i;
    for (i=0;i<size;i++){
        if (sw_pre[i]!=sw_post[i]){
            return 0;
        }
    }
    return 1;
}

jmi_real_t jmi_turn_switch(jmi_real_t ev_ind, jmi_real_t sw, jmi_real_t eps, int rel) {
    /* x >= 0
     * x >  0
     * x <= 0
     * x <  0
     */

    if (eps == 0.0) {
        if (sw == 1.0){
            if ((ev_ind < 0.0 && rel == JMI_REL_GEQ) || (ev_ind <= 0.0 && rel == JMI_REL_GT) || (ev_ind > 0.0 && rel == JMI_REL_LEQ) || (ev_ind >= 0.0 && rel == JMI_REL_LT)){
                sw = 0.0;
            }
        }else{
            if ((ev_ind >= 0.0 && rel == JMI_REL_GEQ) || (ev_ind > 0.0 && rel == JMI_REL_GT) || (ev_ind <= 0.0 && rel == JMI_REL_LEQ) || (ev_ind < 0.0 && rel == JMI_REL_LT)){
                sw = 1.0;
            }
        }
    } else {
        if (sw == 1.0){
            if ((ev_ind <= -1*eps && rel == JMI_REL_GEQ) || (ev_ind <= 0.0 && rel == JMI_REL_GT) || (ev_ind >= eps && rel == JMI_REL_LEQ) || (ev_ind >= 0.0 && rel == JMI_REL_LT)){
                sw = 0.0;
            }
        }else{
            if ((ev_ind >= 0.0 && rel == JMI_REL_GEQ) || (ev_ind >= eps && rel == JMI_REL_GT) || (ev_ind <= 0.0 && rel == JMI_REL_LEQ) || (ev_ind <= -1*eps && rel == JMI_REL_LT)){
                sw = 1.0;
            }
        }
    }
    return sw;
}

jmi_real_t jmi_turn_switch_time(jmi_real_t ev_ind, jmi_real_t sw, jmi_real_t eps, int rel) {
    /* x >= 0
     * x >  0
     * x <= 0
     * x <  0
     */
    if (sw == 1.0){
        if ((ev_ind < -eps && rel == JMI_REL_GEQ) || (ev_ind <= eps && rel == JMI_REL_GT)
                || (ev_ind > eps && rel == JMI_REL_LEQ) || (ev_ind >= -eps && rel == JMI_REL_LT)) {
            sw = 0.0;
        }
    } else {
        if ((ev_ind >= -eps && rel == JMI_REL_GEQ) || (ev_ind > eps && rel == JMI_REL_GT)
                || (ev_ind <= eps && rel == JMI_REL_LEQ) || (ev_ind < -eps && rel == JMI_REL_LT)) {
            sw = 1.0;
        }
    }
    return sw;
}

int jmi_generic_func(jmi_t *jmi, jmi_generic_func_t func) {
    int return_status;
    int depth = jmi_prepare_try(jmi);
    if (jmi_try(jmi, depth))
        return_status = -1;
    else
        return_status = func(jmi);
    jmi_finalize_try(jmi, depth);
    return return_status;
}

int jmi_file_exists(const char* file) {
    FILE *fp;
    if (file && (fp = fopen(file,"r")))
        fclose(fp);
    else
        return 0;
    return 1;
}

int jmi_dir_exists(const char* dir) {
    DIR* dh;
    if(dir && (dh = opendir(dir)))
        closedir(dh);
    else
        return 0;
    return 1;
}

void jmi_load_resource(jmi_t *jmi, jmi_string_t res, const jmi_string_t file) {
    size_t len;
    jmi_string_t loc = jmi->resource_location;
    if (!loc) {
        jmi_log_node(jmi->log, logError, "Error", "Resource location unavailable.");
        strcpy(res,file);
        return;
    }
    len = strlen(loc) + strlen(file);
    if (len >= JMI_PATH_MAX) {
        jmi_log_node(jmi->log, logError, "Error", "File path too long: <Path:%s, File:%s>", loc, file);
        return;
    }
    strcpy(res, loc);
    strcat(res, file);
    if (!jmi_file_exists(res))
        jmi_log_node(jmi->log, logError, "Error", "Could not locate resource <File:%s>", res);
}
