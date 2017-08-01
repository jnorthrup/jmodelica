/*
    Copyright (C) 2015 Modelon AB

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
package CADCodeGenTests

model CADsin
	Real y;
	Real x1(start=1.5);
equation
	y = sin(x1);
	x1 = 1;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADsin",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    (*res)[0] = sin(_x1_1) - (_y_0);
    (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * cos(_x1_1) - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 1.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
")})));
end CADsin;

model CADcos
  Real y;
  Real x1(start=1.5); 
equation 
  y = cos(x1);
  x1 = 1;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADcos",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    (*res)[0] = cos(_x1_1) - (_y_0);
    (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * -sin(_x1_1) - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 1.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
")})));
end CADcos;

model CADtan
	Real y;
	Real x1(start=1.5);
equation
	y = tan(x1);
	x1 = 1;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADtan",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    (*res)[0] = jmi_tan_equation(jmi, _x1_1,\"tan(x1)\") - (_y_0);
    (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] / (cos(_x1_1) * cos(_x1_1)) - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 1.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
")})));
end CADtan;

model CADasin

	Real y;
	Real x1(start=1.5);
equation
	y = asin(x1);
	x1 = 1;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADasin",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    (*res)[0] = asin(_x1_1) - (_y_0);
    (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] / sqrt(1 - _x1_1 * _x1_1) - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 1.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
")})));
end CADasin;

model CADacos

	Real y;
	Real x1(start=1.5);
equation
	y = acos(x1);
	x1 = 1;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADacos",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    (*res)[0] = acos(_x1_1) - (_y_0);
    (*dF)[0] = - (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] / sqrt(1 - _x1_1 * _x1_1) - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 1.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
")})));
end CADacos;

model CADatan

	Real y;
	Real x1(start=1.5);
equation
	y = atan(x1);
	x1 = 1;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADatan",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    (*res)[0] = atan(_x1_1) - (_y_0);
    (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] / (1 + _x1_1 * _x1_1) - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 1.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
")})));
end CADatan;

model CADatan2

	Real y;
	Real x1(start=1.5);
	Real x2(start=2.0);
equation
	y = atan2(x1,x2);
	x1 = 1;
	x2 = (-1.5);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADatan2",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    (*res)[0] = jmi_atan2_equation(jmi, _x1_1,_x2_2,\"atan2(x1, x2)\") - (_y_0);
    (*dF)[0] = ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * _x2_2 - _x1_1 * (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]) / (_x2_2 * _x2_2 + _x1_1 * _x1_1) - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 1.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
    (*res)[2] = -1.5 - (_x2_2);
    (*dF)[2] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]);
")})));
end CADatan2;

model CADsinh

	Real y;
	Real x1(start=1.5);
equation
	y = sinh(x1);
	x1 = 1;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADsinh",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    (*res)[0] = jmi_sinh_equation(jmi, _x1_1,\"sinh(x1)\") - (_y_0);
    (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * cosh(_x1_1) - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 1.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
")})));
end CADsinh;

model CADcosh

	Real y;
	Real x1(start=1.5);
equation
	y = cosh(x1);
	x1 = 1;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADcosh",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    (*res)[0] = jmi_cosh_equation(jmi, _x1_1,\"cosh(x1)\") - (_y_0);
    (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * sinh(_x1_1) - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 1.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
")})));
end CADcosh;

model CADtanh


	Real y;
	Real x1(start=1.5);
equation
	y = tanh(x1);
	x1 = 1;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADtanh",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    jmi_real_t v_0;
    v_0 = tanh(_x1_1);
    (*res)[0] = v_0 - (_y_0);
    (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * (1 - v_0 * v_0) - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 1.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
")})));
end CADtanh;

model CADexp


	Real y;
	Real x1(start=1.5);
equation
	y = exp(x1);
	x1 = 1;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADexp",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    jmi_real_t v_0;
    v_0 = jmi_exp_equation(jmi, _x1_1,\"exp(x1)\");
    (*res)[0] = v_0 - (_y_0);
    (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * v_0 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 1.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
")})));
end CADexp;

model CADlog


	Real y;
	Real x1(start=1.5);
equation
	y = log(x1);
	x1 = 2;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADlog",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    (*res)[0] = jmi_log_equation(jmi, _x1_1,\"log(x1)\") - (_y_0);
    (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] / _x1_1 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 2.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
")})));
end CADlog;

model CADlog10


	Real y;
	Real x1(start=1.5);
equation
	y = log10(x1);
	x1 = 1;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADlog10",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    (*res)[0] = jmi_log10_equation(jmi, _x1_1,\"log10(x1)\") - (_y_0);
    (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * log10(exp(1)) / _x1_1 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 1.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
")})));
end CADlog10;

model CADsqrt


 	Real y;
	Real x1(start=1.5);
equation
	y = sqrt(x1);
	x1 = 2;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADsqrt",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    jmi_real_t v_0;
    v_0 = sqrt(_x1_1);
    (*res)[0] = v_0 - (_y_0);
    (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] / (2 * v_0) - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 2.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
")})));
end CADsqrt;

model CADadd



	Real y;
	Real x1(start=1.5);
	Real x2(start=2.0);
equation
	y = x1 + x2;
	x1 = 1;
	x2 = 3;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADadd",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    (*res)[0] = _x1_1 + _x2_2 - (_y_0);
    (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] + (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 1.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
    (*res)[2] = 3.0 - (_x2_2);
    (*dF)[2] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]);
")})));
end CADadd;

model CADsub



	Real y;
	Real x1(start=1.5);
	Real x2(start=2.0);
equation
	y = x1 - x2;
	x1 = 1;
	x2 = 3;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADsub",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    (*res)[0] = _x1_1 - _x2_2 - (_y_0);
    (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] - (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 1.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
    (*res)[2] = 3.0 - (_x2_2);
    (*dF)[2] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]);
")})));
end CADsub;

model CADmul



	Real y;
	Real x1(start=1.5);
	Real x2(start=2.0);
equation
	y = x1 * x2;
	x1 = 1;
	x2 = 3;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADmul",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    (*res)[0] = _x1_1 * _x2_2 - (_y_0);
    (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * _x2_2 + _x1_1 * (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 1.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
    (*res)[2] = 3.0 - (_x2_2);
    (*dF)[2] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]);
")})));
end CADmul;

model CADdiv
	Real y;
	Real x1(start=1.5);
	Real x2(start=2.0);
equation
	y = x1 / x2;
	x1 = 1;
	x2 = 3;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADdiv",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    (*res)[0] = jmi_divide_equation(jmi, _x1_1,_x2_2,\"x1 / x2\") - (_y_0);
    (*dF)[0] = ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * _x2_2 - _x1_1 * (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]) / (_x2_2 * _x2_2) - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 1.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
    (*res)[2] = 3.0 - (_x2_2);
    (*dF)[2] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]);
")})));
end CADdiv;

model CADpow
	Real y;
	Real x1(start=1.5);
	Real x2(start=2.0);
equation
	y = x1^x2;
	x1 = 2;
	x2 = 3;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADpow",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    jmi_real_t v_0;
    v_0 = jmi_pow_equation(jmi, _x1_1,_x2_2,\"x1 ^ x2\");
    (*res)[0] = v_0 - (_y_0);
    (*dF)[0] = _x1_1 == 0 ? 0 : (v_0 * ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] * log(jmi_abs(_x1_1)) + _x2_2 * (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] / _x1_1)) - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 2.0 - (_x1_1);
    (*dF)[1] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
    (*res)[2] = 3.0 - (_x2_2);
    (*dF)[2] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]);
")})));
end CADpow;

model CADmin
	Real y;
	Real x1(start=1.5);
equation
	y = min(x1,2);
	x1 = -1;
	

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADmin",
            description="",
            variability_propagation=false,
            generate_ode_jacobian=true,
            eliminate_alias_variables=false,
            fmi_version="2.0",
            generate_ode=true,
            equation_sorting=true,
            template="$CAD_ode_derivatives$",
            generatedCode="

/******** Declarations *******/

