/* $Id: ode.cpp 1497 2009-08-13 16:57:34Z bradbell $ */
/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-09 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */
# include <cstring>
# include <cppad/vector.hpp>

/*
$begin adolc_ode.cpp$$
$spell
	Jacobian
        Adolc
        bool
        CppAD
	retape
$$

$section Adolc Speed: Ode$$

$codep */
// The adolc version of this test is not yet available
bool link_ode(
	size_t                     size       ,
	size_t                     repeat     ,
	CppAD::vector<double>      &x         ,
	CppAD::vector<double>      &jacobian
)
{
	return false;
}
/* $$
$end
*/
