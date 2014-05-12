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


package RedeclareTests


model RedeclareTestOx1 "Basic redeclare test"
 // This is perfectly ok.
 
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
   model C
     replaceable A a;
   end C;
 
   C c(redeclare B a);
 

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTestOx1",
			description="Basic redeclares.",
			flatModel="
fclass RedeclareTests.RedeclareTestOx1
 Real c.a.x = 2 /*(2)*/;
 Real c.a.y = 3 /*(3)*/;
end RedeclareTests.RedeclareTestOx1;
")})));
end RedeclareTestOx1;
 
model RedeclareTestOx2_Err "Basic redeclare test, erroneous"
 
/*
  Should give an error message like
  Error in redeclaration in component:
    C c(redeclare A b)
   component 'A b' is not a subtype of component 'B a'.
   
   
   
 
*/
 
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
   model C
     replaceable B b;
   end C;
   // Here is the error
   C c(redeclare A b);
 

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="RedeclareTestOx2_Err",
			description="Test basic redeclares. Error caused by failed subtype test in component redeclaration.",
			errorMessage="
1 errors found:
Error: in file 'src/test/modelica/RedeclareTests.mo':
Semantic error at line 71, column 8:
  In the declaration 'redeclare A b', the replacing class is not a subtype of the constraining class from the declaration 'replaceable B b'
")})));
end RedeclareTestOx2_Err;
 
model RedeclareTestOx3 "Redeclare deeper into instance hierarchy."


 
  // Perfectly ok.
 
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
   model C
     replaceable A a;
   end C;
 
   model D
     C c;
   end D;
 
   D d(c(redeclare B a));
 

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTestOx3",
			description="Basic test of redeclares.",
			flatModel="
fclass RedeclareTests.RedeclareTestOx3
 Real d.c.a.x = 2 /*(2)*/;
 Real d.c.a.y = 3 /*(3)*/;
end RedeclareTests.RedeclareTestOx3;
")})));
end RedeclareTestOx3;
 
model RedeclareTestOx4_Err "Redeclare deeper into instance hierarchy."
 
  
/*
  Should give an error message like
  Error in redeclaration in component:
    D d(c(redeclare A b)) in class RedeclareTestOx4_Err
   component 'A b' is not a subtype of component 'B b'.
   Original declaration located in class C. 
   Instance name of original declaration: d.c.b   
 
 
 
*/
 
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
   model C
     replaceable B b;
   end C;
 
   model D
     C c;
   end D;
 
   D d(c(redeclare A b));
 

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="RedeclareTestOx4_Err",
			description="Test basic redeclares. Error caused by failed subtype test in component redeclaration.",
			errorMessage="
1 errors found:
Error: in file 'src/test/modelica/RedeclareTests.mo':
Semantic error at line 159, column 10:
  In the declaration 'redeclare A b', the replacing class is not a subtype of the constraining class from the declaration 'replaceable B b'
")})));
end RedeclareTestOx4_Err;
 
model RedeclareTestOx5 "Redeclare deeper into instance hierarchy and redeclaration of a replacing component."
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;
 
   model D
     replaceable A a;
   end D;
 
   model E
     D d(redeclare B a);
   end E;
 
   E e(d(redeclare C a));
 

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTestOx5",
			description="Basic test of redeclares.",
			flatModel="
fclass RedeclareTests.RedeclareTestOx5
 Real e.d.a.x = 2 /*(2)*/;
 Real e.d.a.y = 3 /*(3)*/;
 Real e.d.a.z = 4 /*(4)*/;
end RedeclareTests.RedeclareTestOx5;
")})));
end RedeclareTestOx5;
 
model RedeclareTestOx6_Err 
    "Redeclare deeper into instance hierarchy and redeclaration of a replacing component, Errouneous?"
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;
 
   model D
     replaceable A a;
   end D;
 
   model E
     D d(redeclare replaceable C a);
     Real q = d.a.z; // This should not be ok since the constraining class of component a is A.
   end E;
 
   E e(d(redeclare B a)); // This redeclaration should be ok since B is a subtype of A!
 
end RedeclareTestOx6_Err;

 
model RedeclareTestOx65_Err "Redeclare deeper into instance hierarchy and redeclaration of a replacing component, Errouneous?"
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;
 
   model D
     replaceable B a;
   end D;
 
   model E
     D d(redeclare replaceable A a);
   end E;
 
   E e(d(redeclare C a)); 

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="RedeclareTestOx65_Err",
			description="Test basic redeclares. Error caused by failed subtype test in component redeclaration.",
			errorMessage="
1 errors found:
Error: in file 'src/test/modelica/RedeclareTests.mo':
Semantic error at line 276, column 10:
  In the declaration 'redeclare replaceable A a', the replacing class is not a subtype of the constraining class from the declaration 'replaceable B a'
")})));
end RedeclareTestOx65_Err;
 
 
model RedeclareTestOx7_Err 
    "Redeclare deeper into instance hierarchy and redeclaration of a replacing component, Errouneous?"
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;
 
   model D
     replaceable model AA = A;
     AA a;
   end D;
 
   model E
     D d(redeclare replaceable model AA=C);
     Real q = d.a.z; // This should not be ok!
   end E;
 
   E e(d(redeclare model AA=B)); // This redeclaration should be ok since B is a subtype of A!
 
	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="RedeclareTestOx7_Err",
			description="Using var not available in final type without explicit constrainedby",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/RedeclareTests.mo':
Semantic error at line 283, column 19:
  Cannot find class or component declaration for z
")})));
end RedeclareTestOx7_Err;
 
model RedeclareTestOx8 "Constraining clause example"
 
 
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;
 
   model D
     replaceable C c constrainedby B;
   end D;
   // Ok, since the constraining clause of C c is B.
   D d(redeclare B c);
 

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTestOx8",
			description="Basic test of redeclares.",
			flatModel="
fclass RedeclareTests.RedeclareTestOx8
 Real d.c.x = 2 /*(2)*/;
 Real d.c.y = 3 /*(3)*/;
end RedeclareTests.RedeclareTestOx8;
")})));
end RedeclareTestOx8;
 
model RedeclareTestOx9_Err "Constraining clause example, errouneous"
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;
 
   model D
     replaceable C c constrainedby B;
   end D;
 
   D d(redeclare A c);
 

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="RedeclareTestOx9_Err",
			description="Test basic redeclares. Error caused by failed subtype test in component redeclaration.",
			errorMessage="
1 errors found:
Error: in file 'src/test/modelica/RedeclareTests.mo':
Semantic error at line 399, column 8:
  In the declaration 'redeclare A c', the replacing class is not a subtype of the constraining class from the declaration 'replaceable C c constrainedby B'
")})));
end RedeclareTestOx9_Err;


model RedeclareTestOx95_Err "Constraining clause example, errouneous"
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;
 
   model D
     replaceable B b constrainedby C;
   end D;
 
   D d;
 

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="RedeclareTestOx95_Err",
			description="Check that the declaration is a subtype of the constraining clause",
			errorMessage="
1 errors found:
Error: in file 'src/test/modelica/RedeclareTests.mo':
Semantic error at line 450, column 10:
  In the declaration 'replaceable B b constrainedby C', the declared class is not a subtype of the constraining class
")})));
end RedeclareTestOx95_Err;


model RedeclareTestOx10 "Constraining clause example."
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;
 
   model D
     replaceable B c constrainedby B;
   end D;
 
   model E
     // This is actually ok since the replacing component does not have an
     // explicit constraining clause, in which case the constraining clause
     // of the original declaration is used.
     replaceable D d constrainedby D(redeclare replaceable C c);
   end E;
 
   E e(redeclare D d(redeclare B c));
 

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTestOx10",
			description="Basic test of redeclares.",
			flatModel="
fclass RedeclareTests.RedeclareTestOx10
 Real e.d.c.x = 2;
 Real e.d.c.y = 3;
end RedeclareTests.RedeclareTestOx10;
")})));
end RedeclareTestOx10;


model RedeclareTestOx11_Err "Constraining clause example."
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;
 
   model D
     replaceable B c;
   end D;
 
   model E
     // This is an error
     replaceable D d constrainedby D(redeclare replaceable B c constrainedby A);
   end E;
   
   // This is another error
   E e(redeclare D d(redeclare A c));

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="RedeclareTestOx11_Err",
			description="Check that the declaration is a subtype of the constraining clause",
			errorMessage="
2 errors found:

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/RedeclareTests.mo':
Semantic error at line 537, column 38:
  In the declaration 'redeclare replaceable B c constrainedby A', the replacing class is not a subtype of the constraining class from the declaration 'replaceable B c'
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/RedeclareTests.mo':
Semantic error at line 541, column 8:
  In the declaration 'redeclare D d(redeclare A c)', the replacing class is not a subtype of the constraining class from the declaration 'replaceable D d constrainedby D (redeclare replaceable B c constrainedby A)'
")})));
end RedeclareTestOx11_Err;


model RedeclareTestOx115_Err "Constraining clause example."
/*
  Should give an error message like
  Error: in file 'src/test/modelica/RedeclareTests.mo':
Semantic error at line 431, column 32:
  'B' is not a subtype of 'C'
*/
 
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;
 
   model D
     replaceable B c;
   end D;
 
   model E
     replaceable D d(redeclare replaceable C c constrainedby C) constrainedby D(redeclare replaceable B c constrainedby C);
   end E;

   E e;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="RedeclareTestOx115_Err",
			description="Check that the declaration is a subtype of the constraining clause",
			errorMessage="
1 errors found:
Error: in file 'src/test/modelica/RedeclareTests.mo':
Semantic error at line 601, column 69:
  In the declaration 'redeclare replaceable B c constrainedby C', the declared class is not a subtype of the constraining class
")})));
end RedeclareTestOx115_Err;


model RedeclareTestOx116_Err "Constraining clause example."
/*
  Should give an error message like
  Error: in file 'src\test\modelica\RedeclareTests.mo':
Semantic error at line 470, column 58:
  'A' is not a subtype of 'B'
 */
 
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;
 
   model D
     replaceable B c;
   end D;
 
   model E 
     // This is an error because the constraining clause of C c constrainedby A is not a subtype of B c
     replaceable D d constrainedby D(redeclare replaceable C c constrainedby A);
   end E;
 
   E e;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="RedeclareTestOx116_Err",
			description="Check that the declaration is a subtype of the constraining clause",
			errorMessage="
1 errors found:
Error: in file 'src/test/modelica/RedeclareTests.mo':
Semantic error at line 651, column 32:
  In the declaration 'redeclare replaceable C c constrainedby A', the replacing class is not a subtype of the constraining class from the declaration 'replaceable B c'
")})));
end RedeclareTestOx116_Err;


/* Does not work - the modification of y is reported as an error.
model RedeclareTestOx12 "Constraining clause example."
 
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
   model D
     //Here the modifiers (x=3,y=3) are not used when the component is redeclared.
     replaceable B c(x=3,y=5) constrainedby A(x=5);
   end D;
 
   D d(redeclare A c);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTestOx12",
			description="Check that the declaration is a subtype of the constraining clause",
			flatModel="
fclass RedeclareTests.RedeclareTestOx12
 Real d.c.x = 5;
end RedeclareTests.RedeclareTestOx12;
")})));
end RedeclareTestOx12;
*/
 

model RedeclareTestOx13 "Constraining clause example."
 
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;
 
   model D
     replaceable A c;
   end D;
 
   model E
     D d( redeclare replaceable B c(y=10) constrainedby A(x=4));
   end E;
 
   E e(d(redeclare C c(z=5)));
 

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTestOx13",
			description="Check that the declaration is a subtype of the constraining clause",
			flatModel="
fclass RedeclareTests.RedeclareTestOx13
 Real e.d.c.x = 4 /*(4)*/;
 Real e.d.c.y = 3 /*(3)*/;
 Real e.d.c.z = 5 /*(5)*/;
end RedeclareTests.RedeclareTestOx13;
")})));
end RedeclareTestOx13;


model RedeclareTest_Constr_14_Err "Constraining clause example."
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;
 
   model D
     replaceable A c;
   end D;
 
   model E
     // Here is the error: A is not a subtype of C
     D d(redeclare replaceable B c constrainedby C);
   end E;
 
   E e(d(redeclare C c));
 

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="RedeclareTest_Constr_14_Err",
			description="Check that the declaration is a subtype of the constraining clause",
			errorMessage="
1 errors found:
Error: in file 'src/test/modelica/RedeclareTests.mo':
Semantic error at line 752, column 10:
  In the declaration 'redeclare replaceable B c constrainedby C', the declared class is not a subtype of the constraining class
")})));
end RedeclareTest_Constr_14_Err;


