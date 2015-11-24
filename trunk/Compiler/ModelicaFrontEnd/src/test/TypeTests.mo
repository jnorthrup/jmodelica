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

package TypeTests

	model TypeTest1
		Integer x = true;
	

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="TypeTest1",
            description="Basic expression type test.",
            errorMessage="
1 errors found:

Error at line 20, column 15, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  The binding expression of the variable x does not match the declared type of the variable
")})));
	end TypeTest1;

	model TypeTest2

	  Real x;
	equation
	  x=true;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="TypeTest2",
            description="Basic expression type test.",
            errorMessage="
1 errors found:

Error at line 39, column 4, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  The right and left expression types of equation are not compatible, type of left-hand side is Real, and type of right-hand side is Boolean
")})));
	end TypeTest2;

	model TypeTest3
	  Real x = 1;
	  Boolean y = true;
      Real z = x + y;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="TypeTest3",
            description="Basic expression type test.",
            errorMessage="
1 errors found:

Error at line 56, column 16, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Type error in expression: x + y
    type of 'x' is Real
    type of 'y' is Boolean
")})));
	end TypeTest3;

	model TypeTest4
	  Real x = 1;
	  Boolean y = true;
	equation
	  x+y=3;  

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="TypeTest4",
            description="Basic expression type test.",
            errorMessage="
1 errors found:

Error at line 76, column 4, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Type error in expression: x + y
    type of 'x' is Real
    type of 'y' is Boolean
")})));
	end TypeTest4;

	model TypeTest5
	  Real x = 1;
	  Boolean y = true;
	initial equation
	  x+y=3;  

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="TypeTest5",
            description="Basic expression type test.",
            errorMessage="
1 errors found:

Error at line 96, column 4, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Type error in expression: x + y
    type of 'x' is Real
    type of 'y' is Boolean
")})));
	end TypeTest5;

	model TypeTest6
	  Real x = 1;
	  Real y(start=true,unit=3,nominal="N",min=true,max="M");
	equation
	  x+y=3;  

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="TypeTest6",
            description="Basic expression type test.",
            errorMessage="
5 errors found:

Error at line 114, column 10, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  The type of the binding expression of the attribute start for the variable y does not match the declared type of the variable

Error at line 114, column 21, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  The type of the binding expression of the attribute unit for the variable y does not match the declared type of the variable

Error at line 114, column 28, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  The type of the binding expression of the attribute nominal for the variable y does not match the declared type of the variable

Error at line 114, column 40, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  The type of the binding expression of the attribute min for the variable y does not match the declared type of the variable

Error at line 114, column 49, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  The type of the binding expression of the attribute max for the variable y does not match the declared type of the variable
")})));
	end TypeTest6;


model TypeRel1
 Boolean eq = 1   == 2;
 Boolean ne = 1   <> 2;
 Boolean gt = 1.0 >  2.0;
 Boolean ge = 1.0 >= 2.0;
 Boolean lt = 1.0 <  2.0;
 Boolean le = 1.0 <= 2.0;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="TypeRel1",
			description="Type checks of relational operators: Real/Real (Integer for ==/<>)",
			flatModel="
fclass TypeTests.TypeRel1
 discrete Boolean eq = 1 == 2;
 discrete Boolean ne = 1 <> 2;
 discrete Boolean gt = 1.0 > 2.0;
 discrete Boolean ge = 1.0 >= 2.0;
 discrete Boolean lt = 1.0 < 2.0;
 discrete Boolean le = 1.0 <= 2.0;

end TypeTests.TypeRel1;
")})));
end TypeRel1;


model TypeRel2
 Boolean gt = 1 >  2.0;
 Boolean ge = 1 >= 2.0;
 Boolean lt = 1 <  2.0;
 Boolean le = 1 <= 2.0;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="TypeRel2",
			description="Type checks of relational operators: Real/Integer",
			flatModel="
fclass TypeTests.TypeRel2
 discrete Boolean gt = 1 > 2.0;
 discrete Boolean ge = 1 >= 2.0;
 discrete Boolean lt = 1 < 2.0;
 discrete Boolean le = 1 <= 2.0;

end TypeTests.TypeRel2;
")})));
end TypeRel2;


model TypeRel3
 Boolean eq = true == false;
 Boolean ne = true <> false;
 Boolean gt = true >  false;
 Boolean ge = true >= false;
 Boolean lt = true <  false;
 Boolean le = true <= false;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="TypeRel3",
			description="Type checks of relational operators: Boolean/Boolean",
			flatModel="
fclass TypeTests.TypeRel3
 discrete Boolean eq = true == false;
 discrete Boolean ne = true <> false;
 discrete Boolean gt = true > false;
 discrete Boolean ge = true >= false;
 discrete Boolean lt = true < false;
 discrete Boolean le = true <= false;

end TypeTests.TypeRel3;
")})));
end TypeRel3;


model TypeRel4
 Boolean eq = "1.0" == "2.0";
 Boolean ne = "1.0" <> "2.0";
 Boolean gt = "1.0" >  "2.0";
 Boolean ge = "1.0" >= "2.0";
 Boolean lt = "1.0" <  "2.0";
 Boolean le = "1.0" <= "2.0";

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="TypeRel4",
			description="Type checks of relational operators: String/String",
			flatModel="
fclass TypeTests.TypeRel4
 discrete Boolean eq = \"1.0\" == \"2.0\";
 discrete Boolean ne = \"1.0\" <> \"2.0\";
 discrete Boolean gt = \"1.0\" > \"2.0\";
 discrete Boolean ge = \"1.0\" >= \"2.0\";
 discrete Boolean lt = \"1.0\" < \"2.0\";
 discrete Boolean le = \"1.0\" <= \"2.0\";

end TypeTests.TypeRel4;
")})));
end TypeRel4;


model TypeRel5
 Boolean eq = {1.0} == {2.0};
 Boolean ne = {1.0} <> {2.0};
 Boolean gt = {1.0} >  {2.0};
 Boolean ge = {1.0} >= {2.0};
 Boolean lt = {1.0} <  {2.0};
 Boolean le = {1.0} <= {2.0};

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="TypeRel5",
            description="Type checks of relational operators: Real[1]/Real[1]",
            errorMessage="
6 errors found:

Error at line 244, column 15, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Type error in expression: {1.0} == {2.0}
    type of '{1.0}' is Real[1]
    type of '{2.0}' is Real[1]

Error at line 245, column 15, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Type error in expression: {1.0} <> {2.0}
    type of '{1.0}' is Real[1]
    type of '{2.0}' is Real[1]

Error at line 246, column 15, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Type error in expression: {1.0} > {2.0}
    type of '{1.0}' is Real[1]
    type of '{2.0}' is Real[1]

Error at line 247, column 15, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Type error in expression: {1.0} >= {2.0}
    type of '{1.0}' is Real[1]
    type of '{2.0}' is Real[1]

Error at line 248, column 15, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Type error in expression: {1.0} < {2.0}
    type of '{1.0}' is Real[1]
    type of '{2.0}' is Real[1]

Error at line 249, column 15, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Type error in expression: {1.0} <= {2.0}
    type of '{1.0}' is Real[1]
    type of '{2.0}' is Real[1]
")})));
end TypeRel5;


model TypeRel6
 Boolean eq = 1.0 == "2.0";
 Boolean ne = 1.0 <> "2.0";
 Boolean gt = 1.0 >  "2.0";
 Boolean ge = 1.0 >= "2.0";
 Boolean lt = 1.0 <  "2.0";
 Boolean le = 1.0 <= "2.0";

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="TypeRel6",
            description="Type checks of relational operators: Real/String",
            errorMessage="
6 errors found:

Error at line 292, column 15, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Equality comparisons do not allow real operands: 1.0 == \"2.0\"
    type of '1.0' is Real
    type of '\"2.0\"' is String

Error at line 293, column 15, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Equality comparisons do not allow real operands: 1.0 <> \"2.0\"
    type of '1.0' is Real
    type of '\"2.0\"' is String

Error at line 294, column 15, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Type error in expression: 1.0 > \"2.0\"
    type of '1.0' is Real
    type of '\"2.0\"' is String

