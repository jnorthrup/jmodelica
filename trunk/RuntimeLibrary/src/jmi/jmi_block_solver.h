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


/** \file jmi_block_solver.h
 *  \brief Equiation block solver interface.
 */

#ifndef _JMI_BLOCK_SOLVER_H
#define _JMI_BLOCK_SOLVER_H

#include "jmi_log.h"


/** \brief Evaluation modes for the residual function.*/
/** TODO: convert into enum */
#define JMI_BLOCK_INITIALIZE                                    0
#define JMI_BLOCK_EVALUATE                                      1
#define JMI_BLOCK_WRITE_BACK                                    2
#define JMI_BLOCK_EVALUATE_INACTIVE                             4
#define JMI_BLOCK_EVALUATE_NON_REALS                            8
#define JMI_BLOCK_MIN                                           16
#define JMI_BLOCK_MAX                                           32
#define JMI_BLOCK_NOMINAL                                       64
#define JMI_BLOCK_EVALUATE_JACOBIAN                             128
#define JMI_BLOCK_EQUATION_NOMINAL                              256
#define JMI_BLOCK_VALUE_REFERENCE                               512
#define JMI_BLOCK_SOLVED_NON_REAL_VALUE_REFERENCE               1024
#define JMI_BLOCK_ACTIVE_SWITCH_INDEX                           2048
#define JMI_BLOCK_START                                         4096
#define JMI_BLOCK_DIRECTLY_IMPACTING_NON_REAL_VALUE_REFERENCE   8192
#define JMI_BLOCK_DIRECTLY_ACTIVE_SWITCH_INDEX                  16384
#define JMI_BLOCK_SOLVED_REAL_VALUE_REFERENCE                   32768
#define JMI_BLOCK_NON_REAL_TEMP_VALUE_REFERENCE                 65536
#define JMI_BLOCK_START_SET                                     131072
#define JMI_BLOCK_EQUATION_NOMINAL_AUTO                         262144
#define JMI_BLOCK_EVALUATE_JAC                                  524288
#define JMI_BLOCK_GET_DEPENDENCY_MATRIX                         1048576

#define JMI_LIMIT_VALUE 1e30

/** \brief Jacobian variability for the linear solver */
typedef enum jmi_block_solver_jac_variability_t {
    JMI_CONSTANT_VARIABILITY=0,
    JMI_PARAMETER_VARIABILITY=1,
    JMI_DISCRETE_VARIABILITY=2,
    JMI_CONTINUOUS_VARIABILITY=4
} jmi_block_solver_jac_variability_t;

/** \brief Available block solvers */
typedef enum {
     JMI_SIMPLE_NEWTON_SOLVER, /* Only used for testing at some point. Not maintained. */
     JMI_KINSOL_SOLVER,
     JMI_LINEAR_SOLVER,
     JMI_MINPACK_SOLVER
} jmi_block_solver_kind_t;

/** \brief Scaling mode for the residuals in non-linear solver*/
typedef enum jmi_block_solver_residual_scaling_mode_t {
    jmi_residual_scaling_none = 0, /* must be zero */
    jmi_residual_scaling_auto = 1,
    jmi_residual_scaling_manual = 2,
    jmi_residual_scaling_hybrid = 3,
    jmi_residual_scaling_aggressive_auto = 4,
    jmi_residual_scaling_full_jacobian_auto = 5
} jmi_block_solver_residual_scaling_mode_t;

/** \brief Scaling mode for the iteration variables in the non-linear solver*/
typedef enum jmi_block_solver_iv_scaling_mode_t {
    jmi_iter_var_scaling_none = 0,
    jmi_iter_var_scaling_nominal = 1,
    jmi_iter_var_scaling_heuristics = 2
} jmi_block_solver_iv_scaling_mode_t;

/** \brief Exit criterion mode for the non-linear solver*/
typedef enum jmi_block_solver_exit_criterion_mode_t {
    jmi_exit_criterion_step_residual = 0, /* must be zero */
    jmi_exit_criterion_step = 1,
    jmi_exit_criterion_residual = 2,
    jmi_exit_criterion_hybrid = 3
} jmi_block_solver_exit_criterion_mode_t;

