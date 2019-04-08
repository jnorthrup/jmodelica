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

package ExpandableConnectorArrays


    model NoConnectionSingleCell
        expandable connector EC
        end EC;

        EC ec1[1], ec2[1];
    equation
        connect(ec1, ec2);

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="NoConnectionSingleCell",
            description="Expandable to expandable only, one cell each.",
            flatModel="
fclass ExpandableConnectors.NoConnectionSingleCell
end ExpandableConnectors.NoConnectionSingleCell;
")})));
    end NoConnectionSingleCell;

    model NoConnectionIntegerSized
        expandable connector EC
        end EC;

        EC ec1[2], ec2[2];
    equation
        connect(ec1, ec2);

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="EmptyIntegerSized",
            description="Expandable to expandable only, several cells each.",
            flatModel="
fclass ExpandableConnectors.NoConnectionIntegerSized
end ExpandableConnectors.NoConnectionIntegerSized;
")})));
    end NoConnectionIntegerSized;

    model NoConnectionParameterSized
        expandable connector EC
        end EC;

        parameter Integer n;

        EC ec1[n], ec2[n];
    equation
        connect(ec1, ec2);

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="NoConnectionParameterSized",
            description="Expandable to expandable only, parameter sized.",
            flatModel="
fclass ExpandableConnectorArrays.NoConnectionParameterSized
 structural parameter Integer n = 0 /* 0 */;
end ExpandableConnectorArrays.NoConnectionParameterSized;
")})));
    end NoConnectionParameterSized;


    model SingleCells
        expandable connector EC
        end EC;

        connector C = Real;

        EC ec1[1], ec2[1];
        C c1, c2;
    equation
        connect(c1, ec1[1].a);
        connect(ec1[1], ec2[1]);
        connect(ec2[1].a, c2);
        c1 = time;

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="SingleCells",
            description="Arrays of expandable connectors, singular cells.",
            flatModel="
fclass ExpandableConnectorArrays.SingleCells
 Real ec1[1].a;
 Real ec2[1].a;
 Real c1;
 Real c2;
equation
 c1 = time;
 c1 = c2;
 c2 = ec1[1].a;
 ec1[1].a = ec2[1].a;
end ExpandableConnectorArrays.SingleCells;
")})));
    end SingleCells;


    model IntegerSized
        expandable connector EC
        end EC;

        connector C = Real;

        EC ec1[1], ec2[1];
        C c1, c2;
    equation
        connect(c1, ec1[1].a);
        connect(ec1[1], ec2[1]);
        connect(ec2[1].a, c2);
        c1 = time;

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="IntegerSized",
            description="Arrays of expandable connectors, several cells each.",
            flatModel="
fclass ExpandableConnectorArrays.IntegerSized
 Real ec1[1].a;
 Real ec2[1].a;
 Real c1;
 Real c2;
equation
 c1 = time;
 c1 = c2;
 c2 = ec1[1].a;
 ec1[1].a = ec2[1].a;
end ExpandableConnectorArrays.IntegerSized;
")})));
    end IntegerSized;


    model ParameterSized
    
        model M
            expandable connector EC
            end EC;

            parameter Integer n;

            connector C = Real;

            EC ec1[n], ec2[n];
            C c1, c2;
        equation
            connect(c1, ec1[n - 2].a);
            connect(ec1[n - 2], ec2[n - 1]);
            connect(ec2[n - 1].a, c2);
            c1 = time;
        end M;

        M m(n = 3);
    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="ParameterSized",
            description="Arrays of expandable connectors, parameter sized.",
            flatModel="
fclass ExpandableConnectorArrays.ParameterSized
 structural parameter Integer m.n = 3 /* 3 */;
 Real m.ec1[1].a;
 Real m.ec2[2].a;
 Real m.c1;
 Real m.c2;
equation
 m.c1 = time;
 m.c1 = m.c2;
 m.c2 = m.ec1[1].a;
 m.ec1[1].a = m.ec2[2].a;
end ExpandableConnectorArrays.ParameterSized;
")})));
    end ParameterSized;


    model CompositeConnectors

        expandable connector EC
        end EC;

        connector C
            Real a;
            flow Real b;
        end C;

        EC ec1[3], ec2[3], ec3[3];
        C c1, c2, c3, c4, c5;
    equation
        connect(ec1, ec2);
        connect(ec2, ec3);
        connect(c1, ec1[1].x);
        connect(c2, ec1[1].y);
        connect(ec3[3].x, c3);
        connect(ec3[3].y, c4);
        connect(ec2[2].x, c5);

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="CompositeConnectors",
            description="Expandable connector arrays: composite connectors.",
            flatModel="
