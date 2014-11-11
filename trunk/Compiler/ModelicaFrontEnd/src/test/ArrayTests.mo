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

within ;
package ArrayTests
	
model Test
    connector C = Real;
    C x[3];
equation
    for i in 1:3 loop
        if i < 3 then
            connect(x[i], x[i+1]);
        else
            connect(x[i], x[1]);
        end if;
    end for;
end Test;
	
package General
		
  model ArrayTest1
    Real x[2];
  equation
    x[1] = 3;
    x[2] = 4;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ArrayTest1",
			description="Flattening of arrays.",
			flatModel="
fclass ArrayTests.General.ArrayTest1
 Real x[2];
equation 
 x[1] = 3;
 x[2] = 4;

end ArrayTests.General.ArrayTest1;
")})));
  end ArrayTest1;

  model ArrayTest1b
  
    parameter Integer n = 2;
    Real x[n];
  equation
    x[1] = 3;
    x[2] = 4;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ArrayTest1b",
			description="Flattening of arrays.",
			flatModel=" 
fclass ArrayTests.General.ArrayTest1b
 structural parameter Integer n = 2 /* 2 */;
 Real x[2];
equation 
 x[1] = 3;
 x[2] = 4; 

end ArrayTests.General.ArrayTest1b;
")})));
  end ArrayTest1b;


  model ArrayTest1c

    Real x[2];
  equation
    der(x[1]) = 3;
    der(x[2]) = 4;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayTest1c",
			description="Test scalarization of variables",
			flatModel="
fclass ArrayTests.General.ArrayTest1c
 Real x[1];
 Real x[2];
initial equation 
 x[1] = 0.0;
 x[2] = 0.0;
equation 
 der(x[1]) = 3;
 der(x[2]) = 4;

end ArrayTests.General.ArrayTest1c;
")})));
  end ArrayTest1c;


  model ArrayTest2

    Real x[2,2];
  equation
    x[1,1] = 1;
    x[1,2] = 2;
    x[2,1] = 3;
    x[2,2] = 4;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="General_ArrayTest2",
			description="Test scalarization of variables",
			flatModel="
fclass ArrayTests.General.ArrayTest2
 constant Real x[1,1] = 1;
 constant Real x[1,2] = 2;
 constant Real x[2,1] = 3;
 constant Real x[2,2] = 4;
end ArrayTests.General.ArrayTest2;
")})));
  end ArrayTest2;

  model ArrayTest3

    Real x[:] = {2,3};
    Real y[2];
  equation
    y[1] = x[1];
    y[2] = x[2];
  end ArrayTest3;

  model ArrayTest4



    model M
      Real x[2];
    end M;
    M m[2];
  equation
    m[1].x[1] = 1;
    m[1].x[2] = 2;
    m[2].x[1] = 3;
    m[2].x[2] = 4;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="General_ArrayTest4",
			description="Test scalarization of variables",
			flatModel="
fclass ArrayTests.General.ArrayTest4
 constant Real m[1].x[1] = 1;
 constant Real m[1].x[2] = 2;
 constant Real m[2].x[1] = 3;
 constant Real m[2].x[2] = 4;
end ArrayTests.General.ArrayTest4;
")})));
  end ArrayTest4;

  model ArrayTest5
    model M
      Real x[3] = {-1,-2,-3};
    end M;
    M m[2](x={{1,2,3},{4,5,6}});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="General_ArrayTest5",
			description="Test scalarization of variables",
			flatModel="
fclass ArrayTests.General.ArrayTest5
 constant Real m[1].x[1] = 1;
 constant Real m[1].x[2] = 2;
 constant Real m[1].x[3] = 3;
 constant Real m[2].x[1] = 4;
 constant Real m[2].x[2] = 5;
 constant Real m[2].x[3] = 6;
end ArrayTests.General.ArrayTest5;
")})));
  end ArrayTest5;

  model ArrayTest6
    model M
      Real x[3];
    end M;
    M m[2];
  equation
    m.x = {{1,2,3},{4,5,6}};

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="General_ArrayTest6",
			description="Test scalarization of variables",
			flatModel="
fclass ArrayTests.General.ArrayTest6
 constant Real m[1].x[1] = 1;
 constant Real m[1].x[2] = 2;
 constant Real m[1].x[3] = 3;
 constant Real m[2].x[1] = 4;
 constant Real m[2].x[2] = 5;
 constant Real m[2].x[3] = 6;
end ArrayTests.General.ArrayTest6;
")})));
  end ArrayTest6;

  model ArrayTest7
    Real x[3];
  equation
    x[1:2] = {1,2};
    x[3] = 3;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="General_ArrayTest7",
			description="Test scalarization of variables",
			flatModel="
fclass ArrayTests.General.ArrayTest7
 constant Real x[1] = 1;
 constant Real x[2] = 2;
 constant Real x[3] = 3;
end ArrayTests.General.ArrayTest7;
")})));
  end ArrayTest7;

  model ArrayTest8
    model M
      parameter Integer n = 3;
      Real x[n] = ones(n);
    end M;
      M m[2](n={1,2});

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ArrayTest8",
			description="Test flattening of variables with sizes given in modifications",
			flatModel="
fclass ArrayTests.General.ArrayTest8
 structural parameter Integer m[1].n = 1 /* 1 */;
 Real m[1].x[1] = ones(1);
 structural parameter Integer m[2].n = 2 /* 2 */;
 Real m[2].x[2] = ones(2);

end ArrayTests.General.ArrayTest8;
")})));
  end ArrayTest8;

      model ArrayTest9
        model M
              parameter Integer n1 = 2;
              Real x[n1] = ones(n1);
        end M;

        model N
              parameter Integer n2 = 2;
              M m[n2,n2+1];
        end N;
	    N nn;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="General_ArrayTest9",
			description="Test scalarization of variables",
			flatModel="
fclass ArrayTests.General.ArrayTest9
 structural parameter Integer nn.n2 = 2 /* 2 */;
 structural parameter Integer nn.m[1,1].n1 = 2 /* 2 */;
 constant Real nn.m[1,1].x[1] = 1;
 constant Real nn.m[1,1].x[2] = 1;
 structural parameter Integer nn.m[1,2].n1 = 2 /* 2 */;
 constant Real nn.m[1,2].x[1] = 1;
 constant Real nn.m[1,2].x[2] = 1;
 structural parameter Integer nn.m[1,3].n1 = 2 /* 2 */;
 constant Real nn.m[1,3].x[1] = 1;
 constant Real nn.m[1,3].x[2] = 1;
 structural parameter Integer nn.m[2,1].n1 = 2 /* 2 */;
 constant Real nn.m[2,1].x[1] = 1;
 constant Real nn.m[2,1].x[2] = 1;
 structural parameter Integer nn.m[2,2].n1 = 2 /* 2 */;
 constant Real nn.m[2,2].x[1] = 1;
 constant Real nn.m[2,2].x[2] = 1;
 structural parameter Integer nn.m[2,3].n1 = 2 /* 2 */;
 constant Real nn.m[2,3].x[1] = 1;
 constant Real nn.m[2,3].x[2] = 1;
end ArrayTests.General.ArrayTest9;
")})));
      end ArrayTest9;

      model ArrayTest95
        model M
              parameter Integer n1 = 3;
              Real x = n1;
        end M;

        model N
              parameter Integer n2 = 2;
              M m;
        end N;
        N n[2](m(n1={3,4}));

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayTest95",
			description="Test scalarization of variables",
			flatModel="
fclass ArrayTests.General.ArrayTest95
 parameter Integer n[1].n2 = 2 /* 2 */;
 parameter Integer n[1].m.n1 = 3 /* 3 */;
 parameter Real n[1].m.x;
 parameter Integer n[2].n2 = 2 /* 2 */;
 parameter Integer n[2].m.n1 = 4 /* 4 */;
 parameter Real n[2].m.x;
parameter equation
 n[1].m.x = n[1].m.n1;
 n[2].m.x = n[2].m.n1;
end ArrayTests.General.ArrayTest95;
")})));
      end ArrayTest95;


   model ArrayTest10
    parameter Integer n;
    Real x[n];

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayTest10",
			description="Test scalarization of variables",
			flatModel="
fclass ArrayTests.General.ArrayTest10
 structural parameter Integer n = 0 /* 0 */;
end ArrayTests.General.ArrayTest10;
")})));
   end ArrayTest10;

   model ArrayTest11
    model M
      Real x[2];
    end M;
      M m1[2];
      M m2[3];
   equation
      m1[:].x[:] = {{1,2},{3,4}};
      m2[1:2].x[:] = {{1,2},{3,4}};
      m2[3].x[:] = {1,2};

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="General_ArrayTest11",
			description="Test scalarization of variables",
			flatModel="
fclass ArrayTests.General.ArrayTest11
 constant Real m1[1].x[1] = 1;
 constant Real m1[1].x[2] = 2;
 constant Real m1[2].x[1] = 3;
 constant Real m1[2].x[2] = 4;
 constant Real m2[1].x[1] = 1;
 constant Real m2[1].x[2] = 2;
 constant Real m2[2].x[1] = 3;
 constant Real m2[2].x[2] = 4;
 constant Real m2[3].x[1] = 1;
 constant Real m2[3].x[2] = 2;
end ArrayTests.General.ArrayTest11;
")})));
   end ArrayTest11;

      model ArrayTest12
        model M
              Real x[2];
        end M;

        model N
              M m[3];
        end N;
        N n[1];
      equation
        n.m.x={{{1,2},{3,4},{5,6}}};


	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="General_ArrayTest12",
			description="Test scalarization of variables",
			flatModel="
fclass ArrayTests.General.ArrayTest12
 constant Real n[1].m[1].x[1] = 1;
 constant Real n[1].m[1].x[2] = 2;
 constant Real n[1].m[2].x[1] = 3;
 constant Real n[1].m[2].x[2] = 4;
 constant Real n[1].m[3].x[1] = 5;
 constant Real n[1].m[3].x[2] = 6;
end ArrayTests.General.ArrayTest12;
")})));
      end ArrayTest12;

  model ArrayTest13
    model C
      parameter Integer n = 2;
    end C;
    C c;
    C cv[c.n];

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayTest13",
			description="Test scalarization of variables",
			flatModel="
fclass ArrayTests.General.ArrayTest13
 structural parameter Integer c.n = 2 /* 2 */;
 parameter Integer cv[1].n = 2 /* 2 */;
 parameter Integer cv[2].n = 2 /* 2 */;

end ArrayTests.General.ArrayTest13;
")})));
  end ArrayTest13;

      model ArrayTest14
        model M
              Real x[1] = ones(1);
        end M;

        model N
              M m[3,2];
        end N;
        N n;
      equation


	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="General_ArrayTest14",
			description="Test scalarization of variables",
			flatModel="
fclass ArrayTests.General.ArrayTest14
 constant Real n.m[1,1].x[1] = 1;
 constant Real n.m[1,2].x[1] = 1;
 constant Real n.m[2,1].x[1] = 1;
 constant Real n.m[2,2].x[1] = 1;
 constant Real n.m[3,1].x[1] = 1;
 constant Real n.m[3,2].x[1] = 1;
end ArrayTests.General.ArrayTest14;
")})));
      end ArrayTest14;

model ArrayTest15_Err
   Real x[3] = {{2},{2},{3}};

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayTest15_Err",
			description="Test type checking of arrays",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 251, column 9:
  Array size mismatch in declaration of x, size of declaration is [3] and size of binding expression is [3, 1]
")})));
end ArrayTest15_Err;

  model ArrayTest16
    model M
      Real x[2,1,1,1];
    end M;
    M m[2,1,2];
  equation
    m[1].x[1] = 1;
    m[1].x[2] = 2;
    m[2].x[1] = 3;
    m[2].x[2] = 4;
  end ArrayTest16;

model ArrayTest17
  model N
    model M
      Real x[2];
	equation
	  x[2] = 1;
    end M;
    M m[2,1];
  end N;
  N n[2];
  equation
//  n.m.x=1;
  n.m.x[1]={{{1},{2}},{{3},{4}}};


	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="General_ArrayTest17",
			description="Test scalarization of variables",
			automatic_add_initial_equations=false,
			flatModel="
fclass ArrayTests.General.ArrayTest17
 constant Real n[1].m[1,1].x[1] = 1;
 constant Real n[1].m[1,1].x[2] = 1;
 constant Real n[1].m[2,1].x[1] = 2;
 constant Real n[1].m[2,1].x[2] = 1;
 constant Real n[2].m[1,1].x[1] = 3;
 constant Real n[2].m[1,1].x[2] = 1;
 constant Real n[2].m[2,1].x[1] = 4;
 constant Real n[2].m[2,1].x[2] = 1;
end ArrayTests.General.ArrayTest17;
")})));
end ArrayTest17;

model ArrayTest21
  Real x[2];
  Real y[2];
equation
  x=y;
  x=zeros(2);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="General_ArrayTest21",
			description="Flattening of arrays.",
			flatModel="
fclass ArrayTests.General.ArrayTest21
 constant Real x[1] = 0;
 constant Real x[2] = 0;
 constant Real y[1] = 0;
 constant Real y[2] = 0;
end ArrayTests.General.ArrayTest21;
")})));
end ArrayTest21;

model ArrayTest22
  Real x[2];
  Real y[2];
equation
  x=y;
  x=ones(2);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="General_ArrayTest22",
			description="Flattening of arrays.",
			flatModel="
fclass ArrayTests.General.ArrayTest22
 constant Real x[1] = 1;
 constant Real x[2] = 1;
 constant Real y[1] = 1;
 constant Real y[2] = 1;
end ArrayTests.General.ArrayTest22;
			
")})));
end ArrayTest22;

model ArrayTest23
  Real x[2,2];
  Real y[2,2];
equation
  x=y;
  x=ones(2,2);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="General_ArrayTest23",
			description="Flattening of arrays.",
			flatModel="
fclass ArrayTests.General.ArrayTest23
 constant Real x[1,1] = 1;
 constant Real x[1,2] = 1;
 constant Real x[2,1] = 1;
 constant Real x[2,2] = 1;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 1;
 constant Real y[2,1] = 1;
 constant Real y[2,2] = 1;
end ArrayTests.General.ArrayTest23;
			
")})));
end ArrayTest23;

model ArrayTest24

  Real x[2,2];
  Real y[2,2];
equation
  for i in 1:2, j in 1:2 loop
    x[i,j] = i;
    y[i,j] = x[i,j]+j;
  end for;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="General_ArrayTest24",
			description="Flattening of arrays.",
			flatModel="
fclass ArrayTests.General.ArrayTest24
 constant Real x[1,1] = 1;
 constant Real x[1,2] = 1;
 constant Real x[2,1] = 2;
 constant Real x[2,2] = 2;
 constant Real y[1,1] = 2.0;
 constant Real y[1,2] = 3.0;
 constant Real y[2,1] = 3.0;
 constant Real y[2,2] = 4.0;
end ArrayTests.General.ArrayTest24;
")})));
end ArrayTest24;

model ArrayTest25

  Real x[2,3];
  Real y[2,3];
equation
  for i in 1:2 loop
   for j in 1:3 loop
    x[i,j] = i;
    y[i,j] = x[i,j]+j;
   end for;
  end for;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="General_ArrayTest25",
			description="Flattening of arrays.",
			flatModel="
fclass ArrayTests.General.ArrayTest25
 constant Real x[1,1] = 1;
 constant Real x[1,2] = 1;
 constant Real x[1,3] = 1;
 constant Real x[2,1] = 2;
 constant Real x[2,2] = 2;
 constant Real x[2,3] = 2;
 constant Real y[1,1] = 2.0;
 constant Real y[1,2] = 3.0;
 constant Real y[1,3] = 4.0;
 constant Real y[2,1] = 3.0;
 constant Real y[2,2] = 4.0;
 constant Real y[2,3] = 5.0;
end ArrayTests.General.ArrayTest25;
")})));
end ArrayTest25;


model ArrayTest26

  Real x[4,4];
  Real y[4,4];
equation
  for i in 2:2:4 loop
   for j in 2:2:4 loop
    x[i,j] = i;
    y[i,j] = x[i,j]+j;
   end for;
  end for;
  for i in 1:2:4 loop
   for j in 1:2:4 loop
    x[i,j] = i+2;
    y[i,j] = x[i,j]+j+2;
   end for;
  end for;
  for i in 3:-2:1 loop
   for j in 1:2:4 loop
    x[i,j] = i+2;
    y[i,j] = x[i,j]+j+2;
   end for;
  end for;
  for i in 2:2:4 loop
   for j in 3:-2:1 loop
    x[i,j] = i+2;
    y[i,j] = x[i,j]+j+2;
   end for;
  end for;


	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="General_ArrayTest26",
			description="Flattening of arrays.",
			automatic_add_initial_equations=false,
			enable_structural_diagnosis=false,
			flatModel="
fclass ArrayTests.General.ArrayTest26
 constant Real x[1,1] = 3;
 Real x[1,2];
 constant Real x[1,3] = 3;
 Real x[1,4];
 constant Real x[2,1] = 4;
 constant Real x[2,2] = 2;
 constant Real x[2,3] = 4;
 constant Real x[2,4] = 2;
 constant Real x[3,1] = 5;
 Real x[3,2];
 constant Real x[3,3] = 5;
 Real x[3,4];
 constant Real x[4,1] = 6;
 constant Real x[4,2] = 4;
 constant Real x[4,3] = 6;
 constant Real x[4,4] = 4;
 constant Real y[1,1] = 6.0;
 Real y[1,2];
 constant Real y[1,3] = 8.0;
 Real y[1,4];
 constant Real y[2,1] = 7.0;
 constant Real y[2,2] = 4.0;
 constant Real y[2,3] = 9.0;
 constant Real y[2,4] = 6.0;
 constant Real y[3,1] = 8.0;
 Real y[3,2];
 constant Real y[3,3] = 10.0;
 Real y[3,4];
 constant Real y[4,1] = 9.0;
 constant Real y[4,2] = 6.0;
 constant Real y[4,3] = 11.0;
 constant Real y[4,4] = 8.0;
equation
 5.0 = 5;
 8.0 = 8.0;
 5.0 = 5;
 10.0 = 10.0;
 3.0 = 3;
 6.0 = 6.0;
 3.0 = 3;
 8.0 = 8.0;
end ArrayTests.General.ArrayTest26;
")})));
end ArrayTest26;


model ArrayTest27_Err
   Real x[3](start={1,2});
equation
   der(x) = ones(3);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayTest27_Err",
			description="Test type checking of arrays",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 592, column 13:
  Array size mismatch for the attribute start, size of declaration is [3] and size of start expression is [2]
")})));
end ArrayTest27_Err;


model ArrayTest29
   Real x[3](start={1,2,3});
equation
   der(x) = ones(3);


	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayTest29",
			description="Flattening of arrays.",
			flatModel="
fclass ArrayTests.General.ArrayTest29
 Real x[1](start = 1);
 Real x[2](start = 2);
 Real x[3](start = 3);
initial equation 
 x[1] = 1;
 x[2] = 2;
 x[3] = 3;
equation
 der(x[1]) = 1;
 der(x[2]) = 1;
 der(x[3]) = 1;
end ArrayTests.General.ArrayTest29;
")})));
end ArrayTest29;

model ArrayTest30

   Real x[3,2](start={{1,2},{3,4},{5,6}});
equation
   der(x) = {{-1,-2},{-3,-4},{-5,-6}};


	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayTest30",
			description="Flattening of arrays.",
			flatModel="
fclass ArrayTests.General.ArrayTest30
 Real x[1,1](start = 1);
 Real x[1,2](start = 2);
 Real x[2,1](start = 3);
 Real x[2,2](start = 4);
 Real x[3,1](start = 5);
 Real x[3,2](start = 6);
initial equation 
 x[1,1] = 1;
 x[1,2] = 2;
 x[2,1] = 3;
 x[2,2] = 4;
 x[3,1] = 5;
 x[3,2] = 6;
equation
 der(x[1,1]) = - 1;
 der(x[1,2]) = - 2;
 der(x[2,1]) = - 3;
 der(x[2,2]) = - 4;
 der(x[3,1]) = - 5;
 der(x[3,2]) = - 6;
end ArrayTests.General.ArrayTest30;
")})));
end ArrayTest30;

model ArrayTest31
  Real x[2];
equation
 x = {sin(time),cos(time)};

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayTest31",
			description="Flattening of arrays.",
			flatModel="
fclass ArrayTests.General.ArrayTest31
 Real x[1];
 Real x[2];
equation
 x[1] = sin(time);
 x[2] = cos(time);
end ArrayTests.General.ArrayTest31;
")})));
end ArrayTest31;

model ArrayTest32
 Real x[2];
initial equation
 x = {1,-2};
equation
 der(x) = -x;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayTest32",
			description="Scalarization of initial equation",
			flatModel="
fclass ArrayTests.General.ArrayTest32
 Real x[1];
 Real x[2];
initial equation 
 x[1] = 1;
 x[2] = - 2;
equation
 der(x[1]) = - x[1];
 der(x[2]) = - x[2];
end ArrayTests.General.ArrayTest32;
")})));
end ArrayTest32;


model ArrayTest33
  model C
	Real x;
  equation
    x = 1;
  end C;
  
  C c[3];

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ArrayTest33",
			description="Equations in array components",
			flatModel="
fclass ArrayTests.General.ArrayTest33
 Real c[1].x;
 Real c[2].x;
 Real c[3].x;
equation
 c[1].x = 1;
 c[2].x = 1;
 c[3].x = 1;

end ArrayTests.General.ArrayTest33;
")})));
end ArrayTest33;


model ArrayTest34
  model A
    B b[2];
  end A;
  
  model B
    Real x;
    C c[2];
  equation
    x = c[1].x;
  end B;
  
  model C
	Real x;
  equation
    x = 1;
  end C;
  
  A a[2];

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ArrayTest34",
			description="Equations in array components",
			flatModel="
fclass ArrayTests.General.ArrayTest34
 Real a[1].b[1].x;
 Real a[1].b[1].c[1].x;
 Real a[1].b[1].c[2].x;
 Real a[1].b[2].x;
 Real a[1].b[2].c[1].x;
 Real a[1].b[2].c[2].x;
 Real a[2].b[1].x;
 Real a[2].b[1].c[1].x;
 Real a[2].b[1].c[2].x;
 Real a[2].b[2].x;
 Real a[2].b[2].c[1].x;
 Real a[2].b[2].c[2].x;
equation
 a[1].b[1].x = a[1].b[1].c[1].x;
 a[1].b[1].c[1].x = 1;
 a[1].b[1].c[2].x = 1;
 a[1].b[2].x = a[1].b[2].c[1].x;
 a[1].b[2].c[1].x = 1;
 a[1].b[2].c[2].x = 1;
 a[2].b[1].x = a[2].b[1].c[1].x;
 a[2].b[1].c[1].x = 1;
 a[2].b[1].c[2].x = 1;
 a[2].b[2].x = a[2].b[2].c[1].x;
 a[2].b[2].c[1].x = 1;
 a[2].b[2].c[2].x = 1;

