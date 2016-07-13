 /*
    Copyright (C) 2016 Modelon AB

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


/** \file jmi_math.h
 *  \brief Mathematical functions used in the run-time and code-gen.
 */

#ifndef _JMI_MATH_H
#define _JMI_MATH_H

#include "jmi_types.h"

/* Define the machine epsilon */
#define JMI_EPS 2.2204460492503131e-16
#define JMI_ALMOST_EPS (JMI_EPS*100)

/*#define ALMOST_ZERO(op) (jmi_abs(op)<=1e-6? JMI_TRUE: JMI_FALSE)*/
#define ALMOST_ZERO(op) LOG_EXP_AND(ALMOST_LT_ZERO(op),ALMOST_GT_ZERO(op))
#define ALMOST_LT_ZERO(op) (op<=JMI_ALMOST_EPS? JMI_TRUE: JMI_FALSE)
#define ALMOST_GT_ZERO(op) (op>=-JMI_ALMOST_EPS? JMI_TRUE: JMI_FALSE)
#define SURELY_LT_ZERO(op) (op<-JMI_ALMOST_EPS? JMI_TRUE: JMI_FALSE)
#define SURELY_GT_ZERO(op) (op>JMI_ALMOST_EPS? JMI_TRUE: JMI_FALSE)

/**
 * Function for checking if a vector contains NAN values. Returns the
 * index of the NAN (if found) in the parameter index_of_nan
 */
int jmi_check_nan(jmi_t *jmi, jmi_real_t* val, size_t n_val, jmi_int_t* index_of_nan);

/**
 * Function to wrap division and report errors to the log, for use in functions.
 */
jmi_ad_var_t jmi_divide_function(const char* name, jmi_ad_var_t num, jmi_ad_var_t den, const char* msg);

/**
 * Function to wrap division and report errors to the log, for use in equations.
 */
jmi_ad_var_t jmi_divide_equation(jmi_t *jmi, jmi_ad_var_t num, jmi_ad_var_t den, const char* msg);

/**
 * Function to wrap atan2 and report errors to the log, for use in functions.
 */
jmi_ad_var_t jmi_atan2_function(const char* name, jmi_ad_var_t x, jmi_ad_var_t y, const char* msg);

/**
 * Function to wrap atan2 and report errors to the log, for use in equations.
 */
jmi_ad_var_t jmi_atan2_equation(jmi_t *jmi, jmi_ad_var_t x, jmi_ad_var_t y, const char* msg);

/**
 * Function to wrap the C pow function and report errors to the log, for use in functions.
 */
jmi_ad_var_t jmi_pow_function(const char* name, jmi_ad_var_t x, jmi_ad_var_t y, const char* msg);

/**
 * Function to wrap the C pow function and report errors to the log, for use in equations.
 */
jmi_ad_var_t jmi_pow_equation(jmi_t *jmi, jmi_ad_var_t x, jmi_ad_var_t y, const char* msg);

/**
 * Function to wrap the C exp function and report errors to the log, for use in functions.
 */
jmi_ad_var_t jmi_exp_function(const char* name, jmi_ad_var_t x, const char* msg);

/**
 * Function to wrap the C exp function and report errors to the log, for use in equations.
 */
jmi_ad_var_t jmi_exp_equation(jmi_t *jmi, jmi_ad_var_t x, const char* msg);

/**
 * Function to wrap the C log function and report errors to the log, for use in functions.
 */
jmi_ad_var_t jmi_log_function(const char* name, jmi_ad_var_t x, const char* msg);

/**
 * Function to wrap the C log function and report errors to the log, for use in equations.
 */
jmi_ad_var_t jmi_log_equation(jmi_t *jmi, jmi_ad_var_t x, const char* msg);

/**
 * Function to wrap the C log10 function and report errors to the log, for use in functions.
 */
jmi_ad_var_t jmi_log10_function(const char* name, jmi_ad_var_t x, const char* msg);

/**
 * Function to wrap the C log10 function and report errors to the log, for use in equations.
 */
jmi_ad_var_t jmi_log10_equation(jmi_t *jmi, jmi_ad_var_t x, const char* msg);

/**
 * Function to wrap the C sinh function and report errors to the log, for use in functions.
 */
jmi_ad_var_t jmi_sinh_function(const char* name, jmi_ad_var_t x, const char* msg);

/**
 * Function to wrap the C sinh function and report errors to the log, for use in equations.
 */
jmi_ad_var_t jmi_sinh_equation(jmi_t *jmi, jmi_ad_var_t x, const char* msg);

/**
 * Function to wrap the C cosh function and report errors to the log, for use in functions.
 */
jmi_ad_var_t jmi_cosh_function(const char* name, jmi_ad_var_t x, const char* msg);

/**
 * Function to wrap the C cosh function and report errors to the log, for use in equations.
 */
jmi_ad_var_t jmi_cosh_equation(jmi_t *jmi, jmi_ad_var_t x, const char* msg);

/**
 * Function to wrap the C tan function and report errors to the log, for use in functions.
 */
jmi_ad_var_t jmi_tan_function(const char* name, jmi_ad_var_t x, const char* msg);

/**
 * Function to wrap the C tan function and report errors to the log, for use in equations.
 */
jmi_ad_var_t jmi_tan_equation(jmi_t *jmi, jmi_ad_var_t x, const char* msg);

/**
 * Function to get the absolute value.
 * Is a separate function to avoid evaluating expressions several times.
 */
jmi_ad_var_t jmi_abs(jmi_ad_var_t v);

/**
 * Function to get the absolute value.
 * Is a separate function to avoid evaluating expressions several times.
 */
jmi_ad_var_t jmi_sign(jmi_ad_var_t v);

/**
 * Function to get the smaller of two values.
 * Is a separate function to avoid evaluating expressions twice.
 */
jmi_ad_var_t jmi_min(jmi_ad_var_t x, jmi_ad_var_t y);

/**
 * Function to get the larger of two values.
 * Is a separate function to avoid evaluating expressions twice.
 */
jmi_ad_var_t jmi_max(jmi_ad_var_t x, jmi_ad_var_t y);

/**
 * The round function for double numbers. 
 *
 */
jmi_real_t jmi_dround(jmi_real_t x);

/**
 * The remainder function for double numbers. 
 *
 */
jmi_real_t jmi_dremainder(jmi_t* jmi, jmi_real_t x, jmi_real_t y);

/**
 * The sample operator. Returns true if time = offset + i*h, i>=0 during
 * handling of an event. During continuous integration, false is returned.
 *
 */
jmi_ad_var_t jmi_sample(jmi_t* jmi, jmi_real_t offset, jmi_real_t h);

/**
 * Performs a vector vector multiplication (x*y).
 * The result is stored in x.
 */
int jmi_vector_mul(jmi_real_t* x, jmi_real_t* y, jmi_int_t n);
/**
 * Performs a matrix times a diagonal matrix multiplication (A*D).
 * The result is stored in A.
 */
int jmi_matrix_diagonal_mul(jmi_real_t* A, jmi_real_t* D, jmi_int_t n);


#endif /* _JMI_MATH_H */