model RedeclareTest_Constr_15_Err "Constraining clause example."
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;
 
   model D
     replaceable A c;
   end D;
 
   model E
     // Here is the error: B is not a subtype of C
     D d(redeclare replaceable B c constrainedby C);
   end E;
 
   E e(d(redeclare replaceable C c));

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="RedeclareTest_Constr_15_Err",
			description="Check that the declaration is a subtype of the constraining clause",
			errorMessage="
1 errors found:
Error: in file 'src/test/modelica/RedeclareTests.mo':
Semantic error at line 790, column 10:
  In the declaration 'redeclare replaceable B c constrainedby C', the declared class is not a subtype of the constraining class
")})));
end RedeclareTest_Constr_15_Err;


model RedeclareTest_Constr_16_Err "Constraining clause example."
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;
 
   model D
     replaceable A c;
   end D;
 
   model E
     // Here is the error: B is not a subtype of C
     D d(redeclare replaceable B c constrainedby B);
   end E;
 
   E e(d(redeclare replaceable A c));

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="RedeclareTest_Constr_16_Err",
			description="Check that the declaration is a subtype of the constraining clause",
			errorMessage="
1 errors found:
Error: in file 'src/test/modelica/RedeclareTests.mo':
Semantic error at line 837, column 10:
  In the declaration 'redeclare replaceable A c', the replacing class is not a subtype of the constraining class from the declaration 'redeclare replaceable B c constrainedby B'
")})));
end RedeclareTest_Constr_16_Err;


model RedeclareTest_Constr_17_Err "Constraining clause example."
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;
 
   model D
     replaceable A c;
   end D;
 
   model E
     // Here is the error: B is not a subtype of C
     replaceable D d(redeclare replaceable B c constrainedby B);
   end E;
 
   E e(redeclare replaceable D d(redeclare replaceable B c) constrainedby D(redeclare replaceable C c constrainedby C));

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="RedeclareTest_Constr_17_Err",
			description="Check that the declaration is a subtype of the constraining clause",
			errorMessage="
1 errors found:
Error: in file 'src/test/modelica/RedeclareTests.mo':
Semantic error at line 884, column 34:
  In the declaration 'redeclare replaceable B c', the replacing class is not a subtype of the constraining class from the declaration 'redeclare replaceable C c constrainedby C'
")})));
end RedeclareTest_Constr_17_Err;


model RedeclareTest_Constr_18_Err "Constraining clause example."
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;
 
   model D
     replaceable C c constrainedby C;
   end D;
 
   model E
     // Notice that the modifier in the constraining clause is applied to the declaration itself
     // and is therefore type checked.
     replaceable D d constrainedby D(redeclare replaceable B c);
   end E;
 
   E e;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="RedeclareTest_Constr_18_Err",
			description="Check that the declaration is a subtype of the constraining clause",
			errorMessage="
2 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/RedeclareTests.mo':
Semantic error at line 940, column 20:
  In the declaration 'replaceable D d constrainedby D (redeclare replaceable B c)', the declared class is not a subtype of the constraining class
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/RedeclareTests.mo':
Semantic error at line 940, column 38:
  In the declaration 'redeclare replaceable B c', the replacing class is not a subtype of the constraining class from the declaration 'replaceable C c constrainedby C'
")})));
end RedeclareTest_Constr_18_Err;


model RedeclareTest_Classes_1 "Redeclaration of classes example."
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;
 
   model D
     replaceable model myA = A;
     myA a(x=4);
   end D;
 
   model E
      D d(redeclare replaceable model myA = C);
   end E;
 
   E e;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest_Classes_1",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest_Classes_1
 Real e.d.a.x = 4 /*(4)*/;
 Real e.d.a.y = 3 /*(3)*/;
 Real e.d.a.z = 4 /*(4)*/;
end RedeclareTests.RedeclareTest_Classes_1;
")})));
end RedeclareTest_Classes_1;


model RedeclareTestOx6b_Err
 model A
    Real x=1;
 end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
 
   model D
     replaceable A a;
   end D;
 
   model E
     D d(redeclare replaceable B a constrainedby B);
     Real q = d.a.y; // This access should not be ok since y is not part of
                     // the constraining interface of the replacing
                     // component B b. The constraining interface of the
                     // replacing component B b is rather defined by the
                     // original declaration A a.
   end E;
 
   // This is a perfectly legal redeclare, since the constraining class of 
   // the replacing declaration B a is A a
   E e(d(redeclare A a));
 
end RedeclareTestOx6b_Err;


model RedeclareTest0
  model A
    Real x;
  end A;
  
  model B
   Real x;
   Real y;
  end B;
  
  model B2
   Real x;
   Real y;
   Real z;
  end B2;

  
   model C
     replaceable A a;
   end C;
   
   model D
     C c(redeclare B a);
   end D;
   
   D d(c(redeclare B2 a));
   
 

end RedeclareTest0;



model RedeclareTest1
  
  
  model C2
    Real x=2;
  end C2;
  
  model C22
    Real x=3;
    Real y=4;
  end C22;
  
  model C222
    Real x=5;
    Real y=6;
    Real z=7;
  end C222;
  
  model A
    replaceable C2 c2;
  end A;
  
  model B
    // Notice that the modifier 'x=8' is not merged since
    // it redeclared and since there is no constraining clause  
    A a(redeclare replaceable C22 c2(x=8));
    A aa;
  end B;
  
  A a(redeclare C22 c2);
  B b(a(redeclare C222 c2(z=9,y=4)));

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest1",
			description="Basic redeclares.",
			flatModel="
 fclass RedeclareTests.RedeclareTest1
 Real a.c2.x = 3 /*(3)*/;
 Real a.c2.y = 4 /*(4)*/;
 Real b.a.c2.x = 5 /*(5)*/;
 Real b.a.c2.y = 4 /*(4)*/;
 Real b.a.c2.z = 9 /*(9)*/;
 Real b.aa.c2.x = 2 /*(2)*/;
end RedeclareTests.RedeclareTest1;
")})));
end RedeclareTest1;


model RedeclareTest2
  
  
  model Color 
    Real r=0;
    Real g=0;
    Real b=0;
  end Color;
  
  model Red 
    extends Color(r=1);
  end Red;
  
  model Green 
    extends Color(g=1);
  end Green;
  
  model Blue 
    extends Color(b=1);
  end Blue;
  
  model Palette 
     replaceable Color c1;
     replaceable Color c2;
     replaceable Color c3;
  end Palette;
  
  Palette p(redeclare Red c1(r=1,g=0.1,b=0.1),redeclare Blue c2,redeclare Green c3);
  

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest2",
			description="Basic redeclares.",
			flatModel="
/*
fclass RedeclareTests.RedeclareTest2;
  Real p.c1.r = 1;
  Real p.c1.g = 0.1;
  Real p.c1.b = 0.1;
  Real p.c2.r = 0;
  Real p.c2.g = 0;
  Real p.c2.b = 1;
  Real p.c3.r = 0;
  Real p.c3.g = 1;
  Real p.c3.b = 0;
end RedeclareTests.RedeclareTest2;
*/
fclass RedeclareTests.RedeclareTest2
 Real p.c1.r = 1 /*(1)*/;
 Real p.c1.g = 0.1 /*(0.1)*/;
 Real p.c1.b = 0.1 /*(0.1)*/;
 Real p.c2.r = 0 /*(0)*/;
 Real p.c2.g = 0 /*(0)*/;
 Real p.c2.b = 1 /*(1)*/;
 Real p.c3.r = 0 /*(0)*/;
 Real p.c3.g = 1 /*(1)*/;
 Real p.c3.b = 0 /*(0)*/;
end RedeclareTests.RedeclareTest2;
")})));
end RedeclareTest2;

model RedeclareTest3 
  
  
  
  extends C0.Colors.MyPalette(p(redeclare C0.Colors.Green c3(r=0.56,g=0.85,b=0.24),c1(b=0.23)));
model C0 
    
  model Colors 
  model Color 
    Real rr = 0;
    Real r=rr;
    Real g=0;
    Real b=0;
  end Color;
      
  model Red 
    extends Color(r=1);
  end Red;
      
  model Green
    extends Color(g=gg);
    Real gg = 1; 
  end Green;
      
  model Blue 
    extends Color(b=1);
  end Blue;
      
  model Palette 
     Real b = 0.001;
     replaceable Color c1;
     replaceable Color c2;
     replaceable Color c3(b=b);
     Real q = 0.4;
  end Palette;
      
  model MyPalette 
        
  Real q = 0.3;
        
  Palette p(redeclare replaceable Red c1(g=0.1,b=q),redeclare replaceable Blue c2,
            redeclare replaceable Green c3(b=0.002));
        
  end MyPalette;
      
  end Colors;
    
end C0;
  
  Real r = 0.1;
 C0.Colors.MyPalette palette(p(c3(r=r),redeclare C0.Colors.Red c1(g=0.2)));
  

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest3",
			description="Basic redeclares.",
			flatModel="
fclass RedeclareTests.RedeclareTest3
 Real r = 0.1 /*(0.1)*/;
 Real palette.q = 0.3 /*(0.3)*/;
 Real palette.p.b = 0.0010 /*(0.0010)*/;
 Real palette.p.c1.rr = 0 /*(0)*/;
 Real palette.p.c1.r = 1 /*(1)*/;
 Real palette.p.c1.g = 0.2 /*(0.2)*/;
 Real palette.p.c1.b = 0 /*(0)*/;
 Real palette.p.c2.rr = 0 /*(0)*/;
 Real palette.p.c2.r = palette.p.c2.rr;
 Real palette.p.c2.g = 0 /*(0)*/;
 Real palette.p.c2.b = 1 /*(1)*/;
 Real palette.p.c3.gg = 1 /*(1)*/;
 Real palette.p.c3.rr = 0 /*(0)*/;
 Real palette.p.c3.r = r;
 Real palette.p.c3.g = palette.p.c3.gg;
 Real palette.p.c3.b = 0.0020 /*(0.0020)*/;
 Real palette.p.q = 0.4 /*(0.4)*/;
 Real q = 0.3 /*(0.3)*/;
 Real p.b = 0.0010 /*(0.0010)*/;
 Real p.c1.rr = 0 /*(0)*/;
 Real p.c1.r = 1 /*(1)*/;
 Real p.c1.g = 0.1 /*(0.1)*/;
 Real p.c1.b = 0.23 /*(0.23)*/;
 Real p.c2.rr = 0 /*(0)*/;
 Real p.c2.r = p.c2.rr;
 Real p.c2.g = 0 /*(0)*/;
 Real p.c2.b = 1 /*(1)*/;
 Real p.c3.gg = 1 /*(1)*/;
 Real p.c3.rr = 0 /*(0)*/;
 Real p.c3.r = 0.56 /*(0.56)*/;
 Real p.c3.g = 0.85 /*(0.85)*/;
 Real p.c3.b = 0.24 /*(0.24)*/;
 Real p.q = 0.4 /*(0.4)*/;
end RedeclareTests.RedeclareTest3;
")})));
end RedeclareTest3;


model RedeclareTest4
   
 
  extends C0(p(redeclare C0.Green c3(r=0.56,g=0.85,b=0.24),c1(b=0.23)));
model C0 
  
  
  model Color 
    Real r=0;
    Real g=0;
    Real b=0;
  end Color;
  
  model Red 
    extends Color(r=1);
  end Red;
  
  model Green 
    extends Color(g=1);
  end Green;
  
  model Blue 
    extends Color(b=1);
  end Blue;
  
  model Palette 
     replaceable Color c1;
     replaceable Color c2;
     replaceable Color c3(b=0.001);
  end Palette;
  
  Real q = 0.3;
  
  Palette p(redeclare replaceable Red c1(g=0.1,b=q),redeclare replaceable Blue c2,redeclare replaceable Green c3);
  
end C0;

 C0 c0(p(c3(r=0.1),redeclare C0.Red c1(g=0.2)));

  


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest4",
			description="Basic redeclares.",
			flatModel="
fclass RedeclareTests.RedeclareTest4
 Real c0.q = 0.3 /*(0.3)*/;
 Real c0.p.c1.r = 1 /*(1)*/;
 Real c0.p.c1.g = 0.2 /*(0.2)*/;
 Real c0.p.c1.b = 0 /*(0)*/;
 Real c0.p.c2.r = 0 /*(0)*/;
 Real c0.p.c2.g = 0 /*(0)*/;
 Real c0.p.c2.b = 1 /*(1)*/;
 Real c0.p.c3.r = 0.1 /*(0.1)*/;
 Real c0.p.c3.g = 1 /*(1)*/;
 Real c0.p.c3.b = 0.0010 /*(0.0010)*/;
 Real q = 0.3 /*(0.3)*/;
 Real p.c1.r = 1 /*(1)*/;
 Real p.c1.g = 0.1 /*(0.1)*/;
 Real p.c1.b = 0.23 /*(0.23)*/;
 Real p.c2.r = 0 /*(0)*/;
 Real p.c2.g = 0 /*(0)*/;
 Real p.c2.b = 1 /*(1)*/;
 Real p.c3.r = 0.56 /*(0.56)*/;
 Real p.c3.g = 0.85 /*(0.85)*/;
 Real p.c3.b = 0.24 /*(0.24)*/;
