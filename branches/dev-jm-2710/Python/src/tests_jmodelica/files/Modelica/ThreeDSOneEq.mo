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
end ThreeDSOneEq;