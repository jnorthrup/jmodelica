/* $Id: rev_hes_sweep.hpp 1659 2010-03-11 03:48:31Z bradbell $ */
# ifndef CPPAD_REV_HES_SWEEP_INCLUDED
# define CPPAD_REV_HES_SWEEP_INCLUDED

/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-10 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */

CPPAD_BEGIN_NAMESPACE
/*!
\file rev_hes_sweep.hpp
Compute Reverse mode Hessian sparsity patterns.
*/

/*!
\def CPPAD_REV_HES_SWEEP_TRACE
This value is either zero or one. 
Zero is the normal operational value.
If it is one, a trace of every rev_hes_sweep computation is printed.
*/
# define CPPAD_REV_HES_SWEEP_TRACE 0

/*!
Given the forward Jacobian sparsity pattern for all the variables,
and the reverse Jacobian sparsity pattern for the dependent variables,
RevHesSweep computes the Hessian sparsity pattern for all the independent 
variables.

\tparam Base
base type for the operator; i.e., this operation sequence was recorded
using AD< \a Base > and computations by this routine are done using type 
\a Base.

\tparam Vector_set
is the type used for vectors of sets. It can be either
\c sparse_pack or \c sparse_set.

\param n
is the number of independent variables on the tape.

\param numvar
is the total number of variables on the tape; i.e.,
\a play->num_rec_var().
This is also the number of rows in the entire sparsity pattern 
\a rev_hes_sparse.

\param play
The information stored in \a play
is a recording of the operations corresponding to a function
\f[
	F : {\bf R}^n \rightarrow {\bf R}^m
\f]
where \f$ n \f$ is the number of independent variables
and \f$ m \f$ is the number of dependent variables.
The object \a play is effectly constant.
It is not declared const because while playing back the tape
the object \a play holds information about the currentl location
with in the tape and this changes during playback.

\param for_jac_sparse
For i = 0 , ... , \a numvar - 1, 
(for all the variables on the tape),
the forward Jacobian sparsity pattern for the variable with index i
corresponds to the set with index i in \a for_jac_sparse.

\param RevJac
\b Input:
For i = 0, ... , \a numvar - 1 
the if the variable with index i on the tape is an dependent variable and
included in the Hessian, \a RevJac[ i ] is equal to true,
otherwise it is equal to false. 
\n
\n
\b Output: The values in \a RevJac upon return are not specified; i.e.,
it is used for temporary work space.

\param rev_hes_sparse
The reverse Hessian sparsity pattern for the variable with index i
corresponds to the set with index i in \a rev_hes_sparse.
\n
\n
\b Input: For i = 0 , ... , \a numvar - 1  
the reverse Hessian sparsity pattern for the variable with index i is empty.
\n
\n
\b Output: For j = 1 , ... , \a n,
the reverse Hessian sparsity pattern for the independent dependent variable 
with index (j-1) is given by the set with index j
in \a rev_hes_sparse. 
The values in the rest of \a rev_hes_sparse are not specified; i.e.,
they are used for temporary work space.
*/