end RedeclareTests.RedeclareTest4;
")})));
end RedeclareTest4;


model RedeclareTest5
  
  


model Unnamed 
  model C1 
    model C2 
      Real x=2;
    end C2;
    replaceable C2 c2(x=4);
  end C1;
    
  model C22 
     Real x=1;
     Real y=3;
  end C22;
    
  model C222 
    Real x=11;
     Real y=33;
  end C222;
    
  C1 c1(redeclare replaceable C222 c2(y=44,x=2));
    
end Unnamed;
  
model C222
     Real x=2;
     Real y=4;
     Real z=6;
end C222;
 Unnamed u(c1(redeclare C222 c2(x=55,z=66)));


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest5",
			description="Basic redeclares.",
			flatModel="
fclass RedeclareTests.RedeclareTest5
 Real u.c1.c2.x = 55 /*(55)*/;
 Real u.c1.c2.y = 4 /*(4)*/;
 Real u.c1.c2.z = 66 /*(66)*/;
end RedeclareTests.RedeclareTest5;
")})));
end RedeclareTest5;

model RedeclareTest6
  model C2
    Real x=2;
  end C2;
  
  model C22
    Real x=3;
    Real y=4;
  end C22;
  
  model C222
    Real x=5;
    Real y=6;
    Real z=7;
  end C222;
  
  model A
    replaceable C2 c2(x=55); 
  end A;
  
  model B
    A a(redeclare replaceable C22 c2(y=8));
  end B;
  
  B b(a(redeclare C222 c2(z=9,y=4,x=6)));
  B bb;


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest6",
			description="Basic redeclares.",
			flatModel="
fclass RedeclareTests.RedeclareTest6
 Real b.a.c2.x = 6 /*(6)*/;
 Real b.a.c2.y = 4 /*(4)*/;
 Real b.a.c2.z = 9 /*(9)*/;
 Real bb.a.c2.x = 55 /*(55)*/;
 Real bb.a.c2.y = 8 /*(8)*/;
end RedeclareTests.RedeclareTest6;
")})));
end RedeclareTest6;


model RedeclareTest7
  model A
  	model B
    	Real x=3;
 	 	end B;
  	model C
    	Real x=4;
    	Real y=5;
  	end C;
  	model D
  	  replaceable B b(x=0);
  	end D;
  	D d(b(x=7));
  end A;
  Real p=4;
  A a(d(redeclare A.C b(x=p)));

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest7",
			description="Basic redeclares.",
			flatModel="
fclass RedeclareTests.RedeclareTest7
 Real p = 4 /*(4)*/;
 Real a.d.b.x = p;
 Real a.d.b.y = 5 /*(5)*/;
end RedeclareTests.RedeclareTest7;
")})));
end RedeclareTest7;

model RedeclareTest8
  
  model C2
    Real x=2;
    
    
  end C2;
  
  model C22
    Real x=3;
    Real y=4;
    Real w=5;
  end C22;
  
  model C222
    Real x=5;
    Real y=6;
		Real w=4;
    Real z=7;
  end C222;
  
  model A
    Real q = 1;
    replaceable C2 c2;
  end A;
  
  model B
    Real p =1;
    A a(redeclare replaceable C22 c2(x=8,y=10),q=2);
    A a1(redeclare replaceable C22 c2(x=p));
    A aa;
  end B;
  
  A a(redeclare C22 c2);
  B b(a(redeclare C222 c2(z=9,y=4)));
end RedeclareTest8;

model RedeclareTest9
  
  
  model C2
    Real x=2;
  end C2;
  
  model C22
    Real x=3;
    Real y=4;
  end C22;
  
  model C222
    Real x=5;
    Real y=6;
    Real z=7;
  end C222;
  
  model A
    replaceable C2 c2;
  end A;
  
  model B
    // Note that the modifier 'x=8' is  merged since
    // it appears in a constraining clause  
    A a(redeclare replaceable C22 c2 constrainedby C22(x=8));
    A aa;
  end B;
  
  A a(redeclare C22 c2);
  B b(a(redeclare C222 c2(z=9,y=4)));

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest9",
			description="Basic redeclares.",
			flatModel="
 fclass RedeclareTests.RedeclareTest9
 Real a.c2.x = 3 /*(3)*/;
 Real a.c2.y = 4 /*(4)*/;
 Real b.a.c2.x = 8 /*(8)*/;
 Real b.a.c2.y = 4 /*(4)*/;
 Real b.a.c2.z = 9 /*(9)*/;
 Real b.aa.c2.x = 2 /*(2)*/;
end RedeclareTests.RedeclareTest9;
")})));
end RedeclareTest9;

model RedeclareTest95_Err
  
  
  model C2
    Real x=2;
  end C2;
  
  model C22
    Real x=3;
    Real y=4;
  end C22;
  
  model C222
    Real x=5;
    Real y=6;
    Real z=7;
  end C222;
  
  model A
    replaceable C2 c2;
  end A;
  
  model B
    // Note that the modifier 'w=8' is  merged since
    // it appears in a constraining clause  
    A a(redeclare replaceable C22 c2 constrainedby C22(w=8));
    A aa;
  end B;
  
  A a(redeclare C22 c2);
  B b(a(redeclare C222 c2(z=9,y=4)));

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="RedeclareTest95_Err",
			description="Basic redeclares.",
			errorMessage="
1 errors found:
Error: in file 'src/test/modelica/ModificationTests.mo':
Semantic error at line 1609, column 7:
  Cannot find component declaration for w

")})));
end RedeclareTest95_Err;


model RedeclareTest97_Err
  model C2
    Real x=2;
  end C2;
  
  model C22
    Real x=3;
    Real y=4;
  end C22;
  
  model C222
    Real x=5;
    Real y=6;
    Real z=7;
  end C222;
  
  model A
    replaceable C2 c2;
  end A;
  
  model B
    // Note that the modifier 'w=8' is  merged since
    // it appears in a constraining clause  
    extends A(redeclare replaceable C22 c2 constrainedby C22(w=8));
    A aa;
  end B;
  
  A a(redeclare C22 c2);
  B b(redeclare C222 c2(z=9,y=4));

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="RedeclareTest97_Err",
			description="Basic redeclares.",
			errorMessage="
1 errors found:
Error: in file 'src/test/modelica/ModificationTests.mo':
Semantic error at line 1659, column 7:
  Cannot find component declaration for w

")})));
end RedeclareTest97_Err;

model RedeclareTest10 
  
  extends C0.Colors.MyPalette(p(redeclare C0.Colors.Green c3(r=0.56,g=0.85,b=0.24),c1(b=0.23)));
model C0 
    
  model Colors 
  model Color 
    Real rr = 0;
    Real r=rr;
    Real g=0;
    Real b=0;
  end Color;
      
  model Red 
    extends Color(r=1);
  end Red;
      
  model Green
    extends Color(g=gg);
    Real gg = 1; 
  end Green;
      
  model Blue 
    extends Color(b=1);
  end Blue;
      
  model Palette 
     Real b = 0.001;
     replaceable Color c1;
     replaceable Color c2;
     replaceable Color c3(b=b);
     Real q = 0.4;
  end Palette;
      
  model MyPalette 
        
  Real q = 0.3;
        
  Palette p(redeclare replaceable Red c1 constrainedby Red(g=0.1,b=q),redeclare replaceable Blue c2,
            redeclare replaceable Green c3 constrainedby Green(b=0.002));
        
  end MyPalette;
      
  end Colors;
    
end C0;
  
  Real r = 0.1;
 C0.Colors.MyPalette palette(p(c3(r=r),redeclare C0.Colors.Red c1(g=0.2)));
  

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest10",
			description="Basic redeclares.",
			flatModel="
fclass RedeclareTests.RedeclareTest10
 Real r = 0.1 /*(0.1)*/;
 Real palette.q = 0.3 /*(0.3)*/;
 Real palette.p.b = 0.0010 /*(0.0010)*/;
 Real palette.p.c1.rr = 0 /*(0)*/;
 Real palette.p.c1.r = 1 /*(1)*/;
 Real palette.p.c1.g = 0.2 /*(0.2)*/;
 Real palette.p.c1.b = palette.q;
 Real palette.p.c2.rr = 0 /*(0)*/;
 Real palette.p.c2.r = palette.p.c2.rr;
 Real palette.p.c2.g = 0 /*(0)*/;
 Real palette.p.c2.b = 1 /*(1)*/;
 Real palette.p.c3.gg = 1 /*(1)*/;
 Real palette.p.c3.rr = 0 /*(0)*/;
 Real palette.p.c3.r = r;
 Real palette.p.c3.g = palette.p.c3.gg;
 Real palette.p.c3.b = 0.0020 /*(0.0020)*/;
 Real palette.p.q = 0.4 /*(0.4)*/;
 Real q = 0.3 /*(0.3)*/;
 Real p.b = 0.0010 /*(0.0010)*/;
 Real p.c1.rr = 0 /*(0)*/;
 Real p.c1.r = 1 /*(1)*/;
 Real p.c1.g = 0.1 /*(0.1)*/;
 Real p.c1.b = 0.23 /*(0.23)*/;
 Real p.c2.rr = 0 /*(0)*/;
 Real p.c2.r = p.c2.rr;
 Real p.c2.g = 0 /*(0)*/;
 Real p.c2.b = 1 /*(1)*/;
 Real p.c3.gg = 1 /*(1)*/;
 Real p.c3.rr = 0 /*(0)*/;
 Real p.c3.r = 0.56 /*(0.56)*/;
 Real p.c3.g = 0.85 /*(0.85)*/;
 Real p.c3.b = 0.24 /*(0.24)*/;
 Real p.q = 0.4 /*(0.4)*/;
end RedeclareTests.RedeclareTest10;
")})));
end RedeclareTest10;

model RedeclareTest11
   
 
  extends C0(p(redeclare replaceable C0.Green c3 constrainedby C0.Green(r=0.56,g=0.85,b=0.24),c1(b=0.23)));
model C0 
  
  
  model Color 
    Real r=0;
    Real g=0;
    Real b=0;
  end Color;
  
  model Red 
    extends Color(r=1);
  end Red;
  
  model Green 
    extends Color(g=1);
  end Green;
  
  model Blue 
    extends Color(b=1);
  end Blue;
  
  model Palette 
     replaceable Color c1;
     replaceable Color c2;
     replaceable Color c3(b=0.001);
  end Palette;
  
  Real q = 0.3;
  
  Palette p(redeclare replaceable Red c1 constrainedby Red(g=0.1,b=q),
            redeclare replaceable Blue c2,redeclare replaceable Green c3);
  
end C0;

 C0 c0(p(c3(r=0.1),redeclare C0.Red c1(g=0.2)));

  


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest11",
			description="Basic redeclares.",
			flatModel="
fclass RedeclareTests.RedeclareTest11
 Real c0.q = 0.3 /*(0.3)*/;
 Real c0.p.c1.r = 1 /*(1)*/;
 Real c0.p.c1.g = 0.2 /*(0.2)*/;
 Real c0.p.c1.b = c0.q;
 Real c0.p.c2.r = 0 /*(0)*/;
 Real c0.p.c2.g = 0 /*(0)*/;
 Real c0.p.c2.b = 1 /*(1)*/;
 Real c0.p.c3.r = 0.1 /*(0.1)*/;
 Real c0.p.c3.g = 1 /*(1)*/;
 Real c0.p.c3.b = 0.0010 /*(0.0010)*/;
 Real q = 0.3 /*(0.3)*/;
 Real p.c1.r = 1 /*(1)*/;
 Real p.c1.g = 0.1 /*(0.1)*/;
 Real p.c1.b = 0.23 /*(0.23)*/;
 Real p.c2.r = 0 /*(0)*/;
 Real p.c2.g = 0 /*(0)*/;
 Real p.c2.b = 1 /*(1)*/;
 Real p.c3.r = 0.56 /*(0.56)*/;
 Real p.c3.g = 0.85 /*(0.85)*/;
 Real p.c3.b = 0.24 /*(0.24)*/;
end RedeclareTests.RedeclareTest11;
")})));
end RedeclareTest11;

