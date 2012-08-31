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


model ConnectTests

  class ConnectTest1

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ConnectTest1",
			description="Test of generation of connection equations.",
			flatModel="
fclass ConnectTests.ConnectTest1
 Real c2.ca.x;
 Real c2.ca.y;
 Real c2.cb.x;
 Real c2.cb.y;
equation
  - ( c2.ca.x ) - ( c2.cb.x ) = 0;
 c2.ca.y = c2.cb.y;
 c2.ca.x = 0;
 c2.cb.x = 0;
end ConnectTests.ConnectTest1;
")})));

	connector Ca
		flow Real x;
		Real y;
	end Ca;
	
	connector Cb
		flow Real x;
		Real y;
	end Cb;
	
	model C2
		Ca ca;
		Cb cb;
	equation
      connect(ca,cb);
    end C2;
    
    C2 c2;  
      
   end ConnectTest1;

    class ConnectTest2_Err

	connector Ca
		flow Real x;
		Real y;
	end Ca;
	
	connector Cb
		flow Real x;
		Real y;
	end Cb;
	
	model C2
		Ca ca;
		Cb cb;
	equation
      connect(cc,cb);
    end C2;
    
    C2 c2;  
      

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="ConnectTest2_Err",
			description="Basic test of name lookup in connect clauses",
			errorMessage="
1 error(s) found...
In file 'src/test/modelica/ConnectTests.mo':
Semantic error at line 53, column 15:
  Cannot find class or component declaration for cc
")})));
   end ConnectTest2_Err;
   
model ConnectTest3
 block Gain 
  "Output the product of a gain value with the input signal" 
  
  parameter Real k=1 "Gain value multiplied with input signal";
public 
  RealInput u "Input signal connector";
  RealOutput y "Output signal connector";
equation 
  y = k*u;
end Gain;
 
connector RealInput = input RealSignal "'input Real' as connector";
 
connector RealSignal 
  "Real port (both input/output possible)" 
  replaceable type SignalType = Real;
  
  extends SignalType;
  
end RealSignal;
 
connector RealOutput = output RealSignal "'output Real' as connector";
 
block Constant 
  "Generate constant signal of type Real" 
  parameter Real k=1 "Constant output value";
  extends SO;
equation 
  y = k;
end Constant;
 
partial block SO 
  "Single Output continuous control block" 
  RealOutput y "Connector of Real output signal";
end SO;  
  
  Gain gain;
  Constant const;
equation 
  connect(const.y, gain.u);



	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ConnectTest3",
			description="Test of generation of connection equations",
			flatModel="
fclass ConnectTests.ConnectTest3
 parameter Real gain.k = 1 \"Gain value multiplied with input signal\" /* 1 */;
 ConnectTests.ConnectTest3.RealInput gain.u \"Input signal connector\";
 ConnectTests.ConnectTest3.RealOutput gain.y \"Output signal connector\";
 parameter Real const.k = 1 \"Constant output value\" /* 1 */;
 ConnectTests.ConnectTest3.RealOutput const.y \"Connector of Real output signal\";
equation
 gain.y = ( gain.k ) * ( gain.u );
 const.y = const.k;
 const.y = gain.u;

public
 type ConnectTests.ConnectTest3.RealInput = Real;
 type ConnectTests.ConnectTest3.RealOutput = Real;
end ConnectTests.ConnectTest3;
")})));
end ConnectTest3;

  class ConnectTest4

	connector Ca
		flow Real x;
		Real y;
	end Ca;
	
	connector Cb
		flow Real x;
		Real y;
	end Cb;
	
	model C2
		Ca ca;
		Cb cb;
                Ca ca2;
	equation
        ca2.x =3;
      connect(ca,cb);
    end C2;
    
    C2 c2;  
      

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ConnectTest4",
			description="Test of generation of connection equations.",
			flatModel="
fclass ConnectTests.ConnectTest4
 Real c2.ca.x;
 Real c2.ca.y;
 Real c2.cb.x;
 Real c2.cb.y;
 Real c2.ca2.x;
 Real c2.ca2.y;
equation
 c2.ca2.x = 3;
  - ( c2.ca.x ) - ( c2.cb.x ) = 0;
 c2.ca.y = c2.cb.y;
 c2.ca.x = 0;
 c2.cb.x = 0;
 c2.ca2.x = 0;

end ConnectTests.ConnectTest4;
")})));
   end ConnectTest4;

model ConnectTest5
  connector C
    parameter Integer n = 2;
    Real x[n];
  end C;
  C c1;
  C c2;

equation
  connect(c1,c2);
  c1.x = {1,2};


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ConnectTest5",
			description="Test of generation of connection equations.",
			flatModel="
fclass ConnectTests.ConnectTest5
 parameter Integer c1.n = 2 /* 2 */;
 Real c1.x[2];
 parameter Integer c2.n = 2 /* 2 */;
 Real c2.x[2];
equation
 c1.x[1:2] = {1,2};
 c1.x[1:2] = c2.x[1:2];
end ConnectTests.ConnectTest5;
")})));
end ConnectTest5;


model ConnectTest6
	connector A
		Real y[2];
		flow Real x[2];
	end A;
	
	model B
		A a1;
		A a2;
          equation
            connect(a1,a2);
	end B;
	
	B b1;
	B b2;
equation
	connect(b1.a1, b2.a2);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ConnectTest6",
			description="Connecting array flow variables",
			flatModel="
fclass ConnectTests.ConnectTest6
 Real b1.a1.y[2];
 Real b1.a1.x[2];
 Real b1.a2.y[2];
 Real b1.a2.x[2];
 Real b2.a1.y[2];
 Real b2.a1.x[2];
 Real b2.a2.y[2];
 Real b2.a2.x[2];
equation
 b1.a1.x[1:2] + b2.a2.x[1:2] = zeros(2);
 b1.a1.y[1:2] = b2.a2.y[1:2];
  - ( b1.a1.x[1:2] ) - ( b1.a2.x[1:2] ) = zeros(2);
 b1.a1.y[1:2] = b1.a2.y[1:2];
 b1.a2.x[1:2] = zeros(2);
  - ( b2.a1.x[1:2] ) - ( b2.a2.x[1:2] ) = zeros(2);
 b2.a1.y[1:2] = b2.a2.y[1:2];
 b2.a1.x[1:2] = zeros(2);

end ConnectTests.ConnectTest6;
")})));
end ConnectTest6;


model ConnectTest7
    connector A
        Real x;
        flow Real y;
    end A;
    
    A a1[2];
    A a2[2];
equation
    connect(a1, a2);
    a1.x = ones(2);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ConnectTest7",
			description="Connecting arrays of connectors",
			flatModel="
fclass ConnectTests.ConnectTest7
 Real a1[1].x;
 Real a1[1].y;
 Real a1[2].x;
 Real a1[2].y;
 Real a2[1].x;
 Real a2[1].y;
 Real a2[2].x;
 Real a2[2].y;
equation
 a1[1:2].x = ones(2);
 a1[1].x = a2[1].x;
  - ( a1[1].y ) - ( a2[1].y ) = 0;
 a1[2].x = a2[2].x;
  - ( a1[2].y ) - ( a2[2].y ) = 0;
 a1[1].y = 0;
 a1[2].y = 0;
 a2[1].y = 0;
 a2[2].y = 0;

end ConnectTests.ConnectTest7;
")})));
end ConnectTest7;


model ConnectTest8
    connector A
        Real x;
        flow Real y;
    end A;
    
    A a[4];
equation
    for i in 1:3 loop
        connect(a[i], a[i+1]);
    end for;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ConnectTest8",
			description="Connect in for loop",
			flatModel="
fclass ConnectTests.ConnectTest8
 Real a[1].x;
 Real a[1].y;
 Real a[2].x;
 Real a[2].y;
 Real a[3].x;
 Real a[3].y;
 Real a[4].x;
 Real a[4].y;
equation
 for i in 1:3 loop
 end for;
 a[1].x = a[2].x;
 a[2].x = a[3].x;
 a[3].x = a[4].x;
  - ( a[1].y ) - ( a[2].y ) - ( a[3].y ) - ( a[4].y ) = 0;
 a[1].y = 0;
 a[2].y = 0;
 a[3].y = 0;
 a[4].y = 0;

