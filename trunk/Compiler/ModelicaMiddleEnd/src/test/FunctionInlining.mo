/*
    Copyright (C) 2011-2015 Modelon AB

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


package FunctionInlining
    
    model BasicInline1
        function f
            input Real a;
            output Real b;
        algorithm
            b := a;
	        end f;
        
        Real x = f(1);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="BasicInline1",
			description="Most basic inlining case",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.BasicInline1
 Real x;
equation
 x = 1;
end FunctionInlining.BasicInline1;
")})));
    end BasicInline1;
       
	   
    model BasicInline2
        function f
            input Real a;
            output Real b;
        protected
            Real c;
            Real d;
            Real e;
            Real f;
        algorithm
            c := a;
            d := 2 * c + a;
            c := d / 3 + 1;
            e := c ^ d;
            f := e - c - d - c;
            b := f + 1;
        end f;
        
        Real x = f(y - 1);
        constant Real y = 2;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="BasicInline2",
			description="More complicated inlining case with only assignments and constant argument",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.BasicInline2
 Real x;
 constant Real y = 2;
equation
 x = 2.0;
end FunctionInlining.BasicInline2;
")})));
    end BasicInline2;
       
	   
    model BasicInline3
        function f
            input Real a;
            output Real b;
        protected
            Real c;
            Real d;
            Real e;
            Real f;
        algorithm
            c := a;
            d := 2 * c + a;
            c := d / 3 + 1;
            e := c ^ d;
            f := e - c - d - c;
            b := f + 1;
        end f;
        
        Real x = f(y + 1);
        Real y = time;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="BasicInline3",
			description="More complicated inlining case with only assignments and continous argument",
			variability_propagation=false,
			inline_functions="all",
			eliminate_alias_variables=false,
			flatModel="
fclass FunctionInlining.BasicInline3
 Real x;
 Real y;
 Real temp_1;
 Real temp_3;
 Real temp_4;
equation
 x = temp_4 ^ temp_3 - temp_4 - temp_3 - temp_4 + 1;
 y = time;
 temp_1 = y + 1;
 temp_3 = 2 * temp_1 + temp_1;
 temp_4 = temp_3 / 3 + 1;
end FunctionInlining.BasicInline3;
")})));
    end BasicInline3;
       
	   
    model BasicInline4
        function f
            input Real a;
            output Real b;
        protected
            Real c;
            Real d;
            Real e;
            Real f;
        algorithm
            c := a;
            d := c;
            c := d;
            e := c + d;
            f := e;
            b := f;
        end f;
        
        Real x = f(y);
        Real y = time;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="BasicInline4",
			description="Test of alias elimination after inlining",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.BasicInline4
 Real x;
 Real y;
equation
 x = y + y;
 y = time;
end FunctionInlining.BasicInline4;
")})));
    end BasicInline4;
    
	
    model BasicInline6
        function f
            input Real[:] a;
            output Real[size(a,1)] b;
        protected
            Real[size(a,1)] c;
            Real d;
        algorithm
            c := a .+ 2;
            d := a * c;
            b := d * (a + c);
        end f;
        
        Real x[:] = f(y);
        Real y[3] = { 1, 2, 3 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="BasicInline6",
			description="",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.BasicInline6
 Real x[1];
 Real x[2];
 Real x[3];
 Real y[1];
 Real y[2];
 Real y[3];
 Real temp_7;
 Real temp_9;
 Real temp_11;
 Real temp_20;
equation
 x[1] = temp_20 * (y[1] + temp_7);
 x[2] = temp_20 * (y[2] + temp_9);
 x[3] = temp_20 * (y[3] + temp_11);
 y[1] = 1;
 y[2] = 2;
 y[3] = 3;
 temp_7 = y[1] .+ 2;
 temp_9 = y[2] .+ 2;
 temp_11 = y[3] .+ 2;
 temp_20 = y[1] * temp_7 + y[2] * temp_9 + y[3] * temp_11;
end FunctionInlining.BasicInline6;
			
")})));
    end BasicInline6;
    
	
    model BasicInline7
        function f1
            input Real a;
            output Real b;
        protected
            Real c;
        algorithm
            c := a * 2;
            b := (a + c);
        end f1;
        
	    function f2
            input Real a;
            output Real b;
        protected
            Real c;
        algorithm
            c := a * 2;
            b := f1(a) + f1(c);
        end f2;
        
	    Real x = f2(y);
        Real y = 1;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="BasicInline7",
			description="",
			variability_propagation=false,
			inline_functions="all",
			eliminate_alias_variables=false,
			flatModel="
fclass FunctionInlining.BasicInline7
 Real x;
 Real y;
 Real temp_1;
 Real temp_4;
 Real temp_7;
equation
 x = temp_4 + temp_4 * 2 + (temp_7 + temp_7 * 2);
 y = 1;
 temp_1 = y;
 temp_4 = temp_1;
 temp_7 = temp_1 * 2;
end FunctionInlining.BasicInline7;
")})));
    end BasicInline7;
    

    model BasicInline8
        function f1
            input Real[:] a;
            output Real[size(a,1)] b;
        protected
            Real[size(a,1)] c;
            Real d;
        algorithm
            c := a .+ 1;
            d := a * c;
            b := d * (a + c);
        end f1;
        
        function f2
            input Real[:] a;
            output Real[size(a,1)] b;
        protected
            Real[size(a,1)] c;
        algorithm
            c := a * 2;
            b := f1(a) + f1(c);
        end f2;
        
        Real x[:] = f2(y);
        Real y[3] = { 1, 2, 3 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="BasicInline8",
			description="Inlining function with both function calls and arrays",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.BasicInline8
 Real x[1];
 Real x[2];
 Real x[3];
 Real y[1];
 Real y[2];
 Real y[3];
 Real temp_28;
 Real temp_30;
 Real temp_32;
 Real temp_41;
 Real temp_48;
 Real temp_49;
 Real temp_50;
 Real temp_52;
 Real temp_54;
 Real temp_56;
 Real temp_65;
equation
 x[1] = temp_41 * (y[1] + temp_28) + temp_65 * (temp_48 + temp_52);
 x[2] = temp_41 * (y[2] + temp_30) + temp_65 * (temp_49 + temp_54);
 x[3] = temp_41 * (y[3] + temp_32) + temp_65 * (temp_50 + temp_56);
 y[1] = 1;
 y[2] = 2;
 y[3] = 3;
 temp_28 = y[1] .+ 1;
 temp_30 = y[2] .+ 1;
 temp_32 = y[3] .+ 1;
 temp_41 = y[1] * temp_28 + y[2] * temp_30 + y[3] * temp_32;
 temp_48 = y[1] * 2;
 temp_49 = y[2] * 2;
 temp_50 = y[3] * 2;
 temp_52 = temp_48 .+ 1;
 temp_54 = temp_49 .+ 1;
 temp_56 = temp_50 .+ 1;
 temp_65 = temp_48 * temp_52 + temp_49 * temp_54 + temp_50 * temp_56;
end FunctionInlining.BasicInline8;
			
")})));
    end BasicInline8;
    
    
    model BasicInline9
        function f
            input Real a;
            output Real b;
        protected
            Real c;
            Real d;
            Real e;
            Real f;
        algorithm
            c := a;
            d := 2 * c + a;
            c := d / 3 + 1;
            e := c ^ d;
            f := e - c - d - c;
            b := f + 1;
		end f;
		
        parameter Real x = f(y - 1);
        parameter Real y = 2;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="BasicInline9",
			description="",
			variability_propagation=false,
			inline_functions="all",
			eliminate_alias_variables=false,
			flatModel="
fclass FunctionInlining.BasicInline9
 parameter Real temp_1;
 parameter Real y = 2 /* 2 */;
 parameter Real temp_3;
 parameter Real temp_4;
 parameter Real x;
parameter equation
 temp_1 = y - 1;
 temp_3 = 2 * temp_1 + temp_1;
 temp_4 = temp_3 / 3 + 1;
 x = temp_4 ^ temp_3 - temp_4 - temp_3 - temp_4 + 1;
