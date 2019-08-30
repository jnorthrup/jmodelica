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
        description="No zero equation for top level flow connector variables when using causal_ports",
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
    A a1, a2;
equation
    c.a = 1;
    a2.c.a = 2;
    connect(a1.c, c);
annotation(__JModelica(UnitTesting(tests={
    TransformCanonicalTestCase(
        description="causal_ports only affect top level connectors",
        causal_ports=true,
        eliminate_alias_variables=false,
        variability_propagation=false,
        flatModel="
fclass CausalPorts.Flow2
 potential Real c.a;
 flow Real c.b;
 Real a1.c.a;
 Real a1.c.b;
 Real a2.c.a;
 Real a2.c.b;
equation
 c.a = 1;
 a2.c.a = 2;
 a1.c.a = c.a;
 a1.c.b - c.b = 0.0;
 a2.c.b = 0.0;
end CausalPorts.Flow2;
")})));
end Flow2;


model Stream1
    connector C
        Real p;
        flow Real f;
        stream Real s;
    end C;
    C c;
equation
    c.p = time;
    c.s = inStream(c.s);
annotation(__JModelica(UnitTesting(tests={
    TransformCanonicalTestCase(
        description="Top level stream connector variables get an inStream variable when using causal_ports",
        causal_ports=true,
        eliminate_alias_variables=false,
        variability_propagation=false,
        flatModel="
fclass CausalPorts.Stream1
 potential Real c.p;
 flow Real c.f;
 stream Real c.s;
 inStream Real c.s._instream_;
equation
 c.p = time;
 c.s = c.s._instream_;
end CausalPorts.Stream1;
")})));
end Stream1;


// TODO Add test with outside stream connector

end CausalPorts;