fclass ExpandableConnectors.CompositeConnectors
 Real ec1.x.a;
 Real ec1.x.b;
 Real ec1.y.a;
 Real ec1.y.b;
 Real ec2.x.a;
 Real ec2.x.b;
 Real ec2.y.a;
 Real ec2.y.b;
 Real ec3.x.a;
 Real ec3.x.b;
 Real ec3.y.a;
 Real ec3.y.b;
 Real c1.a;
 input Real c1.b;
 Real c2.a;
 input Real c2.b;
 Real c3.a;
 input Real c3.b;
 Real c4.a;
 input Real c4.b;
 Real c5.a;
 input Real c5.b;
equation
 c1.a = c3.a;
 c3.a = c5.a;
 c5.a = ec1.x.a;
 ec1.x.a = ec2.x.a;
 ec2.x.a = ec3.x.a;
 - c1.b - c3.b - c5.b - ec1.x.b - ec2.x.b - ec3.x.b = 0.0;
 c2.a = c4.a;
 c4.a = ec1.y.a;
 ec1.y.a = ec2.y.a;
 ec2.y.a = ec3.y.a;
 - c2.b - c4.b - ec1.y.b - ec2.y.b - ec3.y.b = 0.0;
 ec1.x.b = 0.0;
 ec1.y.b = 0.0;
 ec2.x.b = 0.0;
 ec2.y.b = 0.0;
 ec3.x.b = 0.0;
 ec3.y.b = 0.0;
end ExpandableConnectors.CompositeConnectors;
")})));
    end CompositeConnectors;


    model Redeclare
        expandable connector EC
        end EC;

        model A
            replaceable EC ec[3];
        end A;

        connector C = Real;

        A a1(redeclare EC ec);
        A a2(redeclare EC ec);
        A a3(redeclare EC ec);
        C c1, c2;
    equation
        connect(c1, a1.ec.b);
        connect(a1.ec[1], a2.ec[2]);
        connect(a2.ec[2], a3.ec[3]);
        connect(a3.ec[3].b, c2);

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="Redeclare",
            description="Expandable connector arrays: redeclaring expandable connectors.",
            flatModel="
fclass ExpandableConnectors.Redeclare
 Real a1.ec.b;
 Real a2.ec.b;
 Real a3.ec.b;
 Real c1;
 Real c2;
equation
 a1.ec.b = a2.ec.b;
 a2.ec.b = a3.ec.b;
 a3.ec.b = c1;
 c1 = c2;
end ExpandableConnectors.Redeclare;
")})));
    end Redeclare;


    model BindingExpressionComposite
        expandable connector EC
        end EC;

        connector C
            Real x;
            Real y;
        end C;

        EC ec1[1], ec2[2], ec3[3];
        C c1(x = 1, y = 2);
        C c2;
    equation
        connect(c1, ec1[1].a);
        connect(ec1[1], ec2[2]);
        connect(ec2[2], ec3[3]);
        connect(ec3[3].a, c2);

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="BindingExpressionComposite",
            description="Adding to expandable connectors from composite with binding exps",
            flatModel="
fclass ExpandableConnectorArrays.BindingExpressionComposite
 Real ec1[1].a.x;
 Real ec1[1].a.y;
 Real ec2[2].a.x;
 Real ec2[2].a.y;
 Real ec3[3].a.x;
 Real ec3[3].a.y;
 Real c1.x = 1;
 Real c1.y = 2;
 Real c2.x;
 Real c2.y;
equation
 c1.x = c2.x;
 c2.x = ec1[1].a.x;
 ec1[1].a.x = ec2[2].a.x;
 ec2[2].a.x = ec3[3].a.x;
 c1.y = c2.y;
 c2.y = ec1[1].a.y;
 ec1[1].a.y = ec2[2].a.y;
 ec2[2].a.y = ec3[3].a.y;
end ExpandableConnectorArrays.BindingExpressionComposite;
")})));
    end BindingExpressionComposite;


    model ConnectorArray
        expandable connector EC
        end EC;

        connector C = Real[2];

        model M
            EC ec1[3], ec2[3], ec3[3];
            C c1, c2;
        equation
            connect(c1, ec1[1].a);
            connect(ec1, ec2);
            connect(ec2, ec3);
            connect(ec3[3].a, c2);
        end M;

        M m[2];

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="ConnectorArray",
            description="Expandable connector arrays: adding entire array without subscripts, within array component.",
            flatModel="