end ConnectTests.ConnectTest8;
")})));
end ConnectTest8;


model ConnectTest9
	connector A
		Real x;
		flow Real y;
	end A;
	
	A a[2];
equation
	connect(a[1], a[2]);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ConnectTest9",
			description="Connecting array elements",
			flatModel="
fclass ConnectTests.ConnectTest9
 Real a[1].x;
 Real a[1].y;
 Real a[2].x;
 Real a[2].y;
equation
 a[1].x = a[2].x;
  - ( a[1].y ) - ( a[2].y ) = 0;
 a[1].y = 0;
 a[2].y = 0;

end ConnectTests.ConnectTest9;
")})));
end ConnectTest9;


model ConnectTest10
	connector A
		Real x;
		Real y;
	end A;
	
	connector B
		Real y;
		Real x;
	end B;
	
	A a;
	B b;
equation
	connect(a, b);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ConnectTest10",
			description="Check that order of variables within connector does not matter",
			flatModel="
fclass ConnectTests.ConnectTest10
 Real a.x;
 Real a.y;
 Real b.y;
 Real b.x;
equation
 a.x = b.x;
 a.y = b.y;

end ConnectTests.ConnectTest10;
")})));
end ConnectTest10;


model ConnectTest11
	connector B
	    Real x;
	    flow Real y;
	end B;
  
	connector C
	    B b1;
	    B b2;
	end C;
  
	C c1;
	C c2;
equation
	connect(c1, c2);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ConnectTest11",
			description="Connecting nestled connectors",
			flatModel="
fclass ConnectTests.ConnectTest11
 Real c1.b1.x;
 Real c1.b1.y;
 Real c1.b2.x;
 Real c1.b2.y;
 Real c2.b1.x;
 Real c2.b1.y;
 Real c2.b2.x;
 Real c2.b2.y;
equation
 c1.b1.x = c2.b1.x;
  - ( c1.b1.y ) - ( c2.b1.y ) = 0;
 c1.b2.x = c2.b2.x;
  - ( c1.b2.y ) - ( c2.b2.y ) = 0;
 c1.b1.y = 0;
 c1.b2.y = 0;
 c2.b1.y = 0;
 c2.b2.y = 0;

end ConnectTests.ConnectTest11;
")})));
end ConnectTest11;


model ConnectTest12
	connector A
		Real x;
		flow Real y;
	end A;
	
	connector B
		A a[2];
	end B;
	
	B b[3,4];
equation
	for i in 1:2, j in 1:3 loop
		connect(b[i,j].a[1], b[i,j+1].a[1]);
		connect(b[i,j].a[2], b[i+1,j].a[2]);
		connect(b[i,j].a[1], b[i,j].a[2]);
	end for;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ConnectTest12",
			description="Connect in for loop on nestles arrays of connectors",
			flatModel="
fclass ConnectTests.ConnectTest12
 Real b[1,1].a[1].x;
 Real b[1,1].a[1].y;
 Real b[1,1].a[2].x;
 Real b[1,1].a[2].y;
 Real b[1,2].a[1].x;
 Real b[1,2].a[1].y;
 Real b[1,2].a[2].x;
 Real b[1,2].a[2].y;
 Real b[1,3].a[1].x;
 Real b[1,3].a[1].y;
 Real b[1,3].a[2].x;
 Real b[1,3].a[2].y;
 Real b[1,4].a[1].x;
 Real b[1,4].a[1].y;
 Real b[1,4].a[2].x;
 Real b[1,4].a[2].y;
 Real b[2,1].a[1].x;
 Real b[2,1].a[1].y;
 Real b[2,1].a[2].x;
 Real b[2,1].a[2].y;
 Real b[2,2].a[1].x;
 Real b[2,2].a[1].y;
 Real b[2,2].a[2].x;
 Real b[2,2].a[2].y;
 Real b[2,3].a[1].x;
 Real b[2,3].a[1].y;
 Real b[2,3].a[2].x;
 Real b[2,3].a[2].y;
 Real b[2,4].a[1].x;
 Real b[2,4].a[1].y;
 Real b[2,4].a[2].x;
 Real b[2,4].a[2].y;
 Real b[3,1].a[1].x;
 Real b[3,1].a[1].y;
 Real b[3,1].a[2].x;
 Real b[3,1].a[2].y;
 Real b[3,2].a[1].x;
 Real b[3,2].a[1].y;
 Real b[3,2].a[2].x;
 Real b[3,2].a[2].y;
 Real b[3,3].a[1].x;
 Real b[3,3].a[1].y;
 Real b[3,3].a[2].x;
 Real b[3,3].a[2].y;
 Real b[3,4].a[1].x;
 Real b[3,4].a[1].y;
 Real b[3,4].a[2].x;
 Real b[3,4].a[2].y;
equation
 for i in 1:2, j in 1:3 loop
 end for;
 b[1,1].a[1].x = b[1,1].a[2].x;
 b[1,1].a[2].x = b[1,2].a[1].x;
 b[1,2].a[1].x = b[1,2].a[2].x;
 b[1,2].a[2].x = b[1,3].a[1].x;
 b[1,3].a[1].x = b[1,3].a[2].x;
 b[1,3].a[2].x = b[1,4].a[1].x;
 b[1,4].a[1].x = b[2,1].a[1].x;
 b[2,1].a[1].x = b[2,1].a[2].x;
 b[2,1].a[2].x = b[2,2].a[1].x;
 b[2,2].a[1].x = b[2,2].a[2].x;
 b[2,2].a[2].x = b[2,3].a[1].x;
 b[2,3].a[1].x = b[2,3].a[2].x;
 b[2,3].a[2].x = b[2,4].a[1].x;
 b[2,4].a[1].x = b[3,1].a[2].x;
 b[3,1].a[2].x = b[3,2].a[2].x;
 b[3,2].a[2].x = b[3,3].a[2].x;
  - ( b[1,1].a[1].y ) - ( b[1,1].a[2].y ) - ( b[1,2].a[1].y ) - ( b[1,2].a[2].y ) - ( b[1,3].a[1].y ) - ( b[1,3].a[2].y ) - ( b[1,4].a[1].y ) - ( b[2,1].a[1].y ) - ( b[2,1].a[2].y ) - ( b[2,2].a[1].y ) - ( b[2,2].a[2].y ) - ( b[2,3].a[1].y ) - ( b[2,3].a[2].y ) - ( b[2,4].a[1].y ) - ( b[3,1].a[2].y ) - ( b[3,2].a[2].y ) - ( b[3,3].a[2].y ) = 0;
 b[1,1].a[1].y = 0;
 b[1,1].a[2].y = 0;
 b[1,2].a[1].y = 0;
 b[1,2].a[2].y = 0;
 b[1,3].a[1].y = 0;
 b[1,3].a[2].y = 0;
 b[1,4].a[1].y = 0;
 b[1,4].a[2].y = 0;
 b[2,1].a[1].y = 0;
 b[2,1].a[2].y = 0;
 b[2,2].a[1].y = 0;
 b[2,2].a[2].y = 0;
 b[2,3].a[1].y = 0;
 b[2,3].a[2].y = 0;
 b[2,4].a[1].y = 0;
 b[2,4].a[2].y = 0;
 b[3,1].a[1].y = 0;
 b[3,1].a[2].y = 0;
 b[3,2].a[1].y = 0;
 b[3,2].a[2].y = 0;
 b[3,3].a[1].y = 0;
 b[3,3].a[2].y = 0;
 b[3,4].a[1].y = 0;
 b[3,4].a[2].y = 0;

end ConnectTests.ConnectTest12;
")})));
end ConnectTest12;


model ConnectTest13
	connector A
		Real x;
		flow Real y;
	end A;
	
	connector B
		A a[2];
	end B;
	
	B b[3];
equation
	for i in 1:2 loop
		connect(b[i].a, b[i+1].a);
	end for;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ConnectTest13",
			description="Connecting arrays of connectors in a for loop",
			flatModel="
