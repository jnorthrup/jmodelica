package InnerOuterTests
model InnerOuterTest1
model A 
  outer Real T0;
  Real z = sin(T0);
end A;
model B 
  inner Real T0;
  A a1, a2;	// B.T0, B.a1.T0 and B.a2.T0 is the same variable
equation
  T0 = time;
end B;
B b;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InnerOuterTest1",
			description="Basic test of inner outer.",
			equation_sorting=true,
			flatModel="
fclass InnerOuterTests.InnerOuterTest1
 Real b.T0;
 Real b.a1.z;
 Real b.a2.z;
equation
 b.T0 = time;
 b.a1.z = sin(b.T0);
 b.a2.z = sin(b.T0);

end InnerOuterTests.InnerOuterTest1;
")})));
end InnerOuterTest1;

model InnerOuterTest2
	model A
		outer Real TI = time;
		Real x=TI*2;
		model B
			Real TI=1;
			model C
				Real TI=2;
				model D
					outer Real TI;
					Real x = 3*TI;
				end D;
				D d;
			end C;
			C c;
		end B;
		B b;
	end A;
	model E
		inner Real TI=4*time;
		model F
			inner Real TI=5*time;			
			model G
				Real TI = 5;
				class H
					A a;
				end H;
				H h;
			end G;
			G g;
		end F;
		F f;
	end E;
	model I
		inner Real TI = 2*time;
		E e;
		A a;
	end I;
	I i;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InnerOuterTest2",
			description="Basic test of inner outer.",
			equation_sorting=true,
			flatModel="
fclass InnerOuterTests.InnerOuterTest2
 Real i.TI;
 Real i.e.TI;
 Real i.e.f.TI;
 Real i.e.f.g.TI;
 Real i.e.f.g.h.a.x;
 Real i.e.f.g.h.a.b.TI;
 Real i.e.f.g.h.a.b.c.TI;
 Real i.e.f.g.h.a.b.c.d.x;
 Real i.a.x;
 Real i.a.b.TI;
 Real i.a.b.c.TI;
 Real i.a.b.c.d.x;
equation
 i.TI = 2 * time;
 i.e.TI = 4 * time;
 i.e.f.TI = 5 * time;
 i.e.f.g.TI = 5;
 i.e.f.g.h.a.x = i.e.f.TI * 2;
 i.e.f.g.h.a.b.TI = 1;
 i.e.f.g.h.a.b.c.TI = 2;
 i.e.f.g.h.a.b.c.d.x = 3 * i.e.f.TI;
 i.a.x = i.TI * 2;
 i.a.b.TI = 1;
 i.a.b.c.TI = 2;
 i.a.b.c.d.x = 3 * i.TI;
end InnerOuterTests.InnerOuterTest2;
")})));
end InnerOuterTest2;

model InnerOuterTest3_Err
 model A
   outer Boolean x;
 end A;
 inner Integer x = 3;
 A a;
end InnerOuterTest3_Err;

model InnerOuterTest4
	model A
		Real x;
	end A;
	model B
		outer A a;
		Real x = 2*a.x;
	end B;
	model C
		inner A a(x=sin(time));
		B b;
	end C;
	C c;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InnerOuterTest4",
			description="Basic test of inner outer.",
			equation_sorting=true,
			flatModel="
fclass InnerOuterTests.InnerOuterTest4
 Real c.a.x;
 Real c.b.x;
equation
 c.a.x = sin(time);
 c.b.x = 2 * c.a.x;
end InnerOuterTests.InnerOuterTest4;
")})));
end InnerOuterTest4;

model InnerOuterTest5
model ConditionalIntegrator 
    "Simple differential equation if isEnabled"
outer Boolean isEnabled;
Real x(start=1);
equation 
  der(x)= if isEnabled then -x else 0;
end ConditionalIntegrator;

model SubSystem 
    "subsystem that 'enable' its conditional integrators"
Boolean enableMe = time<=1; // Set inner isEnabled to outer isEnabled and enableMe 
inner outer Boolean isEnabled = isEnabled and enableMe;
ConditionalIntegrator conditionalIntegrator;
ConditionalIntegrator conditionalIntegrator2;
end SubSystem;

