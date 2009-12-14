#!/usr/bin/env python 
# -*- coding: utf-8 -*-

import os
import numpy as N
import pylab as p
import matplotlib

import jmodelica
import jmodelica.jmi as jmi
from time import time
from jmodelica.tests import get_example_path
from jmodelica.simulation.sundials import SundialsDAESimulator
from jmodelica.compiler import ModelicaCompiler
from jmodelica.initialization.ipopt import NLPInitialization
from jmodelica.initialization.ipopt import InitializationOptimizer

from jmodelica.simulation.assimulo import Simulator

def run_demo(with_plots=True):
    """
    An example on how to simulate a model using a DAE simulator with 
    pySundials and with Assimulo. The model used is made by Maja Djačić.
    """

    curr_dir = os.path.dirname(os.path.abspath(__file__));

    m_name = 'SolAngles'
    mofile = curr_dir+'/files/SolAngles.mo'
    
    
    mc = ModelicaCompiler()
    
    # Compile the Modelica model first to C code and
    # then to a dynamic library
    mc.compile_model(mofile,m_name,target='ipopt')

    # Load the dynamic library and XML data
    model=jmi.Model(m_name)

    # Create DAE initialization object
    init_nlp = NLPInitialization(model)
    
    # Create an Ipopt solver object for the DAE initialization system
    init_nlp_ipopt = InitializationOptimizer(init_nlp)
        
    # Solve the DAE initialization system with Ipopt
    init_nlp_ipopt.init_opt_ipopt_solve()

    simulator = SundialsDAESimulator(model, verbosity=3, start_time=0.0, final_time=86400.0, time_step=1.0)
    
    #Time the run method for pySundials
    time_begin = time()
    simulator.run()
    pySundials = time()-time_begin #Elapsed time
    
    simulator.write_data()
    
    # Load the data we just wrote to file
    res = jmodelica.io.ResultDymolaTextual('SolAngles_result.txt')
    theta = res.get_variable_data('theta')
    azim = res.get_variable_data('azim')
    N_day = res.get_variable_data('N_day')

    
    # Plot results
    p.figure(1)
    p.plot(theta.t, theta.x)
    p.xlabel('time [s]')
    p.ylabel('theta [deg]')
    p.title('Angle of Incidence on Surface')
    p.grid()
    p.show()
    
    #Simulation with the new package
    SolAng_sim = Simulator(model, 'IDA')
    SolAng_sim.reset() #Resets to the initial values from the model
    SolAng_sim.solver.make_consistency('IDA_YA_YDP_INIT') #Calculates initial values
    
    #Time the run method for assimulo
    time_begin = time()
    SolAng_sim.run(86400.0, 86400) #Simulate the same time and with the same number of output points
    #rtol and atol is by default 1.0e-6 the same as with pySundials
    assimulo = time()-time_begin #Elapsed time
    
    SolAng_sim.solver.stats_print() #Print statistics

    SolAng_sim.write_data()
    
    # Load the data we just wrote to file
    res = jmodelica.io.ResultDymolaTextual('SolAngles_result.txt')
    theta = res.get_variable_data('theta')
    azim = res.get_variable_data('azim')
    N_day = res.get_variable_data('N_day')

    
    # Plot results
    p.figure(2)
    p.plot(theta.t, theta.x)
    p.xlabel('time [s]')
    p.ylabel('theta [deg]')
    p.title('Angle of Incidence on Surface')
    p.grid()
    p.show()
    
    #Print the statistics for the timing
    print '\nElapsed time:'
    print 'pySundials: %e' %pySundials
    print 'Assimulo: %e' %assimulo

if __name__=="__main__":
    run_demo()
