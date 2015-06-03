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


package DynamicStates
    package Basic
        model TwoDSOneEq
            // a1 a2
            // +  +
            Real a1;
            Real a2;
            Real b;
        equation
            der(a1) = b;
            der(a2) = b;
            a1 * a2 = 1;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="DynamicStates_Basic_TwoDSOneEq",
                description="Two dynamic states in one equation",
                dynamic_states=true,
                methodName="printDAEBLT",
                methodResult="
--- Dynamic state block ---
  --- States: a1 ---
    --- Solved equation ---
    a2 := 1 / ds(0, a1)
    -------------------------------
  --- States: a2 ---
    --- Solved equation ---
    a1 := 1 / ds(0, a2)
    -------------------------------

--- Torn linear system (Block 2) of 1 iteration variables and 2 solved variables ---
Coefficient variability: continuous-time
Torn variables:
  b
  dynDer(a1)

Iteration variables:
  dynDer(a2)

Torn equations:
  b := dynDer(a2)
  dynDer(a1) := b

Residual equations:
  ds(0, a1) * dynDer(a2) + dynDer(a1) * ds(0, a2) = 0
    Iteration variables: dynDer(a2)

Jacobian:
  |-1.0, 0.0, 1.0|
  |-1.0, 1.0, 0.0|
  |0.0, ds(0, a2), ds(0, a1)|

--- Solved equation ---
der(_ds.0.s0) := dsDer(0, 0)
-------------------------------
")})));
        end TwoDSOneEq;

        model TwoDSOneEqUnsolved
            // a1 a2
            // +  +
            Real a1;
            Real a2;
            Real b;
        equation
            der(a1) = b;
            der(a2) = b;
            a1^2 + a2^2 = 1;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="DynamicStates_Basic_TwoDSOneEqUnsolved",
                description="Two dynamic states in one equation with unsolved incidences",
                dynamic_states=true,
                methodName="printDAEBLT",
                methodResult="
--- Dynamic state block ---
  --- States: a2 ---
    --- Unsolved equation (Block 1(a2).0) ---
    ds(0, a1) ^ 2 + ds(0, a2) ^ 2 = 1
      Computed variables: a1
    -------------------------------
  --- States: a1 ---
    --- Unsolved equation (Block 1(a1).0) ---
    ds(0, a1) ^ 2 + ds(0, a2) ^ 2 = 1
      Computed variables: a2
    -------------------------------

--- Torn linear system (Block 2) of 1 iteration variables and 2 solved variables ---
Coefficient variability: continuous-time
Torn variables:
  b
  dynDer(a2)

Iteration variables:
  dynDer(a1)

Torn equations:
  b := dynDer(a1)
  dynDer(a2) := b

Residual equations:
  2 * ds(0, a1) * dynDer(a1) + 2 * ds(0, a2) * dynDer(a2) = 0
    Iteration variables: dynDer(a1)

Jacobian:
  |-1.0, 0.0, 1.0|
  |-1.0, 1.0, 0.0|
  |0.0, 2 * ds(0, a2), 2 * ds(0, a1)|

--- Solved equation ---
der(_ds.0.s0) := dsDer(0, 0)
-------------------------------
")})));
        end TwoDSOneEqUnsolved;

        model ThreeDSOneEq
            // a1 a2 a3
            // +  +  +
            Real a1;
            Real a2;
            Real a3;
            Real b;
        equation
            der(a1) = b;
            der(a2) = b;
            der(a3) = b;
            a1 * a2 * a3 = 1;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="DynamicStates_Basic_ThreeDSOneEq",
                description="Three dynamic states in one equation",
                dynamic_states=true,
                methodName="printDAEBLT",
                methodResult="
--- Dynamic state block ---
  --- States: a2, a1 ---
    --- Solved equation ---
    a3 := 1 / (ds(0, a1) * ds(0, a2))
    -------------------------------
  --- States: a3, a1 ---
    --- Solved equation ---
    a2 := 1 / (ds(0, a1) * ds(0, a3))
    -------------------------------
  --- States: a3, a2 ---
    --- Solved equation ---
    a1 := 1 / (ds(0, a2) * ds(0, a3))
    -------------------------------

--- Torn linear system (Block 2) of 1 iteration variables and 3 solved variables ---
Coefficient variability: continuous-time
Torn variables:
  b
  dynDer(a2)
  dynDer(a1)

Iteration variables:
  dynDer(a3)

Torn equations:
  b := dynDer(a3)
  dynDer(a2) := b
  dynDer(a1) := b

Residual equations:
  ds(0, a1) * ds(0, a2) * dynDer(a3) + (ds(0, a1) * dynDer(a2) + dynDer(a1) * ds(0, a2)) * ds(0, a3) = 0
    Iteration variables: dynDer(a3)

Jacobian:
  |-1.0, 0.0, 0.0, 1.0|
  |-1.0, 1.0, 0.0, 0.0|
  |-1.0, 0.0, 1.0, 0.0|
  |0.0, ds(0, a1) * ds(0, a3), ds(0, a2) * ds(0, a3), ds(0, a1) * ds(0, a2)|