model RedeclareTest12
  
  


model Unnamed 
  model C1 
    model C2 
      Real x=2;
    end C2;
    replaceable C2 c2(x=4);
  end C1;
    
  model C22 
     Real x=1;
     Real y=3;
  end C22;
    
  model C222 
    Real x=11;
     Real y=33;
  end C222;
    
  C1 c1(redeclare replaceable C222 c2 constrainedby C222(y=44,x=2));
    
end Unnamed;
  
model C222
     Real x=2;
     Real y=4;
     Real z=6;
end C222;
 Unnamed u(c1(redeclare C222 c2(x=55,z=66)));


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest12",
			description="Basic redeclares.",
			flatModel="
fclass RedeclareTests.RedeclareTest12
 Real u.c1.c2.x = 55 /*(55)*/;
 Real u.c1.c2.y = 44 /*(44)*/;
 Real u.c1.c2.z = 66 /*(66)*/;
end RedeclareTests.RedeclareTest12;
")})));
end RedeclareTest12;

model RedeclareTest13

	model A
	  Real x=1;
	  Real y=2;
	end A;
	
	model B
	  extends A;
	  Real z = 3;
	end B;
	
	model C
	  replaceable B b1(x=5) constrainedby B(x=3,y=4);
	  replaceable B b2(x=5) constrainedby B(y=3);
    end C;
    
    C c;
	

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest13",
			description="Basic redeclares.",
			flatModel="
fclass RedeclareTests.RedeclareTest13
 Real c.b1.z = 3 /*(3)*/;
 Real c.b1.x = 5 /*(5)*/;
 Real c.b1.y = 4 /*(4)*/;
 Real c.b2.z = 3 /*(3)*/;
 Real c.b2.x = 5 /*(5)*/;
 Real c.b2.y = 3 /*(3)*/;
end RedeclareTests.RedeclareTest13;
")})));
end RedeclareTest13;

model RedeclareTest14
	model A
	  Real x=1;
	  Real y=2;
	end A;
	
	model B
	  extends A;
	  Real z = 3;
	end B;
	
	model C
	  replaceable B b1(x=5) constrainedby B(x=3,y=4);
	  replaceable B b2(x=5) constrainedby B(y=3);
    end C;
    
    C c(redeclare B b2(z=5));
	

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest14",
			description="Basic redeclares.",
			flatModel="
fclass RedeclareTests.RedeclareTest14
 Real c.b1.z = 3 /*(3)*/;
 Real c.b1.x = 5 /*(5)*/;
 Real c.b1.y = 4 /*(4)*/;
 Real c.b2.z = 5 /*(5)*/;
 Real c.b2.x = 1 /*(1)*/;
 Real c.b2.y = 3 /*(3)*/;
end RedeclareTests.RedeclareTest14;
")})));
end RedeclareTest14;

class RedeclareTest15 "Test of merging of modifications in parametrized classes"
 
  
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
  
   model C
     replaceable model myA = A(x=2);
     myA a(x=4);
   end C;
 
   model D
      C c(redeclare replaceable model myA = B(y=5));
   end D;
 
   D d;


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest15",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest15
 Real d.c.a.x = 4 /*(4)*/;
 Real d.c.a.y = 5 /*(5)*/;
end RedeclareTests.RedeclareTest15;
")})));
end RedeclareTest15;

class RedeclareTest16 "Test of merging of modifications in parametrized classes"
 
  
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
  
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;

   model D
     replaceable A a(x=4);
   
   end D;
 
   model E
     replaceable model myB = B(x=6,y=4);
     D d(redeclare replaceable myB a(x=5));
   end E;
 
   E e(redeclare model myB = C(z=6));


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest16",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest16
 Real e.d.a.x = 5 /*(5)*/;
 Real e.d.a.y = 4 /*(4)*/;
 Real e.d.a.z = 6 /*(6)*/;
end RedeclareTests.RedeclareTest16;
")})));
end RedeclareTest16;

class RedeclareTest161 "Test of merging of modifications in parametrized classes"
 
  
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
  
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;

   model E
     replaceable model myB = B(x=6,y=4);
     extends myB;
   end E;
 
   E e(redeclare model myB = C(z=6));


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest161",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest161
 Real e.x = 6 /*(6)*/;
 Real e.y = 4 /*(4)*/;
 Real e.z = 6 /*(6)*/;
end RedeclareTests.RedeclareTest161;
")})));
end RedeclareTest161;

class RedeclareTest165 
 
 
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
   Real z=4;
   Real u=5;
   Real v=6;
  end B;
 
  model C
   Real x=2;
   Real y=3;
   Real z=4;
   Real u=5;
   Real v=6;
   Real w=7;
  end C;
 
   model D
     replaceable A a(x=4);
 
   end D;
 
   model E
     parameter Real pE = 5;
     replaceable model myB = BB(x=6,y=pE); // This access to B should be illegal since
                                           // Redeclare165 is not a package.
     D d(redeclare replaceable myB a(x=5));
   end E;
 
   model BB = B(u=1); // This is tricky. Notice that 'u=1' is inside BB and is 
                      // handled as such when modifications are merged. In this
                      // case it means that it is discarded when myB is redeclared.
 
   E e(redeclare model myB = C(z=6));
 

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest165",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest165
 parameter Real e.pE = 5 /*(5)*/;
 Real e.d.a.x = 5 /*(5)*/;
 Real e.d.a.y = e.pE /*(5)*/;
 Real e.d.a.z = 6 /*(6)*/;
 Real e.d.a.u = 5 /*(5)*/;
 Real e.d.a.v = 6 /*(6)*/;
 Real e.d.a.w = 7 /*(7)*/;
end RedeclareTests.RedeclareTest165;
")})));
end RedeclareTest165;

model RedeclareTest17
  
   
  
   package P
   model A
    Real x=1;
   end A;
 
     model B
        Real x=2;
        Real y=3;
     end B;
 
     model C
        Real x=2;
        Real y=3;
        Real z=4;
     end C;
     
     replaceable model BB = B(x=3);
   end P;
 
   package PP = P(redeclare model BB = P.C(y=5));
 
  PP.BB bb(y=3);
 

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest17",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest17
 Real bb.x = 3 /*(3)*/;
 Real bb.y = 3 /*(3)*/;
 Real bb.z = 4 /*(4)*/;
end RedeclareTests.RedeclareTest17;

")})));
end RedeclareTest17;

model RedeclareTest175
  
   
   package P
   model A
    Real x=1;
   end A;
 
     model B
        Real x=2;
        Real y=3;
     end B;
 
     model C
        Real x=2;
        Real y=3;
        Real z=4;
     end C;
     
     replaceable model BB 
     	extends B(x=3);
     end BB;
   end P;
 
   package PP = P(redeclare model BB = P.C(z=5));
 
  PP.BB bb(y=6);
 

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest175",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest175
 Real bb.x = 2 /*(2)*/;
 Real bb.y = 6 /*(6)*/;
 Real bb.z = 5 /*(5)*/;
end RedeclareTests.RedeclareTest175;

")})));
end RedeclareTest175;

model RedeclareTest176
  
   
   package P
   model A
    Real x=1;
   end A;
 
     model B
        Real x=2;
        Real y=3;
     end B;
 
     model C
        Real x=2;
        Real y=3;
        Real z=4;
     end C;
     
     replaceable model BB = B(x=3);
     
   end P;
 
   package PP = P(redeclare model BB 
     	                      extends P.C(y=4);
                            end BB);
 
  PP.BB bb(y=6);
 

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest176",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest176
 Real bb.x = 3 /*(3)*/;
 Real bb.y = 6 /*(6)*/;
 Real bb.z = 4 /*(4)*/;
end RedeclareTests.RedeclareTest176;

")})));
end RedeclareTest176;


model RedeclareTest18 "Test of merging of modifications in parametrized classes"
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
  
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;

  model D
   Real x=2;
   Real y=3;
   Real z=4;
   Real w=5;
  end D;

   model E
     replaceable A a(x=4);
   
   end E;
 
   model F
     replaceable model myB = B(x=6,y=4);
     E e(redeclare replaceable myB a(x=5));
   end F;
 
   model G
     replaceable model myC = C(y=7,z=4);
     F f(redeclare model myB = myC);
   end G;
    
   G g(redeclare model myC = D(z=6,w=5));

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest18",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest18
 Real g.f.e.a.x = 5 /*(5)*/;
 Real g.f.e.a.y = 4 /*(4)*/;
 Real g.f.e.a.z = 6 /*(6)*/;
 Real g.f.e.a.w = 5 /*(5)*/;
end RedeclareTests.RedeclareTest18;
")})));
end RedeclareTest18;

class RedeclareTest19 "Test of merging of modifications in parametrized classes"
 
  
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
  
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;

  model D
   Real x=2;
   Real y=3;
   Real z=4;
   Real w=5;
  end D;

   model E
     replaceable A a(x=4);
   
   end E;
 
   model F
     replaceable model myB = B(x=6,y=4);
     E e(redeclare replaceable myB a(x=5));
   end F;
 
   model G
     replaceable model myC = C(y=7,z=4);
     model myC2 = myC(y=10);
     F f(redeclare model myB = myC2);
   end G;
    
    
   G g(redeclare model myC = D(z=6,w=5));


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest19",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest19
 Real g.f.e.a.x = 5 /*(5)*/;
 Real g.f.e.a.y = 4 /*(4)*/;
 Real g.f.e.a.z = 6 /*(6)*/;
 Real g.f.e.a.w = 5 /*(5)*/;
end RedeclareTests.RedeclareTest19;
")})));
end RedeclareTest19;

class RedeclareTest20 "Test of merging of modifications in parametrized classes"
 
  
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
  
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;

  model D
   Real x=2;
   Real y=3;
   Real z=4;
   Real w=5;
  end D;

   model E
   
     model myB = B(x=5);
     myB b;
     replaceable A a(x=4);
   
   end E;
 
   model F
     replaceable model myB = B(x=6,y=4);
     E e(redeclare replaceable myB a(x=5));
   end F;
 
   model G
     replaceable model myC = C(y=7,z=4);
     model myC2 = myC(y=10);
     F f(redeclare model myB = myC2);
   end G;
    
   G g(redeclare model myC = D(z=6,w=5));


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest20",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest20
 Real g.f.e.b.x = 5 /*(5)*/;
 Real g.f.e.b.y = 3 /*(3)*/;
 Real g.f.e.a.x = 5 /*(5)*/;
 Real g.f.e.a.y = 4 /*(4)*/;
 Real g.f.e.a.z = 6 /*(6)*/;
 Real g.f.e.a.w = 5 /*(5)*/;
end RedeclareTests.RedeclareTest20;
	
")})));
end RedeclareTest20;

class RedeclareTest21 "Test of merging of modifications in parametrized classes"
 
  
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
  
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;

  model D
   Real x=2;
   Real y=3;
   Real z=4;
   Real w=5;
  end D;

   model E
     parameter Real pE = 3;
     model myB = B(x=pE);
     myB b;
     replaceable A a(x=4);
   
   end E;
 
   model F
     parameter Real pF = 4;
     replaceable model myB = B(x=6,y=pF);
     E e(redeclare replaceable myB a(x=5));
   end F;
 
   model G
   	 parameter Real pG = 6;
     replaceable model myC = C(y=7,z=pG);
     model myC2 = myC(y=10);
     F f(redeclare model myB = myC2);
   end G;
    
   parameter Real p0 = 5; 
   G g(redeclare model myC = D(w=p0));


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest21",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest21
 parameter Real p0 = 5 /*(5)*/;
 parameter Real g.pG = 6 /*(6)*/;
 parameter Real g.f.pF = 4 /*(4)*/;
 parameter Real g.f.e.pE = 3 /*(3)*/;
 Real g.f.e.b.x = g.f.e.pE /*(3)*/;
 Real g.f.e.b.y = 3 /*(3)*/;
 Real g.f.e.a.x = 5 /*(5)*/;
 Real g.f.e.a.y = g.f.pF /*(4)*/;
 Real g.f.e.a.z = g.pG /*(6)*/;
 Real g.f.e.a.w = p0 /*(5)*/;
end RedeclareTests.RedeclareTest21;	
")})));
end RedeclareTest21;

