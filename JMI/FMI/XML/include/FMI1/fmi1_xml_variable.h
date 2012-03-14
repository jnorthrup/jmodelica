/*
    Copyright (C) 2012 Modelon AB

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3 of the License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/



/** \file fmi1_xml_variable.h
*  \brief Public interface to the FMI XML C-library. Handling of model variables.
*/

#ifndef FMI1_XML_VARIABLE_H_
#define FMI1_XML_VARIABLE_H_

#include "fmi1_xml_model_description.h"
#include "fmi1_xml_type.h"


#ifdef __cplusplus
extern "C" {
#endif

const char* fmi1_xml_get_variable_name(fmi1_xml_variable_t*);
const char* fmi1_xml_get_variable_description(fmi1_xml_variable_t*);

fmi1_value_reference_t fmi1_xml_get_variable_vr(fmi1_xml_variable_t*);

/*
    For scalar variable gives the type definition is present
*/
fmi1_xml_variable_typedef_t* fmi1_xml_get_variable_declared_type(fmi1_xml_variable_t*);
fmi1_xml_base_type_enu_t fmi1_xml_get_variable_base_type(fmi1_xml_variable_t*);

int   fmi1_xml_get_variable_has_start(fmi1_xml_variable_t*);
int   fmi1_xml_get_variable_is_fixed(fmi1_xml_variable_t*);

fmi1_variability_enu_t fmi1_xml_get_variability(fmi1_xml_variable_t*);

fmi1_causality_enu_t fmi1_xml_get_causality(fmi1_xml_variable_t*);

/* DirectDependency is returned for variables with causality Output. Null pointer for others. */
fmi1_xml_variable_list_t* fmi1_xml_get_direct_dependency(fmi1_xml_model_description_t* md,fmi1_xml_variable_t*);

fmi1_xml_real_variable_t* fmi1_xml_get_variable_as_real(fmi1_xml_variable_t*);
fmi1_xml_integer_variable_t* fmi1_xml_get_variable_as_integer(fmi1_xml_variable_t*);
fmi1_xml_enum_variable_t* fmI_xml_get_variable_as_enum(fmi1_xml_variable_t*);
fmi1_xml_string_variable_t* fmi1_xml_get_variable_as_string(fmi1_xml_variable_t*);
fmi1_xml_bool_variable_t* fmi1_xml_get_variable_as_boolean(fmi1_xml_variable_t*);

double fmi1_xml_get_real_variable_start(fmi1_xml_real_variable_t* v);
double fmi1_xml_get_real_variable_max(fmi1_xml_real_variable_t* v);
double fmi1_xml_get_real_variable_min(fmi1_xml_real_variable_t* v);
double fmi1_xml_get_real_variable_nominal(fmi1_xml_real_variable_t* v);
fmi1_xml_unit_t* fmi1_xml_get_real_variable_unit(fmi1_xml_real_variable_t* v);
fmi1_xml_display_unit_t* fmi1_xml_get_real_variable_display_unit(fmi1_xml_real_variable_t* v);

const char* fmi1_xml_get_string_variable_start(fmi1_xml_string_variable_t* v);
fmi1_boolean_t fmi1_xml_get_boolean_variable_start(fmi1_xml_bool_variable_t* v);

int fmi1_xml_get_integer_variable_start(fmi1_xml_integer_variable_t* v);
int fmi1_xml_get_integer_variable_min(fmi1_xml_integer_variable_t* v);
int fmi1_xml_get_integer_variable_max(fmi1_xml_integer_variable_t* v);

int fmi1_xml_get_enum_variable_start(fmi1_xml_enum_variable_t* v);
int fmi1_xml_get_enum_variable_min(fmi1_xml_enum_variable_t* v);
int fmi1_xml_get_enum_variable_max(fmi1_xml_enum_variable_t* v);


fmi1_variable_alias_kind_enu_t fmi1_xml_get_variable_alias_kind(fmi1_xml_variable_t*);
fmi1_xml_variable_t* fmi1_xml_get_variable_alias_base(fmi1_xml_model_description_t* md,fmi1_xml_variable_t*);

/*
    Return the list of all the variables aliased to the given one (including the base one.
    The list is ordered: base variable, aliases, negated aliases.
*/
fmi1_xml_variable_list_t* fmi1_xml_get_variable_aliases(fmi1_xml_model_description_t* md,fmi1_xml_variable_t*);

#ifdef __cplusplus
}
#endif
#endif