--- Solved equation ---
der(_ds.0.s0) := dsDer(0, 0)

--- Solved equation ---
der(_ds.0.s1) := dsDer(0, 1)
-------------------------------
")})));
        end ThreeDSOneEq;

        model ThreeDSTwoEq
            // a1 a2 a3
            // +  +    
            //    +  + 
            Real a1;
            Real a2;
            Real a3;
            Real b;
        equation
            der(a1) = b + 1;
            der(a2) + der(a3) = b;
            a1 * a2 = 1;
            a2 * a3 = 1;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="DynamicStates_Basic_ThreeDSTwoEq",
                description="Three dynamic states in two equation",
                dynamic_states=true,
                methodName="printDAEBLT",
                methodResult="
--- Dynamic state block ---
  --- States: a1 ---
    --- Solved equation ---
    a2 := 1 / ds(0, a1)

    --- Solved equation ---
    a3 := 1 / ds(0, a2)
    -------------------------------
  --- States: a2 ---
    --- Solved equation ---
    a3 := 1 / ds(0, a2)

    --- Solved equation ---
    a1 := 1 / ds(0, a2)
    -------------------------------
  --- States: a3 ---
    --- Solved equation ---
    a2 := 1 / ds(0, a3)

    --- Solved equation ---
    a1 := 1 / ds(0, a2)
    -------------------------------

--- Torn linear system (Block 2) of 2 iteration variables and 2 solved variables ---
Coefficient variability: continuous-time
Torn variables:
  b
  dynDer(a1)

Iteration variables:
  dynDer(a2)
  dynDer(a3)

Torn equations:
  b := dynDer(a2) + dynDer(a3)
  dynDer(a1) := b + 1

Residual equations:
  ds(0, a2) * dynDer(a3) + dynDer(a2) * ds(0, a3) = 0
    Iteration variables: dynDer(a2)
  ds(0, a1) * dynDer(a2) + dynDer(a1) * ds(0, a2) = 0
    Iteration variables: dynDer(a3)

Jacobian:
  |-1.0, 0.0, 1.0, 1.0|
  |-1.0, 1.0, 0.0, 0.0|
  |0.0, 0.0, ds(0, a3), ds(0, a2)|
  |0.0, ds(0, a2), ds(0, a1), 0.0|

--- Solved equation ---
der(_ds.0.s0) := dsDer(0, 0)
-------------------------------
")})));
        end ThreeDSTwoEq;

        model FourDSTwoEq
            // a1 a2 a3 a4
            // +  +  +    
            //    +  +  + 
            Real a1;
            Real a2;
            Real a3;
            Real a4;
            Real b;
        equation
            der(a1) = b + 1;
            der(a2) = b + 2;
            der(a3) + der(a4) = b;
            a1 * a2 * a3 = 1;
            a2 * a3 * a4 = 1;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="DynamicStates_Basic_FourDSTwoEq",
                description="Four dynamic states in two equation",
                dynamic_states=true,
                methodName="printDAEBLT",
                methodResult="
--- Dynamic state block ---
  --- States: a2, a1 ---
    --- Solved equation ---
    a3 := 1 / (ds(0, a1) * ds(0, a2))

    --- Solved equation ---
    a4 := 1 / (ds(0, a2) * ds(0, a3))
    -------------------------------
  --- States: a3, a1 ---
    --- Solved equation ---
    a2 := 1 / (ds(0, a1) * ds(0, a3))

    --- Solved equation ---
    a4 := 1 / (ds(0, a2) * ds(0, a3))
    -------------------------------
  --- States: a3, a2 ---
    --- Solved equation ---
    a4 := 1 / (ds(0, a2) * ds(0, a3))

    --- Solved equation ---
    a1 := 1 / (ds(0, a2) * ds(0, a3))
    -------------------------------
  --- States: a4, a1 ---
    --- Unsolved system (Block 1(a4, a1).0) of 2 variables ---
    Unknown variables:
      a2 ()
      a3 ()

    Equations:
      ds(0, a1) * ds(0, a2) * ds(0, a3) = 1
        Iteration variables: a2
      ds(0, a2) * ds(0, a3) * ds(0, a4) = 1
        Iteration variables: a3
    -------------------------------
  --- States: a4, a2 ---
    --- Solved equation ---
    a3 := 1 / (ds(0, a2) * ds(0, a4))

    --- Solved equation ---
    a1 := 1 / (ds(0, a2) * ds(0, a3))
    -------------------------------
  --- States: a4, a3 ---
    --- Solved equation ---
    a2 := 1 / (ds(0, a3) * ds(0, a4))

    --- Solved equation ---
    a1 := 1 / (ds(0, a2) * ds(0, a3))
    -------------------------------