class RedeclareTest22 "Test of merging of modifications in parametrized classes"
 
  
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
  
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;

  model D
   Real x=2;
   Real y=3;
   Real z=4;
   Real w=5;
  end D;

   model E
     parameter Real pE = 3;
     replaceable model myB = B(x=pE);
     myB b;
   end E;
 
   model F
     parameter Real pF = 4;
     replaceable model myB2 = B(x=6,y=pF);
     E e(redeclare model myB = myB2);
   end F;
 
   model G
   	 parameter Real pG = 6;
     replaceable model myC = C(y=7,z=pG);
     F f(e(redeclare model myB = myC));
   end G;
    
   parameter Real p0 = 5; 
   G g(f(e(redeclare model myB = D(w=p0))));


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest22",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest22
 parameter Real p0 = 5 /*(5)*/;
 parameter Real g.pG = 6 /*(6)*/;
 parameter Real g.f.pF = 4 /*(4)*/;
 parameter Real g.f.e.pE = 3 /*(3)*/;
 Real g.f.e.b.x = g.f.e.pE /*(3)*/;
 Real g.f.e.b.y = 3 /*(3)*/;
 Real g.f.e.b.z = 4 /*(4)*/;
 Real g.f.e.b.w = p0 /*(5)*/;
end RedeclareTests.RedeclareTest22;
")})));
end RedeclareTest22;

class RedeclareTest225 "Test of merging of modifications in parametrized classes"
 
  
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
  
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;

  model D
   Real x=2;
   Real y=3;
   Real z=4;
   Real w=5;
  end D;

   model E
     parameter Real pE = 3;
     replaceable model myB = B(x=pE);
     myB b;
   end E;
 
   model F
     E e;
   end F;
 
   parameter Real p0 = 5; 
   F f(e(redeclare model myB = D(w=p0)));


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest225",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest225
 parameter Real p0 = 5 /*(5)*/;
 parameter Real f.e.pE = 3 /*(3)*/;
 Real f.e.b.x = f.e.pE /*(3)*/;
 Real f.e.b.y = 3 /*(3)*/;
 Real f.e.b.z = 4 /*(4)*/;
 Real f.e.b.w = p0 /*(5)*/;
end RedeclareTests.RedeclareTest225;	
")})));
end RedeclareTest225;

model RedeclareTest23


  model B
     Real x=2;
     Real y=3;
  end B;

  model C
     Real x=2;
     Real y=3;
     Real z=4;
  end C;

  model D
    replaceable model BB = B(x=4);
    BB b;
  end D;

  model CC = C(x=5,z=10);

  model CCC
     extends C(x=5,z=10);
  end CCC;


  D d1(redeclare model BB = CC);
  D d2(redeclare model BB = CCC);
 


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest23",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest23
 Real d1.b.x = 4 /*(4)*/;
 Real d1.b.y = 3 /*(3)*/;
 Real d1.b.z = 10 /*(10)*/;
 Real d2.b.x = 4 /*(4)*/;
 Real d2.b.y = 3 /*(3)*/;
 Real d2.b.z = 10 /*(10)*/;
end RedeclareTests.RedeclareTest23;

")})));
end RedeclareTest23;

class RedeclareTest24 "Test of merging of modifications in parametrized classes"
 
  
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
  
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;

  model D
   Real x=2;
   Real y=3;
   Real z=4;
   Real w=5;
  end D;

   model E
     parameter Real pE = 3;
     replaceable model myB = B(x=pE);
     myB b;
   end E;
 
   model F
     parameter Real pF = 4;
     replaceable model myB2 = B(x=6,y=pF);
     E e(redeclare model myB = myB2(y=8));
   end F;
 
   model G
   	 parameter Real pG = 6;
     replaceable model myC = C(y=7,z=pG);
     F f(e(redeclare model myB = myC(z=9)));
   end G;
    
   parameter Real p0 = 5; 
   G g(f(e(redeclare model myB = D(w=p0))));


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest24",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest24
 parameter Real p0 = 5 /*(5)*/;
 parameter Real g.pG = 6 /*(6)*/;
 parameter Real g.f.pF = 4 /*(4)*/;
 parameter Real g.f.e.pE = 3 /*(3)*/;
 Real g.f.e.b.x = g.f.e.pE /*(3)*/;
 Real g.f.e.b.y = 3 /*(3)*/;
 Real g.f.e.b.z = 4 /*(4)*/;
 Real g.f.e.b.w = p0 /*(5)*/;
end RedeclareTests.RedeclareTest24;
")})));
end RedeclareTest24;

class RedeclareTest25 "Test of merging of modifications in parametrized classes"
 
  
  model A
    Real x=1;
  end A;
 
  model B
   Real x=2;
   Real y=3;
  end B;
  
  model C
   Real x=2;
   Real y=3;
   Real z=4;
  end C;

  model D
   Real x=2;
   Real y=3;
   Real z=4;
   Real w=5;
  end D;

   model E
     parameter Real pE = 3;
     replaceable model myB = B(x=pE);
     myB b;
   end E;
 
   model F
     parameter Real pF = 4;
     replaceable model myB2 = B(x=6,y=pF);
     E e(redeclare replaceable model myB = myB2 constrainedby myB2(y=8));
   end F;
 
   model G
   	 parameter Real pG = 6;
     replaceable model myC = C(y=7,z=pG);
     F f(e(redeclare replaceable model myB = myC constrainedby myC(z=9)));
   end G;
    
   parameter Real p0 = 5; 
   G g(f(e(redeclare model myB = D(w=p0))));


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest25",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest25
 parameter Real p0 = 5 /*(5)*/;
 parameter Real g.pG = 6 /*(6)*/;
 parameter Real g.f.pF = 4 /*(4)*/;
 parameter Real g.f.e.pE = 3 /*(3)*/;
 Real g.f.e.b.x = g.f.e.pE /*(3)*/;
 Real g.f.e.b.y = 8 /*(8)*/;
 Real g.f.e.b.z = 9 /*(9)*/;
 Real g.f.e.b.w = p0 /*(5)*/;
end RedeclareTests.RedeclareTest25;
")})));
end RedeclareTest25;

model RedeclareTest26 

	
	model M1
	  Real x;
	  model Q
	    Real z;
	  end Q;
	end M1;
	
	model M2
	  Real x;
	  Real y;
	  model Q
	    Real z;
	  end Q;
	end M2;
	
	model A
	   replaceable M1 m;
	end A;

    extends A(redeclare M2 m);


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest26",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest26
 Real m.x;
 Real m.y;
end RedeclareTests.RedeclareTest26;
")})));
end RedeclareTest26;

model RedeclareTest27
 
 package P1
    model A
      Real x=2;
    end A;
  end P1;

  package P2
    extends P1;
    model B
      Real y=3;
    end B;
  end P2;

  package P3
    replaceable package P = P1;
  end P3;

  package P4
    extends P3(redeclare package P = P2);
  end P4;

  P4.P.B b;



	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest27",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest27
 Real b.y = 3;
end RedeclareTests.RedeclareTest27;
")})));
end RedeclareTest27;

model RedeclareTest28



  model M1
    parameter Real p1=2;
  end M1;

  model M2
    extends M1;
    parameter Real p2=2;
  end M2;

  model A
    parameter Real p3 = 1;
    replaceable M1 m1(p1=p3);
  end A;
  
  parameter Real p2 = 3;
  extends A(redeclare M2 m1(p2=p2));



	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest28",
			description="Test of parametrized classes.",
			flatModel="
fclass RedeclareTests.RedeclareTest28
 parameter Real p2 = 3 /* 3.0 */;
 parameter Real p3 = 1 /* 1.0 */;
 parameter Real m1.p2 = p2;
 parameter Real m1.p1 = p3;
end RedeclareTests.RedeclareTest28;
")})));
end RedeclareTest28;


model RedeclareTest29
    record A
        parameter Integer n;
        Real x[n];
    end A;
    
    package B
        constant A a;
    end B;
    
    package C
        extends B(a(n=2, x={1,2}));
    end C;
    
    Real y[2] = C.a.x;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest29",
			description="Modifying parameter that is used as size of array",
			flatModel="
fclass RedeclareTests.RedeclareTest29
 Real y[2] = {1.0,2.0};
end RedeclareTests.RedeclareTest29;
")})));
end RedeclareTest29;


model RedeclareTest30
    model A
        Real x;
    end A;
    
    model B
        extends A;
        parameter Real y = 2;
    equation
        x = y;
    end B;
    
    replaceable B a constrainedby A;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest30",
			description="Test that constrainedby does not prevent accesses within same class",
			flatModel="
fclass RedeclareTests.RedeclareTest30
 parameter Real a.y = 2 /* 2 */;
 Real a.x;
equation
 a.x = a.y;
end RedeclareTests.RedeclareTest30;
")})));
end RedeclareTest30;


model RedeclareTest31
    model A
        Real x;
    end A;
    
    model B
        extends A;
        parameter Real y = 2;
    end B;
    
    replaceable B a constrainedby A;
equation
	a.x = a.y;

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="RedeclareTest31",
			description="Test that constrainedby prevents accesses to elements not in constraining class from outside component",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/RedeclareTests.mo':
Semantic error at line 3061, column 10:
  Cannot find class or component declaration for y
")})));
end RedeclareTest31;


model RedeclareTest32
	package A
		constant Real x = 1;
	end A;
	
	model B
		replaceable package C
			constant Real x = 2;
		end C;
		
		Real y = C.x;
	end B;
	
	model D
		extends B(redeclare package C = E);
	end D;
	
	package E
		constant Real x = 3;
	end E;
	
	D[2] d;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RedeclareTest32",
			description="Lookup of extends with redeclare modification in array",
			flatModel="
fclass RedeclareTests.RedeclareTest32
 constant Real d[1].y = 3.0;
 constant Real d[2].y = 3.0;
end RedeclareTests.RedeclareTest32;
")})));
end RedeclareTest32;


model RedeclareTest33
	model A
		replaceable Boolean a;
		Real x = if a then time else -time;
	end A;
	
	A a(redeclare Boolean a = time < 3);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest33",
			description="Replacing primitive variable",
			flatModel="
fclass RedeclareTests.RedeclareTest33
 discrete Boolean a.a = time < 3;
 Real a.x = if a.a then time else - time;
end RedeclareTests.RedeclareTest33;
")})));
end RedeclareTest33;


model RedeclareTest34
    record A
        parameter Real a = 1;
        replaceable parameter B b;
    end A;

    record B
        parameter Real c = 2;
    end B;

    record C
        extends A(a = 3, redeclare parameter D b(c = 4));
    end C;
		
    record D
        extends B(c = 5);
    end D;

    model E
        replaceable parameter A d;
        Real x;
    equation
        x = d.a;
    end E;

	model F
        E e(redeclare parameter C d(a = 6));
    end F;
	
	F f;
end RedeclareTest34;


model RedeclareTest35
	model A
		replaceable package E = F;
	end A;
	
	model B
		extends A;
        replaceable C x constrainedby C(redeclare package D = E);
	end B;
	
	model C
		replaceable package D = G;
		Real z = D.c;
	end C;
    
    package F
        constant Real c = 1;
    end F;
    
    package G
        constant Real c = 0;
    end G;
	
	B w;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest35",
			description="Redeclare class in constrainedby",
			flatModel="
fclass RedeclareTests.RedeclareTest35
 Real w.x.z = 1.0;
end RedeclareTests.RedeclareTest35;
")})));
end RedeclareTest35;


model RedeclareTest36
    model A
        extends B(redeclare G.D c(x = 1));
    end A;
    
    model B
        replaceable C c;
    end B;
    
    model C
    end C;
    
    package G
        model D
            parameter F x = 1;
            E e(y = x);
        end D;
        
        model E
            parameter F y;
        end E;
        
        type F = Real;
    end G;
    
    A a;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest36",
			description="Class lookup from replacing component",
			flatModel="
fclass RedeclareTests.RedeclareTest36
 parameter Real a.c.x = 1 /* 1 */;
 parameter Real a.c.e.y = a.c.x;
end RedeclareTests.RedeclareTest36;
")})));
end RedeclareTest36;


model RedeclareTest37
    record A
        extends B(redeclare G.D c(x = 1));
    end A;
    
    record B
        replaceable C c;
    end B;
    
    record C
    end C;
    
    package G
        record D
            parameter F x = 1;
            E e(y = x);
        end D;
        
        record E
            parameter F y;
        end E;
        
        type F = Real;
    end G;
    
    A a;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest37",
			description="Class lookup from replacing record",
			flatModel="
fclass RedeclareTests.RedeclareTest37
 parameter RedeclareTests.RedeclareTest37.A a;

public
 record RedeclareTests.RedeclareTest37.G.E
  parameter Real y;
 end RedeclareTests.RedeclareTest37.G.E;

 record RedeclareTests.RedeclareTest37.G.D
  parameter Real x = 1 /* 1 */;
  parameter RedeclareTests.RedeclareTest37.G.E e(y = x);
 end RedeclareTests.RedeclareTest37.G.D;

 record RedeclareTests.RedeclareTest37.A
  parameter RedeclareTests.RedeclareTest37.G.D c(x = 1);
 end RedeclareTests.RedeclareTest37.A;

