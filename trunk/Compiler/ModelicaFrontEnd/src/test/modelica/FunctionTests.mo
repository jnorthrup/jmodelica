/*
    Copyright (C) 2009-2011 Modelon AB

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


package FunctionTests 

/* Functions used in tests. */
function TestFunction0
 output Real o1 = 0;
algorithm
 return;
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

function TestFunctionString
 input String i1;
 output String o1 = i1;
algorithm
end TestFunctionString;

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

function TestFunctionWithConst
 input Real x = 1;
 output Real y = x + A + B + C;
protected
 constant Real A = 1;
 constant Real B = 2;
 constant Real C = 3;
algorithm
end TestFunctionWithConst;


/* Temporary functions for manual C-tests */

function Func00
algorithm
 return;
end Func00;

function Func10
 input Real i1 = 0;
algorithm
 return;
end Func10;

function Func01
 output Real o1 = 0;
algorithm
 return;
end Func01;

function Func11
 input Real i1 = 0;
 output Real o1 = i1;
algorithm
 return;
end Func11;

function Func21
 input Real i1 = 0;
 input Real i2 = 0;
 output Real o1 = i1 + i2;
algorithm
 return;
end Func21;

function Func02
 output Real o1 = 0;
 output Real o2 = 1;
algorithm
 return;
end Func02;

function Func12
 input Real i1 = 0;
 output Real o1 = i1;
 output Real o2 = 1;
algorithm
 return;
end Func12;

function Func22
 input Real i1 = 0;
 input Real i2 = 0;
 output Real o1 = i1 + i2;
 output Real o2 = 1;
algorithm
 for i in 1:3 loop
   o1 := o1 + 1;
   o2 := o2 - o1;
 end for;
 return;
end Func22;


/* ====================== Functions ====================== */

model FunctionFlatten1
 Real x;
equation
 x = TestFunction1(1);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionFlatten1",
			description="Flattening functions: simple function call",
			flatModel="
fclass FunctionTests.FunctionFlatten1
 Real x;
equation
 x = FunctionTests.TestFunction1(1);

public
 function FunctionTests.TestFunction1
  input Real i1 := 0;
  output Real o1 := i1;
 algorithm
  return;
 end FunctionTests.TestFunction1;

end FunctionTests.FunctionFlatten1;
")})));
end FunctionFlatten1;


model FunctionFlatten2
 Real x;
 Real y = TestFunction2(2, 3);
equation
 x = TestFunction2(1);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionFlatten2",
			description="Flattening functions: two calls to same function",
			flatModel="
fclass FunctionTests.FunctionFlatten2
 Real x;
 Real y = FunctionTests.TestFunction2(2, 3);
equation
 x = FunctionTests.TestFunction2(1, 0);

public
 function FunctionTests.TestFunction2
  input Real i1 := 0;
  input Real i2 := 0;
  output Real o1 := 0;
  output Real o2 := i2;
 algorithm
  o1 := i1;
  return;
 end FunctionTests.TestFunction2;

end FunctionTests.FunctionFlatten2;
")})));
end FunctionFlatten2;


model FunctionFlatten3
 Real x;
 Real y = TestFunction2(2, 3);
equation
 x = TestFunction1(y * 2);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionFlatten3",
			description="Flattening functions: calls to two functions",
			flatModel="
fclass FunctionTests.FunctionFlatten3
 Real x;
 Real y = FunctionTests.TestFunction2(2, 3);
equation
 x = FunctionTests.TestFunction1(y * 2);

public
 function FunctionTests.TestFunction2
  input Real i1 := 0;
  input Real i2 := 0;
  output Real o1 := 0;
  output Real o2 := i2;
 algorithm
  o1 := i1;
  return;
 end FunctionTests.TestFunction2;

 function FunctionTests.TestFunction1
  input Real i1 := 0;
  output Real o1 := i1;
 algorithm
  return;
 end FunctionTests.TestFunction1;

end FunctionTests.FunctionFlatten3;
")})));
end FunctionFlatten3;


model FunctionFlatten4
 Real x = TestFunctionWithConst(2);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionFlatten4",
			description="Flattening functions: function containing constants",
			flatModel="
fclass FunctionTests.FunctionFlatten4
 Real x = FunctionTests.TestFunctionWithConst(2);

public
 function FunctionTests.TestFunctionWithConst
  input Real x := 1;
  output Real y := x + 1.0 + 2.0 + 3.0;
 algorithm
  return;
 end FunctionTests.TestFunctionWithConst;

end FunctionTests.FunctionFlatten4;
")})));
end FunctionFlatten4;


model FunctionFlatten5
	model A
		Real x;
	equation
		x = TestFunction1(1);
	end A;
	
	model B
		extends A;
	end B;
	
	B y;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionFlatten5",
			description="Flattening functions: function called in extended class",
			flatModel="
fclass FunctionTests.FunctionFlatten5
 Real y.x;
equation
 y.x = FunctionTests.TestFunction1(1);

public
 function FunctionTests.TestFunction1
  input Real i1 := 0;
  output Real o1 := i1;
 algorithm
  return;
 end FunctionTests.TestFunction1;

end FunctionTests.FunctionFlatten5;
")})));
end FunctionFlatten5;


model FunctionFlatten6
	model A
		Real x;
	end A;
	
	model B = A(x = TestFunction1(1));
	
	B y;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionFlatten6",
			description="Flattening functions: function called in class modification",
			flatModel="
fclass FunctionTests.FunctionFlatten6
 Real y.x = FunctionTests.TestFunction1(1);

public
 function FunctionTests.TestFunction1
  input Real i1 := 0;
  output Real o1 := i1;
 algorithm
  return;
 end FunctionTests.TestFunction1;

end FunctionTests.FunctionFlatten6;
")})));
end FunctionFlatten6;


model FunctionFlatten7
	package A
		constant Real c = 1;
		function f
			output Real a = c;
		algorithm
		end f;
	end A;
	
	package B
		extends A(c = 2);
	end B;
	
	package C
		extends A(c = 3);
	end C;
	
	Real x = A.f();
	Real y = B.f();
	Real z = C.f();

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionFlatten7",
			description="Calling different inherited versions of same function",
			flatModel="
fclass FunctionTests.FunctionFlatten7
 Real x = FunctionTests.FunctionFlatten7.A.f();
 Real y = FunctionTests.FunctionFlatten7.B.f();
 Real z = FunctionTests.FunctionFlatten7.C.f();

public
 function FunctionTests.FunctionFlatten7.A.f
  output Real a := 1.0;
 algorithm
  return;
 end FunctionTests.FunctionFlatten7.A.f;

 function FunctionTests.FunctionFlatten7.B.f
  output Real a := 2.0;
 algorithm
  return;
 end FunctionTests.FunctionFlatten7.B.f;

 function FunctionTests.FunctionFlatten7.C.f
  output Real a := 3.0;
 algorithm
  return;
 end FunctionTests.FunctionFlatten7.C.f;

end FunctionTests.FunctionFlatten7;
")})));
end FunctionFlatten7;


model FunctionFlatten8
	function f
		output Real x = 1;
	algorithm
	end f;
	
	model A
		Real x;
	equation
		x = f();
	end A;
	
	A y;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionFlatten8",
			description="Calling function from parallel class",
			flatModel="
fclass FunctionTests.FunctionFlatten8
 Real y.x;
equation
 y.x = FunctionTests.FunctionFlatten8.f();

public
 function FunctionTests.FunctionFlatten8.f
  output Real x := 1;
 algorithm
  return;
 end FunctionTests.FunctionFlatten8.f;

end FunctionTests.FunctionFlatten8;
")})));
end FunctionFlatten8;


model FunctionFlatten9
    constant Real[3] a = {1,2,3};
    
    function f
        input Real[2] x;
        output Real[2] y;
    algorithm
        y := x + a[1:2] + a[1:2];
    end f;
    
    Real[2] z = f({3,4});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="FunctionFlatten9",
			description="Require copying of same constant array twice",
			flatModel="
fclass FunctionTests.FunctionFlatten9
 constant Real a[1] = 1;
 constant Real a[2] = 2;
 constant Real a[3] = 3;
 Real z[1];
 Real z[2];
equation
 ({z[1],z[2]}) = FunctionTests.FunctionFlatten9.f({3,4});

public
 function FunctionTests.FunctionFlatten9.f
  Real[3] a;
  input Real[2] x;
  output Real[2] y;
 algorithm
  a[1] := 1;
  a[2] := 2;
  a[3] := 3;
  y[1] := x[1] + a[1] + a[1];
  y[2] := x[2] + a[2] + a[2];
  return;
 end FunctionTests.FunctionFlatten9.f;

end FunctionTests.FunctionFlatten9;
")})));
end FunctionFlatten9;


model FunctionFlatten10
    function f1
        input Real x;
        output Real y;
    end f1;
    
    function f2
        extends f1;
    end f2;
    
    function f3
        extends f2;
    algorithm
        y := x;
    end f3;
    
    Real z = f3(1);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionFlatten10",
			description="Multi-level extending of functions",
			flatModel="
fclass FunctionTests.FunctionFlatten10
 Real z = FunctionTests.FunctionFlatten10.f3(1);

public
 function FunctionTests.FunctionFlatten10.f3
  input Real x;
  output Real y;
 algorithm
  y := x;
  return;
 end FunctionTests.FunctionFlatten10.f3;

end FunctionTests.FunctionFlatten10;
")})));
end FunctionFlatten10;


