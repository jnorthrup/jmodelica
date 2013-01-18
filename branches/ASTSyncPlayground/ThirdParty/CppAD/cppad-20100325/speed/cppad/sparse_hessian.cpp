/* $Id: sparse_hessian.cpp 1644 2010-02-06 19:56:43Z bradbell $ */
/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-10 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */
/*
$begin cppad_sparse_hessian.cpp$$
$spell
	CppAD
	cppad
	hpp
	bool
	typedef
	endif
	tmp
	std
	var
	cout
	endl
$$

$section CppAD Speed: Sparse Hessian$$

$index cppad, speed sparse Hessian$$
$index speed, cppad sparse Hessian$$
$index Hessian, sparse speed cppad$$
$index sparse, Hessian speed cppad$$

$head Operation Sequence$$
Note that the 
$cref/operation sequence/glossary/Operation/Sequence/$$
depends on the vectors $italic i$$ and $italic j$$.
Hence we use a different $cref/ADFun/$$ object for 
each choice of $italic i$$ and $italic j$$.

$head Sparse Hessian$$
If the preprocessor symbol $code CPPAD_USE_SPARSE_HESSIAN$$ is 
true, the routine $cref/SparseHessian/sparse_hessian/$$ 
is used for the calculation.
Otherwise, the routine $cref/Hessian/$$ is used.

$head link_sparse_hessian$$
$index link_sparse_hessian$$
$codep */
# include <cppad/cppad.hpp>
# include <cppad/speed/uniform_01.hpp>
# include <cppad/speed/sparse_evaluate.hpp>

// value can be true or false
# define CPPAD_USE_SPARSE_HESSIAN  1

bool link_sparse_hessian(
	size_t                     repeat   , 
	CppAD::vector<double>     &x        ,
	CppAD::vector<size_t>     &i        ,
	CppAD::vector<size_t>     &j        ,
	CppAD::vector<double>     &hessian  )
{
	// -----------------------------------------------------
	// setup
	using CppAD::AD;
	typedef CppAD::vector<double>       DblVector;
	typedef CppAD::vector< AD<double> > ADVector;
	typedef CppAD::vector<size_t>       SizeVector;

	size_t order = 0;         // derivative order corresponding to function
	size_t m = 1;             // number of dependent variables
	size_t n = x.size();      // number of independent variables
	size_t ell = i.size();    // number of indices in i and j
	ADVector   X(n);          // AD domain space vector
	ADVector   Y(m);          // AD range space vector
	DblVector  w(m);          // double range space vector
	DblVector tmp(2 * ell);   // double temporary vector
	CppAD::ADFun<double> f;   // AD function object

	
	// choose a value for x 
	CppAD::uniform_01(n, x);
	size_t k;
	for(k = 0; k < n; k++)
		X[k] = x[k];

	// weights for hessian calculation (only one component of f)
	w[0] = 1.;

	// used to display results of optimizing the operation sequence
        static bool printed = false;
        bool print_this_time = (! printed) & (repeat > 1) & (n >= 30);

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

		// declare independent variables
		Independent(X);	

		// AD computation of f(x)
		CppAD::sparse_evaluate< AD<double> >(X, i, j, order, Y);

		// create function object f : X -> Y
		f.Dependent(X, Y);

		extern bool global_optimize;
		if( global_optimize )
		{	size_t before, after;
			before = f.size_var();
			f.optimize();
			if( print_this_time ) 
			{	after = f.size_var();
				std::cout << "cppad_sparse_hessian_optimize_size_"
				          << int(n) << " = [ " << int(before) 
				          << ", " << int(after) << "]" << std::endl;
				printed         = true;
				print_this_time = false;
			}
		}

		// evaluate and return the hessian of f
# if CPPAD_USE_SPARSE_HESSIAN
		hessian = f.SparseHessian(x, w);
# else
		hessian = f.Hessian(x, w);
# endif
	}
	return true;
}
/* $$
$end
*/