fclass ExpandableConnectors.ConnectorArray
 ExpandableConnectors.Expandable3.C m[1].ec1.a[2];
 ExpandableConnectors.Expandable3.C m[1].ec2.a[2];
 ExpandableConnectors.Expandable3.C m[1].ec3.a[2];
 ExpandableConnectors.Expandable3.C m[1].c1[2];
 ExpandableConnectors.Expandable3.C m[1].c2[2];
 ExpandableConnectors.Expandable3.C m[2].ec1.a[2];
 ExpandableConnectors.Expandable3.C m[2].ec2.a[2];
 ExpandableConnectors.Expandable3.C m[2].ec3.a[2];
 ExpandableConnectors.Expandable3.C m[2].c1[2];
 ExpandableConnectors.Expandable3.C m[2].c2[2];
equation
 m[1].c1[1] = m[1].c2[1];
 m[1].c2[1] = m[1].ec1.a[1];
 m[1].ec1.a[1] = m[1].ec2.a[1];
 m[1].ec2.a[1] = m[1].ec3.a[1];
 m[1].c1[2] = m[1].c2[2];
 m[1].c2[2] = m[1].ec1.a[2];
 m[1].ec1.a[2] = m[1].ec2.a[2];
 m[1].ec2.a[2] = m[1].ec3.a[2];
 m[2].c1[1] = m[2].c2[1];
 m[2].c2[1] = m[2].ec1.a[1];
 m[2].ec1.a[1] = m[2].ec2.a[1];
 m[2].ec2.a[1] = m[2].ec3.a[1];
 m[2].c1[2] = m[2].c2[2];
 m[2].c2[2] = m[2].ec1.a[2];
 m[2].ec1.a[2] = m[2].ec2.a[2];
 m[2].ec2.a[2] = m[2].ec3.a[2];

public
 type ExpandableConnectors.ConnectorArray.C = Real;
end ExpandableConnectors.ConnectorArray;
")})));
    end ConnectorArray;


    model ConnectorSlice
        expandable connector EC
        end EC;

        connector C = Real;

        EC ec1[3], ec2[3], ec3[3];
        C c[4];
    equation
        connect(c[1:2], ec1.a);
        connect(ec1, ec2);
        connect(ec2, ec3);
        connect(ec3.a, c[3:4]);

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="ConnectorSlice",
            description="Expandable connectors: connect to slice",
            flatModel="
fclass ExpandableConnectors.ConnectorSlice
 Real ec1.a[2];
 Real ec2.a[2];
 Real ec3.a[2];
 Real c[4];
equation
 c[1] = c[3];
 c[3] = ec1.a[1];
 ec1.a[1] = ec2.a[1];
 ec2.a[1] = ec3.a[1];
 c[2] = c[4];
 c[4] = ec1.a[2];
 ec1.a[2] = ec2.a[2];
 ec2.a[2] = ec3.a[2];
end ExpandableConnectors.ConnectorSlice;
")})));
    end ConnectorSlice;


    model SliceToSlice
        expandable connector EC
        end EC;

        connector C = Real;

        EC ec1[2], ec2[3], ec3[4];
        C c[4];
    equation
        connect(c[1:2], ec1.a);
        connect(ec1[1:2], ec2[2:3]);
        connect(ec2[2:3], ec3[3:4]);
        connect(ec3.a, c[3:4]);

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="SliceToSlice",
            description="Expandable connectors: connect slice to slice",
            flatModel="
fclass ExpandableConnectors.SliceToSlice
 Real ec1.a[2];
 Real ec2.a[2];
 Real ec3.a[2];
 Real c[4];
equation
 c[1] = c[3];
 c[3] = ec1.a[1];
 ec1.a[1] = ec2.a[1];
 ec2.a[1] = ec3.a[1];
 c[2] = c[4];
 c[4] = ec1.a[2];
 ec1.a[2] = ec2.a[2];
 ec2.a[2] = ec3.a[2];
end ExpandableConnectors.SliceToSlice;
")})));
    end SliceToSlice;


    model MatrixSlices
        expandable connector EC
        end EC;

        connector C = Real;

        EC ec1[2], ec2[3];
        C c1[2], c2[2,2];
    equation
        connect(ec1[1].a[1,:], c1);
        connect(ec1[2].b[:,1:2], c2);
        connect(ec2[3].a[:,1:2], c2);

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="MatrixSlices",
            description="Connecting to slice with colon of array in expandable connector array.",
            flatModel="
fclass ExpandableConnectorArrays.MatrixSlices
 Real ec1[1].a[1,2];
 Real ec1[2].b[2,2];
 Real ec2[3].a[2,2];
 Real c1[2];
 Real c2[2,2];
