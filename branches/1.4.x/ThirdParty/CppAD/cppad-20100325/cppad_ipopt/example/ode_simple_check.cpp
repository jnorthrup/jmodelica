/* $Id: ode_simple_check.cpp 1635 2010-01-24 16:27:06Z bradbell $ */
/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-10 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */
# include "ode_run.hpp"
# include "ode_simple.hpp"
# include "ode_check.hpp"

bool ode_simple_check(void)
{	bool ok = true;
	bool retape;
	size_t i;

	// solution vector
	NumberVector x;

	// number of time grid intervals between measurement values
	SizeVector N(Nz + 1);
	N[0] = 0;
	for(i = 1; i <= Nz; i++)
		N[i] = 4;

	for(i = 0; i < 2; i++)
	{	retape = bool(i);
		ipopt_ode_case<FG_simple>(retape, N, x);
		ok &= ode_check(N, x);
	}
 
	return ok;
}