--- Torn linear system (Block 2) of 2 iteration variables and 3 solved variables ---
Coefficient variability: continuous-time
Torn variables:
  b
  dynDer(a2)
  dynDer(a1)

Iteration variables:
  dynDer(a3)
  dynDer(a4)

Torn equations:
  b := dynDer(a3) + dynDer(a4)
  dynDer(a2) := b + 2
  dynDer(a1) := b + 1

Residual equations:
  ds(0, a2) * ds(0, a3) * dynDer(a4) + (ds(0, a2) * dynDer(a3) + dynDer(a2) * ds(0, a3)) * ds(0, a4) = 0
    Iteration variables: dynDer(a3)
  ds(0, a1) * ds(0, a2) * dynDer(a3) + (ds(0, a1) * dynDer(a2) + dynDer(a1) * ds(0, a2)) * ds(0, a3) = 0
    Iteration variables: dynDer(a4)

Jacobian:
  |-1.0, 0.0, 0.0, 1.0, 1.0|
  |-1.0, 1.0, 0.0, 0.0, 0.0|
  |-1.0, 0.0, 1.0, 0.0, 0.0|
  |0.0, ds(0, a3) * ds(0, a4), 0.0, ds(0, a2) * ds(0, a4), ds(0, a2) * ds(0, a3)|
  |0.0, ds(0, a1) * ds(0, a3), ds(0, a2) * ds(0, a3), ds(0, a1) * ds(0, a2), 0.0|

--- Solved equation ---
der(_ds.0.s0) := dsDer(0, 0)

