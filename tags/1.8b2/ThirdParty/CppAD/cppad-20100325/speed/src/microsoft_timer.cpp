/* $Id: microsoft_timer.cpp 1655 2010-02-11 19:59:43Z bradbell $ */
/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-10 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */
/*
$begin microsoft_timer$$
$spell
	Microsoft
	cpp
$$

$section Microsoft Version of Elapsed Number of Seconds$$


$head Syntax$$
$icode%s% = microsoft_timer()%$$

$head Purpose$$
This routine is accurate to within .02 seconds
(see $cref/elapsed_seconds.cpp/$$ which uses this routine when 
the preprocessor symbol $code _MSC_VER$$ is defined).
It does not necessary work for time intervals that are greater than a day.
It uses $code ::GetSystemTime$$ for timing.

$head s$$
is a $code double$$ equal to the 
number of seconds since the first call to $code microsoft_timer$$.

$head Linking$$
The source code for this routine is located in 
$code speed/microsoft_timer.cpp$$.
The preprocessor symbol $code _MSC_VER$$ must
be defined, or this routine is not compiled.

$end
-----------------------------------------------------------------------
*/

/*!
\file microsoft_timer.hpp
\brief Microsoft version of elapsed_seconds.
*/
/*
Microsoft version of elapsed number of seconds since frist call.

\copydetails elapsed_seconds
*/
# if _MSC_VER
# include <windows.h>
# include <cassert>
double microsoft_timer(void)
{	static bool       first_  = true;
	static SYSTEMTIME st_;
	SYSTEMTIME st;

	if( first_ )
	{	::GetSystemTime(&st_);
		first_ = false;
		return 0.;
	}
	::GetSystemTime(&st);

	double hour   = double(st.wHour)         - double(st_.wHour);
	double minute = double(st.wMinute)       - double(st_.wMinute);
	double second = double(st.wSecond)       - double(st_.wSecond);
	double milli  = double(st.wMilliseconds) - double(st_.wMilliseconds);

	double diff   = 1e-3*milli + second + 60.*minute + 3600.*hour;
	if( diff < 0. )
		diff += 3600.*24.;
	assert( 0 <= diff && diff < 3600.*24. );

	return diff;
}
# endif