end RedeclareTests.RedeclareTest37;
")})));
end RedeclareTest37;


model RedeclareTest38
    model A
        replaceable B b constrainedby B;
    end A;
    
    model B
        C c[1];
    end B;
    
    model C
        Real x;
    end C;
    
    A a;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest38",
			description="Constrainedby with model containing array of models",
			flatModel="
fclass RedeclareTests.RedeclareTest38
 Real a.b.c[1].x;
end RedeclareTests.RedeclareTest38;
")})));
end RedeclareTest38;


model RedeclareTest39
    function f1
        input Real x;
        output Real y;
    end f1;
    
    function f2
        extends f1;
    algorithm
        y := x + 1;
    end f2;
    
    model A
        replaceable function f = f1;
        Real x;
    equation
        x = f(time);
    end A;
    
    model B
        replaceable A a constrainedby A(redeclare function f = f2);
    end B;
    
    model C
        B b(redeclare A a);
    end C;
    
    C c;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareTest39",
			description="Error check of redeclare that needs the modifications from the constrainedby clause to be valid",
			flatModel="
fclass RedeclareTests.RedeclareTest39
 Real c.b.a.x;
equation
 c.b.a.x = RedeclareTests.RedeclareTest39.f2(time);

public
 function RedeclareTests.RedeclareTest39.f2
  input Real x;
  output Real y;
 algorithm
  y := x + 1;
  return;
 end RedeclareTests.RedeclareTest39.f2;

end RedeclareTests.RedeclareTest39;
")})));
end RedeclareTest39;


model RedeclareTest40
    function f1
        input Real x;
        output Real y;
    end f1;
    
    function f2
        extends f1;
    algorithm
        y := x + 1;
    end f2;
    
    model A
        replaceable function f = f1;
        Real x = f(time);
    end A;
    
    model B
        replaceable A a constrainedby A(redeclare function f = f2);
    end B;
    
    model C
        B b(redeclare A a);
    end C;
    
    C c;

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="RedeclareTest40",
            description="Check that only final redeclared are erro checked",
            flatModel="
fclass RedeclareTests.RedeclareTest40
 Real c.b.a.x = RedeclareTests.RedeclareTest40.f2(time);

public
 function RedeclareTests.RedeclareTest40.f2
  input Real x;
  output Real y;
 algorithm
  y := x + 1;
  return;
 end RedeclareTests.RedeclareTest40.f2;

end RedeclareTests.RedeclareTest40;
")})));
end RedeclareTest40;


model RedeclareTest41
    package A
        replaceable model B
            Real x = 1;
        end B;
    end A;
    
    package C
        extends A;
        redeclare model extends B
            Real y = 2;
        end B;
    end C;
    
    model D
        extends C.B;
    end D;
    
    D b;

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="RedeclareTest41",
            description="",
            flatModel="
fclass RedeclareTests.RedeclareTest41
 Real b.y = 2;
 Real b.x = 1;
end RedeclareTests.RedeclareTest41;
")})));
end RedeclareTest41;


model RedeclareElement1
  model A
    replaceable model B
      Real y;
    end B;
    
    B b;
  end A;
  
  model C
    extends A;
    redeclare model B = D;
    model D 
      Real y;
      Real z;
    end D;
  end C;
  
  C c;
equation
  c.b.y = 1;
  c.b.z = 2;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareElement1",
			description="Redeclare class as element, short replacing declaration, basic test",
			flatModel="
fclass RedeclareTests.RedeclareElement1
 Real c.b.y;
 Real c.b.z;
equation
 c.b.y = 1;
 c.b.z = 2;
end RedeclareTests.RedeclareElement1;
")})));
end RedeclareElement1;


model RedeclareElement2
  model A
    replaceable model B
      Real y;
    end B;
    
    B b;
  end A;
  
  model C
    extends A;
    redeclare model B
      Real y;
      Real z;
    end B;
  end C;
  
  C c;
equation
  c.b.y = 1;
  c.b.z = 2;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareElement2",
			description="Redeclare class as element, long replacing declaration, basic test",
			flatModel="
fclass RedeclareTests.RedeclareElement2
 Real c.b.y;
 Real c.b.z;
equation
 c.b.y = 1;
 c.b.z = 2;
end RedeclareTests.RedeclareElement2;
")})));
end RedeclareElement2;


model RedeclareElement3
  model A
    replaceable model B
      Real y;
    end B;
    
    B b;
  end A;
  
  model C
    extends A;
    redeclare model extends B
      Real z;
    end B;
  end C;
  
  C c;
equation
  c.b.y = 1;
  c.b.z = 2;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareElement3",
			description="Redeclare class as element, long extending declaration, basic test",
			flatModel="
fclass RedeclareTests.RedeclareElement3
 Real c.b.z;
 Real c.b.y;
equation
 c.b.y = 1;
 c.b.z = 2;
end RedeclareTests.RedeclareElement3;
")})));
end RedeclareElement3;


model RedeclareElement4
  model A
    replaceable model B
      Real y;
    end B;
    
    B b;
  end A;
  
  model C
    extends A;
    model extends B
      Real z;
    end B;
  end C;
  
  C c;
equation
  c.b.y = 1;
  c.b.z = 2;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareElement4",
			description="Redeclare class as element, long extending declaration, basic test",
			flatModel="
fclass RedeclareTests.RedeclareElement4
 Real c.b.z;
 Real c.b.y;
equation
 c.b.y = 1;
 c.b.z = 2;
end RedeclareTests.RedeclareElement4;
")})));
end RedeclareElement4;


model RedeclareElement5
  model A
    replaceable model B
      Real y(start=3);
    end B;
    
    B b;
  end A;
  
  model C
    extends A;
    redeclare model B = D(z(start=1)=2);
    model D 
      Real y(start=2);
      Real z(start=4);
      Real x(start=5);
    equation
      x = 3;
    end D;
  end C;
  
  C c;
equation
  c.b.y = 1;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RedeclareElement5",
			description="Redeclare class as element, short replacing declaration, with equation and modifications",
			flatModel="
fclass RedeclareTests.RedeclareElement5
 constant Real c.b.y(start = 2) = 1;
 constant Real c.b.z(start = 1) = 2;
 constant Real c.b.x(start = 5) = 3;
end RedeclareTests.RedeclareElement5;
")})));
end RedeclareElement5;


model RedeclareElement6
  model A
	replaceable model B
	  Real y;
	end B;
	
	B b;
  end A;
  
  model C
	extends A;
	redeclare model B
	  Real y;
	  Real z;
	  Real x;
	equation
	  x = 3;
	end B;
  end C;
  
  C c;
equation
  c.b.y = 1;
  c.b.z = 2;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RedeclareElement6",
			description="Redeclare class as element, long replacing declaration, with equation",
			flatModel="
fclass RedeclareTests.RedeclareElement6
 constant Real c.b.y = 1;
 constant Real c.b.z = 2;
 constant Real c.b.x = 3;
end RedeclareTests.RedeclareElement6;
")})));
end RedeclareElement6;


model RedeclareElement7
  model A
	replaceable model B
	  Real y = 2;
	  Real x(start=20);
      Real w;
    equation
      w = 4;
	end B;
	
	B b;
  end A;
  
  model C
	extends A;
	redeclare model extends B(y(start=10), x=3)
	  Real z;
	equation
	  z = 1;
	end B;
  end C;
  
  C c;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RedeclareElement7",
			description="Redeclare class as element, long extending declaration, with equation and modifications",
			flatModel="
fclass RedeclareTests.RedeclareElement7
 constant Real c.b.z = 1;
 constant Real c.b.y(start = 10) = 2;
 constant Real c.b.x(start = 20) = 3;
 constant Real c.b.w = 4;
end RedeclareTests.RedeclareElement7;
")})));
end RedeclareElement7;


model RedeclareElement8
  model A
	replaceable model B
		Real y = 2;
		Real x(start=20);
		Real w;
	equation
		w = 4;
	end B;
	
	B b;
  end A;
  
  model C
	extends A;
	model extends B(y(start=10), x=3)
	  Real z;
	equation
	  z = 1;
	end B;
  end C;
  
  C c;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RedeclareElement8",
			description="Redeclare class as element, long extending declaration, with equation and modifications",
			flatModel="
fclass RedeclareTests.RedeclareElement8
 constant Real c.b.z = 1;
 constant Real c.b.y(start = 10) = 2;
 constant Real c.b.x(start = 20) = 3;
 constant Real c.b.w = 4;
end RedeclareTests.RedeclareElement8;
")})));
end RedeclareElement8;


model RedeclareElement9
	model A
		constant Integer n = 2;
		B b;
		
		replaceable model B
			Real x[n] = {i^2 for i in 1:n};
		end B;
	end A;
	
	model C
		extends A(n=3);
		
		redeclare model extends B
			Real y = 2;
		end B;
	end C;
	
	C c;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareElement9",
			description="Redeclare class as element, using modified constant",
			flatModel="
fclass RedeclareTests.RedeclareElement9
 constant Integer c.n = 3;
 Real c.b.y = 2;
 Real c.b.x[3] = {i ^ 2 for i in 1:3};
end RedeclareTests.RedeclareElement9;
")})));
end RedeclareElement9;


model RedeclareElement10
    package A
        replaceable model C = D;
    end A;
    
    package B
        extends A;
        
        redeclare model extends C
            parameter Real y = x;
        end C;
    end B;
    
    model D
        parameter Real x = 1;
    end D;
    
    B.C c;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareElement10",
			description="Redeclaring a short class decl with redeclare class extends",
			flatModel="
fclass RedeclareTests.RedeclareElement10
 parameter Real c.y = c.x;
 parameter Real c.x = 1 /* 1 */;
end RedeclareTests.RedeclareElement10;
")})));
end RedeclareElement10;


model RedeclareElement11
	package A
		replaceable model C = D;
		C c;
	end A;
	
	package B
		extends A;
		
		redeclare model extends C
			parameter Real y = x;
		end C;
	end B;
	
	model D
		parameter Real x = 1;
	end D;
	
	B b;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareElement11",
			description="Redeclaring a short class decl with redeclare class extends",
			flatModel="
fclass RedeclareTests.RedeclareElement11
 parameter Real b.c.y = b.c.x;
 parameter Real b.c.x = 1 /* 1 */;
end RedeclareTests.RedeclareElement11;
")})));
end RedeclareElement11;


model RedeclareElement12
	package A
		replaceable package C
			constant Real a = 1;
		end C;
		
		replaceable package E
			constant Real a = 2;
		end E;
	end A;
	
	package B
		extends A (redeclare package C = D, redeclare package E = F(a = C.a));
	end B;
	
	package D
		extends A.C(a = 3);
	end D;
	
	package F
		extends A.E(a = 4);
	end F;
	
	package G
		extends B;
	end G;
	
	constant Real a = G.E.a;
	parameter Real b = a;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareElement12",
			description="Class modification containing reference to element of the extends it is attached to",
			flatModel="
fclass RedeclareTests.RedeclareElement12
 constant Real a = 3.0;
 parameter Real b = 3.0 /* 3.0 */;
end RedeclareTests.RedeclareElement12;
")})));
end RedeclareElement12;


model RedeclareElement13
	package A
		constant Real b = 1;
		
		replaceable package E
			constant Real a = 2;
		end E;
	end A;
	
	package B
		extends A (redeclare package E = F(a = b));
	end B;
	
	package F
		extends A.E(a = 3);
	end F;
	
	package G
		extends B;
	end G;
	
	constant Real a = G.E.a;
	parameter Real c = a;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareElement13",
			description="Class modification containing reference to element of the extends it is attached to",
			flatModel="
fclass RedeclareTests.RedeclareElement13
 constant Real a = 1.0;
 parameter Real c = 1.0 /* 1.0 */;
end RedeclareTests.RedeclareElement13;
")})));
end RedeclareElement13;


model RedeclareElement14
	package A
		extends B;
		
		redeclare model extends D
			Real y;
		end D;
	end A;
	
	package B
		extends C;
	end B;
	
	package C
		replaceable model D
			Real x;
		end D;
	end C;

	A.D d(x = 1, y = 2);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RedeclareElement14",
			description="Looking up replacing class through extends",
			flatModel="
fclass RedeclareTests.RedeclareElement14
 constant Real d.y = 2;
 constant Real d.x = 1;
end RedeclareTests.RedeclareElement14;
")})));
end RedeclareElement14;


