# ifndef CPPAD_SPARSE_PACK_INCLUDED
# define CPPAD_SPARSE_PACK_INCLUDED

/* --------------------------------------------------------------------------
CppAD: C++ Algorithmic Differentiation: Copyright (C) 2003-10 Bradley M. Bell

CppAD is distributed under multiple licenses. This distribution is under
the terms of the 
                    Common Public License Version 1.0.

A copy of this license is included in the COPYING file of this distribution.
Please visit http://www.coin-or.org/CppAD/ for information on other licenses.
-------------------------------------------------------------------------- */
# include <cppad/local/cppad_assert.hpp>

CPPAD_BEGIN_NAMESPACE
/*!
\file sparse_pack.hpp
Vector of sets of positive integers.
*/

/*!
Vector of sets of postivie integers, each set stored as a packed boolean array.
*/


class sparse_pack {
private:
	/// Type used to pack elements (should be the same as corresponding
	/// typedef in multiple_n_bit() in test_more/sparse_hacobian.cpp)
	typedef size_t Pack;
	/// Number of bits per Pack value
	static const size_t n_bit_ = std::numeric_limits<Pack>::digits;
	/// Number of sets that we are representing 
	/// (set by constructor and resize).
	size_t n_set_;
	/// Possible elements in each set are 0, 1, ..., end_ - 1
	/// (set by constructor and resize).
	size_t end_;
	/// Number of \c Pack values necessary to represent \c end_ bits.
	/// (set by constructor and resize).
	size_t n_pack_;
	/// Is the memory pointed to by \c data_ allocated by this object
	/// (set by contructor and resize)
	bool   allocated_;    
	/// Pointer to the beginning of data for all the sets.
	Pack*  data_;
	/// index for which we were retrieving next_element
	/// (use n_set_ if no such index exists).
	size_t next_index_;
	/// Next element to start search at 
	/// (use end_ for no such element exists; i.e., past end of the set).
	size_t next_element_;
public:
	// -----------------------------------------------------------------
	/*! Default constructor (no sets)
	*/
	sparse_pack(void) : 
	n_set_(0)                     , 
	end_(0)                       , 
	n_pack_(0)                    ,
	allocated_(false)             ,
	data_(CPPAD_NULL)             ,
	next_index_(0)                ,
	next_element_(0)
	{ }
	// -----------------------------------------------------------------
	/*! Make use of copy constructor an error
 
	\param v
	vector that we are attempting to make a copy of.
 	*/
	sparse_pack(const sparse_pack& v)
	{	// Error: 
		// Probably a sparse_pack argument has been passed by value
		CPPAD_ASSERT_UNKNOWN(0); 
	}
	// -----------------------------------------------------------------
	/*! Destructor 
	*/
	~sparse_pack(void)
	{	if( allocated_ )
		{	allocated_ = false;
			CPPAD_TRACK_DEL_VEC( data_ ); 
		}
	}
	// -----------------------------------------------------------------
	/*! Change number of sets, set end, and initialize all sets as empty

	Any memory currently allocated for this object is freed. If both
	\a n_set and \a end are non-zero new memory is allocated, otherwise
	no new memory is allocated for the object.

	\param n_set
	is the number of sets in this vector of sets.

	\param end
	is the maximum element plus one (the minimum element is 0).
	*/
	void resize(size_t n_set, size_t end) 
	{	Pack zero(0);
		if( allocated_ )
		{	allocated_ = false;
			CPPAD_TRACK_DEL_VEC(data_);
		}

		n_set_          = n_set;
		end_            = end;
		n_pack_         = ( 1 + (end - 1) / n_bit_ );
		size_t i        = n_set_ * n_pack_;

		if( i > 0 )
		{	data_      = CPPAD_TRACK_NEW_VEC(i, data_);
			allocated_ = true;
			while(i--)
				data_[i] = zero;
		}

		// values that signify past end of list
		next_index_   = n_set;
		next_element_ = end;
	}
	// -----------------------------------------------------------------
	/*! Add one element to a set.

	\param index
	is the index for this set in the vector of sets.

	\param element
	is the element we are adding to the set.

	\par Checked Assertions
	\li index    < n_set_
	\li element  < end_
	*/
	void add_element(size_t index, size_t element)
	{	static Pack one(1);
		CPPAD_ASSERT_UNKNOWN( index   < n_set_ );
		CPPAD_ASSERT_UNKNOWN( element < end_ );
		size_t j  = element / n_bit_;
		size_t k  = element - j * n_bit_;
		Pack mask = one << k;
		data_[ index * n_pack_ + j] |= mask;
	}
	// -----------------------------------------------------------------
	/*! Begin retrieving elements from one of the sets.
	
	\param index
	is the index for the set that is going to be retrieved.
	The elements of the set are retrieved in increasing order.

	\par Checked Assertions
	\li index  < n_set_
	*/
	void begin(size_t index)
	{	// initialize element to search for in this set
		CPPAD_ASSERT_UNKNOWN( index < n_set_ );
		next_index_   = index;
		next_element_ = 0; 
	}
	/*! Get the next element from the current retrieval set.
	
	\return
	is the next element in the set with index
	specified by the previous call to \c begin.
	If no such element exists, \c this->end() is returned.
	*/
	size_t next_element(void)
	{	static Pack one(1);
		CPPAD_ASSERT_UNKNOWN( next_index_ < n_set_ );
		CPPAD_ASSERT_UNKNOWN( next_element_ <= end_ );

		if( next_element_ == end_ )
			return end_;

		// initialize packed data index
		size_t j  = next_element_ / n_bit_;

		// initialize bit index
		size_t k  = next_element_ - j * n_bit_;

		// start search at this packed value
		Pack check = data_[ next_index_ * n_pack_ + j ];
		while( true )
		{	// increment next element before checking this one
			next_element_++;
			// check if this element is in the set
			if( check & (one << k) )
				return next_element_ - 1;
			// check if no more elements in the set
			if( next_element_ == end_ )
				return end_;
			// increment bit index in Pack value so corresponds to 
			// next element
			k++;
			CPPAD_ASSERT_UNKNOWN( k <= n_bit_ );
			if( k == n_bit_ )
			{	// get next packed value
				k     = 0;
				j++;
				CPPAD_ASSERT_UNKNOWN( j < n_pack_ );
				check = data_[ next_index_ * n_pack_ + j ];
			}
		}
		// should never get here
		CPPAD_ASSERT_UNKNOWN(false);
		return end_;
	}
	// -----------------------------------------------------------------
	/*! Assign the empty set to one of the sets.

	\param target
	is the index of the set we are setting to the empty set.

	\par Checked Assertions
	\li target < n_set_
	*/
	void clear(size_t target)
	{	// value with all its bits set to false
		static Pack zero(0);
		CPPAD_ASSERT_UNKNOWN( target < n_set_ );
		Pack *t  = data_ + target * n_pack_;

		size_t j = n_pack_;
		while(j--)
			*t++ = zero;
	}
	// -----------------------------------------------------------------
	/*! Assign one set equal to another set.

	\param this_target
	is the index (in this \c sparse_pack object) of the set being assinged.

	\param other_value
	is the index (in the other \c sparse_pack object) of the 
	that we are using as the value to assign to the target set.

	\param other
	is the other \c sparse_pack object (which may be the same as this
	\c sparse_pack object).

	\par Checked Assertions
	\li this_target  < n_set_
	\li other_value  < other.n_set_
	\li n_pack_     == other.n_pack_ 
	*/
	void assignment(
		size_t               this_target  , 
		size_t               other_value  , 
		const sparse_pack&   other        )
	{	CPPAD_ASSERT_UNKNOWN( this_target  <   n_set_        );
		CPPAD_ASSERT_UNKNOWN( other_value  <   other.n_set_  );
		CPPAD_ASSERT_UNKNOWN( n_pack_      ==  other.n_pack_ );
		Pack *t  = data_       + this_target * n_pack_;
		Pack *v  = other.data_ + other_value * n_pack_;

		size_t j = n_pack_;
		while(j--)
			*t++ = *v++;
	}