/** \brief Mode for Jacobian updates*/
typedef enum jmi_block_solver_jacobian_update_mode_t {
    jmi_full_jacobian_update_mode = 0, 
    jmi_broyden_jacobian_update_mode = 1,
    jmi_reuse_jacobian_update_mode = 2
} jmi_block_solver_jacobian_update_mode_t;

/** \brief Experimental features in the solver */
typedef enum jmi_block_solver_experimental_mode_t {
    jmi_block_solver_experimental_none = 0,
    jmi_block_solver_experimental_steepest_descent = 1,
    jmi_block_solver_experimental_steepest_descent_first = 2,
    jmi_block_solver_experimental_Brent = 4,
    jmi_block_solver_experimental_LU_through_sundials = 8,
    jmi_block_solver_experimental_Brent_with_newton = 16,
    jmi_block_solver_experimental_active_bounds_threshold = 32,
    jmi_block_solver_experimental_Broyden_with_zeros = 64,
    jmi_block_solver_experimental_nom_in_active_bounds = 128,
    jmi_block_solver_experimental_mode_jacobian_compression = 256,
    jmi_block_solver_experimental_check_descent_direction = 512,
    jmi_block_solver_experimental_Sparse_Broyden = 2048,
    jmi_block_solver_experimental_use_modifiedBFGS = 4096
} jmi_block_solver_experimental_mode_t;

typedef enum jmi_block_solver_status_t {
    jmi_block_solver_status_success = 0,
    jmi_block_solver_status_err_event_eval = 1,
    jmi_block_solver_status_inf_event_loop = 2,
    jmi_block_solver_status_event_non_converge = 3,
    jmi_block_solver_status_err_f_eval = 4,
    jmi_block_solver_status_err_jac_eval = 5
} jmi_block_solver_status_t;


/**
 * \brief Function signature for evaluation of a equation block residual
 * in the block solver interface.
 *
 * @param problem_data Problem data pointer passed in the jmi_block_solver_new.
 * @param x (Input/Output) The iteration variable vector. If the init argument is
 * set to JMI_BLOCK_INITIALIZE then x is an output argument that holds the
 * initial values. If init is set to JMI_BLOCK_EVALUATE, then x is an input
 * argument used in the evaluation of the residual.
 * @param residual (Output) The residual vector if init is set to
 * JMI_BLOCK_EVALUATE, otherwise this argument is not used.
 * @param mode Evaluation mode define
 * @return Error code.
 */
typedef int (*jmi_block_solver_residual_func_t)(void* problem_data, jmi_real_t* x,
        jmi_real_t* residual, int mode);
        
/**
 * \brief Function signature for evaluation of a directional derivatives for a
 * residual function in the block solver interface.
 *
 * @param problem_data Problem data pointer passed in the jmi_block_solver_new.
 * @param x (Input/Output) The iteration variable vector. If the init argument is
 * set to JMI_BLOCK_INITIALIZE then x is an output argument that holds the
 * initial values. If init is set to JMI_BLOCK_EVALUATE, then x is an input
 * argument used in the evaluation of the residual.
 * @param dx (input) The seed vector that is used if init is set to JMI_BLOCK_EVALUATE
 * @param dRes (output) the directional derivative if init is set to JMI_BLOCK_EVALUATE
 * @param residual (Output) The residual vector if init is set to
 * JMI_BLOCK_EVALUATE, otherwise this argument is not used.
 * @param mode Evaluation mode define
 * @return Error code.
 */
typedef int (*jmi_block_solver_dir_der_func_t)(void* problem_data, jmi_real_t* x,
         jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int mode);

/**
 * \brief Function signature for evaluation of the jacobian corresponding to 
 * an equation block residual in the block solver interface.
 *
 * @param problem_data Problem data pointer passed in the jmi_block_solver_new.
 * @param x (Input/Output) If mode is set to JMI_BLOCK_EVALUATE_JAC, then x is an input
 * argument used in the evaluation of the jacobian.
 * @param jac(Output) The jacobian matrix if mode is set to
 * JMI_BLOCK_EVALUATE_JAC, the dependency matrix if mode is set to JMI_BLOCK_GET_DEPENDENCY_MATRIX,
 * otherwise this argument is not used.
 * @param mode Evaluation mode define
 * @return Error code.
 */
