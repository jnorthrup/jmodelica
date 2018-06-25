/* $Id: cond_exp.cpp 1454 2009-07-06 17:27:45Z bradbell $ */
/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-09 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */

/*
$begin CondExp.cpp$$
$spell
	Cpp
	cstddef
	CondExp
$$

$section Conditional Expressions: Example and Test$$

$index CondExp$$
$index example, CondExp$$
$index test, CondExp$$

$head Description$$
Use $code CondExp$$ to compute
$latex \[
	f(x) = \sum_{j=0}^{m-1} x_j \log( x_j )
\] $$
and its derivative at various argument values
( where $latex x_j \geq 0$$ )
with out having to re-tape; i.e.,
using only one $xref/ADFun/$$ object.
Note that $latex x_j \log ( x_j ) \rightarrow 0 $$
as $latex x_j \downarrow 0$$ and
we need to handle the case $latex x_j = 0$$
in a special way to avoid multiplying zero by infinity.

$code
$verbatim%example/cond_exp.cpp%0%// BEGIN PROGRAM%// END PROGRAM%1%$$
$$

$end
*/
// BEGIN PROGRAM

# include <cppad/cppad.hpp>
# include <limits>

bool CondExp(void)
{	bool ok = true;

	using CppAD::isnan;
	using CppAD::AD;
	using CppAD::NearEqual;
	using CppAD::log; 
	using CppAD::abs;
	double eps  = 100. * std::numeric_limits<double>::epsilon();
	double fmax = std::numeric_limits<double>::max();

	// domain space vector
	size_t n = 5;
	CPPAD_TEST_VECTOR< AD<double> > X(n);
	size_t j;
	for(j = 0; j < n; j++)
		X[j] = 1.;

	// declare independent variables and start tape recording
	CppAD::Independent(X);

	AD<double> Sum  = 0.;
	AD<double> Zero = 0.;
	for(j = 0; j < n; j++)
	{	// if x_j > 0, add x_j * log( x_j ) to the sum
		Sum += CppAD::CondExpGt(X[j], Zero, X[j] * log(X[j]),    Zero);
	}

	// range space vector 
	size_t m = 1;
	CPPAD_TEST_VECTOR< AD<double> > Y(m);
	Y[0] = Sum;

	// create f: X -> Y and stop tape recording
	CppAD::ADFun<double> f(X, Y);

	// vectors for arguments to the function object f
	CPPAD_TEST_VECTOR<double> x(n);   // argument values
	CPPAD_TEST_VECTOR<double> y(m);   // function values 
	CPPAD_TEST_VECTOR<double> w(m);   // function weights 
	CPPAD_TEST_VECTOR<double> dw(n);  // derivative of weighted function

	// a case where x[j] > 0 for all j
	double check  = 0.;
	for(j = 0; j < n; j++)
	{	x[j]   = double(j + 1); 
		check += x[j] * log( x[j] );
	}

	// function value 
	y  = f.Forward(0, x);
	ok &= NearEqual(y[0], check, eps, eps);

	// compute derivative of y[0]
	w[0] = 1.;
	dw   = f.Reverse(1, w);
	for(j = 0; j < n; j++)
		ok &= NearEqual(dw[j], log(x[j]) + 1., eps, eps); 

	// a case where x[3] is equal to zero
	check -= x[3] * log( x[3] );
	x[3]   = 0.;

	// function value 
	y   = f.Forward(0, x);
	ok &= NearEqual(y[0], check, eps, eps);

	// check derivative of y[0]
	w[0] = 1.;
	dw   = f.Reverse(1, w);
	for(j = 0; j < n; j++)
	{	if( x[j] > 0 )
			ok &= NearEqual(dw[j], log(x[j]) + 1., eps, eps); 
		else
		{	// In this case computing dw[j] is computed using 
			//      log(x[j]) + x[j] / x[j] 
			// which has limit minus infinity but computes as nan.
			ok &= ( isnan( dw[j] ) || dw[j] <= -fmax );
		}
	}
	
	return ok;
}
// END PROGRAM
