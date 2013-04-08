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
			variability_propagation=true,
			flatModel="
fclass VariabilityPropagationTests.VariabilityInference
 constant Real x1 = 1;
 constant Boolean x2 = true;
 parameter Real p1 = 4 /* 4 */;
 parameter Real r2;
parameter equation
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
			variability_propagation=true,
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
			description="Tests if constant values inferred from 
			equations are moved to equations and folded.",
			variability_propagation=true,
			flatModel="
fclass VariabilityPropagationTests.ConstantFolding1
 constant Real x3 = 1;
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
			description="Tests folding of some more advanced expressions
			and some which shouldn't be folded.",
			variability_propagation=true,
			flatModel="
fclass VariabilityPropagationTests.ConstantFolding2
 input Real i;
 Real x;
 discrete Real y;
initial equation 
 pre(y) = 0.0;
equation
 x = VariabilityPropagationTests.ConstantFolding2.f(i, {{1, 1, 1}, {1, 1, 1}});
 when x > 1 then
  y = VariabilityPropagationTests.ConstantFolding2.f(i, fill(0, 0, 2));
 end when;

public
 function VariabilityPropagationTests.ConstantFolding2.f
  input Real ii;
  input Real[:, :] i;
  output Real o;
 algorithm
  o := i[1,1];
  return;
 end VariabilityPropagationTests.ConstantFolding2.f;
 
end VariabilityPropagationTests.ConstantFolding2;
")})));
end ConstantFolding2;

model NoExp
	Real x(start=.5);
equation
	x-0.1 = cos(x);
	
	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="NoExp",
			description="Tests that an equation with a single 
			variable but no solution is not changed.",
			variability_propagation=true,
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
			description="This tests that we do not 
			propagate variability to output variables",
			variability_propagation=true,
			flatModel="
fclass VariabilityPropagationTests.Output
  output Real x;
equation
  x = 5;
end VariabilityPropagationTests.Output;
")})));
end Output;


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
			description="Tests some propagation to and through 
			derivative expressions.",
			variability_propagation=true,
			flatModel="
fclass VariabilityPropagationTests.Der1
 constant Real x1 = 3;
 constant Real x2 = 0;
 Real x3;
 Real x4;
 constant Real x5 = 0;
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

model WhenEq1
	parameter Real p1 = 4;
	Real x1,x2;
equation
	when p1 > 3 then
		x1 = x2 + 1;
	end when;
	x2 = 3;
	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="WhenEq1",
			description="Tests that folding occurs,
			but not propagation, in when equations.",
			variability_propagation=true,
			flatModel="
fclass VariabilityPropagationTests.WhenEq1
 parameter Real p1 = 4 /* 4 */;
 discrete Real x1;
 constant Real x2 = 3;
initial equation
 pre(x1) = 0.0;
equation
 when p1 > 3 then
  x1 = 4.0;
 end when;
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
			description="",
			variability_propagation=true,
			flatModel="
fclass VariabilityPropagationTests.IfEq1
 constant Real p1 = 4;
 constant Real x1 = 3;
end VariabilityPropagationTests.IfEq1;
")})));
end IfEq1;

model IfEq2
	constant Real c1 = 4;
	parameter Real p1 = 1;
	Real x1,x2,x3;
equation
	if (x3 < c1) then
		x1 = 1;
		x2 = p1 + 1;
	else
		x1 = 2;
		x2 = 3;
	end if;
	x3 = 3;
	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IfEq2",
			description="",
			variability_propagation=true,
			flatModel="
fclass VariabilityPropagationTests.IfEq2
 constant Real c1 = 4;
 parameter Real p1 = 1 /* 1 */;
 constant Real x1 = 1;
 parameter Real x2;
 constant Real x3 = 3;
parameter equation
 x2 = p1 + 1;
end VariabilityPropagationTests.IfEq2;
")})));
end IfEq2;

model IfEq3
	constant Real c1 = 4;
	parameter Real p1 = 1;
	Real x1,x2;
equation
	if false then
		x1 = 1;
		x2 = p1;
	else
		x1 = p1;
		x2 = 3;
	end if;
	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IfEq3",
			description="",
			variability_propagation=true,
			flatModel="
fclass VariabilityPropagationTests.IfEq3
 constant Real c1 = 4;
 parameter Real p1 = 1 /* 1 */;
 constant Real x2 = 3;
end VariabilityPropagationTests.IfEq3;
")})));
end IfEq3;

model IfEq4
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
			name="IfEq4",
			description="",
			variability_propagation=true,
			flatModel="
fclass VariabilityPropagationTests.IfEq4
 constant Real c1 = 4;
 parameter Real p1 = 1 /* 1 */;
 constant Real x1 = 2;
 parameter Real x2;
 constant Real x3 = 3;
 constant Real x4 = 3;
parameter equation
 x2 = p1 + 2;
end VariabilityPropagationTests.IfEq4;
")})));
end IfEq4;

model FunctionCall1
	Real c_out;
    function f
        output Real c;
    algorithm
    	c := 1;
    end f;