jmi_real_t** dz = jmi->dz;
    /*********** ODE section ***********/
    /*********** Real outputs **********/
    /*** Integer and boolean outputs ***/
    /********* Other variables *********/
    _x1_1 = -1.0;
    (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = 0.0;
    _y_0 = jmi_min(_x1_1, 2.0);
    (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = _x1_1 < 2.0 ? (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] : 0.0;
")})));
end CADmin;

model CADmax
	Real y;
	Real x1(start=1.5);
equation
	y = max(x1,2);
	x1 = -1;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADmax",
            description="",
            variability_propagation=false,
            generate_ode_jacobian=true,
            eliminate_alias_variables=false,
            fmi_version="2.0",
            generate_ode=true,
            equation_sorting=true,
            template="$CAD_ode_derivatives$",
            generatedCode="

/******** Declarations *******/

jmi_real_t** dz = jmi->dz;
    /*********** ODE section ***********/
    /*********** Real outputs **********/
    /*** Integer and boolean outputs ***/
    /********* Other variables *********/
    _x1_1 = -1.0;
    (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = 0.0;
    _y_0 = jmi_max(_x1_1, 2.0);
    (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = _x1_1 > 2.0 ? (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] : 0.0;
")})));
end CADmax;

model CADabs
	Real y;
	Real x1(start=1.5);
equation
	y = abs(x1);
	x1 = -1;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADabs",
            description="",
            variability_propagation=false,
            generate_ode_jacobian=true,
            eliminate_alias_variables=false,
            fmi_version="2.0",
            generate_ode=true,
            equation_sorting=true,
            template="$CAD_ode_derivatives$",
            generatedCode="

/******** Declarations *******/

jmi_real_t** dz = jmi->dz;
    /*********** ODE section ***********/
    /*********** Real outputs **********/
    /*** Integer and boolean outputs ***/
    /********* Other variables *********/
    _x1_1 = -1.0;
    (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = 0.0;
    _y_0 = jmi_abs(_x1_1);
    (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = _x1_1 >= 0 ? (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] : -(*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx];
")})));
end CADabs;

package FSubscriptedExp
    model Use1
        Integer i = noEvent(mod(integer(time), size(y, 1)));
        Real[:] y = {sin(time), cos(time)};
        Real x = y[i] + 1;
    
    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="FSubscriptedExp_Use1",
            description="Test CAD code gen for FSubscriptedExp where it is used in the right hand side of an equation",
            generate_ode_jacobian=true,
            template="$CAD_ode_derivatives$",
            generatedCode="
    /******** Declarations *******/
    jmi_real_t v_0;
    jmi_real_t v_1;
    jmi_real_t v_2;
    jmi_real_t v_3;
    jmi_real_t v_4;
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_0, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_0, 2, 1)
    jmi_real_t** dz = jmi->dz;
    /*********** ODE section ***********/
    /*********** Real outputs **********/
    /*** Integer and boolean outputs ***/
    /********* Other variables *********/
    v_0 = floor(_time);
    v_4 = floor(_time);
    v_3 = v_4 / 2.0;
    v_2 = floor(v_3);
    v_1 = v_2 * 2.0;
    _i_0 = (v_0 - v_1);
    pre_i_0 = _i_0;
    _y_1_1 = sin(_time);
    (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = (*dz)[jmi->offs_t] * cos(_time);
    _y_2_2 = cos(_time);
    (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = (*dz)[jmi->offs_t] * -sin(_time);
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_var_0, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_der_0, 2, 1, 2)
    jmi_array_ref_1(tmp_var_0, 1) = _y_1_1;
    jmi_array_ref_1(tmp_var_0, 2) = _y_2_2;
    jmi_array_ref_1(tmp_der_0, 1) = (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx];
    jmi_array_ref_1(tmp_der_0, 2) = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx];
    _x_3 = jmi_array_val_1(tmp_var_0, _i_0) + 1.0;
    (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] = jmi_array_val_1(tmp_der_0, _i_0) + 0.0;
")})));
    end Use1;
    model Assign1
        // Disabled since CAD doesn't support algorithms!
        Integer i = mod(integer(time), size(y, 1));
        Real[2] y;
    algorithm
        y[i] := 1;
    
        annotation(__JModelica_disabled(UnitTesting(tests={
            CADCodeGenTestCase(
                name="FSubscriptedExp_Assign1",
                description="Test CAD code gen for FSubscriptedExp where it is assigned to",
                generate_ode_jacobian=true,
                template="$CAD_ode_derivatives$",
                generatedCode="
")})));
    end Assign1;
end FSubscriptedExp;

model smoothTest1
	Real x;
equation
	der(x) = smooth(0, if x >= 0 then x else 0); 

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="smoothTest1",
            description="Tests cad generation for the smooth operator",
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    jmi_real_t v_0;
    jmi_real_t d_0;
    if (_sw(0)) {
        v_0 = _x_0;
        d_0 = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx];
    } else {
        v_0 = 0.0;
        d_0 = 0.0;
    }
    (*res)[0] = (v_0) - (_der_x_1);
    (*dF)[0] = d_0 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
")})));
end smoothTest1;

model signTest1
    Real x;
equation
    der(x) = sign(x); 

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="signTest1",
            description="Tests cad generation for the sign operator",
            generate_dae_jacobian=true,
            inline_functions="none",
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    (*res)[0] = jmi_sign(_x_0) - (_der_x_1);
    (*dF)[0] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
")})));
end signTest1;

model signTest2
    function F
        input Real x;
        output Real y;
    algorithm
        y := sign(x);
    end F;
    Real x;
equation
    der(x) = F(x); 

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="signTest2",
            description="Tests cad generation for the sign() operator in functions",
            generate_dae_jacobian=true,
            inline_functions="none",
            template="
$CAD_functions$
$C_DAE_equation_directional_derivative$
",
            generatedCode="
void func_CADCodeGenTests_signTest2_F_der_AD0(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    y_var_v = jmi_sign(x_var_v);
    y_der_v = 0.0;
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}


    jmi_real_t v_0;
    jmi_real_t d_0;
    func_CADCodeGenTests_signTest2_F_der_AD0(_x_0, (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx], &v_0, &d_0);
    (*res)[0] = v_0 - (_der_x_1);
    (*dF)[0] = d_0 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
")})));
end signTest2;

model divFuncTest1
    Real x;
equation
    der(x) = div(x, 3.14); 

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="divFuncTest1",
            description="Tests cad generation for the div() operator",
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    jmi_real_t v_0;
    jmi_real_t v_1;
    jmi_real_t v_2;
    jmi_real_t v_3;
    jmi_real_t v_4;
    jmi_real_t v_5;
    (*res)[0] = _temp_1_1 - (_der_x_3);
    (*dF)[0] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    if (jmi->atInitial || jmi->atEvent) {
        _sw(0) = jmi_turn_switch(jmi, ((long)jmi_divide_equation(jmi, _x_0,3.14, \"div(x, 3.14)\")) - (pre_temp_1_1), _sw(0), JMI_REL_LT);
    }
    if (jmi->atInitial || jmi->atEvent) {
        _sw(1) = jmi_turn_switch(jmi, ((long)jmi_divide_equation(jmi, _x_0,3.14, \"div(x, 3.14)\")) - (pre_temp_1_1 + 1.0), _sw(1), JMI_REL_GEQ);
    }
    (*res)[1] = COND_EXP_EQ(LOG_EXP_OR(LOG_EXP_OR(_sw(0), _sw(1)), _atInitial), JMI_TRUE, ((long) jmi_divide_equation(jmi, _x_0,3.14, \"div(x, 3.14)\")), pre_temp_1_1) - (_temp_1_1);
")})));
end divFuncTest1;

model divFuncTest2
    function F
        input Real x;
        output Real y;
    algorithm
        y := div(x, 3.14);
    end F;
    Real x;
equation
    der(x) = F(x); 

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="divFuncTest2",
            description="Tests cad generation for the div() operator in functions",
            generate_dae_jacobian=true,
            inline_functions="none",
            template="
$CAD_functions$
$C_DAE_equation_directional_derivative$
",
            generatedCode="
void func_CADCodeGenTests_divFuncTest2_F_der_AD0(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    y_var_v = ((long)jmi_divide_function(\"CADCodeGenTests.divFuncTest2.F\", x_var_v,3.14,\"div(x, 3.14)\"));
    y_der_v = 0.0;
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}


    jmi_real_t v_0;
    jmi_real_t d_0;
    func_CADCodeGenTests_divFuncTest2_F_der_AD0(_x_0, (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx], &v_0, &d_0);
    (*res)[0] = v_0 - (_der_x_1);
    (*dF)[0] = d_0 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
")})));
end divFuncTest2;

model stringAddTest1
equation
    assert(time > 0.5, "Time (" + String(time) + ") > 0.5");

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="stringAddTest1",
            description="Tests cad generation for the string concatenation operator",
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    JMI_DEF_STR_STAT(tmp_1, 26)
    if (_sw(0) == JMI_FALSE) {
        JMI_DEF_STR_STAT(tmp_1, 26)
        JMI_INI_STR_STAT(tmp_1)
        snprintf(JMI_STR_END(tmp_1), JMI_STR_LEFT(tmp_1), \"%s\", \"Time (\");
        snprintf(JMI_STR_END(tmp_1), JMI_STR_LEFT(tmp_1), \"%-.*g\", (int) 6, _time);
        snprintf(JMI_STR_END(tmp_1), JMI_STR_LEFT(tmp_1), \"%s\", \") > 0.5\");
        jmi_assert_failed(tmp_1, JMI_ASSERT_ERROR);
    }
")})));
end stringAddTest1;


model notTest1
	Real x;
equation
	der(x) = noEvent(if not x >= 0 then x else 0); 

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="notTest1",
            description="Tests cad generation for the not operator",
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    jmi_real_t v_0;
    jmi_real_t d_0;
    jmi_real_t v_1;
    v_1 = COND_EXP_GE(_x_0, 0.0, JMI_TRUE, JMI_FALSE);
    if (LOG_EXP_NOT(v_1)) {
        v_0 = _x_0;
        d_0 = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx];
    } else {
        v_0 = 0.0;
        d_0 = 0.0;
    }
    (*res)[0] = (v_0) - (_der_x_1);
    (*dF)[0] = d_0 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
")})));
end notTest1;

model IfExpExample1
    Real x,u;
equation
    u = if(x > 3) then noEvent(if time<=Modelica.Constants.pi/2 then sin(time) elseif 
              noEvent(time<=Modelica.Constants.pi) then 1 else sin(time-Modelica.Constants.pi/2)) else noEvent(sin(3*x));
    der(x) = u;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="IfExpExample1",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    jmi_real_t v_0;
    jmi_real_t d_0;
    jmi_real_t v_1;
    jmi_real_t d_1;
    jmi_real_t v_2;
    jmi_real_t d_2;
    jmi_real_t v_3;
    jmi_real_t v_4;
    jmi_real_t d_4;
    jmi_real_t v_5;
    jmi_real_t d_5;
    jmi_real_t v_6;
    jmi_real_t d_6;
    jmi_real_t v_7;
    jmi_real_t d_7;
    jmi_real_t v_8;
    jmi_real_t v_9;
    jmi_real_t d_9;
    jmi_real_t v_10;
    jmi_real_t d_10;
    if (_sw(0)) {
        v_3 = 3.141592653589793 / 2.0;
        if (COND_EXP_LE(_time, v_3, JMI_TRUE, JMI_FALSE)) {
            v_4 = sin(_time);
            d_4 = (*dz)[jmi->offs_t] * cos(_time);
            v_2 = v_4;
            d_2 = d_4;
        } else {
            if ((COND_EXP_LE(_time, 3.141592653589793, JMI_TRUE, JMI_FALSE))) {
                v_5 = 1.0;
                d_5 = 0.0;
            } else {
                v_8 = 3.141592653589793 / 2.0;
                v_7 = _time - v_8;
                d_7 = (*dz)[jmi->offs_t] - 0.0;
                v_6 = sin(v_7);
                d_6 = d_7 * cos(v_7);
                v_5 = v_6;
                d_5 = d_6;
            }
            v_2 = v_5;
            d_2 = d_5;
        }
        v_1 = (v_2);
        d_1 = d_2;
        v_0 = v_1;
        d_0 = d_1;
    } else {
        v_10 = 3.0 * _x_0;
        d_10 = 0.0 * _x_0 + 3.0 * (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx];
        v_9 = (sin(v_10));
        d_9 = d_10 * cos(v_10);
        v_0 = v_9;
        d_0 = d_9;
    }
    (*res)[0] = v_0 - (_der_x_2);
    (*dF)[0] = d_0 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = _u_1 - (_der_x_2);
    (*dF)[1] = (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
")})));
end IfExpExample1;

model IfExpExample2
Real x,u;
equation
    u = if time<=Modelica.Constants.pi/2 then sin(time) elseif 
              time<=Modelica.Constants.pi then 1 else sin(time-Modelica.Constants.pi/2);
    der(x) = u;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="IfExpExample2",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    jmi_real_t v_0;
    jmi_real_t d_0;
    jmi_real_t v_1;
    jmi_real_t d_1;
    jmi_real_t v_2;
    jmi_real_t d_2;
    jmi_real_t v_3;
    jmi_real_t d_3;
    jmi_real_t v_4;
    jmi_real_t d_4;
    jmi_real_t v_5;
    if (_sw(0)) {
        v_1 = sin(_time);
        d_1 = (*dz)[jmi->offs_t] * cos(_time);
        v_0 = v_1;
        d_0 = d_1;
    } else {
        if (_sw(1)) {
            v_2 = 1.0;
            d_2 = 0.0;
        } else {
            v_5 = 3.141592653589793 / 2.0;
            v_4 = _time - v_5;
            d_4 = (*dz)[jmi->offs_t] - 0.0;
            v_3 = sin(v_4);
            d_3 = d_4 * cos(v_4);
            v_2 = v_3;
            d_2 = d_3;
        }
        v_0 = v_2;
        d_0 = d_2;
    }
    (*res)[0] = v_0 - (_der_x_2);
    (*dF)[0] = d_0 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = _u_1 - (_der_x_2);
    (*dF)[1] = (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
")})));
end IfExpExample2;

model IfExpExample3
	Real x,u;
	Boolean b = false;
equation
	u = if(x > 3 or b) then noEvent(if time<=Modelica.Constants.pi/2 then sin(time) elseif 
	    noEvent(time<=Modelica.Constants.pi) then 1 else sin(time-Modelica.Constants.pi/2)) else noEvent(sin(3*x));
	der(x) = u;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="IfExpExample3",
            description="",
            variability_propagation=false,
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    jmi_real_t v_0;
    jmi_real_t d_0;
    jmi_real_t v_1;
    jmi_real_t v_2;
    jmi_real_t d_2;
    jmi_real_t v_3;
    jmi_real_t d_3;
    jmi_real_t v_4;
    jmi_real_t v_5;
    jmi_real_t d_5;
    jmi_real_t v_6;
    jmi_real_t d_6;
    jmi_real_t v_7;
    jmi_real_t d_7;
    jmi_real_t v_8;
    jmi_real_t d_8;
    jmi_real_t v_9;
    jmi_real_t v_10;
    jmi_real_t d_10;
    jmi_real_t v_11;
    jmi_real_t d_11;
    v_1 = _sw(0);
    if (LOG_EXP_OR(v_1, _b_2)) {
        v_4 = 3.141592653589793 / 2.0;
        if (COND_EXP_LE(_time, v_4, JMI_TRUE, JMI_FALSE)) {
            v_5 = sin(_time);
            d_5 = (*dz)[jmi->offs_t] * cos(_time);
            v_3 = v_5;
            d_3 = d_5;
        } else {
            if ((COND_EXP_LE(_time, 3.141592653589793, JMI_TRUE, JMI_FALSE))) {
                v_6 = 1.0;
                d_6 = 0.0;
            } else {
                v_9 = 3.141592653589793 / 2.0;
                v_8 = _time - v_9;
                d_8 = (*dz)[jmi->offs_t] - 0.0;
                v_7 = sin(v_8);
                d_7 = d_8 * cos(v_8);
                v_6 = v_7;
                d_6 = d_7;
            }
            v_3 = v_6;
            d_3 = d_6;
        }
        v_2 = (v_3);
        d_2 = d_3;
        v_0 = v_2;
        d_0 = d_2;
    } else {
        v_11 = 3.0 * _x_0;
        d_11 = 0.0 * _x_0 + 3.0 * (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx];
        v_10 = (sin(v_11));
        d_10 = d_11 * cos(v_11);
        v_0 = v_10;
        d_0 = d_10;
    }
    (*res)[0] = v_0 - (_der_x_4);
    (*dF)[0] = d_0 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = _u_1 - (_der_x_4);
    (*dF)[1] = (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[2] = JMI_FALSE - (_b_2);
")})));
end IfExpExample3;

model CADFunction1

	function F
		input Real x;
		output Real y;
	algorithm
		y := x;
	end F;
	Real a(start=2);
	equation
		der(a) = F(a);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADFunction1",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            generate_ode_jacobian=true,
            template="
$CAD_functions$
$C_DAE_equation_directional_derivative$
",
            generatedCode="
void func_CADCodeGenTests_CADFunction1_F_der_AD0(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    y_var_v = x_var_v;
    y_der_v = x_der_v;
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}


    jmi_real_t v_0;
    jmi_real_t d_0;
    func_CADCodeGenTests_CADFunction1_F_der_AD0(_a_0, (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx], &v_0, &d_0);
    (*res)[0] = v_0 - (_der_a_1);
    (*dF)[0] = d_0 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
")})));
  end CADFunction1;

  model CADFunction2

	function F
		input Real x;
		output Real a;
		output Real b;
		output Real c;
	algorithm
		a := x*2;
		b := x*4;
		c := x*8;
	end F;
	Real x(start=5);
	equation
		der(x) = F(x);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADFunction2",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            generate_ode_jacobian=true,
            template="
$CAD_functions$
$C_DAE_equation_directional_derivative$
",
            generatedCode="
void func_CADCodeGenTests_CADFunction2_F_der_AD0(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* a_var_o, jmi_real_t* b_var_o, jmi_real_t* c_var_o, jmi_real_t* a_der_o, jmi_real_t* b_der_o, jmi_real_t* c_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, a_var_v)
    JMI_DEF(REA, a_der_v)
    JMI_DEF(REA, b_var_v)
    JMI_DEF(REA, b_der_v)
    JMI_DEF(REA, c_var_v)
    JMI_DEF(REA, c_der_v)
    a_var_v = x_var_v * 2.0;
    a_der_v = x_der_v * 2.0 + x_var_v * 0.0;
    b_var_v = x_var_v * 4.0;
    b_der_v = x_der_v * 4.0 + x_var_v * 0.0;
    c_var_v = x_var_v * 8.0;
    c_der_v = x_der_v * 8.0 + x_var_v * 0.0;
    if (a_var_o != NULL) *a_var_o = a_var_v;
    if (a_der_o != NULL) *a_der_o = a_der_v;
    if (b_var_o != NULL) *b_var_o = b_var_v;
    if (b_der_o != NULL) *b_der_o = b_der_v;
    if (c_var_o != NULL) *c_var_o = c_var_v;
    if (c_der_o != NULL) *c_der_o = c_der_v;
    JMI_DYNAMIC_FREE()
    return;
}


    jmi_real_t v_0;
    jmi_real_t d_0;
    func_CADCodeGenTests_CADFunction2_F_der_AD0(_x_0, (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx], &v_0, NULL, NULL, &d_0, NULL, NULL);
    (*res)[0] = v_0 - (_der_x_1);
    (*dF)[0] = d_0 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
")})));
  end CADFunction2;
  

  model CADFunction3

	function F
		input Real x;
		output Real y;
	algorithm
		y := F2(x)^2;
	end F;
	function F2
		input Real x;
		output Real y;
	algorithm
		y := F3(x)^2;
	end F2;
	function F3
		input Real x;
		output Real y;
	algorithm
		y := x^2;
	end F3;
	Real a(start=5);
	equation
		der(a) = F(a)+F2(a);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADFunction3",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            generate_ode_jacobian=true,
            template="
$CAD_functions$
$C_DAE_equation_directional_derivative$
",
            generatedCode="
void func_CADCodeGenTests_CADFunction3_F_der_AD0(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    jmi_real_t v_0;
    jmi_real_t v_1;
    jmi_real_t d_1;
    func_CADCodeGenTests_CADFunction3_F2_der_AD1(x_var_v, x_der_v, &v_1, &d_1);
    v_0 = (1.0 * (v_1) * (v_1));
    y_var_v = v_0;
    y_der_v = v_1 == 0 ? 0 : (v_0 * (0.0 * log(jmi_abs(v_1)) + 2.0 * d_1 / v_1));
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}

void func_CADCodeGenTests_CADFunction3_F2_der_AD1(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    jmi_real_t v_2;
    jmi_real_t v_3;
    jmi_real_t d_3;
    func_CADCodeGenTests_CADFunction3_F3_der_AD2(x_var_v, x_der_v, &v_3, &d_3);
    v_2 = (1.0 * (v_3) * (v_3));
    y_var_v = v_2;
    y_der_v = v_3 == 0 ? 0 : (v_2 * (0.0 * log(jmi_abs(v_3)) + 2.0 * d_3 / v_3));
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}

void func_CADCodeGenTests_CADFunction3_F3_der_AD2(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    jmi_real_t v_4;
    v_4 = (1.0 * (x_var_v) * (x_var_v));
    y_var_v = v_4;
    y_der_v = x_var_v == 0 ? 0 : (v_4 * (0.0 * log(jmi_abs(x_var_v)) + 2.0 * x_der_v / x_var_v));
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}


    jmi_real_t v_5;
    jmi_real_t d_5;
    jmi_real_t v_6;
    jmi_real_t d_6;
    func_CADCodeGenTests_CADFunction3_F_der_AD0(_a_0, (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx], &v_5, &d_5);
    func_CADCodeGenTests_CADFunction3_F2_der_AD1(_a_0, (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx], &v_6, &d_6);
    (*res)[0] = v_5 + v_6 - (_der_a_1);
    (*dF)[0] = d_5 + d_6 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
")})));
  end CADFunction3; 
  
  
    model CADFunction4	

	function F
		input Real x; 
		output Real a;
		output Real b;
		output Real c;
	algorithm
		a := x*2;
		b := x*4;
		c := x*8;
	end F;
	function F2
		input Real x;
		output Real a;
	algorithm
		a := F(x)*x;
	end F2;
	Real x(start=5);
	equation
		der(x) = F2(x);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADFunction4",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            generate_ode_jacobian=true,
            template="
$CAD_functions$
$C_DAE_equation_directional_derivative$
",
            generatedCode="
void func_CADCodeGenTests_CADFunction4_F2_der_AD0(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* a_var_o, jmi_real_t* a_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, a_var_v)
    JMI_DEF(REA, a_der_v)
    jmi_real_t v_0;
    jmi_real_t d_0;
    func_CADCodeGenTests_CADFunction4_F_der_AD1(x_var_v, x_der_v, &v_0, NULL, NULL, &d_0, NULL, NULL);
    a_var_v = v_0 * x_var_v;
    a_der_v = d_0 * x_var_v + v_0 * x_der_v;
    if (a_var_o != NULL) *a_var_o = a_var_v;
    if (a_der_o != NULL) *a_der_o = a_der_v;
    JMI_DYNAMIC_FREE()
    return;
}

void func_CADCodeGenTests_CADFunction4_F_der_AD1(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* a_var_o, jmi_real_t* b_var_o, jmi_real_t* c_var_o, jmi_real_t* a_der_o, jmi_real_t* b_der_o, jmi_real_t* c_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, a_var_v)
    JMI_DEF(REA, a_der_v)
    JMI_DEF(REA, b_var_v)
    JMI_DEF(REA, b_der_v)
    JMI_DEF(REA, c_var_v)
    JMI_DEF(REA, c_der_v)
    a_var_v = x_var_v * 2.0;
    a_der_v = x_der_v * 2.0 + x_var_v * 0.0;
    b_var_v = x_var_v * 4.0;
    b_der_v = x_der_v * 4.0 + x_var_v * 0.0;
    c_var_v = x_var_v * 8.0;
    c_der_v = x_der_v * 8.0 + x_var_v * 0.0;
    if (a_var_o != NULL) *a_var_o = a_var_v;
    if (a_der_o != NULL) *a_der_o = a_der_v;
    if (b_var_o != NULL) *b_var_o = b_var_v;
    if (b_der_o != NULL) *b_der_o = b_der_v;
    if (c_var_o != NULL) *c_var_o = c_var_v;
    if (c_der_o != NULL) *c_der_o = c_der_v;
    JMI_DYNAMIC_FREE()
    return;
}


    jmi_real_t v_1;
    jmi_real_t d_1;
    func_CADCodeGenTests_CADFunction4_F2_der_AD0(_x_0, (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx], &v_1, &d_1);
    (*res)[0] = v_1 - (_der_x_1);
    (*dF)[0] = d_1 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
")})));
  end CADFunction4; 

model CADFunction5

			function F
			input Real x;
			input Real x1;
			input Real x2;
			input Real x3;
			input Real x4;
			output Real a;
			output Real b;
			output Real c;
			output Real d;
			output Real e;
			output Real f;
			output Real g;
		algorithm
			a := x*2;
			b := x1*4;
			c := x2*8;
			d := x3*8;
			e := x4*8;
			f := x*x1*x2;
			g := x3*x4+x1;
		end F;
		Real x(start=5);
		Real x1(start=10);
		Real x2(start=15);
		Real x3(start=20);
		Real x4(start=25);
		 Real a;
		 Real b;
		 Real c;
		 Real d;
		 Real e;
		 Real f;
		 Real g;
		 input Real U(start=10);
		 output Real Y;
		equation
			der(x)   = x1*U;
			(a,b,c,d,e,f,g) = F(x,x1,x2,x3,x4);
			der(x1)  = b;
			der(x2)  = c;
			der(x3)  = d+a;
			der(x4)  = e*f+g;
			Y = x+x1+x2+x3+x4;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADFunction5",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            generate_ode_jacobian=true,
            template="
$CAD_functions$
$C_DAE_equation_directional_derivative$
",
            generatedCode="
void func_CADCodeGenTests_CADFunction5_F_der_AD0(jmi_real_t x_var_v, jmi_real_t x1_var_v, jmi_real_t x2_var_v, jmi_real_t x3_var_v, jmi_real_t x4_var_v, jmi_real_t x_der_v, jmi_real_t x1_der_v, jmi_real_t x2_der_v, jmi_real_t x3_der_v, jmi_real_t x4_der_v, jmi_real_t* a_var_o, jmi_real_t* b_var_o, jmi_real_t* c_var_o, jmi_real_t* d_var_o, jmi_real_t* e_var_o, jmi_real_t* f_var_o, jmi_real_t* g_var_o, jmi_real_t* a_der_o, jmi_real_t* b_der_o, jmi_real_t* c_der_o, jmi_real_t* d_der_o, jmi_real_t* e_der_o, jmi_real_t* f_der_o, jmi_real_t* g_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, a_var_v)
    JMI_DEF(REA, a_der_v)
    JMI_DEF(REA, b_var_v)
    JMI_DEF(REA, b_der_v)
    JMI_DEF(REA, c_var_v)
    JMI_DEF(REA, c_der_v)
    JMI_DEF(REA, d_var_v)
    JMI_DEF(REA, d_der_v)
    JMI_DEF(REA, e_var_v)
    JMI_DEF(REA, e_der_v)
    JMI_DEF(REA, f_var_v)
    JMI_DEF(REA, f_der_v)
    JMI_DEF(REA, g_var_v)
    JMI_DEF(REA, g_der_v)
    jmi_real_t v_0;
    jmi_real_t d_0;
    jmi_real_t v_1;
    jmi_real_t d_1;
    a_var_v = x_var_v * 2.0;
    a_der_v = x_der_v * 2.0 + x_var_v * 0.0;
    b_var_v = x1_var_v * 4.0;
    b_der_v = x1_der_v * 4.0 + x1_var_v * 0.0;
    c_var_v = x2_var_v * 8.0;
    c_der_v = x2_der_v * 8.0 + x2_var_v * 0.0;
    d_var_v = x3_var_v * 8.0;
    d_der_v = x3_der_v * 8.0 + x3_var_v * 0.0;
    e_var_v = x4_var_v * 8.0;
    e_der_v = x4_der_v * 8.0 + x4_var_v * 0.0;
    v_0 = x_var_v * x1_var_v;
    d_0 = x_der_v * x1_var_v + x_var_v * x1_der_v;
    f_var_v = v_0 * x2_var_v;
    f_der_v = d_0 * x2_var_v + v_0 * x2_der_v;
    v_1 = x3_var_v * x4_var_v;
    d_1 = x3_der_v * x4_var_v + x3_var_v * x4_der_v;
    g_var_v = v_1 + x1_var_v;
    g_der_v = d_1 + x1_der_v;
    if (a_var_o != NULL) *a_var_o = a_var_v;
    if (a_der_o != NULL) *a_der_o = a_der_v;
    if (b_var_o != NULL) *b_var_o = b_var_v;
    if (b_der_o != NULL) *b_der_o = b_der_v;
    if (c_var_o != NULL) *c_var_o = c_var_v;
    if (c_der_o != NULL) *c_der_o = c_der_v;
    if (d_var_o != NULL) *d_var_o = d_var_v;
    if (d_der_o != NULL) *d_der_o = d_der_v;
    if (e_var_o != NULL) *e_var_o = e_var_v;
    if (e_der_o != NULL) *e_der_o = e_der_v;
    if (f_var_o != NULL) *f_var_o = f_var_v;
    if (f_der_o != NULL) *f_der_o = f_der_v;
    if (g_var_o != NULL) *g_var_o = g_var_v;
    if (g_der_o != NULL) *g_der_o = g_der_v;
    JMI_DYNAMIC_FREE()
    return;
}


    JMI_DEF(REA, tmp_var_0)
    JMI_DEF(REA, tmp_der_0)
    JMI_DEF(REA, tmp_var_1)
    JMI_DEF(REA, tmp_der_1)
    JMI_DEF(REA, tmp_var_2)
    JMI_DEF(REA, tmp_der_2)
    JMI_DEF(REA, tmp_var_3)
    JMI_DEF(REA, tmp_der_3)
    JMI_DEF(REA, tmp_var_4)
    JMI_DEF(REA, tmp_der_4)
    JMI_DEF(REA, tmp_var_5)
    JMI_DEF(REA, tmp_der_5)
    JMI_DEF(REA, tmp_var_6)
    JMI_DEF(REA, tmp_der_6)
    jmi_real_t v_2;
    jmi_real_t d_2;
    jmi_real_t v_3;
    jmi_real_t d_3;
    jmi_real_t v_4;
    jmi_real_t d_4;
    jmi_real_t v_5;
    jmi_real_t d_5;
    (*res)[0] = _x1_1 * _U_12 - (_der_x_14);
    (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx] * _U_12 + _x1_1 * (*dz)[jmi_get_index_from_value_ref(10)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    func_CADCodeGenTests_CADFunction5_F_der_AD0(_x_0, _x1_1, _x2_2, _x3_3, _x4_4, (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx], (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx], (*dz)[jmi_get_index_from_value_ref(7)-jmi->offs_real_dx], (*dz)[jmi_get_index_from_value_ref(8)-jmi->offs_real_dx], (*dz)[jmi_get_index_from_value_ref(9)-jmi->offs_real_dx], &tmp_var_0, &tmp_var_1, &tmp_var_2, &tmp_var_3, &tmp_var_4, &tmp_var_5, &tmp_var_6, &tmp_der_0, &tmp_der_1, &tmp_der_2, &tmp_der_3, &tmp_der_4, &tmp_der_5, &tmp_der_6);
    (*res)[1] = tmp_var_0 - (_a_5);
    (*dF)[1] = tmp_der_0 - ((*dz)[jmi_get_index_from_value_ref(11)-jmi->offs_real_dx]);
    (*res)[2] = tmp_var_1 - (_b_6);
    (*dF)[2] = tmp_der_1 - ((*dz)[jmi_get_index_from_value_ref(12)-jmi->offs_real_dx]);
    (*res)[3] = tmp_var_2 - (_c_7);
    (*dF)[3] = tmp_der_2 - ((*dz)[jmi_get_index_from_value_ref(13)-jmi->offs_real_dx]);
    (*res)[4] = tmp_var_3 - (_d_8);
    (*dF)[4] = tmp_der_3 - ((*dz)[jmi_get_index_from_value_ref(14)-jmi->offs_real_dx]);
    (*res)[5] = tmp_var_4 - (_e_9);
    (*dF)[5] = tmp_der_4 - ((*dz)[jmi_get_index_from_value_ref(15)-jmi->offs_real_dx]);
    (*res)[6] = tmp_var_5 - (_f_10);
    (*dF)[6] = tmp_der_5 - ((*dz)[jmi_get_index_from_value_ref(16)-jmi->offs_real_dx]);
    (*res)[7] = tmp_var_6 - (_g_11);
    (*dF)[7] = tmp_der_6 - ((*dz)[jmi_get_index_from_value_ref(17)-jmi->offs_real_dx]);
    (*res)[8] = _b_6 - (_der_x1_15);
    (*dF)[8] = (*dz)[jmi_get_index_from_value_ref(12)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
    (*res)[9] = _c_7 - (_der_x2_16);
    (*dF)[9] = (*dz)[jmi_get_index_from_value_ref(13)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]);
    (*res)[10] = _d_8 + _a_5 - (_der_x3_17);
    (*dF)[10] = (*dz)[jmi_get_index_from_value_ref(14)-jmi->offs_real_dx] + (*dz)[jmi_get_index_from_value_ref(11)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx]);
    v_2 = _e_9 * _f_10;
    d_2 = (*dz)[jmi_get_index_from_value_ref(15)-jmi->offs_real_dx] * _f_10 + _e_9 * (*dz)[jmi_get_index_from_value_ref(16)-jmi->offs_real_dx];
    (*res)[11] = v_2 + _g_11 - (_der_x4_18);
    (*dF)[11] = d_2 + (*dz)[jmi_get_index_from_value_ref(17)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx]);
    v_5 = _x_0 + _x1_1;
    d_5 = (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx] + (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx];
    v_4 = v_5 + _x2_2;
    d_4 = d_5 + (*dz)[jmi_get_index_from_value_ref(7)-jmi->offs_real_dx];
    v_3 = v_4 + _x3_3;
    d_3 = d_4 + (*dz)[jmi_get_index_from_value_ref(8)-jmi->offs_real_dx];
    (*res)[12] = v_3 + _x4_4 - (_Y_13);
    (*dF)[12] = d_3 + (*dz)[jmi_get_index_from_value_ref(9)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(18)-jmi->offs_real_dx]);
")})));
end CADFunction5;


model CADFunction6

      function F
      input Real x;
      input Real x1;
      input Real x2;
      input Real x3;
      input Real x4;
      output Real a;
      output Real b;
      output Real c;
      output Real d;
      output Real e;
      output Real f;
      output Real g;
    algorithm
      a := x * 2;
      b := x1 * 4;
      c := x2 * 8;
      d := x3 * 8;
      (e, f, g) := F2(x4, x3, x2);
    end F;
    
    function F2
      input Real x1;
      input Real x2;
      input Real x3;
      output Real a;
      output Real b;
      output Real c;
    algorithm
      a := x1 * 2;
      b := x2 * 4;
      c := x3 * 8;
    end F2;
    
    Real x(start=5);
    Real x1(start=10);
    Real x2(start=15);
    Real x3(start=20);
    Real x4(start=25);
    Real a;
    Real b;
    Real c;
    Real d;
    Real e;
    Real f;
    Real g;
    input Real U(start=10);
    output Real Y;
  equation
    der(x)   = x1 * U;
    (a, b, c, d) = F(x, x1, x2, x3, x4);
    der(x1)  = b;
    der(x2)  = c;
    der(x3)  = d + a;
    der(x4)  = e * f + g + x1;
    (e,f,g) = F(x, x1, x2, x3, x4);
    Y = x + x1 + x2 + x3 + x4;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADFunction6",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            generate_ode_jacobian=true,
            template="
$CAD_functions$
$C_DAE_equation_directional_derivative$
",
            generatedCode="
void func_CADCodeGenTests_CADFunction6_F_der_AD0(jmi_real_t x_var_v, jmi_real_t x1_var_v, jmi_real_t x2_var_v, jmi_real_t x3_var_v, jmi_real_t x4_var_v, jmi_real_t x_der_v, jmi_real_t x1_der_v, jmi_real_t x2_der_v, jmi_real_t x3_der_v, jmi_real_t x4_der_v, jmi_real_t* a_var_o, jmi_real_t* b_var_o, jmi_real_t* c_var_o, jmi_real_t* d_var_o, jmi_real_t* e_var_o, jmi_real_t* f_var_o, jmi_real_t* g_var_o, jmi_real_t* a_der_o, jmi_real_t* b_der_o, jmi_real_t* c_der_o, jmi_real_t* d_der_o, jmi_real_t* e_der_o, jmi_real_t* f_der_o, jmi_real_t* g_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, a_var_v)
    JMI_DEF(REA, a_der_v)
    JMI_DEF(REA, b_var_v)
    JMI_DEF(REA, b_der_v)
    JMI_DEF(REA, c_var_v)
    JMI_DEF(REA, c_der_v)
    JMI_DEF(REA, d_var_v)
    JMI_DEF(REA, d_der_v)
    JMI_DEF(REA, e_var_v)
    JMI_DEF(REA, e_der_v)
    JMI_DEF(REA, f_var_v)
    JMI_DEF(REA, f_der_v)
    JMI_DEF(REA, g_var_v)
    JMI_DEF(REA, g_der_v)
    a_var_v = x_var_v * 2.0;
    a_der_v = x_der_v * 2.0 + x_var_v * 0.0;
    b_var_v = x1_var_v * 4.0;
    b_der_v = x1_der_v * 4.0 + x1_var_v * 0.0;
    c_var_v = x2_var_v * 8.0;
    c_der_v = x2_der_v * 8.0 + x2_var_v * 0.0;
    d_var_v = x3_var_v * 8.0;
    d_der_v = x3_der_v * 8.0 + x3_var_v * 0.0;
    func_CADCodeGenTests_CADFunction6_F2_der_AD1(x4_var_v, x3_var_v, x2_var_v, x4_der_v, x3_der_v, x2_der_v, &e_var_v, &f_var_v, &g_var_v, &e_der_v, &f_der_v, &g_der_v);
    if (a_var_o != NULL) *a_var_o = a_var_v;
    if (a_der_o != NULL) *a_der_o = a_der_v;
    if (b_var_o != NULL) *b_var_o = b_var_v;
    if (b_der_o != NULL) *b_der_o = b_der_v;
    if (c_var_o != NULL) *c_var_o = c_var_v;
    if (c_der_o != NULL) *c_der_o = c_der_v;
    if (d_var_o != NULL) *d_var_o = d_var_v;
    if (d_der_o != NULL) *d_der_o = d_der_v;
    if (e_var_o != NULL) *e_var_o = e_var_v;
    if (e_der_o != NULL) *e_der_o = e_der_v;
    if (f_var_o != NULL) *f_var_o = f_var_v;
    if (f_der_o != NULL) *f_der_o = f_der_v;
    if (g_var_o != NULL) *g_var_o = g_var_v;
    if (g_der_o != NULL) *g_der_o = g_der_v;
    JMI_DYNAMIC_FREE()
    return;
}

void func_CADCodeGenTests_CADFunction6_F2_der_AD1(jmi_real_t x1_var_v, jmi_real_t x2_var_v, jmi_real_t x3_var_v, jmi_real_t x1_der_v, jmi_real_t x2_der_v, jmi_real_t x3_der_v, jmi_real_t* a_var_o, jmi_real_t* b_var_o, jmi_real_t* c_var_o, jmi_real_t* a_der_o, jmi_real_t* b_der_o, jmi_real_t* c_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, a_var_v)
    JMI_DEF(REA, a_der_v)
    JMI_DEF(REA, b_var_v)
    JMI_DEF(REA, b_der_v)
    JMI_DEF(REA, c_var_v)
    JMI_DEF(REA, c_der_v)
    a_var_v = x1_var_v * 2.0;
    a_der_v = x1_der_v * 2.0 + x1_var_v * 0.0;
    b_var_v = x2_var_v * 4.0;
    b_der_v = x2_der_v * 4.0 + x2_var_v * 0.0;
    c_var_v = x3_var_v * 8.0;
    c_der_v = x3_der_v * 8.0 + x3_var_v * 0.0;
    if (a_var_o != NULL) *a_var_o = a_var_v;
    if (a_der_o != NULL) *a_der_o = a_der_v;
    if (b_var_o != NULL) *b_var_o = b_var_v;
    if (b_der_o != NULL) *b_der_o = b_der_v;
    if (c_var_o != NULL) *c_var_o = c_var_v;
    if (c_der_o != NULL) *c_der_o = c_der_v;
    JMI_DYNAMIC_FREE()
    return;
}


    jmi_real_t v_0;
    jmi_real_t d_0;
    jmi_real_t v_1;
    jmi_real_t d_1;
    jmi_real_t v_2;
    jmi_real_t d_2;
    jmi_real_t v_3;
    jmi_real_t d_3;
    jmi_real_t v_4;
    jmi_real_t d_4;
    JMI_DEF(REA, tmp_var_0)
    JMI_DEF(REA, tmp_der_0)
    JMI_DEF(REA, tmp_var_1)
    JMI_DEF(REA, tmp_der_1)
    JMI_DEF(REA, tmp_var_2)
    JMI_DEF(REA, tmp_der_2)
    JMI_DEF(REA, tmp_var_3)
    JMI_DEF(REA, tmp_der_3)
    (*res)[0] = _x1_1 * _U_9 - (_der_x_11);
    (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx] * _U_9 + _x1_1 * (*dz)[jmi_get_index_from_value_ref(10)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = _b_6 - (_der_x1_12);
    (*dF)[1] = (*dz)[jmi_get_index_from_value_ref(12)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
    (*res)[2] = _c_7 - (_der_x2_13);
    (*dF)[2] = (*dz)[jmi_get_index_from_value_ref(13)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]);
    (*res)[3] = _d_8 + _a_5 - (_der_x3_14);
    (*dF)[3] = (*dz)[jmi_get_index_from_value_ref(14)-jmi->offs_real_dx] + (*dz)[jmi_get_index_from_value_ref(11)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx]);
    v_1 = _a_5 * _der_x1_12;
    d_1 = (*dz)[jmi_get_index_from_value_ref(11)-jmi->offs_real_dx] * _der_x1_12 + _a_5 * (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx];
    v_0 = v_1 + _der_x2_13;
    d_0 = d_1 + (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx];
    (*res)[4] = v_0 + _x1_1 - (_der_x4_15);
    (*dF)[4] = d_0 + (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx]);
    v_4 = _x_0 + _x1_1;
    d_4 = (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx] + (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx];
    v_3 = v_4 + _x2_2;
    d_3 = d_4 + (*dz)[jmi_get_index_from_value_ref(7)-jmi->offs_real_dx];
    v_2 = v_3 + _x3_3;
    d_2 = d_3 + (*dz)[jmi_get_index_from_value_ref(8)-jmi->offs_real_dx];
    (*res)[5] = v_2 + _x4_4 - (_Y_10);
    (*dF)[5] = d_2 + (*dz)[jmi_get_index_from_value_ref(9)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(15)-jmi->offs_real_dx]);
    func_CADCodeGenTests_CADFunction6_F_der_AD0(_x_0, _x1_1, _x2_2, _x3_3, _x4_4, (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx], (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx], (*dz)[jmi_get_index_from_value_ref(7)-jmi->offs_real_dx], (*dz)[jmi_get_index_from_value_ref(8)-jmi->offs_real_dx], (*dz)[jmi_get_index_from_value_ref(9)-jmi->offs_real_dx], &tmp_var_0, &tmp_var_1, &tmp_var_2, &tmp_var_3, NULL, NULL, NULL, &tmp_der_0, &tmp_der_1, &tmp_der_2, &tmp_der_3, NULL, NULL, NULL);
    (*res)[6] = tmp_var_0 - (_a_5);
    (*dF)[6] = tmp_der_0 - ((*dz)[jmi_get_index_from_value_ref(11)-jmi->offs_real_dx]);
    (*res)[7] = tmp_var_1 - (_b_6);
    (*dF)[7] = tmp_der_1 - ((*dz)[jmi_get_index_from_value_ref(12)-jmi->offs_real_dx]);
    (*res)[8] = tmp_var_2 - (_c_7);
    (*dF)[8] = tmp_der_2 - ((*dz)[jmi_get_index_from_value_ref(13)-jmi->offs_real_dx]);
    (*res)[9] = tmp_var_3 - (_d_8);
    (*dF)[9] = tmp_der_3 - ((*dz)[jmi_get_index_from_value_ref(14)-jmi->offs_real_dx]);
")})));
end CADFunction6;

model CADFunction7
	function F
		input Real x;
		output Real y;
		output Real z;
	algorithm
		y := x*x;
		z := x*y;
	end F;
	Real x(start=5);
	Real y(start=7);
	Real a(start=2);
	equation
		(x,y) = F(a);
		der(a) = log(x*y);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADFunction7",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            generate_ode_jacobian=true,
            template="
$CAD_functions$
$C_DAE_equation_directional_derivative$
",
            generatedCode="
void func_CADCodeGenTests_CADFunction7_F_der_AD0(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* z_var_o, jmi_real_t* y_der_o, jmi_real_t* z_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    JMI_DEF(REA, z_var_v)
    JMI_DEF(REA, z_der_v)
    y_var_v = x_var_v * x_var_v;
    y_der_v = x_der_v * x_var_v + x_var_v * x_der_v;
    z_var_v = x_var_v * y_var_v;
    z_der_v = x_der_v * y_var_v + x_var_v * y_der_v;
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    if (z_var_o != NULL) *z_var_o = z_var_v;
    if (z_der_o != NULL) *z_der_o = z_der_v;
    JMI_DYNAMIC_FREE()
    return;
}


    JMI_DEF(REA, tmp_var_0)
    JMI_DEF(REA, tmp_der_0)
    JMI_DEF(REA, tmp_var_1)
    JMI_DEF(REA, tmp_der_1)
    jmi_real_t v_0;
    jmi_real_t d_0;
    func_CADCodeGenTests_CADFunction7_F_der_AD0(_a_2, (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx], &tmp_var_0, &tmp_var_1, &tmp_der_0, &tmp_der_1);
    (*res)[0] = tmp_var_0 - (_x_0);
    (*dF)[0] = tmp_der_0 - ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]);
    (*res)[1] = tmp_var_1 - (_y_1);
    (*dF)[1] = tmp_der_1 - ((*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx]);
    v_0 = _x_0 * _y_1;
    d_0 = (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] * _y_1 + _x_0 * (*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx];
    (*res)[2] = jmi_log_equation(jmi, v_0,\"log(x * y)\") - (_der_a_3);
    (*dF)[2] = d_0 / v_0 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
")})));
  end CADFunction7;

model CADFunction8
	function f1
		input Real x[2];
		output Real y[2];
	algorithm
		y := x + {1,1};
		y := y + x;
	end f1;

	function f2
		input Real x[2];
		output Real y[2];
	algorithm
		y := f1(x) + f1(x+{1,1});
		y := y + f1(y);
	end f2;

	Real x[2] = {time, time*2};
	Real y1,y2;
equation
	{y1,y2} = f2(x);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADFunction8",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            generate_ode_jacobian=true,
            template="
$CAD_functions$
$C_DAE_equation_directional_derivative$
",
            generatedCode="
void func_CADCodeGenTests_CADFunction8_f2_der_AD0(jmi_array_t* x_var_a, jmi_array_t* x_der_a, jmi_array_t* y_var_a, jmi_array_t* y_der_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, y_var_an, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, y_der_an, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, temp_1_var_a, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, temp_1_der_a, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, temp_2_var_a, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, temp_2_der_a, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, temp_3_var_a, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, temp_3_der_a, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, temp_4_var_a, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, temp_4_der_a, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_0, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_0, 2, 1)
    if (y_var_a == NULL) {
        JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, y_var_an, 2, 1, 2)
        y_var_a = y_var_an;
    }
    if (y_der_a == NULL) {
        JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, y_der_an, 2, 1, 2)
        y_der_a = y_der_an;
    }
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, temp_1_var_a, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, temp_1_der_a, 2, 1, 2)
    func_CADCodeGenTests_CADFunction8_f1_der_AD1(x_var_a, x_der_a, temp_1_var_a, temp_1_der_a);
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, temp_2_var_a, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, temp_2_der_a, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_var_0, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_der_0, 2, 1, 2)
    jmi_array_ref_1(tmp_var_0, 1) = jmi_array_val_1(x_var_a, 1.0) + 1.0;
    jmi_array_ref_1(tmp_var_0, 2) = jmi_array_val_1(x_var_a, 2.0) + 1.0;
    jmi_array_ref_1(tmp_der_0, 1) = jmi_array_val_1(x_der_a, 1.0) + 0.0;
    jmi_array_ref_1(tmp_der_0, 2) = jmi_array_val_1(x_der_a, 2.0) + 0.0;
    func_CADCodeGenTests_CADFunction8_f1_der_AD1(tmp_var_0, tmp_der_0, temp_2_var_a, temp_2_der_a);
    jmi_array_ref_1(y_var_a, 1.0) = jmi_array_val_1(temp_1_var_a, 1) + jmi_array_val_1(temp_2_var_a, 1);
    jmi_array_ref_1(y_der_a, 1.0) = jmi_array_val_1(temp_1_der_a, 1) + jmi_array_val_1(temp_2_der_a, 1);
    jmi_array_ref_1(y_var_a, 2.0) = jmi_array_val_1(temp_1_var_a, 2) + jmi_array_val_1(temp_2_var_a, 2);
    jmi_array_ref_1(y_der_a, 2.0) = jmi_array_val_1(temp_1_der_a, 2) + jmi_array_val_1(temp_2_der_a, 2);
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, temp_3_var_a, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, temp_3_der_a, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, temp_4_var_a, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, temp_4_der_a, 2, 1, 2)
    func_CADCodeGenTests_CADFunction8_f1_der_AD1(y_var_a, y_der_a, temp_4_var_a, temp_4_der_a);
    jmi_array_ref_1(temp_3_var_a, 1) = jmi_array_val_1(y_var_a, 1.0) + jmi_array_val_1(temp_4_var_a, 1);
    jmi_array_ref_1(temp_3_der_a, 1) = jmi_array_val_1(y_der_a, 1.0) + jmi_array_val_1(temp_4_der_a, 1);
    jmi_array_ref_1(temp_3_var_a, 2) = jmi_array_val_1(y_var_a, 2.0) + jmi_array_val_1(temp_4_var_a, 2);
    jmi_array_ref_1(temp_3_der_a, 2) = jmi_array_val_1(y_der_a, 2.0) + jmi_array_val_1(temp_4_der_a, 2);
    jmi_array_ref_1(y_var_a, 1.0) = jmi_array_val_1(temp_3_var_a, 1);
    jmi_array_ref_1(y_der_a, 1.0) = jmi_array_val_1(temp_3_der_a, 1);
    jmi_array_ref_1(y_var_a, 2.0) = jmi_array_val_1(temp_3_var_a, 2);
    jmi_array_ref_1(y_der_a, 2.0) = jmi_array_val_1(temp_3_der_a, 2);
    JMI_DYNAMIC_FREE()
    return;
}

void func_CADCodeGenTests_CADFunction8_f1_der_AD1(jmi_array_t* x_var_a, jmi_array_t* x_der_a, jmi_array_t* y_var_a, jmi_array_t* y_der_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, y_var_an, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, y_der_an, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, temp_1_var_a, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, temp_1_der_a, 2, 1)
    if (y_var_a == NULL) {
        JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, y_var_an, 2, 1, 2)
        y_var_a = y_var_an;
    }
    if (y_der_a == NULL) {
        JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, y_der_an, 2, 1, 2)
        y_der_a = y_der_an;
    }
    jmi_array_ref_1(y_var_a, 1.0) = jmi_array_val_1(x_var_a, 1.0) + 1.0;
    jmi_array_ref_1(y_der_a, 1.0) = jmi_array_val_1(x_der_a, 1.0) + 0.0;
    jmi_array_ref_1(y_var_a, 2.0) = jmi_array_val_1(x_var_a, 2.0) + 1.0;
    jmi_array_ref_1(y_der_a, 2.0) = jmi_array_val_1(x_der_a, 2.0) + 0.0;
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, temp_1_var_a, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, temp_1_der_a, 2, 1, 2)
    jmi_array_ref_1(temp_1_var_a, 1) = jmi_array_val_1(y_var_a, 1.0) + jmi_array_val_1(x_var_a, 1.0);
    jmi_array_ref_1(temp_1_der_a, 1) = jmi_array_val_1(y_der_a, 1.0) + jmi_array_val_1(x_der_a, 1.0);
    jmi_array_ref_1(temp_1_var_a, 2) = jmi_array_val_1(y_var_a, 2.0) + jmi_array_val_1(x_var_a, 2.0);
    jmi_array_ref_1(temp_1_der_a, 2) = jmi_array_val_1(y_der_a, 2.0) + jmi_array_val_1(x_der_a, 2.0);
    jmi_array_ref_1(y_var_a, 1.0) = jmi_array_val_1(temp_1_var_a, 1);
    jmi_array_ref_1(y_der_a, 1.0) = jmi_array_val_1(temp_1_der_a, 1);
    jmi_array_ref_1(y_var_a, 2.0) = jmi_array_val_1(temp_1_var_a, 2);
    jmi_array_ref_1(y_der_a, 2.0) = jmi_array_val_1(temp_1_der_a, 2);
    JMI_DYNAMIC_FREE()
    return;
}


    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_1, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_1, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_2, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_2, 2, 1)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_var_1, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_der_1, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_var_2, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_der_2, 2, 1, 2)
    jmi_array_ref_1(tmp_var_2, 1) = _x_1_0;
    jmi_array_ref_1(tmp_var_2, 2) = _x_2_1;
    jmi_array_ref_1(tmp_der_2, 1) = (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx];
    jmi_array_ref_1(tmp_der_2, 2) = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx];
    func_CADCodeGenTests_CADFunction8_f2_der_AD0(tmp_var_2, tmp_der_2, tmp_var_1, tmp_der_1);
    (*res)[0] = jmi_array_val_1(tmp_var_1, 1) - (_y1_2);
    (*res)[1] = jmi_array_val_1(tmp_var_1, 2) - (_y2_3);
    (*dF)[0] = jmi_array_val_1(tmp_der_1, 1) - ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]);
    (*dF)[1] = jmi_array_val_1(tmp_der_1, 2) - ((*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx]);
    (*res)[2] = _time - (_x_1_0);
    (*dF)[2] = (*dz)[jmi->offs_t] - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[3] = 2.0 * _x_1_0 - (_x_2_1);
    (*dF)[3] = 0.0 * _x_1_0 + 2.0 * (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
")})));
end CADFunction8;

model CADFunction9
	function f1
		input Real x[2];
		output Real y1;
		output Real y2;
		Real[2] tmp;
	algorithm
		tmp := x + {1,1};
		tmp := tmp + x;
		y1 := tmp[1];
		y2 := tmp[1] + y1;
	end f1;

	function f2
		input Real x[2];
		output Real y1;
		output Real y2;
	algorithm
		y1 := f1(x+{1,1});
		y2 := y1 + x[2];
	end f2;

	Real x[2] = {time, time*2};
	Real y1;
equation
	y1 = f2(x);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADFunction9",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            template="
$CAD_function_headers$
$CAD_functions$
$C_DAE_equation_directional_derivative$
",
            generatedCode="
void func_CADCodeGenTests_CADFunction9_f2_der_AD0(jmi_array_t* x_var_a, jmi_array_t* x_der_a, jmi_real_t* y1_var_o, jmi_real_t* y2_var_o, jmi_real_t* y1_der_o, jmi_real_t* y2_der_o);
void func_CADCodeGenTests_CADFunction9_f1_der_AD1(jmi_array_t* x_var_a, jmi_array_t* x_der_a, jmi_real_t* y1_var_o, jmi_real_t* y2_var_o, jmi_real_t* y1_der_o, jmi_real_t* y2_der_o);

void func_CADCodeGenTests_CADFunction9_f2_der_AD0(jmi_array_t* x_var_a, jmi_array_t* x_der_a, jmi_real_t* y1_var_o, jmi_real_t* y2_var_o, jmi_real_t* y1_der_o, jmi_real_t* y2_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y1_var_v)
    JMI_DEF(REA, y1_der_v)
    JMI_DEF(REA, y2_var_v)
    JMI_DEF(REA, y2_der_v)
    jmi_real_t v_0;
    jmi_real_t d_0;
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_0, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_0, 2, 1)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_var_0, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_der_0, 2, 1, 2)
    jmi_array_ref_1(tmp_var_0, 1) = jmi_array_val_1(x_var_a, 1.0) + 1.0;
    jmi_array_ref_1(tmp_var_0, 2) = jmi_array_val_1(x_var_a, 2.0) + 1.0;
    jmi_array_ref_1(tmp_der_0, 1) = jmi_array_val_1(x_der_a, 1.0) + 0.0;
    jmi_array_ref_1(tmp_der_0, 2) = jmi_array_val_1(x_der_a, 2.0) + 0.0;
    func_CADCodeGenTests_CADFunction9_f1_der_AD1(tmp_var_0, tmp_der_0, &v_0, NULL, &d_0, NULL);
    y1_var_v = v_0;
    y1_der_v = d_0;
    y2_var_v = y1_var_v + jmi_array_val_1(x_var_a, 2.0);
    y2_der_v = y1_der_v + jmi_array_val_1(x_der_a, 2.0);
    if (y1_var_o != NULL) *y1_var_o = y1_var_v;
    if (y1_der_o != NULL) *y1_der_o = y1_der_v;
    if (y2_var_o != NULL) *y2_var_o = y2_var_v;
    if (y2_der_o != NULL) *y2_der_o = y2_der_v;
    JMI_DYNAMIC_FREE()
    return;
}

