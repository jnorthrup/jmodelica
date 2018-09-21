/*
	Copyright (C) 2009-2013 Modelon AB

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

package VariabilityPropagationTests

model VariabilityInference
	Real x1;
	Boolean x2;
	
	parameter Real p1 = 4;
	Real r1;
	Real r2;
equation
	x1 = 1;
	x2 = true;
	r1 = p1;
	r2 = p1 + x1;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="VariabilityInference",
            description="Tests if variability 
			inferred from equations is propagated to declarations",
            flatModel="
fclass VariabilityPropagationTests.VariabilityInference
 constant Real x1 = 1;
 constant Boolean x2 = true;
 parameter Real p1 = 4 /* 4 */;
 parameter Real r1;
 parameter Real r2;
parameter equation
 r1 = p1;
 r2 = p1 + 1.0;
end VariabilityPropagationTests.VariabilityInference;
")})));
end VariabilityInference;

model SimplifyLitExps
	Real x1;
	Boolean x2;
equation
	x1 = 1 + 2 * 3 - 4 / 8 + 6 * 7 - 8 * 9;
	x2 = true and false or true or false and true;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="SimplifyLitExps",
            description="Tests if literal expressions are folded",
            flatModel="
fclass VariabilityPropagationTests.SimplifyLitExps
 constant Real x1 = -23.5;
 constant Boolean x2 = true;
end VariabilityPropagationTests.SimplifyLitExps;
")})));
end SimplifyLitExps;

model ConstantFolding1
	Real x1,x2,x3,x4;
equation
	x1 = 1;
	x2 = x3 + x1;
	x3 = x1;
	x4 = x2;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ConstantFolding1",
            description="Tests if constant values inferred from equations are moved to equations and folded.",
            eliminate_alias_variables=false,
            flatModel="
fclass VariabilityPropagationTests.ConstantFolding1
 constant Real x1 = 1;
 constant Real x2 = 2.0;
 constant Real x3 = 1.0;
 constant Real x4 = 2.0;
end VariabilityPropagationTests.ConstantFolding1;
")})));
end ConstantFolding1;

model ConstantFolding2
function f
	input Real ii;
	input Real i[:,:];
	output Real o;
algorithm
	o := i[1,1];
end f;	

	input Real i;
	Real x;
	Real y;

equation
	x = f(i,fill(1,2,3));
	when (x >1) then
		y = f(i,fill(1,0,2));
	end when;
	

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ConstantFolding2",
            description="Tests folding of some more advanced expressions and some which shouldn't be folded.",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.ConstantFolding2
 input Real i;
 Real x;
 discrete Real y;
 discrete Boolean temp_1;
initial equation 
 pre(y) = 0.0;
 pre(temp_1) = false;
equation
 x = VariabilityPropagationTests.ConstantFolding2.f(i, {{1, 1, 1}, {1, 1, 1}});
 temp_1 = x > 1;
 y = if temp_1 and not pre(temp_1) then VariabilityPropagationTests.ConstantFolding2.f(i, fill(0, 0, 2)) else pre(y);

public
 function VariabilityPropagationTests.ConstantFolding2.f
  input Real ii;
  input Real[:,:] i;
  output Real o;
 algorithm
  o := i[1,1];
  return;
 end VariabilityPropagationTests.ConstantFolding2.f;

end VariabilityPropagationTests.ConstantFolding2;
")})));
end ConstantFolding2;

model ConstantFolding3
	function StringCompare
		input String expected;
		input String actual;
	algorithm
		assert(actual == expected, "Compare failed, expected: " + expected + ", actual: " + actual);
	end StringCompare;
	type E = enumeration(small, medium, large, xlarge);
	Real realVar = 3.14;
	Integer intVar = if realVar < 2.5 then 12 else 42;
	Boolean boolVar = if realVar < 2.5 then true else false;
	E enumVar = if realVar < 2.5 then E.small else E.medium;
equation
	StringCompare("42",           String(intVar));
	StringCompare("42          ", String(intVar, minimumLength=12));
	StringCompare("          42", String(intVar, minimumLength=12, leftJustified=false));
	
	StringCompare("3.14000",      String(realVar));
	StringCompare("3.14000     ", String(realVar, minimumLength=12));
	StringCompare("     3.14000", String(realVar, minimumLength=12, leftJustified=false));
	StringCompare("3.1400000",    String(realVar, significantDigits=8));
	StringCompare("3.1400000   ", String(realVar, minimumLength=12, significantDigits=8));
	StringCompare("   3.1400000", String(realVar, minimumLength=12, leftJustified=false, significantDigits=8));
	
	StringCompare("-3.14000",     String(-realVar));
	StringCompare("-3.14000    ", String(-realVar, minimumLength=12));
	StringCompare("    -3.14000", String(-realVar, minimumLength=12, leftJustified=false));
	StringCompare("-3.1400000",   String(-realVar, significantDigits=8));
	StringCompare("-3.1400000  ", String(-realVar, minimumLength=12, significantDigits=8));
	StringCompare("  -3.1400000", String(-realVar, minimumLength=12, leftJustified=false, significantDigits=8));
	
	StringCompare("false",        String(boolVar));
	StringCompare("false       ", String(boolVar, minimumLength=12));
	StringCompare("       false", String(boolVar, minimumLength=12, leftJustified=false));
	
	StringCompare("true",         String(not boolVar));
	StringCompare("true        ", String(not boolVar, minimumLength=12));
	StringCompare("        true", String(not boolVar, minimumLength=12, leftJustified=false));
	
	StringCompare("medium",       String(enumVar));
	StringCompare("medium      ", String(enumVar, minimumLength=12));
	StringCompare("      medium", String(enumVar, minimumLength=12, leftJustified=false));

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ConstantFolding3",
            description="Tests folding of string operator.",
            flatModel="
fclass VariabilityPropagationTests.ConstantFolding3
 constant Real realVar = 3.14;
 constant Integer intVar = 42;
 constant Boolean boolVar = false;
 constant VariabilityPropagationTests.ConstantFolding3.E enumVar = VariabilityPropagationTests.ConstantFolding3.E.medium;
