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

package ExternalObjectTests


model ShortStructors
    extends ExternalObject;
    function constructor = createShortStructors;
    function destructor = destroyShortStructors;
end ShortStructors;

function createShortStructors
    output ShortStructors obj;
    external;
end createShortStructors;

function destroyShortStructors
    input ShortStructors obj;
    external;
end destroyShortStructors;

function getShortStructorsValue
    input ShortStructors obj;
    output Real value;
    external;
end getShortStructorsValue;


model TestShortStructors1
    ShortStructors obj = ShortStructors();
annotation(__JModelica(UnitTesting(tests={
    TransformCanonicalTestCase(
        name="1",
        description="Test external object short class constructor and destructor declarations",
        variability_propagation=false,
        flatModel="
fclass ExternalObjectTests.TestShortStructors1
 parameter ExternalObjectTests.ShortStructors obj = ExternalObjectTests.ShortStructors.constructor() /* {} */;

public
 function ExternalObjectTests.ShortStructors.destructor
  input ExternalObjectTests.ShortStructors obj;
 algorithm
  external \"C\" destroyShortStructors(obj);
  return;
 end ExternalObjectTests.ShortStructors.destructor;

 function ExternalObjectTests.ShortStructors.constructor
  output ExternalObjectTests.ShortStructors obj;
 algorithm
  external \"C\" obj = createShortStructors();
  return;
 end ExternalObjectTests.ShortStructors.constructor;

 type ExternalObjectTests.ShortStructors = ExternalObject;
end ExternalObjectTests.TestShortStructors1;
")})));
end TestShortStructors1;


model TestShortStructors2
    ShortStructors obj = ShortStructors();
    constant Real c = getShortStructorsValue(obj);
annotation(__JModelica(UnitTesting(tests={
    ErrorTestCase(
        name="2",
        description="No exception when evaluating short constructor declaration",
        errorMessage="
Error at line 3, column 23, in file '...':
  Could not evaluate binding expression for constant 'c': 'getShortStructorsValue(obj)'
    in function 'ExternalObjectTests.getShortStructorsValue'
    Failed to evaluate external function 'getShortStructorsValue', external function cache unavailable
")})));
end TestShortStructors2;

end ExternalObjectTests;