fclass ConnectTests.ConnectTest13
 Real b[1].a[1].x;
 Real b[1].a[1].y;
 Real b[1].a[2].x;
 Real b[1].a[2].y;
 Real b[2].a[1].x;
 Real b[2].a[1].y;
 Real b[2].a[2].x;
 Real b[2].a[2].y;
 Real b[3].a[1].x;
 Real b[3].a[1].y;
 Real b[3].a[2].x;
 Real b[3].a[2].y;
equation
 for i in 1:2 loop
 end for;
 b[1].a[1].x = b[2].a[1].x;
 b[2].a[1].x = b[3].a[1].x;
  - ( b[1].a[1].y ) - ( b[2].a[1].y ) - ( b[3].a[1].y ) = 0;
 b[1].a[2].x = b[2].a[2].x;
 b[2].a[2].x = b[3].a[2].x;
  - ( b[1].a[2].y ) - ( b[2].a[2].y ) - ( b[3].a[2].y ) = 0;
 b[1].a[1].y = 0;
 b[1].a[2].y = 0;
 b[2].a[1].y = 0;
 b[2].a[2].y = 0;
 b[3].a[1].y = 0;
 b[3].a[2].y = 0;

end ConnectTests.ConnectTest13;
")})));
end ConnectTest13;


model ConnectTest14
	connector A
		Real x;
		flow Real y;
	end A;
	
	connector B
		A a[2];
	end B;
	
	B b1[2,2];
	B b2[2,2];
equation
	connect(b1.a, b2.a);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ConnectTest14",
			description="Connecting nestled arrays of connectors",
			flatModel="
fclass ConnectTests.ConnectTest14
 Real b1[1,1].a[1].x;
 Real b1[1,1].a[1].y;
 Real b1[1,1].a[2].x;
 Real b1[1,1].a[2].y;
 Real b1[1,2].a[1].x;
 Real b1[1,2].a[1].y;
 Real b1[1,2].a[2].x;
 Real b1[1,2].a[2].y;
 Real b1[2,1].a[1].x;
 Real b1[2,1].a[1].y;
 Real b1[2,1].a[2].x;
 Real b1[2,1].a[2].y;
 Real b1[2,2].a[1].x;
 Real b1[2,2].a[1].y;
 Real b1[2,2].a[2].x;
 Real b1[2,2].a[2].y;
 Real b2[1,1].a[1].x;
 Real b2[1,1].a[1].y;
 Real b2[1,1].a[2].x;
 Real b2[1,1].a[2].y;
 Real b2[1,2].a[1].x;
 Real b2[1,2].a[1].y;
 Real b2[1,2].a[2].x;
 Real b2[1,2].a[2].y;
 Real b2[2,1].a[1].x;
 Real b2[2,1].a[1].y;
 Real b2[2,1].a[2].x;
 Real b2[2,1].a[2].y;
 Real b2[2,2].a[1].x;
 Real b2[2,2].a[1].y;
 Real b2[2,2].a[2].x;
 Real b2[2,2].a[2].y;
equation
 b1[1,1].a[1].x = b2[1,1].a[1].x;
  - ( b1[1,1].a[1].y ) - ( b2[1,1].a[1].y ) = 0;
 b1[1,1].a[2].x = b2[1,1].a[2].x;
  - ( b1[1,1].a[2].y ) - ( b2[1,1].a[2].y ) = 0;
 b1[1,2].a[1].x = b2[1,2].a[1].x;
  - ( b1[1,2].a[1].y ) - ( b2[1,2].a[1].y ) = 0;
 b1[1,2].a[2].x = b2[1,2].a[2].x;
  - ( b1[1,2].a[2].y ) - ( b2[1,2].a[2].y ) = 0;
 b1[2,1].a[1].x = b2[2,1].a[1].x;
  - ( b1[2,1].a[1].y ) - ( b2[2,1].a[1].y ) = 0;
 b1[2,1].a[2].x = b2[2,1].a[2].x;
  - ( b1[2,1].a[2].y ) - ( b2[2,1].a[2].y ) = 0;
 b1[2,2].a[1].x = b2[2,2].a[1].x;
  - ( b1[2,2].a[1].y ) - ( b2[2,2].a[1].y ) = 0;
 b1[2,2].a[2].x = b2[2,2].a[2].x;
  - ( b1[2,2].a[2].y ) - ( b2[2,2].a[2].y ) = 0;
 b1[1,1].a[1].y = 0;
 b1[1,1].a[2].y = 0;
 b1[1,2].a[1].y = 0;
 b1[1,2].a[2].y = 0;
 b1[2,1].a[1].y = 0;
 b1[2,1].a[2].y = 0;
 b1[2,2].a[1].y = 0;
 b1[2,2].a[2].y = 0;
 b2[1,1].a[1].y = 0;
 b2[1,1].a[2].y = 0;
 b2[1,2].a[1].y = 0;
 b2[1,2].a[2].y = 0;
 b2[2,1].a[1].y = 0;
 b2[2,1].a[2].y = 0;
 b2[2,2].a[1].y = 0;
 b2[2,2].a[2].y = 0;

end ConnectTests.ConnectTest14;
")})));
end ConnectTest14;


model ConnectTest15
	connector A
		Real x;
		flow Real y;
	end A;
	
	connector B
		A a[2];
	end B;
	
	B b[2,2,2];
equation
	connect(b[1,:,:].a, b[2,:,:].a);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ConnectTest15",
			description="Connecting nestled arrays of connectors using simple slice operation",
			flatModel="
fclass ConnectTests.ConnectTest15
 Real b[1,1,1].a[1].x;
 Real b[1,1,1].a[1].y;
 Real b[1,1,1].a[2].x;
 Real b[1,1,1].a[2].y;
 Real b[1,1,2].a[1].x;
 Real b[1,1,2].a[1].y;
 Real b[1,1,2].a[2].x;
 Real b[1,1,2].a[2].y;
 Real b[1,2,1].a[1].x;
 Real b[1,2,1].a[1].y;
 Real b[1,2,1].a[2].x;
 Real b[1,2,1].a[2].y;
 Real b[1,2,2].a[1].x;
 Real b[1,2,2].a[1].y;
 Real b[1,2,2].a[2].x;
 Real b[1,2,2].a[2].y;
 Real b[2,1,1].a[1].x;
 Real b[2,1,1].a[1].y;
 Real b[2,1,1].a[2].x;
 Real b[2,1,1].a[2].y;
 Real b[2,1,2].a[1].x;
 Real b[2,1,2].a[1].y;
 Real b[2,1,2].a[2].x;
 Real b[2,1,2].a[2].y;
 Real b[2,2,1].a[1].x;
 Real b[2,2,1].a[1].y;
 Real b[2,2,1].a[2].x;
 Real b[2,2,1].a[2].y;
 Real b[2,2,2].a[1].x;
 Real b[2,2,2].a[1].y;
 Real b[2,2,2].a[2].x;
 Real b[2,2,2].a[2].y;
equation
 b[1,1,1].a[1].x = b[2,1,1].a[1].x;
  - ( b[1,1,1].a[1].y ) - ( b[2,1,1].a[1].y ) = 0;
 b[1,1,1].a[2].x = b[2,1,1].a[2].x;
  - ( b[1,1,1].a[2].y ) - ( b[2,1,1].a[2].y ) = 0;
 b[1,1,2].a[1].x = b[2,1,2].a[1].x;
  - ( b[1,1,2].a[1].y ) - ( b[2,1,2].a[1].y ) = 0;
 b[1,1,2].a[2].x = b[2,1,2].a[2].x;
  - ( b[1,1,2].a[2].y ) - ( b[2,1,2].a[2].y ) = 0;
 b[1,2,1].a[1].x = b[2,2,1].a[1].x;
  - ( b[1,2,1].a[1].y ) - ( b[2,2,1].a[1].y ) = 0;
 b[1,2,1].a[2].x = b[2,2,1].a[2].x;
  - ( b[1,2,1].a[2].y ) - ( b[2,2,1].a[2].y ) = 0;
 b[1,2,2].a[1].x = b[2,2,2].a[1].x;
  - ( b[1,2,2].a[1].y ) - ( b[2,2,2].a[1].y ) = 0;
 b[1,2,2].a[2].x = b[2,2,2].a[2].x;
  - ( b[1,2,2].a[2].y ) - ( b[2,2,2].a[2].y ) = 0;
 b[1,1,1].a[1].y = 0;
 b[1,1,1].a[2].y = 0;
 b[1,1,2].a[1].y = 0;
 b[1,1,2].a[2].y = 0;
 b[1,2,1].a[1].y = 0;
 b[1,2,1].a[2].y = 0;
 b[1,2,2].a[1].y = 0;
 b[1,2,2].a[2].y = 0;
 b[2,1,1].a[1].y = 0;
 b[2,1,1].a[2].y = 0;
 b[2,1,2].a[1].y = 0;
 b[2,1,2].a[2].y = 0;
 b[2,2,1].a[1].y = 0;
 b[2,2,1].a[2].y = 0;
 b[2,2,2].a[1].y = 0;
 b[2,2,2].a[2].y = 0;