model FunctionFlatten11
    function f0
        input Real x;
        output Real y;
    end f0;
    
    function f1
        extends f0;
    algorithm
        y := x;
    end f1;
    
    function f2
        extends f0;
    algorithm
        y := x + 1;
    end f2;
    
	model A
		replaceable function f3 = f1 constrainedby f0;
		Real x = 1;
		Real y = f3(x);
	end A;
	
	model B = A(redeclare function f3 = f2);
	
	model C
		extends A;
		redeclare function f3 = f2;
	end C;
	
	B b;
	C c;

	annotation(__JModelica(UnitTesting(tests={ 
		FlatteningTestCase(
			name="FunctionFlatten11",
			description="Using redeclared function in model",
			flatModel="
fclass FunctionTests.FunctionFlatten11
 Real b.x = 1;
 Real b.y = FunctionTests.FunctionFlatten11.b.f3(b.x);
 Real c.x = 1;
 Real c.y = FunctionTests.FunctionFlatten11.c.f3(c.x);

public
 function FunctionTests.FunctionFlatten11.b.f3
  input Real x;
  output Real y;
 algorithm
  y := x + 1;
  return;
 end FunctionTests.FunctionFlatten11.b.f3;

 function FunctionTests.FunctionFlatten11.c.f3
  input Real x;
  output Real y;
 algorithm
  y := x + 1;
  return;
 end FunctionTests.FunctionFlatten11.c.f3;

end FunctionTests.FunctionFlatten11;
")})));
end FunctionFlatten11;



/* ====================== Function calls ====================== */

model FunctionBinding1
 Real x = TestFunction1();

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionBinding1",
			description="Binding function arguments: 1 input, use default",
			flatModel="
fclass FunctionTests.FunctionBinding1
 Real x = FunctionTests.TestFunction1(0);

public
 function FunctionTests.TestFunction1
  input Real i1 := 0;
  output Real o1 := i1;
 algorithm
  return;
 end FunctionTests.TestFunction1;

end FunctionTests.FunctionBinding1;
")})));
end FunctionBinding1;

model FunctionBinding2
 Real x = TestFunction1(1);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionBinding2",
			description="Binding function arguments: 1 input, 1 arg",
			flatModel="
fclass FunctionTests.FunctionBinding2
 Real x = FunctionTests.TestFunction1(1);

public
 function FunctionTests.TestFunction1
  input Real i1 := 0;
  output Real o1 := i1;
 algorithm
  return;
 end FunctionTests.TestFunction1;

end FunctionTests.FunctionBinding2;
")})));
end FunctionBinding2;

model FunctionBinding3
 Real x = TestFunction1(1, 2);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="FunctionBinding3",
			description="Function call with too many arguments",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function TestFunction1(): too many positional arguments
")})));
end FunctionBinding3;

model FunctionBinding4
 Real x = TestFunction3();

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="FunctionBinding4",
			description="Function call with too few arguments: no arguments",
			errorMessage="
2 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function TestFunction3(): missing argument for required input i1
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function TestFunction3(): missing argument for required input i2
")})));
end FunctionBinding4;

model FunctionBinding5
 Real x = TestFunction3(1);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="FunctionBinding5",
			description="Function call with too few arguments: one positional argument",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function TestFunction3(): missing argument for required input i2
")})));
end FunctionBinding5;

model FunctionBinding6
 Real x = TestFunction3(1, 2);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionBinding6",
			description="Binding function arguments: 3 inputs, 2 args, 1 default",
			flatModel="
fclass FunctionTests.FunctionBinding6
 Real x = FunctionTests.TestFunction3(1, 2, 0);

public
 function FunctionTests.TestFunction3
  input Real i1;
  input Real i2;
  input Real i3 := 0;
  output Real o1 := i1 + i2 + i3;
  output Real o2 := i2 + i3;
  output Real o3 := i1 + i2;
 algorithm
  return;
 end FunctionTests.TestFunction3;

end FunctionTests.FunctionBinding6;
")})));
end FunctionBinding6;

model FunctionBinding7
 Real x = TestFunction0();

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionBinding7",
			description="Binding function arguments: 3 inputs, 2 args, 1 default",
			flatModel="
fclass FunctionTests.FunctionBinding7
 Real x = FunctionTests.TestFunction0();

public
 function FunctionTests.TestFunction0
  output Real o1 := 0;
 algorithm
  return;
 end FunctionTests.TestFunction0;

end FunctionTests.FunctionBinding7;
")})));
end FunctionBinding7;

model FunctionBinding8
 Real x = TestFunction1(i1=1);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionBinding8",
			description="Binding function arguments: 1 input, 1 named arg",
			flatModel="
fclass FunctionTests.FunctionBinding8
 Real x = FunctionTests.TestFunction1(1);

public
 function FunctionTests.TestFunction1
  input Real i1 := 0;
  output Real o1 := i1;
 algorithm
  return;
 end FunctionTests.TestFunction1;

end FunctionTests.FunctionBinding8;
")})));
end FunctionBinding8;

model FunctionBinding9
 Real x = TestFunction2(i2=2, i1=1);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionBinding9",
			description="Binding function arguments: 2 inputs, 2 named arg (inverted order)",
			flatModel="
fclass FunctionTests.FunctionBinding9
 Real x = FunctionTests.TestFunction2(1, 2);

public
 function FunctionTests.TestFunction2
  input Real i1 := 0;
  input Real i2 := 0;
  output Real o1 := 0;
  output Real o2 := i2;
 algorithm
  o1 := i1;
  return;
 end FunctionTests.TestFunction2;

end FunctionTests.FunctionBinding9;
")})));
end FunctionBinding9;

model FunctionBinding10
 Real x = TestFunction3(1, i3=2);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="FunctionBinding10",
			description="Function call with too few arguments: missing middle argument",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function TestFunction3(): missing argument for required input i2
")})));
end FunctionBinding10;

model FunctionBinding11
 Real x = TestFunction2(i3=1);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="FunctionBinding11",
			description="Function call with named arguments: non-existing input",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function TestFunction2(): no input matching named argument i3 found
")})));
end FunctionBinding11;

model FunctionBinding12
 Real x = TestFunction2(o1=1);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="FunctionBinding12",
			description="Function call with named arguments: using output as input",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function TestFunction2(): no input matching named argument o1 found
")})));
end FunctionBinding12;

model FunctionBinding13
 Real x = TestFunction2(1, 2, i1=3);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="FunctionBinding13",
			description="Function call with named arguments: giving an input value twice",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function TestFunction2(): multiple arguments matches input i1
")})));
end FunctionBinding13;

model FunctionBinding14
 Real x = TestFunction2(1, 2, i1=3, i1=3, i1=3);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="FunctionBinding14",
			description="Function call with named arguments: giving an input value four times",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function TestFunction2(): multiple arguments matches input i1
")})));
end FunctionBinding14;

model FunctionBinding15
    package A
        constant Real a = 1;
        
        function f
            input  Real b = a;
            output Real c = b;
        algorithm
        end f;
    end A;
    
    model B
        Real c = A.f();
    end B;
    
    B d;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionBinding15",
			description="Access to constant in default input value",
			flatModel="
fclass FunctionTests.FunctionBinding15
 Real d.c = FunctionTests.FunctionBinding15.A.f(1.0);

public
 function FunctionTests.FunctionBinding15.A.f
  input Real b := 1.0;
  output Real c := b;
 algorithm
  return;
 end FunctionTests.FunctionBinding15.A.f;

end FunctionTests.FunctionBinding15;
")})));
end FunctionBinding15;


model FunctionBinding16
    function f
        input Real a = 1;
        input Real b = a;
        output Real c = a + b;
    algorithm
    end f;
    
    Real x = f();
    Real y = f(x);
    Real z = f(x,y);
end FunctionBinding16;


model FunctionBinding17
    function f1
        output Real a1;
    algorithm
        a1 := f2;
    end f1;
    
    function f2
        output Real a2 = 1;
    algorithm
    end f2;
    
    Real x = f1();
end FunctionBinding17;


model FunctionBinding18
    function f
        output Real a = 1;
    algorithm
    end f;
   
    Real x = f;
end FunctionBinding18;


model FunctionBinding19
	function a
        input Real x; 
        output Real y;
    end a;
	
    function b
        extends a;
    end b;
	
    function c
        extends a;
        extends b;
    algorithm
        y := x;
    end c;

    Real w = c(1.0);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionBinding19",
			description="",
			flatModel="
fclass FunctionTests.FunctionBinding19
 Real w = FunctionTests.FunctionBinding19.c(1.0);

public
 function FunctionTests.FunctionBinding19.c
  input Real x;
  output Real y;
 algorithm
  y := x;
  return;
 end FunctionTests.FunctionBinding19.c;

end FunctionTests.FunctionBinding19;
")})));
end FunctionBinding19;



model BadFunctionCall1
  Real x = NonExistingFunction(1, 2);
  Real y = NonExistingFunction();

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="BadFunctionCall1",
			description="Call to non-existing function",
			errorMessage="
2 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  The function NonExistingFunction() is undeclared
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  The function NonExistingFunction() is undeclared
")})));
end BadFunctionCall1;

model BadFunctionCall2
  Real notAFunction = 0;
  Real x = notAFunction(1, 2);
  Real y = notAFunction();

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="BadFunctionCall2",
			description="Call to component as function",
			errorMessage="
2 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  The function notAFunction() is undeclared
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  The function notAFunction() is undeclared
")})));
end BadFunctionCall2;

class NotAFunctionClass
 Real x;
end NotAFunctionClass;

model BadFunctionCall3
  Real x = NotAFunctionClass(1, 2);
  Real y = NotAFunctionClass();

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="BadFunctionCall3",
			description="Call to non-function class as function",
			errorMessage="
2 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  The class NotAFunctionClass is not a function
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  The class NotAFunctionClass is not a function
")})));
end BadFunctionCall3;

model MultipleOutput1
  Real x;
  Real y;
equation
  (x, y) = TestFunction2(1, 2);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="MultipleOutput1",
			description="Functions with multiple outputs: flattening of equation",
			flatModel="
fclass FunctionTests.MultipleOutput1
 Real x;
 Real y;
equation
 (x, y) = FunctionTests.TestFunction2(1, 2);

public
 function FunctionTests.TestFunction2
  input Real i1 := 0;
  input Real i2 := 0;
  output Real o1 := 0;
  output Real o2 := i2;
 algorithm
  o1 := i1;
  return;
 end FunctionTests.TestFunction2;

end FunctionTests.MultipleOutput1;
")})));
end MultipleOutput1;

model MultipleOutput2
  Real x;
  Real y;
equation
  (x, y) = TestFunction3(1, 2, 3);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="MultipleOutput2",
			description="Functions with multiple outputs: flattening, fewer components assigned than outputs",
			flatModel="
fclass FunctionTests.MultipleOutput2
 Real x;
 Real y;
equation
 (x, y) = FunctionTests.TestFunction3(1, 2, 3);

public
 function FunctionTests.TestFunction3
  input Real i1;
  input Real i2;
  input Real i3 := 0;
  output Real o1 := i1 + i2 + i3;
  output Real o2 := i2 + i3;
  output Real o3 := i1 + i2;
 algorithm
  return;
 end FunctionTests.TestFunction3;

end FunctionTests.MultipleOutput2;
")})));
end MultipleOutput2;

model MultipleOutput3
  Real x;
  Real z;
equation
  (x, , z) = TestFunction3(1, 2, 3);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="MultipleOutput3",
			description="Functions with multiple outputs: flattening, one output skipped",
			flatModel="
fclass FunctionTests.MultipleOutput3
 Real x;
 Real z;
equation
 (x, , z) = FunctionTests.TestFunction3(1, 2, 3);

public
 function FunctionTests.TestFunction3
  input Real i1;
  input Real i2;
  input Real i3 := 0;
  output Real o1 := i1 + i2 + i3;
  output Real o2 := i2 + i3;
  output Real o3 := i1 + i2;
 algorithm
  return;
 end FunctionTests.TestFunction3;

end FunctionTests.MultipleOutput3;
")})));
end MultipleOutput3;

model MultipleOutput4
  Real x;
  Real y;
equation
  TestFunction2(1, 2);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="MultipleOutput4",
			description="Functions with multiple outputs: flattening, no components assigned",
			flatModel="
fclass FunctionTests.MultipleOutput4
 Real x;
 Real y;
equation
 FunctionTests.TestFunction2(1, 2);

public
 function FunctionTests.TestFunction2
  input Real i1 := 0;
  input Real i2 := 0;
  output Real o1 := 0;
  output Real o2 := i2;
 algorithm
  o1 := i1;
  return;
 end FunctionTests.TestFunction2;

end FunctionTests.MultipleOutput4;
")})));
end MultipleOutput4;

model RecursionTest1
 Real x = TestFunctionCallingFunction(1);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RecursionTest1",
			description="Flattening function calling other function",
			flatModel="
fclass FunctionTests.RecursionTest1
 Real x = FunctionTests.TestFunctionCallingFunction(1);

public
 function FunctionTests.TestFunctionCallingFunction
  input Real i1;
  output Real o1;
 algorithm
  o1 := FunctionTests.TestFunction1(i1);
  return;
 end FunctionTests.TestFunctionCallingFunction;

 function FunctionTests.TestFunction1
  input Real i1 := 0;
  output Real o1 := i1;
 algorithm
  return;
 end FunctionTests.TestFunction1;

end FunctionTests.RecursionTest1;
")})));
end RecursionTest1;

model RecursionTest2
 Real x = TestFunctionRecursive(5);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RecursionTest2",
			description="Flattening function calling other function",
			flatModel="
fclass FunctionTests.RecursionTest2
 Real x = FunctionTests.TestFunctionRecursive(5);

public
 function FunctionTests.TestFunctionRecursive
  input Integer i1;
  output Integer o1;
 algorithm
  if i1 < 3 then
   o1 := 1;
  else
   o1 := FunctionTests.TestFunctionRecursive(i1 - 1) + FunctionTests.TestFunctionRecursive(i1 - 2);
  end if;
  return;
 end FunctionTests.TestFunctionRecursive;

end FunctionTests.RecursionTest2;
")})));
end RecursionTest2;

/* ====================== Function call type checks ====================== */

model FunctionType0
 Real x = TestFunction1(1.0);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionType0",
			description="Function type checks: Real literal arg, Real input",
			flatModel="
fclass FunctionTests.FunctionType0
 Real x = FunctionTests.TestFunction1(1.0);

public
 function FunctionTests.TestFunction1
  input Real i1 := 0;
  output Real o1 := i1;
 algorithm
  return;
 end FunctionTests.TestFunction1;

end FunctionTests.FunctionType0;
")})));
end FunctionType0;

model FunctionType1
 Real x = TestFunction1(1);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionType1",
			description="Function type checks: Integer literal arg, Real input",
			flatModel="
fclass FunctionTests.FunctionType1
 Real x = FunctionTests.TestFunction1(1);

public
 function FunctionTests.TestFunction1
  input Real i1 := 0;
  output Real o1 := i1;
 algorithm
  return;
 end FunctionTests.TestFunction1;

end FunctionTests.FunctionType1;
")})));
end FunctionType1;

model FunctionType2
 Integer x = TestFunction1(1.0);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="FunctionType2",
			description="Function type checks: function with Real output as binding exp for Integer component",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  The binding expression of the variable x does not match the declared type of the variable
")})));
end FunctionType2;

model FunctionType3
 parameter Real a = 1.0;
 Real x = TestFunction1(a);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionType3",
			description="Function type checks: Real component arg, Real input",
			flatModel="
fclass FunctionTests.FunctionType3
 parameter Real a = 1.0 /* 1.0 */;
 Real x = FunctionTests.TestFunction1(a);

public
 function FunctionTests.TestFunction1
  input Real i1 := 0;
  output Real o1 := i1;
 algorithm
  return;
 end FunctionTests.TestFunction1;

end FunctionTests.FunctionType3;
")})));
end FunctionType3;

model FunctionType4
 parameter Integer a = 1;
 Real x = TestFunction1(a);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionType4",
			description="Function type checks: Integer component arg, Real input",
			flatModel="
fclass FunctionTests.FunctionType4
 parameter Integer a = 1 /* 1 */;
 Real x = FunctionTests.TestFunction1(a);

public
 function FunctionTests.TestFunction1
  input Real i1 := 0;
  output Real o1 := i1;
 algorithm
  return;
 end FunctionTests.TestFunction1;

end FunctionTests.FunctionType4;
")})));
end FunctionType4;

model FunctionType5
 Real x = TestFunction2(1, true);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="FunctionType5",
			description="Function type checks: Boolean literal arg, Real input",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function TestFunction2(): types of positional argument 2 and input i2 are not compatible
")})));
end FunctionType5;

model FunctionType6
 parameter Boolean a = true;
 Real x = TestFunction2(1, a);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="FunctionType6",
			description="Function type checks: Boolean component arg, Real input",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function TestFunction2(): types of positional argument 2 and input i2 are not compatible
")})));
end FunctionType6;

model FunctionType7
 parameter Integer a = 1;
 Real x = TestFunction2(TestFunction2(), TestFunction2(1));

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="FunctionType7",
			description="Function type checks: nestled function calls",
			flatModel="
fclass FunctionTests.FunctionType7
 parameter Integer a = 1 /* 1 */;
 Real x = FunctionTests.TestFunction2(FunctionTests.TestFunction2(0, 0), FunctionTests.TestFunction2(1, 0));

public
 function FunctionTests.TestFunction2
  input Real i1 := 0;
  input Real i2 := 0;
  output Real o1 := 0;
  output Real o2 := i2;
 algorithm
  o1 := i1;
  return;
 end FunctionTests.TestFunction2;

end FunctionTests.FunctionType7;
")})));
end FunctionType7;

model FunctionType8
 parameter Integer a = 1;
 Real x = TestFunction2(TestFunction1(true), TestFunction2(1));

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="FunctionType8",
			description="Function type checks: nestled function calls, type mismatch in inner",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function TestFunction1(): types of positional argument 1 and input i1 are not compatible
")})));
end FunctionType8;

model FunctionType9
 String x = TestFunctionString("test");

	annotation(__JModelica(UnitTesting(tests={
		ComplianceErrorTestCase(
			name="FunctionType9",
			description="Function type checks: String literal arg, String input (error for now)",
			errorMessage="
3 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Compliance error at line 52, column 27:
  String variables are not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Compliance error at line 53, column 17:
  String variables are not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Compliance error at line 1303, column 7:
  String variables are not supported
")})));
end FunctionType9;

model FunctionType10
 parameter String a = "test";
 String x = TestFunctionString(a);

	annotation(__JModelica(UnitTesting(tests={
		ComplianceErrorTestCase(
			name="FunctionType10",
			description="Function type checks: String component arg, String input (error for now)",
			errorMessage="
3 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Compliance error at line 52, column 27:
  String variables are not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Compliance error at line 53, column 17:
  String variables are not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Compliance error at line 1327, column 29:
  String variables are not supported
")})));
end FunctionType10;

model FunctionType11
 String x = TestFunctionString(1);

	annotation(__JModelica(UnitTesting(tests={
		ComplianceErrorTestCase(
			name="FunctionType11",
			description="Function type checks: Integer literal arg, String input",
			errorMessage="
4 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Compliance error at line 52, column 27:
  String variables are not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Compliance error at line 53, column 17:
  String variables are not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Compliance error at line 1338, column 7:
  String variables are not supported
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1340, column 32:
  Calling function TestFunctionString(): types of positional argument 1 and input i1 are not compatible
")})));
end FunctionType11;

model FunctionType12
 Real x;
 Integer y;
equation
 (x, y) = TestFunction2(1, 2);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="FunctionType12",
			description="Function type checks: 2 outputs, 2nd wrong type",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function TestFunction2(): types of component y and output o2 are not compatible
")})));
end FunctionType12;

model FunctionType13
 Integer x;
 Real y;
 Integer z;
equation
 (x, y, z) = TestFunction3(1, 2);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="FunctionType13",
			description="Function type checks: 3 outputs, 1st and 3rd wrong type",
			errorMessage="
2 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function TestFunction3(): types of component x and output o1 are not compatible
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function TestFunction3(): types of component z and output o3 are not compatible
")})));
end FunctionType13;

model FunctionType14
 Real x;
 Real y;
 Real z;
equation
 (x, y, z) = TestFunction2(1, 2);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="FunctionType14",
			description="Function type checks: 2 outputs, 3 components assigned",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Too many components assigned from function call: TestFunction2() has 2 output(s)
")})));
end FunctionType14;

model FunctionType15
 Real x;
 Integer z;
equation
 (x, , z) = TestFunction3(1, 2);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="FunctionType15",
			description="Function type checks: 3 outputs, 2nd skipped, 3rd wrong type",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function TestFunction3(): types of component z and output o3 are not compatible
")})));
end FunctionType15;

model FunctionType16
 Real x;
 Real y;
equation
 (x, y) = sin(1);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="FunctionType16",
			description="Function type checks: assigning 2 components from sin()",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Too many components assigned from function call: sin() has 1 output(s)
")})));
end FunctionType16;

model FunctionType17
 function f
  input Real x[:,:];
  input Real y[2,:];
  output Real z[size(x,1),size(x,2)];
 algorithm
  z := x + y;
 end f;
  
 Real x[2,2] = f({{1,2},{3,4}}, {{5,6},{7,8}});

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="FunctionType17",
			description="Function type checks: combining known and unknown types",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1094, column 8:
  Type error in expression: x + y
")})));
end FunctionType17;


model BuiltInCallType1
  Real x = sin(true);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="BuiltInCallType1",
			description="Built-in type checks: passing Boolean literal to sin()",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function sin(): types of positional argument 1 and input u are not compatible
")})));
end BuiltInCallType1;

model BuiltInCallType2
  Real x = sqrt("test");

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="BuiltInCallType2",
			description="Built-in type checks: passing String literal to sqrt()",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function sqrt(): types of positional argument 1 and input x are not compatible
")})));
end BuiltInCallType2;

model BuiltInCallType3
  Real x = sqrt(1);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="BuiltInCallType3",
			description="Built-in type checks: passing Integer literal to sqrt()",
			flatModel="
fclass FunctionTests.BuiltInCallType3
 Real x = sqrt(1);

end FunctionTests.BuiltInCallType3;
")})));
end BuiltInCallType3;

model BuiltInCallType4
  Integer x = sqrt(9.0);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="BuiltInCallType4",
			description="Built-in type checks: using return value from sqrt() as Integer",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  The binding expression of the variable x does not match the declared type of the variable
")})));
end BuiltInCallType4;

model BuiltInCallType5
  Real x = sin();

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="BuiltInCallType5",
			description="Built-in type checks: calling sin() without arguments",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function sin(): missing argument for required input u
")})));
end BuiltInCallType5;

model BuiltInCallType6
  Real x = atan2(9.0);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="BuiltInCallType6",
			description="Built-in type checks: calling atan2() with only one argument",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function atan2(): missing argument for required input u2
")})));
end BuiltInCallType6;

model BuiltInCallType7
  Real x = atan2(9.0, "test");

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="BuiltInCallType7",
			description="Built-in type checks: calling atan2() with String literal as second argument",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Calling function atan2(): types of positional argument 2 and input u2 are not compatible
")})));
end BuiltInCallType7;

model BuiltInCallType8
  Real x[3] = zeros(3);
  Real y[3,2] = ones(3,2);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="BuiltInCallType8",
			description="Built-in type checks: using ones and zeros",
			flatModel="
fclass FunctionTests.BuiltInCallType8
 Real x[3] = zeros(3);
 Real y[3,2] = ones(3, 2);

end FunctionTests.BuiltInCallType8;
")})));
end BuiltInCallType8;

model BuiltInCallType9
   Real x[3] = zeros(3.0);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="BuiltInCallType9",
			description="Built-in type checks: calling zeros() with Real literal as argument",
			errorMessage="
1 error(s) found...
In file 'FunctionTests.mo':
Semantic error at line 1, column 1:
  Argument of zeros() is not compatible with Integer: 3.0
")})));
end BuiltInCallType9;

model BuiltInCallType10
   Real x[3] = ones(3, "test");

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="BuiltInCallType10",
			description="Built-in type checks: calling ones() with String literal as second argument",
			errorMessage="
2 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1234, column 9:
  Array size mismatch in declaration of x, size of declaration is [3] and size of binding expression is [3, \"test\"]
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1223, column 24:
  Argument of ones() is not compatible with Integer: \"test\"
")})));
end BuiltInCallType10;


/* ====================== Algorithm flattening ====================== */

model AlgorithmFlatten1
 Real x;
algorithm
 x := 5;
 x := x + 2;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="AlgorithmFlatten1",
			description="Flattening algorithms: assign stmts",
			flatModel="
fclass FunctionTests.AlgorithmFlatten1
 Real x;
algorithm
 x := 5;
 x := x + 2;

end FunctionTests.AlgorithmFlatten1;
")})));
end AlgorithmFlatten1;

model AlgorithmFlatten2
 Real x;
algorithm
 break;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="AlgorithmFlatten2",
			description="Flattening algorithms: break stmts",
			flatModel="
fclass FunctionTests.AlgorithmFlatten2
 Real x;
algorithm
 break;

end FunctionTests.AlgorithmFlatten2;
")})));
end AlgorithmFlatten2;

model AlgorithmFlatten3
 Integer x;
 Integer y;
algorithm
 if x == 4 then
  x := 1;
  y := 2;
 elseif x == 3 then
  if y == 0 then
   y := 1;
  end if;
  x := 2;
  y := 3;
 else
  x := 3;
 end if;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="AlgorithmFlatten3",
			description="Flattening algorithms: if stmts",
			flatModel="
fclass FunctionTests.AlgorithmFlatten3
 discrete Integer x;
 discrete Integer y;
algorithm
 if x == 4 then
  x := 1;
  y := 2;
 elseif x == 3 then
  if y == 0 then
   y := 1;
  end if;
  x := 2;
  y := 3;
 else
  x := 3;
 end if;

end FunctionTests.AlgorithmFlatten3;
")})));
end AlgorithmFlatten3;

model AlgorithmFlatten4
 Integer x;
 Integer y;
algorithm
 when x == 4 then
  x := 1;
  y := 2;
 elsewhen x == 3 then
  x := 2;
  y := 3;
  if x == 2 then
   x := 3;
  end if;
 end when;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="AlgorithmFlatten4",
			description="Flattening algorithms: when stmts",
			flatModel="
fclass FunctionTests.AlgorithmFlatten4
 discrete Integer x;
 discrete Integer y;
algorithm
 when x == 4 then
  x := 1;
  y := 2;
 elsewhen x == 3 then
  x := 2;
  y := 3;
  if x == 2 then
   x := 3;
  end if;
 end when;

end FunctionTests.AlgorithmFlatten4;
")})));
end AlgorithmFlatten4;

model AlgorithmFlatten5
 Real x;
algorithm
 while x < 1 loop
  while x < 2 loop
   while x < 3 loop
    x := x - 1;
   end while;
  end while;
 end while;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="AlgorithmFlatten5",
			description="Flattening algorithms: while stmts",
			flatModel="
fclass FunctionTests.AlgorithmFlatten5
 Real x;
algorithm
 while x < 1 loop
  while x < 2 loop
   while x < 3 loop
    x := x - 1;
   end while;
  end while;
 end while;
end FunctionTests.AlgorithmFlatten5;
")})));
end AlgorithmFlatten5;

model AlgorithmFlatten6
 Real x;
algorithm
 for i in {1, 2, 4}, j in 1:3 loop
  x := x + i * j;
 end for;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="AlgorithmFlatten6",
			description="Flattening algorithms: for stmts",
			flatModel="
fclass FunctionTests.AlgorithmFlatten6
 Real x;
algorithm
 for i in {1, 2, 4} loop
  for j in 1:3 loop
   x := x + i * j;
  end for;
 end for;
end FunctionTests.AlgorithmFlatten6;
")})));
end AlgorithmFlatten6;


/* ====================== Algorithm type checks ====================== */

/* ----- if ----- */

model AlgorithmTypeIf1
 Real x;
algorithm
 if 1 then
  x := 1.0;
 end if;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="AlgorithmTypeIf1",
			description="Type checks in algorithms: Integer literal as test in if",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1944, column 5:
  Type of test expression of if statement is not Boolean
")})));
end AlgorithmTypeIf1;

model AlgorithmTypeIf2
 Integer a = 1;
 Real x;
algorithm
 if a then
  x := 1.0;
 end if;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="AlgorithmTypeIf2",
			description="Type checks in algorithms: Integer component as test in if",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1382, column 5:
  Type of test expression of if statement is not Boolean
")})));
end AlgorithmTypeIf2;

model AlgorithmTypeIf3
 Integer a = 1;
 Real x;
algorithm
 if a + x then
  x := 1.0;
 end if;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="AlgorithmTypeIf3",
			description="Type checks in algorithms: arithmetic expression as test in if",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1403, column 5:
  Type of test expression of if statement is not Boolean
")})));
end AlgorithmTypeIf3;

model AlgorithmTypeIf4
 Real x;
algorithm
 if { true, false } then
  x := 1.0;
 end if;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="AlgorithmTypeIf4",
			description="Type checks in algorithms: Boolean vector as test in if",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1422, column 5:
  Type of test expression of if statement is not Boolean
")})));
end AlgorithmTypeIf4;

model AlgorithmTypeIf5
 Real x;
algorithm
 if true then
  x := 1.0;
 end if;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="AlgorithmTypeIf5",
			description="Type checks in algorithms: Boolean literal as test in if",
			flatModel="
fclass FunctionTests.AlgorithmTypeIf5
 Real x;
algorithm
 if true then
  x := 1.0;
 end if;

end FunctionTests.AlgorithmTypeIf5;
")})));
end AlgorithmTypeIf5;

/* ----- when ----- */

model AlgorithmTypeWhen1
 Real x;
algorithm
 when 1 then
  x := 1.0;
 end when;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="AlgorithmTypeWhen1",
			description="Type checks in algorithms: Integer literal as test in when",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1469, column 7:
  Test expression of when statement isn't Boolean scalar or vector expression
")})));
end AlgorithmTypeWhen1;

model AlgorithmTypeWhen2
 Integer a = 1;
 Real x;
algorithm
 when a then
  x := 1.0;
 end when;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="AlgorithmTypeWhen2",
			description="Type checks in algorithms: Integer component as test in when",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1489, column 7:
  Test expression of when statement isn't Boolean scalar or vector expression
")})));
end AlgorithmTypeWhen2;

model AlgorithmTypeWhen3
 Integer a = 1;
 Real x;
algorithm
 when a + x then
  x := 1.0;
 end when;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="AlgorithmTypeWhen3",
			description="Type checks in algorithms: arithmetic expression as test in when",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1509, column 7:
  Test expression of when statement isn't Boolean scalar or vector expression
")})));
end AlgorithmTypeWhen3;

model AlgorithmTypeWhen4
 Real x;
algorithm
 when { true, false } then
  x := 1.0;
 end when;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="AlgorithmTypeWhen4",
			description="Type checks in algorithms: Boolean vector as test in when",
			flatModel="
fclass FunctionTests.AlgorithmTypeWhen4
 Real x;
algorithm
 when {true,false} then
  x := 1.0;
 end when;

end FunctionTests.AlgorithmTypeWhen4;
")})));
end AlgorithmTypeWhen4;

model AlgorithmTypeWhen5
 Real x;
algorithm
 when true then
  x := 1.0;
 end when;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="AlgorithmTypeWhen5",
			description="Type checks in algorithms: Boolean literal as test in when",
			flatModel="
fclass FunctionTests.AlgorithmTypeWhen5
 Real x;
algorithm
 when true then
  x := 1.0;
 end when;

end FunctionTests.AlgorithmTypeWhen5;
")})));
end AlgorithmTypeWhen5;

/* ----- while ----- */

model AlgorithmTypeWhile1
 Real x;
algorithm
 while 1 loop
  x := 1.0;
 end while;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="AlgorithmTypeWhile1",
			description="Type checks in algorithms: Integer literal as test in while",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1363, column 5:
  Type of test expression of while statement is not Boolean
")})));
end AlgorithmTypeWhile1;

model AlgorithmTypeWhile2
 Integer a = 1;
 Real x;
algorithm
 while a loop
  x := 1.0;
 end while;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="AlgorithmTypeWhile2",
			description="Type checks in algorithms: Integer component as test in while",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1382, column 5:
  Type of test expression of while statement is not Boolean
")})));
end AlgorithmTypeWhile2;

model AlgorithmTypeWhile3
 Integer a = 1;
 Real x;
algorithm
 while a + x loop
  x := 1.0;
 end while;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="AlgorithmTypeWhile3",
			description="Type checks in algorithms: arithmetic expression as test in while",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1403, column 5:
  Type of test expression of while statement is not Boolean
")})));
end AlgorithmTypeWhile3;

model AlgorithmTypeWhile4
 Real x;
algorithm
 while { true, false } loop
  x := 1.0;
 end while;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="AlgorithmTypeWhile4",
			description="Type checks in algorithms: Boolean vector as test in while",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1422, column 5:
  Type of test expression of while statement is not Boolean
")})));
end AlgorithmTypeWhile4;

model AlgorithmTypeWhile5
 Real x;
algorithm
 while true loop
  x := 1.0;
 end while;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="AlgorithmTypeWhile5",
			description="Type checks in algorithms: Boolean literal as test in while",
			flatModel="
fclass FunctionTests.AlgorithmTypeWhile5
 Real x;
algorithm
 while true loop
  x := 1.0;
 end while;

end FunctionTests.AlgorithmTypeWhile5;
")})));
end AlgorithmTypeWhile5;

model AlgorithmTypeAssign1
 Integer x;
algorithm
 x := 1.0;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="AlgorithmTypeAssign1",
			description="Type checks in algorithms: assign Real to Integer component",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1674, column 2:
  Types of right and left side of assignment are not compatible
")})));
end AlgorithmTypeAssign1;

model AlgorithmTypeAssign2
 Real x;
algorithm
 x := 1;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="AlgorithmTypeAssign2",
			description="Type checks in algorithms: assign Integer to Real component",
			flatModel="
fclass FunctionTests.AlgorithmTypeAssign2
 Real x;
algorithm
 x := 1;

end FunctionTests.AlgorithmTypeAssign2;
")})));
end AlgorithmTypeAssign2;

model AlgorithmTypeAssign3
 Real x;
algorithm
 x := 1.0;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="AlgorithmTypeAssign3",
			description="Type checks in algorithms: assign Real to Real component",
			flatModel="
fclass FunctionTests.AlgorithmTypeAssign3
 Real x;
algorithm
 x := 1.0;

end FunctionTests.AlgorithmTypeAssign3;
")})));
end AlgorithmTypeAssign3;

model AlgorithmTypeAssign4
 Real x;
algorithm
 x := "foo";

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="AlgorithmTypeAssign4",
			description="Type checks in algorithms: assign String to Real component",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1715, column 2:
  Types of right and left side of assignment are not compatible
")})));
end AlgorithmTypeAssign4;


model AlgorithmTypeForIndex1
 Real x;
algorithm
 for i in 1:3 loop
  i := 2;
  x := i;
 end for;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="AlgorithmTypeForIndex1",
			description="Type checks in algorithms: assigning to for index",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1794, column 3:
  Can not assign a value to a for loop index
")})));
end AlgorithmTypeForIndex1;


model AlgorithmTypeForIndex2
 Real x;
algorithm
 for i in 1:3 loop
  (i, x) := TestFunction2(1, 2);
 end for;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="AlgorithmTypeForIndex2",
			description="Type checks in algorithms: assigning to for index (FunctionCallStmt)",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 1815, column 3:
  Can not assign a value to a for loop index
")})));
end AlgorithmTypeForIndex2;


/* ====================== Algorithm transformations ===================== */

model AlgorithmTransformation1
 Real a = 1;
 Real b = 2;
 Real x;
 Real y;
algorithm
 x := a;
 y := b;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AlgorithmTransformation1",
			description="Generating functions from algorithms: simple algorithm",
			flatModel="
fclass FunctionTests.AlgorithmTransformation1
 Real a;
 Real b;
 Real x;
 Real y;
equation
 (x, y) = FunctionTests.AlgorithmTransformation1.algorithm_1(a, b);
 a = 1;
 b = 2;

public
 function FunctionTests.AlgorithmTransformation1.algorithm_1
  output Real x;
  output Real y;
  input Real a;
  input Real b;
 algorithm
  x := a;
  y := b;
  return;
 end FunctionTests.AlgorithmTransformation1.algorithm_1;

end FunctionTests.AlgorithmTransformation1;
")})));
end AlgorithmTransformation1;


model AlgorithmTransformation2
 Real a = 1;
 Real x;
 Real y;
algorithm
 x := a;
 y := a;
 x := a;
 y := a;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AlgorithmTransformation2",
			description="Generating functions from algorithms: vars used several times",
			flatModel="
fclass FunctionTests.AlgorithmTransformation2
 Real a;
 Real x;
 Real y;
equation
 (x, y) = FunctionTests.AlgorithmTransformation2.algorithm_1(a);
 a = 1;

public
 function FunctionTests.AlgorithmTransformation2.algorithm_1
  output Real x;
  output Real y;
  input Real a;
 algorithm
  x := a;
  y := a;
  x := a;
  y := a;
  return;
 end FunctionTests.AlgorithmTransformation2.algorithm_1;

end FunctionTests.AlgorithmTransformation2;
")})));
end AlgorithmTransformation2;


model AlgorithmTransformation3
 Real a = 1;
 Real b = 2;
 Real x;
 Real y;
algorithm
 x := a + 1;
 if b > 1 then
  y := a + 2;
 end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AlgorithmTransformation3",
			description="Generating functions from algorithms: complex algorithm",
			flatModel="
fclass FunctionTests.AlgorithmTransformation3
 Real a;
 Real b;
 Real x;
 Real y;
equation
 (x, y) = FunctionTests.AlgorithmTransformation3.algorithm_1(a, b);
 a = 1;
 b = 2;

public
 function FunctionTests.AlgorithmTransformation3.algorithm_1
  output Real x;
  output Real y;
  input Real a;
  input Real b;
 algorithm
  x := a + 1;
  if b > 1 then
   y := a + 2;
  end if;
  return;
 end FunctionTests.AlgorithmTransformation3.algorithm_1;

end FunctionTests.AlgorithmTransformation3;
")})));
end AlgorithmTransformation3;


model AlgorithmTransformation4
 Real a = 1;
 Real b = 2;
 Real x;
 Real y;
algorithm
 while b > 1 loop
  x := a;
  if a < 2 then
   y := b;
  else
   y := a + 2;
  end if;
 end while;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AlgorithmTransformation4",
			description="Generating functions from algorithms: complex algorithm",
			flatModel="
fclass FunctionTests.AlgorithmTransformation4
 Real a;
 Real b;
 Real x;
 Real y;
equation
 (x, y) = FunctionTests.AlgorithmTransformation4.algorithm_1(b, a);
 a = 1;
 b = 2;

public
 function FunctionTests.AlgorithmTransformation4.algorithm_1
  output Real x;
  output Real y;
  input Real b;
  input Real a;
 algorithm
  while b > 1 loop
   x := a;
   if a < 2 then
    y := b;
   else
    y := a + 2;
   end if;
  end while;
  return;
 end FunctionTests.AlgorithmTransformation4.algorithm_1;

end FunctionTests.AlgorithmTransformation4;
")})));
end AlgorithmTransformation4;


model AlgorithmTransformation5
 Real x;
 Real y;
algorithm
 x := 1;
 y := 2;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AlgorithmTransformation5",
			description="Generating functions from algorithms: no used variables",
			flatModel="
fclass FunctionTests.AlgorithmTransformation5
 Real x;
 Real y;
equation
 (x, y) = FunctionTests.AlgorithmTransformation5.algorithm_1();

public
 function FunctionTests.AlgorithmTransformation5.algorithm_1
  output Real x;
  output Real y;
 algorithm
  x := 1;
  y := 2;
  return;
 end FunctionTests.AlgorithmTransformation5.algorithm_1;

end FunctionTests.AlgorithmTransformation5;
")})));
end AlgorithmTransformation5;


model AlgorithmTransformation6
 Real x;
 Real y;
algorithm
 x := 1;
algorithm
 y := 2;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AlgorithmTransformation6",
			description="Generating functions from algorithms: 2 algorithms",
			flatModel="
fclass FunctionTests.AlgorithmTransformation6
 Real x;
 Real y;
equation
 (x) = FunctionTests.AlgorithmTransformation6.algorithm_1();
 (y) = FunctionTests.AlgorithmTransformation6.algorithm_2();

public
 function FunctionTests.AlgorithmTransformation6.algorithm_1
  output Real x;
 algorithm
  x := 1;
  return;
 end FunctionTests.AlgorithmTransformation6.algorithm_1;

 function FunctionTests.AlgorithmTransformation6.algorithm_2
  output Real y;
 algorithm
  y := 2;
  return;
 end FunctionTests.AlgorithmTransformation6.algorithm_2;

end FunctionTests.AlgorithmTransformation6;
")})));
end AlgorithmTransformation6;


model AlgorithmTransformation7
 function algorithm_1
  input Real i;
  output Real o = i * 2;
  algorithm
 end algorithm_1;
 
 Real x;
algorithm
 x := algorithm_1(2);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AlgorithmTransformation7",
			description="Generating functions from algorithms: generated name exists - function",
			flatModel="
fclass FunctionTests.AlgorithmTransformation7
 Real x;
equation
 (x) = FunctionTests.AlgorithmTransformation7.algorithm_2();

public
 function FunctionTests.AlgorithmTransformation7.algorithm_1
  input Real i;
  output Real o;
 algorithm
  o := i * 2;
  return;
 end FunctionTests.AlgorithmTransformation7.algorithm_1;

 function FunctionTests.AlgorithmTransformation7.algorithm_2
  output Real x;
 algorithm
  x := FunctionTests.AlgorithmTransformation7.algorithm_1(2);
  return;
 end FunctionTests.AlgorithmTransformation7.algorithm_2;

end FunctionTests.AlgorithmTransformation7;
")})));
end AlgorithmTransformation7;


model AlgorithmTransformation8
 model algorithm_1
  Real a;
  Real b;
 end algorithm_1;
 
 algorithm_1 x;
algorithm
 x.a := 2;
 x.b := 3;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AlgorithmTransformation8",
			description="Generating functions from algorithms: generated name exists - model",
			flatModel="
fclass FunctionTests.AlgorithmTransformation8
 Real x.a;
 Real x.b;
equation
 (x.a, x.b) = FunctionTests.AlgorithmTransformation8.algorithm_1();

public
 function FunctionTests.AlgorithmTransformation8.algorithm_1
  output Real x.a;
  output Real x.b;
 algorithm
  x.a := 2;
  x.b := 3;
  return;
 end FunctionTests.AlgorithmTransformation8.algorithm_1;

end FunctionTests.AlgorithmTransformation8;
")})));
end AlgorithmTransformation8;


model AlgorithmTransformation9
 Real algorithm_1;
 Real algorithm_3;
algorithm
 algorithm_1 := 1;
algorithm
 algorithm_3 := 3;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AlgorithmTransformation9",
			description="Generating functions from algorithms: generated name exists - component",
			flatModel="
fclass FunctionTests.AlgorithmTransformation9
 Real algorithm_1;
 Real algorithm_3;
equation
 (algorithm_1) = FunctionTests.AlgorithmTransformation9.algorithm_2();
 (algorithm_3) = FunctionTests.AlgorithmTransformation9.algorithm_4();

public
 function FunctionTests.AlgorithmTransformation9.algorithm_2
  output Real algorithm_1;
 algorithm
  algorithm_1 := 1;
  return;
 end FunctionTests.AlgorithmTransformation9.algorithm_2;

 function FunctionTests.AlgorithmTransformation9.algorithm_4
  output Real algorithm_3;
 algorithm
  algorithm_3 := 3;
  return;
 end FunctionTests.AlgorithmTransformation9.algorithm_4;

end FunctionTests.AlgorithmTransformation9;
")})));
end AlgorithmTransformation9;


model AlgorithmTransformation10
 Real x;
 Real x_0;
 Real x_1;
algorithm
 x := x_0;
 x_1 := x;
equation
 x_0 = 0;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AlgorithmTransformation10",
			description="Generating functions from algorithms: generated arg name exists",
			flatModel="
fclass FunctionTests.AlgorithmTransformation10
 Real x;
 Real x_0;
 Real x_1;
equation
 x_0 = 0;
 (x, x_1) = FunctionTests.AlgorithmTransformation10.algorithm_1(x_0, 0.0);

public
 function FunctionTests.AlgorithmTransformation10.algorithm_1
  output Real x;
  output Real x_1;
  input Real x_0;
  input Real x_2;
 algorithm
  x := x_2;
  x := x_0;
  x_1 := x;
  return;
 end FunctionTests.AlgorithmTransformation10.algorithm_1;

end FunctionTests.AlgorithmTransformation10;
")})));
end AlgorithmTransformation10;


model AlgorithmTransformation11
 Real x;
 Real y;
algorithm
 x := 1;
 y := x;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AlgorithmTransformation11",
			description="Generating functions from algorithms: assigned variable used",
			flatModel="
fclass FunctionTests.AlgorithmTransformation11
 Real x;
 Real y;
equation
 (x, y) = FunctionTests.AlgorithmTransformation11.algorithm_1(0.0);

public
 function FunctionTests.AlgorithmTransformation11.algorithm_1
  output Real x;
  output Real y;
  input Real x_0;
 algorithm
  x := x_0;
  x := 1;
  y := x;
  return;
 end FunctionTests.AlgorithmTransformation11.algorithm_1;

end FunctionTests.AlgorithmTransformation11;
")})));
end AlgorithmTransformation11;


model AlgorithmTransformation12
 Real x0;
 Real x1(start=1);
 Real x2(start=2);
 Real y;
algorithm
 x0 := 1;
 x1 := x0;
 x2 := x1;
 y := x2;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AlgorithmTransformation12",
			description="Generating functions from algorithms: assigned variables used, different start values",
			flatModel="
fclass FunctionTests.AlgorithmTransformation12
 Real x0;
 Real x1(start = 1);
 Real x2(start = 2);
 Real y;
equation
 (x0, x1, x2, y) = FunctionTests.AlgorithmTransformation12.algorithm_1(0.0, 1, 2);

public
 function FunctionTests.AlgorithmTransformation12.algorithm_1
  output Real x0;
  output Real x1;
  output Real x2;
  output Real y;
  input Real x0_0;
  input Real x1_0;
  input Real x2_0;
 algorithm
  x0 := x0_0;
  x1 := x1_0;
  x2 := x2_0;
  x0 := 1;
  x1 := x0;
  x2 := x1;
  y := x2;
  return;
 end FunctionTests.AlgorithmTransformation12.algorithm_1;

end FunctionTests.AlgorithmTransformation12;
")})));
end AlgorithmTransformation12;


model AlgorithmTransformation13
 Real x = 2;
algorithm
 if x < 3 then
  TestFunction1(x);
 end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AlgorithmTransformation13",
			description="Generating functions from algorithms: no assignments",
			flatModel="
fclass FunctionTests.AlgorithmTransformation13
 Real x;
equation
 FunctionTests.AlgorithmTransformation13.algorithm_1(x);
 x = 2;

public
 function FunctionTests.TestFunction1
  input Real i1;
  output Real o1;
 algorithm
  o1 := i1;
  return;
 end FunctionTests.TestFunction1;

 function FunctionTests.AlgorithmTransformation13.algorithm_1
  input Real x;
 algorithm
  if x < 3 then
   FunctionTests.TestFunction1(x);
  end if;
  return;
 end FunctionTests.AlgorithmTransformation13.algorithm_1;

end FunctionTests.AlgorithmTransformation13;
")})));
end AlgorithmTransformation13;


model AlgorithmTransformation14
 Real x;
algorithm
 x := 0;
 for i in 1:3 loop
  x := x + i;
 end for;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AlgorithmTransformation14",
			description="Generating functions from algorithms: using for index",
			flatModel="
fclass FunctionTests.AlgorithmTransformation14
 Real x;
equation
 (x) = FunctionTests.AlgorithmTransformation14.algorithm_1(0.0);

public
 function FunctionTests.AlgorithmTransformation14.algorithm_1
  output Real x;
  input Real x_0;
 algorithm
  x := x_0;
  x := 0;
  for i in 1:3 loop
   x := x + i;
  end for;
  return;
 end FunctionTests.AlgorithmTransformation14.algorithm_1;

end FunctionTests.AlgorithmTransformation14;
")})));
end AlgorithmTransformation14;


model AlgorithmTransformation15
	Real a_in = 1;
	Real b_in = 2;
	Real c_out;
	Real d_out;

	function f
		input Real a;
		input Real b;
		output Real c = a;
		output Real d = b;
	algorithm
	end f;

algorithm
	(c_out, d_out) := f(a_in, b_in);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AlgorithmTransformation15",
			description="Generating functions from algorithms: function call statement",
			flatModel="
fclass FunctionTests.AlgorithmTransformation15
 Real a_in;
 Real b_in;
 Real c_out;
 Real d_out;
equation
 (c_out, d_out) = FunctionTests.AlgorithmTransformation15.algorithm_1(a_in, b_in);
 a_in = 1;
 b_in = 2;

public
 function FunctionTests.AlgorithmTransformation15.f
  input Real a;
  input Real b;
  output Real c;
  output Real d;
 algorithm
  c := a;
  d := b;
  return;
 end FunctionTests.AlgorithmTransformation15.f;

 function FunctionTests.AlgorithmTransformation15.algorithm_1
  output Real c_out;
  output Real d_out;
  input Real a_in;
  input Real b_in;
 algorithm
  (c_out, d_out) := FunctionTests.AlgorithmTransformation15.f(a_in, b_in);
  return;
 end FunctionTests.AlgorithmTransformation15.algorithm_1;

end FunctionTests.AlgorithmTransformation15;
")})));
end AlgorithmTransformation15;



/* =========================== Arrays in functions =========================== */

model ArrayExpInFunc1
 function f
  output Real o = 1.0;
  protected Real x[3];
 algorithm
  x := { 1, 2, 3 };
 end f;
 
 Real x = f();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayExpInFunc1",
			description="Scalarization of functions: assign from array",
			flatModel="
fclass FunctionTests.ArrayExpInFunc1
 Real x;
equation
 x = FunctionTests.ArrayExpInFunc1.f();

public
 function FunctionTests.ArrayExpInFunc1.f
  output Real o;
  Real[3] x;
 algorithm
  o := 1.0;
  x[1] := 1;
  x[2] := 2;
  x[3] := 3;
  return;
 end FunctionTests.ArrayExpInFunc1.f;

end FunctionTests.ArrayExpInFunc1;
")})));
end ArrayExpInFunc1;


model ArrayExpInFunc2
 function f
  output Real o = 1.0;
  protected Real x[2,2];
 algorithm
  x := {{1,2},{3,4}} * {{1,2},{3,4}};
 end f;
 
 Real x = f();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayExpInFunc2",
			description="Scalarization of functions: assign from array exp",
			flatModel="
fclass FunctionTests.ArrayExpInFunc2
 Real x;
equation
 x = FunctionTests.ArrayExpInFunc2.f();

public
 function FunctionTests.ArrayExpInFunc2.f
  output Real o;
  Real[2, 2] x;
 algorithm
  o := 1.0;
  x[1,1] := 1 * 1 + 2 * 3;
  x[1,2] := 1 * 2 + 2 * 4;
  x[2,1] := 3 * 1 + 4 * 3;
  x[2,2] := 3 * 2 + 4 * 4;
  return;
 end FunctionTests.ArrayExpInFunc2.f;

end FunctionTests.ArrayExpInFunc2;
")})));
end ArrayExpInFunc2;


model ArrayExpInFunc3
 function f
  output Real o = 1.0;
  protected Real x[2,2];
 algorithm
  x[1,:] := {1,2};
  x[2,:] := {3,4};
 end f;
 
 Real x = f();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayExpInFunc3",
			description="Scalarization of functions: assign to slice",
			flatModel="
fclass FunctionTests.ArrayExpInFunc3
 Real x;
equation
 x = FunctionTests.ArrayExpInFunc3.f();

public
 function FunctionTests.ArrayExpInFunc3.f
  output Real o;
  Real[2, 2] x;
 algorithm
  o := 1.0;
  x[1,1] := 1;
  x[1,2] := 2;
  x[2,1] := 3;
  x[2,2] := 4;
  return;
 end FunctionTests.ArrayExpInFunc3.f;

end FunctionTests.ArrayExpInFunc3;
")})));
end ArrayExpInFunc3;


model ArrayExpInFunc4
 function f
  output Real o = 1.0;
  protected Real x[2,2] = {{1,2},{3,4}} * {{1,2},{3,4}};
 algorithm
 end f;
 
 Real x = f();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayExpInFunc4",
			description="Scalarization of functions: binding exp to array var",
			flatModel="
fclass FunctionTests.ArrayExpInFunc4
 Real x;
equation
 x = FunctionTests.ArrayExpInFunc4.f();

public
 function FunctionTests.ArrayExpInFunc4.f
  output Real o;
  Real[2, 2] x;
 algorithm
  o := 1.0;
  x[1,1] := 1 * 1 + 2 * 3;
  x[1,2] := 1 * 2 + 2 * 4;
  x[2,1] := 3 * 1 + 4 * 3;
  x[2,2] := 3 * 2 + 4 * 4;
  return;
 end FunctionTests.ArrayExpInFunc4.f;

end FunctionTests.ArrayExpInFunc4;
")})));
end ArrayExpInFunc4;


model ArrayExpInFunc5
 function f
  input Real a;
  output Real o;
  protected Real x;
  protected Real y;
 algorithm
  (x, y) := f2({1,2,3} * {1,2,3});
  o := a + x + y;
 end f;
 
 function f2
  input Real a;
  output Real b = a;
  output Real c = a;
 algorithm
 end f2;
 
 Real x = f({1,2,3} * {1,2,3});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayExpInFunc5",
			description="Scalarization of functions: (x, y) := f(...) syntax",
			flatModel="
fclass FunctionTests.ArrayExpInFunc5
 Real x;
equation
 x = FunctionTests.ArrayExpInFunc5.f(1 * 1 + 2 * 2 + 3 * 3);

public
 function FunctionTests.ArrayExpInFunc5.f
  input Real a;
  output Real o;
  Real x;
  Real y;
 algorithm
  (x, y) := FunctionTests.ArrayExpInFunc5.f2(1 * 1 + 2 * 2 + 3 * 3);
  o := a + x + y;
  return;
 end FunctionTests.ArrayExpInFunc5.f;

 function FunctionTests.ArrayExpInFunc5.f2
  input Real a;
  output Real b;
  output Real c;
 algorithm
  b := a;
  c := a;
  return;
 end FunctionTests.ArrayExpInFunc5.f2;

end FunctionTests.ArrayExpInFunc5;
")})));
end ArrayExpInFunc5;


model ArrayExpInFunc6
 function f
  output Real o = 1.0;
  protected Real x[3];
 algorithm
  if o < 2.0 then
   x := { 1, 2, 3 };
  elseif o < 1.5 then
   x := { 4, 5, 6 };
  else
   x := { 7, 8, 9 };
  end if;
 end f;
 
 Real x = f();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayExpInFunc6",
			description="Scalarization of functions: if statements",
			flatModel="
fclass FunctionTests.ArrayExpInFunc6
 Real x;
equation
 x = FunctionTests.ArrayExpInFunc6.f();

public
 function FunctionTests.ArrayExpInFunc6.f
  output Real o;
  Real[3] x;
 algorithm
  o := 1.0;
  if o < 2.0 then
   x[1] := 1;
   x[2] := 2;
   x[3] := 3;
  elseif o < 1.5 then
   x[1] := 4;
   x[2] := 5;
   x[3] := 6;
  else
   x[1] := 7;
   x[2] := 8;
   x[3] := 9;
  end if;
  return;
 end FunctionTests.ArrayExpInFunc6.f;

end FunctionTests.ArrayExpInFunc6;
")})));
end ArrayExpInFunc6;


model ArrayExpInFunc7
 Real o = 1.0;
 Real x[3];
algorithm
 when {o < 2.0, o > 3.0} then
  x := { 1, 2, 3 };
 elsewhen o < 1.5 then
  x := { 4, 5, 6 };
 end when;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayExpInFunc7",
			description="Scalarization of functions: when statements",
			flatModel="
fclass FunctionTests.ArrayExpInFunc7
 Real o;
 Real x[1];
 Real x[2];
 Real x[3];
equation
 ({x[1], x[2], x[3]}) = FunctionTests.ArrayExpInFunc7.algorithm_1(o);
 o = 1.0;

public
 function FunctionTests.ArrayExpInFunc7.algorithm_1
  output Real[3] x;
  input Real o;
 algorithm
  when o < 2.0 or o > 3.0 then
   x[1] := 1;
   x[2] := 2;
   x[3] := 3;
  elsewhen o < 1.5 then
   x[1] := 4;
   x[2] := 5;
   x[3] := 6;
  end when;
  return;
 end FunctionTests.ArrayExpInFunc7.algorithm_1;

end FunctionTests.ArrayExpInFunc7;
")})));
end ArrayExpInFunc7;


model ArrayExpInFunc8
 function f
  output Real o = 1.0;
  protected Real x[3];
  protected Real y[3];
 algorithm
  for i in 1:3 loop
   x[i] := i;
   y := {i*i for i in 1:3};
  end for;
 end f;
 
 Real x = f();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayExpInFunc8",
			description="Scalarization of functions: for statements",
			flatModel="
fclass FunctionTests.ArrayExpInFunc8
 Real x;
equation
 x = FunctionTests.ArrayExpInFunc8.f();

public
 function FunctionTests.ArrayExpInFunc8.f
  output Real o;
  Real[3] x;
  Real[3] y;
 algorithm
  o := 1.0;
  for i in 1:3 loop
   x[i] := i;
   y[1] := 1 * 1;
   y[2] := 2 * 2;
   y[3] := 3 * 3;
  end for;
  return;
 end FunctionTests.ArrayExpInFunc8.f;

end FunctionTests.ArrayExpInFunc8;
")})));
end ArrayExpInFunc8;


model ArrayExpInFunc9
 function f
  output Real o = 1.0;
  protected Real x[3];
  protected Integer y = 3;
 algorithm
  while y > 0 loop
   x := 1:3;
   x[y] := y;
   y := y - 1;
  end while;
 end f;
 
 Real x = f();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayExpInFunc9",
			description="Scalarization of functions: while statements",
			flatModel="
fclass FunctionTests.ArrayExpInFunc9
 Real x;
equation
 x = FunctionTests.ArrayExpInFunc9.f();

public
 function FunctionTests.ArrayExpInFunc9.f
  output Real o;
  Real[3] x;
  Integer y;
 algorithm
  o := 1.0;
  y := 3;
  while y > 0 loop
   x[1] := 1;
   x[2] := 2;
   x[3] := 3;
   x[y] := y;
   y := y - 1;
  end while;
  return;
 end FunctionTests.ArrayExpInFunc9.f;

end FunctionTests.ArrayExpInFunc9;
")})));
end ArrayExpInFunc9;



model ArrayOutputScalarization1
 function f
  output Real x[2] = {1,2};
  output Real y[2] = {1,2};
 algorithm
 end f;
 
 Real x[2];
 Real y[2];
equation
 (x,y) = f();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization1",
			description="Scalarization of array function outputs: function call equation",
			flatModel="
fclass FunctionTests.ArrayOutputScalarization1
 Real x[1];
 Real x[2];
 Real y[1];
 Real y[2];
equation
 ({x[1], x[2]}, {y[1], y[2]}) = FunctionTests.ArrayOutputScalarization1.f();

public
 function FunctionTests.ArrayOutputScalarization1.f
  output Real[2] x;
  output Real[2] y;
 algorithm
  x[1] := 1;
  x[2] := 2;
  y[1] := 1;
  y[2] := 2;
  return;
 end FunctionTests.ArrayOutputScalarization1.f;

end FunctionTests.ArrayOutputScalarization1;
")})));
end ArrayOutputScalarization1;


model ArrayOutputScalarization2
 function f
  output Real x[2] = {1,2};
 algorithm
 end f;
 
 Real x[2];
equation
 x = {3,4} + f();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization2",
			description="Scalarization of array function outputs: expression with func call",
			flatModel="
fclass FunctionTests.ArrayOutputScalarization2
 Real x[1];
 Real x[2];
 Real temp_1[1];
 Real temp_1[2];
equation
 ({temp_1[1],temp_1[2]}) = FunctionTests.ArrayOutputScalarization2.f();
 x[1] = 3 + temp_1[1];
 x[2] = 4 + temp_1[2];

public
 function FunctionTests.ArrayOutputScalarization2.f
  output Real[2] x;
 algorithm
  x[1] := 1;
  x[2] := 2;
  return;
 end FunctionTests.ArrayOutputScalarization2.f;

end FunctionTests.ArrayOutputScalarization2;
")})));
end ArrayOutputScalarization2;


model ArrayOutputScalarization3
 function f
  output Real x[2] = {1, 2};
 algorithm
 end f;
 
 Real x[2];
 Real temp = 1;
 Real temp_1 = 2;
 Real temp_3 = 3;
equation
 x = {1,2} + f();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization3",
			description="Scalarization of array function outputs: finding free temp name",
			flatModel="
fclass FunctionTests.ArrayOutputScalarization3
 Real x[1];
 Real x[2];
 Real temp;
 Real temp_1;
 Real temp_3;
 Real temp_2[1];
 Real temp_2[2];
equation
 ({temp_2[1],temp_2[2]}) = FunctionTests.ArrayOutputScalarization3.f();
 x[1] = 1 + temp_2[1];
 x[2] = 2 + temp_2[2];
 temp = 1;
 temp_1 = 2;
 temp_3 = 3;

public
 function FunctionTests.ArrayOutputScalarization3.f
  output Real[2] x;
 algorithm
  x[1] := 1;
  x[2] := 2;
  return;
 end FunctionTests.ArrayOutputScalarization3.f;

end FunctionTests.ArrayOutputScalarization3;
")})));
end ArrayOutputScalarization3;


model ArrayOutputScalarization4
 function f1
  output Real x[2] = {1,2};
  output Real y[2] = {1,2};
 algorithm
 end f1;
 
 function f2
  output Real x;
  protected Real y[2];
  protected Real z[2];
 algorithm
  (y,z) := f1();
  x := y[1];
 end f2;
 
 Real x = f2();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization4",
			description="Scalarization of array function outputs: function call statement",
			flatModel="
fclass FunctionTests.ArrayOutputScalarization4
 Real x;
equation
 x = FunctionTests.ArrayOutputScalarization4.f2();

public
 function FunctionTests.ArrayOutputScalarization4.f2
  output Real x;
  Real[2] y;
  Real[2] z;
 algorithm
  (y, z) := FunctionTests.ArrayOutputScalarization4.f1();
  x := y[1];
  return;
 end FunctionTests.ArrayOutputScalarization4.f2;

 function FunctionTests.ArrayOutputScalarization4.f1
  output Real[2] x;
  output Real[2] y;
 algorithm
  x[1] := 1;
  x[2] := 2;
  y[1] := 1;
  y[2] := 2;
  return;
 end FunctionTests.ArrayOutputScalarization4.f1;

end FunctionTests.ArrayOutputScalarization4;
")})));
end ArrayOutputScalarization4;


model ArrayOutputScalarization5
 function f1
  output Real x[2] = {1, 2};
 algorithm
 end f1;
 
 function f2
  output Real x;
  protected Real y[2];
 algorithm
  y := {1,2} + f1();
  x := y[1];
 end f2;
 
 Real x = f2();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization5",
			description="Scalarization of array function outputs: assign statement with expression",
			flatModel="
fclass FunctionTests.ArrayOutputScalarization5
 Real x;
equation
 x = FunctionTests.ArrayOutputScalarization5.f2();

public
 function FunctionTests.ArrayOutputScalarization5.f2
  output Real x;
  Real[2] y;
  Real[2] temp_1;
 algorithm
  (temp_1) := FunctionTests.ArrayOutputScalarization5.f1();
  y[1] := 1 + temp_1[1];
  y[2] := 2 + temp_1[2];
  x := y[1];
  return;
 end FunctionTests.ArrayOutputScalarization5.f2;

 function FunctionTests.ArrayOutputScalarization5.f1
  output Real[2] x;
 algorithm
  x[1] := 1;
  x[2] := 2;
  return;
 end FunctionTests.ArrayOutputScalarization5.f1;

end FunctionTests.ArrayOutputScalarization5;
")})));
end ArrayOutputScalarization5;


model ArrayOutputScalarization6

 function f1
  output Real x[2] = {1, 2};
 algorithm
 end f1;
 
 function f2
  output Real x;
  protected Real y[2];
  protected Real temp_1;
 algorithm
  y := f1();
  x := y[1];
 end f2;
 
 Real x = f2();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization6",
			description="Scalarization of array function outputs: finding free temp name",
			flatModel="
fclass FunctionTests.ArrayOutputScalarization6
 Real x;
equation
 x = FunctionTests.ArrayOutputScalarization6.f2();

public
 function FunctionTests.ArrayOutputScalarization6.f2
  output Real x;
  Real[2] y;
  Real temp_1;
 algorithm
  (y) := FunctionTests.ArrayOutputScalarization6.f1();
  x := y[1];
  return;
 end FunctionTests.ArrayOutputScalarization6.f2;

 function FunctionTests.ArrayOutputScalarization6.f1
  output Real[2] x;
 algorithm
  x[1] := 1;
  x[2] := 2;
  return;
 end FunctionTests.ArrayOutputScalarization6.f1;

end FunctionTests.ArrayOutputScalarization6;
")})));
end ArrayOutputScalarization6;


model ArrayOutputScalarization7
 function f1
  output Real x[2] = {1, 2};
 algorithm
 end f1;
 
 function f2
  output Real x;
  protected Real y[2];
 algorithm
  if sum(f1()) < 4 then
   x := 1;
   y := {1,2} + f1();
  elseif sum(f1()) < 5 then
   y := {3,4};
  else
   x := 1;
   y := f1();
  end if;
  x := y[1];
 end f2;
 
 Real x = f2();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization7",
			description="Scalarization of array function outputs: if statement",
			flatModel="
fclass FunctionTests.ArrayOutputScalarization7
 Real x;
equation
 x = FunctionTests.ArrayOutputScalarization7.f2();

public
 function FunctionTests.ArrayOutputScalarization7.f2
  output Real x;
  Real[2] y;
  Real[2] temp_1;
  Real[2] temp_2;
  Real[2] temp_3;
 algorithm
  (temp_1) := FunctionTests.ArrayOutputScalarization7.f1();
  (temp_2) := FunctionTests.ArrayOutputScalarization7.f1();
  if temp_1[1] + temp_1[2] < 4 then
   x := 1;
   (temp_3) := FunctionTests.ArrayOutputScalarization7.f1();
   y[1] := 1 + temp_3[1];
   y[2] := 2 + temp_3[2];
  elseif temp_2[1] + temp_2[2] < 5 then
   y[1] := 3;
   y[2] := 4;
  else
   x := 1;
   (y) := FunctionTests.ArrayOutputScalarization7.f1();
  end if;
  x := y[1];
  return;
 end FunctionTests.ArrayOutputScalarization7.f2;

 function FunctionTests.ArrayOutputScalarization7.f1
  output Real[2] x;
 algorithm
  x[1] := 1;
  x[2] := 2;
  return;
 end FunctionTests.ArrayOutputScalarization7.f1;

end FunctionTests.ArrayOutputScalarization7;
")})));
end ArrayOutputScalarization7;


model ArrayOutputScalarization8
 function f1
  output Real x[2] = {1, 2};
 algorithm
 end f1;
 
 function f2
  output Real x;
  protected Real y[2];
 algorithm
  for i in f1() loop
   y[1] := i;
   y := f1();
  end for;
  x := y[1];
 end f2;
 
 Real x = f2();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization8",
			description="Scalarization of array function outputs: for statement",
			flatModel="
fclass FunctionTests.ArrayOutputScalarization8
 Real x;
equation
 x = FunctionTests.ArrayOutputScalarization8.f2();

public
 function FunctionTests.ArrayOutputScalarization8.f2
  output Real x;
  Real[2] y;
  Real[2] temp_1;
 algorithm
  (temp_1) := FunctionTests.ArrayOutputScalarization8.f1();
  for i in {temp_1[1],temp_1[2]} loop
   y[1] := i;
   (y) := FunctionTests.ArrayOutputScalarization8.f1();
  end for;
  x := y[1];
  return;
 end FunctionTests.ArrayOutputScalarization8.f2;

 function FunctionTests.ArrayOutputScalarization8.f1
  output Real[2] x;
 algorithm
  x[1] := 1;
  x[2] := 2;
  return;
 end FunctionTests.ArrayOutputScalarization8.f1;

end FunctionTests.ArrayOutputScalarization8;
")})));
end ArrayOutputScalarization8;


model ArrayOutputScalarization9
 function f
  output Real x[2] = {1, 2};
 algorithm
 end f;
 
 Real x[2];
equation
 x = f();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization9",
			description="Scalarization of array function outputs: equation without expression",
			eliminate_alias_variables=false,
			flatModel="
fclass FunctionTests.ArrayOutputScalarization9
 Real x[1];
 Real x[2];
 Real temp_1[1];
 Real temp_1[2];
equation
 ({temp_1[1],temp_1[2]}) = FunctionTests.ArrayOutputScalarization9.f();
 x[1] = temp_1[1];
 x[2] = temp_1[2];

public
 function FunctionTests.ArrayOutputScalarization9.f
  output Real[2] x;
 algorithm
  x[1] := 1;
  x[2] := 2;
  return;
 end FunctionTests.ArrayOutputScalarization9.f;

end FunctionTests.ArrayOutputScalarization9;
")})));
end ArrayOutputScalarization9;


model ArrayOutputScalarization10
 function f1
  output Real x[2] = {1, 2};
 algorithm
 end f1;
 
 function f2
  output Real x = 0;
 algorithm
  while x < sum(f1()) loop
   x := x + 1;
  end while;
 end f2;
 
 Real x = f2();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization10",
			description="Scalarization of array function outputs: while statement",
			flatModel="
fclass FunctionTests.ArrayOutputScalarization10
 Real x;
equation
 x = FunctionTests.ArrayOutputScalarization10.f2();

public
 function FunctionTests.ArrayOutputScalarization10.f2
  output Real x;
  Real[2] temp_1;
 algorithm
  x := 0;
  (temp_1) := FunctionTests.ArrayOutputScalarization10.f1();
  while x < temp_1[1] + temp_1[2] loop
   x := x + 1;
   (temp_1) := FunctionTests.ArrayOutputScalarization10.f1();
  end while;
  return;
 end FunctionTests.ArrayOutputScalarization10.f2;

 function FunctionTests.ArrayOutputScalarization10.f1
  output Real[2] x;
 algorithm
  x[1] := 1;
  x[2] := 2;
  return;
 end FunctionTests.ArrayOutputScalarization10.f1;

end FunctionTests.ArrayOutputScalarization10;
")})));
end ArrayOutputScalarization10;


model ArrayOutputScalarization11
 function f1
  output Real x[2] = {1, 2};
 algorithm
 end f1;
 
 function f2
  output Real x;
  protected Real y[2] = f1();
 algorithm
  x := y[1];
 end f2;
 
 Real x = f2();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization11",
			description="Scalarization of array function outputs: binding expression",
			flatModel="
fclass FunctionTests.ArrayOutputScalarization11
 Real x;
equation
 x = FunctionTests.ArrayOutputScalarization11.f2();

public
 function FunctionTests.ArrayOutputScalarization11.f1
  output Real[2] x;
 algorithm
  x[1] := 1;
  x[2] := 2;
  return;
 end FunctionTests.ArrayOutputScalarization11.f1;

 function FunctionTests.ArrayOutputScalarization11.f2
  output Real x;
  Real[2] y;
 algorithm
  (y) := FunctionTests.ArrayOutputScalarization11.f1();
  x := y[1];
  return;
 end FunctionTests.ArrayOutputScalarization11.f2;

end FunctionTests.ArrayOutputScalarization11;
")})));
end ArrayOutputScalarization11;


model ArrayOutputScalarization12
 function f1
  output Real x[2] = {1, 2};
 algorithm
 end f1;
 
 function f2
  output Real x;
  protected Real y[2] = f1() + {3, 4};
 algorithm
  x := y[1];
 end f2;
 
 Real x = f2();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization12",
			description="Scalarization of array function outputs: part of binding expression",
			flatModel="
fclass FunctionTests.ArrayOutputScalarization12
 Real x;
equation
 x = FunctionTests.ArrayOutputScalarization12.f2();

public
 function FunctionTests.ArrayOutputScalarization12.f1
  output Real[2] x;
 algorithm
  x[1] := 1;
  x[2] := 2;
  return;
 end FunctionTests.ArrayOutputScalarization12.f1;

 function FunctionTests.ArrayOutputScalarization12.f2
  output Real x;
  Real[2] y;
  Real[2] temp_1;
 algorithm
  (temp_1) := FunctionTests.ArrayOutputScalarization12.f1();
  y[1] := temp_1[1] + 3;
  y[2] := temp_1[2] + 4;
  x := y[1];
  return;
 end FunctionTests.ArrayOutputScalarization12.f2;

end FunctionTests.ArrayOutputScalarization12;
")})));
end ArrayOutputScalarization12;


model ArrayOutputScalarization13
 function f1
  output Real x[2] = {1, 2};
 algorithm
 end f1;
 
 function f2
  output Real x;
  protected Real y = sum(f1());
 algorithm
  x := y;
 end f2;
 
 Real x = f2();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization13",
			description="Scalarization of array function outputs: part of scalar binding exp",
			flatModel="
fclass FunctionTests.ArrayOutputScalarization13
 Real x;
equation
 x = FunctionTests.ArrayOutputScalarization13.f2();

public
 function FunctionTests.ArrayOutputScalarization13.f1
  output Real[2] x;
 algorithm
  x[1] := 1;
  x[2] := 2;
  return;
 end FunctionTests.ArrayOutputScalarization13.f1;

 function FunctionTests.ArrayOutputScalarization13.f2
  output Real x;
  Real y;
  Real[2] temp_1;
 algorithm
  (temp_1) := FunctionTests.ArrayOutputScalarization13.f1();
  y := temp_1[1] + temp_1[2];
  x := y;
  return;
 end FunctionTests.ArrayOutputScalarization13.f2;

end FunctionTests.ArrayOutputScalarization13;
")})));
end ArrayOutputScalarization13;


model ArrayOutputScalarization14
 function f
  output Real x[2] = {1, 2};
 algorithm
 end f;
 
 Real x = f() * {3, 4};

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization14",
			description="Scalarization of array function outputs: part of scalar expression",
			flatModel="
fclass FunctionTests.ArrayOutputScalarization14
 Real x;
 Real temp_1[1];
 Real temp_1[2];
equation
 ({temp_1[1], temp_1[2]}) = FunctionTests.ArrayOutputScalarization14.f();
 x = temp_1[1] * 3 + temp_1[2] * 4;

public
 function FunctionTests.ArrayOutputScalarization14.f
  output Real[2] x;
 algorithm
  x[1] := 1;
  x[2] := 2;
  return;
 end FunctionTests.ArrayOutputScalarization14.f;

end FunctionTests.ArrayOutputScalarization14;
")})));
end ArrayOutputScalarization14;


model ArrayOutputScalarization15
 function f
  output Real x[2] = {1,2};
  output Real y = 2;
 algorithm
 end f;
 
 Real x[2];
 Real y;
equation
 (x, y) = f();

	annotation(__JModelica(UnitTesting(tests={
		GenericCodeGenTestCase(
			name="ArrayOutputScalarization15",
			description="Scalarization of array function outputs: number of equations",
			template="$n_equations$",
			generatedCode="3"
 )})));
end ArrayOutputScalarization15;


model ArrayOutputScalarization16
 function f1
  output Real o = 2;
  protected Real x[2] = {1,2};
  protected Real y[2];
 algorithm
  y := f2(x);
 end f1;
 
 function f2
  input Real x[2];
  output Real y[2] = x;
 algorithm
 end f2;
 
 Real x = f1();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization16",
			description="Scalarization of array function outputs: using original arrays",
			flatModel="
fclass FunctionTests.ArrayOutputScalarization16
 Real x;
equation
 x = FunctionTests.ArrayOutputScalarization16.f1();

public
 function FunctionTests.ArrayOutputScalarization16.f1
  output Real o;
  Real[2] x;
  Real[2] y;
 algorithm
  o := 2;
  x[1] := 1;
  x[2] := 2;
  (y) := FunctionTests.ArrayOutputScalarization16.f2(x);
  return;
 end FunctionTests.ArrayOutputScalarization16.f1;

 function FunctionTests.ArrayOutputScalarization16.f2
  input Real[2] x;
  output Real[2] y;
 algorithm
  y[1] := x[1];
  y[2] := x[2];
  return;
 end FunctionTests.ArrayOutputScalarization16.f2;

end FunctionTests.ArrayOutputScalarization16;
")})));
end ArrayOutputScalarization16;


model ArrayOutputScalarization17
 function f1
  output Real o = 2;
  protected Real y[2];
 algorithm
  y := f2(f2({1,2}));
 end f1;
 
 function f2
  input Real x[2];
  output Real y[2] = x;
 algorithm
 end f2;
 
 Real x = f1();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization17",
			description="Scalarization of array function outputs: using original arrays",
			flatModel="
fclass FunctionTests.ArrayOutputScalarization17
 Real x;
equation
 x = FunctionTests.ArrayOutputScalarization17.f1();

public
 function FunctionTests.ArrayOutputScalarization17.f1
  output Real o;
  Real[2] y;
  Real[2] temp_1;
 algorithm
  o := 2;
  (temp_1) := FunctionTests.ArrayOutputScalarization17.f2({1,2});
  (y) := FunctionTests.ArrayOutputScalarization17.f2(temp_1);
  return;
 end FunctionTests.ArrayOutputScalarization17.f1;

 function FunctionTests.ArrayOutputScalarization17.f2
  input Real[2] x;
  output Real[2] y;
 algorithm
  y[1] := x[1];
  y[2] := x[2];
  return;
 end FunctionTests.ArrayOutputScalarization17.f2;

end FunctionTests.ArrayOutputScalarization17;
")})));
end ArrayOutputScalarization17;


model ArrayOutputScalarization18
    function f1
        input Real[:] a1;
        output Real x1;
    protected
        Real[:] b1 = f2(a1);
    algorithm
        x1 := a1 * b1;
    end f1;
    
    function f2
        input Real[:] a2;
        output Real[size(a2, 1)] x2 = 2 * a2;
    algorithm
    end f2;
    
    Real x = f1({ 1, 2 });

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization18",
			description="Scalarization of binding expression of unknown size for protected var in func",
			flatModel="
fclass FunctionTests.ArrayOutputScalarization18
 Real x;
equation
 x = FunctionTests.ArrayOutputScalarization18.f1({1, 2});

public
 function FunctionTests.ArrayOutputScalarization18.f2
  input Real[:] a2;
  output Real[size(a2, 1)] x2;
 algorithm
  for i1 in 1:size(x2, 1) loop
   x2[i1] := 2 * a2[i1];
  end for;
  return;
 end FunctionTests.ArrayOutputScalarization18.f2;

 function FunctionTests.ArrayOutputScalarization18.f1
  input Real[:] a1;
  output Real x1;
  Real[:] b1;
  Real temp_1;
 algorithm
  size(b1) := {size(a1, 1)};
  (b1) := FunctionTests.ArrayOutputScalarization18.f2(a1);
  temp_1 := 0.0;
  for i1 in 1:size(a1, 1) loop
   temp_1 := temp_1 + a1[i1] * b1[i1];
  end for;
  x1 := temp_1;
  return;
 end FunctionTests.ArrayOutputScalarization18.f1;

end FunctionTests.ArrayOutputScalarization18;
")})));
end ArrayOutputScalarization18;


model ArrayOutputScalarization19
    function f1
        input Real[:] a1;
        output Real x1;
    protected
        Real[2] b1 = f2(a1);
    algorithm
        x1 := sum(b1);
    end f1;
    
    function f2
        input Real[:] a2;
        output Real[size(a2, 1)] x2 = 2 * a2;
    algorithm
    end f2;
    
    Real x = f1({ 1, 2 });

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization19",
			description="Scalarization of binding expression of unknown size for protected var in func",
			flatModel="
fclass FunctionTests.ArrayOutputScalarization19
 Real x;
equation
 x = FunctionTests.ArrayOutputScalarization19.f1({1, 2});

public
 function FunctionTests.ArrayOutputScalarization19.f2
  input Real[:] a2;
  output Real[size(a2, 1)] x2;
 algorithm
  for i1 in 1:size(x2, 1) loop
   x2[i1] := 2 * a2[i1];
  end for;
  return;
 end FunctionTests.ArrayOutputScalarization19.f2;

 function FunctionTests.ArrayOutputScalarization19.f1
  input Real[:] a1;
  output Real x1;
  Real[2] b1;
 algorithm
  (b1) := FunctionTests.ArrayOutputScalarization19.f2(a1);
  x1 := b1[1] + b1[2];
  return;
 end FunctionTests.ArrayOutputScalarization19.f1;

end FunctionTests.ArrayOutputScalarization19;
")})));
end ArrayOutputScalarization19;


model ArrayOutputScalarization20
	record R
		Real a;
		Real b[2];		
	end R;
	
    function f1
        input Real c;
        output R d;
    algorithm
        d := f2(c);
    end f1;
    
    function f2
        input Real e;
        output R f;
    algorithm
        f := R(e, {1,2});
    end f2;
    
    R x = f1(1);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayOutputScalarization20",
			description="Checks for bug in #1895",
			flatModel="
fclass FunctionTests.ArrayOutputScalarization20
 Real x.a;
 Real x.b[1];
 Real x.b[2];
equation
 (FunctionTests.ArrayOutputScalarization20.R(x.a, {x.b[1], x.b[2]})) = FunctionTests.ArrayOutputScalarization20.f1(1);

public
 function FunctionTests.ArrayOutputScalarization20.f1
  input Real c;
  output FunctionTests.ArrayOutputScalarization20.R d;
 algorithm
  (d) := FunctionTests.ArrayOutputScalarization20.f2(c);
  return;
 end FunctionTests.ArrayOutputScalarization20.f1;

 function FunctionTests.ArrayOutputScalarization20.f2
  input Real e;
  output FunctionTests.ArrayOutputScalarization20.R f;
 algorithm
  f.a := e;
  f.b[1] := 1;
  f.b[2] := 2;
  return;
 end FunctionTests.ArrayOutputScalarization20.f2;

 record FunctionTests.ArrayOutputScalarization20.R
  Real a;
  Real b[2];
 end FunctionTests.ArrayOutputScalarization20.R;

end FunctionTests.ArrayOutputScalarization20;
")})));
end ArrayOutputScalarization20;



/* ======================= Unknown array sizes ======================*/

model UnknownArray1
 function f
  input Real a[:];
  output Real b[size(a,1)];
 algorithm
  b := a;
 end f;
 
 Real x[3] = f({1,2,3});
 Real y[2] = f({4,5});

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="UnknownArray1",
			description="Using functions with unknown array sizes: basic type test",
			flatModel="
fclass FunctionTests.UnknownArray1
 Real x[3] = FunctionTests.UnknownArray1.f({1,2,3});
 Real y[2] = FunctionTests.UnknownArray1.f({4,5});

public
 function FunctionTests.UnknownArray1.f
  input Real[:] a;
  output Real[size(a, 1)] b;
 algorithm
  b := a;
  return;
 end FunctionTests.UnknownArray1.f;

end FunctionTests.UnknownArray1;
")})));
end UnknownArray1;


model UnknownArray2
 function f
  input Real a[:];
  output Real b[:] = a;
 algorithm
 end f;
 
 Real x[3] = f({1,2,3});
 Real y[2] = f({4,5});

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="UnknownArray2",
			description="Using functions with unknown array sizes: size from binding exp",
			flatModel="
fclass FunctionTests.UnknownArray2
 Real x[3] = FunctionTests.UnknownArray2.f({1,2,3});
 Real y[2] = FunctionTests.UnknownArray2.f({4,5});

public
 function FunctionTests.UnknownArray2.f
  input Real[:] a;
  output Real[size(a, 1)] b := a;
 algorithm
  return;
 end FunctionTests.UnknownArray2.f;

end FunctionTests.UnknownArray2;
")})));
end UnknownArray2;


model UnknownArray3
 function f
  input Real a[:];
  output Real b[size(c,1)];
  protected Real c[size(a,1)];
 algorithm
  b := a;
 end f;
 
 Real x[3] = f({1,2,3});
 Real y[2] = f({4,5});

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="UnknownArray3",
			description="Using functions with unknown array sizes: indirect dependency",
			flatModel="
fclass FunctionTests.UnknownArray3
 Real x[3] = FunctionTests.UnknownArray3.f({1,2,3});
 Real y[2] = FunctionTests.UnknownArray3.f({4,5});

public
 function FunctionTests.UnknownArray3.f
  input Real[:] a;
  output Real[size(c, 1)] b;
  Real[size(a, 1)] c;
 algorithm
  b := a;
  return;
 end FunctionTests.UnknownArray3.f;

end FunctionTests.UnknownArray3;
")})));
end UnknownArray3;


model UnknownArray4
 function f
  input Real a[:];
  output Real b[:] = c;
  protected Real c[:] = a;
 algorithm
 end f;
 
 Real x[3] = f({1,2,3});
 Real y[2] = f({4,5});

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="UnknownArray4",
			description="Using functions with unknown array sizes: indirect dependency from binding exp",
			flatModel="
fclass FunctionTests.UnknownArray4
 Real x[3] = FunctionTests.UnknownArray4.f({1,2,3});
 Real y[2] = FunctionTests.UnknownArray4.f({4,5});

public
 function FunctionTests.UnknownArray4.f
  input Real[:] a;
  output Real[size(a, 1)] b := c;
  Real[size(a, 1)] c := a;
 algorithm
  return;
 end FunctionTests.UnknownArray4.f;

end FunctionTests.UnknownArray4;
")})));
end UnknownArray4;


model UnknownArray5
 function f
  input Real a[:];
  output Real b[:] = c;
  output Real c[:] = a;
 algorithm
 end f;
 
 Real x[3];
 Real y[3];
equation
 (x, y) = f({1,2,3});

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="UnknownArray5",
			description="Using functions with unknown array sizes: multiple outputs",
			flatModel="
fclass FunctionTests.UnknownArray5
 Real x[3];
 Real y[3];
equation
 (x[1:3], y[1:3]) = FunctionTests.UnknownArray5.f({1,2,3});

public
 function FunctionTests.UnknownArray5.f
  input Real[:] a;
  output Real[size(a, 1)] b := c;
  output Real[size(a, 1)] c := a;
 algorithm
  return;
 end FunctionTests.UnknownArray5.f;

end FunctionTests.UnknownArray5;
")})));
end UnknownArray5;


model UnknownArray6
 function f
  input Real a[:];
  output Real b[:] = c;
  output Real c[:] = a;
 algorithm
 end f;
 
 Real x[2] = f({1,2,3});

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="UnknownArray6",
			description="Using functions with unknown array sizes: wrong size",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 3747, column 7:
  Array size mismatch in declaration of x, size of declaration is [2] and size of binding expression is [3]
")})));
end UnknownArray6;


model UnknownArray7
 function f
  input Real a[:];
  output Real b[:] = c;
  output Real c[:] = a;
 algorithm
 end f;
 
 Real x[3];
 Real y[2];
equation
 (x, y) = f({1,2,3});

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="UnknownArray7",
			description="Using functions with unknown array sizes: wrong size",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 3773, column 2:
  Calling function f(): types of component y and output c are not compatible
")})));
end UnknownArray7;


model UnknownArray8
 function f
  input Real a[:];
  output Real b[size(b,1)];
 algorithm
  b := {1,2};
 end f;
 
 Real x[2] = f({1,2,3});

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="UnknownArray8",
			description="Using functions with unknown array sizes: circular size",
			errorMessage="
2 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 3796, column 7:
  Array size mismatch in declaration of x, size of declaration is [2] and size of binding expression is [size(b, 1)]
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 3796, column 14:
  Could not evaluate array size of output b
")})));
end UnknownArray8;


model UnknownArray9
 function f
  input Real a[:,:];
  input Real b[:,size(a,2)];
  output Real c[size(d,1), size(d,2)];
  protected Real d[:,:] = cat(1, a, b);
 algorithm
  c := d;
 end f;
 
 Real x[5,2] = f({{1,2},{3,4}}, {{5,6},{7,8},{9,0}});

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="UnknownArray9",
			description="Unknown size calculated by adding sizes",
			flatModel="
fclass FunctionTests.UnknownArray9
 Real x[5,2] = FunctionTests.UnknownArray9.f({{1,2},{3,4}}, {{5,6},{7,8},{9,0}});

public
 function FunctionTests.UnknownArray9.f
  input Real[:, :] a;
  input Real[:, size(a, 2)] b;
  output Real[size(d, 1), size(d, 2)] c;
  Real[size(cat(1, a, b), 1), size(cat(1, a, b), 2)] d := cat(1, a, b);
 algorithm
  c := d;
  return;
 end FunctionTests.UnknownArray9.f;

end FunctionTests.UnknownArray9;
")})));
end UnknownArray9;


model UnknownArray10
 function f
  input Real a[:];
  output Real b[size(a,1)];
 algorithm
  b := a;
 end f;
 
 Real x[2] = f({1,2});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray10",
			description="Scalarization of operations on arrays of unknown size: assignment",
			flatModel="
fclass FunctionTests.UnknownArray10
 Real x[1];
 Real x[2];
equation
 ({x[1],x[2]}) = FunctionTests.UnknownArray10.f({1,2});

public
 function FunctionTests.UnknownArray10.f
  input Real[:] a;
  output Real[size(a, 1)] b;
 algorithm
  for i1 in 1:size(b, 1) loop
   b[i1] := a[i1];
  end for;
  return;
 end FunctionTests.UnknownArray10.f;

end FunctionTests.UnknownArray10;
")})));
end UnknownArray10;


model UnknownArray11
 function f
  input Real a[:];
  output Real b[size(a,1)] = a;
 algorithm
 end f;
 
 Real x[2] = f({1,2});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray11",
			description="Scalarization of operations on arrays of unknown size: binding expression",
			flatModel="
fclass FunctionTests.UnknownArray11
 Real x[1];
 Real x[2];
equation
 ({x[1],x[2]}) = FunctionTests.UnknownArray11.f({1,2});

public
 function FunctionTests.UnknownArray11.f
  input Real[:] a;
  output Real[size(a, 1)] b;
 algorithm
  for i1 in 1:size(b, 1) loop
   b[i1] := a[i1];
  end for;
  return;
 end FunctionTests.UnknownArray11.f;

end FunctionTests.UnknownArray11;
")})));
end UnknownArray11;


model UnknownArray12
 function f
  input Real a[:];
  input Real b[:];
  input Real c;
  output Real o[size(a,1)];
 algorithm
  o := c * a + 2 * b;
 end f;
 
 Real x[2] = f({1,2}, {3,4}, 5);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray12",
			description="Scalarization of operations on arrays of unknown size: element-wise expression",
			flatModel="
fclass FunctionTests.UnknownArray12
 Real x[1];
 Real x[2];
equation
 ({x[1], x[2]}) = FunctionTests.UnknownArray12.f({1, 2}, {3, 4}, 5);

public
 function FunctionTests.UnknownArray12.f
  input Real[:] a;
  input Real[:] b;
  input Real c;
  output Real[size(a, 1)] o;
 algorithm
  for i1 in 1:size(o, 1) loop
   o[i1] := c * a[i1] + 2 * b[i1];
  end for;
  return;
 end FunctionTests.UnknownArray12.f;

end FunctionTests.UnknownArray12;
")})));
end UnknownArray12;


model UnknownArray13
 function f
  input Real a[:];
  input Real b[:];
  input Real c;
  output Real o[size(a,1)] = c * a + 2 * b;
 algorithm
 end f;
 
 Real x[2] = f({1,2}, {3,4}, 5);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray13",
			description="Scalarization of operations on arrays of unknown size: element-wise binding expression",
			flatModel="
fclass FunctionTests.UnknownArray13
 Real x[1];
 Real x[2];
equation
 ({x[1], x[2]}) = FunctionTests.UnknownArray13.f({1, 2}, {3, 4}, 5);

public
 function FunctionTests.UnknownArray13.f
  input Real[:] a;
  input Real[:] b;
  input Real c;
  output Real[size(a, 1)] o;
 algorithm
  for i1 in 1:size(o, 1) loop
   o[i1] := c * a[i1] + 2 * b[i1];
  end for;
  return;
 end FunctionTests.UnknownArray13.f;

end FunctionTests.UnknownArray13;
")})));
end UnknownArray13;


model UnknownArray14
 function f
  input Real a[:,:];
  input Real b[size(a,2),:];
  output Real o[size(a,1),size(b,2)] = a * b;
 algorithm
 end f;
 
 Real x[2,2] = f({{1,2},{3,4}}, {{5,6},{7,8}});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray14",
			description="Scalarization of operations on arrays of unknown size: matrix multiplication",
			flatModel="
fclass FunctionTests.UnknownArray14
 Real x[1,1];
 Real x[1,2];
 Real x[2,1];
 Real x[2,2];
equation
 ({{x[1,1], x[1,2]}, {x[2,1], x[2,2]}}) = FunctionTests.UnknownArray14.f({{1, 2}, {3, 4}}, {{5, 6}, {7, 8}});

public
 function FunctionTests.UnknownArray14.f
  input Real[:, :] a;
  input Real[size(a, 2), :] b;
  output Real[size(a, 1), size(b, 2)] o;
  Real temp_1;
 algorithm
  for i1 in 1:size(o, 1) loop
   for i2 in 1:size(o, 2) loop
    temp_1 := 0.0;
    for i3 in 1:size(a, 2) loop
     temp_1 := temp_1 + a[i1,i3] * b[i3,i2];
    end for;
    o[i1,i2] := temp_1;
   end for;
  end for;
  return;
 end FunctionTests.UnknownArray14.f;

end FunctionTests.UnknownArray14;
")})));
end UnknownArray14;


model UnknownArray15
 function f
  input Real a[:];
  input Real b[size(a,1)];
  output Real o = a * b;
 algorithm
 end f;
 
 Real x = f({1,2}, {3,4});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray15",
			description="Scalarization of operations on arrays of unknown size: vector multiplication",
			flatModel="
fclass FunctionTests.UnknownArray15
 Real x;
equation
 x = FunctionTests.UnknownArray15.f({1, 2}, {3, 4});

public
 function FunctionTests.UnknownArray15.f
  input Real[:] a;
  input Real[size(a, 1)] b;
  output Real o;
  Real temp_1;
 algorithm
  temp_1 := 0.0;
  for i1 in 1:size(a, 1) loop
   temp_1 := temp_1 + a[i1] * b[i1];
  end for;
  o := temp_1;
  return;
 end FunctionTests.UnknownArray15.f;

end FunctionTests.UnknownArray15;
")})));
end UnknownArray15;


model UnknownArray16
 function f
  input Real a[:];
  input Real b[size(a,1)];
  output Real o = 1;
 algorithm
  if a * b < 4 then
   o := 2;
  end if;
 end f;
 
 Real x = f({1,2}, {3,4});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray16",
			description="Scalarization of operations on arrays of unknown size: outside assignment",
			flatModel="
fclass FunctionTests.UnknownArray16
 Real x;
equation
 x = FunctionTests.UnknownArray16.f({1, 2}, {3, 4});

public
 function FunctionTests.UnknownArray16.f
  input Real[:] a;
  input Real[size(a, 1)] b;
  output Real o;
  Real temp_1;
 algorithm
  o := 1;
  temp_1 := 0.0;
  for i1 in 1:size(a, 1) loop
   temp_1 := temp_1 + a[i1] * b[i1];
  end for;
  if temp_1 < 4 then
   o := 2;
  end if;
  return;
 end FunctionTests.UnknownArray16.f;

end FunctionTests.UnknownArray16;
")})));
end UnknownArray16;


model UnknownArray17
 function f
  input Real a[:,:];
  input Real b[size(a,2),:];
  input Real c[size(b,2),:];
  output Real[size(a, 1), size(c, 2)] o = a * b * c;
 algorithm
 end f;
 
 Real y[2,2] = {{1,2}, {3,4}};
 Real x[2,2] = f(y, y, y);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray17",
			description="Scalarization of operations on arrays of unknown size: nestled multiplications",
			flatModel="
fclass FunctionTests.UnknownArray17
 Real y[1,1];
 Real y[1,2];
 Real y[2,1];
 Real y[2,2];
 Real x[1,1];
 Real x[1,2];
 Real x[2,1];
 Real x[2,2];
equation
 y[1,1] = 1;
 y[1,2] = 2;
 y[2,1] = 3;
 y[2,2] = 4;
 ({{x[1,1], x[1,2]}, {x[2,1], x[2,2]}}) = FunctionTests.UnknownArray17.f({{y[1,1], y[1,2]}, {y[2,1], y[2,2]}}, {{y[1,1], y[1,2]}, {y[2,1], y[2,2]}}, {{y[1,1], y[1,2]}, {y[2,1], y[2,2]}});

public
 function FunctionTests.UnknownArray17.f
  input Real[:, :] a;
  input Real[size(a, 2), :] b;
  input Real[size(b, 2), :] c;
  output Real[size(a, 1), size(c, 2)] o;
  Real temp_1;
  Real temp_2;
 algorithm
  for i1 in 1:size(o, 1) loop
   for i2 in 1:size(o, 2) loop
    temp_1 := 0.0;
    for i3 in 1:size(b, 2) loop
     temp_2 := 0.0;
     for i4 in 1:size(a, 2) loop
      temp_2 := temp_2 + a[i1,i4] * b[i4,i3];
     end for;
     temp_1 := temp_1 + temp_2 * c[i3,i2];
    end for;
    o[i1,i2] := temp_1;
   end for;
  end for;
  return;
 end FunctionTests.UnknownArray17.f;

end FunctionTests.UnknownArray17;
")})));
end UnknownArray17;


model UnknownArray18
 function f
  input Real a[:];
  output Real o[size(a,1)];
 algorithm
  for i in 1:size(a,1) loop
   o[i] := a[i] + i;
  end for;
 end f;
 
  Real x[2] = f({1,2});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray18",
			description="Scalarization of operations on arrays of unknown size: already expressed as loop",
			flatModel="
fclass FunctionTests.UnknownArray18
 Real x[1];
 Real x[2];
equation
 ({x[1], x[2]}) = FunctionTests.UnknownArray18.f({1, 2});

public
 function FunctionTests.UnknownArray18.f
  input Real[:] a;
  output Real[size(a, 1)] o;
 algorithm
  for i in 1:size(a, 1) loop
   o[i] := a[i] + i;
  end for;
  return;
 end FunctionTests.UnknownArray18.f;

end FunctionTests.UnknownArray18;
")})));
end UnknownArray18;


model UnknownArray19
 function f
  input Real a[:,:];
  output Real[size(a, 1), size(b, 2)] c = a;
 algorithm
 end f;
 
 Real x[2,2] = f({{1,2}, {3,4}});

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="UnknownArray19",
			description="Function inputs of unknown size: using size() of non-existent component",
			errorMessage="
3 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 4429, column 32:
  Cannot find class or component declaration for b
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 4433, column 7:
  Array size mismatch in declaration of x, size of declaration is [2, 2] and size of binding expression is [2, size(zeros(), 2)]
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 4433, column 16:
  Could not evaluate array size of output c
")})));
end UnknownArray19;


model UnknownArray20
 function f
  input Real a[:,:];
  output Real[2] c;
 algorithm
  c[1] := a[1,1];
  c[end] := a[end,end];
 end f;
 
 Real x[2] = f({{1,2}, {3,4}});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray20",
			description="Function inputs of unknown size: scalarizing end",
			flatModel="
fclass FunctionTests.UnknownArray20
 Real x[1];
 Real x[2];
equation
 ({x[1],x[2]}) = FunctionTests.UnknownArray20.f({{1,2},{3,4}});

public
 function FunctionTests.UnknownArray20.f
  input Real[:, :] a;
  output Real[2] c;
 algorithm
  c[1] := a[1,1];
  c[2] := a[size(a, 1),size(a, 2)];
  return;
 end FunctionTests.UnknownArray20.f;

end FunctionTests.UnknownArray20;
")})));
end UnknownArray20;


model UnknownArray21
	function f
		input Real a[:];
		input Real b[:];
		output Real c = a * b;
	algorithm
	end f;
	
	Real x = f({1,2}, {3,4});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray21",
			description="Scalarizing multiplication between two inputs of unknown size",
			flatModel="
fclass FunctionTests.UnknownArray21
 Real x;
equation
 x = FunctionTests.UnknownArray21.f({1, 2}, {3, 4});

public
 function FunctionTests.UnknownArray21.f
  input Real[:] a;
  input Real[:] b;
  output Real c;
  Real temp_1;
 algorithm
  temp_1 := 0.0;
  for i1 in 1:size(b, 1) loop
   temp_1 := temp_1 + a[i1] * b[i1];
  end for;
  c := temp_1;
  return;
 end FunctionTests.UnknownArray21.f;

end FunctionTests.UnknownArray21;
")})));
end UnknownArray21;


model UnknownArray22
	function f
		input Real a[:] = {1, 2, 3};
		input Real b[:] = {4, 5, 6};
		output Real c = a * b;
	algorithm
	end f;
	
	Real x = f({1,2}, {3,4});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray22",
			description="Scalarizing multiplication between two inputs of unknown size, with defaults",
			flatModel="
fclass FunctionTests.UnknownArray22
 Real x;
equation
 x = FunctionTests.UnknownArray22.f({1, 2}, {3, 4});

public
 function FunctionTests.UnknownArray22.f
  input Real[:] a;
  input Real[:] b;
  output Real c;
  Real temp_1;
 algorithm
  temp_1 := 0.0;
  for i1 in 1:size(b, 1) loop
   temp_1 := temp_1 + a[i1] * b[i1];
  end for;
  c := temp_1;
  return;
 end FunctionTests.UnknownArray22.f;

end FunctionTests.UnknownArray22;
")})));
end UnknownArray22;


// TODO: assignment to temp array should be outside loop - see #699
model UnknownArray23
	function f
		input Real a[:];
		output Real c = a * {1, 2, 3};
	algorithm
	end f;

	Real x = f({1,2,3});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray23",
			description="Using array constructors with inputs of unknown size",
			flatModel="
fclass FunctionTests.UnknownArray23
 Real x;
equation
 x = FunctionTests.UnknownArray23.f({1, 2, 3});

public
 function FunctionTests.UnknownArray23.f
  input Real[:] a;
  output Real c;
  Real temp_1;
  Integer[3] temp_2;
 algorithm
  temp_1 := 0.0;
  for i1 in 1:3 loop
   temp_2[1] := 1;
   temp_2[2] := 2;
   temp_2[3] := 3;
   temp_1 := temp_1 + a[i1] * temp_2[i1];
  end for;
  c := temp_1;
  return;
 end FunctionTests.UnknownArray23.f;

end FunctionTests.UnknownArray23;
")})));
end UnknownArray23;


// TODO: assignment to temp array should be outside loop - see #699
model UnknownArray24
	function f
		input Real x[:,2];
		output Real y[size(x, 1), 2];
	algorithm
		y := x * {{1, 2}, {3, 4}};
	end f;

	Real x[3,2] = f({{5,6},{7,8},{9,0}});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray24",
			description="Using array constructors with inputs of unknown size",
			flatModel="
fclass FunctionTests.UnknownArray24
 Real x[1,1];
 Real x[1,2];
 Real x[2,1];
 Real x[2,2];
 Real x[3,1];
 Real x[3,2];
equation
 ({{x[1,1], x[1,2]}, {x[2,1], x[2,2]}, {x[3,1], x[3,2]}}) = FunctionTests.UnknownArray24.f({{5, 6}, {7, 8}, {9, 0}});

public
 function FunctionTests.UnknownArray24.f
  input Real[:, 2] x;
  output Real[size(x, 1), 2] y;
  Real temp_1;
  Integer[2, 2] temp_2;
 algorithm
  for i1 in 1:size(y, 1) loop
   for i2 in 1:size(y, 2) loop
    temp_1 := 0.0;
    for i3 in 1:2 loop
     temp_2[1,1] := 1;
     temp_2[1,2] := 2;
     temp_2[2,1] := 3;
     temp_2[2,2] := 4;
     temp_1 := temp_1 + x[i1,i3] * temp_2[i3,i2];
    end for;
    y[i1,i2] := temp_1;
   end for;
  end for;
  return;
 end FunctionTests.UnknownArray24.f;

end FunctionTests.UnknownArray24;
")})));
end UnknownArray24;


model UnknownArray25
    function f
        input Real[:] y;
        output Real x;
    algorithm
        x := sum(y);
    end f;
    
    Real x = f({1,2});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray25",
			description="Taking sum of array of unknown size",
			flatModel="
fclass FunctionTests.UnknownArray25
 Real x;
equation
 x = FunctionTests.UnknownArray25.f({1,2});

public
 function FunctionTests.UnknownArray25.f
  input Real[:] y;
  output Real x;
  Real temp_1;
 algorithm
  temp_1 := 0.0;
  for i1 in 1:size(y, 1) loop
   temp_1 := temp_1 + y[i1];
  end for;
  x := temp_1;
  return;
 end FunctionTests.UnknownArray25.f;

end FunctionTests.UnknownArray25;
")})));
end UnknownArray25;


model UnknownArray26
    function f
        input Real[:] y;
        output Real x;
    algorithm
        x := sum(y[i]*y[i] for i in 1:size(y,1));
    end f;
    
    Real x = f({1,2});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray26",
			description="Taking sum of iterator expression over array of unknown size",
			flatModel="
fclass FunctionTests.UnknownArray26
 Real x;
equation
 x = FunctionTests.UnknownArray26.f({1, 2});

public
 function FunctionTests.UnknownArray26.f
  input Real[:] y;
  output Real x;
  Real temp_1;
 algorithm
  temp_1 := 0.0;
  for i1 in 1:size(y, 1) loop
   temp_1 := temp_1 + y[i1] * y[i1];
  end for;
  x := temp_1;
  return;
 end FunctionTests.UnknownArray26.f;

end FunctionTests.UnknownArray26;
")})));
end UnknownArray26;


model UnknownArray27
    function f
        input Real[:] y;
        input Real[size(y,1), size(y,1)] z;
        output Real x;
    algorithm
        x := sum(y[i]*y[i]/(sum(y[j]*z[i,j] for j in 1:size(y,1))) for i in 1:size(y,1));
    end f;
    
    Real x = f({1,2}, {{1,2},{3,4}});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray27",
			description="Nestled sums over iterator expressions over arrays of unknown size",
			flatModel="
fclass FunctionTests.UnknownArray27
 Real x;
equation
 x = FunctionTests.UnknownArray27.f({1, 2}, {{1, 2}, {3, 4}});

public
 function FunctionTests.UnknownArray27.f
  input Real[:] y;
  input Real[size(y, 1), size(y, 1)] z;
  output Real x;
  Real temp_1;
  Real temp_2;
 algorithm
  temp_1 := 0.0;
  for i1 in 1:size(y, 1) loop
   temp_2 := 0.0;
   for i2 in 1:size(y, 1) loop
    temp_2 := temp_2 + y[i2] * z[i1,i2];
   end for;
   temp_1 := temp_1 + y[i1] * y[i1] / temp_2;
  end for;
  x := temp_1;
  return;
 end FunctionTests.UnknownArray27.f;

end FunctionTests.UnknownArray27;
")})));
end UnknownArray27;


// TODO: this gives wrong result
model UnknownArray28
    function f
        input Real[:] y;
        output Real x;
    algorithm
        x := sum(sum(j for j in 1:size({k for k in 1:i},1)) for i in 1:size(y,1));
    end f;
    
    Real x = f({1,2});
end UnknownArray28;


model UnknownArray29
    final constant Real a[:] = {1, 2, 3};
    
    function f1
        output Real y1;
    protected
    algorithm
      y1 := f2(a[1:2]);
    end f1;
    
    function f2
        input Real x2[:];
        output Real y2 = sum(x2);
    algorithm
    end f2;
    
    Real x = f1();

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray29",
			description="Calling function from function with slice argument",
			flatModel="
fclass FunctionTests.UnknownArray29
 constant Real a[1] = 1;
 constant Real a[2] = 2;
 constant Real a[3] = 3;
 Real x;
equation
 x = FunctionTests.UnknownArray29.f1();

public
 function FunctionTests.UnknownArray29.f1
  Real[3] a;
  output Real y1;
  Real[2] temp_1;
 algorithm
  a[1] := 1;
  a[2] := 2;
  a[3] := 3;
  temp_1[1] := a[1];
  temp_1[2] := a[2];
  y1 := FunctionTests.UnknownArray29.f2(temp_1);
  return;
 end FunctionTests.UnknownArray29.f1;

 function FunctionTests.UnknownArray29.f2
  input Real[:] x2;
  output Real y2;
  Real temp_1;
 algorithm
  temp_1 := 0.0;
  for i1 in 1:size(x2, 1) loop
   temp_1 := temp_1 + x2[i1];
  end for;
  y2 := temp_1;
  return;
 end FunctionTests.UnknownArray29.f2;

end FunctionTests.UnknownArray29;
")})));
end UnknownArray29;


model UnknownArray30
	function f
		input Real[:] a;
		output Real b;
	algorithm
		b := a * ones(size(a, 1)) + zeros(size(a, 1)) * fill(a[1], size(a, 1));
	end f;
	
	Real x = f({1,2,3});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray30",
			description="Fill type operators with unknown arguments in functions",
			flatModel="
fclass FunctionTests.UnknownArray30
 Real x;
equation
 x = FunctionTests.UnknownArray30.f({1, 2, 3});

public
 function FunctionTests.UnknownArray30.f
  input Real[:] a;
  output Real b;
  Real temp_1;
  Real temp_2;
 algorithm
  temp_1 := 0.0;
  for i1 in 1:size(a, 1) loop
   temp_1 := temp_1 + a[i1] * 1;
  end for;
  temp_2 := 0.0;
  for i1 in 1:size(a, 1) loop
   temp_2 := temp_2 + 0 * a[1];
  end for;
  b := temp_1 + temp_2;
  return;
 end FunctionTests.UnknownArray30.f;

end FunctionTests.UnknownArray30;
")})));
end UnknownArray30;

model UnknownArray31
	function f1
		input Real[:] a;
		output Real[size(a,1)] b;
	algorithm
		b := 2 * a;
	end f1;
	
	function f2
		input Real[:] c;
		output Real[size(c,1)] d;
	algorithm
		d := f1(c);
	end f2;
	
	Real[2] x = f2({1,2});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray31",
			description="Assignstatement with right hand side function call.",
			flatModel="
fclass FunctionTests.UnknownArray31
 Real x[1];
 Real x[2];
equation
 ({x[1], x[2]}) = FunctionTests.UnknownArray31.f2({1, 2});

public
 function FunctionTests.UnknownArray31.f2
  input Real[:] c;
  output Real[size(c, 1)] d;
 algorithm
  (d) := FunctionTests.UnknownArray31.f1(c);
  return;
 end FunctionTests.UnknownArray31.f2;

 function FunctionTests.UnknownArray31.f1
  input Real[:] a;
  output Real[size(a, 1)] b;
 algorithm
  for i1 in 1:size(b, 1) loop
   b[i1] := 2 * a[i1];
  end for;
  return;
 end FunctionTests.UnknownArray31.f1;

end FunctionTests.UnknownArray31;
")})));
end UnknownArray31;

model UnknownArray32
    function f
        input Real[:] a;
        output Real b;
	protected
        Real[1,size(a,1)] c;
    algorithm
        c[1,:] := 2 * a;
		b := sum(c);
    end f;
    
    Real x = f({1,2});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownArray32",
			description="Check that size assignment for protected array with some dimensions known works",
			flatModel="
fclass FunctionTests.UnknownArray32
 Real x;
equation
 x = FunctionTests.UnknownArray32.f({1, 2});

public
 function FunctionTests.UnknownArray32.f
  input Real[:] a;
  output Real b;
  Real[:,:] c;
  Real temp_1;
 algorithm
  size(c) := {1, size(a, 1)};
  for i1 in 1:size(c, 1) loop
   for i2 in 1:size(c, 2) loop
    c[i1,i2] := 2 * a[i1,i2];
   end for;
  end for;
  temp_1 := 0.0;
  for i1 in 1:1 loop
   for i2 in 1:size(a, 1) loop
    temp_1 := temp_1 + c[i1,i2];
   end for;
  end for;
  b := temp_1;
  return;
 end FunctionTests.UnknownArray32.f;

end FunctionTests.UnknownArray32;
")})));
end UnknownArray32;

// TODO: need more complex cases
model IncompleteFunc1
 function f
  input Real x;
  output Real y = x;
 end f;
 
 Real x = f(2);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="IncompleteFunc1",
			description="Wrong contents of called function: neither algorithm nor external",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 4251, column 11:
  Calling function f(): can only call functions that have one algorithm section or external function specification
")})));
end IncompleteFunc1;


model IncompleteFunc2
 function f
  input Real x;
  output Real y = x;
 algorithm
  y := y + 1;
 algorithm
  y := y + 1;
 end f;
 
 Real x = f(2);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="IncompleteFunc2",
			description="Wrong contents of called function: 2 algorithm",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 4276, column 11:
  Calling function f(): can only call functions that have one algorithm section or external function specification
")})));
end IncompleteFunc2;


model IncompleteFunc3
 function f
  input Real x;
  output Real y = x;
 algorithm
  y := y + 1;
 external;
 end f;
 
 Real x = f(2);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="IncompleteFunc3",
			description="Wrong contents of called function: both algorithm and external",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 4300, column 11:
  Calling function f(): can only call functions that have one algorithm section or external function specification
")})));
end IncompleteFunc3;



model ExternalFunc1
 function f
  input Real x;
  output Real y;
 external;
 end f;
 
 Real x = f(2);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ExternalFunc1",
			description="External functions: simple func, all default",
			flatModel="
fclass FunctionTests.ExternalFunc1
 Real x = FunctionTests.ExternalFunc1.f(2);

public
 function FunctionTests.ExternalFunc1.f
  input Real x;
  output Real y;
 algorithm
  external \"C\" y = f(x);
  return;
 end FunctionTests.ExternalFunc1.f;

end FunctionTests.ExternalFunc1;
")})));
end ExternalFunc1;


model ExternalFunc2
 function f
  input Real x[:,2];
  input Real y;
  output Real z;
  output Real q;
  protected Real a = y + 2;
 external;
 end f;
 
 Real x = f({{1,2},{3,4}}, 5);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ExternalFunc2",
			description="External functions: complex func, all default",
			flatModel="
fclass FunctionTests.ExternalFunc2
 Real x = FunctionTests.ExternalFunc2.f({{1,2},{3,4}}, 5);

public
 function FunctionTests.ExternalFunc2.f
  input Real[:, 2] x;
  input Real y;
  output Real z;
  output Real q;
  Real a := y + 2;
 algorithm
  external \"C\" f(x, size(x, 1), size(x, 2), y, z, q, a);
  return;
 end FunctionTests.ExternalFunc2.f;

end FunctionTests.ExternalFunc2;
")})));
end ExternalFunc2;


model ExternalFunc3
 function f
  input Real x[:,2];
  input Real y;
  output Real z;
  output Real q;
 external foo(size(x,1), 2, x, z, y, q);
 end f;
 
 Real x = f({{1,2},{3,4}}, 5);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ExternalFunc3",
			description="External functions: complex func, call set",
			flatModel="
fclass FunctionTests.ExternalFunc3
 Real x = FunctionTests.ExternalFunc3.f({{1,2},{3,4}}, 5);

public
 function FunctionTests.ExternalFunc3.f
  input Real[:, 2] x;
  input Real y;
  output Real z;
  output Real q;
 algorithm
  external \"C\" foo(size(x, 1), 2, x, z, y, q);
  return;
 end FunctionTests.ExternalFunc3.f;

end FunctionTests.ExternalFunc3;
")})));
end ExternalFunc3;


model ExternalFunc4
 function f
  input Real x[:,2];
  input Real y;
  output Real z;
  output Real q;
 external q = foo(size(x,1), 2, x, z, y);
 end f;
 
 Real x = f({{1,2},{3,4}}, 5);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ExternalFunc4",
			description="External functions: complex func, call and return set",
			flatModel="
fclass FunctionTests.ExternalFunc4
 Real x = FunctionTests.ExternalFunc4.f({{1,2},{3,4}}, 5);

public
 function FunctionTests.ExternalFunc4.f
  input Real[:, 2] x;
  input Real y;
  output Real z;
  output Real q;
 algorithm
  external \"C\" q = foo(size(x, 1), 2, x, z, y);
  return;
 end FunctionTests.ExternalFunc4.f;

end FunctionTests.ExternalFunc4;
")})));
end ExternalFunc4;


model ExternalFunc5
 function f
  input Real x;
  output Real y;
 external "C";
 end f;
 
 Real x = f(2);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ExternalFunc5",
			description="External functions: simple func, language \"C\"",
			flatModel="
fclass FunctionTests.ExternalFunc5
 Real x = FunctionTests.ExternalFunc5.f(2);

public
 function FunctionTests.ExternalFunc5.f
  input Real x;
  output Real y;
 algorithm
  external \"C\" y = f(x);
  return;
 end FunctionTests.ExternalFunc5.f;

end FunctionTests.ExternalFunc5;
")})));
end ExternalFunc5;


model ExternalFunc6
 function f
  input Real x;
  output Real y;
 external "FORTRAN 77";
 end f;
 
 Real x = f(2);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ExternalFunc6",
			description="External functions: simple func, language \"FORTRAN 77\"",
			flatModel="
fclass FunctionTests.ExternalFunc6
 Real x = FunctionTests.ExternalFunc6.f(2);

public
 function FunctionTests.ExternalFunc6.f
  input Real x;
  output Real y;
 algorithm
  external \"FORTRAN 77\" y = f(x);
  return;
 end FunctionTests.ExternalFunc6.f;

end FunctionTests.ExternalFunc6;
")})));
end ExternalFunc6;


model ExternalFunc7
 function f
  input Real x;
  output Real y;
 external "C++";
 end f;
 
 Real x = f(2);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ExternalFunc7",
			description="External functions: simple func, language \"C++\"",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 4508, column 2:
  The external language specification \"C++\" is not supported
")})));
end ExternalFunc7;



model ExternalFuncLibs1
 function f1
  input Real x;
  output Real y;
 external annotation(Library="foo");
 end f1;
 
 function f2
  input Real x;
  output Real y;
 external annotation(Library="bar");
 end f2;
 
 function f3
  input Real x;
  output Real y;
 external annotation(Library={"bar", "m"});
 end f3;
 
 function f4
  input Real x;
  output Real y;
 external;
 end f4;
 
 Real x1 = f1(1);
 Real x2 = f2(2);
 Real x3 = f3(3);
 Real x4 = f4(4);

	annotation(__JModelica(UnitTesting(tests={
		FClassMethodTestCase(
			name="ExternalFuncLibs1",
			description="External function annotations, Library",
			methodName="externalLibraries",
			methodResult="[foo, m, bar]"
 )})));
end ExternalFuncLibs1;


model ExternalFuncLibs2
 function f1
  input Real x;
  output Real y;
 external annotation(Include="#include \"foo.h\"");
 end f1;
 
 function f2
  input Real x;
  output Real y;
 external annotation(Include="#include \"foo.h\"");
 end f2;
 
 function f3
  input Real x;
  output Real y;
 external annotation(Include="#include \"bar.h\"");
 end f3;
 
 function f4
  input Real x;
  output Real y;
 external;
 end f4;
 
 Real x1 = f1(1);
 Real x2 = f2(2);
 Real x3 = f3(3);
 Real x4 = f4(4);

	annotation(__JModelica(UnitTesting(tests={
		FClassMethodTestCase(
			name="ExternalFuncLibs2",
			description="External function annotations, Include",
			methodName="externalIncludes",
			methodResult="[#include \"bar.h\", #include \"foo.h\"]"
 )})));
end ExternalFuncLibs2;


model ExternalFuncLibs3
 function f1
  input Real x;
  output Real y;
 external annotation(LibraryDirectory="file:///c:/foo/lib");
 end f1;
 
 function f2
  input Real x;
  output Real y;
 external;
 end f2;
 
 function f3
  input Real x;
  output Real y;
 external annotation(Library="bar", 
                     LibraryDirectory="file:///c:/bar/lib");
 end f3;
 
 Real x1 = f1(1);
 Real x2 = f2(2);
 Real x3 = f3(3);

	annotation(__JModelica(UnitTesting(tests={
		FClassMethodTestCase(
			name="ExternalFuncLibs3",
			description="External function annotations, LibraryDirectory",
			methodName="externalLibraryDirectories",
			methodResult="[/c:/bar/lib, /c:/foo/lib]"
 )})));
end ExternalFuncLibs3;


model ExternalFuncLibs4
 function f1
  input Real x;
  output Real y;
 external annotation(Library="foo");
 end f1;
 
 function f2
  input Real x;
  output Real y;
 external annotation(Library="bar");
 end f2;
 
 function f3
  input Real x;
  output Real y;
 external;
 end f3;
 
 Real x1 = f1(1);
 Real x2 = f2(2);
 Real x3 = f3(3);

	annotation(__JModelica(UnitTesting(tests={
		FClassMethodTestCase(
			name="ExternalFuncLibs4",
			description="External function annotations, LibraryDirectory",
			methodName="externalLibraryDirectories",
			filter=true,
			methodResult="
[%dir%/Resources/Library]"
 )})));
end ExternalFuncLibs4;


model ExternalFuncLibs5
 function f1
  input Real x;
  output Real y;
 external annotation(IncludeDirectory="file:///c:/foo/inc");
 end f1;
 
 function f2
  input Real x;
  output Real y;
 external annotation(Include="#include \"bar.h\"", 
                     IncludeDirectory="file:///c:/bar/inc");
 end f2;
 
 function f3
  input Real x;
  output Real y;
 external;
 end f3;
 
 Real x1 = f1(1);
 Real x2 = f2(2);
 Real x3 = f3(3);

	annotation(__JModelica(UnitTesting(tests={
		FClassMethodTestCase(
			name="ExternalFuncLibs5",
			description="External function annotations, IncludeDirectory",
			methodName="externalIncludeDirectories",
			filter=true,
			methodResult="[/c:/foo/inc, /c:/bar/inc]"
 )})));
end ExternalFuncLibs5;


model ExternalFuncLibs6
 function f1
  input Real x;
  output Real y;
 external annotation(Include="#include \"foo.h\"");
 end f1;
 
 function f2
  input Real x;
  output Real y;
 external annotation(Include="#include \"bar.h\"");
 end f2;
 
 function f3
  input Real x;
  output Real y;
 external;
 end f3;
 
 Real x1 = f1(1);
 Real x2 = f2(2);
 Real x3 = f3(3);

	annotation(__JModelica(UnitTesting(tests={
		FClassMethodTestCase(
			name="ExternalFuncLibs6",
			description="External function annotations, IncludeDirectory",
			methodName="externalIncludeDirectories",
			filter=true,
			methodResult="
[%dir%/Resources/Include]"
 )})));
end ExternalFuncLibs6;


model ExternalFuncLibs7
 function f1
  input Real x;
  output Real y;
 external annotation(LibraryDirectory="file:///c:/std/lib", 
                     IncludeDirectory="file:///c:/std/inc");
 end f1;
 
 function f2
  input Real x;
  output Real y;
 external annotation(Library="foo",
                     LibraryDirectory="file:///c:/foo/lib",  
                     Include="#include \"foo.h\"", 
                     IncludeDirectory="file:///c:/foo/inc");
 end f2;
 
 function f3
  input Real x;
  output Real y;
 external annotation(Include="#include \"bar.h\"", 
                     IncludeDirectory="file:///c:/bar/inc", 
                     Library="bar", 
                     LibraryDirectory="file:///c:/bar/lib");
 end f3;
 
 function f4
  input Real x;
  output Real y;
 external;
 end f4;
 
 Real x1 = f1(1);
 Real x2 = f2(2);
 Real x3 = f3(3);
 Real x4 = f4(4);

	annotation(__JModelica(UnitTesting(tests={
		FClassMethodTestCase(
			name="ExternalFuncLibs7",
			description="External function annotations, compiler args",
			methodName="externalCompilerArgs",
			methodResult=" -lfoo -lbar -L/c:/bar/lib -L/c:/std/lib -L/c:/foo/lib -I/c:/foo/inc -I/c:/std/inc -I/c:/bar/inc"
 )})));
end ExternalFuncLibs7;


model ExternalFuncLibs8
 function f
  input Real x;
  output Real y;
 external annotation(Library="foo", 
                     Include="#include \"foo.h\"");
 end f;
 
 Real x = f(1);

	annotation(__JModelica(UnitTesting(tests={
		FClassMethodTestCase(
			name="ExternalFuncLibs8",
			description="External function annotations, compiler args",
			methodName="externalCompilerArgs",
			filter=true,
			methodResult=" -lfoo -L%dir%/Resources/Library -I%dir%/Resources/Include"
 )})));
end ExternalFuncLibs8;



model ExtendFunc1
    function f1
        input Real a;
        output Real b;
    end f1;
    
    function f2
        extends f1;
    algorithm
        b := a;
    end f2;
    
    Real x = f2(1.0);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ExtendFunc1",
			description="Flattening of function extending other function",
			flatModel="
fclass FunctionTests.ExtendFunc1
 Real x = FunctionTests.ExtendFunc1.f2(1.0);

public
 function FunctionTests.ExtendFunc1.f2
  input Real a;
  output Real b;
 algorithm
  b := a;
  return;
 end FunctionTests.ExtendFunc1.f2;

end FunctionTests.ExtendFunc1;
")})));
end ExtendFunc1;



model ExtendFunc2
	constant Real[2] d = { 1, 2 };
	
    function f1
        input Real a;
        output Real b;
    end f1;
    
    function f2
        extends f1;
		input Integer c = 2;
	protected
		Real f = a + d[c];
    algorithm
        b := f;
    end f2;

    Real x = f2(1);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ExtendFunc2",
			description="Order of variables in functions when inheriting and adding constants",
			flatModel="
fclass FunctionTests.ExtendFunc2
 constant Real d[2] = {1,2};
 Real x = FunctionTests.ExtendFunc2.f2(1, 2);

public
 function FunctionTests.ExtendFunc2.f2
  Real[2] d := {1,2};
  input Real a;
  output Real b;
  input Integer c := 2;
  Real f := a + d[c];
 algorithm
  b := f;
  return;
 end FunctionTests.ExtendFunc2.f2;

end FunctionTests.ExtendFunc2;
")})));
end ExtendFunc2;



model AttributeTemp1
	function f
		output Real o[2] = {1, 2};
	algorithm
	end f;
	
	Real x[2](start = f()) = {3, 4};

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AttributeTemp1",
			description="Temporary variable for attribute",
			flatModel="
fclass FunctionTests.AttributeTemp1
 Real x[1](start = temp_1[1]);
 Real x[2](start = temp_1[2]);
 parameter Real temp_1[1];
 parameter Real temp_1[2];
parameter equation
 ({temp_1[1],temp_1[2]}) = FunctionTests.AttributeTemp1.f();
equation
 x[1] = 3;
 x[2] = 4;

public
 function FunctionTests.AttributeTemp1.f
  output Real[2] o;
 algorithm
  o[1] := 1;
  o[2] := 2;
  return;
 end FunctionTests.AttributeTemp1.f;

end FunctionTests.AttributeTemp1;
")})));
end AttributeTemp1;



model InputAsArraySize1
	function f
		input Integer n;
		output Real x[n];
	algorithm
		x := 1:size(x,1);
	end f;
	
	Real x[3] = f(3);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InputAsArraySize1",
			description="Input as array size of output in function: basic test",
			flatModel="
fclass FunctionTests.InputAsArraySize1
 Real x[1];
 Real x[2];
 Real x[3];
equation
 ({x[1],x[2],x[3]}) = FunctionTests.InputAsArraySize1.f(3);

public
 function FunctionTests.InputAsArraySize1.f
  input Integer n;
  output Real[n] x;
 algorithm
  for i1 in 1:size(x, 1) loop
   x[i1] := i1;
  end for;
  return;
 end FunctionTests.InputAsArraySize1.f;

end FunctionTests.InputAsArraySize1;
")})));
end InputAsArraySize1;


model InputAsArraySize2
	function f
		input Integer n;
		output Real x[n];
	algorithm
		x := 1:size(x,1);
	end f;
	
	parameter Integer n = 3;
	Real x[3] = f(n);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InputAsArraySize2",
			description="Input as array size of output in function: basic test",
			flatModel="
fclass FunctionTests.InputAsArraySize2
 parameter Integer n = 3 /* 3 */;
 Real x[1];
 Real x[2];
 Real x[3];
equation
 ({x[1],x[2],x[3]}) = FunctionTests.InputAsArraySize2.f(n);

public
 function FunctionTests.InputAsArraySize2.f
  input Integer n;
  output Real[n] x;
 algorithm
  for i1 in 1:size(x, 1) loop
   x[i1] := i1;
  end for;
  return;
 end FunctionTests.InputAsArraySize2.f;

end FunctionTests.InputAsArraySize2;
")})));
end InputAsArraySize2;


model InputAsArraySize3
	function f
		input Integer n;
		output Real x[n];
	algorithm
		x := 1:size(x,1);
	end f;
	
	parameter Integer n = 3;
	Real x[n] = f(n);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InputAsArraySize3",
			description="Input as array size of output in function: basic test",
			flatModel="
fclass FunctionTests.InputAsArraySize3
 parameter Integer n = 3 /* 3 */;
 Real x[1];
 Real x[2];
 Real x[3];
equation
 ({x[1],x[2],x[3]}) = FunctionTests.InputAsArraySize3.f(n);

public
 function FunctionTests.InputAsArraySize3.f
  input Integer n;
  output Real[n] x;
 algorithm
  for i1 in 1:size(x, 1) loop
   x[i1] := i1;
  end for;
  return;
 end FunctionTests.InputAsArraySize3.f;

end FunctionTests.InputAsArraySize3;
")})));
end InputAsArraySize3;


model InputAsArraySize4
	function f
		input Integer n;
		output Real x[n];
	algorithm
		x := 1:size(x,1);
	end f;
	
	Real x[3] = f(size(x,1));

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InputAsArraySize4",
			description="Input as array size of output in function: test using size()",
			flatModel="
fclass FunctionTests.InputAsArraySize4
 Real x[1];
 Real x[2];
 Real x[3];
equation
 ({x[1],x[2],x[3]}) = FunctionTests.InputAsArraySize4.f(3);

public
 function FunctionTests.InputAsArraySize4.f
  input Integer n;
  output Real[n] x;
 algorithm
  for i1 in 1:size(x, 1) loop
   x[i1] := i1;
  end for;
  return;
 end FunctionTests.InputAsArraySize4.f;

end FunctionTests.InputAsArraySize4;
")})));
end InputAsArraySize4;


model InputAsArraySize5
	function f
		input Integer n;
		output Real x[n];
	algorithm
		x := 1:size(x,1);
	end f;
	
	Integer n = 3;
	Real x[3] = f(n);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="InputAsArraySize5",
			description="Input as array size of output in function: variable passed",
			errorMessage="
2 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 5605, column 7:
  Array size mismatch in declaration of x, size of declaration is [3] and size of binding expression is [n]
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 5605, column 14:
  Could not evaluate array size of output x
")})));
end InputAsArraySize5;


model InputAsArraySize6
	function f
		input Integer n;
		output Real x[n];
	algorithm
		x := 1:size(x,1);
	end f;
	
	Real x[3] = f(4);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="InputAsArraySize6",
			description="Input as array size of output in function: wrong value passed",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/FunctionTests.mo':
Semantic error at line 5631, column 7:
  Array size mismatch in declaration of x, size of declaration is [3] and size of binding expression is [4]
")})));
end InputAsArraySize6;


model InputAsArraySize7
	function f
		input Integer n;
		input Real y[n];
		output Real x;
	algorithm
		x := sum(y[1:n]);
	end f;
	
	Real x = f(3, {1, 2, 3});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InputAsArraySize7",
			description="Input as array size of other input in function: basic test",
			flatModel="
fclass FunctionTests.InputAsArraySize7
 Real x;
equation
 x = FunctionTests.InputAsArraySize7.f(3, {1,2,3});

public
 function FunctionTests.InputAsArraySize7.f
  input Integer n;
  input Real[n] y;
  output Real x;
  Real temp_1;
 algorithm
  temp_1 := 0.0;
  for i1 in 1:n loop
   temp_1 := temp_1 + y[i1];
  end for;
  x := temp_1;
  return;
 end FunctionTests.InputAsArraySize7.f;

end FunctionTests.InputAsArraySize7;
")})));
end InputAsArraySize7;


model InputAsArraySize8
	function f
		input Integer n;
		input Real y[n];
		output Real x;
	algorithm
		x := sum(y[1:n]);
	end f;
	
	Real x = f(4, {1, 2, 3});
end InputAsArraySize8;


model InputAsArraySize9
	function f
		input Integer n;
		input Real y[n];
		output Real x;
	algorithm
		x := sum(y);
	end f;
	
	Real x = f(3, {1, 2, 3});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InputAsArraySize9",
			description="Input as array size of other input in function: basic test",
			flatModel="
fclass FunctionTests.InputAsArraySize9
 Real x;
equation
 x = FunctionTests.InputAsArraySize9.f(3, {1,2,3});

public
 function FunctionTests.InputAsArraySize9.f
  input Integer n;
  input Real[n] y;
  output Real x;
  Real temp_1;
 algorithm
  temp_1 := 0.0;
  for i1 in 1:n loop
   temp_1 := temp_1 + y[i1];
  end for;
  x := temp_1;
  return;
 end FunctionTests.InputAsArraySize9.f;

end FunctionTests.InputAsArraySize9;
")})));
end InputAsArraySize9;


model InputAsArraySize10
	function f
		input Integer n;
		input Real y[n];
		output Real x;
	algorithm
		x := sum(y);
	end f;
	
	Real x = f(4, {1, 2, 3});
end InputAsArraySize10;
// TODO: Fler som ovan



model VectorizedCall1
    function f
        input Real x;
        output Real y;
    algorithm
        y := 2 * x;
    end f;
    
    Real z[2] = f({1,2});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="VectorizedCall1",
			description="Vectorization: basic test",
			flatModel="
fclass FunctionTests.VectorizedCall1
 Real z[1];
 Real z[2];
equation
 z[1] = FunctionTests.VectorizedCall1.f(1);
 z[2] = FunctionTests.VectorizedCall1.f(2);

public
 function FunctionTests.VectorizedCall1.f
  input Real x;
  output Real y;
 algorithm
  y := 2 * x;
  return;
 end FunctionTests.VectorizedCall1.f;

end FunctionTests.VectorizedCall1;
")})));
end VectorizedCall1;


model VectorizedCall2
    function f
        input Real x1;
		input Real x2;
		input Real x3 = 2;
        output Real y;
    algorithm
        y := 2 * x1 + x2 + x3;
    end f;
    
    Real z[2,2] = f({{1,2},{3,4}}, 5);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="VectorizedCall2",
			description="Vectorization: one of two args vectorized",
			flatModel="
fclass FunctionTests.VectorizedCall2
 Real z[1,1];
 Real z[1,2];
 Real z[2,1];
 Real z[2,2];
equation
 z[1,1] = FunctionTests.VectorizedCall2.f(1, 5, 2);
 z[1,2] = FunctionTests.VectorizedCall2.f(2, 5, 2);
 z[2,1] = FunctionTests.VectorizedCall2.f(3, 5, 2);
 z[2,2] = FunctionTests.VectorizedCall2.f(4, 5, 2);

public
 function FunctionTests.VectorizedCall2.f
  input Real x1;
  input Real x2;
  input Real x3;
  output Real y;
 algorithm
  y := 2 * x1 + x2 + x3;
  return;
 end FunctionTests.VectorizedCall2.f;

end FunctionTests.VectorizedCall2;
")})));
end VectorizedCall2;


model VectorizedCall3
    function f
        input Real[:,:] x1;
        input Real[:,:] x2;
        output Real y;
    algorithm
        y := sum(x1 * x2);
    end f;
    
    constant Real v[3,3] = -1 * [1,2,3;4,5,6;7,8,9];
    constant Real w[3,3] = [1,2,3;4,5,6;7,8,9];
    Real z[2,2] = f({{w, 2*w},{3*w, 4*w}}, {{v, 2*v},{3*v, 4*v}});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="VectorizedCall3",
			description="Vectorization: vectorised array arg, constant",
			flatModel="
fclass FunctionTests.VectorizedCall3
 constant Real v[1,1] = (- 1) * 1;
 constant Real v[1,2] = (- 1) * 2;
 constant Real v[1,3] = (- 1) * 3;
 constant Real v[2,1] = (- 1) * 4;
 constant Real v[2,2] = (- 1) * 5;
 constant Real v[2,3] = (- 1) * 6;
 constant Real v[3,1] = (- 1) * 7;
 constant Real v[3,2] = (- 1) * 8;
 constant Real v[3,3] = (- 1) * 9;
 constant Real w[1,1] = 1;
 constant Real w[1,2] = 2;
 constant Real w[1,3] = 3;
 constant Real w[2,1] = 4;
 constant Real w[2,2] = 5;
 constant Real w[2,3] = 6;
 constant Real w[3,1] = 7;
 constant Real w[3,2] = 8;
 constant Real w[3,3] = 9;
 Real z[1,1];
 Real z[1,2];
 Real z[2,1];
 Real z[2,2];
equation
 z[1,1] = FunctionTests.VectorizedCall3.f({{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}, {{-1.0, -2.0, -3.0}, {-4.0, -5.0, -6.0}, {-7.0, -8.0, -9.0}});
 z[1,2] = FunctionTests.VectorizedCall3.f({{2 * 1.0, 2 * 2.0, 2 * 3.0}, {2 * 4.0, 2 * 5.0, 2 * 6.0}, {2 * 7.0, 2 * 8.0, 2 * 9.0}}, {{2 * -1.0, 2 * -2.0, 2 * -3.0}, {2 * -4.0, 2 * -5.0, 2 * -6.0}, {2 * -7.0, 2 * -8.0, 2 * -9.0}});
 z[2,1] = FunctionTests.VectorizedCall3.f({{3 * 1.0, 3 * 2.0, 3 * 3.0}, {3 * 4.0, 3 * 5.0, 3 * 6.0}, {3 * 7.0, 3 * 8.0, 3 * 9.0}}, {{3 * -1.0, 3 * -2.0, 3 * -3.0}, {3 * -4.0, 3 * -5.0, 3 * -6.0}, {3 * -7.0, 3 * -8.0, 3 * -9.0}});
 z[2,2] = FunctionTests.VectorizedCall3.f({{4 * 1.0, 4 * 2.0, 4 * 3.0}, {4 * 4.0, 4 * 5.0, 4 * 6.0}, {4 * 7.0, 4 * 8.0, 4 * 9.0}}, {{4 * -1.0, 4 * -2.0, 4 * -3.0}, {4 * -4.0, 4 * -5.0, 4 * -6.0}, {4 * -7.0, 4 * -8.0, 4 * -9.0}});

public
 function FunctionTests.VectorizedCall3.f
  input Real[:, :] x1;
  input Real[:, :] x2;
  output Real y;
  Real temp_1;
  Real temp_2;
 algorithm
  temp_1 := 0.0;
  for i1 in 1:size(x1, 1) loop
   for i2 in 1:size(x2, 2) loop
    temp_2 := 0.0;
    for i3 in 1:size(x2, 1) loop
     temp_2 := temp_2 + x1[i1,i3] * x2[i3,i2];
    end for;
    temp_1 := temp_1 + temp_2;
   end for;
  end for;
  y := temp_1;
  return;
 end FunctionTests.VectorizedCall3.f;

end FunctionTests.VectorizedCall3;
")})));
end VectorizedCall3;


model VectorizedCall4
    function f
        input Real[:,:] x1;
        input Real[:,:] x2;
        output Real y;
    algorithm
        y := sum(x1 * x2);
    end f;
    
    Real v[3,3] = -1 * [1,2,3;4,5,6;7,8,9];
    Real w[3,3] = [1,2,3;4,5,6;7,8,9];
    Real v2[2,2,3,3] = {{v, 2*v},{3*v, 4*v}};
    Real w2[2,2,3,3] = {{w, 2*w},{3*w, 4*w}};
    Real z[2,2] = f(w2, v2);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="VectorizedCall4",
			description="Vectorization: vectorised array arg, continous",
			flatModel="
fclass FunctionTests.VectorizedCall4
 Real v2[1,1,1,1];
 Real v2[1,1,1,2];
 Real v2[1,1,1,3];
 Real v2[1,1,2,1];
 Real v2[1,1,2,2];
 Real v2[1,1,2,3];
 Real v2[1,1,3,1];
 Real v2[1,1,3,2];
 Real v2[1,1,3,3];
 Real v2[1,2,1,1];
 Real v2[1,2,1,2];
 Real v2[1,2,1,3];
 Real v2[1,2,2,1];
 Real v2[1,2,2,2];
 Real v2[1,2,2,3];
 Real v2[1,2,3,1];
 Real v2[1,2,3,2];
 Real v2[1,2,3,3];
 Real v2[2,1,1,1];
 Real v2[2,1,1,2];
 Real v2[2,1,1,3];
 Real v2[2,1,2,1];
 Real v2[2,1,2,2];
 Real v2[2,1,2,3];
 Real v2[2,1,3,1];
 Real v2[2,1,3,2];
 Real v2[2,1,3,3];
 Real v2[2,2,1,1];
 Real v2[2,2,1,2];
 Real v2[2,2,1,3];
 Real v2[2,2,2,1];
 Real v2[2,2,2,2];
 Real v2[2,2,2,3];
 Real v2[2,2,3,1];
 Real v2[2,2,3,2];
 Real v2[2,2,3,3];
 Real w2[1,1,1,1];
 Real w2[1,1,1,2];
 Real w2[1,1,1,3];
 Real w2[1,1,2,1];
 Real w2[1,1,2,2];
 Real w2[1,1,2,3];
 Real w2[1,1,3,1];
 Real w2[1,1,3,2];
 Real w2[1,1,3,3];
 Real w2[1,2,1,1];
 Real w2[1,2,1,2];
 Real w2[1,2,1,3];
 Real w2[1,2,2,1];
 Real w2[1,2,2,2];
 Real w2[1,2,2,3];
 Real w2[1,2,3,1];
 Real w2[1,2,3,2];
 Real w2[1,2,3,3];
 Real w2[2,1,1,1];
 Real w2[2,1,1,2];
 Real w2[2,1,1,3];
 Real w2[2,1,2,1];
 Real w2[2,1,2,2];
 Real w2[2,1,2,3];
 Real w2[2,1,3,1];
 Real w2[2,1,3,2];
 Real w2[2,1,3,3];
 Real w2[2,2,1,1];
 Real w2[2,2,1,2];
 Real w2[2,2,1,3];
 Real w2[2,2,2,1];
 Real w2[2,2,2,2];
 Real w2[2,2,2,3];
 Real w2[2,2,3,1];
 Real w2[2,2,3,2];
 Real w2[2,2,3,3];
 Real z[1,1];
 Real z[1,2];
 Real z[2,1];
 Real z[2,2];
equation
 v2[1,1,1,1] = (- 1) * 1;
 v2[1,1,1,2] = (- 1) * 2;
 v2[1,1,1,3] = (- 1) * 3;
 v2[1,1,2,1] = (- 1) * 4;
 v2[1,1,2,2] = (- 1) * 5;
 v2[1,1,2,3] = (- 1) * 6;
 v2[1,1,3,1] = (- 1) * 7;
 v2[1,1,3,2] = (- 1) * 8;
 v2[1,1,3,3] = (- 1) * 9;
 w2[1,1,1,1] = 1;
 w2[1,1,1,2] = 2;
 w2[1,1,1,3] = 3;
 w2[1,1,2,1] = 4;
 w2[1,1,2,2] = 5;
 w2[1,1,2,3] = 6;
 w2[1,1,3,1] = 7;
 w2[1,1,3,2] = 8;
 w2[1,1,3,3] = 9;
 v2[1,2,1,1] = 2 * v2[1,1,1,1];
 v2[1,2,1,2] = 2 * v2[1,1,1,2];
 v2[1,2,1,3] = 2 * v2[1,1,1,3];
 v2[1,2,2,1] = 2 * v2[1,1,2,1];
 v2[1,2,2,2] = 2 * v2[1,1,2,2];
 v2[1,2,2,3] = 2 * v2[1,1,2,3];
 v2[1,2,3,1] = 2 * v2[1,1,3,1];
 v2[1,2,3,2] = 2 * v2[1,1,3,2];
 v2[1,2,3,3] = 2 * v2[1,1,3,3];
 v2[2,1,1,1] = 3 * v2[1,1,1,1];
 v2[2,1,1,2] = 3 * v2[1,1,1,2];
 v2[2,1,1,3] = 3 * v2[1,1,1,3];
 v2[2,1,2,1] = 3 * v2[1,1,2,1];
 v2[2,1,2,2] = 3 * v2[1,1,2,2];
 v2[2,1,2,3] = 3 * v2[1,1,2,3];
 v2[2,1,3,1] = 3 * v2[1,1,3,1];
 v2[2,1,3,2] = 3 * v2[1,1,3,2];
 v2[2,1,3,3] = 3 * v2[1,1,3,3];
 v2[2,2,1,1] = 4 * v2[1,1,1,1];
 v2[2,2,1,2] = 4 * v2[1,1,1,2];
 v2[2,2,1,3] = 4 * v2[1,1,1,3];
 v2[2,2,2,1] = 4 * v2[1,1,2,1];
 v2[2,2,2,2] = 4 * v2[1,1,2,2];
 v2[2,2,2,3] = 4 * v2[1,1,2,3];
 v2[2,2,3,1] = 4 * v2[1,1,3,1];
 v2[2,2,3,2] = 4 * v2[1,1,3,2];
 v2[2,2,3,3] = 4 * v2[1,1,3,3];
 w2[1,2,1,1] = 2 * w2[1,1,1,1];
 w2[1,2,1,2] = 2 * w2[1,1,1,2];
 w2[1,2,1,3] = 2 * w2[1,1,1,3];
 w2[1,2,2,1] = 2 * w2[1,1,2,1];
 w2[1,2,2,2] = 2 * w2[1,1,2,2];
 w2[1,2,2,3] = 2 * w2[1,1,2,3];
 w2[1,2,3,1] = 2 * w2[1,1,3,1];
 w2[1,2,3,2] = 2 * w2[1,1,3,2];
 w2[1,2,3,3] = 2 * w2[1,1,3,3];
 w2[2,1,1,1] = 3 * w2[1,1,1,1];
 w2[2,1,1,2] = 3 * w2[1,1,1,2];
 w2[2,1,1,3] = 3 * w2[1,1,1,3];
 w2[2,1,2,1] = 3 * w2[1,1,2,1];
 w2[2,1,2,2] = 3 * w2[1,1,2,2];
 w2[2,1,2,3] = 3 * w2[1,1,2,3];
 w2[2,1,3,1] = 3 * w2[1,1,3,1];
 w2[2,1,3,2] = 3 * w2[1,1,3,2];
 w2[2,1,3,3] = 3 * w2[1,1,3,3];
 w2[2,2,1,1] = 4 * w2[1,1,1,1];
 w2[2,2,1,2] = 4 * w2[1,1,1,2];
 w2[2,2,1,3] = 4 * w2[1,1,1,3];
 w2[2,2,2,1] = 4 * w2[1,1,2,1];
 w2[2,2,2,2] = 4 * w2[1,1,2,2];
 w2[2,2,2,3] = 4 * w2[1,1,2,3];
 w2[2,2,3,1] = 4 * w2[1,1,3,1];
 w2[2,2,3,2] = 4 * w2[1,1,3,2];
 w2[2,2,3,3] = 4 * w2[1,1,3,3];
 z[1,1] = FunctionTests.VectorizedCall4.f({{w2[1,1,1,1], w2[1,1,1,2], w2[1,1,1,3]}, {w2[1,1,2,1], w2[1,1,2,2], w2[1,1,2,3]}, {w2[1,1,3,1], w2[1,1,3,2], w2[1,1,3,3]}}, {{v2[1,1,1,1], v2[1,1,1,2], v2[1,1,1,3]}, {v2[1,1,2,1], v2[1,1,2,2], v2[1,1,2,3]}, {v2[1,1,3,1], v2[1,1,3,2], v2[1,1,3,3]}});
 z[1,2] = FunctionTests.VectorizedCall4.f({{w2[1,2,1,1], w2[1,2,1,2], w2[1,2,1,3]}, {w2[1,2,2,1], w2[1,2,2,2], w2[1,2,2,3]}, {w2[1,2,3,1], w2[1,2,3,2], w2[1,2,3,3]}}, {{v2[1,2,1,1], v2[1,2,1,2], v2[1,2,1,3]}, {v2[1,2,2,1], v2[1,2,2,2], v2[1,2,2,3]}, {v2[1,2,3,1], v2[1,2,3,2], v2[1,2,3,3]}});
 z[2,1] = FunctionTests.VectorizedCall4.f({{w2[2,1,1,1], w2[2,1,1,2], w2[2,1,1,3]}, {w2[2,1,2,1], w2[2,1,2,2], w2[2,1,2,3]}, {w2[2,1,3,1], w2[2,1,3,2], w2[2,1,3,3]}}, {{v2[2,1,1,1], v2[2,1,1,2], v2[2,1,1,3]}, {v2[2,1,2,1], v2[2,1,2,2], v2[2,1,2,3]}, {v2[2,1,3,1], v2[2,1,3,2], v2[2,1,3,3]}});
 z[2,2] = FunctionTests.VectorizedCall4.f({{w2[2,2,1,1], w2[2,2,1,2], w2[2,2,1,3]}, {w2[2,2,2,1], w2[2,2,2,2], w2[2,2,2,3]}, {w2[2,2,3,1], w2[2,2,3,2], w2[2,2,3,3]}}, {{v2[2,2,1,1], v2[2,2,1,2], v2[2,2,1,3]}, {v2[2,2,2,1], v2[2,2,2,2], v2[2,2,2,3]}, {v2[2,2,3,1], v2[2,2,3,2], v2[2,2,3,3]}});

public
 function FunctionTests.VectorizedCall4.f
  input Real[:, :] x1;
  input Real[:, :] x2;
  output Real y;
  Real temp_1;
  Real temp_2;
 algorithm
  temp_1 := 0.0;
  for i1 in 1:size(x1, 1) loop
   for i2 in 1:size(x2, 2) loop
    temp_2 := 0.0;
    for i3 in 1:size(x2, 1) loop
     temp_2 := temp_2 + x1[i1,i3] * x2[i3,i2];
    end for;
    temp_1 := temp_1 + temp_2;
   end for;
  end for;
  y := temp_1;
  return;
 end FunctionTests.VectorizedCall4.f;

end FunctionTests.VectorizedCall4;
")})));
end VectorizedCall4;


model VectorizedCall5
	record R
		Real a;
		Real b;
	end R;
	
    function f
        input R x;
        output Real y;
    algorithm
        y := 2 * x.a + x.b;
    end f;
    
	R[2] w = {R(1,2), R(3,4)};
    Real z[2] = f(w);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="VectorizedCall5",
			description="Vectorization: scalarized record arg",
			flatModel="
fclass FunctionTests.VectorizedCall5
 Real w[1].a;
 Real w[1].b;
 Real w[2].a;
 Real w[2].b;
 Real z[1];
 Real z[2];
equation
 w[1].a = 1;
 w[2].a = 3;
 w[1].b = 2;
 w[2].b = 4;
 z[1] = FunctionTests.VectorizedCall5.f(FunctionTests.VectorizedCall5.R(w[1].a, w[1].b));
 z[2] = FunctionTests.VectorizedCall5.f(FunctionTests.VectorizedCall5.R(w[2].a, w[2].b));

public
 function FunctionTests.VectorizedCall5.f
  input FunctionTests.VectorizedCall5.R x;
  output Real y;
 algorithm
  y := 2 * x.a + x.b;
  return;
 end FunctionTests.VectorizedCall5.f;

 record FunctionTests.VectorizedCall5.R
  Real a;
  Real b;
 end FunctionTests.VectorizedCall5.R;

end FunctionTests.VectorizedCall5;
")})));
end VectorizedCall5;


model Lapack_dgeqpf
  Real A[2,2] = {{1,2},{3,4}};
  Real QR[2,2];
  Real tau[2];
equation 
  (QR,tau,) = Modelica.Math.Matrices.LAPACK.dgeqpf(A);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Lapack_dgeqpf",
			description="Test scalarization of LAPACK function that has had some issues",
			flatModel="
fclass FunctionTests.Lapack_dgeqpf
 Real A[1,1];
 Real A[1,2];
 Real A[2,1];
 Real A[2,2];
 Real QR[1,1];
 Real QR[1,2];
 Real QR[2,1];
 Real QR[2,2];
 Real tau[1];
 Real tau[2];
equation
 ({{QR[1,1], QR[1,2]}, {QR[2,1], QR[2,2]}}, {tau[1], tau[2]}, ) = Modelica.Math.Matrices.LAPACK.dgeqpf({{A[1,1], A[1,2]}, {A[2,1], A[2,2]}});
 A[1,1] = 1;
 A[1,2] = 2;
 A[2,1] = 3;
 A[2,2] = 4;

public
 function Modelica.Math.Matrices.LAPACK.dgeqpf
  input Real[:, :] A;
  output Real[size(A, 1), size(A, 2)] QR;
  output Real[min(size(A, 1), size(A, 2))] tau;
  output Integer[size(A, 2)] p;
  output Integer info;
  Integer lda;
  Integer ncol;
  Real[:] work;
 algorithm
  size(work) := {3 * size(A, 2)};
  for i1 in 1:size(QR, 1) loop
   for i2 in 1:size(QR, 2) loop
    QR[i1,i2] := A[i1,i2];
   end for;
  end for;
  for i1 in 1:size(p, 1) loop
   p[i1] := 0;
  end for;
  lda := max(1, size(A, 1));
  ncol := size(A, 2);
  external \"FORTRAN 77\" dgeqpf(size(A, 1), ncol, QR, lda, p, tau, work, info);
  return;
 end Modelica.Math.Matrices.LAPACK.dgeqpf;

end FunctionTests.Lapack_dgeqpf;
")})));
end Lapack_dgeqpf;

model Lapack_QR
 Real A[2,2] = {{5,6},{7,8}};
 Real Q[2,2];
 Real R[2,2];
 //Integer piv[2];
equation 
 (Q,R,) = Modelica.Math.Matrices.QR(A);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Lapack_QR",
			description="",
			flatModel="
fclass FunctionTests.Lapack_QR
 Real A[1,1];
 Real A[1,2];
 Real A[2,1];
 Real A[2,2];
 Real Q[1,1];
 Real Q[1,2];
 Real Q[2,1];
 Real Q[2,2];
 Real R[1,1];
 Real R[1,2];
 Real R[2,1];
 Real R[2,2];
equation
 ({{Q[1,1], Q[1,2]}, {Q[2,1], Q[2,2]}}, {{R[1,1], R[1,2]}, {R[2,1], R[2,2]}}, ) = Modelica.Math.Matrices.QR({{A[1,1], A[1,2]}, {A[2,1], A[2,2]}}, true);
 A[1,1] = 5;
 A[1,2] = 6;
 A[2,1] = 7;
 A[2,2] = 8;

public
 function Modelica.Math.Matrices.QR
  input Real[:, :] A;
  input Boolean pivoting;
  output Real[size(A, 1), size(A, 2)] Q;
  output Real[size(A, 2), size(A, 2)] R;
  output Integer[size(A, 2)] p;
  Integer nrow;
  Integer ncol;
  Real[:] tau;
 algorithm
  size(tau) := {size(A, 2)};
  nrow := size(A, 1);
  ncol := size(A, 2);
  ();
  if pivoting then
   (Q, tau, p) := Modelica.Math.Matrices.LAPACK.dgeqpf(A);
  else
   (Q, tau) := Modelica.Math.Matrices.LAPACK.dgeqrf(A);
   for i1 in 1:size(p, 1) loop
    p[i1] := i1;
   end for;
  end if;
  for i1 in 1:size(R, 1) loop
   for i2 in 1:size(R, 2) loop
    R[i1,i2] := 0;
   end for;
  end for;
  for i in 1:ncol loop
   for j in i:ncol loop
    R[i,j] := Q[i,j];
   end for;
  end for;
  (Q) := Modelica.Math.Matrices.LAPACK.dorgqr(Q, tau);
  return;
 end Modelica.Math.Matrices.QR;

 function Modelica.Math.Matrices.LAPACK.dgeqpf
  input Real[:, :] A;
  output Real[size(A, 1), size(A, 2)] QR;
  output Real[min(size(A, 1), size(A, 2))] tau;
  output Integer[size(A, 2)] p;
  output Integer info;
  Integer lda;
  Integer ncol;
  Real[:] work;
 algorithm
  size(work) := {3 * size(A, 2)};
  for i1 in 1:size(QR, 1) loop
   for i2 in 1:size(QR, 2) loop
    QR[i1,i2] := A[i1,i2];
   end for;
  end for;
  for i1 in 1:size(p, 1) loop
   p[i1] := 0;
  end for;
  lda := max(1, size(A, 1));
  ncol := size(A, 2);
  external \"FORTRAN 77\" dgeqpf(size(A, 1), ncol, QR, lda, p, tau, work, info);
  return;
 end Modelica.Math.Matrices.LAPACK.dgeqpf;

 function Modelica.Math.Matrices.LAPACK.dgeqrf
  input Real[:, :] A;
  output Real[size(A, 1), size(A, 2)] Aout;
  output Real[min(size(A, 1), size(A, 2))] tau;
  output Integer info;
  output Real[3 * max(1, size(A, 2))] work;
  Integer m;
  Integer n;
  Integer lda;
  Integer lwork;
 algorithm
  for i1 in 1:size(Aout, 1) loop
   for i2 in 1:size(Aout, 2) loop
    Aout[i1,i2] := A[i1,i2];
   end for;
  end for;
  m := size(A, 1);
  n := size(A, 2);
  lda := max(1, m);
  lwork := 3 * max(1, n);
  external \"FORTRAN 77\" dgeqrf(m, n, Aout, lda, tau, work, lwork, info);
  return;
 end Modelica.Math.Matrices.LAPACK.dgeqrf;

 function Modelica.Math.Matrices.LAPACK.dorgqr
  input Real[:, :] QR;
  input Real[min(size(QR, 1), size(QR, 2))] tau;
  output Real[size(QR, 1), size(QR, 2)] Q;
  output Integer info;
  Integer lda;
  Integer lwork;
  Real[:] work;
 algorithm
  size(work) := {max(1, min(10, size(QR, 2)) * size(QR, 2))};
  for i1 in 1:size(Q, 1) loop
   for i2 in 1:size(Q, 2) loop
    Q[i1,i2] := QR[i1,i2];
   end for;
  end for;
  lda := max(1, size(Q, 1));
  lwork := max(1, min(10, size(QR, 2)) * size(QR, 2));
  external \"FORTRAN 77\" dorgqr(size(QR, 1), size(QR, 2), size(tau, 1), Q, lda, tau, work, lwork, info);
  return;
 end Modelica.Math.Matrices.LAPACK.dorgqr;

end FunctionTests.Lapack_QR;
")})));
end Lapack_QR;

model BindingSort1
	function f
		input Real x;
		output Real y = a + 1;
	protected
        Real a = b + e;
	    Real b = c + d;
	    Real c = x + d;
	    Real d = e + 1;
	    Real e = x + 1;
	algorithm
		y := y + x;
	end f;
	
	Real x = f(y);
	Real y = 1;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="BindingSort1",
			description="Test sorting of binding expressions",
			flatModel="
fclass FunctionTests.BindingSort1
 Real x;
 Real y;
equation
 x = FunctionTests.BindingSort1.f(y);
 y = 1;

public
 function FunctionTests.BindingSort1.f
  input Real x;
  output Real y;
  Real a;
  Real b;
  Real c;
  Real d;
  Real e;
 algorithm
  e := x + 1;
  d := e + 1;
  c := x + d;
  b := c + d;
  a := b + e;
  y := a + 1;
  y := y + x;
  return;
 end FunctionTests.BindingSort1.f;

end FunctionTests.BindingSort1;
")})));
end BindingSort1;

model Interpolate
    function interp
        input Real u;
        output Real value;
    algorithm
	   value := u*2;
	   annotation(derivative=Interpolate.interpDer);
	end interp;

    function interpDer
        input Real u;
        output Real value;
	algorithm
        value := u*3;
    end interpDer;
end Interpolate;

model UseInterpolate	
 Real result;
 Real i = 1.0;
 
equation
	 result = Interpolate.interp(i);


	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UseInterpolate",
			description="",
			flatModel="
fclass FunctionTests.UseInterpolate
 Real result;
 Real i;
equation
 result = FunctionTests.Interpolate.interp(i);
 i = 1.0;

public
 function FunctionTests.Interpolate.interp
  input Real u;
  output Real value;
 algorithm
  value := u * 2;
  return;
 end FunctionTests.Interpolate.interp;

end FunctionTests.UseInterpolate;
")})));
end UseInterpolate;

end FunctionTests;