typedef int (*jmi_block_solver_jacobian_func_t)(void* problem_data, jmi_real_t* x,
         jmi_real_t** jac, int mode);

/**
 * \brief Function signature for checking if discrete variables would change
 * if the Ivs are set to "x".
 *
 * @param problem_data (Input) Problem data pointer passed in the jmi_block_solver_new.
 * @param x (Input) The iteration variable vector. 
 * @return 0 if there is no change, 1 otherwise.
 */
typedef int (*jmi_block_solver_check_discrete_variables_change_func_t)(void* problem_data, double* x);

/**
 * \brief Function signature for updating discrete variables due to changes in
 *  the iteration variables. Values from the last residuals evaluation are used.
 *
 * @param problem_data (Input) Problem data pointer passed in the jmi_block_solver_new.
 * @param non_reals_changed_flag (Output) The flag indicating if discrete variables changed and further iterations are needed.
 * @return 0 on successful execution or error code.
 */
typedef jmi_block_solver_status_t (*jmi_block_solver_update_discrete_variables_func_t)(void* problem_data, int* non_reals_changed_flag);

/* TODO: log_discrete_variables is not really needed. Kept just to make sure there are not changes during refactoring */
typedef int (*jmi_block_solver_log_discrete_variables)(void* problem_data, jmi_log_node_t node);

typedef struct jmi_block_solver_t jmi_block_solver_t;
typedef struct jmi_block_solver_options_t jmi_block_solver_options_t;

/**
 * \brief Allocate the internal structure for the block solver.
 */
int jmi_new_block_solver(jmi_block_solver_t** block_solver_ptr,
                         jmi_callbacks_t* cb,
                         jmi_log_t* log,
                         jmi_block_solver_residual_func_t F,
                         jmi_block_solver_dir_der_func_t dF,  /* can be NULL if no directional derivative function is provided */
                         jmi_block_solver_jacobian_func_t Jacobian, /* can be NULL if, e.g., kin_dF should be used for Jacobian calculation */
                         jmi_block_solver_check_discrete_variables_change_func_t check_discrete_variables_change,
                         jmi_block_solver_update_discrete_variables_func_t update_discrete_variables,
                         jmi_block_solver_log_discrete_variables log_discrete_variables, /* Function for logging the discrete variables, can be NULL and then there is no logging of discrete variables */
                         int n,
                         jmi_block_solver_options_t* options,
                         void* problem_data);

/* Free allocated memory */
void jmi_delete_block_solver(jmi_block_solver_t** block_solver_ptr);

/**
 * \brief A equation block solver function signature.
 *
 * @param block A jmi_block_solver_t struct.
 * @return Error code.
 */
typedef int (*jmi_block_solver_solve_func_t)(jmi_block_solver_t* block_solver);

/**
 * \brief A equation block solver destructor signature.
 *
 * @param block A jmi_block_residual_t struct.
  */
typedef void (*jmi_block_solver_delete_func_t)(jmi_block_solver_t* block_solver);

/**
 * \brief A equation block signature for notifying the block that an integrator step has been accepted.
 * 
 * @param block A jmi_block_solver_t struct.
 * @return Error code.
 */
typedef int (*jmi_block_solver_completed_integrator_step_func_t)(jmi_block_solver_t* block_solver);

/**< \brief Equation block solver options. */
struct jmi_block_solver_options_t {
    double res_tol;                         /**< \brief Tolerance for the equation block solver */
    double min_tol;                         /**< \brief Minimal allowed value for the tolerance */
    double step_limit_factor;               /**< \brief Step limiting factor */
    double regularization_tolerance;        /**< \brief Tolerance for deciding when regularization should be performed */
    int max_iter;                           /**< \brief Maximum number of iterations for the equation block solver before failure */
    int max_iter_no_jacobian;               /**< \brief Maximum number of iterations for the equation block solver without full jacobian recalculation */

    jmi_block_solver_exit_criterion_mode_t solver_exit_criterion_mode; /**< \brief Exit criterion mode for non-linear block solver:
                                                                       0 - step length + residual, 1 - step length, 2 - residual, 3 -hybrid (default) */

