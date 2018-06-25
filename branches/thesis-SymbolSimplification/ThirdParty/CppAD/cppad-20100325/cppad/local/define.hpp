/* $Id: define.hpp 1588 2009-11-24 20:26:48Z bradbell $ */
# ifndef CPPAD_DEFINE_INCLUDED
# define CPPAD_DEFINE_INCLUDED

/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-09 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */

/*!
\file define.hpp
Define processor symbols and macros that are used by CppAD.

*/

/*!
\def CPPAD_USE_FORWARD0SWEEP
If ture, use compute zero order sweeps using a specialized routine.

The value of this define should be zero or one. 
If it is one, a specialized routine is used for zero order forward sweeps.
Otherwise, use the general forward routine is used for zero order.
Using the specialized routine is an optimization that makes the source
more complicated and a significant speed improvement has not been 
verified (as yet).
This preprocessor symbol makes it easier to compare these two options.
*/
# define CPPAD_USE_FORWARD0SWEEP 1

/*! 
\def CPPAD_BEGIN_NAMESPACE
Declares beginning of the CppAD namespace is a way not reconized by doxygen.

\def CPPAD_END_NAMESPACE
Used for end that matches the beginning of a CppAD namespace section
*/

# define CPPAD_BEGIN_NAMESPACE namespace CppAD {
# define CPPAD_END_NAMESPACE   }


/*!
\def CPPAD_INLINE
A version of the inline command that works with MC compiler.

Microsoft Visual C++ version 9.0 generates a warning if a template
function is declared as a friend
(this was not a problem for version 7.0). 
The warning identifier is
\verbatim
	warning C4396
\endverbatim 
and it contains the text
\verbatim
	the inline specifier cannot be used when a friend declaration refers 
	to a specialization of a function template
\endverbatim
This happens even if the function is not a specialization.
The macro CPPAD_INLINE is defined as empty for Microsoft compilers.
*/
# ifdef _MSC_VER
# define CPPAD_INLINE
# else
# define CPPAD_INLINE inline
# endif

/*!
\def CPPAD_NULL
This preprocessor symbol is used for a null pointer. 

If it is not yet defined,
it is defined when cppad/local/define.hpp is included.
*/
# ifndef CPPAD_NULL
# define CPPAD_NULL     0
# endif
 
/*!
\def CPPAD_MAX_NUM_THREADS
Specifies the maximum number of OpenMp threads that can be used with CppAD.

If it is not yet defined,
it is defined when cppad/local/define.hpp is included.
If the preprocessor symbol _OPENMP is not defined, 
CPPAD_MAX_NUM_THREADS one. Otheriwse it is 32.
*/
# ifndef CPPAD_MAX_NUM_THREADS
# ifdef _OPENMP
# define CPPAD_MAX_NUM_THREADS 32
# else
# define CPPAD_MAX_NUM_THREADS 1
# endif
# endif

/*!
\def CPPAD_FOLD_ASSIGNMENT_OPERATOR(Op)
Declares automatic coercion for certain AD assignment operations.

This macro assumes that the operator
\verbatim
	left Op right
\endverbatim
is defined for the case where left and right have type AD<Base>.
It uses this case to define the cases where
left has type AD<Base> and right has type
VecAD_reference<Base>,
Base, or
double.
The argument right is const and call by reference.
This macro converts the operands to AD<Base> and then
uses the definition of the same operation for that case. 
*/

# define CPPAD_FOLD_ASSIGNMENT_OPERATOR(Op)                             \
/* ----------------------------------------------------------------*/   \
template <class Base>                                                   \
inline AD<Base>& operator Op                                            \
(AD<Base> &left, double right)                                          \
{	return left Op AD<Base>(right); }                               \
                                                                        \
template <class Base>                                                   \
inline AD<Base>& operator Op                                            \
(AD<Base> &left, const Base &right)                                     \
{	return left Op AD<Base>(right); }                               \
                                                                        \
inline AD<double>& operator Op                                          \
(AD<double> &left, const double &right)                                 \
{	return left Op AD<double>(right); }                             \
                                                                        \
