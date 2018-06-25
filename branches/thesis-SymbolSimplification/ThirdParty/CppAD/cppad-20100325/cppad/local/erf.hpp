/* $Id: erf.hpp 1369 2009-05-31 01:31:48Z bradbell $ */
# ifndef CPPAD_ERF_INCLUDED
# define CPPAD_ERF_INCLUDED

/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-08 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */

/*
-------------------------------------------------------------------------------
$begin erf$$

$section The AD Error Function$$
$spell
	Vedder
	Cpp
	namespace
	Vec
	erf
	const
$$

$index erf, AD function$$
$index error, AD function$$
$index function, error AD$$

$head Syntax$$
$icode%y% = erf(%x%)%$$


$head Description$$
Returns the value of the error function which is defined by
$latex \[
{\rm erf} (x) = \frac{2}{ \sqrt{\pi} } \int_0^x \exp( - t * t ) \; {\bf d} t
\] $$

$head x$$
The argument $icode x$$, and the result $icode y$$
have one of the following paris of prototypes:
$codei%
	const float%%                  &%x%,     float%%    %y%
	const double%%                 &%x%,     double%%   %y%
	const AD<%Base%>               &%x%,     AD<%Base%> %y%
	const VecAD<%Base%>::reference &%x%,     AD<%Base%> %y%
%$$


$head Operation Sequence$$
The AD of $icode Base$$
operation sequence used to calculate $icode y$$ is
$xref/glossary/Operation/Independent/independent/1/$$
of $icode x$$.

$head Method$$
This is a fast approximation (few numerical operations) 
with relative error bound $latex 4 \times 10^{-4}$$; see
Vedder, J.D.,
$italic Simple approximations for the error function and its inverse$$,
American Journal of Physics, 
v 55, 
n 8, 
1987, 
p 762-3.

$head Example$$
$children%
	example/erf.cpp
%$$
The file
$xref/Erf.cpp/$$
contains an example and test of this function.   
It returns true if it succeeds and false otherwise.

$end
-------------------------------------------------------------------------------
*/

// BEGIN CppAD namespace
namespace CppAD {   

template <class Type>
Type erf_template(const Type &x)
{	using CppAD::exp;
	static Type a = static_cast<Type>(993./880.);
	static Type b = static_cast<Type>(89./880.); 

	return tanh( (a + b * x * x) * x );
}

inline float erf(const float &x)
{	return erf_template(x); }

inline double erf(const double &x)
{	return erf_template(x); }

template <class Base>
inline AD<Base> erf(const AD<Base> &x)
{	return erf_template(x); }

template <class Base>
inline AD<Base> erf(const VecAD_reference<Base> &x)
{	return erf_template( x.ADBase() ); }


} // END CppAD namespace

# endif
