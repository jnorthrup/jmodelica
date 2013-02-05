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


package ModificationTests 

class ModTest1
  parameter Real y = 4;
  Real z(unit="m") = y;
  Real x;
equation
  x=4;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ModTest1",
			description="Test of Real attribute \"unit\".",
			flatModel="
fclass ModificationTests.ModTest1
 parameter Real y=4;
 Real z(unit=\"m\")=y;
 Real x;
equation 
 x=4;
end ModificationTests.ModTest1;
")})));
end ModTest1;

class ModTest2
  class C1
    parameter Real a;
  end C1;
  
  class C2
    parameter Real b,c;
  end C2;
  
  class C3
    parameter Real x1;
    parameter Real x2 = 2;
    parameter C1 x3;
    parameter C2 x4(b=4);
    parameter C1 x5(a=5);
    extends C1;
    extends C2(b=6,c=77);
  end C3;
  
  class C4
    extends C3(x2=22, x3(a=33), x4(c=44), a=55, b=66);
  end C4;
  C4 c4;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ModTest2",
			description="Merging of modifications",
			flatModel="  fclass ModificationTests.ModTest2
 parameter Real c4.x1;
 parameter Real c4.x2=22;
 parameter Real c4.x3.a=33;
 parameter Real c4.x4.b=4;
 parameter Real c4.x4.c=44;
 parameter Real c4.x5.a=5;
 parameter Real c4.a=55;
 parameter Real c4.b=66;
 parameter Real c4.c=77;
end ModificationTests.ModTest2;
")})));
end ModTest2;

class ModTest3
  
  class C
    Real x=3;
  end C;
  
  C c(x=5);
  

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ModTest3",
			description="Simple modification test",
			flatModel="
fclass ModificationTests.ModTest3
 Real c.x=5;
end ModificationTests.ModTest3;
")})));
end ModTest3;

class ModTest5
  
  
  parameter Real p=3;
  Real y(start=p)=5;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ModTest5",
			description="Test of start-attribute",
			flatModel=" fclass ModificationTests.ModTest5
 parameter Real p=3;
 Real y(start=p)=5;
end ModificationTests.ModTest5;
")})));
end ModTest5;

class ModTest6
class C1
 Real x;
end C1;

class C2
  parameter Real p(nominal=4)=3;
  C1 c1 (x(min=p)=5);
end C2;

C2 c2;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ModTest6",
			description="Test merging of modifications",
			flatModel=" fclass ModificationTests.ModTest6
 parameter Real c2.p(nominal=4)=3;
 Real c2.c1.x(min=c2.p)=5;
end ModificationTests.ModTest6;
")})));
end ModTest6;

class ModTest7 
  Real x=3;
  class C2 
    Real y;
    class C3 
      Real z(nominal=1)=1;
    end C3;
    C3 c3(z(nominal=2)=3);
  end C2;
  C2 c2(c3.z(max=4)=5, y=3);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ModTest7",
			description="Test merging of attributes",
			flatModel="
fclass ModificationTests.ModTest7
 Real x=3;
 Real c2.y=3;
 Real c2.c3.z(max=4,nominal=2)=5;
end ModificationTests.ModTest7;
")})));
end ModTest7;


class ModTest8
class C1
 Real x;
end C1;

class C2
  extends C1(x=4);
  C1 c1(x=6);
end C2;

class C3

	extends C2(x=c1.x,c1(x=44));  
  
end C3;
C3 c3;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ModTest8",
			description="Merging of modifications in extends clauses",
			flatModel="
fclass ModificationTests.ModTest8
 Real c3.c1.x=44;
 Real c3.x=c3.c1.x;
end ModificationTests.ModTest8;
")})));
end ModTest8;

class ModTest9
  
class C1
 Real x;
end C1;

class C2
  extends C1(x(unit="qwe",start=3.0)=4);
  C1 c1(x(start=2,quantity="qwe")=6);
end C2;

class C3
	extends C2(x(quantity="qqq",unit="m2",displayUnit="m22",start=4.2,
	             min=4.1,max=9.0,nominal=0.2)=55,c1(x=44));  
  
end C3;

C3 c3;


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ModTest9",
			description="Test of attributes of Real",
			flatModel="
fclass ModificationTests.ModTest9
 Real c3.c1.x(start=2,quantity=\"qwe\")=44;
 Real c3.x(quantity=\"qqq\",unit=\"m2\",displayUnit=\"m22\",start=4.2,min=4.1,max=9.0,nominal=0.2)=55;
end ModificationTests.ModTest9;
")})));
end ModTest9;

class ModTest10
  parameter Real A=2;
  
	class C2
	  parameter Real B=1;
	  Real x=B;
	end C2;
  
  C2 c2a;
  C2 c2b(x=A);
  

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ModTest10",
			description="Test of parameter-prefix in modifications.",
			flatModel="
fclass ModificationTests.ModTest10
 parameter Real A=2;
 parameter Real c2a.B=1;
 Real c2a.x=c2a.B;
 parameter Real c2b.B=1;
 Real c2b.x=A;
end ModificationTests.ModTest10;
")})));
end ModTest10;

class ModTest11
  class C2
    
    class C3
      
      class C4
        Real z=2;
        Real x=3;
      end C4;
    
      C4 c4a,c4b;
    
    end C3;
  	
  	C3 c3(c4a.z=6);
  	
  end C2;
  
  C2 c2(c3.c4a.x=4,c3.c4b.x=10);
  extends C2(c3.c4a.x=5,c3.c4b.z=8);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ModTest11",
			description="Additional merging tests",
			flatModel=" fclass ModificationTests.ModTest11
 Real c2.c3.c4a.z=6;
 Real c2.c3.c4a.x=4;
 Real c2.c3.c4b.z=2;
 Real c2.c3.c4b.x=10;
 Real c3.c4a.z=6;
 Real c3.c4a.x=5;
 Real c3.c4b.z=8;
 Real c3.c4b.x=3;
end ModificationTests.ModTest11;
")})));
end ModTest11;
 
 model ModTest_PM_12
  
  extends C2(c3(c4a(x=5)),c3.c4b.z=a);
  //extends C2(c3.c4b.z=a);
  
  model C2
    
    model C3
      
      model C4
        Real z=2;
        Real x=3; 
        Real w=3;
      end C4;
    
        Real b=5;
    
      C4 c4a;
      C4 c4b(x=b); 
    
    end C3;
        
        C3 c3(c4a.z=6);
        
  end C2;
  
  Real a;
  
  C2 c0;
  C2 c2(c3.c4a.x=a,c3.c4b.x=c3.b,c3(c4a(w=6,z=9)));
  

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ModTest12",
			description="Additional merging tests",
			flatModel="
fclass ModificationTests.ModTest_PM_12
 Real a;
 Real c0.c3.b=5;
 Real c0.c3.c4a.z=6;
 Real c0.c3.c4a.x=3;
 Real c0.c3.c4a.w=3;
 Real c0.c3.c4b.z=2;
 Real c0.c3.c4b.x=c0.c3.b;
 Real c0.c3.c4b.w=3;
 Real c2.c3.b=5;
 Real c2.c3.c4a.z=9;
 Real c2.c3.c4a.x=a;
 Real c2.c3.c4a.w=6;
 Real c2.c3.c4b.z=2;
 Real c2.c3.c4b.x=c3.b;
 Real c2.c3.c4b.w=3;
 Real c3.b=5;
 Real c3.c4a.z=6;
 Real c3.c4a.x=5;
 Real c3.c4a.w=3;
 Real c3.c4b.z=a;
 Real c3.c4b.x=c3.b;
 Real c3.c4b.w=3;
end ModificationTests.ModTest_PM_12;
")})));
end ModTest_PM_12;
 
model ModTest13_Err
  model A
    Real x=2;
  end A;

  A a(y=3);


	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ModTest13_Err",
			description="Test of lookup errors in modifications",
			errorMessage="
1 error(s) found...
In file 'src/test/modelica/ModificationTests.mo':
Semantic error at line 351, column 7:
  The component y is undeclared

")})));
end ModTest13_Err;
 
model ModTest14_Err
  model A
    Real x=2;
  end A;

  extends A(y=3);


	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ModTest14_Err",
			description="Test of lookup errors in modifications",
			errorMessage="
1 error(s) found...
In file 'src/test/modelica/ModificationTests.mo':
Semantic error at line 351, column 7:
  The component y is undeclared

")})));
end ModTest14_Err;

model ModTest15_Err
  model A
   Real x=4;
    Real y=5;
  end A;
  
  model B
    extends A;
  end B;
  
  model C
    extends B(x=5,z=4);
  end C;
  
  extends C(y=3);


	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ModTest15_Err",
			description="Test of lookup errors in modifications",
			errorMessage="
1 error(s) found...
In file 'src/test/modelica/ModificationTests.mo':
Semantic error at line 404, column 7:
  The component z is undeclared

")})));
end ModTest15_Err;
  
 

model ShortClassDeclModTest1
  model A
    Real x=2;
  end A;
  
  model AA=A;
  
  AA aa(x=3);


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ShortClassDeclModTest1",
			description="Test simple use of short class declaration and modification.",
			flatModel="
fclass ModificationTests.ShortClassDeclModTest1
 Real aa.x=3;

end ModificationTests.ShortClassDeclModTest1;
")})));
end ShortClassDeclModTest1;

 model ShortClassDeclModTest2
  model A
    Real x=2;
  end A;
  
  model AA=A(x=2.5);
  
  AA aa;


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ShortClassDeclModTest2",
			description="Test simple use of short class declaration and modification.",
			flatModel="
fclass ModificationTests.ShortClassDeclModTest2
 Real aa.x=2.5;

end ModificationTests.ShortClassDeclModTest2;
")})));
end ShortClassDeclModTest2;

model ShortClassDeclModTest3
  model A
    Real x=2;
  end A;
  
  model AA=A(x=2.5);
  
  AA aa(x=3);


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ShortClassDeclModTest3",
			description="Test simple use of short class declaration and modification.",
			flatModel="
fclass ModificationTests.ShortClassDeclModTest3
 Real aa.x=3;

end ModificationTests.ShortClassDeclModTest3;
")})));
end ShortClassDeclModTest3;



model ArrayModifications1
 Real a[3](each start=3) = zeros(3);
 Real b[3](start={1,2,3}) = zeros(3);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications1",
			description="Modifications to arrays: array attributes",
			flatModel="
fclass ModificationTests.ArrayModifications1
 Real a[1](start = 3);
 Real a[2](start = 3);
 Real a[3](start = 3);
 Real b[1](start = 1);
 Real b[2](start = 2);
 Real b[3](start = 3);
equation
 a[1] = 0;
 a[2] = 0;
 a[3] = 0;
 b[1] = 0;
 b[2] = 0;
 b[3] = 0;

end ModificationTests.ArrayModifications1;
")})));
end ArrayModifications1;


model ArrayModifications2
 Real a(each start=3) = 0;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications2",
			description="Modifications to arrays: [](start=[])",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 712, column 9:
  The 'each' keyword cannot be applied to attributes of scalar components
")})));
end ArrayModifications2;


model ArrayModifications3
 Real b[3](start={1,2,3,4}) = zeros(3);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications3",
			description="Modifications to arrays: [3](start=[4])",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 728, column 11:
  Array size mismatch for the attribute start, size of declaration is [3] and size of start expression is [4]
")})));
end ArrayModifications3;


model ArrayModifications4
 Real a[3](each start={1,2}) = zeros(3);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications4",
			description="Modifications to arrays: [3](each start=[2])",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 744, column 12:
  The attribute start is declared 'each' and the binding expression is not scalar
")})));
end ArrayModifications4;


model ArrayModifications5
 model B
  Real x[3];
  Real y[3];
 end B;
 
 B b[2](x={{1,2,3},{4,5,6}}, each y={10,20,30});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications5",
			description="Modifications to arrays: members that are arrays",
			flatModel="
fclass ModificationTests.ArrayModifications5
 Real b[1].x[1];
 Real b[1].x[2];
 Real b[1].x[3];
 Real b[1].y[1];
 Real b[1].y[2];
 Real b[1].y[3];
 Real b[2].x[1];
 Real b[2].x[2];
 Real b[2].x[3];
 Real b[2].y[1];
 Real b[2].y[2];
 Real b[2].y[3];
equation
 b[1].x[1] = 1;
 b[1].x[2] = 2;
 b[1].x[3] = 3;
 b[1].y[1] = 10;
 b[1].y[2] = 20;
 b[1].y[3] = 30;
 b[2].x[1] = 4;
 b[2].x[2] = 5;
 b[2].x[3] = 6;
 b[2].y[1] = 10;
 b[2].y[2] = 20;
 b[2].y[3] = 30;

end ModificationTests.ArrayModifications5;
")})));
end ArrayModifications5;


model ArrayModifications6
 model B
  Real x[3];
 end B;
 
 B b(x={1,2,3,4});

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications6",
			description="Modifications to arrays: [3] = [4]",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 792, column 8:
  Array size mismatch in declaration of x, size of declaration is [3] and size of binding expression is [4]
")})));
end ArrayModifications6;


model ArrayModifications7
 model B
  Real y;
 end B;
 
 B b(each y=2);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications7",
			description="Modifications to arrays: each [] = []",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 813, column 8:
  The 'each' keyword cannot be applied to members of non-array components
")})));
end ArrayModifications7;


model ArrayModifications8
 model C
  Real x[2];
 end C;
 
 model B
  C y[2];
  Real x[2];
 end B;
 
 B x[2](y(each x={1,2}), x={{10,20},{30,40}});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications8",
			description="Modifications to arrays: arrays of composites: same name on different levels",
			flatModel="
fclass ModificationTests.ArrayModifications8
 Real x[1].y[1].x[1];
 Real x[1].y[1].x[2];
 Real x[1].y[2].x[1];
 Real x[1].y[2].x[2];
 Real x[1].x[1];
 Real x[1].x[2];
 Real x[2].y[1].x[1];
 Real x[2].y[1].x[2];
 Real x[2].y[2].x[1];
 Real x[2].y[2].x[2];
 Real x[2].x[1];
 Real x[2].x[2];
equation
 x[1].y[1].x[1] = 1;
 x[1].y[1].x[2] = 2;
 x[1].y[2].x[1] = 1;
 x[1].y[2].x[2] = 2;
 x[1].x[1] = 10;
 x[1].x[2] = 20;
 x[2].y[1].x[1] = 1;
 x[2].y[1].x[2] = 2;
 x[2].y[2].x[1] = 1;
 x[2].y[2].x[2] = 2;
 x[2].x[1] = 30;
 x[2].x[2] = 40;

end ModificationTests.ArrayModifications8;
")})));
end ArrayModifications8;


model ArrayModifications9
 model C
  Real x[2] = zeros(2);
 end C;
 
 model B
  C y[2];
  Real x[2] = zeros(2);
 end B;
 
 B x[2](y(x(each start=1)), x(start={{10,20},{30,40}}));

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications9",
			description="Modifications to arrays: arrays of composites: same name on different levels, attribute",
			flatModel="
fclass ModificationTests.ArrayModifications9
 Real x[1].y[1].x[1](start = 1);
 Real x[1].y[1].x[2](start = 1);
 Real x[1].y[2].x[1](start = 1);
 Real x[1].y[2].x[2](start = 1);
 Real x[1].x[1](start = 10);
 Real x[1].x[2](start = 20);
 Real x[2].y[1].x[1](start = 1);
 Real x[2].y[1].x[2](start = 1);
 Real x[2].y[2].x[1](start = 1);
 Real x[2].y[2].x[2](start = 1);
 Real x[2].x[1](start = 30);
 Real x[2].x[2](start = 40);
equation
 x[1].y[1].x[1] = 0;
 x[1].y[1].x[2] = 0;
 x[1].y[2].x[1] = 0;
 x[1].y[2].x[2] = 0;
 x[1].x[1] = 0;
 x[1].x[2] = 0;
 x[2].y[1].x[1] = 0;
 x[2].y[1].x[2] = 0;
 x[2].y[2].x[1] = 0;
 x[2].y[2].x[2] = 0;
 x[2].x[1] = 0;
 x[2].x[2] = 0;

end ModificationTests.ArrayModifications9;
")})));
end ArrayModifications9;


model ArrayModifications10
 model C
  Real z[3];
 end C;
 
 model B
  C y[2];
 end B;
 
 B x[2](y(z={{{1,2,3},{4,5,6}},{{7,8,9},{10,11,12}}}));

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications10",
			description="Modifications to arrays: arrays of composites: 3 levels deep, literal modifier on outer",
			flatModel="
fclass ModificationTests.ArrayModifications10
 Real x[1].y[1].z[1];
 Real x[1].y[1].z[2];
 Real x[1].y[1].z[3];
 Real x[1].y[2].z[1];
 Real x[1].y[2].z[2];
 Real x[1].y[2].z[3];
 Real x[2].y[1].z[1];
 Real x[2].y[1].z[2];
 Real x[2].y[1].z[3];
 Real x[2].y[2].z[1];
 Real x[2].y[2].z[2];
 Real x[2].y[2].z[3];
equation
 x[1].y[1].z[1] = 1;
 x[1].y[1].z[2] = 2;
 x[1].y[1].z[3] = 3;
 x[1].y[2].z[1] = 4;
 x[1].y[2].z[2] = 5;
 x[1].y[2].z[3] = 6;
 x[2].y[1].z[1] = 7;
 x[2].y[1].z[2] = 8;
 x[2].y[1].z[3] = 9;
 x[2].y[2].z[1] = 10;
 x[2].y[2].z[2] = 11;
 x[2].y[2].z[3] = 12;

end ModificationTests.ArrayModifications10;
")})));
end ArrayModifications10;


model ArrayModifications11
 model C
  Real z[3] = zeros(3);
 end C;
 
 model B
  C y[2];
 end B;
 
 B x[2](y(z(start={{{1,2,3},{4,5,6}},{{7,8,9},{10,11,12}}})));

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications11",
			description="Modifications to arrays: arrays of composites: 3 levels deep, literal attribute on outer",
			flatModel="
fclass ModificationTests.ArrayModifications11
 Real x[1].y[1].z[1](start = 1);
 Real x[1].y[1].z[2](start = 2);
 Real x[1].y[1].z[3](start = 3);
 Real x[1].y[2].z[1](start = 4);
 Real x[1].y[2].z[2](start = 5);
 Real x[1].y[2].z[3](start = 6);
 Real x[2].y[1].z[1](start = 7);
 Real x[2].y[1].z[2](start = 8);
 Real x[2].y[1].z[3](start = 9);
 Real x[2].y[2].z[1](start = 10);
 Real x[2].y[2].z[2](start = 11);
 Real x[2].y[2].z[3](start = 12);
equation
 x[1].y[1].z[1] = 0;
 x[1].y[1].z[2] = 0;
 x[1].y[1].z[3] = 0;
 x[1].y[2].z[1] = 0;
 x[1].y[2].z[2] = 0;
 x[1].y[2].z[3] = 0;
 x[2].y[1].z[1] = 0;
 x[2].y[1].z[2] = 0;
 x[2].y[1].z[3] = 0;
 x[2].y[2].z[1] = 0;
 x[2].y[2].z[2] = 0;
 x[2].y[2].z[3] = 0;

end ModificationTests.ArrayModifications11;
")})));
end ArrayModifications11;


model ArrayModifications12
 model C
  Real zc[3];
 end C;
 
 model B
  C yb[2];
 end B;
 
 B xa[2](yb(zc=ya));
 Real ya[2,2,3] = {{{1,2,3},{4,5,6}},{{7,8,9},{10,11,12}}};

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ArrayModifications12",
			description="Modifications to arrays: arrays of composites: 3 levels deep, component modifier on outer",
			flatModel="
fclass ModificationTests.ArrayModifications12
 Real xa[1].yb[1].zc[3] = ya[1,1,1:3];
 Real xa[1].yb[2].zc[3] = ya[1,2,1:3];
 Real xa[2].yb[1].zc[3] = ya[2,1,1:3];
 Real xa[2].yb[2].zc[3] = ya[2,2,1:3];
 Real ya[2,2,3] = {{{1,2,3},{4,5,6}},{{7,8,9},{10,11,12}}};

end ModificationTests.ArrayModifications12;
")})));
end ArrayModifications12;


model ArrayModifications13
 model C
  Real zc[3] = zeros(3);
 end C;
 
 model B
  C yb[2];
 end B;
 
 B xa[2](yb(zc(start=za)));
 constant Real za[2,2,3] = {{{1,2,3},{4,5,6}},{{7,8,9},{10,11,12}}};

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications13",
			description="Modifications to arrays: arrays of composites: 3 levels deep, attribute modifier on outer",
			flatModel="
fclass ModificationTests.ArrayModifications13
 Real xa[1].yb[1].zc[1](start = 1.0);
 Real xa[1].yb[1].zc[2](start = 2.0);
 Real xa[1].yb[1].zc[3](start = 3.0);
 Real xa[1].yb[2].zc[1](start = 4.0);
 Real xa[1].yb[2].zc[2](start = 5.0);
 Real xa[1].yb[2].zc[3](start = 6.0);
 Real xa[2].yb[1].zc[1](start = 7.0);
 Real xa[2].yb[1].zc[2](start = 8.0);
 Real xa[2].yb[1].zc[3](start = 9.0);
 Real xa[2].yb[2].zc[1](start = 10.0);
 Real xa[2].yb[2].zc[2](start = 11.0);
 Real xa[2].yb[2].zc[3](start = 12.0);
 constant Real za[1,1,1] = 1;
 constant Real za[1,1,2] = 2;
 constant Real za[1,1,3] = 3;
 constant Real za[1,2,1] = 4;
 constant Real za[1,2,2] = 5;
 constant Real za[1,2,3] = 6;
 constant Real za[2,1,1] = 7;
 constant Real za[2,1,2] = 8;
 constant Real za[2,1,3] = 9;
 constant Real za[2,2,1] = 10;
 constant Real za[2,2,2] = 11;
 constant Real za[2,2,3] = 12;
equation
 xa[1].yb[1].zc[1] = 0;
 xa[1].yb[1].zc[2] = 0;
 xa[1].yb[1].zc[3] = 0;
 xa[1].yb[2].zc[1] = 0;
 xa[1].yb[2].zc[2] = 0;
 xa[1].yb[2].zc[3] = 0;
 xa[2].yb[1].zc[1] = 0;
 xa[2].yb[1].zc[2] = 0;
 xa[2].yb[1].zc[3] = 0;
 xa[2].yb[2].zc[1] = 0;
 xa[2].yb[2].zc[2] = 0;
 xa[2].yb[2].zc[3] = 0;

end ModificationTests.ArrayModifications13;
")})));
end ArrayModifications13;


model ArrayModifications14
 model B
  Real yb[2];
 end B;
 
 B x[2](yb={{1,2},{3,4}}*{{10,20},{30,40}});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications14",
			description="Modifications to arrays: arrays of composites: array expression modifier on outer level",
			flatModel="
fclass ModificationTests.ArrayModifications14
 Real x[1].yb[1];
 Real x[1].yb[2];
 Real x[2].yb[1];
 Real x[2].yb[2];
equation
 x[1].yb[1] = 1 * 10 + 2 * 30;
 x[1].yb[2] = 1 * 20 + 2 * 40;
 x[2].yb[1] = 3 * 10 + 4 * 30;
 x[2].yb[2] = 3 * 20 + 4 * 40;
end ModificationTests.ArrayModifications14;
")})));
end ArrayModifications14;


model ArrayModifications15
 model B
  Real yb[2];
 end B;
 
 B x[2](yb=y*z);
 Real y[2,2] = {{1,2},{3,4}};
 Real z[2,2] = {{10,20},{30,40}};

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications15",
			description="Modifications to arrays: arrays of composites: array expression modifier on outer level",
			flatModel="
fclass ModificationTests.ArrayModifications15
 Real x[1].yb[1];
 Real x[1].yb[2];
 Real x[2].yb[1];
 Real x[2].yb[2];
 Real y[1,1];
 Real y[1,2];
 Real y[2,1];
 Real y[2,2];
 Real z[1,1];
 Real z[1,2];
 Real z[2,1];
 Real z[2,2];
equation
 x[1].yb[1] = y[1,1] * z[1,1] + y[1,2] * z[2,1];
 x[1].yb[2] = y[1,1] * z[1,2] + y[1,2] * z[2,2];
 x[2].yb[1] = y[2,1] * z[1,1] + y[2,2] * z[2,1];
 x[2].yb[2] = y[2,1] * z[1,2] + y[2,2] * z[2,2];
 y[1,1] = 1;
 y[1,2] = 2;
 y[2,1] = 3;
 y[2,2] = 4;
 z[1,1] = 10;
 z[1,2] = 20;
 z[2,1] = 30;
 z[2,2] = 40;
end ModificationTests.ArrayModifications15;
")})));
end ArrayModifications15;


model ArrayModifications16
 model C
  Real x[2];
 end C;
 
 model B
  C y[2];
 end B;
 
 B x[2](y(each x=1));

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications16",
			description="Modifications to arrays: arrays of composites: bad size for 'each'",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1176, column 8:
  Array size mismatch in declaration of each x, size of declaration is [2] and size of binding expression is scalar
")})));
end ArrayModifications16;


model ArrayModifications17
 model C
  Real x[2];
 end C;
 
 model B
  C y[2];
 end B;
 
 B x[2](y(each x={1,2,3}));

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications17",
			description="Modifications to arrays: arrays of composites: bad size for 'each'",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1200, column 8:
  Array size mismatch in declaration of each x, size of declaration is [2] and size of binding expression is [3]
")})));
end ArrayModifications17;


model ArrayModifications18
 model C
  Real x[2] = zeros(2);
 end C;
 
 model B
  C y[2];
 end B;
 
 B x[2](y(x(each start={1,2})));

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications18",
			description="Modifications to arrays: arrays of composites: non-scalar attribute",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1231, column 13:
  The attribute start is declared 'each' and the binding expression is not scalar
")})));
end ArrayModifications18;


model ArrayModifications19
 model C
  parameter Real a [3];
  parameter Real d;
 end C;
 
 C c[5](each a ={1,2,3}, d={1,2,3,4,5});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications19",
			description="Modifications to arrays: arrays of composites: example from MLS v3.1 section 7.2.5",
			flatModel="
fclass ModificationTests.ArrayModifications19
 parameter Real c[1].a[1] = 1 /* 1.0 */;
 parameter Real c[1].a[2] = 2 /* 2.0 */;
 parameter Real c[1].a[3] = 3 /* 3.0 */;
 parameter Real c[1].d = 1 /* 1.0 */;
 parameter Real c[2].a[1] = 1 /* 1.0 */;
 parameter Real c[2].a[2] = 2 /* 2.0 */;
 parameter Real c[2].a[3] = 3 /* 3.0 */;
 parameter Real c[2].d = 2 /* 2.0 */;
 parameter Real c[3].a[1] = 1 /* 1.0 */;
 parameter Real c[3].a[2] = 2 /* 2.0 */;
 parameter Real c[3].a[3] = 3 /* 3.0 */;
 parameter Real c[3].d = 3 /* 3.0 */;
 parameter Real c[4].a[1] = 1 /* 1.0 */;
 parameter Real c[4].a[2] = 2 /* 2.0 */;
 parameter Real c[4].a[3] = 3 /* 3.0 */;
 parameter Real c[4].d = 4 /* 4.0 */;
 parameter Real c[5].a[1] = 1 /* 1.0 */;
 parameter Real c[5].a[2] = 2 /* 2.0 */;
 parameter Real c[5].a[3] = 3 /* 3.0 */;
 parameter Real c[5].d = 5 /* 5.0 */;

end ModificationTests.ArrayModifications19;
")})));
end ArrayModifications19;


model ArrayModifications20
 model C
  Real z[3];
 end C;
 
 model B
  C y[2];
 end B;
 
 B x[2](y(z={{{1,2},{3,4},{5,6}},{{7,8},{9,10},{11,12}}}));

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications20",
			description="Modifications to arrays: arrays of composites: wrong size of binding exp",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1248, column 8:
  Array size mismatch in declaration of z, size of declaration is [2, 2, 3] and size of binding expression is [2, 3, 2]
")})));
end ArrayModifications20;


model ArrayModifications21
 model C
  Real z[3] = zeros(3);
 end C;
 
 model B
  C y[2];
 end B;
 
 B x[2](y(z(start={{{1,2},{3,4},{5,6}},{{7,8},{9,10},{11,12}}})));

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications21",
			description="Modifications to arrays: arrays of composites: wrong size of attribute",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1279, column 12:
  Array size mismatch for the attribute start, size of declaration is [2, 2, 3] and size of start expression is [2, 3, 2]
")})));
end ArrayModifications21;


model ArrayModifications22
 model C
  Real zc[3];
 end C;
 
 model B
  C yb[2];
 end B;
 
 B xa[2](yb(zc=ya));
 Real ya[2,3,2] = {{{1,2},{3,4},{5,6}},{{7,8},{9,10},{11,12}}};

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications22",
			description="Modifications to arrays: arrays of composites: wrong size of binding exp (through access)",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1296, column 8:
  Array size mismatch in declaration of zc, size of declaration is [2, 2, 3] and size of binding expression is [2, 3, 2]
")})));
end ArrayModifications22;


model ArrayModifications23
 model C
  Real zc[3] = zeros(3);
 end C;
 
 model B
  C yb[2];
 end B;
 
 B xa[2](yb(zc(start=za)));
 constant Real za[2,3,2] = {{{1,2},{3,4},{5,6}},{{7,8},{9,10},{11,12}}};

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications23",
			description="Modifications to arrays: arrays of composites: wrong size of attribute (through access)",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1328, column 15:
  Array size mismatch for the attribute start, size of declaration is [2, 2, 3] and size of start expression is [2, 3, 2]
")})));
end ArrayModifications23;


model ArrayModifications24
 model B
  Real yb[2];
 end B;
 
 B x[2](yb={{1,2},{3,4}}*{{10,20,30},{40,50,60}});

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications24",
			description="Modifications to arrays: arrays of composites: wrong size of binding exp (through expression)",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1346, column 8:
  Array size mismatch in declaration of yb, size of declaration is [2, 2] and size of binding expression is [2, 3]
")})));
end ArrayModifications24;


model ArrayModifications25
 model B
  Real yb[2];
 end B;
 
 B x[2](yb=y*z);
 Real y[2,2] = {{1,2},{3,4}};
 Real z[2,3] = {{10,20,30},{40,50,60}};

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications25",
			description="Modifications to arrays: arrays of composites: wrong size of binding exp (through expression with accesses)",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1366, column 8:
  Array size mismatch in declaration of yb, size of declaration is [2, 2] and size of binding expression is [2, 3]
")})));
end ArrayModifications25;


model ArrayModifications26
 Real x1[2,3] = y[1,:,:] .+ 1;
 Real x2[2,3] = y[2,:,:] .+ 1;
 Real y[2,2,3] = {{{1,2,3},{4,5,6}},{{7,8,9},{10,11,12}}};

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications26",
			description="Modifications to arrays: scalarisation of accesses with colon subscrpt",
			flatModel="
fclass ModificationTests.ArrayModifications26
 Real x1[1,1];
 Real x1[1,2];
 Real x1[1,3];
 Real x1[2,1];
 Real x1[2,2];
 Real x1[2,3];
 Real x2[1,1];
 Real x2[1,2];
 Real x2[1,3];
 Real x2[2,1];
 Real x2[2,2];
 Real x2[2,3];
 Real y[1,1,1];
 Real y[1,1,2];
 Real y[1,1,3];
 Real y[1,2,1];
 Real y[1,2,2];
 Real y[1,2,3];
 Real y[2,1,1];
 Real y[2,1,2];
 Real y[2,1,3];
 Real y[2,2,1];
 Real y[2,2,2];
 Real y[2,2,3];
equation
 x1[1,1] = y[1,1,1] .+ 1;
 x1[1,2] = y[1,1,2] .+ 1;
 x1[1,3] = y[1,1,3] .+ 1;
 x1[2,1] = y[1,2,1] .+ 1;
 x1[2,2] = y[1,2,2] .+ 1;
 x1[2,3] = y[1,2,3] .+ 1;
 x2[1,1] = y[2,1,1] .+ 1;
 x2[1,2] = y[2,1,2] .+ 1;
 x2[1,3] = y[2,1,3] .+ 1;
 x2[2,1] = y[2,2,1] .+ 1;
 x2[2,2] = y[2,2,2] .+ 1;
 x2[2,3] = y[2,2,3] .+ 1;
 y[1,1,1] = 1;
 y[1,1,2] = 2;
 y[1,1,3] = 3;
 y[1,2,1] = 4;
 y[1,2,2] = 5;
 y[1,2,3] = 6;
 y[2,1,1] = 7;
 y[2,1,2] = 8;
 y[2,1,3] = 9;
 y[2,2,1] = 10;
 y[2,2,2] = 11;
 y[2,2,3] = 12;

end ModificationTests.ArrayModifications26;
")})));
end ArrayModifications26;


model ArrayModifications27
 model B
  Real yb[2];
 end B;
 
 B x[2](yb(start={{1,2},{3,4}}*{{10,20},{30,40}}) = {{1,2},{3,4}});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications27",
			description="Modifications to arrays: arrays of composites: array expression attribute on outer level",
			flatModel="
fclass ModificationTests.ArrayModifications27
 Real x[1].yb[1](start = 1 * 10 + 2 * 30);
 Real x[1].yb[2](start = 1 * 20 + 2 * 40);
 Real x[2].yb[1](start = 3 * 10 + 4 * 30);
 Real x[2].yb[2](start = 3 * 20 + 4 * 40);
equation
 x[1].yb[1] = 1;
 x[1].yb[2] = 2;
 x[2].yb[1] = 3;
 x[2].yb[2] = 4;
end ModificationTests.ArrayModifications27;
")})));
end ArrayModifications27;


model ArrayModifications28
 model B
  Real yb[2];
 end B;
 
 B x[2](yb(start=y*z) = {{1,2},{3,4}});
 constant Real y[2,2] = {{1,2},{3,4}};
 constant Real z[2,2] = {{10,20},{30,40}};

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications28",
			description="Modifications to arrays: arrays of composites: array expression (with constants) attribute on outer level",
			flatModel="
fclass ModificationTests.ArrayModifications28
 Real x[1].yb[1](start = 1.0 * 10.0 + 2.0 * 30.0);
 Real x[1].yb[2](start = 1.0 * 20.0 + 2.0 * 40.0);
 Real x[2].yb[1](start = 3.0 * 10.0 + 4.0 * 30.0);
 Real x[2].yb[2](start = 3.0 * 20.0 + 4.0 * 40.0);
 constant Real y[1,1] = 1;
 constant Real y[1,2] = 2;
 constant Real y[2,1] = 3;
 constant Real y[2,2] = 4;
 constant Real z[1,1] = 10;
 constant Real z[1,2] = 20;
 constant Real z[2,1] = 30;
 constant Real z[2,2] = 40;
equation
 x[1].yb[1] = 1;
 x[1].yb[2] = 2;
 x[2].yb[1] = 3;
 x[2].yb[2] = 4;
end ModificationTests.ArrayModifications28;
")})));
end ArrayModifications28;


model ArrayModifications29
 model B
  Real yb[2];
 end B;
 
 B x[2](yb(start={{1,2},{3,4}}*{{10,20,30},{40,50,60}}));

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications29",
			description="Modifications to arrays: arrays of composites: wrong size of attribute (through expression)",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1510, column 11:
  Array size mismatch for the attribute start, size of declaration is [2, 2] and size of start expression is [2, 3]
")})));
end ArrayModifications29;


model ArrayModifications30
 model B
  Real yb[2];
 end B;
 
 B x[2](yb(start=y*z));
 constant Real y[2,2] = {{1,2},{3,4}};
 constant Real z[2,3] = {{10,20,30},{40,50,60}};

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications30",
			description="Modifications to arrays: arrays of composites: wrong size of attribute (through expression with accesses)",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1530, column 11:
  Array size mismatch for the attribute start, size of declaration is [2, 2] and size of start expression is [2, 3]
")})));
end ArrayModifications30;


model ArrayModifications31
 model C
  Real x[2] = {1,2};
 end C;
 
 model B
  C y[2];
 end B;
 
 B x[2];

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications31",
			description="Modifications to arrays: arrays of composites: 3 levels deep, binding exp on inner",
			flatModel="
fclass ModificationTests.ArrayModifications31
 Real x[1].y[1].x[1];
 Real x[1].y[1].x[2];
 Real x[1].y[2].x[1];
 Real x[1].y[2].x[2];
 Real x[2].y[1].x[1];
 Real x[2].y[1].x[2];
 Real x[2].y[2].x[1];
 Real x[2].y[2].x[2];
equation
 x[1].y[1].x[1] = 1;
 x[1].y[1].x[2] = 2;
 x[1].y[2].x[1] = 1;
 x[1].y[2].x[2] = 2;
 x[2].y[1].x[1] = 1;
 x[2].y[1].x[2] = 2;
 x[2].y[2].x[1] = 1;
 x[2].y[2].x[2] = 2;

end ModificationTests.ArrayModifications31;
")})));
end ArrayModifications31;


model ArrayModifications32
 model C
  Real x[2](start={1,2}) = {3,4};
 end C;
 
 model B
  C y[2];
 end B;
 
 B x[2];

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications32",
			description="Modifications to arrays: arrays of composites: 3 levels deep, attribute on inner",
			flatModel="
fclass ModificationTests.ArrayModifications32
 Real x[1].y[1].x[1](start = 1);
 Real x[1].y[1].x[2](start = 2);
 Real x[1].y[2].x[1](start = 1);
 Real x[1].y[2].x[2](start = 2);
 Real x[2].y[1].x[1](start = 1);
 Real x[2].y[1].x[2](start = 2);
 Real x[2].y[2].x[1](start = 1);
 Real x[2].y[2].x[2](start = 2);
equation
 x[1].y[1].x[1] = 3;
 x[1].y[1].x[2] = 4;
 x[1].y[2].x[1] = 3;
 x[1].y[2].x[2] = 4;
 x[2].y[1].x[1] = 3;
 x[2].y[1].x[2] = 4;
 x[2].y[2].x[1] = 3;
 x[2].y[2].x[2] = 4;

end ModificationTests.ArrayModifications32;
")})));
end ArrayModifications32;


model ArrayModifications33
 model C
  Real x[2];
 end C;
 
 model B
  C y[2](x={{1,2},{3,4}});
 end B;
 
 B x[2];

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications33",
			description="Modifications to arrays: arrays of composites: 3 levels deep, binding exp on middle",
			flatModel="
fclass ModificationTests.ArrayModifications33
 Real x[1].y[1].x[1];
 Real x[1].y[1].x[2];
 Real x[1].y[2].x[1];
 Real x[1].y[2].x[2];
 Real x[2].y[1].x[1];
 Real x[2].y[1].x[2];
 Real x[2].y[2].x[1];
 Real x[2].y[2].x[2];
equation
 x[1].y[1].x[1] = 1;
 x[1].y[1].x[2] = 2;
 x[1].y[2].x[1] = 3;
 x[1].y[2].x[2] = 4;
 x[2].y[1].x[1] = 1;
 x[2].y[1].x[2] = 2;
 x[2].y[2].x[1] = 3;
 x[2].y[2].x[2] = 4;

end ModificationTests.ArrayModifications33;
")})));
end ArrayModifications33;


model ArrayModifications34
 model C
  Real x[2] = {3,4};
 end C;
 
 model B
  C y[2](x(start={{1,2},{3,4}}));
 end B;
 
 B x[2];

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications34",
			description="Modifications to arrays: arrays of composites: 3 levels deep, attribute on middle",
			flatModel="
fclass ModificationTests.ArrayModifications34
 Real x[1].y[1].x[1](start = 1);
 Real x[1].y[1].x[2](start = 2);
 Real x[1].y[2].x[1](start = 3);
 Real x[1].y[2].x[2](start = 4);
 Real x[2].y[1].x[1](start = 1);
 Real x[2].y[1].x[2](start = 2);
 Real x[2].y[2].x[1](start = 3);
 Real x[2].y[2].x[2](start = 4);
equation
 x[1].y[1].x[1] = 3;
 x[1].y[1].x[2] = 4;
 x[1].y[2].x[1] = 3;
 x[1].y[2].x[2] = 4;
 x[2].y[1].x[1] = 3;
 x[2].y[1].x[2] = 4;
 x[2].y[2].x[1] = 3;
 x[2].y[2].x[2] = 4;

end ModificationTests.ArrayModifications34;
")})));
end ArrayModifications34;


model ArrayModifications35
 model C
  Real x[2] = {1,2,3};
 end C;
 
 model B
  C y[2];
 end B;
 
 B x[2];

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications35",
			description="Modifications to arrays: arrays of composites: 3 levels deep, binding exp on inner, wrong size",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1687, column 8:
  Array size mismatch in declaration of x, size of declaration is [2] and size of binding expression is [3]
")})));
end ArrayModifications35;


model ArrayModifications36
 model C
  Real x[2] = {{1,2},{3,4}};
 end C;
 
 model B
  C y[2];
 end B;
 
 B x[2];

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications36",
			description="Modifications to arrays: arrays of composites: 3 levels deep, binding exp on inner, wrong size",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1711, column 8:
  Array size mismatch in declaration of x, size of declaration is [2] and size of binding expression is [2, 2]
")})));
end ArrayModifications36;


model ArrayModifications37
 model C
  Real x[2];
 end C;
 
 model B
  C y[2](x = {1,2});
 end B;
 
 B x[2];

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications37",
			description="Modifications to arrays: inferring each: 3 levels deep, binding exp on middle",
			flatModel="
fclass ModificationTests.ArrayModifications37
 Real x[1].y[1].x[1];
 Real x[1].y[1].x[2];
 Real x[1].y[2].x[1];
 Real x[1].y[2].x[2];
 Real x[2].y[1].x[1];
 Real x[2].y[1].x[2];
 Real x[2].y[2].x[1];
 Real x[2].y[2].x[2];
equation
 x[1].y[1].x[1] = 1;
 x[1].y[1].x[2] = 2;
 x[1].y[2].x[1] = 1;
 x[1].y[2].x[2] = 2;
 x[2].y[1].x[1] = 1;
 x[2].y[1].x[2] = 2;
 x[2].y[2].x[1] = 1;
 x[2].y[2].x[2] = 2;

end ModificationTests.ArrayModifications37;
")})));
end ArrayModifications37;


model ArrayModifications38
 model C
  Real x[2];
 end C;
 
 model B
  C y[2](x = {{1,2,3},{4,5,6}});
 end B;
 
 B x[2];

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications38",
			description="Modifications to arrays: arrays of composites: 3 levels deep, binding exp on middle, wrong size",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1759, column 8:
  Array size mismatch in declaration of x, size of declaration is [2, 2] and size of binding expression is [2, 3]
")})));
end ArrayModifications38;


model ArrayModifications39
 model C
  Real x[2];
 end C;
 
 model B
  C y[2](x = {{{1,2},{3,4}},{{5,6},{7,8}}});
 end B;
 
 B x[2];

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications39",
			description="Modifications to arrays: arrays of composites: 3 levels deep, binding exp on middle, wrong size",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1783, column 8:
  Array size mismatch in declaration of x, size of declaration is [2, 2] and size of binding expression is [2, 2, 2]
")})));
end ArrayModifications39;


model ArrayModifications40
 model C
  Real x[2](start = {1,2,3});
 end C;
 
 model B
  C y[2];
 end B;
 
 B x[2];

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications40",
			description="Modifications to arrays: arrays of composites: 3 levels deep, attribute on inner, wrong size",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1807, column 12:
  Array size mismatch for the attribute start, size of declaration is [2] and size of start expression is [3]
")})));
end ArrayModifications40;


model ArrayModifications41
 model C
  Real x[2](start = {{1,2},{3,4}});
 end C;
 
 model B
  C y[2];
 end B;
 
 B x[2];

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications41",
			description="Modifications to arrays: arrays of composites: 3 levels deep, attribute on inner, wrong size",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1831, column 12:
  Array size mismatch for the attribute start, size of declaration is [2] and size of start expression is [2, 2]
")})));
end ArrayModifications41;


model ArrayModifications42
 model C
  Real x[2];
 end C;
 
 model B
  C y[2](x(start = {1,2}));
 end B;
 
 B x[2];

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications42",
			description="Modifications to arrays: arrays of composites: 3 levels deep, attribute on middle, wrong size",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1859, column 11:
  Array size mismatch for the attribute start, size of declaration is [2, 2] and size of start expression is [2]
")})));
end ArrayModifications42;


model ArrayModifications43
 model C
  Real x[2];
 end C;
 
 model B
  C y[2](x(start = {{1,2,3},{4,5,6}}));
 end B;
 
 B x[2];

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications43",
			description="Modifications to arrays: arrays of composites: 3 levels deep, attribute on middle, wrong size",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1883, column 11:
  Array size mismatch for the attribute start, size of declaration is [2, 2] and size of start expression is [2, 3]
")})));
end ArrayModifications43;


model ArrayModifications44
 model C
  Real x[2];
 end C;
 
 model B
  C y[2](x(start = {{{1,2},{3,4}},{{5,6},{7,8}}}));
 end B;
 
 B x[2];

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ArrayModifications44",
			description="Modifications to arrays: arrays of composites: 3 levels deep, attribute on middle, wrong size",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ModificationTests.mo':
Semantic error at line 1907, column 11:
  Array size mismatch for the attribute start, size of declaration is [2, 2] and size of start expression is [2, 2, 2]
")})));
end ArrayModifications44;


model ArrayModifications45
 Real x[2](start=0) = {1,2};

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications45",
			description="Modifications to arrays: inferring each: attribute",
			flatModel="
fclass ModificationTests.ArrayModifications45
 Real x[1](start = 0);
 Real x[2](start = 0);
equation
 x[1] = 1;
 x[2] = 2;

end ModificationTests.ArrayModifications45;
")})));
end ArrayModifications45;


model ArrayModifications46
 model A
  Real x[2];
 end A;
 
 A y[2](x = {1,2});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ArrayModifications46",
			description="Modifications to arrays: inferring each: binding expression",
			flatModel="
fclass ModificationTests.ArrayModifications46
 Real y[1].x[1];
 Real y[1].x[2];
 Real y[2].x[1];
 Real y[2].x[2];
equation
 y[1].x[1] = 1;
 y[1].x[2] = 2;
 y[2].x[1] = 1;
 y[2].x[2] = 2;

end ModificationTests.ArrayModifications46;
")})));
end ArrayModifications46;


model ArrayModifications47
    model A
        Real x;
    end A;
    
    model B
        Real y;
    end B;
    
    A a[2](x = b.y);
    B b[2](y = {1, 2});

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ArrayModifications47",
			description="Dotted name as modifier to array of components",
			flatModel="
fclass ModificationTests.ArrayModifications47
 Real a[1].x = b[1].y;
 Real a[2].x = b[2].y;
 Real b[1].y = 1;
 Real b[2].y = 2;
end ModificationTests.ArrayModifications47;
")})));
end ArrayModifications47;



/* ========= Modifications on type declarations ========= */

type TypeA = Real(final quantity="A", unit="1");


model TypeModifications1
 TypeA x[3] = {1, 2, 3};

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="TypeModifications1",
			description="Type declarations with modifications: array of new type",
			flatModel="
fclass ModificationTests.TypeModifications1
 ModificationTests.TypeA x[3] = {1,2,3};

public
 type ModificationTests.TypeA = Real(final quantity = \"A\",unit = \"1\");
end ModificationTests.TypeModifications1;
")})));
end TypeModifications1;


model TypeModifications2
 model B
  TypeA x[3] = {1, 2, 3};
 end B;
 
 B y[3];

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="TypeModifications2",
			description="Type declarations with modifications: array of components containing array of new type",
			flatModel="
fclass ModificationTests.TypeModifications2
 ModificationTests.TypeA y[1].x[3] = {1,2,3};
 ModificationTests.TypeA y[2].x[3] = {1,2,3};
 ModificationTests.TypeA y[3].x[3] = {1,2,3};

public
 type ModificationTests.TypeA = Real(final quantity = \"A\",unit = \"1\");
end ModificationTests.TypeModifications2;
")})));
end TypeModifications2;


model ModelB
 Real x(start=1) = 1;
 TypeA y = 1;
end ModelB;


model TypeModifications3
 ModelB z[2](y(start={2,3}));

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="TypeModifications3",
			description="Type declarations with modifications: modifying type in component decl",
			flatModel="
fclass ModificationTests.TypeModifications3
 Real z[1].x(start = 1) = 1;
 ModificationTests.TypeA z[1].y(start = 2) = 1;
 Real z[2].x(start = 1) = 1;
 ModificationTests.TypeA z[2].y(start = 3) = 1;

public
 type ModificationTests.TypeA = Real(final quantity = \"A\",unit = \"1\");
end ModificationTests.TypeModifications3;
")})));
end TypeModifications3;


type TypeC = ModelB(y(final start=1));


// TODO: Something is wrong with how this is handled
model TypeModifications4
 TypeC x[3];
end TypeModifications4;



model ConstMod1
	record A
		Real x;
	end A;
	
	package B
		constant A y;
	end B;
	
	package C
		extends B(y = A(1));
	end C;
	
	package D
		replaceable package E = A;
	end D;
	
	package F
		extends D;
		redeclare replaceable package E = C constrainedby A;
	end F;
	
	Real z = F.E.y.x;
end ConstMod1;



end ModificationTests;
