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
package CausalPorts

model Flow1
    connector C
        Real a;
        flow Real b;
    end C;
    
    C c;
equation
    c.a = 1;
annotation(__JModelica(UnitTesting(tests={
    TransformCanonicalTestCase(
        description="No equals ",
        causal_ports=true,
        eliminate_alias_variables=false,
        variability_propagation=false,
        flatModel="
fclass CausalPorts.Flow1
 potential Real c.a;
 flow Real c.b;
equation
 c.a = 1;
end CausalPorts.Flow1;
")})));
end Flow1;

model Flow2
    connector C
        Real a;
        flow Real b;
    end C;
    
    model A
        C c;
    end A;
    
    C c;
    A a;
equation
    c.a = 1;
    connect(a.c, c);
annotation(__JModelica(UnitTesting(tests={
    TransformCanonicalTestCase(
        description="",
        causal_ports=true,
        eliminate_alias_variables=false,
        variability_propagation=false,
        flatModel="
fclass CausalPorts.Flow2
 potential Real c.a;
 flow Real c.b;
 Real a.c.a;
 Real a.c.b;
equation
 c.a = 1;
 a.c.a = c.a;
 a.c.b - c.b = 0.0;
end CausalPorts.Flow2;
")})));
end Flow2;

end CausalPorts;