void func_CADCodeGenTests_CADFunction9_f1_der_AD1(jmi_array_t* x_var_a, jmi_array_t* x_der_a, jmi_real_t* y1_var_o, jmi_real_t* y2_var_o, jmi_real_t* y1_der_o, jmi_real_t* y2_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y1_var_v)
    JMI_DEF(REA, y1_der_v)
    JMI_DEF(REA, y2_var_v)
    JMI_DEF(REA, y2_der_v)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_a, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_a, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, temp_1_var_a, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, temp_1_der_a, 2, 1)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_var_a, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_der_a, 2, 1, 2)
    jmi_array_ref_1(tmp_var_a, 1.0) = jmi_array_val_1(x_var_a, 1.0) + 1.0;
    jmi_array_ref_1(tmp_der_a, 1.0) = jmi_array_val_1(x_der_a, 1.0) + 0.0;
    jmi_array_ref_1(tmp_var_a, 2.0) = jmi_array_val_1(x_var_a, 2.0) + 1.0;
    jmi_array_ref_1(tmp_der_a, 2.0) = jmi_array_val_1(x_der_a, 2.0) + 0.0;
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, temp_1_var_a, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, temp_1_der_a, 2, 1, 2)
    jmi_array_ref_1(temp_1_var_a, 1) = jmi_array_val_1(tmp_var_a, 1.0) + jmi_array_val_1(x_var_a, 1.0);
    jmi_array_ref_1(temp_1_der_a, 1) = jmi_array_val_1(tmp_der_a, 1.0) + jmi_array_val_1(x_der_a, 1.0);
    jmi_array_ref_1(temp_1_var_a, 2) = jmi_array_val_1(tmp_var_a, 2.0) + jmi_array_val_1(x_var_a, 2.0);
    jmi_array_ref_1(temp_1_der_a, 2) = jmi_array_val_1(tmp_der_a, 2.0) + jmi_array_val_1(x_der_a, 2.0);
    jmi_array_ref_1(tmp_var_a, 1.0) = jmi_array_val_1(temp_1_var_a, 1);
    jmi_array_ref_1(tmp_der_a, 1.0) = jmi_array_val_1(temp_1_der_a, 1);
    jmi_array_ref_1(tmp_var_a, 2.0) = jmi_array_val_1(temp_1_var_a, 2);
    jmi_array_ref_1(tmp_der_a, 2.0) = jmi_array_val_1(temp_1_der_a, 2);
    y1_var_v = jmi_array_val_1(tmp_var_a, 1.0);
    y1_der_v = jmi_array_val_1(tmp_der_a, 1.0);
    y2_var_v = jmi_array_val_1(tmp_var_a, 1.0) + y1_var_v;
    y2_der_v = jmi_array_val_1(tmp_der_a, 1.0) + y1_der_v;
    if (y1_var_o != NULL) *y1_var_o = y1_var_v;
    if (y1_der_o != NULL) *y1_der_o = y1_der_v;
    if (y2_var_o != NULL) *y2_var_o = y2_var_v;
    if (y2_der_o != NULL) *y2_der_o = y2_der_v;
    JMI_DYNAMIC_FREE()
    return;
}


    jmi_real_t v_1;
    jmi_real_t d_1;
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_1, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_1, 2, 1)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_var_1, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_der_1, 2, 1, 2)
    jmi_array_ref_1(tmp_var_1, 1) = _x_1_0;
    jmi_array_ref_1(tmp_var_1, 2) = _x_2_1;
    jmi_array_ref_1(tmp_der_1, 1) = (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx];
    jmi_array_ref_1(tmp_der_1, 2) = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx];
    func_CADCodeGenTests_CADFunction9_f2_der_AD0(tmp_var_1, tmp_der_1, &v_1, NULL, &d_1, NULL);
    (*res)[0] = v_1 - (_y1_2);
    (*dF)[0] = d_1 - ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]);
    (*res)[1] = _time - (_x_1_0);
    (*dF)[1] = (*dz)[jmi->offs_t] - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[2] = 2.0 * _x_1_0 - (_x_2_1);
    (*dF)[2] = 0.0 * _x_1_0 + 2.0 * (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
")})));
end CADFunction9;

model CADFunction10
    function F1
        input Real x;
        output Real y;
        Real[:] m = {1, 2, 3, 4, 5, 6, 7, 8};
    algorithm
        y := 0;
        for i in 1:size(m,1)/2 loop
            for j in 1:size(m,1)/2 loop
                if m[integer(i + j * 2)] > x then
                    break;
                end if;
                y := y + m[integer(i + j * 2)] * x;
            end for;
        end for;
    annotation(Inline=false,smoothOrder=1);
    end F1;
    
    Real x = sin(y);
    Real y = F1(x);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADFunction10",
            description="Test code gen bug where ad steps were produced for array subscripts",
            generate_dae_jacobian=true,
            template="$CAD_functions$",
            generatedCode="
void func_CADCodeGenTests_CADFunction10_F1_der_AD0(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, m_var_a, 8, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, m_der_a, 8, 1)
    jmi_real_t v_0;
    jmi_real_t i_0i;
    jmi_real_t i_0ie;
    jmi_real_t v_1;
    jmi_real_t j_1i;
    jmi_real_t j_1ie;
    jmi_real_t v_2;
    jmi_real_t d_2;
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, m_var_a, 8, 1, 8)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, m_der_a, 8, 1, 8)
    jmi_array_ref_1(m_var_a, 1) = 1.0;
    jmi_array_ref_1(m_der_a, 1) = 0.0;
    jmi_array_ref_1(m_var_a, 2) = 2.0;
    jmi_array_ref_1(m_der_a, 2) = 0.0;
    jmi_array_ref_1(m_var_a, 3) = 3.0;
    jmi_array_ref_1(m_der_a, 3) = 0.0;
    jmi_array_ref_1(m_var_a, 4) = 4.0;
    jmi_array_ref_1(m_der_a, 4) = 0.0;
    jmi_array_ref_1(m_var_a, 5) = 5.0;
    jmi_array_ref_1(m_der_a, 5) = 0.0;
    jmi_array_ref_1(m_var_a, 6) = 6.0;
    jmi_array_ref_1(m_der_a, 6) = 0.0;
    jmi_array_ref_1(m_var_a, 7) = 7.0;
    jmi_array_ref_1(m_der_a, 7) = 0.0;
    jmi_array_ref_1(m_var_a, 8) = 8.0;
    jmi_array_ref_1(m_der_a, 8) = 0.0;
    y_var_v = 0.0;
    y_der_v = 0.0;
    v_0 = 8.0 / 2.0;
    i_0ie = v_0 + 1 / 2.0;
    for (i_0i = 1; i_0i < i_0ie; i_0i += 1) {
        v_1 = 8.0 / 2.0;
        j_1ie = v_1 + 1 / 2.0;
        for (j_1i = 1; j_1i < j_1ie; j_1i += 1) {
            if (COND_EXP_GT(jmi_array_val_1(m_var_a, floor(i_0i + j_1i * 2.0)), x_var_v, JMI_TRUE, JMI_FALSE)) {
                break;
            }
            v_2 = jmi_array_val_1(m_var_a, floor(i_0i + j_1i * 2.0)) * x_var_v;
            d_2 = jmi_array_val_1(m_der_a, floor(i_0i + j_1i * 2.0)) * x_var_v + jmi_array_val_1(m_var_a, floor(i_0i + j_1i * 2.0)) * x_der_v;
            y_var_v = y_var_v + v_2;
            y_der_v = y_der_v + d_2;
        }
    }
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}
")})));
end CADFunction10;

model CADFunction11
    function F1
        input Real[2] X;
        output Real lambda;
    algorithm
        lambda := F3(F2(X, {1.1, 1.2}));
    annotation(smoothOrder = 1, Inline=false);
    end F1;

    function F2
        input Real[:] X;
        input Real[size(X, 1)] MMX;
        output Real[size(X, 1)] moleFractions;
    algorithm
        for i in 1:size(X, 1) loop
            moleFractions[i] := X[i] * MMX[i];
        end for;
        annotation(smoothOrder = 1, Inline=false);
    end F2;

    function F3
        input Real[:] X;
        output Real y;
    algorithm
        y := 0;
        for i in 1:size(X, 1) loop
            y := y + X[i];
        end for;
    annotation(smoothOrder = 1, Inline=false);
    end F3;

    Real x;
    Real y;
equation
    x = F1({y, -y});
    y * x = 0;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADFunction11",
            description="Test code gen bug where function call and input initialization was done in the wrong order",
            generate_dae_jacobian=true,
            template="$CAD_functions$",
            generatedCode="
void func_CADCodeGenTests_CADFunction11_F1_der_AD0(jmi_array_t* X_var_a, jmi_array_t* X_der_a, jmi_real_t* lambda_var_o, jmi_real_t* lambda_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, lambda_var_v)
    JMI_DEF(REA, lambda_der_v)
    jmi_real_t v_0;
    jmi_real_t d_0;
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_0, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_0, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_1, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_1, 2, 1)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_var_0, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_der_0, 2, 1, 2)
    jmi_array_ref_1(tmp_var_0, 1) = 1.1;
    jmi_array_ref_1(tmp_var_0, 2) = 1.2;
    jmi_array_ref_1(tmp_der_0, 1) = 0.0;
    jmi_array_ref_1(tmp_der_0, 2) = 0.0;
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_var_1, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_der_1, 2, 1, 2)
    func_CADCodeGenTests_CADFunction11_F2_der_AD2(X_var_a, tmp_var_0, X_der_a, tmp_der_0, tmp_var_1, tmp_der_1);
    func_CADCodeGenTests_CADFunction11_F3_der_AD1(tmp_var_1, tmp_der_1, &v_0, &d_0);
    lambda_var_v = v_0;
    lambda_der_v = d_0;
    if (lambda_var_o != NULL) *lambda_var_o = lambda_var_v;
    if (lambda_der_o != NULL) *lambda_der_o = lambda_der_v;
    JMI_DYNAMIC_FREE()
    return;
}

void func_CADCodeGenTests_CADFunction11_F3_der_AD1(jmi_array_t* X_var_a, jmi_array_t* X_der_a, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    jmi_real_t v_1;
    jmi_real_t i_0i;
    jmi_real_t i_0ie;
    y_var_v = 0.0;
    y_der_v = 0.0;
    v_1 = jmi_array_size(X_var_a, 0);
    i_0ie = v_1 + 1 / 2.0;
    for (i_0i = 1; i_0i < i_0ie; i_0i += 1) {
        y_var_v = y_var_v + jmi_array_val_1(X_var_a, i_0i);
        y_der_v = y_der_v + jmi_array_val_1(X_der_a, i_0i);
    }
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}

void func_CADCodeGenTests_CADFunction11_F2_der_AD2(jmi_array_t* X_var_a, jmi_array_t* MMX_var_a, jmi_array_t* X_der_a, jmi_array_t* MMX_der_a, jmi_array_t* moleFractions_var_a, jmi_array_t* moleFractions_der_a) {
    JMI_DYNAMIC_INIT()
    jmi_real_t v_2;
    JMI_ARR(DYNA, jmi_real_t, jmi_array_t, moleFractions_var_an, -1, 1)
    JMI_ARR(DYNA, jmi_real_t, jmi_array_t, moleFractions_der_an, -1, 1)
    jmi_real_t v_3;
    jmi_real_t i_1i;
    jmi_real_t i_1ie;
    if (moleFractions_var_a == NULL) {
        v_2 = jmi_array_size(X_var_a, 0);
        JMI_ARRAY_INIT_1(DYNA, jmi_real_t, jmi_array_t, moleFractions_var_an, v_2, 1, jmi_array_size(X_var_a, 0))
        moleFractions_var_a = moleFractions_var_an;
    }
    if (moleFractions_der_a == NULL) {
        v_2 = jmi_array_size(X_var_a, 0);
        JMI_ARRAY_INIT_1(DYNA, jmi_real_t, jmi_array_t, moleFractions_der_an, v_2, 1, jmi_array_size(X_var_a, 0))
        moleFractions_der_a = moleFractions_der_an;
    }
    v_3 = jmi_array_size(X_var_a, 0);
    i_1ie = v_3 + 1 / 2.0;
    for (i_1i = 1; i_1i < i_1ie; i_1i += 1) {
        jmi_array_ref_1(moleFractions_var_a, i_1i) = jmi_array_val_1(X_var_a, i_1i) * jmi_array_val_1(MMX_var_a, i_1i);
        jmi_array_ref_1(moleFractions_der_a, i_1i) = jmi_array_val_1(X_der_a, i_1i) * jmi_array_val_1(MMX_var_a, i_1i) + jmi_array_val_1(X_var_a, i_1i) * jmi_array_val_1(MMX_der_a, i_1i);
    }
    JMI_DYNAMIC_FREE()
    return;
}
")})));
end CADFunction11;

