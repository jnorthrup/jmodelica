package Reinit

model ReinitWriteback
	//Declaration(s)
  output Integer os( start = 0);
  output Modelica.SIunits.Time timer;


algorithm 
  when pre(os) == 0 and timer >= 10 then
    os :=1;
  elsewhen pre(os) == 1 and timer >= 10 then
    os :=0;
  end when;

equation 
  when pre(os) <> os then
    reinit(timer, 0);
  end when;

  if os == 0 then
    der(timer) = 0.5;
  else
    der(timer) = 1;
  end if;
end  ReinitWriteback;

end Reinit;
