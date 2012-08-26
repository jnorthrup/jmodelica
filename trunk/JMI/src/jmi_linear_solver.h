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

/** \file jmi_linear_solver.h
 *  \brief A linear solver based on LAPACK.
 */

#ifndef _JMI_LINEAR_SOLVER_H
#define _JMI_LINEAR_SOLVER_H

#include "jmi_common.h"

#if JMI_AD == JMI_AD_CPPAD
/* This must be done outside of 'extern "C"' */
#include <cppad/cppad.hpp>
#include <vector>
#endif /* JMI_AD == JMI_AD_CPPAD */

#ifdef JMI_AD_NONE_AND_CPP
extern "C" {
#endif /* JMI_AD_NONE_AND_CPP */

/* Lapack function */
extern void dgetrf_(int* M, int* N, double* A, int* LDA, int* IPIV, int* INFO );
extern void dgetrs_(char* TRANS, int* N, int* NRHS, double* A, int* LDA, int* IPIV, double* B, int* LDB, int* INFO);

typedef struct jmi_linear_solver_t jmi_linear_solver_t;

int jmi_linear_solver_new(jmi_linear_solver_t** solver, jmi_block_residual_t* block);

int jmi_linear_solver_solve(jmi_block_residual_t* block);

void jmi_linear_solver_delete(jmi_block_residual_t* block);

struct jmi_linear_solver_t {
    int* ipiv;                     /**< \brief Work vector needed for dgesv */
    jmi_real_t* factorization;      /**< \brief Matrix for storing the Jacobian factorization */
    int cached_jacobian;          /**< \brief This flag indicates weather the Jacobian needs to be refactorized */
};

#ifdef JMI_AD_NONE_AND_CPP
}
#endif /* JMI_AD_NONE_AND_CPP */
#endif /* _JMI_LINEAR_SOLVER_H */