equation
    c_out = f() * 5;
    annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="FunctionCall1",
			description="Tests a constant function call with 
			no parameters.",
			variability_propagation=true,
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
			description="Tests that variability is propagated through 
			function call equations with multiple destinations.",
			variability_propagation=true,
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
  c1 := 1 * i1;
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
			description="Tests that variability is propagated 
			through function call equations with array destinations.",
			variability_propagation=true,
			flatModel="
fclass VariabilityPropagationTests.FunctionCallEquation2
 constant Real z1[1] = 1.0;
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
  output Real[2] c;
 algorithm
  c[1] := 1 * i1;
  c[2] := 2 * i1;
  return;
 end VariabilityPropagationTests.FunctionCallEquation2.f;
 
 function VariabilityPropagationTests.FunctionCallEquation2.e
  input Real i1;
  output Real[2] c;
 algorithm
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
        output A o;
    algorithm
    	o := A(i*1,i*2);
    end f;
    
	record A
		Real a;
		Real b;
	end A;
equation
    a = f(3);
    b = f(p);
    annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="FunctionCallEquation3",
			description="Tests that variability is propagated through 
			function call equations with record destinations.",
			variability_propagation=true,
			flatModel="
fclass VariabilityPropagationTests.FunctionCallEquation3
 constant Real a.a = 3.0;
 constant Real a.b = 6.0;
 parameter Real b.a;
 parameter Real b.b;
 parameter Real p = 3 /* 3 */;
parameter equation
 (VariabilityPropagationTests.FunctionCallEquation3.A(b.a, b.b)) = VariabilityPropagationTests.FunctionCallEquation3.f(p);

public
 function VariabilityPropagationTests.FunctionCallEquation3.f
  input Real i;
  output VariabilityPropagationTests.FunctionCallEquation3.A o;
 algorithm
  o.a := i * 1;
  o.b := i * 2;
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
			description="Tests that parameters in function call 
			equations are folded. Also tests that when it is constant 
			and can't evaluate, variability is propagated as parameter.",
			variability_propagation=true,
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
  input Real[:, size(A, 1)] A;
  input Real[size(A, 1)] b;
  output Real[size(b, 1)] x;
  Integer info;
 algorithm
  (x, info) := Modelica.Math.Matrices.LAPACK.dgesv_vec(A, b);
  ();
  return;
 end Modelica.Math.Matrices.solve;

 function Modelica.Math.Matrices.LAPACK.dgesv_vec
  input Real[:, size(A, 1)] A;
  input Real[size(A, 1)] b;
  output Real[size(A, 1)] x;
  output Integer info;
  Real[:,:] Awork;
  Integer lda;
  Integer ldb;
  Integer[:] ipiv;
 algorithm
  size(Awork) := {size(A, 1), size(A, 1)};
  size(ipiv) := {size(A, 1)};
  for i1 in 1:size(x, 1) loop
   x[i1] := b[i1];
  end for;
  for i1 in 1:size(Awork, 1) loop
   for i2 in 1:size(Awork, 2) loop
    Awork[i1,i2] := A[i1,i2];
   end for;
  end for;
  lda := max(1, size(A, 1));
  ldb := max(1, size(b, 1));
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
			description="Tests  evaluation of matrix 
			multiplication in function, proper evaluation of 
			size expressions.",
			variability_propagation=true,
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

model FunctionCallEquation6
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
			name="FunctionCallEquation6",
			description="Tests  evaluation of matrix 
			multiplication in function, proper evaluation of 
			size expressions.",
			variability_propagation=true,
			flatModel="
fclass VariabilityPropagationTests.FunctionCallEquation6
 output Real a;
 Real b;
equation
 (a, b) = VariabilityPropagationTests.FunctionCallEquation6.f();

public
 function VariabilityPropagationTests.FunctionCallEquation6.f
  output Real o1;
  output Real o2;
 algorithm
  o1 := 1;
  o2 := 2;
  return;
 end VariabilityPropagationTests.FunctionCallEquation6.f;

end VariabilityPropagationTests.FunctionCallEquation6;
")})));
end FunctionCallEquation6;

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
			variability_propagation=true,
			flatModel="
fclass VariabilityPropagationTests.ConstantRecord1
 constant Real c.a[1] = 1;
 constant Real c.a[2] = 2;
 constant Real c.a[3] = 3;
 constant Real c.b = 4;

public
 record VariabilityPropagationTests.ConstantRecord1.A
  Real a[:];
  Real b;
 end VariabilityPropagationTests.ConstantRecord1.A;

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
			description="Tests that a constant right hand in a function 
			call equation is not folded. It should only be propagated.",
			variability_propagation=true,
			flatModel="
fclass VariabilityPropagationTests.ConstantStartFunc1
 constant Real x[1](start = temp_1[1]) = 3;
 constant Real x[2](start = temp_1[2]) = 4;
 parameter Real temp_1[1];
 parameter Real temp_1[2];
parameter equation
 ({temp_1[1],temp_1[2]}) = VariabilityPropagationTests.ConstantStartFunc1.f();

public
 function VariabilityPropagationTests.ConstantStartFunc1.f
  output Real[2] o;
 algorithm
  o[1] := 1;
  o[2] := 2;
  return;
 end VariabilityPropagationTests.ConstantStartFunc1.f;

end VariabilityPropagationTests.ConstantStartFunc1;
")})));
end ConstantStartFunc1;


end VariabilityPropagationTests;