model RedeclareElement15
	package A
		replaceable model B
			Real x = 1;
		end B;
	end A;
	
	package C
		extends A;
		
		function f
			input Real i;
			output Real o;
		algorithm
			o := i * 2;
		end f;
		
		redeclare model extends B
			Real y = f(x);
		end B;
	end C;
	
	C.B z;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RedeclareElement15",
			description="Class declared in same scope as replacing class",
			flatModel="
fclass RedeclareTests.RedeclareElement15
 constant Real z.y = 2.0;
 constant Real z.x = 1;
end RedeclareTests.RedeclareElement15;
")})));
end RedeclareElement15;


model RedeclareElement16
	package A
		replaceable model B
			Real x = 1;
		end B;
	end A;
	
	package C
		extends A;
		
		redeclare model B = D.E;
	end C;
	
	package D
		function f
			input Real i;
			output Real o;
		algorithm
			o := i * 2;
		end f;
		
		model E
			Real x = 1;
			Real y = f(x);
		end E;
	end D;
	
	C.B z;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RedeclareElement16",
			description="Class declared in same scope as replacing class",
			flatModel="
fclass RedeclareTests.RedeclareElement16
 constant Real z.x = 1;
 constant Real z.y = 2.0;
end RedeclareTests.RedeclareElement16;
")})));
end RedeclareElement16;


model RedeclareElement17
	package A
		replaceable model B
			Real x = 1;
		end B;
	end A;
	
	package C
		extends A(redeclare model B = D.E);
	end C;
	
	package D
		function f
			input Real i;
			output Real o;
		algorithm
			o := i * 2;
		end f;
		
		model E
			Real x = 1;
			Real y = f(x);
		end E;
	end D;
	
	C.B z;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RedeclareElement17",
			description="Class declared in same scope as replacing class",
			flatModel="
fclass RedeclareTests.RedeclareElement17
 constant Real z.x = 1;
 constant Real z.y = 2.0;
end RedeclareTests.RedeclareElement17;
")})));
end RedeclareElement17;


model RedeclareElement18
    package A
        replaceable model B
            Real x = 1;
        end B;
    end A;
    
    package C
        extends A;
        redeclare replaceable model extends B
            Real y = 2;
        end B;
    end C;
    
    package D
        extends C;
        redeclare replaceable model extends B
            Real z = 3;
        end B;
    end D;
    
    package E
        extends D;
        redeclare model extends B
            Real w = 4;
        end B;
    end E;
    
    E.B f;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareElement18",
			description="Chain of redeclare class extends - packages",
			flatModel="
fclass RedeclareTests.RedeclareElement18
 Real f.w = 4;
 Real f.z = 3;
 Real f.y = 2;
 Real f.x = 1;
end RedeclareTests.RedeclareElement18;
")})));
end RedeclareElement18;


model RedeclareElement19
    package A
        replaceable model B
            Real x = 1;
        end B;
    end A;
    
    package C
        extends A;
    end C;
    
    package D
        extends C;
        redeclare replaceable model extends B
            Real y = 2;
        end B;
    end D;
    
    package E
        extends D;
    end E;
    
    package F
        extends E;
        redeclare model extends B
            Real z = 3;
        end B;
    end F;
    
    package G
        extends F;
    end G;
    
    G.B h;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareElement19",
			description="Chain of redeclare class extends - packages, with extends in between",
			flatModel="
fclass RedeclareTests.RedeclareElement19
 Real h.z = 3;
 Real h.y = 2;
 Real h.x = 1;
end RedeclareTests.RedeclareElement19;
")})));
end RedeclareElement19;


model RedeclareElement20
    model A
        replaceable model B
            Real x = 1;
        end B;
		
		B g;
    end A;
    
    model C
        extends A;
        redeclare replaceable model extends B
            Real y = 2;
        end B;
    end C;
    
    model D
        extends C;
        redeclare replaceable model extends B
            Real z = 3;
        end B;
    end D;
    
    model E
        extends D;
        redeclare model extends B
            Real w = 4;
        end B;
    end E;
    
    E f;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareElement20",
			description="Chain of redeclare class extends - models",
			flatModel="
fclass RedeclareTests.RedeclareElement20
 Real f.g.w = 4;
 Real f.g.z = 3;
 Real f.g.y = 2;
 Real f.g.x = 1;
end RedeclareTests.RedeclareElement20;
")})));
end RedeclareElement20;


model RedeclareElement21
    model A
        replaceable model B
            Real x = 1;
        end B;
        
        B i;
    end A;
    
    model C
        extends A;
    end C;
    
    model D
        extends C;
        redeclare replaceable model extends B
            Real y = 2;
        end B;
    end D;
    
    model E
        extends D;
    end E;
    
    model F
        extends E;
        redeclare model extends B
            Real z = 3;
        end B;
    end F;
    
    model G
        extends F;
    end G;
    
    G h;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareElement21",
			description="Chain of redeclare class extends - models, with extends in between",
			flatModel="
fclass RedeclareTests.RedeclareElement21
 Real h.i.z = 3;
 Real h.i.y = 2;
 Real h.i.x = 1;
end RedeclareTests.RedeclareElement21;
")})));
end RedeclareElement21;


model RedeclareElement22
  package A
    replaceable model B
      Real y = 1;
    end B;
    
    B b;
  end A;
  
  package C
    extends A;
    redeclare model extends B
      Real z = 2;
    end B;
  end C;
  
  model D
    replaceable model E
    end E;

    E e;
  end D;

  model F
    extends D(redeclare final model E = C.B);
  end F;
  
  F f;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RedeclareElement22",
			description="Redeclare class extends used directly in redeclare",
			flatModel="
fclass RedeclareTests.RedeclareElement22
 constant Real f.e.z = 2;
 constant Real f.e.y = 1;
end RedeclareTests.RedeclareElement22;
")})));
end RedeclareElement22;


model RedeclareElement23
  package A
    replaceable model B
      Real y = 1;
    end B;
    
    B b;
  end A;
  
  package C
    extends A;
    redeclare model extends B
      Real z = 2;
    end B;
  end C;
  
  C.B[2] b;
  Real x = b[1].y;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RedeclareElement23",
			description="Array of redeclare class extends",
			flatModel="
fclass RedeclareTests.RedeclareElement23
 constant Real b[1].z = 2;
 constant Real b[2].z = 2;
 constant Real b[2].y = 1;
 constant Real x = 1;
 constant Real b[1].y = 1;
end RedeclareTests.RedeclareElement23;
")})));
end RedeclareElement23;