equation
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"42\", \"42\");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"42          \", \"42          \");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"          42\", \"          42\");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"3.14000\", \"3.14000\");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"3.14000     \", \"3.14000     \");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"     3.14000\", \"     3.14000\");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"3.1400000\", \"3.1400000\");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"3.1400000   \", \"3.1400000   \");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"   3.1400000\", \"   3.1400000\");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"-3.14000\", \"-3.14000\");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"-3.14000    \", \"-3.14000    \");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"    -3.14000\", \"    -3.14000\");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"-3.1400000\", \"-3.1400000\");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"-3.1400000  \", \"-3.1400000  \");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"  -3.1400000\", \"  -3.1400000\");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"false\", \"false\");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"false       \", \"false       \");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"       false\", \"       false\");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"true\", \"true\");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"true        \", \"true        \");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"        true\", \"        true\");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"medium\", \"medium\");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"medium      \", \"medium      \");
 VariabilityPropagationTests.ConstantFolding3.StringCompare(\"      medium\", \"      medium\");

public
 function VariabilityPropagationTests.ConstantFolding3.StringCompare
  input String expected;
  input String actual;
 algorithm
  assert(actual == expected, \"Compare failed, expected: \" + expected + \", actual: \" + actual);
  return;
 end VariabilityPropagationTests.ConstantFolding3.StringCompare;

 type VariabilityPropagationTests.ConstantFolding3.E = enumeration(small, medium, large, xlarge);

end VariabilityPropagationTests.ConstantFolding3;
")})));
end ConstantFolding3;

model ConstantFolding4
	Real x;
	parameter Real y;
equation
	when y > 1 then
		x = 1;
	end when;
	
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ConstantFolding4",
            description="Rewrite parameter pre expressions",
            flatModel="
fclass VariabilityPropagationTests.ConstantFolding4
 discrete Real x;
 parameter Real y;
 parameter Boolean temp_1;
initial equation 
 pre(x) = 0.0;
parameter equation
 temp_1 = y > 1;
equation
 x = if temp_1 and not temp_1 then 1 else pre(x);
end VariabilityPropagationTests.ConstantFolding4;
")})));
end ConstantFolding4;

model NoExp
	Real x(start=.5);
equation
	x-0.1 = cos(x);
	
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="NoExp",
            description="Tests that an equation with a single 
			variable but no solution is not changed.",
            flatModel="
fclass VariabilityPropagationTests.NoExp
 Real x(start = 0.5);
equation
 x - 0.1 = cos(x);
end VariabilityPropagationTests.NoExp;
")})));
end NoExp;


model Output
	output Real x;
equation
	x = 5;
	
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="Output",
            description="This tests that we do not propagate variability to output variables",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.Output
 output Real x;
equation
 x = 5;
end VariabilityPropagationTests.Output;
")})));
end Output;


model Output2
	output Real a;
	Real b;
	
	function f
		output Real o1;
		output Real o2;
	algorithm
		o1 := 1;
		o2 := 2;
	end f;

equation
	(a,b) = f();
	
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="Output2",
            description="This tests that we do not propagate variability to output variables",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.Output2
 output Real a;
 constant Real b = 2;
equation
 (a, ) = VariabilityPropagationTests.Output2.f();

public
 function VariabilityPropagationTests.Output2.f
  output Real o1;
  output Real o2;
 algorithm
  o1 := 1;
  o2 := 2;
  return;
 end VariabilityPropagationTests.Output2.f;

end VariabilityPropagationTests.Output2;
")})));
end Output2;

model Der1
	Real x1,x2;
	Real x3,x4;
	Real x5,x6;
	parameter Real p1 = 4;
equation
    x2 = der(x1);
    x1 = 3;
    x3 = der(x4);
    der(x4) = 3;
    x5 = der(x6);
    x6 = p1 + 1;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="Der1",
            description="Tests some propagation to and through derivative expressions.",
            eliminate_alias_variables=false,
            flatModel="
fclass VariabilityPropagationTests.Der1
 constant Real x1 = 3;
 constant Real x2 = 0.0;
 Real x3;
 Real x4;
 constant Real x5 = 0.0;
 parameter Real x6;
 parameter Real p1 = 4 /* 4 */;
initial equation 
 x4 = 0.0;
parameter equation
 x6 = p1 + 1;
equation
 x3 = der(x4);
 der(x4) = 3;
end VariabilityPropagationTests.Der1;
")})));
end Der1;

model Der2
	Real x,y;
	Real z;
equation
	z = time;
	y = x * der(z) + 1;
	x = 0;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="Der2",
            description="Test removal of der var",
            flatModel="
fclass VariabilityPropagationTests.Der2
 constant Real x = 0;
 constant Real y = 1.0;
 Real z;
equation
 z = time;
end VariabilityPropagationTests.Der2;
")})));
end Der2;



model WhenEq1
	Real x1,x2;
equation
	when time > 3 then
		x1 = x2 + 1;
	end when;
	x2 = 3;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="WhenEq1",
            description="Tests that folding occurs, but not propagation, in when equations.",
            flatModel="
fclass VariabilityPropagationTests.WhenEq1
 discrete Real x1;
 constant Real x2 = 3;
 discrete Boolean temp_1;
initial equation 
 pre(x1) = 0.0;
 pre(temp_1) = false;
equation
 temp_1 = time > 3;
 x1 = if temp_1 and not pre(temp_1) then 4.0 else pre(x1);
end VariabilityPropagationTests.WhenEq1;
")})));
end WhenEq1;


model IfEq1
	constant Real p1 = 4;
	Real x1,x2;
equation
	if 3 > p1 then
		x1 = x2 + 1;
	elseif 3 < p1 then
		x1 = x2;
	else
		x1 = x2 - 1;		
	end if;
	x2 = 3;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="IfEq1",
            description="Tests if-expressions",
            eliminate_alias_variables=false,
            flatModel="
fclass VariabilityPropagationTests.IfEq1
 constant Real p1 = 4;
 constant Real x1 = 3.0;
 constant Real x2 = 3;
end VariabilityPropagationTests.IfEq1;
")})));
end IfEq1;


model IfEq2
	constant Real c1 = 4;
	parameter Real p1 = 1;
	Real x1,x2,x3,x4;
equation
	x3 = 3;
	if (x3 > c1) then
		x1 = 1;
		x2 = p1 + 1;
	elseif (x4 < c1) then
		x1 = 2;
		x2 = p1 + 2;
	else
		x1 = 3;
		x2 = 4;
	end if;
	x4 = 3;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="IfEq2",
            description="Tests if-expressions",
            eliminate_alias_variables=false,
            flatModel="
fclass VariabilityPropagationTests.IfEq2
 constant Real c1 = 4;
 parameter Real p1 = 1 /* 1 */;
 constant Real x1 = 2;
 parameter Real x2;
 constant Real x3 = 3;
 constant Real x4 = 3;
parameter equation
 x2 = p1 + 2;
end VariabilityPropagationTests.IfEq2;
")})));
end IfEq2;


model FunctionCall1
	Real c_out;
    function f
        output Real c;
    algorithm
    	c := 1;
    end f;
equation
    c_out = f() * 5.0;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FunctionCall1",
            description="Tests a constant function call with no parameters.",
            flatModel="
fclass VariabilityPropagationTests.FunctionCall1
 constant Real c_out = 5.0;
end VariabilityPropagationTests.FunctionCall1;
")})));
end FunctionCall1;


model FunctionCallEquation1
	Real x1,x2;
	Real x3,x4;
	Real x5;
	Real x6,x7;
	parameter Real p = 3;
	
    function f
    	input Real i1;
        output Real c1;
        output Real c2;
    algorithm
    	c1 := 1*i1;
    	c2 := 2*i1;
    end f;
    function e
    	input Real i1;
    	output Real o1,o2;
    	external "C";
    end e;
equation
    (x1,x2) = f(x5);
    (x3,x4) = f(p);
    x5 = 5;
    (x6,x7) = e(1);

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FunctionCallEquation1",
            description="Tests that variability is propagated through function call equations with multiple destinations.",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.FunctionCallEquation1
 constant Real x1 = 5.0;
 constant Real x2 = 10.0;
 parameter Real x3;
 parameter Real x4;
 constant Real x5 = 5;
 parameter Real x6;
 parameter Real x7;
 parameter Real p = 3 /* 3 */;
parameter equation
 (x3, x4) = VariabilityPropagationTests.FunctionCallEquation1.f(p);
 (x6, x7) = VariabilityPropagationTests.FunctionCallEquation1.e(1);

public
 function VariabilityPropagationTests.FunctionCallEquation1.f
  input Real i1;
  output Real c1;
  output Real c2;
 algorithm
  c1 := i1;
  c2 := 2 * i1;
  return;
 end VariabilityPropagationTests.FunctionCallEquation1.f;

 function VariabilityPropagationTests.FunctionCallEquation1.e
  input Real i1;
  output Real o1;
  output Real o2;
 algorithm
  external \"C\" e(i1, o1, o2);
  return;
 end VariabilityPropagationTests.FunctionCallEquation1.e;

end VariabilityPropagationTests.FunctionCallEquation1;
")})));
end FunctionCallEquation1;


model FunctionCallEquation2
	Real z1[2];
	Real z2[2];
	Real z3[2];
	parameter Real p = 3;
	
    function f
    	input Real i1;
        output Real c[2];
    algorithm
    	c[1] := 1*i1;
    	c[2] := 2*i1;
    end f;
    function e
    	input Real i1;
        output Real c[2];
    	external "C";
    end e;
equation
    (z1) = f(1);
    (z2) = f(p);
    (z3) = e(1);

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FunctionCallEquation2",
            description="Tests that variability is propagated through function call equations with array destinations.",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.FunctionCallEquation2
 constant Real z1[1] = 1;
 constant Real z1[2] = 2.0;
 parameter Real z2[1];
 parameter Real z2[2];
 parameter Real z3[1];
 parameter Real z3[2];
 parameter Real p = 3 /* 3 */;
parameter equation
 ({z2[1], z2[2]}) = VariabilityPropagationTests.FunctionCallEquation2.f(p);
 ({z3[1], z3[2]}) = VariabilityPropagationTests.FunctionCallEquation2.e(1);

public
 function VariabilityPropagationTests.FunctionCallEquation2.f
  input Real i1;
  output Real[:] c;
 algorithm
  init c as Real[2];
  c[1] := i1;
  c[2] := 2 * i1;
  return;
 end VariabilityPropagationTests.FunctionCallEquation2.f;

 function VariabilityPropagationTests.FunctionCallEquation2.e
  input Real i1;
  output Real[:] c;
 algorithm
  init c as Real[2];
  external \"C\" e(i1, c, size(c, 1));
  return;
 end VariabilityPropagationTests.FunctionCallEquation2.e;

end VariabilityPropagationTests.FunctionCallEquation2;
")})));
end FunctionCallEquation2;


model FunctionCallEquation3
	A a;
	A b;
	parameter Real p = 3;
	
    function f
    	input Real i;
        output A o1;
        output Real o2;
    algorithm
    	o1 := A(i*1,i*2);
    	o2 := i*3;
    end f;
    
	record A
		Real a;
		Real b;
	end A;
equation
    (a, ) = f(3);
    (b, ) = f(p);

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FunctionCallEquation3",
            description="Tests that variability is propagated through function call equations with record destinations.",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.FunctionCallEquation3
 constant Real a.a = 3;
 constant Real a.b = 6.0;
 parameter Real b.a;
 parameter Real b.b;
 parameter Real p = 3 /* 3 */;
parameter equation
 (VariabilityPropagationTests.FunctionCallEquation3.A(b.a, b.b), ) = VariabilityPropagationTests.FunctionCallEquation3.f(p);

public
 function VariabilityPropagationTests.FunctionCallEquation3.f
  input Real i;
  output VariabilityPropagationTests.FunctionCallEquation3.A o1;
  output Real o2;
 algorithm
  o1.a := i;
  o1.b := i * 2;
  o2 := i * 3;
  return;
 end VariabilityPropagationTests.FunctionCallEquation3.f;

 record VariabilityPropagationTests.FunctionCallEquation3.A
  Real a;
  Real b;
 end VariabilityPropagationTests.FunctionCallEquation3.A;

end VariabilityPropagationTests.FunctionCallEquation3;
")})));
end FunctionCallEquation3;


model FunctionCallEquation4
	Real a[2,2];
	constant Real b[2] = {1,2};
	Real x1[2];
equation
	x1 = Modelica.Math.Matrices.solve(a, b);
	a = {{1,2},{3,4}};
	
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FunctionCallEquation4",
            description="Tests that parameters in function call equations are folded. 
Also tests that when it is constant and can't evaluate, variability is propagated as parameter.",
            eliminate_alias_variables=false,
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.FunctionCallEquation4
 constant Real a[1,1] = 1;
 constant Real a[1,2] = 2;
 constant Real a[2,1] = 3;
 constant Real a[2,2] = 4;
 constant Real b[1] = 1;
 constant Real b[2] = 2;
 parameter Real x1[1];
 parameter Real x1[2];
parameter equation
 ({x1[1], x1[2]}) = Modelica.Math.Matrices.solve({{1.0, 2.0}, {3.0, 4.0}}, {1.0, 2.0});

public
 function Modelica.Math.Matrices.solve
  input Real[:,:] A;
  input Real[:] b;
  output Real[:] x;
  Integer info;
 algorithm
  init x as Real[size(b, 1)];
  (x, info) := Modelica.Math.Matrices.LAPACK.dgesv_vec(A, b);
  assert(info == 0, \"Solving a linear system of equations with function
\\\"Matrices.solve\\\" is not possible, because the system has either
no or infinitely many solutions (A is singular).\");
  return;
 end Modelica.Math.Matrices.solve;

 function Modelica.Math.Matrices.LAPACK.dgesv_vec
  input Real[:,:] A;
  input Real[:] b;
  output Real[:] x;
  output Integer info;
  Real[:,:] Awork;
  Integer lda;
  Integer ldb;
  Integer[:] ipiv;
 algorithm
  init x as Real[size(A, 1)];
  for i1 in 1:size(b, 1) loop
   x[i1] := b[i1];
  end for;
  init Awork as Real[size(A, 1), size(A, 1)];
  for i1 in 1:size(A, 1) loop
   for i2 in 1:size(A, 2) loop
    Awork[i1,i2] := A[i1,i2];
   end for;
  end for;
  lda := max(1, size(A, 1));
  ldb := max(1, size(b, 1));
  init ipiv as Integer[size(A, 1)];
  external \"FORTRAN 77\" dgesv(size(A, 1), 1, Awork, lda, ipiv, x, ldb, info);
  return;
 end Modelica.Math.Matrices.LAPACK.dgesv_vec;

end VariabilityPropagationTests.FunctionCallEquation4;
")})));
end FunctionCallEquation4;


model FunctionCallEquation5
	constant Real a[2,2] = {{1,2},{3,4}};
	
	function f
		input Real a[:,:];
		input Real b[size(a,2),:];
		output Real o[size(a,1),size(b,2)];
	algorithm
		o := a * b;
	end f;

	Real x1[2,2] = f(a,a);
	
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FunctionCallEquation5",
            description="Tests evaluation of matrix multiplication in function.",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.FunctionCallEquation5
 constant Real a[1,1] = 1;
 constant Real a[1,2] = 2;
 constant Real a[2,1] = 3;
 constant Real a[2,2] = 4;
 constant Real x1[1,1] = 7.0;
 constant Real x1[1,2] = 10.0;
 constant Real x1[2,1] = 15.0;
 constant Real x1[2,2] = 22.0;
end VariabilityPropagationTests.FunctionCallEquation5;
")})));
end FunctionCallEquation5;

model Algorithm1
    parameter Real p;
    Real y;
algorithm
    y := p;
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="Algorithm1",
            description="",
            flatModel="
fclass VariabilityPropagationTests.Algorithm1
 parameter Real p;
 parameter Real y;
parameter equation
 algorithm
  y := p;
;
end VariabilityPropagationTests.Algorithm1;
")})));
end Algorithm1;

model Algorithm2
    parameter Real p;
    Real y;
algorithm
    y := p + time;
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="Algorithm2",
            description="",
            flatModel="
fclass VariabilityPropagationTests.Algorithm2
 parameter Real p;
 Real y;
algorithm
 y := p + time;
end VariabilityPropagationTests.Algorithm2;
")})));
end Algorithm2;

model Algorithm3
    parameter Real p;
    Real x;
    Real y;
algorithm
    y := x;
equation
    x = p;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="Algorithm3",
            description="",
            flatModel="
fclass VariabilityPropagationTests.Algorithm3
 parameter Real p;
 parameter Real x;
 parameter Real y;
parameter equation
 x = p;
 algorithm
  y := x;
;
end VariabilityPropagationTests.Algorithm3;
")})));
end Algorithm3;

model Algorithm4
    parameter Real p;
    Real x;
    Real y;
algorithm
    x := p;
    y := x;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="Algorithm4",
            description="",
            flatModel="
fclass VariabilityPropagationTests.Algorithm4
 parameter Real p;
 parameter Real x;
 parameter Real y;
parameter equation
 algorithm
  x := p;
  y := x;
;
end VariabilityPropagationTests.Algorithm4;
")})));
end Algorithm4;

model Algorithm5
    parameter Real p;
    Real x;
    Real y;
algorithm
    x := p;
    y := x;

    annotation(__JModelica(UnitTesting(tests={
        CCodeGenTestCase(
            name="Algorithm5",
            description="Parameter algorithm code generation",
            template="
$C_set_start_values$
$C_DAE_initial_dependent_parameter_assignments$
",
            generatedCode="
int jmi_set_start_values_0_0(jmi_t* jmi) {
    int ef = 0;
    JMI_DYNAMIC_INIT()
    JMI_DYNAMIC_FREE()
    return ef;
}

int jmi_set_start_values_0_0(jmi_t* jmi);


int jmi_set_start_values_base(jmi_t* jmi) {
    int ef = 0;
    JMI_DYNAMIC_INIT()
    ef |= jmi_set_start_values_0_0(jmi);
    model_init_eval_parameters(jmi);
    JMI_DYNAMIC_FREE()
    return ef;
}


int model_init_eval_parameters_base(jmi_t* jmi) {
    int ef = 0;
    JMI_DYNAMIC_INIT()
    _x_1 = _p_0;
    _y_2 = _x_1;
    JMI_DYNAMIC_FREE()
    return ef;
}
")})));
end Algorithm5;

    function fp
        input Real i1;
        input Real i2;
        output Real o1 = i1;
        output Real o2 = i2;
    algorithm
    end fp;

model FunctionCallEquationPartial1
    Real x1,x2;
  equation
    (x1,x2) = fp(time,7);
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FunctionCallEquationPartial1",
            description="Tests evaluation of matrix multiplication in function.",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.FunctionCallEquationPartial1
 Real x1;
 constant Real x2 = 7;
equation
 (x1, ) = VariabilityPropagationTests.fp(time, 7);

public
 function VariabilityPropagationTests.fp
  input Real i1;
  input Real i2;
  output Real o1;
  output Real o2;
 algorithm
  o1 := i1;
  o2 := i2;
  return;
 end VariabilityPropagationTests.fp;

end VariabilityPropagationTests.FunctionCallEquationPartial1;
")})));
end FunctionCallEquationPartial1;

model FunctionCallEquationPartial2
    Real x1,x2,x3;
  equation
    x3 = 7;
    (x1,x2) = fp(time,x3);
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FunctionCallEquationPartial2",
            description="Tests evaluation of matrix multiplication in function.",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.FunctionCallEquationPartial2
 Real x1;
 constant Real x2 = 7.0;
 constant Real x3 = 7;
equation
 (x1, ) = VariabilityPropagationTests.fp(time, 7.0);

public
 function VariabilityPropagationTests.fp
  input Real i1;
  input Real i2;
  output Real o1;
  output Real o2;
 algorithm
  o1 := i1;
  o2 := i2;
  return;
 end VariabilityPropagationTests.fp;

end VariabilityPropagationTests.FunctionCallEquationPartial2;
")})));
end FunctionCallEquationPartial2;

model FunctionCallEquationPartial3
    Real x1,x2,x3;
  equation
    (x1,x2) = fp(time,x3);
    x3 = 7;
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FunctionCallEquationPartial3",
            description="Tests evaluation of matrix multiplication in function.",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.FunctionCallEquationPartial3
 Real x1;
 constant Real x2 = 7.0;
 constant Real x3 = 7;
equation
 (x1, ) = VariabilityPropagationTests.fp(time, 7.0);

public
 function VariabilityPropagationTests.fp
  input Real i1;
  input Real i2;
  output Real o1;
  output Real o2;
 algorithm
  o1 := i1;
  o2 := i2;
  return;
 end VariabilityPropagationTests.fp;

end VariabilityPropagationTests.FunctionCallEquationPartial3;
")})));
end FunctionCallEquationPartial3;

model FunctionCallEquationPartial4
    Real x1,x2,x3,x4,x5;
  equation
    (x1,x2) = fp(x4,x5);
    (x3,x4) = fp(x1,x2);
    x5 = 7;
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FunctionCallEquationPartial4",
            description="Tests evaluation of matrix multiplication in function.",
            inline_functions="none",
            eliminate_alias_variables=false,
            flatModel="
fclass VariabilityPropagationTests.FunctionCallEquationPartial4
 constant Real x1 = 7.0;
 constant Real x2 = 7.0;
 constant Real x3 = 7.0;
 constant Real x4 = 7.0;
 constant Real x5 = 7;
end VariabilityPropagationTests.FunctionCallEquationPartial4;
")})));
end FunctionCallEquationPartial4;

model FunctionCallEquationPartial5
    function fp
        input Real i1;
        input Real i2;
        input Real i3;
        input Real i4 = 13;
        output Real o1 = i1;
        output Real o2 = i2;
        output Real o3 = i3;
        output Real o4 = i4;
    algorithm
    end fp;
    Real x1,x2,x3,x4,x5,x6;
  equation
    (x1,x2,x3) = fp(x4, x5, x6);
    x4 = 3;
    x5 = x4 + x1;
    x6 = x4 + x1 + x2;
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FunctionCallEquationPartial5",
            description="Tests evaluation of matrix multiplication in function.",
            eliminate_alias_variables=false,
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.FunctionCallEquationPartial5
 constant Real x1 = 3.0;
 constant Real x2 = 6.0;
 constant Real x3 = 12.0;
 constant Real x4 = 3;
 constant Real x5 = 6.0;
 constant Real x6 = 12.0;
end VariabilityPropagationTests.FunctionCallEquationPartial5;
")})));
end FunctionCallEquationPartial5;

model FunctionCallEquationPartial6
    Real x1,x2;
    parameter Real x3;
    Real x4;
  equation
    (x1,x2) = fp(x3,x4);
    x4 = 7;
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FunctionCallEquationPartial6",
            description="Tests evaluation of matrix multiplication in function.",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.FunctionCallEquationPartial6
 parameter Real x1;
 constant Real x2 = 7.0;
 parameter Real x3;
 constant Real x4 = 7;
parameter equation
 (x1, ) = VariabilityPropagationTests.fp(x3, 7.0);

public
 function VariabilityPropagationTests.fp
  input Real i1;
  input Real i2;
  output Real o1;
  output Real o2;
 algorithm
  o1 := i1;
  o2 := i2;
  return;
 end VariabilityPropagationTests.fp;

end VariabilityPropagationTests.FunctionCallEquationPartial6;
")})));
end FunctionCallEquationPartial6;

model FunctionCallEquationPartial7
    function fp
        input Real i1;
        input Real i2;
        output Real o1 = i1;
        output Real o2 = i2;
        output Real o3 = i1;
    algorithm
    end fp;
    
    Real x1,x2,x3,x4,x5,c;
    parameter Real p;
  equation
    (x3,x4,x5) = fp(x1,x2);
    (x1,x2) = fp(p,c);
    c = 7;
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FunctionCallEquationPartial7",
            description="Tests evaluation of matrix multiplication in function.",
            inline_functions="none",
            eliminate_alias_variables=false,
            flatModel="
fclass VariabilityPropagationTests.FunctionCallEquationPartial7
 parameter Real x1;
 constant Real x2 = 7.0;
 parameter Real x3;
 constant Real x4 = 7.0;
 parameter Real x5;
 constant Real c = 7;
 parameter Real p;
parameter equation
 (x1, ) = VariabilityPropagationTests.FunctionCallEquationPartial7.fp(p, 7.0);
 (x3, , x5) = VariabilityPropagationTests.FunctionCallEquationPartial7.fp(x1, 7.0);

public
 function VariabilityPropagationTests.FunctionCallEquationPartial7.fp
  input Real i1;
  input Real i2;
  output Real o1;
  output Real o2;
  output Real o3;
 algorithm
  o1 := i1;
  o2 := i2;
  o3 := i1;
  return;
 end VariabilityPropagationTests.FunctionCallEquationPartial7.fp;

end VariabilityPropagationTests.FunctionCallEquationPartial7;
")})));
end FunctionCallEquationPartial7;

model FunctionCallEquationPartial8
    function f
        input Real[:] x;
        input Boolean b;
        output Real[:] y = x;
    algorithm
        y := g(y);
        y := u(y);
        annotation(Inline=false);
    end f;
    
    function g
        input Real[:] x;
        output Real[size(x,1)] y;
    external;
    end g;
    
    function u
        input Real[:] x;
        output Real[size(x,1)] y = x;
    algorithm
    end u;
    Real[:] y = f({time,time},true);
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FunctionCallEquationPartial8",
            description="",
            flatModel="
fclass VariabilityPropagationTests.FunctionCallEquationPartial8
 Real y[1];
 Real y[2];
equation
 ({y[1], y[2]}) = VariabilityPropagationTests.FunctionCallEquationPartial8.f({time, time}, true);

public
 function VariabilityPropagationTests.FunctionCallEquationPartial8.f
  input Real[:] x;
  input Boolean b;
  output Real[:] y;
 algorithm
  init y as Real[size(x, 1)];
  for i1 in 1:size(x, 1) loop
   y[i1] := x[i1];
  end for;
  (y) := VariabilityPropagationTests.FunctionCallEquationPartial8.g(y);
  (y) := VariabilityPropagationTests.FunctionCallEquationPartial8.u(y);
  return;
 annotation(Inline = false);
 end VariabilityPropagationTests.FunctionCallEquationPartial8.f;

 function VariabilityPropagationTests.FunctionCallEquationPartial8.g
  input Real[:] x;
  output Real[:] y;
 algorithm
  init y as Real[size(x, 1)];
  external \"C\" g(x, size(x, 1), y, size(y, 1));
  return;
 end VariabilityPropagationTests.FunctionCallEquationPartial8.g;

 function VariabilityPropagationTests.FunctionCallEquationPartial8.u
  input Real[:] x;
  output Real[:] y;
 algorithm
  init y as Real[size(x, 1)];
  for i1 in 1:size(x, 1) loop
   y[i1] := x[i1];
  end for;
  return;
 end VariabilityPropagationTests.FunctionCallEquationPartial8.u;

end VariabilityPropagationTests.FunctionCallEquationPartial8;
")})));
end FunctionCallEquationPartial8;

model FunctionCallEquationPartial9
        function f
            input Real x1;
            input Integer n;
            output Real[n] y;
        algorithm
            y := {x1,x1};
            assert(x1==1,"nope");
        end f;
    
        function g
            input Real x1;
            input Real x2;
            input Integer n;
            output Real[n] y;
        algorithm
            if x1 < x2 then
                y := f(x1,n);
            else
                y := {1,2};
            end if;
        end g;
    
        Real[:] y = g(2,time,2);
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FunctionCallEquationPartial9",
            description="Bug when returning cloned CValueUnknown",
            flatModel="
fclass VariabilityPropagationTests.FunctionCallEquationPartial9
 Real y[1];
 Real y[2];
equation
 ({y[1], y[2]}) = VariabilityPropagationTests.FunctionCallEquationPartial9.g(2, time, 2);

public
 function VariabilityPropagationTests.FunctionCallEquationPartial9.g
  input Real x1;
  input Real x2;
  input Integer n;
  output Real[:] y;
  Integer[:] temp_1;
 algorithm
  init y as Real[n];
  if x1 < x2 then
   (y) := VariabilityPropagationTests.FunctionCallEquationPartial9.f(x1, n);
  else
   assert(n == 2, \"Mismatching sizes in VariabilityPropagationTests.FunctionCallEquationPartial9.g\");
   init temp_1 as Integer[2];
   temp_1[1] := 1;
   temp_1[2] := 2;
   for i1 in 1:2 loop
    y[i1] := temp_1[i1];
   end for;
  end if;
  return;
 end VariabilityPropagationTests.FunctionCallEquationPartial9.g;

 function VariabilityPropagationTests.FunctionCallEquationPartial9.f
  input Real x1;
  input Integer n;
  output Real[:] y;
  Real[:] temp_1;
 algorithm
  init y as Real[n];
  assert(n == 2, \"Mismatching sizes in VariabilityPropagationTests.FunctionCallEquationPartial9.f\");
  init temp_1 as Real[2];
  temp_1[1] := x1;
  temp_1[2] := x1;
  for i1 in 1:2 loop
   y[i1] := temp_1[i1];
  end for;
  assert(x1 == 1, \"nope\");
  return;
 end VariabilityPropagationTests.FunctionCallEquationPartial9.f;

end VariabilityPropagationTests.FunctionCallEquationPartial9;
")})));
end FunctionCallEquationPartial9;

    model PartiallyKnownComposite1
        function f
            input Real x1;
            input Real x2;
            output Real[2] y;
          algorithm
            y[1] := x1;
            y[2] := x2;
        end f;
        Real[2] y = f(2,time);

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="PartiallyKnownComposite1",
            description="Partially propagated array",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.PartiallyKnownComposite1
 constant Real y[1] = 2;
 Real y[2];
equation
 ({, y[2]}) = VariabilityPropagationTests.PartiallyKnownComposite1.f(2, time);

public
 function VariabilityPropagationTests.PartiallyKnownComposite1.f
  input Real x1;
  input Real x2;
  output Real[:] y;
 algorithm
  init y as Real[2];
  y[1] := x1;
  y[2] := x2;
  return;
 end VariabilityPropagationTests.PartiallyKnownComposite1.f;

end VariabilityPropagationTests.PartiallyKnownComposite1;
")})));
    end PartiallyKnownComposite1;
    
    model PartiallyKnownComposite2
        record R
            Real a;
            Real b;
        end R;
        function f
            input Real x1;
            input Real x2;
            output R y;
          algorithm
            y.a := x1;
            y.b := x2;
        end f;
        R y = f(2,time);

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="PartiallyKnownComposite2",
            description="Partially propagated record",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.PartiallyKnownComposite2
 constant Real y.a = 2;
 Real y.b;
equation
 (VariabilityPropagationTests.PartiallyKnownComposite2.R(, y.b)) = VariabilityPropagationTests.PartiallyKnownComposite2.f(2, time);

public
 function VariabilityPropagationTests.PartiallyKnownComposite2.f
  input Real x1;
  input Real x2;
  output VariabilityPropagationTests.PartiallyKnownComposite2.R y;
 algorithm
  y.a := x1;
  y.b := x2;
  return;
 end VariabilityPropagationTests.PartiallyKnownComposite2.f;

 record VariabilityPropagationTests.PartiallyKnownComposite2.R
  Real a;
  Real b;
 end VariabilityPropagationTests.PartiallyKnownComposite2.R;

end VariabilityPropagationTests.PartiallyKnownComposite2;
")})));
    end PartiallyKnownComposite2;
    
        model PartiallyKnownComposite3
        function f
            input Real x1;
            input Real x2;
            output Real[2] y;
          algorithm
            y[1] := x1;
            y[2] := x2;
        end f;
        parameter Real p = 2;
        Real[2] y = f(2,p);

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="PartiallyKnownComposite3",
            description="Partially propagated array, parameter",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.PartiallyKnownComposite3
 parameter Real p = 2 /* 2 */;
 constant Real y[1] = 2;
 parameter Real y[2];
parameter equation
 ({, y[2]}) = VariabilityPropagationTests.PartiallyKnownComposite3.f(2, p);

public
 function VariabilityPropagationTests.PartiallyKnownComposite3.f
  input Real x1;
  input Real x2;
  output Real[:] y;
 algorithm
  init y as Real[2];
  y[1] := x1;
  y[2] := x2;
  return;
 end VariabilityPropagationTests.PartiallyKnownComposite3.f;

end VariabilityPropagationTests.PartiallyKnownComposite3;
")})));
    end PartiallyKnownComposite3;
    
    model PartiallyKnownComposite4
        record R
            Real a;
            Real b;
        end R;
        function f
            input Real x1;
            input Real x2;
            output R y;
          algorithm
            y.a := x1;
            y.b := x2;
        end f;
        parameter Real p = 2;
        R y = f(2,p);

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="PartiallyKnownComposite4",
            description="Partially propagated record, parameter",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.PartiallyKnownComposite4
 parameter Real p = 2 /* 2 */;
 constant Real y.a = 2;
 parameter Real y.b;
parameter equation
 (VariabilityPropagationTests.PartiallyKnownComposite4.R(, y.b)) = VariabilityPropagationTests.PartiallyKnownComposite4.f(2, p);

public
 function VariabilityPropagationTests.PartiallyKnownComposite4.f
  input Real x1;
  input Real x2;
  output VariabilityPropagationTests.PartiallyKnownComposite4.R y;
 algorithm
  y.a := x1;
  y.b := x2;
  return;
 end VariabilityPropagationTests.PartiallyKnownComposite4.f;

 record VariabilityPropagationTests.PartiallyKnownComposite4.R
  Real a;
  Real b;
 end VariabilityPropagationTests.PartiallyKnownComposite4.R;

end VariabilityPropagationTests.PartiallyKnownComposite4;
")})));
    end PartiallyKnownComposite4;
    
        model PartiallyKnownComposite5
        function f
            input Integer n;
            input Real[n] x;
            output Real[n] y;
          algorithm
            y := x;
        end f;
        Real[4] y;
        Real[4] z;
      equation
        z[1:3] = y[2:4] .+ 1;
        y = f(4,z);
        z[4] = 3.14;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="PartiallyKnownComposite5",
            description="Repeatedly partially propagated array",
            eliminate_alias_variables=false,
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.PartiallyKnownComposite5
 constant Real y[1] = 6.140000000000001;
 constant Real y[2] = 5.140000000000001;
 constant Real y[3] = 4.140000000000001;
 constant Real y[4] = 3.14;
 constant Real z[1] = 6.140000000000001;
 constant Real z[2] = 5.140000000000001;
 constant Real z[3] = 4.140000000000001;
 constant Real z[4] = 3.14;
end VariabilityPropagationTests.PartiallyKnownComposite5;
")})));
    end PartiallyKnownComposite5;
    
    model PartiallyKnownComposite6
        function f
            input Real[:] x;
            input Integer n;
            output Real[size(x,1)] y;
          algorithm
            y := x;
        end f;
        Real[2] y = f({1,1-time}, 3);

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="PartiallyKnownComposite6",
            description="Test evaluation of known components in partially known composite arg. (array)",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.PartiallyKnownComposite6
 constant Real y[1] = 1;
 Real y[2];
equation
 ({, y[2]}) = VariabilityPropagationTests.PartiallyKnownComposite6.f({1, 1 - time}, 3);

public
 function VariabilityPropagationTests.PartiallyKnownComposite6.f
  input Real[:] x;
  input Integer n;
  output Real[:] y;
 algorithm
  init y as Real[size(x, 1)];
  for i1 in 1:size(x, 1) loop
   y[i1] := x[i1];
  end for;
  return;
 end VariabilityPropagationTests.PartiallyKnownComposite6.f;

end VariabilityPropagationTests.PartiallyKnownComposite6;
")})));
    end PartiallyKnownComposite6;
    
    model PartiallyKnownComposite7
        record R
            Real a;
            Real b;
        end R;
        function f
            input R x;
            input Integer n;
            output R y;
          algorithm
            y := x;
        end f;
        R y = f(R(1,1-time), 3);

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="PartiallyKnownComposite7",
            description="Test evaluation of known components in partially known composite arg. (record)",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.PartiallyKnownComposite7
 constant Real y.a = 1;
 Real y.b;
equation
 (VariabilityPropagationTests.PartiallyKnownComposite7.R(, y.b)) = VariabilityPropagationTests.PartiallyKnownComposite7.f(VariabilityPropagationTests.PartiallyKnownComposite7.R(1, 1 - time), 3);

public
 function VariabilityPropagationTests.PartiallyKnownComposite7.f
  input VariabilityPropagationTests.PartiallyKnownComposite7.R x;
  input Integer n;
  output VariabilityPropagationTests.PartiallyKnownComposite7.R y;
 algorithm
  y.a := x.a;
  y.b := x.b;
  return;
 end VariabilityPropagationTests.PartiallyKnownComposite7.f;

 record VariabilityPropagationTests.PartiallyKnownComposite7.R
  Real a;
  Real b;
 end VariabilityPropagationTests.PartiallyKnownComposite7.R;

end VariabilityPropagationTests.PartiallyKnownComposite7;
")})));
    end PartiallyKnownComposite7;
    
    model PartiallyKnownComposite8
        record R1
            R2 r2;
            Real y2;
        end R1;
        record R2
            Real[2] y1;
        end R2;
        function f
            input Real x1;
            input Real x2;
            output R1 r = R1(R2({x1,x1}),x2);
          algorithm
            annotation(Inline=false);
        end f;
        
        R1 r;
      equation
        r = f(1,time);

    annotation(__JModelica(UnitTesting(tests={
        CCodeGenTestCase(
            name="PartiallyKnownComposite8",
            description="Test cleanup of record/array outputs",
            inline_functions="none",
            eliminate_alias_constants=false,
            template="$C_ode_derivatives$",
            generatedCode="

int model_ode_derivatives_base(jmi_t* jmi) {
    int ef = 0;
    JMI_DYNAMIC_INIT()
    JMI_RECORD_STATIC(R1_1_r, tmp_1)
    JMI_RECORD_STATIC(R2_0_r, tmp_2)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_3, 2, 1)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_3, 2, 1, 2)
    tmp_2->y1 = tmp_3;
    tmp_1->r2 = tmp_2;
    func_VariabilityPropagationTests_PartiallyKnownComposite8_f_def0(AD_WRAP_LITERAL(1), _time, tmp_1);
    _r_y2_2 = (tmp_1->y2);
    JMI_DYNAMIC_FREE()
    return ef;
}
")})));
    end PartiallyKnownComposite8;
    
    model PartiallyKnownComposite9
        record R
            Real x,y,z;
        end R;
        function f1
            input Real x,y,z;
            output R r = R(x,y,z);
            algorithm
            annotation(Inline=false);
        end f1;
        function f2
            input R r;
            output Real x = r.x;
            output Real y = r.y;
            algorithm
            annotation(Inline=true);
        end f2;
        
        Real x,y;
    equation
        (x,y) = f2(f1(3,time,time));

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="PartiallyKnownComposite9",
            description="Test propagation to FNoExp in lhs",
            flatModel="
fclass VariabilityPropagationTests.PartiallyKnownComposite9
 constant Real x = 3;
 Real y;
equation
 (VariabilityPropagationTests.PartiallyKnownComposite9.R(, y, )) = VariabilityPropagationTests.PartiallyKnownComposite9.f1(3, time, time);

public
 function VariabilityPropagationTests.PartiallyKnownComposite9.f1
  input Real x;
  input Real y;
  input Real z;
  output VariabilityPropagationTests.PartiallyKnownComposite9.R r;
 algorithm
  r.x := x;
  r.y := y;
  r.z := z;
  return;
 annotation(Inline = false);
 end VariabilityPropagationTests.PartiallyKnownComposite9.f1;

 record VariabilityPropagationTests.PartiallyKnownComposite9.R
  Real x;
  Real y;
  Real z;
 end VariabilityPropagationTests.PartiallyKnownComposite9.R;

end VariabilityPropagationTests.PartiallyKnownComposite9;
")})));
    end PartiallyKnownComposite9;

    model PartiallyKnownComposite10
        record R
            Real x,y,z;
        end R;
        function f1
            input Real x;
            output Real[:,:] r = {{x,x},{x,x}};
            algorithm
            annotation(Inline=false);
        end f1;
        function f2
            input Real[:,:] r;
            output Real[:] y = r[1,:];
            algorithm
            annotation(Inline=true);
        end f2;
        
        Real[:] x = f2(f1(time));

    annotation(__JModelica(UnitTesting(tests={
        CCodeGenTestCase(
            name="PartiallyKnownComposite10",
            description="Test cleanup of record/array outputs",
            template="$C_ode_derivatives$",
            generatedCode="

int model_ode_derivatives_base(jmi_t* jmi) {
    int ef = 0;
    JMI_DYNAMIC_INIT()
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_1, 4, 2)
    JMI_ARRAY_INIT_2(STAT, jmi_real_t, jmi_array_t, tmp_1, 4, 2, 2, 2)
    func_VariabilityPropagationTests_PartiallyKnownComposite10_f1_def0(_time, tmp_1);
    memcpy(&_x_1_0, &jmi_array_val_2(tmp_1, 1,1), 2 * sizeof(jmi_real_t));
    JMI_DYNAMIC_FREE()
    return ef;
}
")})));
    end PartiallyKnownComposite10;
    
    model PartiallyKnownComposite11
    record R
        Real x;
        Real[1] z;
    end R;
    
    function f
        input Real x;
        input Real y;
        output R r = R(x, {y});
        algorithm
        annotation(Inline=false);
    end f;
    
    R r;
  equation
    r = f(time, 3);

    annotation(__JModelica(UnitTesting(tests={
        CCodeGenTestCase(
            name="PartiallyKnownComposite11",
            description="Test cleanup of record/array outputs",
            template="$C_ode_derivatives$",
            generatedCode="

int model_ode_derivatives_base(jmi_t* jmi) {
    int ef = 0;
    JMI_DYNAMIC_INIT()
    JMI_RECORD_STATIC(R_0_r, tmp_1)
    JMI_ARR(STAT, jmi_real_t, jmi_array_t, tmp_2, 1, 1)
    JMI_ARRAY_INIT_1(STAT, jmi_real_t, jmi_array_t, tmp_2, 1, 1, 1)
    tmp_1->z = tmp_2;
    func_VariabilityPropagationTests_PartiallyKnownComposite11_f_def0(_time, AD_WRAP_LITERAL(3), tmp_1);
    _r_x_0 = (tmp_1->x);
    JMI_DYNAMIC_FREE()
    return ef;
}
")})));
    end PartiallyKnownComposite11;
    
    model PartiallyKnownComposite12
       function e
           input Real x;
           output Real y;
           external;
       end e;
           
       function f
           input Real x1,x2;
           output Real y1,y2;
       algorithm
           y2 := e(x2);
           y1 := x1;
           annotation(Inline=false);
       end f;
    
        Real y1,y2,y3;
    equation
        (y1,y2) = f(1,y3);
        y3 = 3;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="PartiallyKnownComposite12",
            description="Failing on second evaluation of constant function",
            flatModel="
fclass VariabilityPropagationTests.PartiallyKnownComposite12
 constant Real y1 = 1;
 parameter Real y2;
 constant Real y3 = 3;
parameter equation
 (, y2) = VariabilityPropagationTests.PartiallyKnownComposite12.f(1, 3.0);

public
 function VariabilityPropagationTests.PartiallyKnownComposite12.f
  input Real x1;
  input Real x2;
  output Real y1;
  output Real y2;
 algorithm
  y2 := VariabilityPropagationTests.PartiallyKnownComposite12.e(x2);
  y1 := x1;
  return;
 annotation(Inline = false);
 end VariabilityPropagationTests.PartiallyKnownComposite12.f;

 function VariabilityPropagationTests.PartiallyKnownComposite12.e
  input Real x;
  output Real y;
 algorithm
  external \"C\" y = e(x);
  return;
 end VariabilityPropagationTests.PartiallyKnownComposite12.e;

end VariabilityPropagationTests.PartiallyKnownComposite12;
")})));
    end PartiallyKnownComposite12;

model ConstantRecord1
	record A
		Real a[:];
		Real b;
	end A;

	A c = A({1, 2, 3}, 4);

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ConstantRecord1",
            description="Tests propagation of a constant record.",
            flatModel="
fclass VariabilityPropagationTests.ConstantRecord1
 constant Real c.a[1] = 1;
 constant Real c.a[2] = 2;
 constant Real c.a[3] = 3;
 constant Real c.b = 4;
end VariabilityPropagationTests.ConstantRecord1;
")})));
end ConstantRecord1;


model ConstantStartFunc1
	function f
		output Real o[2] = {1, 2};
	algorithm
	end f;
	
	Real x[2](start = f()) = {3,4};

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ConstantStartFunc1",
            description="Tests that a constant right hand in a function call equation is not folded. It should only be propagated.",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.ConstantStartFunc1
 constant Real x[1](start = temp_1[1]) = 3;
 constant Real x[2](start = temp_1[2]) = 4;
 parameter Real temp_1[1];
 parameter Real temp_1[2];
parameter equation
 ({temp_1[1], temp_1[2]}) = VariabilityPropagationTests.ConstantStartFunc1.f();

public
 function VariabilityPropagationTests.ConstantStartFunc1.f
  output Real[:] o;
 algorithm
  init o as Real[2];
  o[1] := 1;
  o[2] := 2;
  return;
 end VariabilityPropagationTests.ConstantStartFunc1.f;

end VariabilityPropagationTests.ConstantStartFunc1;
")})));
end ConstantStartFunc1;

model InitialEquation1
    parameter Boolean c = false;
    Boolean b = c;
initial equation
    pre(b) = false;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="InitialEquation1",
            description="Tests that corresponding initial equations are removed",
            flatModel="
fclass VariabilityPropagationTests.InitialEquation1
 parameter Boolean c = false /* false */;
 parameter Boolean b;
parameter equation
 b = c;
end VariabilityPropagationTests.InitialEquation1;
")})));
end InitialEquation1;

model InitialEquation2
    Real x(fixed=false,start=3.14);
	Real y;
	parameter Real p1 = 1;
equation
	x = y + 1;
	y = p1 + 1;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="InitialEquation2",
            description="Check fixed=true",
            flatModel="
fclass VariabilityPropagationTests.InitialEquation2
 parameter Real y;
 parameter Real x(fixed = true,start = 3.14);
 parameter Real p1 = 1 /* 1 */;
parameter equation
 y = p1 + 1;
 x = y + 1;
end VariabilityPropagationTests.InitialEquation2;
")})));
end InitialEquation2;

model InitialEquation3
    Real x;
    parameter Real p1 = 3;
    Real p2 = p1;
initial equation
    x = p2;
equation
    when time > 1 then
        x = time;
    end when;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="InitialEquation3",
            description="Test no propagation of initial equations",
            flatModel="
fclass VariabilityPropagationTests.InitialEquation3
 discrete Real x;
 parameter Real p1 = 3 /* 3 */;
 parameter Real p2;
 discrete Boolean temp_1;
initial equation 
 x = p2;
 pre(temp_1) = false;
parameter equation
 p2 = p1;
equation
 temp_1 = time > 1;
 x = if temp_1 and not pre(temp_1) then time else pre(x);
end VariabilityPropagationTests.InitialEquation3;
")})));
end InitialEquation3;

model AliasVariabilities1
	Real a,b,c,d;
	parameter Real p1,p2;
	constant Real c1 = 1;
	constant Real c2 = 2;
equation
	a = b;
	b = p1 + p2;
	c = d;
	d = c1 + c2;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AliasVariabilities1",
			description="Check that aliases are handled correctly",
            eliminate_alias_constants=false,
			flatModel="
fclass VariabilityPropagationTests.AliasVariabilities1
 parameter Real a;
 constant Real c = 3.0;
 parameter Real p1;
 parameter Real p2;
 constant Real c1 = 1;
 constant Real c2 = 2;
 parameter Real b;
 constant Real d = 3.0;
parameter equation
 a = p1 + p2;
 b = a;
end VariabilityPropagationTests.AliasVariabilities1;
			
"),
		XMLCodeGenTestCase(
			name="AliasVariabilities1XML",
			description="Check that aliases are handled correctly",
			generate_fmi_me_xml=false,
			eliminate_alias_constants=false,
			template="$XML_variables$",
			generatedCode="
		<ScalarVariable name=\"a\" valueReference=\"6\" variability=\"parameter\" causality=\"internal\" alias=\"noAlias\">
			<Real relativeQuantity=\"false\" />
			<isLinear>true</isLinear>
			<VariableCategory>dependentParameter</VariableCategory>
		</ScalarVariable>
		<ScalarVariable name=\"b\" valueReference=\"7\" variability=\"parameter\" causality=\"internal\" alias=\"noAlias\">
			<Real relativeQuantity=\"false\" />
			<isLinear>true</isLinear>
			<VariableCategory>dependentParameter</VariableCategory>
		</ScalarVariable>
		<ScalarVariable name=\"c\" valueReference=\"0\" variability=\"constant\" causality=\"internal\" alias=\"noAlias\">
			<Real relativeQuantity=\"false\" start=\"3.0\" />
			<isLinear>true</isLinear>
			<VariableCategory>independentConstant</VariableCategory>
		</ScalarVariable>
		<ScalarVariable name=\"c1\" valueReference=\"1\" variability=\"constant\" causality=\"internal\" alias=\"noAlias\">
			<Real relativeQuantity=\"false\" start=\"1.0\" />
			<isLinear>true</isLinear>
			<VariableCategory>independentConstant</VariableCategory>
		</ScalarVariable>
		<ScalarVariable name=\"c2\" valueReference=\"2\" variability=\"constant\" causality=\"internal\" alias=\"noAlias\">
			<Real relativeQuantity=\"false\" start=\"2.0\" />
			<isLinear>true</isLinear>
			<VariableCategory>independentConstant</VariableCategory>
		</ScalarVariable>
		<ScalarVariable name=\"d\" valueReference=\"3\" variability=\"constant\" causality=\"internal\" alias=\"noAlias\">
			<Real relativeQuantity=\"false\" start=\"3.0\" />
			<isLinear>true</isLinear>
			<VariableCategory>independentConstant</VariableCategory>
		</ScalarVariable>
		<ScalarVariable name=\"p1\" valueReference=\"4\" variability=\"parameter\" causality=\"internal\" alias=\"noAlias\">
			<Real relativeQuantity=\"false\" />
			<isLinear>true</isLinear>
			<VariableCategory>independentParameter</VariableCategory>
		</ScalarVariable>
		<ScalarVariable name=\"p2\" valueReference=\"5\" variability=\"parameter\" causality=\"internal\" alias=\"noAlias\">
			<Real relativeQuantity=\"false\" />
			<isLinear>true</isLinear>
			<VariableCategory>independentParameter</VariableCategory>
		</ScalarVariable>
")})));
end AliasVariabilities1;

model StructParam1
    record R
        Real a,b;
    end R;
    function f
        output R r;
      algorithm
        r.a := 1;
    end f;
    function f2
        input R r;
        output Real a = r.a;
      algorithm
    end f2;
    parameter R r = f() annotation(Evaluate=true);
    Real a;
  equation
    a = f2(r);
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="StructParam1",
            description="Test propagation of structural parameters",
            flatModel="
fclass VariabilityPropagationTests.StructParam1
 eval parameter Real r.b = 0.0 /* 0.0 */;
 constant Real a = 1;
end VariabilityPropagationTests.StructParam1;
")})));
end StructParam1;

model ZeroFactor1
    Real c = 0;
    Real x1 = c * time;
    Real x2 = time * c;
    Real x3 = c / time;
    Real x4 = time / c;
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ZeroFactor1",
            description="Test elimination of factors that can be reduced to zero.",
            eliminate_alias_variables=false,
            flatModel="
fclass VariabilityPropagationTests.ZeroFactor1
 constant Real c = 0;
 constant Real x1 = 0.0;
 constant Real x2 = 0.0;
 constant Real x3 = 0.0;
 Real x4;
equation
 x4 = time / 0.0;
end VariabilityPropagationTests.ZeroFactor1;
")})));
end ZeroFactor1;

model ZeroFactor2
    Real c = 0;
    Real z = time;
    Real x1 = c * z + z;
    Real x2 = z * c + z;
    Real x3 = c / z + z;
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ZeroFactor2",
            description="Test elimination of factors that can be reduced to zero.",
            flatModel="
fclass VariabilityPropagationTests.ZeroFactor2
 constant Real c = 0;
 Real x1;
equation
 x1 = time;
end VariabilityPropagationTests.ZeroFactor2;
")})));
end ZeroFactor2;

model ZeroFactor3
    Real c = 0;
    Real z1 = time;
    Real z2 = time;
    Real z3 = time;
    Real x1 = z1 * (z2 * (z3 * c));
    Real x2 = ((c / z1) / z2) / z3;
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ZeroFactor3",
            description="Test elimination of factors that can be reduced to zero.",
            eliminate_alias_variables=false,
            eliminate_linear_equations=false,
            flatModel="
fclass VariabilityPropagationTests.ZeroFactor3
 constant Real c = 0;
 Real z1;
 Real z2;
 Real z3;
 constant Real x1 = 0.0;
 constant Real x2 = 0.0;
equation
 z1 = time;
 z2 = time;
 z3 = time;
end VariabilityPropagationTests.ZeroFactor3;
")})));
end ZeroFactor3;

model FixedFalse1
    parameter Real p1(fixed=false);
    Real p2 = p1 + 1;
initial equation
    p1 = 23;
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FixedFalse1",
            description="Test propagation of fixed false parameters",
            flatModel="
fclass VariabilityPropagationTests.FixedFalse1
 initial parameter Real p1(fixed = false);
 initial parameter Real p2;
initial equation 
 p1 = 23;
 p2 = p1 + 1;
end VariabilityPropagationTests.FixedFalse1;
")})));
end FixedFalse1;

model FixedFalse2

    function f
        input Real x;
        output Real y2 = x;
        output Real y3 = x;
        algorithm
    end f;

    parameter Real p1(fixed=false);
    Real p2;
    Real p3;
initial equation
    p1 = 23;
equation
    (p2,p3) = f(p1);
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FixedFalse2",
            inline_functions="none",
            description="Test propagation of fixed false parameters, function call equation",
            flatModel="
fclass VariabilityPropagationTests.FixedFalse2
 initial parameter Real p1(fixed = false);
 initial parameter Real p2;
 initial parameter Real p3;
initial equation 
 p1 = 23;
 (p2, p3) = VariabilityPropagationTests.FixedFalse2.f(p1);

public
 function VariabilityPropagationTests.FixedFalse2.f
  input Real x;
  output Real y2;
  output Real y3;
 algorithm
  y2 := x;
  y3 := x;
  return;
 end VariabilityPropagationTests.FixedFalse2.f;

end VariabilityPropagationTests.FixedFalse2;
")})));
end FixedFalse2;

model FixedFalse3
    parameter Real p1(fixed=false);
    discrete Real p2 = p1 + 1;
initial equation
    p1 = 23;
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FixedFalse3",
            description="Test propagation of fixed false parameters, originally discrete",
            flatModel="
fclass VariabilityPropagationTests.FixedFalse3
 initial parameter Real p1(fixed = false);
 initial parameter Real p2;
initial equation 
 p1 = 23;
 p2 = p1 + 1;
end VariabilityPropagationTests.FixedFalse3;
")})));
end FixedFalse3;

model FixedFalse4
    parameter Real p1(fixed=false);
    Real p2 = p1 + 1;
    Real p3 = p2 + 1;
initial equation
    p1 = 23;
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FixedFalse4",
            description="Test propagation of fixed false parameters, chained",
            flatModel="
fclass VariabilityPropagationTests.FixedFalse4
 initial parameter Real p1(fixed = false);
 initial parameter Real p2;
 initial parameter Real p3;
initial equation 
 p1 = 23;
 p2 = p1 + 1;
 p3 = p2 + 1;
end VariabilityPropagationTests.FixedFalse4;
")})));
end FixedFalse4;

model FixedFalse5
    parameter Real p1(fixed=false);
    Real p2 = p1 + 1;
    Real p3 = p2;
initial equation
    p1 = p2 * 23;
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FixedFalse5",
            description="Test propagation of fixed false parameters, alias",
            flatModel="
fclass VariabilityPropagationTests.FixedFalse5
 initial parameter Real p1(fixed = false);
 initial parameter Real p3;
 initial parameter Real p2;
initial equation 
 p1 = p3 * 23;
 p3 = p1 + 1;
 p2 = p3;
end VariabilityPropagationTests.FixedFalse5;
")})));
end FixedFalse5;

model EvalFail1
    function f
        output Real y = 1;
    algorithm
        assert(false,"nope");
    end f;
    
    Real y = f();
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="EvalFail1",
            description="Test parameter from constant on fail to evaluate",
            flatModel="
fclass VariabilityPropagationTests.EvalFail1
 parameter Real y;
parameter equation
 y = VariabilityPropagationTests.EvalFail1.f();

public
 function VariabilityPropagationTests.EvalFail1.f
  output Real y;
 algorithm
  y := 1;
  assert(false, \"nope\");
  return;
 end VariabilityPropagationTests.EvalFail1.f;

end VariabilityPropagationTests.EvalFail1;
")})));
end EvalFail1;

model EvalFail2
    function f
        output Real[1] y = {1};
    algorithm
        assert(false,"nope");
    end f;
    
    Real[:] y = f();
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="EvalFail2",
            description="Test parameter from constant on fail to evaluate",
            flatModel="
fclass VariabilityPropagationTests.EvalFail2
 parameter Real y[1];
parameter equation
 ({y[1]}) = VariabilityPropagationTests.EvalFail2.f();

public
 function VariabilityPropagationTests.EvalFail2.f
  output Real[:] y;
 algorithm
  init y as Real[1];
  y[1] := 1;
  assert(false, \"nope\");
  return;
 end VariabilityPropagationTests.EvalFail2.f;

end VariabilityPropagationTests.EvalFail2;
")})));
end EvalFail2;

model AlgebraicLoopParameter1
    parameter Real p = 1;
    Real zero = 0;
    Real x = p*y;
    Real y = zero * x + p;
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="AlgebraicLoopParameter1",
            description="Test evaluation of algebraic loop in propagated parameters",
            flatModel="
fclass VariabilityPropagationTests.AlgebraicLoopParameter1
 parameter Real p = 1 /* 1 */;
 constant Real zero = 0;
 parameter Real y;
 parameter Real x;
parameter equation
 y = p;
 x = p * y;
end VariabilityPropagationTests.AlgebraicLoopParameter1;
")})));
end AlgebraicLoopParameter1;

model AlgorithmFolding1
    function f
        input Real x;
        output Real y1 = x;
        output Real y2 = x;
        algorithm
    end f;
    Real y;
    Real x = 1;
    Real z;
    parameter Real p;
    Real a = p;
algorithm
    y := x;
    (y, ) := f(x);
    x := z + pre(p);
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="AlgorithmFolding1",
            description="Folding in algorithm",
            flatModel="
fclass VariabilityPropagationTests.AlgorithmFolding1
 Real y;
 constant Real x = 1;
 Real z;
 parameter Real p;
 parameter Real a;
parameter equation
 a = p;
algorithm
 y := 1.0;
 (y, ) := VariabilityPropagationTests.AlgorithmFolding1.f(1.0);
 x := z + p;

public
 function VariabilityPropagationTests.AlgorithmFolding1.f
  input Real x;
  output Real y1;
  output Real y2;
 algorithm
  y1 := x;
  y2 := x;
  return;
 end VariabilityPropagationTests.AlgorithmFolding1.f;

end VariabilityPropagationTests.AlgorithmFolding1;
")})));
end AlgorithmFolding1;


model KnownParameter1
    function f
        input Real x;
        output Real[1,1] y;
    algorithm
        y[1,1] := x + 1;
    end f;
    
    model C
        Real x = y;
        Real y(start = 1) = a[1];
        parameter Real a[1] = {1};
    end C;
    
    C c[1](a = f(b));
    final parameter Real b = 1;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="KnownParameter1",
            description="Test variability propagation for known parameter expressions",
            flatModel="
fclass VariabilityPropagationTests.KnownParameter1
 final parameter Real c[1].a[1](start = 1) = 2.0 /* 2.0 */;
 final parameter Real b = 1 /* 1 */;
end VariabilityPropagationTests.KnownParameter1;
")})));
end KnownParameter1;


model IfEquationTemp1
    function f
        input Real x;
        output Real[2] y = {x,x+1};
    algorithm
    end f;
    
    Real[:] y = if sum(f(time))>0 then f(1) else f(2);

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="IfEquationTemp1",
            description="",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.IfEquationTemp1
 Real y[1];
 Real y[2];
 Real temp_1[1];
 Real temp_1[2];
equation
 ({temp_1[1], temp_1[2]}) = VariabilityPropagationTests.IfEquationTemp1.f(time);
 y[1] = if temp_1[1] + temp_1[2] > 0 then 1.0 else 2.0;
 y[2] = if temp_1[1] + temp_1[2] > 0 then 2.0 else 3.0;

public
 function VariabilityPropagationTests.IfEquationTemp1.f
  input Real x;
  output Real[:] y;
 algorithm
  init y as Real[2];
  y[1] := x;
  y[2] := x + 1;
  return;
 end VariabilityPropagationTests.IfEquationTemp1.f;

end VariabilityPropagationTests.IfEquationTemp1;
")})));
end IfEquationTemp1;

model IfEquationTemp2
    function f
        input Real x;
        output Real[2] y = {x,x+1};
    algorithm
    end f;
    
    Real[:] y = if sum(f(time))>0 then f(c) else f(c+1);
    Real c = 1;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="IfEquationTemp2",
            description="",
            inline_functions="none",
            flatModel="
fclass VariabilityPropagationTests.IfEquationTemp2
 Real y[1];
 Real y[2];
 constant Real c = 1;
 Real temp_1[1];
 Real temp_1[2];
equation
 ({temp_1[1], temp_1[2]}) = VariabilityPropagationTests.IfEquationTemp2.f(time);
 y[1] = if temp_1[1] + temp_1[2] > 0 then 1.0 else 2.0;
 y[2] = if temp_1[1] + temp_1[2] > 0 then 2.0 else 3.0;

public
 function VariabilityPropagationTests.IfEquationTemp2.f
  input Real x;
  output Real[:] y;
 algorithm
  init y as Real[2];
  y[1] := x;
  y[2] := x + 1;
  return;
 end VariabilityPropagationTests.IfEquationTemp2.f;

end VariabilityPropagationTests.IfEquationTemp2;
")})));
end IfEquationTemp2;

model SmallConstant1
    Real x;
equation
    1e-17*x=1e-16;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="SmallConstant1",
            description="",
            inline_functions="none",
            tearing_division_tolerance=1e-15,
            flatModel="
fclass VariabilityPropagationTests.SmallConstant1
 constant Real x = 9.999999999999998;
end VariabilityPropagationTests.SmallConstant1;
")})));
end SmallConstant1;

model StringVariable1
    String s1,s2;
equation
    s1 = "1";
    s2 = s1 + "2";
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="StringVariable1",
            description="",
            flatModel="
fclass VariabilityPropagationTests.StringVariable1
 constant String s1 = \"1\";
 constant String s2 = \"12\";
end VariabilityPropagationTests.StringVariable1;
")})));
end StringVariable1;

model ExternalObjectConstant1
    model EO
        extends ExternalObject;
        function constructor
            input Real x;
            output EO eo;
            external;
        end constructor;
        function destructor
            input EO eo;
            external;
        end destructor;
    end EO;
    
    function f
        input EO x;
        output Real y;
        external;
    end f;
    
    constant Real x = 1;
    constant EO eo = EO(x);
    Real y = f(eo);

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ExternalObjectConstant1",
            description="",
            flatModel="
            
fclass VariabilityPropagationTests.ExternalObjectConstant1
 constant Real x = 1;
 parameter Real y;
package constant
 constant VariabilityPropagationTests.ExternalObjectConstant1.EO VariabilityPropagationTests.ExternalObjectConstant1.eo = VariabilityPropagationTests.ExternalObjectConstant1.EO.constructor(1.0);
parameter equation
 y = VariabilityPropagationTests.ExternalObjectConstant1.f(global(VariabilityPropagationTests.ExternalObjectConstant1.eo));

public
 function VariabilityPropagationTests.ExternalObjectConstant1.EO.destructor
  input VariabilityPropagationTests.ExternalObjectConstant1.EO eo;
 algorithm
  external \"C\" destructor(eo);
  return;
 end VariabilityPropagationTests.ExternalObjectConstant1.EO.destructor;

 function VariabilityPropagationTests.ExternalObjectConstant1.EO.constructor
  input Real x;
  output VariabilityPropagationTests.ExternalObjectConstant1.EO eo;
 algorithm
  external \"C\" eo = constructor(x);
  return;
 end VariabilityPropagationTests.ExternalObjectConstant1.EO.constructor;

 function VariabilityPropagationTests.ExternalObjectConstant1.f
  input VariabilityPropagationTests.ExternalObjectConstant1.EO x;
  output Real y;
 algorithm
  external \"C\" y = f(x);
  return;
 end VariabilityPropagationTests.ExternalObjectConstant1.f;

 type VariabilityPropagationTests.ExternalObjectConstant1.EO = ExternalObject;
end VariabilityPropagationTests.ExternalObjectConstant1;
")})));
end ExternalObjectConstant1;

model ExternalObjectConstant2
    model EO
        extends ExternalObject;
        function constructor
            input Real x;
            output EO eo;
            external;
        end constructor;
        function destructor
            input EO eo;
            external;
        end destructor;
    end EO;
    
    function f
        input EO x;
        output Real y;
        external;
    end f;
    
    function g
        input EO x;
        output EO y = x;
    algorithm
        annotation(Inline=false);
    end g;
    
    constant Real x = 1;
    constant EO eo = EO(x);
    Real y = f(g(eo));

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ExternalObjectConstant2",
            description="",
            flatModel="
fclass VariabilityPropagationTests.ExternalObjectConstant2
 constant Real x = 1;
 parameter Real y;
package constant
 constant VariabilityPropagationTests.ExternalObjectConstant2.EO VariabilityPropagationTests.ExternalObjectConstant2.eo = VariabilityPropagationTests.ExternalObjectConstant2.EO.constructor(1.0);
parameter equation
 y = VariabilityPropagationTests.ExternalObjectConstant2.f(VariabilityPropagationTests.ExternalObjectConstant2.g(global(VariabilityPropagationTests.ExternalObjectConstant2.eo)));

public
 function VariabilityPropagationTests.ExternalObjectConstant2.EO.destructor
  input VariabilityPropagationTests.ExternalObjectConstant2.EO eo;
 algorithm
  external \"C\" destructor(eo);
  return;
 end VariabilityPropagationTests.ExternalObjectConstant2.EO.destructor;

 function VariabilityPropagationTests.ExternalObjectConstant2.EO.constructor
  input Real x;
  output VariabilityPropagationTests.ExternalObjectConstant2.EO eo;
 algorithm
  external \"C\" eo = constructor(x);
  return;
 end VariabilityPropagationTests.ExternalObjectConstant2.EO.constructor;

 function VariabilityPropagationTests.ExternalObjectConstant2.f
  input VariabilityPropagationTests.ExternalObjectConstant2.EO x;
  output Real y;
 algorithm
  external \"C\" y = f(x);
  return;
 end VariabilityPropagationTests.ExternalObjectConstant2.f;

 function VariabilityPropagationTests.ExternalObjectConstant2.g
  input VariabilityPropagationTests.ExternalObjectConstant2.EO x;
  output VariabilityPropagationTests.ExternalObjectConstant2.EO y;
 algorithm
  y := x;
  return;
 annotation(Inline = false);
 end VariabilityPropagationTests.ExternalObjectConstant2.g;

 type VariabilityPropagationTests.ExternalObjectConstant2.EO = ExternalObject;
end VariabilityPropagationTests.ExternalObjectConstant2;
")})));
end ExternalObjectConstant2;


end VariabilityPropagationTests;
