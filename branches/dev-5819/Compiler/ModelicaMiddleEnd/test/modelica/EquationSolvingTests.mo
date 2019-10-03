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

within ;
package EquationSolvingTests

model ParametricNominal1
        function f
            output Real y = 1;
        algorithm
            assert(false, "");
        end f;

        parameter Real p = f();
        Real x;
        Real y(nominal=p);
    equation
        x*y=1;
        x*2 + y*3 = 0;
    annotation(__JModelica(UnitTesting(tests={
        FClassMethodTestCase(
            name="ParametricNominal1",
            description="",
            methodName="printDAEBLT",
            methodResult="
--- Torn system (Block 1) of 1 iteration variables and 1 solved variables ---
Torn variables:
  y

Iteration variables:
  x ()

Torn equations:
  y := (- x * 2) / 3

Residual equations:
  x * y = 1
    Iteration variables: x
-------------------------------
")})));
end ParametricNominal1;

end EquationSolvingTests;
