/* $Id: ode.cpp 1497 2009-08-13 16:57:34Z bradbell $ */
/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-09 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */
/*
$begin double_ode.cpp$$
$spell
	Jacobian
	CppAD
	cppad
	hpp
	bool
	cstring
	retape
	resize
	endif
$$

$section Double Speed: Ode Solution$$

$index double, speed ode$$
$index speed, double ode$$
$index ode, speed double$$

$head link_ode$$
$index link_ode$$
$codep */
# include <cstring>
# include <cppad/vector.hpp>
# include <cppad/speed/ode_evaluate.hpp>
# include <cppad/speed/uniform_01.hpp>

bool link_ode(
	size_t                     size       ,
	size_t                     repeat     ,
	CppAD::vector<double>      &x         ,
	CppAD::vector<double>      &jacobian
)
{	// -------------------------------------------------------------
	// setup

	size_t n = size;
	assert( x.size() == n );

	size_t m = 0;
	CppAD::vector<double> f(n);

	while(repeat--)
	{ 	// choose next x value
		uniform_01(n, x);

		// evaluate function
		CppAD::ode_evaluate(x, m, f);

	}
	size_t i;
	for(i = 0; i < n; i++)
		jacobian[i] = f[i];
	return true;
}
/* $$
$end
*/