Error at line 295, column 15, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Type error in expression: 1.0 >= \"2.0\"
    type of '1.0' is Real
    type of '\"2.0\"' is String

Error at line 296, column 15, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Type error in expression: 1.0 < \"2.0\"
    type of '1.0' is Real
    type of '\"2.0\"' is String

Error at line 297, column 15, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Type error in expression: 1.0 <= \"2.0\"
    type of '1.0' is Real
    type of '\"2.0\"' is String
")})));
end TypeRel6;



model AbsType1
 Real x = abs(y);
 Real y = -2.0;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="AbsType1",
			description="abs() operator: Real arg & result",
			flatModel="
fclass TypeTests.AbsType1
 Real x = abs(y);
 Real y = - 2.0;
end TypeTests.AbsType1;
")})));
end AbsType1;


model AbsType2
 constant Real x1 = abs(-2.0);
 constant Real x2 = abs(2.0);
 Real y1 = x1;
 Real y2 = x2;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="AbsType2",
			description="abs() operator: Real constant",
			flatModel="
fclass TypeTests.AbsType2
 constant Real x1 = 2.0;
 constant Real x2 = 2.0;
 Real y1 = 2.0;
 Real y2 = 2.0;
end TypeTests.AbsType2;
")})));
end AbsType2;


model AbsType3
 Integer x = abs(y);
 Integer y = -2;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="AbsType3",
			description="abs() operator: Integer arg & result",
			flatModel="
fclass TypeTests.AbsType3
 discrete Integer x = abs(y);
 discrete Integer y = - 2;
end TypeTests.AbsType3;
")})));
end AbsType3;


model AbsType4
 constant Integer x1 = abs(-2);
 constant Integer x2 = abs(2);
 Integer y1 = x1;
 Integer y2 = x2;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="AbsType4",
			description="abs() operator: Integer constant",
			flatModel="
fclass TypeTests.AbsType4
 constant Integer x1 = 2;
 constant Integer x2 = 2;
 discrete Integer y1 = 2;
 discrete Integer y2 = 2;
end TypeTests.AbsType4;
")})));
end AbsType4;


model AbsType5
 parameter String x = abs("-1");

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="AbsType5",
            description="abs() operator: String arg",
            errorMessage="
2 errors found:

Error at line 416, column 14, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Could not evaluate binding expression for structural parameter 'x': 'abs(\"-1\")'

Error at line 417, column 27, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function abs(): types of positional argument 1 and input v are not compatible
    type of '\"-1\"' is String
")})));
end AbsType5;


model AbsType6
 Real x[2] = abs({1,-1});

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="AbsType6",
            description="abs() operator: array arg",
            flatModel="
fclass TypeTests.AbsType6
 Real x[2] = abs({1, -1});
end TypeTests.AbsType6;
")})));
end AbsType6;


model AbsType7
 Real x = abs(1,-1);

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="AbsType7",
            description="abs() operator: too many args",
            errorMessage="
1 errors found:

Error at line 452, column 17, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function abs(): too many positional arguments
")})));
end AbsType7;


model AbsType8
 Real x = abs();

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="AbsType8",
            description="abs() operator: no args",
            errorMessage="
1 errors found:

Error at line 468, column 11, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function abs(): missing argument for required input v
")})));
end AbsType8;



model IntegerExp1
 constant Integer x = integer(1.8);
 Integer y = x;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IntegerExp1",
			description="integer() operator: constant",
			flatModel="
fclass TypeTests.IntegerExp1
 constant Integer x = 1;
 constant Integer y = 1;
end TypeTests.IntegerExp1;
")})));
end IntegerExp1;


model IntegerExp2
 Real x = time;
 Integer y = integer(x);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IntegerExp2",
			description="integer() operator: continous arg",
			flatModel="
fclass TypeTests.IntegerExp2
 Real x;
 discrete Integer y;
initial equation 
 pre(y) = 0;
equation
 x = time;
 y = if x < pre(y) or x >= pre(y) + 1 or initial() then integer(x) else pre(y);
end TypeTests.IntegerExp2;
			
")})));
end IntegerExp2;

model IntegerExp3
  Integer y1 = integer(ceil(floor(3)));
    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="IntegerExp3",
            description="integer() operator: integer arg",
            flatModel="
fclass TypeTests.IntegerExp3
 discrete Integer y1 = integer(ceil(floor(3)));
end TypeTests.IntegerExp3;
")})));
end IntegerExp3;


model ConstCmpEq
 constant Boolean a = 1 == 2;
 constant Boolean b = 1 == 1;
 Boolean x = a;
 Boolean y = b;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ConstCmpEq",
			description="Constant evaluation of comparisons: equals",
			flatModel="
fclass TypeTests.ConstCmpEq
 constant Boolean a = false;
 constant Boolean b = true;
 constant Boolean x = false;
 constant Boolean y = true;
end TypeTests.ConstCmpEq;
")})));
end ConstCmpEq;


model ConstCmpNeq
 constant Boolean a = 1 <> 2;
 constant Boolean b = 1 <> 1;
 Boolean x = a;
 Boolean y = b;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ConstCmpNeq",
			description="Constant evaluation of comparisons: not equal",
			flatModel="
fclass TypeTests.ConstCmpNeq
 constant Boolean a = true;
 constant Boolean b = false;
 constant Boolean x = true;
 constant Boolean y = false;
end TypeTests.ConstCmpNeq;
")})));
end ConstCmpNeq;


model ConstCmpLeq
 constant Boolean a = 1 <= 2;
 constant Boolean b = 1 <= 1;
 constant Boolean c = 2 <= 1;
 Boolean x = a;
 Boolean y = b;
 Boolean z = c;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ConstCmpLeq",
			description="Constant evaluation of comparisons: less or equal",
			flatModel="
fclass TypeTests.ConstCmpLeq
 constant Boolean a = true;
 constant Boolean b = true;
 constant Boolean c = false;
 constant Boolean x = true;
 constant Boolean y = true;
 constant Boolean z = false;
end TypeTests.ConstCmpLeq;
")})));
end ConstCmpLeq;


model ConstCmpLt
 constant Boolean a = 1 < 2;
 constant Boolean b = 1 < 1;
 constant Boolean c = 2 < 1;
 Boolean x = a;
 Boolean y = b;
 Boolean z = c;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ConstCmpLt",
			description="Constant evaluation of comparisons: less than",
			flatModel="
fclass TypeTests.ConstCmpLt
 constant Boolean a = true;
 constant Boolean b = false;
 constant Boolean c = false;
 constant Boolean x = true;
 constant Boolean y = false;
 constant Boolean z = false;
end TypeTests.ConstCmpLt;
")})));
end ConstCmpLt;


model ConstCmpGeq
 constant Boolean a = 1 >= 2;
 constant Boolean b = 1 >= 1;
 constant Boolean c = 2 >= 1;
 Boolean x = a;
 Boolean y = b;
 Boolean z = c;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ConstCmpGeq",
			description="Constant evaluation of comparisons: greater or equal",
			flatModel="
fclass TypeTests.ConstCmpGeq
 constant Boolean a = false;
 constant Boolean b = true;
 constant Boolean c = true;
 constant Boolean x = false;
 constant Boolean y = true;
 constant Boolean z = true;
end TypeTests.ConstCmpGeq;
")})));
end ConstCmpGeq;


model ConstCmpGt
 constant Boolean a = 1 > 2;
 constant Boolean b = 1 > 1;
 constant Boolean c = 2 > 1;
 Boolean x = a;
 Boolean y = b;
 Boolean z = c;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ConstCmpGt",
			description="Constant evaluation of comparisons:greater than",
			flatModel="
fclass TypeTests.ConstCmpGt
 constant Boolean a = false;
 constant Boolean b = false;
 constant Boolean c = true;
 constant Boolean x = false;
 constant Boolean y = false;
 constant Boolean z = true;
end TypeTests.ConstCmpGt;
")})));
end ConstCmpGt;



model RealEq1
 Boolean a = 1.0 == 2;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="RealEq1",
            description="Equality comparisons for reals: == outside function",
            errorMessage="
1 errors found:

Error at line 681, column 14, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Equality comparisons do not allow real operands: 1.0 == 2
    type of '1.0' is Real
    type of '2' is Integer
