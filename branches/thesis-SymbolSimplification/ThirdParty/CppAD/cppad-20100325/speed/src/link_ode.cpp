/* $Id: link_ode.cpp 1655 2010-02-11 19:59:43Z bradbell $ */
/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-10 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */

/*
$begin link_ode$$
$spell
	Jacobian
	fm
	bool
	CppAD
$$

$index link_ode$$
$index ode, speed test$$
$index speed, test ode$$
$index test, ode speed$$

$section Speed Testing the Jacobian of Ode Solution$$

$head Prototype$$
$codei%extern bool link_ode(
	size_t                 %size%      ,
	size_t                 %repeat%    ,
	CppAD::vector<double> &%x%         ,
	CppAD::vector<double> &%jacobian%
);
%$$

$head Purpose$$
Each $cref/package/speed_main/package/$$
must define a version of this routine as specified below.
This is used by the $cref/speed_main/$$ program
to run the corresponding speed and correctness tests.


$head f$$
The function 
$latex f : \R^n \rightarrow \R^n$$ that is defined and computed by
evaluating $cref/ode_evaluate/$$ with a call of the form
$codei%
	ode_evaluate(%x%, %m%, %fm%)
%$$
with $icode m$$ equal to zero.
Calls with the value $icode m$$ equal to one are used to check
the derivative values.

$head Return Value$$
If this speed test is not yet
supported by a particular $icode package$$,
the corresponding return value for $code link_ode$$
should be $code false$$.

$head size$$
The argument $icode size$$ 
is the number of variables in the ordinary differential equations
which is also equal to $latex n$$.

$head repeat$$
The argument $icode repeat$$ is the number of times the
Jacobian is computed. 

$head x$$
The argument $icode x$$ is a vector with $latex n$$ elements.
The input value of the elements of $icode x$$ does not matter.
On output, it has been set to the
argument value for which the function,
or its derivative, is being evaluated.
The value of this vector must change with each repetition.

$head jacobian$$
The argument $icode jacobian$$ is a vector with $latex n^2$$ elements.
The input value of its elements does not matter. 
The output value of its elements is the Jacobian of the function $latex f(x)$$
that corresponds to output value of $icode x$$.
To be more specific, for
$latex i = 0 , \ldots , n-1$$ and $latex j = 0 , \ldots , n-1$$,
$latex \[
	\D{f[i]}{x[j]} (x) = jacobian [ i \cdot n + j ]
\] $$

$subhead double$$
In the case where $icode package$$ is $code double$$,
only the first $latex n$$ element of $icode jacobian$$
are modified and they are to the function value
$latex f(x)$$ corresponding to the output value of $icode x$$.

$end 
-----------------------------------------------------------------------------
*/
# include <cppad/vector.hpp>
# include <cppad/speed/ode_evaluate.hpp>
# include <cppad/near_equal.hpp>

extern bool link_ode(
	size_t                     size       ,
	size_t                     repeat     ,
	CppAD::vector<double>      &x         ,
	CppAD::vector<double>      &jacobian
);
bool available_ode(void)
{	size_t n      = 1;
	size_t repeat = 1;
	CppAD::vector<double> x(n);
	CppAD::vector<double> jacobian(n * n);

	return link_ode(n, repeat, x, jacobian);
}
bool correct_ode(bool is_package_double)
{	bool ok       = true;

	size_t n      = 5;
	size_t repeat = 1;
	CppAD::vector<double> x(n);
	CppAD::vector<double> jacobian(n * n);

	link_ode(n, repeat, x, jacobian);

	size_t size = n * n;
	size_t m = 1;
	if( is_package_double )
	{	m    = 0;  // check function value
		size = n;
	}
	CppAD::vector<double> check(size);
	CppAD::ode_evaluate(x, m, check);
	size_t k;
	for(k = 0; k < size; k++)
		ok &= CppAD::NearEqual(check[k], jacobian[k], 1e-6, 1e-6);

	return ok;
}
void speed_ode(size_t n, size_t repeat)
{
	CppAD::vector<double> x(n);
	CppAD::vector<double> jacobian(n * n);
	link_ode(n, repeat, x, jacobian);
	return;
}
