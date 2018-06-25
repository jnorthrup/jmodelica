/* $Id: runge_45.hpp 1370 2009-05-31 05:31:50Z bradbell $ */
# ifndef CPPAD_RUNGE_45_INCLUDED
# define CPPAD_RUNGE_45_INCLUDED

/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-08 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */

/*
$begin Runge45$$
$spell
	cppad.hpp
	bool
	xf
	templated
	const
	Runge-Kutta
	CppAD
	xi
	ti
	tf
	Karp
$$

$index Runge45$$
$index ODE, Runge-Kutta$$
$index Runge, ODE$$
$index Kutta, ODE$$
$index solve, ODE$$
$index differential, equation$$
$index equation, differential$$
 
$section An Embedded 4th and 5th Order Runge-Kutta ODE Solver$$

$head Syntax$$
$syntax%# include <cppad/runge_45.hpp>
%$$
$syntax%%xf% = Runge45(%F%, %M%, %ti%, %tf%, %xi%)
%$$
$syntax%%xf% = Runge45(%F%, %M%, %ti%, %tf%, %xi%, %e%)
%$$


$head Purpose$$
This is an implementation of the
Cash-Karp embedded 4th and 5th order Runge-Kutta ODE solver 
described in Section 16.2 of $xref/Bib/Numerical Recipes/Numerical Recipes/$$.
We use $latex n$$ for the size of the vector $italic xi$$.
Let $latex \R$$ denote the real numbers
and let $latex F : \R \times \R^n \rightarrow \R^n$$ be a smooth function.
The return value $italic xf$$ contains a 5th order
approximation for the value $latex X(tf)$$ where 
$latex X : [ti , tf] \rightarrow \R^n$$ is defined by 
the following initial value problem:
$latex \[
\begin{array}{rcl}
	X(ti)  & = & xi    \\
	X'(t)  & = & F[t , X(t)] 
\end{array}
\] $$
If your set of ordinary differential equations
are stiff, an implicit method may be better
(perhaps $xref/Rosen34/$$.)

$head Include$$
The file $code cppad/runge_45.hpp$$ is included by $code cppad/cppad.hpp$$
but it can also be included separately with out the rest of 
the $code CppAD$$ routines.

$head xf$$
The return value $italic xf$$ has the prototype
$syntax%
	%Vector% %xf%
%$$
and the size of $italic xf$$ is equal to $italic n$$ 
(see description of $xref/Runge45/Vector/Vector/$$ below).
$latex \[
	X(tf) = xf + O( h^6 )
\] $$
where $latex h = (tf - ti) / M$$ is the step size.
If $italic xf$$ contains not a number $cref/nan/$$,
see the discussion for $cref/f/Runge45/Fun/f/$$.

$head Fun$$
The class $italic Fun$$ 
and the object $italic F$$ satisfy the prototype
$syntax%
	%Fun% &%F%
%$$
The object $italic F$$ (and the class $italic Fun$$)
must have a member function named $code Ode$$ 
that supports the syntax
$syntax%
	%F%.Ode(%t%, %x%, %f%)
%$$

$subhead t$$
The argument $italic t$$ to $syntax%%F%.Ode%$$ has prototype
$syntax%
	const %Scalar% &%t%
%$$
(see description of $xref/Runge45/Scalar/Scalar/$$ below). 

$subhead x$$
The argument $italic x$$ to $syntax%%F%.Ode%$$ has prototype
$syntax%
	const %Vector% &%x%
%$$
and has size $italic n$$
(see description of $xref/Runge45/Vector/Vector/$$ below). 

$subhead f$$
The argument $italic f$$ to $syntax%%F%.Ode%$$ has prototype
$syntax%
	%Vector% &%f%
%$$
On input and output, $italic f$$ is a vector of size $italic n$$
and the input values of the elements of $italic f$$ do not matter.
On output,
$italic f$$ is set equal to $latex F(t, x)$$ in the differential equation.
If any of the elements of $italic f$$ have the value not a number $code nan$$
the routine $code Runge45$$ returns with all the
elements of $italic xf$$ and $italic e$$ equal to $code nan$$.

$subhead Warning$$
The argument $italic f$$ to $syntax%%F%.Ode%$$
must have a call by reference in its prototype; i.e.,
do not forget the $code &$$ in the prototype for $italic f$$.

$head M$$
The argument $italic M$$ has prototype
$syntax%
	size_t %M%
%$$
It specifies the number of steps
to use when solving the differential equation.
This must be greater than or equal one.
The step size is given by $latex h = (tf - ti) / M$$, thus
the larger $italic M$$, the more accurate the
return value $italic xf$$ is as an approximation
for $latex X(tf)$$.

$head ti$$
The argument $italic ti$$ has prototype
$syntax%
	const %Scalar% &%ti%
%$$
(see description of $xref/Runge45/Scalar/Scalar/$$ below). 
It specifies the initial time for $italic t$$ in the 
differential equation; i.e., 
the time corresponding to the value $italic xi$$.

$head tf$$
The argument $italic tf$$ has prototype
$syntax%
	const %Scalar% &%tf%
%$$
It specifies the final time for $italic t$$ in the 
differential equation; i.e., 
the time corresponding to the value $italic xf$$.

$head xi$$
The argument $italic xi$$ has the prototype
$syntax%
	const %Vector% &%xi%
%$$
and the size of $italic xi$$ is equal to $italic n$$.
It specifies the value of $latex X(ti)$$

$head e$$
The argument $italic e$$ is optional and has the prototype
$syntax%
	%Vector% &%e%
%$$
If $italic e$$ is present,
the size of $italic e$$ must be equal to $italic n$$.
The input value of the elements of $italic e$$ does not matter.
On output
it contains an element by element
estimated bound for the absolute value of the error in $italic xf$$
$latex \[
	e = O( h^5 )
\] $$
where $latex h = (tf - ti) / M$$ is the step size.
If on output, $italic e$$ contains not a number $code nan$$,
see the discussion for $cref/f/Runge45/Fun/f/$$.

$head Scalar$$
The type $italic Scalar$$ must satisfy the conditions
for a $xref/NumericType/$$ type.
The routine $xref/CheckNumericType/$$ will generate an error message
if this is not the case.
In addition, the following operations must be defined for 
$italic Scalar$$ objects $italic a$$ and $italic b$$:

$table
$bold Operation$$ $cnext $bold Description$$  $rnext
$syntax%%a% < %b%$$ $cnext
	less than operator (returns a $code bool$$ object)
$tend

$head Vector$$
The type $italic Vector$$ must be a $xref/SimpleVector/$$ class with
$xref/SimpleVector/Elements of Specified Type/elements of type Scalar/$$.
The routine $xref/CheckSimpleVector/$$ will generate an error message
if this is not the case.

$head Example$$
$children%
	example/runge_45_1.cpp%
	example/runge_45_2.cpp
%$$
The file
$cref/runge_45_1.cpp/$$
contains a simple example and test of $code Runge45$$.
It returns true if it succeeds and false otherwise.
$pre

$$
The file
$cref/runge_45_2.cpp/$$ contains an example using $code Runge45$$
in the context of algorithmic differentiation.
It also returns true if it succeeds and false otherwise.

$head Source Code$$
The source code for this routine is in the file
$code cppad/runge_45.hpp$$.

$end
--------------------------------------------------------------------------
*/
# include <cstddef>
# include <cppad/local/cppad_assert.hpp>
# include <cppad/check_simple_vector.hpp>
# include <cppad/check_numeric_type.hpp>
# include <cppad/nan.hpp>

