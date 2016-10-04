/* $Id: fun_construct.hpp 1641 2010-02-01 16:39:45Z bradbell $ */
# ifndef CPPAD_FUN_CONSTRUCT_INCLUDED
# define CPPAD_FUN_CONSTRUCT_INCLUDED

/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-10 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */
/*
$begin FunConstruct$$
$spell 
	Jac
	bool
	taylor_
	var
	ADvector
	const
	Jacobian
$$

$spell
$$

$section Construct an ADFun Object and Stop Recording$$

$index ADFun, construct$$
$index construct, ADFun$$
$index tape, stop recording$$
$index recording, stop tape$$

$head Syntax$$
$codei%ADFun<%Base%> %f%, %g%
%$$
$codei%ADFun<%Base%> %f%(%x%, %y%)
%$$
$icode%g% = %f%
%$$


$head Purpose$$
The $codei%AD<%Base%>%$$ object $icode f$$ can 
store an AD of $icode Base$$
$xref/glossary/Operation/Sequence/operation sequence/1/$$.
It can then be used to calculate derivatives of the corresponding
$xref/glossary/AD Function/AD function/$$
$latex \[
	F : B^n \rightarrow B^m
\] $$
where $latex B$$ is the space corresponding to objects of type $icode Base$$.

$head x$$
If the argument $icode x$$ is present, it has prototype
$codei%
	const %VectorAD% &%x%
%$$
It must be the vector argument in the previous call to
$cref/Independent/$$.
Neither its size, or any of its values, are allowed to change
between calling
$codei%
	Independent(%x%)
%$$
and 
$codei%
	ADFun<%Base%> %f%(%x%, %y%)
%$$.

$head y$$
If the argument $icode y$$ is present, it has prototype
$codei%
	const %VectorAD% &%y%
%$$
The sequence of operations that map $icode x$$
to $icode y$$ are stored in the ADFun object $icode f$$.

$head VectorAD$$
The type $icode VectorAD$$ must be a $cref/SimpleVector/$$ class with
$cref/elements of type/SimpleVector/Elements of Specified Type/$$ 
$codei%AD<%Base%>%$$.
The routine $cref/CheckSimpleVector/$$ will generate an error message
if this is not the case.

$head Default Constructor$$
$index default, ADFun constructor$$
$index ADFun, default constructor$$
$index constructor, ADFun constructor$$
The default constructor 
$codei%
	ADFun<%Base%> %f%
%$$
creates an 
$codei%AD<%Base%>%$$ object with no corresponding operation sequence; i.e.,
$codei%
	%f%.size_var()
%$$
returns the value zero (see $xref/seq_property/size_var/size_var/$$).

$head Sequence Constructor$$
$index sequence, ADFun constructor$$
$index ADFun, sequence constructor$$
$index constructor, ADFun sequence$$
The default constructor 
The sequence constructor 
$codei%
	ADFun<%Base%> %f%(%x%, %y%)
%$$
creates the $codei%AD<%Base%>%$$ object $icode f$$,
stops the recording of AD of $icode Base$$ operations
corresponding to the call
$codei%
	Independent(%x%)
%$$
and stores the corresponding operation sequence in the object $icode f$$.
It then stores the first order taylor_ coefficients 
(corresponding to the value of $icode x$$) in $icode f$$.
This is equivalent to the following steps using the default constructor:

$list number$$
Create $icode f$$ with the default constructor
$codei%
	ADFun<%Base%> %f%;
%$$
$lnext
Stop the tape and storing the operation sequence using
$codei%
	%f%.Dependent(%x%, %y%);
%$$
(see $xref/Dependent/$$).
$lnext
Calculating the first order taylor_ coefficients for all 
the variables in the operation sequence using
$codei%
	%f%.Forward(%p%, %x_p%)
%$$
with $icode p$$ equal to zero and the elements of $icode x_p$$
equal to the corresponding elements of $icode x$$
(see $xref/Forward/$$).
$lend

$head Copy Constructor$$
$index copy, ADFun constructor$$
$index ADFun, copy constructor$$
$index constructor, ADFun copy$$
It is an error to attempt to use the $code%ADFun<%Base%>%$$ copy constructor;
i.e., the following syntax is not allowed:
$codei%
	ADFun<%Base%> g(f)
%$$
where $icode f$$ is an $code%ADFun<%Base%>%$$ object.
Use its $cref/default constructor/FunConstruct/Default Constructor/$$ instead
and its assignment operator.

$head Assignment Operator$$
$index ADFun, assignment operator$$
$index assignment, ADFun operator$$
$index operator, ADFun assignment$$
The $codei%ADFun<%Base%>%$$ assignment operation
$codei%
	%g% = %f%
%$$.
makes a copy of the operation sequence currently stored in $icode f$$
in the object $icode g$$.
The object $icode f$$ is not affected by this operation and
can be $code const$$.
Any operation sequence or other information in $icode g$$ is lost.

$subhead Taylor Coefficients$$
The Taylor coefficient information currently stored in $icode f$$ 
(computed by $cref/f.Forward/Forward/$$) is 
copied to $icode g$$.
Hence, directly after this operation
$codei%
	%g%.size_taylor() == %f%.size_taylor()
%$$

$subhead Sparsity Patterns$$
The forward Jacobian sparsity pattern currently stored in $icode f$$ 
(computed by $cref/f.ForSparseJac/ForSparseJac/$$) is 
copied to $icode g$$.
Hence, directly after this operation
$codei%
	%g%.size_forward_bool() == %f%.size_forward_bool()
	%g%.size_forward_set()  == %f%.size_forward_set()
%$$

$head OpenMP$$
$index OpenMP, Dependent$$
$index Dependent, OpenMP$$
$index OpenMP, ADFun$$
$index ADFun, OpenMP$$
In the case of multi-threading with OpenMP,
the call to $code Independent$$
and the corresponding call to
$codei%
	ADFun<%Base%> %f%( %x%, %y%)
%$$
or 
$codei%
	%f%.Dependent( %x%, %y%)
%$$
must be preformed by the same thread.


$head Example$$

$subhead Sequence Constructor$$
The file
$xref/Independent.cpp/$$ 
contains an example and test of the sequence constructor.
It returns true if it succeeds and false otherwise.

$subhead Default Constructor$$
The files
$xref/FunCheck.cpp/$$ 
and
$xref/HesLagrangian.cpp/$$
contain an examples and tests using the default constructor.
They return true if they succeed and false otherwise.

$children%
	example/fun_assign.cpp
%$$
$subhead Assignment Operator$$
The file 
$cref/fun_assign.cpp/$$
contains an example and test of the $codei%ADFun<%Base%>%$$
assignment operator.
It returns true if it succeeds and false otherwise.

$end
----------------------------------------------------------------------------
*/

