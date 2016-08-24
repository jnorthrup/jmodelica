 /*
    Copyright (C) 2009 Modelon AB

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License version 3 as published
    by the Free Software Foundation, or optionally, under the terms of the
    Common Public License version 1.0 as published by IBM.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License, or the Common Public License, for more details.

    You should have received copies of the GNU General Public License
    and the Common Public License along with this program.  If not,
    see <http://www.gnu.org/licenses/> or
    <http://www.ibm.com/developerworks/library/os-cpl.html/> respectively.
*/



/** \file jmi_array_cppad.h
 *  \brief Handling of arrays in the JMI interface, version with CppAD.
 *
 *  Note that arrays are only used in functions at this point.
 */

#ifndef _JMI_ARRAY_CPPAD_H
#define _JMI_ARRAY_CPPAD_H

#include "jmi_array_common.h"

#include <cppad/cppad.hpp>
#include <vector>

typedef struct jmi_array_t jmi_array_t;
struct jmi_array_t {
    int*                      size;
    int                       num_dims;
    int                       num_elems;
    CppAD::VecAD<jmi_real_t>* var;
};

typedef CppAD::VecAD<jmi_real_t>::reference jmi_ad_array_ref_t;

// Linked list for saving pointers to be freed at return
class jmi_dynamic_list {
public:
    jmi_dynamic_list() { next = 0; }
    jmi_dynamic_list(jmi_dynamic_list* n) { next = n; }
    virtual ~jmi_dynamic_list();
private:
    jmi_dynamic_list* next;
};
class jmi_dynamic_list_arr : public jmi_dynamic_list {
public:
    jmi_dynamic_list_arr(jmi_dynamic_list* n, CppAD::VecAD<jmi_real_t>* d) : jmi_dynamic_list(n) { data = d; }
    virtual ~jmi_dynamic_list_arr();
private:
    CppAD::VecAD<jmi_real_t>* data;
};

// Record array type declaration macro
#define JMI_ARRAY_TYPE(rec, arr) \
    typedef struct _##arr {\
        int* size;\
        int  num_dims;\
        int  num_elems;\
        std::vector<rec>* var;\
    } arr;\
    class jmi_dynamic_list_arr_##arr : public jmi_dynamic_list {\
    public:\
        jmi_dynamic_list_arr_##arr(jmi_dynamic_list* n, std::vector<rec>* d) : jmi_dynamic_list(n) { data = d; }\
        virtual ~jmi_dynamic_list_arr_##arr();\
    private:\
        std::vector<rec>* data;\
    };\
    jmi_dynamic_list_arr_##arr::~jmi_dynamic_list_arr_##arr() {\
        delete data;\
    }

// Array creation macro
#define JMI_ARRAY_DECL_STATREAL(type, arr, name, ne, nd) \
    int name##_size[nd];\
    CppAD::VecAD<jmi_real_t> name##_var(ne);\
    jmi_array_t name##_obj = { 0, (int) (nd), (int) (ne), 0 };\
    jmi_array_t* name = &name##_obj;

// Record array creation macro
#define JMI_ARRAY_DECL_STAT(type, arr, name, ne, nd) \
    int name##_size[nd];\
    std::vector<type> name##_var(ne);\
    arr name##_obj = { 0, (int) (nd), (int) (ne), 0 };\
    arr* name = &name##_obj;

// Dynamic array creation macro
#define JMI_ARRAY_DECL_DYNAREAL(type, arr, name, ne, nd) \
    int name##_size[nd];\
    jmi_array_t name##_obj = { name##_size, (int) (nd), 0, 0 };\
    jmi_array_t* name = &name##_obj;