model CADFunction12
    function F1
        input Real x;
        output Real[2] y;
    algorithm
        y[1] := x;
        y[2] := -x;
    annotation(derivative=F1_der, Inline=false);
    end F1;

    function F1_der
        input Real x;
        input Real x_der;
        output Real[2] y;
    algorithm
        y[1] := x_der;
        y[2] := -x_der;
    annotation(Inline=false);
    end F1_der;


    Real x;
    Real y;
    Real z;
equation
    {x, y} = F1(z);
    y * x = z;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADFunction12",
            description="Test code gen bug including function call with derivative annoation and non-scalar output",
            generate_dae_jacobian=true,
            template="
$C_functions$
$CAD_functions$
",
            generatedCode="
void func_CADCodeGenTests_CADFunction12_F1_def0(jmi_real_t x_v, jmi_array_t* y_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, y_an, 2, 1)
    if (y_a == NULL) {
        JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, y_an, 2, 1, 2)
        y_a = y_an;
    }
    jmi_array_ref_1(y_a, 1.0) = x_v;
    jmi_array_ref_1(y_a, 2.0) = - x_v;
    JMI_DYNAMIC_FREE()
    return;
}

void func_CADCodeGenTests_CADFunction12_F1_der_def1(jmi_real_t x_v, jmi_real_t x_der_v, jmi_array_t* y_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, y_an, 2, 1)
    if (y_a == NULL) {
        JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, y_an, 2, 1, 2)
        y_a = y_an;
    }
    jmi_array_ref_1(y_a, 1.0) = x_der_v;
    jmi_array_ref_1(y_a, 2.0) = - x_der_v;
    JMI_DYNAMIC_FREE()
    return;
}


void func_CADCodeGenTests_CADFunction12_F1_der_AD0(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_array_t* y_var_a, jmi_array_t* y_der_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, y_var_an, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, y_der_an, 2, 1)
    /*Using specified derivative annotation instead of AD*/
    func_CADCodeGenTests_CADFunction12_F1_def0(x_var_v, y_var_a);
    func_CADCodeGenTests_CADFunction12_F1_der_def1(x_var_v, x_der_v, y_der_a);
    JMI_DYNAMIC_FREE()
    return;
}
")})));
end CADFunction12;

model FunctionDiscreteInputTest1
	function f
		input Integer i;
		output Real y;
	algorithm
		y := 1 + i;
	end f;
	
	Real x;
equation
	x = f(42);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="FunctionDiscreteInputTest1",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_ode_jacobian=true,
            template="
$CAD_function_headers$
$CAD_functions$
",
            generatedCode="
void func_CADCodeGenTests_FunctionDiscreteInputTest1_f_der_AD0(jmi_real_t i_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o);

void func_CADCodeGenTests_FunctionDiscreteInputTest1_f_der_AD0(jmi_real_t i_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    /*Zero derivative function*/
    func_CADCodeGenTests_FunctionDiscreteInputTest1_f_def0(i_v, &y_var_v);
    y_der_v = 0;
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end FunctionDiscreteInputTest1;

model FunctionDiscreteOutputTest1
	function f
		input Real x;
		output Integer i;
	algorithm
		i := if x + 23 > 42 then 42 else 1;
	end f;
	Integer i;
equation
	i = f(2.0);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="FunctionDiscreteOutputTest1",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_ode_jacobian=true,
            template="
$CAD_function_headers$
$CAD_functions$
",
            generatedCode="
void func_CADCodeGenTests_FunctionDiscreteOutputTest1_f_der_AD0(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* i_o);

void func_CADCodeGenTests_FunctionDiscreteOutputTest1_f_der_AD0(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* i_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(INT, i_v)
    /*Zero derivative function*/
    func_CADCodeGenTests_FunctionDiscreteOutputTest1_f_def0(x_var_v, &i_v);
    JMI_RET(GEN, i_o, i_v)
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end FunctionDiscreteOutputTest1;

model FunctionDiscreteOutputTest2
	function F1
		output Integer y;
	algorithm
		y := 42;
	end F1;
	function F2
		input Real x;
		output Real y;
		Integer i;
	algorithm
		y := F1() + x;
	end F2;
	Real x = 3;
	Real y;
equation
	y = F2(x);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="FunctionDiscreteOutputTest2",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_ode_jacobian=true,
            template="
$CAD_function_headers$
$CAD_functions$
",
            generatedCode="
void func_CADCodeGenTests_FunctionDiscreteOutputTest2_F2_der_AD0(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o);
void func_CADCodeGenTests_FunctionDiscreteOutputTest2_F1_der_AD1(jmi_real_t* y_o);

void func_CADCodeGenTests_FunctionDiscreteOutputTest2_F2_der_AD0(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    JMI_DEF(INT, i_v)
    jmi_real_t v_0;
    func_CADCodeGenTests_FunctionDiscreteOutputTest2_F1_der_AD1(&v_0);
    y_var_v = v_0 + x_var_v;
    y_der_v = 0.0 + x_der_v;
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}

void func_CADCodeGenTests_FunctionDiscreteOutputTest2_F1_der_AD1(jmi_real_t* y_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(INT, y_v)
    /*Zero derivative function*/
    func_CADCodeGenTests_FunctionDiscreteOutputTest2_F1_def1(&y_v);
    JMI_RET(GEN, y_o, y_v)
    JMI_DYNAMIC_FREE()
    return;
}
")})));
end FunctionDiscreteOutputTest2;

model FunctionDiscreteOutputTest3
	function F
		input Real x[:];
		output Integer i;
	algorithm
		i := size(x, 1);
	end F;
	Integer x[:] = {1,2,3};
	Integer i;
equation
	i = F(x);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="FunctionDiscreteOutputTest3",
            description="",
            variability_propagation=false,
            inline_functions="none",
            equation_sorting=true,
            generate_dae=true,
            generate_ode=true,
            generate_ode_jacobian=true,
            template="
$CAD_ode_derivatives$
$CAD_function_headers$
$CAD_functions$
",
            generatedCode="
    /******** Declarations *******/
    jmi_real_t v_0;
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_0, 3, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_0, 3, 1)
    jmi_real_t** dz = jmi->dz;
    /*********** ODE section ***********/
    /*********** Real outputs **********/
    /*** Integer and boolean outputs ***/
    /********* Other variables *********/
    _x_1_0 = 1.0;
    pre_x_1_0 = _x_1_0;
    _x_2_1 = 2.0;
    pre_x_2_1 = _x_2_1;
    _x_3_2 = 3.0;
    pre_x_3_2 = _x_3_2;
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_var_0, 3, 1, 3)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_der_0, 3, 1, 3)
    jmi_array_ref_1(tmp_var_0, 1) = _x_1_0;
    jmi_array_ref_1(tmp_var_0, 2) = _x_2_1;
    jmi_array_ref_1(tmp_var_0, 3) = _x_3_2;
    jmi_array_ref_1(tmp_der_0, 1) = 0.0;
    jmi_array_ref_1(tmp_der_0, 2) = 0.0;
    jmi_array_ref_1(tmp_der_0, 3) = 0.0;
    func_CADCodeGenTests_FunctionDiscreteOutputTest3_F_der_AD0(tmp_var_0, tmp_der_0, &v_0);
    _i_3 = v_0;
    pre_i_3 = _i_3;

void func_CADCodeGenTests_FunctionDiscreteOutputTest3_F_der_AD0(jmi_array_t* x_var_a, jmi_array_t* x_der_a, jmi_real_t* i_o);

void func_CADCodeGenTests_FunctionDiscreteOutputTest3_F_der_AD0(jmi_array_t* x_var_a, jmi_array_t* x_der_a, jmi_real_t* i_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(INT, i_v)
    /*Zero derivative function*/
    func_CADCodeGenTests_FunctionDiscreteOutputTest3_F_def0(x_var_a, &i_v);
    JMI_RET(GEN, i_o, i_v)
    JMI_DYNAMIC_FREE()
    return;
}
")})));
end FunctionDiscreteOutputTest3;

model FunctionMixedRecordInputTest1
	record R
		Real X[2];
		Integer i;
	end R;
	function F
		input R r;
		output Real y;
	algorithm
		y := sum(r.X) + r.i;
	end F;
	R r;
	Real y;
equation
	r.X[2] = 3;
	r.i = 1;
	y = F(R({r.X[1], 1 - r.X[2]}, r.i));
	r.X[1] = y + 2;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="FunctionMixedRecordInputTest1",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_ode_jacobian=true,
            template="
$CAD_function_headers$
$CAD_functions$
",
            generatedCode="
void func_CADCodeGenTests_FunctionMixedRecordInputTest1_F_der_AD0(R_0_r* r_var_v, R_0_r* r_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o);

void func_CADCodeGenTests_FunctionMixedRecordInputTest1_F_der_AD0(R_0_r* r_var_v, R_0_r* r_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    jmi_real_t v_0;
    jmi_real_t d_0;
    v_0 = jmi_array_val_1(r_var_v->X, 1.0) + jmi_array_val_1(r_var_v->X, 2.0);
    d_0 = jmi_array_val_1(r_der_v->X, 1.0) + jmi_array_val_1(r_der_v->X, 2.0);
    y_var_v = v_0 + r_var_v->i;
    y_der_v = d_0 + 0.0;
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}
")})));
end FunctionMixedRecordInputTest1;

model FunctionUnknownArraySizeTest1
	function F
		input Real x[:];
		output Real y;
		Real t[size(x, 1)];
	algorithm
		t := x .* 23;
		y := sum(t);
	end F;
	Real x[4] = {1,2,3,4};
	Real y;
equation
	y = F(x);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="FunctionUnknownArraySizeTest1",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_ode_jacobian=true,
            template="
$CAD_function_headers$
$CAD_functions$
",
            generatedCode="
void func_CADCodeGenTests_FunctionUnknownArraySizeTest1_F_der_AD0(jmi_array_t* x_var_a, jmi_array_t* x_der_a, jmi_real_t* y_var_o, jmi_real_t* y_der_o);

void func_CADCodeGenTests_FunctionUnknownArraySizeTest1_F_der_AD0(jmi_array_t* x_var_a, jmi_array_t* x_der_a, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    jmi_real_t v_0;
    JMI_ARR(DYNA, jmi_real_t, jmi_array_t, t_var_a, -1, 1)
    JMI_ARR(DYNA, jmi_real_t, jmi_array_t, t_der_a, -1, 1)
    JMI_DEF(REA, temp_1_var_v)
    JMI_DEF(REA, temp_1_der_v)
    jmi_real_t v_1;
    jmi_real_t i1_0i;
    jmi_real_t i1_0ie;
    jmi_real_t v_2;
    jmi_real_t i1_1i;
    jmi_real_t i1_1ie;
    v_0 = jmi_array_size(x_var_a, 0);
    JMI_ARRAY_INIT_1(DYNA, jmi_real_t, jmi_array_t, t_var_a, v_0, 1, jmi_array_size(x_var_a, 0))
    v_0 = jmi_array_size(x_var_a, 0);
    JMI_ARRAY_INIT_1(DYNA, jmi_real_t, jmi_array_t, t_der_a, v_0, 1, jmi_array_size(x_var_a, 0))
    v_1 = jmi_array_size(x_var_a, 0);
    i1_0ie = v_1 + 1 / 2.0;
    for (i1_0i = 1; i1_0i < i1_0ie; i1_0i += 1) {
        jmi_array_ref_1(t_var_a, i1_0i) = jmi_array_val_1(x_var_a, i1_0i) * 23.0;
        jmi_array_ref_1(t_der_a, i1_0i) = jmi_array_val_1(x_der_a, i1_0i) * 23.0 + jmi_array_val_1(x_var_a, i1_0i) * 0.0;
    }
    temp_1_var_v = 0.0;
    temp_1_der_v = 0.0;
    v_2 = jmi_array_size(x_var_a, 0);
    i1_1ie = v_2 + 1 / 2.0;
    for (i1_1i = 1; i1_1i < i1_1ie; i1_1i += 1) {
        temp_1_var_v = temp_1_var_v + jmi_array_val_1(t_var_a, i1_1i);
        temp_1_der_v = temp_1_der_v + jmi_array_val_1(t_der_a, i1_1i);
    }
    y_var_v = temp_1_var_v;
    y_der_v = temp_1_der_v;
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}")})));
end FunctionUnknownArraySizeTest1;

model FunctionUnknownArraySizeTest2
    function F1
        input Real x[2];
        input Integer num;
        output Real y[2 + num * num];
    algorithm
        for i in 1:size(y,1) loop
            y[i] := x[1] + x[2];
        end for;
    end F1;
    
    Real z[2]={time,1};
    constant Integer num = 2;
    Real w[2 + num * num] = F1(z, num);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="FunctionUnknownArraySizeTest2",
            description="",
            generate_ode_jacobian=true,
            inline_functions="none",
            template="$CAD_functions$",
            generatedCode="
void func_CADCodeGenTests_FunctionUnknownArraySizeTest2_F1_der_AD0(jmi_array_t* x_var_a, jmi_real_t num_v, jmi_array_t* x_der_a, jmi_array_t* y_var_a, jmi_array_t* y_der_a) {
    JMI_DYNAMIC_INIT()
    jmi_real_t v_0;
    jmi_real_t v_1;
    JMI_ARR(DYNA, jmi_real_t, jmi_array_t, y_var_an, -1, 1)
    JMI_ARR(DYNA, jmi_real_t, jmi_array_t, y_der_an, -1, 1)
    jmi_real_t v_2;
    jmi_real_t i_0i;
    jmi_real_t i_0ie;
    if (y_var_a == NULL) {
        v_1 = num_v * num_v;
        v_0 = 2.0 + v_1;
        JMI_ARRAY_INIT_1(DYNA, jmi_real_t, jmi_array_t, y_var_an, (v_0), 1, 2.0 + v_1)
        y_var_a = y_var_an;
    }
    if (y_der_a == NULL) {
        v_1 = num_v * num_v;
        v_0 = 2.0 + v_1;
        JMI_ARRAY_INIT_1(DYNA, jmi_real_t, jmi_array_t, y_der_an, (v_0), 1, 2.0 + v_1)
        y_der_a = y_der_an;
    }
    v_2 = jmi_array_size(y_var_a, 0);
    i_0ie = v_2 + 1 / 2.0;
    for (i_0i = 1; i_0i < i_0ie; i_0i += 1) {
        jmi_array_ref_1(y_var_a, i_0i) = jmi_array_val_1(x_var_a, 1.0) + jmi_array_val_1(x_var_a, 2.0);
        jmi_array_ref_1(y_der_a, i_0i) = jmi_array_val_1(x_der_a, 1.0) + jmi_array_val_1(x_der_a, 2.0);
    }
    JMI_DYNAMIC_FREE()
    return;
}
")})));
end FunctionUnknownArraySizeTest2;

model CADDerAnno1
		function f
			input Real x;
			output Real y;
		algorithm
			y := x^2;
			annotation(derivative=f_der);
		end f;
		
		function f_der
			input Real x;
			input Real der_x;
			output Real der_y;
		algorithm
			der_y := 2*x*der_x;
		end f_der;

		Real x1,x2;
	equation
		der(x1) + der(x2) = 1;
		x1 + f(x2) = 0;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADDerAnno1",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            generate_ode_jacobian=true,
            template="
$CAD_function_headers$
$CAD_functions$
",
            generatedCode="
void func_CADCodeGenTests_CADDerAnno1_f_der_AD0(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o);
void func_CADCodeGenTests_CADDerAnno1_f_der_der_AD1(jmi_real_t x_var_v, jmi_real_t der_x_var_v, jmi_real_t x_der_v, jmi_real_t der_x_der_v, jmi_real_t* der_y_var_o, jmi_real_t* der_y_der_o);

void func_CADCodeGenTests_CADDerAnno1_f_der_AD0(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    /*Using specified derivative annotation instead of AD*/
    func_CADCodeGenTests_CADDerAnno1_f_def0(x_var_v, &y_var_v);
    func_CADCodeGenTests_CADDerAnno1_f_der_def1(x_var_v, x_der_v, &y_der_v);
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}

void func_CADCodeGenTests_CADDerAnno1_f_der_der_AD1(jmi_real_t x_var_v, jmi_real_t der_x_var_v, jmi_real_t x_der_v, jmi_real_t der_x_der_v, jmi_real_t* der_y_var_o, jmi_real_t* der_y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, der_y_var_v)
    JMI_DEF(REA, der_y_der_v)
    jmi_real_t v_0;
    jmi_real_t d_0;
    v_0 = 2.0 * x_var_v;
    d_0 = 0.0 * x_var_v + 2.0 * x_der_v;
    der_y_var_v = v_0 * der_x_var_v;
    der_y_der_v = d_0 * der_x_var_v + v_0 * der_x_der_v;
    if (der_y_var_o != NULL) *der_y_var_o = der_y_var_v;
    if (der_y_der_o != NULL) *der_y_der_o = der_y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}
")})));
end CADDerAnno1;


model CADDerAnno2
		function f2
			input Real x1;
			input Integer i = 1;
			input Boolean b = true;
			output Integer i1;
			output Boolean b1;
			output Real y;
		algorithm
			i1 := 1;
			b1 := true;
			y  := if(b) then x1^2 else x1^3;
			annotation(derivative = f_der);
		end f2;
		
		function f_der
			input Real x1;
			input Integer i1;
			input Boolean b1;
			input Real der_x1;
			output Real der_y1;
		algorithm
			der_y1 := if(b1) then 2*x1*der_x1 else 3*x1^2*der_x1;
		end f_der;
		
		Real x1(start=2);
		Real y(start=2);
		Integer i (start = 1);
		Boolean b (start = true);
		output Real a1(start=4);
	equation
		y = f2(x1,i,b);
		i = if b then 1 else 2;
		b = x1 > 0;
		der(a1) = if i == 1 then x1 else -x1;
		der(x1) = a1;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADDerAnno2",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_ode_jacobian=true,
            generate_block_jacobian=true,
            template="
$CAD_function_headers$
$CAD_functions$
$C_functions$
",
            generatedCode="
void func_CADCodeGenTests_CADDerAnno2_f2_der_AD0(jmi_real_t x1_var_v, jmi_real_t i_v, jmi_real_t b_v, jmi_real_t x1_der_v, jmi_real_t* i1_o, jmi_real_t* b1_o, jmi_real_t* y_var_o, jmi_real_t* y_der_o);

void func_CADCodeGenTests_CADDerAnno2_f2_der_AD0(jmi_real_t x1_var_v, jmi_real_t i_v, jmi_real_t b_v, jmi_real_t x1_der_v, jmi_real_t* i1_o, jmi_real_t* b1_o, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(INT, i1_v)
    JMI_DEF(BOO, b1_v)
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    /*Using specified derivative annotation instead of AD*/
    func_CADCodeGenTests_CADDerAnno2_f2_def0(x1_var_v, i_v, b_v, &i1_v, &b1_v, &y_var_v);
    func_CADCodeGenTests_CADDerAnno2_f_der_def1(x1_var_v, i_v, b_v, x1_der_v, &y_der_v);
    JMI_RET(GEN, i1_o, i1_v)
    JMI_RET(GEN, b1_o, b1_v)
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}


void func_CADCodeGenTests_CADDerAnno2_f2_def0(jmi_real_t x1_v, jmi_real_t i_v, jmi_real_t b_v, jmi_real_t* i1_o, jmi_real_t* b1_o, jmi_real_t* y_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(INT, i1_v)
    JMI_DEF(BOO, b1_v)
    JMI_DEF(REA, y_v)
    i1_v = 1.0;
    b1_v = JMI_TRUE;
    y_v = COND_EXP_EQ(b_v, JMI_TRUE, (1.0 * (x1_v) * (x1_v)), (1.0 * (x1_v) * (x1_v) * (x1_v)));
    JMI_RET(GEN, i1_o, i1_v)
    JMI_RET(GEN, b1_o, b1_v)
    JMI_RET(GEN, y_o, y_v)
    JMI_DYNAMIC_FREE()
    return;
}

jmi_real_t func_CADCodeGenTests_CADDerAnno2_f2_exp0(jmi_real_t x1_v, jmi_real_t i_v, jmi_real_t b_v) {
    JMI_DEF(INT, i1_v)
    func_CADCodeGenTests_CADDerAnno2_f2_def0(x1_v, i_v, b_v, &i1_v, NULL, NULL);
    return i1_v;
}

void func_CADCodeGenTests_CADDerAnno2_f_der_def1(jmi_real_t x1_v, jmi_real_t i1_v, jmi_real_t b1_v, jmi_real_t der_x1_v, jmi_real_t* der_y1_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, der_y1_v)
    der_y1_v = COND_EXP_EQ(b1_v, JMI_TRUE, 2.0 * x1_v * der_x1_v, 3.0 * (1.0 * (x1_v) * (x1_v)) * der_x1_v);
    JMI_RET(GEN, der_y1_o, der_y1_v)
    JMI_DYNAMIC_FREE()
    return;
}

jmi_real_t func_CADCodeGenTests_CADDerAnno2_f_der_exp1(jmi_real_t x1_v, jmi_real_t i1_v, jmi_real_t b1_v, jmi_real_t der_x1_v) {
    JMI_DEF(REA, der_y1_v)
    func_CADCodeGenTests_CADDerAnno2_f_der_def1(x1_v, i1_v, b1_v, der_x1_v, &der_y1_v);
    return der_y1_v;
}
")})));
end CADDerAnno2;


model CADIfStmtTest1
	function f
		input Real x;
		input Boolean b;
		output Real y;
	algorithm
		if x > 5 or false then
			y := x^2;
		else
			y := 2;
		end if;
	end f;

	Real x;
equation
	der(x) = f(x, x > 4);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADIfStmtTest1",
            description="",
            variability_propagation=false,
            generate_ode_jacobian=true,
            template="
$CAD_function_headers$
$CAD_functions$
",
            generatedCode="
void func_CADCodeGenTests_CADIfStmtTest1_f_der_AD0(jmi_real_t x_var_v, jmi_real_t b_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o);

void func_CADCodeGenTests_CADIfStmtTest1_f_der_AD0(jmi_real_t x_var_v, jmi_real_t b_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    jmi_real_t v_0;
    jmi_real_t v_1;
    v_0 = COND_EXP_GT(x_var_v, 5.0, JMI_TRUE, JMI_FALSE);
    if (LOG_EXP_OR(v_0, JMI_FALSE)) {
        v_1 = (1.0 * (x_var_v) * (x_var_v));
        y_var_v = v_1;
        y_der_v = x_var_v == 0 ? 0 : (v_1 * (0.0 * log(jmi_abs(x_var_v)) + 2.0 * x_der_v / x_var_v));
    } else {
        y_var_v = 2.0;
        y_der_v = 0.0;
    }
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}
")})));
end CADIfStmtTest1;

model CADForStmtTest1
	function f
		input Real x;
		input Integer n;
		output Real y;
	algorithm
		for i in {1, 2 + x, 4}, j in 1:(x + 1) loop
			y := x + y + i * j;
		end for;
	end f;

	Real x;
equation
	der(x) = f(x, 4);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADForStmtTest1",
            description="CAD for function with for loop",
            variability_propagation=false,
            generate_ode_jacobian=true,
            template="
$CAD_function_headers$
$CAD_functions$
",
            generatedCode="
void func_CADCodeGenTests_CADForStmtTest1_f_der_AD0(jmi_real_t x_var_v, jmi_real_t n_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o);

void func_CADCodeGenTests_CADForStmtTest1_f_der_AD0(jmi_real_t x_var_v, jmi_real_t n_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, temp_1_var_a, 3, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, temp_1_der_a, 3, 1)
    jmi_real_t i_0i;
    int i_0ii;
    jmi_real_t v_0;
    jmi_real_t d_0;
    jmi_real_t j_1i;
    jmi_real_t j_1ie;
    jmi_real_t v_1;
    jmi_real_t d_1;
    jmi_real_t v_2;
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, temp_1_var_a, 3, 1, 3)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, temp_1_der_a, 3, 1, 3)
    jmi_array_ref_1(temp_1_var_a, 1) = 1.0;
    jmi_array_ref_1(temp_1_der_a, 1) = 0.0;
    jmi_array_ref_1(temp_1_var_a, 2) = 2.0 + x_var_v;
    jmi_array_ref_1(temp_1_der_a, 2) = 0.0 + x_der_v;
    jmi_array_ref_1(temp_1_var_a, 3) = 4.0;
    jmi_array_ref_1(temp_1_der_a, 3) = 0.0;
    for (i_0ii = 0; i_0ii < jmi_array_size(temp_1_a, 0); i_0ii++) {
        i_0i = jmi_array_val_1(temp_1_a, i_0ii);
        v_0 = x_var_v + 1.0;
        d_0 = x_der_v + 0.0;
        j_1ie = v_0 + 1 / 2.0;
        for (j_1i = 1; j_1i < j_1ie; j_1i += 1) {
            v_1 = x_var_v + y_var_v;
            d_1 = x_der_v + y_der_v;
            v_2 = i_0i * j_1i;
            y_var_v = v_1 + v_2;
            y_der_v = d_1 + 0.0;
        }
    }
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}
")})));
end CADForStmtTest1;

model CADWhileStmtTest1
	function f
		input Real x;
		input Integer n;
		output Real y;
	algorithm
		while y < x - 2 or n < y loop
			y := y + 1;
		end while;
	end f;

	Real x;
equation
	der(x) = f(x, 4);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADWhileStmtTest1",
            description="",
            variability_propagation=false,
            generate_ode_jacobian=true,
            equation_sorting=false,
            template="
$CAD_ode_derivatives$
$CAD_function_headers$
$CAD_functions$
",
            generatedCode="
    /******** Declarations *******/
    jmi_real_t** dz = jmi->dz;
    /*********** ODE section ***********/
    /*********** Real outputs **********/
    /*** Integer and boolean outputs ***/
    /********* Other variables *********/