	// -----------------------------------------------------------------
	/*! Assing a set equal to the union of two other sets.

	\param this_target
	is the index (in this \c sparse_pack object) of the set being assinged.

	\param this_left
	is the index (in this \c sparse_pack object) of the 
	left operand for the union operation.
	It is OK for \a this_target and \a this_left to be the same value.

	\param other_right
	is the index (in the other \c sparse_pack object) of the 
	right operand for the union operation.
	It is OK for \a this_target and \a other_right to be the same value.

	\param other
	is the other \c sparse_pack object (which may be the same as this
	\c sparse_pack object).

	\par Checked Assertions
	\li this_target <  n_set_
	\li this_left   <  n_set_
	\li other_right <  other.n_set_
	\li n_pack_     == other.n_pack_ 
	*/
	void binary_union(
		size_t                  this_target  , 
		size_t                  this_left    , 
		size_t                  other_right  , 
		const sparse_pack&      other        )
	{	CPPAD_ASSERT_UNKNOWN( this_target < n_set_         );
		CPPAD_ASSERT_UNKNOWN( this_left   < n_set_         );
		CPPAD_ASSERT_UNKNOWN( other_right < other.n_set_   );
		CPPAD_ASSERT_UNKNOWN( n_pack_    ==  other.n_pack_ );

		Pack *t  = data_       + this_target * n_pack_;
		Pack *l  = data_       + this_left   * n_pack_;
		Pack *r  = other.data_ + other_right * n_pack_;

		size_t j = n_pack_;
		while(j--)
			*t++ = (*l++ | *r++);
	}
	// -----------------------------------------------------------------
	/*! Amount of memory used by this vector of sets
 
	\return
	The amount of memory in units of type unsigned char memory.
 	*/
	size_t memory(void) const
	{	return n_set_ * n_pack_ * sizeof(Pack);
	}
	// -----------------------------------------------------------------
	/*! Fetch n_set for vector of sets object.
	
	\return
	Number of from sets for this vector of sets object
	*/
	size_t n_set(void) const
	{	return n_set_; }
	// -----------------------------------------------------------------
	/*! Fetch end for this vector of sets object. 
	
	\return
	is the maximum element value plus one (the minimum element value is 0).
	*/
	size_t end(void) const
	{	return end_; }
};

CPPAD_END_NAMESPACE
# endif