equation
 c1[1] = ec1[1].a[1,1];
 c1[2] = ec1[1].a[1,2];
 c2[1,1] = ec1[2].b[1,1];
 ec1[2].b[1,1] = ec2[3].a[1,1];
 c2[1,2] = ec1[2].b[1,2];
 ec1[2].b[1,2] = ec2[3].a[1,2];
 c2[2,1] = ec1[2].b[2,1];
 ec1[2].b[2,1] = ec2[3].a[2,1];
 c2[2,2] = ec1[2].b[2,2];
 ec1[2].b[2,2] = ec2[3].a[2,2];
end ExpandableConnectorArrays.MatrixSlices;
")})));
    end MatrixSlices;


    model MemberAccess
        expandable connector EC
            Real x;
        end EC;

        connector C = Real;

        C c1, c2, c3;
        EC ec[3];
        Real x, y, z;
    equation
        connect(c1, ec[1].a);
        connect(c2, ec[2].b);
        connect(c3, ec[3].c);
        connect(ec[1], ec[2]);      // TODO: Change this if Github issue ModelicaSpecification#2345
        connect(ec[2], ec[3]);      //       resolves to EC arrays being implicitly connected.

        x = ec[1].a;
        y = ec[2].b;
        z = ec[3].c;

        c1 = time;
        c2 = time;
        c3 = time;

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="MemberAccess",
            description="Using members of expandable connector array.",
            flatModel="
fclass ExpandableConnectorArrays.MemberAccess
 Real ec[1].a;
 Real ec[2].b;
 Real ec[3].c;
 Real c1;
 Real c2;
 Real c3;
 Real x;
 Real y;
 Real z;
equation
 c[1] = ec[1].a;
 c[2] = ec[2].b;
 c[3] = ec[3].c;
 x = ec[1].a;
 y = ec[2].b;
 z = ec[3].c;
 ec[1].a = c1;
 ec[2].b = c2;
 ec[3].c = c3;
 c1 = time;
 c2 = time;
 c3 = time;
end ExpandableConnectorArrays.MemberAccess;
")})));
    end MemberAccess;


    // TODO: Remove this if Github issue ModelicaSpecification#2345 resolves
    //       to EC arrays *not* being implicitly corrected.
    model MemberAccessImplicit
        expandable connector EC
            Real x;
        end EC;

        connector C = Real;

        C c1, c2, c3;
        EC ec[3];
        Real x, y, z;
    equation
        connect(c1, ec[1].a);
        connect(c2, ec[2].b);
        connect(c3, ec[3].c);
        connect(ec[1], ec[2]);
        connect(ec[2], ec[3]);

        x = ec[1].b;
        y = ec[2].c;
        z = ec[3].a;

        c1 = time;
        c2 = time;
        c3 = time;

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="MemberAccessImplicit",
            description="Using members of expandable connector array.",
            flatModel="
fclass ExpandableConnectorArrays.MemberAccessImplicit
 Real ec[1].a;
 Real ec[2].b;
 Real ec[3].c;
 Real c1;
 Real c2;
 Real c3;
 Real x;
 Real y;
 Real z;
equation
 c[1] = ec[1].b;
 c[2] = ec[2].c;
 c[3] = ec[3].a;
 x = ec[1].b;
 y = ec[2].c;
 z = ec[3].a;
 ec[1].b = c1;
 ec[2].c = c2;
 ec[3].a = c3;
 c1 = time;
 c2 = time;
 c3 = time;
end ExpandableConnectorArrays.MemberAccessImplicit;
")})));
    end MemberAccessImplicit;


    model NestedAccess
        expandable connector EC1
            EC2 ec2[2];
        end EC1;

        expandable connector EC2
        end EC2;

        connector C = Real;

        EC1 ec1[3];
        C c1, c2;
    equation
        connect(c1, ec1.ec2[2].a);
        connect(c2, ec1.ec2[1].b);

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="NestedAccess",
            description="Nested declared expandable connector ",
            flatModel="
fclass ExpandableConnectors.NestedAccess
 Real ec1.ec2.a;
 Real c;
equation
 c = ec1.ec2.a;
end ExpandableConnectors.NestedAccess;
")})));
    end NestedAccess;


    model NestedDisconnected
        expandable connector EC1
            C1 c1;
        end EC1;

        connector C1
            EC2 ec2;
            Real x;
        end C1;

        expandable connector EC2
        end EC2;

        connector C2 = Real;

        EC1 ec1;
        C2 c2;

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="NestedDisconnected",
            description="Nested declared expandable connector arrays: not connected.",
            flatModel="
fclass ExpandableConnectorArrays.NestedDisconnected
 Real c2;