void func_CADCodeGenTests_CADWhileStmtTest1_f_der_AD0(jmi_real_t x_var_v, jmi_real_t n_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o);

void func_CADCodeGenTests_CADWhileStmtTest1_f_der_AD0(jmi_real_t x_var_v, jmi_real_t n_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    jmi_real_t v_0;
    jmi_real_t v_1;
    jmi_real_t d_1;
    jmi_real_t v_2;
    v_1 = x_var_v - 2.0;
    d_1 = x_der_v - 0.0;
    v_0 = COND_EXP_LT(y_var_v, v_1, JMI_TRUE, JMI_FALSE);
    v_2 = COND_EXP_LT(n_v, y_var_v, JMI_TRUE, JMI_FALSE);
    while (LOG_EXP_OR(v_0, v_2)) {
        y_var_v = y_var_v + 1.0;
        y_der_v = y_der_v + 0.0;
        v_1 = x_var_v - 2.0;
        d_1 = x_der_v - 0.0;
        v_0 = COND_EXP_LT(y_var_v, v_1, JMI_TRUE, JMI_FALSE);
        v_2 = COND_EXP_LT(n_v, y_var_v, JMI_TRUE, JMI_FALSE);
    }
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}
")})));
end CADWhileStmtTest1;

model CADRes1
	Real x(start=0.5);
	Real y(start=0.5);
	Real a(start=15);
	Real b(start=15);
equation
	x = sin(x);
	y = sin(y);
	der(a) = log(x+1)*a;
	der(b) = log(y+2)*b;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADRes1",
            description="",
            variability_propagation=false,
            generate_ode_jacobian=true,
            eliminate_alias_variables=false,
            fmi_version="2.0",
            generate_ode=true,
            equation_sorting=true,
            template="
$CAD_ode_derivatives$
$CAD_dae_blocks_residual_functions$
",
            generatedCode="
    /******** Declarations *******/
    jmi_real_t v_0;
    jmi_real_t d_0;
    jmi_real_t v_1;
    jmi_real_t d_1;
    jmi_real_t v_2;
    jmi_real_t d_2;
    jmi_real_t v_3;
    jmi_real_t d_3;
    jmi_real_t** dz = jmi->dz;
    /*********** ODE section ***********/
    ef |= jmi_ode_unsolved_block_dir_der(jmi, jmi->dae_block_residuals[0]);
    v_1 = _x_0 + 1.0;
    d_1 = (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] + 0.0;
    v_0 = jmi_log_equation(jmi, v_1, \"log(x + 1)\");
    d_0 = d_1 / v_1;
    _der_a_4 = v_0 * _a_2;
    (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = d_0 * _a_2 + v_0 * (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx];
    ef |= jmi_ode_unsolved_block_dir_der(jmi, jmi->dae_block_residuals[1]);
    v_3 = _y_1 + 2.0;
    d_3 = (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx] + 0.0;
    v_2 = jmi_log_equation(jmi, v_3, \"log(y + 2)\");
    d_2 = d_3 / v_3;
    _der_b_5 = v_2 * _b_3;
    (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = d_2 * _b_3 + v_2 * (*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx];
    /*********** Real outputs **********/
    /*** Integer and boolean outputs ***/
    /********* Other variables *********/

static int dae_block_dir_der_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 1 *****/
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        x[0] = _x_0;
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
        (*dz)[ jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] = dx[0];
        _x_0 = x[0];
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
        (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] = -(*dF)[0];
    } else {
        return -1;
    }
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
        (*res)[0] = sin(_x_0) - (_x_0);
        (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] * cos(_x_0) - ((*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx]);
        (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] = 0;
    }
        JMI_DYNAMIC_FREE()
    return ef;
}

static int dae_block_dir_der_1(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 2 *****/
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        x[0] = _y_1;
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
        (*dz)[ jmi_get_index_from_value_ref(5)-jmi->offs_real_dx] = dx[0];
        _y_1 = x[0];
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
        (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx] = -(*dF)[0];
    } else {
        return -1;
    }
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
        (*res)[0] = sin(_y_1) - (_y_1);
        (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx] * cos(_y_1) - ((*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx]);
        (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx] = 0;
    }
        JMI_DYNAMIC_FREE()
    return ef;
}
")})));
end CADRes1;

model CADRes2
	function F
		input Real x;
		output Real a;
	algorithm
		a := sin(x);
	end F;
	Real x(start=0.5);
	Real y(start=10);
	Real a(start=15);
equation
	x = F(x);
	der(y) = x*a;
	der(a) = log(x*y+1);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADRes2",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_ode_jacobian=true,
            eliminate_alias_variables=false,
            fmi_version="2.0",
            generate_ode=true,
            equation_sorting=true,
            template="
$CAD_ode_derivatives$
$CAD_dae_blocks_residual_functions$
",
            generatedCode="

/******** Declarations *******/
    jmi_real_t v_0;
    jmi_real_t d_0;
    jmi_real_t v_1;
    jmi_real_t d_1;
    jmi_real_t** dz = jmi->dz;
    /*********** ODE section ***********/
    ef |= jmi_ode_unsolved_block_dir_der(jmi, jmi->dae_block_residuals[0]);
    _der_y_3 = _x_0 * _a_2;
    (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] * _a_2 + _x_0 * (*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx];
    v_1 = _x_0 * _y_1;
    d_1 = (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] * _y_1 + _x_0 * (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx];
    v_0 = v_1 + 1.0;
    d_0 = d_1 + 0.0;
    _der_a_4 = jmi_log_equation(jmi, v_0,\"log(x * y + 1)\");
    (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = d_0 / v_0;
    /*********** Real outputs **********/
    /*** Integer and boolean outputs ***/
    /********* Other variables *********/

static int dae_block_dir_der_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 1 *****/
    jmi_real_t v_2;
    jmi_real_t d_2;
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        x[0] = _x_0;
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
        (*dz)[ jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] = dx[0];
        _x_0 = x[0];
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
        (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] = -(*dF)[0];
    } else {
        return -1;
    }
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
        func_CADCodeGenTests_CADRes2_F_der_AD0(_x_0, (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx], &v_2, &d_2);
        (*res)[0] = v_2 - (_x_0);
        (*dF)[0] = d_2 - ((*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx]);
        (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] = 0;
    }
        JMI_DYNAMIC_FREE()
    return ef;
}

")})));
end CADRes2;

model CADRes3
	function F
		input Real x1;
		input Real x2;
		input Real x3;
		input Real x4;
		output Real a;
		output Real b;
		output Real c;
		output Real d;
	algorithm
		a := sin(x1);
		b := cos(x1);
		c := tan(x2);
		d := sin(x3);
	end F;
	Real x1(start=.1);
	Real x2(start=.2);
	Real x3(start=.3);
	Real x4(start=.4);
	Real e(start=1);
	Real f(start=2);
	Real g(start=3);
	output Real Y;
equation
	(x1,x2,x3,x4) = F(x1,x2,x3,x4);
	der(e) = log(x1*x2+1)*e;
	der(f) = sin(x2*x3+2)*f;
	der(g) = log(x1*x2*x3*x4+3)*g+e+f;
	der(Y) = x1+x2+x3+x4+e+f+g;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADRes3",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_ode_jacobian=true,
            eliminate_alias_variables=false,
            fmi_version="2.0",
            generate_ode=true,
            equation_sorting=true,
            template="
