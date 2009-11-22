#!/usr/bin/python
# -*- coding: utf-8 -*-

# Import library for path manipulations
import os.path

# Import the JModelica.org Python packages
import jmodelica
import jmodelica.jmi as jmi
from jmodelica.compiler import OptimicaCompiler
from jmodelica.optimization import ipopt

# Import numerical libraries
import numpy as N
import ctypes as ct
import matplotlib.pyplot as plt

import scipy.integrate as int

def run_demo(with_plots=True):
    """Optimal control of the quadruple tank process."""

    oc = OptimicaCompiler()
    oc.set_boolean_option('state_start_values_fixed',True)
    
    curr_dir = os.path.dirname(os.path.abspath(__file__));
    
    # Compile the Optimica model first to C code and
    # then to a dynamic library
    oc.compile_model(curr_dir+"/files/QuadTank.mo",
                     "QuadTank_pack.QuadTank_Opt",
                     target='ipopt')

    # Load the dynamic library and XML data
    qt=jmi.Model("QuadTank_pack_QuadTank_Opt")

    # Define inputs for operating point A
    u_A = N.array([2.,2])

    # Define inputs for operating point B
    u_B = N.array([2.5,2.5])

    x_0 = N.ones(4)*0.01

    def res(y,t):
        for i in range(4):
            qt.get_x()[i] = y[i]
        qt.jmimodel.ode_f()
        return qt.get_dx()[0:4]

    # Compute stationary state values for operating point A
    qt.set_u(u_A)
    #qt.getPI()[21] = u_A[0]
    #qt.getPI()[22] = u_A[1]
    
    t_sim = N.linspace(0.,2000.,500)
    y_sim = int.odeint(res,x_0,t_sim)

    x_A = y_sim[-1,:]

    if with_plots:
        # Plot
        plt.figure(1)
        plt.clf()
        plt.subplot(211)
        plt.plot(t_sim,y_sim[:,0:4])
        plt.grid()
    
    # Compute stationary state values for operating point A
    qt.set_u(u_B)
    
    t_sim = N.linspace(0.,2000.,500)
    y_sim = int.odeint(res,x_0,t_sim)
    
    x_B = y_sim[-1,:]

    if with_plots:
        # Plot
        plt.figure(1)
        plt.subplot(212)
        plt.plot(t_sim,y_sim[:,0:4])
        plt.grid()
        plt.show()
    
    qt.get_pi()[13] = x_A[0]
    qt.get_pi()[14] = x_A[1]
    qt.get_pi()[15] = x_A[2]
    qt.get_pi()[16] = x_A[3]
    
    qt.get_pi()[17] = x_B[0]
    qt.get_pi()[18] = x_B[1]
    qt.get_pi()[19] = x_B[2]
    qt.get_pi()[20] = x_B[3]
    qt.get_pi()[21] = u_B[0]
    qt.get_pi()[22] = u_B[1]

    # Solve optimal control problem
    
    # Initialize the mesh
    n_e = 50 # Number of elements 
    hs = N.ones(n_e)*1./n_e # Equidistant points
    n_cp = 3; # Number of collocation points in each element
    
    # Create an NLP object
    nlp = ipopt.NLPCollocationLagrangePolynomials(qt,n_e,hs,n_cp)
    
    # Create an Ipopt NLP object
    nlp_ipopt = ipopt.CollocationOptimizer(nlp)
    
    #nlp_ipopt.opt_sim_ipopt_set_string_option("derivative_test","first-order")
    nlp_ipopt.opt_sim_ipopt_set_int_option("max_iter",500)
    
    # Solve the optimization problem
    nlp_ipopt.opt_sim_ipopt_solve()
    
    # Write to file. The resulting file can also be
    # loaded into Dymola.
    nlp.export_result_dymola()
    
    # Load the file we just wrote to file
    res = jmodelica.io.ResultDymolaTextual('QuadTank_pack_QuadTank_Opt_result.txt')

    # Extract variable profiles
    x1=res.get_variable_data('x1')
    x2=res.get_variable_data('x2')
    x3=res.get_variable_data('x3')
    x4=res.get_variable_data('x4')
    u1=res.get_variable_data('u1')
    u2=res.get_variable_data('u2')

    cost=res.get_variable_data('cost')

    assert N.abs(cost.x[-1] - 5.0333257e+02) < 1e-3, \
           "Wrong value of cost function in quadtank.py"  

    if with_plots:
        # Plot
        plt.figure(2)
        plt.clf()
        plt.subplot(411)
        plt.plot(x1.t,x1.x)
        plt.grid()
        plt.ylabel('x1')
        
        plt.subplot(412)
        plt.plot(x2.t,x2.x)
        plt.grid()
        plt.ylabel('x2')
        
        plt.subplot(413)
        plt.plot(x3.t,x3.x)
        plt.grid()
        plt.ylabel('x3')
        
        plt.subplot(414)
        plt.plot(x4.t,x4.x)
        plt.grid()
        plt.ylabel('x4')
        plt.show()
        
        plt.figure(3)
        plt.clf()
        plt.subplot(211)
        plt.plot(u1.t,u1.x)
        plt.grid()
        plt.ylabel('u1')
        
        plt.subplot(212)
        plt.plot(u2.t,u2.x)
        plt.grid()
        plt.ylabel('u2')
        
    if __name__ == "__main__":
        run_demo()
