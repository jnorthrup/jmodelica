/* $Id: sparse_jacobian.cpp 1537 2009-10-01 03:52:53Z bradbell $ */
/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-09 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */
/*
$begin double_sparse_jacobian.cpp$$
$spell
	Jacobian
	fp
	bool
	cppad
	hpp
	CppAD
	cmath
	exp
	tmp
	std
$$

$section Double Speed: Sparse Jacobian$$

$index double, speed sparse jacobian$$
$index speed, double sparse jacobian$$
$index sparse, jacobian speed double$$

$head link_sparse_jacobian$$
$index link_sparse_jacobian$$
$codep */
# include <cppad/vector.hpp>
# include <cppad/speed/uniform_01.hpp>

// must include cmath before sparse_evaluate so that exp is defined for double
# include <cmath>
# include <cppad/speed/sparse_evaluate.hpp>

bool link_sparse_jacobian(
	size_t                     repeat   , 
	CppAD::vector<double>     &x        ,
	CppAD::vector<size_t>     &i        ,
	CppAD::vector<size_t>     &j        ,
	CppAD::vector<double>     &jacobian )
{
	// -----------------------------------------------------
	// setup
	using CppAD::vector;
	size_t order = 1;        // derivative order for f'(x)
	size_t n     = x.size(); // argument space dimension
	size_t ell   = i.size(); // size of index vectors
	vector<double> fp(n);    // f'(x)
	vector<double> y(ell);   // function value y = g(x)

	// temporaries
	size_t k;
	vector<double> tmp(2 * ell);

	// choose a value for x
	CppAD::uniform_01(n, x);
	
	// ------------------------------------------------------

	while(repeat--)
	{
		// get the next set of indices
		CppAD::uniform_01(2 * ell, tmp);
		for(k = 0; k < ell; k++)
		{	i[k] = size_t( n * tmp[k] );
			i[k] = std::min(n-1, i[k]);
			//
			j[k] = size_t( n * tmp[k + ell] );
			j[k] = std::min(n-1, j[k]);
		}

		// computation of the function
		CppAD::sparse_evaluate(x, i, j, order, fp);
		for(k = 0; k < ell; k++)
			y[k] = fp[ i[k] ];
	}
	for(k = 0; k < ell; k++)
		jacobian[k] = y[k];

	return true;
}
/* $$
$end
*/
