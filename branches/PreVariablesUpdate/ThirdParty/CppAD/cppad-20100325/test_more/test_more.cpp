/* $Id: test_more.cpp 1659 2010-03-11 03:48:31Z bradbell $ */
/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-10 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */

// system include files used for I/O
# include <iostream>

// AD<Type> template class definition
# include <cppad/cppad.hpp>

// various examples / tests
extern bool Abs(void);
extern bool Acos(void);
extern bool Add(void);
extern bool AddEq(void);
extern bool AddZero(void);
extern bool Asin(void);
extern bool Atan(void);
extern bool Atan2(void);
extern bool base_adolc(void);
extern bool check_simple_vector(void);
extern bool Compare(void);
extern bool CompareChange(void);
extern bool CondExp(void);
extern bool CondExpAD(void);
extern bool Copy(void);
extern bool Cos(void);
extern bool Cosh(void);
extern bool dbl_epsilon(void);
extern bool Div(void);
extern bool DivEq(void);
extern bool DivZeroOne(void);
extern bool Erf(void);
extern bool Exp(void);
extern bool ForHess(void);
extern bool for_sparse_jac(void);
extern bool Forward(void);
extern bool FromBase(void);
extern bool FunCheck(void);
extern bool jacobian(void);
extern bool Log(void);
extern bool Log10(void);
extern bool Mul(void);
extern bool mul_level(void);
extern bool MulEq(void);
extern bool MulZeroOne(void);
extern bool NearEqualExt(void);
extern bool Neg(void);
extern bool ode_err_control(void);
extern bool optimize(void);
extern bool Poly(void);
extern bool Pow(void);
extern bool PowInt(void);
extern bool reverse(void);
extern bool rev_sparse_hes(void);
extern bool rev_sparse_jac(void);
extern bool RevTwo(void);
extern bool RombergOne(void);
extern bool Rosen34(void);
extern bool Runge45(void);
extern bool SimpleVector(void);
extern bool Sin(void);
extern bool SinCos(void);
extern bool Sinh(void);
extern bool sparse_hessian(void);
extern bool sparse_jacobian(void);
extern bool sparse_vec_ad(void);
extern bool Sqrt(void);
extern bool std_math(void);
extern bool Sub(void);
extern bool SubEq(void);
extern bool SubZero(void);
extern bool Value(void);
extern bool VecAD(void);
extern bool VecADPar(void);
extern bool VecUnary(void);

namespace {
	// function that runs one test
	static size_t Run_ok_count    = 0;
	static size_t Run_error_count = 0;
	bool Run(bool TestOk(void), std::string name)
	{	bool ok               = true;
		std::streamsize width =  20;         
		std::cout.width( width );
		std::cout.setf( std::ios_base::left );
		std::cout << name;
		//
		ok &= name.size() < size_t(width);
		ok &= TestOk();
		if( ok )
		{	std::cout << "OK" << std::endl;
			Run_ok_count++;
		}
		else
		{	std::cout << "Error" << std::endl;
			Run_error_count++;
		}
		return ok;
	}
}

