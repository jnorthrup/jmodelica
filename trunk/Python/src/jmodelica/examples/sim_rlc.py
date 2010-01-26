#!/usr/bin/python
# -*- coding: utf-8 -*-

# Import the JModelica.org Python packages
import os
import jmodelica
import jmodelica.jmi as jmi
from jmodelica.compiler import ModelicaCompiler
from jmodelica.initialization.ipopt import NLPInitialization
from jmodelica.initialization.ipopt import InitializationOptimizer
from jmodelica.tests import get_example_path

# Import numerical libraries
import numpy as N
import ctypes as ct
import matplotlib.pyplot as plt


def run_demo(with_plots=True):

    mc = ModelicaCompiler()

    # Comile the Modelica model first to C code and
    # then to a dynamic library
    mofile = 'RLC_Circuit.mo'
    optpackage = 'RLC_Circuit'
    path = get_example_path()
    os.chdir(path)

    mc.compile_model(os.path.join(path, mofile),
                     optpackage,
                     target='ipopt')

    # Load the dynamic library and XML data
    rlc=jmi.Model('RLC_Circuit')


    # Create DAE initialization object.
    init_rlc = NLPInitialization(rlc)
        
    # Create an Ipopt solver object for the DAE initialization system
    init_rlc_ipopt = InitializationOptimizer(init_rlc)

    # Solve the DAE initialization system with Ipopt
    init_rlc_ipopt.init_opt_ipopt_solve()

    # Simulate system...

    # Verify solution by loading result file generated by dymola
    res = jmodelica.io.ResultDymolaBinary('RLC_Circuit_dymola.mat')

    # Get result variables
    V_in = res.get_variable_data('sine.y')
    V_resistor = res.get_variable_data('resistor.v')
    I_inductor1 = res.get_variable_data('inductor1.i')

    assert N.abs(V_in.x[-1]*1.e14 - 9.2128345) < 1e-3, \
            "Wrong value of V_in function in sim_rlc.py"  

    assert N.abs(V_resistor.x[-1]*1.e1 - 1.5932719) < 1e-3, \
            "Wrong value of V_resistor function in sim_rlc.py"  

    assert N.abs(I_inductor1.x[-1]*1.e3 - 4.1748262) < 1e-3, \
            "Wrong value of I_inductor1 function in sim_rlc.py"  


    if with_plots:
        plt.figure(1)
        plt.clf()
        plt.hold(True)
        plt.plot(V_in.t,V_in.x)
        plt.plot(V_resistor.t,V_resistor.x)
        plt.plot(I_inductor1.t,I_inductor1.x)
        plt.show()
     

if __name__ == "__main__":
    run_demo()
    
