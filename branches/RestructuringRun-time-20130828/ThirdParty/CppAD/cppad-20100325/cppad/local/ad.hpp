/* $Id: ad.hpp 1369 2009-05-31 01:31:48Z bradbell $ */
# ifndef CPPAD_AD_INCLUDED
# define CPPAD_AD_INCLUDED

/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-08 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */

// simple AD operations that must be defined for AD as well as base class
# include <cppad/local/ordered.hpp>
# include <cppad/local/identical.hpp>

// define the template classes that are used by the AD template class
# include <cppad/local/op_code.hpp>
# include <cppad/local/recorder.hpp>
# include <cppad/local/player.hpp>
# include <cppad/local/ad_tape.hpp>

//  BEGIN CppAD namespace
namespace CppAD {

template <class Base>
class AD {

	// template friend functions where template parameter is not bound
	template <class VectorAD>
	friend void Independent(VectorAD &x);

	// one argument functions
	friend bool GreaterThanZero    <Base> 
		(const AD<Base>    &u);
	friend bool LessThanZero       <Base> 
		(const AD<Base>    &u);
	friend bool LessThanOrZero     <Base> 
		(const AD<Base>    &u);
	friend bool GreaterThanOrZero  <Base> 
		(const AD<Base>    &u);
	friend bool Parameter          <Base> 
		(const AD<Base>    &u);
	friend bool Parameter          <Base>
		(const VecAD<Base> &u);
	friend bool Variable           <Base> 
		(const AD<Base>    &u);
	friend bool Variable           <Base> 
		(const VecAD<Base> &u);
	friend bool IdenticalPar       <Base> 
		(const AD<Base>    &u);
	friend bool IdenticalZero      <Base> 
		(const AD<Base>    &u);
	friend bool IdenticalOne       <Base> 
		(const AD<Base>    &u);
	friend int  Integer            <Base> 
		(const AD<Base>    &u);
	friend AD   Var2Par            <Base>
		(const AD<Base>    &u);

	// power function
	friend AD pow <Base>
		(const AD<Base> &x, const AD<Base> &y);

	// IdenticalEqualPar function
	friend bool IdenticalEqualPar <Base> 
		(const AD<Base> &u, const AD<Base> &v);

	// EqualOpSeq function
	friend bool EqualOpSeq <Base> 
		(const AD<Base> &u, const AD<Base> &v);

	// NearEqual function
	friend bool NearEqual <Base> (
	const AD<Base> &x, const AD<Base> &y, const Base &r, const Base &a);

	friend bool NearEqual <Base> (
	const Base &x, const AD<Base> &y, const Base &r, const Base &a);

	friend bool NearEqual <Base> (
	const AD<Base> &x, const Base &y, const Base &r, const Base &a);

	// CondExp function
	friend AD<Base> CondExpOp  <Base> (
		enum CompareOp  cop       ,
		const AD<Base> &left      , 
		const AD<Base> &right     , 
		const AD<Base> &trueCase  , 
		const AD<Base> &falseCase 
	);

	// classes
	friend class ADTape<Base>;
	friend class ADDiscrete<Base>;
	friend class ADFun<Base>;
	friend class VecAD<Base>;
	friend class VecAD_reference<Base>;

	// arithematic binary operators
	friend AD<Base> operator + <Base>
		(const AD<Base> &left, const AD<Base> &right);
	friend AD<Base> operator - <Base>
		(const AD<Base> &left, const AD<Base> &right);
	friend AD<Base> operator * <Base>
		(const AD<Base> &left, const AD<Base> &right);
	friend AD<Base> operator / <Base>
		(const AD<Base> &left, const AD<Base> &right);

	// comparison operators
	friend bool operator < <Base>
		(const AD<Base> &left, const AD<Base> &right);
	friend bool operator <= <Base>
		(const AD<Base> &left, const AD<Base> &right);
	friend bool operator > <Base>
		(const AD<Base> &left, const AD<Base> &right);
	friend bool operator >= <Base>
		(const AD<Base> &left, const AD<Base> &right);
	friend bool operator == <Base>
		(const AD<Base> &left, const AD<Base> &right);
	friend bool operator != <Base>
		(const AD<Base> &left, const AD<Base> &right);