namespace CppAD { // BEGIN CppAD namespace

template <typename Scalar, typename Vector, typename Fun>
Vector Runge45(
	Fun           &F , 
	size_t         M , 
	const Scalar &ti , 
	const Scalar &tf , 
	const Vector &xi )
{	Vector e( xi.size() );
	return Runge45(F, M, ti, tf, xi, e);
}

template <typename Scalar, typename Vector, typename Fun>
Vector Runge45(
	Fun           &F , 
	size_t         M , 
	const Scalar &ti , 
	const Scalar &tf , 
	const Vector &xi ,
	Vector       &e )
{
	// check numeric type specifications
	CheckNumericType<Scalar>();

	// check simple vector class specifications
	CheckSimpleVector<Scalar, Vector>();

	// Cash-Karp parameters for embedded Runge-Kutta method
	// are static to avoid recalculation on each call and 
	// do not use Vector to avoid possible memory leak
	static Scalar a[6] = {
		Scalar(0),
		Scalar(1) / Scalar(5),
		Scalar(3) / Scalar(10),
		Scalar(3) / Scalar(5),
		Scalar(1),
		Scalar(7) / Scalar(8)
	};
	static Scalar b[5 * 5] = {
		Scalar(1) / Scalar(5),
		Scalar(0),
		Scalar(0),
		Scalar(0),
		Scalar(0),
		
		Scalar(3) / Scalar(40),
		Scalar(9) / Scalar(40),
		Scalar(0),
		Scalar(0),
		Scalar(0),
		
		Scalar(3) / Scalar(10),
		-Scalar(9) / Scalar(10),
		Scalar(6) / Scalar(5),
		Scalar(0),
		Scalar(0),
		
		-Scalar(11) / Scalar(54),
		Scalar(5) / Scalar(2),
		-Scalar(70) / Scalar(27),
		Scalar(35) / Scalar(27),
		Scalar(0),
		
		Scalar(1631) / Scalar(55296),
		Scalar(175) / Scalar(512),
		Scalar(575) / Scalar(13824),
		Scalar(44275) / Scalar(110592),
		Scalar(253) / Scalar(4096)
	};
	static Scalar c4[6] = {
		Scalar(2825) / Scalar(27648),
		Scalar(0),
		Scalar(18575) / Scalar(48384),
		Scalar(13525) / Scalar(55296),
		Scalar(277) / Scalar(14336),
		Scalar(1) / Scalar(4),
	};
	static Scalar c5[6] = {
		Scalar(37) / Scalar(378),
		Scalar(0),
		Scalar(250) / Scalar(621),
		Scalar(125) / Scalar(594),
		Scalar(0),
		Scalar(512) / Scalar(1771)
	};

	CPPAD_ASSERT_KNOWN(
		M >= 1,
		"Error in Runge45: the number of steps is less than one"
	);
	CPPAD_ASSERT_KNOWN(
		e.size() == xi.size(),
		"Error in Runge45: size of e not equal to size of xi"
	);
	size_t i, j, k, m;              // indices

	size_t  n = xi.size();          // number of components in X(t)
	Scalar  ns = Scalar(int(M));    // number of steps as Scalar object
	Scalar  h = (tf - ti) / ns;     // step size 
	Scalar  z = Scalar(0);          // zero
	for(i = 0; i < n; i++)          // initialize e = 0
		e[i] = z;

	// vectors used to store values returned by F
	Vector fh(6 * n), xtmp(n), ftmp(n), x4(n), x5(n), xf(n), nan_vec(n);

	// vector of nans
	for(i = 0; i < n; i++)
		nan_vec[i] = nan(z);

	xf = xi;           // initialize solution
	for(m = 0; m < M; m++)
	{	// time at beginning of this interval
		// (convert to int to avoid MS compiler warning)
		Scalar t = ti * (Scalar(int(M - m)) / ns) 
		         + tf * (Scalar(int(m)) / ns);

		// loop over integration steps
		x4 = x5 = xf;   // start x4 and x5 at same point for each step
		for(j = 0; j < 6; j++)
		{	// loop over function evaluations for this step
			xtmp = xf;  // location for next function evaluation
			for(k = 0; k < j; k++)
			{	// loop over previous function evaluations
				Scalar bjk = b[ (j-1) * 5 + k ];
				for(i = 0; i < n; i++)
				{	// loop over elements of x
					xtmp[i] += bjk * fh[i * 6 + k];
				}
			}
			// ftmp = F(t + a[j] * h, xtmp)
			F.Ode(t + a[j] * h, xtmp, ftmp); 
			if( hasnan(ftmp) )
			{	e = nan_vec;
				return nan_vec;
			}

			for(i = 0; i < n; i++)
			{	// loop over elements of x
				Scalar fhi    = ftmp[i] * h;
				fh[i * 6 + j] = fhi;
				x4[i]        += c4[j] * fhi;
				x5[i]        += c5[j] * fhi;
			}
		}
		// accumulate error bound
		for(i = 0; i < n; i++)
		{	// cant use abs because cppad.hpp may not be included
			Scalar diff = x5[i] - x4[i];
			if( diff < z )
				e[i] -= diff;
			else	e[i] += diff;
		}

		// advance xf for this step using x5
		xf = x5;
	}
	return xf;
}

} // End CppAD namespace 

# endif
