/* $Id: jac_g_map.hpp 1634 2010-01-24 08:44:17Z bradbell $ */
# ifndef  CPPAD_JAC_G_MAP_INCLUDED
# define  CPPAD_JAC_G_MAP_INCLUDED
/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-10 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */
# include "cppad_ipopt_nlp.hpp"
CPPAD_BEGIN_NAMESPACE
/*!
\file jac_g_map.hpp
\brief Create a mapping between two representations for Jacobian of g.
*/

extern void jac_g_map(
	cppad_ipopt_fg_info*  fg_info                                  , 
	size_t                                          m              ,
	size_t                                          n              ,
	size_t                                          K              ,
	const CppAD::vector<size_t>&                    L              ,
	const CppAD::vector<size_t>&                    p              ,
	const CppAD::vector<size_t>&                    q              ,
	const CppAD::vector<CppAD::vectorBool>&         pattern_jac_r  ,
	CppAD::vector<size_t>&                          I              ,
	CppAD::vector<size_t>&                          J              ,
	CppAD::vector< std::map<size_t,size_t> >&       index_jac_g    
);

CPPAD_END_NAMESPACE
# endif