CPPAD_BEGIN_NAMESPACE
/*!
\file fun_construct.hpp
ADFun function constructors and assignment operator.
*/

/*!
ADFun default constructor

The C++ syntax for this operation is
\verbatim
	ADFun<Base> f
\endverbatim
An empty ADFun object is created. 
The Dependent member function,
or the ADFun<Base> assingment operator,
can then be used to put an operation sequence in this ADFun object.

\tparam Base
is the base for the recording that can be stored in this ADFun object;
i.e., operation sequences that were recorded using the type \c AD<Base>.
*/
template <typename Base>
ADFun<Base>::ADFun(void)
: total_num_var_(0), taylor_(CPPAD_NULL)
{ }

/*!
ADFun assignment operator

The C++ syntax for this operation is
\verbatim
	g = f
\endverbatim
where \c g and \c f are ADFun<Base> ADFun objects.
A copy of the the operation sequence currently stored in \c f 
is placed in this ADFun object (called \c g above).
Any information currently stored in this ADFun object is lost.

\tparam Base
is the base for the recording that can be stored in this ADFun object;
i.e., operation sequences that were recorded using the type \c AD<Base>.

\param f
ADFun object containing the operation sequence to be copied.
*/
template <typename Base>
void ADFun<Base>::operator=(const ADFun<Base>& f)
{	size_t m = f.Range();
	size_t n = f.Domain();

	// go through member variables in order
	// (see ad_fun.hpp for meaning of each variable)
	compare_change_            = 0;
	taylor_per_var_            = 0;
	taylor_col_dim_            = 0;
	total_num_var_             = f.total_num_var_;
	ind_taddr_.resize(n);
	ind_taddr_                 = f.ind_taddr_;
	dep_taddr_.resize(m);
	dep_taddr_                 = f.dep_taddr_;
	dep_parameter_.resize(m);
	dep_parameter_             = f.dep_parameter_;
	play_                      = f.play_;
	if( taylor_ != CPPAD_NULL )
		CPPAD_TRACK_DEL_VEC(taylor_);
	taylor_                    = CPPAD_NULL;
	for_jac_sparse_pack_.resize(0, 0);
	for_jac_sparse_set_.resize(0, 0);

	// allocate and copy the Taylor coefficients
	taylor_per_var_     = f.taylor_per_var_;
	taylor_col_dim_     = f.taylor_col_dim_;
	size_t length       = total_num_var_ * taylor_col_dim_;
	if( length > 0 ) taylor_   = CPPAD_TRACK_NEW_VEC(length, taylor_);
	size_t i, j;
	for(i = 0; i < total_num_var_; i++)
	{	for(j = 0; j < taylor_per_var_; j++)
		{	taylor_[ i * taylor_col_dim_ + j ] =
				f.taylor_[ i * taylor_col_dim_ + j ];
		}
	}

	// allocate and copy the forward sparsity information
	size_t n_set = f.for_jac_sparse_pack_.n_set();
	size_t end   = f.for_jac_sparse_pack_.end();
	if( n_set > 0 )
	{	CPPAD_ASSERT_UNKNOWN( n_set == total_num_var_ );
		CPPAD_ASSERT_UNKNOWN( f.for_jac_sparse_set_.n_set() == 0 );
		for_jac_sparse_pack_.resize(n_set, end);
		for(i = 0; i < total_num_var_ ; i++)
		{	for_jac_sparse_pack_.assignment(
				i                       ,
				i                       ,
				f.for_jac_sparse_pack_
			);
		}
	}
	n_set = f.for_jac_sparse_set_.n_set();
	end   = f.for_jac_sparse_set_.end();
	if( n_set > 0 )
	{	CPPAD_ASSERT_UNKNOWN( n_set == total_num_var_ );
		CPPAD_ASSERT_UNKNOWN( f.for_jac_sparse_pack_.n_set() == 0 );
		for_jac_sparse_set_.resize(n_set, end);
		for(i = 0; i < total_num_var_; i++)
		{	for_jac_sparse_set_.assignment(
				i                       ,
				i                       ,
				f.for_jac_sparse_set_
			);
		}
	}

}

