/* $Id: opt_val_hes.cpp 1643 2010-02-04 05:45:21Z bradbell $ */
/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-10 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */

/*
$begin opt_val_hes.cpp$$
$spell
	hes
$$

$section opt_val_hes: Example and Test$$

$index opt_val_hes, example$$
$index example, opt_val_hes$$
$index test, opt_val_hes$$

Fix $latex z \in \R^\ell$$ and define the functions
$latex S_k : \R \times \R \rightarrow \R^\ell$$ by and
$latex F : \R \times \R \rightarrow \R$$ by
$latex \[
\begin{array}{rcl}
S_k (x, y) & = & \frac{1}{2} [ y * \sin ( x * t_k ) - z_k ]^2
\\
F(x, y)    & = &  \sum_{k=0}^{\ell-1} S_k (x, y)
\end{array}
\] $$ 
It follows that
$latex \[
\begin{array}{rcl}
\partial_y F(x, y) 
& = & 
\sum_{k=0}^{\ell-1} [ y * \sin ( x * t_k ) - z_k ] \sin( x * t_k )
\\
\partial_y \partial_y F(x, y)
& = & 
\sum_{k=0}^{\ell-1} \sin ( x t_k )^2
\end{array}
\] $$
Furthermore if we define $latex Y(x)$$ 
as solving the equation $latex \partial F[ x, Y(x) ] = 0 $$ we have
$latex \[
\begin{array}{rcl}
0 & = &
\sum_{k=0}^{\ell-1} [ Y(x) * \sin ( x * t_k ) - z_k ] \sin( x * t_k )
\\
Y(x) \sum_{k=0}^{\ell-1} \sin ( x * t_k )^2  
- \sum_{k=0}^{\ell-1} \sin ( x * t_k ) z_k
\\
Y(x) & = & \frac{
	\sum_{k=0}^{\ell-1} \sin( x * t_k ) z_k
	}{
	\sum_{k=0}^{\ell-1} \sin ( x * t_k )^2
}
\end{array}
\] $$

$code
$verbatim%example/opt_val_hes.cpp%0%// BEGIN PROGRAM%// END PROGRAM%1%$$
$$

$end
*/
// BEGIN PROGRAM

# include <limits>
# include <cppad/cppad.hpp>

namespace {
	using CppAD::AD;
	typedef CPPAD_TEST_VECTOR<double>       BaseVector;
	typedef CPPAD_TEST_VECTOR< AD<double> > ADVector;

	class Fun {
	private:
		const BaseVector t_;    // measurement times
		const BaseVector z_;    // measurement values
	public:
		typedef ADVector ad_vector; 
		// constructor
		Fun(const BaseVector &t, const BaseVector &z)
		: t_(t) , z_(z)
		{	assert( t.size() == z.size() ); }
		// ell
		size_t ell(void) const
		{	return t_.size(); }
		// Fun.s
		AD<double> s(size_t k, const ad_vector& x, const ad_vector& y) const
		{
			AD<double> residual = y[0] * sin( x[0] * t_[k] ) - z_[k];
			AD<double> s_k      = .5 * residual * residual;

			return s_k;
		}
		// Fun.sy
		ad_vector sy(size_t k, const ad_vector& x, const ad_vector& y) const
		{	assert( y.size() == 1);
			ad_vector sy_k(1);

			AD<double> residual = y[0] * sin( x[0] * t_[k] ) - z_[k];
			sy_k[0] = residual * sin( x[0] * t_[k] );
			
			return sy_k;
		}
	};
	// Used to test calculation of Hessian of V
	AD<double> V(const ADVector& x, const BaseVector& t, const BaseVector& z)
	{	// compute Y(x)
		AD<double> numerator = 0.;
		AD<double> denominator = 0.;
		size_t k;
		for(k = 0; k < t.size(); k++)
		{	numerator   += sin( x[0] * t[k] ) * z[k];
			denominator += sin( x[0] * t[k] ) * sin( x[0] * t[k] ); 	
		}
		AD<double> y = numerator / denominator;

		// V(x) = F[x, Y(x)]
		AD<double> sum = 0;
		for(k = 0; k < t.size(); k++)
		{	AD<double> residual = y * sin( x[0] * t[k] ) - z[k];
			sum += .5 * residual * residual;
		}
		return sum;
	}
}

bool opt_val_hes(void)
{	bool ok = true;
	using CppAD::AD;
	using CppAD::NearEqual;

	// temporary indices
	size_t j, k;

	// x space vector
	size_t n = 1;
	BaseVector x(n);
	x[0] = 2. * 3.141592653;

	// y space vector
	size_t m = 1;
	BaseVector y(m);
	y[0] = 1.;

	// t and z vectors
	size_t ell = 10;
	BaseVector t(ell);
	BaseVector z(ell);
	for(k = 0; k < ell; k++)
	{	t[k] = double(k) / double(ell);       // time of measurement
		z[k] = y[0] * sin( x[0] * t[k] );     // data without noise
	}

	// construct the function object 
	Fun fun(t, z);

	// evaluate the Jacobian and Hessian 
	BaseVector jac(n), hes(n * n);
	int signdet = CppAD::opt_val_hes(x, y, fun, jac, hes);

	// we know that F_yy is positive definate for this case
	assert( signdet == 1 );

	// create ADFun object g corresponding to V(x)
	ADVector a_x(n), a_v(1);
	for(j = 0; j < n; j++)
		a_x[j] = x[j];
	Independent(a_x);
	a_v[0] = V(a_x, t, z);
	CppAD::ADFun<double> g(a_x, a_v);

	// accuracy for checks
	double eps = 10. * std::numeric_limits<double>::epsilon();

	// check Jacobian
	BaseVector check_jac = g.Jacobian(x);
	for(j = 0; j < n; j++)
		ok &= NearEqual(jac[j], check_jac[j], eps, eps);

	// check Hessian
	BaseVector check_hes = g.Hessian(x, 0);
	for(j = 0; j < n*n; j++)
		ok &= NearEqual(hes[j], check_hes[j], eps, eps);

	return ok;
}

// END PROGRAM