")})));
end RealEq1;


model RealEq2
 Boolean a = 1.0 <> 2;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="RealEq2",
            description="Equality comparisons for reals: <> outside function",
            errorMessage="
1 errors found:

Error at line 699, column 14, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Equality comparisons do not allow real operands: 1.0 <> 2
    type of '1.0' is Real
    type of '2' is Integer
")})));
end RealEq2;


model RealEq3
 function f
  output Boolean a = 1.0 == 2;
 algorithm
 end f;
 
 Boolean b = f();

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RealEq3",
			description="Equality comparisons for reals: == in function",
			flatModel="
fclass TypeTests.RealEq3
 discrete Boolean b = TypeTests.RealEq3.f();

public
 function TypeTests.RealEq3.f
  output Boolean a := 1.0 == 2;
 algorithm
  return;
 end TypeTests.RealEq3.f;

end TypeTests.RealEq3;
")})));
end RealEq3;


model RealEq4
 function f
  output Boolean a = 1.0 <> 2;
 algorithm
 end f;
 
 Boolean b = f();

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RealEq4",
			description="Equality comparisons for reals: <> in function",
			flatModel="
fclass TypeTests.RealEq4
 discrete Boolean b = TypeTests.RealEq4.f();

public
 function TypeTests.RealEq4.f
  output Boolean a := 1.0 <> 2;
 algorithm
  return;
 end TypeTests.RealEq4.f;

end TypeTests.RealEq4;
")})));
end RealEq4;



model ParameterStart1
  constant Real p(start=2);
  Real y = p;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ParameterStart1",
			description="Constant without binding expression: start set",
			flatModel="
fclass TypeTests.ParameterStart1
 constant Real p(start = 2) = 2;
 constant Real y = 2.0;
end TypeTests.ParameterStart1;
")})));
end ParameterStart1;


model ParameterStart2
  constant Real p;
  Real y = p;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ParameterStart2",
			description="Constant without binding expression: start not set",
			flatModel="
fclass TypeTests.ParameterStart2
 constant Real p = 0.0;
 constant Real y = 0.0;
end TypeTests.ParameterStart2;
")})));
end ParameterStart2;

model ArrayTypeTest1
  type T = Real[3](unit="m");
  T x = {1,2,4};

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayTypeTest1",
			description="Check that short type declarations with array indices are expanded correctly.",
			flatModel="
fclass TypeTests.ArrayTypeTest1
 constant TypeTests.ArrayTypeTest1.T x[1] = 1;
 constant TypeTests.ArrayTypeTest1.T x[2] = 2;
 constant TypeTests.ArrayTypeTest1.T x[3] = 4;

