/* $Id: det_grad_33.hpp 1369 2009-05-31 01:31:48Z bradbell $ */
# ifndef CPPAD_DET_GRAD_33_INCLUDED
# define CPPAD_DET_GRAD_33_INCLUDED

/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-07 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */
/*
$begin det_grad_33$$
$spell
	cppad
	CppAD
	det
	cppad.hpp
	namespace
	const
	bool
$$

$section Check Gradient of Determinant of 3 by 3 matrix$$ 

$index det_grad_33$$
$index determinant, check correct$$
$index correct, determinant check$$
$index check, determinant correct$$

$head Syntax$$
$syntax%# include <cppad/speed/det_grad_33.hpp>
%$$
$syntax%%ok% = det_grad_33(%x%, %g%)%$$

$head Purpose$$
This routine can be used to check a method for computing the 
gradient of the determinant of a matrix.

$head Inclusion$$
The template function $code det_grad_33$$ is defined in the $code CppAD$$
namespace by including 
the file $code cppad/speed/det_grad_33.hpp$$ 
(relative to the CppAD distribution directory).
It is only intended for example and testing purposes, 
so it is not automatically included by
$cref/cppad.hpp/cppad/$$.

$head x$$
The argument $italic x$$ has prototype
$syntax%
	const %Vector% &%x%
%$$.
It contains the elements of the matrix $latex X$$ in row major order; i.e.,
$latex \[
	X_{i,j} = x [ i * 3 + j ]
\] $$

$head g$$
The argument $italic g$$ has prototype
$syntax%
	const %Vector% &%g%
%$$.
It contains the elements of the gradient of
$latex \det ( X )$$ in row major order; i.e.,
$latex \[
	\D{\det (X)}{X(i,j)} = g [ i * 3 + j ]
\] $$

$head Vector$$
If $italic y$$ is a $italic Vector$$ object, 
it must support the syntax
$syntax%
	%y%[%i%]
%$$
where $italic i$$ has type $code size_t$$ with value less than 9.
This must return a $code double$$ value corresponding to the $th i$$
element of the vector $italic y$$.
This is the only requirement of the type $italic Vector$$.

$head ok$$
The return value $italic ok$$ has prototype
$syntax%
	bool %ok%
%$$
It is true, if the gradient $italic g$$ 
passes the test and false otherwise.

$children%
	omh/det_grad_33_hpp.omh
%$$

$head Source Code$$
The file 
$cref/det_grad_33.hpp/$$
contains the source code for this template function.

$end
------------------------------------------------------------------------------
*/
// BEGIN PROGRAM
# include <cppad/near_equal.hpp>
namespace CppAD {
template <class Vector>
	bool det_grad_33(const Vector &x, const Vector &g)
	{	bool ok = true;
	
		// use expansion by minors to compute the derivative by hand
		double check[9];
		check[0] = + ( x[4] * x[8] - x[5] * x[7] );
		check[1] = - ( x[3] * x[8] - x[5] * x[6] );
		check[2] = + ( x[3] * x[7] - x[4] * x[6] );
		//
		check[3] = - ( x[1] * x[8] - x[2] * x[7] );
		check[4] = + ( x[0] * x[8] - x[2] * x[6] );
		check[5] = - ( x[0] * x[7] - x[1] * x[6] );
		//
		check[6] = + ( x[1] * x[5] - x[2] * x[4] );
		check[7] = - ( x[0] * x[5] - x[2] * x[3] );
		check[8] = + ( x[0] * x[4] - x[1] * x[3] ); 
		//
		size_t i;
		for(i = 0; i < 3 * 3; i++)
			ok &= CppAD::NearEqual(check[i], g[i], 1e-10, 1e-10);
		
		return ok;
	}
}
// END PROGRAM
# endif