model System
             SubSystem subSystem;
  inner Boolean isEnabled = time>=0.5; // subSystem.conditionalIntegrator.isEnabled will be
                                       // 'isEnabled and subSystem.enableMe'
end System;

System sys;


	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InnerOuterTest5",
			description="Basic test of inner outer.",
			equation_sorting=true,
			flatModel="
fclass InnerOuterTests.InnerOuterTest5
 discrete Boolean sys.subSystem.enableMe;
 discrete Boolean sys.subSystem.isEnabled;
 Real sys.subSystem.conditionalIntegrator.x(start = 1);
 Real sys.subSystem.conditionalIntegrator2.x(start = 1);
 discrete Boolean sys.isEnabled;
initial equation 
 sys.subSystem.conditionalIntegrator.x = 1;
 sys.subSystem.conditionalIntegrator2.x = 1;
 sys.subSystem.pre(enableMe) = false;
 sys.subSystem.pre(isEnabled) = false;
 sys.pre(isEnabled) = false;
equation
 sys.subSystem.conditionalIntegrator.der(x) = if sys.subSystem.isEnabled then - sys.subSystem.conditionalIntegrator.x else 0;
 sys.subSystem.conditionalIntegrator2.der(x) = if sys.subSystem.isEnabled then - sys.subSystem.conditionalIntegrator2.x else 0;
 sys.subSystem.enableMe = time <= 1;
 sys.subSystem.isEnabled = sys.isEnabled and sys.subSystem.enableMe;
 sys.isEnabled = time >= 0.5;
end InnerOuterTests.InnerOuterTest5;
")})));
end InnerOuterTest5;

model InnerOuterTest6

function A
input Real u;
output Real y;
/*algorithm
	y := u;*/
end A;

function B
  input Real u;
output Real y;
algorithm 
  y := 3*u;
end B;
// B is a subtype of A
class D
  outer function fc = A;
  Real y;
  Real u = time;
equation 
y = fc(u);
end D;

class C
  inner function fc = B;
   D d; // The equation is now treated as y = B(u)
end C;
	C c;		
end InnerOuterTest6;

model InnerOuterTest7
	model A
		Real x = 4;
	end A;
	model B
		Real x = 6;
		Real y = 9;
	end B;
    model C
		outer model Q = A;	
		Q a;
		Real z = a.x;
	end C;
	model D
	 	inner model Q = B;
		B a; 
		C c;
	end D;
	D d;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InnerOuterTest7",
			description="Basic test of inner outer.",
			equation_sorting=true,
			eliminate_alias_variables=false,
			flatModel="
fclass InnerOuterTests.InnerOuterTest7
 Real d.a.x;
 Real d.a.y;
 Real d.c.a.x;
 Real d.c.a.y;
 Real d.c.z;
equation
 d.a.x = 6;
 d.a.y = 9;
 d.c.a.x = 6;
 d.c.a.y = 9;
 d.c.z = d.c.a.x;
end InnerOuterTests.InnerOuterTest7;
	")})));
end InnerOuterTest7;
	
model InnerOuterTest8
	package P1
    	model A 
	    	Real x = 4;
	    end A;
	end P1;
	package P2
		model A
			Real x = 6;
			Real y = 9;
		end A;
	end P2;
    model C
		outer package P = P1;	
		P.A a;
		Real z = a.x;
	end C;
	model D
	 	inner package P = P2;
		C c;
	end D;
	D d;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InnerOuterTest8",
			description="Basic test of inner outer.",
			equation_sorting=true,
			eliminate_alias_variables=false,
			flatModel="
fclass InnerOuterTests.InnerOuterTest8
 Real d.c.a.x;
 Real d.c.a.y;
 Real d.c.z;
equation
 d.c.a.x = 6;
 d.c.a.y = 9;
 d.c.z = d.c.a.x;
end InnerOuterTests.InnerOuterTest8;	 
	")})));
end InnerOuterTest8;

end InnerOuterTests;
