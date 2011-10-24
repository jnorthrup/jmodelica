/* $Id: abs_op.hpp 1641 2010-02-01 16:39:45Z bradbell $ */
# ifndef CPPAD_ABS_OP_INCLUDED
# define CPPAD_ABS_OP_INCLUDED

/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-10 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */


CPPAD_BEGIN_NAMESPACE
/*!
\file abs_op.hpp
Forward and reverse mode calculations for z = abs(x).
*/


/*!
Compute forward mode Taylor coefficient for result of op = AbsOp.

The C++ source code corresponding to this operation is
\verbatim
	z = abs(x)
\endverbatim

\copydetails forward_unary1_op
*/
template <class Base>
inline void forward_abs_op(
	size_t j           ,
	size_t i_z         ,
	size_t i_x         ,
	size_t nc_taylor   , 
	Base*  taylor      )
{
	size_t k;
	static Base zero(0);

	// check assumptions
	CPPAD_ASSERT_UNKNOWN( NumArg(AbsOp) == 1 );
	CPPAD_ASSERT_UNKNOWN( NumRes(AbsOp) == 1 );
	CPPAD_ASSERT_UNKNOWN( i_x < i_z );
	CPPAD_ASSERT_UNKNOWN( j < nc_taylor );

	// Taylor coefficients corresponding to argument and result
	Base* x = taylor + i_x * nc_taylor;
	Base* z = taylor + i_z * nc_taylor;

	// order that decides positive, negative or zero
	k = 0;
	while( (k < j) & (x[k] == zero) )
		k++; 

	if( GreaterThanZero(x[k]) )
		z[j]  = x[j];
	else if( LessThanZero(x[k]) )
		z[j] = -x[j]; 
	else	z[j] = zero;
}

/*!
Compute zero order forward mode Taylor coefficient for result of op = AbsOp.

The C++ source code corresponding to this operation is
\verbatim
	z = abs(x)
\endverbatim

\copydetails forward_unary1_op_0
*/
template <class Base>
inline void forward_abs_op_0(
	size_t i_z         ,
	size_t i_x         ,
	size_t nc_taylor   , 
	Base*  taylor      )
{

	// check assumptions
	CPPAD_ASSERT_UNKNOWN( NumArg(AbsOp) == 1 );
	CPPAD_ASSERT_UNKNOWN( NumRes(AbsOp) == 1 );
	CPPAD_ASSERT_UNKNOWN( i_x < i_z );
	CPPAD_ASSERT_UNKNOWN( 0 < nc_taylor );

	// Taylor coefficients corresponding to argument and result
	Base y0 = *(taylor + i_x * nc_taylor);
	Base* z = taylor + i_z * nc_taylor;

	if( LessThanZero(y0) )
		z[0]  = - y0;
	else	z[0] = y0; 
}
/*!
Compute reverse mode partial derivatives for result of op = AbsOp.

The C++ source code corresponding to this operation is
\verbatim
	z = abs(x)
\endverbatim

\copydetails reverse_unary1_op
*/

template <class Base>
inline void reverse_abs_op(
	size_t      d            ,
	size_t      i_z          ,
	size_t      i_x          ,
	size_t      nc_taylor    , 
	const Base* taylor       ,
	size_t      nc_partial   ,
	Base*       partial      )
{	size_t j, k;	
	static Base zero(0);


	// check assumptions
	CPPAD_ASSERT_UNKNOWN( NumArg(AbsOp) == 1 );
	CPPAD_ASSERT_UNKNOWN( NumRes(AbsOp) == 1 );
	CPPAD_ASSERT_UNKNOWN( i_x < i_z );
	CPPAD_ASSERT_UNKNOWN( d < nc_taylor );
	CPPAD_ASSERT_UNKNOWN( d < nc_partial );

	// Taylor coefficients and partials corresponding to argument
	const Base* x  = taylor  + i_x * nc_taylor;
	Base* px       = partial + i_x * nc_partial;

	// Taylor coefficients and partials corresponding to result
	Base* pz       = partial +    i_z * nc_partial;

	// order that decides positive, negative or zero
	k = 0;
	while( (k < d) & (x[k] == zero) )
		k++; 

	if( GreaterThanZero(x[k]) )
	{	// partial of z w.r.t y is +1
		for(j = k; j <= d; j++)
			px[j] += pz[j];
	}
	else if( LessThanZero(x[k]) )
	{	// partial of z w.r.t y is -1
		for(j = k; j <= d; j++)
			px[j] -= pz[j];
	}
}

CPPAD_END_NAMESPACE
# endif