$CAD_ode_derivatives$
$CAD_dae_blocks_residual_functions$
",
            generatedCode="
    /******** Declarations *******/
    jmi_real_t v_0;
    jmi_real_t d_0;
    jmi_real_t v_1;
    jmi_real_t d_1;
    jmi_real_t v_2;
    jmi_real_t d_2;
    jmi_real_t v_3;
    jmi_real_t d_3;
    jmi_real_t v_4;
    jmi_real_t d_4;
    jmi_real_t v_5;
    jmi_real_t d_5;
    jmi_real_t v_6;
    jmi_real_t d_6;
    jmi_real_t v_7;
    jmi_real_t d_7;
    jmi_real_t v_8;
    jmi_real_t d_8;
    jmi_real_t v_9;
    jmi_real_t d_9;
    jmi_real_t v_10;
    jmi_real_t d_10;
    jmi_real_t v_11;
    jmi_real_t d_11;
    jmi_real_t v_12;
    jmi_real_t d_12;
    jmi_real_t v_13;
    jmi_real_t d_13;
    jmi_real_t v_14;
    jmi_real_t d_14;
    jmi_real_t v_15;
    jmi_real_t d_15;
    jmi_real_t v_16;
    jmi_real_t d_16;
    jmi_real_t v_17;
    jmi_real_t d_17;
    jmi_real_t** dz = jmi->dz;
    /*********** ODE section ***********/
    ef |= jmi_ode_unsolved_block_dir_der(jmi, jmi->dae_block_residuals[0]);
    v_2 = _x1_0 * _x2_1;
    d_2 = (*dz)[jmi_get_index_from_value_ref(8)-jmi->offs_real_dx] * _x2_1 + _x1_0 * (*dz)[jmi_get_index_from_value_ref(9)-jmi->offs_real_dx];
    v_1 = v_2 + 1.0;
    d_1 = d_2 + 0.0;
    v_0 = jmi_log_equation(jmi, v_1, \"log(x1 * x2 + 1)\");
    d_0 = d_1 / v_1;
    _der_e_8 = v_0 * _e_4;
    (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = d_0 * _e_4 + v_0 * (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx];
    v_5 = _x2_1 * _x3_2;
    d_5 = (*dz)[jmi_get_index_from_value_ref(9)-jmi->offs_real_dx] * _x3_2 + _x2_1 * (*dz)[jmi_get_index_from_value_ref(10)-jmi->offs_real_dx];
    v_4 = v_5 + 2.0;
    d_4 = d_5 + 0.0;
    v_3 = sin(v_4);
    d_3 = d_4 * cos(v_4);
    _der_f_9 = v_3 * _f_5;
    (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = d_3 * _f_5 + v_3 * (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx];
    v_12 = _x1_0 * _x2_1;
    d_12 = (*dz)[jmi_get_index_from_value_ref(8)-jmi->offs_real_dx] * _x2_1 + _x1_0 * (*dz)[jmi_get_index_from_value_ref(9)-jmi->offs_real_dx];
    v_11 = v_12 * _x3_2;
    d_11 = d_12 * _x3_2 + v_12 * (*dz)[jmi_get_index_from_value_ref(10)-jmi->offs_real_dx];
    v_10 = v_11 * _x4_3;
    d_10 = d_11 * _x4_3 + v_11 * (*dz)[jmi_get_index_from_value_ref(11)-jmi->offs_real_dx];
    v_9 = v_10 + 3.0;
    d_9 = d_10 + 0.0;
    v_8 = jmi_log_equation(jmi, v_9, \"log(x1 * x2 * x3 * x4 + 3)\");
    d_8 = d_9 / v_9;
    v_7 = v_8 * _g_6;
    d_7 = d_8 * _g_6 + v_8 * (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx];
    v_6 = v_7 + _e_4;
    d_6 = d_7 + (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx];
    _der_g_10 = v_6 + _f_5;
    (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] = d_6 + (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx];
    v_14 = _x1_0 + _x2_1;
    d_14 = (*dz)[jmi_get_index_from_value_ref(8)-jmi->offs_real_dx] + (*dz)[jmi_get_index_from_value_ref(9)-jmi->offs_real_dx];
    v_15 = (_x3_2 + _x4_3);
    d_15 = (*dz)[jmi_get_index_from_value_ref(10)-jmi->offs_real_dx] + (*dz)[jmi_get_index_from_value_ref(11)-jmi->offs_real_dx];
    v_13 = v_14 + v_15;
    d_13 = d_14 + d_15;
    v_17 = _e_4 + _f_5;
    d_17 = (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] + (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx];
    v_16 = (v_17 + _g_6);
    d_16 = d_17 + (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx];
    _der_Y_11 = v_13 + v_16;
    (*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx] = d_13 + d_16;
    /*********** Real outputs **********/
    /*** Integer and boolean outputs ***/
    /********* Other variables *********/

static int dae_block_dir_der_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 1 *****/
    JMI_DEF(REA, tmp_var_0)
    JMI_DEF(REA, tmp_der_0)
    JMI_DEF(REA, tmp_var_1)
    JMI_DEF(REA, tmp_der_1)
    JMI_DEF(REA, tmp_var_2)
    JMI_DEF(REA, tmp_der_2)
    JMI_DEF(REA, tmp_var_3)
    JMI_DEF(REA, tmp_der_3)
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        x[0] = _x4_3;
        x[1] = _x3_2;
        x[2] = _x2_1;
        x[3] = _x1_0;
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
        (*dz)[ jmi_get_index_from_value_ref(11)-jmi->offs_real_dx] = dx[0];
        _x4_3 = x[0];
        (*dz)[ jmi_get_index_from_value_ref(10)-jmi->offs_real_dx] = dx[1];
        _x3_2 = x[1];
        (*dz)[ jmi_get_index_from_value_ref(9)-jmi->offs_real_dx] = dx[2];
        _x2_1 = x[2];
        (*dz)[ jmi_get_index_from_value_ref(8)-jmi->offs_real_dx] = dx[3];
        _x1_0 = x[3];
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
        (*dz)[jmi_get_index_from_value_ref(11)-jmi->offs_real_dx] = -(*dF)[0];
        (*dz)[jmi_get_index_from_value_ref(10)-jmi->offs_real_dx] = -(*dF)[1];
        (*dz)[jmi_get_index_from_value_ref(9)-jmi->offs_real_dx] = -(*dF)[2];
        (*dz)[jmi_get_index_from_value_ref(8)-jmi->offs_real_dx] = -(*dF)[3];
    } else {
        return -1;
    }
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
        func_CADCodeGenTests_CADRes3_F_der_AD0(_x1_0, _x2_1, _x3_2, _x4_3, (*dz)[jmi_get_index_from_value_ref(8)-jmi->offs_real_dx], (*dz)[jmi_get_index_from_value_ref(9)-jmi->offs_real_dx], (*dz)[jmi_get_index_from_value_ref(10)-jmi->offs_real_dx], (*dz)[jmi_get_index_from_value_ref(11)-jmi->offs_real_dx], &tmp_var_0, &tmp_var_1, &tmp_var_2, &tmp_var_3, &tmp_der_0, &tmp_der_1, &tmp_der_2, &tmp_der_3);
        (*res)[0] = tmp_var_0 - (_x1_0);
        (*dF)[0] = tmp_der_0 - ((*dz)[jmi_get_index_from_value_ref(8)-jmi->offs_real_dx]);
        (*res)[1] = tmp_var_1 - (_x2_1);
        (*dF)[1] = tmp_der_1 - ((*dz)[jmi_get_index_from_value_ref(9)-jmi->offs_real_dx]);
        (*res)[2] = tmp_var_2 - (_x3_2);
        (*dF)[2] = tmp_der_2 - ((*dz)[jmi_get_index_from_value_ref(10)-jmi->offs_real_dx]);
        (*res)[3] = tmp_var_3 - (_x4_3);
        (*dF)[3] = tmp_der_3 - ((*dz)[jmi_get_index_from_value_ref(11)-jmi->offs_real_dx]);
        (*dz)[jmi_get_index_from_value_ref(11)-jmi->offs_real_dx] = 0;
        (*dz)[jmi_get_index_from_value_ref(10)-jmi->offs_real_dx] = 0;
        (*dz)[jmi_get_index_from_value_ref(9)-jmi->offs_real_dx] = 0;
        (*dz)[jmi_get_index_from_value_ref(8)-jmi->offs_real_dx] = 0;
    }
        JMI_DYNAMIC_FREE()
    return ef;
}
")})));
end CADRes3;

model CADRes4
    Real a;
    Real b;
    Boolean d;
equation
    a = 1 - b;
    a = b * (if d then 1 else 2);
    d = b < 0;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADRes4",
            description="Test cad code gen for mixed unsolved block with discrete variables",
            generate_ode_jacobian=true,
            fmi_version="2.0",
            generate_ode=true,
            equation_sorting=true,
            automatic_tearing=false,
            template="$CAD_dae_blocks_residual_functions$",
            generatedCode="
static int dae_block_dir_der_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 1 *****/
    jmi_real_t v_0;
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        x[0] = _b_1;
        x[1] = _a_0;
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
        (*dz)[ jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = dx[0];
        _b_1 = x[0];
        (*dz)[ jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = dx[1];
        _a_0 = x[1];
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
        (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = -(*dF)[0];
        (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = -(*dF)[1];
    } else {
        return -1;
    }
    _d_2 = _sw(0);
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
        if (_d_2) {
            v_0 = 1.0;
        } else {
            v_0 = 2.0;
        }
        (*res)[0] = _b_1 * v_0 - (_a_0);
        (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * v_0 + _b_1 * 0.0 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
        (*res)[1] = 1.0 - _b_1 - (_a_0);
        (*dF)[1] = 0.0 - (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
        (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = 0;
        (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = 0;
    }
        JMI_DYNAMIC_FREE()
    return ef;
}
")})));
end CADRes4;

model CADRes5
    record R
        Real a1;
        Real a2;
    end R;
    
    function F
        input Real x1;
        input Real x2;
        output R y;
    algorithm
        y.a1 := x2;
        y.a2 := x1 * 2;
    annotation(Inline=false);
    end F;
    Real x = y.a1 + y.a2;
    R y = F(x, 2);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADRes5",
            description="Test cad code gen for function call with FNoExp in left hand side",
            generate_ode_jacobian=true,
            template="$CAD_dae_blocks_residual_functions$",
            generatedCode="
static int dae_block_dir_der_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 1 *****/
    JMI_RECORD_STATIC(R_0_r, tmp_var_0)
    JMI_RECORD_STATIC(R_0_r, tmp_der_0)
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        x[0] = _x_0;
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
        (*dz)[ jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = dx[0];
        _x_0 = x[0];
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
        (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = -(*dF)[0];
    } else {
        return -1;
    }
    func_CADCodeGenTests_CADRes5_F_der_AD0(_x_0, 2.0, (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx], 0.0, tmp_var_0, tmp_der_0);
    _y_a2_2 = tmp_var_0->a2;
    (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] = tmp_der_0->a2;
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
        (*res)[0] = 2.0 + _y_a2_2 - (_x_0);
        (*dF)[0] = 0.0 + (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
        (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = 0;
    }
        JMI_DYNAMIC_FREE()
    return ef;
}
")})));
end CADRes5;

model CADRes6
    record R
        Real a1;
        Real a2;
    end R;
    
    function F1
        input Real x1;
        input Real x2;
        output R y;
    algorithm
        y.a1 := x2;
        y.a2 := x1 * 2;
    annotation(Inline=false);
    end F1;
    
    function F2
        input R x;
        output Real y;
    algorithm
        y := x.a1 + x.a2;
    annotation(Inline=false);
    end F2;
    Real x = sin(y);
    Real y = F2(F1(x, 2));

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADRes6",
            description="Test cad code gen for function call with composite returning function call as agrument",
            generate_ode_jacobian=true,
            template="$CAD_dae_blocks_residual_functions$",
            generatedCode="
static int dae_block_dir_der_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 1 *****/
    jmi_real_t v_0;
    jmi_real_t d_0;
    JMI_RECORD_STATIC(R_0_r, tmp_var_0)
    JMI_RECORD_STATIC(R_0_r, tmp_der_0)
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        x[0] = _y_1;
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
        (*dz)[ jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = dx[0];
        _y_1 = x[0];
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
        (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = -(*dF)[0];
    } else {
        return -1;
    }
    _x_0 = sin(_y_1);
    (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * cos(_y_1);
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
        func_CADCodeGenTests_CADRes6_F1_der_AD1(_x_0, 2.0, (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx], 0.0, tmp_var_0, tmp_der_0);
        func_CADCodeGenTests_CADRes6_F2_der_AD0(tmp_var_0, tmp_der_0, &v_0, &d_0);
        (*res)[0] = v_0 - (_y_1);
        (*dF)[0] = d_0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
        (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = 0;
    }
        JMI_DYNAMIC_FREE()
    return ef;
}

")})));
end CADRes6;

model CADTorn1
  Real x_1(start=1.29533105933);
  output Real w_ode_1_1;
  Real w_ode_1_2;
  input Real ur_1;
  input Real ur_2;
  input Real ur_3;
equation
  w_ode_1_1*20 + (1.30*w_ode_1_2 + sin(w_ode_1_2) ) + (-2.01*x_1 + sin(x_1) ) + (-1.18*x_1) + (1.45*x_1) + (1.09*ur_2 + sin(ur_2) ) + (-1.24*ur_2) + (2.16*ur_3 + sin(ur_3) ) = 0;
  w_ode_1_2*20 + (-2.10*w_ode_1_1 + sin(w_ode_1_1) ) + (1.63*x_1 + sin(x_1) ) + (2.59*x_1 + sin(x_1) ) - (2.05*x_1) = 0;
  der(x_1) = (1.58*w_ode_1_1 + sin(w_ode_1_1) ) + (-2.51*w_ode_1_2 + sin(w_ode_1_2) ) + (2.15*x_1 + sin(x_1) ) - (2.19*x_1 + sin(x_1) ) - (-2.89*x_1) + (2.99*ur_1 + sin(ur_1) ) + (-2.34*ur_3 + sin(ur_3) ) + (-1.23*ur_2);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADTorn1",
            description="",
            variability_propagation=false,
            generate_ode_jacobian=true,
            eliminate_alias_variables=false,
            fmi_version="2.0",
            generate_ode=true,
            equation_sorting=true,
            automatic_tearing=true,
            template="
$CAD_ode_derivatives$
$CAD_dae_blocks_residual_functions$
",
            generatedCode="
    /******** Declarations *******/
    jmi_real_t v_0;
    jmi_real_t d_0;
    jmi_real_t v_1;
    jmi_real_t d_1;
    jmi_real_t v_2;
    jmi_real_t d_2;
    jmi_real_t v_3;
    jmi_real_t d_3;
    jmi_real_t v_4;
    jmi_real_t d_4;
    jmi_real_t v_5;
    jmi_real_t d_5;
    jmi_real_t v_6;
    jmi_real_t d_6;
    jmi_real_t v_7;
    jmi_real_t d_7;
    jmi_real_t v_8;
    jmi_real_t d_8;
    jmi_real_t v_9;
    jmi_real_t d_9;
    jmi_real_t v_10;
    jmi_real_t d_10;
    jmi_real_t v_11;
    jmi_real_t d_11;
    jmi_real_t v_12;
    jmi_real_t d_12;
    jmi_real_t v_13;
    jmi_real_t d_13;
    jmi_real_t v_14;
    jmi_real_t d_14;
    jmi_real_t v_15;
    jmi_real_t d_15;
    jmi_real_t v_16;
    jmi_real_t d_16;
    jmi_real_t v_17;
    jmi_real_t d_17;
    jmi_real_t v_18;
    jmi_real_t d_18;
    jmi_real_t v_19;
    jmi_real_t d_19;
    jmi_real_t v_20;
    jmi_real_t d_20;
    jmi_real_t v_21;
    jmi_real_t d_21;
    jmi_real_t v_22;
    jmi_real_t d_22;
    jmi_real_t v_23;
    jmi_real_t d_23;
    jmi_real_t v_24;
    jmi_real_t d_24;
    jmi_real_t v_25;
    jmi_real_t d_25;
    jmi_real_t v_26;
    jmi_real_t d_26;
    jmi_real_t v_27;
    jmi_real_t d_27;
    jmi_real_t v_28;
    jmi_real_t d_28;
    jmi_real_t** dz = jmi->dz;
    /*********** ODE section ***********/
    ef |= jmi_ode_unsolved_block_dir_der(jmi, jmi->dae_block_residuals[0]);
    v_3 = 1.58 * _w_ode_1_1_1;
    d_3 = 0.0 * _w_ode_1_1_1 + 1.58 * (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx];
    v_4 = sin(_w_ode_1_1_1);
    d_4 = (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx] * cos(_w_ode_1_1_1);
    v_2 = v_3 + v_4;
    d_2 = d_3 + d_4;
    v_6 = -2.51 * _w_ode_1_2_2;
    d_6 = 0.0 * _w_ode_1_2_2 + -2.51 * (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx];
    v_7 = sin(_w_ode_1_2_2);
    d_7 = (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx] * cos(_w_ode_1_2_2);
    v_5 = (v_6 + v_7);
    d_5 = d_6 + d_7;
    v_1 = v_2 + v_5;
    d_1 = d_2 + d_5;
    v_10 = 2.15 * _x_1_0;
    d_10 = 0.0 * _x_1_0 + 2.15 * (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx];
    v_11 = sin(_x_1_0);
    d_11 = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * cos(_x_1_0);
    v_9 = v_10 + v_11;
    d_9 = d_10 + d_11;
    v_13 = 2.19 * _x_1_0;
    d_13 = 0.0 * _x_1_0 + 2.19 * (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx];
    v_12 = (- v_13);
    d_12 = - (d_13);
    v_8 = (v_9 + v_12);
    d_8 = d_9 + d_12;
    v_0 = v_1 + v_8;
    d_0 = d_1 + d_8;
    v_18 = sin(_x_1_0);
    d_18 = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * cos(_x_1_0);
    v_17 = - v_18;
    d_17 = - (d_18);
    v_20 = -2.89 * _x_1_0;
    d_20 = 0.0 * _x_1_0 + -2.89 * (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx];
    v_19 = (- v_20);
    d_19 = - (d_20);
    v_16 = v_17 + v_19;
    d_16 = d_17 + d_19;
    v_22 = 2.99 * _ur_1_3;
    d_22 = 0.0 * _ur_1_3 + 2.99 * (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx];
    v_23 = sin(_ur_1_3);
    d_23 = (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] * cos(_ur_1_3);
    v_21 = (v_22 + v_23);
    d_21 = d_22 + d_23;
    v_15 = v_16 + v_21;
    d_15 = d_16 + d_21;
    v_26 = -2.34 * _ur_3_5;
    d_26 = 0.0 * _ur_3_5 + -2.34 * (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx];
    v_27 = sin(_ur_3_5);
    d_27 = (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] * cos(_ur_3_5);
    v_25 = v_26 + v_27;
    d_25 = d_26 + d_27;
    v_28 = -1.23 * _ur_2_4;
    d_28 = 0.0 * _ur_2_4 + -1.23 * (*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx];
    v_24 = (v_25 + v_28);
    d_24 = d_25 + d_28;
    v_14 = (v_15 + v_24);
    d_14 = d_15 + d_24;
    _der_x_1_6 = v_0 + v_14;
    (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = d_0 + d_14;
    /*********** Real outputs **********/
    /*** Integer and boolean outputs ***/
    /********* Other variables *********/

static int dae_block_dir_der_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 1 *****/
    jmi_real_t v_29;
    jmi_real_t d_29;
    jmi_real_t v_30;
    jmi_real_t d_30;
    jmi_real_t v_31;
    jmi_real_t d_31;
    jmi_real_t v_32;
    jmi_real_t d_32;
    jmi_real_t v_33;
    jmi_real_t d_33;
    jmi_real_t v_34;
    jmi_real_t d_34;
    jmi_real_t v_35;
    jmi_real_t d_35;
    jmi_real_t v_36;
    jmi_real_t d_36;
    jmi_real_t v_37;
    jmi_real_t d_37;
    jmi_real_t v_38;
    jmi_real_t d_38;
    jmi_real_t v_39;
    jmi_real_t d_39;
    jmi_real_t v_40;
    jmi_real_t d_40;
    jmi_real_t v_41;
    jmi_real_t d_41;
    jmi_real_t v_42;
    jmi_real_t d_42;
    jmi_real_t v_43;
    jmi_real_t d_43;
    jmi_real_t v_44;
    jmi_real_t d_44;
    jmi_real_t v_45;
    jmi_real_t d_45;
    jmi_real_t v_46;
    jmi_real_t d_46;
    jmi_real_t v_47;
    jmi_real_t d_47;
    jmi_real_t v_48;
    jmi_real_t d_48;
    jmi_real_t v_49;
    jmi_real_t d_49;
    jmi_real_t v_50;
    jmi_real_t d_50;
    jmi_real_t v_51;
    jmi_real_t d_51;
    jmi_real_t v_52;
    jmi_real_t d_52;
    jmi_real_t v_53;
    jmi_real_t d_53;
    jmi_real_t v_54;
    jmi_real_t d_54;
    jmi_real_t v_55;
    jmi_real_t d_55;
    jmi_real_t v_56;
    jmi_real_t d_56;
    jmi_real_t v_57;
    jmi_real_t d_57;
    jmi_real_t v_58;
    jmi_real_t d_58;
    jmi_real_t v_59;
    jmi_real_t d_59;
    jmi_real_t v_60;
    jmi_real_t d_60;
    jmi_real_t v_61;
    jmi_real_t d_61;
    jmi_real_t v_62;
    jmi_real_t d_62;
    jmi_real_t v_63;
    jmi_real_t d_63;
    jmi_real_t v_64;
    jmi_real_t d_64;
    jmi_real_t v_65;
    jmi_real_t d_65;
    jmi_real_t v_66;
    jmi_real_t d_66;
    jmi_real_t v_67;
    jmi_real_t d_67;
    jmi_real_t v_68;
    jmi_real_t d_68;
    jmi_real_t v_69;
    jmi_real_t d_69;
    jmi_real_t v_70;
    jmi_real_t d_70;
    jmi_real_t v_71;
    jmi_real_t d_71;
    jmi_real_t v_72;
    jmi_real_t d_72;
    jmi_real_t v_73;
    jmi_real_t d_73;
    jmi_real_t v_74;
    jmi_real_t d_74;
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        x[0] = _w_ode_1_2_2;
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
        (*dz)[ jmi_get_index_from_value_ref(6)-jmi->offs_real_dx] = dx[0];
        _w_ode_1_2_2 = x[0];
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
        (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx] = -(*dF)[0];
    } else {
        return -1;
    }
    v_34 = 1.3 * _w_ode_1_2_2;
    d_34 = 0.0 * _w_ode_1_2_2 + 1.3 * (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx];
    v_33 = - v_34;
    d_33 = - (d_34);
    v_36 = sin(_w_ode_1_2_2);
    d_36 = (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx] * cos(_w_ode_1_2_2);
    v_35 = (- v_36);
    d_35 = - (d_36);
    v_32 = v_33 + v_35;
    d_32 = d_33 + d_35;
    v_38 = -2.01 * _x_1_0;
    d_38 = 0.0 * _x_1_0 + -2.01 * (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx];
    v_37 = (- v_38);
    d_37 = - (d_38);
    v_31 = v_32 + v_37;
    d_31 = d_32 + d_37;
    v_42 = sin(_x_1_0);
    d_42 = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * cos(_x_1_0);
    v_41 = - v_42;
    d_41 = - (d_42);
    v_44 = -1.18 * _x_1_0;
    d_44 = 0.0 * _x_1_0 + -1.18 * (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx];
    v_43 = (- v_44);
    d_43 = - (d_44);
    v_40 = v_41 + v_43;
    d_40 = d_41 + d_43;
    v_46 = 1.45 * _x_1_0;
    d_46 = 0.0 * _x_1_0 + 1.45 * (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx];
    v_45 = (- v_46);
    d_45 = - (d_46);
    v_39 = (v_40 + v_45);
    d_39 = d_40 + d_45;
    v_30 = v_31 + v_39;
    d_30 = d_31 + d_39;
    v_51 = 1.09 * _ur_2_4;
    d_51 = 0.0 * _ur_2_4 + 1.09 * (*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx];
    v_50 = - v_51;
    d_50 = - (d_51);
    v_53 = sin(_ur_2_4);
    d_53 = (*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx] * cos(_ur_2_4);
    v_52 = (- v_53);
    d_52 = - (d_53);
    v_49 = v_50 + v_52;
    d_49 = d_50 + d_52;
    v_55 = -1.24 * _ur_2_4;
    d_55 = 0.0 * _ur_2_4 + -1.24 * (*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx];
    v_54 = (- v_55);
    d_54 = - (d_55);
    v_48 = v_49 + v_54;
    d_48 = d_49 + d_54;
    v_58 = 2.16 * _ur_3_5;
    d_58 = 0.0 * _ur_3_5 + 2.16 * (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx];
    v_57 = - v_58;
    d_57 = - (d_58);
    v_60 = sin(_ur_3_5);
    d_60 = (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] * cos(_ur_3_5);
    v_59 = (- v_60);
    d_59 = - (d_60);
    v_56 = (v_57 + v_59);
    d_56 = d_57 + d_59;
    v_47 = (v_48 + v_56);
    d_47 = d_48 + d_56;
    v_29 = (v_30 + v_47);
    d_29 = d_30 + d_47;
    _w_ode_1_1_1 = v_29 / 20.0;
    (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx] = (d_29 * 20.0 - v_29 * 0.0) / (20.0 * 20.0);
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
        v_64 = _w_ode_1_2_2 * 20.0;
        d_64 = (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx] * 20.0 + _w_ode_1_2_2 * 0.0;
        v_66 = -2.1 * _w_ode_1_1_1;
        d_66 = 0.0 * _w_ode_1_1_1 + -2.1 * (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx];
        v_67 = sin(_w_ode_1_1_1);
        d_67 = (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx] * cos(_w_ode_1_1_1);
        v_65 = (v_66 + v_67);
        d_65 = d_66 + d_67;
        v_63 = v_64 + v_65;
        d_63 = d_64 + d_65;
        v_69 = 1.63 * _x_1_0;
        d_69 = 0.0 * _x_1_0 + 1.63 * (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx];
        v_70 = sin(_x_1_0);
        d_70 = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * cos(_x_1_0);
        v_68 = (v_69 + v_70);
        d_68 = d_69 + d_70;
        v_62 = v_63 + v_68;
        d_62 = d_63 + d_68;
        v_72 = 2.59 * _x_1_0;
        d_72 = 0.0 * _x_1_0 + 2.59 * (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx];
        v_73 = sin(_x_1_0);
        d_73 = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * cos(_x_1_0);
        v_71 = (v_72 + v_73);
        d_71 = d_72 + d_73;
        v_61 = v_62 + v_71;
        d_61 = d_62 + d_71;
        v_74 = 2.05 * _x_1_0;
        d_74 = 0.0 * _x_1_0 + 2.05 * (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx];
        (*res)[0] = 0.0 - (v_61 - v_74);
        (*dF)[0] = 0.0 - (d_61 - d_74);
        (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx] = 0;
    }
        JMI_DYNAMIC_FREE()
    return ef;
}
")})));
end CADTorn1;

model CADOde1
	function F
		input Real x1;
		input Real x2;
		input Real x3;
		input Real x4;
		output Real a;
		output Real b;
		output Real c;
		output Real d;
	algorithm
		a := sin(x1);
		b := cos(x1);
		c := tan(x2);
		d := sin(x3);
	end F;
	Real x1(start=.1);
	Real x2(start=.2);
	Real x3(start=.3);
	Real x4(start=.4);
	Real e(start=1);
	Real f(start=2);
	Real g(start=3);
	output Real Y;
equation
	(e,f,g,Y) = F(x1,x2,x3,x4);
	der(x1) = sin(2+1);
	der(x2) = cos(x1*x3+2)*5;
	der(x3) = tanh(x1*x2*5*x4+3);
	der(x4) = 1;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADOde1",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_ode_jacobian=true,
            eliminate_alias_variables=false,
            fmi_version="2.0",
            generate_ode=true,
            equation_sorting=true,
            template="$CAD_ode_derivatives$",
            generatedCode="
    /******** Declarations *******/
    jmi_real_t v_0;
    jmi_real_t v_1;
    jmi_real_t d_1;
    jmi_real_t v_2;
    jmi_real_t d_2;
    jmi_real_t v_3;
    jmi_real_t d_3;
    jmi_real_t v_4;
    jmi_real_t v_5;
    jmi_real_t d_5;
    jmi_real_t v_6;
    jmi_real_t d_6;
    jmi_real_t v_7;
    jmi_real_t d_7;
    jmi_real_t v_8;
    jmi_real_t d_8;
    JMI_DEF(REA, tmp_var_0)
    JMI_DEF(REA, tmp_der_0)
    JMI_DEF(REA, tmp_var_1)
    JMI_DEF(REA, tmp_der_1)
    JMI_DEF(REA, tmp_var_2)
    JMI_DEF(REA, tmp_der_2)
    JMI_DEF(REA, tmp_var_3)
    JMI_DEF(REA, tmp_der_3)
    jmi_real_t** dz = jmi->dz;
    /*********** ODE section ***********/
    v_0 = 2.0 + 1.0;
    _der_x1_8 = sin(v_0);
    (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = 0.0;
    v_3 = _x1_0 * _x3_2;
    d_3 = (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] * _x3_2 + _x1_0 * (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx];
    v_2 = v_3 + 2.0;
    d_2 = d_3 + 0.0;
    v_1 = cos(v_2);
    d_1 = d_2 * -sin(v_2);
    _der_x2_9 = v_1 * 5.0;
    (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = d_1 * 5.0 + v_1 * 0.0;
    v_8 = _x1_0 * _x2_1;
    d_8 = (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] * _x2_1 + _x1_0 * (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx];
    v_7 = v_8 * 5.0;
    d_7 = d_8 * 5.0 + v_8 * 0.0;
    v_6 = v_7 * _x4_3;
    d_6 = d_7 * _x4_3 + v_7 * (*dz)[jmi_get_index_from_value_ref(7)-jmi->offs_real_dx];
    v_5 = v_6 + 3.0;
    d_5 = d_6 + 0.0;
    v_4 = tanh(v_5);
    _der_x3_10 = v_4;
    (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] = d_5 * (1 - v_4 * v_4);
    _der_x4_11 = 1.0;
    (*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx] = 0.0;
    /*********** Real outputs **********/
    func_CADCodeGenTests_CADOde1_F_der_AD0(_x1_0, _x2_1, _x3_2, _x4_3, (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx], (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx], (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx], (*dz)[jmi_get_index_from_value_ref(7)-jmi->offs_real_dx], &tmp_var_0, &tmp_var_1, &tmp_var_2, &tmp_var_3, &tmp_der_0, &tmp_der_1, &tmp_der_2, &tmp_der_3);
    _e_4 = tmp_var_0;
    (*dz)[jmi_get_index_from_value_ref(8)-jmi->offs_real_dx] = tmp_der_0;
    _f_5 = tmp_var_1;
    (*dz)[jmi_get_index_from_value_ref(9)-jmi->offs_real_dx] = tmp_der_1;
    _g_6 = tmp_var_2;
    (*dz)[jmi_get_index_from_value_ref(10)-jmi->offs_real_dx] = tmp_der_2;
    _Y_7 = tmp_var_3;
    (*dz)[jmi_get_index_from_value_ref(11)-jmi->offs_real_dx] = tmp_der_3;
    /*** Integer and boolean outputs ***/
    /********* Other variables *********/
")})));
end CADOde1;

model CADOde2
    function F
            input Real x1;
            input Real x2;
            input Real x3;
            input Real x4;
            output Real a;
            output Real b;
            output Real c;
            output Real d;
        algorithm
            a := sin(x1);
            b := cos(x1);
            c := tan(x2);
            d := sin(x3);
        end F;
        Real x1(start=.1);
        Real x2(start=.2);
        Real x3(start=.3);
        Real x4(start=.4);
        Real e(start=1);
        Real f(start=2);
        Real g(start=3);
        output Real Y;
    equation
        (e,f,g,Y) = F(x1,x2,x3,x4);
        der(x1) = sin(2+1);
        der(x2) = cos(x1*x3+2)*5;
        der(x3) = tanh(x1*x2*5*x4+3);
        der(x4) = 1;


    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADOde2",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_ode_jacobian=true,
            eliminate_alias_variables=false,
            fmi_version="2.0",
            generate_ode=true,
            equation_sorting=true,
            generate_only_initial_system=true,
            template="$CAD_ode_derivatives$",
            generatedCode=""
 )})));
end CADOde2;

model CADExpInFuncArg1
	function f
		input Real x;
		output Real y1;
		output Real y2;
	algorithm
		(y1,y2) := f3(x+100,x^2);
	end f;

	function f1
		input Real x;
		output Real y;
	algorithm
		y := f2(sin(x))^(-2);
	end f1;


	function f2
		input Real x;
		output Real y;
	algorithm
		y := x^(-3);
	end f2;
	
	function f3
		input Real x1;
		input Real x2;
		output Real y1;
		output Real y2;
	algorithm
		y1 := x1^(-3);
		y2 := x2^(-5);
	end f3;

	Real x1(start=.1),x2(start=.2);
	Real u1,u2;
	Real v1,v2;
equation
	der(x1) = f(sin(x2));
	der(x2) = f1(x1);
	(u1,u2) = f(sin(x1));
	der(v1) = u1;
	der(v2) = u2;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADExpInFuncArg1",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_ode_jacobian=true,
            template="
$CAD_function_headers$
$CAD_functions$
",
            generatedCode="
void func_CADCodeGenTests_CADExpInFuncArg1_f_der_AD0(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* y1_var_o, jmi_real_t* y2_var_o, jmi_real_t* y1_der_o, jmi_real_t* y2_der_o);
void func_CADCodeGenTests_CADExpInFuncArg1_f3_der_AD1(jmi_real_t x1_var_v, jmi_real_t x2_var_v, jmi_real_t x1_der_v, jmi_real_t x2_der_v, jmi_real_t* y1_var_o, jmi_real_t* y2_var_o, jmi_real_t* y1_der_o, jmi_real_t* y2_der_o);
void func_CADCodeGenTests_CADExpInFuncArg1_f1_der_AD2(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o);
void func_CADCodeGenTests_CADExpInFuncArg1_f2_der_AD3(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o);

void func_CADCodeGenTests_CADExpInFuncArg1_f_der_AD0(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* y1_var_o, jmi_real_t* y2_var_o, jmi_real_t* y1_der_o, jmi_real_t* y2_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y1_var_v)
    JMI_DEF(REA, y1_der_v)
    JMI_DEF(REA, y2_var_v)
    JMI_DEF(REA, y2_der_v)
    jmi_real_t v_0;
    jmi_real_t d_0;
    jmi_real_t v_1;
    jmi_real_t d_1;
    v_0 = x_var_v + 100.0;
    d_0 = x_der_v + 0.0;
    v_1 = (1.0 * (x_var_v) * (x_var_v));
    d_1 = x_var_v == 0 ? 0 : (v_1 * (0.0 * log(jmi_abs(x_var_v)) + 2.0 * x_der_v / x_var_v));
    func_CADCodeGenTests_CADExpInFuncArg1_f3_der_AD1(v_0, v_1, d_0, d_1, &y1_var_v, &y2_var_v, &y1_der_v, &y2_der_v);
    if (y1_var_o != NULL) *y1_var_o = y1_var_v;
    if (y1_der_o != NULL) *y1_der_o = y1_der_v;
    if (y2_var_o != NULL) *y2_var_o = y2_var_v;
    if (y2_der_o != NULL) *y2_der_o = y2_der_v;
    JMI_DYNAMIC_FREE()
    return;
}

void func_CADCodeGenTests_CADExpInFuncArg1_f3_der_AD1(jmi_real_t x1_var_v, jmi_real_t x2_var_v, jmi_real_t x1_der_v, jmi_real_t x2_der_v, jmi_real_t* y1_var_o, jmi_real_t* y2_var_o, jmi_real_t* y1_der_o, jmi_real_t* y2_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y1_var_v)
    JMI_DEF(REA, y1_der_v)
    JMI_DEF(REA, y2_var_v)
    JMI_DEF(REA, y2_der_v)
    jmi_real_t v_2;
    jmi_real_t v_3;
    v_2 = (1.0 / (x1_var_v) / (x1_var_v) / (x1_var_v));
    y1_var_v = v_2;
    y1_der_v = x1_var_v == 0 ? 0 : (v_2 * (0.0 * log(jmi_abs(x1_var_v)) + -3.0 * x1_der_v / x1_var_v));
    v_3 = (1.0 / (x2_var_v) / (x2_var_v) / (x2_var_v) / (x2_var_v) / (x2_var_v));
    y2_var_v = v_3;
    y2_der_v = x2_var_v == 0 ? 0 : (v_3 * (0.0 * log(jmi_abs(x2_var_v)) + -5.0 * x2_der_v / x2_var_v));
    if (y1_var_o != NULL) *y1_var_o = y1_var_v;
    if (y1_der_o != NULL) *y1_der_o = y1_der_v;
    if (y2_var_o != NULL) *y2_var_o = y2_var_v;
    if (y2_der_o != NULL) *y2_der_o = y2_der_v;
    JMI_DYNAMIC_FREE()
    return;
}

void func_CADCodeGenTests_CADExpInFuncArg1_f1_der_AD2(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    jmi_real_t v_4;
    jmi_real_t v_5;
    jmi_real_t d_5;
    jmi_real_t v_6;
    jmi_real_t d_6;
    v_6 = sin(x_var_v);
    d_6 = x_der_v * cos(x_var_v);
    func_CADCodeGenTests_CADExpInFuncArg1_f2_der_AD3(v_6, d_6, &v_5, &d_5);
    v_4 = (1.0 / (v_5) / (v_5));
    y_var_v = v_4;
    y_der_v = v_5 == 0 ? 0 : (v_4 * (0.0 * log(jmi_abs(v_5)) + -2.0 * d_5 / v_5));
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}

void func_CADCodeGenTests_CADExpInFuncArg1_f2_der_AD3(jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* y_var_o, jmi_real_t* y_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, y_var_v)
    JMI_DEF(REA, y_der_v)
    jmi_real_t v_7;
    v_7 = (1.0 / (x_var_v) / (x_var_v) / (x_var_v));
    y_var_v = v_7;
    y_der_v = x_var_v == 0 ? 0 : (v_7 * (0.0 * log(jmi_abs(x_var_v)) + -3.0 * x_der_v / x_var_v));
    if (y_var_o != NULL) *y_var_o = y_var_v;
    if (y_der_o != NULL) *y_der_o = y_der_v;
    JMI_DYNAMIC_FREE()
    return;
}
")})));
end CADExpInFuncArg1;


model TestLiteralFuncArg1
	function F
		input Real x;
		input Real y;
		input Integer i;
		output Real z;
	algorithm
		z := x ^ y + i;
	end F;
	Real x;
	Integer i=2;
equation
	der(x) = F(x, 2.0, 1);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="TestLiteralFuncArg1",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_ode_jacobian=true,
            template="
$CAD_function_headers$
$CAD_functions$
",
            generatedCode="
void func_CADCodeGenTests_TestLiteralFuncArg1_F_der_AD0(jmi_real_t x_var_v, jmi_real_t y_var_v, jmi_real_t i_v, jmi_real_t x_der_v, jmi_real_t y_der_v, jmi_real_t* z_var_o, jmi_real_t* z_der_o);

void func_CADCodeGenTests_TestLiteralFuncArg1_F_der_AD0(jmi_real_t x_var_v, jmi_real_t y_var_v, jmi_real_t i_v, jmi_real_t x_der_v, jmi_real_t y_der_v, jmi_real_t* z_var_o, jmi_real_t* z_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, z_var_v)
    JMI_DEF(REA, z_der_v)
    jmi_real_t v_0;
    jmi_real_t d_0;
    v_0 = jmi_pow_function(\"CADCodeGenTests.TestLiteralFuncArg1.F\", x_var_v,y_var_v,\"x ^ y\");
    d_0 = x_var_v == 0 ? 0 : (v_0 * (y_der_v * log(jmi_abs(x_var_v)) + y_var_v * x_der_v / x_var_v));
    z_var_v = v_0 + i_v;
    z_der_v = d_0 + 0.0;
    if (z_var_o != NULL) *z_var_o = z_var_v;
    if (z_der_o != NULL) *z_der_o = z_der_v;
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end TestLiteralFuncArg1;

model CADRecord1
	record Complex 
		Real re;
		Real im;
	end Complex;
	
	function add
		input Complex u, v;
		output Complex w;
	algorithm
		w := Complex(u.re - v.re,u.im - v.re);
	end add;
	Complex c1, c2;
	Real x(start=10);
	Real y(start=2);
equation
	c1 = Complex(re = cos(y+time),im = 2.0);
	c2 = add(c1,Complex(4, time)); 
	y  = c1.re+0.1;
	der(x) = x*y;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADRecord1",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_ode_jacobian=true,
            eliminate_alias_variables=false,
            automatic_tearing=false,
            fmi_version="2.0",
            generate_ode=true,
            equation_sorting=true,
            template="
$CAD_ode_derivatives$
$CAD_dae_blocks_residual_functions$
$CAD_functions$
",
            generatedCode="
    /******** Declarations *******/
    JMI_RECORD_STATIC(Complex_0_r, tmp_var_0)
    JMI_RECORD_STATIC(Complex_0_r, tmp_der_0)
    JMI_RECORD_STATIC(Complex_0_r, tmp_var_1)
    JMI_RECORD_STATIC(Complex_0_r, tmp_der_1)
    JMI_RECORD_STATIC(Complex_0_r, tmp_var_2)
    JMI_RECORD_STATIC(Complex_0_r, tmp_der_2)
    jmi_real_t** dz = jmi->dz;
    /*********** ODE section ***********/
    ef |= jmi_ode_unsolved_block_dir_der(jmi, jmi->dae_block_residuals[0]);
    _der_x_6 = _x_4 * _y_5;
    (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * _y_5 + _x_4 * (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx];
    /*********** Real outputs **********/
    /*** Integer and boolean outputs ***/
    /********* Other variables *********/
    _c1_im_1 = 2.0;
    (*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx] = 0.0;
    tmp_var_1->re = _c1_re_0;
    tmp_var_1->im = _c1_im_1;
    tmp_der_1->re = (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx];
    tmp_der_1->im = (*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx];
    tmp_var_2->re = 4.0;
    tmp_var_2->im = _time;
    tmp_der_2->re = 0.0;
    tmp_der_2->im = (*dz)[jmi->offs_t];
    func_CADCodeGenTests_CADRecord1_add_der_AD0(tmp_var_1, tmp_var_2, tmp_der_1, tmp_der_2, tmp_var_0, tmp_der_0);
    _c2_re_2 = tmp_var_0->re;
    _c2_im_3 = tmp_var_0->im;
    (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] = tmp_der_0->re;
    (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx] = tmp_der_0->im;

static int dae_block_dir_der_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 1 *****/
    jmi_real_t v_0;
    jmi_real_t d_0;
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        x[0] = _y_5;
        x[1] = _c1_re_0;
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
        (*dz)[ jmi_get_index_from_value_ref(6)-jmi->offs_real_dx] = dx[0];
        _y_5 = x[0];
        (*dz)[ jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] = dx[1];
        _c1_re_0 = x[1];
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
        (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx] = -(*dF)[0];
        (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] = -(*dF)[1];
    } else {
        return -1;
    }
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
        (*res)[0] = _c1_re_0 + 0.1 - (_y_5);
        (*dF)[0] = (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] + 0.0 - ((*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx]);
        v_0 = _y_5 + _time;
        d_0 = (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx] + (*dz)[jmi->offs_t];
        (*res)[1] = cos(v_0) - (_c1_re_0);
        (*dF)[1] = d_0 * -sin(v_0) - ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]);
        (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx] = 0;
        (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] = 0;
    }
        JMI_DYNAMIC_FREE()
    return ef;
}


void func_CADCodeGenTests_CADRecord1_add_der_AD0(Complex_0_r* u_var_v, Complex_0_r* v_var_v, Complex_0_r* u_der_v, Complex_0_r* v_der_v, Complex_0_r* w_var_v, Complex_0_r* w_der_v) {
    JMI_DYNAMIC_INIT()
    JMI_RECORD_STATIC(Complex_0_r, w_var_vn)
    JMI_RECORD_STATIC(Complex_0_r, w_der_vn)
    if (w_var_v == NULL) {
        w_var_v = w_var_vn;
    }
    if (w_der_v == NULL) {
        w_der_v = w_der_vn;
    }
    w_var_v->re = u_var_v->re - v_var_v->re;
    w_der_v->re = u_der_v->re - v_der_v->re;
    w_var_v->im = u_var_v->im - v_var_v->re;
    w_der_v->im = u_der_v->im - v_der_v->re;
    JMI_DYNAMIC_FREE()
    return;
}
")})));
end CADRecord1;