template <class Base>                                                   \
inline AD<Base>& operator Op                                            \
(AD<Base> &left, const VecAD_reference<Base> &right)                    \
{	return left Op right.ADBase(); }

// =====================================================================
/*!
\def CPPAD_FOLD_AD_VALUED_BINARY_OPERATOR(Op)
Declares automatic coercion for certain binary operations with AD result.

This macro assumes that the operator
\verbatim
	left Op right
\endverbatim
is defined for the case where left and right 
and the result of the operation all 
have type AD<Base>.
It uses this case to define the cases either left
or right has type VecAD_reference<Base> or AD<Base>
and the type of the other operand is one of the following:
VecAD_reference<Base>, AD<Base>, Base, double.
All of the arguments are const and call by reference.
This macro converts the operands to AD<Base> and then
uses the definition of the same operation for that case. 
*/
# define CPPAD_FOLD_AD_VALUED_BINARY_OPERATOR(Op)                      \
/* ----------------------------------------------------------------*/  \
/* Operations with VecAD_reference<Base> and AD<Base> only*/           \
                                                                       \
template <class Base>                                                  \
inline AD<Base> operator Op                                            \
(const AD<Base> &left, const VecAD_reference<Base> &right)             \
{	return left Op right.ADBase(); }                               \
                                                                       \
template <class Base>                                                  \
inline AD<Base> operator Op                                            \
(const VecAD_reference<Base> &left, const VecAD_reference<Base> &right)\
{	return left.ADBase() Op right.ADBase(); }                      \
                                                                       \
template <class Base>                                                  \
inline AD<Base> operator Op                                            \
	(const VecAD_reference<Base> &left, const AD<Base> &right)     \
{	return left.ADBase() Op right; }                               \
/* ----------------------------------------------------------------*/  \
/* Operations Base */                                                  \
                                                                       \
template <class Base>                                                  \
inline AD<Base> operator Op                                            \
	(const Base &left, const AD<Base> &right)                      \
{	return AD<Base>(left) Op right; }                              \
                                                                       \
template <class Base>                                                  \
inline AD<Base> operator Op                                            \
	(const Base &left, const VecAD_reference<Base> &right)         \
{	return AD<Base>(left) Op right.ADBase(); }                     \
                                                                       \
template <class Base>                                                  \
inline AD<Base> operator Op                                            \
	(const AD<Base> &left, const Base &right)                      \
{	return left Op AD<Base>(right); }                              \
                                                                       \
template <class Base>                                                  \
inline AD<Base> operator Op                                            \
	(const VecAD_reference<Base> &left, const Base &right)         \
{	return left.ADBase() Op AD<Base>(right); }                     \
                                                                       \
/* ----------------------------------------------------------------*/  \
/* Operations double */                                                \
                                                                       \
template <class Base>                                                  \
inline AD<Base> operator Op                                            \
	(const double &left, const AD<Base> &right)                    \
{	return AD<Base>(left) Op right; }                              \
                                                                       \
template <class Base>                                                  \
inline AD<Base> operator Op                                            \
	(const double &left, const VecAD_reference<Base> &right)       \
{	return AD<Base>(left) Op right.ADBase(); }                     \
                                                                       \
template <class Base>                                                  \
inline AD<Base> operator Op                                            \
	(const AD<Base> &left, const double &right)                    \
{	return left Op AD<Base>(right); }                              \
                                                                       \
template <class Base>                                                  \
inline AD<Base> operator Op                                            \
	(const VecAD_reference<Base> &left, const double &right)       \
{	return left.ADBase() Op AD<Base>(right); }                     \
/* ----------------------------------------------------------------*/  \
/* Special case to avoid ambuigity when Base is double */              \
                                                                       \
inline AD<double> operator Op                                          \
	(const double &left, const AD<double> &right)                  \
{	return AD<double>(left) Op right; }                            \
                                                                       \
inline AD<double> operator Op                                          \
	(const double &left, const VecAD_reference<double> &right)     \
{	return AD<double>(left) Op right.ADBase(); }                   \
                                                                       \
inline AD<double> operator Op                                          \
	(const AD<double> &left, const double &right)                  \
{	return left Op AD<double>(right); }                            \
                                                                       \