model RedeclareElement24
	partial function A
        input Real x;
        output Real y;
	end A;
	
	function B
        extends A;
    algorithm
        y := x;
    end B;
	
	partial record C
        replaceable function D = A;
    end C;
	
	record E
        extends C(redeclare function D = B);
    end E;
	
	model F
		replaceable function G = A;
		Real x = 1;
	end F;
	
	model H
		replaceable record I = C;
        function J = I.D;
		replaceable function K = J;
		F b(redeclare function G = K);
	end H;
	
	H a(redeclare record I = E);

	annotation(__JModelica(UnitTesting(tests={ 
		FlatteningTestCase(
			name="RedeclareElement24",
			description="Complex system of redeclares that caused erroneous error message",
			flatModel="
fclass RedeclareTests.RedeclareElement24
 Real a.b.x = 1;
end RedeclareTests.RedeclareElement24;
")})));
end RedeclareElement24;


model RedeclareElement25
    package A
        extends F(redeclare model C = D);
    end A;
    
    package F
        replaceable model C = E;
    end F;
    
    model E
        replaceable package B = F;
        Real x = 1;
    end E;
    
    model D
        extends E(redeclare replaceable package B = A);
    end D;
    
    A.C a;

	annotation(__JModelica(UnitTesting(tests={ 
		FlatteningTestCase(
			name="RedeclareElement25",
			description="Causes recursive class structure that expands infinitely if classes are expanded",
			flatModel="
fclass RedeclareTests.RedeclareElement25
 Real a.x = 1;
end RedeclareTests.RedeclareElement25;
")})));
end RedeclareElement25;

model RedeclareElement26
	record RA
		Real a = 2;
	end RB;
	record RB
		extends RA(a = 1);
	end RB;
	
	model B
		replaceable record R = RA;
		R r;
		Real x;
	equation
		x = r.a;
	end B;
	B b(redeclare record R = RB);
	annotation(__JModelica(UnitTesting(tests={ 
		FlatteningTestCase(
			name="RedeclareElement26",
			description="Redeclare of records",
			flatModel="
fclass RedeclareTests.RedeclareElement26
 RedeclareTests.RedeclareElement26.b.R b.r(a = 1);
 Real b.x;
equation
 b.x = b.r.a;

public
 record RedeclareTests.RedeclareElement26.b.R
  Real a = 1;
 end RedeclareTests.RedeclareElement26.b.R;

end RedeclareTests.RedeclareElement26;
")})));
end RedeclareElement26;

model RedeclareSameLevel10
	package A
		replaceable partial model C
		end C;
		
		replaceable model D
			C c;
		end D;
	end A;
	
	package B
		extends A;
		
		redeclare model C
			Real x;
		end C;

		redeclare model extends D
			Real y;
		end D;
	end B;
	
	B.D d;
equation
	d.c.x = 1;
	d.y = 2;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareSameLevel10",
			description="Class used in base class redeclared as element",
			flatModel="
fclass RedeclareTests.RedeclareSameLevel10
 Real d.y;
 Real d.c.x;
equation
 d.c.x = 1;
 d.y = 2;
end RedeclareTests.RedeclareSameLevel10;
")})));
end RedeclareSameLevel10;


model RedeclareSameLevel11
	package A
		replaceable model C
			Real x;
		end C;
		
		model D
			C c;
		end D;
	end A;
	
	package B
		extends A;
		
		redeclare model extends C
			Real y;
		end C;
	end B;
	
	B.D d;
equation
	d.c.x = 1;
	d.c.y = 2;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareSameLevel11",
			description="Class used in base class redeclared as element",
			flatModel="
fclass RedeclareTests.RedeclareSameLevel11
 Real d.c.y;
 Real d.c.x;
equation
 d.c.x = 1;
 d.c.y = 2;
end RedeclareTests.RedeclareSameLevel11;
")})));
end RedeclareSameLevel11;


model RedeclareSameLevel12
	package A
		replaceable partial model C
		end C;
		
		replaceable model D
			C c;
		end D;
	end A;
	
	package B
		extends A;
		
		redeclare model C
			Real x;
		end C;

		redeclare model extends D
			Real y;
		equation
			c.x = 1;
			y = 2;
		end D;
	end B;
	
	B.D d;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareSameLevel12",
			description="Two interdependent classes redeclared as elements, with inner equations",
			flatModel="
fclass RedeclareTests.RedeclareSameLevel12
 Real d.y;
 Real d.c.x;
equation
 d.c.x = 1;
 d.y = 2;
end RedeclareTests.RedeclareSameLevel12;
")})));
end RedeclareSameLevel12;

	
	
model RedeclareFunction1
	package A
		constant Integer n = 1;
		replaceable partial function B
			input Real i[n];
			output Real o[n];
		end B;
	end A;
	
	package C
		extends A(n = 2);
		
		redeclare function extends B
		algorithm
			o := i;
		end B;
	end C;
	
	Real x[2] = C.B({1, 2});

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareFunction1",
			description="Lookup with modifications in extending function",
			flatModel="
fclass RedeclareTests.RedeclareFunction1
 Real x[2] = RedeclareTests.RedeclareFunction1.C.B({1,2});

public
 function RedeclareTests.RedeclareFunction1.C.B
  input Real[2] i;
  output Real[2] o;
 algorithm
  o := i;
  return;
 end RedeclareTests.RedeclareFunction1.C.B;

end RedeclareTests.RedeclareFunction1;
")})));
end RedeclareFunction1;


model RedeclareFunction2
	package A
		constant Integer n = 1;
		
		replaceable partial function B
			input Real i[n];
			output D o;
		end B;
		
		replaceable partial record D
		end D;
	end A;
	
	package C
		extends A(n = 2);
		
		redeclare function extends B
		algorithm
			o.a := i;
		end B;

		redeclare record D
			Real a[n];
		end D;
	end C;
	
	C.D x = C.B({1, 2});

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareFunction2",
			description="Lookup in extending function with redeclared record",
			flatModel="
fclass RedeclareTests.RedeclareFunction2
 RedeclareTests.RedeclareFunction2.C.D x = RedeclareTests.RedeclareFunction2.C.B({1,2});

public
 function RedeclareTests.RedeclareFunction2.C.B
  input Real[2] i;
  output RedeclareTests.RedeclareFunction2.C.D o;
 algorithm
  o.a := i;
  return;
 end RedeclareTests.RedeclareFunction2.C.B;

 record RedeclareTests.RedeclareFunction2.C.D
  Real a[2];
 end RedeclareTests.RedeclareFunction2.C.D;

end RedeclareTests.RedeclareFunction2;
")})));
end RedeclareFunction2;


model RedeclareFunction3
	package A
		extends B;
		redeclare model extends C(redeclare package D = E)
			Real x = D.f(y);
		end C;
	end A;
	
	package B
		replaceable model C
			replaceable package D = F;
			Real y = 1;
		end C;
	end B;
	
	package E
		extends F;
		
		redeclare function extends f
		algorithm
			o := i * 2;
		end f;
	end E;
	
	package F
		replaceable function f
			input Real i;
			output Real o;
		end f;
	end F;

	A.C z;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RedeclareFunction3",
			description="Functions redeclared in replacing package",
			flatModel="
fclass RedeclareTests.RedeclareFunction3
 constant Real z.x = 2.0;
 constant Real z.y = 1;
end RedeclareTests.RedeclareFunction3;
")})));
end RedeclareFunction3;



model RedeclareFunction4
    package A
        constant Integer n = 2;
        function f
            input Real a[n];
            output Real b;
        algorithm
            b := a * (1:n);
        end f;
    end A;
    
    model B
        package A2 = A;
        package A3 = A(n = 3);
        
        Real x = A2.f(1.0:2.0);
        Real y = A3.f(1.0:3.0);
    end B;
    
    B b;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RedeclareFunction4",
			description="Redeclared versions of same function",
			flatModel="
fclass RedeclareTests.RedeclareFunction4
 constant Real b.x = 5.0;
 constant Real b.y = 14.0;
end RedeclareTests.RedeclareFunction4;
")})));
end RedeclareFunction4;



model RedeclareEach1
	model A
		package B = D;
		Real a[B.N] = zeros(B.N);
	end A;
	
	package C
		extends D(N = 1);
	end C;
	
	package D
		constant Integer N = 2;
	end D;
	
	A a[2](redeclare each package B = C);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RedeclareEach1",
			description="Using redeclare on array",
			flatModel="
fclass RedeclareTests.RedeclareEach1
 constant Real a[1].a[1] = 0;
 constant Real a[2].a[1] = 0;
end RedeclareTests.RedeclareEach1;
")})));
end RedeclareEach1;


model RedeclareEach2
	model E
		package B = D;
	end E;
	
	model A
		extends E;
		Real a[B.N] = zeros(B.N);
	end A;
	
	package C
		extends D(N = 1);
	end C;
	
	package D
		constant Integer N = 2;
	end D;
	
	A a[2](redeclare each package B = C);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RedeclareEach2",
			description="Using redeclare on array",
			flatModel="
fclass RedeclareTests.RedeclareEach2
 constant Real a[1].a[1] = 0;
 constant Real a[2].a[1] = 0;
end RedeclareTests.RedeclareEach2;
")})));
end RedeclareEach2;



// When looking up the class H.D extends (E.D) from the redeclaration in A, 
// InstReplacingFullClassDecl.doSurroundingSuperLookupInstClass returns B, but should 
// lookup from H.D instead
model ShortRedeclare1
    package A
        replaceable function B
            output Real c = 2;
        end B;
    end A;
    
    package C = A(redeclare function B = F.D);
    package F = H;
    
    package H
        extends E;
          redeclare function extends D
        algorithm
            c := b;
        end D;
    end H;
    
    package E
        replaceable function D
            input Real b = 1;
            output Real c;
        end D;
    end E;
    
    Real x = C.B();
end ShortRedeclare1;


model CyclicRedeclare1
	package A
		replaceable model B = C;
	end A;
	
	model C
		Real x = 1;
	end C;
    
    package D
        extends A;
        redeclare model B = E.B;
    end D;
    
    package E
        extends A;
        redeclare model B = D.B;
    end E;
	
	E.B b;
end CyclicRedeclare1;


model ModifyClass1
    package A
        package B
            constant Real x = 1;
        end B;
    end A;
    
    package C = A(B(x = 2));
    
    Real y = C.B.x;
	Real Z = A.B.x;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ModifyClass1",
			description="Modification of constant in sub-package",
			flatModel="
fclass RedeclareTests.ModifyClass1
 Real y = 2.0;
 Real Z = 1.0;
end RedeclareTests.ModifyClass1;
")})));
end ModifyClass1;


model ModifyClass2
    package A
        type B = Real(max = 1);
    end A;
    
    package C = A(B(max = 2));
    
    C.B y = 0;
	A.B z = 0;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ModifyClass2",
			description="Modification of attribute of type declared in package being modified",
			flatModel="
fclass RedeclareTests.ModifyClass2
 RedeclareTests.ModifyClass2.C.B y(max = 2) = 0;
 RedeclareTests.ModifyClass2.A.B z = 0;

public
 type RedeclareTests.ModifyClass2.C.B = Real(max = 2);
 type RedeclareTests.ModifyClass2.A.B = Real(max = 1);
end RedeclareTests.ModifyClass2;
")})));
end ModifyClass2;


model ShortClassDeclEqu1
    model A
        Real x;
    equation
        x = y;
    end A;
    
    model B = A;
    
    B a;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="ShortClassDeclEqu1",
            description="Make sure equations in instances of short class decls are checked",
            errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/RedeclareTests.mo':
Semantic error at line 4701, column 13:
  Cannot find class or component declaration for y
")})));
end ShortClassDeclEqu1;


model ShortClassDeclEqu2Extra
    Real x;
equation
    x = y;
end ShortClassDeclEqu2Extra;

model ShortClassDeclEqu2 = ShortClassDeclEqu2Extra
	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ShortClassDeclEqu2",
			description="Make sure equations in short class decls being instantiated are checked",
			errorMessage="
1 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/RedeclareTests.mo':
Semantic error at line 4724, column 9:
  Cannot find class or component declaration for y
")})));


model ShortClassDeclClass1
	model A
		replaceable function B = C;
		
		Real x = B(y);
		Real y = 1;
	end A;
	
	partial function C
		input Real z;
		output Real w;
	end C;
	
	model D
		replaceable function E = C;
		
		A a(redeclare function B = E);
	end D;
	
	model F
	    replaceable record G
			replaceable function H = C;
	    end G;
		replaceable function I = G.H;
		
		D d(redeclare function E = I);
	end F;
	
	function J
        extends C;
    algorithm
        w := z;
	end J;
	
	record K
		function H = J;
	end K;
	
	F f(redeclare record G = K);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ShortClassDeclClass1",
			description="Lookup through short class decl with replacing short class decls above and below",
			flatModel="
fclass RedeclareTests.ShortClassDeclClass1
 Real f.d.a.x = RedeclareTests.ShortClassDeclClass1.J(f.d.a.y);
 Real f.d.a.y = 1;

public
 function RedeclareTests.ShortClassDeclClass1.J
  input Real z;
  output Real w;
 algorithm
  w := z;
  return;
 end RedeclareTests.ShortClassDeclClass1.J;

end RedeclareTests.ShortClassDeclClass1;
")})));
end ShortClassDeclClass1;


model ReplacableArray1
    model A
        replaceable B b[2];
    end A;
    
    model B
        Real x;
    end B;
    
	model C
	    extends A;
	    redeclare D b;
	end C;
    
    model D
        Real x;
        Real y;
    end D;
    
    C c;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ReplacableArray1",
			description="Redeclaring array of components as element in subclass, omitting size",
			flatModel="
fclass RedeclareTests.ReplacableArray1
 Real c.b[1].x;
 Real c.b[1].y;
 Real c.b[2].x;
 Real c.b[2].y;
end RedeclareTests.ReplacableArray1;
")})));
end ReplacableArray1;


model ReplacableArray2
    model A
        replaceable B b[2];
    end A;
    
    model B
        Real x;
    end B;
    
	model C
	    extends A(redeclare D b);
	end C;
    
    model D
        Real x;
        Real y;
    end D;
    
    C c;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ReplacableArray2",
			description="Redeclaring array of components in modification on extends, omitting size",
			flatModel="
fclass RedeclareTests.ReplacableArray2
 Real c.b[1].x;
 Real c.b[1].y;
 Real c.b[2].x;
 Real c.b[2].y;
end RedeclareTests.ReplacableArray2;
")})));
end ReplacableArray2;


model ReplacableArray3
    model A
        replaceable B b[2];
    end A;
    
    model B
        Real x;
    end B;
    
	model C
	    extends A(redeclare D b[2]);
	end C;
	
    model D
        Real x;
        Real y;
    end D;
    
    C c;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ReplacableArray3",
			description="Redeclaring array of components in modification on extends, including size",
			flatModel="
fclass RedeclareTests.ReplacableArray3
 Real c.b[1].x;
 Real c.b[1].y;
 Real c.b[2].x;
 Real c.b[2].y;
end RedeclareTests.ReplacableArray3;
")})));
end ReplacableArray3;


model ReplacableArray4
    model A
        replaceable Real x[2];
    end A;
    
    model B
        extends A(redeclare Real x(each start = 1));
    end B;
    
    B b;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ReplacableArray4",
			description="Redeclare of primitive array ommitting size, with each on modifier on redeclaration",
			flatModel="
fclass RedeclareTests.ReplacableArray4
 Real b.x[2](each start = 1);
end RedeclareTests.ReplacableArray4;
")})));
end ReplacableArray4;


model ReplacableArray5
    package A
        constant Integer n = 2;
		
		model B
            replaceable Real x[n];
	    end B;
    end A;
    
    model C
        extends A.B(redeclare Real x(each start = 1));
    end C;
    
    C c;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ReplacableArray5",
			description="Redeclare of array with size depending on constant not reachable from redeclaration",
			flatModel="
fclass RedeclareTests.ReplacableArray5
 Real c.x[2](each start = 1);
end RedeclareTests.ReplacableArray5;
")})));
end ReplacableArray5;


model ReplacableArray6
    model A
        replaceable Real x[2];
    end A;
    
    model B
        extends A(redeclare Real x(start = 1:2));
    end B;
    
    B b;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ReplacableArray6",
			description="Redeclare of primitive array ommitting size, with array modifier on redeclaration",
			flatModel="
fclass RedeclareTests.ReplacableArray6
 Real b.x[2](start = 1:2);
end RedeclareTests.ReplacableArray6;
")})));
end ReplacableArray6;


model ReplacableArray7
    model A
        replaceable B b[2];
    end A;
	
	model B
		Real x;
	end B;
    
    model C
        extends A(redeclare B b(x(start = 1:2) = 3:4));
    end C;
    
    C c;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ReplacableArray7",
			description="Redeclare of composite array ommitting size, with array modifier on scalar member on redeclaration",
			flatModel="
fclass RedeclareTests.ReplacableArray7
 Real c.b[1].x(start = (1:2)[1]) = (3:4)[1];
 Real c.b[2].x(start = (1:2)[2]) = (3:4)[2];
end RedeclareTests.ReplacableArray7;
")})));
end ReplacableArray7;


model RedeclareConditional1
    model A
        parameter Boolean use_b;
        B b if use_b;
    end A;
    
    model B
        Real x = time;
    end B;
    
    model C
        extends B;
        Real y = x + 1;
    end C;
    
    A a(use_b = false, redeclare C b);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareConditional1",
			description="Redeclaring inactive conditional as modification",
			flatModel="
fclass RedeclareTests.RedeclareConditional1
 parameter Boolean a.use_b = false /* false */;
end RedeclareTests.RedeclareConditional1;
")})));
end RedeclareConditional1;


model RedeclareConditional2
    model A
        parameter Boolean use_b;
        B b if use_b;
    end A;
    
    model B
        Real x = time;
    end B;
    
    model C
        extends B;
        Real y = x + 1;
    end C;
    
	model D
        extends A(use_b = false);
		redeclare C b;
	end D;
	
	D d;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="RedeclareConditional2",
			description="Redeclaring inactive conditional as element",
			flatModel="
fclass RedeclareTests.RedeclareConditional2
 parameter Boolean d.use_b = false /* false */;
end RedeclareTests.RedeclareConditional2;
")})));
end RedeclareConditional2;


model RedeclarePrimitive1
    model A
        replaceable Real x;
    end A;
    
    type B = Real(unit="V");
    
    A a(redeclare B x);

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="RedeclarePrimitive1",
            description="Subtyping of primitive variables",
            flatModel="
fclass RedeclareTests.RedeclarePrimitive1
 RedeclareTests.RedeclarePrimitive1.B a.x;

public
 type RedeclareTests.RedeclarePrimitive1.B = Real(unit = \"V\");
end RedeclareTests.RedeclarePrimitive1;
")})));
end RedeclarePrimitive1;


end RedeclareTests;