end ArrayTests.General.ArrayTest34;
")})));
end ArrayTest34;


model ArrayTest35
	function f
		input Real[:] x;
		output Real[2 * size(x, 1) + 1] y = cat(1, x, zeros(size(x, 1) + 1));
	algorithm
	end f;
	
	Real[5] z = f({1,2});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="General_ArrayTest35",
			description="Test adding array sizes that are present as expressions in tree",
			flatModel="
fclass ArrayTests.General.ArrayTest35
 constant Real z[1] = 1;
 constant Real z[2] = 2;
 constant Real z[3] = 0;
 constant Real z[4] = 0;
 constant Real z[5] = 0;
end ArrayTests.General.ArrayTest35;
")})));
end ArrayTest35;


model ArrayTest36
	model A
		Real x = b;
		parameter Real b = 1;
	end A;
	
	A[3] c(b = { j*j for j in 1:3 });

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="General_ArrayTest36",
			description="",
			flatModel="
fclass ArrayTests.General.ArrayTest36
 parameter Real c[1].x;
 parameter Real c[1].b = 1 /* 1 */;
 parameter Real c[2].x;
 parameter Real c[2].b = 4 /* 4 */;
 parameter Real c[3].x;
 parameter Real c[3].b = 9 /* 9 */;
parameter equation
 c[1].x = c[1].b;
 c[2].x = c[2].b;
 c[3].x = c[3].b;
end ArrayTests.General.ArrayTest36;
			
")})));
end ArrayTest36;


model ArrayTest37
    package A
        constant Integer n = 2;
        type B = Real[n];
    end A;
    
    A.B x = 1:A.n;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="General_ArrayTest37",
			description="",
			flatModel="
fclass ArrayTests.General.ArrayTest37
 ArrayTests.General.ArrayTest37.A.B x[2] = 1:2;

public
 type ArrayTests.General.ArrayTest37.A.B = Real;
end ArrayTests.General.ArrayTest37;
")})));
end ArrayTest37;


model ArrayTest38
    model A
        Real x;
    end A;
    
    parameter Integer n = 0;
    A[n] a(x = ones(n));

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="General_ArrayTest38",
			description="Modification on variable in zero-size component array",
			flatModel="
fclass ArrayTests.General.ArrayTest38
 structural parameter Integer n = 0 /* 0 */;
end ArrayTests.General.ArrayTest38;
")})));
end ArrayTest38;

model ArrayTest39
    function f
        input Integer n;
        input Real t;
        output Real[n] o;
      algorithm
        o := {t for i in 1:n};
    end f;

    parameter Integer n = 0;
    parameter Real[n] y;
    parameter Real p = 1;
    parameter Real[n] a;
  initial equation
    y = f(n, p);
    a = y;
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="General_ArrayTest39",
            description="Initial equation for size zero array",
            flatModel="
fclass ArrayTests.General.ArrayTest39
 structural parameter Integer n = 0 /* 0 */;
 parameter Real p = 1 /* 1 */;
end ArrayTests.General.ArrayTest39;
")})));
end ArrayTest39;

model ArrayTest40
    function f
        input Integer n;
        input Real t;
        output Real[n] o;
      algorithm
        o := {t for i in 1:n};
    end f;

    parameter Integer n = 0;
    parameter Real[n] y(start=f(n, p));
    parameter Real p = 1;
    parameter Real[n] a = y;
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="General_ArrayTest40",
            description="Start value for size zero array",
            flatModel="
fclass ArrayTests.General.ArrayTest40
 structural parameter Integer n = 0 /* 0 */;
 parameter Real p = 1 /* 1 */;
end ArrayTests.General.ArrayTest40;
")})));
end ArrayTest40;

end General;


package UnknownSize

model UnknownSize1
 Real x[:,:] = {{1,2},{3,4}};

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownSize_UnknownSize1",
			description="Using unknown array sizes: deciding with binding exp",
			flatModel="
fclass ArrayTests.UnknownSize.UnknownSize1
 constant Real x[1,1] = 1;
 constant Real x[1,2] = 2;
 constant Real x[2,1] = 3;
 constant Real x[2,2] = 4;
end ArrayTests.UnknownSize.UnknownSize1;
")})));
end UnknownSize1;


model UnknownSize2
 model A
  Real z[:] = {1};
 end A;
 
 model B
  A y[2](z={{1,2},{3,4}});
 end B;
 
 B x[2];

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownSize_UnknownSize2",
			description="Using unknown array sizes: binding exp through modification on array",
			flatModel="
fclass ArrayTests.UnknownSize.UnknownSize2
 constant Real x[1].y[1].z[1] = 1;
 constant Real x[1].y[1].z[2] = 2;
 constant Real x[1].y[2].z[1] = 3;
 constant Real x[1].y[2].z[2] = 4;
 constant Real x[2].y[1].z[1] = 1;
 constant Real x[2].y[1].z[2] = 2;
 constant Real x[2].y[2].z[1] = 3;
 constant Real x[2].y[2].z[2] = 4;
end ArrayTests.UnknownSize.UnknownSize2;
")})));
end UnknownSize2;


model UnknownSize3
 Real x[1,:] = {{1,2}};

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="UnknownSize_UnknownSize3",
			description="Using unknown array sizes: one dim known, one unknown",
			flatModel="
fclass ArrayTests.UnknownSize.UnknownSize3
 constant Real x[1,1] = 1;
 constant Real x[1,2] = 2;
end ArrayTests.UnknownSize.UnknownSize3;
")})));
end UnknownSize3;


model UnknownSize4
 Real x[1,:] = {1,2};

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="UnknownSize4",
			description="Using unknown array sizes: too few dims",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 789, column 7:
  Can not infer array size of the variable x
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 789, column 7:
  Array size mismatch in declaration of x, size of declaration is [1, :] and size of binding expression is [2]
")})));
end UnknownSize4;


model UnknownSize5
 Real x[1,:] = {{1,2},{3,4}};

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="UnknownSize5",
			description="Using unknown array sizes: one dim specified and does not match",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 805, column 7:
  Array size mismatch in declaration of x, size of declaration is [1, 2] and size of binding expression is [2, 2]
")})));
end UnknownSize5;


model UnknownSize6
 Real x[:,:];
equation
 x = {{1,2},{3,4}};

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="UnknownSize6",
			description="Using unknown array sizes:",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 821, column 7:
  Can not infer array size of the variable x
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 823, column 2:
  The array sizes of right and left hand side of equation are not compatible
")})));
end UnknownSize6;

end UnknownSize;


package Subscripts
	
model SubscriptExpression1
 Real x[4];
equation
 x[1] = 1;
 for i in 2:4 loop
  x[i] = x[i-1] * 2;
 end for;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Subscripts_SubscriptExpression1",
			description="Replacing expressions in array subscripts with literals: basic test",
			flatModel="
fclass ArrayTests.Subscripts.SubscriptExpression1
 constant Real x[1] = 1;
 constant Real x[2] = 2.0;
 constant Real x[3] = 4.0;
 constant Real x[4] = 8.0;
end ArrayTests.Subscripts.SubscriptExpression1;
")})));
end SubscriptExpression1;


model SubscriptExpression2
 Real x[4];
equation
 x[0] = 1;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="SubscriptExpression2",
			description="Type checking array subscripts: literal < 1",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 737, column 4:
  Array index out of bounds: 0, index expression: 0
")})));
end SubscriptExpression2;


model SubscriptExpression3
 Real x[4];
equation
 x[5] = 1;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="SubscriptExpression3",
			description="Type checking array subscripts: literal > end",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 754, column 4:
  Array index out of bounds: 5, index expression: 5
")})));
end SubscriptExpression3;


model SubscriptExpression4
 Real x[4];
equation
 for i in 1:4 loop
  x[i] = x[i-1] * 2;
 end for;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="SubscriptExpression4",
			description="Type checking array subscripts: expression < 1",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 1307, column 12:
  Array index out of bounds: 0, index expression: i - 1
")})));
end SubscriptExpression4;


model SubscriptExpression5
 Real x[4];
equation
 for i in 1:4 loop
  x[i] = x[i+1] * 2;
 end for;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="SubscriptExpression5",
			description="Type checking array subscripts: expression > end",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 769, column 12:
  Array index out of bounds: 5, index expression: i + 1
")})));
end SubscriptExpression5;


model SubscriptExpression6
 Real x[16];
equation
 for i in 1:4, j in 1:4 loop
  x[4*(i-1) + j] = i + j * 2;
 end for;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Subscripts_SubscriptExpression6",
			description="Type checking array subscripts: simulating [4,4] with [16]",
			flatModel="
fclass ArrayTests.Subscripts.SubscriptExpression6
 constant Real x[1] = 3;
 constant Real x[2] = 5;
 constant Real x[3] = 7;
 constant Real x[4] = 9;
 constant Real x[5] = 4;
 constant Real x[6] = 6;
 constant Real x[7] = 8;
 constant Real x[8] = 10;
 constant Real x[9] = 5;
 constant Real x[10] = 7;
 constant Real x[11] = 9;
 constant Real x[12] = 11;
 constant Real x[13] = 6;
 constant Real x[14] = 8;
 constant Real x[15] = 10;
 constant Real x[16] = 12;
end ArrayTests.Subscripts.SubscriptExpression6;
")})));
end SubscriptExpression6;


model SubscriptExpression7
 Real x[4,4];
equation
 for i in 1:4, j in 1:4 loop
  x[i, j + i - min(i, j)] = i + j * 2;
 end for;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Subscripts_SubscriptExpression7",
			description="Type checking array subscripts: using min in subscripts",
			automatic_add_initial_equations=false,
			enable_structural_diagnosis=false,
			flatModel="
fclass ArrayTests.Subscripts.SubscriptExpression7
 constant Real x[1,1] = 3;
 constant Real x[1,2] = 5;
 constant Real x[1,3] = 7;
 constant Real x[1,4] = 9;
 Real x[2,1];
 constant Real x[2,2] = 4;
 constant Real x[2,3] = 8;
 constant Real x[2,4] = 10;
 Real x[3,1];
 Real x[3,2];
 constant Real x[3,3] = 5;
 constant Real x[3,4] = 11;
 Real x[4,1];
 Real x[4,2];
 Real x[4,3];
 constant Real x[4,4] = 6;
equation
 4.0 = 6;
 5.0 = 7;
 5.0 = 9;
 6.0 = 8;
 6.0 = 10;
 6.0 = 12;
end ArrayTests.Subscripts.SubscriptExpression7;
")})));
end SubscriptExpression7;


model SubscriptExpression8
 Real x[4];
equation
 for i in 1:4, j in 1:4 loop
  x[i + j * max(i*(1:4))] = i + j * 2;
 end for;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="SubscriptExpression8",
			description="Type checking array subscripts: complex expression, several bad indices",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 1451, column 5:
  Array index out of bounds: 5, index expression: i + j * max(i * (1:4))
")})));
end SubscriptExpression8;


model SubscriptExpression9
    connector C = Real;
    C x[3], y;
equation
    for i in 1:3 loop
        if i < 3 then
            connect(x[i], x[i+1]);
        else
            connect(x[i], y);
        end if;
    end for;

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="Subscripts_SubscriptExpression9",
            description="",
            flatModel="
fclass ArrayTests.Subscripts.SubscriptExpression9
 Real x[3];
 Real y;
equation
 x[1] = x[2];
 x[2] = x[3];
 x[3] = y;
end ArrayTests.Subscripts.SubscriptExpression9;
")})));
end SubscriptExpression9;



model NumSubscripts1
 Real x = 1;
 Real y = x[1];

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="NumSubscripts1",
			description="Check number of array subscripts:",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 1928, column 12:
  Too many array subscripts for access: 1 subscripts given, component has 0 dimensions
")})));
end NumSubscripts1;


model NumSubscripts2
 Real x[1,1] = {{1}};
 Real y = x[1,1,1];

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="NumSubscripts2",
			description="Check number of array subscripts:",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 1945, column 12:
  Too many array subscripts for access: 3 subscripts given, component has 2 dimensions
")})));
end NumSubscripts2;

model Enum1
    type ShirtSizes = enumeration(small, medium, large, xlarge);
    Real[ShirtSizes] w;
  equation
    w[ShirtSizes.small:ShirtSizes.large] = {1,1.5,2};
  algorithm
    w[ShirtSizes.xlarge] := 2.28;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="Subscripts_Enum1",
            description="Test subscripting with enums.",
            flatModel="
fclass ArrayTests.Subscripts.Enum1
 constant Real w[1] = 1;
 constant Real w[2] = 1.5;
 constant Real w[3] = 2;
 Real w[4];
algorithm
 w[4] := 2.28;

public
 type ArrayTests.Subscripts.Enum1.ShirtSizes = enumeration(small, medium, large, xlarge);

end ArrayTests.Subscripts.Enum1;
")})));
end Enum1;

model Enum2
    type ShirtSizes = enumeration(small, medium, large, xlarge);
    type ShirtSizesAnotherStandard = enumeration(small1, medium2, large3, xlarge4);
    Real[ShirtSizes] w;
    Real[1] v;
  equation
    w[ShirtSizes.small:ShirtSizes.large] = {1,1.5,2};
    w[4] = 2.28;
    v[ShirtSizes.medium] = 1;
    w[ShirtSizesAnotherStandard.small1] = 1;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Subscripts_Enum2",
            description="Check incompatible type index errors for enum.",
            errorMessage="
3 errors found:
Error: in file '...':
Semantic error at line 1422, column 7:
  Expected array index of type 'ArrayTests.Subscripts.Enum2.ShirtSizes' found 'Integer'
Error: in file '...':
Semantic error at line 1423, column 7:
  Expected array index of type 'Integer' found 'ArrayTests.Subscripts.Enum2.ShirtSizes'
Error: in file '...':
Semantic error at line 1424, column 7:
  Expected array index of type 'ArrayTests.Subscripts.Enum2.ShirtSizes' found 'ArrayTests.Subscripts.Enum2.ShirtSizesAnotherStandard'
")})));
end Enum2;

model Bool1
    Real[Boolean] b2;
  equation
    b2[false] = 5;
  algorithm
    b2[true] := 10.0;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="Subscripts_Bool1",
            description="Test subscripting with bools.",
            flatModel="
fclass ArrayTests.Subscripts.Bool1
 constant Real b2[1] = 5;
 Real b2[2];
algorithm
 b2[2] := 10.0;
end ArrayTests.Subscripts.Bool1;
")})));
end Bool1;

model Bool2
    Real[Boolean] b2;
    Real[1] b3;
  equation
    b2[false] = 5;
    b2[2] = 10.0;
    b3[true] = 1;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Subscripts_Bool2",
            description="Check incompatible type index errors for bool.",
            errorMessage="
2 errors found:
Error: in file '...':
Semantic error at line 1466, column 8:
  Expected array index of type 'Boolean' found 'Integer'
Error: in file '...':
Semantic error at line 1467, column 8:
  Expected array index of type 'Integer' found 'Boolean'
")})));
end Bool2;

model MixedTypes1
    
    type ShirtSizes  = enumeration(small);
    type ShirtColors = enumeration(blue, yellow);
    type SlimFit = Boolean;
    parameter Integer maxQuality = 1;
    
    Integer[ShirtSizes, maxQuality, ShirtColors, SlimFit] stock;
  equation
    stock[ShirtSizes.small, 1, ShirtColors.blue:ShirtColors.yellow, false] = {1,2};
    stock[ShirtSizes.small, 1, ShirtColors.blue:ShirtColors.yellow, true]  = {0,0};
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="Subscripts_MixedTypes1",
            description="Test subscripting with bools.",
            flatModel="
fclass ArrayTests.Subscripts.MixedTypes1
 structural parameter Integer maxQuality = 1 /* 1 */;
 constant Integer stock[1,1,1,1] = 1;
 constant Integer stock[1,1,1,2] = 0;
 constant Integer stock[1,1,2,1] = 2;
 constant Integer stock[1,1,2,2] = 0;
public
 type ArrayTests.Subscripts.MixedTypes1.ShirtSizes = enumeration(small);
 type ArrayTests.Subscripts.MixedTypes1.ShirtColors = enumeration(blue, yellow);
end ArrayTests.Subscripts.MixedTypes1;
")})));
    
end MixedTypes1;
    
end Subscripts;



/* ========== Array algebra ========== */
package Algebra

package Add
	