model CADTornRecord1
	record R
		Real x,y;
	end R;
	function f
		input Real i;
		output R o;
	algorithm
		o.x := i;
		o.y := i;
	end f;
	R r;
equation
	r = f(r.x);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADTornRecord1",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_block_jacobian=true,
            fmi_version="2.0",
            generate_ode=true,
            equation_sorting=true,
            automatic_tearing=true,
            template="$CAD_dae_blocks_residual_functions$",
            generatedCode="
static int dae_block_dir_der_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 1 *****/
    JMI_RECORD_STATIC(R_0_r, tmp_var_0)
    JMI_RECORD_STATIC(R_0_r, tmp_der_0)
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        x[0] = _r_x_0;
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
        (*dz)[ jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = dx[0];
        _r_x_0 = x[0];
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
        (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = -(*dF)[0];
    } else {
        return -1;
    }
    func_CADCodeGenTests_CADTornRecord1_f_der_AD0(_r_x_0, (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx], tmp_var_0, tmp_der_0);
    _r_y_1 = tmp_var_0->y;
    (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = tmp_der_0->y;
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
        (*res)[0] = tmp_var_0->x - (_r_x_0);
        (*dF)[0] = tmp_der_0->x - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
        (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = 0;
    }
        JMI_DYNAMIC_FREE()
    return ef;
}

")})));
end CADTornRecord1;

model CADTornRecord2
	function F
		input Real a;
		input Real b;
		output Real c;
		output Real d;
	algorithm
		c := a + b;
		d := c - a;
	end F;
	Real x,y;
	
	constant Real c1 = 23;
equation
	(c1, c1) = F(x,y);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADTornRecord2",
            description="",
            inline_functions="none",
            generate_block_jacobian=true,
            fmi_version="2.0",
            generate_ode=true,
            equation_sorting=true,
            automatic_tearing=true,
            template="$CAD_dae_blocks_residual_functions$",
            generatedCode="
static int dae_block_dir_der_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 1 *****/
    JMI_DEF(REA, tmp_var_0)
    JMI_DEF(REA, tmp_der_0)
    JMI_DEF(REA, tmp_var_1)
    JMI_DEF(REA, tmp_der_1)
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        x[0] = _y_1;
        x[1] = _x_0;
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
        (*dz)[ jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] = dx[0];
        _y_1 = x[0];
        (*dz)[ jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = dx[1];
        _x_0 = x[1];
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
        (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] = -(*dF)[0];
        (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = -(*dF)[1];
    } else {
        return -1;
    }
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
        func_CADCodeGenTests_CADTornRecord2_F_der_AD0(_x_0, _y_1, (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx], (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx], &tmp_var_0, &tmp_var_1, &tmp_der_0, &tmp_der_1);
        (*res)[0] = tmp_var_0 - (_c1_2);
        (*res)[1] = tmp_var_1 - (_c1_2);
        (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] = 0;
        (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = 0;
    }
        JMI_DYNAMIC_FREE()
    return ef;
}

")})));
end CADTornRecord2;

model CADArray1
	Real A[2,2] (start={{1,2},{4,5}});
	Real X[2,2] = {{0,0},{0,0}};
	Real dx[1,2] (start={{4,5}});
	function f
		input  Real A[2,2];
		input  Real X[2,2];
		output Real B[2,2];
	algorithm
		B := A-X;
	end f;
equation
	A       = f(A,X);
	der(dx) = dx*A;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADArray1",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_ode_jacobian=true,
            eliminate_alias_variables=false,
            automatic_tearing=false,
            fmi_version="2.0",
            generate_ode=true,
            equation_sorting=true,
            template="
$CAD_ode_derivatives$
$CAD_dae_blocks_residual_functions$
$CAD_functions$
",
            generatedCode="
    /******** Declarations *******/
    jmi_real_t v_0;
    jmi_real_t d_0;
    jmi_real_t v_1;
    jmi_real_t d_1;
    jmi_real_t v_2;
    jmi_real_t d_2;
    jmi_real_t v_3;
    jmi_real_t d_3;
    jmi_real_t** dz = jmi->dz;
    /*********** ODE section ***********/
    _X_1_1_4 = 0.0;
    (*dz)[jmi_get_index_from_value_ref(8)-jmi->offs_real_dx] = 0.0;
    _X_1_2_5 = 0.0;
    (*dz)[jmi_get_index_from_value_ref(9)-jmi->offs_real_dx] = 0.0;
    _X_2_1_6 = 0.0;
    (*dz)[jmi_get_index_from_value_ref(10)-jmi->offs_real_dx] = 0.0;
    _X_2_2_7 = 0.0;
    (*dz)[jmi_get_index_from_value_ref(11)-jmi->offs_real_dx] = 0.0;
    ef |= jmi_ode_unsolved_block_dir_der(jmi, jmi->dae_block_residuals[0]);
    v_0 = _dx_1_1_8 * _A_1_1_0;
    d_0 = (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] * _A_1_1_0 + _dx_1_1_8 * (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx];
    v_1 = _dx_1_2_9 * _A_2_1_2;
    d_1 = (*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx] * _A_2_1_2 + _dx_1_2_9 * (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx];
    _der_dx_1_1_10 = v_0 + v_1;
    (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = d_0 + d_1;
    v_2 = _dx_1_1_8 * _A_1_2_1;
    d_2 = (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] * _A_1_2_1 + _dx_1_1_8 * (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx];
    v_3 = _dx_1_2_9 * _A_2_2_3;
    d_3 = (*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx] * _A_2_2_3 + _dx_1_2_9 * (*dz)[jmi_get_index_from_value_ref(7)-jmi->offs_real_dx];
    _der_dx_1_2_11 = v_2 + v_3;
    (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = d_2 + d_3;
    /*********** Real outputs **********/
    /*** Integer and boolean outputs ***/
    /********* Other variables *********/

static int dae_block_dir_der_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 1 *****/
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_0, 4, 2)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_0, 4, 2)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_1, 4, 2)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_1, 4, 2)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_2, 4, 2)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_2, 4, 2)
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        x[0] = _A_2_2_3;
        x[1] = _A_2_1_2;
        x[2] = _A_1_2_1;
        x[3] = _A_1_1_0;
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
        (*dz)[ jmi_get_index_from_value_ref(7)-jmi->offs_real_dx] = dx[0];
        _A_2_2_3 = x[0];
        (*dz)[ jmi_get_index_from_value_ref(6)-jmi->offs_real_dx] = dx[1];
        _A_2_1_2 = x[1];
        (*dz)[ jmi_get_index_from_value_ref(5)-jmi->offs_real_dx] = dx[2];
        _A_1_2_1 = x[2];
        (*dz)[ jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] = dx[3];
        _A_1_1_0 = x[3];
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
        (*dz)[jmi_get_index_from_value_ref(7)-jmi->offs_real_dx] = -(*dF)[0];
        (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx] = -(*dF)[1];
        (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx] = -(*dF)[2];
        (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] = -(*dF)[3];
    } else {
        return -1;
    }
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
        JMI_ARRAY_INIT_2(STAT, jmi_real_t, jmi_array_t, tmp_var_0, 4, 2, 2, 2)
        JMI_ARRAY_INIT_2(STAT, jmi_real_t, jmi_array_t, tmp_der_0, 4, 2, 2, 2)
        JMI_ARRAY_INIT_2(STAT, jmi_real_t, jmi_array_t, tmp_var_1, 4, 2, 2, 2)
        JMI_ARRAY_INIT_2(STAT, jmi_real_t, jmi_array_t, tmp_der_1, 4, 2, 2, 2)
        jmi_array_ref_2(tmp_var_1, 1,1) = _A_1_1_0;
        jmi_array_ref_2(tmp_var_1, 1,2) = _A_1_2_1;
        jmi_array_ref_2(tmp_var_1, 2,1) = _A_2_1_2;
        jmi_array_ref_2(tmp_var_1, 2,2) = _A_2_2_3;
        jmi_array_ref_2(tmp_der_1, 1,1) = (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx];
        jmi_array_ref_2(tmp_der_1, 1,2) = (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx];
        jmi_array_ref_2(tmp_der_1, 2,1) = (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx];
        jmi_array_ref_2(tmp_der_1, 2,2) = (*dz)[jmi_get_index_from_value_ref(7)-jmi->offs_real_dx];
        JMI_ARRAY_INIT_2(STAT, jmi_real_t, jmi_array_t, tmp_var_2, 4, 2, 2, 2)
        JMI_ARRAY_INIT_2(STAT, jmi_real_t, jmi_array_t, tmp_der_2, 4, 2, 2, 2)
        jmi_array_ref_2(tmp_var_2, 1,1) = _X_1_1_4;
        jmi_array_ref_2(tmp_var_2, 1,2) = _X_1_2_5;
        jmi_array_ref_2(tmp_var_2, 2,1) = _X_2_1_6;
        jmi_array_ref_2(tmp_var_2, 2,2) = _X_2_2_7;
        jmi_array_ref_2(tmp_der_2, 1,1) = (*dz)[jmi_get_index_from_value_ref(8)-jmi->offs_real_dx];
        jmi_array_ref_2(tmp_der_2, 1,2) = (*dz)[jmi_get_index_from_value_ref(9)-jmi->offs_real_dx];
        jmi_array_ref_2(tmp_der_2, 2,1) = (*dz)[jmi_get_index_from_value_ref(10)-jmi->offs_real_dx];
        jmi_array_ref_2(tmp_der_2, 2,2) = (*dz)[jmi_get_index_from_value_ref(11)-jmi->offs_real_dx];
        func_CADCodeGenTests_CADArray1_f_der_AD0(tmp_var_1, tmp_var_2, tmp_der_1, tmp_der_2, tmp_var_0, tmp_der_0);
        (*res)[0] = jmi_array_val_2(tmp_var_0, 1,1) - (_A_1_1_0);
        (*res)[1] = jmi_array_val_2(tmp_var_0, 1,2) - (_A_1_2_1);
        (*res)[2] = jmi_array_val_2(tmp_var_0, 2,1) - (_A_2_1_2);
        (*res)[3] = jmi_array_val_2(tmp_var_0, 2,2) - (_A_2_2_3);
        (*dF)[0] = jmi_array_val_2(tmp_der_0, 1,1) - ((*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx]);
        (*dF)[1] = jmi_array_val_2(tmp_der_0, 1,2) - ((*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx]);
        (*dF)[2] = jmi_array_val_2(tmp_der_0, 2,1) - ((*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx]);
        (*dF)[3] = jmi_array_val_2(tmp_der_0, 2,2) - ((*dz)[jmi_get_index_from_value_ref(7)-jmi->offs_real_dx]);
        (*dz)[jmi_get_index_from_value_ref(7)-jmi->offs_real_dx] = 0;
        (*dz)[jmi_get_index_from_value_ref(6)-jmi->offs_real_dx] = 0;
        (*dz)[jmi_get_index_from_value_ref(5)-jmi->offs_real_dx] = 0;
        (*dz)[jmi_get_index_from_value_ref(4)-jmi->offs_real_dx] = 0;
    }
        JMI_DYNAMIC_FREE()
    return ef;
}


void func_CADCodeGenTests_CADArray1_f_der_AD0(jmi_array_t* A_var_a, jmi_array_t* X_var_a, jmi_array_t* A_der_a, jmi_array_t* X_der_a, jmi_array_t* B_var_a, jmi_array_t* B_der_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, B_var_an, 4, 2)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, B_der_an, 4, 2)
    if (B_var_a == NULL) {
        JMI_ARRAY_INIT_2(STAT, jmi_real_t, jmi_array_t, B_var_an, 4, 2, 2, 2)
        B_var_a = B_var_an;
    }
    if (B_der_a == NULL) {
        JMI_ARRAY_INIT_2(STAT, jmi_real_t, jmi_array_t, B_der_an, 4, 2, 2, 2)
        B_der_a = B_der_an;
    }
    jmi_array_ref_2(B_var_a, 1.0, 1.0) = jmi_array_val_2(A_var_a, 1.0, 1.0) - jmi_array_val_2(X_var_a, 1.0, 1.0);
    jmi_array_ref_2(B_der_a, 1.0, 1.0) = jmi_array_val_2(A_der_a, 1.0, 1.0) - jmi_array_val_2(X_der_a, 1.0, 1.0);
    jmi_array_ref_2(B_var_a, 1.0, 2.0) = jmi_array_val_2(A_var_a, 1.0, 2.0) - jmi_array_val_2(X_var_a, 1.0, 2.0);
    jmi_array_ref_2(B_der_a, 1.0, 2.0) = jmi_array_val_2(A_der_a, 1.0, 2.0) - jmi_array_val_2(X_der_a, 1.0, 2.0);
    jmi_array_ref_2(B_var_a, 2.0, 1.0) = jmi_array_val_2(A_var_a, 2.0, 1.0) - jmi_array_val_2(X_var_a, 2.0, 1.0);
    jmi_array_ref_2(B_der_a, 2.0, 1.0) = jmi_array_val_2(A_der_a, 2.0, 1.0) - jmi_array_val_2(X_der_a, 2.0, 1.0);
    jmi_array_ref_2(B_var_a, 2.0, 2.0) = jmi_array_val_2(A_var_a, 2.0, 2.0) - jmi_array_val_2(X_var_a, 2.0, 2.0);
    jmi_array_ref_2(B_der_a, 2.0, 2.0) = jmi_array_val_2(A_der_a, 2.0, 2.0) - jmi_array_val_2(X_der_a, 2.0, 2.0);
    JMI_DYNAMIC_FREE()
    return;
}
")})));
end CADArray1;

model CADTornArray1
	function f
		input Real i;
		output Real o[2];
	algorithm
		o[1] := i;
		o[2] := i + o[1];
	end f;
	Real x[2];
equation
	x = f(x[1]);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="CADTornArray1",
            description="",
            variability_propagation=false,
            inline_functions="none",
            generate_block_jacobian=true,
            fmi_version="2.0",
            generate_ode=true,
            equation_sorting=true,
            automatic_tearing=true,
            template="$CAD_dae_blocks_residual_functions$",
            generatedCode="
static int dae_block_dir_der_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 1 *****/
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_0, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_0, 2, 1)
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        x[0] = _x_1_0;
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
        (*dz)[ jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = dx[0];
        _x_1_0 = x[0];
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
        (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = -(*dF)[0];
    } else {
        return -1;
    }
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_var_0, 2, 1, 2)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_der_0, 2, 1, 2)
    func_CADCodeGenTests_CADTornArray1_f_der_AD0(_x_1_0, (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx], tmp_var_0, tmp_der_0);
    _x_2_1 = jmi_array_val_1(tmp_var_0, 2);
    (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = jmi_array_val_1(tmp_der_0, 2);
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
        (*res)[0] = jmi_array_val_1(tmp_var_0, 1) - (_x_1_0);
        (*dF)[0] = jmi_array_val_1(tmp_der_0, 1) - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
        (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = 0;
    }
        JMI_DYNAMIC_FREE()
    return ef;
}

")})));
end CADTornArray1;

model SparseJacTest1
 parameter Real p1=2;
 parameter Integer p2 = 1;
 parameter Boolean p3 = false;
 Real x[3]; 
 Real x2[2];
 Real y[3];
 Real y2;
 input Real u[3];
 input Real u2[2];
equation
 der(x2) = -x2;
 der(x) = x + y + u;
 y = {1,2,3};
 y2 = sum(u2);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="SparseJacTest1",
            description="Test that sparsity information is generated correctly",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            template="$C_DAE_equation_sparsity$",
            generatedCode="
static const int CAD_dae_real_p_opt_n_nz = 0;
static const int CAD_dae_real_dx_n_nz = 5;
static const int CAD_dae_real_x_n_nz = 5;
static const int CAD_dae_real_u_n_nz = 5;
static const int CAD_dae_real_w_n_nz = 7;
static int CAD_dae_n_nz = 22;
static const int CAD_dae_nz_rows[22] = {0,1,2,3,4,0,1,2,3,4,2,3,4,8,8,2,5,3,6,4,7,8};
static const int CAD_dae_nz_cols[22] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,15,16,16,17,17,18};
")})));
end SparseJacTest1;

model SparseJacTest2
    function F1
      input Real x1[3];
      input Real x2;
      input Real x3;
      output Real y1;
      output Real y2[3];
    algorithm
      y1 := x1[1]+x2;
      y2 := {x1[1],x2,x3} + x1;
    end F1;
    Real y[3](start={1,2,3});
    Real a(start = 3);
    parameter Real x[3](start={3,2,2});
    parameter Real z(start=1);
    parameter Real w(start =3);
equation
    (a,y) = F1(x,z,w);


    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="SparseJacTest2",
            description="Test that sparsity information is generated correctly",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            template="$C_DAE_equation_sparsity$",
            generatedCode="
static const int CAD_dae_real_p_opt_n_nz = 0;
static const int CAD_dae_real_dx_n_nz = 0;
static const int CAD_dae_real_x_n_nz = 0;
static const int CAD_dae_real_u_n_nz = 0;
static const int CAD_dae_real_w_n_nz = 4;
static int CAD_dae_n_nz = 4;
static const int CAD_dae_nz_rows[4] = {1,2,3,0};
static const int CAD_dae_nz_cols[4] = {0,1,2,3};
")})));
end SparseJacTest2;

model SparseJacTest3
    function F1
      input Real x1[3];
      input Real x2;
      input Real x3;
      output Real y1;
      output Real y2[3];
    algorithm
      y1 := x1[1]+x2;
      y2 := {x1[1],x2,x3} + x1;
    end F1;
    Real y[3](start={1,2,3});
    Real a(start = 3);
    Real q = 3;
    parameter Real x[3](start={3,2,2});
    parameter Real z(start=1);
    parameter Real w(start =3);
equation
    (a,y) = F1(x,q,a);


    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="SparseJacTest3",
            description="Test that sparsity information is generated correctly",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            template="$C_DAE_equation_sparsity$",
            generatedCode="
static const int CAD_dae_real_p_opt_n_nz = 0;
static const int CAD_dae_real_dx_n_nz = 0;
static const int CAD_dae_real_x_n_nz = 0;
static const int CAD_dae_real_u_n_nz = 0;
static const int CAD_dae_real_w_n_nz = 12;
static int CAD_dae_n_nz = 12;
static const int CAD_dae_nz_rows[12] = {1,2,3,0,1,2,3,0,1,2,3,4};
static const int CAD_dae_nz_cols[12] = {0,1,2,3,3,3,3,4,4,4,4,4};
")})));
end SparseJacTest3;

model SparseJacTest4
    function F1
      input Real x1[3];
      input Real x2;
      input Real x3;
      output Real y1;
      output Real y2[3];
    algorithm
      y1 := x1[1]+x2;
      y2 := {x1[1],x2,x3} + x1;
    end F1;
    Real y[3](start={1,2,3});
    Real a(start = 3);
    Real q = 3;
    input Real x[3](start={3,2,2});
equation
    (a,y) = F1(x,q,a);


    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="SparseJacTest4",
            description="Test that sparsity information is generated correctly",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            template="$C_DAE_equation_sparsity$",
            generatedCode="
static const int CAD_dae_real_p_opt_n_nz = 0;
static const int CAD_dae_real_dx_n_nz = 0;
static const int CAD_dae_real_x_n_nz = 0;
static const int CAD_dae_real_u_n_nz = 12;
static const int CAD_dae_real_w_n_nz = 12;
static int CAD_dae_n_nz = 24;
static const int CAD_dae_nz_rows[24] = {0,1,2,3,0,1,2,3,0,1,2,3,1,2,3,0,1,2,3,0,1,2,3,4};
static const int CAD_dae_nz_cols[24] = {0,0,0,0,1,1,1,1,2,2,2,2,3,4,5,6,6,6,6,7,7,7,7,7};
")})));
end SparseJacTest4;

model SparseJacTest5
    function F1
      input Real x1[3];
      input Real x2;
      input Real x3;
      output Real y1;
      output Real y2[3];
    algorithm
      y1 := x1[1]+x2;
      y2 := {x1[1],x2,x3} + x1;
    end F1;
    Real y[3](start={1,2,3});
    Real a(start = 3);
    Real q = 3;
    Real x[3](start={3,2,2});
equation
    (a,y) = F1(der(x)+x,q,a);
    der(x) = -x;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="SparseJacTest5",
            description="Test that sparsity information is generated correctly",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            template="$C_DAE_equation_sparsity$",
            generatedCode="
static const int CAD_dae_real_p_opt_n_nz = 0;
static const int CAD_dae_real_dx_n_nz = 15;
static const int CAD_dae_real_x_n_nz = 15;
static const int CAD_dae_real_u_n_nz = 0;
static const int CAD_dae_real_w_n_nz = 12;
static int CAD_dae_n_nz = 42;
static const int CAD_dae_nz_rows[42] = {0,1,2,3,4,0,1,2,3,5,0,1,2,3,6,0,1,2,3,4,0,1,2,3,5,0,1,2,3,6,1,2,3,0,1,2,3,0,1,2,3,7};
static const int CAD_dae_nz_cols[42] = {0,0,0,0,0,1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,4,4,4,4,4,5,5,5,5,5,6,7,8,9,9,9,9,10,10,10,10,10};
")})));
end SparseJacTest5;

model SparseJacTest6
    parameter String s = "string";
    Real x;
equation
    der(x) = time;
    
    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="SparseJacTest6",
            description="Test that sparsity information is generated correctly. #4644.",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            template="$C_DAE_equation_sparsity$",
            generatedCode="
static const int CAD_dae_real_p_opt_n_nz = 0;
static const int CAD_dae_real_dx_n_nz = 1;
static const int CAD_dae_real_x_n_nz = 0;
static const int CAD_dae_real_u_n_nz = 0;
static const int CAD_dae_real_w_n_nz = 0;
static int CAD_dae_n_nz = 1;
static const int CAD_dae_nz_rows[1] = {0};
static const int CAD_dae_nz_cols[1] = {0};
")})));
end SparseJacTest6;

model TestExtObject1
	class ExtObjectwInput
		extends ExternalObject;
		
		function constructor
			input Real i;
			output ExtObjectwInput eo;
			external "C" eo = init_myEO(i);
		end constructor;
		
		function destructor
			input ExtObjectwInput eo;
			external "C" close_myEO(eo);
		end destructor;
	end ExtObjectwInput;
	function f
		input ExtObjectwInput eo;
		input Real x;
		output Real r;
		external "C" r = useMyEO(eo, x);
		annotation(derivative=f_der);
	end f;
	
	function f_der
		input ExtObjectwInput eo;
		input Real x;
		input Real x_der;
		output Real r_der;
		external "C" r_der = useMyEO_der(eo, x, x_der);
	end f_der;
	
	ExtObjectwInput myEO = ExtObjectwInput(123);
	Real y;
equation
	y = f(myEO, y);

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="TestExtObject1",
            description="",
            variability_propagation=false,
            generate_block_jacobian=true,
            template="
$C_function_headers$
$C_functions$
$CAD_function_headers$
$CAD_functions$
",
            generatedCode="
void func_CADCodeGenTests_TestExtObject1_ExtObjectwInput_destructor_def0(jmi_extobj_t eo_v);
void func_CADCodeGenTests_TestExtObject1_ExtObjectwInput_constructor_def1(jmi_real_t i_v, jmi_extobj_t* eo_o);
jmi_extobj_t func_CADCodeGenTests_TestExtObject1_ExtObjectwInput_constructor_exp1(jmi_real_t i_v);
void func_CADCodeGenTests_TestExtObject1_f_def2(jmi_extobj_t eo_v, jmi_real_t x_v, jmi_real_t* r_o);
jmi_real_t func_CADCodeGenTests_TestExtObject1_f_exp2(jmi_extobj_t eo_v, jmi_real_t x_v);
void func_CADCodeGenTests_TestExtObject1_f_der_def3(jmi_extobj_t eo_v, jmi_real_t x_v, jmi_real_t x_der_v, jmi_real_t* r_der_o);
jmi_real_t func_CADCodeGenTests_TestExtObject1_f_der_exp3(jmi_extobj_t eo_v, jmi_real_t x_v, jmi_real_t x_der_v);

void func_CADCodeGenTests_TestExtObject1_ExtObjectwInput_destructor_def0(jmi_extobj_t eo_v) {
    JMI_DYNAMIC_INIT()
    extern void close_myEO(void*);
    close_myEO(eo_v);
    JMI_DYNAMIC_FREE()
    return;
}

void func_CADCodeGenTests_TestExtObject1_ExtObjectwInput_constructor_def1(jmi_real_t i_v, jmi_extobj_t* eo_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(EXO, eo_v)
    extern void* init_myEO(double);
    eo_v = init_myEO(i_v);
    JMI_RET(GEN, eo_o, eo_v)
    JMI_DYNAMIC_FREE()
    return;
}

jmi_extobj_t func_CADCodeGenTests_TestExtObject1_ExtObjectwInput_constructor_exp1(jmi_real_t i_v) {
    JMI_DEF(EXO, eo_v)
    func_CADCodeGenTests_TestExtObject1_ExtObjectwInput_constructor_def1(i_v, &eo_v);
    return eo_v;
}

void func_CADCodeGenTests_TestExtObject1_f_def2(jmi_extobj_t eo_v, jmi_real_t x_v, jmi_real_t* r_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, r_v)
    extern double useMyEO(void*, double);
    r_v = useMyEO(eo_v, x_v);
    JMI_RET(GEN, r_o, r_v)
    JMI_DYNAMIC_FREE()
    return;
}

jmi_real_t func_CADCodeGenTests_TestExtObject1_f_exp2(jmi_extobj_t eo_v, jmi_real_t x_v) {
    JMI_DEF(REA, r_v)
    func_CADCodeGenTests_TestExtObject1_f_def2(eo_v, x_v, &r_v);
    return r_v;
}

void func_CADCodeGenTests_TestExtObject1_f_der_def3(jmi_extobj_t eo_v, jmi_real_t x_v, jmi_real_t x_der_v, jmi_real_t* r_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, r_der_v)
    extern double useMyEO_der(void*, double, double);
    r_der_v = useMyEO_der(eo_v, x_v, x_der_v);
    JMI_RET(GEN, r_der_o, r_der_v)
    JMI_DYNAMIC_FREE()
    return;
}

