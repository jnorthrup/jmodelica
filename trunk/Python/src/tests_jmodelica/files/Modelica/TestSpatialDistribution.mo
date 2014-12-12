/*
    Copyright (C) 2014 Modelon AB

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

block SpatialDist
    parameter Real[:] xInit = {0.0, 1.0};
    parameter Real[:] yInit = {0.0, 0.0};
    input Real in0, in1, x;
    input Boolean pVel;
    output Real out0, out1;
equation
    (out0, out1) = spatialDistribution(in0, in1, x, pVel,
                                       initialPoints = xInit, initialValues = yInit);
end SpatialDist;

model TestForwardFlow
    block SD = SpatialDist;
    SD sd(yInit = {1, 1});
    Real x = sd.out1;
equation
    sd.in0  = time;
    sd.in1  = 0;
    sd.x    = time^2;
    sd.pVel = true;
end TestForwardFlow;

model TestBackFlow
    block SD = SpatialDist;
    SD sd;
    Real x = sd.out1;
equation
    sd.in0  = 1-time;
    sd.in1  = time;
    sd.x    = if sd.pVel then time-1 else (1-time)^2;
    sd.pVel = time >= 1;
end TestBackFlow;

model TestInitialContents
    block SD = SpatialDist;
    SD sd(xInit = {0, 0.75, 1}, yInit = {0, 1, 0});
    Real x = sd.out1;
equation
    sd.in0  = -1;
    sd.in1  = -1;
    sd.x    = time-10;
    sd.pVel = true;
end TestInitialContents;

model TestReversingFlow
    block SD = SpatialDist;
    SD sd;
    Real x = sd.out1;
equation
    sd.in0  = 0;
    sd.in1  = 1;
    sd.x    = 2*sin(time);
    sd.pVel = der(sd.x) >= 0;
end TestReversingFlow;

model TestImplicitX
    block SD = SpatialDist;
    SD sd(yInit = {0, -1});
    Real x(start = 0) = sd.x;
equation
    sd.in0  = time + time^2;
    sd.in1  = 0;
    sd.out1 = time-1;
    sd.pVel = true;
end TestImplicitX;

model TestSinusoid
    block SD = SpatialDist;
    SD sd(yInit = {1, 1});
    Real x(start = 1, fixed = true);
equation
    der(x)  = -Modelica.Constants.pi/2*sd.out1*der(sd.x);
    sd.in0  = x;
    sd.in1  = 0;
    sd.x    = time^2;
    sd.pVel = true;
end TestSinusoid;

model TestFeedLoop
    parameter Boolean usePVelEvents = true;
    block SD = SpatialDist;
    SD sd(yInit = {1, 0});
    Real x = sd.out1;
equation
    sd.in0  = -sd.out1;
    sd.in1  = -sd.out0;
    sd.x    = 4.5*sin(time);
    //sd.pVel = if usePVelEvents then der(sd.x) >= 0 else noEvent(der(sd.x) >= 0);
    //sd.pVel = noEvent(der(sd.x) >= 0);
    if usePVelEvents then
        sd.pVel = der(sd.x) >= 0;
    else
        sd.pVel = noEvent(der(sd.x) >= 0);
    end if;
end TestFeedLoop;