model ArrayAdd1
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y + { 10, 20 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Add_ArrayAdd1",
			description="Scalarization of addition: Real[2] + Integer[2]",
			flatModel="
fclass ArrayTests.Algebra.Add.ArrayAdd1
 constant Real x[1] = 11.0;
 constant Real x[2] = 22.0;
 constant Real y[1] = 1;
 constant Real y[2] = 2;
end ArrayTests.Algebra.Add.ArrayAdd1;
")})));
end ArrayAdd1;


model ArrayAdd2
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y + { { 10, 20 }, { 30, 40 } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Add_ArrayAdd2",
			description="Scalarization of addition: Real[2,2] + Integer[2,2]",
			flatModel="
fclass ArrayTests.Algebra.Add.ArrayAdd2
 constant Real x[1,1] = 11.0;
 constant Real x[1,2] = 22.0;
 constant Real x[2,1] = 33.0;
 constant Real x[2,2] = 44.0;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Add.ArrayAdd2;
")})));
end ArrayAdd2;


model ArrayAdd3
 Real x[2,2,2];
 Real y[2,2,2] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };
equation
 x = y + { { { 10, 20 }, { 30, 40 } }, { { 50, 60 }, { 70, 80 } } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Add_ArrayAdd3",
			description="Scalarization of addition: Real[2,2,2] + Integer[2,2,2]",
			flatModel="
fclass ArrayTests.Algebra.Add.ArrayAdd3
 constant Real x[1,1,1] = 11.0;
 constant Real x[1,1,2] = 22.0;
 constant Real x[1,2,1] = 33.0;
 constant Real x[1,2,2] = 44.0;
 constant Real x[2,1,1] = 55.0;
 constant Real x[2,1,2] = 66.0;
 constant Real x[2,2,1] = 77.0;
 constant Real x[2,2,2] = 88.0;
 constant Real y[1,1,1] = 1;
 constant Real y[1,1,2] = 2;
 constant Real y[1,2,1] = 3;
 constant Real y[1,2,2] = 4;
 constant Real y[2,1,1] = 5;
 constant Real y[2,1,2] = 6;
 constant Real y[2,2,1] = 7;
 constant Real y[2,2,2] = 8;
end ArrayTests.Algebra.Add.ArrayAdd3;
")})));
end ArrayAdd3;


model ArrayAdd4
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y + 10;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Add_ArrayAdd4",
            description="Scalarization of addition: Real[2] + Integer",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 1653, column 6:
  Type error in expression: y + 10
    type of 'y' is Real[2]
    type of '10' is Integer
")})));
end ArrayAdd4;


model ArrayAdd5
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y + 10;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Add_ArrayAdd5",
            description="Scalarization of addition: Real[2,2] + Integer",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 1674, column 6:
  Type error in expression: y + 10
    type of 'y' is Real[2, 2]
    type of '10' is Integer
")})));
end ArrayAdd5;


model ArrayAdd6
 Real x[2,2,2];
 Real y[2,2,2] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };
equation
 x = y + 10;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Add_ArrayAdd6",
            description="Scalarization of addition: Real[2,2,2] + Integer",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 1695, column 6:
  Type error in expression: y + 10
    type of 'y' is Real[2, 2, 2]
    type of '10' is Integer
")})));
end ArrayAdd6;


model ArrayAdd7
 Real x[2];
 Real y = 1;
equation
 x = y + { 10, 20 };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Add_ArrayAdd7",
            description="Scalarization of addition: Real + Integer[2,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 1716, column 6:
  Type error in expression: y + {10, 20}
    type of 'y' is Real
    type of '{10, 20}' is Integer[2]
")})));
end ArrayAdd7;


model ArrayAdd8
 Real x[2,2];
 Real y = 1;
equation
 x = y + { { 10, 20 }, { 30, 40 } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Add_ArrayAdd8",
            description="Scalarization of addition: Real + Integer[2,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 1737, column 6:
  Type error in expression: y + {{10, 20}, {30, 40}}
    type of 'y' is Real
    type of '{{10, 20}, {30, 40}}' is Integer[2, 2]
")})));
end ArrayAdd8;


model ArrayAdd9
 Real x[2,2,2];
 Real y = 1;
equation
 x = y + { { { 10, 20 }, { 30, 40 } }, { { 50, 60 }, { 70, 80 } } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Add_ArrayAdd9",
            description="Scalarization of addition: Real + Integer[2,2,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 1758, column 6:
  Type error in expression: y + {{{10, 20}, {30, 40}}, {{50, 60}, {70, 80}}}
    type of 'y' is Real
    type of '{{{10, 20}, {30, 40}}, {{50, 60}, {70, 80}}}' is Integer[2, 2, 2]
")})));
end ArrayAdd9;


model ArrayAdd10
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y + { 10, 20, 30 };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Add_ArrayAdd10",
            description="Scalarization of addition: Real[2] + Integer[3]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 1779, column 6:
  Type error in expression: y + {10, 20, 30}
    type of 'y' is Real[2]
    type of '{10, 20, 30}' is Integer[3]
")})));
end ArrayAdd10;


model ArrayAdd11
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y + { { 10, 20 }, { 30, 40 } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Add_ArrayAdd11",
            description="Scalarization of addition: Real[2] + Integer[2,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 1800, column 6:
  Type error in expression: y + {{10, 20}, {30, 40}}
    type of 'y' is Real[2]
    type of '{{10, 20}, {30, 40}}' is Integer[2, 2]
")})));
end ArrayAdd11;


model ArrayAdd12
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y + { "1", "2" };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Add_ArrayAdd12",
            description="Scalarization of addition: Real[2] + String[2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 1821, column 6:
  Type error in expression: y + {\"1\", \"2\"}
    type of 'y' is Real[2]
    type of '{\"1\", \"2\"}' is String[2]
")})));
end ArrayAdd12;



model ArrayDotAdd1
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .+ { 10, 20 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Add_ArrayDotAdd1",
			description="Scalarization of element-wise addition: Real[2] .+ Integer[2]",
			flatModel="
fclass ArrayTests.Algebra.Add.ArrayDotAdd1
 constant Real x[1] = 11.0;
 constant Real x[2] = 22.0;
 constant Real y[1] = 1;
 constant Real y[2] = 2;
end ArrayTests.Algebra.Add.ArrayDotAdd1;
")})));
end ArrayDotAdd1;


model ArrayDotAdd2
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y .+ { { 10, 20 }, { 30, 40 } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Add_ArrayDotAdd2",
			description="Scalarization of element-wise addition: Real[2,2] .+ Integer[2,2]",
			flatModel="
fclass ArrayTests.Algebra.Add.ArrayDotAdd2
 constant Real x[1,1] = 11.0;
 constant Real x[1,2] = 22.0;
 constant Real x[2,1] = 33.0;
 constant Real x[2,2] = 44.0;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Add.ArrayDotAdd2;
")})));
end ArrayDotAdd2;


model ArrayDotAdd3
 Real x[2,2,2];
 Real y[2,2,2] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };
equation
 x = y .+ { { { 10, 20 }, { 30, 40 } }, { { 50, 60 }, { 70, 80 } } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Add_ArrayDotAdd3",
			description="Scalarization of element-wise addition: Real[2,2,2] .+ Integer[2,2,2]",
			flatModel="
fclass ArrayTests.Algebra.Add.ArrayDotAdd3
 constant Real x[1,1,1] = 11.0;
 constant Real x[1,1,2] = 22.0;
 constant Real x[1,2,1] = 33.0;
 constant Real x[1,2,2] = 44.0;
 constant Real x[2,1,1] = 55.0;
 constant Real x[2,1,2] = 66.0;
 constant Real x[2,2,1] = 77.0;
 constant Real x[2,2,2] = 88.0;
 constant Real y[1,1,1] = 1;
 constant Real y[1,1,2] = 2;
 constant Real y[1,2,1] = 3;
 constant Real y[1,2,2] = 4;
 constant Real y[2,1,1] = 5;
 constant Real y[2,1,2] = 6;
 constant Real y[2,2,1] = 7;
 constant Real y[2,2,2] = 8;
end ArrayTests.Algebra.Add.ArrayDotAdd3;
")})));
end ArrayDotAdd3;


model ArrayDotAdd4
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .+ 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Add_ArrayDotAdd4",
			description="Scalarization of element-wise addition: Real[2] .+ Integer",
			flatModel="
fclass ArrayTests.Algebra.Add.ArrayDotAdd4
 constant Real x[1] = 11.0;
 constant Real x[2] = 12.0;
 constant Real y[1] = 1;
 constant Real y[2] = 2;
end ArrayTests.Algebra.Add.ArrayDotAdd4;
")})));
end ArrayDotAdd4;


model ArrayDotAdd5
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y .+ 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Add_ArrayDotAdd5",
			description="Scalarization of element-wise addition: Real[2,2] .+ Integer",
			flatModel="
fclass ArrayTests.Algebra.Add.ArrayDotAdd5
 constant Real x[1,1] = 11.0;
 constant Real x[1,2] = 12.0;
 constant Real x[2,1] = 13.0;
 constant Real x[2,2] = 14.0;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Add.ArrayDotAdd5;
")})));
end ArrayDotAdd5;


model ArrayDotAdd6
 Real x[2,2,2];
 Real y[2,2,2] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };
equation
 x = y .+ 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Add_ArrayDotAdd6",
			description="Scalarization of element-wise addition: Real[2,2,2] .+ Integer",
			flatModel="
fclass ArrayTests.Algebra.Add.ArrayDotAdd6
 constant Real x[1,1,1] = 11.0;
 constant Real x[1,1,2] = 12.0;
 constant Real x[1,2,1] = 13.0;
 constant Real x[1,2,2] = 14.0;
 constant Real x[2,1,1] = 15.0;
 constant Real x[2,1,2] = 16.0;
 constant Real x[2,2,1] = 17.0;
 constant Real x[2,2,2] = 18.0;
 constant Real y[1,1,1] = 1;
 constant Real y[1,1,2] = 2;
 constant Real y[1,2,1] = 3;
 constant Real y[1,2,2] = 4;
 constant Real y[2,1,1] = 5;
 constant Real y[2,1,2] = 6;
 constant Real y[2,2,1] = 7;
 constant Real y[2,2,2] = 8;
end ArrayTests.Algebra.Add.ArrayDotAdd6;
")})));
end ArrayDotAdd6;


model ArrayDotAdd7
 Real x[2];
 Real y = 1;
equation
 x = y .+ { 10, 20 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Add_ArrayDotAdd7",
			description="Scalarization of element-wise addition: Real .+ Integer[2]",
			flatModel="
fclass ArrayTests.Algebra.Add.ArrayDotAdd7
 constant Real x[1] = 11.0;
 constant Real x[2] = 21.0;
 constant Real y = 1;
end ArrayTests.Algebra.Add.ArrayDotAdd7;
")})));
end ArrayDotAdd7;


model ArrayDotAdd8
 Real x[2,2];
 Real y = 1;
equation
 x = y .+ { { 10, 20 }, { 30, 40 } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Add_ArrayDotAdd8",
			description="Scalarization of element-wise addition: Real .+ Integer[2,2]",
			flatModel="
fclass ArrayTests.Algebra.Add.ArrayDotAdd8
 constant Real x[1,1] = 11.0;
 constant Real x[1,2] = 21.0;
 constant Real x[2,1] = 31.0;
 constant Real x[2,2] = 41.0;
 constant Real y = 1;
end ArrayTests.Algebra.Add.ArrayDotAdd8;
")})));
end ArrayDotAdd8;


model ArrayDotAdd9
 Real x[2,2,2];
 Real y = 1;
equation
 x = y .+ { { { 10, 20 }, { 30, 40 } }, { { 50, 60 }, { 70, 80 } } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Add_ArrayDotAdd9",
			description="Scalarization of element-wise addition: Real .+ Integer[2,2,2]",
			flatModel="
fclass ArrayTests.Algebra.Add.ArrayDotAdd9
 constant Real x[1,1,1] = 11.0;
 constant Real x[1,1,2] = 21.0;
 constant Real x[1,2,1] = 31.0;
 constant Real x[1,2,2] = 41.0;
 constant Real x[2,1,1] = 51.0;
 constant Real x[2,1,2] = 61.0;
 constant Real x[2,2,1] = 71.0;
 constant Real x[2,2,2] = 81.0;
 constant Real y = 1;
end ArrayTests.Algebra.Add.ArrayDotAdd9;
")})));
end ArrayDotAdd9;


model ArrayDotAdd10
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .+ { 10, 20, 30 };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Add_ArrayDotAdd10",
            description="Scalarization of element-wise addition: Real[2] .+ Integer[3]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 2069, column 6:
  Type error in expression: y .+ {10, 20, 30}
    type of 'y' is Real[2]
    type of '{10, 20, 30}' is Integer[3]
")})));
end ArrayDotAdd10;


model ArrayDotAdd11
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .+ { { 10, 20 }, { 30, 40 } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Add_ArrayDotAdd11",
            description="Scalarization of element-wise addition: Real[2] .+ Integer[2,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 2090, column 6:
  Type error in expression: y .+ {{10, 20}, {30, 40}}
    type of 'y' is Real[2]
    type of '{{10, 20}, {30, 40}}' is Integer[2, 2]
")})));
end ArrayDotAdd11;


model ArrayDotAdd12
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .+ { "1", "2" };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Add_ArrayDotAdd12",
            description="Scalarization of element-wise addition: Real[2] .+ String[2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 2111, column 6:
  Type error in expression: y .+ {\"1\", \"2\"}
    type of 'y' is Real[2]
    type of '{\"1\", \"2\"}' is String[2]
")})));
end ArrayDotAdd12;

end Add;


package Sub
	
model ArraySub1
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y - { 10, 20 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Sub_ArraySub1",
			description="Scalarization of subtraction: Real[2] - Integer[2]",
			flatModel="
fclass ArrayTests.Algebra.Sub.ArraySub1
 constant Real x[1] = -9.0;
 constant Real x[2] = -18.0;
 constant Real y[1] = 1;
 constant Real y[2] = 2;
end ArrayTests.Algebra.Sub.ArraySub1;
")})));
end ArraySub1;


model ArraySub2
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y - { { 10, 20 }, { 30, 40 } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Sub_ArraySub2",
			description="Scalarization of subtraction: Real[2,2] - Integer[2,2]",
			flatModel="
fclass ArrayTests.Algebra.Sub.ArraySub2
 constant Real x[1,1] = -9.0;
 constant Real x[1,2] = -18.0;
 constant Real x[2,1] = -27.0;
 constant Real x[2,2] = -36.0;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Sub.ArraySub2;
")})));
end ArraySub2;


model ArraySub3
 Real x[2,2,2];
 Real y[2,2,2] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };
equation
 x = y - { { { 10, 20 }, { 30, 40 } }, { { 50, 60 }, { 70, 80 } } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Sub_ArraySub3",
			description="Scalarization of subtraction: Real[2,2,2] - Integer[2,2,2]",
			flatModel="
fclass ArrayTests.Algebra.Sub.ArraySub3
 constant Real x[1,1,1] = -9.0;
 constant Real x[1,1,2] = -18.0;
 constant Real x[1,2,1] = -27.0;
 constant Real x[1,2,2] = -36.0;
 constant Real x[2,1,1] = -45.0;
 constant Real x[2,1,2] = -54.0;
 constant Real x[2,2,1] = -63.0;
 constant Real x[2,2,2] = -72.0;
 constant Real y[1,1,1] = 1;
 constant Real y[1,1,2] = 2;
 constant Real y[1,2,1] = 3;
 constant Real y[1,2,2] = 4;
 constant Real y[2,1,1] = 5;
 constant Real y[2,1,2] = 6;
 constant Real y[2,2,1] = 7;
 constant Real y[2,2,2] = 8;
end ArrayTests.Algebra.Sub.ArraySub3;
")})));
end ArraySub3;


model ArraySub4
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y - 10;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Sub_ArraySub4",
            description="Scalarization of subtraction: Real[2] - Integer",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 2215, column 6:
  Type error in expression: y - 10
    type of 'y' is Real[2]
    type of '10' is Integer
")})));
end ArraySub4;


model ArraySub5
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y - 10;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Sub_ArraySub5",
            description="Scalarization of subtraction: Real[2,2] - Integer",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 2236, column 6:
  Type error in expression: y - 10
    type of 'y' is Real[2, 2]
    type of '10' is Integer
")})));
end ArraySub5;


model ArraySub6
 Real x[2,2,2];
 Real y[2,2,2] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };
equation
 x = y - 10;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Sub_ArraySub6",
            description="Scalarization of subtraction: Real[2,2,2] - Integer",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 2257, column 6:
  Type error in expression: y - 10
    type of 'y' is Real[2, 2, 2]
    type of '10' is Integer
")})));
end ArraySub6;


model ArraySub7
 Real x[2];
 Real y = 1;
equation
 x = y - { 10, 20 };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Sub_ArraySub7",
            description="Scalarization of subtraction: Real - Integer[2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 2278, column 6:
  Type error in expression: y - {10, 20}
    type of 'y' is Real
    type of '{10, 20}' is Integer[2]
")})));
end ArraySub7;


model ArraySub8
 Real x[2,2];
 Real y = 1;
equation
 x = y - { { 10, 20 }, { 30, 40 } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Sub_ArraySub8",
            description="Scalarization of subtraction: Real - Integer[2,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 2299, column 6:
  Type error in expression: y - {{10, 20}, {30, 40}}
    type of 'y' is Real
    type of '{{10, 20}, {30, 40}}' is Integer[2, 2]
")})));
end ArraySub8;


model ArraySub9
 Real x[2,2,2];
 Real y = 1;
equation
 x = y - { { { 10, 20 }, { 30, 40 } }, { { 50, 60 }, { 70, 80 } } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Sub_ArraySub9",
            description="Scalarization of subtraction: Real - Integer[2,2,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 2320, column 6:
  Type error in expression: y - {{{10, 20}, {30, 40}}, {{50, 60}, {70, 80}}}
    type of 'y' is Real
    type of '{{{10, 20}, {30, 40}}, {{50, 60}, {70, 80}}}' is Integer[2, 2, 2]
")})));
end ArraySub9;


model ArraySub10
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y - { 10, 20, 30 };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Sub_ArraySub10",
            description="Scalarization of subtraction: Real[2] - Integer[3]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 2341, column 6:
  Type error in expression: y - {10, 20, 30}
    type of 'y' is Real[2]
    type of '{10, 20, 30}' is Integer[3]
")})));
end ArraySub10;


model ArraySub11
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y - { { 10, 20 }, { 30, 40 } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Sub_ArraySub11",
            description="Scalarization of subtraction: Real[2] - Integer[2,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 2362, column 6:
  Type error in expression: y - {{10, 20}, {30, 40}}
    type of 'y' is Real[2]
    type of '{{10, 20}, {30, 40}}' is Integer[2, 2]
")})));
end ArraySub11;


model ArraySub12
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y - { "1", "2" };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Sub_ArraySub12",
            description="Scalarization of subtraction: Real[2] - String[2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 2383, column 6:
  Type error in expression: y - {\"1\", \"2\"}
    type of 'y' is Real[2]
    type of '{\"1\", \"2\"}' is String[2]
")})));
end ArraySub12;



model ArrayDotSub1
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .- { 10, 20 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Sub_ArrayDotSub1",
			description="Scalarization of element-wise subtraction: Real[2] .- Integer[2]",
			flatModel="
fclass ArrayTests.Algebra.Sub.ArrayDotSub1
 constant Real x[1] = -9.0;
 constant Real x[2] = -18.0;
 constant Real y[1] = 1;
 constant Real y[2] = 2;
end ArrayTests.Algebra.Sub.ArrayDotSub1;
")})));
end ArrayDotSub1;


model ArrayDotSub2
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y .- { { 10, 20 }, { 30, 40 } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Sub_ArrayDotSub2",
			description="Scalarization of element-wise subtraction: Real[2,2] .- Integer[2,2]",
			flatModel="
fclass ArrayTests.Algebra.Sub.ArrayDotSub2
 constant Real x[1,1] = -9.0;
 constant Real x[1,2] = -18.0;
 constant Real x[2,1] = -27.0;
 constant Real x[2,2] = -36.0;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Sub.ArrayDotSub2;
")})));
end ArrayDotSub2;


model ArrayDotSub3
 Real x[2,2,2];
 Real y[2,2,2] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };
equation
 x = y .- { { { 10, 20 }, { 30, 40 } }, { { 50, 60 }, { 70, 80 } } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Sub_ArrayDotSub3",
			description="Scalarization of element-wise subtraction: Real[2,2,2] .- Integer[2,2,2]",
			flatModel="
fclass ArrayTests.Algebra.Sub.ArrayDotSub3
 constant Real x[1,1,1] = -9.0;
 constant Real x[1,1,2] = -18.0;
 constant Real x[1,2,1] = -27.0;
 constant Real x[1,2,2] = -36.0;
 constant Real x[2,1,1] = -45.0;
 constant Real x[2,1,2] = -54.0;
 constant Real x[2,2,1] = -63.0;
 constant Real x[2,2,2] = -72.0;
 constant Real y[1,1,1] = 1;
 constant Real y[1,1,2] = 2;
 constant Real y[1,2,1] = 3;
 constant Real y[1,2,2] = 4;
 constant Real y[2,1,1] = 5;
 constant Real y[2,1,2] = 6;
 constant Real y[2,2,1] = 7;
 constant Real y[2,2,2] = 8;
end ArrayTests.Algebra.Sub.ArrayDotSub3;
")})));
end ArrayDotSub3;


model ArrayDotSub4
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .- 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Sub_ArrayDotSub4",
			description="Scalarization of element-wise subtraction: Real[2] .- Integer",
			flatModel="
fclass ArrayTests.Algebra.Sub.ArrayDotSub4
 constant Real x[1] = -9.0;
 constant Real x[2] = -8.0;
 constant Real y[1] = 1;
 constant Real y[2] = 2;
end ArrayTests.Algebra.Sub.ArrayDotSub4;
")})));
end ArrayDotSub4;


model ArrayDotSub5
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y .- 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Sub_ArrayDotSub5",
			description="Scalarization of element-wise subtraction: Real[2,2] .- Integer",
			flatModel="
fclass ArrayTests.Algebra.Sub.ArrayDotSub5
 constant Real x[1,1] = -9.0;
 constant Real x[1,2] = -8.0;
 constant Real x[2,1] = -7.0;
 constant Real x[2,2] = -6.0;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Sub.ArrayDotSub5;
")})));
end ArrayDotSub5;


model ArrayDotSub6
 Real x[2,2,2];
 Real y[2,2,2] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };
equation
 x = y .- 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Sub_ArrayDotSub6",
			description="Scalarization of element-wise subtraction: Real[2,2,2] .- Integer",
			flatModel="
fclass ArrayTests.Algebra.Sub.ArrayDotSub6
 constant Real x[1,1,1] = -9.0;
 constant Real x[1,1,2] = -8.0;
 constant Real x[1,2,1] = -7.0;
 constant Real x[1,2,2] = -6.0;
 constant Real x[2,1,1] = -5.0;
 constant Real x[2,1,2] = -4.0;
 constant Real x[2,2,1] = -3.0;
 constant Real x[2,2,2] = -2.0;
 constant Real y[1,1,1] = 1;
 constant Real y[1,1,2] = 2;
 constant Real y[1,2,1] = 3;
 constant Real y[1,2,2] = 4;
 constant Real y[2,1,1] = 5;
 constant Real y[2,1,2] = 6;
 constant Real y[2,2,1] = 7;
 constant Real y[2,2,2] = 8;
end ArrayTests.Algebra.Sub.ArrayDotSub6;
")})));
end ArrayDotSub6;


model ArrayDotSub7
 Real x[2];
 Real y = 1;
equation
 x = y .- { 10, 20 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Sub_ArrayDotSub7",
			description="Scalarization of element-wise subtraction: Real .- Integer[2]",
			flatModel="
fclass ArrayTests.Algebra.Sub.ArrayDotSub7
 constant Real x[1] = -9.0;
 constant Real x[2] = -19.0;
 constant Real y = 1;
end ArrayTests.Algebra.Sub.ArrayDotSub7;
")})));
end ArrayDotSub7;


model ArrayDotSub8
 Real x[2,2];
 Real y = 1;
equation
 x = y .- { { 10, 20 }, { 30, 40 } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Sub_ArrayDotSub8",
			description="Scalarization of element-wise subtraction: Real .- Integer[2,2]",
			flatModel="
fclass ArrayTests.Algebra.Sub.ArrayDotSub8
 constant Real x[1,1] = -9.0;
 constant Real x[1,2] = -19.0;
 constant Real x[2,1] = -29.0;
 constant Real x[2,2] = -39.0;
 constant Real y = 1;
end ArrayTests.Algebra.Sub.ArrayDotSub8;
")})));
end ArrayDotSub8;


model ArrayDotSub9
 Real x[2,2,2];
 Real y = 1;
equation
 x = y .- { { { 10, 20 }, { 30, 40 } }, { { 50, 60 }, { 70, 80 } } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Sub_ArrayDotSub9",
			description="Scalarization of element-wise subtraction: Real .- Integer[2,2,2]",
			flatModel="
fclass ArrayTests.Algebra.Sub.ArrayDotSub9
 constant Real x[1,1,1] = -9.0;
 constant Real x[1,1,2] = -19.0;
 constant Real x[1,2,1] = -29.0;
 constant Real x[1,2,2] = -39.0;
 constant Real x[2,1,1] = -49.0;
 constant Real x[2,1,2] = -59.0;
 constant Real x[2,2,1] = -69.0;
 constant Real x[2,2,2] = -79.0;
 constant Real y = 1;
end ArrayTests.Algebra.Sub.ArrayDotSub9;
")})));
end ArrayDotSub9;


model ArrayDotSub10
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .- { 10, 20, 30 };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Sub_ArrayDotSub10",
            description="Scalarization of element-wise subtraction: Real[2] .- Integer[3]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 2631, column 6:
  Type error in expression: y .- {10, 20, 30}
    type of 'y' is Real[2]
    type of '{10, 20, 30}' is Integer[3]
")})));
end ArrayDotSub10;


model ArrayDotSub11
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .- { { 10, 20 }, { 30, 40 } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Sub_ArrayDotSub11",
            description="Scalarization of element-wise subtraction: Real[2] .- Integer[2,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 2652, column 6:
  Type error in expression: y .- {{10, 20}, {30, 40}}
    type of 'y' is Real[2]
    type of '{{10, 20}, {30, 40}}' is Integer[2, 2]
")})));
end ArrayDotSub11;


model ArrayDotSub12
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .- { "1", "2" };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Sub_ArrayDotSub12",
            description="Scalarization of element-wise subtraction: Real[2] .- String[2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 2673, column 6:
  Type error in expression: y .- {\"1\", \"2\"}
    type of 'y' is Real[2]
    type of '{\"1\", \"2\"}' is String[2]
")})));
end ArrayDotSub12;

end Sub;


package Mul
	
model ArrayMulOK1
 Real x;
 Real y[3] = { 1, 2, 3 };
equation
 x = y * { 10, 20, 30 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayMulOK1",
			description="Scalarization of multiplication: Real[3] * Integer[3]",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayMulOK1
 constant Real x = 140.0;
 constant Real y[1] = 1;
 constant Real y[2] = 2;
 constant Real y[3] = 3;
end ArrayTests.Algebra.Mul.ArrayMulOK1;
")})));
end ArrayMulOK1;


model ArrayMulOK2
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y * { { 10, 20 }, { 30, 40 } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayMulOK2",
			description="Scalarization of multiplication: Real[2,2] * Integer[2,2]",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayMulOK2
 constant Real x[1,1] = 70.0;
 constant Real x[1,2] = 100.0;
 constant Real x[2,1] = 150.0;
 constant Real x[2,2] = 220.0;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Mul.ArrayMulOK2;
")})));
end ArrayMulOK2;


model ArrayMulOK3
 Real x[3,4];
 Real y[2,4] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
equation
 x = { { 10, 20 }, { 30, 40 }, { 50, 60 } } * y;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayMulOK3",
			description="Scalarization of multiplication: Integer[3,2] * Real[2,4]",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayMulOK3
 constant Real x[1,1] = 110.0;
 constant Real x[1,2] = 140.0;
 constant Real x[1,3] = 170.0;
 constant Real x[1,4] = 200.0;
 constant Real x[2,1] = 230.0;
 constant Real x[2,2] = 300.0;
 constant Real x[2,3] = 370.0;
 constant Real x[2,4] = 440.0;
 constant Real x[3,1] = 350.0;
 constant Real x[3,2] = 460.0;
 constant Real x[3,3] = 570.0;
 constant Real x[3,4] = 680.0;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[1,3] = 3;
 constant Real y[1,4] = 4;
 constant Real y[2,1] = 5;
 constant Real y[2,2] = 6;
 constant Real y[2,3] = 7;
 constant Real y[2,4] = 8;
end ArrayTests.Algebra.Mul.ArrayMulOK3;
")})));
end ArrayMulOK3;


model ArrayMulOK4
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y * { { 10, 20 }, { 30, 40 } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayMulOK4",
			description="Scalarization of multiplication: Real[2] * Integer[2,2]",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayMulOK4
 constant Real x[1] = 70.0;
 constant Real x[2] = 100.0;
 constant Real y[1] = 1;
 constant Real y[2] = 2;
end ArrayTests.Algebra.Mul.ArrayMulOK4;
")})));
end ArrayMulOK4;


model ArrayMulOK5
 Real x[2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y * { 10, 20 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayMulOK5",
			description="Scalarization of multiplication: Real[2,2] * Integer[2]",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayMulOK5
 constant Real x[1] = 50.0;
 constant Real x[2] = 110.0;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Mul.ArrayMulOK5;
")})));
end ArrayMulOK5;


model ArrayMulOK6
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y * 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayMulOK6",
			description="Scalarization of multiplication: Real[2] * Integer",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayMulOK6
 constant Real x[1] = 10.0;
 constant Real x[2] = 20.0;
 constant Real y[1] = 1;
 constant Real y[2] = 2;
end ArrayTests.Algebra.Mul.ArrayMulOK6;
")})));
end ArrayMulOK6;


model ArrayMulOK7
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y * 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayMulOK7",
			description="Scalarization of multiplication: Real[2,2] * Integer",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayMulOK7
 constant Real x[1,1] = 10.0;
 constant Real x[1,2] = 20.0;
 constant Real x[2,1] = 30.0;
 constant Real x[2,2] = 40.0;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Mul.ArrayMulOK7;
")})));
end ArrayMulOK7;


model ArrayMulOK8
 Real x[2,2,2];
 Real y[2,2,2] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };
equation
 x = y * 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayMulOK8",
			description="Scalarization of multiplication: Real[2,2,2] * Integer",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayMulOK8
 constant Real x[1,1,1] = 10.0;
 constant Real x[1,1,2] = 20.0;
 constant Real x[1,2,1] = 30.0;
 constant Real x[1,2,2] = 40.0;
 constant Real x[2,1,1] = 50.0;
 constant Real x[2,1,2] = 60.0;
 constant Real x[2,2,1] = 70.0;
 constant Real x[2,2,2] = 80.0;
 constant Real y[1,1,1] = 1;
 constant Real y[1,1,2] = 2;
 constant Real y[1,2,1] = 3;
 constant Real y[1,2,2] = 4;
 constant Real y[2,1,1] = 5;
 constant Real y[2,1,2] = 6;
 constant Real y[2,2,1] = 7;
 constant Real y[2,2,2] = 8;
end ArrayTests.Algebra.Mul.ArrayMulOK8;
")})));
end ArrayMulOK8;


model ArrayMulOK9
 Real x[2];
 Real y = 1;
equation
 x = y * { 10, 20 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayMulOK9",
			description="Scalarization of multiplication: Real * Integer[2]",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayMulOK9
 constant Real x[1] = 10.0;
 constant Real x[2] = 20.0;
 constant Real y = 1;
end ArrayTests.Algebra.Mul.ArrayMulOK9;
")})));
end ArrayMulOK9;


model ArrayMulOK10
 Real x[2,2];
 Real y = 1;
equation
 x = y * { { 10, 20 }, { 30, 40 } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayMulOK10",
			description="Scalarization of multiplication: Real * Integer[2,2]",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayMulOK10
 constant Real x[1,1] = 10.0;
 constant Real x[1,2] = 20.0;
 constant Real x[2,1] = 30.0;
 constant Real x[2,2] = 40.0;
 constant Real y = 1;
end ArrayTests.Algebra.Mul.ArrayMulOK10;
")})));
end ArrayMulOK10;


model ArrayMulOK11
 Real x[2,2,2];
 Real y = 1;
equation
 x = y * { { { 10, 20 }, { 30, 40 } }, { { 50, 60 }, { 70, 80 } } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayMulOK11",
			description="Scalarization of multiplication: Real * Integer[2,2,2]",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayMulOK11
 constant Real x[1,1,1] = 10.0;
 constant Real x[1,1,2] = 20.0;
 constant Real x[1,2,1] = 30.0;
 constant Real x[1,2,2] = 40.0;
 constant Real x[2,1,1] = 50.0;
 constant Real x[2,1,2] = 60.0;
 constant Real x[2,2,1] = 70.0;
 constant Real x[2,2,2] = 80.0;
 constant Real y = 1;
end ArrayTests.Algebra.Mul.ArrayMulOK11;
")})));
end ArrayMulOK11;


model ArrayMulOK12
 Real x[2,1];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y * { { 10 }, { 20 } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayMulOK12",
			description="Scalarization of multiplication: Real[2,2] * Integer[2,1]",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayMulOK12
 constant Real x[1,1] = 50.0;
 constant Real x[2,1] = 110.0;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Mul.ArrayMulOK12;
")})));
end ArrayMulOK12;


model ArrayMulOK13
 Real x[3] = { 1, 2, 3 };
 Real y[3] = x * x * x;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayMulOK13",
			description="Scalarization of multiplication: check that type() of Real[3] * Real[3] is correct",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayMulOK13
 constant Real x[1] = 1;
 constant Real x[2] = 2;
 constant Real x[3] = 3;
 constant Real y[1] = 14.0;
 constant Real y[2] = 28.0;
 constant Real y[3] = 42.0;
end ArrayTests.Algebra.Mul.ArrayMulOK13;
")})));
end ArrayMulOK13;


model ArrayMulErr1
 Real x[2,2,2];
 Real y[2,2,2] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };
equation
 x = y * { { { 10, 20 }, { 30, 40 } }, { { 50, 60 }, { 70, 80 } } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Mul_ArrayMulErr1",
            description="Scalarization of multiplication: Real[2,2,2] * Integer[2,2,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 2992, column 6:
  Type error in expression: y * {{{10, 20}, {30, 40}}, {{50, 60}, {70, 80}}}
    type of 'y' is Real[2, 2, 2]
    type of '{{{10, 20}, {30, 40}}, {{50, 60}, {70, 80}}}' is Integer[2, 2, 2]
")})));
end ArrayMulErr1;


model ArrayMulErr2
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y * { 10, 20, 30 };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Mul_ArrayMulErr2",
            description="Scalarization of multiplication: Real[2] * Integer[3]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3013, column 6:
  Type error in expression: y * {10, 20, 30}
    type of 'y' is Real[2]
    type of '{10, 20, 30}' is Integer[3]
")})));
end ArrayMulErr2;


model ArrayMulErr3
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y * { "1", "2" };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Mul_ArrayMulErr3",
            description="Scalarization of multiplication: Real[2] * String[2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3034, column 6:
  Type error in expression: y * {\"1\", \"2\"}
    type of 'y' is Real[2]
    type of '{\"1\", \"2\"}' is String[2]
")})));
end ArrayMulErr3;


model ArrayMulErr4
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y * { { 10, 20 }, { 30, 40 }, { 50, 60 } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Mul_ArrayMulErr4",
            description="Scalarization of multiplication: Real[2,2] * Integer[3,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3055, column 6:
  Type error in expression: y * {{10, 20}, {30, 40}, {50, 60}}
    type of 'y' is Real[2, 2]
    type of '{{10, 20}, {30, 40}, {50, 60}}' is Integer[3, 2]
")})));
end ArrayMulErr4;


model ArrayMulErr5
 Real x[2,2];
 Real y[2,3] = { { 1, 2, 3 }, { 4, 5, 6 } };
equation
 x = y * { { 10, 20 }, { 30, 40 } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Mul_ArrayMulErr5",
            description="Scalarization of multiplication: Real[2,3] * Integer[2,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3076, column 6:
  Type error in expression: y * {{10, 20}, {30, 40}}
    type of 'y' is Real[2, 3]
    type of '{{10, 20}, {30, 40}}' is Integer[2, 2]
")})));
end ArrayMulErr5;


model ArrayMulErr6
 Real x[2,2];
 Real y[2,3] = { { 1, 2, 3 }, { 4, 5, 6 } };
equation
 x = y * { { 10, 20, 30 }, { 40, 50, 60 } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Mul_ArrayMulErr6",
            description="Scalarization of multiplication: Real[2,3] * Integer[2,3]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3097, column 6:
  Type error in expression: y * {{10, 20, 30}, {40, 50, 60}}
    type of 'y' is Real[2, 3]
    type of '{{10, 20, 30}, {40, 50, 60}}' is Integer[2, 3]
")})));
end ArrayMulErr6;


model ArrayMulErr7
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y * { 10, 20, 30 };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Mul_ArrayMulErr7",
            description="Scalarization of multiplication: Real[2,2] * Integer[3]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3118, column 6:
  Type error in expression: y * {10, 20, 30}
    type of 'y' is Real[2, 2]
    type of '{10, 20, 30}' is Integer[3]
")})));
end ArrayMulErr7;


model ArrayMulErr8
 Real x[2,2];
 Real y[3] = { 1, 2, 3 };
equation
 x = y * { { 10, 20 }, { 30, 40 } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Mul_ArrayMulErr8",
            description="Scalarization of multiplication: Real[3] * Integer[2,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3139, column 6:
  Type error in expression: y * {{10, 20}, {30, 40}}
    type of 'y' is Real[3]
    type of '{{10, 20}, {30, 40}}' is Integer[2, 2]
")})));
end ArrayMulErr8;


model ArrayMulErr9
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y * { { 10, 20 } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Mul_ArrayMulErr9",
            description="Scalarization of multiplication: Real[2,2] * Integer[1,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3160, column 6:
  Type error in expression: y * {{10, 20}}
    type of 'y' is Real[2, 2]
    type of '{{10, 20}}' is Integer[1, 2]
")})));
end ArrayMulErr9;



model ArrayDotMul1
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .* { 10, 20 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayDotMul1",
			description="Scalarization of element-wise multiplication: Real[2] .* Integer[2]",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayDotMul1
 constant Real x[1] = 10.0;
 constant Real x[2] = 40.0;
 constant Real y[1] = 1;
 constant Real y[2] = 2;
end ArrayTests.Algebra.Mul.ArrayDotMul1;
")})));
end ArrayDotMul1;


model ArrayDotMul2
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y .* { { 10, 20 }, { 30, 40 } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayDotMul2",
			description="Scalarization of element-wise multiplication: Real[2,2] .* Integer[2,2]",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayDotMul2
 constant Real x[1,1] = 10.0;
 constant Real x[1,2] = 40.0;
 constant Real x[2,1] = 90.0;
 constant Real x[2,2] = 160.0;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Mul.ArrayDotMul2;
")})));
end ArrayDotMul2;


model ArrayDotMul3
 Real x[2,2,2];
 Real y[2,2,2] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };
equation
 x = y .* { { { 10, 20 }, { 30, 40 } }, { { 50, 60 }, { 70, 80 } } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayDotMul3",
			description="Scalarization of element-wise multiplication: Real[2,2,2] .* Integer[2,2,2]",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayDotMul3
 constant Real x[1,1,1] = 10.0;
 constant Real x[1,1,2] = 40.0;
 constant Real x[1,2,1] = 90.0;
 constant Real x[1,2,2] = 160.0;
 constant Real x[2,1,1] = 250.0;
 constant Real x[2,1,2] = 360.0;
 constant Real x[2,2,1] = 490.0;
 constant Real x[2,2,2] = 640.0;
 constant Real y[1,1,1] = 1;
 constant Real y[1,1,2] = 2;
 constant Real y[1,2,1] = 3;
 constant Real y[1,2,2] = 4;
 constant Real y[2,1,1] = 5;
 constant Real y[2,1,2] = 6;
 constant Real y[2,2,1] = 7;
 constant Real y[2,2,2] = 8;
end ArrayTests.Algebra.Mul.ArrayDotMul3;
")})));
end ArrayDotMul3;


model ArrayDotMul4
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .* 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayDotMul4",
			description="Scalarization of element-wise multiplication: Real[2] .* Integer",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayDotMul4
 constant Real x[1] = 10.0;
 constant Real x[2] = 20.0;
 constant Real y[1] = 1;
 constant Real y[2] = 2;
end ArrayTests.Algebra.Mul.ArrayDotMul4;
")})));
end ArrayDotMul4;


model ArrayDotMul5
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y .* 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayDotMul5",
			description="Scalarization of element-wise multiplication: Real[2,2] .* Integer",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayDotMul5
 constant Real x[1,1] = 10.0;
 constant Real x[1,2] = 20.0;
 constant Real x[2,1] = 30.0;
 constant Real x[2,2] = 40.0;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Mul.ArrayDotMul5;
")})));
end ArrayDotMul5;


model ArrayDotMul6
 Real x[2,2,2];
 Real y[2,2,2] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };
equation
 x = y .* 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayDotMul6",
			description="Scalarization of element-wise multiplication: Real[2,2,2] .* Integer",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayDotMul6
 constant Real x[1,1,1] = 10.0;
 constant Real x[1,1,2] = 20.0;
 constant Real x[1,2,1] = 30.0;
 constant Real x[1,2,2] = 40.0;
 constant Real x[2,1,1] = 50.0;
 constant Real x[2,1,2] = 60.0;
 constant Real x[2,2,1] = 70.0;
 constant Real x[2,2,2] = 80.0;
 constant Real y[1,1,1] = 1;
 constant Real y[1,1,2] = 2;
 constant Real y[1,2,1] = 3;
 constant Real y[1,2,2] = 4;
 constant Real y[2,1,1] = 5;
 constant Real y[2,1,2] = 6;
 constant Real y[2,2,1] = 7;
 constant Real y[2,2,2] = 8;
end ArrayTests.Algebra.Mul.ArrayDotMul6;
")})));
end ArrayDotMul6;


model ArrayDotMul7
 Real x[2];
 Real y = 1;
equation
 x = y .* { 10, 20 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayDotMul7",
			description="Scalarization of element-wise multiplication: Real .* Integer[2]",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayDotMul7
 constant Real x[1] = 10.0;
 constant Real x[2] = 20.0;
 constant Real y = 1;
end ArrayTests.Algebra.Mul.ArrayDotMul7;
")})));
end ArrayDotMul7;


model ArrayDotMul8
 Real x[2,2];
 Real y = 1;
equation
 x = y .* { { 10, 20 }, { 30, 40 } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayDotMul8",
			description="Scalarization of element-wise multiplication: Real .* Integer[2,2]",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayDotMul8
 constant Real x[1,1] = 10.0;
 constant Real x[1,2] = 20.0;
 constant Real x[2,1] = 30.0;
 constant Real x[2,2] = 40.0;
 constant Real y = 1;
end ArrayTests.Algebra.Mul.ArrayDotMul8;
")})));
end ArrayDotMul8;


model ArrayDotMul9
 Real x[2,2,2];
 Real y = 1;
equation
 x = y .* { { { 10, 20 }, { 30, 40 } }, { { 50, 60 }, { 70, 80 } } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Mul_ArrayDotMul9",
			description="Scalarization of element-wise multiplication: Real .* Integer[2,2,2]",
			flatModel="
fclass ArrayTests.Algebra.Mul.ArrayDotMul9
 constant Real x[1,1,1] = 10.0;
 constant Real x[1,1,2] = 20.0;
 constant Real x[1,2,1] = 30.0;
 constant Real x[1,2,2] = 40.0;
 constant Real x[2,1,1] = 50.0;
 constant Real x[2,1,2] = 60.0;
 constant Real x[2,2,1] = 70.0;
 constant Real x[2,2,2] = 80.0;
 constant Real y = 1;
end ArrayTests.Algebra.Mul.ArrayDotMul9;
")})));
end ArrayDotMul9;


model ArrayDotMul10
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .* { 10, 20, 30 };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Mul_ArrayDotMul10",
            description="Scalarization of element-wise multiplication: Real[2] .* Integer[3]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3408, column 6:
  Type error in expression: y .* {10, 20, 30}
    type of 'y' is Real[2]
    type of '{10, 20, 30}' is Integer[3]
")})));
end ArrayDotMul10;


model ArrayDotMul11
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .* { { 10, 20 }, { 30, 40 } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Mul_ArrayDotMul11",
            description="Scalarization of element-wise multiplication: Real[2] .* Integer[2,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3429, column 6:
  Type error in expression: y .* {{10, 20}, {30, 40}}
    type of 'y' is Real[2]
    type of '{{10, 20}, {30, 40}}' is Integer[2, 2]
")})));
end ArrayDotMul11;


model ArrayDotMul12
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .* { "1", "2" };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Mul_ArrayDotMul12",
            description="Scalarization of element-wise multiplication: Real[2] .* String[2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3450, column 6:
  Type error in expression: y .* {\"1\", \"2\"}
    type of 'y' is Real[2]
    type of '{\"1\", \"2\"}' is String[2]
")})));
end ArrayDotMul12;

end Mul;


package Div
	
model ArrayDiv1
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y / { 10, 20 };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Div_ArrayDiv1",
            description="Scalarization of division: Real[2] / Integer[2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3475, column 6:
  Type error in expression: y / {10, 20}
    type of 'y' is Real[2]
    type of '{10, 20}' is Integer[2]
")})));
end ArrayDiv1;


model ArrayDiv2
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y / { { 10, 20 }, { 30, 40 } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Div_ArrayDiv2",
            description="Scalarization of division: Real[2,2] / Integer[2,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3496, column 6:
  Type error in expression: y / {{10, 20}, {30, 40}}
    type of 'y' is Real[2, 2]
    type of '{{10, 20}, {30, 40}}' is Integer[2, 2]
")})));
end ArrayDiv2;


model ArrayDiv3
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y / 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Div_ArrayDiv3",
			description="Scalarization of division: Real[2] / Integer",
			flatModel="
fclass ArrayTests.Algebra.Div.ArrayDiv3
 constant Real x[1] = 0.1;
 constant Real x[2] = 0.2;
 constant Real y[1] = 1;
 constant Real y[2] = 2;
end ArrayTests.Algebra.Div.ArrayDiv3;
")})));
end ArrayDiv3;


model ArrayDiv4
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y / 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Div_ArrayDiv4",
			description="Scalarization of division: Real[2,2] / Integer",
			flatModel="
fclass ArrayTests.Algebra.Div.ArrayDiv4
 constant Real x[1,1] = 0.1;
 constant Real x[1,2] = 0.2;
 constant Real x[2,1] = 0.3;
 constant Real x[2,2] = 0.4;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Div.ArrayDiv4;
")})));
end ArrayDiv4;


model ArrayDiv5
 Real x[2,2,2];
 Real y[2,2,2] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };
equation
 x = y / 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Div_ArrayDiv5",
			description="Scalarization of division: Real[2,2,2] / Integer",
			flatModel="
fclass ArrayTests.Algebra.Div.ArrayDiv5
 constant Real x[1,1,1] = 0.1;
 constant Real x[1,1,2] = 0.2;
 constant Real x[1,2,1] = 0.3;
 constant Real x[1,2,2] = 0.4;
 constant Real x[2,1,1] = 0.5;
 constant Real x[2,1,2] = 0.6;
 constant Real x[2,2,1] = 0.7;
 constant Real x[2,2,2] = 0.8;
 constant Real y[1,1,1] = 1;
 constant Real y[1,1,2] = 2;
 constant Real y[1,2,1] = 3;
 constant Real y[1,2,2] = 4;
 constant Real y[2,1,1] = 5;
 constant Real y[2,1,2] = 6;
 constant Real y[2,2,1] = 7;
 constant Real y[2,2,2] = 8;
end ArrayTests.Algebra.Div.ArrayDiv5;
")})));
end ArrayDiv5;


model ArrayDiv6
 Real x[2];
 Real y = 1;
equation
 x = y / { 10, 20 };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Div_ArrayDiv6",
            description="Scalarization of division: Real / Integer[2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3596, column 6:
  Type error in expression: y / {10, 20}
    type of 'y' is Real
    type of '{10, 20}' is Integer[2]
")})));
end ArrayDiv6;


model ArrayDiv7
 Real x[2,2];
 Real y = 1;
equation
 x = y / { { 10, 20 }, { 30, 40 } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Div_ArrayDiv7",
            description="Scalarization of division: Real / Integer[2,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3617, column 6:
  Type error in expression: y / {{10, 20}, {30, 40}}
    type of 'y' is Real
    type of '{{10, 20}, {30, 40}}' is Integer[2, 2]
")})));
end ArrayDiv7;


model ArrayDiv8
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y / { "1", "2" };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Div_ArrayDiv8",
            description="Scalarization of division: Real[2] / String",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3638, column 6:
  Type error in expression: y / {\"1\", \"2\"}
    type of 'y' is Real[2]
    type of '{\"1\", \"2\"}' is String[2]
")})));
end ArrayDiv8;



model ArrayDotDiv1
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y ./ { 10, 20 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Div_ArrayDotDiv1",
			description="Scalarization of element-wise division: Real[2] ./ Integer[2]",
			flatModel="
fclass ArrayTests.Algebra.Div.ArrayDotDiv1
 constant Real x[1] = 0.1;
 constant Real x[2] = 0.1;
 constant Real y[1] = 1;
 constant Real y[2] = 2;
end ArrayTests.Algebra.Div.ArrayDotDiv1;
")})));
end ArrayDotDiv1;


model ArrayDotDiv2
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y ./ { { 10, 20 }, { 30, 40 } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Div_ArrayDotDiv2",
			description="Scalarization of element-wise division: Real[2,2] ./ Integer[2,2]",
			flatModel="
fclass ArrayTests.Algebra.Div.ArrayDotDiv2
 constant Real x[1,1] = 0.1;
 constant Real x[1,2] = 0.1;
 constant Real x[2,1] = 0.1;
 constant Real x[2,2] = 0.1;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Div.ArrayDotDiv2;
")})));
end ArrayDotDiv2;


model ArrayDotDiv3
 Real x[2,2,2];
 Real y[2,2,2] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };
equation
 x = y ./ { { { 10, 20 }, { 30, 40 } }, { { 50, 60 }, { 70, 80 } } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Div_ArrayDotDiv3",
			description="Scalarization of element-wise division: Real[2,2,2] ./ Integer[2,2,2]",
			flatModel="
fclass ArrayTests.Algebra.Div.ArrayDotDiv3
 constant Real x[1,1,1] = 0.1;
 constant Real x[1,1,2] = 0.1;
 constant Real x[1,2,1] = 0.1;
 constant Real x[1,2,2] = 0.1;
 constant Real x[2,1,1] = 0.1;
 constant Real x[2,1,2] = 0.1;
 constant Real x[2,2,1] = 0.1;
 constant Real x[2,2,2] = 0.1;
 constant Real y[1,1,1] = 1;
 constant Real y[1,1,2] = 2;
 constant Real y[1,2,1] = 3;
 constant Real y[1,2,2] = 4;
 constant Real y[2,1,1] = 5;
 constant Real y[2,1,2] = 6;
 constant Real y[2,2,1] = 7;
 constant Real y[2,2,2] = 8;
end ArrayTests.Algebra.Div.ArrayDotDiv3;
")})));
end ArrayDotDiv3;


model ArrayDotDiv4
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y ./ 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Div_ArrayDotDiv4",
			description="Scalarization of element-wise division: Real[2] ./ Integer",
			flatModel="
fclass ArrayTests.Algebra.Div.ArrayDotDiv4
 constant Real x[1] = 0.1;
 constant Real x[2] = 0.2;
 constant Real y[1] = 1;
 constant Real y[2] = 2;
end ArrayTests.Algebra.Div.ArrayDotDiv4;
")})));
end ArrayDotDiv4;


model ArrayDotDiv5
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y ./ 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Div_ArrayDotDiv5",
			description="Scalarization of element-wise division: Real[2,2] ./ Integer",
			flatModel="
fclass ArrayTests.Algebra.Div.ArrayDotDiv5
 constant Real x[1,1] = 0.1;
 constant Real x[1,2] = 0.2;
 constant Real x[2,1] = 0.3;
 constant Real x[2,2] = 0.4;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Div.ArrayDotDiv5;
")})));
end ArrayDotDiv5;


model ArrayDotDiv6
 Real x[2,2,2];
 Real y[2,2,2] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };
equation
 x = y ./ 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Div_ArrayDotDiv6",
			description="Scalarization of element-wise division: Real[2,2,2] ./ Integer",
			flatModel="
fclass ArrayTests.Algebra.Div.ArrayDotDiv6
 constant Real x[1,1,1] = 0.1;
 constant Real x[1,1,2] = 0.2;
 constant Real x[1,2,1] = 0.3;
 constant Real x[1,2,2] = 0.4;
 constant Real x[2,1,1] = 0.5;
 constant Real x[2,1,2] = 0.6;
 constant Real x[2,2,1] = 0.7;
 constant Real x[2,2,2] = 0.8;
 constant Real y[1,1,1] = 1;
 constant Real y[1,1,2] = 2;
 constant Real y[1,2,1] = 3;
 constant Real y[1,2,2] = 4;
 constant Real y[2,1,1] = 5;
 constant Real y[2,1,2] = 6;
 constant Real y[2,2,1] = 7;
 constant Real y[2,2,2] = 8;
end ArrayTests.Algebra.Div.ArrayDotDiv6;
")})));
end ArrayDotDiv6;


model ArrayDotDiv7
 Real x[2];
 Real y = 1;
equation
 x = y ./ { 10, 20 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Div_ArrayDotDiv7",
			description="Scalarization of element-wise division: Real ./ Integer[2]",
			flatModel="
fclass ArrayTests.Algebra.Div.ArrayDotDiv7
 constant Real x[1] = 0.1;
 constant Real x[2] = 0.05;
 constant Real y = 1;
end ArrayTests.Algebra.Div.ArrayDotDiv7;
")})));
end ArrayDotDiv7;


model ArrayDotDiv8
 Real x[2,2];
 Real y = 1;
equation
 x = y ./ { { 10, 20 }, { 30, 40 } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Div_ArrayDotDiv8",
			description="Scalarization of element-wise division: Real ./ Integer[2,2]",
			flatModel="
fclass ArrayTests.Algebra.Div.ArrayDotDiv8
 constant Real x[1,1] = 0.1;
 constant Real x[1,2] = 0.05;
 constant Real x[2,1] = 0.03333333333333333;
 constant Real x[2,2] = 0.025;
 constant Real y = 1;
end ArrayTests.Algebra.Div.ArrayDotDiv8;
")})));
end ArrayDotDiv8;


model ArrayDotDiv9
 Real x[2,2,2];
 Real y = 1;
equation
 x = y ./ { { { 10, 20 }, { 30, 40 } }, { { 50, 60 }, { 70, 80 } } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Div_ArrayDotDiv9",
			description="Scalarization of element-wise division: Real ./ Integer[2,2,2]",
			flatModel="
fclass ArrayTests.Algebra.Div.ArrayDotDiv9
 constant Real x[1,1,1] = 0.1;
 constant Real x[1,1,2] = 0.05;
 constant Real x[1,2,1] = 0.03333333333333333;
 constant Real x[1,2,2] = 0.025;
 constant Real x[2,1,1] = 0.02;
 constant Real x[2,1,2] = 0.016666666666666666;
 constant Real x[2,2,1] = 0.014285714285714285;
 constant Real x[2,2,2] = 0.0125;
 constant Real y = 1;
end ArrayTests.Algebra.Div.ArrayDotDiv9;
")})));
end ArrayDotDiv9;


model ArrayDotDiv10
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y ./ { 10, 20, 30 };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Div_ArrayDotDiv10",
            description="Scalarization of element-wise division: Real[2] ./ Integer[3]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3886, column 6:
  Type error in expression: y ./ {10, 20, 30}
    type of 'y' is Real[2]
    type of '{10, 20, 30}' is Integer[3]
")})));
end ArrayDotDiv10;


model ArrayDotDiv11
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y ./ { { 10, 20 }, { 30, 40 } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Div_ArrayDotDiv11",
            description="Scalarization of element-wise division: Real[2] ./ Integer[2,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3907, column 6:
  Type error in expression: y ./ {{10, 20}, {30, 40}}
    type of 'y' is Real[2]
    type of '{{10, 20}, {30, 40}}' is Integer[2, 2]
")})));
end ArrayDotDiv11;


model ArrayDotDiv12
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y ./ { "1", "2" };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Div_ArrayDotDiv12",
            description="Scalarization of element-wise division: Real[2] ./ String[2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 3928, column 6:
  Type error in expression: y ./ {\"1\", \"2\"}
    type of 'y' is Real[2]
    type of '{\"1\", \"2\"}' is String[2]
")})));
end ArrayDotDiv12;

end Div;


package Pow
	
model ArrayDotPow1
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .^ { 10, 20 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayDotPow1",
			description="Scalarization of element-wise exponentiation:",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayDotPow1
 constant Real x[1] = 1.0;
 constant Real x[2] = 1048576.0;
 constant Real y[1] = 1;
 constant Real y[2] = 2;
end ArrayTests.Algebra.Pow.ArrayDotPow1;
")})));
end ArrayDotPow1;


model ArrayDotPow2
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y .^ { { 10, 20 }, { 30, 40 } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayDotPow2",
			description="Scalarization of element-wise exponentiation:",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayDotPow2
 constant Real x[1,1] = 1.0;
 constant Real x[1,2] = 1048576.0;
 constant Real x[2,1] = 2.05891132094649E14;
 constant Real x[2,2] = 1.2089258196146292E24;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Pow.ArrayDotPow2;
")})));
end ArrayDotPow2;


model ArrayDotPow3
 Real x[2,2,2];
 Real y[2,2,2] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };
equation
 x = y .^ { { { 10, 20 }, { 30, 40 } }, { { 50, 60 }, { 70, 80 } } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayDotPow3",
			description="Scalarization of element-wise exponentiation:",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayDotPow3
 constant Real x[1,1,1] = 1.0;
 constant Real x[1,1,2] = 1048576.0;
 constant Real x[1,2,1] = 2.05891132094649E14;
 constant Real x[1,2,2] = 1.2089258196146292E24;
 constant Real x[2,1,1] = 8.881784197001253E34;
 constant Real x[2,1,2] = 4.887367798068926E46;
 constant Real x[2,2,1] = 1.4350360160986845E59;
 constant Real x[2,2,2] = 1.7668470647783843E72;
 constant Real y[1,1,1] = 1;
 constant Real y[1,1,2] = 2;
 constant Real y[1,2,1] = 3;
 constant Real y[1,2,2] = 4;
 constant Real y[2,1,1] = 5;
 constant Real y[2,1,2] = 6;
 constant Real y[2,2,1] = 7;
 constant Real y[2,2,2] = 8;
end ArrayTests.Algebra.Pow.ArrayDotPow3;
")})));
end ArrayDotPow3;


model ArrayDotPow4
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .^ 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayDotPow4",
			description="Scalarization of element-wise exponentiation:",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayDotPow4
 constant Real x[1] = 1.0;
 constant Real x[2] = 1024.0;
 constant Real y[1] = 1;
 constant Real y[2] = 2;
end ArrayTests.Algebra.Pow.ArrayDotPow4;
")})));
end ArrayDotPow4;


model ArrayDotPow5
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation
 x = y .^ 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayDotPow5",
			description="Scalarization of element-wise exponentiation:",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayDotPow5
 constant Real x[1,1] = 1.0;
 constant Real x[1,2] = 1024.0;
 constant Real x[2,1] = 59049.0;
 constant Real x[2,2] = 1048576.0;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Pow.ArrayDotPow5;
")})));
end ArrayDotPow5;


model ArrayDotPow6
 Real x[2,2,2];
 Real y[2,2,2] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };
equation
 x = y .^ 10;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayDotPow6",
			description="Scalarization of element-wise exponentiation:",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayDotPow6
 constant Real x[1,1,1] = 1.0;
 constant Real x[1,1,2] = 1024.0;
 constant Real x[1,2,1] = 59049.0;
 constant Real x[1,2,2] = 1048576.0;
 constant Real x[2,1,1] = 9765625.0;
 constant Real x[2,1,2] = 6.0466176E7;
 constant Real x[2,2,1] = 2.82475249E8;
 constant Real x[2,2,2] = 1.073741824E9;
 constant Real y[1,1,1] = 1;
 constant Real y[1,1,2] = 2;
 constant Real y[1,2,1] = 3;
 constant Real y[1,2,2] = 4;
 constant Real y[2,1,1] = 5;
 constant Real y[2,1,2] = 6;
 constant Real y[2,2,1] = 7;
 constant Real y[2,2,2] = 8;
end ArrayTests.Algebra.Pow.ArrayDotPow6;
")})));
end ArrayDotPow6;


model ArrayDotPow7
 Real x[2];
 Real y = 1;
equation
 x = y .^ { 10, 20 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayDotPow7",
			description="Scalarization of element-wise exponentiation:",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayDotPow7
 constant Real x[1] = 1.0;
 constant Real x[2] = 1.0;
 constant Real y = 1;
end ArrayTests.Algebra.Pow.ArrayDotPow7;
")})));
end ArrayDotPow7;


model ArrayDotPow8
 Real x[2,2];
 Real y = 1;
equation
 x = y .^ { { 10, 20 }, { 30, 40 } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayDotPow8",
			description="Scalarization of element-wise exponentiation:",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayDotPow8
 constant Real x[1,1] = 1.0;
 constant Real x[1,2] = 1.0;
 constant Real x[2,1] = 1.0;
 constant Real x[2,2] = 1.0;
 constant Real y = 1;
end ArrayTests.Algebra.Pow.ArrayDotPow8;
")})));
end ArrayDotPow8;


model ArrayDotPow9
 Real x[2,2,2];
 Real y = 1;
equation
 x = y .^ { { { 10, 20 }, { 30, 40 } }, { { 50, 60 }, { 70, 80 } } };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayDotPow9",
			description="Scalarization of element-wise exponentiation:",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayDotPow9
 constant Real x[1,1,1] = 1.0;
 constant Real x[1,1,2] = 1.0;
 constant Real x[1,2,1] = 1.0;
 constant Real x[1,2,2] = 1.0;
 constant Real x[2,1,1] = 1.0;
 constant Real x[2,1,2] = 1.0;
 constant Real x[2,2,1] = 1.0;
 constant Real x[2,2,2] = 1.0;
 constant Real y = 1;
end ArrayTests.Algebra.Pow.ArrayDotPow9;
")})));
end ArrayDotPow9;


model ArrayDotPow10
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .^ { 10, 20, 30 };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Pow_ArrayDotPow10",
            description="Scalarization of element-wise exponentiation:",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4179, column 6:
  Type error in expression: y .^ {10, 20, 30}
    type of 'y' is Real[2]
    type of '{10, 20, 30}' is Integer[3]
")})));
end ArrayDotPow10;


model ArrayDotPow11
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .^ { { 10, 20 }, { 30, 40 } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Pow_ArrayDotPow11",
            description="Scalarization of element-wise exponentiation:",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4200, column 6:
  Type error in expression: y .^ {{10, 20}, {30, 40}}
    type of 'y' is Real[2]
    type of '{{10, 20}, {30, 40}}' is Integer[2, 2]
")})));
end ArrayDotPow11;


model ArrayDotPow12
 Real x[2];
 Real y[2] = { 1, 2 };
equation
 x = y .^ { "1", "2" };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Pow_ArrayDotPow12",
            description="Scalarization of element-wise exponentiation:",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4221, column 6:
  Type error in expression: y .^ {\"1\", \"2\"}
    type of 'y' is Real[2]
    type of '{\"1\", \"2\"}' is String[2]
")})));
end ArrayDotPow12;



model ArrayPow1
 Real x[2,2] = { { 1, 2 }, { 3, 4 } } ^ 0;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayPow1",
			description="Scalarization of element-wise exponentiation: Integer[2,2] ^ 0",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayPow1
 constant Real x[1,1] = 1;
 constant Real x[1,2] = 0;
 constant Real x[2,1] = 0;
 constant Real x[2,2] = 1;
end ArrayTests.Algebra.Pow.ArrayPow1;
")})));
end ArrayPow1;


model ArrayPow2
 Real x[2,2] = { { 1, 2 }, { 3, 4 } } ^ 1;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayPow2",
			description="Scalarization of element-wise exponentiation: Integer[2,2] ^ 1",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayPow2
 constant Real x[1,1] = 1;
 constant Real x[1,2] = 2;
 constant Real x[2,1] = 3;
 constant Real x[2,2] = 4;
end ArrayTests.Algebra.Pow.ArrayPow2;
")})));
end ArrayPow2;


model ArrayPow3
 Real x[2,2] = { { 1, 2 }, { 3, 4 } } ^ 2;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayPow3",
			description="Scalarization of element-wise exponentiation: Integer[2,2] ^ 2",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayPow3
 constant Real x[1,1] = 7;
 constant Real x[1,2] = 10;
 constant Real x[2,1] = 15;
 constant Real x[2,2] = 22;
end ArrayTests.Algebra.Pow.ArrayPow3;
")})));
end ArrayPow3;


model ArrayPow4
 Real x[2,2] = { { 1, 2 }, { 3, 4 } } ^ 3;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayPow4",
			description="Scalarization of element-wise exponentiation: Integer[2,2] ^ 3",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayPow4
 constant Real x[1,1] = 37;
 constant Real x[1,2] = 54;
 constant Real x[2,1] = 81;
 constant Real x[2,2] = 118;
end ArrayTests.Algebra.Pow.ArrayPow4;
")})));
end ArrayPow4;


model ArrayPow5
 Real x[3,3] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } } ^ 2;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayPow5",
			description="Scalarization of element-wise exponentiation: Integer[3,3] ^ 2",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayPow5
 constant Real x[1,1] = 30;
 constant Real x[1,2] = 36;
 constant Real x[1,3] = 42;
 constant Real x[2,1] = 66;
 constant Real x[2,2] = 81;
 constant Real x[2,3] = 96;
 constant Real x[3,1] = 102;
 constant Real x[3,2] = 126;
 constant Real x[3,3] = 150;
end ArrayTests.Algebra.Pow.ArrayPow5;
")})));
end ArrayPow5;


model ArrayPow6
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation 
 x = y ^ 2;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayPow6",
			description="Scalarization of element-wise exponentiation: component Real[2,2] ^ 2",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayPow6
 constant Real x[1,1] = 7.0;
 constant Real x[1,2] = 10.0;
 constant Real x[2,1] = 15.0;
 constant Real x[2,2] = 22.0;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Pow.ArrayPow6;
")})));
end ArrayPow6;


model ArrayPow7
 Real x[2,2];
 Real y[2,2] = { { 1, 2 }, { 3, 4 } };
equation 
 x = y ^ 0;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayPow7",
			description="Scalarization of element-wise exponentiation:component Real[2,2] ^ 0",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayPow7
 constant Real x[1,1] = 1;
 constant Real x[1,2] = 0;
 constant Real x[2,1] = 0;
 constant Real x[2,2] = 1;
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
end ArrayTests.Algebra.Pow.ArrayPow7;
")})));
end ArrayPow7;


model ArrayPow8
 Real x[2,2] = { { 1, 2 }, { 3, 4 } } ^ (-1);

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Pow_ArrayPow8",
            description="Scalarization of element-wise exponentiation: Integer[2,2] ^ (negative Integer)",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4385, column 16:
  Type error in expression: {{1, 2}, {3, 4}} ^ -1
    type of '{{1, 2}, {3, 4}}' is Integer[2, 2]
    type of '-1' is Integer
")})));
end ArrayPow8;


model ArrayPow9
 Real x[2,2] = { { 1, 2 }, { 3, 4 } } ^ 1.0;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Pow_ArrayPow9",
            description="Scalarization of element-wise exponentiation: Integer[2,2] ^ Real",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4403, column 16:
  Type error in expression: {{1, 2}, {3, 4}} ^ 1.0
    type of '{{1, 2}, {3, 4}}' is Integer[2, 2]
    type of '1.0' is Real
")})));
end ArrayPow9;


model ArrayPow10
 Real x[2,2] = { { 1, 2 }, { 3, 4 } } ^ { { 1, 2 }, { 3, 4 } };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Pow_ArrayPow10",
            description="Scalarization of element-wise exponentiation: Integer[2,2] ^ Integer[2,2]",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4421, column 16:
  Type error in expression: {{1, 2}, {3, 4}} ^ {{1, 2}, {3, 4}}
    type of '{{1, 2}, {3, 4}}' is Integer[2, 2]
    type of '{{1, 2}, {3, 4}}' is Integer[2, 2]
")})));
end ArrayPow10;


model ArrayPow11
 Real x[2,3] = { { 1, 2 }, { 3, 4 }, { 5, 6 } } ^ 2;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Pow_ArrayPow11",
            description="Scalarization of element-wise exponentiation: Integer[2,3] ^ 2",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4439, column 16:
  Type error in expression: {{1, 2}, {3, 4}, {5, 6}} ^ 2
    type of '{{1, 2}, {3, 4}, {5, 6}}' is Integer[3, 2]
    type of '2' is Integer
")})));
end ArrayPow11;


model ArrayPow12
 Real x[2,2] = { { 1, 2 }, { 3, 4 } } ^ y;
 Integer y = 2;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Pow_ArrayPow12",
            description="Scalarization of element-wise exponentiation: Real[2,2] ^ Integer component",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4457, column 16:
  Type error in expression: {{1, 2}, {3, 4}} ^ y
    type of '{{1, 2}, {3, 4}}' is Integer[2, 2]
    type of 'y' is Integer
")})));
end ArrayPow12;


model ArrayPow13
 Real x[2,2] = { { 1, 2 }, { 3, 4 } } ^ y;
 constant Integer y = 2;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayPow13",
			description="Scalarization of element-wise exponentiation: Real[2,2] ^ constant Integer component",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayPow13
 constant Real x[1,1] = 7;
 constant Real x[1,2] = 10;
 constant Real x[2,1] = 15;
 constant Real x[2,2] = 22;
 constant Integer y = 2;
end ArrayTests.Algebra.Pow.ArrayPow13;
")})));
end ArrayPow13;


model ArrayPow14
 Real x[2,2] = { { 1, 2 }, { 3, 4 } } ^ y;
 parameter Integer y = 2;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Pow_ArrayPow14",
            description="Scalarization of element-wise exponentiation: Real[2,2] ^ parameter Integer component",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4496, column 16:
  Type error in expression: {{1, 2}, {3, 4}} ^ y
    type of '{{1, 2}, {3, 4}}' is Integer[2, 2]
    type of 'y' is Integer
")})));
end ArrayPow14;


model ArrayPow15
 Real x[1,1] = { { 1 } } ^ 2;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayPow15",
			description="Scalarization of element-wise exponentiation: Integer[1,1] ^ 2",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayPow15
 constant Real x[1,1] = 1;
end ArrayTests.Algebra.Pow.ArrayPow15;
")})));
end ArrayPow15;


model ArrayPow16
 Real x[1] = { 1 } ^ 2;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Pow_ArrayPow16",
            description="Scalarization of element-wise exponentiation: Integer[1] ^ 2",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4530, column 14:
  Type error in expression: {1} ^ 2
    type of '{1}' is Integer[1]
    type of '2' is Integer
")})));
end ArrayPow16;


model ArrayPow17
 Real x = 1 ^ 2;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Pow_ArrayPow17",
			description="Scalarization of element-wise exponentiation: Integer ^ 2",
			flatModel="
fclass ArrayTests.Algebra.Pow.ArrayPow17
 constant Real x = 1.0;
end ArrayTests.Algebra.Pow.ArrayPow17;
")})));
end ArrayPow17;

end Pow;


package Neg
    
model ArrayNeg1
 Integer x[3] = -{ 1, 0, -1 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Neg_ArrayNeg1",
			description="Scalarization of negation: array of Integer (literal)",
			flatModel="
fclass ArrayTests.Algebra.Neg.ArrayNeg1
 constant Integer x[1] = -1;
 constant Integer x[2] = 0;
 constant Integer x[3] = 1;
end ArrayTests.Algebra.Neg.ArrayNeg1;
")})));
end ArrayNeg1;


model ArrayNeg2
 Integer x[3] = -y;
 Integer y[3] = { 1, 0, -1 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Neg_ArrayNeg2",
			description="Scalarization of negation: array of Integer (variable)",
			eliminate_alias_variables=false,
			flatModel="
fclass ArrayTests.Algebra.Neg.ArrayNeg2
 constant Integer x[1] = -1;
 constant Integer x[2] = 0;
 constant Integer x[3] = 1;
 constant Integer y[1] = 1;
 constant Integer y[2] = 0;
 constant Integer y[3] = -1;
end ArrayTests.Algebra.Neg.ArrayNeg2;
")})));
end ArrayNeg2;


model ArrayNeg3
 Integer x[3] = y;
 constant Integer y[3] = -{ 1, 0, -1 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Algebra_Neg_ArrayNeg3",
			description="Scalarization of negation: constant evaluation",
			flatModel="
fclass ArrayTests.Algebra.Neg.ArrayNeg3
 constant Integer x[1] = -1;
 constant Integer x[2] = 0;
 constant Integer x[3] = 1;
 constant Integer y[1] = - 1;
 constant Integer y[2] = 0;
 constant Integer y[3] = 1;
end ArrayTests.Algebra.Neg.ArrayNeg3;
")})));
end ArrayNeg3;


model ArrayNeg4
 Boolean x[2] = -{ true, false };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Neg_ArrayNeg4",
            description="Scalarization of negation: -Boolean[2] (literal)",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4651, column 17:
  Type error in expression: - {true, false}
    type of '{true, false}' is Boolean[2]
")})));
end ArrayNeg4;


model ArrayNeg5
 Boolean x[2] = -y;
 Boolean y[2] = { true, false };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Algebra_Neg_ArrayNeg5",
            description="Scalarization of negation: -Boolean[2] (component)",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4668, column 17:
  Type error in expression: - y
    type of 'y' is Boolean[2]
")})));
end ArrayNeg5;

end Neg;

end Algebra;



package Logical
	
package And

model ArrayAnd1
 Boolean x[2] = { true, true } and { true, false };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Logical_And_ArrayAnd1",
			description="Scalarization of logical and: arrays of Booleans (literal)",
			flatModel="
fclass ArrayTests.Logical.And.ArrayAnd1
 constant Boolean x[1] = true;
 constant Boolean x[2] = false;
end ArrayTests.Logical.And.ArrayAnd1;
")})));
end ArrayAnd1;

model ArrayAnd2
 Boolean y[2] = { true, false };
 Boolean x[2] = { true, true } and y;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Logical_And_ArrayAnd2",
			description="Scalarization of logical and: arrays of Booleans (component)",
			flatModel="
fclass ArrayTests.Logical.And.ArrayAnd2
 constant Boolean y[1] = true;
 constant Boolean y[2] = false;
 constant Boolean x[1] = true;
 constant Boolean x[2] = false;
end ArrayTests.Logical.And.ArrayAnd2;
")})));
end ArrayAnd2;


model ArrayAnd3
 Boolean x[2] = { true, true } and { true, false, true };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Logical_And_ArrayAnd3",
            description="Scalarization of logical and: different array sizes (literal)",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4729, column 17:
  Type error in expression: {true, true} and {true, false, true}
    type of '{true, true}' is Boolean[2]
    type of '{true, false, true}' is Boolean[3]
")})));
end ArrayAnd3;


model ArrayAnd4
 Boolean y[3] = { true, false, true };
 Boolean x[2] = { true, true } and y;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Logical_And_ArrayAnd4",
            description="Scalarization of logical and: different array sizes (component)",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4748, column 17:
  Type error in expression: {true, true} and y
    type of '{true, true}' is Boolean[2]
    type of 'y' is Boolean[3]
")})));
end ArrayAnd4;


model ArrayAnd5
 Boolean x[2] = { true, true } and true;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Logical_And_ArrayAnd5",
            description="Scalarization of logical and: array and scalar (literal)",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4766, column 17:
  Type error in expression: {true, true} and true
    type of '{true, true}' is Boolean[2]
    type of 'true' is Boolean
")})));
end ArrayAnd5;


model ArrayAnd6
 Boolean y = true;
 Boolean x[2] = { true, true } and y;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Logical_And_ArrayAnd6",
            description="Scalarization of logical and: array and scalar (component)",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4785, column 17:
  Type error in expression: {true, true} and y
    type of '{true, true}' is Boolean[2]
    type of 'y' is Boolean
")})));
end ArrayAnd6;


model ArrayAnd7
 Integer x[2] = { 1, 1 } and { 1, 0 };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Logical_And_ArrayAnd7",
            description="Scalarization of logical and: Integer[2] and Integer[2] (literal)",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4803, column 17:
  Type error in expression: {1, 1} and {1, 0}
    type of '{1, 1}' is Integer[2]
    type of '{1, 0}' is Integer[2]
")})));
end ArrayAnd7;


model ArrayAnd8
 Integer y[2] = { 1, 0 };
 Integer x[2] = { 1, 1 } and y;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Logical_And_ArrayAnd8",
            description="Scalarization of logical and: Integer[2] and Integer[2] (component)",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4822, column 17:
  Type error in expression: {1, 1} and y
    type of '{1, 1}' is Integer[2]
    type of 'y' is Integer[2]
")})));
end ArrayAnd8;


model ArrayAnd9
 constant Boolean y[3] = { true, false, false } and { true, true, false };
 Boolean x[3] = y;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Logical_And_ArrayAnd9",
			description="Scalarization of logical and: constant evaluation",
			flatModel="
fclass ArrayTests.Logical.And.ArrayAnd9
 constant Boolean y[1] = true;
 constant Boolean y[2] = false;
 constant Boolean y[3] = false;
 constant Boolean x[1] = true;
 constant Boolean x[2] = false;
 constant Boolean x[3] = false;
end ArrayTests.Logical.And.ArrayAnd9;
")})));
end ArrayAnd9;

end And;


package Or
	
model ArrayOr1
 Boolean x[2] = { true, true } or { true, false };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Logical_Or_ArrayOr1",
			description="Scalarization of logical or: arrays of Booleans (literal)",
			flatModel="
fclass ArrayTests.Logical.Or.ArrayOr1
 constant Boolean x[1] = true;
 constant Boolean x[2] = true;
end ArrayTests.Logical.Or.ArrayOr1;
")})));
end ArrayOr1;


model ArrayOr2
 Boolean y[2] = { true, false };
 Boolean x[2] = { true, true } or y;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Logical_Or_ArrayOr2",
			description="Scalarization of logical or: arrays of Booleans (component)",
			flatModel="
fclass ArrayTests.Logical.Or.ArrayOr2
 constant Boolean y[1] = true;
 constant Boolean y[2] = false;
 constant Boolean x[1] = true;
 constant Boolean x[2] = true;
end ArrayTests.Logical.Or.ArrayOr2;
")})));
end ArrayOr2;


model ArrayOr3
 Boolean x[2] = { true, true } or { true, false, true };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Logical_Or_ArrayOr3",
            description="Scalarization of logical or: different array sizes (literal)",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4900, column 17:
  Type error in expression: {true, true} or {true, false, true}
    type of '{true, true}' is Boolean[2]
    type of '{true, false, true}' is Boolean[3]
")})));
end ArrayOr3;


model ArrayOr4
 Boolean y[3] = { true, false, true };
 Boolean x[2] = { true, true } or y;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Logical_Or_ArrayOr4",
            description="Scalarization of logical or: different array sizes (component)",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4919, column 17:
  Type error in expression: {true, true} or y
    type of '{true, true}' is Boolean[2]
    type of 'y' is Boolean[3]
")})));
end ArrayOr4;


model ArrayOr5
 Boolean x[2] = { true, true } or true;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Logical_Or_ArrayOr5",
            description="Scalarization of logical or: array and scalar (literal)",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4937, column 17:
  Type error in expression: {true, true} or true
    type of '{true, true}' is Boolean[2]
    type of 'true' is Boolean
")})));
end ArrayOr5;


model ArrayOr6
 Boolean y = true;
 Boolean x[2] = { true, true } or y;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Logical_Or_ArrayOr6",
            description="Scalarization of logical or: array and scalar (component)",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4956, column 17:
  Type error in expression: {true, true} or y
    type of '{true, true}' is Boolean[2]
    type of 'y' is Boolean
")})));
end ArrayOr6;


model ArrayOr7
 Integer x[2] = { 1, 1 } or { 1, 0 };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Logical_Or_ArrayOr7",
            description="Scalarization of logical or: Integer[2] or Integer[2] (literal)",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4974, column 17:
  Type error in expression: {1, 1} or {1, 0}
    type of '{1, 1}' is Integer[2]
    type of '{1, 0}' is Integer[2]
")})));
end ArrayOr7;


model ArrayOr8
 Integer y[2] = { 1, 0 };
 Integer x[2] = { 1, 1 } or y;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Logical_Or_ArrayOr8",
            description="Scalarization of logical or: Integer[2] or Integer[2] (component)",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 4993, column 17:
  Type error in expression: {1, 1} or y
    type of '{1, 1}' is Integer[2]
    type of 'y' is Integer[2]
")})));
end ArrayOr8;


model ArrayOr9
 constant Boolean y[3] = { true, true, false } or { true, false, false };
 Boolean x[3] = y;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Logical_Or_ArrayOr9",
			description="Scalarization of logical or: constant evaluation",
			flatModel="
fclass ArrayTests.Logical.Or.ArrayOr9
 constant Boolean y[1] = true;
 constant Boolean y[2] = true;
 constant Boolean y[3] = false;
 constant Boolean x[1] = true;
 constant Boolean x[2] = true;
 constant Boolean x[3] = false;
end ArrayTests.Logical.Or.ArrayOr9;
")})));
end ArrayOr9;

end Or;



package Not
	
model ArrayNot1
 Boolean x[2] = not { true, false };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Logical_Not_ArrayNot1",
			description="Scalarization of logical not: array of Boolean (literal)",
			flatModel="
fclass ArrayTests.Logical.Not.ArrayNot1
 constant Boolean x[1] = false;
 constant Boolean x[2] = true;
end ArrayTests.Logical.Not.ArrayNot1;
")})));
end ArrayNot1;


model ArrayNot2
 Boolean x[2] = not y;
 Boolean y[2] = { true, false };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Logical_Not_ArrayNot2",
			description="Scalarization of logical not: array of Boolean (component)",
			flatModel="
fclass ArrayTests.Logical.Not.ArrayNot2
 constant Boolean x[1] = false;
 constant Boolean x[2] = true;
 constant Boolean y[1] = true;
 constant Boolean y[2] = false;
end ArrayTests.Logical.Not.ArrayNot2;
")})));
end ArrayNot2;


model ArrayNot3
 Boolean x[2] = y;
 constant Boolean y[2] = not { true, false };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Logical_Not_ArrayNot3",
			description="Scalarization of logical not: constant evaluation",
			flatModel="
fclass ArrayTests.Logical.Not.ArrayNot3
 constant Boolean x[1] = false;
 constant Boolean x[2] = true;
 constant Boolean y[1] = false;
 constant Boolean y[2] = true;
end ArrayTests.Logical.Not.ArrayNot3;
")})));
end ArrayNot3;


model ArrayNot4
 Integer x[2] = not { 1, 0 };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Logical_Not_ArrayNot4",
            description="Scalarization of logical not: not Integer[2] (literal)",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 5091, column 17:
  Type error in expression: not {1, 0}
    type of '{1, 0}' is Integer[2]
")})));
end ArrayNot4;


model ArrayNot5
 Integer x[2] = not y;
 Integer y[2] = { 1, 0 };

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Logical_Not_ArrayNot5",
            description="Scalarization of logical or: not Integer[2] (component)",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 5108, column 17:
  Type error in expression: not y
    type of 'y' is Integer[2]
")})));
end ArrayNot5;

end Not;

end Logical;



package Constructors

package LongForm
	
model LongArrayForm1
 Real x[3] = array(1, 2, 3);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="Constructors_LongForm_LongArrayForm1",
			description="Long form of array constructor",
			flatModel="
fclass ArrayTests.Constructors.LongForm.LongArrayForm1
 Real x[3] = array(1, 2, 3);
end ArrayTests.Constructors.LongForm.LongArrayForm1;
")})));
end LongArrayForm1;


model LongArrayForm2
 Real x[3] = array(1, 2, 3);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Constructors_LongForm_LongArrayForm2",
			description="Long form of array constructor",
			flatModel="
fclass ArrayTests.Constructors.LongForm.LongArrayForm2
 constant Real x[1] = 1;
 constant Real x[2] = 2;
 constant Real x[3] = 3;
end ArrayTests.Constructors.LongForm.LongArrayForm2;
")})));
end LongArrayForm2;


model LongArrayForm3
 Real x1[3] = array(1,2,3);
 Real x2[3] = {4,5,6};
 Real x3[3,3] = array(x1,x2,{7,8,9});

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="LongArrayForm3",
			description="Long form of array constructor, array component parts",
			flatModel="
fclass ArrayTests.Constructors.LongForm.LongArrayForm3
 Real x1[3] = array(1,2,3);
 Real x2[3] = {4,5,6};
 Real x3[3,3] = array(x1[1:3],x2[1:3],{7,8,9});

end ArrayTests.Constructors.LongForm.LongArrayForm3;
")})));
end LongArrayForm3;


model LongArrayForm4
 Real x1[3] = array(1,2,3);
 Real x2[3] = {4,5,6};
 Real x3[3,3] = array(x1,x2,{7,8,9});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Constructors_LongForm_LongArrayForm4",
			description="Long form of array constructor, array component parts",
			flatModel="
fclass ArrayTests.Constructors.LongForm.LongArrayForm4
 constant Real x3[1,1] = 1;
 constant Real x3[1,2] = 2;
 constant Real x3[1,3] = 3;
 constant Real x3[2,1] = 4;
 constant Real x3[2,2] = 5;
 constant Real x3[2,3] = 6;
 constant Real x3[3,1] = 7;
 constant Real x3[3,2] = 8;
 constant Real x3[3,3] = 9;
 constant Real x1[1] = 1;
 constant Real x1[2] = 2;
 constant Real x1[3] = 3;
 constant Real x2[1] = 4;
 constant Real x2[2] = 5;
 constant Real x2[3] = 6;
end ArrayTests.Constructors.LongForm.LongArrayForm4;
")})));
end LongArrayForm4;

end LongForm;


package EmptyArray
	
model EmptyArray1
    Real x[3,0] = zeros(3,0);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="EmptyArray1",
			description="Empty arrays, basic test",
			flatModel="
fclass ArrayTests.Constructors.EmptyArray.EmptyArray1

end ArrayTests.Constructors.EmptyArray.EmptyArray1;
")})));
end EmptyArray1;


model EmptyArray2
    Real x[3,0] = zeros(3,0);
    Real y[3,0] = zeros(3,0);
    Real z[3,0] = x + y;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="EmptyArray2",
			description="Empty arrays, addition",
			flatModel="
fclass ArrayTests.Constructors.EmptyArray.EmptyArray2

end ArrayTests.Constructors.EmptyArray.EmptyArray2;
")})));
end EmptyArray2;


model EmptyArray3
    Real x[2,2] = {{1,2},{3,4}};
    Real y[2,0] = ones(2,0);
    Real z[0,2] = ones(0,2);
    Real w[0,0] = ones(0,0);
    Real xx[2,2] = [x, y; z, w];

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Constructors_EmptyArray_EmptyArray3",
			description="Empty arrays, concatenation",
			flatModel="
fclass ArrayTests.Constructors.EmptyArray.EmptyArray3
 constant Real xx[1,1] = 1;
 constant Real xx[1,2] = 2;
 constant Real xx[2,1] = 3;
 constant Real xx[2,2] = 4;
 constant Real x[1,1] = 1;
 constant Real x[1,2] = 2;
 constant Real x[2,1] = 3;
 constant Real x[2,2] = 4;
end ArrayTests.Constructors.EmptyArray.EmptyArray3;
")})));
end EmptyArray3;


model EmptyArray4
    Real x[2,0] = {{1,2},{3,4}} * ones(2,0);
    Real y[2,2] = ones(2,0) * ones(0,2);
    Real z[0,0] = ones(0,2) * ones(2,0);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Constructors_EmptyArray_EmptyArray4",
			description="Empty arrays, multiplication",
			flatModel="
fclass ArrayTests.Constructors.EmptyArray.EmptyArray4
 constant Real y[1,1] = 0;
 constant Real y[1,2] = 0;
 constant Real y[2,1] = 0;
 constant Real y[2,2] = 0;
end ArrayTests.Constructors.EmptyArray.EmptyArray4;
")})));
end EmptyArray4;


model EmptyArray5
    parameter Integer n = 0;
    parameter Integer p = 2;
    parameter Integer q = 2;
    input Real u[p];
    Real x[n];
    Real y[q];
    parameter Real A[n,n] = ones(n,n);
    parameter Real B[n,p] = ones(n,p);
    parameter Real C[q,n] = ones(q,n);
    parameter Real D[q,p] = { i*j for i in 1:q, j in 1:p };
equation
    der(x) = A*x + B*u;
        y  = C*x + D*u;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Constructors_EmptyArray_EmptyArray5",
			description="Empty arrays, simple equation system",
			flatModel="
fclass ArrayTests.Constructors.EmptyArray.EmptyArray5
 structural parameter Integer n = 0 /* 0 */;
 structural parameter Integer p = 2 /* 2 */;
 structural parameter Integer q = 2 /* 2 */;
 input Real u[1];
 input Real u[2];
 Real y[1];
 Real y[2];
 structural parameter Real D[1,1] = 1 /* 1 */;
 structural parameter Real D[1,2] = 2 /* 2 */;
 structural parameter Real D[2,1] = 2 /* 2 */;
 structural parameter Real D[2,2] = 4 /* 4 */;
equation
 y[1] = u[1] + 2.0 * u[2];
 y[2] = 2.0 * u[1] + 4.0 * u[2];
end ArrayTests.Constructors.EmptyArray.EmptyArray5;
")})));
end EmptyArray5;

end EmptyArray;


package Iterators

model ArrayIterTest1
 Real x[3,3] = {i * j for i in 1:3, j in {2,3,5}};

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Constructors_Iterators_ArrayIterTest1",
			description="Array constructor with iterators: over scalar exp",
			flatModel="
fclass ArrayTests.Constructors.Iterators.ArrayIterTest1
 constant Real x[1,1] = 2;
 constant Real x[1,2] = 4;
 constant Real x[1,3] = 6;
 constant Real x[2,1] = 3;
 constant Real x[2,2] = 6;
 constant Real x[2,3] = 9;
 constant Real x[3,1] = 5;
 constant Real x[3,2] = 10;
 constant Real x[3,3] = 15;
end ArrayTests.Constructors.Iterators.ArrayIterTest1;
")})));
end ArrayIterTest1;


model ArrayIterTest2
 Real x[2,2,2] = {{i * i, j} for i in 1:2, j in {2,5}};

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Constructors_Iterators_ArrayIterTest2",
			description="Array constructor with iterators: over array exp",
			flatModel="
fclass ArrayTests.Constructors.Iterators.ArrayIterTest2
 constant Real x[1,1,1] = 1;
 constant Real x[1,1,2] = 2;
 constant Real x[1,2,1] = 4;
 constant Real x[1,2,2] = 2;
 constant Real x[2,1,1] = 1;
 constant Real x[2,1,2] = 5;
 constant Real x[2,2,1] = 4;
 constant Real x[2,2,2] = 5;
end ArrayTests.Constructors.Iterators.ArrayIterTest2;
")})));
end ArrayIterTest2;


model ArrayIterTest3
 Real i = 1;
 Real x[2,2,2,2] = { { { {i, j} for j in 1:2 } for i in 3:4 } for i in 5:6 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Constructors_Iterators_ArrayIterTest3",
			description="Array constructor with iterators: nestled constructors, masking index",
			flatModel="
fclass ArrayTests.Constructors.Iterators.ArrayIterTest3
 constant Real i = 1;
 constant Real x[1,1,1,1] = 3;
 constant Real x[1,1,1,2] = 1;
 constant Real x[1,1,2,1] = 3;
 constant Real x[1,1,2,2] = 2;
 constant Real x[1,2,1,1] = 4;
 constant Real x[1,2,1,2] = 1;
 constant Real x[1,2,2,1] = 4;
 constant Real x[1,2,2,2] = 2;
 constant Real x[2,1,1,1] = 3;
 constant Real x[2,1,1,2] = 1;
 constant Real x[2,1,2,1] = 3;
 constant Real x[2,1,2,2] = 2;
 constant Real x[2,2,1,1] = 4;
 constant Real x[2,2,1,2] = 1;
 constant Real x[2,2,2,1] = 4;
 constant Real x[2,2,2,2] = 2;
end ArrayTests.Constructors.Iterators.ArrayIterTest3;
")})));
end ArrayIterTest3;


model ArrayIterTest4
 Real x[1,1,1] = { {1} for i in {1}, j in {1} };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Constructors_Iterators_ArrayIterTest4",
			description="Array constructor with iterators: vectors of length 1",
			flatModel="
fclass ArrayTests.Constructors.Iterators.ArrayIterTest4
 constant Real x[1,1,1] = 1;
end ArrayTests.Constructors.Iterators.ArrayIterTest4;
")})));
end ArrayIterTest4;


model ArrayIterTest5
    function f
    algorithm
    end f;
    
    Real x[3] = { f() for i in 1:3 };

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayIterTest5",
			description="Iterated expression with bad size",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 1960, column 16:
  Function f() has no outputs, but is used in expression
")})));
end ArrayIterTest5;


model ArrayIterTest6
    Real x[3,2] = { { 2 * i for i in 1:2 }, { i * i for i in 2:3 }, { 1, 2 } } * time;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="Constructors_Iterators_ArrayIterTest6",
            description="Iteration expressions as members of array constructor",
            flatModel="
fclass ArrayTests.Constructors.Iterators.ArrayIterTest6
 Real x[1,1];
 Real x[1,2];
 Real x[2,1];
 Real x[2,2];
 Real x[3,1];
 Real x[3,2];
equation
 x[1,1] = 2 * time;
 x[1,2] = 4 * time;
 x[2,1] = 4 * time;
 x[2,2] = 9 * time;
 x[3,1] = time;
 x[3,2] = 2 * time;
end ArrayTests.Constructors.Iterators.ArrayIterTest6;
")})));
end ArrayIterTest6;

model ArrayIterTest7
    record R
        Real a;
        Real b;
    end R;
    
    function f1
        input Real x;
        output R y;
    algorithm
        y := R(x, x+1);
    end f1;
    
    Real z[2] = time * {1, 2};
    R w[2] = { f1(z[i]) for i in 1:2 };
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="Constructors_Iterators_ArrayIterTest7",
            description="Iteration expressions with generated temporaries",
            inline_functions="none",
            flatModel="
fclass ArrayTests.Constructors.Iterators.ArrayIterTest7
 Real z[1];
 Real z[2];
 Real w[1].a;
 Real w[1].b;
 Real w[2].a;
 Real w[2].b;
equation
 z[1] = time;
 z[2] = time * 2;
 (ArrayTests.Constructors.Iterators.ArrayIterTest7.R(w[1].a, w[1].b)) = ArrayTests.Constructors.Iterators.ArrayIterTest7.f1(z[1]);
 (ArrayTests.Constructors.Iterators.ArrayIterTest7.R(w[2].a, w[2].b)) = ArrayTests.Constructors.Iterators.ArrayIterTest7.f1(z[2]);

public
 function ArrayTests.Constructors.Iterators.ArrayIterTest7.f1
  input Real x;
  output ArrayTests.Constructors.Iterators.ArrayIterTest7.R y;
 algorithm
  y.a := x;
  y.b := x + 1;
  return;
 end ArrayTests.Constructors.Iterators.ArrayIterTest7.f1;

 record ArrayTests.Constructors.Iterators.ArrayIterTest7.R
  Real a;
  Real b;
 end ArrayTests.Constructors.Iterators.ArrayIterTest7.R;

end ArrayTests.Constructors.Iterators.ArrayIterTest7;
")})));
end ArrayIterTest7;

model ArrayIterTest8
    record R
        Real a;
        Real b;
    end R;
    
    function f1
        input Real x;
        output R y;
    algorithm
        y := R(x, x+1);
    end f1;
    
    function f2
        input R x;
        output Real y;
    algorithm
        y := x.a * x.b;
    end f2;
    
    Real z[2] = time * {1, 2};
    Real w[2] = { f2(f1(z[i])) for i in 1:2 };
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="Constructors_Iterators_ArrayIterTest8",
            description="Iteration expressions with generated temporaries",
            inline_functions="none",
            flatModel="
fclass ArrayTests.Constructors.Iterators.ArrayIterTest8
 Real z[1];
 Real z[2];
 Real w[1];
 Real w[2];
 Real temp_1[1].a;
 Real temp_1[1].b;
 Real temp_1[2].a;
 Real temp_1[2].b;
equation
 z[1] = time;
 z[2] = time * 2;
 (ArrayTests.Constructors.Iterators.ArrayIterTest8.R(temp_1[1].a, temp_1[1].b)) = ArrayTests.Constructors.Iterators.ArrayIterTest8.f1(z[1]);
 (ArrayTests.Constructors.Iterators.ArrayIterTest8.R(temp_1[2].a, temp_1[2].b)) = ArrayTests.Constructors.Iterators.ArrayIterTest8.f1(z[2]);
 w[1] = ArrayTests.Constructors.Iterators.ArrayIterTest8.f2(ArrayTests.Constructors.Iterators.ArrayIterTest8.R(temp_1[1].a, temp_1[1].b));
 w[2] = ArrayTests.Constructors.Iterators.ArrayIterTest8.f2(ArrayTests.Constructors.Iterators.ArrayIterTest8.R(temp_1[2].a, temp_1[2].b));

public
 function ArrayTests.Constructors.Iterators.ArrayIterTest8.f2
  input ArrayTests.Constructors.Iterators.ArrayIterTest8.R x;
  output Real y;
 algorithm
  y := x.a * x.b;
  return;
 end ArrayTests.Constructors.Iterators.ArrayIterTest8.f2;

 function ArrayTests.Constructors.Iterators.ArrayIterTest8.f1
  input Real x;
  output ArrayTests.Constructors.Iterators.ArrayIterTest8.R y;
 algorithm
  y.a := x;
  y.b := x + 1;
  return;
 end ArrayTests.Constructors.Iterators.ArrayIterTest8.f1;

 record ArrayTests.Constructors.Iterators.ArrayIterTest8.R
  Real a;
  Real b;
 end ArrayTests.Constructors.Iterators.ArrayIterTest8.R;

end ArrayTests.Constructors.Iterators.ArrayIterTest8;
")})));
end ArrayIterTest8;

model ArrayIterTest9
    record R
        Real a;
        Real b;
    end R;
    
    function f1
        input Real x;
        output R y;
    algorithm
        y := R(x, x+1);
    end f1;
    
    function f2
        input Real[2] x;
        output R[2] y = { f1(x[i]) for i in 1:2 };
        algorithm
    end f2;
    
    Real z[2] = time * {1, 2};
    R w[2] = f2(z);
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="Constructors_Iterators_ArrayIterTest9",
            description="Iteration expressions with generated temporaries",
            inline_functions="none",
            flatModel="
fclass ArrayTests.Constructors.Iterators.ArrayIterTest9
 Real z[1];
 Real z[2];
 Real w[1].a;
 Real w[1].b;
 Real w[2].a;
 Real w[2].b;
equation
 z[1] = time;
 z[2] = time * 2;
 ({ArrayTests.Constructors.Iterators.ArrayIterTest9.R(w[1].a, w[1].b), ArrayTests.Constructors.Iterators.ArrayIterTest9.R(w[2].a, w[2].b)}) = ArrayTests.Constructors.Iterators.ArrayIterTest9.f2({z[1], z[2]});

public
 function ArrayTests.Constructors.Iterators.ArrayIterTest9.f2
  input Real[2] x;
  output ArrayTests.Constructors.Iterators.ArrayIterTest9.R[2] y;
  ArrayTests.Constructors.Iterators.ArrayIterTest9.R[2] temp_1;
 algorithm
  (temp_1[1]) := ArrayTests.Constructors.Iterators.ArrayIterTest9.f1(x[1]);
  (temp_1[2]) := ArrayTests.Constructors.Iterators.ArrayIterTest9.f1(x[2]);
  y[1].a := temp_1[1].a;
  y[1].b := temp_1[1].b;
  y[2].a := temp_1[2].a;
  y[2].b := temp_1[2].b;
  return;
 end ArrayTests.Constructors.Iterators.ArrayIterTest9.f2;

 function ArrayTests.Constructors.Iterators.ArrayIterTest9.f1
  input Real x;
  output ArrayTests.Constructors.Iterators.ArrayIterTest9.R y;
 algorithm
  y.a := x;
  y.b := x + 1;
  return;
 end ArrayTests.Constructors.Iterators.ArrayIterTest9.f1;

  record ArrayTests.Constructors.Iterators.ArrayIterTest9.R
  Real a;
  Real b;
 end ArrayTests.Constructors.Iterators.ArrayIterTest9.R;

end ArrayTests.Constructors.Iterators.ArrayIterTest9;
")})));
end ArrayIterTest9;


model ArrayIterTestUnknown1
    function f
		input Integer a;
		output Real x[:] = { i^2 for i in 1:a/2 };
    algorithm
    end f;
    
	Real x[3] = f(6);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Constructors_Iterators_ArrayIterTestUnknown1",
			description="Array constructor with iterators: vectors of length 1",
			variability_propagation=false,
			flatModel="
fclass ArrayTests.Constructors.Iterators.ArrayIterTestUnknown1
 Real x[1];
 Real x[2];
 Real x[3];
equation
 ({x[1], x[2], x[3]}) = ArrayTests.Constructors.Iterators.ArrayIterTestUnknown1.f(6);

public
 function ArrayTests.Constructors.Iterators.ArrayIterTestUnknown1.f
  input Integer a;
  output Real[:] x;
  Real[:] temp_1;
 algorithm
  size(x) := {max(integer(a / 2 - 1) + 1, 0)};
  size(temp_1) := {max(integer(a / 2 - 1) + 1, 0)};
  for i2 in 1:max(integer(a / 2 - 1) + 1, 0) loop
   temp_1[i2] := i2 ^ 2;
  end for;
  for i1 in 1:max(integer(a / 2 - 1) + 1, 0) loop
   x[i1] := temp_1[i1];
  end for;
  return;
 end ArrayTests.Constructors.Iterators.ArrayIterTestUnknown1.f;

end ArrayTests.Constructors.Iterators.ArrayIterTestUnknown1;
			
")})));
end ArrayIterTestUnknown1;

end Iterators;

end Constructors;



package For
	
model ForEquation1
 model A
  Real x[3];
 equation
  for i in 1:3 loop
   x[i] = i*i;
  end for;
 end A;
 
 A y;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ForEquation1",
			description="Flattening of for equations: for equ in a component",
			flatModel="
fclass ArrayTests.For.ForEquation1
 Real y.x[3];
equation
 for i in 1:3 loop
  y.x[i] = i * i;
 end for;
end ArrayTests.For.ForEquation1;
")})));
end ForEquation1;


model ForEquation2
    model A
        parameter Integer N;
        parameter Integer[N] rev = N:-1:1;
        Real[N] x;
        Real[N] y;
    equation
        for i in 1:N loop
            x[i] = y[rev[i]];
        end for;
    end A;
    
    A a(N=3, x={1,2,3});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="For_ForEquation2",
			description="",
			flatModel="
fclass ArrayTests.For.ForEquation2
 structural parameter Integer a.N = 3 /* 3 */;
 structural parameter Integer a.rev[1] = 3 /* 3 */;
 structural parameter Integer a.rev[2] = 2 /* 2 */;
 structural parameter Integer a.rev[3] = 1 /* 1 */;
 constant Real a.x[1] = 1;
 constant Real a.x[2] = 2;
 constant Real a.x[3] = 3;
 constant Real a.y[1] = 3;
 constant Real a.y[2] = 2;
 constant Real a.y[3] = 1;
end ArrayTests.For.ForEquation2;
")})));
end ForEquation2;


model ForEquation3
	function f
		input Real x;
		output Real y = x + 1;
	algorithm
	end f;
	
	parameter Integer n = 3;
	Real x[n];
equation
	for i in 1:n loop
		x[i] = f(sum(1.0:i));
	end for;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="For_ForEquation3",
			description="Array expressions depending on for loop index",
			flatModel="
fclass ArrayTests.For.ForEquation3
 structural parameter Integer n = 3 /* 3 */;
 constant Real x[1] = 2.0;
 constant Real x[2] = 4.0;
 constant Real x[3] = 7.0;
end ArrayTests.For.ForEquation3;
")})));
end ForEquation3;


model ForEquation4
    parameter Integer N = 3;
    Real x[N];
equation
    for i in 1:N loop
        der(x[i]) = if i == 1 then 1 else x[i-1];
    end for;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="For_ForEquation4",
			description="",
			flatModel="
fclass ArrayTests.For.ForEquation4
 structural parameter Integer N = 3 /* 3 */;
 Real x[1];
 Real x[2];
 Real x[3];
initial equation 
 x[1] = 0.0;
 x[2] = 0.0;
 x[3] = 0.0;
equation
 der(x[1]) = 1;
 der(x[2]) = x[1];
 der(x[3]) = x[2];
end ArrayTests.For.ForEquation4;
")})));
end ForEquation4;


model ForEquation5
    parameter Integer N = 5;
    parameter Real x[2,N] = {{1, 2, 3, 4, 3}, {0.1, 0.2, 0.1, 0.4, 0.5}};
equation
    for i in 1:N-1 loop
		if x[1,i] < x[1,i+1] then
			assert(x[2,i] < x[2,i+1], "x[:2] should rise when x[:1] rises");
        else
            assert(x[2,i] > x[2,i+1], "x[:2] should fall when x[:1] falls");
		end if;
    end for;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="For_ForEquation5",
			description="Test handling of if equation with parameter test using for index in expression in array index",
			errorMessage="
2 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 0, column 0:
  Assertion failed: x[:2] should fall when x[:1] falls
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 0, column 0:
  Assertion failed: x[:2] should rise when x[:1] rises
")})));
end ForEquation5;


model ForInitial1
  parameter Integer N = 3;
  Real x[N];
initial equation
  for i in 1:N loop
    der(x[i]) = 0;
  end for;
equation
  der(x) = -x;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ForInitial1",
			description="For equation in initial equation block",
			flatModel="
fclass ArrayTests.For.ForInitial1
 structural parameter Integer N = 3 /* 3 */;
 Real x[1];
 Real x[2];
 Real x[3];
initial equation 
 der(x[1]) = 0;
 der(x[2]) = 0;
 der(x[3]) = 0;
equation
 der(x[1]) = - x[1];
 der(x[2]) = - x[2];
 der(x[3]) = - x[3];
end ArrayTests.For.ForInitial1;
")})));
end ForInitial1;


model ForStructural1
	parameter Boolean[2] p = {true, false};
	Real[2] x;
equation
	for i in 1:2 loop
		if p[i] then
			x[i] = time;
        else
            x[i] = 1;
		end if;
	end for;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="For_ForStructural1",
			description="Check that for indices aren't converted to structural parameters",
			flatModel="
fclass ArrayTests.For.ForStructural1
 structural parameter Boolean p[2] = {true, false} /* { true, false } */;
 Real x[2];
equation
 for i in 1:2 loop
  if p[i] then
   x[i] = time;
  else
   x[i] = 1;
  end if;
 end for;
end ArrayTests.For.ForStructural1;
")})));
end ForStructural1;

model ForAlgorithm1
	function f
		input Real x;
		output Real y = x + 1;
	algorithm
	end f;
	
	constant Integer n = 3;
	Real x[n];
algorithm
	for i in 2:n + 1, j in 2:n+1 loop
		x[i-1] := f(sum(1.0:j));
	end for;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ForAlgorithm1",
			description="Array expressions depending on for loop index",
			flatModel="
fclass ArrayTests.For.ForAlgorithm1
 constant Integer n = 3;
 Real x[1];
 Real x[2];
 Real x[3];
algorithm
 x[1] := ArrayTests.For.ForAlgorithm1.f(1.0 + 2.0);
 x[1] := ArrayTests.For.ForAlgorithm1.f(1.0 + 2.0 + 3.0);
 x[1] := ArrayTests.For.ForAlgorithm1.f(1.0 + 2.0 + 3.0 + 4.0);
 x[2] := ArrayTests.For.ForAlgorithm1.f(1.0 + 2.0);
 x[2] := ArrayTests.For.ForAlgorithm1.f(1.0 + 2.0 + 3.0);
 x[2] := ArrayTests.For.ForAlgorithm1.f(1.0 + 2.0 + 3.0 + 4.0);
 x[3] := ArrayTests.For.ForAlgorithm1.f(1.0 + 2.0);
 x[3] := ArrayTests.For.ForAlgorithm1.f(1.0 + 2.0 + 3.0);
 x[3] := ArrayTests.For.ForAlgorithm1.f(1.0 + 2.0 + 3.0 + 4.0);

public
 function ArrayTests.For.ForAlgorithm1.f
  input Real x;
  output Real y;
 algorithm
  y := x + 1;
  return;
 end ArrayTests.For.ForAlgorithm1.f;

end ArrayTests.For.ForAlgorithm1;
")})));
end ForAlgorithm1;

end For;



package Slices
	
model SliceTest1
 model A
  Real a[2];
 end A;
 
 A x[2](a={{1,2},{3,4}});
 Real y[2,2] = x.a .+ 1;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="SliceTest1",
			description="Slice operations: basic test",
			flatModel="
fclass ArrayTests.Slices.SliceTest1
 Real x[1].a[2] = {1,2};
 Real x[2].a[2] = {3,4};
 Real y[2,2] = x[1:2].a[1:2] .+ 1;

end ArrayTests.Slices.SliceTest1;
")})));
end SliceTest1;


model SliceTest2
 model A
  Real a[2];
 end A;
 
 A x[2](a={{1,2},{3,4}});
 Real y[2,2] = x.a .+ 1;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Slices_SliceTest2",
			description="Slice operations: basic test",
			flatModel="
fclass ArrayTests.Slices.SliceTest2
 constant Real x[1].a[1] = 1;
 constant Real x[1].a[2] = 2;
 constant Real x[2].a[1] = 3;
 constant Real x[2].a[2] = 4;
 constant Real y[1,1] = 2.0;
 constant Real y[1,2] = 3.0;
 constant Real y[2,1] = 4.0;
 constant Real y[2,2] = 5.0;
end ArrayTests.Slices.SliceTest2;
")})));
end SliceTest2;


model SliceTest3
 model A
  Real a[4];
 end A;
 
 A x[4](a={{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}});
 Real y[2,2] = x[2:3].a[{2,4}] .+ 1;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Slices_SliceTest3",
			description="Slice operations: test with vector indices",
			flatModel="
fclass ArrayTests.Slices.SliceTest3
 constant Real x[1].a[1] = 1;
 constant Real x[1].a[2] = 2;
 constant Real x[1].a[3] = 3;
 constant Real x[1].a[4] = 4;
 constant Real x[2].a[1] = 1;
 constant Real x[2].a[2] = 2;
 constant Real x[2].a[3] = 3;
 constant Real x[2].a[4] = 4;
 constant Real x[3].a[1] = 1;
 constant Real x[3].a[2] = 2;
 constant Real x[3].a[3] = 3;
 constant Real x[3].a[4] = 4;
 constant Real x[4].a[1] = 1;
 constant Real x[4].a[2] = 2;
 constant Real x[4].a[3] = 3;
 constant Real x[4].a[4] = 4;
 constant Real y[1,1] = 3.0;
 constant Real y[1,2] = 5.0;
 constant Real y[2,1] = 3.0;
 constant Real y[2,2] = 5.0;
end ArrayTests.Slices.SliceTest3;
")})));
end SliceTest3;



model MixedIndices1
 model M
   Real x[2,2] = identity(2);
 end M;
 
 M m[2];
 Real y[2,2,2];
 Real z[2,2,2];
equation
 for i in 1:2 loop
  der(y[i,:,:]) = m[i].x;
  z[i,:,:] = m[i].x;
 end for;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Slices_MixedIndices1",
			description="Mixing for index subscripts with colon subscripts",
			flatModel="
fclass ArrayTests.Slices.MixedIndices1
 Real y[1,1,1];
 Real y[1,1,2];
 Real y[1,2,1];
 Real y[1,2,2];
 Real y[2,1,1];
 Real y[2,1,2];
 Real y[2,2,1];
 Real y[2,2,2];
 constant Real z[1,1,1] = 1;
 constant Real z[1,1,2] = 0;
 constant Real z[1,2,1] = 0;
 constant Real z[1,2,2] = 1;
 constant Real z[2,1,1] = 1;
 constant Real z[2,1,2] = 0;
 constant Real z[2,2,1] = 0;
 constant Real z[2,2,2] = 1;
 constant Real m[1].x[1,1] = 1;
 constant Real m[1].x[1,2] = 0;
 constant Real m[1].x[2,1] = 0;
 constant Real m[1].x[2,2] = 1;
 constant Real m[2].x[1,1] = 1;
 constant Real m[2].x[1,2] = 0;
 constant Real m[2].x[2,1] = 0;
 constant Real m[2].x[2,2] = 1;
initial equation 
 y[1,1,1] = 0.0;
 y[1,1,2] = 0.0;
 y[1,2,1] = 0.0;
 y[1,2,2] = 0.0;
 y[2,1,1] = 0.0;
 y[2,1,2] = 0.0;
 y[2,2,1] = 0.0;
 y[2,2,2] = 0.0;
equation
 der(y[1,1,1]) = 1.0;
 der(y[1,1,2]) = 0.0;
 der(y[1,2,1]) = 0.0;
 der(y[1,2,2]) = 1.0;
 der(y[2,1,1]) = 1.0;
 der(y[2,1,2]) = 0.0;
 der(y[2,2,1]) = 0.0;
 der(y[2,2,2]) = 1.0;
end ArrayTests.Slices.MixedIndices1;
")})));
end MixedIndices1;


model MixedIndices2
 Real y[4,2];
 Real z[2,2] = identity(2);
equation
 for i in 0:2:2 loop
   y[(1:2).+i,:] = z[:,:] * 2;
 end for;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Slices_MixedIndices2",
			description="Mixing expression subscripts containing for indices with colon subscripts",
			flatModel="
fclass ArrayTests.Slices.MixedIndices2
 constant Real y[1,1] = 2.0;
 constant Real y[1,2] = 0.0;
 constant Real y[2,1] = 0.0;
 constant Real y[2,2] = 2.0;
 constant Real y[3,1] = 2.0;
 constant Real y[3,2] = 0.0;
 constant Real y[4,1] = 0.0;
 constant Real y[4,2] = 2.0;
 constant Real z[1,1] = 1;
 constant Real z[1,2] = 0;
 constant Real z[2,1] = 0;
 constant Real z[2,2] = 1;
end ArrayTests.Slices.MixedIndices2;
")})));
end MixedIndices2;


model EmptySlice1
    model A
        Real x;
    end A;
    
    parameter Integer n = 0;
    A a[n];
    Real y[n] = a.x;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="Slices_EmptySlice1",
			description="Slice in empty array of components",
			flatModel="
fclass ArrayTests.Slices.EmptySlice1
 structural parameter Integer n = 0 /* 0 */;
 Real y[0] = a[1:0].x;
end ArrayTests.Slices.EmptySlice1;
")})));
end EmptySlice1;

end Slices;

package VariableIndex

model Equation
    Real table[:] = {42, 3.14};
    Integer i = if time > 1 then 1 else 2;
    Real x = table[i];

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="VariableIndex_Equation",
            description="Test array index with discrete variability in equation",
            flatModel="
fclass ArrayTests.VariableIndex.Equation
 constant Real table[1] = 42;
 constant Real table[2] = 3.14;
 discrete Integer i;
 Real x;
initial equation 
 pre(i) = 0;
equation
 i = if time > 1 then 1 else 2;
 x = temp_1(i, {42.0, 3.14});

public
 function temp_1
  input Integer i_0;
  input Real[2] x;
  output Real y;
 algorithm
  y := x[i_0];
  return;
 end temp_1;

end ArrayTests.VariableIndex.Equation;
")})));
end Equation;

model TwoDim1
    Real table[:,:] = {{1, 2}, {3, 4}};
    Integer i = if time > 1 then 1 else 2;
    Real x = table[i,2];

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="VariableIndex_TwoDim1",
            description="Test array index with discrete variability in equation",
            flatModel="
fclass ArrayTests.VariableIndex.TwoDim1
 constant Real table[1,1] = 1;
 constant Real table[1,2] = 2;
 constant Real table[2,1] = 3;
 constant Real table[2,2] = 4;
 discrete Integer i;
 Real x;
initial equation 
 pre(i) = 0;
equation
 i = if time > 1 then 1 else 2;
 x = temp_1(i, {2.0, 4.0});

public
 function temp_1
  input Integer i_0;
  input Real[2] x;
  output Real y;
 algorithm
  y := x[i_0];
  return;
 end temp_1;

end ArrayTests.VariableIndex.TwoDim1;
")})));
end TwoDim1;

model TwoDim2
    Real table[:,:] = {{1, 2}, {3, 4}};
    Integer i = if time > 1 then 1 else 2;
    Real x = table[1,i];

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="VariableIndex_TwoDim2",
            description="Test array index with discrete variability in equation",
            flatModel="
fclass ArrayTests.VariableIndex.TwoDim2
 constant Real table[1,1] = 1;
 constant Real table[1,2] = 2;
 constant Real table[2,1] = 3;
 constant Real table[2,2] = 4;
 discrete Integer i;
 Real x;
initial equation 
 pre(i) = 0;
equation
 i = if time > 1 then 1 else 2;
 x = temp_1(i, {1.0, 2.0});

public
 function temp_1
  input Integer i_0;
  input Real[2] x;
  output Real y;
 algorithm
  y := x[i_0];
  return;
 end temp_1;

end ArrayTests.VariableIndex.TwoDim2;
")})));
end TwoDim2;

model TwoDim3
    Real table[:,:] = {{1, 2}, {3, 4}};
    Integer i1 = if time > 1 then 1 else 2;
    Integer i2 = if time > 0.5 then 1 else 2;
    Real x = table[i1,i2];

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="VariableIndex_TwoDim3",
            description="Test array index with discrete variability in equation",
            flatModel="
fclass ArrayTests.VariableIndex.TwoDim3
 constant Real table[1,1] = 1;
 constant Real table[1,2] = 2;
 constant Real table[2,1] = 3;
 constant Real table[2,2] = 4;
 discrete Integer i1;
 discrete Integer i2;
 Real x;
initial equation 
 pre(i1) = 0;
 pre(i2) = 0;
equation
 i1 = if time > 1 then 1 else 2;
 i2 = if time > 0.5 then 1 else 2;
 x = temp_1(i1, i2, {{1.0, 2.0}, {3.0, 4.0}});

public
 function temp_1
  input Integer i_0;
  input Integer i_1;
  input Real[2, 2] x;
  output Real y;
 algorithm
  y := x[i_0,i_1];
  return;
 end temp_1;

end ArrayTests.VariableIndex.TwoDim3;
")})));
end TwoDim3;

model TwoDim4
    Real table[:,:] = {{1, 2}, {3, 4}};
    Integer i = if time > 1 then 1 else 2;
    Real x[2] = table[i,:];

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="VariableIndex_TwoDim4",
            description="Test array index with discrete variability in equation",
            flatModel="
fclass ArrayTests.VariableIndex.TwoDim4
 constant Real table[1,1] = 1;
 constant Real table[1,2] = 2;
 constant Real table[2,1] = 3;
 constant Real table[2,2] = 4;
 discrete Integer i;
 Real x[1];
 Real x[2];
initial equation 
 pre(i) = 0;
equation
 i = if time > 1 then 1 else 2;
 ({x[1], x[2]}) = temp_1(i, {{1.0, 2.0}, {3.0, 4.0}});

public
 function temp_1
  input Integer i_0;
  input Real[2, 2] x;
  output Real[2] y;
 algorithm
  y[1] := x[i_0,1];
  y[2] := x[i_0,2];
  return;
 end temp_1;

end ArrayTests.VariableIndex.TwoDim4;
")})));
end TwoDim4;

model TwoDim5
    Real table[:,:] = {{1, 2}, {3, 4}};
    Integer i = if time > 1 then 1 else 2;
    Real x[2] = table[:,i];

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="VariableIndex_TwoDim5",
            description="Test array index with discrete variability in equation",
            flatModel="
fclass ArrayTests.VariableIndex.TwoDim5
 constant Real table[1,1] = 1;
 constant Real table[1,2] = 2;
 constant Real table[2,1] = 3;
 constant Real table[2,2] = 4;
 discrete Integer i;
 Real x[1];
 Real x[2];
initial equation 
 pre(i) = 0;
equation
 i = if time > 1 then 1 else 2;
 ({x[1], x[2]}) = temp_1(i, {{1.0, 2.0}, {3.0, 4.0}});

public
 function temp_1
  input Integer i_0;
  input Real[2, 2] x;
  output Real[2] y;
 algorithm
  y[1] := x[1,i_0];
  y[2] := x[2,i_0];
  return;
 end temp_1;

end ArrayTests.VariableIndex.TwoDim5;
")})));
end TwoDim5;

model TwoDim6
    Real table[:,:] = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
    Integer i = if time > 1 then 1 else 2;
    Real x[2] = table[{2,3},i];

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="VariableIndex_TwoDim6",
            description="Test array index with discrete variability in equation",
            flatModel="
fclass ArrayTests.VariableIndex.TwoDim6
 constant Real table[1,1] = 1;
 constant Real table[1,2] = 2;
 constant Real table[2,1] = 3;
 constant Real table[2,2] = 4;
 constant Real table[3,1] = 5;
 constant Real table[3,2] = 6;
 constant Real table[4,1] = 7;
 constant Real table[4,2] = 8;
 discrete Integer i;
 Real x[1];
 Real x[2];
initial equation 
 pre(i) = 0;
equation
 i = if time > 1 then 1 else 2;
 ({x[1], x[2]}) = temp_1(i, {{3.0, 4.0}, {5.0, 6.0}});

public
 function temp_1
  input Integer i_0;
  input Real[2, 2] x;
  output Real[2] y;
 algorithm
  y[1] := x[1,i_0];
  y[2] := x[2,i_0];
  return;
 end temp_1;

end ArrayTests.VariableIndex.TwoDim6;
")})));
end TwoDim6;

model TwoDim7
    Real table[:,:] = {{1, 2, 3, 4}, {5, 6, 7, 8}};
    Integer i = if time > 1 then 1 else 2;
    Real x[2] = table[i, {2,3}];

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="VariableIndex_TwoDim7",
            description="Test array index with discrete variability in equation",
            flatModel="
fclass ArrayTests.VariableIndex.TwoDim7
 constant Real table[1,1] = 1;
 constant Real table[1,2] = 2;
 constant Real table[1,3] = 3;
 constant Real table[1,4] = 4;
 constant Real table[2,1] = 5;
 constant Real table[2,2] = 6;
 constant Real table[2,3] = 7;
 constant Real table[2,4] = 8;
 discrete Integer i;
 Real x[1];
 Real x[2];
initial equation 
 pre(i) = 0;
equation
 i = if time > 1 then 1 else 2;
 ({x[1], x[2]}) = temp_1(i, {{2.0, 3.0}, {6.0, 7.0}});

public
 function temp_1
  input Integer i_0;
  input Real[2, 2] x;
  output Real[2] y;
 algorithm
  y[1] := x[i_0,1];
  y[2] := x[i_0,2];
  return;
 end temp_1;

end ArrayTests.VariableIndex.TwoDim7;
")})));
end TwoDim7;

model Algorithm
    Real table[:] = {42, 3.14};
    Integer i = if time > 1 then 1 else 2;
    Real x;
algorithm
    x := table[i];

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="VariableIndex_Algorithm",
            description="Test array index with discrete variability in algorithm",
            flatModel="
fclass ArrayTests.VariableIndex.Algorithm
 constant Real table[1] = 42;
 constant Real table[2] = 3.14;
 discrete Integer i;
 Real x;
initial equation 
 pre(i) = 0;
algorithm
 x := temp_1(i, {table[1], table[2]});
equation
 i = if time > 1 then 1 else 2;

public
 function temp_1
  input Integer i_0;
  input Real[2] x;
  output Real y;
 algorithm
  y := x[i_0];
  return;
 end temp_1;

end ArrayTests.VariableIndex.Algorithm;
")})));
end Algorithm;

model Enum
    type ABC = enumeration(A,B,C);
    ABC table[ABC] = {ABC.A, ABC.B, ABC.C};
    ABC i = if time > 1 then ABC.A else ABC.B;
    ABC x = table[i];

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="VariableIndex_Enum",
            description="Test enum array index with discrete variability",
            flatModel="
fclass ArrayTests.VariableIndex.Enum
 constant ArrayTests.VariableIndex.Enum.ABC table[1] = ArrayTests.VariableIndex.Enum.ABC.A;
 constant ArrayTests.VariableIndex.Enum.ABC table[2] = ArrayTests.VariableIndex.Enum.ABC.B;
 constant ArrayTests.VariableIndex.Enum.ABC table[3] = ArrayTests.VariableIndex.Enum.ABC.C;
 discrete ArrayTests.VariableIndex.Enum.ABC i;
 discrete ArrayTests.VariableIndex.Enum.ABC x;
initial equation 
 pre(i) = ArrayTests.VariableIndex.Enum.ABC.A;
 pre(x) = ArrayTests.VariableIndex.Enum.ABC.A;
equation
 i = if time > 1 then ArrayTests.VariableIndex.Enum.ABC.A else ArrayTests.VariableIndex.Enum.ABC.B;
 x = temp_1(i, {ArrayTests.VariableIndex.Enum.ABC.A, ArrayTests.VariableIndex.Enum.ABC.B, ArrayTests.VariableIndex.Enum.ABC.C});

public
 function temp_1
  input ArrayTests.VariableIndex.Enum.ABC i_0;
  input ArrayTests.VariableIndex.Enum.ABC[3] x;
  output ArrayTests.VariableIndex.Enum.ABC y;
 algorithm
  y := x[i_0];
  return;
 end temp_1;

 type ArrayTests.VariableIndex.Enum.ABC = enumeration(A, B, C);

end ArrayTests.VariableIndex.Enum;
")})));
end Enum;

model Bool
    type ABC = enumeration(A,B,C);
    Boolean table[Boolean] = {true, false};
    Boolean i = if time > 1 then false else true;
    Boolean x = table[i];

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="VariableIndex_Bool",
            description="Test bool array index with discrete variability",
            flatModel="
fclass ArrayTests.VariableIndex.Bool
 constant Boolean table[1] = true;
 constant Boolean table[2] = false;
 discrete Boolean i;
 discrete Boolean x;
initial equation 
 pre(i) = false;
 pre(x) = false;
equation
 i = if time > 1 then false else true;
 x = temp_1(i, {true, false});

public
 function temp_1
  input Boolean i_0;
  input Boolean[2] x;
  output Boolean y;
 algorithm
  y := x[i_0];
  return;
 end temp_1;

end ArrayTests.VariableIndex.Bool;
")})));
end Bool;

model ExpEquation
    package P
      constant Real[3] c = {1,2,3};
    end P;
    input Integer i;
    Real y = P.c[i];
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="VariableIndex_ExpEquation",
            description="Subscripted exp with discrete index",
            flatModel="
fclass ArrayTests.VariableIndex.ExpEquation
 discrete input Integer i;
 Real y;
equation
 y = temp_1(i, {1.0, 2.0, 3.0});

public
 function temp_1
  input Integer i_0;
  input Real[3] x;
  output Real y;
 algorithm
  y := x[i_0];
  return;
 end temp_1;

end ArrayTests.VariableIndex.ExpEquation;
")})));
end ExpEquation;

model ExpEquationArray
    package P
      constant Real[3] c = {1,2,3};
    end P;
    input Integer i;
    Real[2] y = P.c[{i,i+1}];
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="VariableIndex_ExpEquationArray",
            description="Subscripted exp with discrete index, non scalar",
            flatModel="
fclass ArrayTests.VariableIndex.ExpEquationArray
 discrete input Integer i;
 Real y[1];
 Real y[2];
 discrete Real temp_1[1];
 discrete Real temp_1[2];
initial equation 
 pre(temp_1[1]) = 0.0;
 pre(temp_1[2]) = 0.0;
equation
 ({temp_1[1], temp_1[2]}) = temp_1({i, i + 1}, {1.0, 2.0, 3.0});
 y[1] = temp_1[1];
 y[2] = temp_1[2];

public
 function temp_1
  input Integer[2] i_0;
  input Real[3] x;
  output Real[2] y;
 algorithm
  y[1] := x[i_0[1]];
  y[2] := x[i_0[2]];
  return;
 end temp_1;

end ArrayTests.VariableIndex.ExpEquationArray;
")})));
end ExpEquationArray;


model Slice1
    record R
        Real p;
    end R;
    
    Real y;
    R[2] x = { R(time), R(2 * time) };
    input Integer i;
equation
    y = if i == 0 then 1 else x[i].p;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="VariableIndex_Slice1",
            description="Using variable index in slice",
            flatModel="
fclass ArrayTests.VariableIndex.Slice1
 Real y;
 Real x[1].p;
 Real x[2].p;
 discrete input Integer i;
equation
 y = if i == 0 then 1 else temp_1(i, {x[1].p, x[2].p});
 x[1].p = time;
 x[2].p = 2 * time;

public
 function temp_1
  input Integer i_0;
  input Real[2] x;
  output Real y;
 algorithm
  y := x[i_0];
  return;
 end temp_1;

end ArrayTests.VariableIndex.Slice1;
")})));
end Slice1;


model Slice2
    Real x[2, 2, 2] = { { {1, 2}, {3, 4} }, { {5, 6}, {7, 8} } } * time;
    Real y[2, 3] = x[i, {2, 1}, {1, 2, 2}];
    input Integer i;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="VariableIndex_Slice2",
            description="Using variable index in slice with matrix result",
            flatModel="
fclass ArrayTests.VariableIndex.Slice2
 Real x[1,1,1];
 Real x[1,1,2];
 Real x[1,2,1];
 Real x[1,2,2];
 Real x[2,1,1];
 Real x[2,1,2];
 Real x[2,2,1];
 Real x[2,2,2];
 Real y[1,1];
 Real y[1,2];
 Real y[1,3];
 Real y[2,1];
 Real y[2,2];
 Real y[2,3];
 discrete input Integer i;
equation
 x[1,1,1] = time;
 x[1,1,2] = 2 * time;
 x[1,2,1] = 3 * time;
 x[1,2,2] = 4 * time;
 x[2,1,1] = 5 * time;
 x[2,1,2] = 6 * time;
 x[2,2,1] = 7 * time;
 x[2,2,2] = 8 * time;
 ({{y[1,1], y[1,2], y[1,3]}, {y[2,1], y[2,2], y[2,3]}}) = temp_1(i, {{{x[1,2,1], x[1,2,2], x[1,2,2]}, {x[1,1,1], x[1,1,2], x[1,1,2]}}, {{x[2,2,1], x[2,2,2], x[2,2,2]}, {x[2,1,1], x[2,1,2], x[2,1,2]}}});

public
 function temp_1
  input Integer i_0;
  input Real[2, 2, 3] x;
  output Real[2, 3] y;
 algorithm
  y[1,1] := x[i_0,1,1];
  y[1,2] := x[i_0,1,2];
  y[1,3] := x[i_0,1,3];
  y[2,1] := x[i_0,2,1];
  y[2,2] := x[i_0,2,2];
  y[2,3] := x[i_0,2,3];
  return;
 end temp_1;

end ArrayTests.VariableIndex.Slice2;
")})));
end Slice2;


model Slice3
    record R
        Real x[2];
    end R;
    
    R r[2] =  {R({1, 2} * time), R({3, 4} * time)};
    Real x[2] = r.x[i];
    input Integer i;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="VariableIndex_Slice3",
            description="Using variable index in slice with no index on record",
            flatModel="
fclass ArrayTests.VariableIndex.Slice3
 Real r[1].x[1];
 Real r[1].x[2];
 Real r[2].x[1];
 Real r[2].x[2];
 Real x[1];
 Real x[2];
 discrete input Integer i;
equation
 r[1].x[1] = time;
 r[1].x[2] = 2 * time;
 r[2].x[1] = 3 * time;
 r[2].x[2] = 4 * time;
 ({x[1], x[2]}) = temp_1(i, {{r[1].x[1], r[1].x[2]}, {r[2].x[1], r[2].x[2]}});

public
 function temp_1
  input Integer i_0;
  input Real[2, 2] x;
  output Real[2] y;
 algorithm
  y[1] := x[1,i_0];
  y[2] := x[2,i_0];
  return;
 end temp_1;

end ArrayTests.VariableIndex.Slice3;
")})));
end Slice3;

end VariableIndex;


package Other
	
model CircularFunctionArg1
	function f 
		input Real[:] a;
		output Real[:] b = a;
	algorithm
	end f;
	
	Real[:] c = f(d);
	Real[:] d = f(c);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="CircularFunctionArg1",
			description="Circular dependency when calculating size of function output",
			errorMessage="
2 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 1528, column 14:
  Could not evaluate array size of output b
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 1529, column 14:
  Could not evaluate array size of output b
")})));
end CircularFunctionArg1;



constant Real testConst[2] = { 1, 2 };


model ArrayConst1
	Real x[2] = { 1.0 / testConst[i] for i in 1:2 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Other_ArrayConst1",
			description="Array constants used with parameter index",
			flatModel="
fclass ArrayTests.Other.ArrayConst1
 constant Real x[1] = 1.0;
 constant Real x[2] = 0.5;
end ArrayTests.Other.ArrayConst1;
")})));
end ArrayConst1;
								   
   
model ArrayConst2
	Real x[2];
equation
	for i in 1:2 loop
		x[i] = testConst[i];
	end for;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Other_ArrayConst2",
			description="Array constants used with parameter index",
			flatModel="
fclass ArrayTests.Other.ArrayConst2
 constant Real x[1] = 1.0;
 constant Real x[2] = 2.0;
end ArrayTests.Other.ArrayConst2;
")})));
end ArrayConst2;


model ArrayConst3
	function f
		input Real i;
		output Real o;
	algorithm
		o := testConst[integer(i)];
	end f;
	
	Real x = f(1);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Other_ArrayConst3",
			description="Array constants used with index of discrete variability",
			flatModel="
fclass ArrayTests.Other.ArrayConst3
 constant Real x = 1;
end ArrayTests.Other.ArrayConst3;
")})));
end ArrayConst3;


model ArrayConst4
	parameter Integer i = 1;
	Real x = testConst[i];

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Other_ArrayConst4",
			description="Array constants used with parameter index",
			flatModel="
fclass ArrayTests.Other.ArrayConst4
 parameter Integer i = 1 /* 1 */;
 constant Real x = 1.0;
end ArrayTests.Other.ArrayConst4;
")})));
end ArrayConst4;


model ArraySize2
	parameter Real x[:, size(x,1)];

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArraySize2",
			description="Size of variable: one dimension refering to another",
			errorMessage="
2 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 6365, column 17:
  Can not infer array size of the variable x
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ArrayTests.mo':
Semantic error at line 6365, column 22:
  Could not evaluate array size expression: size(x, 1)
")})));
end ArraySize2;


model ArraySize3
	model A
		Real x[2] = {1,2};
	end A;
	
	parameter Integer n = 2;
	A[n] b;
	Real[n] c;
equation
	for i in 1:n loop
		c[i] = b[i].x[1] + b[i].x[end];
	end for;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Other_ArraySize3",
			description="Handle end in for loop",
			flatModel="
fclass ArrayTests.Other.ArraySize3
 structural parameter Integer n = 2 /* 2 */;
 constant Real b[1].x[1] = 1;
 constant Real b[1].x[2] = 2;
 constant Real b[2].x[1] = 1;
 constant Real b[2].x[2] = 2;
 constant Real c[1] = 3.0;
 constant Real c[2] = 3.0;
end ArrayTests.Other.ArraySize3;
")})));
end ArraySize3;


model ArraySizeInIf1
    function f1
        input Integer g;
        output Real[g] h;
    algorithm
        h := 1:g;
    end f1;
    
    function f2
        input Integer i;
        output Real[div(i, 2)] j;
        output Real[mod(i, 2)] k;
    algorithm
        j := 1:div(i, 2);
        k := 1:mod(i, 2);
    end f2;
    
    parameter Boolean a = false;
    parameter Integer b = 5;
    parameter Integer c = if a then b else div(b, 2);
    parameter Integer d = if a then 0 else mod(b, 2);
    Real e[c];
    Real f[d];
equation
    if a then
        e = f1(b);
    else
        (e, f) = f2(b);
    end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Other_ArraySizeInIf1",
			description="Test that array size errors lock if branches if possible",
			flatModel="
fclass ArrayTests.Other.ArraySizeInIf1
 structural parameter Boolean a = false /* false */;
 structural parameter Integer b = 5 /* 5 */;
 structural parameter Integer c = 2 /* 2 */;
 structural parameter Integer d = 1 /* 1 */;
 constant Real e[1] = 1;
 constant Real e[2] = 2;
 constant Real f[1] = 1;
end ArrayTests.Other.ArraySizeInIf1;
")})));
end ArraySizeInIf1;


model ArraySizeInIf2
    function f1
        input Integer g;
        output Real[g] h;
    algorithm
        h := 1:g;
    end f1;
    
    function f2
        input Integer i;
        output Real[div(i, 2)] j;
        output Real[mod(i, 2)] k;
    algorithm
        j := 1:div(i, 2);
        k := 1:mod(i, 2);
    end f2;
    
    parameter Boolean a = false;
    parameter Integer b = 5;
    parameter Integer c = if a then b else div(b, 2);
    parameter Integer d = if a then 0 else mod(b, 2);
    Real e[c];
    Real f[d];
equation
    if time > 2 then
        e = f1(b);
    else
        (e, f) = f2(b);
    end if;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="Other_ArraySizeInIf2",
			description="Test that array size errors don't lock if branches if not possible",
			errorMessage="
2 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 6225, column 5:
  All branches in if equation with non-parameter tests must have the same number of equations
Error: in file 'Compiler/ModelicaFrontEnd/src/test/ArrayTests.mo':
Semantic error at line 6226, column 9:
  The array sizes of right and left hand side of equation are not compatible
")})));
end ArraySizeInIf2;


model ArraySizeInIf3
    function f1
        input Integer g;
        output Real[g] h;
    algorithm
        h := 1:g;
    end f1;
    
    function f2
        input Integer i;
        output Real[div(i, 2)] j;
        output Real[mod(i, 2)] k;
    algorithm
        j := 1:div(i, 2);
        k := 1:mod(i, 2);
    end f2;
    
    parameter Boolean a = true;
    parameter Integer b = 5;
    parameter Integer c = if a then b else div(b, 2);
    parameter Integer d = if a then 0 else mod(b, 2);
    Real e[c];
    Real f[d];
equation
    if a then
        e = f1(b);
    else
        (e, f) = f2(b);
    end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Other_ArraySizeInIf3",
			description="Test that array size errors lock if branches if possible",
			flatModel="
fclass ArrayTests.Other.ArraySizeInIf3
 structural parameter Boolean a = true /* true */;
 structural parameter Integer b = 5 /* 5 */;
 structural parameter Integer c = 5 /* 5 */;
 structural parameter Integer d = 0 /* 0 */;
 constant Real e[1] = 1;
 constant Real e[2] = 2;
 constant Real e[3] = 3;
 constant Real e[4] = 4;
 constant Real e[5] = 5;
end ArrayTests.Other.ArraySizeInIf3;
")})));
end ArraySizeInIf3;


model ArraySimplify1
    Real x[2], y[2], z[2];
equation
    der(x) = {1, 2} * time;
    y = 0 * x;
    z = x * 0;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="Other_ArraySimplify1",
			description="Correct simplification of array expressions",
			flatModel="
fclass ArrayTests.Other.ArraySimplify1
 Real x[1];
 Real x[2];
 constant Real y[1] = 0;
 constant Real y[2] = 0;
 constant Real z[1] = 0;
 constant Real z[2] = 0;
initial equation 
 x[1] = 0.0;
 x[2] = 0.0;
equation
 der(x[1]) = time;
 der(x[2]) = 2 * time;
end ArrayTests.Other.ArraySimplify1;
")})));
end ArraySimplify1;

package P
    function f
        input Real[:,:] x;
        output Real[size(x,1), size(x,2)] y;
      algorithm
        y := x;
    end f;
    constant Real[1,1] x = {{2}} * f({{3}});
end P;
model FuncCallInPackConstEval
    constant Real y[1,1] = P.x;
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="Other_FuncCallInPackConstEval",
            description="Test getArray for function call in package constant",
            flatModel="
fclass ArrayTests.Other.FuncCallInPackConstEval
 constant Real y[1,1] = 6;
end ArrayTests.Other.FuncCallInPackConstEval;
")})));
end FuncCallInPackConstEval;

model ScalarizingPre
    Integer[2] i(start={0,0});
  algorithm
    i := pre(i);
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="Other_ScalarizingPre",
            description="Test scalarizing of pre array",
            flatModel="
fclass ArrayTests.Other.ScalarizingPre
 discrete Integer i[1](start = 0);
 discrete Integer i[2](start = 0);
initial equation 
 pre(i[1]) = 0;
 pre(i[2]) = 0;
algorithm
 i[1] := pre(i[1]);
 i[2] := pre(i[2]);
end ArrayTests.Other.ScalarizingPre;
")})));
end ScalarizingPre;


end Other;

end ArrayTests;