end ConnectTests.ConnectTest15;
")})));
end ConnectTest15;


model ConnectTest16
    connector A
        Real x;
    end A;
    
    model B
        A a1[2];
        A a2[2];
    equation
        connect(a1, a2);
    end B;
    
    B b[2];

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ConnectTest16",
			description="Connecting arrays of connectors within an array of component instances, no indices",
			flatModel="
fclass ConnectTests.ConnectTest16
 Real b[1].a1[1].x;
 Real b[1].a1[2].x;
 Real b[1].a2[1].x;
 Real b[1].a2[2].x;
 Real b[2].a1[1].x;
 Real b[2].a1[2].x;
 Real b[2].a2[1].x;
 Real b[2].a2[2].x;
equation
 b[1].a1[1].x = b[1].a2[1].x;
 b[1].a1[2].x = b[1].a2[2].x;
 b[2].a1[1].x = b[2].a2[1].x;
 b[2].a1[2].x = b[2].a2[2].x;

end ConnectTests.ConnectTest16;
")})));
end ConnectTest16;


model ConnectTest17
    connector A
        Real x;
    end A;
    
    model B
        A a1[3];
        A a2[3];
    equation
        connect(a1[1:2], a2[2:3]);
    end B;
    
    B b[2];

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="ConnectTest17",
            description="Connecting arrays of connectors within an array of component instances, slices",
            flatModel="
fclass ConnectTests.ConnectTest17
 Real b[1].a1[1].x;
 Real b[1].a1[2].x;
 Real b[1].a1[3].x;
 Real b[1].a2[1].x;
 Real b[1].a2[2].x;
 Real b[1].a2[3].x;
 Real b[2].a1[1].x;
 Real b[2].a1[2].x;
 Real b[2].a1[3].x;
 Real b[2].a2[1].x;
 Real b[2].a2[2].x;
 Real b[2].a2[3].x;
equation
 b[1].a1[1].x = b[1].a2[2].x;
 b[1].a1[2].x = b[1].a2[3].x;
 b[2].a1[1].x = b[2].a2[2].x;
 b[2].a1[2].x = b[2].a2[3].x;

end ConnectTests.ConnectTest17;
")})));
end ConnectTest17;