inline AD<double> operator Op                                          \
	(const VecAD_reference<double> &left, const double &right)     \
{	return left.ADBase() Op AD<double>(right); }

// =======================================================================

/*!
\def CPPAD_FOLD_BOOL_VALUED_BINARY_OPERATOR(Op)
Declares automatic coercion for certain binary operations with bool result.

This macro assumes that the operator
\verbatim
	left Op right
\endverbatim
is defined for the case where left and right 
have type AD<Base> and the result has type bool.
It uses this case to define the cases either left
or right has type
VecAD_reference<Base> or AD<Base>
and the type of the other operand is one of the following:
VecAD_reference<Base>, AD<Base>, Base, double.
All of the arguments are const and call by reference.
This macro converts the operands to AD<Base> and then
uses the definition of the same operation for that case. 
*/
# define CPPAD_FOLD_BOOL_VALUED_BINARY_OPERATOR(Op)                    \
/* ----------------------------------------------------------------*/  \
/* Operations with VecAD_reference<Base> and AD<Base> only*/           \
                                                                       \
template <class Base>                                                  \
inline bool operator Op                                                \
(const AD<Base> &left, const VecAD_reference<Base> &right)             \
{	return left Op right.ADBase(); }                               \
                                                                       \
template <class Base>                                                  \
inline bool operator Op                                                \
(const VecAD_reference<Base> &left, const VecAD_reference<Base> &right)\
{	return left.ADBase() Op right.ADBase(); }                      \
                                                                       \
template <class Base>                                                  \
inline bool operator Op                                                \
	(const VecAD_reference<Base> &left, const AD<Base> &right)     \
{	return left.ADBase() Op right; }                               \
/* ----------------------------------------------------------------*/  \
/* Operations Base */                                                  \
                                                                       \
template <class Base>                                                  \
inline bool operator Op                                                \
	(const Base &left, const AD<Base> &right)                      \
{	return AD<Base>(left) Op right; }                              \
                                                                       \
template <class Base>                                                  \
inline bool operator Op                                                \
	(const Base &left, const VecAD_reference<Base> &right)         \
{	return AD<Base>(left) Op right.ADBase(); }                     \
                                                                       \
template <class Base>                                                  \
inline bool operator Op                                                \
	(const AD<Base> &left, const Base &right)                      \
{	return left Op AD<Base>(right); }                              \
                                                                       \
template <class Base>                                                  \
inline bool operator Op                                                \
	(const VecAD_reference<Base> &left, const Base &right)         \
{	return left.ADBase() Op AD<Base>(right); }                     \
                                                                       \
/* ----------------------------------------------------------------*/  \
/* Operations double */                                                \
                                                                       \
template <class Base>                                                  \
inline bool operator Op                                                \
	(const double &left, const AD<Base> &right)                    \
{	return AD<Base>(left) Op right; }                              \
                                                                       \
template <class Base>                                                  \
inline bool operator Op                                                \
	(const double &left, const VecAD_reference<Base> &right)       \
{	return AD<Base>(left) Op right.ADBase(); }                     \
                                                                       \
template <class Base>                                                  \
inline bool operator Op                                                \
	(const AD<Base> &left, const double &right)                    \
{	return left Op AD<Base>(right); }                              \
                                                                       \
template <class Base>                                                  \
inline bool operator Op                                                \
	(const VecAD_reference<Base> &left, const double &right)       \
{	return left.ADBase() Op AD<Base>(right); }                     \
/* ----------------------------------------------------------------*/  \
/* Special case to avoid ambuigity when Base is double */              \
                                                                       \
inline bool operator Op                                                \
	(const double &left, const AD<double> &right)                  \
{	return AD<double>(left) Op right; }                            \
                                                                       \
inline bool operator Op                                                \
	(const double &left, const VecAD_reference<double> &right)     \
{	return AD<double>(left) Op right.ADBase(); }                   \
                                                                       \
inline bool operator Op                                                \
	(const AD<double> &left, const double &right)                  \
{	return left Op AD<double>(right); }                            \
                                                                       \
inline bool operator Op                                                \
	(const VecAD_reference<double> &left, const double &right)     \
{	return left.ADBase() Op AD<double>(right); }

# endif