--- Solved equation ---
der(_ds.0.s1) := dsDer(0, 1)
-------------------------------
")})));
        end FourDSTwoEq;

        model FiveDSTwoEq
            // a1 a2 a3 a4 a5
            // +  +  +      
            //       +  +  +
            Real a1;
            Real a2;
            Real a3;
            Real a4;
            Real a5;
            Real b;
        equation
            der(a1) = b;
            der(a2) = b;
            der(a3) = b;
            der(a4) + der(a5) = b;
            a1 * a2 * a3 = 1;
            a3 * a4 * a5 = 1;

        annotation(__JModelica(disabled_UnitTesting(tests={
            FClassMethodTestCase(
                name="DynamicStates_Basic_FiveDSTwoEq",
                description="Five dynamic states in two equation",
                dynamic_states=true,
                methodName="printDAEBLT",
                methodResult="
")})));
        end FiveDSTwoEq;

        model TwoDSSetMerge
            // a1 a2 a3 a4
            // +  +       
            //    *  *    
            //       +  + 
            Real a1;
            Real a2;
            Real a3;
            Real a4;
            Real b;
        equation
            der(a1) + der(a4) = b;
            der(a2) + der(a3) = b;
            a1 * a2 = 1;
            a2 + a3 = 1;
            a3 * a4 = 1;

        annotation(__JModelica_disabled(UnitTesting(tests={
            FClassMethodTestCase(
                name="DynamicStates_Basic_TwoDSSetMerge",
                description="Two dynamic state sets that need to be merged",
                dynamic_states=true,
                methodName="printDAEBLT",
                methodResult="
--- Dynamic state block ---
  --- States: a3 ---
    --- Solved equation ---
    a4 := 1 / ds(0, a3)

    --- Solved equation ---
    a2 := - ds(0, a3) + 1

    --- Solved equation ---
    a1 := 1 / ds(0, a2)
    -------------------------------
  --- States: a1 ---
    --- Solved equation ---
    a2 := 1 / ds(0, a1)

    --- Solved equation ---
    a3 := - ds(0, a2) + 1

    --- Solved equation ---
    a4 := 1 / ds(0, a3)
    -------------------------------
  --- States: a2 ---
    --- Solved equation ---
    a3 := - ds(0, a2) + 1

    --- Solved equation ---
    a4 := 1 / ds(0, a3)

    --- Solved equation ---
    a1 := 1 / ds(0, a2)
    -------------------------------
  --- States: a4 ---
    --- Solved equation ---
    a3 := 1 / ds(0, a4)

    --- Solved equation ---
    a2 := - ds(0, a3) + 1

    --- Solved equation ---
    a1 := 1 / ds(0, a2)
    -------------------------------

--- Torn linear system (Block 2) of 2 iteration variables and 3 solved variables ---
Coefficient variability: continuous-time
Torn variables:
  dynDer(a3)
  b
  dynDer(a1)

Iteration variables:
  dynDer(a2)
  dynDer(a4)

Torn equations:
  dynDer(a3) := - dynDer(a2)
  b := dynDer(a2) + dynDer(a3)
  dynDer(a1) := - dynDer(a4) + b

Residual equations:
  ds(0, a1) * dynDer(a2) + dynDer(a1) * ds(0, a2) = 0
    Iteration variables: dynDer(a2)
  ds(0, a3) * dynDer(a4) + dynDer(a3) * ds(0, a4) = 0
    Iteration variables: dynDer(a4)

Jacobian:
  |1.0, 0.0, 0.0, 1.0, 0.0|
  |1.0, -1.0, 0.0, 1.0, 0.0|
  |0.0, -1.0, 1.0, 0.0, 1.0|
  |0.0, 0.0, ds(0, a2), ds(0, a1), 0.0|
  |ds(0, a4), 0.0, 0.0, 0.0, ds(0, a3)|

--- Solved equation ---
der(_ds.0.s0) := dsDer(0, 0)
-------------------------------
")})));
        end TwoDSSetMerge;

        model TwoBigDSSetMerge
            // a1 a2 a3 a4 a5 a6
            // +  +             
            //    +  +          
            //       *  *       
            //          +  +    
            //             +  + 
            Real a1;
            Real a2;
            Real a3;
            Real a4;
            Real a5;
            Real a6;
            Real b;
        equation
            der(a1) + der(a4) = b;
            der(a2) + der(a3) + der(a5) = b;
            a1 * a2 = 1;
            a2 * a3 = 1;
            a3 + a4 = 1;
            a4 * a5 = 1;
            a5 * a6 = 1;

        annotation(__JModelica_disabled(UnitTesting(tests={
            FClassMethodTestCase(
                name="DynamicStates_Basic_TwoBigDSSetMerge",
                description="Two dynamic state sets of two equations each that need to be merged",
                dynamic_states=true,
                methodName="printDAEBLT",
                methodResult="
--- Dynamic state block ---
  --- States: a4 ---
    --- Solved equation ---
    a5 := 1 / ds(0, a4)

    --- Solved equation ---
    a3 := - ds(0, a4) + 1

    --- Solved equation ---
    a2 := 1 / ds(0, a3)

    --- Solved equation ---
    a1 := 1 / ds(0, a2)
    -------------------------------
  --- States: a1 ---
    --- Solved equation ---
    a2 := 1 / ds(0, a1)

    --- Solved equation ---
    a3 := 1 / ds(0, a2)

    --- Solved equation ---
    a4 := - ds(0, a3) + 1

    --- Solved equation ---
    a5 := 1 / ds(0, a4)
    -------------------------------
  --- States: a2 ---
    --- Solved equation ---
    a3 := 1 / ds(0, a2)

    --- Solved equation ---
    a4 := - ds(0, a3) + 1

    --- Solved equation ---
    a5 := 1 / ds(0, a4)

    --- Solved equation ---
    a1 := 1 / ds(0, a2)
    -------------------------------
  --- States: a3 ---
    --- Solved equation ---
    a4 := - ds(0, a3) + 1

    --- Solved equation ---
    a5 := 1 / ds(0, a4)

    --- Solved equation ---
    a2 := 1 / ds(0, a3)

    --- Solved equation ---
    a1 := 1 / ds(0, a2)
    -------------------------------
  --- States: a5 ---
    --- Solved equation ---
    a4 := 1 / ds(0, a5)

    --- Solved equation ---
    a3 := - ds(0, a4) + 1

    --- Solved equation ---
    a2 := 1 / ds(0, a3)

    --- Solved equation ---
    a1 := 1 / ds(0, a2)
    -------------------------------

--- Torn linear system (Block 2) of 3 iteration variables and 3 solved variables ---
Coefficient variability: continuous-time
Torn variables:
  b
  dynDer(a4)
  dynDer(a1)

Iteration variables:
  dynDer(a2)
  dynDer(a3)
  dynDer(a5)

Torn equations:
  b := dynDer(a2) + dynDer(a3) + dynDer(a5)
  dynDer(a4) := - dynDer(a3)
  dynDer(a1) := - dynDer(a4) + b

Residual equations:
  ds(0, a4) * dynDer(a5) + dynDer(a4) * ds(0, a5) = 0
    Iteration variables: dynDer(a2)
  ds(0, a1) * dynDer(a2) + dynDer(a1) * ds(0, a2) = 0
    Iteration variables: dynDer(a3)
  ds(0, a2) * dynDer(a3) + dynDer(a2) * ds(0, a3) = 0
    Iteration variables: dynDer(a5)

Jacobian:
  |-1.0, 0.0, 0.0, 1.0, 1.0, 1.0|
  |0.0, 1.0, 0.0, 0.0, 1.0, 0.0|
  |-1.0, 1.0, 1.0, 0.0, 0.0, 0.0|
  |0.0, ds(0, a5), 0.0, 0.0, 0.0, ds(0, a4)|
  |0.0, 0.0, ds(0, a2), ds(0, a1), 0.0, 0.0|
  |0.0, 0.0, 0.0, ds(0, a3), ds(0, a2), 0.0|

--- Solved equation ---
a6 := 1 / ds(0, a5)

--- Solved equation ---
der(_ds.0.s0) := dsDer(0, 0)
-------------------------------
")})));
        end TwoBigDSSetMerge;

        model TwoDSSetForced
            // a1 a2 a3 a4 a5
            // *  +  +       
            // *        *    
            //          +  + 
            Real a1;
            Real a2;
            Real a3;
            Real a4;
            Real a5;
        equation
            der(a1) + der(a4) + der(a5) = 0;
            der(a2) + der(a3) = 0;
            a1 = a2 * a3;
            a1 + a4 = 1;
            a4 * a5 = 1;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="DynamicStates_Basic_TwoDSSetForced",
                description="Two dynamic states sets where one is forced by the other",
                dynamic_states=true,
                methodName="printDAEBLT",
                methodResult="
--- Dynamic state block ---
  --- States: a4 ---
    --- Solved equation ---
    a5 := 1 / ds(0, a4)
    -------------------------------
  --- States: a5 ---
    --- Solved equation ---
    a4 := 1 / ds(0, a5)
    -------------------------------

--- Torn linear system (Block 2) of 1 iteration variables and 2 solved variables ---
Coefficient variability: continuous-time
Torn variables:
  dynDer(a4)
  dynDer(a5)

Iteration variables:
  _der_a1

Torn equations:
  dynDer(a4) := - _der_a1
  dynDer(a5) := - _der_a1 + (- dynDer(a4))

Residual equations:
  ds(0, a4) * dynDer(a5) + dynDer(a4) * ds(0, a5) = 0
    Iteration variables: _der_a1

Jacobian:
  |1.0, 0.0, 1.0|
  |1.0, 1.0, 1.0|
  |ds(0, a5), ds(0, a4), 0.0|

--- Solved equation ---
a1 := - ds(0, a4) + 1

--- Dynamic state block ---
  --- States: a2 ---
    --- Solved equation ---
    a3 := (- a1) / (- ds(1, a2))
    -------------------------------
  --- States: a3 ---
    --- Solved equation ---
    a2 := (- a1) / (- ds(1, a3))
    -------------------------------

--- Torn linear system (Block 4) of 1 iteration variables and 1 solved variables ---
Coefficient variability: continuous-time
Torn variables:
  dynDer(a2)

Iteration variables:
  dynDer(a3)

Torn equations:
  dynDer(a2) := - dynDer(a3)

Residual equations:
  _der_a1 = ds(1, a2) * dynDer(a3) + dynDer(a2) * ds(1, a3)
    Iteration variables: dynDer(a3)

Jacobian:
  |1.0, 1.0|
  |- ds(1, a3), - ds(1, a2)|

--- Solved equation ---
der(_ds.0.s0) := dsDer(0, 0)

--- Solved equation ---
der(_ds.1.s0) := dsDer(1, 0)
-------------------------------
")})));
        end TwoDSSetForced;

    end Basic;
    
    package StateSelectBias
        
        model AlwaysVar1
            // a1 a2 a3
            // *  *    
            //    +  + 
            Real a1(stateSelect = StateSelect.always);
            Real a2;
            Real a3;
            Real b;
        equation
            der(a1) + der(a2) = b;
            der(a2) + der(a3) = b;
            a1 + a2 = 1;
            a2 * a3 = 1;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="DynamicStates_StateSelectBias_AlwaysVar1",
                description="Test so that StateSelect.always prevents the dss algorithm from moving variables.",
                methodName="printDAEBLT",
                methodResult="
--- Solved equation ---
a2 := - a1 + 1

--- Solved equation ---
a3 := 1 / a2

--- Torn linear system (Block 1) of 1 iteration variables and 3 solved variables ---
Coefficient variability: continuous-time
Torn variables:
  der(a1)
  b
  _der_a3

Iteration variables:
  _der_a2

Torn equations:
  der(a1) := - _der_a2
  b := der(a1) + _der_a2
  _der_a3 := - _der_a2 + b

Residual equations:
  a2 * _der_a3 + _der_a2 * a3 = 0
    Iteration variables: _der_a2

Jacobian:
  |1.0, 0.0, 0.0, 1.0|
  |1.0, -1.0, 0.0, 1.0|
  |0.0, -1.0, 1.0, 1.0|
  |0.0, 0.0, a2, a3|
-------------------------------
")})));
        end AlwaysVar1;
        
        model AlwaysVar2
            // a1 a2 a3
            // *  +  + 
            //    +  + 
            Real a1(stateSelect = StateSelect.always);
            Real a2;
            Real a3;
            Real b;
        equation
            der(a1) + der(a2) = b;
            der(a2) + der(a3) = b;
            a1 + a2 * a3 = 1;
            a2 * a3 = 1;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="DynamicStates_StateSelectBias_AlwaysVar2",
                description="Test so that StateSelect.always prevents the dss algorithm from moving variables.",
                methodName="printDAEBLT",
                methodResult="
--- Unsolved system (Block 1) of 2 variables ---
Unknown variables:
  a3 ()
  a2 ()

Equations:
  a2 * a3 = 1
    Iteration variables: a3
  a1 + a2 * a3 = 1
    Iteration variables: a2

--- Torn linear system (Block 2) of 2 iteration variables and 2 solved variables ---
Coefficient variability: continuous-time
Torn variables:
  der(a1)
  b

Iteration variables:
  _der_a2
  _der_a3

Torn equations:
  der(a1) := - a2 * _der_a3 + (- _der_a2 * a3)
  b := _der_a2 + _der_a3

Residual equations:
  der(a1) + _der_a2 = b
    Iteration variables: _der_a2
  a2 * _der_a3 + _der_a2 * a3 = 0
    Iteration variables: _der_a3

Jacobian:
  |1.0, 0.0, a3, a2|
  |0.0, -1.0, 1.0, 1.0|
  |1.0, -1.0, 1.0, 0.0|
  |0.0, 0.0, a3, a2|
-------------------------------
")})));
        end AlwaysVar2;
        
        model NeverVar1
            // a1 a2 a3
            // *  *    
            //    +  + 
            Real a1;
            Real a2(stateSelect = StateSelect.never);
            Real a3;
            Real b;
        equation
            der(a1) + der(a2) = b;
            der(a2) + der(a3) = b;
            a1 + a2 = 1;
            a2 * a3 = 1;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="DynamicStates_StateSelectBias_NeverVar1",
                description="Test so that StateSelect.never prevents the dss algorithm from moving variables.",
                methodName="printDAEBLT",
                methodResult="
--- Solved equation ---
a2 := 1 / a3

--- Torn linear system (Block 1) of 1 iteration variables and 3 solved variables ---
Coefficient variability: continuous-time
Torn variables:
  _der_a1
  b
  der(a3)

Iteration variables:
  _der_a2

Torn equations:
  _der_a1 := - _der_a2
  b := _der_a1 + _der_a2
  der(a3) := - _der_a2 + b

Residual equations:
  a2 * der(a3) + _der_a2 * a3 = 0
    Iteration variables: _der_a2

Jacobian:
  |1.0, 0.0, 0.0, 1.0|
  |1.0, -1.0, 0.0, 1.0|
  |0.0, -1.0, 1.0, 1.0|
  |0.0, 0.0, a2, a3|

--- Solved equation ---
a1 := - a2 + 1
-------------------------------
")})));
        end NeverVar1;
        
        model NeverVar2
            // a1 a2 a3
            // *  +  + 
            //    +  + 
            Real a1;
            Real a2(stateSelect = StateSelect.never);
            Real a3;
            Real b;
        equation
            der(a1) + der(a2) = b;
            der(a2) + der(a3) = b;
            a1 + a2 * a3 = 1;
            a2 * a3 = 1;

        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="DynamicStates_StateSelectBias_NeverVar2",
                description="Test so that StateSelect.never prevents the dss algorithm from moving variables.",
                dynamic_states=true,
                methodName="printDAEBLT",
                methodResult="
--- Solved equation ---
a2 := 1 / a3

--- Torn linear system (Block 1) of 2 iteration variables and 2 solved variables ---
Coefficient variability: continuous-time
Torn variables:
  _der_a1
  b

Iteration variables:
  _der_a2
  der(a3)

Torn equations:
  _der_a1 := - a2 * der(a3) + (- _der_a2 * a3)
  b := _der_a2 + der(a3)

Residual equations:
  _der_a1 + _der_a2 = b
    Iteration variables: _der_a2
  a2 * der(a3) + _der_a2 * a3 = 0
    Iteration variables: der(a3)

Jacobian:
  |1.0, 0.0, a3, a2|
  |0.0, -1.0, 1.0, 1.0|
  |1.0, -1.0, 1.0, 0.0|
  |0.0, 0.0, a3, a2|

--- Solved equation ---
a1 := - a2 * a3 + 1
-------------------------------
")})));
        end NeverVar2;
        
    end StateSelectBias;
    
    model TempVar1
        function F
            input Real a;
            input Real b;
            input Real c;
            output Real d;
        algorithm
            d := a * b + c * a;
        end F;
        // a1 a2 tmp
        // +  +  + 
        Real a1;
        Real a2;
        Real b;
    equation
        der(a1) = b;
        der(a2) = b;
        0 = F(a1 * a2, a1, a2);

    annotation(__JModelica(UnitTesting(tests={
        FClassMethodTestCase(
            name="DynamicStates_TempVar1",
            description="Test so that temp variables doesn't form dynamic state sets",
            dynamic_states=true,
            methodName="printDAEBLT",
            methodResult="
--- Dynamic state block ---
  --- States: a1 ---
    --- Torn system (Block 1(a1).0) of 1 iteration variables and 1 solved variables ---
    Torn variables:
      temp_1

    Iteration variables:
      a2 ()

    Torn equations:
      temp_1 := ds(0, a1) * ds(0, a2)

    Residual equations:
      0 = temp_1 * ds(0, a1) + ds(0, a2) * temp_1
        Iteration variables: a2
    -------------------------------
  --- States: a2 ---
    --- Torn system (Block 1(a2).0) of 1 iteration variables and 1 solved variables ---
    Torn variables:
      temp_1

    Iteration variables:
      a1 ()

    Torn equations:
      temp_1 := ds(0, a1) * ds(0, a2)

    Residual equations:
      0 = temp_1 * ds(0, a1) + ds(0, a2) * temp_1
        Iteration variables: a1
    -------------------------------

--- Torn linear system (Block 2) of 1 iteration variables and 3 solved variables ---
Coefficient variability: continuous-time
Torn variables:
  b
  dynDer(a1)
  _der_temp_1

Iteration variables:
  dynDer(a2)

Torn equations:
  b := dynDer(a2)
  dynDer(a1) := b
  _der_temp_1 := ds(0, a1) * dynDer(a2) + dynDer(a1) * ds(0, a2)

Residual equations:
  0 = temp_1 * dynDer(a1) + _der_temp_1 * ds(0, a1) + (ds(0, a2) * _der_temp_1 + dynDer(a2) * temp_1)
    Iteration variables: dynDer(a2)

Jacobian:
  |-1.0, 0.0, 0.0, 1.0|
  |-1.0, 1.0, 0.0, 0.0|
  |0.0, - ds(0, a2), 1.0, - ds(0, a1)|
  |0.0, - temp_1, - ds(0, a1) - ds(0, a2), - temp_1|

--- Solved equation ---
der(_ds.0.s0) := dsDer(0, 0)
-------------------------------
")})));
    end TempVar1;

    package Examples
        model Pendulum
            parameter Real L = 1 "Pendulum length";
            parameter Real g = 9.81 "Acceleration due to gravity";
            Real x(start = L) "Cartesian x coordinate";
            Real y "Cartesian x coordinate";
            Real vx "Velocity in x coordinate";
            Real vy(start = 0) "Velocity in y coordinate";
            Real lambda "Lagrange multiplier";
        equation
            der(x) = vx;
            der(y) = vy;
            der(vx) = lambda*x;
            der(vy) = lambda*y - g;
            x^2 + y^2 = L;
        annotation(__JModelica(UnitTesting(tests={
            FClassMethodTestCase(
                name="DynamicStates_Examples_Pendulum_BLT",
                description="Check the BLT of the pendulum model",
                dynamic_states=true,
                methodName="printDAEBLT",
                methodResult="
--- Dynamic state block ---
  --- States: y ---
    --- Unsolved equation (Block 1(y).0) ---
    ds(1, x) ^ 2 + ds(1, y) ^ 2 = L
      Computed variables: x
    -------------------------------
  --- States: x ---
    --- Unsolved equation (Block 1(x).0) ---
    ds(1, x) ^ 2 + ds(1, y) ^ 2 = L
      Computed variables: y
    -------------------------------

--- Dynamic state block ---
  --- States: _der_y ---
    --- Solved equation ---
    dynDer(y) := ds(0, _der_y)

    --- Solved equation ---
    dynDer(x) := (- 2 * ds(1, y) * dynDer(y)) / (2 * ds(1, x))

    --- Solved equation ---
    _der_x := dynDer(x)
    -------------------------------
  --- States: _der_x ---
    --- Solved equation ---
    dynDer(x) := ds(0, _der_x)

    --- Solved equation ---
    dynDer(y) := (- 2 * ds(1, x) * dynDer(x)) / (2 * ds(1, y))

    --- Solved equation ---
    _der_y := dynDer(y)
    -------------------------------

--- Solved equation ---
vx := dynDer(x)

--- Solved equation ---
vy := dynDer(y)

--- Torn linear system (Block 3) of 1 iteration variables and 4 solved variables ---
Coefficient variability: continuous-time
Torn variables:
  _der_vy
  dynDer(_der_y)
  _der_vx
  dynDer(_der_x)

Iteration variables:
  lambda

Torn equations:
  _der_vy := lambda * ds(1, y) + (- g)
  dynDer(_der_y) := _der_vy
  _der_vx := lambda * ds(1, x)
  dynDer(_der_x) := _der_vx

Residual equations:
  2 * ds(1, x) * dynDer(_der_x) + 2 * dynDer(x) * dynDer(x) + (2 * ds(1, y) * dynDer(_der_y) + 2 * dynDer(y) * dynDer(y)) = 0.0
    Iteration variables: lambda

Jacobian:
  |1.0, 0.0, 0.0, 0.0, - ds(1, y)|
  |-1.0, 1.0, 0.0, 0.0, 0.0|
  |0.0, 0.0, 1.0, 0.0, (- ds(1, x))|
  |0.0, 0.0, -1.0, 1.0, 0.0|
  |0.0, 2 * ds(1, y), 0.0, 2 * ds(1, x), 0.0|

--- Solved equation ---
der(_ds.0.s0) := dsDer(0, 0)

--- Solved equation ---
der(_ds.1.s0) := dsDer(1, 0)
-------------------------------
"),FClassMethodTestCase(
                name="DynamicStates_Examples_Pendulum_initBLT",
                description="Check the BLT of the pendulum model",
                dynamic_states=true,
                methodName="printDAEInitBLT",
                methodResult="
--- Solved equation ---
_der_y := 0.0

--- Solved equation ---
dynDer(y) := ds(0, _der_y)

--- Solved equation ---
x := L

--- Unsolved equation (Block 1) ---
ds(1, x) ^ 2 + ds(1, y) ^ 2 = L
  Computed variables: y

--- Solved equation ---
dynDer(x) := (- 2 * ds(1, y) * dynDer(y)) / (2 * ds(1, x))

--- Solved equation ---
vx := dynDer(x)

--- Solved equation ---
vy := dynDer(y)

--- Torn linear system (Block 2) of 1 iteration variables and 4 solved variables ---
Coefficient variability: continuous-time
Torn variables:
  _der_vy
  dynDer(_der_y)
  _der_vx
  dynDer(_der_x)

Iteration variables:
  lambda

Torn equations:
  _der_vy := lambda * ds(1, y) + (- g)
  dynDer(_der_y) := _der_vy
  _der_vx := lambda * ds(1, x)
  dynDer(_der_x) := _der_vx

Residual equations:
  2 * ds(1, x) * dynDer(_der_x) + 2 * dynDer(x) * dynDer(x) + (2 * ds(1, y) * dynDer(_der_y) + 2 * dynDer(y) * dynDer(y)) = 0.0
    Iteration variables: lambda

Jacobian:
  |1.0, 0.0, 0.0, 0.0, - ds(1, y)|
  |-1.0, 1.0, 0.0, 0.0, 0.0|
  |0.0, 0.0, 1.0, 0.0, (- ds(1, x))|
  |0.0, 0.0, -1.0, 1.0, 0.0|
  |0.0, 2 * ds(1, y), 0.0, 2 * ds(1, x), 0.0|

--- Solved equation ---
_der_x := dynDer(x)

--- Solved equation ---
der(_ds.0.s0) := dsDer(0, 0)

--- Solved equation ---
der(_ds.1.s0) := dsDer(1, 0)

--- Solved equation ---
_ds.0.s0 := 0.0

--- Solved equation ---
_ds.1.s0 := 0.0
-------------------------------
"),FClassMethodTestCase(
                name="DynamicStates_Examples_Pendulum_States",
                description="Check the states of the pendulum model",
                dynamic_states=true,
                methodName="stateDiagnosticsObj",
                methodResult="
States:
  Set of dynamic states with 1 states and 1 algebraics:
    Real _der_x
    Real _der_y
  Set of dynamic states with 1 states and 1 algebraics:
    Real x(start = L) \"Cartesian x coordinate\"
    Real y \"Cartesian x coordinate\"
"),TransformCanonicalTestCase(
                name="DynamicStates_Examples_Pendulum_Model",
                description="Check the model of the pendulum model",
                dynamic_states=true,
                flatModel="
fclass DynamicStates.Examples.Pendulum
 parameter Real L = 1 \"Pendulum length\" /* 1 */;
 parameter Real g = 9.81 \"Acceleration due to gravity\" /* 9.81 */;
 Real x(start = L) \"Cartesian x coordinate\";
 Real y \"Cartesian x coordinate\";
 Real vx \"Velocity in x coordinate\";
 Real vy(start = 0) \"Velocity in y coordinate\";
 Real lambda \"Lagrange multiplier\";
 Real _der_vx;
 Real _der_vy;
 Real _der_x;
 Real _der_y;
 Real _ds.0.a0;
 Real _ds.0.s0;
 Real _ds.1.a0;
 Real _ds.1.s0;
 Real dynDer(x);
 Real dynDer(y);
 Real dynDer(_der_x);
 Real dynDer(_der_y);
initial equation 
 _ds.0.s0 = 0.0;
 _ds.1.s0 = 0.0;
 x = L;
 _der_y = 0.0;
equation
 dynDer(x) = vx;
 dynDer(y) = vy;
 _der_vx = lambda * ds(1, x);
 _der_vy = lambda * ds(1, y) - g;
 ds(1, x) ^ 2 + ds(1, y) ^ 2 = L;
 2 * ds(1, x) * dynDer(x) + 2 * ds(1, y) * dynDer(y) = 0.0;
 dynDer(_der_x) = _der_vx;
 dynDer(_der_y) = _der_vy;
 2 * ds(1, x) * dynDer(_der_x) + 2 * dynDer(x) * dynDer(x) + (2 * ds(1, y) * dynDer(_der_y) + 2 * dynDer(y) * dynDer(y)) = 0.0;
 ds(0, _der_x) = dynDer(x);
 ds(0, _der_y) = dynDer(y);
 der(_ds.0.s0) = dsDer(0, 0);
 der(_ds.1.s0) = dsDer(1, 0);
end DynamicStates.Examples.Pendulum;
")})));
        end Pendulum;
    end Examples;
end DynamicStates;