model ConnectTest18
    connector A
        Real x;
    end A;
    
    model B
        A a1;
        A a2;
        A a3[2];
    equation
        connect(a1, a3[1]);
        connect(a2, a3[2]);
    end B;
    
    B b[2];

	annotation(__JModelica(UnitTesting(tests={ 
		FlatteningTestCase(
			name="ConnectTest18",
			description="Connecting single element in array of connectors",
			flatModel="
fclass ConnectTests.ConnectTest18
 Real b[1].a1.x;
 Real b[1].a2.x;
 Real b[1].a3[1].x;
 Real b[1].a3[2].x;
 Real b[2].a1.x;
 Real b[2].a2.x;
 Real b[2].a3[1].x;
 Real b[2].a3[2].x;
equation
 b[1].a1.x = b[1].a3[1].x;
 b[1].a2.x = b[1].a3[2].x;
 b[2].a1.x = b[2].a3[1].x;
 b[2].a2.x = b[2].a3[2].x;
end ConnectTests.ConnectTest18;
")})));
end ConnectTest18;


model ConnectTest19
    model A
        Real a1;
        Real a2[1];
    equation
        connect(a1, a2[1]);
    end B;
    
    A b[2];

	annotation(__JModelica(UnitTesting(tests={ 
		FlatteningTestCase(
			name="ConnectTest19",
			description="Connecting single element in array of reals",
			flatModel="
fclass ConnectTests.ConnectTest19
 Real b[1].a1;
 Real b[1].a2[1];
 Real b[2].a1;
 Real b[2].a2[1];
equation
 b[1].a1 = b[1].a2[1];
 b[2].a1 = b[2].a2[1];
end ConnectTests.ConnectTest19;
")})));
end ConnectTest19;


model ConnectTest20
    model A
        Real a1;
        Real a2;
        Real a3[2];
    equation
        connect(a1, a3[1]);
        connect(a2, a3[2]);
    end B;
    
    A b[2];

	annotation(__JModelica(UnitTesting(tests={ 
		FlatteningTestCase(
			name="ConnectTest20",
			description="Connecting several elemens in array of reals, one at a time",
			flatModel="
fclass ConnectTests.ConnectTest20
 Real b[1].a1;
 Real b[1].a2;
 Real b[1].a3[2];
 Real b[2].a1;
 Real b[2].a2;
 Real b[2].a3[2];
equation
 b[1].a1 = b[1].a3[1];
 b[1].a2 = b[1].a3[2];
 b[2].a1 = b[2].a3[1];
 b[2].a2 = b[2].a3[2];
end ConnectTests.ConnectTest20;
")})));
end ConnectTest20;


model ConnectTest21
    model A
        Real a1[3];
        Real a2[3];
    equation
        connect(a1[1:2], a2[2:3]);
    end A;
    
    A b[2];

	annotation(__JModelica(UnitTesting(tests={ 
		FlatteningTestCase(
			name="ConnectTest21",
			description="Connecting arrays of reals within an array of component instances, slices",
			flatModel="
fclass ConnectTests.ConnectTest21
 Real b[1].a1[3];
 Real b[1].a2[3];
 Real b[2].a1[3];
 Real b[2].a2[3];
equation
 b[1].a1[1] = b[1].a2[2];
 b[1].a1[2] = b[1].a2[3];
 b[2].a1[1] = b[2].a2[2];
 b[2].a1[2] = b[2].a2[3];
end ConnectTests.ConnectTest21;
")})));
end ConnectTest21;


model Electrical
  
  connector Pin "Pin of an electrical component" 
    Real v "Potential at the pin";
    flow Real i "Current flowing into the pin";
  end Pin;

  connector PositivePin "Positive pin of an electric component" 
    Real v "Potential at the pin";
    flow Real i "Current flowing into the pin";
  end PositivePin;
  
  connector NegativePin "Negative pin of an electric component" 
    Real v "Potential at the pin";
    flow Real i "Current flowing into the pin";
  end NegativePin;
  
  partial model TwoPin "Component with one electrical port" 
    Real v "Voltage drop between the two pins (= p.v - n.v)";
    PositivePin p "Positive pin";
    NegativePin n "Negative pin";
  equation 
    v = p.v - n.v;
  end TwoPin;

  partial model OnePort 
    "Component with two electrical pins p and n and current i from p to n" 
    
    Real v "Voltage drop between the two pins (= p.v - n.v)";
    Real i "Current flowing from pin p to pin n";
    PositivePin p ;
    NegativePin n ;
  equation 
    v = p.v - n.v;
    0 = p.i + n.i;
    i = p.i;
  end OnePort;

 model Resistor "Ideal linear electrical resistor" 
    extends OnePort;
    parameter Real R=1 "Resistance";
  equation 
    R*i = v;
  end Resistor;

 model Capacitor "Ideal linear electrical capacitor" 
    extends OnePort;
    parameter Real C=1 "Capacitance";
  equation 
    i = C*der(v);
  end Capacitor;

  model Inductor "Ideal linear electrical inductor" 
    extends OnePort;
    parameter Real L=1 "Inductance";
  equation 
    L*der(i) = v;
  end Inductor;

 model ConstantVoltage "Source for constant voltage" 
    parameter Real V=1 "Value of constant voltage";
    extends OnePort;
  equation 
    v = V;
  end ConstantVoltage;

  model Ground "Ground node" 
    Pin p;
  equation 
    p.v = 0;
  end Ground;



end Electrical;

  model CircuitTest1
    Electrical.ConstantVoltage cv;
    Electrical.Ground g;
    Electrical.Resistor r;
    Electrical.Capacitor c;
  equation
    connect(cv.p,r.p);
    connect(r.p,c.p);
    connect(cv.n,g.p);
    connect(cv.n,r.n);
    connect(r.n,c.n);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="CircuitTest1",
			description="Test of generation of connection equations.",
			flatModel="
fclass ConnectTests.CircuitTest1
 parameter Real cv.V = 1 \"Value of constant voltage\" /* 1 */;
 Real cv.v \"Voltage drop between the two pins (= p.v - n.v)\";
 Real cv.i \"Current flowing from pin p to pin n\";
 Real cv.p.v \"Potential at the pin\";
 Real cv.p.i \"Current flowing into the pin\";
 Real cv.n.v \"Potential at the pin\";
 Real cv.n.i \"Current flowing into the pin\";
 Real g.p.v \"Potential at the pin\";
 Real g.p.i \"Current flowing into the pin\";
 parameter Real r.R = 1 \"Resistance\" /* 1 */;
 Real r.v \"Voltage drop between the two pins (= p.v - n.v)\";
 Real r.i \"Current flowing from pin p to pin n\";
 Real r.p.v \"Potential at the pin\";
 Real r.p.i \"Current flowing into the pin\";
 Real r.n.v \"Potential at the pin\";
 Real r.n.i \"Current flowing into the pin\";
 parameter Real c.C = 1 \"Capacitance\" /* 1 */;
 Real c.v \"Voltage drop between the two pins (= p.v - n.v)\";
 Real c.i \"Current flowing from pin p to pin n\";
 Real c.p.v \"Potential at the pin\";
 Real c.p.i \"Current flowing into the pin\";
 Real c.n.v \"Potential at the pin\";
 Real c.n.i \"Current flowing into the pin\";
equation
 cv.v = cv.V;
 cv.v = cv.p.v - ( cv.n.v );
 0 = cv.p.i + cv.n.i;
 cv.i = cv.p.i;
 g.p.v = 0;
 ( r.R ) * ( r.i ) = r.v;
 r.v = r.p.v - ( r.n.v );
 0 = r.p.i + r.n.i;
 r.i = r.p.i;
 c.i = ( c.C ) * ( c.der(v) );
 c.v = c.p.v - ( c.n.v );
 0 = c.p.i + c.n.i;
 c.i = c.p.i;
 c.p.i + cv.p.i + r.p.i = 0;
 c.p.v = cv.p.v;
 cv.p.v = r.p.v;
 c.n.i + cv.n.i + g.p.i + r.n.i = 0;
 c.n.v = cv.n.v;
 cv.n.v = g.p.v;
 g.p.v = r.n.v;

end ConnectTests.CircuitTest1;
")})));
  end CircuitTest1;

  model CircuitTest2
    model F
      extends Electrical.OnePort;
      Electrical.Resistor r;
      Electrical.Capacitor c;
    equation
      connect(p,r.p);
      connect(p,c.p);
      connect(n,r.n);
      connect(n,c.n);
    end F;

    model F2
      extends Electrical.TwoPin;
      Electrical.Resistor r;
      Electrical.Capacitor c;
    equation
      connect(p,r.p);
      connect(p,c.p);
      connect(n,r.n);
      connect(n,c.n);
    end F2;
  
    Electrical.ConstantVoltage cv;
    Electrical.Ground g;
    Electrical.Resistor r;
    F2 f;
  equation
    connect(cv.p,r.p);
    connect(r.p,f.p);
    connect(cv.n,g.p);
    connect(cv.n,r.n);
    connect(r.n,f.n);

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="CircuitTest2",
			description="Test of generation of connection equations",
			flatModel="
fclass ConnectTests.CircuitTest2
 parameter Real cv.V = 1 \"Value of constant voltage\" /* 1 */;
 Real cv.v \"Voltage drop between the two pins (= p.v - n.v)\";
 Real cv.i \"Current flowing from pin p to pin n\";
 Real cv.p.v \"Potential at the pin\";
 Real cv.p.i \"Current flowing into the pin\";
 Real cv.n.v \"Potential at the pin\";
 Real cv.n.i \"Current flowing into the pin\";
 Real g.p.v \"Potential at the pin\";
 Real g.p.i \"Current flowing into the pin\";
 parameter Real r.R = 1 \"Resistance\" /* 1 */;
 Real r.v \"Voltage drop between the two pins (= p.v - n.v)\";
 Real r.i \"Current flowing from pin p to pin n\";
 Real r.p.v \"Potential at the pin\";
 Real r.p.i \"Current flowing into the pin\";
 Real r.n.v \"Potential at the pin\";
 Real r.n.i \"Current flowing into the pin\";
 parameter Real f.r.R = 1 \"Resistance\" /* 1 */;
 Real f.r.v \"Voltage drop between the two pins (= p.v - n.v)\";
 Real f.r.i \"Current flowing from pin p to pin n\";
 Real f.r.p.v \"Potential at the pin\";
 Real f.r.p.i \"Current flowing into the pin\";
 Real f.r.n.v \"Potential at the pin\";
 Real f.r.n.i \"Current flowing into the pin\";
 parameter Real f.c.C = 1 \"Capacitance\" /* 1 */;
 Real f.c.v \"Voltage drop between the two pins (= p.v - n.v)\";
 Real f.c.i \"Current flowing from pin p to pin n\";
 Real f.c.p.v \"Potential at the pin\";
 Real f.c.p.i \"Current flowing into the pin\";
 Real f.c.n.v \"Potential at the pin\";
 Real f.c.n.i \"Current flowing into the pin\";
 Real f.v \"Voltage drop between the two pins (= p.v - n.v)\";
 Real f.p.v \"Potential at the pin\";
 Real f.p.i \"Current flowing into the pin\";
 Real f.n.v \"Potential at the pin\";
 Real f.n.i \"Current flowing into the pin\";
equation
 cv.v = cv.V;
 cv.v = cv.p.v - ( cv.n.v );
 0 = cv.p.i + cv.n.i;
 cv.i = cv.p.i;
 g.p.v = 0;
 ( r.R ) * ( r.i ) = r.v;
 r.v = r.p.v - ( r.n.v );
 0 = r.p.i + r.n.i;
 r.i = r.p.i;
 ( f.r.R ) * ( f.r.i ) = f.r.v;
 f.r.v = f.r.p.v - ( f.r.n.v );
 0 = f.r.p.i + f.r.n.i;
 f.r.i = f.r.p.i;
 f.c.i = ( f.c.C ) * ( f.c.der(v) );
 f.c.v = f.c.p.v - ( f.c.n.v );
 0 = f.c.p.i + f.c.n.i;
 f.c.i = f.c.p.i;
 f.v = f.p.v - ( f.n.v );
 cv.p.i + f.p.i + r.p.i = 0;
 cv.p.v = f.p.v;
 f.p.v = r.p.v;
 cv.n.i + f.n.i + g.p.i + r.n.i = 0;
 cv.n.v = f.n.v;
 f.n.v = g.p.v;
 g.p.v = r.n.v;
 f.c.p.i - ( f.p.i ) + f.r.p.i = 0;
 f.c.p.v = f.p.v;
 f.p.v = f.r.p.v;
 f.c.n.i - ( f.n.i ) + f.r.n.i = 0;
 f.c.n.v = f.n.v;
 f.n.v = f.r.n.v;

end ConnectTests.CircuitTest2;
")})));
  end CircuitTest2;

model ConnectorTest
   model A
 
     RealInput u
      annotation (Placement(transformation(extent={{-120,-20},{-80,20}})));
     RealOutput y
      annotation (Placement(transformation(extent={{100,-10},{120,10}})));
     parameter Real k = 1;
   equation 
     y = k*u;
   end A;
 
   model B
		FirstOrder firstOrder
		  annotation (Placement(transformation(extent={{30,12},{50,32}})));
    Feedback feedback
      annotation (Placement(transformation(extent={{-46,12},{-26,32}})));
    annotation (Diagram(coordinateSystem(preserveAspectRatio=true, extent={{
              -100,-100},{100,100}}), graphics));
    RealInput u
      annotation (Placement(transformation(extent={{-120,-20},{-80,20}})));
   equation 
    connect(feedback.y, firstOrder.u) annotation (Line(
        points={{-27,22},{28,22}},
        color={0,0,127},
        smooth=Smooth.None));
    connect(firstOrder.y, feedback.u2) annotation (Line(
        points={{51,22},{74,22},{74,-22},{-36,-22},{-36,14}},
        color={0,0,127},
        smooth=Smooth.None));
    connect(feedback.u1, u) annotation (Line(
        points={{-44,22},{-66,22},{-66,0},{-100,0}},
        color={0,0,127},
        smooth=Smooth.None));
   end B;


   
	  block FirstOrder "First order transfer function block (= 1 pole)"
	   parameter Real k=1 "Gain";
	   parameter Modelica.SIunits.Time T(start=1)=1 "Time Constant";
	   parameter Real y_start=0 "Initial or guess value of output (= state)";
	
	   extends SISO(y(start=y_start));
	
	 initial equation 
		 y = y_start;
	 equation 
	   der(y) = (k*u - y)/T;
	 end FirstOrder;
	
	connector RealInput =  input Real "'input Real' as connector";
	
   connector RealOutput = output Real "'output Real' as connector";
	
   block Feedback 
	 "Output difference between commanded and feedback input"
	
	 input RealInput u1;
	 input RealInput u2;
	 output RealOutput y;
	
   equation 
	 y = u1 - u2;
   end Feedback;
	
	partial block SISO 
	 "Single Input Single Output continuous control block"
	 extends BlockIcon;
	
	 RealInput u "Connector of Real input signal";
	 RealOutput y "Connector of Real output signal";
   end SISO;
	
   partial block BlockIcon 
	 "Basic graphical layout of input/output block"
	
	
   equation
	
   end BlockIcon;
	
   block Constant 
	 "Generate constant signal of type Real"
	 parameter Real k(start=1) "Constant output value";
	 extends SO;
	
   equation 
	 y = k;
   end Constant;
	
   partial block SO 
	 "Single Output continuous control block"
	 extends BlockIcon;
	
	 RealOutput y "Connector of Real output signal";
	
   end SO;
    model C
    B b annotation (Placement(transformation(extent={{28,6},{48,26}})));
    Constant const(k=1)
      annotation (Placement(transformation(extent={{-60,8},{-40,28}})));
    annotation (Diagram(coordinateSystem(preserveAspectRatio=false, extent={{
              -100,-100},{100,100}}), graphics));
  equation 
    connect(const.y, b.u) annotation (Line(
        points={{-39,18},{-6,18},{-6,16},{28,16}},
        color={0,0,127},
        smooth=Smooth.None));
  end C;
  
  C c;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="ConnectorTest",
			description="Test of generation of connection equations",
			flatModel="
fclass ConnectTests.ConnectorTest
 parameter Real c.b.firstOrder.k = 1 \"Gain\" /* 1 */;
 parameter Modelica.SIunits.Time c.b.firstOrder.T(start = 1) = 1 \"Time Constant\" /* 1 */;
 parameter Real c.b.firstOrder.y_start = 0 \"Initial or guess value of output (= state)\" /* 0 */;
 ConnectTests.ConnectorTest.RealInput c.b.firstOrder.u \"Connector of Real input signal\";
 ConnectTests.ConnectorTest.RealOutput c.b.firstOrder.y(start = c.b.firstOrder.y_start) \"Connector of Real output signal\";
 ConnectTests.ConnectorTest.RealInput c.b.feedback.u1;
 ConnectTests.ConnectorTest.RealInput c.b.feedback.u2;
 ConnectTests.ConnectorTest.RealOutput c.b.feedback.y;
 ConnectTests.ConnectorTest.RealInput c.b.u;
 parameter Real c.const.k(start = 1) = 1 \"Constant output value\" /* 1 */;
 ConnectTests.ConnectorTest.RealOutput c.const.y \"Connector of Real output signal\";
initial equation 
 c.b.firstOrder.y = c.b.firstOrder.y_start;
equation
 c.b.firstOrder.der(y) = ( ( c.b.firstOrder.k ) * ( c.b.firstOrder.u ) - ( c.b.firstOrder.y ) ) / ( c.b.firstOrder.T );
 c.b.feedback.y = c.b.feedback.u1 - ( c.b.feedback.u2 );
 c.const.y = c.const.k;
 c.b.u = c.const.y;
 c.b.feedback.y = c.b.firstOrder.u;
 c.b.feedback.u2 = c.b.firstOrder.y;
 c.b.feedback.u1 = c.b.u;

public
 type Modelica.SIunits.Time = Real(final quantity = \"Time\",final unit = \"s\");
 type ConnectTests.ConnectorTest.RealInput = Real;
 type ConnectTests.ConnectorTest.RealOutput = Real;
end ConnectTests.ConnectorTest;
")})));
end ConnectorTest;

model CauerLowPassAnalog
extends Modelica.Electrical.Analog.Examples.CauerLowPassAnalog(R1(R=1),R2(R=1),V(V=0));


	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="CauerLowPassAnalog",
			description="Test of generation of connection equations",
			flatModel="
fclass ConnectTests.CauerLowPassAnalog
 parameter Modelica.SIunits.Inductance l1 = 1.304 \"filter coefficient I1\" /* 1.304 */;
 parameter Modelica.SIunits.Inductance l2 = 0.8586 \"filter coefficient I2\" /* 0.8586 */;
 parameter Modelica.SIunits.Capacitance c1 = 1.072 \"filter coefficient c1\" /* 1.072 */;
 parameter Modelica.SIunits.Capacitance c2 = ( 1 ) / ( ( 1.704992 ^ 2 ) * ( l1 ) ) \"filter coefficient c2\";
 parameter Modelica.SIunits.Capacitance c3 = 1.682 \"filter coefficient c3\" /* 1.682 */;
 parameter Modelica.SIunits.Capacitance c4 = ( 1 ) / ( ( 1.179945 ^ 2 ) * ( l2 ) ) \"filter coefficient c4\";
 parameter Modelica.SIunits.Capacitance c5 = 0.7262 \"filter coefficient c5\" /* 0.7262 */;
 Modelica.SIunits.Voltage G.p.v \"Potential at the pin\";
 Modelica.SIunits.Current G.p.i \"Current flowing into the pin\";
 parameter Modelica.SIunits.Capacitance C1.C(start = 1) = c1 \"Capacitance\";
 Modelica.SIunits.Voltage C1.v \"Voltage drop between the two pins (= p.v - n.v)\";
 Modelica.SIunits.Current C1.i \"Current flowing from pin p to pin n\";
 Modelica.SIunits.Voltage C1.p.v \"Potential at the pin\";
 Modelica.SIunits.Current C1.p.i \"Current flowing into the pin\";
 Modelica.SIunits.Voltage C1.n.v \"Potential at the pin\";
 Modelica.SIunits.Current C1.n.i \"Current flowing into the pin\";
 parameter Modelica.SIunits.Capacitance C2.C(start = 1) = c2 \"Capacitance\";
 Modelica.SIunits.Voltage C2.v \"Voltage drop between the two pins (= p.v - n.v)\";
 Modelica.SIunits.Current C2.i \"Current flowing from pin p to pin n\";
 Modelica.SIunits.Voltage C2.p.v \"Potential at the pin\";
 Modelica.SIunits.Current C2.p.i \"Current flowing into the pin\";
 Modelica.SIunits.Voltage C2.n.v \"Potential at the pin\";
 Modelica.SIunits.Current C2.n.i \"Current flowing into the pin\";
 parameter Modelica.SIunits.Capacitance C3.C(start = 1) = c3 \"Capacitance\";
 Modelica.SIunits.Voltage C3.v \"Voltage drop between the two pins (= p.v - n.v)\";
 Modelica.SIunits.Current C3.i \"Current flowing from pin p to pin n\";
 Modelica.SIunits.Voltage C3.p.v \"Potential at the pin\";
 Modelica.SIunits.Current C3.p.i \"Current flowing into the pin\";
 Modelica.SIunits.Voltage C3.n.v \"Potential at the pin\";
 Modelica.SIunits.Current C3.n.i \"Current flowing into the pin\";
 parameter Modelica.SIunits.Capacitance C4.C(start = 1) = c4 \"Capacitance\";
 Modelica.SIunits.Voltage C4.v \"Voltage drop between the two pins (= p.v - n.v)\";
 Modelica.SIunits.Current C4.i \"Current flowing from pin p to pin n\";
 Modelica.SIunits.Voltage C4.p.v \"Potential at the pin\";
 Modelica.SIunits.Current C4.p.i \"Current flowing into the pin\";
 Modelica.SIunits.Voltage C4.n.v \"Potential at the pin\";
 Modelica.SIunits.Current C4.n.i \"Current flowing into the pin\";
 parameter Modelica.SIunits.Capacitance C5.C(start = 1) = c5 \"Capacitance\";
 Modelica.SIunits.Voltage C5.v \"Voltage drop between the two pins (= p.v - n.v)\";
 Modelica.SIunits.Current C5.i \"Current flowing from pin p to pin n\";
 Modelica.SIunits.Voltage C5.p.v \"Potential at the pin\";
 Modelica.SIunits.Current C5.p.i \"Current flowing into the pin\";
 Modelica.SIunits.Voltage C5.n.v \"Potential at the pin\";
 Modelica.SIunits.Current C5.n.i \"Current flowing into the pin\";
 parameter Modelica.SIunits.Inductance L1.L(start = 1) = l1 \"Inductance\";
 Modelica.SIunits.Voltage L1.v \"Voltage drop between the two pins (= p.v - n.v)\";
 Modelica.SIunits.Current L1.i \"Current flowing from pin p to pin n\";
 Modelica.SIunits.Voltage L1.p.v \"Potential at the pin\";
 Modelica.SIunits.Current L1.p.i \"Current flowing into the pin\";
 Modelica.SIunits.Voltage L1.n.v \"Potential at the pin\";
 Modelica.SIunits.Current L1.n.i \"Current flowing into the pin\";
 parameter Modelica.SIunits.Inductance L2.L(start = 1) = l2 \"Inductance\";
 Modelica.SIunits.Voltage L2.v \"Voltage drop between the two pins (= p.v - n.v)\";
 Modelica.SIunits.Current L2.i \"Current flowing from pin p to pin n\";
 Modelica.SIunits.Voltage L2.p.v \"Potential at the pin\";
 Modelica.SIunits.Current L2.p.i \"Current flowing into the pin\";
 Modelica.SIunits.Voltage L2.n.v \"Potential at the pin\";
 Modelica.SIunits.Current L2.n.i \"Current flowing into the pin\";
 parameter Modelica.SIunits.Resistance R1.R(start = 1) = 1 \"Resistance at temperature T_ref\" /* 1 */;
 parameter Modelica.SIunits.Temperature R1.T_ref = 300.15 \"Reference temperature\" /* 300.15 */;
 parameter Modelica.SIunits.LinearTemperatureCoefficient R1.alpha = 0 \"Temperature coefficient of resistance (R_actual = R*(1 + alpha*(T_heatPort - T_ref))\" /* 0 */;
 Modelica.SIunits.Resistance R1.R_actual \"Actual resistance = R*(1 + alpha*(T_heatPort - T_ref))\";
 Modelica.SIunits.Voltage R1.v \"Voltage drop between the two pins (= p.v - n.v)\";
 Modelica.SIunits.Current R1.i \"Current flowing from pin p to pin n\";
 Modelica.SIunits.Voltage R1.p.v \"Potential at the pin\";
 Modelica.SIunits.Current R1.p.i \"Current flowing into the pin\";
 Modelica.SIunits.Voltage R1.n.v \"Potential at the pin\";
 Modelica.SIunits.Current R1.n.i \"Current flowing into the pin\";
 parameter Boolean R1.useHeatPort = false \"=true, if HeatPort is enabled\" /* false */;
 parameter Modelica.SIunits.Temperature R1.T = R1.T_ref \"Fixed device temperature if useHeatPort = false\";
 Modelica.SIunits.Power R1.LossPower \"Loss power leaving component via HeatPort\";
 Modelica.SIunits.Temperature R1.T_heatPort \"Temperature of HeatPort\";
 parameter Modelica.SIunits.Resistance R2.R(start = 1) = 1 \"Resistance at temperature T_ref\" /* 1 */;
 parameter Modelica.SIunits.Temperature R2.T_ref = 300.15 \"Reference temperature\" /* 300.15 */;
 parameter Modelica.SIunits.LinearTemperatureCoefficient R2.alpha = 0 \"Temperature coefficient of resistance (R_actual = R*(1 + alpha*(T_heatPort - T_ref))\" /* 0 */;
 Modelica.SIunits.Resistance R2.R_actual \"Actual resistance = R*(1 + alpha*(T_heatPort - T_ref))\";
 Modelica.SIunits.Voltage R2.v \"Voltage drop between the two pins (= p.v - n.v)\";
 Modelica.SIunits.Current R2.i \"Current flowing from pin p to pin n\";
 Modelica.SIunits.Voltage R2.p.v \"Potential at the pin\";
 Modelica.SIunits.Current R2.p.i \"Current flowing into the pin\";
 Modelica.SIunits.Voltage R2.n.v \"Potential at the pin\";
 Modelica.SIunits.Current R2.n.i \"Current flowing into the pin\";
 parameter Boolean R2.useHeatPort = false \"=true, if HeatPort is enabled\" /* false */;
 parameter Modelica.SIunits.Temperature R2.T = R2.T_ref \"Fixed device temperature if useHeatPort = false\";
 Modelica.SIunits.Power R2.LossPower \"Loss power leaving component via HeatPort\";
 Modelica.SIunits.Temperature R2.T_heatPort \"Temperature of HeatPort\";
 parameter Modelica.SIunits.Voltage V.V(start = 1) = 0 \"Height of step\" /* 0 */;
 parameter Modelica.SIunits.Voltage V.offset = 0 \"Voltage offset\" /* 0 */;
 parameter Modelica.SIunits.Time V.startTime = 1 \"Time offset\" /* 1 */;
 parameter Real V.signalSource.height = V.V \"Height of step\";
 parameter Real V.signalSource.offset = V.offset \"Offset of output signal y\";
 parameter Modelica.SIunits.Time V.signalSource.startTime = V.startTime \"Output y = offset for time < startTime\";
 Modelica.Blocks.Interfaces.RealOutput V.signalSource.y \"Connector of Real output signal\";
 Modelica.SIunits.Voltage V.v \"Voltage drop between the two pins (= p.v - n.v)\";
 Modelica.SIunits.Current V.i \"Current flowing from pin p to pin n\";
 Modelica.SIunits.Voltage V.p.v \"Potential at the pin\";
 Modelica.SIunits.Current V.p.i \"Current flowing into the pin\";
 Modelica.SIunits.Voltage V.n.v \"Potential at the pin\";
 Modelica.SIunits.Current V.n.i \"Current flowing into the pin\";
equation
 G.p.v = 0;
 C1.i = ( C1.C ) * ( C1.der(v) );
 C1.v = C1.p.v - ( C1.n.v );
 0 = C1.p.i + C1.n.i;
 C1.i = C1.p.i;
 C2.i = ( C2.C ) * ( C2.der(v) );
 C2.v = C2.p.v - ( C2.n.v );
 0 = C2.p.i + C2.n.i;
 C2.i = C2.p.i;
 C3.i = ( C3.C ) * ( C3.der(v) );
 C3.v = C3.p.v - ( C3.n.v );
 0 = C3.p.i + C3.n.i;
 C3.i = C3.p.i;
 C4.i = ( C4.C ) * ( C4.der(v) );
 C4.v = C4.p.v - ( C4.n.v );
 0 = C4.p.i + C4.n.i;
 C4.i = C4.p.i;
 C5.i = ( C5.C ) * ( C5.der(v) );
 C5.v = C5.p.v - ( C5.n.v );
 0 = C5.p.i + C5.n.i;
 C5.i = C5.p.i;
 ( L1.L ) * ( L1.der(i) ) = L1.v;
 L1.v = L1.p.v - ( L1.n.v );
 0 = L1.p.i + L1.n.i;
 L1.i = L1.p.i;
 ( L2.L ) * ( L2.der(i) ) = L2.v;
 L2.v = L2.p.v - ( L2.n.v );
 0 = L2.p.i + L2.n.i;
 L2.i = L2.p.i;
 R1.R_actual = ( R1.R ) * ( 1 + ( R1.alpha ) * ( R1.T_heatPort - ( R1.T_ref ) ) );
 R1.v = ( R1.R_actual ) * ( R1.i );
 R1.LossPower = ( R1.v ) * ( R1.i );
 R1.v = R1.p.v - ( R1.n.v );
 0 = R1.p.i + R1.n.i;
 R1.i = R1.p.i;
 if not R1.useHeatPort then
  R1.T_heatPort = R1.T;
 end if;
 R2.R_actual = ( R2.R ) * ( 1 + ( R2.alpha ) * ( R2.T_heatPort - ( R2.T_ref ) ) );
 R2.v = ( R2.R_actual ) * ( R2.i );
 R2.LossPower = ( R2.v ) * ( R2.i );
 R2.v = R2.p.v - ( R2.n.v );
 0 = R2.p.i + R2.n.i;
 R2.i = R2.p.i;
 if not R2.useHeatPort then
  R2.T_heatPort = R2.T;
 end if;
 V.v = V.signalSource.y;
 V.signalSource.y = V.signalSource.offset + (if time < V.signalSource.startTime then 0 else V.signalSource.height);
 V.v = V.p.v - ( V.n.v );
 0 = V.p.i + V.n.i;
 V.i = V.p.i;
 C1.p.i + C2.p.i + L1.p.i + R1.n.i = 0;
 C1.p.v = C2.p.v;
 C2.p.v = L1.p.v;
 L1.p.v = R1.n.v;
 C2.n.i + C3.p.i + C4.p.i + L1.n.i + L2.p.i = 0;
 C2.n.v = C3.p.v;
 C3.p.v = C4.p.v;
 C4.p.v = L1.n.v;
 L1.n.v = L2.p.v;
 C4.n.i + C5.p.i + L2.n.i + R2.p.i = 0;
 C4.n.v = C5.p.v;
 C5.p.v = L2.n.v;
 L2.n.v = R2.p.v;
 R1.p.i + V.p.i = 0;
 R1.p.v = V.p.v;
 C1.n.i + C3.n.i + C5.n.i + G.p.i + R2.n.i + V.n.i = 0;
 C1.n.v = C3.n.v;
 C3.n.v = C5.n.v;
 C5.n.v = G.p.v;
 G.p.v = R2.n.v;
 R2.n.v = V.n.v;

public
 type Modelica.SIunits.Inductance = Real(final quantity = \"Inductance\",final unit = \"H\");
 type Modelica.SIunits.Capacitance = Real(final quantity = \"Capacitance\",final unit = \"F\",min = 0);
 type Modelica.SIunits.Voltage = Real(final quantity = \"ElectricPotential\",final unit = \"V\");
 type Modelica.SIunits.Current = Real(final quantity = \"ElectricCurrent\",final unit = \"A\");
 type Modelica.SIunits.Resistance = Real(final quantity = \"Resistance\",final unit = \"Ohm\");
 type Modelica.SIunits.Temperature = Real(final quantity = \"ThermodynamicTemperature\",final unit = \"K\",min = 0,displayUnit = \"degC\");
 type Modelica.SIunits.LinearTemperatureCoefficient = Real(final quantity = \"LinearTemperatureCoefficient\",final unit = \"1/K\");
 type Modelica.SIunits.Power = Real(final quantity = \"Power\",final unit = \"W\");
 type Modelica.SIunits.Time = Real(final quantity = \"Time\",final unit = \"s\");
 type Modelica.Blocks.Interfaces.RealOutput = Real;
end ConnectTests.CauerLowPassAnalog;
")})));
end CauerLowPassAnalog; 


model StreamTest1
	connector A
		Real a;
		flow Real b;
		stream Real c;
		stream Real d;
	end A;
	
	model B
		A e;
		A f;
	equation
		connect(e,f);
	end B;
	
	B g;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="StreamTest1",
			description="Stream variables: basic test",
			flatModel="
fclass ConnectTests.StreamTest1
 Real g.e.a;
 Real g.e.b;
 Real g.e.c;
 Real g.e.d;
 Real g.f.a;
 Real g.f.b;
 Real g.f.c;
 Real g.f.d;
equation
 g.e.a = g.f.a;
  - ( g.e.b ) - ( g.f.b ) = 0;
 g.e.b = 0;
 g.f.b = 0;

end ConnectTests.StreamTest1;
")})));
end StreamTest1;


model StreamTest2
	connector A
		Real a;
		flow Real b;
		stream Real c;
		stream Real d;
	end A;
	
	model B
		A e;
		A f;
		Real x;
		Real y;

	equation
         	x = inStream(e.c);
	        y = actualStream(e.c);
		connect(e,f);
	end B;
	
	B g;

	annotation(__JModelica(UnitTesting(tests={
		FlatteningTestCase(
			name="StreamTest2",
			description="Basic test of inStream() and actualStream()",
			flatModel="
fclass ConnectTests.StreamTest2
 Real g.e.a;
 Real g.e.b;
 Real g.e.c;
 Real g.e.d;
 Real g.f.a;
 Real g.f.b;
 Real g.f.c;
 Real g.f.d;
 Real g.x;
 Real g.y;
equation
 g.x = inStream(g.e.c);
 g.y = actualStream(g.e.c);
 g.e.a = g.f.a;
  - ( g.e.b ) - ( g.f.b ) = 0;
 g.e.b = 0;
 g.f.b = 0;

end ConnectTests.StreamTest2;
")})));
end StreamTest2;


model StreamTest3
	connector A
		Real a;
		flow Real b;
		stream Real c;
	end A;
	
	A d;
	Real x;
	Real y;
equation
	x = inStream(d.a);
	y = actualStream(d.a);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="StreamTest3",
			description="Using inStream() and actualStream() on normal var in connector",
			errorMessage="
2 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ConnectTests.mo':
Semantic error at line 930, column 6:
  Argument of inStream() must be a stream variable
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ConnectTests.mo':
Semantic error at line 931, column 6:
  Argument of actualStream() must be a stream variable
")})));
end StreamTest3;


model StreamTest4
	connector A
		Real a;
		flow Real b;
		stream Real c;
	end A;
	
	A d;
	Real x;
	Real y;
equation
	x = inStream(d.b);
	y = actualStream(d.b);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="StreamTest4",
			description="Using inStream() and actualStream() on flow var",
			errorMessage="
2 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ConnectTests.mo':
Semantic error at line 960, column 6:
  Argument of inStream() must be a stream variable
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ConnectTests.mo':
Semantic error at line 961, column 6:
  Argument of actualStream() must be a stream variable
")})));
end StreamTest4;


model StreamTest5
	Real a;
	Real x;
	Real y;
equation
	x = inStream(a);
	y = actualStream(a);

	annotation(__JModelica(UnitTesting(tests={
		ErrorTestCase(
			name="StreamTest5",
			description="Using inStream() and actualStream() on normal var not in connector",
			errorMessage="
2 errors found:
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ConnectTests.mo':
Semantic error at line 984, column 6:
  Argument of inStream() must be a stream variable
Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/ConnectTests.mo':
Semantic error at line 985, column 6:
  Argument of actualStream() must be a stream variable
")})));
end StreamTest5;



end ConnectTests;
