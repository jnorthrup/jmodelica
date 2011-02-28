package ComplianceTests



model String_ComplErr
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
      JModelica.UnitTesting.ComplianceErrorTestCase(name="String_ComplErr",
        description="Compliance error for String variables",
                                               errorMessage=
"Error: in file '/Users/jakesson/projects/JModelica/Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 73, column 9:
  String variables are not supported
Error: in file '/Users/jakesson/projects/JModelica/Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 74, column 19:
  String variables are not supported
")})));


 String str1="s1";
 parameter String str2="s2";

end String_ComplErr;

model IntegerVariable_ComplErr
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
      JModelica.UnitTesting.ComplianceErrorTestCase(name="IntegerVariable_ComplErr",
        description="Compliance error for integer variables",
                                               errorMessage=
"
Error: in file '/Users/jakesson/projects/JModelica/Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 87, column 9:
  Integer variables are not supported, only constants and parameters
")})));


Integer i=1;

end IntegerVariable_ComplErr;

model BooleanVariable_ComplErr
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
	  JModelica.UnitTesting.ComplianceErrorTestCase(name="BooleanVariable_ComplErr",
		description="Compliance error for boolean variables",
											   errorMessage=
"
Error: in file '/Users/jakesson/projects/JModelica/Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 103, column 10:
  Boolean variables are not supported, only constants and parameters
")})));

 Boolean b=true;

end BooleanVariable_ComplErr;

model EnumVariable_ComplErr
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
	  JModelica.UnitTesting.ComplianceErrorTestCase(name="EnumVariable_ComplErr",
		description="Compliance error for enumeration variables",
											   errorMessage=
"
Error: in file '/Users/jakesson/projects/JModelica/Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 103, column 10:
  Enumeration variables are not supported, only constants and parameters
")})));

 type A = enumeration(a, b, c);
 A x = A.b;

end EnumVariable_ComplErr;


model InnerOuter
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.ComplianceErrorTestCase(
         name="InnerOuter",
         description="Compliance error for inner and outer",
         errorMessage="
2 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 74, column 14:
  Inner/outer components are not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 75, column 14:
  Inner/outer components are not supported
")})));

	model A
		inner Real x;
		outer Real y;
	end A;
	
	A z;
end InnerOuter;


model ArrayOfRecords_Warn
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.WarningTestCase(
         name="ArrayOfRecords_Warn",
         description="Compliance warning for arrays of records with index variability > parameter",
         errorMessage="
1 errors found:
Warning: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
At line 79, column 3:
  Using arrays of records with indices of higher than parameter variability is currently not supported when compiling with CppAD
")})));

 function f
  input Real i;
  output R[2] a;
 algorithm
  a := {R(1,2), R(3,4)};
  a[integer(i)].a := 0;
 end f;

 record R
  Real a;
  Real b;
 end R;
 
 R x[2] = f(1);
end ArrayOfRecords_Warn;


//model ExternalFunction_ComplErr
// annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
//     JModelica.UnitTesting.ComplianceErrorTestCase(
//         name="ExternalFunction_ComplErr",
//         description="Compliance error for external functions",
//         errorMessage="
//1 errors found:
//Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
//Compliance error at line 105, column 3:
//  External functions are not supported
//")})));

// function f
//  output Real x;
//  external "C";
// end f;
 
// Real x = f();
//end ExternalFunction_ComplErr;


model WhenStmt_ComplErr
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.ComplianceErrorTestCase(
         name="WhenStmt_ComplErr",
         description="Compliance error for when statements",
         errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 126, column 2:
  When statements are not supported
")})));

 Real x;
algorithm
 when (time < 2) then
  x := 5;
 end when;
end WhenStmt_ComplErr;


model UnsupportedBuiltins1_ComplErr
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.ComplianceErrorTestCase(
         name="UnsupportedBuiltins1_ComplErr",
         description="Compliance error for unsupported builtins",
         errorMessage="
8 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 165, column 3:
  The scalar() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 166, column 3:
  The vector() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 167, column 3:
  The matrix() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 168, column 3:
  The diagonal() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 169, column 3:
  The product() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 170, column 3:
  The outerProduct() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 171, column 3:
  The symmetric() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 172, column 3:
  The skew() function-like operator is not supported
")})));

 equation
  scalar(1);
  vector(1);
  matrix(1);
  diagonal(1 + "2");
  product(1);
  outerProduct(1);
  symmetric(1);
  skew(1);
end UnsupportedBuiltins1_ComplErr;


model UnsupportedBuiltins2_ComplErr
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.ComplianceErrorTestCase(
         name="UnsupportedBuiltins2_ComplErr",
         description="Compliance error for unsupported builtins",
         errorMessage="
10 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 210, column 3:
  The sign() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Semantic error at line 212, column 3:
  The class String is not a function
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 213, column 3:
  The div() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 214, column 3:
  The mod() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 215, column 3:
  The rem() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 216, column 3:
  The ceil() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 217, column 3:
  The floor() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 218, column 3:
  The delay() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 219, column 3:
  The cardinality() function-like operator is not supported
")})));

 equation
  sign(1);
  String();
  div(1);
  mod();
  rem(1);
  ceil();
  floor();
  delay(1);
  cardinality();
end UnsupportedBuiltins2_ComplErr;


model UnsupportedBuiltins3_ComplErr
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.ComplianceErrorTestCase(
         name="UnsupportedBuiltins3_ComplErr",
         description="Compliance error for unsupported builtins",
         errorMessage="
10 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 280, column 3:
  The semiLinear() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 281, column 3:
  The initial() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 282, column 3:
  The terminal() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 283, column 3:
  The smooth() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 284, column 3:
  The sample() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 285, column 3:
  The pre() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 286, column 3:
  The edge() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 287, column 3:
  The reinit() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 288, column 3:
  The terminate() function-like operator is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 289, column 3:
  The integer() function-like operator is not supported
")})));

  discrete Real x;
 equation
  semiLinear();
  initial();
  terminal();
  smooth(1);
  sample(1,1);
  pre(x);
  edge();
  reinit(1);
  terminate();
  integer(1);
end UnsupportedBuiltins3_ComplErr;


model UnsupportedBuiltins4_Warn
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.WarningTestCase(
         name="UnsupportedBuiltins4_Warn",
         description="Warnings for ignored builtins",
         errorMessage="
1 errors found:
Warning: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
At line 294, column 2:
  The assert() function-like operator is not supported, and is currently ignored
")})));

equation
 assert(1);
end UnsupportedBuiltins4_Warn;


model UnsupportedBuiltins5_Err
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.ErrorTestCase(
         name="UnsupportedBuiltins5_Err",
         description="Ignored builtins can't have outputs",
         errorMessage="
2 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Semantic error at line 313, column 12:
  Too many components assigned from function call: assert() has 0 output(s)
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Semantic error at line 314, column 3:
  Function assert() has no outputs, but is used in expression
")})));

  Real a;
  Real b;
 equation
  (a, b) = assert(1);
  a = assert(1);
end UnsupportedBuiltins5_Err;


model UnsupportedBuiltins6
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.TransformCanonicalTestCase(
         name="UnsupportedBuiltins6",
         description="Check that ignored built-ins aren't printed and doesn't cause exceptions",
         flatModel="
fclass ComplianceTests.UnsupportedBuiltins6
end ComplianceTests.UnsupportedBuiltins6;
")})));

equation
 assert(1);
end UnsupportedBuiltins6;


model StringConcat_ComplErr
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.ComplianceErrorTestCase(
         name="StringConcat_ComplErr",
         description="Compliance error for string concatenation",
         errorMessage="
6 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 308, column 9:
  String variables are not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 308, column 13:
  String concatenation is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 309, column 12:
  String variables are not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 309, column 16:
  String concatenation is not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 310, column 12:
  String variables are not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 310, column 16:
  String concatenation is not supported
")})));

 Real a = 1 + 2;
 String b = "1" + "2";
 String[2] c = { "1", "2" } .+ "3";
 String[2] d = { "1", "2" } + { "3", "4" };
end StringConcat_ComplErr;


model ArrayCellMod_ComplErr
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.ComplianceErrorTestCase(
         name="ArrayCellMod_ComplErr",
         description="Compliance error for modifiers of specific array elements",
         errorMessage="
3 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Semantic error at line 361, column 8:
  Array size mismatch in declaration of b, size of declaration is [2] and size of binding expression is []
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 364, column 5:
  Modifiers of specific array elements are not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 364, column 14:
  Modifiers of specific array elements are not supported
")})));

 model A
  Real b[2];
 end A;
 
 A a(b[1] = 1, b[1](start=2));
end ArrayCellMod_ComplErr;

model DuplicateVariables_ComplErr
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.ComplianceErrorTestCase(
         name="DuplicateVariables_ComplErr",
         enable_structural_diagnosis=false,
         description="Compliance error test checking for duplicate variables",
         errorMessage="
1 Errors found:
Compliance error at line 0, column 0:
  The variable x is declared multiple times. Possibly, the model is still legal, but the JModelica.org compiler does currently not merge indentical components.

")})));
  Real x = 1;
  Real x = 1;

end DuplicateVariables_ComplErr;


model HybridNonFMU1
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.ComplianceErrorTestCase(
         name="HybridNonFMU1",
         description="Test that compliance warnings for hybrid elements are issued when not compiling FMU",
         errorMessage="
11 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 450, column 18:
  Boolean variables are not supported when compiling JMUs, only constants and parameters
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 451, column 18:
  Boolean variables are not supported when compiling JMUs, only constants and parameters
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 452, column 18:
  Boolean variables are not supported when compiling JMUs, only constants and parameters
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 455, column 1:
  When equations are currently only supported when compiling FMUs
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 455, column 16:
  The pre() function-like operator is supported only when compiling FMUs
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 458, column 1:
  When equations are currently only supported when compiling FMUs
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 461, column 1:
  When equations are currently only supported when compiling FMUs
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 464, column 1:
  When equations are currently only supported when compiling FMUs
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 464, column 6:
  The sample() function-like operator is supported only when compiling FMUs
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 465, column 5:
  The pre() function-like operator is supported only when compiling FMUs
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 466, column 5:
  The pre() function-like operator is supported only when compiling FMUs
")})));

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
when sample(0,1) then 
x = pre(x) + 1.1; 
y = pre(y) + 1.1; 
end when; 
end HybridNonFMU1;


model HybridFMU1
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.TransformCanonicalTestCase(
         name="HybridFMU1",
         description="Test that compliance warnings for hybrid elements aren't issued when compiling FMU",
         generate_ode=true,
		 checkAll=true,
         flatModel="
fclass ComplianceTests.HybridFMU1
 Real xx(start = 2);
 discrete Real x;
 discrete Real y;
 discrete Boolean w(start = true);
 discrete Boolean v(start = true);
 discrete Boolean z(start = true);
initial equation 
 xx = 2;
 pre(x) = 0.0;
 pre(y) = 0.0;
 pre(w) = true;
 pre(v) = true;
 pre(z) = true;
equation
 der(xx) =  - ( x );
 when y > 2 and pre(z) then
  w = false;
 end when;
 when y > 2 and z then
  v = false;
 end when;
 when x > 2 then
  z = false;
 end when;
 when sample(0, 1) then
  x = pre(x) + 1.1;
 end when;
 when sample(0, 1) then
  y = pre(y) + 1.1;
 end when;
end ComplianceTests.HybridFMU1;
")})));

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
when sample(0,1) then 
x = pre(x) + 1.1; 
y = pre(y) + 1.1; 
end when; 
end HybridFMU1;


model HybridNonFMU2 
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.ComplianceErrorTestCase(
         name="HybridNonFMU2",
         description="Test that compliance warnings for hybrid elements are issued when not compiling FMU",
         errorMessage="
6 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 583, column 2:
  When equations are currently only supported when compiling FMUs
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 583, column 7:
  The sample() function-like operator is supported only when compiling FMUs
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 584, column 8:
  The pre() function-like operator is supported only when compiling FMUs
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 586, column 2:
  When equations are currently only supported when compiling FMUs
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 586, column 7:
  The initial() function-like operator supported only when compiling FMUs
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ComplianceTests.mo':
Compliance error at line 587, column 8:
  The pre() function-like operator is supported only when compiling FMUs
")})));

 discrete Real x,y;
 Real dummy;
equation
 der(dummy) = 0;
 when sample(0,1/3) then
   x = pre(x) + 1;
 end when;
 when initial() then
   y = pre(y) + 1;
 end when;
end HybridNonFMU2; 


model HybridFMU2 
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.TransformCanonicalTestCase(
         name="HybridFMU2",
         description="Test that compliance warnings for hybrid elements aren't issued when compiling FMU",
         generate_ode=true,
		 checkAll=true,
         flatModel="
fclass ComplianceTests.HybridFMU2
 discrete Real x;
 discrete Real y;
 Real dummy;
initial equation 
 dummy = 0.0;
 pre(x) = 0.0;
 pre(y) = 0.0;
equation
 der(dummy) = 0;
 when sample(0, ( 1 ) / ( 3 )) then
  x = pre(x) + 1;
 end when;
 when initial() then
  y = pre(y) + 1;
 end when;
end ComplianceTests.HybridFMU2;
")})));

 discrete Real x,y;
 Real dummy;
equation
 der(dummy) = 0;
 when sample(0,1/3) then
   x = pre(x) + 1;
 end when;
 when initial() then
   y = pre(y) + 1;
 end when;
end HybridFMU2; 



end ComplianceTests;