/*!
ADFun constructor from an operation sequence.

The C++ syntax for this operation is
\verbatim
	ADFun<Base> f(x, y)
\endverbatim
The operation sequence that started with the previous call
\c Independent(x), and that ends with this operation, is stored
in this \c ADFun<Base> object \c f.

\tparam Base
is the base for the recording that will be stored in the object \c f;
i.e., the operations were recorded using the type \c AD<Base>.

\tparam VectorAD
is a simple vector class with elements of typea \c AD<Base>.

\param x
is the independent variable vector for this ADFun object.
The domain dimension of this object will be the size of \a x.

\param y
is the dependent variable vector for this ADFun object.
The range dimension of this object will be the size of \a y.

\par Taylor Coefficients
A zero order forward mode sweep is done,
and if NDEBUG is not defined the resulting values for the
depenedent variables are checked against the values in \a y.
Thus, the zero order Taylor coefficients
corresponding to the value of the \a x vector
are stored in this ADFun object. 
*/
template <typename Base>
template <typename VectorAD>
ADFun<Base>::ADFun(const VectorAD &x, const VectorAD &y)
: total_num_var_(0), taylor_(CPPAD_NULL)
{
	CPPAD_ASSERT_KNOWN(
		x.size() > 0,
		"ADFun<Base>: independent variable vector has size zero."
	);
	CPPAD_ASSERT_KNOWN(
		Variable(x[0]),
		"ADFun<Base>: independent variable vector has been changed."
	);
	ADTape<Base> *tape = AD<Base>::tape_ptr(x[0].id_);
	CPPAD_ASSERT_KNOWN(
		tape->size_independent_ == x.size(),
		"ADFun<Base>: independent variable vector has been changed."
	);
	size_t j, n = x.size();
# ifndef NDEBUG
	size_t i, m = y.size();
	for(j = 0; j < n; j++)
	{	CPPAD_ASSERT_KNOWN(
		x[j].taddr_ == (j+1),
		"ADFun<Base>: independent variable vector has been changed."
		);
		CPPAD_ASSERT_KNOWN(
		x[j].id_ == x[0].id_,
		"ADFun<Base>: independent variable vector has been changed."
		);
	}
	for(i = 0; i < m; i++)
	{	CPPAD_ASSERT_KNOWN(
		CppAD::Parameter( y[i] ) | (y[i].id_ == x[0].id_) ,
		"ADFun<Base>: dependent vector contains variables for"
		"\na different tape than the independent variables."
		);
	}
# endif

	// stop the tape and store the operation sequence
	Dependent(tape, y);

	// allocate memory for one zero order taylor_ coefficient
	taylor_per_var_  = 1;
	taylor_col_dim_  = 1;
	taylor_          = CPPAD_TRACK_NEW_VEC(total_num_var_, taylor_);

	// set zero order coefficients corresponding to indpendent variables
	CPPAD_ASSERT_UNKNOWN( n == ind_taddr_.size() );
	for(j = 0; j < n; j++)
	{	CPPAD_ASSERT_UNKNOWN( ind_taddr_[j] == (j+1) );
		CPPAD_ASSERT_UNKNOWN( x[j].taddr_  == (j+1) );
		taylor_[ ind_taddr_[j] ]  = x[j].value_;
	}

	// use independent variable values to fill in values for others
# if CPPAD_USE_FORWARD0SWEEP
	compare_change_ = forward0sweep(
		false, n, total_num_var_, &play_, taylor_col_dim_, taylor_
	);
# else
	size_t p = 0;
	compare_change_ = forward_sweep(
		false, p, n, total_num_var_, &play_, taylor_col_dim_, taylor_
	);
# endif
	CPPAD_ASSERT_UNKNOWN( compare_change_ == 0 );

# ifndef NDEBUG
	for(i = 0; i < m; i++) if( taylor_[dep_taddr_[i]] != y[i].value_ )
	{	using std::endl;
		std::ostringstream buf;
		buf << "A dependent variable value is not equal to "
		    << "its tape evaluation value," << endl
		    << "perhaps it is nan." << endl
		    << "Dependent variable value = " 
		    <<  y[i].value_ << endl
		    << "Tape evaluation value    = " 
		    <<  taylor_[dep_taddr_[i]]  << endl
		    << "Difference               = " 
		    <<  y[i].value_ -  taylor_[dep_taddr_[i]]  << endl
		;
		CPPAD_ASSERT_KNOWN(
			0,
			buf.str().c_str()
		);
	}
# endif
}

CPPAD_END_NAMESPACE
# endif
