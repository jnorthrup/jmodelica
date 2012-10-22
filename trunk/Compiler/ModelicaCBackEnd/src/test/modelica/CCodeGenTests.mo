/*
    Copyright (C) 2009 Modelon AB

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


package CCodeGenTests

model CCodeGenTest1
  Real x1(start=0); 
  Real x2(start=1); 
  input Real u; 
  parameter Real p = 1;
  Real w = x1+x2;
equation 
  der(x1) = (1-x2^2)*x1 - x2 + p*u; 
  der(x2) = x1; 

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CCodeGenTest1",
			description="Test of code generation",
			template="
$C_variable_aliases$
$C_DAE_equation_residuals$
",
         generatedCode="
#define _p_3 ((*(jmi->z))[jmi->offs_real_pi+0])
#define _der_x1_5 ((*(jmi->z))[jmi->offs_real_dx+0])
#define _der_x2_6 ((*(jmi->z))[jmi->offs_real_dx+1])
#define _x1_0 ((*(jmi->z))[jmi->offs_real_x+0])
#define _x2_1 ((*(jmi->z))[jmi->offs_real_x+1])
#define _u_2 ((*(jmi->z))[jmi->offs_real_u+0])
#define _w_4 ((*(jmi->z))[jmi->offs_real_w+0])
#define _time ((*(jmi->z))[jmi->offs_t])

    (*res)[0] = ( 1 - ( (1.0 * (_x2_1) * (_x2_1)) ) ) * ( _x1_0 ) - ( _x2_1 ) + ( _p_3 ) * ( _u_2 ) - (_der_x1_5);
    (*res)[1] = _x1_0 - (_der_x2_6);
    (*res)[2] = _x1_0 + _x2_1 - (_w_4);
")})));
end CCodeGenTest1;


	model CCodeGenTest2
		Real x(start=1);
		Real y(start=3,fixed=true)=3;
	    Real z = x;
	    Real w(start=1) = 2;
	    Real v;
	equation
		der(x) = -x;
		der(v) = 4;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CCodeGenTest2",
			description="Test of code generation",
			automatic_add_initial_equations=false,
			template="
$C_variable_aliases$
$C_DAE_equation_residuals$
$C_DAE_initial_equation_residuals$
$C_DAE_initial_guess_equation_residuals$
",
         generatedCode="
#define _der_x_4 ((*(jmi->z))[jmi->offs_real_dx+0])
#define _der_v_5 ((*(jmi->z))[jmi->offs_real_dx+1])
#define _x_0 ((*(jmi->z))[jmi->offs_real_x+0])
#define _v_3 ((*(jmi->z))[jmi->offs_real_x+1])
#define _y_1 ((*(jmi->z))[jmi->offs_real_w+0])
#define _w_2 ((*(jmi->z))[jmi->offs_real_w+1])
#define _time ((*(jmi->z))[jmi->offs_t])

    (*res)[0] =  - ( _x_0 ) - (_der_x_4);
    (*res)[1] = 4 - (_der_v_5);
    (*res)[2] = 3 - (_y_1);
    (*res)[3] = 2 - (_w_2);

    (*res)[0] =  - ( _x_0 ) - (_der_x_4);
    (*res)[1] = 4 - (_der_v_5);
    (*res)[2] = 3 - (_y_1);
    (*res)[3] = 2 - (_w_2);
    (*res)[4] = 3 - (_y_1);

   (*res)[0] = 1 - _x_0;
   (*res)[1] = 1 - _w_2;
   (*res)[2] = 0.0 - _v_3;
")})));
	end CCodeGenTest2;

	model CCodeGenTest3
	    parameter Real p3 = p2;
	    parameter Real p2 = p1*p1;
		parameter Real p1 = 4;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CCodeGenTest3",
			description="Test of code generation",
			template="$C_DAE_initial_dependent_parameter_residuals$",
			generatedCode="
    (*res)[0] = ( _p1_2 ) * ( _p1_2 ) - (_p2_0);
    (*res)[1] = _p2_0 - (_p3_1);
")})));
	end CCodeGenTest3;


model CCodeGenTest4
  Real x(start=0);
  Real y = noEvent(if time <= Modelica.Constants.pi/2 then sin(time) else x);
equation
  der(x) = y; 

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CCodeGenTest4",
			description="Test of code generation",
			template="$C_DAE_equation_residuals$",
			generatedCode="
    (*res)[0] = _y_1 - (_der_x_2);
    (*res)[1] = COND_EXP_EQ(COND_EXP_LE(_time,jmi_divide(AD_WRAP_LITERAL(3.141592653589793),AD_WRAP_LITERAL(2),\"Divide by zero: ( 3.141592653589793 ) / ( 2 )\"),JMI_TRUE,JMI_FALSE),JMI_TRUE,sin(_time),_x_0) - (_y_1);
")})));
end CCodeGenTest4;


model CCodeGenTest5
  parameter Real one = 1;
  parameter Real two = 2;
  Real x(start=0.1,fixed=true);
  Real y = noEvent(if time <= one then x else if time <= two then -2*x else 3*x);
equation
  der(x) = y; 

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CCodeGenTest5",
			description="Test of code generation",
			template="$C_DAE_equation_residuals$",
			generatedCode="
    (*res)[0] = _y_3 - (_der_x_4);
    (*res)[1] = COND_EXP_EQ(COND_EXP_LE(_time,_one_0,JMI_TRUE,JMI_FALSE),JMI_TRUE,_x_2,COND_EXP_EQ(COND_EXP_LE(_time,_two_1,JMI_TRUE,JMI_FALSE),JMI_TRUE,(  - ( AD_WRAP_LITERAL(2) ) ) * ( _x_2 ),( AD_WRAP_LITERAL(3) ) * ( _x_2 ))) - (_y_3);
")})));
end CCodeGenTest5;

model CCodeGenTest6
  parameter Real p=1;
  parameter Real one = 1;
  parameter Real two = 2;
  Real x(start=0.1,fixed=true);
  Real y = if time <= one then x else if time <= two then -2*x else 3*x;
  Real z;
initial equation
  z = if p>=one then one else two; 
equation
  der(x) = y; 
  der(z) = -z;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CCodeGenTest6",
			description="Test of code generation",
			template="
$C_DAE_event_indicator_residuals$
$C_DAE_initial_event_indicator_residuals$
",
         generatedCode="
    (*res)[0] = _one_1 - (_time);
    (*res)[1] = _two_2 - (_time);

    (*res)[0] = _one_1 - (_time);
    (*res)[1] = _two_2 - (_time);
    (*res)[2] = _p_0 - (_one_1);
")})));
end CCodeGenTest6;

model CCodeGenTest7
  Real x(start=0);
  Real y = noEvent(if 1 <= 2 then 0 else if 3 >= 4 then 1 
   else if 1 < 2 then 2 else if 3 > 4 then 4 
   else if 4 == 3 then 4 else 7);
equation
 der(x) = y; 

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CCodeGenTest7",
			description="Test of code generation. Verify that no event indicators are generated from relational expressions inside noEvent operators.",
			template="
$C_DAE_equation_residuals$
$C_DAE_event_indicator_residuals$
",
         generatedCode="
    (*res)[0] = _y_1 - (_der_x_2);
    (*res)[1] = COND_EXP_EQ(COND_EXP_LE(AD_WRAP_LITERAL(1),AD_WRAP_LITERAL(2),JMI_TRUE,JMI_FALSE),JMI_TRUE,AD_WRAP_LITERAL(0),CO
ND_EXP_EQ(COND_EXP_GE(AD_WRAP_LITERAL(3),AD_WRAP_LITERAL(4),JMI_TRUE,JMI_FALSE),JMI_TRUE,AD_WRAP_LITERAL(1),COND_EXP_EQ(COND_EXP_
LT(AD_WRAP_LITERAL(1),AD_WRAP_LITERAL(2),JMI_TRUE,JMI_FALSE),JMI_TRUE,AD_WRAP_LITERAL(2),COND_EXP_EQ(COND_EXP_GT(AD_WRAP_LITERAL(
3),AD_WRAP_LITERAL(4),JMI_TRUE,JMI_FALSE),JMI_TRUE,AD_WRAP_LITERAL(4),COND_EXP_EQ(COND_EXP_EQ(AD_WRAP_LITERAL(4),AD_WRAP_LITERAL(
3),JMI_TRUE,JMI_FALSE),JMI_TRUE,AD_WRAP_LITERAL(4),AD_WRAP_LITERAL(7)))))) - (_y_1);
")})));
end CCodeGenTest7;

model CCodeGenTest8
  Real x(start=0);
  Real y(start=1);
  Real z(start=0);
equation
   x = if time>=1 then (-1 + y) else  (- y);
   y = z + x +(if z>=-1.5 then -3 else 3);
   z = -y  - x + (if y>=0.5 then -1 else 1);


	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CCodeGenTest8",
			description="Test of code generation",
			template="$C_DAE_equation_residuals$",
			generatedCode="
    (*res)[0] = COND_EXP_EQ(_sw(0),JMI_TRUE, - ( AD_WRAP_LITERAL(1) ) + _y_1, - ( _y_1 )) - (_x_0);
    (*res)[1] = _z_2 + _x_0 + COND_EXP_EQ(_sw(1),JMI_TRUE, - ( AD_WRAP_LITERAL(3) ),AD_WRAP_LITERAL(3)) - (_y_1);
    (*res)[2] =  - ( _y_1 ) - ( _x_0 ) + COND_EXP_EQ(_sw(2),JMI_TRUE, - ( AD_WRAP_LITERAL(1) ),AD_WRAP_LITERAL(1)) - (_z_2);
")})));
end CCodeGenTest8;

model CCodeGenTest9
  Real x(start=0);
  Real y(start=1);
  Real z(start=0);
initial equation
   x = noEvent(if time>=1 then (-1 + y) else  (- y));
   y = noEvent(z + x +(if z>=-1.5 then -3 else 3));
   z = -y  - x + (if y>=0.5 then -1 else 1);
equation
   der(x) = -x;
   der(y) = -y;
   der(z) = -z;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CCodeGenTest9",
			description="Test of code generation",
			template="
$C_DAE_initial_equation_residuals$
$C_DAE_initial_event_indicator_residuals$
",
         generatedCode="
    (*res)[0] =  - ( _x_0 ) - (_der_x_3);
    (*res)[1] =  - ( _y_1 ) - (_der_y_4);
    (*res)[2] =  - ( _z_2 ) - (_der_z_5);
    (*res)[3] = COND_EXP_EQ(COND_EXP_GE(_time,AD_WRAP_LITERAL(1),JMI_TRUE,JMI_FALSE),JMI_TRUE, - ( AD_WRAP_LITERAL(1) ) + _y_1, - ( _y_1 )) - (_x_0);
    (*res)[4] = _z_2 + _x_0 + COND_EXP_EQ(COND_EXP_GE(_z_2, - ( AD_WRAP_LITERAL(1.5) ),JMI_TRUE,JMI_FALSE),JMI_TRUE, - ( AD_WRAP_LITERAL(3) ),AD_WRAP_LITERAL(3)) - (_y_1);
    (*res)[5] =  - ( _y_1 ) - ( _x_0 ) + COND_EXP_EQ(_sw_init(0),JMI_TRUE, - ( AD_WRAP_LITERAL(1) ),AD_WRAP_LITERAL(1)) - (_z_2);
    (*res)[0] = _y_1 - (AD_WRAP_LITERAL(0.5));
")})));
end CCodeGenTest9;

model CCodeGenTest10
  Real x(start=0);
  Real y(start=1);
  Real z(start=0);
initial equation
   x = if time>=1 then (-1 + y) else  (- y);
   y = z + x +(if z>=-1.5 then -3 else 3);
   z = -y  - x + (if y>=0.5 then -1 else 1);
equation
   der(x) = -x;
   der(y) = -y;
   der(z) = -z;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CCodeGenTest10",
			description="Test of code generation",
			template="
$C_DAE_initial_equation_residuals$
$C_DAE_initial_event_indicator_residuals$
",
         generatedCode="
    (*res)[0] =  - ( _x_0 ) - (_der_x_3);
    (*res)[1] =  - ( _y_1 ) - (_der_y_4);
    (*res)[2] =  - ( _z_2 ) - (_der_z_5);
    (*res)[3] = COND_EXP_EQ(_sw_init(0),JMI_TRUE, - ( AD_WRAP_LITERAL(1) ) + _y_1, - ( _y_1 )) - (_x_0);
    (*res)[4] = _z_2 + _x_0 + COND_EXP_EQ(_sw_init(1),JMI_TRUE, - ( AD_WRAP_LITERAL(3) ),AD_WRAP_LITERAL(3)) - (_y_1);
    (*res)[5] =  - ( _y_1 ) - ( _x_0 ) + COND_EXP_EQ(_sw_init(2),JMI_TRUE, - ( AD_WRAP_LITERAL(1) ),AD_WRAP_LITERAL(1)) - (_z_2);
    (*res)[0] = _time - (AD_WRAP_LITERAL(1));
    (*res)[1] = _z_2 - ( - ( AD_WRAP_LITERAL(1.5) ));
    (*res)[2] = _y_1 - (AD_WRAP_LITERAL(0.5));
")})));
end CCodeGenTest10;

model CCodeGenTest11
 Integer x = 1;
 Integer y = 2;
 Real z = noEvent(if x <> y then 1.0 else 2.0);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CCodeGenTest11",
			description="C code generation: the '<>' operator",
			template="$C_DAE_equation_residuals$",
			generatedCode="
    (*res)[0] = 1 - (_x_0);
    (*res)[1] = 2 - (_y_1);
    (*res)[2] = COND_EXP_EQ(COND_EXP_EQ(_x_0, _y_1, JMI_FALSE, JMI_TRUE),JMI_TRUE,AD_WRAP_LITERAL(1.0),AD_WRAP_LITERAL(2.0)) - (_z_2);
")})));
end CCodeGenTest11;


model CCodeGenTest12
  Real x(start=1,fixed=true);
equation
  der(x) = (x-0.3)^0.3 + (x-0.3)^3;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CCodeGenTest12",
			description="C code generation: test that x^2 is represented by x*x in the generated code. ",
			template="$C_DAE_equation_residuals$",
			generatedCode="
    (*res)[0] = pow(_x_0 - ( 0.3 ),0.3) + (1.0 * (_x_0 - ( 0.3 )) * (_x_0 - ( 0.3 )) * (_x_0 - ( 0.3 ))) - (_der_x_1);
")})));
end CCodeGenTest12;


model CCodeGenTest13
	constant Integer ci = 1;
	constant Integer cd = ci;
	parameter Integer pi = 2;
	parameter Integer pd = pi;

	type A = enumeration(a, b, c);
	type B = enumeration(d, e, f);
	
	constant A aic = A.a;
	constant B bic = B.e;
	constant A adc = aic;
	constant B bdc = bic;
	parameter A aip = A.b;
	parameter B bip = B.f;
	parameter A adp = aip;
	parameter B bdp = bip;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CCodeGenTest13",
			description="Code generation for enumerations: variable aliases",
			template="$C_variable_aliases$",
			generatedCode="
#define _ci_0 ((*(jmi->z))[jmi->offs_integer_ci+0])
#define _cd_1 ((*(jmi->z))[jmi->offs_integer_ci+1])
#define _aic_4 ((*(jmi->z))[jmi->offs_integer_ci+2])
#define _bic_5 ((*(jmi->z))[jmi->offs_integer_ci+3])
#define _adc_6 ((*(jmi->z))[jmi->offs_integer_ci+4])
#define _bdc_7 ((*(jmi->z))[jmi->offs_integer_ci+5])
#define _pi_2 ((*(jmi->z))[jmi->offs_integer_pi+0])
#define _aip_8 ((*(jmi->z))[jmi->offs_integer_pi+1])
#define _bip_9 ((*(jmi->z))[jmi->offs_integer_pi+2])
#define _pd_3 ((*(jmi->z))[jmi->offs_integer_pd+0])
#define _adp_10 ((*(jmi->z))[jmi->offs_integer_pd+1])
#define _bdp_11 ((*(jmi->z))[jmi->offs_integer_pd+2])
#define _time ((*(jmi->z))[jmi->offs_t])	 
")})));
end CCodeGenTest13;



model CLogExp1
 Boolean x = true;
 Boolean y = false;
 Real z = noEvent(if x and y then 1.0 else 2.0);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CLogExp1",
			description="C code generation for logical operators: and",
			template="$C_DAE_equation_residuals$",
			generatedCode="
    (*res)[0] = JMI_TRUE - (_x_0);
    (*res)[1] = JMI_FALSE - (_y_1);
    (*res)[2] = COND_EXP_EQ(LOG_EXP_AND(_x_0, _y_1),JMI_TRUE,AD_WRAP_LITERAL(1.0),AD_WRAP_LITERAL(2.0)) - (_z_2);
")})));
end CLogExp1;


model CLogExp2
 Boolean x = true;
 Boolean y = false;
 Real z = noEvent(if x or y then 1.0 else 2.0);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CLogExp2",
			description="C code generation for logical operators: or",
			template="$C_DAE_equation_residuals$",
			generatedCode="
    (*res)[0] = JMI_TRUE - (_x_0);
    (*res)[1] = JMI_FALSE - (_y_1);
    (*res)[2] = COND_EXP_EQ(LOG_EXP_OR(_x_0, _y_1),JMI_TRUE,AD_WRAP_LITERAL(1.0),AD_WRAP_LITERAL(2.0)) - (_z_2);
")})));
end CLogExp2;


model CLogExp3
 Boolean x = true;
 Real y = noEvent(if not x then 1.0 else 2.0);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CLogExp3",
			description="C code generation for logical operators: not",
			template="$C_DAE_equation_residuals$",
			generatedCode="
    (*res)[0] = JMI_TRUE - (_x_0);
    (*res)[1] = COND_EXP_EQ(LOG_EXP_NOT(_x_0),JMI_TRUE,AD_WRAP_LITERAL(1.0),AD_WRAP_LITERAL(2.0)) - (_y_1);
")})));
end CLogExp3;




model CCodeGenDiscreteVariables1
  constant Real c1 = 1;
  constant Real c2 = c1;
  parameter Real p1 = 1;
  parameter Real p2 = p1;
  discrete Real rd1 = 4;
  discrete Real rd2 = rd1;
  Real x(start=1);
  Real w = 4;

  constant Integer ci1 = 1;
  constant Integer ci2 = ci1;
  parameter Integer pi1 = 1;
  parameter Integer pi2 = pi1;
  discrete Integer rid1 = 4;
  discrete Integer rid2 = rid1;

  constant Boolean cb1 = true;
  constant Boolean cb2 = cb1;
  parameter Boolean pb1 = true;
  parameter Boolean pb2 = pb1;
  discrete Boolean rbd1 = false;
  discrete Boolean rbd2 = rbd1;

equation
  der(x) = -x;


	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CCodeGenDiscreteVariables1",
			description="Test C code generation of discrete variables.",
			template="
$C_variable_aliases$
$C_DAE_equation_residuals$
",
         generatedCode="
#define _c1_0 ((*(jmi->z))[jmi->offs_real_ci+0])
#define _c2_1 ((*(jmi->z))[jmi->offs_real_ci+1])
#define _p1_2 ((*(jmi->z))[jmi->offs_real_pi+0])
#define _p2_3 ((*(jmi->z))[jmi->offs_real_pd+0])
#define _ci1_7 ((*(jmi->z))[jmi->offs_integer_ci+0])
#define _ci2_8 ((*(jmi->z))[jmi->offs_integer_ci+1])
#define _pi1_9 ((*(jmi->z))[jmi->offs_integer_pi+0])
#define _pi2_10 ((*(jmi->z))[jmi->offs_integer_pd+0])
#define _cb1_12 ((*(jmi->z))[jmi->offs_boolean_ci+0])
#define _cb2_13 ((*(jmi->z))[jmi->offs_boolean_ci+1])
#define _pb1_14 ((*(jmi->z))[jmi->offs_boolean_pi+0])
#define _pb2_15 ((*(jmi->z))[jmi->offs_boolean_pd+0])
#define _der_x_17 ((*(jmi->z))[jmi->offs_real_dx+0])
#define _x_5 ((*(jmi->z))[jmi->offs_real_x+0])
#define _w_6 ((*(jmi->z))[jmi->offs_real_w+0])
#define _time ((*(jmi->z))[jmi->offs_t])
#define _rd2_4 ((*(jmi->z))[jmi->offs_real_d+0])
#define _rid2_11 ((*(jmi->z))[jmi->offs_integer_d+0])
#define _rbd2_16 ((*(jmi->z))[jmi->offs_boolean_d+0])

    (*res)[0] =  - ( _x_5 ) - (_der_x_17);
    (*res)[1] = 4 - (_rd2_4);
    (*res)[2] = 4 - (_w_6);
    (*res)[3] = 4 - (_rid2_11);
    (*res)[4] = JMI_FALSE - (_rbd2_16);
")})));
end CCodeGenDiscreteVariables1;


model CCodeGenParameters1
	function f
		input Real x;
		output Real y;
		external "C";
	end f;
	
	parameter Real x = 1;
	parameter Real y = x;
	parameter Real z = f(1);
	Real dummy = x;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CCodeGenParameters1",
			description="Make sure scaling is applied properly when setting to parameter values",
			generate_dae=true,
			enable_variable_scaling=true,
			template="
$C_DAE_initial_dependent_parameter_assignments$
$C_set_start_values$
",
         generatedCode="
    _y_1 = ((_x_0*sf(0)))/sf(2);

    _x_0 = (1)/sf(0);
    _z_2 = (func_CCodeGenTests_CCodeGenParameters1_f_exp(AD_WRAP_LITERAL(1)))/sf(1);
   model_init_eval_parameters(jmi);
   jmi->indep_extobjs_initialized = 1;
")})));
end CCodeGenParameters1;

model CCodeGenUniqueNames
 model A
  Real y;
 end A;
 
 Real x_y = 1;
 A x(y = x_y + 2);
 Real der_x_y = der(x_y) - 1;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CCodeGenUniqueNames",
			enable_structural_diagnosis=false,
			index_reduction=false,
			description="Test that unique names are generated for each variable",
			template="
$C_variable_aliases$
$C_DAE_equation_residuals$
",
         generatedCode="
#define _der_x_y_3 ((*(jmi->z))[jmi->offs_real_dx+0])
#define _x_y_0 ((*(jmi->z))[jmi->offs_real_x+0])
#define _x_y_1 ((*(jmi->z))[jmi->offs_real_w+0])
#define _der_x_y_2 ((*(jmi->z))[jmi->offs_real_w+1])
#define _time ((*(jmi->z))[jmi->offs_t])

    (*res)[0] = 1 - (_x_y_0);
    (*res)[1] = _x_y_0 + 2 - (_x_y_1);
    (*res)[2] = _der_x_y_3 - ( 1 ) - (_der_x_y_2);
")})));
end CCodeGenUniqueNames;


model CCodeGenDotOp
 Real x[2,2] = y .* y ./ (y .+ y .- 2) .^ y;
 Real y[2,2] = {{1,2},{3,4}};

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CCodeGenDotOp",
			description="C code generation of dot operators (.+, .*, etc)",
			template="$C_DAE_equation_residuals$",
			generatedCode="
    (*res)[0] = jmi_divide(( _y_1_1_4 ) * ( _y_1_1_4 ),pow(_y_1_1_4 + _y_1_1_4 - ( 2 ),_y_1_1_4),\"Divide by zero: ( ( y[1,1] ) .* ( y[1,1] ) ) ./ ( ( y[1,1] .+ y[1,1] .- ( 2 ) ) .^ y[1,1] )\") - (_x_1_1_0);
    (*res)[1] = jmi_divide(( _y_1_2_5 ) * ( _y_1_2_5 ),pow(_y_1_2_5 + _y_1_2_5 - ( 2 ),_y_1_2_5),\"Divide by zero: ( ( y[1,2] ) .* ( y[1,2] ) ) ./ ( ( y[1,2] .+ y[1,2] .- ( 2 ) ) .^ y[1,2] )\") - (_x_1_2_1);
    (*res)[2] = jmi_divide(( _y_2_1_6 ) * ( _y_2_1_6 ),pow(_y_2_1_6 + _y_2_1_6 - ( 2 ),_y_2_1_6),\"Divide by zero: ( ( y[2,1] ) .* ( y[2,1] ) ) ./ ( ( y[2,1] .+ y[2,1] .- ( 2 ) ) .^ y[2,1] )\") - (_x_2_1_2);
    (*res)[3] = jmi_divide(( _y_2_2_7 ) * ( _y_2_2_7 ),pow(_y_2_2_7 + _y_2_2_7 - ( 2 ),_y_2_2_7),\"Divide by zero: ( ( y[2,2] ) .* ( y[2,2] ) ) ./ ( ( y[2,2] .+ y[2,2] .- ( 2 ) ) .^ y[2,2] )\") - (_x_2_2_3);
    (*res)[4] = 1 - (_y_1_1_4);
    (*res)[5] = 2 - (_y_1_2_5);
    (*res)[6] = 3 - (_y_2_1_6);
    (*res)[7] = 4 - (_y_2_2_7);
")})));
end CCodeGenDotOp;



model CCodeGenMinMax
 Real x[2,2] = {{1,2},{3,4}};
 Real y1 = min(x);
 Real y2 = min(1, 2);
 Real y3 = max(x);
 Real y4 = max(1, 2);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CCodeGenMinMax",
			description="C code generation of min() and max()",
			template="$C_DAE_equation_residuals$",
			generatedCode="
    (*res)[0] = 1 - (_x_1_1_0);
    (*res)[1] = 2 - (_x_1_2_1);
    (*res)[2] = 3 - (_x_2_1_2);
    (*res)[3] = 4 - (_x_2_2_3);
    (*res)[4] = jmi_min(jmi_min(jmi_min(_x_1_1_0, _x_1_2_1), _x_2_1_2), _x_2_2_3) - (_y1_4);
    (*res)[5] = jmi_min(AD_WRAP_LITERAL(1), AD_WRAP_LITERAL(2)) - (_y2_5);
    (*res)[6] = jmi_max(jmi_max(jmi_max(_x_1_1_0, _x_1_2_1), _x_2_1_2), _x_2_2_3) - (_y3_6);
    (*res)[7] = jmi_max(AD_WRAP_LITERAL(1), AD_WRAP_LITERAL(2)) - (_y4_7);
")})));
end CCodeGenMinMax;



/* ====================== Function tests =================== */

/* Functions used in tests */
function TestFunction0
 output Real o1 = 0;
algorithm
end TestFunction0;

function TestFunction1
 input Real i1 = 0;
 output Real o1 = i1;
algorithm
end TestFunction1;

function TestFunction2
 input Real i1 = 0;
 input Real i2 = 0;
 output Real o1 = 0;
 output Real o2 = i2;
algorithm
 o1 := i1;
end TestFunction2;

function TestFunction3
 input Real i1;
 input Real i2;
 input Real i3 = 0;
 output Real o1 = i1 + i2 + i3;
 output Real o2 = i2 + i3;
 output Real o3 = i1 + i2;
algorithm
end TestFunction3;

function TestFunctionNoOut
 input Real i1;
algorithm
end TestFunctionNoOut;

function TestFunctionCallingFunction
 input Real i1;
 output Real o1;
algorithm
 o1 := TestFunction1(i1);
end TestFunctionCallingFunction;

function TestFunctionRecursive
 input Integer i1;
 output Integer o1;
algorithm
 if i1 < 3 then
  o1 := 1;
 else
  o1 := TestFunctionRecursive(i1 - 1) + TestFunctionRecursive(i1 - 2);
 end if;
end TestFunctionRecursive;


/* Function tests */
model CFunctionTest1
 Real x;
equation
 x = TestFunction1(2.0);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CFunctionTest1",
			description="Test of code generation",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_TestFunction1_def(jmi_ad_var_t i1_v, jmi_ad_var_t* o1_o);
jmi_ad_var_t func_CCodeGenTests_TestFunction1_exp(jmi_ad_var_t i1_v);

