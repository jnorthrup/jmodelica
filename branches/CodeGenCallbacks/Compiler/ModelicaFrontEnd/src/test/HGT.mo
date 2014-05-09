/*
    Copyright (C) 2009-2014 Modelon AB

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

package HGT
    package Unpaired
        
        model Simple1
            Real u0,u1,u2,u3,uL;
            Real i0,i1,i2,iL;
            Real i3 annotation(__Modelon(IterationVariable));
            parameter Real R1 = 1;
            parameter Real R2 = 1;
            parameter Real R3 = 1;
            parameter Real L = 1;
        equation
            u0 = sin(time);
            u1 = R1*i1 annotation(__Modelon(ResidualEquation));
            u2 = R2*i2;
            u3 = R3*i3;
            uL = L*der(iL);
            u0 = u1 + u3;
            uL = u1 + u2;
            u2 = u3;
            i0 = i1 + iL;
            i1 = i2 + i3;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="Unpaired_Simple1",
                methodName="printDAEBLT",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                description="Simple test of unmatched hand guided tearing, one 'pair'",
                methodResult="
-------------------------------
Solved block of 1 variables:
Computed variable:
  u0
Solution:
  sin(time)
-------------------------------
Torn linear block of 2 iteration variables and 3 solved variables:
Coefficient variability: Parameter
Solved variables:
  u2
  u1
  i1
Iteration variables:
  i3
  i2
Solved equations:
  u2 = R3 * i3
  u0 = u1 + u2
  i1 = i2 + i3
Residual equations:
 Iteration variables: i3
  u1 = R1 * i1
 Iteration variables: i2
  u2 = R2 * i2
Jacobian:
  |1.0, 0.0, 0.0, (- R3), 0.0|
  |- 1.0, - 1.0, 0.0, 0.0, 0.0|
  |0.0, 0.0, 1.0, - 1.0, - 1.0|
  |0.0, 1.0, (- R1), 0.0, 0.0|
  |1.0, 0.0, 0.0, 0.0, (- R2)|
-------------------------------
Solved block of 1 variables:
Computed variable:
  uL
Solution:
  u1 + u2
-------------------------------
Solved block of 1 variables:
Computed variable:
  der(iL)
Solution:
  (- uL) / (- L)
-------------------------------
Solved block of 1 variables:
Computed variable:
  i0
Solution:
  i1 + iL
-------------------------------
")})));
        end Simple1;

        model Alias1
            Real u0,u1,u2,u3,uL;
            Real i0,i1,i2,i3,iL;
            Real i4 annotation(__Modelon(IterationVariable));
            parameter Real R1 = 1;
            parameter Real R2 = 1;
            parameter Real R3 = 1;
            parameter Real L = 1;
        equation
            i3 = i4;
            u0 = sin(time);
            u1 = R1*i1 annotation(__Modelon(ResidualEquation));
            u2 = R2*i2;
            u3 = R3*i3;
            uL = L*der(iL);
            u0 = u1 + u3;
            uL = u1 + u2;
            u2 = u3;
            i0 = i1 + iL;
            i1 = i2 + i3;

    annotation(__JModelica(UnitTesting(tests={
        FClassMethodTestCase(
            name="Unpaired_Alias1",
            methodName="printDAEBLT",
            equation_sorting=true,
            automatic_tearing=true,
            hand_guided_tearing=true,
            description="Test of unmatched hand guided tearing with alias variable",
            methodResult="
-------------------------------
Solved block of 1 variables:
Computed variable:
  u0
Solution:
  sin(time)
-------------------------------
Torn linear block of 2 iteration variables and 3 solved variables:
Coefficient variability: Parameter
Solved variables:
  u2
  u1
  i1
Iteration variables:
  i4
  i2
Solved equations:
  u2 = R3 * i4
  u0 = u1 + u2
  i1 = i2 + i4
Residual equations:
 Iteration variables: i4
  u1 = R1 * i1
 Iteration variables: i2
  u2 = R2 * i2
Jacobian:
  |1.0, 0.0, 0.0, (- R3), 0.0|
  |- 1.0, - 1.0, 0.0, 0.0, 0.0|
  |0.0, 0.0, 1.0, - 1.0, - 1.0|
  |0.0, 1.0, (- R1), 0.0, 0.0|
  |1.0, 0.0, 0.0, 0.0, (- R2)|
-------------------------------
Solved block of 1 variables:
Computed variable:
  uL
Solution:
  u1 + u2
-------------------------------
Solved block of 1 variables:
Computed variable:
  der(iL)
Solution:
  (- uL) / (- L)
-------------------------------
Solved block of 1 variables:
Computed variable:
  i0
Solution:
  i1 + iL
-------------------------------
")})));
        end Alias1;
        
        model Enabled1
            Real u0,u1,u2,u3,uL;
            Real i0,i1,i2,iL;
            Real i3 annotation(__Modelon(IterationVariable));
            parameter Real R1 = 1;
            parameter Real R2 = 1;
            parameter Real R3 = 1;
            parameter Real L = 1;
        equation
            u0 = sin(time);
            u1 = R1*i1 annotation(__Modelon(ResidualEquation(enabled=true)));
            u2 = R2*i2;
            u3 = R3*i3;
            uL = L*der(iL);
            u0 = u1 + u3;
            uL = u1 + u2;
            u2 = u3;
            i0 = i1 + iL;
            i1 = i2 + i3;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="Unpaired_Enabled1",
                methodName="printDAEBLT",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                description="Test of hand guided tearing with enable set to true",
                methodResult="
-------------------------------
Solved block of 1 variables:
Computed variable:
  u0
Solution:
  sin(time)
-------------------------------
Torn linear block of 2 iteration variables and 3 solved variables:
Coefficient variability: Parameter
Solved variables:
  u2
  u1
  i1
Iteration variables:
  i3
  i2
Solved equations:
  u2 = R3 * i3
  u0 = u1 + u2
  i1 = i2 + i3
Residual equations:
 Iteration variables: i3
  u1 = R1 * i1
 Iteration variables: i2
  u2 = R2 * i2
Jacobian:
  |1.0, 0.0, 0.0, (- R3), 0.0|
  |- 1.0, - 1.0, 0.0, 0.0, 0.0|
  |0.0, 0.0, 1.0, - 1.0, - 1.0|
  |0.0, 1.0, (- R1), 0.0, 0.0|
  |1.0, 0.0, 0.0, 0.0, (- R2)|
-------------------------------
Solved block of 1 variables:
Computed variable:
  uL
Solution:
  u1 + u2
-------------------------------
Solved block of 1 variables:
Computed variable:
  der(iL)
Solution:
  (- uL) / (- L)
-------------------------------
Solved block of 1 variables:
Computed variable:
  i0
Solution:
  i1 + iL
-------------------------------
")})));
        end Enabled1;

        model Enabled2
            Real u0,u1,u2,u3,uL;
            Real i0,i1,i2,i3,iL;
            parameter Real R1 = 1;
            parameter Real R2 = 1;
            parameter Real R3 = 1;
            parameter Real L = 1;
        equation
            u0 = sin(time);
            u1 = R1*i1 annotation(__Modelon(ResidualEquation(enabled=false)));
            u2 = R2*i2;
            u3 = R3*i3;
            uL = L*der(iL);
            u0 = u1 + u3;
            uL = u1 + u2;
            u2 = u3;
            i0 = i1 + iL;
            i1 = i2 + i3;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="Unpaired_Enabled2",
                methodName="printDAEBLT",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                description="Test of hand guided tearing with enable set to false",
                methodResult="
-------------------------------
Solved block of 1 variables:
Computed variable:
  u0
Solution:
  sin(time)
-------------------------------
Torn linear block of 2 iteration variables and 3 solved variables:
Coefficient variability: Parameter
Solved variables:
  i1
  u1
  u2
Iteration variables:
  i2
  i3
Solved equations:
  i1 = i2 + i3
  u1 = R1 * i1
  u0 = u1 + u2
Residual equations:
 Iteration variables: i2
  u2 = R3 * i3
 Iteration variables: i3
  u2 = R2 * i2
Jacobian:
  |1.0, 0.0, 0.0, - 1.0, - 1.0|
  |(- R1), 1.0, 0.0, 0.0, 0.0|
  |0.0, - 1.0, - 1.0, 0.0, 0.0|
  |0.0, 0.0, 1.0, 0.0, (- R3)|
  |0.0, 0.0, 1.0, (- R2), 0.0|
-------------------------------
Solved block of 1 variables:
Computed variable:
  uL
Solution:
  u1 + u2
-------------------------------
Solved block of 1 variables:
Computed variable:
  der(iL)
Solution:
  (- uL) / (- L)
-------------------------------
Solved block of 1 variables:
Computed variable:
  i0
Solution:
  i1 + iL
-------------------------------
")})));
        end Enabled2;
       
       model Enabled3
            parameter Boolean isResidual = true;
            Real u0,u1,u2,u3,uL;
            Real i0,i1,i2,iL;
            Real i3 annotation(__Modelon(IterationVariable));
            parameter Real R1 = 1;
            parameter Real R2 = 1;
            parameter Real R3 = 1;
            parameter Real L = 1;
        equation
            u0 = sin(time);
            u1 = R1*i1 annotation(__Modelon(ResidualEquation(enabled=isResidual)));
            u2 = R2*i2;
            u3 = R3*i3;
            uL = L*der(iL);
            u0 = u1 + u3;
            uL = u1 + u2;
            u2 = u3;
            i0 = i1 + iL;
            i1 = i2 + i3;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="Unpaired_Enabled3",
                methodName="printDAEBLT",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                description="Test of hand guided tearing with enable set to true through a parameter",
                methodResult="
-------------------------------
Solved block of 1 variables:
Computed variable:
  u0
Solution:
  sin(time)
-------------------------------
Torn linear block of 2 iteration variables and 3 solved variables:
Coefficient variability: Parameter
Solved variables:
  u2
  u1
  i1
Iteration variables:
  i3
  i2
Solved equations:
  u2 = R3 * i3
  u0 = u1 + u2
  i1 = i2 + i3
Residual equations:
 Iteration variables: i3
  u1 = R1 * i1
 Iteration variables: i2
  u2 = R2 * i2
Jacobian:
  |1.0, 0.0, 0.0, (- R3), 0.0|
  |- 1.0, - 1.0, 0.0, 0.0, 0.0|
  |0.0, 0.0, 1.0, - 1.0, - 1.0|
  |0.0, 1.0, (- R1), 0.0, 0.0|
  |1.0, 0.0, 0.0, 0.0, (- R2)|
-------------------------------
Solved block of 1 variables:
Computed variable:
  uL
Solution:
  u1 + u2
-------------------------------
Solved block of 1 variables:
Computed variable:
  der(iL)
Solution:
  (- uL) / (- L)
-------------------------------
Solved block of 1 variables:
Computed variable:
  i0
Solution:
  i1 + iL
-------------------------------
")})));
        end Enabled3;

        model Enabled4
            parameter Boolean isResidual = false;
            Real u0,u1,u2,u3,uL;
            Real i0,i1,i2,i3,iL;
            parameter Real R1 = 1;
            parameter Real R2 = 1;
            parameter Real R3 = 1;
            parameter Real L = 1;
        equation
            u0 = sin(time);
            u1 = R1*i1 annotation(__Modelon(ResidualEquation(enabled=isResidual)));
            u2 = R2*i2;
            u3 = R3*i3;
            uL = L*der(iL);
            u0 = u1 + u3;
            uL = u1 + u2;
            u2 = u3;
            i0 = i1 + iL;
            i1 = i2 + i3;
       
        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="Unpaired_Enabled4",
                methodName="printDAEBLT",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                description="Test of hand guided tearing with enable set to false through a parameter",
                methodResult="
-------------------------------
Solved block of 1 variables:
Computed variable:
  u0
Solution:
  sin(time)
-------------------------------
Torn linear block of 2 iteration variables and 3 solved variables:
Coefficient variability: Parameter
Solved variables:
  i1
  u1
  u2
Iteration variables:
  i2
  i3
Solved equations:
  i1 = i2 + i3
  u1 = R1 * i1
  u0 = u1 + u2
Residual equations:
 Iteration variables: i2
  u2 = R3 * i3
 Iteration variables: i3
  u2 = R2 * i2
Jacobian:
  |1.0, 0.0, 0.0, - 1.0, - 1.0|
  |(- R1), 1.0, 0.0, 0.0, 0.0|
  |0.0, - 1.0, - 1.0, 0.0, 0.0|
  |0.0, 0.0, 1.0, 0.0, (- R3)|
  |0.0, 0.0, 1.0, (- R2), 0.0|
-------------------------------
Solved block of 1 variables:
Computed variable:
  uL
Solution:
  u1 + u2
-------------------------------
Solved block of 1 variables:
Computed variable:
  der(iL)
Solution:
  (- uL) / (- L)
-------------------------------
Solved block of 1 variables:
Computed variable:
  i0
Solution:
  i1 + iL
-------------------------------
")})));
       end Enabled4;

        model Enabled5
            Real u0,u1,u2,u3,uL;
            Real i0,i1,iL;
            Real i2 annotation(__Modelon(IterationVariable(enabled=true)));
            Real i3 annotation(__Modelon(IterationVariable(enabled=false)));
            parameter Real R1 = 1;
            parameter Real R2 = 1;
            parameter Real R3 = 1;
            parameter Real L = 1;
        equation
            u0 = sin(time);
            u1 = R1*i1 annotation(__Modelon(ResidualEquation));
            u2 = R2*i2;
            u3 = R3*i3;
            uL = L*der(iL);
            u0 = u1 + u3;
            uL = u1 + u2;
            u2 = u3;
            i0 = i1 + iL;
            i1 = i2 + i3;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="Unpaired_Enabled",
                methodName="printDAEBLT",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                description="Test of hand guided tearing with annotation on two iteration variables",
                methodResult="
-------------------------------
Solved block of 1 variables:
Computed variable:
  u0
Solution:
  sin(time)
-------------------------------
Torn linear block of 2 iteration variables and 3 solved variables:
Coefficient variability: Parameter
Solved variables:
  u2
  u1
  i1
Iteration variables:
  i2
  i3
Solved equations:
  u2 = R2 * i2
  u0 = u1 + u2
  i1 = i2 + i3
Residual equations:
 Iteration variables: i2
  u1 = R1 * i1
 Iteration variables: i3
  u2 = R3 * i3
Jacobian:
  |1.0, 0.0, 0.0, (- R2), 0.0|
  |- 1.0, - 1.0, 0.0, 0.0, 0.0|
  |0.0, 0.0, 1.0, - 1.0, - 1.0|
  |0.0, 1.0, (- R1), 0.0, 0.0|
  |1.0, 0.0, 0.0, 0.0, (- R3)|
-------------------------------
Solved block of 1 variables:
Computed variable:
  uL
Solution:
  u1 + u2
-------------------------------
Solved block of 1 variables:
Computed variable:
  der(iL)
Solution:
  (- uL) / (- L)
-------------------------------
Solved block of 1 variables:
Computed variable:
  i0
Solution:
  i1 + iL
-------------------------------
      ")})));
        end Enabled5;

        model Enabled6
            Real u0,u1,u2,u3,uL;
            Real i0,i1,iL;
            Real i2 annotation(__Modelon(IterationVariable(enabled=false)));
            Real i3 annotation(__Modelon(IterationVariable(enabled=true)));
            parameter Real R1 = 1;
            parameter Real R2 = 1;
            parameter Real R3 = 1;
            parameter Real L = 1;
        equation
            u0 = sin(time);
            u1 = R1*i1 annotation(__Modelon(ResidualEquation));
            u2 = R2*i2;
            u3 = R3*i3;
            uL = L*der(iL);
            u0 = u1 + u3;
            uL = u1 + u2;
            u2 = u3;
            i0 = i1 + iL;
            i1 = i2 + i3;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="Unpaired_Enabled6",
                methodName="printDAEBLT",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                description="Test of hand guided tearing with annotation on two iteration variables",
                methodResult="
-------------------------------
Solved block of 1 variables:
Computed variable:
  u0
Solution:
  sin(time)
-------------------------------
Torn linear block of 2 iteration variables and 3 solved variables:
Coefficient variability: Parameter
Solved variables:
  u2
  u1
  i1
Iteration variables:
  i3
  i2
Solved equations:
  u2 = R3 * i3
  u0 = u1 + u2
  i1 = i2 + i3
Residual equations:
 Iteration variables: i3
  u1 = R1 * i1
 Iteration variables: i2
  u2 = R2 * i2
Jacobian:
  |1.0, 0.0, 0.0, (- R3), 0.0|
  |- 1.0, - 1.0, 0.0, 0.0, 0.0|
  |0.0, 0.0, 1.0, - 1.0, - 1.0|
  |0.0, 1.0, (- R1), 0.0, 0.0|
  |1.0, 0.0, 0.0, 0.0, (- R2)|
-------------------------------
Solved block of 1 variables:
Computed variable:
  uL
Solution:
  u1 + u2
-------------------------------
Solved block of 1 variables:
Computed variable:
  der(iL)
Solution:
  (- uL) / (- L)
-------------------------------
Solved block of 1 variables:
Computed variable:
  i0
Solution:
  i1 + iL
-------------------------------
      ")})));
        end Enabled6;

        model Enabled7
            parameter Boolean isIteration = true;
            Real u0,u1,u2,u3,uL;
            Real i0,i1,iL;
            Real i2 annotation(__Modelon(IterationVariable(enabled=isIteration)));
            Real i3 annotation(__Modelon(IterationVariable(enabled=not isIteration)));
            parameter Real R1 = 1;
            parameter Real R2 = 1;
            parameter Real R3 = 1;
            parameter Real L = 1;
       equation
            u0 = sin(time);
            u1 = R1*i1 annotation(__Modelon(ResidualEquation));
            u2 = R2*i2;
            u3 = R3*i3;
            uL = L*der(iL);
            u0 = u1 + u3;
            uL = u1 + u2;
            u2 = u3;
            i0 = i1 + iL;
            i1 = i2 + i3;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="Unpaired_Enabled7",
                methodName="printDAEBLT",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                description="Test of hand guided tearing with annotation on two iteration variables, set through parameter",
                methodResult="
-------------------------------
Solved block of 1 variables:
Computed variable:
  u0
Solution:
  sin(time)
-------------------------------
Torn linear block of 2 iteration variables and 3 solved variables:
Coefficient variability: Parameter
Solved variables:
  u2
  u1
  i1
Iteration variables:
  i2
  i3
Solved equations:
  u2 = R2 * i2
  u0 = u1 + u2
  i1 = i2 + i3
Residual equations:
 Iteration variables: i2
  u1 = R1 * i1
 Iteration variables: i3
  u2 = R3 * i3
Jacobian:
  |1.0, 0.0, 0.0, (- R2), 0.0|
  |- 1.0, - 1.0, 0.0, 0.0, 0.0|
  |0.0, 0.0, 1.0, - 1.0, - 1.0|
  |0.0, 1.0, (- R1), 0.0, 0.0|
  |1.0, 0.0, 0.0, 0.0, (- R3)|
-------------------------------
Solved block of 1 variables:
Computed variable:
  uL
Solution:
  u1 + u2
-------------------------------
Solved block of 1 variables:
Computed variable:
  der(iL)
Solution:
  (- uL) / (- L)
-------------------------------
Solved block of 1 variables:
Computed variable:
  i0
Solution:
  i1 + iL
-------------------------------
      ")})));
        end Enabled7;

        model Enabled8
            parameter Boolean isIteration = false;
            Real u0,u1,u2,u3,uL;
            Real i0,i1,iL;
            Real i2 annotation(__Modelon(IterationVariable(enabled=isIteration)));
            Real i3 annotation(__Modelon(IterationVariable(enabled=not isIteration)));
            parameter Real R1 = 1;
            parameter Real R2 = 1;
            parameter Real R3 = 1;
            parameter Real L = 1;
        equation
            u0 = sin(time);
            u1 = R1*i1 annotation(__Modelon(ResidualEquation));
            u2 = R2*i2;
            u3 = R3*i3;
            uL = L*der(iL);
            u0 = u1 + u3;
            uL = u1 + u2;
            u2 = u3;
            i0 = i1 + iL;
            i1 = i2 + i3;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="Unpaired_Enabled8",
                methodName="printDAEBLT",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                description="Test of hand guided tearing with annotation on two iteration variables, set through parameter",
                methodResult="
-------------------------------
Solved block of 1 variables:
Computed variable:
  u0
Solution:
  sin(time)
-------------------------------
Torn linear block of 2 iteration variables and 3 solved variables:
Coefficient variability: Parameter
Solved variables:
  u2
  u1
  i1
Iteration variables:
  i3
  i2
Solved equations:
  u2 = R3 * i3
  u0 = u1 + u2
  i1 = i2 + i3
Residual equations:
 Iteration variables: i3
  u1 = R1 * i1
 Iteration variables: i2
  u2 = R2 * i2
Jacobian:
  |1.0, 0.0, 0.0, (- R3), 0.0|
  |- 1.0, - 1.0, 0.0, 0.0, 0.0|
  |0.0, 0.0, 1.0, - 1.0, - 1.0|
  |0.0, 1.0, (- R1), 0.0, 0.0|
  |1.0, 0.0, 0.0, 0.0, (- R2)|
-------------------------------
Solved block of 1 variables:
Computed variable:
  uL
Solution:
  u1 + u2
-------------------------------
Solved block of 1 variables:
Computed variable:
  der(iL)
Solution:
  (- uL) / (- L)
-------------------------------
Solved block of 1 variables:
Computed variable:
  i0
Solution:
  i1 + iL
-------------------------------
      ")})));
        end Enabled8;

        model Enabled9
            constant Integer n = 4;
            Real x[n] annotation(__Modelon(IterationVariable(each enabled=true)));
            Real y[n];
        equation
            x = y .+ 3 annotation(__Modelon(ResidualEquation));
            x .+ y = fill(4, n);
        annotation(
           __JModelica(UnitTesting(tests={
                FClassMethodTestCase(
                    name="Unpaired_Enabled9",
                    description="Test of hand guided tearing with each on enabled attribute for interation variable.",
                    equation_sorting=true,
                    automatic_tearing=true,
                    hand_guided_tearing=true,
                    methodName="printDAEBLT",
                    methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[1]
Iteration variables:
  x[1]
Solved equations:
  x[1] .+ y[1] = 4
Residual equations:
 Iteration variables: x[1]
  x[1] = y[1] .+ 3
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[2]
Iteration variables:
  x[2]
Solved equations:
  x[2] .+ y[2] = 4
Residual equations:
 Iteration variables: x[2]
  x[2] = y[2] .+ 3
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[3]
Iteration variables:
  x[3]
Solved equations:
  x[3] .+ y[3] = 4
Residual equations:
 Iteration variables: x[3]
  x[3] = y[3] .+ 3
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[4]
Iteration variables:
  x[4]
Solved equations:
  x[4] .+ y[4] = 4
Residual equations:
 Iteration variables: x[4]
  x[4] = y[4] .+ 3
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
")})));
        end Enabled9;

        model Enabled10
            constant Integer n = 4;
            Real x[n] annotation(__Modelon(IterationVariable(enabled=fill(true, n))));
            Real y[n];
        equation
            x = y .+ 3 annotation(__Modelon(ResidualEquation));
            x .+ y = fill(4, n);
        annotation(
            __JModelica(UnitTesting(tests={
                FClassMethodTestCase(
                name="Unpaired_Enabled10",
                description="Test of hand guided tearing with vectorized enabled attribute for interation variable.",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                methodName="printDAEBLT",
                methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[1]
Iteration variables:
  x[1]
Solved equations:
  x[1] .+ y[1] = 4
Residual equations:
 Iteration variables: x[1]
  x[1] = y[1] .+ 3
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[2]
Iteration variables:
  x[2]
Solved equations:
  x[2] .+ y[2] = 4
Residual equations:
 Iteration variables: x[2]
  x[2] = y[2] .+ 3
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[3]
Iteration variables:
  x[3]
Solved equations:
  x[3] .+ y[3] = 4
Residual equations:
 Iteration variables: x[3]
  x[3] = y[3] .+ 3
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[4]
Iteration variables:
  x[4]
Solved equations:
  x[4] .+ y[4] = 4
Residual equations:
 Iteration variables: x[4]
  x[4] = y[4] .+ 3
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
")})));
        end Enabled10;

        model Enabled11
            constant Integer n = 2;
            Real x[n] annotation(__Modelon(IterationVariable(enabled=if n == 2 then {true,false} else fill(true, n))));
            Real y[n] annotation(__Modelon(IterationVariable(enabled=if n == 2 then {false,true} else fill(false, n))));
        equation
            x = y .+ 3 annotation(__Modelon(ResidualEquation));
            x .+ y = fill(4, n);
        annotation(
            __JModelica(UnitTesting(tests={
                FClassMethodTestCase(
                    name="Unpaired_Enabled11",
                    description="Test of hand guided tearing with vectorized enabled attribute for interation variable.",
                    equation_sorting=true,
                    automatic_tearing=true,
                    hand_guided_tearing=true,
                    methodName="printDAEBLT",
                    methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[1]
Iteration variables:
  x[1]
Solved equations:
  x[1] .+ y[1] = 4
Residual equations:
 Iteration variables: x[1]
  x[1] = y[1] .+ 3
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  x[2]
Iteration variables:
  y[2]
Solved equations:
  x[2] .+ y[2] = 4
Residual equations:
 Iteration variables: y[2]
  x[2] = y[2] .+ 3
Jacobian:
  |1.0, 1.0|
  |1.0, - 1.0|
-------------------------------
")})));
    end Enabled11;

        model Enabled12
            constant Integer n = 4;
            Real x[n] annotation(__Modelon(IterationVariable(enabled=fill(true, n))));
            Real y[n];
        equation
            x = y .+ 3 annotation(__Modelon(ResidualEquation));
            x .* y = fill(4, n);
        annotation(__JModelica(UnitTesting(tests={
            FlatteningTestCase(
                name="Unpaired_Enabled12",
                description="Test of prettyprinting of the enabled exp",
                hand_guided_tearing=true,
                flatModel="
fclass HGT.Unpaired.Enabled12
 constant Integer n = 4;
 Real x[4] annotation(__Modelon(IterationVariable(enabled={ true, true, true, true })));
 Real y[4];
equation
 x[1:4] = y[1:4] .+ 3;
 x[1:4] .* y[1:4] = fill(4, 4);
end HGT.Unpaired.Enabled12;
")})));
end Enabled12;

model EnabledError1
    Real x;
    Real y;
    Real z annotation(__Modelon(IterationVariable(enabled=1)));
equation
    x=y + 1;
    y=z + 2 annotation(__Modelon(name=res));
    z=x - 3 annotation(__Modelon(ResidualEquation(enabled=1)));
    annotation(
    __Modelon(tearingPairs(
        Pair(iterationVariable=x, residualEquation=res, enabled=1)
    )),
    __JModelica(UnitTesting(tests={
        ErrorTestCase(
            equation_sorting=true,
            automatic_tearing=true,
            hand_guided_tearing=true,
            name="Unpaired_EnabledError1",
            description="Test hand guided tearing errors",
            errorMessage="
3 errors found:

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8432, column 56:
  The type of the enabled expression is not boolean

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8436, column 56:
  The type of the enabled expression is not boolean

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8439, column 59:
  Cannot evaluate boolean enabled expression: 1
")})));
        end EnabledError1;

        model EnabledError2
            Real x;
            Real y;
            Real z annotation(__Modelon(IterationVariable(enabled=unknownParameter1)));
        equation
            x=y + 1;
            y=z + 2 annotation(__Modelon(name=res));
            z=x - 3 annotation(__Modelon(ResidualEquation(enabled=unknownParameter2)));
        annotation(
            __Modelon(tearingPairs(
                Pair(iterationVariable=x, residualEquation=res, enabled=unknownParameter3)
            )),
           __JModelica(UnitTesting(tests={
                ErrorTestCase(
                    equation_sorting=true,
                    automatic_tearing=true,
                    hand_guided_tearing=true,
                    name="Unpaired_EnabledError2",
                    description="Test hand guided tearing errors",
                    errorMessage="
6 errors found:

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8464, column 56:
  Cannot find class or component declaration for unknownParameter1

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8468, column 56:
  Cannot find class or component declaration for unknownParameter2

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8471, column 59:
  Cannot evaluate boolean enabled expression: unknownParameter3

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8471, column 59:
  Cannot find class or component declaration for unknownParameter3
")})));
        end EnabledError2;

        model EnabledError3
            constant Integer n = 4;
            Real x[n] annotation(__Modelon(IterationVariable(enabled={true, false})));
            Real y[n];
        equation
            x = y .+ 3 annotation(__Modelon(ResidualEquation));
            x .* y = fill(4, n);

        annotation(__JModelica(UnitTesting(tests={
            ErrorTestCase(
                name="Unpaired_EnabledError3",
                description="Test of hand guided tearing error when enable flag have incorrect dimensions",
                equation_sorting=true,
                hand_guided_tearing=true,
                automatic_tearing=false,
                errorMessage="
1 errors found:

Error: in file '...':
Semantic error at line 0, column 0:
  Array size mismatch for the enabled attribute, size of component declaration is [4] and size of expression is [2]
")})));

        end EnabledError3;

        model EnabledError4
            Real x annotation(__Modelon(IterationVariable(enabled={true, false})));
            Real y;
        equation
            x = y + 3 annotation(__Modelon(ResidualEquation));
            x * y = 4;

        annotation(__JModelica(UnitTesting(tests={
            ErrorTestCase(
                name="Unpaired_EnabledError4",
                description="Test of hand guided tearing error when enable flag have incorrect dimensions",
                equation_sorting=true,
                hand_guided_tearing=true,
                automatic_tearing=false,
                errorMessage="
1 errors found:

Error: in file '...':
Semantic error at line 0, column 0:
  Array size mismatch for the enabled attribute, size of component declaration is scalar and size of expression is [2]
")})));

        end EnabledError4;

        model EnabledError5
            Real x annotation(__Modelon(IterationVariable(each enabled=true)));
            Real y;
        equation
            x = y + 3 annotation(__Modelon(ResidualEquation));
            x * y = 4;

        annotation(__JModelica(UnitTesting(tests={
            ErrorTestCase(
                name="Unpaired_EnabledError5",
                description="Test of hand guided tearing error when enable flag have keyword each",
                equation_sorting=true,
                hand_guided_tearing=true,
                automatic_tearing=false,
                errorMessage="
1 errors found:

Error: in file '...':
Semantic error at line 0, column 0:
  The 'each' keyword cannot be applied to attributes of scalar components
")})));

        end EnabledError5;

        model EnabledError6
            constant Integer n = 4;
            Real x[n] annotation(__Modelon(IterationVariable(each enabled=fill(true,n))));
            Real y[n];
        equation
            x = y .+ 3 annotation(__Modelon(ResidualEquation));
            x .* y = fill(4, n);

        annotation(__JModelica(UnitTesting(tests={
            ErrorTestCase(
                name="Unpaired_EnabledError6",
                description="Test of hand guided tearing error when enable flag have each keyword incorrectly",
                equation_sorting=true,
                hand_guided_tearing=true,
                automatic_tearing=false,
                errorMessage="
1 errors found:

Error: in file '...':
Semantic error at line 0, column 0:
  The enabled attribute is declared 'each' and the expression is not scalar
")})));

        end EnabledError6;

        model EnabledWarning1
            constant Integer n = 4;
            Real x[n] annotation(__Modelon(IterationVariable(enabled=true)));
            Real y[n];
        equation
            x = y .+ 3 annotation(__Modelon(ResidualEquation));
            x .* y = fill(4, n);

        annotation(
            __JModelica(UnitTesting(tests={
                WarningTestCase(
                    equation_sorting=true,
                    automatic_tearing=true,
                    hand_guided_tearing=true,
                    name="Unpaired_EnabledWarning1",
                    description="Test hand guided tearing warnings",
                    errorMessage="
1 warnings found:

Warning: in file '...':
At line 0, column 0:
  Assuming 'each' for enabled expression
")})));
        end EnabledWarning1;

        model Error1
            Real u0,u1,u2,u3,uL;
            Real i0,i1,iL;
            Real i2 annotation(__Modelon(IterationVariable));
            Real i3 annotation(__Modelon(IterationVariable));
            parameter Real R1 = 1;
            parameter Real R2 = 1;
            parameter Real R3 = 1;
            parameter Real L = 1;
        equation
            u0 = sin(time);
            u1 = R1*i1 annotation(__Modelon(ResidualEquation));
            u2 = R2*i2;
            u3 = R3*i3;
            uL = L*der(iL);
            u0 = u1 + u3;
            uL = u1 + u2;
            u2 = u3;
            i0 = i1 + iL;
            i1 = i2 + i3;

        annotation(__JModelica(UnitTesting(tests={
            ErrorTestCase(
                name="Unpaired_Error1",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                description="Test of hand guided tearing with annotation on two iteration variables and only one equation, should give error.",
                errorMessage="
1 errors found:

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 0, column 0:
  Unable to apply hand-guided tearing selections on block 2. The number of unmatched hand guided equations and variables are not equal.
  Unmatched hand guided equations(1):
    u1 = R1 * i1

  Unmatched hand guided variables(2):
    i3
    i2
")})));
        end Error1;

        model Error2
            Real x;
            Real y;
            Real z;
        equation
            x=y + 1;
            y=z + 2 annotation(__Modelon(name=res));
            z=x - 3 annotation(__Modelon(ResidualEquation(iterationVariable=1)));
            annotation(
                __Modelon(tearingPairs(
                    Pair(iterationVariable=2, residualEquation=3)
                )),
                __JModelica(UnitTesting(tests={
                ErrorTestCase(
                    equation_sorting=true,
                    automatic_tearing=true,
                    hand_guided_tearing=true,
                    name="Unpaired_Error2",
                    description="Test hand guided tearing errors",
                    errorMessage="
3 errors found:

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8504, column 66:
  Expression \"1\" is not a legal iteration variable reference

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8507, column 26:
  Expression \"2\" is not a legal iteration variable reference

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8507, column 46:
  Expression \"3\" is not a legal residual equation reference
")})));
        end Error2;

    end Unpaired;
    
    package Paired
        
        model Simple1
            Real u0,u1,u2,u3,uL;
            Real i0,i1,i2,i3,iL;
            parameter Real R1 = 1;
            parameter Real R2 = 1;
            parameter Real R3 = 1;
            parameter Real L = 1;
        equation
            u0 = sin(time);
            u1 = R1*i1 annotation(__Modelon(ResidualEquation(iterationVariable=i3)));
            u2 = R2*i2;
            u3 = R3*i3;
            uL = L*der(iL);
            u0 = u1 + u3;
            uL = u1 + u2;
            u2 = u3;
            i0 = i1 + iL;
            i1 = i2 + i3;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="Paired_Simple1",
                description="Simple test of matched hand guided tearing",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                methodName="printDAEBLT",
                methodResult="
-------------------------------
Solved block of 1 variables:
Computed variable:
  u0
Solution:
  sin(time)
-------------------------------
Torn linear block of 2 iteration variables and 3 solved variables:
Coefficient variability: Parameter
Solved variables:
  u2
  u1
  i1
Iteration variables:
  i3
  i2
Solved equations:
  u2 = R3 * i3
  u0 = u1 + u2
  i1 = i2 + i3
Residual equations:
 Iteration variables: i3
  u1 = R1 * i1
 Iteration variables: i2
  u2 = R2 * i2
Jacobian:
  |1.0, 0.0, 0.0, (- R3), 0.0|
  |- 1.0, - 1.0, 0.0, 0.0, 0.0|
  |0.0, 0.0, 1.0, - 1.0, - 1.0|
  |0.0, 1.0, (- R1), 0.0, 0.0|
  |1.0, 0.0, 0.0, 0.0, (- R2)|
-------------------------------
Solved block of 1 variables:
Computed variable:
  uL
Solution:
  u1 + u2
-------------------------------
Solved block of 1 variables:
Computed variable:
  der(iL)
Solution:
  (- uL) / (- L)
-------------------------------
Solved block of 1 variables:
Computed variable:
  i0
Solution:
  i1 + iL
-------------------------------
")})));
        end Simple1;
        
        model Simple2
            Real u0,u1,u2,u3,uL;
            Real i0,i1,i2,i3,iL;
            parameter Real R1 = 1;
            parameter Real R2 = 1;
            parameter Real R3 = 1;
            parameter Real L = 1;
        equation
            u0 = sin(time);
            u1 = R1*i1;
            u2 = R2*i2;
            u3 = R3*i3;
            uL = L*der(iL);
            u0 = u1 + u3 annotation(__Modelon(ResidualEquation(iterationVariable=i2)));
            uL = u1 + u2;
            u2 = u3;
            i0 = i1 + iL;
            i1 = i2 + i3 annotation(__Modelon(ResidualEquation(iterationVariable=i1)));

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="Paired_Simple2",
                description="Simple test of matched hand guided tearing, two residual equations",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                methodName="printDAEBLT",
                methodResult="
-------------------------------
Solved block of 1 variables:
Computed variable:
  u0
Solution:
  sin(time)
-------------------------------
Torn linear block of 3 iteration variables and 2 solved variables:
Coefficient variability: Parameter
Solved variables:
  u2
  u1
Iteration variables:
  i1
  i2
  i3
Solved equations:
  u2 = R2 * i2
  u1 = R1 * i1
Residual equations:
 Iteration variables: i1
  i1 = i2 + i3
 Iteration variables: i2
  u0 = u1 + u2
 Iteration variables: i3
  u2 = R3 * i3
Jacobian:
  |1.0, 0.0, 0.0, (- R2), 0.0|
  |0.0, 1.0, (- R1), 0.0, 0.0|
  |0.0, 0.0, 1.0, - 1.0, - 1.0|
  |- 1.0, - 1.0, 0.0, 0.0, 0.0|
  |1.0, 0.0, 0.0, 0.0, (- R3)|
-------------------------------
Solved block of 1 variables:
Computed variable:
  uL
Solution:
  u1 + u2
-------------------------------
Solved block of 1 variables:
Computed variable:
  der(iL)
Solution:
  (- uL) / (- L)
-------------------------------
Solved block of 1 variables:
Computed variable:
  i0
Solution:
  i1 + iL
-------------------------------
")})));
        end Simple2;
        
        model Simple3
            Real u0,u1,u2,u3,uL;
            Real i0,i1,i2,i3,iL;
            parameter Real R1 = 1;
            parameter Real R2 = 1;
            parameter Real R3 = 1;
            parameter Real L = 1;
        equation
            u0 = sin(time);
            u1 = R1*i1;
            u2 = R2*i2;
            u3 = R3*i3;
            uL = L*der(iL);
            u0 = u1 + u3 annotation(__Modelon(ResidualEquation(iterationVariable=i2)));
            uL = u1 + u2;
            u2 = u3;
            i0 = i1 + iL;
            i1 = i2 + i3 annotation(__Modelon(ResidualEquation(iterationVariable=i3)));

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="Paired_Simple3",
                description="Simple test of matched hand guided tearing, two residual equations",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                methodName="printDAEBLT",
                methodResult="
-------------------------------
Solved block of 1 variables:
Computed variable:
  u0
Solution:
  sin(time)
-------------------------------
Torn linear block of 3 iteration variables and 2 solved variables:
Coefficient variability: Parameter
Solved variables:
  u2
  u1
Iteration variables:
  i3
  i2
  i1
Solved equations:
  u2 = R3 * i3
  u1 = R1 * i1
Residual equations:
 Iteration variables: i3
  i1 = i2 + i3
 Iteration variables: i2
  u0 = u1 + u2
 Iteration variables: i1
  u2 = R2 * i2
Jacobian:
  |1.0, 0.0, (- R3), 0.0, 0.0|
  |0.0, 1.0, 0.0, 0.0, (- R1)|
  |0.0, 0.0, - 1.0, - 1.0, 1.0|
  |- 1.0, - 1.0, 0.0, 0.0, 0.0|
  |1.0, 0.0, 0.0, (- R2), 0.0|
-------------------------------
Solved block of 1 variables:
Computed variable:
  uL
Solution:
  u1 + u2
-------------------------------
Solved block of 1 variables:
Computed variable:
  der(iL)
Solution:
  (- uL) / (- L)
-------------------------------
Solved block of 1 variables:
Computed variable:
  i0
Solution:
  i1 + iL
-------------------------------
")})));
        end Simple3;
        
        model VectorizedBaseline
            
            parameter Integer n = 5;
            Real a[n];
            Real b[n];
            Real c[n];
            
        equation
            for i in 1:n loop
                a[i]=c[i] + 1;
                a[i]=b[i] + 2;
                c[i]=b[i] - 3;
            end for;
        
        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="Paired_VectorizedBaseline",
                description="Test of hand guided tearing of vectors and indices whit no annotation, base case.",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                methodName="printDAEBLT",
                methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  c[1]
  a[1]
Iteration variables:
  b[1]
Solved equations:
  c[1] = b[1] - 3
  a[1] = c[1] + 1
Residual equations:
 Iteration variables: b[1]
  a[1] = b[1] + 2
Jacobian:
  |1.0, 0.0, - 1.0|
  |- 1.0, 1.0, 0.0|
  |0.0, 1.0, - 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  c[2]
  a[2]
Iteration variables:
  b[2]
Solved equations:
  c[2] = b[2] - 3
  a[2] = c[2] + 1
Residual equations:
 Iteration variables: b[2]
  a[2] = b[2] + 2
Jacobian:
  |1.0, 0.0, - 1.0|
  |- 1.0, 1.0, 0.0|
  |0.0, 1.0, - 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  c[3]
  a[3]
Iteration variables:
  b[3]
Solved equations:
  c[3] = b[3] - 3
  a[3] = c[3] + 1
Residual equations:
 Iteration variables: b[3]
  a[3] = b[3] + 2
Jacobian:
  |1.0, 0.0, - 1.0|
  |- 1.0, 1.0, 0.0|
  |0.0, 1.0, - 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  c[4]
  a[4]
Iteration variables:
  b[4]
Solved equations:
  c[4] = b[4] - 3
  a[4] = c[4] + 1
Residual equations:
 Iteration variables: b[4]
  a[4] = b[4] + 2
Jacobian:
  |1.0, 0.0, - 1.0|
  |- 1.0, 1.0, 0.0|
  |0.0, 1.0, - 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  c[5]
  a[5]
Iteration variables:
  b[5]
Solved equations:
  c[5] = b[5] - 3
  a[5] = c[5] + 1
Residual equations:
 Iteration variables: b[5]
  a[5] = b[5] + 2
Jacobian:
  |1.0, 0.0, - 1.0|
  |- 1.0, 1.0, 0.0|
  |0.0, 1.0, - 1.0|
-------------------------------
")})));
        end VectorizedBaseline;
        
        model Vectorized1
        
            parameter Integer n = 5;
            Real a[n];
            Real b[n];
            Real c[n];
        
        equation
            for i in 1:n loop
                a[i]=c[i] + 1;
                a[i]=b[i] + 2;
                c[i]=b[i] - 3 annotation(__Modelon(ResidualEquation(enabled=true,iterationVariable=c[i])));
            end for;
        
        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="Paired_Vectorized1",
                description="Test of hand guided tearing of vectors and indices with hand guided annotation.",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                methodName="printDAEBLT",
                methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[1]
  b[1]
Iteration variables:
  c[1]
Solved equations:
  a[1] = c[1] + 1
  a[1] = b[1] + 2
Residual equations:
 Iteration variables: c[1]
  c[1] = b[1] - 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[2]
  b[2]
Iteration variables:
  c[2]
Solved equations:
  a[2] = c[2] + 1
  a[2] = b[2] + 2
Residual equations:
 Iteration variables: c[2]
  c[2] = b[2] - 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[3]
  b[3]
Iteration variables:
  c[3]
Solved equations:
  a[3] = c[3] + 1
  a[3] = b[3] + 2
Residual equations:
 Iteration variables: c[3]
  c[3] = b[3] - 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[4]
  b[4]
Iteration variables:
  c[4]
Solved equations:
  a[4] = c[4] + 1
  a[4] = b[4] + 2
Residual equations:
 Iteration variables: c[4]
  c[4] = b[4] - 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[5]
  b[5]
Iteration variables:
  c[5]
Solved equations:
  a[5] = c[5] + 1
  a[5] = b[5] + 2
Residual equations:
 Iteration variables: c[5]
  c[5] = b[5] - 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
")})));
        end Vectorized1;
        
        model Vectorized2
        
            parameter Integer n = 5;
            Real a[n];
            Real b[n];
            Real c[n];
        
        equation
            for i in 1:n loop
                a[i]=c[i] + 1;
                a[i]=b[i] + 2;
                c[i]=b[i] - 3 annotation(__Modelon(ResidualEquation(enabled=true,iterationVariable=c[i])));
            end for;
        
        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="Paired_Vectorized2",
                description="Test of hand guided tearing of vectors and indices with handguided annotation and blt merge.",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                merge_blt_blocks=true,
                methodName="printDAEBLT",
                methodResult="
-------------------------------
Torn linear block of 5 iteration variables and 10 solved variables:
Coefficient variability: Constant
Solved variables:
  a[1]
  b[1]
  a[2]
  b[2]
  a[3]
  b[3]
  a[4]
  b[4]
  a[5]
  b[5]
Iteration variables:
  c[1]
  c[2]
  c[3]
  c[4]
  c[5]
Solved equations:
  a[1] = c[1] + 1
  a[1] = b[1] + 2
  a[2] = c[2] + 1
  a[2] = b[2] + 2
  a[3] = c[3] + 1
  a[3] = b[3] + 2
  a[4] = c[4] + 1
  a[4] = b[4] + 2
  a[5] = c[5] + 1
  a[5] = b[5] + 2
Residual equations:
 Iteration variables: c[1]
  c[1] = b[1] - 3
 Iteration variables: c[2]
  c[2] = b[2] - 3
 Iteration variables: c[3]
  c[3] = b[3] - 3
 Iteration variables: c[4]
  c[4] = b[4] - 3
 Iteration variables: c[5]
  c[5] = b[5] - 3
Jacobian:
  |1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, - 1.0, 0.0, 0.0, 0.0, 0.0|
  |1.0, - 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0|
  |0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, - 1.0, 0.0, 0.0, 0.0|
  |0.0, 0.0, 1.0, - 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0|
  |0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, - 1.0, 0.0, 0.0|
  |0.0, 0.0, 0.0, 0.0, 1.0, - 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0|
  |0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, - 1.0, 0.0|
  |0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, - 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0|
  |0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, - 1.0|
  |0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, - 1.0, 0.0, 0.0, 0.0, 0.0, 0.0|
  |0.0, - 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0|
  |0.0, 0.0, 0.0, - 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0|
  |0.0, 0.0, 0.0, 0.0, 0.0, - 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0|
  |0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, - 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0|
  |0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, - 1.0, 0.0, 0.0, 0.0, 0.0, 1.0|
-------------------------------
")})));
end Vectorized2;

        model VectorizedEnabled1
        
            parameter Integer n = 5;
            Real a[n];
            Real b[n];
            Real c[n];
        
        equation
            a=c .+ 1;
            a=b .+ 2;
            c=b .- 3 annotation(__Modelon(ResidualEquation(each enabled=true,iterationVariable=c)));
        
        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="Paired_VectorizedEnabled1",
                description="Test of hand guided tearing of vectors and indices with hand guided annotation.",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                methodName="printDAEBLT",
                methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[1]
  b[1]
Iteration variables:
  c[1]
Solved equations:
  a[1] = c[1] .+ 1
  a[1] = b[1] .+ 2
Residual equations:
 Iteration variables: c[1]
  c[1] = b[1] .- 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[2]
  b[2]
Iteration variables:
  c[2]
Solved equations:
  a[2] = c[2] .+ 1
  a[2] = b[2] .+ 2
Residual equations:
 Iteration variables: c[2]
  c[2] = b[2] .- 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[3]
  b[3]
Iteration variables:
  c[3]
Solved equations:
  a[3] = c[3] .+ 1
  a[3] = b[3] .+ 2
Residual equations:
 Iteration variables: c[3]
  c[3] = b[3] .- 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[4]
  b[4]
Iteration variables:
  c[4]
Solved equations:
  a[4] = c[4] .+ 1
  a[4] = b[4] .+ 2
Residual equations:
 Iteration variables: c[4]
  c[4] = b[4] .- 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[5]
  b[5]
Iteration variables:
  c[5]
Solved equations:
  a[5] = c[5] .+ 1
  a[5] = b[5] .+ 2
Residual equations:
 Iteration variables: c[5]
  c[5] = b[5] .- 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
")})));
        end VectorizedEnabled1;
        
        model Enabled1
            constant Integer n = 4;
            Real x[n];
            Real y[n];
        equation
            x = y .+ 3 annotation(__Modelon(ResidualEquation(iterationVariable = x, each enabled = true)));
            x .+ y = fill(4, n);
        annotation(
            __JModelica(UnitTesting(tests={
                FClassMethodTestCase(
                    name="Paired_Enabled1",
                    description="Test of hand guided tearing with each on enabled attribute for interation variable.",
                    equation_sorting=true,
                    automatic_tearing=true,
                    hand_guided_tearing=true,
                    methodName="printDAEBLT",
                    methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[1]
Iteration variables:
  x[1]
Solved equations:
  x[1] .+ y[1] = 4
Residual equations:
 Iteration variables: x[1]
  x[1] = y[1] .+ 3
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[2]
Iteration variables:
  x[2]
Solved equations:
  x[2] .+ y[2] = 4
Residual equations:
 Iteration variables: x[2]
  x[2] = y[2] .+ 3
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[3]
Iteration variables:
  x[3]
Solved equations:
  x[3] .+ y[3] = 4
Residual equations:
 Iteration variables: x[3]
  x[3] = y[3] .+ 3
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[4]
Iteration variables:
  x[4]
Solved equations:
  x[4] .+ y[4] = 4
Residual equations:
 Iteration variables: x[4]
  x[4] = y[4] .+ 3
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
")})));
        end Enabled1;
        
        model Enabled2
            constant Integer n = 4;
            Real x[n];
            Real y[n];
        equation
            x = y .+ 3 annotation(__Modelon(ResidualEquation(iterationVariable = x, enabled = fill(true, n))));
            x .+ y = fill(4, n);
        annotation(
            __JModelica(UnitTesting(tests={
                FClassMethodTestCase(
                    name="Paired_Enabled2",
                    description="Test of hand guided tearing with vectorized enabled attribute for interation variable.",
                    equation_sorting=true,
                    automatic_tearing=true,
                    hand_guided_tearing=true,
                    methodName="printDAEBLT",
                    methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[1]
Iteration variables:
  x[1]
Solved equations:
  x[1] .+ y[1] = 4
Residual equations:
 Iteration variables: x[1]
  x[1] = y[1] .+ 3
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[2]
Iteration variables:
  x[2]
Solved equations:
  x[2] .+ y[2] = 4
Residual equations:
 Iteration variables: x[2]
  x[2] = y[2] .+ 3
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[3]
Iteration variables:
  x[3]
Solved equations:
  x[3] .+ y[3] = 4
Residual equations:
 Iteration variables: x[3]
  x[3] = y[3] .+ 3
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[4]
Iteration variables:
  x[4]
Solved equations:
  x[4] .+ y[4] = 4
Residual equations:
 Iteration variables: x[4]
  x[4] = y[4] .+ 3
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
")})));
        end Enabled2;
        
        model Enabled3
            constant Integer n = 2;
            Real x[n];
            Real y[n];
        equation
            x = y .+ 3 annotation(__Modelon(ResidualEquation(iterationVariable = x, enabled = if n == 2 then {true,false} else fill(true, n))));
            x .+ y = fill(4, n) annotation(__Modelon(ResidualEquation(iterationVariable = x, enabled = if n == 2 then {false,true} else fill(false, n))));
        annotation(
            __JModelica(UnitTesting(tests={
                FClassMethodTestCase(
                    name="Paired_Enabled3",
                    description="Test of hand guided tearing with vectorized enabled attribute for residual equation.",
                    equation_sorting=true,
                    automatic_tearing=true,
                    hand_guided_tearing=true,
                    methodName="printDAEBLT",
                    methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[1]
Iteration variables:
  x[1]
Solved equations:
  x[1] .+ y[1] = 4
Residual equations:
 Iteration variables: x[1]
  x[1] = y[1] .+ 3
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y[2]
Iteration variables:
  x[2]
Solved equations:
  x[2] = y[2] .+ 3
Residual equations:
 Iteration variables: x[2]
  x[2] .+ y[2] = 4
Jacobian:
  |- 1.0, 1.0|
  |1.0, 1.0|
-------------------------------
")})));
        end Enabled3;
        
        model EnabledError1
            constant Integer n = 4;
            Real x[n];
            Real y[n];
        equation
            x = y .+ 3 annotation(__Modelon(ResidualEquation(iterationVariable = x, enabled = {false,true})));
            x .* y = fill(4, n);
        
        annotation(__JModelica(UnitTesting(tests={
            ErrorTestCase(
                name="Paired_EnabledError1",
                description="Test of hand guided tearing error when enable flag have incorrect dimensions",
                equation_sorting=true,
                hand_guided_tearing=true,
                automatic_tearing=false,
                errorMessage="
1 errors found:

Error: in file '...':
Semantic error at line 0, column 0:
  Array size mismatch for the enabled attribute, size of component declaration is [4] and size of expression is [2]
")})));
            
        end EnabledError1;
        
        model EnabledError2
            Real x;
            Real y;
        equation
            x = y + 3 annotation(__Modelon(ResidualEquation(iterationVariable = x, enabled = {false,true})));
            x * y = 4;
            
        annotation(__JModelica(UnitTesting(tests={
            ErrorTestCase(
                name="Paired_EnabledError2",
                description="Test of hand guided tearing error when enable flag have incorrect dimensions",
                equation_sorting=true,
                hand_guided_tearing=true,
                automatic_tearing=false,
                errorMessage="
1 errors found:

Error: in file '...':
Semantic error at line 0, column 0:
  Array size mismatch for the enabled attribute, size of component declaration is scalar and size of expression is [2]
")})));
            
        end EnabledError2;
        
        model EnabledError3
            Real x;
            Real y;
        equation
            x = y + 3 annotation(__Modelon(ResidualEquation(iterationVariable = x, each enabled = true)));
            x * y = 4;
        
        annotation(__JModelica(UnitTesting(tests={
            ErrorTestCase(
                name="Paired_EnabledError3",
                description="Test of hand guided tearing error when enable flag have keyword each",
                equation_sorting=true,
                hand_guided_tearing=true,
                automatic_tearing=false,
                errorMessage="
1 errors found:

Error: in file '...':
Semantic error at line 0, column 0:
  The 'each' keyword cannot be applied to attributes of scalar components
")})));
            
        end EnabledError3;
        
        model EnabledError4
            constant Integer n = 4;
            Real x[n];
            Real y[n];
        equation
            x = y .+ 3 annotation(__Modelon(ResidualEquation(iterationVariable = x, each enabled = fill(true,n))));
            x .* y = fill(4, n);
        
        annotation(__JModelica(UnitTesting(tests={
            ErrorTestCase(
                name="Paired_EnabledError4",
                description="Test of hand guided tearing error when enable flag have each keyword incorrectly",
                equation_sorting=true,
                hand_guided_tearing=true,
                automatic_tearing=false,
                errorMessage="
1 errors found:

Error: in file '...':
Semantic error at line 0, column 0:
  The enabled attribute is declared 'each' and the expression is not scalar
")})));
            
        end EnabledError4;
        
        model EnabledWarning1
            constant Integer n = 4;
            Real x[n];
            Real y[n];
        equation
            x = y .+ 3 annotation(__Modelon(ResidualEquation(iterationVariable = x, enabled = true)));
            x .* y = fill(4, n);
        
        annotation(
        __JModelica(UnitTesting(tests={
            WarningTestCase(
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                name="Paired_EnabledWarning1",
                description="Test hand guided tearing warnings",
                errorMessage="
1 warnings found:

Warning: in file '...':
At line 0, column 0:
  Assuming 'each' for enabled expression
")})));
        end EnabledWarning1;
        
        model Alias1
            Real x[2](each start=1), y[2](each start=2), z[2];
        equation
            x = -y;
            y = z .+ 1 annotation(__Modelon(ResidualEquation(iterationVariable=y)));
            z = x .- 1;
        annotation(
            __JModelica(UnitTesting(tests={
                FClassMethodTestCase(
                    name="Paired_Alias1",
                    description="Test of hand guided tearing and alias elimination.",
                    equation_sorting=true,
                    automatic_tearing=true,
                    hand_guided_tearing=true,
                    methodName="printDAEBLT",
                    methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  z[1]
Iteration variables:
  y[1]
Solved equations:
  z[1] = - y[1] .- 1
Residual equations:
 Iteration variables: y[1]
  y[1] = z[1] .+ 1
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  z[2]
Iteration variables:
  y[2]
Solved equations:
  z[2] = - y[2] .- 1
Residual equations:
 Iteration variables: y[2]
  y[2] = z[2] .+ 1
Jacobian:
  |1.0, 1.0|
  |- 1.0, 1.0|
-------------------------------
")})));
        end Alias1;
    
    end Paired;
    
    package SystemPairs
        
        model Simple1
            model A
                Real x;
                Real y;
            equation
                x = y + 1 annotation(__Modelon(name=eq));
            end A;
            
            model B
                Real x;
                Real y;
            equation
                x = y + 2;
            end B;
            
            A a;
            B b;
        equation
            a.x = b.y + 2;
            a.y = b.x - 3;
        annotation(__Modelon(tearingPairs={
            Pair(residualEquation=a.eq, iterationVariable=b.x)
        }),
        __JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="SystemPairs_Simple1",
                description="Test of hand guided tearing with pairs defined on system level.",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                merge_blt_blocks=true,
                methodName="printDAEBLT",
                methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 3 solved variables:
Coefficient variability: Constant
Solved variables:
  a.y
  b.y
  a.x
Iteration variables:
  b.x
Solved equations:
  a.y = b.x - 3
  b.x = b.y + 2
  a.x = b.y + 2
Residual equations:
 Iteration variables: b.x
  a.x = a.y + 1
Jacobian:
  |1.0, 0.0, 0.0, - 1.0|
  |0.0, - 1.0, 0.0, 1.0|
  |0.0, - 1.0, 1.0, 0.0|
  |- 1.0, 0.0, 1.0, 0.0|
-------------------------------
")})));
        end Simple1;
        
        model Simple2
            model C
                model A
                    Real x;
                    Real y;
                equation
                    x = y + 1 annotation(__Modelon(name=eq));
                end A;
                
                model B
                    Real x;
                    Real y;
                equation
                    x = y + 2;
                end B;
                
                A a;
                B b;
            equation
                a.x = b.y + 2;
                a.y = b.x - 3;
                annotation(__Modelon(tearingPairs={
                    Pair(residualEquation=a.eq, iterationVariable=b.x)
                }));
            end C;
            C c;
        
        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="SystemPairs_Simple2",
                description="Test of hand guided tearing with pairs defined on system level, but in sub class.",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                merge_blt_blocks=true,
                methodName="printDAEBLT",
                methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 3 solved variables:
Coefficient variability: Constant
Solved variables:
  c.a.y
  c.b.y
  c.a.x
Iteration variables:
  c.b.x
Solved equations:
  c.a.y = c.b.x - 3
  c.b.x = c.b.y + 2
  c.a.x = c.b.y + 2
Residual equations:
 Iteration variables: c.b.x
  c.a.x = c.a.y + 1
Jacobian:
  |1.0, 0.0, 0.0, - 1.0|
  |0.0, - 1.0, 0.0, 1.0|
  |0.0, - 1.0, 1.0, 0.0|
  |- 1.0, 0.0, 1.0, 0.0|
-------------------------------
")})));
        end Simple2;
        
        model Vectorized1
        
            parameter Integer n = 5;
            Real a[n];
            Real b[n];
            Real c[n];
        
        equation
            a=c .+ 1;
            a=b .+ 2;
            c=b .- 3 annotation(__Modelon(name=res));
        annotation(
        __Modelon(tearingPairs={Pair(residualEquation=res,iterationVariable=c)}),
        __JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="SystemPairs_Vectorized1",
                description="Test of hand guided tearing of vectors and indices with hand guided annotation.",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                methodName="printDAEBLT",
                methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[1]
  b[1]
Iteration variables:
  c[1]
Solved equations:
  a[1] = c[1] .+ 1
  a[1] = b[1] .+ 2
Residual equations:
 Iteration variables: c[1]
  c[1] = b[1] .- 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[2]
  b[2]
Iteration variables:
  c[2]
Solved equations:
  a[2] = c[2] .+ 1
  a[2] = b[2] .+ 2
Residual equations:
 Iteration variables: c[2]
  c[2] = b[2] .- 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[3]
  b[3]
Iteration variables:
  c[3]
Solved equations:
  a[3] = c[3] .+ 1
  a[3] = b[3] .+ 2
Residual equations:
 Iteration variables: c[3]
  c[3] = b[3] .- 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[4]
  b[4]
Iteration variables:
  c[4]
Solved equations:
  a[4] = c[4] .+ 1
  a[4] = b[4] .+ 2
Residual equations:
 Iteration variables: c[4]
  c[4] = b[4] .- 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[5]
  b[5]
Iteration variables:
  c[5]
Solved equations:
  a[5] = c[5] .+ 1
  a[5] = b[5] .+ 2
Residual equations:
 Iteration variables: c[5]
  c[5] = b[5] .- 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
")})));
        end Vectorized1;
        
        model Vectorized2
            parameter Integer n = 5;
            Real a[n];
            Real b[n];
            Real c[n];
        equation
            a=c .+ 1;
            a=b .+ 2;
            c=b .- 3 annotation(__Modelon(name=res));
        annotation(
        __Modelon(tearingPairs={
            Pair(residualEquation=res[1],iterationVariable=c[1]),
            Pair(residualEquation=res[2:3],iterationVariable=b[2:3]),
            Pair(residualEquation=res[4:5],iterationVariable=a[4:5])
        }),
        __JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="SystemPairs_Vectorized2",
                description="Test of hand guided tearing of vectors and indices with hand guided annotation.",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                methodName="printDAEBLT",
                methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[1]
  b[1]
Iteration variables:
  c[1]
Solved equations:
  a[1] = c[1] .+ 1
  a[1] = b[1] .+ 2
Residual equations:
 Iteration variables: c[1]
  c[1] = b[1] .- 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[2]
  c[2]
Iteration variables:
  b[2]
Solved equations:
  a[2] = b[2] .+ 2
  a[2] = c[2] .+ 1
Residual equations:
 Iteration variables: b[2]
  c[2] = b[2] .- 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, 1.0, - 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[3]
  c[3]
Iteration variables:
  b[3]
Solved equations:
  a[3] = b[3] .+ 2
  a[3] = c[3] .+ 1
Residual equations:
 Iteration variables: b[3]
  c[3] = b[3] .- 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, 1.0, - 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  b[4]
  c[4]
Iteration variables:
  a[4]
Solved equations:
  a[4] = b[4] .+ 2
  a[4] = c[4] .+ 1
Residual equations:
 Iteration variables: a[4]
  c[4] = b[4] .- 3
Jacobian:
  |- 1.0, 0.0, 1.0|
  |0.0, - 1.0, 1.0|
  |- 1.0, 1.0, 0.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  b[5]
  c[5]
Iteration variables:
  a[5]
Solved equations:
  a[5] = b[5] .+ 2
  a[5] = c[5] .+ 1
Residual equations:
 Iteration variables: a[5]
  c[5] = b[5] .- 3
Jacobian:
  |- 1.0, 0.0, 1.0|
  |0.0, - 1.0, 1.0|
  |- 1.0, 1.0, 0.0|
-------------------------------
")})));
    end Vectorized2;
    
    model Vectorized3
    
        parameter Integer n = 5;
        Real a[n];
        Real b[n];
        Real c[n];
    
    equation
        for i in 1:n loop
            a[i]=c[i] + 1;
            a[i]=b[i] + 2;
            c[i]=b[i] - 3 annotation(__Modelon(name=res));
        end for;
        
    annotation(
    __Modelon(tearingPairs={
        Pair(residualEquation=res[1],iterationVariable=c[1]),
        Pair(residualEquation=res[2:3],iterationVariable=b[2:3]),
        Pair(residualEquation=res[4:5],iterationVariable=a[4:5])
    }),
    __JModelica(UnitTesting(tests={
        FClassMethodTestCase(
            name="SystemPairs_Vectorized3",
            description="Test of hand guided tearing of vectors and indices with hand guided annotation.",
            equation_sorting=true,
            automatic_tearing=true,
            hand_guided_tearing=true,
            methodName="printDAEBLT",
            methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[1]
  b[1]
Iteration variables:
  c[1]
Solved equations:
  a[1] = c[1] + 1
  a[1] = b[1] + 2
Residual equations:
 Iteration variables: c[1]
  c[1] = b[1] - 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[2]
  c[2]
Iteration variables:
  b[2]
Solved equations:
  a[2] = b[2] + 2
  a[2] = c[2] + 1
Residual equations:
 Iteration variables: b[2]
  c[2] = b[2] - 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, 1.0, - 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a[3]
  c[3]
Iteration variables:
  b[3]
Solved equations:
  a[3] = b[3] + 2
  a[3] = c[3] + 1
Residual equations:
 Iteration variables: b[3]
  c[3] = b[3] - 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, 1.0, - 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  b[4]
  c[4]
Iteration variables:
  a[4]
Solved equations:
  a[4] = b[4] + 2
  a[4] = c[4] + 1
Residual equations:
 Iteration variables: a[4]
  c[4] = b[4] - 3
Jacobian:
  |- 1.0, 0.0, 1.0|
  |0.0, - 1.0, 1.0|
  |- 1.0, 1.0, 0.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  b[5]
  c[5]
Iteration variables:
  a[5]
Solved equations:
  a[5] = b[5] + 2
  a[5] = c[5] + 1
Residual equations:
 Iteration variables: a[5]
  c[5] = b[5] - 3
Jacobian:
  |- 1.0, 0.0, 1.0|
  |0.0, - 1.0, 1.0|
  |- 1.0, 1.0, 0.0|
-------------------------------
")})));
    end Vectorized3;
    
    model Vectorized4
        model A
            parameter Integer n = 5;
            Real a[n];
            Real b[n];
            Real c[n];
        
        equation
            for i in 1:n loop
                a[i]=c[i] + 1;
                a[i]=b[i] + 2;
                c[i]=b[i] - 3 annotation(__Modelon(name=res));
            end for;
        end A;
        
        A a;
        
    annotation(
    __Modelon(tearingPairs={
        Pair(residualEquation=a.res,iterationVariable=a.c)
    }),
    __JModelica(UnitTesting(tests={
        FClassMethodTestCase(
            name="SystemPairs_Vectorized4",
            description="Test of hand guided tearing of vectors and indices with hand guided annotation.",
            equation_sorting=true,
            automatic_tearing=true,
            hand_guided_tearing=true,
            methodName="printDAEBLT",
            methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a.a[1]
  a.b[1]
Iteration variables:
  a.c[1]
Solved equations:
  a.a[1] = a.c[1] + 1
  a.a[1] = a.b[1] + 2
Residual equations:
 Iteration variables: a.c[1]
  a.c[1] = a.b[1] - 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a.a[2]
  a.b[2]
Iteration variables:
  a.c[2]
Solved equations:
  a.a[2] = a.c[2] + 1
  a.a[2] = a.b[2] + 2
Residual equations:
 Iteration variables: a.c[2]
  a.c[2] = a.b[2] - 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a.a[3]
  a.b[3]
Iteration variables:
  a.c[3]
Solved equations:
  a.a[3] = a.c[3] + 1
  a.a[3] = a.b[3] + 2
Residual equations:
 Iteration variables: a.c[3]
  a.c[3] = a.b[3] - 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a.a[4]
  a.b[4]
Iteration variables:
  a.c[4]
Solved equations:
  a.a[4] = a.c[4] + 1
  a.a[4] = a.b[4] + 2
Residual equations:
 Iteration variables: a.c[4]
  a.c[4] = a.b[4] - 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a.a[5]
  a.b[5]
Iteration variables:
  a.c[5]
Solved equations:
  a.a[5] = a.c[5] + 1
  a.a[5] = a.b[5] + 2
Residual equations:
 Iteration variables: a.c[5]
  a.c[5] = a.b[5] - 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
")})));
    end Vectorized4;
    
    model Precedence1
        model C
            model A
                Real x;
                Real y;
            equation
                x = y + 1 annotation(__Modelon(name=eq));
                annotation(__Modelon(tearingPairs={
                    Pair(residualEquation=eq, iterationVariable=x)
                }));
            end A;
            
            model B
                Real x;
                Real y;
            equation
                x = y + 2;
            end B;
            
            A a;
            B b;
        equation
            a.x = b.y + 2;
            a.y = b.x - 3;
            annotation(__Modelon(tearingPairs={
                Pair(residualEquation=a.eq, iterationVariable=b.x)
            }));
        end C;
        C c;
    
    annotation(__JModelica(UnitTesting(tests={
        FClassMethodTestCase(
            name="SystemPairs_Precedence1",
            description="Test of hand guided tearing with pairs defined on system level and sub class.",
            equation_sorting=true,
            automatic_tearing=true,
            hand_guided_tearing=true,
            merge_blt_blocks=true,
            methodName="printDAEBLT",
            methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 3 solved variables:
Coefficient variability: Constant
Solved variables:
  c.a.y
  c.b.y
  c.a.x
Iteration variables:
  c.b.x
Solved equations:
  c.a.y = c.b.x - 3
  c.b.x = c.b.y + 2
  c.a.x = c.b.y + 2
Residual equations:
 Iteration variables: c.b.x
  c.a.x = c.a.y + 1
Jacobian:
  |1.0, 0.0, 0.0, - 1.0|
  |0.0, - 1.0, 0.0, 1.0|
  |0.0, - 1.0, 1.0, 0.0|
  |- 1.0, 0.0, 1.0, 0.0|
-------------------------------
")})));
        end Precedence1;
        
        model Precedence2
            model A
                B b;
            annotation(
            __Modelon(tearingPairs={
                Pair(residualEquation=b.res[1],iterationVariable=b.x[1]),
                Pair(residualEquation=b.res[2],iterationVariable=b.z[2])
            }));
            end A;
            model B
                parameter Integer n = 5;
                Real x[n];
                Real y[n];
                Real z[n];
            equation
                x=z .+ 1;
                x=y .+ 2;
                z=y .- 3 annotation(__Modelon(name=res));
            annotation(
            __Modelon(tearingPairs={
                Pair(residualEquation=res[1],iterationVariable=z[1]),
                Pair(residualEquation=res[2:3],iterationVariable=y[2:3])
            }));
            end B;
            A a;
        annotation(
        __Modelon(tearingPairs={
            Pair(residualEquation=a.b.res[1],iterationVariable=a.b.y[1]),
            Pair(residualEquation=a.b.res[4:5],iterationVariable=a.b.x[4:5])
        }),
        __JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="SystemPairs_Precedence2",
                description="Test of hand guided tearing of vectors and indices with hand guided annotation.",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                methodName="printDAEBLT",
                methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a.b.x[1]
  a.b.z[1]
Iteration variables:
  a.b.y[1]
Solved equations:
  a.b.x[1] = a.b.y[1] .+ 2
  a.b.x[1] = a.b.z[1] .+ 1
Residual equations:
 Iteration variables: a.b.y[1]
  a.b.z[1] = a.b.y[1] .- 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, 1.0, - 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a.b.x[2]
  a.b.y[2]
Iteration variables:
  a.b.z[2]
Solved equations:
  a.b.x[2] = a.b.z[2] .+ 1
  a.b.x[2] = a.b.y[2] .+ 2
Residual equations:
 Iteration variables: a.b.z[2]
  a.b.z[2] = a.b.y[2] .- 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, - 1.0, 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a.b.x[3]
  a.b.z[3]
Iteration variables:
  a.b.y[3]
Solved equations:
  a.b.x[3] = a.b.y[3] .+ 2
  a.b.x[3] = a.b.z[3] .+ 1
Residual equations:
 Iteration variables: a.b.y[3]
  a.b.z[3] = a.b.y[3] .- 3
Jacobian:
  |1.0, 0.0, - 1.0|
  |1.0, - 1.0, 0.0|
  |0.0, 1.0, - 1.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a.b.y[4]
  a.b.z[4]
Iteration variables:
  a.b.x[4]
Solved equations:
  a.b.x[4] = a.b.y[4] .+ 2
  a.b.x[4] = a.b.z[4] .+ 1
Residual equations:
 Iteration variables: a.b.x[4]
  a.b.z[4] = a.b.y[4] .- 3
Jacobian:
  |- 1.0, 0.0, 1.0|
  |0.0, - 1.0, 1.0|
  |- 1.0, 1.0, 0.0|
-------------------------------
Torn linear block of 1 iteration variables and 2 solved variables:
Coefficient variability: Constant
Solved variables:
  a.b.y[5]
  a.b.z[5]
Iteration variables:
  a.b.x[5]
Solved equations:
  a.b.x[5] = a.b.y[5] .+ 2
  a.b.x[5] = a.b.z[5] .+ 1
Residual equations:
 Iteration variables: a.b.x[5]
  a.b.z[5] = a.b.y[5] .- 3
Jacobian:
  |- 1.0, 0.0, 1.0|
  |0.0, - 1.0, 1.0|
  |- 1.0, 1.0, 0.0|
-------------------------------
")})));
        end Precedence2;
        
        model Enabled1
            model C
                model A
                    Real x;
                    Real y;
                equation
                    x = y + 1 annotation(__Modelon(name=eq));
                end A;
                
                model B
                    Real x;
                    Real y;
                equation
                    x = y + 2;
                end B;
                
                parameter Boolean useFirst = true;
                
                A a;
                B b;
            equation
                a.x = b.y + 2;
                a.y = b.x - 3;
                annotation(__Modelon(tearingPairs={
                    Pair(enabled=useFirst, residualEquation=a.eq, iterationVariable=b.x),
                    Pair(enabled=not useFirst, residualEquation=a.eq, iterationVariable=b.y)
                }));
            end C;
            C c;
        
        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="SystemPairs_Enabled1",
                description="Test of hand guided tearing with pairs defined on system level.",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                merge_blt_blocks=true,
                methodName="printDAEBLT",
                methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 3 solved variables:
Coefficient variability: Constant
Solved variables:
  c.a.y
  c.b.y
  c.a.x
Iteration variables:
  c.b.x
Solved equations:
  c.a.y = c.b.x - 3
  c.b.x = c.b.y + 2
  c.a.x = c.b.y + 2
Residual equations:
 Iteration variables: c.b.x
  c.a.x = c.a.y + 1
Jacobian:
  |1.0, 0.0, 0.0, - 1.0|
  |0.0, - 1.0, 0.0, 1.0|
  |0.0, - 1.0, 1.0, 0.0|
  |- 1.0, 0.0, 1.0, 0.0|
-------------------------------
")})));
        end Enabled1;
        
        model Enabled2
            model C
                model A
                    Real x;
                    Real y;
                equation
                    x = y + 1 annotation(__Modelon(name=eq));
                end A;
                
                model B
                    Real x;
                    Real y;
                equation
                    x = y + 2;
                end B;
                
                parameter Boolean useFirst = false;
                
                A a;
                B b;
            equation
                a.x = b.y + 2;
                a.y = b.x - 3;
                annotation(__Modelon(tearingPairs={
                    Pair(enabled=useFirst, residualEquation=a.eq, iterationVariable=b.x),
                    Pair(enabled=not useFirst, residualEquation=a.eq, iterationVariable=b.y)
                }));
            end C;
            C c;
        
        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="SystemPairs_Enabled2",
                description="Test of hand guided tearing with pairs defined on system level.",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                merge_blt_blocks=true,
                methodName="printDAEBLT",
                methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 3 solved variables:
Coefficient variability: Constant
Solved variables:
  c.b.x
  c.a.y
  c.a.x
Iteration variables:
  c.b.y
Solved equations:
  c.b.x = c.b.y + 2
  c.a.y = c.b.x - 3
  c.a.x = c.b.y + 2
Residual equations:
 Iteration variables: c.b.y
  c.a.x = c.a.y + 1
Jacobian:
  |1.0, 0.0, 0.0, - 1.0|
  |- 1.0, 1.0, 0.0, 0.0|
  |0.0, 0.0, 1.0, - 1.0|
  |0.0, - 1.0, 1.0, 0.0|
-------------------------------
")})));
        end Enabled2;
        
        model Extends1
            model B
                Real x, y;
            equation
                x = y + 1 annotation(__Modelon(name=res));
                y = x - 1;
            end B;
            extends B;
        annotation(
            __Modelon(tearingPairs={
                Pair(residualEquation=res, iterationVariable=x)
            }),
            __JModelica(UnitTesting(tests={
                FClassMethodTestCase(
                    name="SystemPairs_Extends1",
                    description="Test of hand guided tearing of vectors and indices with hand guided annotation.",
                    equation_sorting=true,
                    automatic_tearing=true,
                    hand_guided_tearing=true,
                    methodName="printDAEBLT",
                    methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 1 solved variables:
Coefficient variability: Constant
Solved variables:
  y
Iteration variables:
  x
Solved equations:
  y = x - 1
Residual equations:
 Iteration variables: x
  x = y + 1
Jacobian:
  |1.0, - 1.0|
  |- 1.0, 1.0|
-------------------------------
")})));
        end Extends1;
        
        model Extends2
            model A
                Real x;
                Real y;
            equation
                x = y + 1 annotation(__Modelon(name=eq));
            end A;
            
            model B
                Real x;
                Real y;
            equation
                x = y + 2;
            end B;
            
            model C
            
                A a;
                B b;
            equation
                a.x = b.y + 2;
                a.y = b.x - 3;
            annotation(__Modelon(tearingPairs={
                Pair(residualEquation=a.eq, iterationVariable=b.x)
            }));
            end C;
            extends C;
        
        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="SystemPairs_Extends2",
                description="Test of hand guided tearing with pairs defined on system level in an extended class.",
                automatic_tearing=false,
                hand_guided_tearing=true,
                methodName="printDAEBLT",
                methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 3 solved variables:
Coefficient variability: Constant
Solved variables:
  b.y
  a.y
  a.x
Iteration variables:
  b.x
Solved equations:
  b.x = b.y + 2
  a.y = b.x - 3
  a.x = b.y + 2
Residual equations:
 Iteration variables: b.x
  a.x = a.y + 1
Jacobian:
  |- 1.0, 0.0, 0.0, 1.0|
  |0.0, 1.0, 0.0, - 1.0|
  |- 1.0, 0.0, 1.0, 0.0|
  |0.0, - 1.0, 1.0, 0.0|
-------------------------------
")})));
        end Extends2;
        
        model Conditional1
            model A
                Real a;
                Real b;
                Real c;
            equation
                a=c + 1;
                a=b + 2;
                c=b - 3 annotation(__Modelon(name=res));
            annotation(__Modelon(tearingPairs={Pair(residualEquation=res,iterationVariable=c)}));
            end A;
            
            A a if 1 == 2;
        
        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="SystemPairs_Conditional1",
                description="Test of hand guided tearing with pairs defined on system level in an conditional false class.",
                automatic_tearing=false,
                hand_guided_tearing=true,
                methodName="printDAEBLT",
                methodResult="
-------------------------------
")})));
        end Conditional1;
        
        model Error1
            Real x;
            Real y;
            Real z;
        equation
            x=y + 1;
            y=z + 2 annotation(__Modelon(name=res));
            z=x - 3 annotation(__Modelon(ResidualEquation(iterationVariable=unknownVariable1)));
        annotation(
        __Modelon(tearingPairs(
            Pair(iterationVariable=unknownVariable2, residualEquation=unknownEquation)
        )),
        __JModelica(UnitTesting(tests={
            ErrorTestCase(
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                name="SystemPairs_Error1",
                description="Test hand guided tearing errors",
                errorMessage="
3 errors found:

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8532, column 66:
  Cannot find class or component declaration for unknownVariable1

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8535, column 26:
  Cannot find class or component declaration for unknownVariable2

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8535, column 61:
  Cannot find equation declaration for unknownEquation
")})));
        end Error1;
        
        model Error2
            parameter Real p1 = 1;
            parameter Real p2 = 2;
            Real x;
            Real y;
            Real z;
        equation
            x=y + 1;
            y=z + 2 annotation(__Modelon(name=res));
            z=x - 3 annotation(__Modelon(ResidualEquation(iterationVariable=p1)));
        annotation(
        __Modelon(tearingPairs(
            Pair(iterationVariable=p2, residualEquation=res)
        )),
        __JModelica(UnitTesting(tests={
            ErrorTestCase(
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                name="SystemPairs_Error2",
                description="Test hand guided tearing errors",
                errorMessage="
2 errors found:

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8566, column 2:
  Iteration variable should have continuous variability, p1 has parameter variability

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8569, column 26:
  Iteration variable should have continuous variability, p2 has parameter variability
")})));
        end Error2;
        
        model Error3
            Real x;
            Real y;
            Real z;
            Real v[2];
        equation
            v[1] = v[2] + 1;
            x=3 + v[2];
            x=y + 1;
            y=z + 2 annotation(__Modelon(name=res));
            z=x - 3 annotation(__Modelon(ResidualEquation(iterationVariable=v)));
        annotation(
        __Modelon(tearingPairs(
            Pair(iterationVariable=v, residualEquation=res)
        )),
        __JModelica(UnitTesting(tests={
            ErrorTestCase(
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                name="SystemPairs_Error3",
                description="Test hand guided tearing errors",
                errorMessage="
2 errors found:

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8597, column 2:
  Size of iteration variable v is not the same size as the surrounding equation, size of variable [2], size of equation scalar

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8599, column 24:
  Size of the iteration variable is not the same size as the size of the residual equation, size of variable [2], size of equation scalar
")})));
        end Error3;
        
        model Error4
            Real x[2];
            Real y[2];
            Real z[2];
            Real v;
        equation
            v = 1;
            x=y .+ 1;
            y=z .+ 2 annotation(__Modelon(name=res));
            z=x .- 3 annotation(__Modelon(ResidualEquation(iterationVariable=v)));
        annotation(
        __Modelon(tearingPairs(
            Pair(iterationVariable=v, residualEquation=res)
        )),
        __JModelica(UnitTesting(tests={
            ErrorTestCase(
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                name="SystemPairs_Error4",
                description="Test hand guided tearing errors",
                errorMessage="
2 errors found:

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8627, column 2:
  Size of iteration variable v is not the same size as the surrounding equation, size of variable scalar, size of equation [2]

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8629, column 24:
  Size of the iteration variable is not the same size as the size of the residual equation, size of variable scalar, size of equation [2]
")})));
        end Error4;
        
        model Error5
            Real x[2];
            Real y[2];
            Real z[2];
            Real v[2,2] = {{1,2},{3,4}};
        equation
            x=y .+ 1;
            y=z .+ 2 annotation(__Modelon(name=res));
            z=x .- 3 annotation(__Modelon(ResidualEquation(iterationVariable=v[3,:])));
        annotation(
        __Modelon(tearingPairs(
            Pair(iterationVariable=x[3], residualEquation=res[3])
        )),
        __JModelica(UnitTesting(tests={
            ErrorTestCase(
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                name="SystemPairs_Error5",
                description="Test hand guided tearing errors",
                errorMessage="
3 errors found:

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8705, column 69:
  Array index out of bounds: 3, index expression: 3

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8708, column 28:
  Array index out of bounds: 3, index expression: 3

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 8708, column 53:
  Array index out of bounds: 3, index expression: 3
")})));
        end Error5;

    end SystemPairs;
    
    package Mixed
    
        model Precedence1
            model C
                model A
                    Real x;
                    Real y;
                equation
                    x = y + 1 annotation(__Modelon(name=eq, ResidualEquation(iterationVariable=x)));
                end A;
                
                model B
                    Real x;
                    Real y;
                equation
                    x = y + 2;
                end B;
                
                A a;
                B b;
            equation
                a.x = b.y + 2;
                a.y = b.x - 3;
                annotation(__Modelon(tearingPairs={
                    Pair(residualEquation=a.eq, iterationVariable=b.x)
                }));
            end C;
            C c;
        
        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="Mixed_Precedence1",
                description="Test of hand guided tearing with pairs defined on system level and in sub class.",
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                merge_blt_blocks=true,
                methodName="printDAEBLT",
                methodResult="
-------------------------------
Torn linear block of 1 iteration variables and 3 solved variables:
Coefficient variability: Constant
Solved variables:
  c.a.y
  c.b.y
  c.a.x
Iteration variables:
  c.b.x
Solved equations:
  c.a.y = c.b.x - 3
  c.b.x = c.b.y + 2
  c.a.x = c.b.y + 2
Residual equations:
 Iteration variables: c.b.x
  c.a.x = c.a.y + 1
Jacobian:
  |1.0, 0.0, 0.0, - 1.0|
  |0.0, - 1.0, 0.0, 1.0|
  |0.0, - 1.0, 1.0, 0.0|
  |- 1.0, 0.0, 1.0, 0.0|
-------------------------------
")})));
        end Precedence1;

    end Mixed;
    
    package Generic
    
        model Error1
            Real u0,u1,u2,u3,uL;
            Real i0,i1,i2,i3,iL;
            parameter Real R1 = 1;
            parameter Real R2 = 1;
            parameter Real R3 = 1;
            parameter Real L = 1;
        equation
            u0 = sin(time);
            u1 = R1*i1 annotation(__Modelon(ResidualEquation(iterationVariable=i3)));
            u2 = R2*i2;
            u3 = R3*i3;
            uL = L*der(iL);
            u0 = u1 + u3;
            uL = u1 + u2;
            u2 = u3;
            i0 = i1 + iL;
            i1 = i2 + i3;
        
        annotation(__JModelica(UnitTesting(tests={
            ErrorTestCase(
                name="Generic_Error1",
                description="Test of hand guided tearing error when hgt is unable to solve the block",
                equation_sorting=true,
                hand_guided_tearing=true,
                automatic_tearing=false,
                errorMessage="
1 errors found:

Error: in file 'Compiler/ModelicaFrontEnd/src/test/modelica/TearingTests.mo':
Semantic error at line 0, column 0:
  Hand guided tearing selections in block 2 does not result in a torn system. Consider adding additional selections of hand guided equations and variables, or enable automatic tearing.
")})));

        end Error1;

        model Warning1
            Real x(start=1), y(start=2), z, w;
        equation
            x = y + 1;
            y = x + 1 annotation(__Modelon(ResidualEquation(iterationVariable=y)));
            w = z + 1;
            z = w - 1 annotation(__Modelon(ResidualEquation(iterationVariable=x)));
        annotation(
        __JModelica(UnitTesting(tests={
            WarningTestCase(
                equation_sorting=true,
                automatic_tearing=true,
                hand_guided_tearing=true,
                name="Generic_Warning1",
                description="Test hand guided tearing warnings",
                errorMessage="
1 warnings found:

Warning: in file '...':
At line 0, column 0:
  Can not use hand guided tearing pair, equation and variable resides in different blocks. Variable: x. Equation: z = w - 1
")})));
        end Warning1;
        
    end Generic;
end HGT;