    int enforce_bounds_flag;                /**< \brief Enforce min-max bounds on variables in the equation blocks*/
    int use_jacobian_equilibration_flag;    /**< \brief If jacobian equlibration should be used in equation block solvers */
    int use_Brent_in_1d_flag;               /**< \brief If Brent search should be used to improve accuracy in solution of 1D non-linear equations */

    int block_jacobian_check;               /**< \brief Compares analytic block jacobian with finite difference block jacobian */ 
    double block_jacobian_check_tol;        /**< \brief Tolerance for block jacobian comparison */
    
    jmi_block_solver_jacobian_update_mode_t jacobian_update_mode; /**< \brief Jacobian update mode in equation block solvers: 0 - full Jacobian, 1 - Broyden update */
    jmi_block_solver_residual_scaling_mode_t residual_equation_scaling_mode; /**< \brief Equations scaling mode in equation block solvers:0-no scaling,1-automatic scaling,2-manual scaling */

    double max_residual_scaling_factor;    /**< \breif Maximum residual scaling factor used in nle solver */
    double min_residual_scaling_factor;    /**< \breif Minimum residual scaling factor used in nle solver */

    jmi_block_solver_iv_scaling_mode_t iteration_variable_scaling_mode;    /**< \brief Iteration variables scaling mode in equation block solvers:
                                                                         0 - no scaling, 1 - scaling based on nominals only (default), 2 - utilize heuristict to guess nominal based on min,max,start, etc. */

    int rescale_each_step_flag;             /**< \brief If scaling should be updated at every step (only active if residual_equation_scaling_mode is not "none") */
    int rescale_after_singular_jac_flag;    /**< \brief If scaling should be updated after singular jac was detected (only active if residual_equation_scaling_mode is not "none") */

    int check_jac_cond_flag;       /**< \brief Flag if the solver should check Jacobian condition number and log it. */
    int brent_ignore_error_flag;   /**< \brief Flag if the solver should ignore errors in Brent solve. */
    int experimental_mode;         /**< \brief  Activate experimental features of equation block solvers. Combination of jmi_block_solver_experimental_mode_t flags. */
    double events_epsilon;         /**< \brief The event epsilon used for event indicators and switches. */
    int use_newton_for_brent;      /**< \brief If a few Newton steps are to be performed in order to get a better guess for Brent. */
    double active_bounds_threshold; /**< \brief Threshold for when we are at active bounds. */
    int use_nominals_as_fallback_in_init; /**< \brief If set, uses the nominals as initial guess in case everything else failed during initialization */
    int start_from_last_integrator_step; /**< \brief If set, uses the iteration variables from the last integrator step as initial guess. */
    int calculate_jacobian_externally; /**< \brief Flag indicating if the solver should use callback for calculating Jacobian */
    double jacobian_finite_difference_delta; /**< \brief Option for which delta to use in finite differences Jacobians, default sqrt(eps). */

    /* Options below are not supposed to change between invocations of the solver*/
    jmi_block_solver_kind_t solver; /**< brief Kind of block solver to use */
    jmi_block_solver_jac_variability_t jacobian_variability; /**< brief Jac variability for linear block solver */
    jmi_string_t label;                          /** label of this block solver (used for logging) */

};

/** \brief Solve the equations in the associated problem. */
int jmi_block_solver_solve(jmi_block_solver_t * block_solver, double cur_time, int handle_discrete_changes);

/** \brief Notify the block that an integrator step is completed */
int jmi_block_solver_completed_integrator_step(jmi_block_solver_t * block_solver);

/** \brief Initialize the options with defaults */
void jmi_block_solver_init_default_options(jmi_block_solver_options_t* op);

/** \brief Check and log illegal iv inputs */
int jmi_check_and_log_illegal_iv_input(jmi_block_solver_t* block, double* ivs, int N);

/** \brief Check and log illegal residual output(s) */
int jmi_check_and_log_illegal_residual_output(jmi_block_solver_t *block, double* f, double* ivs, double* heuristic_nominal,int N);
#endif /* _JMI_BLOCK_SOLVER_H */