void func_CCodeGenTests_TestFunction1_def(jmi_ad_var_t i1_v, jmi_ad_var_t* o1_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t o1_v;
    o1_v = i1_v;
    if (o1_o != NULL) *o1_o = o1_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_TestFunction1_exp(jmi_ad_var_t i1_v) {
    jmi_ad_var_t o1_v;
    func_CCodeGenTests_TestFunction1_def(i1_v, &o1_v);
    return o1_v;
}


    (*res)[0] = func_CCodeGenTests_TestFunction1_exp(2.0) - (_x_0);
")})));
end CFunctionTest1;

model CFunctionTest2
 Real x;
 Real y;
equation
 (x, y) = TestFunction2(1, 2);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CFunctionTest2",
			description="C code gen: functions: using multiple outputs",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_TestFunction2_def(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v, jmi_ad_var_t* o1_o, jmi_ad_var_t* o2_o);
jmi_ad_var_t func_CCodeGenTests_TestFunction2_exp(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v);

void func_CCodeGenTests_TestFunction2_def(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v, jmi_ad_var_t* o1_o, jmi_ad_var_t* o2_o) {
   JMI_DYNAMIC_INIT()
   jmi_ad_var_t o1_v;
   jmi_ad_var_t o2_v;
   o1_v = 0;
   o2_v = i2_v;
   o1_v = i1_v;
   if (o1_o != NULL) *o1_o = o1_v;
   if (o2_o != NULL) *o2_o = o2_v;
   JMI_DYNAMIC_FREE()
   return;
}

jmi_ad_var_t func_CCodeGenTests_TestFunction2_exp(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v) {
   jmi_ad_var_t o1_v;
   func_CCodeGenTests_TestFunction2_def(i1_v, i2_v, &o1_v, NULL);
   return o1_v;
}


    jmi_ad_var_t tmp_1;
    jmi_ad_var_t tmp_2;
    func_CCodeGenTests_TestFunction2_def(AD_WRAP_LITERAL(1), AD_WRAP_LITERAL(2), &tmp_1, &tmp_2);
    (*res)[0] = tmp_1 - (_x_0);
    (*res)[1] = tmp_2 - (_y_1);
")})));
end CFunctionTest2;

model CFunctionTest3
 Real x;
 Real y = TestFunction2(2, 3);
equation
 x = TestFunction2(1);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CFunctionTest3",
			description="C code gen: functions: two calls to same function",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_TestFunction2_def(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v, jmi_ad_var_t* o1_o, jmi_ad_var_t* o2_o);
jmi_ad_var_t func_CCodeGenTests_TestFunction2_exp(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v);

void func_CCodeGenTests_TestFunction2_def(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v, jmi_ad_var_t* o1_o, jmi_ad_var_t* o2_o) {
   JMI_DYNAMIC_INIT()
   jmi_ad_var_t o1_v;
   jmi_ad_var_t o2_v;
   o1_v = 0;
   o2_v = i2_v;
   o1_v = i1_v;
   if (o1_o != NULL) *o1_o = o1_v;
   if (o2_o != NULL) *o2_o = o2_v;
   JMI_DYNAMIC_FREE()
   return;
}

jmi_ad_var_t func_CCodeGenTests_TestFunction2_exp(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v) {
   jmi_ad_var_t o1_v;
   func_CCodeGenTests_TestFunction2_def(i1_v, i2_v, &o1_v, NULL);
   return o1_v;
}


    (*res)[0] = func_CCodeGenTests_TestFunction2_exp(AD_WRAP_LITERAL(1), AD_WRAP_LITERAL(0)) - (_x_0);
    (*res)[1] = func_CCodeGenTests_TestFunction2_exp(AD_WRAP_LITERAL(2), AD_WRAP_LITERAL(3)) - (_y_1);
")})));
end CFunctionTest3;

model CFunctionTest4
 Real x;
 Real y = TestFunction2(2, 3);
equation
 x = TestFunction1(y * 2);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CFunctionTest4",
			description="C code gen: functions: calls to two functions",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_TestFunction2_def(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v, jmi_ad_var_t* o1_o, jmi_ad_var_t* o2_o);
jmi_ad_var_t func_CCodeGenTests_TestFunction2_exp(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v);
void func_CCodeGenTests_TestFunction1_def(jmi_ad_var_t i1_v, jmi_ad_var_t* o1_o);
jmi_ad_var_t func_CCodeGenTests_TestFunction1_exp(jmi_ad_var_t i1_v);

void func_CCodeGenTests_TestFunction2_def(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v, jmi_ad_var_t* o1_o, jmi_ad_var_t* o2_o) {
   JMI_DYNAMIC_INIT()
   jmi_ad_var_t o1_v;
   jmi_ad_var_t o2_v;
   o1_v = 0;
   o2_v = i2_v;
   o1_v = i1_v;
   if (o1_o != NULL) *o1_o = o1_v;
   if (o2_o != NULL) *o2_o = o2_v;
   JMI_DYNAMIC_FREE()
   return;
}

jmi_ad_var_t func_CCodeGenTests_TestFunction2_exp(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v) {
   jmi_ad_var_t o1_v;
   func_CCodeGenTests_TestFunction2_def(i1_v, i2_v, &o1_v, NULL);
   return o1_v;
}

void func_CCodeGenTests_TestFunction1_def(jmi_ad_var_t i1_v, jmi_ad_var_t* o1_o) {
   JMI_DYNAMIC_INIT()
   jmi_ad_var_t o1_v;
   o1_v = i1_v;
   if (o1_o != NULL) *o1_o = o1_v;
   JMI_DYNAMIC_FREE()
   return;
}

jmi_ad_var_t func_CCodeGenTests_TestFunction1_exp(jmi_ad_var_t i1_v) {
   jmi_ad_var_t o1_v;
   func_CCodeGenTests_TestFunction1_def(i1_v, &o1_v);
   return o1_v;
}


    (*res)[0] = func_CCodeGenTests_TestFunction1_exp(( _y_1 ) * ( AD_WRAP_LITERAL(2) )) - (_x_0);
    (*res)[1] = func_CCodeGenTests_TestFunction2_exp(AD_WRAP_LITERAL(2), AD_WRAP_LITERAL(3)) - (_y_1);
")})));
end CFunctionTest4;

model CFunctionTest5
  Real x;
  Real y;
equation
  (x, y) = TestFunction3(1, 2, 3);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CFunctionTest5",
			description="C code gen: functions: fewer components assigned than outputs",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_TestFunction3_def(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v, jmi_ad_var_t i3_v, jmi_ad_var_t* o1_o, jmi_ad_var_t* o2_o, jmi_ad_var_t* o3_o);
jmi_ad_var_t func_CCodeGenTests_TestFunction3_exp(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v, jmi_ad_var_t i3_v);

void func_CCodeGenTests_TestFunction3_def(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v, jmi_ad_var_t i3_v, jmi_ad_var_t* o1_o, jmi_ad_var_t* o2_o, jmi_ad_var_t* o3_o) {
   JMI_DYNAMIC_INIT()
   jmi_ad_var_t o1_v;
   jmi_ad_var_t o2_v;
   jmi_ad_var_t o3_v;
   o1_v = i1_v + i2_v + i3_v;
   o2_v = i2_v + i3_v;
   o3_v = i1_v + i2_v;
   if (o1_o != NULL) *o1_o = o1_v;
   if (o2_o != NULL) *o2_o = o2_v;
   if (o3_o != NULL) *o3_o = o3_v;
   JMI_DYNAMIC_FREE()
   return;
}

jmi_ad_var_t func_CCodeGenTests_TestFunction3_exp(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v, jmi_ad_var_t i3_v) {
   jmi_ad_var_t o1_v;
   func_CCodeGenTests_TestFunction3_def(i1_v, i2_v, i3_v, &o1_v, NULL, NULL);
   return o1_v;
}


    jmi_ad_var_t tmp_1;
    jmi_ad_var_t tmp_2;
    func_CCodeGenTests_TestFunction3_def(AD_WRAP_LITERAL(1), AD_WRAP_LITERAL(2), AD_WRAP_LITERAL(3), &tmp_1, &tmp_2, NULL);
    (*res)[0] = tmp_1 - (_x_0);
    (*res)[1] = tmp_2 - (_y_1);
")})));
end CFunctionTest5;

model CFunctionTest6
  Real x;
  Real z;
equation
  (x, , z) = TestFunction3(1, 2, 3);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CFunctionTest6",
			description="C code gen: functions: one output skipped",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_TestFunction3_def(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v, jmi_ad_var_t i3_v, jmi_ad_var_t* o1_o, jmi_ad_var_t* o2_o, jmi_ad_var_t* o3_o);
jmi_ad_var_t func_CCodeGenTests_TestFunction3_exp(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v, jmi_ad_var_t i3_v);

void func_CCodeGenTests_TestFunction3_def(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v, jmi_ad_var_t i3_v, jmi_ad_var_t* o1_o, jmi_ad_var_t* o2_o, jmi_ad_var_t* o3_o) {
   JMI_DYNAMIC_INIT()
   jmi_ad_var_t o1_v;
   jmi_ad_var_t o2_v;
   jmi_ad_var_t o3_v;
   o1_v = i1_v + i2_v + i3_v;
   o2_v = i2_v + i3_v;
   o3_v = i1_v + i2_v;
   if (o1_o != NULL) *o1_o = o1_v;
   if (o2_o != NULL) *o2_o = o2_v;
   if (o3_o != NULL) *o3_o = o3_v;
   JMI_DYNAMIC_FREE()
   return;
}

jmi_ad_var_t func_CCodeGenTests_TestFunction3_exp(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v, jmi_ad_var_t i3_v) {
   jmi_ad_var_t o1_v;
   func_CCodeGenTests_TestFunction3_def(i1_v, i2_v, i3_v, &o1_v, NULL, NULL);
   return o1_v;
}


    jmi_ad_var_t tmp_1;
    jmi_ad_var_t tmp_2;
    func_CCodeGenTests_TestFunction3_def(AD_WRAP_LITERAL(1), AD_WRAP_LITERAL(2), AD_WRAP_LITERAL(3), &tmp_1, NULL, &tmp_2);
    (*res)[0] = tmp_1 - (_x_0);
    (*res)[1] = tmp_2 - (_z_1);
")})));
end CFunctionTest6;

model CFunctionTest7
equation
  TestFunction2(1, 2);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CFunctionTest7",
			description="C code gen: functions: no components assigned",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_TestFunction2_def(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v, jmi_ad_var_t* o1_o, jmi_ad_var_t* o2_o);
jmi_ad_var_t func_CCodeGenTests_TestFunction2_exp(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v);

void func_CCodeGenTests_TestFunction2_def(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v, jmi_ad_var_t* o1_o, jmi_ad_var_t* o2_o) {
   JMI_DYNAMIC_INIT()
   jmi_ad_var_t o1_v;
   jmi_ad_var_t o2_v;
   o1_v = 0;
   o2_v = i2_v;
   o1_v = i1_v;
   if (o1_o != NULL) *o1_o = o1_v;
   if (o2_o != NULL) *o2_o = o2_v;
   JMI_DYNAMIC_FREE()
   return;
}

jmi_ad_var_t func_CCodeGenTests_TestFunction2_exp(jmi_ad_var_t i1_v, jmi_ad_var_t i2_v) {
   jmi_ad_var_t o1_v;
   func_CCodeGenTests_TestFunction2_def(i1_v, i2_v, &o1_v, NULL);
   return o1_v;
}


    func_CCodeGenTests_TestFunction2_def(AD_WRAP_LITERAL(1), AD_WRAP_LITERAL(2), NULL, NULL);
")})));
end CFunctionTest7;

model CFunctionTest8
 Real x = TestFunctionCallingFunction(1);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CFunctionTest8",
			description="C code gen: functions: function calling other function",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_TestFunctionCallingFunction_def(jmi_ad_var_t i1_v, jmi_ad_var_t* o1_o);
jmi_ad_var_t func_CCodeGenTests_TestFunctionCallingFunction_exp(jmi_ad_var_t i1_v);
void func_CCodeGenTests_TestFunction1_def(jmi_ad_var_t i1_v, jmi_ad_var_t* o1_o);
jmi_ad_var_t func_CCodeGenTests_TestFunction1_exp(jmi_ad_var_t i1_v);

void func_CCodeGenTests_TestFunctionCallingFunction_def(jmi_ad_var_t i1_v, jmi_ad_var_t* o1_o) {
   JMI_DYNAMIC_INIT()
   jmi_ad_var_t o1_v;
   o1_v = func_CCodeGenTests_TestFunction1_exp(i1_v);
   if (o1_o != NULL) *o1_o = o1_v;
   JMI_DYNAMIC_FREE()
   return;
}

jmi_ad_var_t func_CCodeGenTests_TestFunctionCallingFunction_exp(jmi_ad_var_t i1_v) {
   jmi_ad_var_t o1_v;
   func_CCodeGenTests_TestFunctionCallingFunction_def(i1_v, &o1_v);
   return o1_v;
}

void func_CCodeGenTests_TestFunction1_def(jmi_ad_var_t i1_v, jmi_ad_var_t* o1_o) {
   JMI_DYNAMIC_INIT()
   jmi_ad_var_t o1_v;
   o1_v = i1_v;
   if (o1_o != NULL) *o1_o = o1_v;
   JMI_DYNAMIC_FREE()
   return;
}

jmi_ad_var_t func_CCodeGenTests_TestFunction1_exp(jmi_ad_var_t i1_v) {
   jmi_ad_var_t o1_v;
   func_CCodeGenTests_TestFunction1_def(i1_v, &o1_v);
   return o1_v;
}


    (*res)[0] = func_CCodeGenTests_TestFunctionCallingFunction_exp(AD_WRAP_LITERAL(1)) - (_x_0);
")})));
end CFunctionTest8;


/* TODO: Why is this commented out?
model CFunctionTest9
 Real x = TestFunctionRecursive(5);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CFunctionTest9",
			description="C code gen: functions:",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_TestFunctionRecursive_def(jmi_ad_var_t i1_v, jmi_ad_var_t* o1_o);
jmi_ad_var_t func_CCodeGenTests_TestFunctionRecursive_exp(jmi_ad_var_t i1_v);

void func_CCodeGenTests_TestFunctionRecursive_def(jmi_ad_var_t i1_v, jmi_ad_var_t* o1_o) {
   JMI_DYNAMIC_INIT()
   jmi_ad_var_t o1_v;
   if (i1_v < 3) {
       o1_v = 1;
   } else {
       o1_v = func_CCodeGenTests_TestFunctionRecursive_exp(i1_v - ( 1 )) + func_CCodeGenTests_TestFunctionRecursive_exp(i1_v - ( 2 ));
   }
   if (o1_o != NULL) *o1_o = o1_v;
   JMI_DYNAMIC_FREE()
   return;
}

jmi_ad_var_t func_CCodeGenTests_TestFunctionRecursive_exp(jmi_ad_var_t i1_v) {
   jmi_ad_var_t o1_v;
   func_CCodeGenTests_TestFunctionRecursive_def(i1_v, &o1_v);
   return o1_v;
}


    (*res)[0] = func_CCodeGenTests_TestFunctionRecursive_exp(5) - (_x_0);
")})));
end CFunctionTest9;
*/

model CFunctionTest10
 Real x = TestFunction0();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CFunctionTest10",
			description="C code gen: functions: no inputs",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_TestFunction0_def(jmi_ad_var_t* o1_o);
jmi_ad_var_t func_CCodeGenTests_TestFunction0_exp();

void func_CCodeGenTests_TestFunction0_def(jmi_ad_var_t* o1_o) {
   JMI_DYNAMIC_INIT()
   jmi_ad_var_t o1_v;
   o1_v = 0;
   if (o1_o != NULL) *o1_o = o1_v;
   JMI_DYNAMIC_FREE()
   return;
}

jmi_ad_var_t func_CCodeGenTests_TestFunction0_exp() {
   jmi_ad_var_t o1_v;
   func_CCodeGenTests_TestFunction0_def(&o1_v);
   return o1_v;
}


    (*res)[0] = func_CCodeGenTests_TestFunction0_exp() - (_x_0);
")})));
end CFunctionTest10;

model CFunctionTest11
equation
 TestFunctionNoOut(1);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CFunctionTest11",
			description="C code gen: functions: no outputs",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_TestFunctionNoOut_def(jmi_ad_var_t i1_v);

void func_CCodeGenTests_TestFunctionNoOut_def(jmi_ad_var_t i1_v) {
   JMI_DYNAMIC_INIT()
   JMI_DYNAMIC_FREE()
   return;
}


    func_CCodeGenTests_TestFunctionNoOut_def(AD_WRAP_LITERAL(1));
")})));
end CFunctionTest11;

model CFunctionTest12

function f
  input Real x[2];
  output Real y[2];
algorithm
  y:=x;
end f;
Real z[2](each nominal=3)={1,1};
Real w[2];
equation
w=f(z);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CFunctionTest12",
			description="C code gen: function and variable scaling",
			enable_variable_scaling=true,
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_CFunctionTest12_f_def(jmi_array_t* x_a, jmi_array_t* y_a);


void func_CCodeGenTests_CFunctionTest12_f_def(jmi_array_t* x_a, jmi_array_t* y_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_STATIC(y_an, 2, 1)
	    if (y_a == NULL) {
        JMI_ARRAY_STATIC_INIT_1(y_an, 2)
        y_a = y_an;
    }
    jmi_array_ref_1(y_a, 1) = jmi_array_val_1(x_a, 1);
    jmi_array_ref_1(y_a, 2) = jmi_array_val_1(x_a, 2);
    JMI_DYNAMIC_FREE()
    return;
}

    JMI_ARRAY_STATIC(tmp_1, 2, 1)
    JMI_ARRAY_STATIC(tmp_2, 2, 1)
    JMI_ARRAY_STATIC_INIT_1(tmp_1, 2)
    JMI_ARRAY_STATIC_INIT_1(tmp_2, 2)
    jmi_array_ref_1(tmp_2, 1) = (_z_1_0*sf(0));
    jmi_array_ref_1(tmp_2, 2) = (_z_2_1*sf(1));
    func_CCodeGenTests_CFunctionTest12_f_def(tmp_2, tmp_1);
    (*res)[0] = jmi_array_val_1(tmp_1, 1) - ((_w_1_2*sf(2)));
    (*res)[1] = jmi_array_val_1(tmp_1, 2) - ((_w_2_3*sf(3)));
    (*res)[2] = 1 - ((_z_1_0*sf(0)));
    (*res)[3] = 1 - ((_z_2_1*sf(1)));

")})));
end CFunctionTest12;


model CFunctionTest13

		
function F
  input Real x[2];
  input Real u;
  output Real dx[2];
  output Real y[2];
algorithm
  dx := -x + {u,0};
  y := 2*x;
end F;

Real x[2](each start = 3);
Real z[2];
Real u = 3;
Real y[2];
equation
 der(x) = -x;
(z,y) = F(x,u);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CFunctionTest13",
			description="C code gen: solved function call equation",
			generate_ode=true,
			equation_sorting=true,
			template="
$C_function_headers$
$C_functions$
$C_ode_derivatives$
",
         generatedCode="
void func_CCodeGenTests_CFunctionTest13_F_def(jmi_array_t* x_a, jmi_ad_var_t u_v, jmi_array_t* dx_a, jmi_array_t* y_a);

void func_CCodeGenTests_CFunctionTest13_F_def(jmi_array_t* x_a, jmi_ad_var_t u_v, jmi_array_t* dx_a, jmi_array_t* y_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_STATIC(dx_an, 2, 1)
    JMI_ARRAY_STATIC(y_an, 2, 1)
    if (dx_a == NULL) {
        JMI_ARRAY_STATIC_INIT_1(dx_an, 2)
        dx_a = dx_an;
    }
    if (y_a == NULL) {
        JMI_ARRAY_STATIC_INIT_1(y_an, 2)
        y_a = y_an;
    }
    jmi_array_ref_1(dx_a, 1) =  - ( jmi_array_val_1(x_a, 1) ) + u_v;
    jmi_array_ref_1(dx_a, 2) =  - ( jmi_array_val_1(x_a, 2) ) + 0;
    jmi_array_ref_1(y_a, 1) = ( 2 ) * ( jmi_array_val_1(x_a, 1) );
    jmi_array_ref_1(y_a, 2) = ( 2 ) * ( jmi_array_val_1(x_a, 2) );
    JMI_DYNAMIC_FREE()
    return;
}

    JMI_ARRAY_STATIC(tmp_1, 2, 1)
    JMI_ARRAY_STATIC(tmp_2, 2, 1)
    JMI_ARRAY_STATIC(tmp_3, 2, 1)
    model_ode_guards(jmi);
/************* ODE section *********/
  _der_x_1_7 =  - ( _x_1_0 );
  _der_x_2_8 =  - ( _x_2_1 );
/************ Real outputs *********/
/****Integer and boolean outputs ***/
/**** Other variables ***/
  _u_4 = 3;
  JMI_ARRAY_STATIC_INIT_1(tmp_1, 2)
  JMI_ARRAY_STATIC_INIT_1(tmp_2, 2)
  JMI_ARRAY_STATIC_INIT_1(tmp_3, 2)
  jmi_array_ref_1(tmp_3, 1) = _x_1_0;
  jmi_array_ref_1(tmp_3, 2) = _x_2_1;
  func_CCodeGenTests_CFunctionTest13_F_def(tmp_3, _u_4, tmp_1, tmp_2);
  _z_1_2 = (jmi_array_val_1(tmp_1, 1));
  _z_2_3 = (jmi_array_val_1(tmp_1, 2));
  _y_1_5 = (jmi_array_val_1(tmp_2, 1));
  _y_2_6 = (jmi_array_val_1(tmp_2, 2));
	 
")})));
end CFunctionTest13;

model CFunctionTest14
function F
  input Real x[2];
  input Real u;
  output Real dx[2];
  output Real y[2];
algorithm
  dx := -x + {u,0};
  y := 2*x;
end F;

Real x[2](each start = 3);
Real z[2];
Real u = 3;
Real y[2];
equation
 der(x) = -x;
(z,y) = F(z+x,u);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CFunctionTest14",
			description="C code gen: unsolved function call equation",
			generate_ode=true,
			equation_sorting=true,
			template="
$C_function_headers$
$C_functions$
$C_ode_derivatives$
",
         generatedCode="
void func_CCodeGenTests_CFunctionTest14_F_def(jmi_array_t* x_a, jmi_ad_var_t u_v, jmi_array_t* dx_a, jmi_array_t* y_a);

void func_CCodeGenTests_CFunctionTest14_F_def(jmi_array_t* x_a, jmi_ad_var_t u_v, jmi_array_t* dx_a, jmi_array_t* y_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_STATIC(dx_an, 2, 1)
    JMI_ARRAY_STATIC(y_an, 2, 1)
    if (dx_a == NULL) {
        JMI_ARRAY_STATIC_INIT_1(dx_an, 2)
        dx_a = dx_an;
    }
    if (y_a == NULL) {
        JMI_ARRAY_STATIC_INIT_1(y_an, 2)
        y_a = y_an;
    }
    jmi_array_ref_1(dx_a, 1) =  - ( jmi_array_val_1(x_a, 1) ) + u_v;
    jmi_array_ref_1(dx_a, 2) =  - ( jmi_array_val_1(x_a, 2) ) + 0;
    jmi_array_ref_1(y_a, 1) = ( 2 ) * ( jmi_array_val_1(x_a, 1) );
    jmi_array_ref_1(y_a, 2) = ( 2 ) * ( jmi_array_val_1(x_a, 2) );
    JMI_DYNAMIC_FREE()
    return;
}

    model_ode_guards(jmi);
/************* ODE section *********/
  _der_x_1_7 =  - ( _x_1_0 );
  _der_x_2_8 =  - ( _x_2_1 );
/************ Real outputs *********/
/****Integer and boolean outputs ***/
/**** Other variables ***/
  _u_4 = 3;
  ef |= jmi_solve_block_residual(jmi->dae_block_residuals[0]);

")})));
end CFunctionTest14;

model CForLoop1
 function f
  output Real o = 1.0;
  protected Real x = 0;
  algorithm
  for i in 1:3 loop
   x := x + i;
  end for;
 end f;
 
 Real x = f();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CForLoop1",
			description="C code generation for for loops: range exp",
			template="$C_functions$",
			generatedCode="
void func_CCodeGenTests_CForLoop1_f_def(jmi_ad_var_t* o_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t o_v;
    jmi_ad_var_t x_v;
    jmi_ad_var_t i_0i;
    jmi_ad_var_t i_0ie;
    o_v = 1.0;
    x_v = 0;
    i_0ie = 3 + 1 / 2.0;
    for (i_0i = 1; i_0i < i_0ie; i_0i += 1) {
        x_v = x_v + i_0i;
    }
    if (o_o != NULL) *o_o = o_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CForLoop1_f_exp() {
    jmi_ad_var_t o_v;
    func_CCodeGenTests_CForLoop1_f_def(&o_v);
    return o_v;
}

")})));
end CForLoop1;


model CForLoop2
 function f
  output Real o = 1.0;
  protected Real x = 0;
  algorithm
  for i in {2,3,5} loop
   x := x + i;
  end for;
 end f;
 
 Real x = f();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CForLoop2",
			description="C code generation for for loops: generic exp",
			template="$C_functions$",
			generatedCode="
void func_CCodeGenTests_CForLoop2_f_def(jmi_ad_var_t* o_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t o_v;
    jmi_ad_var_t x_v;
    jmi_ad_var_t i_0i;
    int i_0ii;
    jmi_ad_var_t i_0ia[3];
    o_v = 1.0;
    x_v = 0;
    i_0ia[0] = 2;
    i_0ia[1] = 3;
    i_0ia[2] = 5;
    for (i_0ii = 0; i_0ii < 3; i_0ii++) {
        i_0i = i_0ia[i_0ii];
        x_v = x_v + i_0i;
    }
    if (o_o != NULL) *o_o = o_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CForLoop2_f_exp() {
    jmi_ad_var_t o_v;
    func_CCodeGenTests_CForLoop2_f_def(&o_v);
    return o_v;
}

")})));
end CForLoop2;



model CArrayInput1
 function f
  input Real inp[3];
  output Real out = sum(inp);
 algorithm
 end f;
 
 Real x = f(1:3);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CArrayInput1",
			description="C code generation: array inputs to functions: basic test",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_CArrayInput1_f_def(jmi_array_t* inp_a, jmi_ad_var_t* out_o);
jmi_ad_var_t func_CCodeGenTests_CArrayInput1_f_exp(jmi_array_t* inp_a);

void func_CCodeGenTests_CArrayInput1_f_def(jmi_array_t* inp_a, jmi_ad_var_t* out_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t out_v;
    out_v = jmi_array_val_1(inp_a, 1) + jmi_array_val_1(inp_a, 2) + jmi_array_val_1(inp_a, 3);
    if (out_o != NULL) *out_o = out_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CArrayInput1_f_exp(jmi_array_t* inp_a) {
    jmi_ad_var_t out_v;
    func_CCodeGenTests_CArrayInput1_f_def(inp_a, &out_v);
    return out_v;
}


    JMI_ARRAY_STATIC(tmp_1, 3, 1)
    JMI_ARRAY_STATIC_INIT_1(tmp_1, 3)
    jmi_array_ref_1(tmp_1, 1) = AD_WRAP_LITERAL(1);
    jmi_array_ref_1(tmp_1, 2) = AD_WRAP_LITERAL(2);
    jmi_array_ref_1(tmp_1, 3) = AD_WRAP_LITERAL(3);
    (*res)[0] = func_CCodeGenTests_CArrayInput1_f_exp(tmp_1) - (_x_0);
")})));
end CArrayInput1;


model CArrayInput2
 function f
  input Real inp[3];
  output Real out = sum(inp);
 algorithm
 end f;
 
 Real x = 2 + 5 * f((1:3) + {3, 5, 7});

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CArrayInput2",
			description="C code generation: array inputs to functions: expressions around call",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_CArrayInput2_f_def(jmi_array_t* inp_a, jmi_ad_var_t* out_o);
jmi_ad_var_t func_CCodeGenTests_CArrayInput2_f_exp(jmi_array_t* inp_a);

void func_CCodeGenTests_CArrayInput2_f_def(jmi_array_t* inp_a, jmi_ad_var_t* out_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t out_v;
    out_v = jmi_array_val_1(inp_a, 1) + jmi_array_val_1(inp_a, 2) + jmi_array_val_1(inp_a, 3);
    if (out_o != NULL) *out_o = out_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CArrayInput2_f_exp(jmi_array_t* inp_a) {
    jmi_ad_var_t out_v;
    func_CCodeGenTests_CArrayInput2_f_def(inp_a, &out_v);
    return out_v;
}


    JMI_ARRAY_STATIC(tmp_1, 3, 1)
    JMI_ARRAY_STATIC_INIT_1(tmp_1, 3)
    jmi_array_ref_1(tmp_1, 1) = AD_WRAP_LITERAL(1) + AD_WRAP_LITERAL(3);
    jmi_array_ref_1(tmp_1, 2) = AD_WRAP_LITERAL(2) + AD_WRAP_LITERAL(5);
    jmi_array_ref_1(tmp_1, 3) = AD_WRAP_LITERAL(3) + AD_WRAP_LITERAL(7);
    (*res)[0] = 2 + ( 5 ) * ( func_CCodeGenTests_CArrayInput2_f_exp(tmp_1) ) - (_x_0);
")})));
end CArrayInput2;


model CArrayInput3
 function f
  input Real inp[3];
  output Real out = sum(inp);
 algorithm
 end f;
 
 Real x = f({f(1:3),f(4:6),f(7:9)});

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CArrayInput3",
			description="C code generation: array inputs to functions: nestled calls",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_CArrayInput3_f_def(jmi_array_t* inp_a, jmi_ad_var_t* out_o);
jmi_ad_var_t func_CCodeGenTests_CArrayInput3_f_exp(jmi_array_t* inp_a);

void func_CCodeGenTests_CArrayInput3_f_def(jmi_array_t* inp_a, jmi_ad_var_t* out_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t out_v;
    out_v = jmi_array_val_1(inp_a, 1) + jmi_array_val_1(inp_a, 2) + jmi_array_val_1(inp_a, 3);
    if (out_o != NULL) *out_o = out_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CArrayInput3_f_exp(jmi_array_t* inp_a) {
    jmi_ad_var_t out_v;
    func_CCodeGenTests_CArrayInput3_f_def(inp_a, &out_v);
    return out_v;
}


    JMI_ARRAY_STATIC(tmp_1, 3, 1)
    JMI_ARRAY_STATIC(tmp_2, 3, 1)
    JMI_ARRAY_STATIC(tmp_3, 3, 1)
    JMI_ARRAY_STATIC(tmp_4, 3, 1)
    JMI_ARRAY_STATIC_INIT_1(tmp_1, 3)
    jmi_array_ref_1(tmp_1, 1) = AD_WRAP_LITERAL(1);
    jmi_array_ref_1(tmp_1, 2) = AD_WRAP_LITERAL(2);
    jmi_array_ref_1(tmp_1, 3) = AD_WRAP_LITERAL(3);
    JMI_ARRAY_STATIC_INIT_1(tmp_2, 3)
    jmi_array_ref_1(tmp_2, 1) = AD_WRAP_LITERAL(4);
    jmi_array_ref_1(tmp_2, 2) = AD_WRAP_LITERAL(5);
    jmi_array_ref_1(tmp_2, 3) = AD_WRAP_LITERAL(6);
    JMI_ARRAY_STATIC_INIT_1(tmp_3, 3)
    jmi_array_ref_1(tmp_3, 1) = AD_WRAP_LITERAL(7);
    jmi_array_ref_1(tmp_3, 2) = AD_WRAP_LITERAL(8);
    jmi_array_ref_1(tmp_3, 3) = AD_WRAP_LITERAL(9);
    JMI_ARRAY_STATIC_INIT_1(tmp_4, 3)
    jmi_array_ref_1(tmp_4, 1) = func_CCodeGenTests_CArrayInput3_f_exp(tmp_1);
    jmi_array_ref_1(tmp_4, 2) = func_CCodeGenTests_CArrayInput3_f_exp(tmp_2);
    jmi_array_ref_1(tmp_4, 3) = func_CCodeGenTests_CArrayInput3_f_exp(tmp_3);
    (*res)[0] = func_CCodeGenTests_CArrayInput3_f_exp(tmp_4) - (_x_0);
")})));
end CArrayInput3;


model CArrayInput4
 function f1
  output Real out = 1.0;
 algorithm
  out := f2(1:3);
 end f1;
 
 function f2
  input Real inp[3];
  output Real out = sum(inp);
 algorithm
 end f2;
 
 Real x = f1();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CArrayInput4",
			description="C code generation: array inputs to functions: in assign statement",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_CArrayInput4_f1_def(jmi_ad_var_t* out_o);
jmi_ad_var_t func_CCodeGenTests_CArrayInput4_f1_exp();
void func_CCodeGenTests_CArrayInput4_f2_def(jmi_array_t* inp_a, jmi_ad_var_t* out_o);
jmi_ad_var_t func_CCodeGenTests_CArrayInput4_f2_exp(jmi_array_t* inp_a);

void func_CCodeGenTests_CArrayInput4_f1_def(jmi_ad_var_t* out_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t out_v;
    JMI_ARRAY_STATIC(tmp_1, 3, 1)
    out_v = 1.0;
    JMI_ARRAY_STATIC_INIT_1(tmp_1, 3)
    jmi_array_ref_1(tmp_1, 1) = AD_WRAP_LITERAL(1);
    jmi_array_ref_1(tmp_1, 2) = AD_WRAP_LITERAL(2);
    jmi_array_ref_1(tmp_1, 3) = AD_WRAP_LITERAL(3);
    out_v = func_CCodeGenTests_CArrayInput4_f2_exp(tmp_1);
    if (out_o != NULL) *out_o = out_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CArrayInput4_f1_exp() {
    jmi_ad_var_t out_v;
    func_CCodeGenTests_CArrayInput4_f1_def(&out_v);
    return out_v;
}

void func_CCodeGenTests_CArrayInput4_f2_def(jmi_array_t* inp_a, jmi_ad_var_t* out_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t out_v;
    out_v = jmi_array_val_1(inp_a, 1) + jmi_array_val_1(inp_a, 2) + jmi_array_val_1(inp_a, 3);
    if (out_o != NULL) *out_o = out_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CArrayInput4_f2_exp(jmi_array_t* inp_a) {
    jmi_ad_var_t out_v;
    func_CCodeGenTests_CArrayInput4_f2_def(inp_a, &out_v);
    return out_v;
}

")})));
end CArrayInput4;


model CArrayInput5
 function f1
  output Real out = 1.0;
  protected Real t;
 algorithm
  (out, t) := f2(1:3);
 end f1;
 
 function f2
  input Real inp[3];
  output Real out1 = sum(inp);
  output Real out2 = max(inp);
 algorithm
 end f2;
 
 Real x = f1();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CArrayInput5",
			description="C code generation: array inputs to functions: function call stmt",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_CArrayInput5_f1_def(jmi_ad_var_t* out_o);
jmi_ad_var_t func_CCodeGenTests_CArrayInput5_f1_exp();
void func_CCodeGenTests_CArrayInput5_f2_def(jmi_array_t* inp_a, jmi_ad_var_t* out1_o, jmi_ad_var_t* out2_o);
jmi_ad_var_t func_CCodeGenTests_CArrayInput5_f2_exp(jmi_array_t* inp_a);

void func_CCodeGenTests_CArrayInput5_f1_def(jmi_ad_var_t* out_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t out_v;
    jmi_ad_var_t t_v;
    JMI_ARRAY_STATIC(tmp_1, 3, 1)
    out_v = 1.0;
    JMI_ARRAY_STATIC_INIT_1(tmp_1, 3)
    jmi_array_ref_1(tmp_1, 1) = AD_WRAP_LITERAL(1);
    jmi_array_ref_1(tmp_1, 2) = AD_WRAP_LITERAL(2);
    jmi_array_ref_1(tmp_1, 3) = AD_WRAP_LITERAL(3);
    func_CCodeGenTests_CArrayInput5_f2_def(tmp_1, &out_v, &t_v);
    if (out_o != NULL) *out_o = out_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CArrayInput5_f1_exp() {
    jmi_ad_var_t out_v;
    func_CCodeGenTests_CArrayInput5_f1_def(&out_v);
    return out_v;
}

void func_CCodeGenTests_CArrayInput5_f2_def(jmi_array_t* inp_a, jmi_ad_var_t* out1_o, jmi_ad_var_t* out2_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t out1_v;
    jmi_ad_var_t out2_v;
    out1_v = jmi_array_val_1(inp_a, 1) + jmi_array_val_1(inp_a, 2) + jmi_array_val_1(inp_a, 3);
    out2_v = jmi_max(jmi_max(jmi_array_val_1(inp_a, 1), jmi_array_val_1(inp_a, 2)), jmi_array_val_1(inp_a, 3));
    if (out1_o != NULL) *out1_o = out1_v;
    if (out2_o != NULL) *out2_o = out2_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CArrayInput5_f2_exp(jmi_array_t* inp_a) {
    jmi_ad_var_t out1_v;
    func_CCodeGenTests_CArrayInput5_f2_def(inp_a, &out1_v, NULL);
    return out1_v;
}

")})));
end CArrayInput5;


model CArrayInput6
 function f1
  output Real out = 1.0;
 algorithm
  if f2(1:2) < 4 then
   out := f2(5:6);
  elseif f2(3:4) > 5 then
   out := f2(7:8);
  else
   out := f2(9:10);
  end if;
 end f1;
 
 function f2
  input Real inp[2];
  output Real out = sum(inp);
 algorithm
 end f2;
 
 Real x = f1();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CArrayInput6",
			description="C code generation: array inputs to functions: if statement",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_CArrayInput6_f1_def(jmi_ad_var_t* out_o);
jmi_ad_var_t func_CCodeGenTests_CArrayInput6_f1_exp();
void func_CCodeGenTests_CArrayInput6_f2_def(jmi_array_t* inp_a, jmi_ad_var_t* out_o);
jmi_ad_var_t func_CCodeGenTests_CArrayInput6_f2_exp(jmi_array_t* inp_a);

void func_CCodeGenTests_CArrayInput6_f1_def(jmi_ad_var_t* out_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t out_v;
    JMI_ARRAY_STATIC(tmp_1, 2, 1)
    JMI_ARRAY_STATIC(tmp_2, 2, 1)
    JMI_ARRAY_STATIC(tmp_3, 2, 1)
    JMI_ARRAY_STATIC(tmp_4, 2, 1)
    JMI_ARRAY_STATIC(tmp_5, 2, 1)
    out_v = 1.0;
    JMI_ARRAY_STATIC_INIT_1(tmp_1, 2)
    jmi_array_ref_1(tmp_1, 1) = AD_WRAP_LITERAL(1);
    jmi_array_ref_1(tmp_1, 2) = AD_WRAP_LITERAL(2);
    JMI_ARRAY_STATIC_INIT_1(tmp_3, 2)
    jmi_array_ref_1(tmp_3, 1) = AD_WRAP_LITERAL(3);
    jmi_array_ref_1(tmp_3, 2) = AD_WRAP_LITERAL(4);
    if (COND_EXP_LT(func_CCodeGenTests_CArrayInput6_f2_exp(tmp_1),4,JMI_TRUE,JMI_FALSE)) {
        JMI_ARRAY_STATIC_INIT_1(tmp_2, 2)
        jmi_array_ref_1(tmp_2, 1) = AD_WRAP_LITERAL(5);
        jmi_array_ref_1(tmp_2, 2) = AD_WRAP_LITERAL(6);
        out_v = func_CCodeGenTests_CArrayInput6_f2_exp(tmp_2);
    } else if (COND_EXP_GT(func_CCodeGenTests_CArrayInput6_f2_exp(tmp_3),5,JMI_TRUE,JMI_FALSE)) {
        JMI_ARRAY_STATIC_INIT_1(tmp_4, 2)
        jmi_array_ref_1(tmp_4, 1) = AD_WRAP_LITERAL(7);
        jmi_array_ref_1(tmp_4, 2) = AD_WRAP_LITERAL(8);
        out_v = func_CCodeGenTests_CArrayInput6_f2_exp(tmp_4);
    } else {
        JMI_ARRAY_STATIC_INIT_1(tmp_5, 2)
        jmi_array_ref_1(tmp_5, 1) = AD_WRAP_LITERAL(9);
        jmi_array_ref_1(tmp_5, 2) = AD_WRAP_LITERAL(10);
        out_v = func_CCodeGenTests_CArrayInput6_f2_exp(tmp_5);
    }
    if (out_o != NULL) *out_o = out_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CArrayInput6_f1_exp() {
    jmi_ad_var_t out_v;
    func_CCodeGenTests_CArrayInput6_f1_def(&out_v);
    return out_v;
}

void func_CCodeGenTests_CArrayInput6_f2_def(jmi_array_t* inp_a, jmi_ad_var_t* out_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t out_v;
    out_v = jmi_array_val_1(inp_a, 1) + jmi_array_val_1(inp_a, 2);
    if (out_o != NULL) *out_o = out_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CArrayInput6_f2_exp(jmi_array_t* inp_a) {
    jmi_ad_var_t out_v;
    func_CCodeGenTests_CArrayInput6_f2_def(inp_a, &out_v);
    return out_v;
}

")})));
end CArrayInput6;


model CArrayInput7
 function f1
  output Real out = 1.0;
 algorithm
  while f2(1:3) < 2 loop
   out := f2(4:6);
  end while;
 end f1;
 
 function f2
  input Real inp[3];
  output Real out = sum(inp);
 algorithm
 end f2;
 
 Real x = f1();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CArrayInput7",
			description="C code generation: array inputs to functions: while stmt",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_CArrayInput7_f1_def(jmi_ad_var_t* out_o);
jmi_ad_var_t func_CCodeGenTests_CArrayInput7_f1_exp();
void func_CCodeGenTests_CArrayInput7_f2_def(jmi_array_t* inp_a, jmi_ad_var_t* out_o);
jmi_ad_var_t func_CCodeGenTests_CArrayInput7_f2_exp(jmi_array_t* inp_a);

void func_CCodeGenTests_CArrayInput7_f1_def(jmi_ad_var_t* out_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t out_v;
    JMI_ARRAY_STATIC(tmp_1, 3, 1)
    JMI_ARRAY_STATIC(tmp_2, 3, 1)
    out_v = 1.0;
    JMI_ARRAY_STATIC_INIT_1(tmp_1, 3)
    jmi_array_ref_1(tmp_1, 1) = AD_WRAP_LITERAL(1);
    jmi_array_ref_1(tmp_1, 2) = AD_WRAP_LITERAL(2);
    jmi_array_ref_1(tmp_1, 3) = AD_WRAP_LITERAL(3);
    while (COND_EXP_LT(func_CCodeGenTests_CArrayInput7_f2_exp(tmp_1),2,JMI_TRUE,JMI_FALSE)) {
        JMI_ARRAY_STATIC_INIT_1(tmp_2, 3)
        jmi_array_ref_1(tmp_2, 1) = AD_WRAP_LITERAL(4);
        jmi_array_ref_1(tmp_2, 2) = AD_WRAP_LITERAL(5);
        jmi_array_ref_1(tmp_2, 3) = AD_WRAP_LITERAL(6);
        out_v = func_CCodeGenTests_CArrayInput7_f2_exp(tmp_2);
}
    if (out_o != NULL) *out_o = out_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CArrayInput7_f1_exp() {
    jmi_ad_var_t out_v;
    func_CCodeGenTests_CArrayInput7_f1_def(&out_v);
    return out_v;
}

void func_CCodeGenTests_CArrayInput7_f2_def(jmi_array_t* inp_a, jmi_ad_var_t* out_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t out_v;
    out_v = jmi_array_val_1(inp_a, 1) + jmi_array_val_1(inp_a, 2) + jmi_array_val_1(inp_a, 3);
    if (out_o != NULL) *out_o = out_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CArrayInput7_f2_exp(jmi_array_t* inp_a) {
    jmi_ad_var_t out_v;
    func_CCodeGenTests_CArrayInput7_f2_def(inp_a, &out_v);
    return out_v;
}

")})));
end CArrayInput7;


model CArrayInput8
 function f1
  output Real out = 1.0;
 algorithm
  for i in {f2(1:3), f2(4:6)} loop
   out := f2(7:9);
  end for;
 end f1;
 
 function f2
  input Real inp[3];
  output Real out = sum(inp);
 algorithm
 end f2;
 
 Real x = f1();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CArrayInput8",
			description="C code generation: array inputs to functions: for stmt",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_CArrayInput8_f1_def(jmi_ad_var_t* out_o);
jmi_ad_var_t func_CCodeGenTests_CArrayInput8_f1_exp();
void func_CCodeGenTests_CArrayInput8_f2_def(jmi_array_t* inp_a, jmi_ad_var_t* out_o);
jmi_ad_var_t func_CCodeGenTests_CArrayInput8_f2_exp(jmi_array_t* inp_a);

void func_CCodeGenTests_CArrayInput8_f1_def(jmi_ad_var_t* out_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t out_v;
    JMI_ARRAY_STATIC(tmp_1, 3, 1)
    JMI_ARRAY_STATIC(tmp_2, 3, 1)
    jmi_ad_var_t i_0i;
    int i_0ii;
    jmi_ad_var_t i_0ia[2];
    JMI_ARRAY_STATIC(tmp_3, 3, 1)
    out_v = 1.0;
    JMI_ARRAY_STATIC_INIT_1(tmp_1, 3)
    jmi_array_ref_1(tmp_1, 1) = AD_WRAP_LITERAL(1);
    jmi_array_ref_1(tmp_1, 2) = AD_WRAP_LITERAL(2);
    jmi_array_ref_1(tmp_1, 3) = AD_WRAP_LITERAL(3);
    JMI_ARRAY_STATIC_INIT_1(tmp_2, 3)
    jmi_array_ref_1(tmp_2, 1) = AD_WRAP_LITERAL(4);
    jmi_array_ref_1(tmp_2, 2) = AD_WRAP_LITERAL(5);
    jmi_array_ref_1(tmp_2, 3) = AD_WRAP_LITERAL(6);
    i_0ia[0] = func_CCodeGenTests_CArrayInput8_f2_exp(tmp_1);
    i_0ia[1] = func_CCodeGenTests_CArrayInput8_f2_exp(tmp_2);
    for (i_0ii = 0; i_0ii < 2; i_0ii++) {
        i_0i = i_0ia[i_0ii];
        JMI_ARRAY_STATIC_INIT_1(tmp_3, 3)
        jmi_array_ref_1(tmp_3, 1) = AD_WRAP_LITERAL(7);
        jmi_array_ref_1(tmp_3, 2) = AD_WRAP_LITERAL(8);
        jmi_array_ref_1(tmp_3, 3) = AD_WRAP_LITERAL(9);
        out_v = func_CCodeGenTests_CArrayInput8_f2_exp(tmp_3);
    }
    if (out_o != NULL) *out_o = out_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CArrayInput8_f1_exp() {
    jmi_ad_var_t out_v;
    func_CCodeGenTests_CArrayInput8_f1_def(&out_v);
    return out_v;
}

void func_CCodeGenTests_CArrayInput8_f2_def(jmi_array_t* inp_a, jmi_ad_var_t* out_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t out_v;
    out_v = jmi_array_val_1(inp_a, 1) + jmi_array_val_1(inp_a, 2) + jmi_array_val_1(inp_a, 3);
    if (out_o != NULL) *out_o = out_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CArrayInput8_f2_exp(jmi_array_t* inp_a) {
    jmi_ad_var_t out_v;
    func_CCodeGenTests_CArrayInput8_f2_def(inp_a, &out_v);
    return out_v;
}

")})));
end CArrayInput8;


model CArrayOutputs1
 function f
  output Real o[2] = {1,2};
 algorithm
 end f;
 
 Real x[2] = f();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CArrayOutputs1",
			description="C code generation: array outputs from functions: in equation",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_CArrayOutputs1_f_def(jmi_array_t* o_a);

void func_CCodeGenTests_CArrayOutputs1_f_def(jmi_array_t* o_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_STATIC(o_an, 2, 1)
    if (o_a == NULL) {
        JMI_ARRAY_STATIC_INIT_1(o_an, 2)
        o_a = o_an;
    }
    jmi_array_ref_1(o_a, 1) = 1;
    jmi_array_ref_1(o_a, 2) = 2;
    JMI_DYNAMIC_FREE()
    return;
}


    JMI_ARRAY_STATIC(tmp_1, 2, 1)
    JMI_ARRAY_STATIC_INIT_1(tmp_1, 2)
    func_CCodeGenTests_CArrayOutputs1_f_def(tmp_1);
    (*res)[0] = jmi_array_val_1(tmp_1, 1) - (_x_1_0);
    (*res)[1] = jmi_array_val_1(tmp_1, 2) - (_x_2_1);
")})));
end CArrayOutputs1;


model CArrayOutputs2
 function f
  output Real o[2] = {1,2};
 algorithm
 end f;
 
 Real x;
equation
 x = f() * {3,4};

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CArrayOutputs2",
			description="C code generation: array outputs from functions: in expression in equation",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_CArrayOutputs2_f_def(jmi_array_t* o_a);

void func_CCodeGenTests_CArrayOutputs2_f_def(jmi_array_t* o_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_STATIC(o_an, 2, 1)
    if (o_a == NULL) {
        JMI_ARRAY_STATIC_INIT_1(o_an, 2)
        o_a = o_an;
    }
    jmi_array_ref_1(o_a, 1) = 1;
    jmi_array_ref_1(o_a, 2) = 2;
    JMI_DYNAMIC_FREE()
    return;
}


    JMI_ARRAY_STATIC(tmp_1, 2, 1)
    JMI_ARRAY_STATIC_INIT_1(tmp_1, 2)
    func_CCodeGenTests_CArrayOutputs2_f_def(tmp_1);
    (*res)[0] = jmi_array_val_1(tmp_1, 1) - (_temp_1_1_1);
    (*res)[1] = jmi_array_val_1(tmp_1, 2) - (_temp_1_2_2);
    (*res)[2] = ( _temp_1_1_1 ) * ( 3 ) + ( _temp_1_2_2 ) * ( 4 ) - (_x_0);
")})));
end CArrayOutputs2;


model CArrayOutputs3
 function f1
  output Real o = 0;
  protected Real x;
 algorithm
  x := f2() * {3,4};
 end f1;
 
 function f2
  output Real o[2] = {1,2};
 algorithm
 end f2;
 
 Real x = f1();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CArrayOutputs3",
			description="C code generation: array outputs from functions: in expression in function",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_CArrayOutputs3_f1_def(jmi_ad_var_t* o_o);
jmi_ad_var_t func_CCodeGenTests_CArrayOutputs3_f1_exp();
void func_CCodeGenTests_CArrayOutputs3_f2_def(jmi_array_t* o_a);

void func_CCodeGenTests_CArrayOutputs3_f1_def(jmi_ad_var_t* o_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t o_v;
    jmi_ad_var_t x_v;
    JMI_ARRAY_STATIC(temp_1_a, 2, 1)
    JMI_ARRAY_STATIC_INIT_1(temp_1_a, 2)
    o_v = 0;
    func_CCodeGenTests_CArrayOutputs3_f2_def(temp_1_a);
    x_v = ( jmi_array_val_1(temp_1_a, 1) ) * ( 3 ) + ( jmi_array_val_1(temp_1_a, 2) ) * ( 4 );
    if (o_o != NULL) *o_o = o_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CArrayOutputs3_f1_exp() {
    jmi_ad_var_t o_v;
    func_CCodeGenTests_CArrayOutputs3_f1_def(&o_v);
    return o_v;
}

void func_CCodeGenTests_CArrayOutputs3_f2_def(jmi_array_t* o_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_STATIC(o_an, 2, 1)
    if (o_a == NULL) {
        JMI_ARRAY_STATIC_INIT_1(o_an, 2)
        o_a = o_an;
    }
    jmi_array_ref_1(o_a, 1) = 1;
    jmi_array_ref_1(o_a, 2) = 2;
    JMI_DYNAMIC_FREE()
    return;
}


    (*res)[0] = func_CCodeGenTests_CArrayOutputs3_f1_exp() - (_x_0);
")})));
end CArrayOutputs3;


model CArrayOutputs4
 function f1
  output Real o = 0;
  protected Real x[2];
  protected Real y;
 algorithm
  (x,y) := f2();
 end f1;
 
 function f2
  output Real o1[2] = {1,2};
  output Real o2 = 3;
 algorithm
 end f2;
 
 Real x = f1();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CArrayOutputs4",
			description="C code generation: array outputs from functions: function call statement",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_CArrayOutputs4_f1_def(jmi_ad_var_t* o_o);
jmi_ad_var_t func_CCodeGenTests_CArrayOutputs4_f1_exp();
void func_CCodeGenTests_CArrayOutputs4_f2_def(jmi_array_t* o1_a, jmi_ad_var_t* o2_o);

void func_CCodeGenTests_CArrayOutputs4_f1_def(jmi_ad_var_t* o_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t o_v;
    JMI_ARRAY_STATIC(x_a, 2, 1)
    jmi_ad_var_t y_v;
    JMI_ARRAY_STATIC_INIT_1(x_a, 2)
    o_v = 0;
    func_CCodeGenTests_CArrayOutputs4_f2_def(x_a, &y_v);
    if (o_o != NULL) *o_o = o_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CArrayOutputs4_f1_exp() {
    jmi_ad_var_t o_v;
    func_CCodeGenTests_CArrayOutputs4_f1_def(&o_v);
    return o_v;
}

void func_CCodeGenTests_CArrayOutputs4_f2_def(jmi_array_t* o1_a, jmi_ad_var_t* o2_o) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_STATIC(o1_an, 2, 1)
    jmi_ad_var_t o2_v;
    if (o1_a == NULL) {
        JMI_ARRAY_STATIC_INIT_1(o1_an, 2)
        o1_a = o1_an;
    }
    jmi_array_ref_1(o1_a, 1) = 1;
    jmi_array_ref_1(o1_a, 2) = 2;
    o2_v = 3;
    if (o2_o != NULL) *o2_o = o2_v;
    JMI_DYNAMIC_FREE()
    return;
}


    (*res)[0] = func_CCodeGenTests_CArrayOutputs4_f1_exp() - (_x_0);
")})));
end CArrayOutputs4;


model CArrayOutputs5
 function f1
  input Real i[2];
  output Real o = 0;
  protected Real x[2];
  protected Real y;
 algorithm
  (x, y) := f2(i);
 end f1;
 
 function f2
  input Real i[2];
  output Real o1[2] = i;
  output Real o2 = 3;
 algorithm
 end f2;
 
 Real x = f1({1,2});

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CArrayOutputs5",
			description="C code generation: array outputs from functions: passing input array",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_CArrayOutputs5_f1_def(jmi_array_t* i_a, jmi_ad_var_t* o_o);
jmi_ad_var_t func_CCodeGenTests_CArrayOutputs5_f1_exp(jmi_array_t* i_a);
void func_CCodeGenTests_CArrayOutputs5_f2_def(jmi_array_t* i_a, jmi_array_t* o1_a, jmi_ad_var_t* o2_o);

void func_CCodeGenTests_CArrayOutputs5_f1_def(jmi_array_t* i_a, jmi_ad_var_t* o_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t o_v;
    JMI_ARRAY_STATIC(x_a, 2, 1)
    jmi_ad_var_t y_v;
    JMI_ARRAY_STATIC_INIT_1(x_a, 2)
    o_v = 0;
    func_CCodeGenTests_CArrayOutputs5_f2_def(i_a, x_a, &y_v);
    if (o_o != NULL) *o_o = o_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CArrayOutputs5_f1_exp(jmi_array_t* i_a) {
    jmi_ad_var_t o_v;
    func_CCodeGenTests_CArrayOutputs5_f1_def(i_a, &o_v);
    return o_v;
}

void func_CCodeGenTests_CArrayOutputs5_f2_def(jmi_array_t* i_a, jmi_array_t* o1_a, jmi_ad_var_t* o2_o) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_STATIC(o1_an, 2, 1)
    jmi_ad_var_t o2_v;
    if (o1_a == NULL) {
        JMI_ARRAY_STATIC_INIT_1(o1_an, 2)
        o1_a = o1_an;
    }
    jmi_array_ref_1(o1_a, 1) = jmi_array_val_1(i_a, 1);
    jmi_array_ref_1(o1_a, 2) = jmi_array_val_1(i_a, 2);
    o2_v = 3;
    if (o2_o != NULL) *o2_o = o2_v;
    JMI_DYNAMIC_FREE()
    return;
}


    JMI_ARRAY_STATIC(tmp_1, 2, 1)
    JMI_ARRAY_STATIC_INIT_1(tmp_1, 2)
    jmi_array_ref_1(tmp_1, 1) = AD_WRAP_LITERAL(1);
    jmi_array_ref_1(tmp_1, 2) = AD_WRAP_LITERAL(2);
    (*res)[0] = func_CCodeGenTests_CArrayOutputs5_f1_exp(tmp_1) - (_x_0);
")})));
end CArrayOutputs5;



model CAbsTest1
 Real x = abs(y);
 Real y = -2;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CAbsTest1",
			description="C code generation for abs() operator",
			template="$C_DAE_equation_residuals$",
			generatedCode="
    (*res)[0] = jmi_abs(_y_1) - (_x_0);
    (*res)[1] =  - ( 2 ) - (_y_1);
")})));
end CAbsTest1;



model CUnknownArray1
 function f
  input Real a[:];
  input Real b[size(a,1)];
  output Real o[size(a,1)] = a + b;
 algorithm
 end f;
 
 Real x[2] = f({1,2}, {3,4});

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CUnknownArray1",
			description="C code generation for unknown array sizes: basic test",
			template="$C_functions$",
			generatedCode="
void func_CCodeGenTests_CUnknownArray1_f_def(jmi_array_t* a_a, jmi_array_t* b_a, jmi_array_t* o_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_DYNAMIC(o_an, 1)
    jmi_ad_var_t i1_0i;
    jmi_ad_var_t i1_0ie;
    if (o_a == NULL) {
        JMI_ARRAY_DYNAMIC_INIT_1(o_an, jmi_array_size(a_a, 0), jmi_array_size(a_a, 0))
        o_a = o_an;
    }
    i1_0ie = jmi_array_size(o_a, 0) + 1 / 2.0;
    for (i1_0i = 1; i1_0i < i1_0ie; i1_0i += 1) {
        jmi_array_ref_1(o_a, i1_0i) = jmi_array_val_1(a_a, i1_0i) + jmi_array_val_1(b_a, i1_0i);
    }
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end CUnknownArray1;


// TODO: assignment to temp array should be outside loop - see #699
model CUnknownArray2
	function f
		input Real x[:,2];
		output Real y[size(x, 1), 2];
	algorithm
		y := x * {{1, 2}, {3, 4}};
	end f;

	Real x[3,2] = f({{5,6},{7,8},{9,0}});

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CUnknownArray2",
			description="C code generation for unknown array sizes: array constructor * array with unknown size",
			template="$C_functions$",
			generatedCode="
void func_CCodeGenTests_CUnknownArray2_f_def(jmi_array_t* x_a, jmi_array_t* y_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_DYNAMIC(y_an, 2)
    jmi_ad_var_t temp_1_v;
    JMI_ARRAY_STATIC(temp_2_a, 4, 2)
    jmi_ad_var_t i1_0i;
    jmi_ad_var_t i1_0ie;
    jmi_ad_var_t i2_1i;
    jmi_ad_var_t i2_1ie;
    jmi_ad_var_t i3_2i;
    jmi_ad_var_t i3_2ie;
    JMI_ARRAY_STATIC_INIT_2(temp_2_a, 2, 2)
    if (y_a == NULL) {
        JMI_ARRAY_DYNAMIC_INIT_2(y_an, ( jmi_array_size(x_a, 0) ) * ( 2 ), jmi_array_size(x_a, 0), 2)
        y_a = y_an;
    }
    i1_0ie = jmi_array_size(y_a, 0) + 1 / 2.0;
    for (i1_0i = 1; i1_0i < i1_0ie; i1_0i += 1) {
        i2_1ie = jmi_array_size(y_a, 1) + 1 / 2.0;
        for (i2_1i = 1; i2_1i < i2_1ie; i2_1i += 1) {
            temp_1_v = 0.0;
            i3_2ie = 2 + 1 / 2.0;
            for (i3_2i = 1; i3_2i < i3_2ie; i3_2i += 1) {
                jmi_array_ref_2(temp_2_a, 1, 1) = 1;
                jmi_array_ref_2(temp_2_a, 1, 2) = 2;
                jmi_array_ref_2(temp_2_a, 2, 1) = 3;
                jmi_array_ref_2(temp_2_a, 2, 2) = 4;
                temp_1_v = temp_1_v + ( jmi_array_val_2(x_a, i1_0i, i3_2i) ) * ( jmi_array_val_2(temp_2_a, i3_2i, i2_1i) );
            }
            jmi_array_ref_2(y_a, i1_0i, i2_1i) = temp_1_v;
        }
    }
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end CUnknownArray2;


// This tests for a bug that wasn't exposed until C code generation
model CUnknownArray3
    function f1
        input Real[:] x1;
        output Real y1;
    algorithm
        y1 := f3(f2(x1));
    end f1;
    
    function f2
        input Real[:] x2;
        output Real[size(x2,1)] y2;
    algorithm
        y2 := x2;
    end f2;
    
    function f3
        input Real[:] x3;
        output Real y3;
    algorithm
        y3 := sum(x3);
    end f3;
    
    Real x = f1({1,2});

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CUnknownArray3",
			description="Passing array return value of unknown size directly to other function",
			template="$C_functions$",
			generatedCode="
void func_CCodeGenTests_CUnknownArray3_f1_def(jmi_array_t* x1_a, jmi_ad_var_t* y1_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t y1_v;
    JMI_ARRAY_DYNAMIC(temp_1_a, 1)
    JMI_ARRAY_DYNAMIC_INIT_1(temp_1_a, jmi_array_size(x1_a, 0), jmi_array_size(x1_a, 0))
    func_CCodeGenTests_CUnknownArray3_f2_def(x1_a, temp_1_a);
    y1_v = func_CCodeGenTests_CUnknownArray3_f3_exp(temp_1_a);
    if (y1_o != NULL) *y1_o = y1_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CUnknownArray3_f1_exp(jmi_array_t* x1_a) {
    jmi_ad_var_t y1_v;
    func_CCodeGenTests_CUnknownArray3_f1_def(x1_a, &y1_v);
    return y1_v;
}

void func_CCodeGenTests_CUnknownArray3_f3_def(jmi_array_t* x3_a, jmi_ad_var_t* y3_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t y3_v;
    jmi_ad_var_t temp_1_v;
    jmi_ad_var_t i1_0i;
    jmi_ad_var_t i1_0ie;
    temp_1_v = 0.0;
    i1_0ie = jmi_array_size(x3_a, 0) + 1 / 2.0;
    for (i1_0i = 1; i1_0i < i1_0ie; i1_0i += 1) {
        temp_1_v = temp_1_v + jmi_array_val_1(x3_a, i1_0i);
    }
    y3_v = temp_1_v;
    if (y3_o != NULL) *y3_o = y3_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CUnknownArray3_f3_exp(jmi_array_t* x3_a) {
    jmi_ad_var_t y3_v;
    func_CCodeGenTests_CUnknownArray3_f3_def(x3_a, &y3_v);
    return y3_v;
}

void func_CCodeGenTests_CUnknownArray3_f2_def(jmi_array_t* x2_a, jmi_array_t* y2_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_DYNAMIC(y2_an, 1)
    jmi_ad_var_t i1_1i;
    jmi_ad_var_t i1_1ie;
    if (y2_a == NULL) {
        JMI_ARRAY_DYNAMIC_INIT_1(y2_an, jmi_array_size(x2_a, 0), jmi_array_size(x2_a, 0))
        y2_a = y2_an;
    }
    i1_1ie = jmi_array_size(y2_a, 0) + 1 / 2.0;
    for (i1_1i = 1; i1_1i < i1_1ie; i1_1i += 1) {
        jmi_array_ref_1(y2_a, i1_1i) = jmi_array_val_1(x2_a, i1_1i);
    }
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end CUnknownArray3;



model CRecordDecl1
 record A
  Real a;
  Real b;
 end A;
 
 A x;
equation
 x.a = 1;
 x.b = 2;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CRecordDecl1",
			description="C code generation for records: structs: basic test",
			template="$C_records$",
			generatedCode="
typedef struct _A_0_r {
    jmi_ad_var_t a;
    jmi_ad_var_t b;
} A_0_r;
JMI_RECORD_ARRAY_TYPE(A_0_r, A_0_ra)

")})));
end CRecordDecl1;


model CRecordDecl2
 record A
  Real a;
  B b;
 end A;
 
 record B
  Real c;
 end B;
 
 A x;
equation
 x.a = 1;
 x.b.c = 2;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CRecordDecl2",
			description="C code generation for records: structs: nested records",
			template="$C_records$",
			generatedCode="
typedef struct _B_0_r {
    jmi_ad_var_t c;
} B_0_r;
JMI_RECORD_ARRAY_TYPE(B_0_r, B_0_ra)

typedef struct _A_1_r {
    jmi_ad_var_t a;
    B_0_r* b;
} A_1_r;
JMI_RECORD_ARRAY_TYPE(A_1_r, A_1_ra)

")})));
end CRecordDecl2;


model CRecordDecl3
 record A
  Real a[2];
 end A;

 A x;
equation
 x.a = {1,2};

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CRecordDecl3",
			description="C code generation for records: structs: array in record",
			template="$C_records$",
			generatedCode="
typedef struct _A_0_r {
    jmi_array_t* a;
} A_0_r;
JMI_RECORD_ARRAY_TYPE(A_0_r, A_0_ra)

")})));
end CRecordDecl3;


model CRecordDecl4
 record A
  Real a;
  B b[2];
 end A;
 
 record B
  Real c;
 end B;
 
 A x;
equation
 x.a = 1;
 x.b[1].c = 2;
 x.b[2].c = 3;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CRecordDecl4",
			description="C code generation for records: structs: array of records",
			template="$C_records$",
			generatedCode="
typedef struct _B_0_r {
    jmi_ad_var_t c;
} B_0_r;
JMI_RECORD_ARRAY_TYPE(B_0_r, B_0_ra)

typedef struct _A_1_r {
    jmi_ad_var_t a;
    B_0_ra* b;
} A_1_r;
JMI_RECORD_ARRAY_TYPE(A_1_r, A_1_ra)

")})));
end CRecordDecl4;


model CRecordDecl5
  function f
  output Real o;
  protected A x = A(1,2);
 algorithm
  o := x.a;
 end f;
 
 record A
  Real a;
  Real b;
 end A;
 
 Real x = f();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CRecordDecl5",
			description="C code generation for records: declarations: basic test",
			template="$C_functions$",
			generatedCode="
void func_CCodeGenTests_CRecordDecl5_f_def(jmi_ad_var_t* o_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t o_v;
    JMI_RECORD_STATIC(A_0_r, x_v)
    x_v->a = 1;
    x_v->b = 2;
    o_v = x_v->a;
    if (o_o != NULL) *o_o = o_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CRecordDecl5_f_exp() {
    jmi_ad_var_t o_v;
    func_CCodeGenTests_CRecordDecl5_f_def(&o_v);
    return o_v;
}

")})));
end CRecordDecl5;


model CRecordDecl6
 function f
  output Real o;
  protected A x = A(1, B(2));
 algorithm
  o := x.b.c;
 end f;
 
 record A
  Real a;
  B b;
 end A;
 
 record B
  Real c;
 end B;
 
 Real x = f();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CRecordDecl6",
			description="C code generation for records: declarations: nestled records",
			template="$C_functions$",
			generatedCode="
void func_CCodeGenTests_CRecordDecl6_f_def(jmi_ad_var_t* o_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t o_v;
    JMI_RECORD_STATIC(A_1_r, x_v)
    JMI_RECORD_STATIC(B_0_r, tmp_1)
    x_v->b = tmp_1;
    x_v->a = 1;
    x_v->b->c = 2;
    o_v = x_v->b->c;
    if (o_o != NULL) *o_o = o_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CRecordDecl6_f_exp() {
    jmi_ad_var_t o_v;
    func_CCodeGenTests_CRecordDecl6_f_def(&o_v);
    return o_v;
}

")})));
end CRecordDecl6;


model CRecordDecl7
 function f
  output Real o;
  protected A x = A({1,2});
 algorithm
  o := x.a[1];
 end f;
 
 record A
  Real a[2];
 end A;
 
 Real x = f();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CRecordDecl7",
			description="C code generation for records: declarations: array in record",
			template="$C_functions$",
			generatedCode="
void func_CCodeGenTests_CRecordDecl7_f_def(jmi_ad_var_t* o_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t o_v;
    JMI_RECORD_STATIC(A_0_r, x_v)
    JMI_ARRAY_STATIC(tmp_1, 2, 1)
    JMI_ARRAY_STATIC_INIT_1(tmp_1, 2)
    x_v->a = tmp_1;
    jmi_array_ref_1(x_v->a, 1) = 1;
    jmi_array_ref_1(x_v->a, 2) = 2;
    o_v = jmi_array_val_1(x_v->a, 1);
    if (o_o != NULL) *o_o = o_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CRecordDecl7_f_exp() {
    jmi_ad_var_t o_v;
    func_CCodeGenTests_CRecordDecl7_f_def(&o_v);
    return o_v;
}

")})));
end CRecordDecl7;


model CRecordDecl8
 function f
  output Real o;
  protected A x[3] = {A(1,{B(2),B(3)}),A(4,{B(5),B(6)}),A(7,{B(8),B(9)})};
 algorithm
  o := x[1].b[2].c;
 end f;
 
 record A
  Real a;
  B b[2];
 end A;
 
 record B
  Real c;
 end B;
 
 Real x = f();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CRecordDecl8",
			description="C code generation for records: declarations: array of records",
			template="$C_functions$",
			generatedCode="
void func_CCodeGenTests_CRecordDecl8_f_def(jmi_ad_var_t* o_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t o_v;
    JMI_RECORD_ARRAY_STATIC(A_1_r, A_1_ra, x_a, 3, 1)
    JMI_RECORD_ARRAY_STATIC(B_0_r, B_0_ra, tmp_1, 2, 1)
    JMI_RECORD_ARRAY_STATIC(B_0_r, B_0_ra, tmp_2, 2, 1)
    JMI_RECORD_ARRAY_STATIC(B_0_r, B_0_ra, tmp_3, 2, 1)
    JMI_RECORD_ARRAY_STATIC_INIT_1(A_1_r, x_a, 3)
    JMI_RECORD_ARRAY_STATIC_INIT_1(B_0_r, tmp_1, 2)
    jmi_array_rec_1(x_a, 1)->b = tmp_1;
    JMI_RECORD_ARRAY_STATIC_INIT_1(B_0_r, tmp_2, 2)
    jmi_array_rec_1(x_a, 2)->b = tmp_2;
    JMI_RECORD_ARRAY_STATIC_INIT_1(B_0_r, tmp_3, 2)
    jmi_array_rec_1(x_a, 3)->b = tmp_3;
    jmi_array_rec_1(x_a, 1)->a = 1;
    jmi_array_rec_1(jmi_array_rec_1(x_a, 1)->b, 1)->c = 2;
    jmi_array_rec_1(jmi_array_rec_1(x_a, 1)->b, 2)->c = 3;
    jmi_array_rec_1(x_a, 2)->a = 4;
    jmi_array_rec_1(jmi_array_rec_1(x_a, 2)->b, 1)->c = 5;
    jmi_array_rec_1(jmi_array_rec_1(x_a, 2)->b, 2)->c = 6;
    jmi_array_rec_1(x_a, 3)->a = 7;
    jmi_array_rec_1(jmi_array_rec_1(x_a, 3)->b, 1)->c = 8;
    jmi_array_rec_1(jmi_array_rec_1(x_a, 3)->b, 2)->c = 9;
    o_v = jmi_array_rec_1(jmi_array_rec_1(x_a, 1)->b, 2)->c;
    if (o_o != NULL) *o_o = o_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CRecordDecl8_f_exp() {
    jmi_ad_var_t o_v;
    func_CCodeGenTests_CRecordDecl8_f_def(&o_v);
    return o_v;
}

")})));
end CRecordDecl8;


model CRecordDecl9
 function f
  output A x = A(1,2);
 algorithm
 end f;
 
 record A
  Real a;
  Real b;
 end A;
 
 A x = f();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CRecordDecl9",
			description="C code generation for records: outputs: basic test",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_CRecordDecl9_f_def(A_0_r* x_v);

void func_CCodeGenTests_CRecordDecl9_f_def(A_0_r* x_v) {
    JMI_DYNAMIC_INIT()
    JMI_RECORD_STATIC(A_0_r, x_vn)
    if (x_v == NULL) {
        x_v = x_vn;
    }
    x_v->a = 1;
    x_v->b = 2;
    JMI_DYNAMIC_FREE()
    return;
}


    JMI_RECORD_STATIC(A_0_r, tmp_1)
    func_CCodeGenTests_CRecordDecl9_f_def(tmp_1);
    (*res)[0] = tmp_1->a - (_x_a_0);
    (*res)[1] = tmp_1->b - (_x_b_1);
")})));
end CRecordDecl9;


model CRecordDecl10
  function f
  output A x = A(1, B(2));
 algorithm
 end f;
 
 record A
  Real a;
  B b;
 end A;
 
 record B
  Real c;
 end B;
 
 A x = f();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CRecordDecl10",
			description="C code generation for records: outputs: nested arrays",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_CRecordDecl10_f_def(A_1_r* x_v);

void func_CCodeGenTests_CRecordDecl10_f_def(A_1_r* x_v) {
    JMI_DYNAMIC_INIT()
    JMI_RECORD_STATIC(A_1_r, x_vn)
    JMI_RECORD_STATIC(B_0_r, tmp_1)
    if (x_v == NULL) {
        x_vn->b = tmp_1;
        x_v = x_vn;
    }
    x_v->a = 1;
    x_v->b->c = 2;
    JMI_DYNAMIC_FREE()
    return;
}


    JMI_RECORD_STATIC(A_1_r, tmp_1)
    JMI_RECORD_STATIC(B_0_r, tmp_2)
    tmp_1->b = tmp_2;
    func_CCodeGenTests_CRecordDecl10_f_def(tmp_1);
    (*res)[0] = tmp_1->a - (_x_a_0);
    (*res)[1] = tmp_1->b->c - (_x_b_c_1);
")})));
end CRecordDecl10;


model CRecordDecl11
  function f
  output A x = A({1,2});
 algorithm
 end f;
 
 record A
  Real a[2];
 end A;
 
 A x = f();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CRecordDecl11",
			description="C code generation for records: outputs: array in record",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_CRecordDecl11_f_def(A_0_r* x_v);

void func_CCodeGenTests_CRecordDecl11_f_def(A_0_r* x_v) {
    JMI_DYNAMIC_INIT()
    JMI_RECORD_STATIC(A_0_r, x_vn)
    JMI_ARRAY_STATIC(tmp_1, 2, 1)
    if (x_v == NULL) {
	    JMI_ARRAY_STATIC_INIT_1(tmp_1, 2)
        x_vn->a = tmp_1;
        x_v = x_vn;
    }
    jmi_array_ref_1(x_v->a, 1) = 1;
    jmi_array_ref_1(x_v->a, 2) = 2;
    JMI_DYNAMIC_FREE()
    return;
}


    JMI_RECORD_STATIC(A_0_r, tmp_1)
    JMI_ARRAY_STATIC(tmp_2, 2, 1)
    JMI_ARRAY_STATIC_INIT_1(tmp_2, 2)
    tmp_1->a = tmp_2;
    func_CCodeGenTests_CRecordDecl11_f_def(tmp_1);
    (*res)[0] = jmi_array_val_1(tmp_1->a, 1) - (_x_a_1_0);
    (*res)[1] = jmi_array_val_1(tmp_1->a, 2) - (_x_a_2_1);
")})));
end CRecordDecl11;


model CRecordDecl12
  function f
  output A x[3] = {A(1,{B(2),B(3)}),A(4,{B(5),B(6)}),A(7,{B(8),B(9)})};
 algorithm
 end f;
 
 record A
  Real a;
  B b[2];
 end A;
 
 record B
  Real c;
 end B;
 
 A x[3] = f();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CRecordDecl12",
			description="C code generation for records: outputs: array of records",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_CRecordDecl12_f_def(A_1_ra* x_a);

void func_CCodeGenTests_CRecordDecl12_f_def(A_1_ra* x_a) {
    JMI_DYNAMIC_INIT()
    JMI_RECORD_ARRAY_STATIC(A_1_r, A_1_ra, x_an, 3, 1)
    JMI_RECORD_ARRAY_STATIC(B_0_r, B_0_ra, tmp_1, 2, 1)
    JMI_RECORD_ARRAY_STATIC(B_0_r, B_0_ra, tmp_2, 2, 1)
    JMI_RECORD_ARRAY_STATIC(B_0_r, B_0_ra, tmp_3, 2, 1)
    if (x_a == NULL) {
        JMI_RECORD_ARRAY_STATIC_INIT_1(A_1_r, x_an, 3)
        JMI_RECORD_ARRAY_STATIC_INIT_1(B_0_r, tmp_1, 2)
        jmi_array_rec_1(x_an, 1)->b = tmp_1;
        JMI_RECORD_ARRAY_STATIC_INIT_1(B_0_r, tmp_2, 2)
        jmi_array_rec_1(x_an, 2)->b = tmp_2;
        JMI_RECORD_ARRAY_STATIC_INIT_1(B_0_r, tmp_3, 2)
        jmi_array_rec_1(x_an, 3)->b = tmp_3;
        x_a = x_an;
    }
    jmi_array_rec_1(x_a, 1)->a = 1;
    jmi_array_rec_1(jmi_array_rec_1(x_a, 1)->b, 1)->c = 2;
    jmi_array_rec_1(jmi_array_rec_1(x_a, 1)->b, 2)->c = 3;
    jmi_array_rec_1(x_a, 2)->a = 4;
    jmi_array_rec_1(jmi_array_rec_1(x_a, 2)->b, 1)->c = 5;
    jmi_array_rec_1(jmi_array_rec_1(x_a, 2)->b, 2)->c = 6;
    jmi_array_rec_1(x_a, 3)->a = 7;
    jmi_array_rec_1(jmi_array_rec_1(x_a, 3)->b, 1)->c = 8;
    jmi_array_rec_1(jmi_array_rec_1(x_a, 3)->b, 2)->c = 9;
    JMI_DYNAMIC_FREE()
    return;
}


    JMI_RECORD_ARRAY_STATIC(A_1_r, A_1_ra, tmp_1, 3, 1)
    JMI_RECORD_ARRAY_STATIC(B_0_r, B_0_ra, tmp_2, 2, 1)
    JMI_RECORD_ARRAY_STATIC(B_0_r, B_0_ra, tmp_3, 2, 1)
    JMI_RECORD_ARRAY_STATIC(B_0_r, B_0_ra, tmp_4, 2, 1)
    JMI_RECORD_ARRAY_STATIC_INIT_1(A_1_r, tmp_1, 3)
    JMI_RECORD_ARRAY_STATIC_INIT_1(B_0_r, tmp_2, 2)
    jmi_array_rec_1(tmp_1, 1)->b = tmp_2;
    JMI_RECORD_ARRAY_STATIC_INIT_1(B_0_r, tmp_3, 2)
    jmi_array_rec_1(tmp_1, 2)->b = tmp_3;
    JMI_RECORD_ARRAY_STATIC_INIT_1(B_0_r, tmp_4, 2)
    jmi_array_rec_1(tmp_1, 3)->b = tmp_4;
    func_CCodeGenTests_CRecordDecl12_f_def(tmp_1);
    (*res)[0] = jmi_array_rec_1(tmp_1, 1)->a - (_x_1_a_0);
    (*res)[1] = jmi_array_rec_1(jmi_array_rec_1(tmp_1, 1)->b, 1)->c - (_x_1_b_1_c_1);
    (*res)[2] = jmi_array_rec_1(jmi_array_rec_1(tmp_1, 1)->b, 2)->c - (_x_1_b_2_c_2);
    (*res)[1] = jmi_array_rec_1(tmp_1, 2)->a - (_x_2_a_3);
    (*res)[2] = jmi_array_rec_1(jmi_array_rec_1(tmp_1, 2)->b, 1)->c - (_x_2_b_1_c_4);
    (*res)[3] = jmi_array_rec_1(jmi_array_rec_1(tmp_1, 2)->b, 2)->c - (_x_2_b_2_c_5);
    (*res)[2] = jmi_array_rec_1(tmp_1, 3)->a - (_x_3_a_6);
    (*res)[3] = jmi_array_rec_1(jmi_array_rec_1(tmp_1, 3)->b, 1)->c - (_x_3_b_1_c_7);
    (*res)[4] = jmi_array_rec_1(jmi_array_rec_1(tmp_1, 3)->b, 2)->c - (_x_3_b_2_c_8);
")})));
end CRecordDecl12;


model CRecordDecl13
  function f
  output Real o;
  input A x;
 algorithm
  o := x.a;
 end f;
 
 record A
  Real a;
  Real b;
 end A;
 
 Real x = f(A(1,2));

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CRecordDecl13",
			description="C code generation for records: inputs: basic test",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_CRecordDecl13_f_def(A_0_r* x_v, jmi_ad_var_t* o_o);
jmi_ad_var_t func_CCodeGenTests_CRecordDecl13_f_exp(A_0_r* x_v);

void func_CCodeGenTests_CRecordDecl13_f_def(A_0_r* x_v, jmi_ad_var_t* o_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t o_v;
    o_v = x_v->a;
    if (o_o != NULL) *o_o = o_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CRecordDecl13_f_exp(A_0_r* x_v) {
    jmi_ad_var_t o_v;
    func_CCodeGenTests_CRecordDecl13_f_def(x_v, &o_v);
    return o_v;
}


    JMI_RECORD_STATIC(A_0_r, tmp_1)
    tmp_1->a = AD_WRAP_LITERAL(1);
    tmp_1->b = AD_WRAP_LITERAL(2);
    (*res)[0] = func_CCodeGenTests_CRecordDecl13_f_exp(tmp_1) - (_x_0);
")})));
end CRecordDecl13;


model CRecordDecl14
 function f
  output Real o;
  input A x;
 algorithm
  o := x.b.c;
 end f;
 
 record A
  Real a;
  B b;
 end A;
 
 record B
  Real c;
 end B;
 
 Real x = f(A(1, B(2)));

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CRecordDecl14",
			description="C code generation for records: inputs: nested records",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_CRecordDecl14_f_def(A_1_r* x_v, jmi_ad_var_t* o_o);
jmi_ad_var_t func_CCodeGenTests_CRecordDecl14_f_exp(A_1_r* x_v);

void func_CCodeGenTests_CRecordDecl14_f_def(A_1_r* x_v, jmi_ad_var_t* o_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t o_v;
    o_v = x_v->b->c;
    if (o_o != NULL) *o_o = o_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CRecordDecl14_f_exp(A_1_r* x_v) {
    jmi_ad_var_t o_v;
    func_CCodeGenTests_CRecordDecl14_f_def(x_v, &o_v);
    return o_v;
}


    JMI_RECORD_STATIC(A_1_r, tmp_1)
    JMI_RECORD_STATIC(B_0_r, tmp_2)
    tmp_1->b = tmp_2;
    tmp_1->a = AD_WRAP_LITERAL(1);
    tmp_1->b->c = AD_WRAP_LITERAL(2);
    (*res)[0] = func_CCodeGenTests_CRecordDecl14_f_exp(tmp_1) - (_x_0);
")})));
end CRecordDecl14;


model CRecordDecl15
 function f
  output Real o;
  input A x;
 algorithm
  o := x.a[1];
 end f;
 
 record A
  Real a[2];
 end A;
 
 Real x = f(A({1,2}));

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CRecordDecl15",
			description="C code generation for records: inputs: array in record",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_CRecordDecl15_f_def(A_0_r* x_v, jmi_ad_var_t* o_o);
jmi_ad_var_t func_CCodeGenTests_CRecordDecl15_f_exp(A_0_r* x_v);

void func_CCodeGenTests_CRecordDecl15_f_def(A_0_r* x_v, jmi_ad_var_t* o_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t o_v;
    o_v = jmi_array_val_1(x_v->a, 1);
    if (o_o != NULL) *o_o = o_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CRecordDecl15_f_exp(A_0_r* x_v) {
    jmi_ad_var_t o_v;
    func_CCodeGenTests_CRecordDecl15_f_def(x_v, &o_v);
    return o_v;
}


    JMI_RECORD_STATIC(A_0_r, tmp_1)
    JMI_ARRAY_STATIC(tmp_2, 2, 1)
    JMI_ARRAY_STATIC_INIT_1(tmp_2, 2)
    tmp_1->a = tmp_2;
    jmi_array_ref_1(tmp_1->a, 1) = AD_WRAP_LITERAL(1);
    jmi_array_ref_1(tmp_1->a, 2) = AD_WRAP_LITERAL(2);
    (*res)[0] = func_CCodeGenTests_CRecordDecl15_f_exp(tmp_1) - (_x_0);
")})));
end CRecordDecl15;


model CRecordDecl16
 function f
  output Real o;
  input A x[3];
 algorithm
  o := x[1].b[2].c;
 end f;
 
 record A
  Real a;
  B b[2];
 end A;
 
 record B
  Real c;
 end B;
 
 Real x = f({A(1,{B(2),B(3)}),A(4,{B(5),B(6)}),A(7,{B(8),B(9)})});

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CRecordDecl16",
			description="C code generation for records: inputs: array of records",
			template="
$C_function_headers$
$C_functions$
$C_DAE_equation_residuals$
",
         generatedCode="
void func_CCodeGenTests_CRecordDecl16_f_def(A_1_ra* x_a, jmi_ad_var_t* o_o);
jmi_ad_var_t func_CCodeGenTests_CRecordDecl16_f_exp(A_1_ra* x_a);

void func_CCodeGenTests_CRecordDecl16_f_def(A_1_ra* x_a, jmi_ad_var_t* o_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t o_v;
    o_v = jmi_array_rec_1(jmi_array_rec_1(x_a, 1)->b, 2)->c;
    if (o_o != NULL) *o_o = o_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_CRecordDecl16_f_exp(A_1_ra* x_a) {
    jmi_ad_var_t o_v;
    func_CCodeGenTests_CRecordDecl16_f_def(x_a, &o_v);
    return o_v;
}


    JMI_RECORD_ARRAY_STATIC(A_1_r, A_1_ra, tmp_1, 3, 1)
    JMI_RECORD_ARRAY_STATIC(B_0_r, B_0_ra, tmp_2, 2, 1)
    JMI_RECORD_ARRAY_STATIC(B_0_r, B_0_ra, tmp_3, 2, 1)
    JMI_RECORD_ARRAY_STATIC(B_0_r, B_0_ra, tmp_4, 2, 1)
    JMI_RECORD_ARRAY_STATIC_INIT_1(A_1_r, tmp_1, 3)
    JMI_RECORD_ARRAY_STATIC_INIT_1(B_0_r, tmp_2, 2)
    jmi_array_rec_1(tmp_1, 1)->b = tmp_2;
    JMI_RECORD_ARRAY_STATIC_INIT_1(B_0_r, tmp_3, 2)
    jmi_array_rec_1(tmp_1, 2)->b = tmp_3;
    JMI_RECORD_ARRAY_STATIC_INIT_1(B_0_r, tmp_4, 2)
    jmi_array_rec_1(tmp_1, 3)->b = tmp_4;
    jmi_array_rec_1(tmp_1, 1)->a = null;
    jmi_array_rec_1(jmi_array_rec_1(tmp_1, 1)->b, 1)->c = null;
    jmi_array_rec_1(jmi_array_rec_1(tmp_1, 1)->b, 2)->c = null;
    jmi_array_rec_1(tmp_1, 2)->a = null;
    jmi_array_rec_1(jmi_array_rec_1(tmp_1, 2)->b, 1)->c = null;
    jmi_array_rec_1(jmi_array_rec_1(tmp_1, 2)->b, 2)->c = null;
    jmi_array_rec_1(tmp_1, 3)->a = null;
    jmi_array_rec_1(jmi_array_rec_1(tmp_1, 3)->b, 1)->c = null;
    jmi_array_rec_1(jmi_array_rec_1(tmp_1, 3)->b, 2)->c = null;
    (*res)[0] = func_CCodeGenTests_CRecordDecl16_f_exp(tmp_1) - (_x_0);
")})));
end CRecordDecl16;



model RemoveCopyright
	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="RemoveCopyright",
			description="Test that licence tag is filtered out",
			template="/* test copyright blurb */ test",
			generatedCode="
test
")})));
end RemoveCopyright;

model ExtStmtInclude1
	function extFunc
		 external "C" annotation(Include="#include \"extFunc.h\"");
	end extFunc;
	algorithm
		extFunc();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="ExtStmtInclude1",
			description="Test that include statement is inserted properly.",
			template="$external_func_includes$",
			generatedCode="
#include \"extFunc.h\"
")})));
end ExtStmtInclude1;

model ExtStmtInclude2
	function extFunc1
		 external "C" annotation(Include="#include \"extFunc1.h\"");
	end extFunc1;
	function extFunc2
		external "C" annotation(Include="#include \"extFunc2.h\"");
	end extFunc2;
	algorithm
		extFunc1();
		extFunc2();

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="ExtStmtInclude2",
			description="Test that include statements are inserted properly.",
			template="$external_func_includes$",
			generatedCode="
#include \"extFunc2.h\"
#include \"extFunc1.h\"
")})));
end ExtStmtInclude2;

model SimpleExternal1
	Real a_in=1;
	Real b_out;
	function f
		input Real a;
		output Real b;
		external;
	end f;
	equation
		b_out = f(a_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternal1",
			description="External C function (undeclared), one scalar input, one scalar output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternal1_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_SimpleExternal1_f_exp(jmi_ad_var_t a_v);

void func_CCodeGenTests_SimpleExternal1_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    b_v = f(a_v);
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_SimpleExternal1_f_exp(jmi_ad_var_t a_v) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_SimpleExternal1_f_def(a_v, &b_v);
    return b_v;
}

")})));
end SimpleExternal1;

model SimpleExternal2
	Real a_in=1;
	Real b_in=2;
	Real c_out;
	function f
		input Real a;
		input Real b;
		output Real c;
		external "C";
	end f;
	equation
		c_out = f(a_in, b_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternal2",
			description="External C function (undeclared), two scalar inputs, one scalar output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternal2_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o);
jmi_ad_var_t func_CCodeGenTests_SimpleExternal2_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v);

void func_CCodeGenTests_SimpleExternal2_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t c_v;
    c_v = f(a_v, b_v);
    if (c_o != NULL) *c_o = c_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_SimpleExternal2_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v) {
    jmi_ad_var_t c_v;
    func_CCodeGenTests_SimpleExternal2_f_def(a_v, b_v, &c_v);
    return c_v;
}

")})));
end SimpleExternal2;

model SimpleExternal3
	Real a_in=1;
	Real b_out;
	function f
		input Real a;
		output Real b;
		external b = my_f(a);
	end f;
	equation
		b_out = f(a_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternal3",
			description="External C function (declared with return), one scalar input, one scalar output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternal3_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_SimpleExternal3_f_exp(jmi_ad_var_t a_v);

void func_CCodeGenTests_SimpleExternal3_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    b_v = my_f(a_v);
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_SimpleExternal3_f_exp(jmi_ad_var_t a_v) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_SimpleExternal3_f_def(a_v, &b_v);
    return b_v;
}

")})));
end SimpleExternal3;

model SimpleExternal4
	Real a_in=1;
	Real b_out;
	function f
		input Real a;
		output Real b;
		external my_f(a, b);
	end f;
	equation
		b_out = f(a_in);	

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternal4",
			description="External C function (declared without return), one scalar input, one scalar output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternal4_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_SimpleExternal4_f_exp(jmi_ad_var_t a_v);

void func_CCodeGenTests_SimpleExternal4_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    my_f(a_v, &b_v);
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_SimpleExternal4_f_exp(jmi_ad_var_t a_v) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_SimpleExternal4_f_def(a_v, &b_v);
    return b_v;
}

")})));
end SimpleExternal4;

model SimpleExternal5
	Real a_in=1;
	function f
		input Real a;
		external;
	end f;
	equation
		f(a_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternal5",
			description="External C function (undeclared), scalar input, no output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternal5_f_def(jmi_ad_var_t a_v);

void func_CCodeGenTests_SimpleExternal5_f_def(jmi_ad_var_t a_v) {
    JMI_DYNAMIC_INIT()
    f(a_v);
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end SimpleExternal5;

model SimpleExternal6
	Real a_in=1;
	function f
		input Real a;
		external my_f(a);
	end f;
	equation
		f(a_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternal6",
			description="External C function (declared), scalar input, no output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternal6_f_def(jmi_ad_var_t a_v);

void func_CCodeGenTests_SimpleExternal6_f_def(jmi_ad_var_t a_v) {
    JMI_DYNAMIC_INIT()
    my_f(a_v);
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end SimpleExternal6;

model SimpleExternal7
	Real a_in = 1;
	Real b_in = 2;
	Real c_out;
	function f
		input Real a;
		input Real b;
		output Real c;
		external my_f(a,c,b);
	end f;
	equation
		c_out = f(a_in, b_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternal7",
			description="External C function (declared without return), two scalar inputs, one scalar output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternal7_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o);
jmi_ad_var_t func_CCodeGenTests_SimpleExternal7_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v);

void func_CCodeGenTests_SimpleExternal7_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t c_v;
    my_f(a_v, &c_v, b_v);
    if (c_o != NULL) *c_o = c_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_SimpleExternal7_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v) {
    jmi_ad_var_t c_v;
    func_CCodeGenTests_SimpleExternal7_f_def(a_v, b_v, &c_v);
    return c_v;
}

")})));
end SimpleExternal7;

model SimpleExternal8
	Real a_in = 1;
	Real b_in = 2;
	Real c_out;
	Real d_out;
	function f
		input Real a;
		input Real b;
		output Real c;
		output Real d;
		external my_f(a,c,b,d);
	end f;
	equation
		(c_out, d_out) = f(a_in, b_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternal8",
			description="External C function (declared without return), two scalar inputs, two scalar outputs.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternal8_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o, jmi_ad_var_t* d_o);
jmi_ad_var_t func_CCodeGenTests_SimpleExternal8_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v);

void func_CCodeGenTests_SimpleExternal8_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o, jmi_ad_var_t* d_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t c_v;
    jmi_ad_var_t d_v;
    my_f(a_v, &c_v, b_v, &d_v);
    if (c_o != NULL) *c_o = c_v;
    if (d_o != NULL) *d_o = d_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_SimpleExternal8_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v) {
    jmi_ad_var_t c_v;
    func_CCodeGenTests_SimpleExternal8_f_def(a_v, b_v, &c_v, NULL);
    return c_v;
}

")})));
end SimpleExternal8;

model SimpleExternal9
	Real a_in = 1;
	Real b_in = 2;
	Real c_out;
	Real d_out;
	function f
		input Real a;
		input Real b;
		output Real c;
		output Real d;
		external d = my_f(a,b,c);
	end f;
	equation
		(c_out, d_out) = f(a_in, b_in);	

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternal9",
			description="External C function (declared with return), two scalar inputs, two scalar outputs (one in return stmt, one in fcn stmt).",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternal9_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o, jmi_ad_var_t* d_o);
jmi_ad_var_t func_CCodeGenTests_SimpleExternal9_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v);

void func_CCodeGenTests_SimpleExternal9_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o, jmi_ad_var_t* d_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t c_v;
    jmi_ad_var_t d_v;
    d_v = my_f(a_v, b_v, &c_v);
    if (c_o != NULL) *c_o = c_v;
    if (d_o != NULL) *d_o = d_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_SimpleExternal9_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v) {
    jmi_ad_var_t c_v;
    func_CCodeGenTests_SimpleExternal9_f_def(a_v, b_v, &c_v, NULL);
    return c_v;
}

")})));
end SimpleExternal9;

model SimpleExternal10
	Real a_in = 1;
	Real b_in = 2;
	Real c_out;
	Real d_out;
	Real e_out;
	function f
		input Real a;
		input Real b;
		output Real c;
		output Real d;
		output Real e;
		external d = my_f(a,c,b,e);
	end f;
	equation
		(c_out, d_out, e_out) = f(a_in, b_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternal10",
			description="External C function (declared with return), two scalar inputs, three scalar outputs (one in return stmt, two in fcn stmt).",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternal10_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o, jmi_ad_var_t* d_o, jmi_ad_var_t* e_o);
jmi_ad_var_t func_CCodeGenTests_SimpleExternal10_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v);

void func_CCodeGenTests_SimpleExternal10_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o, jmi_ad_var_t* d_o, jmi_ad_var_t* e_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t c_v;
    jmi_ad_var_t d_v;
    jmi_ad_var_t e_v;
    d_v = my_f(a_v, &c_v, b_v, &e_v);
    if (c_o != NULL) *c_o = c_v;
    if (d_o != NULL) *d_o = d_v;
    if (e_o != NULL) *e_o = e_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_SimpleExternal10_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v) {
    jmi_ad_var_t c_v;
    func_CCodeGenTests_SimpleExternal10_f_def(a_v, b_v, &c_v, NULL, NULL);
    return c_v;
}

")})));
end SimpleExternal10;

model IntegerExternal1
	Integer a_in=1;
	Real b_out;
	function f
		input Integer a;
		output Real b;
		external;
	end f;
	equation
		b_out = f(a_in);	

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="IntegerExternal1",
			description="External C function (undeclared), one scalar Integer input, one scalar Real output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_IntegerExternal1_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_IntegerExternal1_f_exp(jmi_ad_var_t a_v);

void func_CCodeGenTests_IntegerExternal1_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    jmi_int_t tmp_1;
    tmp_1 = (int)a_v;
    b_v = f(tmp_1);
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_IntegerExternal1_f_exp(jmi_ad_var_t a_v) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_IntegerExternal1_f_def(a_v, &b_v);
    return b_v;
}

")})));
end IntegerExternal1;

model IntegerExternal2
	Real a_in=1;
	Integer b_out;
	function f
		input Real a;
		output Integer b;
		external;
	end f;
	equation
		b_out = f(a_in);	

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="IntegerExternal2",
			description="External C function (undeclared), one scalar Real input, one scalar Integer output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_IntegerExternal2_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_IntegerExternal2_f_exp(jmi_ad_var_t a_v);

void func_CCodeGenTests_IntegerExternal2_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    b_v = f(a_v);
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_IntegerExternal2_f_exp(jmi_ad_var_t a_v) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_IntegerExternal2_f_def(a_v, &b_v);
    return b_v;
}

")})));
end IntegerExternal2;

model IntegerExternal3
	Real a_in=1;
	Integer b_out;
	function f
		input Real a;
		output Integer b;
		external my_f(a, b);
	end f;
	equation
		b_out = f(a_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="IntegerExternal3",
			description="External C function (declared), one scalar Real input, one scalar Integer output in func stmt.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_IntegerExternal3_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_IntegerExternal3_f_exp(jmi_ad_var_t a_v);

void func_CCodeGenTests_IntegerExternal3_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    jmi_int_t tmp_1;
    tmp_1 = (int)b_v;
    my_f(a_v, &tmp_1);
    b_v = tmp_1;
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_IntegerExternal3_f_exp(jmi_ad_var_t a_v) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_IntegerExternal3_f_def(a_v, &b_v);
    return b_v;
}

")})));
end IntegerExternal3;

model IntegerExternal4
	Integer a_in = 1;
	Integer b_in = 2;
	Integer c_out;
	Integer d_out;
	function f
		input Integer a;
		input Integer b;
		output Integer c;
		output Integer d;
		external d = my_f(a,b,c);
	end f;
	equation
		(c_out, d_out) = f(a_in, b_in);	

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="IntegerExternal4",
			description="External C function (declared), two scalar Integer inputs, two scalar Integer outputs (one in return, one in func stmt.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_IntegerExternal4_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o, jmi_ad_var_t* d_o);
jmi_ad_var_t func_CCodeGenTests_IntegerExternal4_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v);

void func_CCodeGenTests_IntegerExternal4_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o, jmi_ad_var_t* d_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t c_v;
    jmi_ad_var_t d_v;
    jmi_int_t tmp_1;
    jmi_int_t tmp_2;
    jmi_int_t tmp_3;
    tmp_1 = (int)a_v;
    tmp_2 = (int)b_v;
    tmp_3 = (int)c_v;
    d_v = my_f(tmp_1, tmp_2, &tmp_3);
    c_v = tmp_3;
    if (c_o != NULL) *c_o = c_v;
    if (d_o != NULL) *d_o = d_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_IntegerExternal4_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v) {
    jmi_ad_var_t c_v;
    func_CCodeGenTests_IntegerExternal4_f_def(a_v, b_v, &c_v, NULL);
    return c_v;
}

")})));
end IntegerExternal4;

model ExternalLiteral1
	Real a_in = 1;
    Real b_in = 2;
    Real c_out;
    function f
        input Real a;
        input Real b;
        output Real c;
        external my_f(a,b,10);
    end f;
    equation
        c_out = f(a_in, b_in);

	annotation(__JModelica(UnitTesting(tests={ 
		CCodeGenTestCase(
			name="ExternalLiteral1",
			description="",
			template="
$C_function_headers$
$C_functions$
",
			generatedCode="
void func_CCodeGenTests_ExternalLiteral1_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o);
jmi_ad_var_t func_CCodeGenTests_ExternalLiteral1_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v);

void func_CCodeGenTests_ExternalLiteral1_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t c_v;
    my_f(a_v, b_v, 10);
    if (c_o != NULL) *c_o = c_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_ExternalLiteral1_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v) {
    jmi_ad_var_t c_v;
    func_CCodeGenTests_ExternalLiteral1_f_def(a_v, b_v, &c_v);
    return c_v;
}

")})));
end ExternalLiteral1;

model ExternalLiteral2
    Real a_in = 1;
    Real b_in = 2;
    Real c_out;
    function f
        input Real a;
        input Real b;
        output Real c;
        external my_f(a,20,b,10);
    end f;
    equation
        c_out = f(a_in, b_in);

	annotation(__JModelica(UnitTesting(tests={ 
		CCodeGenTestCase(
			name="ExternalLiteral2",
			description="",
			template="
$C_function_headers$
$C_functions$
",
			generatedCode="
void func_CCodeGenTests_ExternalLiteral2_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o);
jmi_ad_var_t func_CCodeGenTests_ExternalLiteral2_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v);

void func_CCodeGenTests_ExternalLiteral2_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t c_v;
    my_f(a_v, 20, b_v, 10);
    if (c_o != NULL) *c_o = c_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_ExternalLiteral2_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v) {
    jmi_ad_var_t c_v;
    func_CCodeGenTests_ExternalLiteral2_f_def(a_v, b_v, &c_v);
    return c_v;
}

")})));
end ExternalLiteral2;

model ExternalLiteral3
    Real c_out;
    function f
        output Real c;
        external my_f(10,20,30);
    end f;
    equation
        c_out = f();

	annotation(__JModelica(UnitTesting(tests={ 
		CCodeGenTestCase(
			name="ExternalLiteral3",
			description="",
			template="
$C_function_headers$
$C_functions$
",
			generatedCode="
void func_CCodeGenTests_ExternalLiteral3_f_def(jmi_ad_var_t* c_o);
jmi_ad_var_t func_CCodeGenTests_ExternalLiteral3_f_exp();

void func_CCodeGenTests_ExternalLiteral3_f_def(jmi_ad_var_t* c_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t c_v;
    my_f(10, 20, 30);
    if (c_o != NULL) *c_o = c_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_ExternalLiteral3_f_exp() {
    jmi_ad_var_t c_v;
    func_CCodeGenTests_ExternalLiteral3_f_def(&c_v);
    return c_v;
}

")})));
end ExternalLiteral3;

model IntegerInFunc1
	function f
		input Integer i;
		input Real a[3];
		output Real x;
	algorithm
		x := a[i];
	end f;
	
	Real x[3] = {2.3, 4.2, 1.5};
	Real y = f(1, x);
	Real z = f(2, x);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="IntegerInFunc1",
			description="Using Integer variable in function",
			template="$C_functions$",
			generatedCode="
void func_CCodeGenTests_IntegerInFunc1_f_def(jmi_ad_var_t i_v, jmi_array_t* a_a, jmi_ad_var_t* x_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t x_v;
    x_v = jmi_array_val_1(a_a, i_v);
    if (x_o != NULL) *x_o = x_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_IntegerInFunc1_f_exp(jmi_ad_var_t i_v, jmi_array_t* a_a) {
    jmi_ad_var_t x_v;
    func_CCodeGenTests_IntegerInFunc1_f_def(i_v, a_a, &x_v);
    return x_v;
}

")})));
end IntegerInFunc1;

model IfExpInParExp
  parameter Integer N = 2;
  parameter Real r[3] = array((if i<=N then 1. else 2.) for i in 1:3); 

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="IfExpInParExp",
			description="Test that relational expressions in parameter expressions are treated correctly",
			template="$C_DAE_initial_dependent_parameter_residuals$",
			generatedCode="
    (*res)[0] = COND_EXP_EQ(COND_EXP_LE(AD_WRAP_LITERAL(1), _N_0, JMI_TRUE, JMI_FALSE),JMI_TRUE,AD_WRAP_LITERAL(1.0),AD_WRAP_LITERAL(2.0)) - (_r_1_1);
    (*res)[1] = COND_EXP_EQ(COND_EXP_LE(AD_WRAP_LITERAL(2), _N_0, JMI_TRUE, JMI_FALSE),JMI_TRUE,AD_WRAP_LITERAL(1.0),AD_WRAP_LITERAL(2.0)) - (_r_2_2);
    (*res)[2] = COND_EXP_EQ(COND_EXP_LE(AD_WRAP_LITERAL(3), _N_0, JMI_TRUE, JMI_FALSE),JMI_TRUE,AD_WRAP_LITERAL(1.0),AD_WRAP_LITERAL(2.0)) - (_r_3_3);
")})));
end IfExpInParExp;



model CIntegerExp1
	Real x = 10 ^ 4;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CIntegerExp1",
			description="Test that exponential expressions with integer exponents are properly transformed",
			template="$C_DAE_equation_residuals$",
			generatedCode="
    (*res)[0] = (1.0 * (10) * (10) * (10) * (10)) - (_x_0);
")})));
end CIntegerExp1;


model CIntegerExp2
	Real x = 10 ^ (-4);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CIntegerExp2",
			description="Test that exponential expressions with integer exponents are properly transformed",
			template="$C_DAE_equation_residuals$",
			generatedCode="
    (*res)[0] = (1.0 / (10) / (10) / (10) / (10)) - (_x_0);
")})));
end CIntegerExp2;


model CIntegerExp3
	Real x = 10 ^ 0;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CIntegerExp3",
			description="Test that exponential expressions with integer exponents are properly transformed",
			template="$C_DAE_equation_residuals$",
			generatedCode="
    (*res)[0] = (1.0) - (_x_0);
")})));
end CIntegerExp3;


model CIntegerExp4
	Real x = 10 ^ 10;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CIntegerExp4",
			description="Test that exponential expressions with integer exponents are properly transformed",
			template="$C_DAE_equation_residuals$",
			generatedCode="
    (*res)[0] = pow(10,10) - (_x_0);
")})));
end CIntegerExp4;


model CIntegerExp5
	Real x = 10 ^ (-10);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="CIntegerExp5",
			description="Test that exponential expressions with integer exponents are properly transformed",
			template="$C_DAE_equation_residuals$",
			generatedCode="
    (*res)[0] = pow(10, - ( 10 )) - (_x_0);
")})));
end CIntegerExp5;



model ModelIdentifierTest
	Real r = 1.0;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="ModelIdentifierTest",
			description="",
			template="$C_model_id$",
			generatedCode="
CCodeGenTests_ModelIdentifierTest
")})));
end ModelIdentifierTest;

model GUIDTest1
	Real r = 1.0;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="GUIDTest1",
			description="",
			template="$C_guid$",
			generatedCode="
\"c143b522ea1fdf6db1132a647457c83a\"
")})));
end GUIDTest1;

model GUIDTest2
	Real r = 2.0;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="GUIDTest2",
			description="",
			template="$C_guid$",
			generatedCode="
\"ff13c7197701d1a1e9559970770f01f0\"
")})));
end GUIDTest2;

model DependentParametersWithScalingTest1
  record R
    Real x = 1;
  end R;

  function F
   input Real x;
   output Real y;
  algorithm
   y := 2*x;
  end F;

  function FR
   input R x;
   output R y;
  algorithm
   y := R(x.x*5);
  end FR;

  parameter Real p1 = 1;
  parameter Real p2 = 3*p1;
  parameter Real p3 = F(p2);
  parameter R r = R(3);
  parameter R r2 = r;
  parameter R r3 = FR(r2);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="DependentParametersWithScalingTest1",
			description="",
			enable_variable_scaling=true,
			template="$C_DAE_initial_dependent_parameter_assignments$",
			generatedCode=" 
JMI_RECORD_STATIC(R_0_r, tmp_1)
JMI_RECORD_STATIC(R_0_r, tmp_2)
_p2_1 = (( 3 ) * ( (_p1_0*sf(0)) ))/sf(2);
_r2_x_2 = ((_r_x_3*sf(1)))/sf(3);
_p3_4 = (func_CCodeGenTests_DependentParametersWithScalingTest1_F_exp((_p2_1*sf(2))))/sf(4);
tmp_2->x = (_r2_x_2*sf(3));
func_CCodeGenTests_DependentParametersWithScalingTest1_FR_def(tmp_2, tmp_1);
_temp_1_x_5 = (tmp_1->x)/sf(5);
_r3_x_6 = ((_temp_1_x_5*sf(5)))/sf(6);
")})));
end DependentParametersWithScalingTest1;

model WhenTest1
Real xx(start=2);
discrete Real x; 
discrete Real y; 
discrete Boolean w(start=true); 
discrete Boolean v(start=true); 
discrete Boolean z(start=true); 
equation
der(xx) = -x; 
when y > 2 and pre(z) then 
w = false; 
end when; 
when y > 2 and z then 
v = false; 
end when; 
when x > 2 then 
z = false; 
end when; 
when (time>1 and time<1.1) or  (time>2 and time<2.1) or  (time>3 and time<3.1) then 
x = pre(x) + 1.1; 
y = pre(y) + 1.1; 
end when; 


	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="WhenTest1",
			description="Test of code generation of when clauses.",
			generate_ode=true,
			equation_sorting=true,
			template="
$C_ode_guards$
                   $C_ode_derivatives$ 
                   $C_ode_initialization$
",
         generatedCode=" 
         _guards(0) = LOG_EXP_AND(_sw(0), pre_z_5);
_guards(1) = LOG_EXP_AND(_sw(1), _z_5);
_guards(2) = _sw(2);
_guards(3) = LOG_EXP_OR(LOG_EXP_OR(LOG_EXP_AND(_sw(3), _sw(4)), LOG_EXP_AND(_sw(5), _sw(6))), LOG_EXP_AND(_sw(7), _sw(8)));
_guards(4) = LOG_EXP_OR(LOG_EXP_OR(LOG_EXP_AND(_sw(3), _sw(4)), LOG_EXP_AND(_sw(5), _sw(6))), LOG_EXP_AND(_sw(7), _sw(8)));

model_ode_guards(jmi);
/************* ODE section *********/
_guards(3) = LOG_EXP_OR(LOG_EXP_OR(LOG_EXP_AND(_sw(3), _sw(4)), LOG_EXP_AND(_sw(5), _sw(6))), LOG_EXP_AND(_sw(7), _sw(8)));
if(COND_EXP_EQ(LOG_EXP_AND(_guards(3),LOG_EXP_NOT(_pre_guards(3))),JMI_TRUE,JMI_TRUE,JMI_FALSE)) {
_x_1 = pre_x_1 + 1.1;
} else {
_x_1 = pre_x_1;
}
_der_xx_6 = - ( _x_1 );
/************ Real outputs *********/
/****Integer and boolean outputs ***/
/**** Other variables ***/
_guards(4) = LOG_EXP_OR(LOG_EXP_OR(LOG_EXP_AND(_sw(3), _sw(4)), LOG_EXP_AND(_sw(5), _sw(6))), LOG_EXP_AND(_sw(7), _sw(8)));
if(COND_EXP_EQ(LOG_EXP_AND(_guards(4),LOG_EXP_NOT(_pre_guards(4))),JMI_TRUE,JMI_TRUE,JMI_FALSE)) {
_y_2 = pre_y_2 + 1.1;
} else {
_y_2 = pre_y_2;
}
_guards(0) = LOG_EXP_AND(_sw(0), pre_z_5);
if(COND_EXP_EQ(LOG_EXP_AND(_guards(0),LOG_EXP_NOT(_pre_guards(0))),JMI_TRUE,JMI_TRUE,JMI_FALSE)) {
_w_3 = JMI_FALSE;
} else {
_w_3 = pre_w_3;
}
_guards(2) = _sw(2);
if(COND_EXP_EQ(LOG_EXP_AND(_guards(2),LOG_EXP_NOT(_pre_guards(2))),JMI_TRUE,JMI_TRUE,JMI_FALSE)) {
_z_5 = JMI_FALSE;
} else {
_z_5 = pre_z_5;
}
_guards(1) = LOG_EXP_AND(_sw(1), _z_5);
if(COND_EXP_EQ(LOG_EXP_AND(_guards(1),LOG_EXP_NOT(_pre_guards(1))),JMI_TRUE,JMI_TRUE,JMI_FALSE)) {
_v_4 = JMI_FALSE;
} else {
_v_4 = pre_v_4;
}

model_ode_guards(jmi);
pre_x_1 = 0.0;
_x_1 = pre_x_1;
_der_xx_6 = - ( _x_1 );
pre_w_3 = JMI_TRUE;
_w_3 = pre_w_3;
pre_v_4 = JMI_TRUE;
_v_4 = pre_v_4;
pre_z_5 = JMI_TRUE;
_z_5 = pre_z_5;
pre_y_2 = 0.0;
_y_2 = pre_y_2;
_xx_0 = 2;
  
")})));
end WhenTest1;

model WhenTest2 

 Real x,ref;
 discrete Real I;
 discrete Real u;

 parameter Real K = 1;
 parameter Real Ti = 1;
 parameter Real h = 0.1;

equation
 der(x) = -x + u;
 when sample(0,h) then
   I = pre(I) + h*(ref-x);
   u = K*(ref-x) + 1/Ti*I;
 end when;
 ref = if time <1 then 0 else 1;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="WhenTest2",
			equation_sorting=true,
			description="Test that samplers are not duplicated in the function tha computes the next time event.",
			generate_ode=true,
			template="
$C_ode_guards$
                   $C_ode_time_events$" ,
         generatedCode="
    _guards(0) = jmi_sample(jmi,AD_WRAP_LITERAL(0),_h_6);
  _guards(1) = jmi_sample(jmi,AD_WRAP_LITERAL(0),_h_6);
 
  jmi_real_t nextTimeEvent;
  jmi_real_t nextTimeEventTmp;
  jmi_real_t nSamp;
  nextTimeEvent = JMI_INF;
  nextTimeEventTmp = JMI_INF;
  if (SURELY_LT_ZERO(_t - AD_WRAP_LITERAL(0))) {
    nextTimeEventTmp = AD_WRAP_LITERAL(0);
  }  else if (ALMOST_ZERO(jmi_dremainder(_t - AD_WRAP_LITERAL(0),_h_6))) {
    nSamp = jmi_dround((_t-AD_WRAP_LITERAL(0))/(_h_6));
    nextTimeEventTmp = (nSamp + 1.0)*_h_6 + AD_WRAP_LITERAL(0);
  }  else if (SURELY_GT_ZERO(jmi_dremainder(_t - AD_WRAP_LITERAL(0),_h_6))) {
    nSamp = floor((_t-AD_WRAP_LITERAL(0))/(_h_6));
    nextTimeEventTmp = (nSamp + 1.0)*_h_6 + AD_WRAP_LITERAL(0);
  }
   if (nextTimeEventTmp<nextTimeEvent) {
    nextTimeEvent = nextTimeEventTmp;
  }
  *nextTime = nextTimeEvent;

")})));
end WhenTest2; 

model WhenTest3 

 discrete Real x,y;
 Real dummy;
equation
 der(dummy) = 0;
 when sample(0,1/3) then
   x = pre(x) + 1;
 end when;
 when sample(0,2/3) then
   y = pre(y) + 1;
 end when;


	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="WhenTest3",
			description="Test code generation of samplers",
			generate_ode=true,
			equation_sorting=true,
			template="
$C_ode_time_events$ 
                   $C_ode_derivatives$ 
                   $C_ode_initialization$", 
         generatedCode=" 
 jmi_real_t nextTimeEvent;
jmi_real_t nextTimeEventTmp;
jmi_real_t nSamp;
nextTimeEvent = JMI_INF;
nextTimeEventTmp = JMI_INF;
if (SURELY_LT_ZERO(_t - AD_WRAP_LITERAL(0))) {
nextTimeEventTmp = AD_WRAP_LITERAL(0);
} else if (ALMOST_ZERO(jmi_dremainder(_t - AD_WRAP_LITERAL(0),jmi_divide(AD_WRAP_LITERAL(1),AD_WRAP_LITERAL(3),\"Divide by zero: ( 1 ) / ( 3 )\")))) {
nSamp = jmi_dround((_t-AD_WRAP_LITERAL(0))/(jmi_divide(AD_WRAP_LITERAL(1),AD_WRAP_LITERAL(3),\"Divide by zero: ( 1 ) / ( 3 )\")));
nextTimeEventTmp = (nSamp + 1.0)*jmi_divide(AD_WRAP_LITERAL(1),AD_WRAP_LITERAL(3),\"Divide by zero: ( 1 ) / ( 3 )\") + AD_WRAP_LITERAL(0);
} else if (SURELY_GT_ZERO(jmi_dremainder(_t - AD_WRAP_LITERAL(0),jmi_divide(AD_WRAP_LITERAL(1),AD_WRAP_LITERAL(3),\"Divide by zero: ( 1 ) / ( 3 )\")))) {
nSamp = floor((_t-AD_WRAP_LITERAL(0))/(jmi_divide(AD_WRAP_LITERAL(1),AD_WRAP_LITERAL(3),\"Divide by zero: ( 1 ) / ( 3 )\")));
nextTimeEventTmp = (nSamp + 1.0)*jmi_divide(AD_WRAP_LITERAL(1),AD_WRAP_LITERAL(3),\"Divide by zero: ( 1 ) / ( 3 )\") + AD_WRAP_LITERAL(0);
}
if (nextTimeEventTmp<nextTimeEvent) {
nextTimeEvent = nextTimeEventTmp;
}
nextTimeEventTmp = JMI_INF;
if (SURELY_LT_ZERO(_t - AD_WRAP_LITERAL(0))) {
nextTimeEventTmp = AD_WRAP_LITERAL(0);
} else if (ALMOST_ZERO(jmi_dremainder(_t - AD_WRAP_LITERAL(0),jmi_divide(AD_WRAP_LITERAL(2),AD_WRAP_LITERAL(3),\"Divide by zero: ( 2 ) / ( 3 )\")))) {
nSamp = jmi_dround((_t-AD_WRAP_LITERAL(0))/(jmi_divide(AD_WRAP_LITERAL(2),AD_WRAP_LITERAL(3),\"Divide by zero: ( 2 ) / ( 3 )\")));
nextTimeEventTmp = (nSamp + 1.0)*jmi_divide(AD_WRAP_LITERAL(2),AD_WRAP_LITERAL(3),\"Divide by zero: ( 2 ) / ( 3 )\") + AD_WRAP_LITERAL(0);
} else if (SURELY_GT_ZERO(jmi_dremainder(_t - AD_WRAP_LITERAL(0),jmi_divide(AD_WRAP_LITERAL(2),AD_WRAP_LITERAL(3),\"Divide by zero: ( 2 ) / ( 3 )\")))) {
nSamp = floor((_t-AD_WRAP_LITERAL(0))/(jmi_divide(AD_WRAP_LITERAL(2),AD_WRAP_LITERAL(3),\"Divide by zero: ( 2 ) / ( 3 )\")));
nextTimeEventTmp = (nSamp + 1.0)*jmi_divide(AD_WRAP_LITERAL(2),AD_WRAP_LITERAL(3),\"Divide by zero: ( 2 ) / ( 3 )\") + AD_WRAP_LITERAL(0);
}
if (nextTimeEventTmp<nextTimeEvent) {
nextTimeEvent = nextTimeEventTmp;
}
*nextTime = nextTimeEvent;

model_ode_guards(jmi);
/************* ODE section *********/
_der_dummy_3 = 0;
/************ Real outputs *********/
/****Integer and boolean outputs ***/
/**** Other variables ***/
_guards(0) = jmi_sample(jmi,AD_WRAP_LITERAL(0),jmi_divide(AD_WRAP_LITERAL(1),AD_WRAP_LITERAL(3),\"Divide by zero: ( 1 ) / ( 3 )\"));
if(COND_EXP_EQ(LOG_EXP_AND(_guards(0),LOG_EXP_NOT(_pre_guards(0))),JMI_TRUE,JMI_TRUE,JMI_FALSE)) {
_x_0 = pre_x_0 + 1;
} else {
_x_0 = pre_x_0;
}
_guards(1) = jmi_sample(jmi,AD_WRAP_LITERAL(0),jmi_divide(AD_WRAP_LITERAL(2),AD_WRAP_LITERAL(3),\"Divide by zero: ( 2 ) / ( 3 )\"));
if(COND_EXP_EQ(LOG_EXP_AND(_guards(1),LOG_EXP_NOT(_pre_guards(1))),JMI_TRUE,JMI_TRUE,JMI_FALSE)) {
_y_1 = pre_y_1 + 1;
} else {
_y_1 = pre_y_1;
}

model_ode_guards(jmi);
_der_dummy_3 = 0;
pre_x_0 = 0.0;
_x_0 = pre_x_0;
pre_y_1 = 0.0;
_y_1 = pre_y_1;
_dummy_2 = 0.0;
 
")})));
end WhenTest3; 

model WhenEqu4
 discrete Boolean sampleTrigger;
 Real x_p(start=1, fixed=true);
 Real u_p;
 discrete Real x_c;
 discrete Real u_c;
 parameter Real a_p = -1;
 parameter Real b_p = 1;
 parameter Real c_p = 1;
 parameter Real a_c = 0.8;
 parameter Real b_c = 1;
 parameter Real c_c = 1;
 parameter Real h = 0.1;
initial equation
 x_c = pre(x_c); 	
equation
 der(x_p) = a_p*x_p + b_p*u_p;
 u_p = c_c*x_c;
 sampleTrigger = sample(0,h);
 when {initial(),sampleTrigger} then
   u_c = c_p*x_p;
   x_c = a_c*pre(x_c) + b_c*u_c;
 end when;


	annotation(__JModelica(UnitTesting(tests={ 
		CCodeGenTestCase(
			name="WhenEqu4",
			description="Test code generation of samplers",
			generate_ode=true,
			equation_sorting=true,
			template="
$C_dae_init_blocks_residual_functions$
$C_ode_derivatives$
$C_ode_initialization$
",
			generatedCode="
static int dae_init_block_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
  jmi_real_t** res = &residual;
  if (evaluation_mode==JMI_BLOCK_NOMINAL) {
  } else  if (evaluation_mode==JMI_BLOCK_MIN) {
  } else if (evaluation_mode==JMI_BLOCK_MAX) {
  } else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
    x[0] = pre_x_c_3;
    x[1] = _x_c_3;
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE_JACOBIAN) {
    residual[0] = - ( ( _a_c_8 ) * ( 1.0 ) );
    residual[1] = - ( 1.0 );
    residual[2] = 1.0;
    residual[3] = 1.0;
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
    pre_x_c_3 = x[0];
    _x_c_3 = x[1];
  (*res)[0] = ( _a_c_8 ) * ( pre_x_c_3 ) + ( _b_c_9 ) * ( _u_c_4 ) - (_x_c_3);
  (*res)[1] = pre_x_c_3 - (_x_c_3);
  } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
    pre_x_c_3 = x[0];
    _x_c_3 = x[1];
  }
  return 0;
}


    model_ode_guards(jmi);
/************* ODE section *********/
  _sampleTrigger_0 = jmi_sample(jmi,AD_WRAP_LITERAL(0),_h_11);
  _guards(0) = _atInitial;
  _guards(1) = _sampleTrigger_0;
  if(LOG_EXP_OR(COND_EXP_EQ(LOG_EXP_AND(_guards(0),LOG_EXP_NOT(_pre_guards(0))),JMI_TRUE,JMI_TRUE,JMI_FALSE),
    COND_EXP_EQ(LOG_EXP_AND(_guards(1),LOG_EXP_NOT(_pre_guards(1))),JMI_TRUE,JMI_TRUE,JMI_FALSE))) {
   _u_c_4 = ( _c_p_7 ) * ( _x_p_1 );
  } else {
  _u_c_4 = pre_u_c_4;
  }
  _guards(2) = _atInitial;
  _guards(3) = _sampleTrigger_0;
  if(LOG_EXP_OR(COND_EXP_EQ(LOG_EXP_AND(_guards(2),LOG_EXP_NOT(_pre_guards(2))),JMI_TRUE,JMI_TRUE,JMI_FALSE),
    COND_EXP_EQ(LOG_EXP_AND(_guards(3),LOG_EXP_NOT(_pre_guards(3))),JMI_TRUE,JMI_TRUE,JMI_FALSE))) {
   _x_c_3 = ( _a_c_8 ) * ( pre_x_c_3 ) + ( _b_c_9 ) * ( _u_c_4 );
  } else {
  _x_c_3 = pre_x_c_3;
  }
  _u_p_2 = ( _c_c_10 ) * ( _x_c_3 );
  _der_x_p_12 = ( _a_p_5 ) * ( _x_p_1 ) + ( _b_p_6 ) * ( _u_p_2 );
/************ Real outputs *********/
/****Integer and boolean outputs ***/
/**** Other variables ***/

    model_ode_guards(jmi);
  _x_p_1 = 1;
  _u_c_4 = ( _c_p_7 ) * ( _x_p_1 );
   ef |= jmi_solve_block_residual(jmi->dae_init_block_residuals[0]);
  _u_p_2 = ( _c_c_10 ) * ( _x_c_3 );
  _der_x_p_12 = ( _a_p_5 ) * ( _x_p_1 ) + ( _b_p_6 ) * ( _u_p_2 );
  _sampleTrigger_0 = jmi_sample(jmi,AD_WRAP_LITERAL(0),_h_11);
  pre_sampleTrigger_0 = JMI_FALSE;
  pre_u_c_4 = 0.0;
")})));
end WhenEqu4;

model WhenEqu5
 discrete Boolean sampleTrigger;
 Real x_p(start=1, fixed=true);
 Real u_p;
 discrete Real x_c;
 discrete Real u_c;
 parameter Real a_p = -1;
 parameter Real b_p = 1;
 parameter Real c_p = 1;
 parameter Real a_c = 0.8;
 parameter Real b_c = 1;
 parameter Real c_c = 1;
 parameter Real h = 0.1;
 discrete Boolean atInit = true and initial();
initial equation
 x_c = pre(x_c); 	
equation
 der(x_p) = a_p*x_p + b_p*u_p;
 u_p = c_c*x_c;
 sampleTrigger = sample(0,h);
 when {atInit,sampleTrigger} then
   u_c = c_p*x_p;
   x_c = a_c*pre(x_c) + b_c*u_c;
 end when;

	annotation(__JModelica(UnitTesting(tests={ 
		CCodeGenTestCase(
			name="WhenEqu5",
			description="Test code generation of samplers",
			generate_ode=true,
			equation_sorting=true,
			template="
$C_dae_init_blocks_residual_functions$
$C_ode_derivatives$
$C_ode_initialization$
",
			generatedCode="
static int dae_init_block_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
  jmi_real_t** res = &residual;
  if (evaluation_mode==JMI_BLOCK_NOMINAL) {
  } else  if (evaluation_mode==JMI_BLOCK_MIN) {
  } else if (evaluation_mode==JMI_BLOCK_MAX) {
  } else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
    x[0] = pre_x_c_3;
    x[1] = _x_c_3;
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE_JACOBIAN) {
    residual[0] = - ( 1.0 );
    residual[1] = - ( 1.0 );
    residual[2] = 1.0;
    residual[3] = 1.0;
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
    pre_x_c_3 = x[0];
    _x_c_3 = x[1];
  (*res)[0] = pre_x_c_3 - (_x_c_3);
  (*res)[1] = pre_x_c_3 - (_x_c_3);
  } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
    pre_x_c_3 = x[0];
    _x_c_3 = x[1];
  }
  return 0;
}


    model_ode_guards(jmi);
/************* ODE section *********/
  _atInit_12 = LOG_EXP_AND(JMI_TRUE, _atInitial);
  _sampleTrigger_0 = jmi_sample(jmi,AD_WRAP_LITERAL(0),_h_11);
  _guards(0) = _atInit_12;
  _guards(1) = _sampleTrigger_0;
  if(LOG_EXP_OR(COND_EXP_EQ(LOG_EXP_AND(_guards(0),LOG_EXP_NOT(_pre_guards(0))),JMI_TRUE,JMI_TRUE,JMI_FALSE),
    COND_EXP_EQ(LOG_EXP_AND(_guards(1),LOG_EXP_NOT(_pre_guards(1))),JMI_TRUE,JMI_TRUE,JMI_FALSE))) {
   _u_c_4 = ( _c_p_7 ) * ( _x_p_1 );
  } else {
  _u_c_4 = pre_u_c_4;
  }
  _guards(2) = _atInit_12;
  _guards(3) = _sampleTrigger_0;
  if(LOG_EXP_OR(COND_EXP_EQ(LOG_EXP_AND(_guards(2),LOG_EXP_NOT(_pre_guards(2))),JMI_TRUE,JMI_TRUE,JMI_FALSE),
    COND_EXP_EQ(LOG_EXP_AND(_guards(3),LOG_EXP_NOT(_pre_guards(3))),JMI_TRUE,JMI_TRUE,JMI_FALSE))) {
   _x_c_3 = ( _a_c_8 ) * ( pre_x_c_3 ) + ( _b_c_9 ) * ( _u_c_4 );
  } else {
  _x_c_3 = pre_x_c_3;
  }
  _u_p_2 = ( _c_c_10 ) * ( _x_c_3 );
  _der_x_p_13 = ( _a_p_5 ) * ( _x_p_1 ) + ( _b_p_6 ) * ( _u_p_2 );
/************ Real outputs *********/
/****Integer and boolean outputs ***/
/**** Other variables ***/

    model_ode_guards(jmi);
   ef |= jmi_solve_block_residual(jmi->dae_init_block_residuals[0]);
  _u_p_2 = ( _c_c_10 ) * ( _x_c_3 );
  _x_p_1 = 1;
  _der_x_p_13 = ( _a_p_5 ) * ( _x_p_1 ) + ( _b_p_6 ) * ( _u_p_2 );
  _sampleTrigger_0 = jmi_sample(jmi,AD_WRAP_LITERAL(0),_h_11);
  _atInit_12 = LOG_EXP_AND(JMI_TRUE, _atInitial);
  pre_u_c_4 = 0.0;
  _u_c_4 = pre_u_c_4;
  pre_sampleTrigger_0 = JMI_FALSE;
  pre_atInit_12 = JMI_FALSE;
")})));
end WhenEqu5;

model WhenEqu6
	function F
		input Real x;
		output Real y1;
		output Real y2;
	algorithm
		y1 := 1;
		y2 := 2;
	end F;
	Real x,y;
	equation
	when sample(0,1) then
		(x,y) = F(time);
	end when;

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="WhenTest6",
			description="Test code generation when equations with function calls.",
			generate_ode=true,
			equation_sorting=true,
			template="
$C_dae_init_blocks_residual_functions$
                   $C_ode_derivatives$ 
                   $C_ode_initialization$",               
         generatedCode=" 
		       jmi_ad_var_t tmp_1;
    jmi_ad_var_t tmp_2;
    model_ode_guards(jmi);
/************* ODE section *********/
/************ Real outputs *********/
/****Integer and boolean outputs ***/
/**** Other variables ***/
  _guards(0) = jmi_sample(jmi,AD_WRAP_LITERAL(0),AD_WRAP_LITERAL(1));
  if(COND_EXP_EQ(LOG_EXP_AND(_guards(0),LOG_EXP_NOT(_pre_guards(0))),JMI_TRUE,JMI_TRUE,JMI_FALSE)) {
   func_CCodeGenTests_WhenEqu6_F_def(_time, &tmp_1, &tmp_2);
   _x_0 = (tmp_1);
   _y_1 = (tmp_2);
  } else {
  _x_0 = pre_x_0;
    _y_1 = pre_y_1;
  }
		 
      model_ode_guards(jmi);
  pre_x_0 = 0.0;
  _x_0 = pre_x_0;
  pre_y_1 = 0.0;
  _y_1 = pre_y_1;		 
")})));
end WhenEqu6;


model NoDAEGenerationTest1
  Real x, y, z;
  parameter Real p = 1;
  parameter Real p2 = p;
equation
  z = x + y;
  3 = x - y;
  5 = x + 3*y;  


	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="NoDAEGenerationTest1",
			description="Test that no DAE is generated if the corresponding option is set to false.",
			generate_dae=false,
			template="
$C_DAE_equation_residuals$
                   $C_DAE_initial_equation_residuals$
                   $C_DAE_initial_dependent_parameter_residuals$
",
         generatedCode=" 
")})));
end NoDAEGenerationTest1;

model BlockTest1
  Real x, y, z;
equation
  z = x + y;
  3 = x - y;
  5 = x + 3*y;  

	annotation(__JModelica(UnitTesting(tests={ 
		CCodeGenTestCase(
			name="BlockTest1",
			description="Test code generation of systems of equations.",
			generate_ode=true,
			equation_sorting=true,
			enable_tearing=false,
			template="
$C_dae_blocks_residual_functions$
$C_dae_init_blocks_residual_functions$
$C_ode_derivatives$
$C_ode_initialization$
",
			generatedCode="
static int dae_block_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
  jmi_real_t** res = &residual;
  if (evaluation_mode==JMI_BLOCK_NOMINAL) {
  } else  if (evaluation_mode==JMI_BLOCK_MIN) {
  } else if (evaluation_mode==JMI_BLOCK_MAX) {
  } else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
    x[0] = _y_1;
    x[1] = _x_0;
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE_JACOBIAN) {
    residual[0] = - ( ( 3 ) * ( 1.0 ) );
    residual[1] = - ( - ( 1.0 ) );
    residual[2] = - ( 1.0 );
    residual[3] = - ( 1.0 );
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
    _y_1 = x[0];
    _x_0 = x[1];
  (*res)[0] = _x_0 + ( 3 ) * ( _y_1 ) - (5);
  (*res)[1] = _x_0 - ( _y_1 ) - (3);
  } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
    _y_1 = x[0];
    _x_0 = x[1];
  }
  return 0;
}


static int dae_init_block_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
  jmi_real_t** res = &residual;
  if (evaluation_mode==JMI_BLOCK_NOMINAL) {
  } else  if (evaluation_mode==JMI_BLOCK_MIN) {
  } else if (evaluation_mode==JMI_BLOCK_MAX) {
  } else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
    x[0] = _y_1;
    x[1] = _x_0;
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE_JACOBIAN) {
    residual[0] = - ( ( 3 ) * ( 1.0 ) );
    residual[1] = - ( - ( 1.0 ) );
    residual[2] = - ( 1.0 );
    residual[3] = - ( 1.0 );
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
    _y_1 = x[0];
    _x_0 = x[1];
  (*res)[0] = _x_0 + ( 3 ) * ( _y_1 ) - (5);
  (*res)[1] = _x_0 - ( _y_1 ) - (3);
  } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
    _y_1 = x[0];
    _x_0 = x[1];
  }
  return 0;
}


    model_ode_guards(jmi);
/************* ODE section *********/
/************ Real outputs *********/
/****Integer and boolean outputs ***/
/**** Other variables ***/
   ef |= jmi_solve_block_residual(jmi->dae_block_residuals[0]);
  _z_2 = _x_0 + _y_1;

    model_ode_guards(jmi);
   ef |= jmi_solve_block_residual(jmi->dae_init_block_residuals[0]);
  _z_2 = _x_0 + _y_1;
")})));
end BlockTest1;


model BlockTest2
Real x1,x2,z1,z2[2];

equation

sin(z1)*3 = z1 + 2;
{{1,2},{3,4}}*z2 = {4,5};

der(x2) = -x2 + z2[1] + z2[2];
der(x1) = -x1 + z1;

	annotation(__JModelica(UnitTesting(tests={ 
		CCodeGenTestCase(
			name="BlockTest2",
			description="Test generation of equation blocks",
			generate_ode=true,
			equation_sorting=true,
			template="
$C_dae_blocks_residual_functions$
$C_dae_init_blocks_residual_functions$
$C_ode_derivatives$
$C_ode_initialization$
",
			generatedCode="
static int dae_block_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
  jmi_real_t** res = &residual;
  if (evaluation_mode==JMI_BLOCK_NOMINAL) {
  } else  if (evaluation_mode==JMI_BLOCK_MIN) {
  } else if (evaluation_mode==JMI_BLOCK_MAX) {
  } else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
    x[0] = _z2_2_4;
    x[1] = _z2_1_3;
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE_JACOBIAN) {
     residual[0] = ( 4 ) * ( 1.0 );
     residual[1] = ( 2 ) * ( 1.0 );
     residual[2] = ( 3 ) * ( 1.0 );
     residual[3] = ( 1 ) * ( 1.0 );
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
    _z2_2_4 = x[0];
    _z2_1_3 = x[1];
  (*res)[0] = 5 - (( 3 ) * ( _z2_1_3 ) + ( 4 ) * ( _z2_2_4 ));
  (*res)[1] = 4 - (( 1 ) * ( _z2_1_3 ) + ( 2 ) * ( _z2_2_4 ));
  } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
    _z2_2_4 = x[0];
    _z2_1_3 = x[1];
  }
  return 0;
}

static int dae_block_1(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
  jmi_real_t** res = &residual;
  if (evaluation_mode==JMI_BLOCK_NOMINAL) {
  } else  if (evaluation_mode==JMI_BLOCK_MIN) {
  } else if (evaluation_mode==JMI_BLOCK_MAX) {
  } else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
    x[0] = _z1_2;
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
    _z1_2 = x[0];
  (*res)[0] = _z1_2 + 2 - (( sin(_z1_2) ) * ( 3 ));
  } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
    _z1_2 = x[0];
  }
  return 0;
}


static int dae_init_block_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
  jmi_real_t** res = &residual;
  if (evaluation_mode==JMI_BLOCK_NOMINAL) {
  } else  if (evaluation_mode==JMI_BLOCK_MIN) {
  } else if (evaluation_mode==JMI_BLOCK_MAX) {
  } else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
    x[0] = _z1_2;
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
    _z1_2 = x[0];
  (*res)[0] = _z1_2 + 2 - (( sin(_z1_2) ) * ( 3 ));
  } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
    _z1_2 = x[0];
  }
  return 0;
}

static int dae_init_block_1(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
  jmi_real_t** res = &residual;
  if (evaluation_mode==JMI_BLOCK_NOMINAL) {
  } else  if (evaluation_mode==JMI_BLOCK_MIN) {
  } else if (evaluation_mode==JMI_BLOCK_MAX) {
  } else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
    x[0] = _z2_2_4;
    x[1] = _z2_1_3;
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE_JACOBIAN) {
     residual[0] = ( 4 ) * ( 1.0 );
     residual[1] = ( 2 ) * ( 1.0 );
     residual[2] = ( 3 ) * ( 1.0 );
     residual[3] = ( 1 ) * ( 1.0 );
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
    _z2_2_4 = x[0];
    _z2_1_3 = x[1];
  (*res)[0] = 5 - (( 3 ) * ( _z2_1_3 ) + ( 4 ) * ( _z2_2_4 ));
  (*res)[1] = 4 - (( 1 ) * ( _z2_1_3 ) + ( 2 ) * ( _z2_2_4 ));
  } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
    _z2_2_4 = x[0];
    _z2_1_3 = x[1];
  }
  return 0;
}


    model_ode_guards(jmi);
/************* ODE section *********/
   ef |= jmi_solve_block_residual(jmi->dae_block_residuals[0]);
  _der_x2_5 =  - ( _x2_1 ) + _z2_1_3 + _z2_2_4;
   ef |= jmi_solve_block_residual(jmi->dae_block_residuals[1]);
  _der_x1_6 =  - ( _x1_0 ) + _z1_2;
/************ Real outputs *********/
/****Integer and boolean outputs ***/
/**** Other variables ***/

    model_ode_guards(jmi);
   ef |= jmi_solve_block_residual(jmi->dae_init_block_residuals[0]);
   ef |= jmi_solve_block_residual(jmi->dae_init_block_residuals[1]);
  _x2_1 = 0.0;
  _der_x2_5 =  - ( _x2_1 ) + _z2_1_3 + _z2_2_4;
  _x1_0 = 0.0;
  _der_x1_6 =  - ( _x1_0 ) + _z1_2;
")})));
end BlockTest2;

model BlockTest3
 parameter Real m = 1;
 parameter Real f0 = 1;
 parameter Real f1 = 1;
 Real v;
 Real a;
 Real f;
 Real u;
 Real sa;
 Boolean startFor(start=false);
 Boolean startBack(start=false);
 Integer mode(start=2);
 Real dummy;
equation 
 der(dummy) = 1;
 u = 2*sin(time);
 m*der(v) = u - f;
 der(v) = a;
 startFor = pre(mode)==2 and sa > 1;
 startBack = pre(mode) == 2 and sa < -1;
 a = if pre(mode) == 1 or startFor then sa-1 else 
     if pre(mode) == 3 or startBack then 
     sa + 1 else 0;
 f = if pre(mode) == 1 or startFor then 
     f0 + f1*v else 
     if pre(mode) == 3 or startBack then 
     -f0 + f1*v else f0*sa;
 mode=if (pre(mode) == 1 or startFor)
      and v>0 then 1 else 
      if (pre(mode) == 3 or startBack)
          and v<0 then 3 else 2;


	annotation(__JModelica(UnitTesting(tests={ 
		CCodeGenTestCase(
			name="BlockTest3",
			description="Test of code generation of blocks",
			generate_ode=true,
			equation_sorting=true,
			template="
$C_dae_blocks_residual_functions$
$C_dae_init_blocks_residual_functions$
$C_ode_derivatives$
$C_ode_initialization$
",
			generatedCode="
static int dae_block_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
  jmi_real_t** res = &residual;
  if (evaluation_mode==JMI_BLOCK_NOMINAL) {
  } else  if (evaluation_mode==JMI_BLOCK_MIN) {
  } else if (evaluation_mode==JMI_BLOCK_MAX) {
  } else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
    x[0] = _a_4;
    x[1] = _sa_7;
    x[2] = _f_5;
    x[3] = _der_v_13;
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
    _a_4 = x[0];
    _sa_7 = x[1];
    _f_5 = x[2];
    _der_v_13 = x[3];
  (*res)[0] = _a_4 - (_der_v_13);
  (*res)[1] = COND_EXP_EQ(LOG_EXP_OR(COND_EXP_EQ(pre_mode_10, AD_WRAP_LITERAL(1), JMI_TRUE, JMI_FALSE), _startFor_8), JMI_TRUE, _sa_7 - ( AD_WRAP_LITERAL(1) ), COND_EXP_EQ(LOG_EXP_OR(COND_EXP_EQ(pre_mode_10, AD_WRAP_LITERAL(3), JMI_TRUE, JMI_FALSE), _startBack_9), JMI_TRUE, _sa_7 + AD_WRAP_LITERAL(1), AD_WRAP_LITERAL(0))) - (_a_4);
  (*res)[2] = COND_EXP_EQ(LOG_EXP_OR(COND_EXP_EQ(pre_mode_10, AD_WRAP_LITERAL(1), JMI_TRUE, JMI_FALSE), _startFor_8), JMI_TRUE, _f0_1 + ( _f1_2 ) * ( _v_3 ), COND_EXP_EQ(LOG_EXP_OR(COND_EXP_EQ(pre_mode_10, AD_WRAP_LITERAL(3), JMI_TRUE, JMI_FALSE), _startBack_9), JMI_TRUE,  - ( _f0_1 ) + ( _f1_2 ) * ( _v_3 ), ( _f0_1 ) * ( _sa_7 ))) - (_f_5);
  (*res)[3] = _u_6 - ( _f_5 ) - (( _m_0 ) * ( _der_v_13 ));
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE_NON_REALS) {
 _startBack_9 = LOG_EXP_AND(COND_EXP_EQ(pre_mode_10, 2, JMI_TRUE, JMI_FALSE), _sw(1));
 _startFor_8 = LOG_EXP_AND(COND_EXP_EQ(pre_mode_10, 2, JMI_TRUE, JMI_FALSE), _sw(0));
  }  else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
    _a_4 = x[0];
    _sa_7 = x[1];
    _f_5 = x[2];
    _der_v_13 = x[3];
  }
  return 0;
}


static int dae_init_block_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
  jmi_real_t** res = &residual;
  if (evaluation_mode==JMI_BLOCK_NOMINAL) {
  } else  if (evaluation_mode==JMI_BLOCK_MIN) {
  } else if (evaluation_mode==JMI_BLOCK_MAX) {
  } else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
    x[0] = _a_4;
    x[1] = _sa_7;
    x[2] = _f_5;
    x[3] = _der_v_13;
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
    _a_4 = x[0];
    _sa_7 = x[1];
    _f_5 = x[2];
    _der_v_13 = x[3];
  (*res)[0] = _a_4 - (_der_v_13);
  (*res)[1] = COND_EXP_EQ(LOG_EXP_OR(COND_EXP_EQ(pre_mode_10, AD_WRAP_LITERAL(1), JMI_TRUE, JMI_FALSE), _startFor_8), JMI_TRUE, _sa_7 - ( AD_WRAP_LITERAL(1) ), COND_EXP_EQ(LOG_EXP_OR(COND_EXP_EQ(pre_mode_10, AD_WRAP_LITERAL(3), JMI_TRUE, JMI_FALSE), _startBack_9), JMI_TRUE, _sa_7 + AD_WRAP_LITERAL(1), AD_WRAP_LITERAL(0))) - (_a_4);
  (*res)[2] = COND_EXP_EQ(LOG_EXP_OR(COND_EXP_EQ(pre_mode_10, AD_WRAP_LITERAL(1), JMI_TRUE, JMI_FALSE), _startFor_8), JMI_TRUE, _f0_1 + ( _f1_2 ) * ( _v_3 ), COND_EXP_EQ(LOG_EXP_OR(COND_EXP_EQ(pre_mode_10, AD_WRAP_LITERAL(3), JMI_TRUE, JMI_FALSE), _startBack_9), JMI_TRUE,  - ( _f0_1 ) + ( _f1_2 ) * ( _v_3 ), ( _f0_1 ) * ( _sa_7 ))) - (_f_5);
  (*res)[3] = _u_6 - ( _f_5 ) - (( _m_0 ) * ( _der_v_13 ));
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE_NON_REALS) {
 _startBack_9 = LOG_EXP_AND(COND_EXP_EQ(pre_mode_10, 2, JMI_TRUE, JMI_FALSE), _sw(1));
 _startFor_8 = LOG_EXP_AND(COND_EXP_EQ(pre_mode_10, 2, JMI_TRUE, JMI_FALSE), _sw(0));
  } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
    _a_4 = x[0];
    _sa_7 = x[1];
    _f_5 = x[2];
    _der_v_13 = x[3];
  }
  return 0;
}


    model_ode_guards(jmi);
/************* ODE section *********/
  _der_dummy_12 = 1;
  _u_6 = ( 2 ) * ( sin(_time) );
   ef |= jmi_solve_block_residual(jmi->dae_block_residuals[0]);
/************ Real outputs *********/
/****Integer and boolean outputs ***/
/**** Other variables ***/
  _mode_10 = COND_EXP_EQ(LOG_EXP_AND(LOG_EXP_OR(COND_EXP_EQ(pre_mode_10, AD_WRAP_LITERAL(1), JMI_TRUE, JMI_FALSE), _startFor_8), _sw(2)), JMI_TRUE, AD_WRAP_LITERAL(1), COND_EXP_EQ(LOG_EXP_AND(LOG_EXP_OR(COND_EXP_EQ(pre_mode_10, AD_WRAP_LITERAL(3), JMI_TRUE, JMI_FALSE), _startBack_9), _sw(3)), JMI_TRUE, AD_WRAP_LITERAL(3), AD_WRAP_LITERAL(2)));

    model_ode_guards(jmi);
  _der_dummy_12 = 1;
  _u_6 = ( 2 ) * ( sin(_time) );
  pre_mode_10 = 2;
  _v_3 = 0.0;
   ef |= jmi_solve_block_residual(jmi->dae_init_block_residuals[0]);
  _mode_10 = COND_EXP_EQ(LOG_EXP_AND(LOG_EXP_OR(COND_EXP_EQ(pre_mode_10, AD_WRAP_LITERAL(1), JMI_TRUE, JMI_FALSE), _startFor_8), _sw(2)), JMI_TRUE, AD_WRAP_LITERAL(1), COND_EXP_EQ(LOG_EXP_AND(LOG_EXP_OR(COND_EXP_EQ(pre_mode_10, AD_WRAP_LITERAL(3), JMI_TRUE, JMI_FALSE), _startBack_9), _sw(3)), JMI_TRUE, AD_WRAP_LITERAL(3), AD_WRAP_LITERAL(2)));
  _dummy_11 = 0.0;
  pre_startFor_8 = JMI_FALSE;
  pre_startBack_9 = JMI_FALSE;
")})));
end BlockTest3;

model BlockTest4
  Real x(min=3); 
  Real y(max=-2, nominal=5);
  Real z(min=4,max=5,nominal=8);
equation
  z = x + y;
  3 = x - y;
  5 = x + 3*y + z;  

	annotation(__JModelica(UnitTesting(tests={ 
		CCodeGenTestCase(
			name="BlockTest4",
			description="Test that min, max, and nominal attributes are correctly generated",
			generate_ode=true,
			equation_sorting=true,
			template="$C_dae_blocks_residual_functions$",
			generatedCode="
static int dae_block_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
  jmi_real_t** res = &residual;
  if (evaluation_mode==JMI_BLOCK_NOMINAL) {
    x[0] = 5.0;
    x[2] = 8.0;
  } else  if (evaluation_mode==JMI_BLOCK_MIN) {
    x[1] = 3.0;
    x[2] = 4.0;
  } else if (evaluation_mode==JMI_BLOCK_MAX) {
    x[0] = -2.0;
    x[2] = 5.0;
  } else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
    x[0] = _y_1;
    init_with_ubound(x[0],-2.0, \"Resetting initial value for y\");
    x[1] = _x_0;
    init_with_lbound(x[1],3.0, \"Resetting initial value for x\");
    x[2] = _z_2;
    init_with_bounds(x[2],4.0, 5.0, \"Resetting initial value for z\");
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE_JACOBIAN) {
    residual[0] = - ( ( 3 ) * ( 1.0 ) );
    residual[1] = - ( - ( 1.0 ) );
    residual[2] = - ( 1.0 );
    residual[3] = - ( 1.0 );
    residual[4] = - ( 1.0 );
    residual[5] = - ( 1.0 );
    residual[6] = - ( 1.0 );
    residual[7] = 0.0;
    residual[8] = 1.0;
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
    check_ubound(x[0],-2.0, \"Out of bounds for variable y\");
    check_lbound(x[1],3.0, \"Out of bound for variable x\");
    check_bounds(x[2],4.0, 5.0, \"Out of bounds for variable z\");
    _y_1 = x[0];
    _x_0 = x[1];
    _z_2 = x[2];
  (*res)[0] = _x_0 + ( 3 ) * ( _y_1 ) + _z_2 - (5);
  (*res)[1] = _x_0 - ( _y_1 ) - (3);
  (*res)[2] = _x_0 + _y_1 - (_z_2);
  } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
    _y_1 = x[0];
    _x_0 = x[1];
    _z_2 = x[2];
  }
  return 0;
}
")})));
end BlockTest4;

model BlockTest5
  parameter Real p1 = 4;
  Real x[2](min={1, 4*p1}); 
  Real y(max=-2, nominal=5);
  equation
  3 = x[1] - y + x[2];
  5 = x[1] + 3*y;
  3 = x[1] + y + x[2];  



	annotation(__JModelica(UnitTesting(tests={ 
		CCodeGenTestCase(
			name="BlockTest5",
			description="Test of min and max for iteration varaibles.",
			generate_ode=true,
			equation_sorting=true,
			template="$C_dae_blocks_residual_functions$",
			generatedCode="
static int dae_block_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
  jmi_real_t** res = &residual;
  if (evaluation_mode==JMI_BLOCK_NOMINAL) {
    x[1] = 5.0;
  } else  if (evaluation_mode==JMI_BLOCK_MIN) {
    x[0] = 16.0;
    x[2] = 1.0;
  } else if (evaluation_mode==JMI_BLOCK_MAX) {
    x[1] = -2.0;
  } else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
    x[0] = _x_2_2;
    init_with_lbound(x[0],16.0, \"Resetting initial value for x[2]\");
    x[1] = _y_3;
    init_with_ubound(x[1],-2.0, \"Resetting initial value for y\");
    x[2] = _x_1_1;
    init_with_lbound(x[2],1.0, \"Resetting initial value for x[1]\");
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE_JACOBIAN) {
    residual[0] = - ( 1.0 );
    residual[1] = 0.0;
    residual[2] = - ( 1.0 );
    residual[3] = - ( 1.0 );
    residual[4] = - ( ( 3 ) * ( 1.0 ) );
    residual[5] = - ( - ( 1.0 ) );
    residual[6] = - ( 1.0 );
    residual[7] = - ( 1.0 );
    residual[8] = - ( 1.0 );
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
    check_lbound(x[0],16.0, \"Out of bound for variable x[2]\");
    check_ubound(x[1],-2.0, \"Out of bounds for variable y\");
    check_lbound(x[2],1.0, \"Out of bound for variable x[1]\");
    _x_2_2 = x[0];
    _y_3 = x[1];
    _x_1_1 = x[2];
  (*res)[0] = _x_1_1 + _y_3 + _x_2_2 - (3);
  (*res)[1] = _x_1_1 + ( 3 ) * ( _y_3 ) - (5);
  (*res)[2] = _x_1_1 - ( _y_3 ) + _x_2_2 - (3);
  } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
    _x_2_2 = x[0];
    _y_3 = x[1];
    _x_1_1 = x[2];
  }
  return 0;
}

")})));
end BlockTest5;

model BlockTest6
 

  function f1
    input Real x;
	output Real y=0;
  algorithm
	  for i in 1:3 loop
		  y := y + x;
	  end for;
  end f1;

  function f2
	input Real x;
	input Integer n;
	output Real y[2]={0,0};
  algorithm
	  for i in 1:n loop
		  y := {y[1] + x, y[2] + 2*x};
	  end for;
  end f2;
  
  parameter Real p1 = 4;
  Real x[2](min=f2(3,2)); 
  Real y(max=-f1(2), nominal=5);
  equation
  3 = x[1] - y + x[2];
  5 = x[1] + 3*y;
  3 = x[1] + y + x[2];  

	annotation(__JModelica(UnitTesting(tests={ 
		CCodeGenTestCase(
			name="BlockTest6",
			description="Test of min, max and nominal attributes in blocks",
			generate_ode=true,
			equation_sorting=true,
			template="$C_dae_blocks_residual_functions$",
			generatedCode="
static int dae_block_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
  jmi_real_t** res = &residual;
  if (evaluation_mode==JMI_BLOCK_NOMINAL) {
    x[1] = 5.0;
  } else  if (evaluation_mode==JMI_BLOCK_MIN) {
    x[0] = 12.0;
    x[2] = 6.0;
  } else if (evaluation_mode==JMI_BLOCK_MAX) {
    x[1] = -6.0;
  } else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
    x[0] = _x_2_2;
    init_with_lbound(x[0],12.0, \"Resetting initial value for x[2]\");
    x[1] = _y_3;
    init_with_ubound(x[1],-6.0, \"Resetting initial value for y\");
    x[2] = _x_1_1;
    init_with_lbound(x[2],6.0, \"Resetting initial value for x[1]\");
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE_JACOBIAN) {
    residual[0] = - ( 1.0 );
    residual[1] = 0.0;
    residual[2] = - ( 1.0 );
    residual[3] = - ( 1.0 );
    residual[4] = - ( ( 3 ) * ( 1.0 ) );
    residual[5] = - ( - ( 1.0 ) );
    residual[6] = - ( 1.0 );
    residual[7] = - ( 1.0 );
    residual[8] = - ( 1.0 );
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
    check_lbound(x[0],12.0, \"Out of bound for variable x[2]\");
    check_ubound(x[1],-6.0, \"Out of bounds for variable y\");
    check_lbound(x[2],6.0, \"Out of bound for variable x[1]\");
    _x_2_2 = x[0];
    _y_3 = x[1];
    _x_1_1 = x[2];
  (*res)[0] = _x_1_1 + _y_3 + _x_2_2 - (3);
  (*res)[1] = _x_1_1 + ( 3 ) * ( _y_3 ) - (5);
  (*res)[2] = _x_1_1 - ( _y_3 ) + _x_2_2 - (3);
  } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
    _x_2_2 = x[0];
    _y_3 = x[1];
    _x_1_1 = x[2];
  }
  return 0;
}

")})));
end BlockTest6;

model BlockTest7

parameter Real A[2,2] = 2*{{1,2},{3,4}};
Real x[2];
Real y[2];
Real z[2];
Real w[2];
parameter Real p = 2;
discrete Real d;

equation
when time>=1 then
 d = pre(d) + 1;
end when;

{{1,2},{3,4}}*x = {3,4};
p*A*y = y;
(d+1)*A*z = z+{2,2};
(x[1]+1)*A*w = w+{3,3};


	annotation(__JModelica(UnitTesting(tests={ 
		CCodeGenTestCase(
			name="BlockTest7",
			description="Test of min, max and nominal attributes in blocks",
			generate_ode=true,
			equation_sorting=true,
			template="$C_dae_blocks_residual_functions$
$C_dae_init_blocks_residual_functions$
$C_dae_add_blocks_residual_functions$
$C_dae_init_add_blocks_residual_functions$",
			generatedCode="
static int dae_block_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
jmi_real_t** res = &residual;
if (evaluation_mode==JMI_BLOCK_NOMINAL) {
} else if (evaluation_mode==JMI_BLOCK_MIN) {
} else if (evaluation_mode==JMI_BLOCK_MAX) {
} else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
x[0] = _x_2_5;
x[1] = _x_1_4;
} else if (evaluation_mode==JMI_BLOCK_EVALUATE_JACOBIAN) {
residual[0] = ( 4 ) * ( 1.0 );
residual[1] = ( 2 ) * ( 1.0 );
residual[2] = ( 3 ) * ( 1.0 );
residual[3] = ( 1 ) * ( 1.0 );
} else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
_x_2_5 = x[0];
_x_1_4 = x[1];
(*res)[0] = 4 - (( 3 ) * ( _x_1_4 ) + ( 4 ) * ( _x_2_5 ));
(*res)[1] = 3 - (( 1 ) * ( _x_1_4 ) + ( 2 ) * ( _x_2_5 ));
} else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
_x_2_5 = x[0];
_x_1_4 = x[1];
}
return 0;
}

static int dae_block_1(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
jmi_real_t** res = &residual;
if (evaluation_mode==JMI_BLOCK_NOMINAL) {
} else if (evaluation_mode==JMI_BLOCK_MIN) {
} else if (evaluation_mode==JMI_BLOCK_MAX) {
} else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
x[0] = _y_2_7;
x[1] = _y_1_6;
} else if (evaluation_mode==JMI_BLOCK_EVALUATE_JACOBIAN) {
residual[0] = ( ( _p_12 ) * ( _A_2_2_3 ) ) * ( 1.0 ) - ( 1.0 );
residual[1] = ( ( _p_12 ) * ( _A_1_2_1 ) ) * ( 1.0 );
residual[2] = ( ( _p_12 ) * ( _A_2_1_2 ) ) * ( 1.0 );
residual[3] = ( ( _p_12 ) * ( _A_1_1_0 ) ) * ( 1.0 ) - ( 1.0 );
} else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
_y_2_7 = x[0];
_y_1_6 = x[1];
(*res)[0] = _y_2_7 - (( ( _p_12 ) * ( _A_2_1_2 ) ) * ( _y_1_6 ) + ( ( _p_12 ) * ( _A_2_2_3 ) ) * ( _y_2_7 ));
(*res)[1] = _y_1_6 - (( ( _p_12 ) * ( _A_1_1_0 ) ) * ( _y_1_6 ) + ( ( _p_12 ) * ( _A_1_2_1 ) ) * ( _y_2_7 ));
} else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
_y_2_7 = x[0];
_y_1_6 = x[1];
}
return 0;
}

static int dae_block_2(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
jmi_real_t** res = &residual;
if (evaluation_mode==JMI_BLOCK_NOMINAL) {
} else if (evaluation_mode==JMI_BLOCK_MIN) {
} else if (evaluation_mode==JMI_BLOCK_MAX) {
} else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
x[0] = _z_2_9;
x[1] = _z_1_8;
} else if (evaluation_mode==JMI_BLOCK_EVALUATE_JACOBIAN) {
residual[0] = ( ( _d_13 + 1 ) * ( _A_2_2_3 ) ) * ( 1.0 ) - ( 1.0 );
residual[1] = ( ( _d_13 + 1 ) * ( _A_1_2_1 ) ) * ( 1.0 );
residual[2] = ( ( _d_13 + 1 ) * ( _A_2_1_2 ) ) * ( 1.0 );
residual[3] = ( ( _d_13 + 1 ) * ( _A_1_1_0 ) ) * ( 1.0 ) - ( 1.0 );
} else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
_z_2_9 = x[0];
_z_1_8 = x[1];
(*res)[0] = _z_2_9 + 2 - (( ( _d_13 + 1 ) * ( _A_2_1_2 ) ) * ( _z_1_8 ) + ( ( _d_13 + 1 ) * ( _A_2_2_3 ) ) * ( _z_2_9 ));
(*res)[1] = _z_1_8 + 2 - (( ( _d_13 + 1 ) * ( _A_1_1_0 ) ) * ( _z_1_8 ) + ( ( _d_13 + 1 ) * ( _A_1_2_1 ) ) * ( _z_2_9 ));
} else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
_z_2_9 = x[0];
_z_1_8 = x[1];
}
return 0;
}

static int dae_block_3(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
jmi_real_t** res = &residual;
if (evaluation_mode==JMI_BLOCK_NOMINAL) {
} else if (evaluation_mode==JMI_BLOCK_MIN) {
} else if (evaluation_mode==JMI_BLOCK_MAX) {
} else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
x[0] = _w_2_11;
x[1] = _w_1_10;
} else if (evaluation_mode==JMI_BLOCK_EVALUATE_JACOBIAN) {
residual[0] = ( ( _x_1_4 + 1 ) * ( _A_2_2_3 ) ) * ( 1.0 ) - ( 1.0 );
residual[1] = ( ( _x_1_4 + 1 ) * ( _A_1_2_1 ) ) * ( 1.0 );
residual[2] = ( ( _x_1_4 + 1 ) * ( _A_2_1_2 ) ) * ( 1.0 );
residual[3] = ( ( _x_1_4 + 1 ) * ( _A_1_1_0 ) ) * ( 1.0 ) - ( 1.0 );
} else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
_w_2_11 = x[0];
_w_1_10 = x[1];
(*res)[0] = _w_2_11 + 3 - (( ( _x_1_4 + 1 ) * ( _A_2_1_2 ) ) * ( _w_1_10 ) + ( ( _x_1_4 + 1 ) * ( _A_2_2_3 ) ) * ( _w_2_11 ));
(*res)[1] = _w_1_10 + 3 - (( ( _x_1_4 + 1 ) * ( _A_1_1_0 ) ) * ( _w_1_10 ) + ( ( _x_1_4 + 1 ) * ( _A_1_2_1 ) ) * ( _w_2_11 ));
} else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
_w_2_11 = x[0];
_w_1_10 = x[1];
}
return 0;
}


static int dae_init_block_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
jmi_real_t** res = &residual;
if (evaluation_mode==JMI_BLOCK_NOMINAL) {
} else if (evaluation_mode==JMI_BLOCK_MIN) {
} else if (evaluation_mode==JMI_BLOCK_MAX) {
} else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
x[0] = _x_2_5;
x[1] = _x_1_4;
} else if (evaluation_mode==JMI_BLOCK_EVALUATE_JACOBIAN) {
residual[0] = ( 4 ) * ( 1.0 );
residual[1] = ( 2 ) * ( 1.0 );
residual[2] = ( 3 ) * ( 1.0 );
residual[3] = ( 1 ) * ( 1.0 );
} else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
_x_2_5 = x[0];
_x_1_4 = x[1];
(*res)[0] = 4 - (( 3 ) * ( _x_1_4 ) + ( 4 ) * ( _x_2_5 ));
(*res)[1] = 3 - (( 1 ) * ( _x_1_4 ) + ( 2 ) * ( _x_2_5 ));
} else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
_x_2_5 = x[0];
_x_1_4 = x[1];
}
return 0;
}

static int dae_init_block_1(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
jmi_real_t** res = &residual;
if (evaluation_mode==JMI_BLOCK_NOMINAL) {
} else if (evaluation_mode==JMI_BLOCK_MIN) {
} else if (evaluation_mode==JMI_BLOCK_MAX) {
} else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
x[0] = _y_2_7;
x[1] = _y_1_6;
} else if (evaluation_mode==JMI_BLOCK_EVALUATE_JACOBIAN) {
residual[0] = ( ( _p_12 ) * ( _A_2_2_3 ) ) * ( 1.0 ) - ( 1.0 );
residual[1] = ( ( _p_12 ) * ( _A_1_2_1 ) ) * ( 1.0 );
residual[2] = ( ( _p_12 ) * ( _A_2_1_2 ) ) * ( 1.0 );
residual[3] = ( ( _p_12 ) * ( _A_1_1_0 ) ) * ( 1.0 ) - ( 1.0 );
} else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
_y_2_7 = x[0];
_y_1_6 = x[1];
(*res)[0] = _y_2_7 - (( ( _p_12 ) * ( _A_2_1_2 ) ) * ( _y_1_6 ) + ( ( _p_12 ) * ( _A_2_2_3 ) ) * ( _y_2_7 ));
(*res)[1] = _y_1_6 - (( ( _p_12 ) * ( _A_1_1_0 ) ) * ( _y_1_6 ) + ( ( _p_12 ) * ( _A_1_2_1 ) ) * ( _y_2_7 ));
} else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
_y_2_7 = x[0];
_y_1_6 = x[1];
}
return 0;
}

static int dae_init_block_2(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
jmi_real_t** res = &residual;
if (evaluation_mode==JMI_BLOCK_NOMINAL) {
} else if (evaluation_mode==JMI_BLOCK_MIN) {
} else if (evaluation_mode==JMI_BLOCK_MAX) {
} else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
x[0] = _z_2_9;
x[1] = _z_1_8;
} else if (evaluation_mode==JMI_BLOCK_EVALUATE_JACOBIAN) {
residual[0] = ( ( _d_13 + 1 ) * ( _A_2_2_3 ) ) * ( 1.0 ) - ( 1.0 );
residual[1] = ( ( _d_13 + 1 ) * ( _A_1_2_1 ) ) * ( 1.0 );
residual[2] = ( ( _d_13 + 1 ) * ( _A_2_1_2 ) ) * ( 1.0 );
residual[3] = ( ( _d_13 + 1 ) * ( _A_1_1_0 ) ) * ( 1.0 ) - ( 1.0 );
} else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
_z_2_9 = x[0];
_z_1_8 = x[1];
(*res)[0] = _z_2_9 + 2 - (( ( _d_13 + 1 ) * ( _A_2_1_2 ) ) * ( _z_1_8 ) + ( ( _d_13 + 1 ) * ( _A_2_2_3 ) ) * ( _z_2_9 ));
(*res)[1] = _z_1_8 + 2 - (( ( _d_13 + 1 ) * ( _A_1_1_0 ) ) * ( _z_1_8 ) + ( ( _d_13 + 1 ) * ( _A_1_2_1 ) ) * ( _z_2_9 ));
} else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
_z_2_9 = x[0];
_z_1_8 = x[1];
}
return 0;
}

static int dae_init_block_3(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
jmi_real_t** res = &residual;
if (evaluation_mode==JMI_BLOCK_NOMINAL) {
} else if (evaluation_mode==JMI_BLOCK_MIN) {
} else if (evaluation_mode==JMI_BLOCK_MAX) {
} else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
x[0] = _w_2_11;
x[1] = _w_1_10;
} else if (evaluation_mode==JMI_BLOCK_EVALUATE_JACOBIAN) {
residual[0] = ( ( _x_1_4 + 1 ) * ( _A_2_2_3 ) ) * ( 1.0 ) - ( 1.0 );
residual[1] = ( ( _x_1_4 + 1 ) * ( _A_1_2_1 ) ) * ( 1.0 );
residual[2] = ( ( _x_1_4 + 1 ) * ( _A_2_1_2 ) ) * ( 1.0 );
residual[3] = ( ( _x_1_4 + 1 ) * ( _A_1_1_0 ) ) * ( 1.0 ) - ( 1.0 );
} else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
_w_2_11 = x[0];
_w_1_10 = x[1];
(*res)[0] = _w_2_11 + 3 - (( ( _x_1_4 + 1 ) * ( _A_2_1_2 ) ) * ( _w_1_10 ) + ( ( _x_1_4 + 1 ) * ( _A_2_2_3 ) ) * ( _w_2_11 ));
(*res)[1] = _w_1_10 + 3 - (( ( _x_1_4 + 1 ) * ( _A_1_1_0 ) ) * ( _w_1_10 ) + ( ( _x_1_4 + 1 ) * ( _A_1_2_1 ) ) * ( _w_2_11 ));
} else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
_w_2_11 = x[0];
_w_1_10 = x[1];
}
return 0;
}

jmi_dae_add_equation_block(*jmi,dae_block_0,NULL,2,0,JMI_CONSTANT_VARIABILITY,JMI_LINEAR_SOLVER,0 );
jmi_dae_add_equation_block(*jmi,dae_block_1,NULL,2,0,JMI_PARAMETER_VARIABILITY,JMI_LINEAR_SOLVER,1 );
jmi_dae_add_equation_block(*jmi,dae_block_2,NULL,2,0,JMI_DISCRETE_VARIABILITY,JMI_LINEAR_SOLVER,2 );
jmi_dae_add_equation_block(*jmi,dae_block_3,NULL,2,0,JMI_CONTINUOUS_VARIABILITY,JMI_LINEAR_SOLVER,3 );

jmi_dae_init_add_equation_block(*jmi,dae_init_block_0,NULL,2,0,JMI_CONSTANT_VARIABILITY,JMI_LINEAR_SOLVER,0 );
jmi_dae_init_add_equation_block(*jmi,dae_init_block_1,NULL,2,0,JMI_PARAMETER_VARIABILITY,JMI_LINEAR_SOLVER,1 );
jmi_dae_init_add_equation_block(*jmi,dae_init_block_2,NULL,2,0,JMI_DISCRETE_VARIABILITY,JMI_LINEAR_SOLVER,2 );
jmi_dae_init_add_equation_block(*jmi,dae_init_block_3,NULL,2,0,JMI_CONTINUOUS_VARIABILITY,JMI_LINEAR_SOLVER,3 );
")})));
end BlockTest7;

model OutputTest1

  output Real x_1(start=0.951858508368);
  output Real x_2(start=2.17691690118);
  output Real x_3(start=1.47982066619);
  output Real x_4(start=2.41568015438);
  output Real x_5(start=2.50288121643);
  output Real w_ode_1_1;
  Real w_ode_1_2;
  Real w_ode_1_3;
  output Real w_ode_2_1;
  Real w_ode_2_2;
  Real w_ode_2_3;
  output Real w_ode_3_1;
  Real w_ode_3_2;
  Real w_ode_3_3;
  output Real w_ode_4_1;
  Real w_ode_4_2;
  Real w_ode_4_3;
  output Real w_ode_5_1;
  Real w_ode_5_2;
  Real w_ode_5_3;
  output Real w_output_1_1;
  output Real w_output_1_2;
  output Real w_output_1_3;
  output Real w_output_2_1;
  output Real w_output_2_2;
  output Real w_output_2_3;
  output Real w_output_3_1;
  output Real w_output_3_2;
  output Real w_output_3_3;
  output Real w_output_4_1;
  output Real w_output_4_2;
  output Real w_output_4_3;
  output Real w_output_5_1;
  output Real w_output_5_2;
  output Real w_output_5_3;
  output Real w_output_6_1;
  output Real w_output_6_2;
  output Real w_output_6_3;
  Real w_other_1_1;
  Real w_other_1_2;
  Real w_other_1_3;
  Real w_other_2_1;
  Real w_other_2_2;
  Real w_other_2_3;
  Real w_other_3_1;
  Real w_other_3_2;
  Real w_other_3_3;
  input Real ur_1;
  input Real ur_2;
  input Real ur_3;
  input Real ur_4;
  output Integer io1 = 1;
  output Boolean bo1 = true;
equation
(w_ode_1_1) + 4*(w_ode_1_2) + (w_ode_1_3) + sin(x_5) - (x_3) - 4*(x_5) + cos(ur_3) + 4*(ur_3) = 0;
cos(w_ode_1_1) + (w_ode_1_2)*sin(w_ode_1_3) + 4*(x_4) - 4*(x_5) - 4*(x_4) + (ur_4) + 4*(ur_1) = 0;
sin(w_ode_1_1) - sin(w_ode_1_2) - sin(w_ode_1_3) + 4*(x_2)*4*(x_3)*4*(x_3) + 4*(ur_3)*4*(ur_1) = 0;

der(x_1) = cos(w_ode_1_1)*(w_ode_1_2)*cos(w_ode_1_3) + 4*(x_2) + 4*(x_1) - (x_5) + 4*(ur_2) + cos(ur_4);

(w_ode_2_1)*sin(w_ode_2_2)*4*(w_ode_2_3) + (x_3) - (x_5) + sin(x_2) + (ur_3)*sin(ur_1) = 0;
4*(w_ode_2_1)*sin(w_ode_2_2) - cos(w_ode_2_3) + cos(x_4)*cos(x_3) - cos(x_3) + 4*(ur_1) - cos(ur_2) = 0;
(w_ode_2_1) - cos(w_ode_2_2) + cos(w_ode_2_3) + sin(x_4)*sin(x_1)*cos(x_4) + cos(ur_1)*sin(ur_1) = 0;

der(x_2) = sin(w_ode_2_1) - sin(w_ode_2_2) - sin(w_ode_2_3) + sin(w_ode_1_1) - sin(w_ode_1_2) - 4*(w_ode_1_3) + sin(x_1) + 4*(x_3) + (x_4) + (ur_2) + sin(ur_3);

4*(w_ode_3_1) - 4*(w_ode_3_2) + sin(w_ode_3_3) + (x_4) + cos(x_5) + 4*(x_3) + sin(ur_4)*cos(ur_1) = 0;
4*(w_ode_3_1) - (w_ode_3_2) + 4*(w_ode_3_3) + sin(x_2) - 4*(x_2) + (x_3) + 4*(ur_4) - 4*(ur_4) = 0;
4*(w_ode_3_1) + cos(w_ode_3_2)*cos(w_ode_3_3) + (x_3) + cos(x_2) + 4*(x_2) + cos(ur_1)*4*(ur_4) = 0;

der(x_3) = 4*(w_ode_3_1) - (w_ode_3_2)*(w_ode_3_3) + sin(w_ode_2_1) - cos(w_ode_2_2) - 4*(w_ode_2_3) + 4*(x_4) - 4*(x_2) - (x_2) + (ur_3)*4*(ur_4);

4*(w_ode_4_1)*(w_ode_4_2) - 4*(w_ode_4_3) + cos(x_1) - sin(x_2)*(x_2) + (ur_1) + 4*(ur_1) = 0;
4*(w_ode_4_1) + cos(w_ode_4_2) + sin(w_ode_4_3) + sin(x_2) + sin(x_4) + cos(x_3) + (ur_3) + sin(ur_2) = 0;
cos(w_ode_4_1)*sin(w_ode_4_2)*cos(w_ode_4_3) + cos(x_3) - cos(x_2) - (x_3) + (ur_3) - sin(ur_3) = 0;

der(x_4) = 4*(w_ode_4_1)*sin(w_ode_4_2)*4*(w_ode_4_3) + sin(w_ode_3_1) - (w_ode_3_2)*cos(w_ode_3_3) + cos(x_5) - (x_4) - (x_4) + (ur_1) + (ur_4);

4*(w_ode_5_1) + (w_ode_5_2)*(w_ode_5_3) + 4*(x_5) - 4*(x_4) + 4*(x_5) + (ur_3)*4*(ur_3) = 0;
(w_ode_5_1) + cos(w_ode_5_2)*(w_ode_5_3) + 4*(x_1) - sin(x_2) - sin(x_4) + cos(ur_2)*sin(ur_1) = 0;
cos(w_ode_5_1) + cos(w_ode_5_2)*cos(w_ode_5_3) + 4*(x_3) + (x_3)*4*(x_4) + cos(ur_3) + sin(ur_2) = 0;

der(x_5) = (w_ode_5_1) - sin(w_ode_5_2) + cos(w_ode_5_3) + 4*(w_ode_4_1) + cos(w_ode_4_2) - 4*(w_ode_4_3) + (x_3) - sin(x_2) + sin(x_2) + (ur_2)*sin(ur_4);

cos(w_output_1_1) - 4*(w_output_1_2)*cos(w_output_1_3) + sin(x_3)*4*(x_4) - (x_5) + cos(ur_1)*4*(ur_3) = 0;
(w_output_1_1) + sin(w_output_1_2) + cos(w_output_1_3) + 4*(x_5) + sin(x_5)*(x_2) + sin(ur_1) - cos(ur_4) = 0;
cos(w_output_1_1) + sin(w_output_1_2) - sin(w_output_1_3) + sin(x_2) - (x_3) + cos(x_5) + 4*(ur_1) + 4*(ur_4) = 0;

sin(w_output_2_1)*4*(w_output_2_2) + cos(w_output_2_3) + 4*(x_4)*cos(x_5) - (x_2) + cos(ur_2)*cos(ur_2) = 0;
(w_output_2_1) - cos(w_output_2_2) + 4*(w_output_2_3) + (x_4) + cos(x_1) - cos(x_5) + sin(ur_3) + (ur_2) = 0;
cos(w_output_2_1)*cos(w_output_2_2)*sin(w_output_2_3) + (x_2) - (x_2)*sin(x_5) + cos(ur_2)*sin(ur_2) = 0;

4*(w_output_3_1) + sin(w_output_3_2) + (w_output_3_3) + (x_4) - cos(x_4)*cos(x_1) + sin(ur_3) + cos(ur_1) = 0;
cos(w_output_3_1) + sin(w_output_3_2)*(w_output_3_3) + sin(x_5) - cos(x_5) - 4*(x_5) + 4*(ur_3) - cos(ur_2) = 0;
cos(w_output_3_1) + 4*(w_output_3_2) - sin(w_output_3_3) + cos(x_3) + cos(x_3) - sin(x_1) + 4*(ur_3) + 4*(ur_4) = 0;

cos(w_output_4_1) + sin(w_output_4_2) + (w_output_4_3) + 4*(x_3)*(x_5)*cos(x_2) + cos(ur_4) - 4*(ur_3) = 0;
4*(w_output_4_1)*sin(w_output_4_2)*sin(w_output_4_3) + (x_1) + sin(x_1)*cos(x_1) + sin(ur_2) - 4*(ur_3) = 0;
sin(w_output_4_1) + 4*(w_output_4_2)*sin(w_output_4_3) + (x_2) + (x_3)*(x_3) + (ur_2) + sin(ur_1) = 0;

(w_output_5_1) + (w_output_5_2) + sin(w_output_5_3) + sin(x_1)*(x_1) - sin(x_3) + (ur_1) + sin(ur_4) = 0;
(w_output_5_1) - sin(w_output_5_2) + (w_output_5_3) + sin(x_4)*sin(x_2) + sin(x_4) + sin(ur_4) + cos(ur_3) = 0;
4*(w_output_5_1) - (w_output_5_2) + (w_output_5_3) + cos(x_1)*(x_1)*sin(x_1) + 4*(ur_4) + sin(ur_4) = 0;

cos(w_output_6_1)*(w_output_6_2) + 4*(w_output_6_3) + cos(x_1)*(x_2)*cos(x_2) + 4*(ur_4) - sin(ur_3) = 0;
(w_output_6_1)*sin(w_output_6_2) + (w_output_6_3) + sin(x_4) - (x_4)*(x_4) + cos(ur_2) + (ur_4) = 0;
4*(w_output_6_1) - 4*(w_output_6_2)*sin(w_output_6_3) + sin(x_5) + sin(x_4)*(x_2) + (ur_3) - (ur_1) = 0;

(w_other_1_1) + cos(w_other_1_2) - (w_other_1_3) + cos(x_2) - 4*(x_5) - 4*(x_2) + (ur_3) + 4*(ur_1) = 0;
(w_other_1_1) + 4*(w_other_1_2) + 4*(w_other_1_3) + 4*(x_1) - cos(x_3)*4*(x_2) + sin(ur_2) + 4*(ur_3) = 0;
cos(w_other_1_1)*(w_other_1_2) - sin(w_other_1_3) + sin(x_4) + cos(x_1)*sin(x_2) + (ur_3) - 4*(ur_3) = 0;

sin(w_other_2_1) - (w_other_2_2) + (w_other_2_3) + 4*(x_5) - 4*(x_4) - sin(x_5) + 4*(ur_4) - 4*(ur_4) = 0;
sin(w_other_2_1)*4*(w_other_2_2) + 4*(w_other_2_3) + sin(x_1) - cos(x_1) + cos(x_4) + sin(ur_2)*cos(ur_2) = 0;
sin(w_other_2_1) + sin(w_other_2_2) - (w_other_2_3) + 4*(x_1)*4*(x_4) - (x_4) + cos(ur_2) - sin(ur_2) = 0;

4*(w_other_3_1) + sin(w_other_3_2)*4*(w_other_3_3) + (x_2) + cos(x_2) - (x_5) + 4*(ur_1) - 4*(ur_1) = 0;
4*(w_other_3_1)*(w_other_3_2) + (w_other_3_3) + cos(x_3) + sin(x_2) + 4*(x_1) + (ur_2) - cos(ur_2) = 0;
cos(w_other_3_1)*4*(w_other_3_2) + (w_other_3_3) + 4*(x_4) - sin(x_4) + (x_3) + 4*(ur_3) - cos(ur_4) = 0;


	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="OutputTest1",
			description="Test of code generation of output value references.",
			generate_ode=true,
			equation_sorting=true,
			template="
$n_outputs$
				   $C_DAE_output_vrefs$
",
         generatedCode=" 
30
static const int Output_vrefs[30] = {5,6,7,8,9,14,17,20,23,26,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,268435513,536870970};         
")})));
end OutputTest1;


model StartValues1
  Real x(start=1);
  parameter Real y = 2;
  parameter Real z(start=3);
  Real q;
  
equation
  der(x) = x;
  q = x + 1;


	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="StartValues1",
			description="",
			template="$C_set_start_values$",
			generatedCode="
_y_1 = (2);
_z_2 = (3);
model_init_eval_parameters(jmi);
_x_0 = (1);
_q_3 = (0.0);
_der_x_4 = (0.0);
jmi->indep_extobjs_initialized = 1;
")})));
end StartValues1;

model StartValues2
  parameter Real pr = 1.5;
  parameter Integer pi = 2;
  parameter Boolean pb = true;
  
  Real r(start=5.5);
  Integer i(start=10); 
  Boolean b(start=false);
  
equation
  der(r) = -r;
  i = r + 2;
  b = false;
  

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="StartValues2",
			description="",
			template="$C_set_start_values$",
			generatedCode="
    _pr_0 = (1.5);
    _pi_1 = (2);
    _pb_2 = (JMI_TRUE);
	model_init_eval_parameters(jmi);
    _r_3 = (5.5);
    _i_4 = (10);
    _b_5 = (JMI_FALSE);
    _der_r_6 = (0.0);
    pre_i_4 = (10);
    pre_b_5 = (JMI_FALSE);
	jmi->indep_extobjs_initialized = 1;
")})));
end StartValues2;

model ExternalArray1
	Real a_in[2]={1,1};
	Real b_out;
	function f
		input Real a[2];
		output Real b;
		external;
	end f;
	equation
		b_out = f(a_in);


	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="ExternalArray1",
			description="External C function (undeclared) with one dim array input, scalar output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_ExternalArray1_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_ExternalArray1_f_exp(jmi_array_t* a_a);

void func_CCodeGenTests_ExternalArray1_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    b_v = f(a_a->var, jmi_array_size(a_a, 0));
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_ExternalArray1_f_exp(jmi_array_t* a_a) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_ExternalArray1_f_def(a_a, &b_v);
    return b_v;
}

")})));
end ExternalArray1;

model ExternalArray2
	Real a_in[2,2]={{1,1},{1,1}};
	Real b_out;
	function f
		input Real a[2,2];
		output Real b;
		external;
	end f;
	equation
		b_out = f(a_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="ExternalArray2",
			description="External C function (undeclared) with two dim array input, scalar output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_ExternalArray2_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_ExternalArray2_f_exp(jmi_array_t* a_a);

void func_CCodeGenTests_ExternalArray2_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    b_v = f(a_a->var, jmi_array_size(a_a, 0), jmi_array_size(a_a, 1));
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_ExternalArray2_f_exp(jmi_array_t* a_a) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_ExternalArray2_f_def(a_a, &b_v);
    return b_v;
}

")})));
end ExternalArray2;

model ExternalArray3
	Real a_in[2,2];
	Real b_out;
	function f
		input Real a[:,:];
		output Real b;
		external;
	end f;
	equation
		a_in = {{1,1},{2,2}};
		b_out = f(a_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="ExternalArray3",
			description="External C function (undeclared) with two dim and unknown no of elements array input, scalar output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_ExternalArray3_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_ExternalArray3_f_exp(jmi_array_t* a_a);

void func_CCodeGenTests_ExternalArray3_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    b_v = f(a_a->var, jmi_array_size(a_a, 0), jmi_array_size(a_a, 1));
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_ExternalArray3_f_exp(jmi_array_t* a_a) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_ExternalArray3_f_def(a_a, &b_v);
    return b_v;
}

")})));
end ExternalArray3;

model ExternalArray4
	Real a_in[2];
	Real b_out[2];
	function f
		input Real a[2];
		output Real b[2];
		external;
	end f;
	equation
		a_in[1] = 1;
		a_in[2] = 2;
		b_out = f(a_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="ExternalArray4",
			description="External C function (undeclared) with one dim array input, one dim array output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_ExternalArray4_f_def(jmi_array_t* a_a, jmi_array_t* b_a);

void func_CCodeGenTests_ExternalArray4_f_def(jmi_array_t* a_a, jmi_array_t* b_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_STATIC(b_an, 2, 1)
    if (b_a == NULL) {
        JMI_ARRAY_STATIC_INIT_1(b_an, 2)
        b_a = b_an;
    }
    f(a_a->var, jmi_array_size(a_a, 0), b_a->var, jmi_array_size(b_a, 0));
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end ExternalArray4;

model ExternalArray5
	Real a_in[2,2];
	Real b_out[2,2];
	function f
		input Real a[2,2];
		output Real b[2,2];
		external;
	end f;
	equation
		a_in = {{1,1},{2,2}};
		b_out = f(a_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="ExternalArray5",
			description="External C function (undeclared) with two dim array input, two dim array output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_ExternalArray5_f_def(jmi_array_t* a_a, jmi_array_t* b_a);

void func_CCodeGenTests_ExternalArray5_f_def(jmi_array_t* a_a, jmi_array_t* b_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_STATIC(b_an, 4, 2)
    if (b_a == NULL) {
        JMI_ARRAY_STATIC_INIT_2(b_an, 2, 2)
        b_a = b_an;
    }
    f(a_a->var, jmi_array_size(a_a, 0), jmi_array_size(a_a, 1), b_a->var, jmi_array_size(b_a, 0), jmi_array_size(b_a, 1));
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end ExternalArray5;

model ExternalArray6
	Real a_in[2,2];
	Real b_out[2,2];
	function f
		input Real a[:,:];
		output Real b[size(a,1),size(a,2)];
		external;
	end f;
	equation
		a_in = {{1,1},{2,2}};
		b_out = f(a_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="ExternalArray6",
			description="External C function (undeclared) with two dim and unknown no of elements array input, two dim array output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_ExternalArray6_f_def(jmi_array_t* a_a, jmi_array_t* b_a);

void func_CCodeGenTests_ExternalArray6_f_def(jmi_array_t* a_a, jmi_array_t* b_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_DYNAMIC(b_an, 2)
    if (b_a == NULL) {
        JMI_ARRAY_DYNAMIC_INIT_2(b_an, ( jmi_array_size(a_a, 0) ) * ( jmi_array_size(a_a, 1) ), jmi_array_size(a_a, 0), jmi_array_size(a_a, 1))
        b_a = b_an;
    }
    f(a_a->var, jmi_array_size(a_a, 0), jmi_array_size(a_a, 1), b_a->var, jmi_array_size(b_a, 0), jmi_array_size(b_a, 1));
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end ExternalArray6;

model IntegerExternalArray1
	Integer a_in[2]={1,1};
	Real b_out;
	function f
		input Integer a[2];
		output Real b;
		external;
	end f;
	equation
		b_out = f(a_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="IntegerExternalArray1",
			description="External C function (undeclared) with one dim Integer array input, scalar Real output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_IntegerExternalArray1_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_IntegerExternalArray1_f_exp(jmi_array_t* a_a);

void func_CCodeGenTests_IntegerExternalArray1_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    JMI_INT_ARRAY_STATIC(tmp_1, 2, 1)
    JMI_ARRAY_STATIC_INIT_1(tmp_1, 2)
    jmi_copy_matrix_to_int(a_a, a_a->var, tmp_1->var);
    b_v = f(tmp_1->var, jmi_array_size(a_a, 0));
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_IntegerExternalArray1_f_exp(jmi_array_t* a_a) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_IntegerExternalArray1_f_def(a_a, &b_v);
    return b_v;
}

")})));
end IntegerExternalArray1;

model IntegerExternalArray2
	Integer a_in[2,2]={{1,1},{1,1}};
	Real b_out;
	function f
		input Integer a[2,2];
		output Real b;
		external;
	end f;
	equation
		b_out = f(a_in);	

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="IntegerExternalArray2",
			description="External C function (undeclared) with two dim Integer array input, scalar Real output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_IntegerExternalArray2_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_IntegerExternalArray2_f_exp(jmi_array_t* a_a);

void func_CCodeGenTests_IntegerExternalArray2_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    JMI_INT_ARRAY_STATIC(tmp_1, 4, 2)
    JMI_ARRAY_STATIC_INIT_2(tmp_1, 2, 2)
    jmi_copy_matrix_to_int(a_a, a_a->var, tmp_1->var);
    b_v = f(tmp_1->var, jmi_array_size(a_a, 0), jmi_array_size(a_a, 1));
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_IntegerExternalArray2_f_exp(jmi_array_t* a_a) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_IntegerExternalArray2_f_def(a_a, &b_v);
    return b_v;
}

")})));
end IntegerExternalArray2;

model IntegerExternalArray3
	Real a_in = 1;
	Integer b_out[2];
	function f
		input Real a;
		output Integer b[2];
		external;
	end f;
	equation
		b_out = f(a_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="IntegerExternalArray3",
			description="External C function (undeclared) with one scalar Real input, one dim array Integer output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_IntegerExternalArray3_f_def(jmi_ad_var_t a_v, jmi_array_t* b_a);

void func_CCodeGenTests_IntegerExternalArray3_f_def(jmi_ad_var_t a_v, jmi_array_t* b_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_STATIC(b_an, 2, 1)
    JMI_INT_ARRAY_STATIC(tmp_1, 2, 1)
    if (b_a == NULL) {
        JMI_ARRAY_STATIC_INIT_1(b_an, 2)
        b_a = b_an;
    }
    JMI_ARRAY_STATIC_INIT_1(tmp_1, 2)
    jmi_copy_matrix_to_int(b_a, b_a->var, tmp_1->var);
    f(a_v, tmp_1->var, jmi_array_size(b_a, 0));
    jmi_copy_matrix_from_int(b_a, tmp_1->var, b_a->var);
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end IntegerExternalArray3;

model IntegerExternalArray4
	Integer a_in[2,2];
	Integer b_out[2,2];
	function f
		input Integer a[2,2];
		output Integer b[2,2];
		external;
	end f;
	equation
		a_in = {{1,1},{2,2}};
		b_out = f(a_in);	

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="IntegerExternalArray4",
			description="External C function (undeclared) with one 2-dim Integer array input, one 2-dim Integer array output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_IntegerExternalArray4_f_def(jmi_array_t* a_a, jmi_array_t* b_a);

void func_CCodeGenTests_IntegerExternalArray4_f_def(jmi_array_t* a_a, jmi_array_t* b_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_STATIC(b_an, 4, 2)
    JMI_INT_ARRAY_STATIC(tmp_1, 4, 2)
    JMI_INT_ARRAY_STATIC(tmp_2, 4, 2)
    if (b_a == NULL) {
        JMI_ARRAY_STATIC_INIT_2(b_an, 2, 2)
        b_a = b_an;
    }
    JMI_ARRAY_STATIC_INIT_2(tmp_1, 2, 2)
    jmi_copy_matrix_to_int(a_a, a_a->var, tmp_1->var);
    JMI_ARRAY_STATIC_INIT_2(tmp_2, 2, 2)
    jmi_copy_matrix_to_int(b_a, b_a->var, tmp_2->var);
    f(tmp_1->var, jmi_array_size(a_a, 0), jmi_array_size(a_a, 1), tmp_2->var, jmi_array_size(b_a, 0), jmi_array_size(b_a, 1));
    jmi_copy_matrix_from_int(b_a, tmp_2->var, b_a->var);
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end IntegerExternalArray4;

model SimpleExternalFortran1

	Real a_in=1;
	Real b_out;
	
	function f
		input Real a;
		output Real b;
		external "FORTRAN 77";
	end f;
	
	equation
		b_out = f(a_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternalFortran1",
			description="",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternalFortran1_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_SimpleExternalFortran1_f_exp(jmi_ad_var_t a_v);

void func_CCodeGenTests_SimpleExternalFortran1_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    extern jmi_ad_var_t f_(jmi_ad_var_t*);
    b_v = f_(&a_v);
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_SimpleExternalFortran1_f_exp(jmi_ad_var_t a_v) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_SimpleExternalFortran1_f_def(a_v, &b_v);
    return b_v;
}

")})));
end SimpleExternalFortran1;

model SimpleExternalFortran2
	Real a_in=1;
	Real b_in=2;
	Real c_out;
	function f
		input Real a;
		input Real b;
		output Real c;
		external "FORTRAN 77";
	end f;
	equation
		c_out = f(a_in, b_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternalFortran2",
			description="",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternalFortran2_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o);
jmi_ad_var_t func_CCodeGenTests_SimpleExternalFortran2_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v);

void func_CCodeGenTests_SimpleExternalFortran2_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t c_v;
    extern jmi_ad_var_t f_(jmi_ad_var_t*, jmi_ad_var_t*);
    c_v = f_(&a_v, &b_v);
    if (c_o != NULL) *c_o = c_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_SimpleExternalFortran2_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v) {
    jmi_ad_var_t c_v;
    func_CCodeGenTests_SimpleExternalFortran2_f_def(a_v, b_v, &c_v);
    return c_v;
}

")})));
end SimpleExternalFortran2;

model SimpleExternalFortran3
	Real a_in=1;
	Real b_out;
	function f
		input Real a;
		output Real b;
		external "FORTRAN 77" b = my_f(a);
	end f;
	equation
		b_out = f(a_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternalFortran3",
			description="",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternalFortran3_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_SimpleExternalFortran3_f_exp(jmi_ad_var_t a_v);

void func_CCodeGenTests_SimpleExternalFortran3_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    extern jmi_ad_var_t my_f_(jmi_ad_var_t*);
    b_v = my_f_(&a_v);
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_SimpleExternalFortran3_f_exp(jmi_ad_var_t a_v) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_SimpleExternalFortran3_f_def(a_v, &b_v);
    return b_v;
}

")})));
end SimpleExternalFortran3;

model SimpleExternalFortran4
	Real a_in=1;
	Real b_out;
	function f
		input Real a;
		output Real b;
		external "FORTRAN 77" my_f(a, b);
	end f;
	equation
		b_out = f(a_in);	

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternalFortran4",
			description="",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternalFortran4_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_SimpleExternalFortran4_f_exp(jmi_ad_var_t a_v);

void func_CCodeGenTests_SimpleExternalFortran4_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    extern void my_f_(jmi_ad_var_t*, jmi_ad_var_t*);
    my_f_(&a_v, &b_v);
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_SimpleExternalFortran4_f_exp(jmi_ad_var_t a_v) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_SimpleExternalFortran4_f_def(a_v, &b_v);
    return b_v;
}

")})));
end SimpleExternalFortran4;

model SimpleExternalFortran5
	Real a_in=1;
	function f
		input Real a;
		external "FORTRAN 77";
	end f;
	equation
		f(a_in);
		

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternalFortran5",
			description="",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternalFortran5_f_def(jmi_ad_var_t a_v);

void func_CCodeGenTests_SimpleExternalFortran5_f_def(jmi_ad_var_t a_v) {
    JMI_DYNAMIC_INIT()
    extern void f_(jmi_ad_var_t*);
    f_(&a_v);
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end SimpleExternalFortran5;

model SimpleExternalFortran6
	Real a_in=1;
	function f
		input Real a;
		external "FORTRAN 77" my_f(a);
	end f;
	equation
		f(a_in);
		

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternalFortran6",
			description="",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternalFortran6_f_def(jmi_ad_var_t a_v);

void func_CCodeGenTests_SimpleExternalFortran6_f_def(jmi_ad_var_t a_v) {
    JMI_DYNAMIC_INIT()
    extern void my_f_(jmi_ad_var_t*);
    my_f_(&a_v);
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end SimpleExternalFortran6;

model SimpleExternalFortran7
	Real a_in = 1;
	Real b_in = 2;
	Real c_out;
	function f
		input Real a;
		input Real b;
		output Real c;
		external "FORTRAN 77" my_f(a,c,b);
	end f;
	equation
		c_out = f(a_in, b_in);
		

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternalFortran7",
			description="",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternalFortran7_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o);
jmi_ad_var_t func_CCodeGenTests_SimpleExternalFortran7_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v);

void func_CCodeGenTests_SimpleExternalFortran7_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t c_v;
    extern void my_f_(jmi_ad_var_t*, jmi_ad_var_t*, jmi_ad_var_t*);
    my_f_(&a_v, &c_v, &b_v);
    if (c_o != NULL) *c_o = c_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_SimpleExternalFortran7_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v) {
    jmi_ad_var_t c_v;
    func_CCodeGenTests_SimpleExternalFortran7_f_def(a_v, b_v, &c_v);
    return c_v;
}

")})));
end SimpleExternalFortran7;

model SimpleExternalFortran8
	Real a_in = 1;
	Real b_in = 2;
	Real c_out;
	Real d_out;
	function f
		input Real a;
		input Real b;
		output Real c;
		output Real d;
		external "FORTRAN 77" my_f(a,c,b,d);
	end f;
	equation
		(c_out, d_out) = f(a_in, b_in);
		

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternalFortran8",
			description="",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternalFortran8_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o, jmi_ad_var_t* d_o);
jmi_ad_var_t func_CCodeGenTests_SimpleExternalFortran8_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v);

void func_CCodeGenTests_SimpleExternalFortran8_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o, jmi_ad_var_t* d_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t c_v;
    jmi_ad_var_t d_v;
    extern void my_f_(jmi_ad_var_t*, jmi_ad_var_t*, jmi_ad_var_t*, jmi_ad_var_t*);
    my_f_(&a_v, &c_v, &b_v, &d_v);
    if (c_o != NULL) *c_o = c_v;
    if (d_o != NULL) *d_o = d_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_SimpleExternalFortran8_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v) {
    jmi_ad_var_t c_v;
    func_CCodeGenTests_SimpleExternalFortran8_f_def(a_v, b_v, &c_v, NULL);
    return c_v;
}

")})));
end SimpleExternalFortran8;

model SimpleExternalFortran9
	Real a_in = 1;
	Real b_in = 2;
	Real c_out;
	Real d_out;
	function f
		input Real a;
		input Real b;
		output Real c;
		output Real d;
		external "FORTRAN 77" d = my_f(a,b,c);
	end f;
	equation
		(c_out, d_out) = f(a_in, b_in);
		

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternalFortran9",
			description="",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternalFortran9_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o, jmi_ad_var_t* d_o);
jmi_ad_var_t func_CCodeGenTests_SimpleExternalFortran9_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v);

void func_CCodeGenTests_SimpleExternalFortran9_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o, jmi_ad_var_t* d_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t c_v;
    jmi_ad_var_t d_v;
    extern jmi_ad_var_t my_f_(jmi_ad_var_t*, jmi_ad_var_t*, jmi_ad_var_t*);
    d_v = my_f_(&a_v, &b_v, &c_v);
    if (c_o != NULL) *c_o = c_v;
    if (d_o != NULL) *d_o = d_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_SimpleExternalFortran9_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v) {
    jmi_ad_var_t c_v;
    func_CCodeGenTests_SimpleExternalFortran9_f_def(a_v, b_v, &c_v, NULL);
    return c_v;
}

")})));
end SimpleExternalFortran9;

model SimpleExternalFortran10
	Real a_in = 1;
	Real b_in = 2;
	Real c_out;
	Real d_out;
	Real e_out;
	function f
		input Real a;
		input Real b;
		output Real c;
		output Real d;
		output Real e;
		external "FORTRAN 77" d = my_f(a,c,b,e);
	end f;
	equation
		(c_out, d_out, e_out) = f(a_in, b_in);
		

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="SimpleExternalFortran10",
			description="",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_SimpleExternalFortran10_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o, jmi_ad_var_t* d_o, jmi_ad_var_t* e_o);
jmi_ad_var_t func_CCodeGenTests_SimpleExternalFortran10_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v);

void func_CCodeGenTests_SimpleExternalFortran10_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o, jmi_ad_var_t* d_o, jmi_ad_var_t* e_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t c_v;
    jmi_ad_var_t d_v;
    jmi_ad_var_t e_v;
    extern jmi_ad_var_t my_f_(jmi_ad_var_t*, jmi_ad_var_t*, jmi_ad_var_t*, jmi_ad_var_t*);
    d_v = my_f_(&a_v, &c_v, &b_v, &e_v);
    if (c_o != NULL) *c_o = c_v;
    if (d_o != NULL) *d_o = d_v;
    if (e_o != NULL) *e_o = e_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_SimpleExternalFortran10_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v) {
    jmi_ad_var_t c_v;
    func_CCodeGenTests_SimpleExternalFortran10_f_def(a_v, b_v, &c_v, NULL, NULL);
    return c_v;
}

")})));
end SimpleExternalFortran10;

model IntegerExternalFortran1
	Integer a_in=1;
	Real b_out;
	function f
		input Integer a;
		output Real b;
		external "FORTRAN 77";
	end f;
	equation
		b_out = f(a_in);		

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="IntegerExternalFortran1",
			description="External Fortran function, one scalar Integer input, one scalar Real output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_IntegerExternalFortran1_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_IntegerExternalFortran1_f_exp(jmi_ad_var_t a_v);

void func_CCodeGenTests_IntegerExternalFortran1_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    jmi_int_t tmp_1;
    extern jmi_ad_var_t f_(jmi_int_t*);
    tmp_1 = (int)a_v;
    b_v = f_(&tmp_1);
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_IntegerExternalFortran1_f_exp(jmi_ad_var_t a_v) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_IntegerExternalFortran1_f_def(a_v, &b_v);
    return b_v;
}

")})));
end IntegerExternalFortran1;

model IntegerExternalFortran2
	Real a_in=1;
	Integer b_out;
	function f
		input Real a;
		output Integer b;
		external "FORTRAN 77";
	end f;
	equation
		b_out = f(a_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="IntegerExternalFortran2",
			description="",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_IntegerExternalFortran2_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_IntegerExternalFortran2_f_exp(jmi_ad_var_t a_v);

void func_CCodeGenTests_IntegerExternalFortran2_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    extern jmi_ad_var_t f_(jmi_ad_var_t*);
    b_v = f_(&a_v);
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_IntegerExternalFortran2_f_exp(jmi_ad_var_t a_v) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_IntegerExternalFortran2_f_def(a_v, &b_v);
    return b_v;
}

")})));
end IntegerExternalFortran2;

model IntegerExternalFortran3
	Real a_in=1;
	Integer b_out;
	function f
		input Real a;
		output Integer b;
		external "FORTRAN 77" my_f(a, b);
	end f;
	equation
		b_out = f(a_in);	

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="IntegerExternalFortran3",
			description="External Fortran function (declared), one scalar Real input, one scalar Integer output in func stmt.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_IntegerExternalFortran3_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_IntegerExternalFortran3_f_exp(jmi_ad_var_t a_v);

void func_CCodeGenTests_IntegerExternalFortran3_f_def(jmi_ad_var_t a_v, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    jmi_int_t tmp_1;
    extern void my_f_(jmi_ad_var_t*, jmi_int_t*);
    tmp_1 = (int)b_v;
    my_f_(&a_v, &tmp_1);
    b_v = tmp_1;
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_IntegerExternalFortran3_f_exp(jmi_ad_var_t a_v) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_IntegerExternalFortran3_f_def(a_v, &b_v);
    return b_v;
}

")})));
end IntegerExternalFortran3;

model IntegerExternalFortran4
	Integer a_in = 1;
	Integer b_in = 2;
	Integer c_out;
	Integer d_out;
	function f
		input Integer a;
		input Integer b;
		output Integer c;
		output Integer d;
		external "FORTRAN 77" d = my_f(a,b,c);
	end f;
	equation
		(c_out, d_out) = f(a_in, b_in);		

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="IntegerExternalFortran4",
			description="External Fortran function (declared), two scalar Integer inputs, two scalar Integer outputs (one in return, one in func stmt.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_IntegerExternalFortran4_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o, jmi_ad_var_t* d_o);
jmi_ad_var_t func_CCodeGenTests_IntegerExternalFortran4_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v);

void func_CCodeGenTests_IntegerExternalFortran4_f_def(jmi_ad_var_t a_v, jmi_ad_var_t b_v, jmi_ad_var_t* c_o, jmi_ad_var_t* d_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t c_v;
    jmi_ad_var_t d_v;
    jmi_int_t tmp_1;
    jmi_int_t tmp_2;
    jmi_int_t tmp_3;
    extern jmi_ad_var_t my_f_(jmi_int_t*, jmi_int_t*, jmi_int_t*);
    tmp_1 = (int)a_v;
    tmp_2 = (int)b_v;
    tmp_3 = (int)c_v;
    d_v = my_f_(&tmp_1, &tmp_2, &tmp_3);
    c_v = tmp_3;
    if (c_o != NULL) *c_o = c_v;
    if (d_o != NULL) *d_o = d_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_IntegerExternalFortran4_f_exp(jmi_ad_var_t a_v, jmi_ad_var_t b_v) {
    jmi_ad_var_t c_v;
    func_CCodeGenTests_IntegerExternalFortran4_f_def(a_v, b_v, &c_v, NULL);
    return c_v;
}

")})));
end IntegerExternalFortran4;

model ExternalArrayFortran1
	Real a_in[2]={1,1};
	Real b_out;
	function f
		input Real a[2];
		output Real b;
		external "FORTRAN 77";
	end f;
	equation
		b_out = f(a_in);


	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="ExternalArrayFortran1",
			description="External Fortan function with one dim array input, scalar output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_ExternalArrayFortran1_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_ExternalArrayFortran1_f_exp(jmi_array_t* a_a);

void func_CCodeGenTests_ExternalArrayFortran1_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    extern jmi_ad_var_t f_(jmi_ad_var_t*, jmi_int_t*);
    b_v = f_(a_a->var, &jmi_array_size(a_a, 0));
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_ExternalArrayFortran1_f_exp(jmi_array_t* a_a) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_ExternalArrayFortran1_f_def(a_a, &b_v);
    return b_v;
}

")})));
end ExternalArrayFortran1;

model ExternalArrayFortran2
	Real a_in[2,2]={{1,1},{1,1}};
	Real b_out;
	function f
		input Real a[2,2];
		output Real b;
		external "FORTRAN 77";
	end f;
	equation
		b_out = f(a_in);
		

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="ExternalArrayFortran2",
			description="External Fortan function with two dim array input, scalar output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_ExternalArrayFortran2_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_ExternalArrayFortran2_f_exp(jmi_array_t* a_a);

void func_CCodeGenTests_ExternalArrayFortran2_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    JMI_ARRAY_STATIC(tmp_1, 4, 2)
    extern jmi_ad_var_t f_(jmi_ad_var_t*, jmi_int_t*, jmi_int_t*);
    JMI_ARRAY_STATIC_INIT_2(tmp_1, 2, 2)
    jmi_matrix_to_fortran_real(a_a, a_a->var, tmp_1->var);
    b_v = f_(tmp_1->var, &jmi_array_size(a_a, 0), &jmi_array_size(a_a, 1));
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_ExternalArrayFortran2_f_exp(jmi_array_t* a_a) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_ExternalArrayFortran2_f_def(a_a, &b_v);
    return b_v;
}

")})));
end ExternalArrayFortran2;

model ExternalArrayFortran3
	Real a_in[2,2];
	Real b_out;
	function f
		input Real a[:,:];
		output Real b;
		external "FORTRAN 77";
	end f;
	equation
		a_in = {{1,1},{2,2}};
		b_out = f(a_in);
		

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="ExternalArrayFortran3",
			description="External Fortran function with two dim and unknown no of elements array input, scalar output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_ExternalArrayFortran3_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_ExternalArrayFortran3_f_exp(jmi_array_t* a_a);

void func_CCodeGenTests_ExternalArrayFortran3_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    JMI_ARRAY_DYNAMIC(tmp_1, 2)
    extern jmi_ad_var_t f_(jmi_ad_var_t*, jmi_int_t*, jmi_int_t*);
    JMI_ARRAY_DYNAMIC_INIT_2(tmp_1, ( jmi_array_size(a_a, 0) ) * ( jmi_array_size(a_a, 1) ), jmi_array_size(a_a, 0), jmi_array_size(a_a, 1))
    jmi_matrix_to_fortran_real(a_a, a_a->var, tmp_1->var);
    b_v = f_(tmp_1->var, &jmi_array_size(a_a, 0), &jmi_array_size(a_a, 1));
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_ExternalArrayFortran3_f_exp(jmi_array_t* a_a) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_ExternalArrayFortran3_f_def(a_a, &b_v);
    return b_v;
}

")})));
end ExternalArrayFortran3;

model ExternalArrayFortran4
	Real a_in[2];
	Real b_out[2];
	function f
		input Real a[2];
		output Real b[2];
		external "FORTRAN 77";
	end f;
	equation
		a_in[1] = 1;
		a_in[2] = 2;
		b_out = f(a_in);
		

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="ExternalArrayFortran4",
			description="External Fortran function with one dim array input, one dim array output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_ExternalArrayFortran4_f_def(jmi_array_t* a_a, jmi_array_t* b_a);

void func_CCodeGenTests_ExternalArrayFortran4_f_def(jmi_array_t* a_a, jmi_array_t* b_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_STATIC(b_an, 2, 1)
    extern void f_(jmi_ad_var_t*, jmi_int_t*, jmi_ad_var_t*, jmi_int_t*);
    if (b_a == NULL) {
        JMI_ARRAY_STATIC_INIT_1(b_an, 2)
        b_a = b_an;
    }
    f_(a_a->var, &jmi_array_size(a_a, 0), b_a->var, &jmi_array_size(b_a, 0));
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end ExternalArrayFortran4;

model ExternalArrayFortran5
	Real a_in[2,2];
	Real b_out[2,2];
	function f
		input Real a[2,2];
		output Real b[2,2];
		external "FORTRAN 77";
	end f;
	equation
		a_in = {{1,1},{2,2}};
		b_out = f(a_in);
		

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="ExternalArrayFortran5",
			description="External Fortran function with two dim array input, two dim array output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_ExternalArrayFortran5_f_def(jmi_array_t* a_a, jmi_array_t* b_a);

void func_CCodeGenTests_ExternalArrayFortran5_f_def(jmi_array_t* a_a, jmi_array_t* b_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_STATIC(b_an, 4, 2)
    JMI_ARRAY_STATIC(tmp_1, 4, 2)
    JMI_ARRAY_STATIC(tmp_2, 4, 2)
    extern void f_(jmi_ad_var_t*, jmi_int_t*, jmi_int_t*, jmi_ad_var_t*, jmi_int_t*, jmi_int_t*);
    if (b_a == NULL) {
        JMI_ARRAY_STATIC_INIT_2(b_an, 2, 2)
        b_a = b_an;
    }
    JMI_ARRAY_STATIC_INIT_2(tmp_1, 2, 2)
    jmi_matrix_to_fortran_real(a_a, a_a->var, tmp_1->var);
    JMI_ARRAY_STATIC_INIT_2(tmp_2, 2, 2)
    jmi_matrix_to_fortran_real(b_a, b_a->var, tmp_2->var);
    f_(tmp_1->var, &jmi_array_size(a_a, 0), &jmi_array_size(a_a, 1), tmp_2->var, &jmi_array_size(b_a, 0), &jmi_array_size(b_a, 1));
    jmi_matrix_from_fortran_real(b_a, tmp_2->var, b_a->var);
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end ExternalArrayFortran5;

model ExternalArrayFortran6
	Real a_in[2,2];
	Real b_out[2,2];
	function f
		input Real a[:,:];
		output Real b[size(a,1),size(a,2)];
		external "FORTRAN 77";
	end f;
	equation
		a_in = {{1,1},{2,2}};
		b_out = f(a_in);
		

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="ExternalArrayFortran6",
			description="External Fortran function with two dim and unknown no of elements array input, two dim array output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_ExternalArrayFortran6_f_def(jmi_array_t* a_a, jmi_array_t* b_a);

void func_CCodeGenTests_ExternalArrayFortran6_f_def(jmi_array_t* a_a, jmi_array_t* b_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_DYNAMIC(b_an, 2)
    JMI_ARRAY_DYNAMIC(tmp_1, 2)
    JMI_ARRAY_DYNAMIC(tmp_2, 2)
    extern void f_(jmi_ad_var_t*, jmi_int_t*, jmi_int_t*, jmi_ad_var_t*, jmi_int_t*, jmi_int_t*);
    if (b_a == NULL) {
        JMI_ARRAY_DYNAMIC_INIT_2(b_an, ( jmi_array_size(a_a, 0) ) * ( jmi_array_size(a_a, 1) ), jmi_array_size(a_a, 0), jmi_array_size(a_a, 1))
        b_a = b_an;
    }
    JMI_ARRAY_DYNAMIC_INIT_2(tmp_1, ( jmi_array_size(a_a, 0) ) * ( jmi_array_size(a_a, 1) ), jmi_array_size(a_a, 0), jmi_array_size(a_a, 1))
    jmi_matrix_to_fortran_real(a_a, a_a->var, tmp_1->var);
    JMI_ARRAY_DYNAMIC_INIT_2(tmp_2, ( jmi_array_size(a_a, 0) ) * ( jmi_array_size(a_a, 1) ), jmi_array_size(a_a, 0), jmi_array_size(a_a, 1))
    jmi_matrix_to_fortran_real(b_a, b_a->var, tmp_2->var);
    f_(tmp_1->var, &jmi_array_size(a_a, 0), &jmi_array_size(a_a, 1), tmp_2->var, &jmi_array_size(b_a, 0), &jmi_array_size(b_a, 1));
    jmi_matrix_from_fortran_real(b_a, tmp_2->var, b_a->var);
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end ExternalArrayFortran6;

model IntegerExternalArrayFortran1
	Integer a_in[2]={1,1};
	Real b_out;
	function f
		input Integer a[2];
		output Real b;
		external "FORTRAN 77";
	end f;
	equation
		b_out = f(a_in);	

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="IntegerExternalArrayFortran1",
			description="External Fortran function (undeclared) with one dim Integer array input, scalar Real output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_IntegerExternalArrayFortran1_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_IntegerExternalArrayFortran1_f_exp(jmi_array_t* a_a);

void func_CCodeGenTests_IntegerExternalArrayFortran1_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    JMI_INT_ARRAY_STATIC(tmp_1, 2, 1)
    extern jmi_ad_var_t f_(jmi_int_t*, jmi_int_t*);
    JMI_ARRAY_STATIC_INIT_1(tmp_1, 2)
    jmi_matrix_to_fortran_int(a_a, a_a->var, tmp_1->var);
    b_v = f_(tmp_1->var, &jmi_array_size(a_a, 0));
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_IntegerExternalArrayFortran1_f_exp(jmi_array_t* a_a) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_IntegerExternalArrayFortran1_f_def(a_a, &b_v);
    return b_v;
}

")})));
end IntegerExternalArrayFortran1;

model IntegerExternalArrayFortran2
	Integer a_in[2,2]={{1,1},{1,1}};
	Real b_out;
	function f
		input Integer a[2,2];
		output Real b;
		external "FORTRAN 77";
	end f;
	equation
		b_out = f(a_in);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="IntegerExternalArrayFortran2",
			description="External Fortran function (undeclared) with two dim Integer array input, scalar Real output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_IntegerExternalArrayFortran2_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o);
jmi_ad_var_t func_CCodeGenTests_IntegerExternalArrayFortran2_f_exp(jmi_array_t* a_a);

void func_CCodeGenTests_IntegerExternalArrayFortran2_f_def(jmi_array_t* a_a, jmi_ad_var_t* b_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t b_v;
    JMI_INT_ARRAY_STATIC(tmp_1, 4, 2)
    extern jmi_ad_var_t f_(jmi_int_t*, jmi_int_t*, jmi_int_t*);
    JMI_ARRAY_STATIC_INIT_2(tmp_1, 2, 2)
    jmi_matrix_to_fortran_int(a_a, a_a->var, tmp_1->var);
    b_v = f_(tmp_1->var, &jmi_array_size(a_a, 0), &jmi_array_size(a_a, 1));
    if (b_o != NULL) *b_o = b_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_IntegerExternalArrayFortran2_f_exp(jmi_array_t* a_a) {
    jmi_ad_var_t b_v;
    func_CCodeGenTests_IntegerExternalArrayFortran2_f_def(a_a, &b_v);
    return b_v;
}

")})));
end IntegerExternalArrayFortran2;

model IntegerExternalArrayFortran3
	Real a_in = 1;
	Integer b_out[2];
	function f
		input Real a;
		output Integer b[2];
		external "FORTRAN 77";
	end f;
	equation
		b_out = f(a_in);	

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="IntegerExternalArrayFortran3",
			description="External Fortran function (undeclared) with one scalar Real input, one dim array Integer output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_IntegerExternalArrayFortran3_f_def(jmi_ad_var_t a_v, jmi_array_t* b_a);

void func_CCodeGenTests_IntegerExternalArrayFortran3_f_def(jmi_ad_var_t a_v, jmi_array_t* b_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_STATIC(b_an, 2, 1)
    JMI_INT_ARRAY_STATIC(tmp_1, 2, 1)
    extern void f_(jmi_ad_var_t*, jmi_int_t*, jmi_int_t*);
    if (b_a == NULL) {
        JMI_ARRAY_STATIC_INIT_1(b_an, 2)
        b_a = b_an;
    }
    JMI_ARRAY_STATIC_INIT_1(tmp_1, 2)
    jmi_matrix_to_fortran_int(b_a, b_a->var, tmp_1->var);
    f_(&a_v, tmp_1->var, &jmi_array_size(b_a, 0));
    jmi_matrix_from_fortran_int(b_a, tmp_1->var, b_a->var);
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end IntegerExternalArrayFortran3;

model IntegerExternalArrayFortran4
	Integer a_in[2,2];
	Integer b_out[2,2];
	function f
		input Integer a[2,2];
		output Integer b[2,2];
		external "FORTRAN 77";
	end f;
	equation
		a_in = {{1,1},{2,2}};
		b_out = f(a_in);		

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="IntegerExternalArrayFortran4",
			description="External Fortran function (undeclared) with one 2-dim Integer array input, one 2-dim Integer array output.",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_CCodeGenTests_IntegerExternalArrayFortran4_f_def(jmi_array_t* a_a, jmi_array_t* b_a);

void func_CCodeGenTests_IntegerExternalArrayFortran4_f_def(jmi_array_t* a_a, jmi_array_t* b_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_STATIC(b_an, 4, 2)
    JMI_INT_ARRAY_STATIC(tmp_1, 4, 2)
    JMI_INT_ARRAY_STATIC(tmp_2, 4, 2)
    extern void f_(jmi_int_t*, jmi_int_t*, jmi_int_t*, jmi_int_t*, jmi_int_t*, jmi_int_t*);
    if (b_a == NULL) {
        JMI_ARRAY_STATIC_INIT_2(b_an, 2, 2)
        b_a = b_an;
    }
    JMI_ARRAY_STATIC_INIT_2(tmp_1, 2, 2)
    jmi_matrix_to_fortran_int(a_a, a_a->var, tmp_1->var);
    JMI_ARRAY_STATIC_INIT_2(tmp_2, 2, 2)
    jmi_matrix_to_fortran_int(b_a, b_a->var, tmp_2->var);
    f_(tmp_1->var, &jmi_array_size(a_a, 0), &jmi_array_size(a_a, 1), tmp_2->var, &jmi_array_size(b_a, 0), &jmi_array_size(b_a, 1));
    jmi_matrix_from_fortran_int(b_a, tmp_2->var, b_a->var);
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end IntegerExternalArrayFortran4;

model Smooth1
  Real y = time - 2;
  Real x = smooth(2, if y < 0 then 0 else y ^ 3);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="Smooth1",
			description="",
			template="$C_DAE_equation_residuals$",
			generatedCode="
    (*res)[0] = _time - ( 2 ) - (_y_0);
    (*res)[1] = COND_EXP_EQ(_sw(0),JMI_TRUE,AD_WRAP_LITERAL(0),(1.0 * (_y_0) * (_y_0) * (_y_0))) - (_x_1);
")})));
end Smooth1;

model TearingTest1
	
  Real u0,u1,u2,u3,uL;
  Real i0,i1,i2,i3,iL;
  parameter Real R1 = 1;
  parameter Real R2 = 1;
  parameter Real R3 = 1;
  parameter Real L = 1;
equation
  u0 = sin(time);
  u1 = R1*i1;
  u2 = R2*i2;
  u3 = R3*i3;
  uL = L*der(iL);
  u0 = u1 + u3;
  uL = u1 + u2;
  u2 = u3;
  i0 = i1 + iL;
  i1 = i2 + i3;

	annotation(__JModelica(UnitTesting(tests={ 
		CCodeGenTestCase(
			name="TearingTest1",
			description="Test code generation of torn blocks",
			generate_ode=true,
			equation_sorting=true,
			enable_tearing=true,
			template="$C_dae_blocks_residual_functions$",
			generatedCode="
static int dae_block_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
  jmi_real_t** res = &residual;
  if (evaluation_mode==JMI_BLOCK_NOMINAL) {
  } else  if (evaluation_mode==JMI_BLOCK_MIN) {
  } else if (evaluation_mode==JMI_BLOCK_MAX) {
  } else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
    x[0] = _i3_7;
    x[1] = _i2_6;
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
    _i3_7 = x[0];
    _i2_6 = x[1];
  _u2_2 = ( _R3_11 ) * ( _i3_7 );
  _i1_5 = _i2_6 + _i3_7;
  _u1_1 = ( _R1_9 ) * ( _i1_5 );
  (*res)[0] = _u1_1 + _u2_2 - (_u0_0);
  (*res)[1] = ( _R2_10 ) * ( _i2_6 ) - (_u2_2);
  } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
    _i3_7 = x[0];
    _i2_6 = x[1];
  }
  return 0;
}

")})));
end TearingTest1;

model MapTearingTest1

  function F
    input Real x;
    input Integer[2] map;
    output Real y;
  algorithm
    y := x + 1;
  end F;
  Integer[2] map = {1,2};
  Real x, y;
equation
  x = y + 1;
  y = F(x, map);

	annotation(__JModelica(UnitTesting(tests={ 
		CCodeGenTestCase(
			name="MapTearingTest1",
			description="Test code generation of torn blocks",
			generate_ode=true,
			equation_sorting=true,
			enable_tearing=true,
			template="$C_dae_blocks_residual_functions$",
			generatedCode="
static int dae_block_0(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode) {
  jmi_real_t** res = &residual;
  JMI_ARRAY_STATIC(tmp_1, 2, 1)
  if (evaluation_mode==JMI_BLOCK_NOMINAL) {
  } else  if (evaluation_mode==JMI_BLOCK_MIN) {
  } else if (evaluation_mode==JMI_BLOCK_MAX) {
  } else if (evaluation_mode==JMI_BLOCK_INITIALIZE) {
    x[0] = _x_2;
  } else if (evaluation_mode==JMI_BLOCK_EVALUATE) {
    _x_2 = x[0];
  JMI_ARRAY_STATIC_INIT_1(tmp_1, 2)
  jmi_array_ref_1(tmp_1, 1) = _map_1_0;
  jmi_array_ref_1(tmp_1, 2) = _map_2_1;
  _y_3 = func_CCodeGenTests_MapTearingTest1_F_exp(_x_2, tmp_1);
  (*res)[0] = _y_3 + 1 - (_x_2);
  } else if (evaluation_mode == JMI_BLOCK_WRITE_BACK) {
    _x_2 = x[0];
  }
  return 0;
}

")})));
end MapTearingTest1;


model MathSolve
	Real a[2,2] = [1,2;3,4];
    Real b[2] = {-2,3};
	Real x[2];
equation
	x = Modelica.Math.Matrices.solve(a, b);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="MathSolve",
			description="",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_Modelica_Math_Matrices_solve_def(jmi_array_t* A_a, jmi_array_t* b_a, jmi_array_t* x_a);
void func_Modelica_Math_Matrices_LAPACK_dgesv_vec_def(jmi_array_t* A_a, jmi_array_t* b_a, jmi_array_t* x_a, jmi_ad_var_t* info_o);

void func_Modelica_Math_Matrices_solve_def(jmi_array_t* A_a, jmi_array_t* b_a, jmi_array_t* x_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_DYNAMIC(x_an, 1)
    jmi_ad_var_t info_v;
    if (x_a == NULL) {
        JMI_ARRAY_DYNAMIC_INIT_1(x_an, jmi_array_size(b_a, 0), jmi_array_size(b_a, 0))
        x_a = x_an;
    }
    func_Modelica_Math_Matrices_LAPACK_dgesv_vec_def(A_a, b_a, x_a, &info_v);
    JMI_DYNAMIC_FREE()
    return;
}

void func_Modelica_Math_Matrices_LAPACK_dgesv_vec_def(jmi_array_t* A_a, jmi_array_t* b_a, jmi_array_t* x_a, jmi_ad_var_t* info_o) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_DYNAMIC(x_an, 1)
    jmi_ad_var_t info_v;
    JMI_ARRAY_DYNAMIC(Awork_a, 2)
    JMI_ARRAY_DYNAMIC(ipiv_a, 1)
    jmi_ad_var_t i1_0i;
    jmi_ad_var_t i1_0ie;
    jmi_ad_var_t i1_1i;
    jmi_ad_var_t i1_1ie;
    jmi_ad_var_t i2_2i;
    jmi_ad_var_t i2_2ie;
    jmi_int_t tmp_1;
    JMI_ARRAY_DYNAMIC(tmp_2, 2)
    JMI_INT_ARRAY_DYNAMIC(tmp_3, 1)
    jmi_int_t tmp_4;
    extern void dgesv_(jmi_int_t*, jmi_int_t*, jmi_ad_var_t*, jmi_int_t*, jmi_int_t*, jmi_ad_var_t*, jmi_int_t*, jmi_int_t*);
    if (x_a == NULL) {
        JMI_ARRAY_DYNAMIC_INIT_1(x_an, jmi_array_size(A_a, 0), jmi_array_size(A_a, 0))
        x_a = x_an;
    }
    JMI_ARRAY_DYNAMIC_INIT_2(Awork_a, ( jmi_array_size(A_a, 0) ) * ( jmi_array_size(A_a, 0) ), jmi_array_size(A_a, 0), jmi_array_size(A_a, 0))
    JMI_ARRAY_DYNAMIC_INIT_1(ipiv_a, jmi_array_size(A_a, 0), jmi_array_size(A_a, 0))
    i1_0ie = jmi_array_size(x_a, 0) + 1 / 2.0;
    for (i1_0i = 1; i1_0i < i1_0ie; i1_0i += 1) {
        jmi_array_ref_1(x_a, i1_0i) = jmi_array_val_1(b_a, i1_0i);
    }
    i1_1ie = jmi_array_size(Awork_a, 0) + 1 / 2.0;
    for (i1_1i = 1; i1_1i < i1_1ie; i1_1i += 1) {
        i2_2ie = jmi_array_size(Awork_a, 1) + 1 / 2.0;
        for (i2_2i = 1; i2_2i < i2_2ie; i2_2i += 1) {
            jmi_array_ref_2(Awork_a, i1_1i, i2_2i) = jmi_array_val_2(A_a, i1_1i, i2_2i);
        }
    }
    tmp_1 = 1;
    JMI_ARRAY_DYNAMIC_INIT_2(tmp_2, ( jmi_array_size(A_a, 0) ) * ( jmi_array_size(A_a, 0) ), jmi_array_size(A_a, 0), jmi_array_size(A_a, 0))
    jmi_matrix_to_fortran_real(Awork_a, Awork_a->var, tmp_2->var);
    JMI_INT_ARRAY_DYNAMIC_INIT_1(tmp_3, jmi_array_size(A_a, 0), jmi_array_size(A_a, 0))
    jmi_matrix_to_fortran_int(ipiv_a, ipiv_a->var, tmp_3->var);
    tmp_4 = (int)info_v;
    dgesv_(&jmi_array_size(A_a, 0), &tmp_1, tmp_2->var, &jmi_array_size(A_a, 0), tmp_3->var, x_a->var, &jmi_array_size(A_a, 0), &tmp_4);
    info_v = tmp_4;
    if (info_o != NULL) *info_o = info_v;
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end MathSolve;

model MathSolve2
	Real A[2,2] = [1,2;3,4];
	Real x_r[2] = {-2,3};
    Real b[2] = A*x_r;
    Real B[2,3] = [b, 2*b, -3*b];
    Real X[2,3];
equation
	X = Modelica.Math.Matrices.solve2(A, B);

	annotation(__JModelica(UnitTesting(tests={
		CCodeGenTestCase(
			name="MathSolve2",
			description="",
			template="
$C_function_headers$
$C_functions$
",
         generatedCode="
void func_Modelica_Math_Matrices_solve2_def(jmi_array_t* A_a, jmi_array_t* B_a, jmi_array_t* X_a);
void func_Modelica_Math_Matrices_LAPACK_dgesv_def(jmi_array_t* A_a, jmi_array_t* B_a, jmi_array_t* X_a, jmi_ad_var_t* info_o);

void func_Modelica_Math_Matrices_solve2_def(jmi_array_t* A_a, jmi_array_t* B_a, jmi_array_t* X_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_DYNAMIC(X_an, 2)
    jmi_ad_var_t info_v;
    if (X_a == NULL) {
        JMI_ARRAY_DYNAMIC_INIT_2(X_an, ( jmi_array_size(B_a, 0) ) * ( jmi_array_size(B_a, 1) ), jmi_array_size(B_a, 0), jmi_array_size(B_a, 1))
        X_a = X_an;
    }
    func_Modelica_Math_Matrices_LAPACK_dgesv_def(A_a, B_a, X_a, &info_v);
    JMI_DYNAMIC_FREE()
    return;
}

void func_Modelica_Math_Matrices_LAPACK_dgesv_def(jmi_array_t* A_a, jmi_array_t* B_a, jmi_array_t* X_a, jmi_ad_var_t* info_o) {
    JMI_DYNAMIC_INIT()
    JMI_ARRAY_DYNAMIC(X_an, 2)
    jmi_ad_var_t info_v;
    JMI_ARRAY_DYNAMIC(Awork_a, 2)
    JMI_ARRAY_DYNAMIC(ipiv_a, 1)
    jmi_ad_var_t i1_0i;
    jmi_ad_var_t i1_0ie;
    jmi_ad_var_t i2_1i;
    jmi_ad_var_t i2_1ie;
    jmi_ad_var_t i1_2i;
    jmi_ad_var_t i1_2ie;
    jmi_ad_var_t i2_3i;
    jmi_ad_var_t i2_3ie;
    JMI_ARRAY_DYNAMIC(tmp_1, 2)
    JMI_INT_ARRAY_DYNAMIC(tmp_2, 1)
    JMI_ARRAY_DYNAMIC(tmp_3, 2)
    jmi_int_t tmp_4;
    extern void dgesv_(jmi_int_t*, jmi_int_t*, jmi_ad_var_t*, jmi_int_t*, jmi_int_t*, jmi_ad_var_t*, jmi_int_t*, jmi_int_t*);
    if (X_a == NULL) {
        JMI_ARRAY_DYNAMIC_INIT_2(X_an, ( jmi_array_size(A_a, 0) ) * ( jmi_array_size(B_a, 1) ), jmi_array_size(A_a, 0), jmi_array_size(B_a, 1))
        X_a = X_an;
    }
    JMI_ARRAY_DYNAMIC_INIT_2(Awork_a, ( jmi_array_size(A_a, 0) ) * ( jmi_array_size(A_a, 0) ), jmi_array_size(A_a, 0), jmi_array_size(A_a, 0))
    JMI_ARRAY_DYNAMIC_INIT_1(ipiv_a, jmi_array_size(A_a, 0), jmi_array_size(A_a, 0))
    i1_0ie = jmi_array_size(X_a, 0) + 1 / 2.0;
    for (i1_0i = 1; i1_0i < i1_0ie; i1_0i += 1) {
        i2_1ie = jmi_array_size(X_a, 1) + 1 / 2.0;
        for (i2_1i = 1; i2_1i < i2_1ie; i2_1i += 1) {
            jmi_array_ref_2(X_a, i1_0i, i2_1i) = jmi_array_val_2(B_a, i1_0i, i2_1i);
        }
    }
    i1_2ie = jmi_array_size(Awork_a, 0) + 1 / 2.0;
    for (i1_2i = 1; i1_2i < i1_2ie; i1_2i += 1) {
        i2_3ie = jmi_array_size(Awork_a, 1) + 1 / 2.0;
        for (i2_3i = 1; i2_3i < i2_3ie; i2_3i += 1) {
            jmi_array_ref_2(Awork_a, i1_2i, i2_3i) = jmi_array_val_2(A_a, i1_2i, i2_3i);
        }
    }
    JMI_ARRAY_DYNAMIC_INIT_2(tmp_1, ( jmi_array_size(A_a, 0) ) * ( jmi_array_size(A_a, 0) ), jmi_array_size(A_a, 0), jmi_array_size(A_a, 0))
    jmi_matrix_to_fortran_real(Awork_a, Awork_a->var, tmp_1->var);
    JMI_INT_ARRAY_DYNAMIC_INIT_1(tmp_2, jmi_array_size(A_a, 0), jmi_array_size(A_a, 0))
    jmi_matrix_to_fortran_int(ipiv_a, ipiv_a->var, tmp_2->var);
    JMI_ARRAY_DYNAMIC_INIT_2(tmp_3, ( jmi_array_size(A_a, 0) ) * ( jmi_array_size(B_a, 1) ), jmi_array_size(A_a, 0), jmi_array_size(B_a, 1))
    jmi_matrix_to_fortran_real(X_a, X_a->var, tmp_3->var);
    tmp_4 = (int)info_v;
    dgesv_(&jmi_array_size(A_a, 0), &jmi_array_size(B_a, 1), tmp_1->var, &jmi_array_size(A_a, 0), tmp_2->var, tmp_3->var, &jmi_array_size(A_a, 0), &tmp_4);
    jmi_matrix_from_fortran_real(X_a, tmp_3->var, X_a->var);
    info_v = tmp_4;
    if (info_o != NULL) *info_o = info_v;
    JMI_DYNAMIC_FREE()
    return;
}

")})));
end MathSolve2;

class ExtObject
	extends ExternalObject;
	
	function constructor
		output ExtObject eo;
		external "C" eo = init_myEO();
	end constructor;
	
	function destructor
		input ExtObject eo;
		external "C" close_myEO(eo);
	end destructor;
end ExtObject;

class ExtObjectwInput
    extends ExternalObject;
    
    function constructor
		input Real i;
        output ExtObject eo;
        external "C" eo = init_myEO(i);
    end constructor;
    
    function destructor
        input ExtObject eo;
        external "C" close_myEO(eo);
    end destructor;
end ExtObjectwInput;

function useMyEO
	input ExtObject eo;
	output Real r;
	external "C" r = useMyEO(eo);
end useMyEO;

model TestExtObject1
	ExtObject myEO = ExtObject();
	Real y;
equation
	y = useMyEO(myEO);


	annotation(__JModelica(UnitTesting(tests={ 
		CCodeGenTestCase(
			name="TestExtObject1",
			description="",
			template="
$C_variable_aliases$
$C_function_headers$
$C_functions$
",
			generatedCode="
#define _y_1 ((*(jmi->z))[jmi->offs_real_w+0])
#define _time ((*(jmi->z))[jmi->offs_t])
#define _myEO_0 ((jmi->ext_objs)[0])

void func_CCodeGenTests_ExtObject_destructor_def(void* eo_v);
void func_CCodeGenTests_ExtObject_constructor_def(void** eo_o);
void* func_CCodeGenTests_ExtObject_constructor_exp();
void func_CCodeGenTests_useMyEO_def(void* eo_v, jmi_ad_var_t* r_o);
jmi_ad_var_t func_CCodeGenTests_useMyEO_exp(void* eo_v);

void func_CCodeGenTests_ExtObject_destructor_def(void* eo_v) {
    JMI_DYNAMIC_INIT()
    close_myEO(eo_v);
    JMI_DYNAMIC_FREE()
    return;
}

void func_CCodeGenTests_ExtObject_constructor_def(void** eo_o) {
    JMI_DYNAMIC_INIT()
    void* eo_v;
    eo_v = init_myEO();
    if (eo_o != NULL) *eo_o = eo_v;
    JMI_DYNAMIC_FREE()
    return;
}

void* func_CCodeGenTests_ExtObject_constructor_exp() {
    void* eo_v;
    func_CCodeGenTests_ExtObject_constructor_def(&eo_v);
    return eo_v;
}

void func_CCodeGenTests_useMyEO_def(void* eo_v, jmi_ad_var_t* r_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t r_v;
    r_v = useMyEO(eo_v);
    if (r_o != NULL) *r_o = r_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_useMyEO_exp(void* eo_v) {
    jmi_ad_var_t r_v;
    func_CCodeGenTests_useMyEO_def(eo_v, &r_v);
    return r_v;
}

")})));
end TestExtObject1;

model TestExtObject2
    ExtObject myEO = ExtObject();
	ExtObject myEO2 = ExtObject();
    Real y;
equation
    y = useMyEO(myEO) + useMyEO(myEO2);	

	annotation(__JModelica(UnitTesting(tests={ 
		CCodeGenTestCase(
			name="TestExtObject2",
			description="",
			template="
$C_variable_aliases$
$C_function_headers$
$C_functions$
",
			generatedCode="
#define _y_2 ((*(jmi->z))[jmi->offs_real_w+0])
#define _time ((*(jmi->z))[jmi->offs_t])
#define _myEO_0 ((jmi->ext_objs)[0])
#define _myEO2_1 ((jmi->ext_objs)[1])

void func_CCodeGenTests_ExtObject_destructor_def(void* eo_v);
void func_CCodeGenTests_ExtObject_constructor_def(void** eo_o);
void* func_CCodeGenTests_ExtObject_constructor_exp();
void func_CCodeGenTests_useMyEO_def(void* eo_v, jmi_ad_var_t* r_o);
jmi_ad_var_t func_CCodeGenTests_useMyEO_exp(void* eo_v);

void func_CCodeGenTests_ExtObject_destructor_def(void* eo_v) {
    JMI_DYNAMIC_INIT()
    close_myEO(eo_v);
    JMI_DYNAMIC_FREE()
    return;
}

void func_CCodeGenTests_ExtObject_constructor_def(void** eo_o) {
    JMI_DYNAMIC_INIT()
    void* eo_v;
    eo_v = init_myEO();
    if (eo_o != NULL) *eo_o = eo_v;
    JMI_DYNAMIC_FREE()
    return;
}

void* func_CCodeGenTests_ExtObject_constructor_exp() {
    void* eo_v;
    func_CCodeGenTests_ExtObject_constructor_def(&eo_v);
    return eo_v;
}

void func_CCodeGenTests_useMyEO_def(void* eo_v, jmi_ad_var_t* r_o) {
    JMI_DYNAMIC_INIT()
    jmi_ad_var_t r_v;
    r_v = useMyEO(eo_v);
    if (r_o != NULL) *r_o = r_v;
    JMI_DYNAMIC_FREE()
    return;
}

jmi_ad_var_t func_CCodeGenTests_useMyEO_exp(void* eo_v) {
    jmi_ad_var_t r_v;
    func_CCodeGenTests_useMyEO_def(eo_v, &r_v);
    return r_v;
}

")})));
end TestExtObject2;

model TestExtObject3
    ExtObject myEO1 = ExtObject();
	ExtObject myEO2 = ExtObject();
	ExtObjectwInput myEO3 = ExtObjectwInput(z1);
	ExtObjectwInput myEO4 = ExtObjectwInput(z1);
    Real y1;
	Real y2;
	Real y3;
	Real y4;
	Real z1 = 5;
equation
    y1 = useMyEO(myEO1);
	y2 = useMyEO(myEO2);
    y3 = useMyEO(myEO3);
    y4 = useMyEO(myEO4);

	annotation(__JModelica(UnitTesting(tests={ 
		CCodeGenTestCase(
			name="TestExtObject3",
			description="",
			template="
$C_set_start_values$
$C_DAE_initial_dependent_parameter_assignments$
",
			generatedCode="
    if (!jmi->indep_extobjs_initialized) { 
        _myEO1_0 = (func_CCodeGenTests_ExtObject_constructor_exp());
    }
    if (!jmi->indep_extobjs_initialized) { 
        _myEO2_1 = (func_CCodeGenTests_ExtObject_constructor_exp());
    }
    model_init_eval_parameters(jmi);
    _y1_4 = (0.0);
    _y2_5 = (0.0);
    _y3_6 = (0.0);
    _y4_7 = (0.0);
    _z1_8 = (0.0);
    jmi->indep_extobjs_initialized = 1;

    if (!jmi->dep_extobjs_initialized) { 
        _myEO3_2 = (func_CCodeGenTests_ExtObjectwInput_constructor_exp(_z1_8));
    }
    if (!jmi->dep_extobjs_initialized) { 
        _myEO4_3 = (func_CCodeGenTests_ExtObjectwInput_constructor_exp(_z1_8));
    }
    jmi->dep_extobjs_initialized = 1;
")})));
end TestExtObject3;

end CCodeGenTests;