end ExpandableConnectorArrays.NestedDisconnected;
")})));
    end NestedDisconnected;


    model NestedAccesses
        expandable connector EC1
            EC2 ec2[4];
        end EC1;

        expandable connector EC2
        end EC2;

        connector C = Real;

        EC1 ec1[3];
        C c1, c2;
    equation
        connect(c1, ec1[1].ec2[3].a);
        connect(c2, ec1[1].b);

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="NestedAccesses",
            description="Nested declared expandable connectors: adding members to both levels",
            flatModel="
fclass ExpandableConnectors.NestedAccesses
 Real ec1.b;
 Real ec1.ec2.a;
 Real c1;
 Real c2;
equation
 c1 = ec1.ec2.a;
 c2 = ec1.b;
end ExpandableConnectors.NestedAccesses;
")})));
    end NestedAccesses;


    model LoopedConnection
        expandable connector EC
        end EC;

        connector C = Real;

        model M
            C c;
        end M;

        parameter Integer n = 4;

        EC ec[n];
        M m[n];
    equation
        for i in 1:(n-2) loop
            connect(ec[i], ec[i+2]);
            connect(ec[i].a, m[i].c);
        end for;
        connect(ec[end-1].a, m[end-1].c);
        connect(ec[end].a, m[end].c);

    annotation(__JModelica(UnitTesting(tests={
        FlatteningTestCase(
            name="LoopedConnection",
            description="Connecting to expandable connector in for loop",
            flatModel="
fclass ExpandableConnectorArrays.LoopedConnection
 structural parameter Integer n = 4 /* 4 */;
 Real ec[1].a;
 Real ec[2].a;
 Real ec[3].a;
 Real ec[4].a;
 Real m[1].c;
 Real m[2].c;
 Real m[3].c;
 Real m[4].c;
equation
 ec[1].a = ec[3].a;
 ec[3].a = m[1].c;
 m[1].c = m[3].c;
 ec[2].a = ec[4].a;
 ec[4].a = m[2].c;
 m[2].c = m[4].c;
end ExpandableConnectorArrays.LoopedConnection;
")})));
    end LoopedConnection;


package Error

    model NoConnectionUnknownSize
        expandable connector EC
        end EC;

        EC ec1[:], ec2[:];
    equation
        connect(ec1, ec2);

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="NoConnectionUnknownSize",
            description="Expandable to expandable.",
            errorMessage="
Error at line 7, column 9, in file '...', ARRAY_SIZE_MISMATCH_IN_CONNECT:
  Sizes do not match in connection, size of 'ec1' is [:] and size of 'ec2' is [:]
")})));
    end NoConnectionUnknownSize;

    model MismatchingSize
        expandable connector EC
        end EC;

        parameter Integer n = 2;

        EC ec1[n], ec2[n + 1];
    equation
        connect(ec1, ec2);

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Error_MismatchingSize",
            description="Mismatching sizes.",
            errorMessage="
Error at line 9, column 9, in file '...', ARRAY_SIZE_MISMATCH_IN_CONNECT:
  Sizes do not match in connection, size of 'ec1' is [2] and size of 'ec2' is [3]
")})));
    end MismatchingSize;


    model ExpandableToExpandableArray
        expandable connector EC
        end EC;

        connector C = Real;

        parameter Integer n = 2;

        EC ec1, ec2[n];
        C c1;
    equation
        connect(c1, ec2[2].a);
        connect(ec1, ec2);
        c1 = time;

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Error_ExpandableToExpandableArray",
            description="Attempt to connect an expandable connector to an
                         expandable connector array cell element.",
            errorMessage="
Error at line 13, column 9, in file '...', ARRAY_SIZE_MISMATCH_IN_CONNECT:
  Sizes do not match in connection, size of 'ec1' is scalar and size of 'ec2' is [2]
")})));
    end ExpandableToExpandableArray;

    model ExpandableToExpandableArrayCellElement
        expandable connector EC
        end EC;

        connector C = Real;

        parameter Integer n = 2;

        EC ec1[n], ec2[n];
        C c1;
    equation
        connect(ec1, ec2[2]);
        connect(c1, ec2[2].a);

    annotation(__JModelica(UnitTesting(tests={
        ErrorTestCase(
            name="Error_ExpandableToExpandableArrayCellElement",
            description="Mismatching sizes.",
            errorMessage="
Error at line 12, column 9, in file '...', ARRAY_SIZE_MISMATCH_IN_CONNECT:
  Sizes do not match in connection, size of 'ec1' is [2] and size of 'ec2[2]' is scalar
")})));
    end ExpandableToExpandableArrayCellElement;


end Error;



end ExpandableConnectorArrays;