jmi_real_t func_CADCodeGenTests_TestExtObject1_f_der_exp3(jmi_extobj_t eo_v, jmi_real_t x_v, jmi_real_t x_der_v) {
    JMI_DEF(REA, r_der_v)
    func_CADCodeGenTests_TestExtObject1_f_der_def3(eo_v, x_v, x_der_v, &r_der_v);
    return r_der_v;
}


void func_CADCodeGenTests_TestExtObject1_f_der_AD2(jmi_extobj_t eo_v, jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* r_var_o, jmi_real_t* r_der_o);

void func_CADCodeGenTests_TestExtObject1_f_der_AD2(jmi_extobj_t eo_v, jmi_real_t x_var_v, jmi_real_t x_der_v, jmi_real_t* r_var_o, jmi_real_t* r_der_o) {
    JMI_DYNAMIC_INIT()
    JMI_DEF(REA, r_var_v)
    JMI_DEF(REA, r_der_v)
    /*Using specified derivative annotation instead of AD*/
    func_CADCodeGenTests_TestExtObject1_f_def2(eo_v, x_var_v, &r_var_v);
    func_CADCodeGenTests_TestExtObject1_f_der_def3(eo_v, x_var_v, x_der_v, &r_der_v);
    if (r_var_o != NULL) *r_var_o = r_var_v;
    if (r_der_o != NULL) *r_der_o = r_der_v;
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end TestExtObject1;


model WhenEqu8
    
function f
    input Real x;
    input Real y;
    output Real a;
    output Real b;
 algorithm
     a := y;
     b := x;
end f;

 discrete Real x,y;
 Real a,b;
equation
    a = time;
    b = time*2;
  when {initial(), time > 1} then
    (x,y) = f(a,b);
  end when;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="WhenEqu8",
            description="Test code generation unsolved when equations",
            generate_ode=true,
            equation_sorting=true,
            variability_propagation=false,
            relational_time_events=false,
            generate_dae_jacobian=true,
            inline_functions="none",
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    JMI_DEF(REA, tmp_var_0)
    JMI_DEF(REA, tmp_der_0)
    JMI_DEF(REA, tmp_var_1)
    JMI_DEF(REA, tmp_der_1)
    jmi_real_t v_0;
    jmi_real_t v_1;
    jmi_real_t v_2;
    (*res)[0] = _time - (_a_2);
    (*dF)[0] = (*dz)[jmi->offs_t] - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
    (*res)[1] = 2.0 * _a_2 - (_b_3);
    (*dF)[1] = 0.0 * _a_2 + 2.0 * (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
    if (jmi->atInitial || jmi->atEvent) {
        _sw(0) = jmi_turn_switch(jmi, _time - (1.0), _sw(0), JMI_REL_GT);
    }
    (*res)[2] = _sw(0) - (_temp_1_4);
    if (LOG_EXP_OR(v_0, v_1)) {
        func_CADCodeGenTests_WhenEqu8_f_der_AD0(_a_2, _b_3, 0.0, 0.0, &tmp_var_0, &tmp_var_1, &tmp_der_0, &tmp_der_1);
        (*res)[3] = tmp_var_0 - (_x_0);
        (*res)[4] = tmp_var_1 - (_y_1);
    } else {
        (*res)[3] = pre_x_0 - (_x_0);
        (*res)[4] = pre_y_1 - (_y_1);
    }
")})));
end WhenEqu8;

model WhenEqu9
    
function f
    input Real x;
    input Real y;
    output Real a;
    output Real b;
 algorithm
     a := y;
     b := x;
end f;

 discrete Real x,y;
 Real a,b;
equation
  a = time;
  b = time*x;
  when time > 2 then
    (x,y) = f(a,b);
  end when;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="WhenEqu9",
            description="Test code generation unsolved when equations",
            generate_ode=true,
            equation_sorting=true,
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            generate_block_jacobian=true,
            template="$CAD_dae_blocks_residual_functions$",
            generatedCode="
static int dae_block_dir_der_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 1 *****/
    JMI_DEF(REA, tmp_var_0)
    JMI_DEF(REA, tmp_der_0)
    JMI_DEF(REA, tmp_var_1)
    JMI_DEF(REA, tmp_der_1)
    jmi_real_t v_0;
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        x[0] = _b_3;
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
        (*dz)[ jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = dx[0];
        _b_3 = x[0];
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
        (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = -(*dF)[0];
    } else {
        return -1;
    }
    _temp_1_4 = _sw(0);
    if (LOG_EXP_AND(_temp_1_4, v_0)) {
        func_CADCodeGenTests_WhenEqu9_f_der_AD0(_a_2, _b_3, 0.0, 0.0, &tmp_var_0, &tmp_var_1, &tmp_der_0, &tmp_der_1);
        _y_1 = tmp_var_1;
    } else {
        _y_1 = pre_y_1;
    }
    if (LOG_EXP_AND(_temp_1_4, v_0)) {
        _x_0 = tmp_var_0;
    } else {
        _x_0 = pre_x_0;
    }
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
        (*res)[0] = _time * _x_0 - (_b_3);
        (*dF)[0] = (*dz)[jmi->offs_t] * _x_0 + _time * 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
        (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = 0;
    }
        JMI_DYNAMIC_FREE()
    return ef;
}
")})));
end WhenEqu9;

model WhenEqu10
    
function f
    input Real x;
    input Real y;
    output Real a;
    output Real b;
 algorithm
     a := y;
     b := x;
end f;

 discrete Real x,y;
 Real a,b;
equation
  when time > 2 then
    (a,b) = f(x,y);
  end when;
  when {initial(), time > 2} then
    (x,y) = f(a,b);
  end when;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="WhenEqu10",
            description="Test code generation unsolved when equations",
            generate_ode=true,
            equation_sorting=true,
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            generate_block_jacobian=true,
            template="$CAD_dae_blocks_residual_functions$",
            generatedCode="
static int dae_block_dir_der_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 1 *****/
    JMI_DEF(REA, tmp_var_0)
    JMI_DEF(REA, tmp_der_0)
    JMI_DEF(REA, tmp_var_1)
    JMI_DEF(REA, tmp_der_1)
    jmi_real_t v_0;
    JMI_DEF(REA, tmp_var_2)
    JMI_DEF(REA, tmp_der_2)
    JMI_DEF(REA, tmp_var_3)
    JMI_DEF(REA, tmp_der_3)
    jmi_real_t v_1;
    jmi_real_t v_2;
    jmi_real_t v_3;
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        x[0] = _y_1;
        x[1] = _x_0;
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
        (*dz)[ jmi_get_index_from_value_ref(3)-jmi->offs_real_dx] = dx[0];
        _y_1 = x[0];
        (*dz)[ jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] = dx[1];
        _x_0 = x[1];
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
        (*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx] = -(*dF)[0];
        (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] = -(*dF)[1];
    } else {
        return -1;
    }
    _temp_2_5 = _sw(0);
    _temp_1_4 = _sw(0);
    if (LOG_EXP_AND(_temp_1_4, v_0)) {
        func_CADCodeGenTests_WhenEqu10_f_der_AD0(_x_0, _y_1, 0.0, 0.0, &tmp_var_0, &tmp_var_1, &tmp_der_0, &tmp_der_1);
        _b_3 = tmp_var_1;
    } else {
        _b_3 = pre_b_3;
    }
    if (LOG_EXP_AND(_temp_1_4, v_0)) {
        _a_2 = tmp_var_0;
    } else {
        _a_2 = pre_a_2;
    }
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
        if (LOG_EXP_OR(v_1, v_2)) {
            func_CADCodeGenTests_WhenEqu10_f_der_AD0(_a_2, _b_3, 0.0, 0.0, &tmp_var_2, &tmp_var_3, &tmp_der_2, &tmp_der_3);
            (*res)[0] = tmp_var_3 - (_y_1);
        } else {
            (*res)[0] = pre_y_1 - (_y_1);
        }
        if (LOG_EXP_OR(v_1, v_2)) {
            (*res)[1] = tmp_var_2 - (_x_0);
        } else {
            (*res)[1] = pre_x_0 - (_x_0);
        }
        (*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx] = 0;
        (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] = 0;
    }
        JMI_DYNAMIC_FREE()
    return ef;
}
")})));
end WhenEqu10;

model WhenTest11
    Real x = time;
    discrete Real z;
equation
    when time >= 2 then
        z = pre(x);
    end when;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="WhenTest11",
            description="Code generation for use of pre on continuous variable",
            equation_sorting=true,
            generate_ode=true,
            generate_dae_jacobian=true,
            relational_time_events=false,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    jmi_real_t v_0;
    jmi_real_t v_1;
    if (jmi->atInitial || jmi->atEvent) {
        _sw(0) = jmi_turn_switch(jmi, _time - (2.0), _sw(0), JMI_REL_GEQ);
    }
    (*res)[0] = _sw(0) - (_temp_1_2);
    (*res)[1] = COND_EXP_EQ(LOG_EXP_AND(_temp_1_2, LOG_EXP_NOT(pre_temp_1_2)), JMI_TRUE, pre_x_0, pre_z_1) - (_z_1);
    (*res)[2] = _time - (_x_0);
    (*dF)[2] = (*dz)[jmi->offs_t] - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
")})));
end WhenTest11; 



function dummyFunc
    input Real i;
    output Real x = i;
    output Real y = i;
    algorithm
end dummyFunc;

model IfEqu1

    Real x,y;
equation
    if time >= 2 then
        (x,y) = dummyFunc(time*time*time/2);
    elseif time >= 1 then
        (x,y) = dummyFunc(time*time);
    else
        (x,y) = dummyFunc(time);
    end if;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="IfEqu1",
            description="Code generation for if equation",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    JMI_DEF(REA, tmp_var_0)
    JMI_DEF(REA, tmp_der_0)
    JMI_DEF(REA, tmp_var_1)
    JMI_DEF(REA, tmp_der_1)
    jmi_real_t v_0;
    jmi_real_t d_0;
    jmi_real_t v_1;
    jmi_real_t d_1;
    jmi_real_t v_2;
    jmi_real_t d_2;
    JMI_DEF(REA, tmp_var_2)
    JMI_DEF(REA, tmp_der_2)
    JMI_DEF(REA, tmp_var_3)
    JMI_DEF(REA, tmp_der_3)
    jmi_real_t v_3;
    jmi_real_t d_3;
    JMI_DEF(REA, tmp_var_4)
    JMI_DEF(REA, tmp_der_4)
    JMI_DEF(REA, tmp_var_5)
    JMI_DEF(REA, tmp_der_5)
    if (_sw(0)) {
        v_2 = _time * _time;
        d_2 = (*dz)[jmi->offs_t] * _time + _time * (*dz)[jmi->offs_t];
        v_1 = v_2 * _time;
        d_1 = d_2 * _time + v_2 * (*dz)[jmi->offs_t];
        v_0 = v_1 / 2.0;
        d_0 = (d_1 * 2.0 - v_1 * 0.0) / (2.0 * 2.0);
        func_CADCodeGenTests_dummyFunc_der_AD0(v_0, d_0, &tmp_var_0, &tmp_var_1, &tmp_der_0, &tmp_der_1);
        (*res)[0] = tmp_var_0 - (_x_0);
        (*dF)[0] = tmp_der_0 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
        (*res)[1] = tmp_var_1 - (_y_1);
        (*dF)[1] = tmp_der_1 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
    } else {
        if (_sw(1)) {
            v_3 = _time * _time;
            d_3 = (*dz)[jmi->offs_t] * _time + _time * (*dz)[jmi->offs_t];
            func_CADCodeGenTests_dummyFunc_der_AD0(v_3, d_3, &tmp_var_2, &tmp_var_3, &tmp_der_2, &tmp_der_3);
            (*res)[0] = tmp_var_2 - (_x_0);
            (*dF)[0] = tmp_der_2 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
            (*res)[1] = tmp_var_3 - (_y_1);
            (*dF)[1] = tmp_der_3 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
        } else {
            func_CADCodeGenTests_dummyFunc_der_AD0(_time, (*dz)[jmi->offs_t], &tmp_var_4, &tmp_var_5, &tmp_der_4, &tmp_der_5);
            (*res)[0] = tmp_var_4 - (_x_0);
            (*dF)[0] = tmp_der_4 - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
            (*res)[1] = tmp_var_5 - (_y_1);
            (*dF)[1] = tmp_der_5 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
        }
    }
")})));
end IfEqu1;

model IfEqu2
    Real x,y,t;
equation
    t = time;
    if time >= 1 then
        (x,t) = dummyFunc(y);
    else
        (x,t) = dummyFunc(y);
    end if;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="IfEqu2",
            description="Code generation for if equation, numerically solved",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            generate_block_jacobian=true,
            template="$CAD_dae_blocks_residual_functions$",
            generatedCode="
static int dae_block_dir_der_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 1 *****/
    JMI_DEF(REA, tmp_var_0)
    JMI_DEF(REA, tmp_der_0)
    JMI_DEF(REA, tmp_var_1)
    JMI_DEF(REA, tmp_der_1)
    JMI_DEF(REA, tmp_var_2)
    JMI_DEF(REA, tmp_der_2)
    JMI_DEF(REA, tmp_var_3)
    JMI_DEF(REA, tmp_der_3)
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        x[0] = _y_1;
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
        (*dz)[ jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = dx[0];
        _y_1 = x[0];
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
        (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = -(*dF)[0];
    } else {
        return -1;
    }
    if (_sw(0)) {
      func_CADCodeGenTests_dummyFunc_der_AD0(_y_1, (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx], &tmp_var_0, &tmp_var_1, &tmp_der_0, &tmp_der_1);
      _x_0 = tmp_var_0;
      (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = tmp_der_0;
    } else {
      func_CADCodeGenTests_dummyFunc_der_AD0(_y_1, (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx], &tmp_var_2, &tmp_var_3, &tmp_der_2, &tmp_der_3);
      _x_0 = tmp_var_2;
      (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = tmp_der_2;
    }
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
        if (_sw(0)) {
            (*res)[0] = tmp_var_1 - (_t_2);
            (*dF)[0] = tmp_der_1 - ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]);
        } else {
            (*res)[0] = tmp_var_3 - (_t_2);
            (*dF)[0] = tmp_der_3 - ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]);
        }
        (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = 0;
    }
        JMI_DYNAMIC_FREE()
    return ef;
}

")})));
end IfEqu2;

model IfEqu3
    Real x,y,a,b;
equation
    if time >= 1 then
        (x,y) = dummyFunc(a);
    else
        (x,y) = dummyFunc(b);
    end if;
    if time >= 1 then
        (a,b) = dummyFunc(x);
    else
        (a,b) = dummyFunc(y);
    end if;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="IfEqu3",
            description="Code generation for if equation, in block",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            generate_block_jacobian=true,
            template="$CAD_dae_blocks_residual_functions$",
            generatedCode="
static int dae_block_dir_der_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 1 *****/
    JMI_DEF(REA, tmp_var_0)
    JMI_DEF(REA, tmp_der_0)
    JMI_DEF(REA, tmp_var_1)
    JMI_DEF(REA, tmp_der_1)
    JMI_DEF(REA, tmp_var_2)
    JMI_DEF(REA, tmp_der_2)
    JMI_DEF(REA, tmp_var_3)
    JMI_DEF(REA, tmp_der_3)
    JMI_DEF(REA, tmp_var_4)
    JMI_DEF(REA, tmp_der_4)
    JMI_DEF(REA, tmp_var_5)
    JMI_DEF(REA, tmp_der_5)
    JMI_DEF(REA, tmp_var_6)
    JMI_DEF(REA, tmp_der_6)
    JMI_DEF(REA, tmp_var_7)
    JMI_DEF(REA, tmp_der_7)
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        x[0] = _b_3;
        x[1] = _a_2;
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
        (*dz)[ jmi_get_index_from_value_ref(3)-jmi->offs_real_dx] = dx[0];
        _b_3 = x[0];
        (*dz)[ jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] = dx[1];
        _a_2 = x[1];
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
        (*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx] = -(*dF)[0];
        (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] = -(*dF)[1];
    } else {
        return -1;
    }
    if (_sw(0)) {
      func_CADCodeGenTests_dummyFunc_der_AD0(_a_2, (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx], &tmp_var_0, &tmp_var_1, &tmp_der_0, &tmp_der_1);
      _y_1 = tmp_var_1;
      (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = tmp_der_1;
    } else {
      func_CADCodeGenTests_dummyFunc_der_AD0(_b_3, (*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx], &tmp_var_2, &tmp_var_3, &tmp_der_2, &tmp_der_3);
      _y_1 = tmp_var_3;
      (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = tmp_der_3;
    }
    if (_sw(0)) {
      _x_0 = tmp_var_0;
      (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = tmp_der_0;
    } else {
      _x_0 = tmp_var_2;
      (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = tmp_der_2;
    }
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
        if (_sw(0)) {
            func_CADCodeGenTests_dummyFunc_der_AD0(_x_0, (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx], &tmp_var_4, &tmp_var_5, &tmp_der_4, &tmp_der_5);
            (*res)[0] = tmp_var_5 - (_b_3);
            (*dF)[0] = tmp_der_5 - ((*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx]);
        } else {
            func_CADCodeGenTests_dummyFunc_der_AD0(_y_1, (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx], &tmp_var_6, &tmp_var_7, &tmp_der_6, &tmp_der_7);
            (*res)[0] = tmp_var_7 - (_b_3);
            (*dF)[0] = tmp_der_7 - ((*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx]);
        }
        if (_sw(0)) {
            (*res)[1] = tmp_var_4 - (_a_2);
            (*dF)[1] = tmp_der_4 - ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]);
        } else {
            (*res)[1] = tmp_var_6 - (_a_2);
            (*dF)[1] = tmp_der_6 - ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]);
        }
        (*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx] = 0;
        (*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx] = 0;
    }
        JMI_DYNAMIC_FREE()
    return ef;
}

")})));
end IfEqu3;

model IfEqu4
function f
    input Real[:] i;
    output Real[size(i,1)] x = i;
    output Real[size(i,1)] y = i;
    algorithm
end f;
    Real[2] x,y;
equation
    if time >= 1 then
        (x,y) = f({time,time});
    else
        (x[1:end],y[{2,1}]) = f({time,time});
    end if;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="IfEqu4",
            description="Code generation for if equation, temp vars",
            variability_propagation=false,
            inline_functions="none",
            generate_dae_jacobian=true,
            template="$C_DAE_equation_directional_derivative$",
            generatedCode="
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_0, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_0, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_1, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_1, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_2, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_2, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_3, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_3, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_4, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_4, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_var_5, 2, 1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_der_5, 2, 1)
    if (_sw(0)) {
        JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_var_0, 2, 1, 2)
        JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_der_0, 2, 1, 2)
        JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_var_1, 2, 1, 2)
        JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_der_1, 2, 1, 2)
        JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_var_2, 2, 1, 2)
        JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_der_2, 2, 1, 2)
        jmi_array_ref_1(tmp_var_2, 1) = _time;
        jmi_array_ref_1(tmp_var_2, 2) = _time;
        jmi_array_ref_1(tmp_der_2, 1) = (*dz)[jmi->offs_t];
        jmi_array_ref_1(tmp_der_2, 2) = (*dz)[jmi->offs_t];
        func_CADCodeGenTests_IfEqu4_f_der_AD0(tmp_var_2, tmp_der_2, tmp_var_0, tmp_var_1, tmp_der_0, tmp_der_1);
        (*res)[0] = jmi_array_val_1(tmp_var_0, 1) - (_x_1_0);
        (*res)[1] = jmi_array_val_1(tmp_var_0, 2) - (_x_2_1);
        (*dF)[0] = jmi_array_val_1(tmp_der_0, 1) - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
        (*dF)[1] = jmi_array_val_1(tmp_der_0, 2) - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
        (*res)[2] = jmi_array_val_1(tmp_var_1, 1) - (_y_1_2);
        (*res)[3] = jmi_array_val_1(tmp_var_1, 2) - (_y_2_3);
        (*dF)[2] = jmi_array_val_1(tmp_der_1, 1) - ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]);
        (*dF)[3] = jmi_array_val_1(tmp_der_1, 2) - ((*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx]);
    } else {
        JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_var_3, 2, 1, 2)
        JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_der_3, 2, 1, 2)
        JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_var_4, 2, 1, 2)
        JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_der_4, 2, 1, 2)
        JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_var_5, 2, 1, 2)
        JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_der_5, 2, 1, 2)
        jmi_array_ref_1(tmp_var_5, 1) = _time;
        jmi_array_ref_1(tmp_var_5, 2) = _time;
        jmi_array_ref_1(tmp_der_5, 1) = (*dz)[jmi->offs_t];
        jmi_array_ref_1(tmp_der_5, 2) = (*dz)[jmi->offs_t];
        func_CADCodeGenTests_IfEqu4_f_der_AD0(tmp_var_5, tmp_der_5, tmp_var_3, tmp_var_4, tmp_der_3, tmp_der_4);
        (*res)[0] = jmi_array_val_1(tmp_var_3, 1) - (_x_1_0);
        (*res)[1] = jmi_array_val_1(tmp_var_3, 2) - (_x_2_1);
        (*dF)[0] = jmi_array_val_1(tmp_der_3, 1) - ((*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
        (*dF)[1] = jmi_array_val_1(tmp_der_3, 2) - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx]);
        (*res)[2] = jmi_array_val_1(tmp_var_4, 1) - (_y_2_3);
        (*res)[3] = jmi_array_val_1(tmp_var_4, 2) - (_y_1_2);
        (*dF)[2] = jmi_array_val_1(tmp_der_4, 1) - ((*dz)[jmi_get_index_from_value_ref(3)-jmi->offs_real_dx]);
        (*dF)[3] = jmi_array_val_1(tmp_der_4, 2) - ((*dz)[jmi_get_index_from_value_ref(2)-jmi->offs_real_dx]);
    }
")})));
end IfEqu4;

model StringZeroValue1
    record R
        Real x;
        parameter String s;
    end R;
    function F1
        input R r;
        output Real y;
    algorithm
        y := r.x;
    annotation(Inline=false);
    end F1;

    R r = R(x, "Jon was here");
    Real x;
    Real y;
equation
    y = F1(r);
    y * x = 0;

    annotation(__JModelica(UnitTesting(tests={
        CADCodeGenTestCase(
            name="StringZeroValue1",
            description="Test code gen for zero value of string expressions",
            generate_ode_jacobian=true,
            template="$CAD_dae_blocks_residual_functions$",
            generatedCode="
static int dae_block_dir_der_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 1 *****/
    jmi_real_t v_0;
    jmi_real_t d_0;
    JMI_RECORD_STATIC(R_0_r, tmp_var_0)
    JMI_RECORD_STATIC(R_0_r, tmp_der_0)
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        x[0] = _x_1;
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
        (*dz)[ jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = dx[0];
        _x_1 = x[0];
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
        (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = -(*dF)[0];
    } else {
        return -1;
    }
    tmp_var_0->x = _x_1;
    tmp_var_0->s = \"Jon was here\";
    tmp_der_0->x = (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx];
    tmp_der_0->s = \"\";
    func_CADCodeGenTests_StringZeroValue1_F1_der_AD0(tmp_var_0, tmp_der_0, &v_0, &d_0);
    _y_2 = v_0;
    (*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] = d_0;
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
        (*res)[0] = 0.0 - (_y_2 * _x_1);
        (*dF)[0] = 0.0 - ((*dz)[jmi_get_index_from_value_ref(1)-jmi->offs_real_dx] * _x_1 + _y_2 * (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx]);
        (*dz)[jmi_get_index_from_value_ref(0)-jmi->offs_real_dx] = 0;
    }
        JMI_DYNAMIC_FREE()
    return ef;
}

")})));
end StringZeroValue1;
    
    package PrePropagation
        
        model Simple1
            Boolean b1 = time > 0 and time < 2;
            Integer i1(start = 0);
        equation
            when b1 then
                i1 = 1;
            end when;
        
        annotation(__JModelica(UnitTesting(tests={
            CADCodeGenTestCase(
                name="PrePropagation_Simple1",
                description="Test CAD gen for pre propagation, ensure that ad steps are produced for switch expressions. Code gen isn't 100% correct, but at least lets try that it is compilable c-code'",
                generate_ode_jacobian=true,
                template="
$CAD_ode_derivatives$
$CAD_dae_blocks_residual_functions$
", /* Yes this result is incorrect, v_0 and v_1 isn't used anywhere, but this test is to ensure that the temporary declarations are produced! */
                    generatedCode="
    /******** Declarations *******/
    jmi_real_t v_0;
    jmi_real_t v_1;
    jmi_real_t** dz = jmi->dz;
    /*********** ODE section ***********/
    /*********** Real outputs **********/
    /*** Integer and boolean outputs ***/
    /********* Other variables *********/
    v_0 = _sw(0);
    v_1 = _sw(1);
    ef |= jmi_ode_unsolved_block_dir_der(jmi, jmi->dae_block_residuals[0]);

static int dae_block_dir_der_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* dx,jmi_real_t* residual, jmi_real_t* dRes, int evaluation_mode) {
    /***** Block: 1 *****/
    jmi_real_t v_2;
    jmi_real_t v_3;
    jmi_real_t v_4;
    jmi_real_t v_5;
    jmi_real_t** res = &residual;
    int ef = 0;
    JMI_DYNAMIC_INIT()
    jmi_real_t** dF = &dRes;
    jmi_real_t** dz;
    if (evaluation_mode == JMI_BLOCK_INITIALIZE) {
        return 0;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE) {
        dz = jmi->dz_active_variables;
    } else if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE) {
        dz = jmi->dz;
    } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
        dz = jmi->dz;
    } else {
        return -1;
    }
    v_2 = _sw(0);
    v_3 = _sw(1);
    _b1_0 = LOG_EXP_AND(v_2, v_3);
    v_5 = LOG_EXP_NOT(pre_b1_0);
    if (LOG_EXP_AND(_b1_0, v_5)) {
        v_4 = 1.0;
    } else {
        v_4 = pre_i1_1;
    }
    _i1_1 = v_4;
    if (evaluation_mode == JMI_BLOCK_EVALUATE_INACTIVE || evaluation_mode == JMI_BLOCK_EVALUATE) {
    }
        JMI_DYNAMIC_FREE()
    return ef;
}


")})));
        end Simple1;
        
    end PrePropagation;

end CADCodeGenTests;