	// output operations
	friend std::ostream& operator << <Base>
		(std::ostream &os, const AD<Base> &x);
	friend void PrintFor <Base>
		(const char *text, const AD<Base> &x);

public:
	// type of value
	typedef Base value_type;

	// default constructor
	inline AD(void);

	// use default copy constructor and assignment operator
	// inline AD(const AD &x);
	// inline AD& operator=(const AD &x);

	// construction and assingment from base type
	inline AD(const Base &b);
	inline AD& operator=(const Base &b); 

	// contructor and assignment from VecAD<Base>::reference
	inline AD(const VecAD_reference<Base> &x);
	inline AD& operator=(const VecAD_reference<Base> &x);

	// construction and assignment from some other type
	template <class T> inline AD(const T &t);
	template <class T> inline AD& operator=(const T &right);

	// base type corresponding to an AD object
	friend Base Value <Base> (const AD<Base> &x);

	// computed assignment operators
	inline AD& operator += (const AD &right);
	inline AD& operator -= (const AD &right);
	inline AD& operator *= (const AD &right);
	inline AD& operator /= (const AD &right);

	// unary operators
	inline AD operator +(void) const;
	inline AD operator -(void) const;

	// destructor
	~AD(void)
	{ }

	// interface so these functions need not be friends
	inline AD Abs(void) const;
	inline AD acos(void) const;
	inline AD asin(void) const;
	inline AD atan(void) const;
	inline AD cos(void) const;
	inline AD cosh(void) const;
	inline AD exp(void) const;
	inline AD log(void) const;
	inline AD sin(void) const;
	inline AD sinh(void) const;
	inline AD sqrt(void) const;

	// ----------------------------------------------------------
	// static public member functions
	
	// abort current AD<Base> recording
	static void        abort_recording(void);   

	// set the maximum number of OpenMP threads that will be active
	static size_t      omp_max_thread(size_t number);

	// These functions declared public so can be accessed by user through
	// a macro interface and are not intended for direct use.
	// The macro interface is documented in bool_fun.hpp.
	// Developer documentation for these fucntions is in  bool_fun_link.hpp
	static inline bool UnaryBool(
		bool FunName(const Base &x),
		const AD<Base> &x
	);
	static inline bool BinaryBool(
		bool FunName(const Base &x, const Base &y),
		const AD<Base> &x , const AD<Base> &y
	);

private:
	// value_ corresponding to this object
	Base value_;

	// tape identifier corresponding to taddr
	// This is a variable if and only if id_ == *id_handle()
	size_t id_;

	// taddr_ in tape for this variable 
	size_t taddr_;
	//
	// Make this variable a parameter
	//
	void make_parameter(void)
	{	CPPAD_ASSERT_UNKNOWN( Variable(*this) );  // currently a var
		id_ = 0;
	}
	//
	// Make this parameter a new variable 
	//
	void make_variable(size_t id,  size_t taddr)
	{	CPPAD_ASSERT_UNKNOWN( Parameter(*this) ); // currently a par
		CPPAD_ASSERT_UNKNOWN( taddr > 0 );        // sure valid taddr

		taddr_ = taddr;
		id_    = id;
	}
	// ---------------------------------------------------------------
	// tape linking functions
	// 
	// not static
	inline ADTape<Base> *tape_this(void) const;
	//
	// static 
	inline static size_t        *id_handle (size_t thread);
	inline static ADTape<Base> **tape_handle(size_t thread);
	static size_t                tape_new(void);
	static void                  tape_delete(size_t id);
	inline static ADTape<Base>  *tape_ptr(void);
	inline static ADTape<Base>  *tape_ptr(size_t id);
}; 
// ---------------------------------------------------------------------------

} // END CppAD namespace

// tape linking private functions
# include <cppad/local/tape_link.hpp>

// operations that expect the AD template class to be defined


# endif
