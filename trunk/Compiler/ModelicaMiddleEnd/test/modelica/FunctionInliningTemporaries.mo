/*
    Copyright (C) 2019 Modelon AB

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


package FunctionInliningTemporaries
    
    model BasicInlineTemp1
        function f
            input Real[:] a;
            Real b;
            Real c;
            output Real d;
        algorithm
            b := product(a);
            c := b * b;
            d := c * c;
        end f;
        
        Real y1;
    equation
        (y1) = f({time + 1, time + 2});

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="BasicInlineTemp1",
            description="Inline functions with temporaries",
            inline_functions="all",
            flatModel="
fclass FunctionInliningTemporaries.BasicInlineTemp1
 Real y1;
 Real temp_7;
equation
 temp_7 = (time + 1) * (time + 2);
 y1 = temp_7 * temp_7 * (temp_7 * temp_7);
end FunctionInliningTemporaries.BasicInlineTemp1;
")})));
    end BasicInlineTemp1;
       
    model BasicInlineTempTrivial1
        function f
            input Real[:] a;
            output Real[:] d = {i^2 for i in 1:size(a,1)} .* a;
        algorithm
        end f;
        
        Real[:] y1 = f({time + 1, time + 2});

    annotation(__JModelica(UnitTesting(tests={
        TransformCanonicalTestCase(
            name="BasicInlineTempTrivial1",
            description="Inline functions with temporaries",
            inline_functions="trivial",
            flatModel="
fclass FunctionInliningTemporaries.BasicInlineTempTrivial1
 Real y1[1];
 Real y1[2];
equation
 y1[1] = time + 1;
 y1[2] = 4.0 .* (time + 2);
end FunctionInliningTemporaries.BasicInlineTempTrivial1;
")})));
    end BasicInlineTempTrivial1;
end FunctionInliningTemporaries;
