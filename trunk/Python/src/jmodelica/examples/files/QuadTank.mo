package QuadTank_pack
	
	optimization QuadTank_Opt (objective = cost(finalTime)/* + 
1000*((x1_r - x1(finalTime))/0.05)^2 + 1000*((x2_r - x2(finalTime))/0.05)^2 + 
1000*((x3_r - x3(finalTime))/0.05)^2 + 1000*((x3_r - x3(finalTime))/0.05)^2*/,
                         startTime = 0,
                         finalTime = 50)

    // Process parameters
	parameter Modelica.SIunits.Area A1=2.8e-3, A2=3.2e-3, A3=2.8e-3, A4=3.2e-3;
	parameter Modelica.SIunits.Area a1=7.1e-6, a2=5.7e-6, a3=7.1e-6, a4=5.7e-6;
	parameter Modelica.SIunits.Acceleration g=9.81;
	parameter Real k1_nmp(unit="m/s/V") = 3.14e-6, k2_nmp(unit="m/s/V") = 3.29e-6;
	parameter Real g1_nmp=0.30, g2_nmp=0.30;

    // Initial tank levels
	parameter Modelica.SIunits.Length x1_0 = 1;
	parameter Modelica.SIunits.Length x2_0 = 1;
	parameter Modelica.SIunits.Length x3_0 = 1;
	parameter Modelica.SIunits.Length x4_0 = 1;

    // Reference values
	parameter Modelica.SIunits.Length x1_r = 1;
	parameter Modelica.SIunits.Length x2_r = 1;
	parameter Modelica.SIunits.Length x3_r = 1;
	parameter Modelica.SIunits.Length x4_r = 1;
	parameter Modelica.SIunits.Voltage u1_r = 1;
	parameter Modelica.SIunits.Voltage u2_r = 1;
	
    // Tank levels
	Modelica.SIunits.Length x1(initialGuess=4,start=x1_0,min=0.01,max=0.20);
	Modelica.SIunits.Length x2(initialGuess=4,start=x2_0,min=0.01,max=0.20);
	Modelica.SIunits.Length x3(initialGuess=4,start=x3_0,min=0.01,max=0.20);
	Modelica.SIunits.Length x4(initialGuess=4,start=x4_0,min=0.01,max=0.20);

	// Inputs
	input Modelica.SIunits.Voltage u1(initialGuess=3,min=0);
	input Modelica.SIunits.Voltage u2(initialGuess=4,min=0);

    Real cost(start=0);

  equation
    	der(x1) = -a1/A1*sqrt(2*g*x1) + a3/A1*sqrt(2*g*x3) +
					g1_nmp*k1_nmp/A1*u1;
		der(x2) = -a2/A2*sqrt(2*g*x2) + a4/A2*sqrt(2*g*x4) +
					g2_nmp*k2_nmp/A2*u2;
		der(x3) = -a3/A3*sqrt(2*g*x3) + (1-g2_nmp)*k2_nmp/A3*u2;
		der(x4) = -a4/A4*sqrt(2*g*x4) + (1-g1_nmp)*k1_nmp/A4*u1;
		
		/* see https://trac.jmodelica.org/ticket/274#comment:4 for background
		 * on these values
		 */
		der(cost) = /* 10*((x1_r - x1)/0.05)^2 + 10*((x2_r - x2)/0.05)^2 + 
10*((x3_r - x3)/0.05)^2 + 10*((x3_r - x3)/0.05)^2 +*/ ((u1_r - u1)/3)^2 + 
((u2_r - u2)/3)^2;

constraint
x1(finalTime) = x1_r;
x2(finalTime) = x2_r;
x3(finalTime) = x3_r;
x4(finalTime) = x4_r;

end QuadTank_Opt;

end QuadTank_pack;