public
 type TypeTests.ArrayTypeTest1.T = Real(unit = \"m\");
end TypeTests.ArrayTypeTest1;
")})));
end ArrayTypeTest1;

model ArrayTypeTest2
  type S = T[4](start=3,unit="m");
  type T = Real[3](unit="l");
  T x = {1,2,4};
  S y = zeros(4,3);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayTypeTest2",
			description="Check that short type declarations with array indices are expanded correctly.",
			flatModel="
fclass TypeTests.ArrayTypeTest2
 constant TypeTests.ArrayTypeTest2.T x[1] = 1;
 constant TypeTests.ArrayTypeTest2.T x[2] = 2;
 constant TypeTests.ArrayTypeTest2.T x[3] = 4;
 constant TypeTests.ArrayTypeTest2.S y[1,1] = 0;
 constant TypeTests.ArrayTypeTest2.S y[1,2] = 0;
 constant TypeTests.ArrayTypeTest2.S y[1,3] = 0;
 constant TypeTests.ArrayTypeTest2.S y[2,1] = 0;
 constant TypeTests.ArrayTypeTest2.S y[2,2] = 0;
 constant TypeTests.ArrayTypeTest2.S y[2,3] = 0;
 constant TypeTests.ArrayTypeTest2.S y[3,1] = 0;
 constant TypeTests.ArrayTypeTest2.S y[3,2] = 0;
 constant TypeTests.ArrayTypeTest2.S y[3,3] = 0;
 constant TypeTests.ArrayTypeTest2.S y[4,1] = 0;
 constant TypeTests.ArrayTypeTest2.S y[4,2] = 0;
 constant TypeTests.ArrayTypeTest2.S y[4,3] = 0;

public
 type TypeTests.ArrayTypeTest2.T = Real(unit = \"l\");
 type TypeTests.ArrayTypeTest2.S = Real(start = 3,unit = \"m\");
end TypeTests.ArrayTypeTest2;
")})));
end ArrayTypeTest2;

model ArrayTypeTest3
 model A
  Real x = 1;
 end A;

 model B = A(x(start=1));

 model C
 extends A;
 end C; 

  B y[3];
  C z[3];
  C w;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayTypeTest3",
			description="Check that short type declarations with array indices are expanded correctly.",
			flatModel="
fclass TypeTests.ArrayTypeTest3
 constant Real y[1].x(start = 1) = 1;
 constant Real y[2].x(start = 1) = 1;
 constant Real y[3].x(start = 1) = 1;
 constant Real z[1].x = 1;
 constant Real z[2].x = 1;
 constant Real z[3].x = 1;
 constant Real w.x = 1;
end TypeTests.ArrayTypeTest3;
")})));
end ArrayTypeTest3;

model ArrayTypeTest4

 model A
  Real x = 1;

 end A;

 model B = A[2](x(start=1));

 model C
 extends A;
 end C; 

  B y[3];
  C z[3];
  C w;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayTypeTest4",
			description="Check that short type declarations with array indices are expanded correctly.",
			flatModel="
fclass TypeTests.ArrayTypeTest4
 constant Real y[1,1].x(start = 1) = 1;
 constant Real y[1,2].x(start = 1) = 1;
 constant Real y[2,1].x(start = 1) = 1;
 constant Real y[2,2].x(start = 1) = 1;
 constant Real y[3,1].x(start = 1) = 1;
 constant Real y[3,2].x(start = 1) = 1;
 constant Real z[1].x = 1;
 constant Real z[2].x = 1;
 constant Real z[3].x = 1;
 constant Real w.x = 1;
end TypeTests.ArrayTypeTest4;
")})));
end ArrayTypeTest4;

model ArrayTypeTest5

 model A
  Real x;
  equation
   x = 3;
 end A;

 model B = A[2](x(start=1));

 model C
 extends A;
 end C; 

  B y[3];
  C z[3];
  C w;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayTypeTest5",
			description="Check that short type declarations with array indices are expanded correctly.",
			flatModel="
fclass TypeTests.ArrayTypeTest5
 constant Real y[1,1].x(start = 1) = 3;
 constant Real y[1,2].x(start = 1) = 3;
 constant Real y[2,1].x(start = 1) = 3;
 constant Real y[2,2].x(start = 1) = 3;
 constant Real y[3,1].x(start = 1) = 3;
 constant Real y[3,2].x(start = 1) = 3;
 constant Real z[1].x = 3;
 constant Real z[2].x = 3;
 constant Real z[3].x = 3;
 constant Real w.x = 3;
end TypeTests.ArrayTypeTest5;
")})));
end ArrayTypeTest5;



model UnknownTypeAccess1
 model C
  Real x=1;
 end C;
 C c;
equation
 c.x = c;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="UnknownTypeAccess1",
            description="Using component of model type as expression",
            errorMessage="
1 errors found:

Error at line 976, column 8, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Accesses to composite components other than records are not allowed: c
")})));
end UnknownTypeAccess1;

model ExtObjType1
    model E1 
        extends ExternalObject;
        function constructor
            output E1 e;
            external "C";
        end constructor;
        
        function destructor
            input E1 e;
            external "C";
        end destructor;
    end E1;
    
    model E2
        extends ExternalObject;
        function constructor
            output E2 e;
            external;
        end constructor;
        
        function destructor
            input E2 e;
            external;
        end destructor;
    end E2;
    parameter E1 e = E2();

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="ExtObjType1",
            description="Check external object types",
            errorMessage="
1 errors found:

Error at line 1016, column 22, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  The binding expression of the variable e does not match the declared type of the variable
")})));
end ExtObjType1;

model RecursiveStructure1
	model A
		B b;
	end A;
	
	model B
		A a1;
	end B;
	
	A a2;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="RecursiveStructure1",
            description="Detect recursive class structures",
            errorMessage="
1 errors found:

Error at line 1035, column 8, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Recursive class structure
")})));
end RecursiveStructure1;


model RecursiveStructure2
	model A
		extends B;
	end A;
	
	model B
		extends A;
	end B;
	
	A a;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="RecursiveStructure2",
            description="Detect recursive class structures",
            errorMessage="
1 errors found:

Error at line 1060, column 3, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Recursive class structure
")})));
end RecursiveStructure2;


model RecursiveStructure3
	model A
		extends B;
	end A;
	
	model B
		A a1;
	end B;
	
	A a2;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="RecursiveStructure3",
            description="Detect recursive class structures",
            errorMessage="
1 errors found:

Error at line 1083, column 8, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Recursive class structure
")})));
end RecursiveStructure3;


model RecursiveStructure4
	model A = B;
	model B = A;
	
	A a;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="RecursiveStructure4",
            description="Detect recursive class structures",
            errorMessage="
1 errors found:

Error at line 1103, column 13, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Recursive class structure
")})));
end RecursiveStructure4;


model RecursiveStructure5
    Integer i = sum(i for i in 1:2);

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="RecursiveStructure5",
            description="Don't trigger recursiveness check on for expression in binding exp of Integer",
            flatModel="
fclass TypeTests.RecursiveStructure5
 discrete Integer i = sum(i for i in 1:2);
end TypeTests.RecursiveStructure5;
")})));
end RecursiveStructure5;


model RecursiveStructure6
    Integer i(start = sum(i for i in 1:2)) = 1;

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="RecursiveStructure6",
            description="Don't trigger recursiveness check on for expression in modifier on Integer",
            flatModel="
fclass TypeTests.RecursiveStructure6
 discrete Integer i(start = sum(i for i in 1:2)) = 1;
end TypeTests.RecursiveStructure6;
")})));
end RecursiveStructure6;


model WhenType1
	Real x = 1;
equation
	when 1 then
		x = 2;
	end when;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="WhenType1",
            description="Using test expression of wrong type",
            errorMessage="
1 errors found:

Error at line 1154, column 2, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Test expression of when equation isn't Boolean scalar or vector expression
")})));
end WhenType1;


model WhenType2
	Real x = 1;
equation
	when fill(false, 1, 1) then
		x = 2;
	end when;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="WhenType2",
            description="Using test expression with too many dimensions",
            errorMessage="
1 errors found:

Error at line 1174, column 2, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Test expression of when equation isn't Boolean scalar or vector expression
")})));
end WhenType2;

model DivTest1
  Real aReal = 3;
  Integer anInt = 3;
  Real x    = div(aReal,aReal) + div(anInt,aReal) + div(aReal,anInt) + div(anInt,anInt);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="DivTest1",
			description="Testing output types of the div operator.",
			flatModel="
fclass TypeTests.DivTest1
 constant Real aReal = 3;
 constant Integer anInt = 3;
 Real x;
 discrete Real temp_1;
 discrete Real temp_2;
 discrete Real temp_3;
initial equation 
 pre(temp_1) = 0.0;
 pre(temp_2) = 0.0;
 pre(temp_3) = 0.0;
equation
 x = temp_3 + temp_2 + temp_1 + 1;
 temp_1 = if 1.0 < pre(temp_1) or 1.0 >= pre(temp_1) + 1 or initial() then 1.0 else pre(temp_1);
 temp_2 = if 1.0 < pre(temp_2) or 1.0 >= pre(temp_2) + 1 or initial() then 1.0 else pre(temp_2);
 temp_3 = if 1.0 < pre(temp_3) or 1.0 >= pre(temp_3) + 1 or initial() then 1.0 else pre(temp_3);
end TypeTests.DivTest1;
			
")})));
end DivTest1;

model DivTest2
  Real x    = div(1.,true) + div("hej",2.);

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="DivTest2",
            description="Testing wrong input types of the div operator.",
            errorMessage="
2 errors found:

Error at line 1222, column 22, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function div(): types of positional argument 2 and input x2 are not compatible
    type of 'true' is Boolean

Error at line 1222, column 34, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function div(): types of positional argument 1 and input x1 are not compatible
    type of '\"hej\"' is String
")})));
end DivTest2;

model ModTest1
  Real aReal = 3;
  Integer anInt = 3;
  Real x    = mod(aReal,aReal) + mod(anInt,aReal) + mod(aReal,anInt) + mod(anInt,anInt);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ModTest1",
			description="Testing output types of the mod operator.",
			flatModel="
fclass TypeTests.ModTest1
 constant Real aReal = 3;
 constant Integer anInt = 3;
 Real x;
 discrete Integer temp_1;
 discrete Real temp_2;
 discrete Real temp_3;
 discrete Real temp_4;
initial equation 
 pre(temp_1) = 0;
 pre(temp_2) = 0.0;
 pre(temp_3) = 0.0;
 pre(temp_4) = 0.0;
equation
 x = 3.0 - temp_4 * 3.0 + (3 - temp_3 * 3.0) + (3.0 - temp_2 * 3) + (3 - temp_1 * 3);
 temp_1 = if 1.0 < pre(temp_1) or 1.0 >= pre(temp_1) + 1 or initial() then 1 else pre(temp_1);
 temp_2 = if 1.0 < pre(temp_2) or 1.0 >= pre(temp_2) + 1 or initial() then 1.0 else pre(temp_2);
 temp_3 = if 1.0 < pre(temp_3) or 1.0 >= pre(temp_3) + 1 or initial() then 1.0 else pre(temp_3);
 temp_4 = if 1.0 < pre(temp_4) or 1.0 >= pre(temp_4) + 1 or initial() then 1.0 else pre(temp_4);
end TypeTests.ModTest1;
			
")})));
end ModTest1;

model ModTest2
  Real x    = mod(1.,true) + mod("hej",2.);

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="ModTest2",
            description="Testing wrong input types of the mod operator.",
            errorMessage="
2 errors found:

Error at line 1276, column 22, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function mod(): types of positional argument 2 and input x2 are not compatible
    type of 'true' is Boolean

Error at line 1276, column 34, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function mod(): types of positional argument 1 and input x1 are not compatible
    type of '\"hej\"' is String
")})));
end ModTest2;

model RemTest1
  Real aReal = 3;
  Integer anInt = 3;
  Real x    = rem(aReal,aReal) + rem(anInt,aReal) + rem(aReal,anInt) + rem(anInt,anInt);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RemTest1",
			description="Testing output types of the rem operator.",
			flatModel="
fclass TypeTests.RemTest1
 constant Real aReal = 3;
 constant Integer anInt = 3;
 Real x;
 discrete Real temp_1;
 discrete Real temp_2;
 discrete Real temp_3;
initial equation 
 pre(temp_1) = 0.0;
 pre(temp_2) = 0.0;
 pre(temp_3) = 0.0;
equation
 x = 3.0 - temp_3 * 3.0 + (3 - temp_2 * 3.0) + (3.0 - temp_1 * 3);
 temp_1 = if 1.0 < pre(temp_1) or 1.0 >= pre(temp_1) + 1 or initial() then 1.0 else pre(temp_1);
 temp_2 = if 1.0 < pre(temp_2) or 1.0 >= pre(temp_2) + 1 or initial() then 1.0 else pre(temp_2);
 temp_3 = if 1.0 < pre(temp_3) or 1.0 >= pre(temp_3) + 1 or initial() then 1.0 else pre(temp_3);
end TypeTests.RemTest1;
			
")})));
end RemTest1;

model RemTest2
  Real x    = rem(1.,true) + rem("hej",2.);

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="RemTest2",
            description="Testing wrong input types of the rem operator.",
            errorMessage="
2 errors found:

Error at line 1327, column 22, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function rem(): types of positional argument 2 and input x2 are not compatible
    type of 'true' is Boolean

Error at line 1327, column 34, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function rem(): types of positional argument 1 and input x1 are not compatible
    type of '\"hej\"' is String
")})));
end RemTest2;

model PreTest1
    Real x (start=3);
    Real y;
    discrete Real z;
equation
    y = pre(x);
    when time>1 then
        z = pre(x);
    elsewhen time > 3 then
        z = 2*pre(x);
    end when;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="PreTest1",
            description="Testing that continuous variables can't be accessed in pre expressions in normal equations",
            errorMessage="
1 errors found:

Error at line 1351, column 9, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling built-in operator pre() with a continuous variable access as argument can only be done in when clauses and initial equations
")})));
end PreTest1;


model PreTest2
	Real x(start = 1);
	discrete Real y;
equation
	when time > 1 then
		x = 2;
	end when;
	y = pre(x);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="PreTest2",
			description="Allow pre() on variable assigned in when",
			flatModel="
fclass TypeTests.PreTest2
 discrete Real x(start = 1);
 discrete Real y;
equation
 when time > 1 then
  x = 2;
 end when;
 y = pre(x);
end TypeTests.PreTest2;
")})));
end PreTest2;


model PreTest3
    Real x(start = 1);
    discrete Real y;
equation
    y = pre(x);
algorithm
    when time > 1 then
        if x < time then
            x := 2;
        end if;
    end when;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="PreTest3",
			description="",
			flatModel="
fclass TypeTests.PreTest3
 discrete Real x(start = 1);
 discrete Real y;
equation
 y = pre(x);
algorithm
 when time > 1 then
  if x < time then
   x := 2;
  end if;
 end when;
end TypeTests.PreTest3;
")})));
end PreTest3;


model PreTest4
    Real x(start = 1);
initial equation
    pre(x) = 0;
equation
    der(x) = time;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="PreInInitial1",
            description="Test that pre() of continuous variable can be used in initial equations",
            flatModel="
fclass TypeTests.PreTest4
 Real x(start = 1);
initial equation 
 pre(x) = 0;
 x = 1;
equation
 der(x) = time;
end TypeTests.PreTest4;
")})));
end PreTest4;

model DerTest1
    Integer i;
    Boolean b;
equation
    der(i) = time;
    der(b) = if time > 0 then true else false;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="DerTest1",
            description="Test that der give errors for non-real references",
            errorMessage="
2 errors found:

Error at line 1458, column 5, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Only real typed expressions are allowed in der() operator

Error at line 1459, column 5, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Only real typed expressions are allowed in der() operator
")})));
end DerTest1;

model DerTest2
    Real r1;
    Real r2;
equation
    der({r1, r2}) = {time, time};

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="DerTest2",
            description="Test that der give errors for non-real references",
            flatModel="
fclass TypeTests.DerTest2
 Real r1;
 Real r2;
initial equation 
 r1 = 0.0;
 r2 = 0.0;
equation
 der(r1) = time;
 der(r2) = time;
end TypeTests.DerTest2;
")})));
end DerTest2;

model EdgeTest1
  Real x (start=3);
  Boolean x2;
  Boolean y,y2;
  Boolean z,z2;
  
equation
  y  = edge(x);
  y2 = edge(x2);
  when time>1 then
    z  = edge(x);
    z2 = edge(x2);
  end when;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="EdgeTest1",
            description="Testing that input to edge has to be boolean.",
            errorMessage="
2 errors found:

Error at line 1507, column 8, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function edge(): argument must be a boolean variable access

Error at line 1510, column 10, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function edge(): argument must be a boolean variable access
")})));
end EdgeTest1;

model ChangeTest1
  Real x (start=3);
  Boolean y;
  Boolean z;
equation
  y = change(x);
  when time>1 then
    z = change(x);
  end when;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="ChangeTest1",
            description="Testing that continuous variables can be accessed in change expressions only inside when clauses.",
            errorMessage="
1 errors found:

Error at line 1534, column 7, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling built-in operator change() with a continuous variable access as argument can only be done in when clauses and initial equations
")})));
end ChangeTest1;


model ChangeTest2
    Real x(start = 1);
    discrete Real y;
equation
    when time > 1 then
        x = 2;
    end when;
    y = if change(x) then 1 else x;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ChangeTest2",
			description="Allow change() on variable assigned in when",
			flatModel="
fclass TypeTests.ChangeTest2
 discrete Real x(start = 1);
 discrete Real y;
equation
 when time > 1 then
  x = 2;
 end when;
 y = if x <> pre(x) then 1 else x;
end TypeTests.ChangeTest2;
")})));
end ChangeTest2;


model HomotopyTest1
  Real x[2] = homotopy({1,2}, {1});

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="HomotopyTest1",
            description="Testing error when type of homotopy arguments differ",
            errorMessage="
1 errors found:

Error at line 1, column 1, in file '...':
  Mismatching sizes in homotopy. All non-scalar arguments need matching sizes
")})));
end HomotopyTest1;

model IfExpType1
    model M
        parameter Integer n=1;
        Real y[n];
    end M;

    parameter Integer n = 3;
    M m(n=n, y = if n==1 then {2} else 1:n);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IfExpType1",
			description="If expression with branches with different array sizes",
			flatModel="
fclass TypeTests.IfExpType1
 structural parameter Integer n = 3 /* 3 */;
 structural parameter Integer m.n = 3 /* 3 */;
 constant Real m.y[1] = 1;
 constant Real m.y[2] = 2;
 constant Real m.y[3] = 3;
end TypeTests.IfExpType1;
")})));
end IfExpType1;


model IfExpType2
    Real x = if 1 then 1 else 2;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="IfExpType2",
            description="If expression errors: non-boolean test expression",
            errorMessage="
1 errors found:

Error at line 1620, column 17, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Test expression of if expression must be scalar boolean
")})));
end IfExpType2;


model IfExpType3
    model M
        parameter Integer n=1;
        Real y[n];
    end M;

    parameter Integer n = 3;
    M m(n=n, y = if n==1 then {true} else 1:n);

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="IfExpType3",
            description="If expression errors: incompatible types of branches",
            errorMessage="
1 errors found:

Error at line 1642, column 18, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Branches of if expression has incompatible types
")})));
end IfExpType3;


model IfExpType4
    model M
        parameter Integer n=1;
        Real y[n];
    end M;

    parameter Integer n = 3;
    Integer k = n;
    M m(n=n, y = if k==1 then {2} else 1:n);

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="IfExpType4",
            description="If expression errors: non-parameter test expression",
            errorMessage="
1 errors found:

Error at line 1665, column 18, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  If expression with branches that have different array sizes must have parameter test expression
")})));
end IfExpType4;


model IfExpType5
  function F
    input Real x1;
    input Real x2;
    input Integer n;
    output Real y[n];
  algorithm
    for i in 1:n loop
      y[i] := i;
    end for;
    y[1] := x1 + x2;
  end F;

  model M
    parameter Integer n=1;
    Real y[n];
  end M;

  parameter Integer n = 3;
  M m(n=n, y = if n==1 then {2.} else F(3,5,n));

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IfExpType5",
			description="If expression with branches with different array sizes, using function call",
			variability_propagation=false,
			flatModel="
fclass TypeTests.IfExpType5
 structural parameter Integer n = 3 /* 3 */;
 structural parameter Integer m.n = 3 /* 3 */;
 Real m.y[1];
 Real m.y[2];
 Real m.y[3];
equation
 ({m.y[1], m.y[2], m.y[3]}) = TypeTests.IfExpType5.F(3, 5, 3);

public
 function TypeTests.IfExpType5.F
  input Real x1;
  input Real x2;
  input Integer n;
  output Real[:] y;
 algorithm
  size(y) := {n};
  for i in 1:n loop
   y[i] := i;
  end for;
  y[1] := x1 + x2;
  return;
 end TypeTests.IfExpType5.F;

end TypeTests.IfExpType5;
")})));
end IfExpType5;

model Primitive1
    type T2 = Real[3];
    type T = T2;
    
    Real[3] x = {1,2,3};
    T y = x;
	T z;
	T2 w = x;
equation
	z = x;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="Primitive1",
			description="Short class decl of type that is array of Real",
			flatModel="
fclass TypeTests.Primitive1
 Real x[3] = {1, 2, 3};
 TypeTests.Primitive1.T2 y[3] = x[1:3];
 TypeTests.Primitive1.T2 z[3];
 TypeTests.Primitive1.T2 w[3] = x[1:3];
equation
 z[1:3] = x[1:3];

public
 type TypeTests.Primitive1.T2 = Real;
end TypeTests.Primitive1;
")})));
end Primitive1;


model Primitive2
    type T2 = Real[3];
    type T
		extends T2;
	end T;
        
    Real[3] x = {1,2,3};
    T y = x;
    T z;
    T2 w = x;
equation
    z = x;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="Primitive2",
			description="Class decl extending type that is array of Real",
			flatModel="
fclass TypeTests.Primitive2
 Real x[3] = {1, 2, 3};
 TypeTests.Primitive2.T y[3] = x[1:3];
 TypeTests.Primitive2.T z[3];
 TypeTests.Primitive2.T2 w[3] = x[1:3];
equation
 z[1:3] = x[1:3];

public
 type TypeTests.Primitive2.T = Real;
 type TypeTests.Primitive2.T2 = Real;
end TypeTests.Primitive2;
")})));
end Primitive2;


model Primitive3
    type T1 = Real;
    type T2 = T1[2];
	type T3 = T2;
	type T4 = T3[3];
	type T5 = T4;
    
    Real[3,2] x = {{1,2},{3,4},{5,6}};
    Real[2] y = {7,8};
    T5 z1 = x;
    T5 z2;
	T3 z3 = y;
	T3 z4;
equation
    z2 = x;
	z4 = y;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="Primitive3",
			description="Short class decl of type that is array of Real, adding dimensions in several levels",
			flatModel="
fclass TypeTests.Primitive3
 Real x[3,2] = {{1, 2}, {3, 4}, {5, 6}};
 Real y[2] = {7, 8};
 TypeTests.Primitive3.T4 z1[3,2] = x[1:3,1:2];
 TypeTests.Primitive3.T4 z2[3,2];
 TypeTests.Primitive3.T2 z3[2] = y[1:2];
 TypeTests.Primitive3.T2 z4[2];
equation
 z2[1:3,1:2] = x[1:3,1:2];
 z4[1:2] = y[1:2];

public
 type TypeTests.Primitive3.T4 = Real;
 type TypeTests.Primitive3.T2 = Real;
end TypeTests.Primitive3;
")})));
end Primitive3;


model Primitive4
    type T2 = Real[3,3];
    type T = T2;
        
    function f
        input Real[3] x;
        input Real[3] y;
        output T z;
    algorithm
        z := {x, cross(x,y), y};
    end f;
    
    Real[3] x = {1,2,3};
    Real[3] y = {4,5,6};
    T z1 = f(x,y);
    T z2;
equation
    z2 = transpose(z1);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="Primitive4",
			description="",
			flatModel="
fclass TypeTests.Primitive4
 Real x[3] = {1, 2, 3};
 Real y[3] = {4, 5, 6};
 TypeTests.Primitive4.T2 z1[3,3] = TypeTests.Primitive4.f(x[1:3], y[1:3]);
 TypeTests.Primitive4.T2 z2[3,3];
equation
 z2[1:3,1:3] = transpose(z1[1:3,1:3]);

public
 function TypeTests.Primitive4.f
  input Real[3] x;
  input Real[3] y;
  output Real[3, 3] z;
 algorithm
  z := {x, cross(x, y), y};
  return;
 end TypeTests.Primitive4.f;

 type TypeTests.Primitive4.T2 = Real;
end TypeTests.Primitive4;
")})));
end Primitive4;


model StringExpType1
	parameter String a = String({1,2});
	parameter String b = String("a");

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="StringExpType1",
            description="",
            errorMessage="
4 errors found:

Error at line 1889, column 20, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Could not evaluate binding expression for structural parameter 'a': 'String({1, 2})'
    Cannot get int value of CValueArray ({ 1, 2 })

Error at line 1890, column 30, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function String(): types of positional argument 1 and input x are not compatible
    type of '{1, 2}' is Integer[2]

Error at line 1890, column 36, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
    Could not evaluate binding expression for structural parameter 'b': 'String(\"a\")'

Error at line 1891, column 30, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function String(): types of positional argument 1 and input x are not compatible
    type of '\"a\"' is String
")})));
end StringExpType1;

model AlgorithmType1
	Boolean b;
	Integer i;
	discrete Real r;
algorithm
	r := time*time + 1;
	b := noEvent(r > 2) and noEvent(r < 4);
	i := integer(r);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AlgorithmType1",
			description="Correct types in algorithm.",
			flatModel="
fclass TypeTests.AlgorithmType1
 discrete Boolean b;
 discrete Integer i;
 discrete Real r;
 discrete Integer temp_1;
 Real _eventIndicator_1;
 Real _eventIndicator_2;
initial equation 
 pre(temp_1) = 0;
 pre(b) = false;
 pre(i) = 0;
 pre(r) = 0.0;
algorithm
 r := time * time + 1;
 b := noEvent(r > 2) and noEvent(r < 4);
 _eventIndicator_1 := r - pre(temp_1);
 _eventIndicator_2 := r - (pre(temp_1) + 1);
 temp_1 := if r < pre(temp_1) or r >= (pre(temp_1) + 1) or initial() then integer(r) else pre(temp_1);
 i := temp_1;
end TypeTests.AlgorithmType1;
			
")})));
end AlgorithmType1;
	
model AlgorithmType2
	record I
		R innerR[3];
		Integer innerInteger[3];
	end I;
	record R
		discrete Real r;
	end R;
	R outerR[3];
	Integer outerInteger[3];
	I i;
algorithm
	outerInteger := {1,2,3};
	outerR := {R(1.0),R(2.0),R(3.0)};
	i := I(outerR, outerInteger);
	
	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AlgorithmType2",
			description="Correct types in algorithm. Records and arrays.",
			flatModel="
fclass TypeTests.AlgorithmType2
 discrete Real outerR[1].r;
 discrete Real outerR[2].r;
 discrete Real outerR[3].r;
 discrete Integer outerInteger[1];
 discrete Integer outerInteger[2];
 discrete Integer outerInteger[3];
 discrete Real i.innerR[1].r;
 discrete Real i.innerR[2].r;
 discrete Real i.innerR[3].r;
 discrete Integer i.innerInteger[1];
 discrete Integer i.innerInteger[2];
 discrete Integer i.innerInteger[3];
initial equation 
 pre(outerR[1].r) = 0.0;
 pre(outerR[2].r) = 0.0;
 pre(outerR[3].r) = 0.0;
 pre(outerInteger[1]) = 0;
 pre(outerInteger[2]) = 0;
 pre(outerInteger[3]) = 0;
 pre(i.innerR[1].r) = 0.0;
 pre(i.innerR[2].r) = 0.0;
 pre(i.innerR[3].r) = 0.0;
 pre(i.innerInteger[1]) = 0;
 pre(i.innerInteger[2]) = 0;
 pre(i.innerInteger[3]) = 0;
algorithm
 outerInteger[1] := 1;
 outerInteger[2] := 2;
 outerInteger[3] := 3;
 outerR[1].r := 1.0;
 outerR[2].r := 2.0;
 outerR[3].r := 3.0;
 i.innerR[1].r := outerR[1].r;
 i.innerR[2].r := outerR[2].r;
 i.innerR[3].r := outerR[3].r;
 i.innerInteger[1] := outerInteger[1];
 i.innerInteger[2] := outerInteger[2];
 i.innerInteger[3] := outerInteger[3];
end TypeTests.AlgorithmType2;
")})));
end AlgorithmType2;

model AlgorithmType3
	Boolean b;
	Integer i;
	Real r;
algorithm
	b := time*time + 1;
	r := noEvent(r > 2) and noEvent(r < 4);
	i := if b then "one" else "two";

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="AlgorithmType3",
            description="Incorrect types in algorithm",
            errorMessage="
3 errors found:

Error at line 2023, column 2, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  The right and left expression types of assignment are not compatible, type of left-hand side is Boolean, and type of right-hand side is Real

Error at line 2024, column 2, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  The right and left expression types of assignment are not compatible, type of left-hand side is Real, and type of right-hand side is Boolean

Error at line 2025, column 2, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  The right and left expression types of assignment are not compatible, type of left-hand side is Integer, and type of right-hand side is String
")})));
end AlgorithmType3;

model AlgorithmType4
	
	function f
		output Real o = 2;
	algorithm
	end f;
	constant Real x;
	parameter Real y;
initial algorithm
	x := 1;
	y := 2;
algorithm
	x := 2;
	y := 3;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="AlgorithmType4",
            description="Algorithm assigning to parameters and constants.",
            errorMessage="
3 errors found:

Error at line 2054, column 2, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Assignments to constants is not allowed in algorithms

Error at line 2057, column 2, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Assignments to constants is not allowed in algorithms

Error at line 2058, column 2, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Assignments to parameters in algorithms is only allowed in initial algorithms
")})));
end AlgorithmType4;

model ModOnConstantExtends
    function f
      input Real[:] x;
      output Real[size(x,1)] y;
    protected
      Real t[size(x,1)] = fill(1,size(x,1))./x;
    algorithm
      y := t;
    end f;
    model T2
       constant Real[1] y;
    end T2;
    
    extends T2(y=f({1}));
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ModOnConstantExtends",
            description="Error checking modification on constant before evaluation. #3822",
            flatModel="
fclass TypeTests.ModOnConstantExtends
 constant Real y[1] = 1.0;
end TypeTests.ModOnConstantExtends;
")})));
end ModOnConstantExtends;


model Functional1
    partial function partFunc1
        input Real x;
        output Real y;
    end partFunc1;
    
    partial function partFunc2
        input Real x;
        output Real y;
    end partFunc2;
    
    function fullFunc
        extends partFunc1;
      algorithm
        y := x*x;
    end fullFunc;
    
    function usePartFunc1
        input partFunc1 pf;
        input Real x;
        output Real y;
      algorithm
        y := pf(x);
    end usePartFunc1;
    
    function usePartFunc2
        input partFunc2 pf;
        input Real x;
        output Real y;
      algorithm
        y := pf(x);
    end usePartFunc2;
    
    Real[2] y1 = usePartFunc1({{function fullFunc(), function fullFunc()}}, time);
    Real[2] y2 = usePartFunc2({{function fullFunc(), function fullFunc()}}, time);

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Functional1",
            description="Check type error for functional input argument",
            errorMessage="
2 errors found:

Error at line 2138, column 18, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Array size mismatch in declaration of y1, size of declaration is [2] and size of binding expression is [1, 2]

Error at line 2139, column 18, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Array size mismatch in declaration of y2, size of declaration is [2] and size of binding expression is [1, 2]
")})));
end Functional1;


model Functional2
    partial function partFunc
        input Real x;
        output Real y;
    end partFunc;
    
    function fullFunc
        extends partFunc;
        input Real x;
      algorithm
        y := x*x;
    end fullFunc;
    
    function usePartFunc
        input partFunc pf;
        input Real x;
        output Real y;
      algorithm
        y := pf(x);
    end usePartFunc;
    
    Real y = usePartFunc(function fullFunc(x=time), time);

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Functional2",
            description="Check that duplicate component declaration is handled correctly",
            errorMessage="
1 errors found:

Error at line 2178, column 44, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Creating functional input argument fullFunc(): no input matching named argument x found
")})));
end Functional2;


model Functional3
    partial function partFunc1
        input Real x;
        output Real y;
    end partFunc1;
    
    partial function partFunc2
        input Real x;
        output Real y;
    end partFunc2;
    
    function fullFunc
        extends partFunc1;
        extends partFunc2;
      algorithm
        y := x*x;
    end fullFunc;
    
    function usePartFunc
        input partFunc1 pf;
        input Real x;
        output Real y;
      algorithm
        y := pf(x);
    end usePartFunc;
    
    Real y = usePartFunc(function fullFunc(x=time), time);

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Functional3",
            description="Check that duplicate component declaration is handled correctly",
            errorMessage="
1 errors found:

Error at line 2219, column 44, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Creating functional input argument fullFunc(): no input matching named argument x found
")})));
end Functional3;


model Functional4
    partial function partFunc
        input Real x;
        output Real y;
    end partFunc;
    
    function fullFunc
        extends partFunc;
      algorithm
        y := x*x;
    end fullFunc;
    
    function usePartFunc
        input partFunc pf;
        input Real x;
        output Real y;
      algorithm
        y := pf(x);
    end usePartFunc;
    
    Real y1 = usePartFunc(time, function fullFunc());
    
    annotation(__JModelica(UnitTesting(tests={
        ComplianceErrorTestCase(
            name="Functional4",
            description="Check type error",
            errorMessage="
2 errors found:

Error at line 2254, column 27, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function usePartFunc(): types of positional argument 1 and input pf are not compatible
    type of 'time' is Real

Error at line 2254, column 33, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function usePartFunc(): types of positional argument 2 and input x are not compatible
    type of 'fullFunc()' is ((Real y) = TypeTests.Functional4.fullFunc(Real x))
")})));
end Functional4;


model Functional5
    partial function partFunc
        input Real x;
        output Real y;
    end partFunc;
    
    function fullFunc
        input Real a;
        output Real b;
      algorithm
        b := a*a;
    end fullFunc;
    
    function usePartFunc
        input partFunc pf;
        input Real x;
        output Real y;
      algorithm
        y := pf(x);
    end usePartFunc;
    
    Real y1 = usePartFunc(function fullFunc(), time);
    
    annotation(__JModelica(UnitTesting(tests={
        ComplianceErrorTestCase(
            name="Functional5",
            description="Check type error",
            errorMessage="
2 errors found:

Error at line 2295, column 27, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function usePartFunc(): types of positional argument 1 and input pf are not compatible
    type of 'fullFunc()' is ((Real b) = TypeTests.Functional5.fullFunc())

Error at line 2295, column 27, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Creating functional input argument fullFunc(): missing argument for required input a
")})));
end Functional5;


model Functional6
    partial function partFunc
        input Real x;
        output Real y;
    end partFunc;
    
    function fullFunc
        input Real a;
        output Real b;
      algorithm
        b := a*a;
    end fullFunc;
    
    function usePartFunc
        output Real y;
      algorithm
        y := 3;
    end usePartFunc;
    
    Real y1 = usePartFunc(function fullFunc());
    
    annotation(__JModelica(UnitTesting(tests={
        ComplianceErrorTestCase(
            name="Functional6",
            description="Check type error",
            errorMessage="
1 errors found:

Error at line 2333, column 27, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function usePartFunc(): too many positional arguments
")})));
end Functional6;


model Functional7
    partial function partFunc
        input Real x1;
        output Real y;
    end partFunc;
    
    partial function middleFunc
        extends partFunc;
        input Real x2;
    end middleFunc;
    
    function fullFunc
        extends middleFunc;
        input Real x3;
      algorithm
        y := x1 + x2 + x3;
    end fullFunc;
    
    function useMiddleFunc
        input middleFunc mf;
        input Real b;
        input Real c;
        output Real y = usePartFunc(function mf(x1=1,x2="string",x3=3,x4=4), c);
        algorithm
    end useMiddleFunc;
    
    function usePartFunc
        input partFunc pf;
        input Real c;
        output Real y;
      algorithm
        y := pf(c);
    end usePartFunc;

    Real y = useMiddleFunc(function fullFunc(x3=time), time, time);
    
    annotation(__JModelica(UnitTesting(tests={
        ComplianceErrorTestCase(
            name="Functional7",
            description="Check type error for functional arguments. Chained",
            errorMessage="
4 errors found:

Error at line 2370, column 49, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Creating functional input argument mf(): no input matching named argument x1 found

Error at line 2370, column 54, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Creating functional input argument mf(): types of named argument x2 and input x2 are not compatible
    type of '\"string\"' is String

Error at line 2370, column 66, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Creating functional input argument mf(): no input matching named argument x3 found

Error at line 2370, column 71, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Creating functional input argument mf(): no input matching named argument x4 found
")})));
end Functional7;


model Delay1
    Real x1 = sin(time);
    Real d;
  equation
    {x1} = delay({x1}, {d,d}, 2);

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Delay1",
            description="Check type error for delay().",
            errorMessage="
1 errors found:

Error at line 2411, column 24, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function delay(): types of positional argument 2 and input delayTime are not compatible
    type of '{d, d}' is Real[2]
")})));
end Delay1;


model SpatialDist1
    Real x = sin(time);
    Real d;
  equation
    {x} = spatialDistribution({x}, d, {2}, {true}, {{0,0},{0,0}});

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="SpatialDist1",
            description="Check type error for spatialDistribution().",
            errorMessage="
4 errors found:

Error at line 2431, column 11, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function spatialDistribution(): first and second arguments 'in0' and 'in1' needs equivalent sizes

Error at line 2431, column 11, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function spatialDistribution(): fourth argument 'positiveVelocity' cannot be vectorized

Error at line 2431, column 11, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function spatialDistribution(): third argument 'x' cannot be vectorized

Error at line 2431, column 52, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Calling function spatialDistribution(): types of positional argument 5 and input initialPoints are not compatible
    type of '{{0, 0}, {0, 0}}' is Integer[2, 2]
")})));
end SpatialDist1;


model SpatialDist2
    Real[2] y1;
    Real[2] y2;
  equation
    (y1,y2) = spatialDistribution({1,2}, {3,4}, 2, true);

    annotation(__JModelica(UnitTesting(tests={
        ComplianceErrorTestCase(
            name="SpatialDist2",
            description="Check type error for spatialDistribution().",
            errorMessage="
1 errors found:

Compliance error at line 2460, column 15, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  The spatialDistribution() function-like operator is not supported vectorized in function call equations
")})));
end SpatialDist2;


model CircularIfExp1
    parameter Boolean a = true annotation(Evaluate=true);
    parameter Real b = if a then 1 else c;
    parameter Real c = if a then b else 2;

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="CircularIfExp1",
            description="Circularity in binding expressions of parameters resolved by Evaluate=true on parameters used in test",
            flatModel="
fclass TypeTests.CircularIfExp1
 eval parameter Boolean a = true /* true */;
 parameter Real b = 1 /* 1 */;
 parameter Real c = b;
end TypeTests.CircularIfExp1;
")})));
end CircularIfExp1;


model CircularIfExp2
    parameter Boolean a = true annotation(Evaluate=true);
    parameter Boolean b = true annotation(Evaluate=true);
    parameter Real c = if a and b then 1 else d;
    parameter Real d = if a and b then c else 2;

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="CircularIfExp2",
            description="Circularity in binding expressions of parameters resolved by Evaluate=true on parameters used in test",
            flatModel="
fclass TypeTests.CircularIfExp2
 eval parameter Boolean a = true /* true */;
 eval parameter Boolean b = true /* true */;
 parameter Real c = 1 /* 1 */;
 parameter Real d = c;
end TypeTests.CircularIfExp2;
")})));
end CircularIfExp2;


model CircularIfExp3
    parameter Boolean a = true annotation(Evaluate=true);
    parameter Boolean b = true annotation(Evaluate=true);
    parameter Real c = if a then 1 else d;
    parameter Real d = if b then c else 2;

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="CircularIfExp3",
            description="Circularity in binding expressions of parameters resolved by Evaluate=true on parameters used in test",
            flatModel="
fclass TypeTests.CircularIfExp3
 eval parameter Boolean a = true /* true */;
 eval parameter Boolean b = true /* true */;
 parameter Real c = 1 /* 1 */;
 parameter Real d = c;
end TypeTests.CircularIfExp3;
")})));
end CircularIfExp3;


model CircularIfExp4
    parameter Boolean a = true annotation(Evaluate=true);
    parameter Boolean b = true;
    parameter Real c = if a and b then 1 else d;
    parameter Real d = if a and b then c else 2;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="CircularIfExp4",
            description="Circularity in binding expressions of parameters not resolved by Evaluate=true on only one of the parameters used in test",
            errorMessage="
2 errors found:

Error at line 2539, column 24, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Circularity in binding expression of parameter: c = if a and b then 1 else d

Error at line 2540, column 24, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Circularity in binding expression of parameter: d = if a and b then c else 2
")})));
end CircularIfExp4;


model CircularIfExp5
    parameter Boolean a = false annotation(Evaluate=true);
    parameter Boolean b = true annotation(Evaluate=true);
    parameter Real c = if a then 1 else d;
    parameter Real d = if b then c else 2;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="CircularIfExp5",
            description="Circularity in binding expressions of parameters not resolved by Evaluate=true on parameters used in test, when actual value leads to circularity",
            errorMessage="
2 errors found:

Error at line 2561, column 24, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Circularity in binding expression of parameter: c = if a then 1 else d

Error at line 2562, column 24, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Circularity in binding expression of parameter: d = if b then c else 2
")})));
end CircularIfExp5;


model CircularIfExp6
    parameter Real a = if a < 2 then 3 else 1;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="CircularIfExp6",
            description="Using circular parameter in if expression",
            errorMessage="
1 errors found:

Error at line 2581, column 24, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  Circularity in binding expression of parameter: a = if a < 2 then 3 else 1
")})));
end CircularIfExp6;

model DivType1
    function f
        input Integer n;
        output Real[n] x;
        Real[:] t = 1:5;
    algorithm
        x := t[div(2:n+1,n)];
    end f;
    
    Real[3] x = f(3);
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="DivType1",
            description="Type calculation for div() operator",
            flatModel="
fclass TypeTests.DivType1
 parameter Real x[1];
 constant Real x[2] = 1;
 constant Real x[3] = 1;
parameter equation
 ({x[1], , }) = TypeTests.DivType1.f(3);

public
 function TypeTests.DivType1.f
  input Integer n;
  output Real[:] x;
  Real[5] t;
 algorithm
  size(x) := {n};
  t[1] := 1;
  t[2] := 2;
  t[3] := 3;
  t[4] := 4;
  t[5] := 5;
  for i1 in 1:max(integer(n + 1 - 2) + 1, 0) loop
   x[i1] := t[div(2 + (i1 - 1), n)];
  end for;
  return;
 end TypeTests.DivType1.f;

end TypeTests.DivType1;
")})));
end DivType1;


model NominalValue1
    Real x(nominal=0, start=2, fixed=true);
equation
    der(x) = -x / time;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="NominalValue1",
            description="Error for nominal=0",
            errorMessage="
1 errors found:

Error at line 2641, column 11, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  The attribute nominal for the variable x is set to 0, evaluating to 0.0. A nominal value of zero is not meaningful. Please set the nominal value to the expected magnitude of the variable.
")})));
end NominalValue1;


model NominalValue2
	parameter Real p1 = 2;
	parameter Real p2 = 1 + 1;
    Real x(nominal=p1 - p2, start=2, fixed=true);
equation
    der(x) = -x / time;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="NominalValue2",
            description="Error for nominal value that evaluates to 0",
            errorMessage="
1 errors found:

Error at line 2661, column 11, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  The attribute nominal for the variable x is set to p1 - p2, evaluating to 0.0. A nominal value of zero is not meaningful. Please set the nominal value to the expected magnitude of the variable.
")})));
end NominalValue2;


model NominalValue3
    Real x(nominal=1e-200, start=2, fixed=true);
equation
    der(x) = -x / time;

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="NominalValue3",
            description="No error for nominal value very close to 0",
            flatModel="
fclass TypeTests.NominalValue3
 Real x(nominal = 1.0E-200,start = 2,fixed = true);
equation
 der(x) = (- x) / time;
end TypeTests.NominalValue3;
")})));
end NominalValue3;


model NominalValue4
    Real x[4](nominal={1,0,2,0}, each start=2, each fixed=true);
equation
    der(x) = -x / time;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="NominalValue4",
            description="Error for array nominal value where some cells evaluate to 0",
            errorMessage="
1 errors found:

Error at line 2686, column 14, in file 'Compiler/ModelicaFrontEnd/src/test/TypeTests.mo':
  The attribute nominal for the variable x is set to {1, 0, 2, 0}, where element [2] evaluates to 0.0. A nominal value of zero is not meaningful. Please set the nominal value to the expected magnitude of the variable.
")})));
end NominalValue4;

end TypeTests;