end FunctionInlining.BasicInline9;
")})));
    end BasicInline9;


    model BasicInline10
        function f
            input Real a;
            input Real[:] b;
            input Integer c;
            output Real d;
        algorithm
            d := a * b[c];
            end f;
        
        constant Integer e = 2;
        Real x = f(y, z, e);
        Real y = 2.2;
        Real[:] z = { 1, 2, 3 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="BasicInline10",
			description="Using array indices",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.BasicInline10
 constant Integer e = 2 /* 2 */;
 Real x;
 Real y;
 Real z[1];
 Real z[2];
 Real z[3];
equation
 x = y * z[2];
 y = 2.2;
 z[1] = 1;
 z[2] = 2;
 z[3] = 3;
end FunctionInlining.BasicInline10;
")})));
    end BasicInline10;


    model BasicInline11
        function f
            input Integer a;
            output Integer b;
        algorithm
            b := 4 - a;
            end f;
        
        parameter Integer e = 1;
        Real x = y[f(e)];
        Real[:] y = { 1, 2, 3 };

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="BasicInline11",
			description="Function call as array index",
			variability_propagation=false,
			inline_functions="all",
			eliminate_alias_variables=false,
			flatModel="
fclass FunctionInlining.BasicInline11
 parameter Integer e = 1 /* 1 */;
 Real x;
 Real y[1];
 Real y[2];
 Real y[3];
equation
 x = ({y[1], y[2], y[3]})[4 - e];
 y[1] = 1;
 y[2] = 2;
 y[3] = 3;
end FunctionInlining.BasicInline11;
")})));
    end BasicInline11;


    model BasicInline12
        function f
            input Real a;
            output Real b;
        algorithm
            b := a;
        end f;
        
        Real[2] y = {1,2};
        Real x(start=1);
    equation
        if x > 3 then
            der(x) = f(y[1]);
        else
            der(x) = f(y[2]);
        end if;
    end BasicInline12;


    model BasicInline13
		type E = enumeration(a, b, c);
		
        function next
            input E x;
            output E y;
        algorithm
            y := if x == E.a then E.b else E.c;
        end next;
        
        E p1 = next(E.a);
		E p2 = next(p1);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="BasicInline13",
			description="Inlining of function using enumeration",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.BasicInline13
 discrete FunctionInlining.BasicInline13.E p1;
 discrete FunctionInlining.BasicInline13.E p2;
initial equation 
 pre(p1) = FunctionInlining.BasicInline13.E.a;
 pre(p2) = FunctionInlining.BasicInline13.E.a;
equation
 p1 = FunctionInlining.BasicInline13.E.b;
 p2 = noEvent(if p1 == FunctionInlining.BasicInline13.E.a then FunctionInlining.BasicInline13.E.b else FunctionInlining.BasicInline13.E.c);

public
 type FunctionInlining.BasicInline13.E = enumeration(a, b, c);

end FunctionInlining.BasicInline13;
")})));
    end BasicInline13;
	
	
	model MatrixInline1
		function f
			input Real[2,2] a;
            input Real[2,2] b;
			output Real[2,2] c;
		algorithm
			c := a + b;
		end f;
		
		parameter Real[2,2] p = [1,2; 3,4];
        Real[2,2] x = p .+ time;
        Real[2,2] y = p * time;
		Real[2,2] z = f(x, y);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="MatrixInline1",
			description="Inline function with matrix as input and output",
			inline_functions="all",
			flatModel="
fclass FunctionInlining.MatrixInline1
 parameter Real p[1,1] = 1 /* 1 */;
 parameter Real p[1,2] = 2 /* 2 */;
 parameter Real p[2,1] = 3 /* 3 */;
 parameter Real p[2,2] = 4 /* 4 */;
 Real x[1,1];
 Real x[1,2];
 Real x[2,1];
 Real x[2,2];
 Real y[1,1];
 Real y[1,2];
 Real y[2,1];
 Real y[2,2];
 Real z[1,1];
 Real z[1,2];
 Real z[2,1];
 Real z[2,2];
equation
 x[1,1] = p[1,1] .+ time;
 x[1,2] = p[1,2] .+ time;
 x[2,1] = p[2,1] .+ time;
 x[2,2] = p[2,2] .+ time;
 y[1,1] = p[1,1] * time;
 y[1,2] = p[1,2] * time;
 y[2,1] = p[2,1] * time;
 y[2,2] = p[2,2] * time;
 z[1,1] = x[1,1] + y[1,1];
 z[1,2] = x[1,2] + y[1,2];
 z[2,1] = x[2,1] + y[2,1];
 z[2,2] = x[2,2] + y[2,2];
end FunctionInlining.MatrixInline1;
")})));
	end MatrixInline1;
    
    
    model RecordInline1
        record R
            Real a[3];
            Integer b;
        end R;
        
        function f
            input R c;
            output Real d;
        algorithm
            d := c.b + sum(c.a);
        end f;
        
        Real x = f(R({1,2,3}, 4));

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RecordInline1",
			description="Inlining function taking constant record arg",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.RecordInline1
 Real x;
equation
 x = 10;
end FunctionInlining.RecordInline1;
")})));
    end RecordInline1;
    
    
    model RecordInline2
        record R
            Real a[3];
            Integer b;
        end R;
        
        function f
            input Real c;
            output R d;
        algorithm
            d := R({1,2,3} * c, 2);
        end f;
        
        R x = f(1);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RecordInline2",
			description="Inlining function returning recor, constant args",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.RecordInline2
 Real x.a[1];
 Real x.a[2];
 Real x.a[3];
 discrete Integer x.b;
initial equation 
 pre(x.b) = 0;
equation
 x.a[1] = 1;
 x.a[2] = 2;
 x.a[3] = 3;
 x.b = 2;
end FunctionInlining.RecordInline2;
")})));
    end RecordInline2;
    
    
    model RecordInline3
        record R
            Real a[3];
            Integer b;
        end R;
        
        function f
            input Real c;
            output Real d;
        protected
            R e;
        algorithm
            e := R({1,2,3} * c, 4);
            d := sum(e.a) + c * e.b;
        end f;
        
        Real x = f(1);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RecordInline3",
			description="",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.RecordInline3
 Real x;
equation
 x = 10;
end FunctionInlining.RecordInline3;
")})));
    end RecordInline3;
    
    
    model RecordInline4
        record R
            Real a[3];
            Integer b;
        end R;
        
        function f
            input R c;
            output Real d;
        algorithm
            d := c.b + sum(c.a);
        end f;
        
		Real y[4] = {1,2,3,4};
        Real x = f(R(y[1:3], integer(y[4])));

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RecordInline4",
			description="",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.RecordInline4
 Real y[1];
 Real y[2];
 Real y[3];
 Real y[4];
 Real x;
 discrete Integer temp_1;
initial equation 
 pre(temp_1) = 0;
equation
 y[1] = 1;
 y[2] = 2;
 y[3] = 3;
 y[4] = 4;
 x = temp_1 + (y[1] + y[2] + y[3]);
 temp_1 = if y[4] < pre(temp_1) or y[4] >= pre(temp_1) + 1 or initial() then integer(y[4]) else pre(temp_1);
end FunctionInlining.RecordInline4;
			
")})));
    end RecordInline4;
    
    
    model RecordInline5
        record R
            Real a[3];
            Integer b;
        end R;
        
        function f
            input Real c;
            output R d;
        algorithm
            d := R({1,2,3} * c, 2);
        end f;
        
		Real y = 1;
        R x = f(y);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RecordInline5",
			description="",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.RecordInline5
 Real y;
 Real x.a[2];
 Real x.a[3];
 discrete Integer x.b;
initial equation 
 pre(x.b) = 0;
equation
 y = 1;
 x.a[2] = 2 * y;
 x.a[3] = 3 * y;
 x.b = 2;
end FunctionInlining.RecordInline5;
")})));
    end RecordInline5;
    
    
    model RecordInline6
        record R
            Real a[3];
            Integer b;
        end R;
        
        function f
            input Real c;
            output Real d;
        protected
            R e;
        algorithm
            e := R({1,2,3} * c, 4);
            d := sum(e.a) + c * e.b;
        end f;
        
        Real y = 1;
        Real x = f(y);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RecordInline6",
			description="",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.RecordInline6
 Real y;
 Real x;
equation
 y = 1;
 x = y + 2 * y + 3 * y + y * 4;
end FunctionInlining.RecordInline6;
")})));
    end RecordInline6;
    
    
    model RecordInline7
        record R
            Real a[3];
            Integer b;
        end R;
        
        function f
            input R c;
            output R d;
        protected
            R e;
            R g;
            R h;
        algorithm
			e := c;
			g := R(e.a + c.a, e.b - c.b);
			h := R(c.a * e.a * g.a, 3);
			d := R(h.a - c.a, h.b + g.b);
        end f;
        
        Real y[4] = {1,2,3,4};
        R x = f(R(y[1:3], integer(y[4])));

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RecordInline7",
			description="",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.RecordInline7
 Real y[1];
 Real y[2];
 Real y[3];
 Real y[4];
 Real x.a[1];
 Real x.a[2];
 Real x.a[3];
 discrete Integer x.b;
 discrete Integer temp_2;
initial equation 
 pre(temp_2) = 0;
 pre(x.b) = 0;
equation
 y[1] = 1;
 y[2] = 2;
 y[3] = 3;
 y[4] = 4;
 x.a[1] = (y[1] * y[1] + y[2] * y[2] + y[3] * y[3]) * (y[1] + y[1]) - y[1];
 x.a[2] = (y[1] * y[1] + y[2] * y[2] + y[3] * y[3]) * (y[2] + y[2]) - y[2];
 x.a[3] = (y[1] * y[1] + y[2] * y[2] + y[3] * y[3]) * (y[3] + y[3]) - y[3];
 x.b = 3 + (temp_2 - temp_2);
 temp_2 = if y[4] < pre(temp_2) or y[4] >= pre(temp_2) + 1 or initial() then integer(y[4]) else pre(temp_2);
end FunctionInlining.RecordInline7;
			
")})));
    end RecordInline7;
    
    
    model RecordInline8
        record R
            Real a[3];
            Integer b;
        end R;
        
        function f
            input Real c;
            output R d;
        algorithm
            d.a[1] := 2 / c;
            d.a[2] := 3 + c;
            d.a[3] := 4 * c;
            d.b := integer(5 - c);
        end f;
        
        Real y = 1;
        R x = f(y);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RecordInline8",
			description="",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.RecordInline8
 Real y;
 Real x.a[1];
 Real x.a[2];
 Real x.a[3];
 discrete Integer x.b;
initial equation 
 pre(x.b) = 0;
equation
 y = 1;
 x.a[1] = 2 / y;
 x.a[2] = 3 + y;
 x.a[3] = 4 * y;
 x.b = noEvent(integer(5 - y));
end FunctionInlining.RecordInline8;
")})));
    end RecordInline8;
    
    
    model RecordInline9
        record R
            Real a[3];
            Integer b;
        end R;
        
        function f
            input Real c;
            output R d;
        algorithm
            d.a[1] := 2 / c;
            d.a[2] := 3 + c;
            d.a[3] := 4 * c;
            d.b := integer(5 - c);
        end f;
        
        R x = f(1);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RecordInline9",
			description="",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.RecordInline9
 Real x.a[1];
 Real x.a[2];
 Real x.a[3];
 discrete Integer x.b;
initial equation 
 pre(x.b) = 0;
equation
 x.a[1] = 2.0;
 x.a[2] = 4;
 x.a[3] = 4;
 x.b = 4;
end FunctionInlining.RecordInline9;
")})));
    end RecordInline9;
    
    
    model RecordInline10
        record R
            Real a[3];
            Integer b;
        end R;
        
        function f1
            input Real c;
            output Real d;
        protected
            R e;
        algorithm
            e.a := { 1, 2, 3 } * c;
            e.b := integer(5 - c);
            d := f2(e);
        end f1;
        
        function f2
            input R f;
            output Real g;
        algorithm
            g := sum(f.a) + f.b;
        end f2;
        
        Real x = f1(y);
        Real y = 1;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RecordInline10",
			description="",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.RecordInline10
 Real x;
 Real y;
equation
 x = y + 2 * y + 3 * y + noEvent(integer(5 - y));
 y = 1;
end FunctionInlining.RecordInline10;
")})));
    end RecordInline10;
    
    
    model RecordInline11
        record R
            Real a[3];
            Integer b;
        end R;
        
        function f1
            input Real f;
            output Real g;
        protected
            R e;
        algorithm
			e := f2(f);
            g := sum(e.a) + e.b;
	    end f1;
        
        function f2
            input Real c;
            output R d;
        algorithm
            d.a := { 1, 2, 3 } * c;
            d.b := integer(5 - c);
        end f2;
        
        Real x = f1(y);
        Real y = 1;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="RecordInline11",
			description="",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.RecordInline11
 Real x;
 Real y;
equation
 x = y + 2 * y + 3 * y + noEvent(integer(5 - y));
 y = 1;
end FunctionInlining.RecordInline11;
")})));
    end RecordInline11;
	

	class O
		extends ExternalObject;
        function constructor
        	output O o;
        	external "C";
        end constructor;
        function destructor
        	input O o;
            external "C";
        end destructor;
	end O;
	
	model ExternalInline1		
		function f
			input O o;
			input Real y;
			output Real x;
			external "C";
		end f;
		
		function g
			input Real y;
			input O o;
			output Real x;
		algorithm
			x := y + f(o, y);
		end g;
		
		O o1 = O();
		Real x = g(time, o1);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ExternalInline1",
			description="Inlining function with external object",
			inline_functions="all",
			flatModel="
fclass FunctionInlining.ExternalInline1
 parameter FunctionInlining.O o1 = FunctionInlining.O.constructor() /* (unknown value) */;
 Real x;
 Real temp_1;
equation
 x = temp_1 + FunctionInlining.ExternalInline1.f(o1, temp_1);
 temp_1 = time;

public
 function FunctionInlining.O.destructor
  input FunctionInlining.O o;
 algorithm
  external \"C\" destructor(o);
  return;
 end FunctionInlining.O.destructor;

 function FunctionInlining.O.constructor
  output FunctionInlining.O o;
 algorithm
  external \"C\" o = constructor();
  return;
 end FunctionInlining.O.constructor;

 function FunctionInlining.ExternalInline1.f
  input FunctionInlining.O o;
  input Real y;
  output Real x;
 algorithm
  external \"C\" x = f(o, y);
  return;
 end FunctionInlining.ExternalInline1.f;

 type FunctionInlining.O = ExternalObject;
end FunctionInlining.ExternalInline1;
")})));
	end ExternalInline1;
	
	model ExternalInline2
		function f
			input O o;
			input Real y;
			output Real x;
			external "C";
		end f;
		
		function g
			input Real y;
			input O os[:];
			output Real x;
		algorithm
			x := y + f(os[1], y);
		end g;
		
		O myOs[2] = { O(), O() };
		Real x = g(time, myOs);
		
	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ExternalInline2",
			description="Test that function with array of external objects as input should not be inlined",
			flatModel="
fclass FunctionInlining.ExternalInline2
 parameter FunctionInlining.O myOs[1] = FunctionInlining.O.constructor() /* (unknown value) */;
 parameter FunctionInlining.O myOs[2] = FunctionInlining.O.constructor() /* (unknown value) */;
 Real x;
equation
 x = FunctionInlining.ExternalInline2.g(time, {myOs[1], myOs[2]});

public
 function FunctionInlining.O.destructor
  input FunctionInlining.O o;
 algorithm
  external \"C\" destructor(o);
  return;
 end FunctionInlining.O.destructor;

 function FunctionInlining.O.constructor
  output FunctionInlining.O o;
 algorithm
  external \"C\" o = constructor();
  return;
 end FunctionInlining.O.constructor;

 function FunctionInlining.ExternalInline2.g
  input Real y;
  input FunctionInlining.O[:] os;
  output Real x;
 algorithm
  x := y + FunctionInlining.ExternalInline2.f(os[1], y);
  return;
 end FunctionInlining.ExternalInline2.g;

 function FunctionInlining.ExternalInline2.f
  input FunctionInlining.O o;
  input Real y;
  output Real x;
 algorithm
  external \"C\" x = f(o, y);
  return;
 end FunctionInlining.ExternalInline2.f;

 type FunctionInlining.O = ExternalObject;
end FunctionInlining.ExternalInline2;
")})));
	end ExternalInline2;

    model UninlinableFunction1
        function f1
            input Real x1;
            input Real x2;
            output Real y = f4(x1);
        algorithm
            while y < x2 loop
                y := y + f3(x1, x2);
            end while;
        end f1;
        
        function f2
            input Real x;
            output Real y = x;
        algorithm
        end f2;
        
        function f3
            input Real x1;
            input Real x2;
            output Real y;
        algorithm
            y := 0;
            while y < x2 loop
                y := y + x1;
            end while;
        end f3;
        
        function f4
            input Real x;
            output Real y = x;
        algorithm
        end f4;
        
        Real z[3] = 1:size(z,1);
        Real w[2];
    equation
        w[1] = f1(z[2], z[3]);
        w[2] = f2(z[1]);

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="UninlinableFunction1",
            description="Make sure that only unused functions are removed",
            variability_propagation=false,
            inline_functions="all",
            eliminate_alias_variables=false,
            flatModel="
fclass FunctionInlining.UninlinableFunction1
 Real z[1];
 Real z[2];
 Real z[3];
 Real w[1];
 Real w[2];
equation
 w[1] = FunctionInlining.UninlinableFunction1.f1(z[2], z[3]);
 w[2] = z[1];
 z[1] = 1;
 z[2] = 2;
 z[3] = 3;

public
 function FunctionInlining.UninlinableFunction1.f1
  input Real x1;
  input Real x2;
  output Real y;
 algorithm
  y := FunctionInlining.UninlinableFunction1.f4(x1);
  while y < x2 loop
   y := y + FunctionInlining.UninlinableFunction1.f3(x1, x2);
  end while;
  return;
 end FunctionInlining.UninlinableFunction1.f1;

 function FunctionInlining.UninlinableFunction1.f4
  input Real x;
  output Real y;
 algorithm
  y := x;
  return;
 end FunctionInlining.UninlinableFunction1.f4;

  function FunctionInlining.UninlinableFunction1.f3
  input Real x1;
  input Real x2;
  output Real y;
 algorithm
  y := 0;
  while y < x2 loop
   y := y + x1;
  end while;
  return;
 end FunctionInlining.UninlinableFunction1.f3;

end FunctionInlining.UninlinableFunction1;
")})));
    end UninlinableFunction1;
    
    
    model IfStatementInline1
        function f
            input Real x;
            output Real y;
        protected
            Real w1;
            Real w2;
        algorithm
            w1 := 1;
            w2 := 2;
            if x > 2 then
                w1 := x;
            end if;
            y := w1 + w2;
        end f;
        
        Real z1 = f(3);
        Real z2 = f(1);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IfStatementInline1",
			description="",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.IfStatementInline1
 Real z1;
 Real z2;
equation
 z1 = 5;
 z2 = 3;

end FunctionInlining.IfStatementInline1;
")})));
    end IfStatementInline1;
    
    
    model IfStatementInline2
        function f
            input Real x;
            output Real y;
        protected
            Real w1;
            Real w2;
        algorithm
            w1 := 1;
            w2 := 2;
            if x > 2 then
                w1 := x;
            end if;
            y := w1 + w2;
        end f;
        
        Real v = 2;
        Real z = f(v);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IfStatementInline2",
			description="",
			variability_propagation=false,
			inline_functions="all",
			eliminate_alias_variables=false,
			flatModel="
fclass FunctionInlining.IfStatementInline2
 Real v;
 Real z;
 Real temp_1;
equation
 v = 2;
 z = noEvent(if temp_1 > 2 then temp_1 else 1) + 2;
 temp_1 = v;
end FunctionInlining.IfStatementInline2;
")})));
    end IfStatementInline2;
    
    
    model IfStatementInline3
        function f
            input Real x1;
            input Real x2;
            input Real x3;
            output Real y;
        protected
            Real w1;
            Real w2;
        algorithm
            w1 := x2;
            w2 := x3;
            if x1 > 2 then
                w1 := x1;
            else
                w2 := x1;
            end if;
            y := w1 + w2;
        end f;
        
        Real v1 = 1;
        Real v2 = 2;
        Real v3 = 3;
        Real z = f(v1, v2, v3);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IfStatementInline3",
			description="",
			variability_propagation=false,
			inline_functions="all",
			eliminate_alias_variables=false,
			flatModel="
fclass FunctionInlining.IfStatementInline3
 Real v1;
 Real v2;
 Real v3;
 Real z;
 Real temp_1;
equation
 v1 = 1;
 v2 = 2;
 v3 = 3;
 z = noEvent(if temp_1 > 2 then temp_1 else v2) + noEvent(if temp_1 > 2 then v3 else temp_1);
 temp_1 = v1;
end FunctionInlining.IfStatementInline3;
")})));
    end IfStatementInline3;
    
    
    model IfStatementInline4
        function f
            input Real x;
            output Real y;
        algorithm
            if x > 2 then
                y := x;
            else
                y := x + 1;
            end if;
        end f;
        
        Real v = 1;
        Real z = f(v);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IfStatementInline4",
			description="",
			variability_propagation=false,
			inline_functions="all",
			eliminate_alias_variables=false,
			flatModel="
fclass FunctionInlining.IfStatementInline4
 Real v;
 Real z;
 Real temp_1;
equation
 v = 1;
 z = noEvent(if temp_1 > 2 then noEvent(if temp_1 > 2 then temp_1 else 0.0) else temp_1 + 1);
 temp_1 = v;
end FunctionInlining.IfStatementInline4;
")})));
    end IfStatementInline4;
	
	
	model IfStatementInline5
        function f
			input Boolean test;
            input Real x;
            output Real y;
        algorithm
            y := x + 1;
	        if test then
                y := x;
            end if;
        end f;
        
		Real v = time + 1;
        Real z = f(time > 3, v);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IfStatementInline5",
			description="Event-generating argument to inlined function",
			inline_functions="all",
			flatModel="
fclass FunctionInlining.IfStatementInline5
 Real v;
 Real z;
 discrete Boolean temp_1;
initial equation 
 pre(temp_1) = false;
equation
 v = time + 1;
 z = noEvent(if temp_1 then v else v + 1);
 temp_1 = time > 3;
end FunctionInlining.IfStatementInline5;
")})));
	end IfStatementInline5;
    
    
    model IfStatementInline6
        function f
            input Real x;
            output Real y;
        algorithm
            if x > 2 then
                y := x;
            else
                y := 1;
            end if;
        end f;

        Real z = f(if time > 3 then time else 3);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IfStatementInline6",
			description="Event-generating argument to inlined function",
			inline_functions="all",
			flatModel="
fclass FunctionInlining.IfStatementInline6
 Real z;
 Real temp_1;
equation
 z = noEvent(if temp_1 > 2 then noEvent(if temp_1 > 2 then temp_1 else 0.0) else 1);
 temp_1 = if time > 3 then time else 3;
end FunctionInlining.IfStatementInline6;
")})));
    end IfStatementInline6;
    
    
    model ForStatementInline1
        function f
            input Real x;
            output Real y;
        algorithm
            y := 0;
            for w in linspace(1, x, 4) loop
                y := y + w * w;
            end for;
        end f;
        
        Real v = 3;
        Real z = f(v);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ForStatementInline1",
			description="",
			variability_propagation=false,
			inline_functions="all",
			eliminate_alias_variables=false,
			flatModel="
fclass FunctionInlining.ForStatementInline1
 Real v;
 Real z;
 Real temp_1;
 Real temp_5;
 Real temp_7;
 Real temp_9;
equation
 v = 3;
 z = 1 + temp_5 * temp_5 + temp_7 * temp_7 + temp_9 * temp_9;
 temp_1 = v;
 temp_5 = 1 + (temp_1 - 1) / 3;
 temp_7 = 1 + 2 * ((temp_1 - 1) / 3);
 temp_9 = 1 + 3 * ((temp_1 - 1) / 3);
end FunctionInlining.ForStatementInline1;
")})));
    end ForStatementInline1;
    
    
    model ForStatementInline2
        function f
            input Real x;
            output Real y;
        algorithm
            y := 0;
            for w in linspace(1, x, 4) loop
                y := y + w * w;
            end for;
        end f;
        
        Real z = f(3);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ForStatementInline2",
			description="",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.ForStatementInline2
 Real z;
equation
 z = 18.22222222222222;

end FunctionInlining.ForStatementInline2;
")})));
    end ForStatementInline2;
    
    
    model ForStatementInline3
        function f
            input Real[:] x;
            output Real y;
        algorithm
            y := 0;
            for w in x loop
                y := y + w * w;
            end for;
        end f;
        
        Real v[3] = {1,2,3};
        Real z = f(v);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ForStatementInline3",
			description="",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.ForStatementInline3
 Real v[1];
 Real v[2];
 Real v[3];
 Real z;
equation
 v[1] = 1;
 v[2] = 2;
 v[3] = 3;
 z = v[1] * v[1] + v[2] * v[2] + v[3] * v[3];
end FunctionInlining.ForStatementInline3;
")})));
    end ForStatementInline3;
    
    
    model ForStatementInline4
        function f
            input Real[:] x;
            output Real y;
        algorithm
            y := 0;
            for w in x loop
                y := y + w * w;
            end for;
        end f;
        
        Real z = f({1,2,3});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ForStatementInline4",
			description="",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.ForStatementInline4
 Real z;
equation
 z = 14;

end FunctionInlining.ForStatementInline4;
")})));
    end ForStatementInline4;


    model ForStatementInline5
        function f
            input Real[:] x;
            output Real y;
        algorithm
            y := 0;
            for w in x loop
                if w > 2 then
                    y := y + w * w;
                else
                    y := y + w;
                end if;
            end for;
        end f;
        
        Real v[3] = {1,2,3};
        Real z = f(v);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ForStatementInline5",
			description="",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.ForStatementInline5
 Real v[1];
 Real v[2];
 Real v[3];
 Real z;
 Real temp_6;
 Real temp_7;
 Real temp_9;
 Real temp_10;
 Real temp_12;
equation
 v[1] = 1;
 v[2] = 2;
 v[3] = 3;
 z = noEvent(if v[3] > 2 then temp_12 else temp_12 + v[3]);
 temp_6 = noEvent(if v[1] > 2 then v[1] * v[1] else 0);
 temp_7 = noEvent(if v[1] > 2 then temp_6 else temp_6 + v[1]);
 temp_9 = noEvent(if v[2] > 2 then temp_7 + v[2] * v[2] else temp_7);
 temp_10 = noEvent(if v[2] > 2 then temp_9 else temp_9 + v[2]);
 temp_12 = noEvent(if v[3] > 2 then temp_10 + v[3] * v[3] else temp_10);
end FunctionInlining.ForStatementInline5;
")})));
    end ForStatementInline5;


    model ForStatementInline6
        function f
            input Real[:] x;
            output Real y;
        algorithm
            y := 0;
            for w in x loop
                if w > 2 then
                    y := y + w * w;
                else
                    y := y + w;
                end if;
            end for;
        end f;
        
        Real z = f({1,2,3});

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ForStatementInline6",
			description="",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.ForStatementInline6
 Real z;
equation
 z = 12;

end FunctionInlining.ForStatementInline6;
")})));
    end ForStatementInline6;


    model ForStatementInline7
        function f
            input Real[:] x;
            output Real y;
		protected
			Real t;
        algorithm
			t := x * x;
            y := 0;
            for w in 1:4 loop
                if w > 2 then
                    y := y + w * t;
                else
                    y := y + t;
                end if;
            end for;
        end f;
        
        Real v[3] = {1,2,3};
        Real z = f(v);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ForStatementInline7",
			description="",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.ForStatementInline7
 Real v[1];
 Real v[2];
 Real v[3];
 Real z;
 Real temp_14;
equation
 v[1] = 1;
 v[2] = 2;
 v[3] = 3;
 z = temp_14 + temp_14 + 3 * temp_14 + 4 * temp_14;
 temp_14 = v[1] * v[1] + v[2] * v[2] + v[3] * v[3];
end FunctionInlining.ForStatementInline7;
			
")})));
    end ForStatementInline7;


    model ForStatementInline8
        function f
            input Real[:] x;
            output Real y;
        algorithm
            y := 0;
            for w in x loop
                for t in x loop
                    y := y + w * t;
                end for;
            end for;
        end f;
        
        Real v[3] = {1,2,3};
        Real z = f(v);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="ForStatementInline8",
			description="",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.ForStatementInline8
 Real v[1];
 Real v[2];
 Real v[3];
 Real z;
equation
 v[1] = 1;
 v[2] = 2;
 v[3] = 3;
 z = v[1] * v[1] + v[1] * v[2] + v[1] * v[3] + v[2] * v[1] + v[2] * v[2] + v[2] * v[3] + v[3] * v[1] + v[3] * v[2] + v[3] * v[3];
end FunctionInlining.ForStatementInline8;
")})));
    end ForStatementInline8;
	
    
    
    model MultipleOutputsInline1
        function f
            input Real a;
            input Real b;
            output Real c;
            output Real d;
        algorithm
            c := a + 1;
            d := c + b;
        end f;
        
        Real x[8];
    equation
        (x[1], x[2]) = f(1, 2 * 2);
        (x[3], x[4]) = f(2, x[2]);
        (x[5], x[6]) = f(x[3], 3);
        (x[7], x[8]) = f(x[5], x[6]);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="MultipleOutputsInline1",
			description="Inlining function call using multiple outputs",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.MultipleOutputsInline1
 Real x[1];
 Real x[2];
 Real x[3];
 Real x[4];
 Real x[5];
 Real x[6];
 Real x[7];
 Real x[8];
equation
 x[1] = 2;
 x[2] = 6;
 x[3] = 3;
 x[4] = 3 + x[2];
 x[6] = x[5] + 3;
 x[8] = x[7] + x[6];
 x[5] = x[3] + 1;
 x[7] = x[5] + 1;
end FunctionInlining.MultipleOutputsInline1;
")})));
    end MultipleOutputsInline1;
    
    
    model MultipleOutputsInline2
        function f
            input Real a;
            input Real b;
            output Real c;
            output Real d;
            output Real e;
        algorithm
            c := a + b;
            d := a - b;
            e := a * b;
        end f;
        
        Real x[6];
		Real y[6] = ones(6);
    equation
        (x[1], , x[2]) = f(y[1], y[2]);
        (x[3], x[4])   = f(y[3], y[4]);
        (, x[5], x[6]) = f(y[5], y[6]);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="MultipleOutputsInline2",
			description="Inlining function call using multiple (but not all) outputs",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.MultipleOutputsInline2
 Real x[1];
 Real x[2];
 Real x[3];
 Real x[4];
 Real x[5];
 Real x[6];
 Real y[1];
 Real y[2];
 Real y[3];
 Real y[4];
 Real y[5];
 Real y[6];
equation
 x[1] = y[1] + y[2];
 x[2] = y[1] * y[2];
 x[3] = y[3] + y[4];
 x[4] = y[3] - y[4];
 x[5] = y[5] - y[6];
 x[6] = y[5] * y[6];
 y[1] = 1;
 y[2] = 1;
 y[3] = 1;
 y[4] = 1;
 y[5] = 1;
 y[6] = 1;
end FunctionInlining.MultipleOutputsInline2;
")})));
    end MultipleOutputsInline2;


    model MultipleOutputsInline3
        function f1
            input Real a;
            input Real b;
            output Real c;
            output Real d;
            output Real e;
        algorithm
            c := a + b;
            d := a - b;
            e := a * b;
        end f1;
		
		function f2
            input Real y1;
            input Real y2;
            output Real x1;
	        output Real x2;
            output Real x3;
	    algorithm
	        (x1, x2, x3) := f1(y1, y2);
		end f2;
        
        Real x[6];
        Real y[6] = ones(6);
    equation
        (x[1], , x[2]) = f2(y[1], y[2]);
        (x[3], x[4])   = f2(y[3], y[4]);
        (, x[5], x[6]) = f2(y[5], y[6]);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="MultipleOutputsInline3",
			description="Inlining function call using multiple (but not all) outputs",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.MultipleOutputsInline3
 Real x[1];
 Real x[2];
 Real x[3];
 Real x[4];
 Real x[5];
 Real x[6];
 Real y[1];
 Real y[2];
 Real y[3];
 Real y[4];
 Real y[5];
 Real y[6];
equation
 x[1] = y[1] + y[2];
 x[2] = y[1] * y[2];
 x[3] = y[3] + y[4];
 x[4] = y[3] - y[4];
 x[5] = y[5] - y[6];
 x[6] = y[5] * y[6];
 y[1] = 1;
 y[2] = 1;
 y[3] = 1;
 y[4] = 1;
 y[5] = 1;
 y[6] = 1;
end FunctionInlining.MultipleOutputsInline3;
")})));
    end MultipleOutputsInline3;
    
model MultipleOutputsInline4
    type E = enumeration(E1);
    record R
        Real x;
        String  v1;
        Integer v2;
        Boolean v3;
        E v4;
    end R;
    function f3
        input Real x;
        output R o;
        String  v1 = "string";
        Integer v2 = 2;
        Boolean v3 = true;
        E v4 = E.E1;
      algorithm
        o := R(x,v1,v2,v3,v4);
    end f3;
    function f2
        input R r;
        output Real o;
      algorithm
        o := r.x;
    end f2;
    function f1
        input Real x;
        output Real y;
        R r;
      algorithm
        r := f3(x);
        y := f2(r);
        annotation (Inline=true);
    end f1;
    Real x,y;
  equation
    y = f1(x);
    x = 1;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="MultipleOutputsInline4",
            description="Inline function function call stmt with unused discrete return values",
            variability_propagation=false,
            flatModel="
fclass FunctionInlining.MultipleOutputsInline4
 Real x;
 Real y;
equation
 x = 1;
 (FunctionInlining.MultipleOutputsInline4.R(y, , , , )) = FunctionInlining.MultipleOutputsInline4.f3(x);

public
 function FunctionInlining.MultipleOutputsInline4.f3
  input Real x;
  output FunctionInlining.MultipleOutputsInline4.R o;
  String v1;
  Integer v2;
  Boolean v3;
  FunctionInlining.MultipleOutputsInline4.E v4;
 algorithm
  v1 := \"string\";
  v2 := 2;
  v3 := true;
  v4 := FunctionInlining.MultipleOutputsInline4.E.E1;
  o.x := x;
  o.v1 := v1;
  o.v2 := v2;
  o.v3 := v3;
  o.v4 := v4;
  return;
 end FunctionInlining.MultipleOutputsInline4.f3;

 record FunctionInlining.MultipleOutputsInline4.R
  Real x;
  discrete String v1;
  discrete Integer v2;
  discrete Boolean v3;
  discrete FunctionInlining.MultipleOutputsInline4.E v4;
 end FunctionInlining.MultipleOutputsInline4.R;

 type FunctionInlining.MultipleOutputsInline4.E = enumeration(E1);

end FunctionInlining.MultipleOutputsInline4;
")})));
end MultipleOutputsInline4;
    
    
    model IfEquationInline1
        function f
            input Real a;
            output Real b;
        algorithm
            b := a;
        end f;
        
        Real x = 1;
        Real y;
    equation
        if (time > 1) then
            y = f(x);
        else
            y = 0;
        end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IfEquationInline1",
			description="Test inlining of function calls in if equations",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.IfEquationInline1
 Real x;
 Real y;
equation
 y = if time > 1 then x else 0;
 x = 1;
end FunctionInlining.IfEquationInline1;
")})));
    end IfEquationInline1;
    
    
    model IfEquationInline2
        function f
            input Real a;
            output Real b;
        algorithm
            b := a;
        end f;
        
		parameter Boolean b = true;
        Real x = 1;
        Real y;
    equation
        if (b) then
            y = f(x);
        end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IfEquationInline2",
			description="Test inlining of function calls in if equations",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.IfEquationInline2
 structural parameter Boolean b = true /* true */;
 Real y;
equation
 y = 1;

end FunctionInlining.IfEquationInline2;
")})));
    end IfEquationInline2;
    
    
    model IfEquationInline3
        function f
            input Real a;
            output Real b;
        algorithm
            b := a;
        end f;
        
        parameter Boolean b = false;
        Real x = 1;
        Real y;
    equation
        if (b) then
            y = f(x);
        end if;
		if (not b) then
			y = 0;
		end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IfEquationInline3",
			description="Test inlining of function calls in if equations",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.IfEquationInline3
 structural parameter Boolean b = false /* false */;
 Real x;
 Real y;
equation
 y = 0;
 x = 1;

end FunctionInlining.IfEquationInline3;
")})));
    end IfEquationInline3;
    
    
    model IfEquationInline4
        function f
            input Real a;
            output Real b;
        algorithm
            b := a;
        end f;
        
        Real x1 = 1;
        Real x2 = 2;
        Real y;
    equation
        if (time > 1) then
            y = f(x1);
        else
            y = f(x2);
        end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IfEquationInline4",
			description="Test inlining of function calls in if equations",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.IfEquationInline4
 Real x1;
 Real x2;
 Real y;
equation
 y = if time > 1 then x1 else x2;
 x1 = 1;
 x2 = 2;
end FunctionInlining.IfEquationInline4;
")})));
    end IfEquationInline4;
    
    
    model IfEquationInline5
        function f
            input Real a;
            output Real b;
        algorithm
            b := a;
        end f;
        
        constant Boolean b = true;
        Real x1 = 1;
        Real x2 = 2;
        Real y;
    equation
        if (b) then
            y = f(x1);
        else
            y = f(x2);
        end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IfEquationInline5",
			description="Test inlining of function calls in if equations",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.IfEquationInline5
 constant Boolean b = true;
 Real x2;
 Real y;
equation
 y = 1;
 x2 = 2;

end FunctionInlining.IfEquationInline5;
")})));
    end IfEquationInline5;
    
    
    model IfEquationInline6
        function f
            input Real a;
            output Real b;
        algorithm
            b := a;
        end f;
        
        constant Boolean b = false;
        Real x1 = 1;
        Real x2 = 2;
        Real y;
    equation
        if (b) then
            y = f(x1);
        else
            y = f(x2);
        end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IfEquationInline6",
			description="Test inlining of function calls in if equations",
			variability_propagation=false,
			inline_functions="all",
			flatModel="
fclass FunctionInlining.IfEquationInline6
 constant Boolean b = false;
 Real x1;
 Real y;
equation
 x1 = 1;
 y = 2;

end FunctionInlining.IfEquationInline6;
")})));
    end IfEquationInline6;


model IfEquationInline7
    record R
        Real p;
    end R;
    
    function f1
        input Real p;
        output R r;
    algorithm
        r := R(p);
    end f1;
    
    function f2
        input R r;
        output Real x;
    algorithm
        x := r.p;
    end f2;
    
    Real x;
    Real y;
equation
    if time > 0 then
        x = 4;
        y = 2;
    else
        x = f2(f1(time));
        time = y + 1;
    end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="IfEquationInline7",
			description="Check that temporary equations are removed properly within if equations",
			inline_functions="trivial",
			flatModel="
fclass FunctionInlining.IfEquationInline7
 Real x;
 Real y;
equation
 x = if time > 0 then 4 else time;
 0.0 = if time > 0 then y - 2 else time - (y + 1);
end FunctionInlining.IfEquationInline7;
")})));
end IfEquationInline7;
    
model WhenEquationInline1
    function F
        input Real x;
        output Real y1;
        output Real y2;
    algorithm
        y1 := 1 + x;
        y2 := 2 + x;
    end F;
    Real x,y;
equation
    when sample(0,1) then
        (x,y) = F(time);
    end when;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="WhenEquationInline1",
			description="Check variability of argument moved out of when equation",
			inline_functions="trivial",
			flatModel="
fclass FunctionInlining.WhenEquationInline1
 discrete Real x;
 discrete Real y;
 discrete Boolean temp_1;
initial equation 
 pre(x) = 0.0;
 pre(y) = 0.0;
 pre(temp_1) = false;
equation
 temp_1 = sample(0, 1);
 if temp_1 and not pre(temp_1) then
  (x, y) = FunctionInlining.WhenEquationInline1.F(time);
 else
  x = pre(x);
  y = pre(y);
 end if;

public
 function FunctionInlining.WhenEquationInline1.F
  input Real x;
  output Real y1;
  output Real y2;
 algorithm
  y1 := 1 + x;
  y2 := 2 + x;
  return;
 end FunctionInlining.WhenEquationInline1.F;

end FunctionInlining.WhenEquationInline1;
			
")})));
end WhenEquationInline1;
	
	

    
    model TrivialInline1
        function f
            input Real a;
            input Real b;
            output Real c;
            output Real d;
        algorithm
            c := a + b;
            d := a * b;
        end f;
        
        Real x;
        Real y;
        Real z = 1;
    equation
        if z > 2 then
            x = 3;
            y = 4;
        else
            (x, y) = f(z, 3);
        end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="TrivialInline1",
			description="Test inlining of trivial functions - 2 outputs",
			variability_propagation=false,
			inline_functions="trivial",
			flatModel="
fclass FunctionInlining.TrivialInline1
 Real x;
 Real y;
 Real z;
equation
 x = if z > 2 then 3 else z + 3;
 y = if z > 2 then 4 else z * 3;
 z = 1;
end FunctionInlining.TrivialInline1;
")})));
    end TrivialInline1;
    
    
    model TrivialInline2
        function f
            input Real a;
            input Real b;
            output Real c[2];
            output Real d;
        algorithm
            c := {a + b, a-b};
            d := a * b;
        end f;
        
        Real x[2];
        Real z = 1;
    equation
        if z > 2 then
            x[1] = 3;
            x[2] = 4;
        else
            x = f(z, 3);
        end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="TrivialInline2",
			description="Test inlining of trivial functions - 2 outputs, one used",
			variability_propagation=false,
			inline_functions="trivial",
			flatModel="
fclass FunctionInlining.TrivialInline2
 Real x[1];
 Real x[2];
 Real z;
 Real temp_1[1];
 Real temp_1[2];
equation
 temp_1[1] = if z > 2 then 0.0 else z + 3;
 temp_1[2] = if z > 2 then 0.0 else z - 3;
 x[1] = if z > 2 then 3 else temp_1[1];
 x[2] = if z > 2 then 4 else temp_1[2];
 z = 1;
end FunctionInlining.TrivialInline2;
")})));
    end TrivialInline2;
    
    
    model TrivialInline3
        record R
            Real a;
            Real b;
        end R;
        
        function f
            input Real c;
            input Real d;
            output R e;
        algorithm
            e := R(c + d, c * d);
        end f;
        
        R x;
        Real z = 1;
    equation
        if z > 2 then
            x = R(3, 4);
        else
            x = f(z, 3);
        end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="TrivialInline3",
			description="Test inlining of trivial functions - record output, record constructor",
			variability_propagation=false,
			inline_functions="trivial",
			flatModel="
fclass FunctionInlining.TrivialInline3
 Real x.a;
 Real x.b;
 Real z;
 Real temp_1.a;
 Real temp_1.b;
equation
 temp_1.a = if z > 2 then 0.0 else z + 3;
 temp_1.b = if z > 2 then 0.0 else z * 3;
 x.a = if z > 2 then 3 else temp_1.a;
 x.b = if z > 2 then 4 else temp_1.b;
 z = 1;
end FunctionInlining.TrivialInline3;
")})));
    end TrivialInline3;
    
    
    model TrivialInline4
        record R
            Real a;
            Real b;
        end R;
        
        function f
            input Real c;
            input Real d;
            output R e;
        algorithm
            e.a := c + d;
			e.b := c * d;
        end f;
        
        R x;
        Real z = 1;
    equation
        if z > 2 then
            x = R(3, 4);
        else
            x = f(z, 3);
        end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="TrivialInline4",
			description="Test inlining of trivial functions - record constructor, separate assignments",
			variability_propagation=false,
			inline_functions="trivial",
			flatModel="
fclass FunctionInlining.TrivialInline4
 Real x.a;
 Real x.b;
 Real z;
 Real temp_1.a;
 Real temp_1.b;
equation
 temp_1.a = if z > 2 then 0.0 else z + 3;
 temp_1.b = if z > 2 then 0.0 else z * 3;
 x.a = if z > 2 then 3 else temp_1.a;
 x.b = if z > 2 then 4 else temp_1.b;
 z = 1;
end FunctionInlining.TrivialInline4;
")})));
    end TrivialInline4;
    
    
    model TrivialInline5
        function f
            input Real a[:];
            input Real b;
            output Real c[size(a,1)];
        algorithm
            c := a * b;
        end f;
        
        Real x[3];
        Real z[3] = {1, 2, 3};
    equation
        if z[1] > 2 then
            x = z[end:-1:1];
        else
            x = f(z, 3);
        end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="TrivialInline5",
			description="Test inlining of trivial functions - array, unknown size",
			variability_propagation=false,
			inline_functions="trivial",
			flatModel="
fclass FunctionInlining.TrivialInline5
 Real x[1];
 Real x[2];
 Real x[3];
 Real z[1];
 Real z[2];
 Real z[3];
 Real temp_1[1];
 Real temp_1[2];
 Real temp_1[3];
equation
 temp_1[1] = if z[1] > 2 then 0.0 else z[1] * 3;
 temp_1[2] = if z[1] > 2 then 0.0 else z[2] * 3;
 temp_1[3] = if z[1] > 2 then 0.0 else z[3] * 3;
 x[1] = if z[1] > 2 then z[3] else temp_1[1];
 x[2] = if z[1] > 2 then z[2] else temp_1[2];
 x[3] = if z[1] > 2 then z[1] else temp_1[3];
 z[1] = 1;
 z[2] = 2;
 z[3] = 3;
end FunctionInlining.TrivialInline5;
")})));
    end TrivialInline5;
    
    
    model TrivialInline6
        function f1
            input Real a;
            output Real b;
        algorithm
            b := f2(a * 2) * 2;
        end f1;
        
        function f2
            input Real c;
            output Real d;
        algorithm
            d := c + 1;
        end f2;
        
        Real x;
        Real z = 1;
    equation
        if z > 2 then
            x = 2;
        else
            x = f1(z);
        end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="TrivialInline6",
			description="Test inlining of trivial functions - function calling function",
			variability_propagation=false,
			inline_functions="trivial",
			flatModel="
fclass FunctionInlining.TrivialInline6
 Real x;
 Real z;
equation
 x = if z > 2 then 2 else (z * 2 + 1) * 2;
 z = 1;
end FunctionInlining.TrivialInline6;
")})));
    end TrivialInline6;
    
    
    model TrivialInline7
        function f1
            input Real a;
            output Real b;
            output Real c;
        algorithm
            (b, c) := f2(a);
        end f1;
        
        function f2
            input Real d;
            output Real e;
            output Real f;
        algorithm
            e := d + 1;
			f := d * 2;
        end f2;
        
        Real x;
        Real y;
        Real z = 1;
    equation
        if z > 2 then
            x = 2;
			y = 3;
        else
            (x, y) = f1(z);
        end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="TrivialInline7",
			description="Test inlining of trivial functions - function calling function, 2 outputs",
			variability_propagation=false,
			inline_functions="trivial",
			flatModel="
fclass FunctionInlining.TrivialInline7
 Real x;
 Real y;
 Real z;
equation
 x = if z > 2 then 2 else z + 1;
 y = if z > 2 then 3 else z * 2;
 z = 1;
end FunctionInlining.TrivialInline7;
")})));
    end TrivialInline7;
    
    
    model TrivialInline8
        function f
            input Real a[3];
            input Real b;
            output Real c[size(a,1)];
        algorithm
            c := a * b;
        end f;
        
        Real x[3];
        Real z[3] = {1, 2, 3};
    equation
        if z[1] > 2 then
            x = z[end:-1:1];
        else
            x = f(z, 3);
        end if;

    annotation(__JModelica(UnitTesting(tests={ 
        TransformCanonicalTestCase(
            name="TrivialInline8",
            description="Test inlining of trivial functions - array, known size",
			variability_propagation=false,
            inline_functions="trivial",
            flatModel="
fclass FunctionInlining.TrivialInline8
 Real x[1];
 Real x[2];
 Real x[3];
 Real z[1];
 Real z[2];
 Real z[3];
 Real temp_1[1];
 Real temp_1[2];
 Real temp_1[3];
equation
 temp_1[1] = if z[1] > 2 then 0.0 else z[1] * 3;
 temp_1[2] = if z[1] > 2 then 0.0 else z[2] * 3;
 temp_1[3] = if z[1] > 2 then 0.0 else z[3] * 3;
 x[1] = if z[1] > 2 then z[3] else temp_1[1];
 x[2] = if z[1] > 2 then z[2] else temp_1[2];
 x[3] = if z[1] > 2 then z[1] else temp_1[3];
 z[1] = 1;
 z[2] = 2;
 z[3] = 3;
end FunctionInlining.TrivialInline8;
")})));
    end TrivialInline8;
    
    
    model TrivialInline9
        function f
            input Real a;
            input Real b;
            output Real c;
        algorithm
            c := a * b;
			c := c + 2;
        end f;
        
        Real x;
        Real z = 1;
    equation
        if z > 2 then
            x = z;
        else
            x = f(z, 3);
        end if;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="TrivialInline9",
			description="Test inlining of trivial functions - non-trivial function",
			variability_propagation=false,
			inline_functions="trivial",
			flatModel="
fclass FunctionInlining.TrivialInline9
 Real x;
 Real z;
equation
 x = if z > 2 then z else FunctionInlining.TrivialInline9.f(z, 3);
 z = 1;

public
 function FunctionInlining.TrivialInline9.f
  input Real a;
  input Real b;
  output Real c;
 algorithm
  c := a * b;
  c := c + 2;
  return;
 end FunctionInlining.TrivialInline9.f;

end FunctionInlining.TrivialInline9;
")})));
    end TrivialInline9;


model TrivialInline10
    record R
        Real a;
        Real b[2];      
    end R;
    
    function f
        input Real c;
        output R d;
    algorithm
        d := R(c, {1,2});
    end f;
    
    R x = f(1);

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="TrivialInline10",
            description="Test that assigning an entire record at once works in trivial inlining mode",
            variability_propagation=false,
			inline_functions="trivial",
            flatModel="
fclass FunctionInlining.TrivialInline10
 Real x.a;
 Real x.b[1];
 Real x.b[2];
equation
 x.a = 1;
 x.b[1] = 1;
 x.b[2] = 2;
end FunctionInlining.TrivialInline10;
")})));
end TrivialInline10;


model InlineAnnotation1
	function f
		input Real a;
		output Real b;
	algorithm
		b := a * a;
		b := b - a;
	annotation(Inline=true);
	end f;
	
	Real x = f(time);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InlineAnnotation1",
			description="Inline annotation",
			inline_functions="trivial",
			variability_propagation=false,
			flatModel="
fclass FunctionInlining.InlineAnnotation1
 Real x;
 Real temp_1;
equation
 x = temp_1 * temp_1 - temp_1;
 temp_1 = time;
end FunctionInlining.InlineAnnotation1;
")})));
end InlineAnnotation1;


model InlineAnnotation2
    function f
        input Real a;
        output Real b;
    algorithm
        b := a * a;
		while b > a loop
            b := b - a;
		end while;
    annotation(Inline=true);
    end f;
    
    Real x = f(time);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InlineAnnotation2",
			description="Inline annotation on function that can't be inlined'",
			inline_functions="trivial",
			variability_propagation=false,
			flatModel="
fclass FunctionInlining.InlineAnnotation2
 Real x;
equation
 x = FunctionInlining.InlineAnnotation2.f(time);

public
 function FunctionInlining.InlineAnnotation2.f
  input Real a;
  output Real b;
 algorithm
  b := a * a;
  while b > a loop
   b := b - a;
  end while;
  return;
 annotation(Inline = true);
 end FunctionInlining.InlineAnnotation2.f;

end FunctionInlining.InlineAnnotation2;
")})));
end InlineAnnotation2;


model InlineAnnotation3
    function f
        input Real a;
        output Real b;
    algorithm
        b := a * a;
        b := b - a;
    annotation(LateInline=true);
    end f;
    
    Real x = f(time);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InlineAnnotation3",
			description="LateInline annotation",
			inline_functions="trivial",
			variability_propagation=false,
			flatModel="
fclass FunctionInlining.InlineAnnotation3
 Real x;
 Real temp_1;
equation
 x = temp_1 * temp_1 - temp_1;
 temp_1 = time;
end FunctionInlining.InlineAnnotation3;
")})));
end InlineAnnotation3;


model InlineAnnotation4
    function f
        input Real a;
        output Real b;
    algorithm
        b := a * a;
        b := b - a;
    annotation(InlineAfterIndexReduction=true);
    end f;
    
    Real x = f(time);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InlineAnnotation4",
			description="InlineAfterIndexReduction annotation",
			inline_functions="trivial",
			variability_propagation=false,
			flatModel="
fclass FunctionInlining.InlineAnnotation4
 Real x;
 Real temp_1;
equation
 x = temp_1 * temp_1 - temp_1;
 temp_1 = time;
end FunctionInlining.InlineAnnotation4;
")})));
end InlineAnnotation4;


model InlineAnnotation5
    function f
        input Real a;
        output Real b;
    algorithm
        b := a * a;
    annotation(Inline=false);
    end f;
    
    Real x = f(time);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InlineAnnotation5",
			description="Inline annotation set to false on function we would normally inline",
			inline_functions="trivial",
			variability_propagation=false,
			flatModel="
fclass FunctionInlining.InlineAnnotation5
 Real x;
equation
 x = FunctionInlining.InlineAnnotation5.f(time);

public
 function FunctionInlining.InlineAnnotation5.f
  input Real a;
  output Real b;
 algorithm
  b := a * a;
  return;
 annotation(Inline = false);
 end FunctionInlining.InlineAnnotation5.f;

end FunctionInlining.InlineAnnotation5;
")})));
end InlineAnnotation5;


model InlineAnnotation6
    function f
        input Real a;
        output Real b;
    algorithm
        b := a * a;
    annotation(LateInline=false);
    end f;
    
    Real x = f(time);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InlineAnnotation6",
			description="LateInline annotation set to false on function we would normally inline",
			inline_functions="trivial",
			variability_propagation=false,
			flatModel="
fclass FunctionInlining.InlineAnnotation6
 Real x;
equation
 x = FunctionInlining.InlineAnnotation6.f(time);

public
 function FunctionInlining.InlineAnnotation6.f
  input Real a;
  output Real b;
 algorithm
  b := a * a;
  return;
 annotation(LateInline = false);
 end FunctionInlining.InlineAnnotation6.f;

end FunctionInlining.InlineAnnotation6;
")})));
end InlineAnnotation6;


model InlineAnnotation7
    function f
        input Real a;
        output Real b;
    algorithm
        b := a * a;
    annotation(InlineAfterIndexReduction=false);
    end f;
    
    Real x = f(time);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="InlineAnnotation7",
			description="InlineAfterIndexReduction annotation set to false on function we would normally inline",
			inline_functions="trivial",
			variability_propagation=false,
			flatModel="
fclass FunctionInlining.InlineAnnotation7
 Real x;
equation
 x = FunctionInlining.InlineAnnotation7.f(time);

public
 function FunctionInlining.InlineAnnotation7.f
  input Real a;
  output Real b;
 algorithm
  b := a * a;
  return;
 annotation(InlineAfterIndexReduction = false);
 end FunctionInlining.InlineAnnotation7.f;

end FunctionInlining.InlineAnnotation7;
")})));
end InlineAnnotation7;


model InlineAnnotation8
    function f
        input Real a;
        output Real b;
    algorithm
        b := f2(a);
        annotation(LateInline=true, derivative=fd);
    end f;
    
    function fd
        input Real a;
        input Real ad;
        output Real b;
    algorithm
        b := a * ad;
    end fd;
    
    function f2
        input Real a;
        output Real b;
    algorithm
        b := a + 1;
        b := b * a;
    end f2;
    
    Real x = f(y);
    Real y;
    Real z = der(y);
equation
    der(x) = time;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="InlineAnnotation8",
            description="Check that functions with LateInline=true is inlined after index reduction",
            flatModel="
fclass FunctionInlining.InlineAnnotation8
 Real x;
 Real y;
 Real z;
 Real _der_x;
initial equation 
 y = 0.0;
equation
 _der_x = time;
 x = FunctionInlining.InlineAnnotation8.f2(y);
 z = der(y);
 _der_x = y * der(y);

public
 function FunctionInlining.InlineAnnotation8.f2
  input Real a;
  output Real b;
 algorithm
  b := a + 1;
  b := b * a;
  return;
 end FunctionInlining.InlineAnnotation8.f2;

end FunctionInlining.InlineAnnotation8;
")})));
end InlineAnnotation8;


/*model InlineAnnotation9
    function f
        input Real a;
        output Real b;
    algorithm
        b := f2(a);
        annotation(InlineAfterIndexReduction=true, derivative=fd);
    end f;
    
    function fd
        input Real a;
        input Real ad;
        output Real b;
    algorithm
        b := a * ad;
    end fd;
    
    function f2
        input Real a;
        output Real b;
    algorithm
        b := a + 1;
        b := b * a;
    end f2;
    
    Real x = f(y);
    Real y;
    Real z = der(y);
equation
    der(x) = time;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="InlineAnnotation9",
            description="Check that functions with InlineAfterIndexReduction=true is inlined after index reduction",
            flatModel="
fclass FunctionInlining.InlineAnnotation9
 Real x;
 Real y;
 Real z;
 Real _der_x;
initial equation 
 y = 0.0;
equation
 _der_x = time;
 x = FunctionInlining.InlineAnnotation9.f2(y);
 z = der(y);
 _der_x = y * der(y);

public
 function FunctionInlining.InlineAnnotation9.f2
  input Real a;
  output Real b;
 algorithm
  b := a + 1;
  b := b * a;
  return;
 end FunctionInlining.InlineAnnotation9.f2;

end FunctionInlining.InlineAnnotation9;
")})));
end InlineAnnotation9;*/

model InlineAnnotation10
    function f
        input Real a;
        output Real b;
        Integer c;
    algorithm
        (b,c) := f2(a);
        annotation(LateInline=true, derivative=fd);
    end f;
    
    function fd
        input Real a;
        input Real ad;
        output Real b;
    algorithm
        b := a * ad;
    end fd;
    
    function f2
        input Real a;
        output Real b;
        output Integer c;
    algorithm
        b := a + 1;
        b := b * a;
        c := 3;
    end f2;
    
    Real x = f(y);
    Real y;
    Real z = der(y);
    Integer t = integer(time);
equation
    der(x) = time;

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="InlineAnnotation10",
            description="Check that functions with LateInline=true and results in discrete temp work",
            flatModel="
fclass FunctionInlining.InlineAnnotation10
 Real x;
 Real y;
 Real z;
 discrete Integer t;
 Real _der_x;
initial equation 
 pre(t) = 0;
 y = 0.0;
equation
 _der_x = time;
 z = der(y);
 t = if time < pre(t) or time >= pre(t) + 1 or initial() then integer(time) else pre(t);
 _der_x = y * der(y);
 (x, ) = FunctionInlining.InlineAnnotation10.f2(y);

public
 function FunctionInlining.InlineAnnotation10.f2
  input Real a;
  output Real b;
  output Integer c;
 algorithm
  b := a + 1;
  b := b * a;
  c := 3;
  return;
 end FunctionInlining.InlineAnnotation10.f2;

end FunctionInlining.InlineAnnotation10;
")})));
end InlineAnnotation10;

model InlineAnnotation11
    function F
        input Real i;
        output Real[1] o;
    algorithm
        o[1] := i;
    annotation(LateInline=true);
    end F;
    Real x[1](start=F(p), fixed=true);
    parameter Real p = 2;
equation
    der(x) = {time * 2};
    
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="InlineAnnotation11",
            description="Check that function call with LateInline=true in start value is propagated correctly",
            flatModel="
fclass FunctionInlining.InlineAnnotation11
 Real x[1](start = p,fixed = true);
 parameter Real p = 2 /* 2 */;
initial equation 
 x[1] = p;
equation
 der(x[1]) = time * 2;
end FunctionInlining.InlineAnnotation11;
")})));
end InlineAnnotation11;


model InlineAnnotation12
    function f
        input Real x;
        input Real y;
        output Real[2] z;
    algorithm
        z := (x - y) * (1:2);
        annotation(LateInline=true);
    end f;
    
    parameter Real p(fixed = false);
    Real x[2](start = 1:2);
initial equation
    x[1] = p - 2;
equation
    der(x) = f(p, time);

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="InlineAnnotation12",
            description="Inlining function call depending on fixed=false parameter should generate fixed=false parameters",
            flatModel="
fclass FunctionInlining.InlineAnnotation12
 parameter Real p(fixed = false);
 Real x[1](start = 1);
 Real x[2](start = 2);
 parameter Real temp_2(fixed = false);
 Real temp_3;
initial equation 
 x[1] = p - 2;
 temp_2 = p;
 x[1] = 1;
 x[2] = 2;
equation
 der(x[1]) = temp_2 - temp_3;
 der(x[2]) = (temp_2 - temp_3) * 2;
 temp_3 = time;
end FunctionInlining.InlineAnnotation12;
")})));
end InlineAnnotation12;


model InlineAnnotation13
	record R
		Real a;
		Real b;
	end R;
	
    function f
        input Real x;
        input Real y;
        output R z;
    algorithm
        z := R(x - y, x + y);
        annotation(LateInline=true);
    end f;
    
    parameter Real p(fixed = false);
    R x;
initial equation
    x.a = p - 2;
equation
    x = f(p, time);

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="InlineAnnotation13",
            description="Inlining function call depending on fixed=false parameter should generate fixed=false parameters",
            flatModel="
fclass FunctionInlining.InlineAnnotation13
 parameter Real p(fixed = false);
 Real x.a;
 Real x.b;
 parameter Real temp_2(fixed = false);
 Real temp_3;
initial equation 
 x.a = p - 2;
 temp_2 = p;
equation
 x.a = temp_2 - temp_3;
 x.b = temp_2 + temp_3;
 temp_3 = time;
end FunctionInlining.InlineAnnotation13;
")})));
end InlineAnnotation13;


model EmptyArray
    function f
        input Real d[:,:];
        output Real e;
    algorithm
        e := sum(size(d));
    end f;
    
    parameter Real a[:, :] = fill(0.0,0,2);
    Real x = f(a);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="EmptyArray",
			description="Test inlining of functions with empty arrays",
			variability_propagation=false,
			inline_functions="trivial",
			flatModel="
fclass FunctionInlining.EmptyArray
 Real x;
equation
 x = 2;
end FunctionInlining.EmptyArray;
")})));
end EmptyArray;


model BindingExpInRecord
    function f
        input Real i;
        output Real[2] o = { i, -i };
    algorithm
    end f;
    
    record A
        parameter Real[2] x = f(1);
    end A;
    
    A a;

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="BindingExpInRecord",
			description="Check that inlining function only used in declaration of record class doesn't cause crash",
			variability_propagation=false,
			inline_functions="trivial",
			flatModel="
fclass FunctionInlining.BindingExpInRecord
 parameter Real a.x[1] = 1 /* 1 */;
 parameter Real a.x[2] = -1 /* -1 */;
end FunctionInlining.BindingExpInRecord;
")})));
end BindingExpInRecord;


model AssertInline1
	function f
		input Real x;
		output Real y;
	algorithm
		assert(x < 5, "Bad x: " + String(x));
		y := 2 / (x - 5);
		annotation(Inline=true);
	end f;
	
	Real z = f(time);

	annotation(__JModelica(UnitTesting(tests={
		TransformCanonicalTestCase(
			name="AssertInline1",
			description="Inline function containing assert",
			flatModel="
fclass FunctionInlining.AssertInline1
 Real z;
 Real temp_1;
equation
 z = 2 / (temp_1 - 5);
 temp_1 = time;
 assert(noEvent(temp_1 < 5), \"Bad x: \" + String(temp_1));
end FunctionInlining.AssertInline1;
")})));
end AssertInline1;


model FunctionalInline1
    partial function partFunc
        output Real y;
    end partFunc;
    
    function fullFunc
        extends partFunc;
        input Real x1;
      algorithm
        y := x1;
    end fullFunc;
    
    function usePartFunc
        input partFunc pf;
        output Real y;
      algorithm
        y := pf();
    end usePartFunc;
    
    Real y = usePartFunc(function fullFunc(x1=time));

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="FunctionalInline1",
            description="Don't inline function containing functional arguments",
            flatModel="
fclass FunctionInlining.FunctionalInline1
 Real y;
equation
 y = FunctionInlining.FunctionalInline1.usePartFunc(function FunctionInlining.FunctionalInline1.fullFunc(time));

public
 function FunctionInlining.FunctionalInline1.usePartFunc
  input ((Real y) = FunctionInlining.FunctionalInline1.partFunc()) pf;
  output Real y;
 algorithm
  y := pf();
  return;
 end FunctionInlining.FunctionalInline1.usePartFunc;

 function FunctionInlining.FunctionalInline1.partFunc
  output Real y;
 algorithm
  return;
 end FunctionInlining.FunctionalInline1.partFunc;

 function FunctionInlining.FunctionalInline1.fullFunc
  output Real y;
  input Real x1;
 algorithm
  y := x1;
  return;
 end FunctionInlining.FunctionalInline1.fullFunc;

end FunctionInlining.FunctionalInline1;
")})));
end FunctionalInline1;

model InitialSystemInlining1
        function f
            input Real a;
            output Real b;
        algorithm
            b := a;
        end f;
        
        parameter Real x(fixed=false);
    initial equation
        x = f(time);
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="InitialSystemInlining1",
            description="Test inlining in the initial system",
            flatModel="
fclass FunctionInlining.InitialSystemInlining1
 parameter Real x(fixed = false);
initial equation 
 x = time;
end FunctionInlining.InitialSystemInlining1;
")})));
end InitialSystemInlining1;

model InitialSystemInlining2
    function F1
        input Real a[2];
        output Real b;
    algorithm
        b := sin(a[1])*cos(a[2]) + cos(a[1])*sin(a[2]);
    annotation(InlineAfterIndexReduction=true);
    end F1;
    
    function F2
        input Real a;
        output Real b[2];
    algorithm
        b[1] := a - 3.14;
        b[2] := a + 3.14;
    annotation(InlineAfterIndexReduction=true);
    end F2;
    
    parameter Real x(fixed=false);
initial equation
    x = F1(F2(time + 1));
    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="InitialSystemInlining2",
            description="Test inlining in the initial system. This test ensures that F2 is inlined correctly",
            flatModel="
fclass FunctionInlining.InitialSystemInlining2
 parameter Real x(fixed = false);
 Real temp_2;
 Real temp_3;
 Real temp_5;
initial equation 
 x = sin(temp_2) * cos(temp_3) + cos(temp_2) * sin(temp_3);
equation
 temp_2 = temp_5 - 3.14;
 temp_3 = temp_5 + 3.14;
 temp_5 = time + 1;
end FunctionInlining.InitialSystemInlining2;
")})));
end InitialSystemInlining2;

model ChainedCallInlining1
    record R
        Real x;
    end R;
    
    function f1
        input Real x;
        output R y = R(x);
        algorithm
    end f1;
    
    function f2
        input R x;
        output Real y = x.x;
        algorithm
    end f2;
    
    Real y = f2(f1(time));
annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ChainedCallInlining1",
            description="Test inlining chained function calls",
            flatModel="
fclass FunctionInlining.ChainedCallInlining1
 Real y;
equation
 y = time;
end FunctionInlining.ChainedCallInlining1;
")})));
end ChainedCallInlining1;

model ChainedCallInlining2
    record R
        Real x;
    end R;
    
    function f1
        input Real x;
        output R y = R(x);
        algorithm
    end f1;
    
    function f2
        input R x;
        output Real y = x.x;
        algorithm
        annotation(Inline=false);
    end f2;
    
    Real y = f2(f1(time));
annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ChainedCallInlining2",
            description="Test inlining chained function calls",
            flatModel="
fclass FunctionInlining.ChainedCallInlining2
 Real y;
equation
 y = FunctionInlining.ChainedCallInlining2.f2(FunctionInlining.ChainedCallInlining2.R(time));

public
 function FunctionInlining.ChainedCallInlining2.f2
  input FunctionInlining.ChainedCallInlining2.R x;
  output Real y;
 algorithm
  y := x.x;
  return;
 annotation(Inline = false);
 end FunctionInlining.ChainedCallInlining2.f2;

 record FunctionInlining.ChainedCallInlining2.R
  Real x;
 end FunctionInlining.ChainedCallInlining2.R;

end FunctionInlining.ChainedCallInlining2;
")})));
end ChainedCallInlining2;

model ChainedCallInlining3
    record R
        Real x;
    end R;
    
    function f1
        input Real x;
        output R y = R(x);
        algorithm
        annotation(Inline=false);
    end f1;
    
    function f2
        input R x;
        output Real y = x.x;
        algorithm
    end f2;
    
    Real y = f2(f1(time));
annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ChainedCallInlining3",
            description="Test inlining chained function calls",
            flatModel="
fclass FunctionInlining.ChainedCallInlining3
 Real y;
equation
 (FunctionInlining.ChainedCallInlining3.R(y)) = FunctionInlining.ChainedCallInlining3.f1(time);

public
 function FunctionInlining.ChainedCallInlining3.f1
  input Real x;
  output FunctionInlining.ChainedCallInlining3.R y;
 algorithm
  y.x := x;
  return;
 annotation(Inline = false);
 end FunctionInlining.ChainedCallInlining3.f1;

 record FunctionInlining.ChainedCallInlining3.R
  Real x;
 end FunctionInlining.ChainedCallInlining3.R;

end FunctionInlining.ChainedCallInlining3;
")})));
end ChainedCallInlining3;

model ChainedCallInlining4
    record R1
        Real x1;
        Real[2] x2;
    end R1;
    
    record R2
        R1[2] r1;
        Real[2] z1;
    end R2;
    
    function f1
        input Real x;
        output R2[:] y = {R2({R1(x,{x+1,x+2}),R1(x+3,{x+4,x+5})}, {x+6, x+7})};
        algorithm
        annotation(Inline=true);
    end f1;
    
    function f2
        input R2[:] x;
        output Real y;
        algorithm
            y := sum(x[1].r1[2].x2[1:2]);
    end f2;
      
      Real y = f2(f1(time));
annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ChainedCallInlining4",
            description="Test inlining chained function calls",
            flatModel="
fclass FunctionInlining.ChainedCallInlining4
 Real y;
 Real temp_11;
equation
 y = temp_11 + 4 + (temp_11 + 5);
 temp_11 = time;
end FunctionInlining.ChainedCallInlining4;
")})));
end ChainedCallInlining4;

model ChainedCallInlining5
    record R1
        Real x1;
        Real[2] x2;
    end R1;
    
    record R2
        R1[2] r1;
        Real[2] z1;
    end R2;
    
    function f1
        input Real x;
        output R2[1] y = {R2({R1(x,{x+1,x+2}),R1(x+3,{x+4,x+5})}, {x+6, x+7})};
        algorithm
        annotation(Inline=true);
    end f1;
    
    function f2
        input R2[1] x;
        output Real y;
        algorithm
            y := x[1].r1[2].x2[1] / x[1].r1[2].x2[2];
    end f2;
      
      Real y = f2(f1(time));
annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ChainedCallInlining5",
            description="Test inlining chained function calls",
            flatModel="
fclass FunctionInlining.ChainedCallInlining5
 Real y;
 Real temp_11;
equation
 y = (temp_11 + 4) / (temp_11 + 5);
 temp_11 = time;
end FunctionInlining.ChainedCallInlining5;
")})));
end ChainedCallInlining5;

model ChainedCallInlining6
    record R1
        Real x1;
        Real[2] x2;
    end R1;
    
    record R2
        R1[2] r1;
        Real[2] z1;
    end R2;
    
    function f1
        input Real x;
        output R2[1] y = {R2({R1(x,{x+1,x+2}),R1(x+3,{x+4,x+5})}, {x+6, x+7})};
        algorithm
        annotation(Inline=true);
    end f1;
    
    function f2
        input R2[1] x;
        output Real y;
        algorithm
            y := x[1].r1[2].x2[1] / x[1].r1[2].x2[2];
    end f2;
      
      Real y = f2(f1(f2(f1(time))));
  annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ChainedCallInlining6",
            description="Test inlining chained function calls",
            flatModel="
fclass FunctionInlining.ChainedCallInlining6
 Real y;
 Real temp_11;
 Real temp_30;
equation
 y = (temp_11 + 4) / (temp_11 + 5);
 temp_11 = (temp_30 + 4) / (temp_30 + 5);
 temp_30 = time;
end FunctionInlining.ChainedCallInlining6;
")})));
end ChainedCallInlining6;

model ChainedCallInlining7
    record R1
        Real x1;
        Real[2] x2;
    end R1;
    
    record R2
        R1[2] r1;
        Real[2] z1;
    end R2;
    
    function f1
        input Real x;
        output R2[1] y = {R2({R1(x,{x+1,x+2}),R1(x+3,{x+4,x+5})}, {x+6, x+7})};
        algorithm
        annotation(Inline=true);
    end f1;
    
    function f2
        input R2[1] x;
        output Real y;
        algorithm
            y := x[1].r1[2].x2[1] / x[1].r1[2].x2[2];
    end f2;
    
    function f3
        input Real x;
        output Real y;
    algorithm
        y := f2(f1(f2(f1(x))));
    end f3;
      
      Real y = f3(time);
  annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ChainedCallInlining7",
            description="Test inlining chained function calls",
            flatModel="
fclass FunctionInlining.ChainedCallInlining7
 Real y;
 Real temp_13;
 Real temp_32;
equation
 y = (temp_13 + 4) / (temp_13 + 5);
 temp_13 = (temp_32 + 4) / (temp_32 + 5);
 temp_32 = time;
end FunctionInlining.ChainedCallInlining7;
")})));
end ChainedCallInlining7;

model ChainedCallInlining8
    function f1
        input Real x;
        output Real y = x;
    algorithm
    end f1;
    
    function f2
        input Real[:] x;
        output Real[:] y = x;
    algorithm
    end f2;
    
    function f3
        input Real x;
        output Real[:] y = f2(f2(f1(f1({x,x+1,x+2}))));
        algorithm
        annotation(Inline=true);
    end f3;
  
    Real[:] y1 = f2(f2(f1(f1({time,time+1,time+2}))));
    Real[:] y2 = f3(time);
  annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ChainedCallInlining8",
            description="Test inlining chained function calls",
            flatModel="
fclass FunctionInlining.ChainedCallInlining8
 Real y1[1];
 Real y1[2];
 Real y1[3];
 Real y2[1];
 Real y2[2];
 Real y2[3];
equation
 y1[1] = time;
 y1[2] = time + 1;
 y1[3] = time + 2;
 y2[2] = y2[1] + 1;
 y2[3] = y2[1] + 2;
 y2[1] = time;
end FunctionInlining.ChainedCallInlining8;
")})));
end ChainedCallInlining8;

model ChainedCallInlining9
    record R
        Real[2] x;
    end R;

    function f1
        input R r;
        output Real[:] y = f2(f2(r.x));
    algorithm
    annotation(Inline=true);
    end f1;
    
    function f2
        input Real[:] x;
        output Real[:] y = x;
    algorithm
    end f2;
  
    Real[:] y = f1(R({time,time+1}));
    
  annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ChainedCallInlining9",
            description="Test inlining chained function calls",
            flatModel="
fclass FunctionInlining.ChainedCallInlining9
 Real y[1];
 Real y[2];
equation
 y[1] = time;
 y[2] = time + 1;
end FunctionInlining.ChainedCallInlining9;
")})));
end ChainedCallInlining9;

model ChainedCallInlining10
    record R
        Real[2,1] x;
    end R;

    function f1
        input R r;
        output Real[:,:] y = f2(f2(r.x));
    algorithm
    annotation(Inline=true);
    end f1;
    
    function f2
        input Real[:,:] x;
        output Real[:,:] y = x;
    algorithm
    end f2;
  
    Real[:,:] y = f1(R({{time},{time+1}}));
    
  annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ChainedCallInlining10",
            description="Test inlining chained function calls",
            flatModel="
fclass FunctionInlining.ChainedCallInlining10
 Real y[1,1];
 Real y[2,1];
equation
 y[1,1] = time;
 y[2,1] = time + 1;
end FunctionInlining.ChainedCallInlining10;
")})));
end ChainedCallInlining10;

model ChainedCallInlining11
    function f1
        input Real x;
        output Real[:,:] y = {{x}};
    algorithm
    annotation(Inline=true);
    end f1;
    
    function f2
        input Real[:,:] x;
        output Real[:,:] y = x;
    algorithm
    annotation(Inline=false);
    end f2;
  
    Real[:,:] y = f2(f1(time));
    
  annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="ChainedCallInlining11",
            description="Test inlining chained function calls",
            flatModel="
fclass FunctionInlining.ChainedCallInlining11
 Real y[1,1];
equation
 ({{y[1,1]}}) = FunctionInlining.ChainedCallInlining11.f2({{time}});

public
 function FunctionInlining.ChainedCallInlining11.f2
  input Real[:, :] x;
  output Real[:,:] y;
 algorithm
  size(y) := {size(x, 1), size(x, 2)};
  for i1 in 1:size(x, 1) loop
   for i2 in 1:size(x, 2) loop
    y[i1,i2] := x[i1,i2];
   end for;
  end for;
  return;
 annotation(Inline = false);
 end FunctionInlining.ChainedCallInlining11.f2;

end FunctionInlining.ChainedCallInlining11;
")})));
end ChainedCallInlining11;


model InputAsIndex1
    function f
        input Integer u;
        input Real map[:];
        output Real y;
    algorithm
      y := map[u];
    end f;
    
    Real y;
    Integer i = integer(time);
equation
    y = f(i, {1,2});

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="InputAsIndex1",
            description="",
            flatModel="
fclass FunctionInlining.InputAsIndex1
 Real y;
 discrete Integer i;
initial equation 
 pre(i) = 0;
equation
 y = ({1, 2})[i];
 i = if time < pre(i) or time >= pre(i) + 1 or initial() then integer(time) else pre(i);
end FunctionInlining.InputAsIndex1;
")})));
end InputAsIndex1;


model InputAsIndex2
    function f
        input Integer u;
        input Integer v;
        input Real map[:,:];
        output Real y;
    algorithm
      y := map[u,v];
    end f;
    
    Real y;
    Integer i = integer(time);
equation
    y = f(i, 1, {{1,2},{3,4}});

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="InputAsIndex2",
            description="",
            flatModel="
fclass FunctionInlining.InputAsIndex2
 Real y;
 discrete Integer i;
initial equation 
 pre(i) = 0;
equation
 y = ({1, 3})[i];
 i = if time < pre(i) or time >= pre(i) + 1 or initial() then integer(time) else pre(i);
end FunctionInlining.InputAsIndex2;
")})));
end InputAsIndex2;


model InputAsIndex3
    record R
        Real x;
    end R;
    
    function f
        input Integer u;
        input R map[:];
        output Real y;
    algorithm
      y := map[u].x;
    end f;
    
    Real y;
    Integer i = integer(time);
    R r[2] = {R(time),R(2 * time)};
equation
    y = f(i, r);

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="InputAsIndex3",
            description="",
            flatModel="
fclass FunctionInlining.InputAsIndex3
 Real y;
 discrete Integer i;
 Real r[1].x;
 Real r[2].x;
initial equation 
 pre(i) = 0;
equation
 y = ({r[1].x, r[2].x})[i];
 r[1].x = time;
 r[2].x = 2 * time;
 i = if time < pre(i) or time >= pre(i) + 1 or initial() then integer(time) else pre(i);
end FunctionInlining.InputAsIndex3;
")})));
end InputAsIndex3;


model InputAsIndex4
    record R
        Real x[2];
    end R;
    
    function f
        input Integer u;
        input R map[:];
        output Real y;
    algorithm
      y := map[u].x[u];
    end f;
    
    Real y;
    Integer i = integer(time);
    R r[2] = {R({1,2}),R({3,4})};
equation
    y = f(i, r);

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="InputAsIndex4",
            description="",
            flatModel="
fclass FunctionInlining.InputAsIndex4
 Real y;
 discrete Integer i;
 constant Real r[1].x[1] = 1;
 constant Real r[1].x[2] = 2;
 constant Real r[2].x[1] = 3;
 constant Real r[2].x[2] = 4;
initial equation 
 pre(i) = 0;
equation
 y = ({{1.0, 2.0}, {3.0, 4.0}})[i,i];
 i = if time < pre(i) or time >= pre(i) + 1 or initial() then integer(time) else pre(i);
end FunctionInlining.InputAsIndex4;
")})));
end InputAsIndex4;

end FunctionInlining;