// main program that runs all the tests
int main(void)
{	bool ok = true;
	using namespace std;

	// This line is used by test_one.sh 

	ok &= Run( Abs,             "Abs"            );
	ok &= Run( Acos,            "Acos"           );
	ok &= Run( Add,             "Add"            );
	ok &= Run( AddEq,           "AddEq"          );
	ok &= Run( AddZero,         "AddZero"        );
	ok &= Run( Asin,            "Asin"           );
	ok &= Run( Atan,            "Atan"           );
	ok &= Run( Atan2,           "Atan2"          );
	ok &= Run( check_simple_vector, "check_simple_vector" );
	ok &= Run( Compare,         "Compare"        );
	ok &= Run( CompareChange,   "CompareChange"  );
	ok &= Run( CondExp,         "CondExp"        );
	ok &= Run( CondExpAD,       "CondExpAD"      );
	ok &= Run( Copy,            "Copy"           );
	ok &= Run( Cos,             "Cos"            );
	ok &= Run( Cosh,            "Cosh"           );
	ok &= Run( dbl_epsilon,     "dbl_epsilon"    );
	ok &= Run( Div,             "Div"            );
	ok &= Run( DivEq,           "DivEq"          );
	ok &= Run( DivZeroOne,      "DivZeroOne"     );
	ok &= Run( Erf,             "Erf"            );
	ok &= Run( Exp,             "Exp"            );
	ok &= Run( ForHess,         "ForHess"        );
	ok &= Run( for_sparse_jac,  "for_sparse_jac" );
	ok &= Run( Forward,         "Forward"        );
	ok &= Run( FromBase,        "FromBase"       );
	ok &= Run( FunCheck,        "FunCheck"       );
	ok &= Run( jacobian,        "jacobian"       );
	ok &= Run( Log,             "Log"            );
	ok &= Run( Log10,           "Log10"          );
	ok &= Run( Mul,             "Mul"            );
	ok &= Run( mul_level,       "mul_level"      );
	ok &= Run( MulEq,           "MulEq"          );
	ok &= Run( MulZeroOne,      "MulZeroOne"     );
	ok &= Run( NearEqualExt,    "NearEqualExt"   );
	ok &= Run( Neg,             "Neg"            );
	ok &= Run( ode_err_control, "ode_err_control");
	ok &= Run( optimize,        "optimize"       );
	ok &= Run( Poly,            "Poly"           );
	ok &= Run( Pow,             "Pow"            );
	ok &= Run( PowInt,          "PowInt"         );
	ok &= Run( reverse,         "reverse"        );
	ok &= Run( rev_sparse_hes,  "rev_sparse_hes" );
	ok &= Run( rev_sparse_jac,  "rev_sparse_jac" );
	ok &= Run( RevTwo,          "RevTwo"         );
	ok &= Run( RombergOne,      "RombergOne"     );
	ok &= Run( Rosen34,         "Rosen34"        );
	ok &= Run( Runge45,         "Runge45"        );
	ok &= Run( SimpleVector,    "SimpleVector"   );
	ok &= Run( Sin,             "Sin"            );
	ok &= Run( SinCos,          "SinCos"         );
	ok &= Run( Sinh,            "Sinh"           );
	ok &= Run( sparse_hessian,  "sparse_hessian" );
	ok &= Run( sparse_jacobian, "sparse_jacobian");
	ok &= Run( sparse_vec_ad,   "sparse_vec_ad"  );
	ok &= Run( Sqrt,            "Sqrt"           );
	ok &= Run( std_math,        "std_math"       );
	ok &= Run( Sub,             "Sub"            );
	ok &= Run( SubEq,           "SubEq"          );
	ok &= Run( SubZero,         "SubZero"        );
	ok &= Run( Value,           "Value"          );
	ok &= Run( VecAD,           "VecAD"          );
	ok &= Run( VecADPar,        "VecADPar"       );
	ok &= Run( VecUnary,        "VecUnary"       );

# ifdef CPPAD_ADOLC_TEST
	ok &= Run( base_adolc,      "base_adolc"     );
# endif

	// check for errors
	using std::cout;
	using std::endl;
	assert( ok || (Run_error_count > 0) );
	if( CPPAD_TRACK_COUNT() == 0 )
	{	Run_ok_count++;
		cout << "Ok:    " << "No memory leak detected" << endl;
	}
	else
	{	ok = false;
		Run_error_count++;
		cout << "Error: " << "memory leak detected" << endl;
	}
	// convert int(size_t) to avoid warning on _MSC_VER systems
	if( ok )
		cout << "All " << int(Run_ok_count) << " tests passed." << endl;
	else	cout << int(Run_error_count) << " tests failed." << endl;

	return static_cast<int>( ! ok );

}
// END PROGRAM
