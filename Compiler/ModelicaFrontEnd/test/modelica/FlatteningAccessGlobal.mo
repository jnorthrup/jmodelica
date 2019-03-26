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

within;

package FlatteningAccessGlobal


model InSubscripts1
    package P
        constant Integer[:] is = {1,2,3};
    end P;
    
    function f
        input Real[:] x;
        input Integer i;
        output Real y = x[P.is[i]];
    algorithm
    end f;

    Real y = f({1,2,3}, 2);

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="InSubscripts1",
            description="",
            flatModel="
fclass FlatteningAccessGlobal.InSubscripts1
 Real y = FlatteningAccessGlobal.InSubscripts1.f({1, 2, 3}, 2);
global variables
 constant Integer FlatteningAccessGlobal.InSubscripts1.P.is[3] = {1, 2, 3};

public
 function FlatteningAccessGlobal.InSubscripts1.f
  input Real[:] x;
  input Integer i;
  output Real y;
 algorithm
  y := x[global(FlatteningAccessGlobal.InSubscripts1.P.is[i])];
  return;
 end FlatteningAccessGlobal.InSubscripts1.f;

end FlatteningAccessGlobal.InSubscripts1;
")})));
end InSubscripts1;


end FlatteningAccessGlobal;