template <class Base, class Vector_set>
void RevHesSweep(
	size_t                n,
	size_t                numvar,
	player<Base>         *play,
	Vector_set&           for_jac_sparse, // should be const
	bool*                 RevJac,
	Vector_set&           rev_hes_sparse
)
{
	OpCode           op;
	size_t         i_op;
	size_t        i_var;

	const size_t   *arg = 0;

	// length of the parameter vector (used by CppAD assert macros)
	const size_t num_par = play->num_rec_par();

	size_t             i, j, k;

	// check numvar argument
	CPPAD_ASSERT_UNKNOWN( play->num_rec_var()     == numvar );
	CPPAD_ASSERT_UNKNOWN( for_jac_sparse.n_set() == numvar );
	CPPAD_ASSERT_UNKNOWN( rev_hes_sparse.n_set() == numvar );
	CPPAD_ASSERT_UNKNOWN( numvar > 0 );

	// upper limit exclusive for set elements
	size_t limit   = rev_hes_sparse.end();
	CPPAD_ASSERT_UNKNOWN( rev_hes_sparse.end() == limit );

	// check number of sets match
	CPPAD_ASSERT_UNKNOWN( 
		for_jac_sparse.n_set() == rev_hes_sparse.n_set()
	);

	// vecad_sparsity contains a sparsity pattern for each VecAD object.
	// vecad_ind maps a VecAD index (beginning of the VecAD object) 
	// to the index for the corresponding set in vecad_sparsity.
	size_t num_vecad_ind   = play->num_rec_vecad_ind();
	size_t num_vecad_vec   = play->num_rec_vecad_vec();
	Vector_set vecad_sparse;
	vecad_sparse.resize(num_vecad_vec, limit);
	size_t* vecad_ind   = CPPAD_NULL;
	bool*   vecad_jac   = CPPAD_NULL;
	if( num_vecad_vec > 0 )
	{	size_t length;
		vecad_ind     = CPPAD_TRACK_NEW_VEC(num_vecad_ind, vecad_ind);
		vecad_jac     = CPPAD_TRACK_NEW_VEC(num_vecad_vec, vecad_jac);
		j             = 0;
		for(i = 0; i < num_vecad_vec; i++)
		{	// length of this VecAD
			length   = play->GetVecInd(j);
			// set vecad_ind to proper index for this VecAD
			vecad_ind[j] = i; 
			// make all other values for this vector invalid
			for(k = 1; k <= length; k++)
				vecad_ind[j+k] = num_vecad_vec;
			// start of next VecAD
			j       += length + 1;
			// initialize this vector's reverse jacobian value 
			vecad_jac[i] = false;
		}
		CPPAD_ASSERT_UNKNOWN( j == play->num_rec_vecad_ind() );
	}

	// Initialize
	play->start_reverse(op, arg, i_op, i_var);
	CPPAD_ASSERT_UNKNOWN( op == EndOp );
# if CPPAD_REV_HES_SWEEP_TRACE
	std::cout << std::endl;
	CppAD::vectorBool zf_value(limit);
	CppAD::vectorBool zh_value(limit);
# endif
	while(op != BeginOp)
	{
		// next op
		play->next_reverse(op, arg, i_op, i_var);
# ifndef NDEBUG
		if( i_op <= n )
		{	CPPAD_ASSERT_UNKNOWN((op == InvOp) | (op == BeginOp));
		}
		else	CPPAD_ASSERT_UNKNOWN((op != InvOp) & (op != BeginOp));
# endif

		// rest of information depends on the case
		switch( op )
		{
			case AbsOp:
			CPPAD_ASSERT_NARG_NRES(op, 1, 1)
			reverse_sparse_hessian_linear_unary_op(
			i_var, arg[0], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case AddvvOp:
			CPPAD_ASSERT_NARG_NRES(op, 2, 1)
			reverse_sparse_hessian_addsub_op(
			i_var, arg, RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case AddpvOp:
			CPPAD_ASSERT_NARG_NRES(op, 2, 1)
			reverse_sparse_hessian_linear_unary_op(
			i_var, arg[1], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case AcosOp:
			// acos(x) and sqrt(1 - x * x) are computed in pairs
			// but i_var + 1 should only be used here
			CPPAD_ASSERT_NARG_NRES(op, 1, 2)
			reverse_sparse_hessian_nonlinear_unary_op(
			i_var, arg[0], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case AsinOp:
			// asin(x) and sqrt(1 - x * x) are computed in pairs
			// but i_var + 1 should only be used here
			CPPAD_ASSERT_NARG_NRES(op, 1, 2)
			reverse_sparse_hessian_nonlinear_unary_op(
			i_var, arg[0], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case AtanOp:
			// atan(x) and 1 + x * x must be computed in pairs
			// but i_var + 1 should only be used here
			CPPAD_ASSERT_NARG_NRES(op, 1, 2)
			reverse_sparse_hessian_nonlinear_unary_op(
			i_var, arg[0], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case BeginOp:
			CPPAD_ASSERT_NARG_NRES(op, 0, 1)
			break;
			// -------------------------------------------------

			case CSumOp:
			// CSumOp has a variable number of arguments and
			// next_reverse thinks it one has one argument.
			// We must inform next_reverse of this special case.
			play->reverse_csum(op, arg, i_op, i_var);
			reverse_sparse_hessian_csum_op(
				i_var, arg, RevJac, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case CExpOp:
			reverse_sparse_hessian_cond_op(
				i_var, arg, num_par, RevJac, rev_hes_sparse
			);
			break;
			// ---------------------------------------------------

			case ComOp:
			CPPAD_ASSERT_NARG_NRES(op, 4, 0)
			CPPAD_ASSERT_UNKNOWN( arg[1] > 1 );
			break;
			// --------------------------------------------------

			case CosOp:
			// cosine and sine must come in pairs
			// but i_var should only be used here
			CPPAD_ASSERT_NARG_NRES(op, 1, 2)
			reverse_sparse_hessian_nonlinear_unary_op(
			i_var, arg[0], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// ---------------------------------------------------

			case CoshOp:
			// hyperbolic cosine and sine must come in pairs
			// but i_var should only be used here
			CPPAD_ASSERT_NARG_NRES(op, 1, 2)
			reverse_sparse_hessian_nonlinear_unary_op(
			i_var, arg[0], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case DisOp:
			CPPAD_ASSERT_NARG_NRES(op, 2, 1)

			break;
			// -------------------------------------------------

			case DivvvOp:
			CPPAD_ASSERT_NARG_NRES(op, 2, 1)
			reverse_sparse_hessian_div_op(
			i_var, arg, RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case DivpvOp:
			CPPAD_ASSERT_NARG_NRES(op, 2, 1)
			reverse_sparse_hessian_nonlinear_unary_op(
			i_var, arg[1], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case DivvpOp:
			CPPAD_ASSERT_NARG_NRES(op, 2, 1)
			reverse_sparse_hessian_linear_unary_op(
			i_var, arg[0], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case ExpOp:
			CPPAD_ASSERT_NARG_NRES(op, 1, 1)
			reverse_sparse_hessian_nonlinear_unary_op(
			i_var, arg[0], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case InvOp:
			CPPAD_ASSERT_NARG_NRES(op, 0, 1)
			// Z is already defined
			break;
			// -------------------------------------------------

			case LdpOp:
			reverse_sparse_hessian_load_op(
				op,
				i_var,
				arg,
				num_vecad_ind,
				vecad_ind,
				rev_hes_sparse,
				vecad_sparse,
				RevJac,
				vecad_jac
			);
			break;
			// -------------------------------------------------

			case LdvOp:
			reverse_sparse_hessian_load_op(
				op,
				i_var,
				arg,
				num_vecad_ind,
				vecad_ind,
				rev_hes_sparse,
				vecad_sparse,
				RevJac,
				vecad_jac
			);
			break;
			// -------------------------------------------------

			case LogOp:
			CPPAD_ASSERT_NARG_NRES(op, 1, 1)
			reverse_sparse_hessian_nonlinear_unary_op(
			i_var, arg[0], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case MulvvOp:
			CPPAD_ASSERT_NARG_NRES(op, 2, 1)
			reverse_sparse_hessian_mul_op(
			i_var, arg, RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case MulpvOp:
			CPPAD_ASSERT_NARG_NRES(op, 2, 1)
			reverse_sparse_hessian_linear_unary_op(
			i_var, arg[1], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case ParOp:
			CPPAD_ASSERT_NARG_NRES(op, 1, 1)

			break;
			// -------------------------------------------------

			case PowpvOp:
			CPPAD_ASSERT_NARG_NRES(op, 2, 3)
			reverse_sparse_hessian_nonlinear_unary_op(
			i_var, arg[1], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case PowvpOp:
			CPPAD_ASSERT_NARG_NRES(op, 2, 3)
			reverse_sparse_hessian_nonlinear_unary_op(
			i_var, arg[0], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case PowvvOp:
			CPPAD_ASSERT_NARG_NRES(op, 2, 3)
                        reverse_sparse_hessian_pow_op(
			i_var, arg, RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case PripOp:
			CPPAD_ASSERT_NARG_NRES(op, 2, 0);
			break;
			// -------------------------------------------------

			case PrivOp:
			CPPAD_ASSERT_NARG_NRES(op, 2, 0);
			break;
			// -------------------------------------------------

			case SinOp:
			// sine and cosine must come in pairs
			// but i_var should only be used here
			CPPAD_ASSERT_NARG_NRES(op, 1, 2)
			reverse_sparse_hessian_nonlinear_unary_op(
			i_var, arg[0], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case SinhOp:
			// sine and cosine must come in pairs
			// but i_var should only be used here
			CPPAD_ASSERT_NARG_NRES(op, 1, 2)
			reverse_sparse_hessian_nonlinear_unary_op(
			i_var, arg[0], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case SqrtOp:
			CPPAD_ASSERT_NARG_NRES(op, 1, 1)
			reverse_sparse_hessian_nonlinear_unary_op(
			i_var, arg[0], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case StppOp:
			// sparsity cannot propagate through a parameter
			CPPAD_ASSERT_NARG_NRES(op, 3, 0)
			break;
			// -------------------------------------------------

			case StpvOp:
			reverse_sparse_hessian_store_op(
				op,
				arg,
				num_vecad_ind,
				vecad_ind,
				rev_hes_sparse,
				vecad_sparse,
				RevJac,
				vecad_jac
			);
			break;
			// -------------------------------------------------

			case StvpOp:
			// sparsity cannot propagate through a parameter
			CPPAD_ASSERT_NARG_NRES(op, 3, 0)
			break;
			// -------------------------------------------------

			case StvvOp:
			reverse_sparse_hessian_store_op(
				op,
				arg,
				num_vecad_ind,
				vecad_ind,
				rev_hes_sparse,
				vecad_sparse,
				RevJac,
				vecad_jac
			);
			break;
			// -------------------------------------------------

			case SubvvOp:
			CPPAD_ASSERT_NARG_NRES(op, 2, 1)
			reverse_sparse_hessian_addsub_op(
			i_var, arg, RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case SubpvOp:
			CPPAD_ASSERT_NARG_NRES(op, 2, 1)
			reverse_sparse_hessian_linear_unary_op(
			i_var, arg[1], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			case SubvpOp:
			CPPAD_ASSERT_NARG_NRES(op, 2, 1)
			reverse_sparse_hessian_linear_unary_op(
			i_var, arg[0], RevJac, for_jac_sparse, rev_hes_sparse
			);
			break;
			// -------------------------------------------------

			default:
			CPPAD_ASSERT_UNKNOWN(0);
		}
# if CPPAD_REV_HES_SWEEP_TRACE
		for(j = 0; j < limit; j++)
		{	zf_value[j] = false;
			zh_value[j] = false;
		}
		for_jac_sparse.begin(i_var);;
		j = for_jac_sparse.next_element();;
		while( j < limit )
		{	zf_value[j] = true;
			j = for_jac_sparse.next_element();
		}
		rev_hes_sparse.begin(i_var);;
		j = rev_hes_sparse.next_element();;
		while( j < limit )
		{	zh_value[j] = true;
			j = rev_hes_sparse.next_element();
		}
		// should also print RevJac[i_var], but printOp does not
		// yet allow for this.
		printOp(
			std::cout, 
			play,
			i_var,
			op, 
			arg,
			1, 
			&zf_value, 
			1, 
			&zh_value
		);
# endif
	}
	// values corresponding to BeginOp
	CPPAD_ASSERT_UNKNOWN( i_op == 0 );
	CPPAD_ASSERT_UNKNOWN( i_var == 0 );

	if( vecad_jac != CPPAD_NULL )
		CPPAD_TRACK_DEL_VEC(vecad_jac);
	if( vecad_ind != CPPAD_NULL )
		CPPAD_TRACK_DEL_VEC(vecad_ind);
	return;
}

# undef CPPAD_REV_HES_SWEEP_TRACE

CPPAD_END_NAMESPACE
# endif
