/* $Id: sparse_map2vec.cpp 1641 2010-02-01 16:39:45Z bradbell $ */
/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-10 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */
# include "cppad_ipopt_nlp.hpp"
# include "sparse_map2vec.hpp"

CPPAD_BEGIN_NAMESPACE
/*!
\file sparse_map2vec.cpp
\brief Create a two vector sparsity representation from a vector of maps.
*/


/*!
Create a two vector sparsity representation from a vector of maps.

\param sparse
Is a vector of maps representation of sparsity as well as
the index in the two vector representation. To be specific;
\verbatim
for(i = 0; i < sparse.size(); i++)
{	for(itr = sparse[i].begin(); itr != sparse[i].end(); itr++)
	{	j   = itr->first;
		// (i, j) is a possibly non-zero entry in sparsity pattern
		// k == itr->second, is corresponding index in i_row and j_col
		k++;
	}
}
\endverbatim

\param n_nz
is the total number of possibly non-zero entries.

\param i_row
The input size and element values for \c i_row do not matter.
On output, it has size \c n_nz
and <tt>i_row[k]</tt> contains the row index corresponding to the
\c k-th possibly non-zero entry.

\param j_col
The input size and element values for \c j_col do not matter.
On output, it has size \c n_nz
and <tt>j_col[k]</tt> contains the column index corresponding to the
\c k-th possibly non-zero entry.
*/
void sparse_map2vec(
	const CppAD::vector< std::map<size_t, size_t> > sparse,
	size_t&                                         n_nz  ,
	CppAD::vector<size_t>&                          i_row ,
	CppAD::vector<size_t>&                          j_col )
{
	size_t i, j, k, m;

	// number of rows in sparse
	m    = sparse.size();

	// itererator for one row
	std::map<size_t, size_t>::const_iterator itr;

	// count the number of possibly non-zeros in sparse
	n_nz = 0;
	for(i = 0; i < m; i++)
		for(itr = sparse[i].begin(); itr != sparse[i].end(); itr++)
			++n_nz;

	// resize the return vectors to accomidate n_nz entries
	i_row.resize(n_nz);
	j_col.resize(n_nz);

	// set the row and column indices and check assumptions on sparse
	k = 0;
	for(i = 0; i < m; i++)
	{	for(itr = sparse[i].begin(); itr != sparse[i].end(); itr++)
		{	j = itr->first;
			CPPAD_ASSERT_UNKNOWN( k == itr->second );
			i_row[k] = i;
			j_col[k] = j;
			++k;
		}
	}
	return;
}

CPPAD_END_NAMESPACE