// Dynamic record array creation macro
#define JMI_ARRAY_DECL_DYNA(type, arr, name, ne, nd) \
    int name##_size[nd];\
    std::vector<type>* name##_var = new std::vector<type>(0);\
    JMI_DYNAMIC_ADD_POINTER(name##_var, jmi_dynamic_list_arr_##arr)\
    arr name##_obj = { name##_size, (int) (nd), 0, name##_var };\
    arr* name = &name##_obj;

#define JMI_ARRAY_INIT_STAT(type, arr, name, ne, nd)\
    name##_obj.size = name##_size;\
    name##_obj.var = &name##_var;

#define JMI_ARRAY_INIT_STATREAL(type, arr, name, ne, nd)\
    JMI_ARRAY_INIT_STAT(type, arr, name, ne, nd)

#define JMI_ARRAY_INIT_DYNA(type, arr, name, ne, nd)\
    name##_var->resize((int) (ne));\
    name##_obj.num_elems = (int) (ne);

#define JMI_ARRAY_INIT_DYNAREAL(type, arr, name, ne, nd)\
    name##_obj.var = new CppAD::VecAD<jmi_real_t>((int) (ne));\
    JMI_DYNAMIC_ADD_POINTER(name##_obj.var, jmi_dynamic_list_arr)\
    name##_obj.num_elems = (int) (ne);\

// Macro for declaring dynamic list variable - should be called at beginning of function
#define JMI_DYNAMIC_INIT() \
    jmi_dynamic_list* jmi_dynamic_first = new jmi_dynamic_list;

// Macro for adding a pointer to dynamic list - only for use in other macros
#define JMI_DYNAMIC_ADD_POINTER(pointer, type) \
    jmi_dynamic_first = new type(jmi_dynamic_first, pointer);

// Dynamic deallocation of all dynamically allocated arrays and record arrays - should be called before return
#define JMI_DYNAMIC_FREE() \
    delete jmi_dynamic_first;

// Record array access macros
#define jmi_array_rec_1(arr, i1) (&((*((arr)->var))[_JMI_ARR_I_1(arr, i1)]))
#define jmi_array_rec_2(arr, i1, i2) (&((*((arr)->var))[_JMI_ARR_I_2(arr, i1, i2)]))
#define jmi_array_rec_3(arr, i1, i2, i3) (&((*((arr)->var))[_JMI_ARR_I_3(arr, i1, i2, i3)]))
#define jmi_array_rec_4(arr, i1, i2, i3, i4) (&((*((arr)->var))[_JMI_ARR_I_4(arr, i1, i2, i3, i4)]))
#define jmi_array_rec_5(arr, i1, i2, i3, i4, i5) (&((*((arr)->var))[_JMI_ARR_I_5(arr, i1, i2, i3, i4, i5)]))
#define jmi_array_rec_6(arr, i1, i2, i3, i4, i5, i6) (&((*((arr)->var))[_JMI_ARR_I_6(arr, i1, i2, i3, i4, i5, i6)]))
#define jmi_array_rec_7(arr, i1, i2, i3, i4, i5, i6, i7) (&((*((arr)->var))[_JMI_ARR_I_7(arr, i1, i2, i3, i4, i5, i6, i7)]))
#define jmi_array_rec_8(arr, i1, i2, i3, i4, i5, i6, i7, i8) (&((*((arr)->var))[_JMI_ARR_I_8(arr, i1, i2, i3, i4, i5, i6, i7, i8)]))
#define jmi_array_rec_9(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9) (&((*((arr)->var))[_JMI_ARR_I_9(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9)]))
#define jmi_array_rec_10(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10) (&((*((arr)->var))[_JMI_ARR_I_10(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10)]))
#define jmi_array_rec_11(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11) (&((*((arr)->var))[_JMI_ARR_I_11(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11)]))
#define jmi_array_rec_12(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12) (&((*((arr)->var))[_JMI_ARR_I_12(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12)]))
#define jmi_array_rec_13(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) (&((*((arr)->var))[_JMI_ARR_I_13(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13)]))
#define jmi_array_rec_14(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14) (&((*((arr)->var))[_JMI_ARR_I_14(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14)]))
#define jmi_array_rec_15(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15) (&((*((arr)->var))[_JMI_ARR_I_15(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15)]))
#define jmi_array_rec_16(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16) (&((*((arr)->var))[_JMI_ARR_I_16(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16)]))
#define jmi_array_rec_17(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17) (&((*((arr)->var))[_JMI_ARR_I_17(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17)]))
#define jmi_array_rec_18(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18) (&((*((arr)->var))[_JMI_ARR_I_18(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18)]))
#define jmi_array_rec_19(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19) (&((*((arr)->var))[_JMI_ARR_I_19(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19)]))
#define jmi_array_rec_20(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20) (&((*((arr)->var))[_JMI_ARR_I_20(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20)]))
#define jmi_array_rec_21(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21) (&((*((arr)->var))[_JMI_ARR_I_21(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21)]))
#define jmi_array_rec_22(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22) (&((*((arr)->var))[_JMI_ARR_I_22(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22)]))
#define jmi_array_rec_23(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23) (&((*((arr)->var))[_JMI_ARR_I_23(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23)]))
#define jmi_array_rec_24(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24) (&((*((arr)->var))[_JMI_ARR_I_24(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24)]))
#define jmi_array_rec_25(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25) (&((*((arr)->var))[_JMI_ARR_I_25(arr, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25)]))

// Access functions
jmi_ad_var_t jmi_array_val_1(jmi_array_t* arr, jmi_ad_var_t i1);
jmi_ad_var_t jmi_array_val_2(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2);
jmi_ad_var_t jmi_array_val_3(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3);
jmi_ad_var_t jmi_array_val_4(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4);
jmi_ad_var_t jmi_array_val_5(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5);
jmi_ad_var_t jmi_array_val_6(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6);
jmi_ad_var_t jmi_array_val_7(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7);
jmi_ad_var_t jmi_array_val_8(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8);
jmi_ad_var_t jmi_array_val_9(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9);
jmi_ad_var_t jmi_array_val_10(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10);
jmi_ad_var_t jmi_array_val_11(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11);
jmi_ad_var_t jmi_array_val_12(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12);
jmi_ad_var_t jmi_array_val_13(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13);
jmi_ad_var_t jmi_array_val_14(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14);
jmi_ad_var_t jmi_array_val_15(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15);
jmi_ad_var_t jmi_array_val_16(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16);
jmi_ad_var_t jmi_array_val_17(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16, jmi_ad_var_t i17);
jmi_ad_var_t jmi_array_val_18(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16, jmi_ad_var_t i17, jmi_ad_var_t i18);
jmi_ad_var_t jmi_array_val_19(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16, jmi_ad_var_t i17, jmi_ad_var_t i18, jmi_ad_var_t i19);
jmi_ad_var_t jmi_array_val_20(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16, jmi_ad_var_t i17, jmi_ad_var_t i18, jmi_ad_var_t i19, jmi_ad_var_t i20);
jmi_ad_var_t jmi_array_val_21(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16, jmi_ad_var_t i17, jmi_ad_var_t i18, jmi_ad_var_t i19, jmi_ad_var_t i20, jmi_ad_var_t i21);
jmi_ad_var_t jmi_array_val_22(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16, jmi_ad_var_t i17, jmi_ad_var_t i18, jmi_ad_var_t i19, jmi_ad_var_t i20, jmi_ad_var_t i21, jmi_ad_var_t i22);
jmi_ad_var_t jmi_array_val_23(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16, jmi_ad_var_t i17, jmi_ad_var_t i18, jmi_ad_var_t i19, jmi_ad_var_t i20, jmi_ad_var_t i21, jmi_ad_var_t i22, jmi_ad_var_t i23);
jmi_ad_var_t jmi_array_val_24(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16, jmi_ad_var_t i17, jmi_ad_var_t i18, jmi_ad_var_t i19, jmi_ad_var_t i20, jmi_ad_var_t i21, jmi_ad_var_t i22, jmi_ad_var_t i23, jmi_ad_var_t i24);
jmi_ad_var_t jmi_array_val_25(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16, jmi_ad_var_t i17, jmi_ad_var_t i18, jmi_ad_var_t i19, jmi_ad_var_t i20, jmi_ad_var_t i21, jmi_ad_var_t i22, jmi_ad_var_t i23, jmi_ad_var_t i24, jmi_ad_var_t i25);

// Reference functions
jmi_ad_array_ref_t jmi_array_ref_1(jmi_array_t* arr, jmi_ad_var_t i1);
jmi_ad_array_ref_t jmi_array_ref_2(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2);
jmi_ad_array_ref_t jmi_array_ref_3(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3);
jmi_ad_array_ref_t jmi_array_ref_4(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4);
jmi_ad_array_ref_t jmi_array_ref_5(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5);
jmi_ad_array_ref_t jmi_array_ref_6(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6);
jmi_ad_array_ref_t jmi_array_ref_7(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7);
jmi_ad_array_ref_t jmi_array_ref_8(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8);
jmi_ad_array_ref_t jmi_array_ref_9(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9);
jmi_ad_array_ref_t jmi_array_ref_10(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10);
jmi_ad_array_ref_t jmi_array_ref_11(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11);
jmi_ad_array_ref_t jmi_array_ref_12(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12);
jmi_ad_array_ref_t jmi_array_ref_13(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13);
jmi_ad_array_ref_t jmi_array_ref_14(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14);
jmi_ad_array_ref_t jmi_array_ref_15(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15);
jmi_ad_array_ref_t jmi_array_ref_16(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16);
jmi_ad_array_ref_t jmi_array_ref_17(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16, jmi_ad_var_t i17);
jmi_ad_array_ref_t jmi_array_ref_18(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16, jmi_ad_var_t i17, jmi_ad_var_t i18);
jmi_ad_array_ref_t jmi_array_ref_19(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16, jmi_ad_var_t i17, jmi_ad_var_t i18, jmi_ad_var_t i19);
jmi_ad_array_ref_t jmi_array_ref_20(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16, jmi_ad_var_t i17, jmi_ad_var_t i18, jmi_ad_var_t i19, jmi_ad_var_t i20);
jmi_ad_array_ref_t jmi_array_ref_21(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16, jmi_ad_var_t i17, jmi_ad_var_t i18, jmi_ad_var_t i19, jmi_ad_var_t i20, jmi_ad_var_t i21);
jmi_ad_array_ref_t jmi_array_ref_22(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16, jmi_ad_var_t i17, jmi_ad_var_t i18, jmi_ad_var_t i19, jmi_ad_var_t i20, jmi_ad_var_t i21, jmi_ad_var_t i22);
jmi_ad_array_ref_t jmi_array_ref_23(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16, jmi_ad_var_t i17, jmi_ad_var_t i18, jmi_ad_var_t i19, jmi_ad_var_t i20, jmi_ad_var_t i21, jmi_ad_var_t i22, jmi_ad_var_t i23);
jmi_ad_array_ref_t jmi_array_ref_24(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16, jmi_ad_var_t i17, jmi_ad_var_t i18, jmi_ad_var_t i19, jmi_ad_var_t i20, jmi_ad_var_t i21, jmi_ad_var_t i22, jmi_ad_var_t i23, jmi_ad_var_t i24);
jmi_ad_array_ref_t jmi_array_ref_25(jmi_array_t* arr, jmi_ad_var_t i1, jmi_ad_var_t i2, jmi_ad_var_t i3, jmi_ad_var_t i4, jmi_ad_var_t i5, jmi_ad_var_t i6, jmi_ad_var_t i7, jmi_ad_var_t i8, jmi_ad_var_t i9, jmi_ad_var_t i10, jmi_ad_var_t i11, jmi_ad_var_t i12, jmi_ad_var_t i13, jmi_ad_var_t i14, jmi_ad_var_t i15, jmi_ad_var_t i16, jmi_ad_var_t i17, jmi_ad_var_t i18, jmi_ad_var_t i19, jmi_ad_var_t i20, jmi_ad_var_t i21, jmi_ad_var_t i22, jmi_ad_var_t i23, jmi_ad_var_t i24, jmi_ad_var_t i25);

#endif /* _JMI_ARRAY_CPPAD_H */
