#!/usr/bin/env python 
# -*- coding: utf-8 -*-
"""
This file contains code for wrapping our new Integrator package 
to Jmodelica.
"""

import numpy as N
import jmodelica.io as io

try:
    from Integrator.Explicit_ODE import CVode
    from Integrator.Implicit_ODE import IDA
except ImportError:
    print 'Could not load Integrator package.'

class Simulator_Exception(Exception):
    """
    An exception class for Simulator.
    """
    pass

class Simulator(object):
    """
    An object oriented interface for simulating JModelica.org models.
    """
    
    sup_solvers = ['IDA','CVode'] #Supported solvers.
    
    def __init__(self, model, solver, t0=0.0):
        """
        Initiates the solver.
        """
        self._model = model
        self._model.t = t0
        
        if solver in self.sup_solvers:
            if solver == self.sup_solvers[0]:
                
                y0 = N.append(self._model.x,self._model.w)
                yd0 = N.append(self._model.dx,[0]*len(self._model.w))
                
                self.solver = IDA(self.f_DAE, y0, yd0, self._model.t)
                self.solver.algvar = [1.0]*len(self._model.x) + [0.0]*len(self._model.w) #Sets the algebraic components of the model
        else:
            raise Simulator_Exception('The solver is not supported. '\
            'The supported solvers are the following: %s' %sup_solvers)
        
    def run(self, tfinal, ncp=0):
        """
        This is the method that runs the simulation.
        
            tfinal = Time to integrate to.
            ncp = Number of communication points.
        """
        self.solver(tfinal,ncp) #Runs the simulation
        
    def plot(self):
        """
        This method plots the solution.
        """
        self.solver.plot()
        
    def write_data(self):
        """
        Writes simulation data to file.
        """
        t = N.array(self.solver.t)
        
        y = N.array(self.solver.y)
        yd = N.array(self.solver.yd)
        u = N.ones((len(t),len(self._model.u)))*self._model.u
        # extends the time array with the states columnwise
        data = N.c_[t,yd[:,0:len(self._model.dx)]]
        data = N.c_[data, y[:,0:len(self._model.x)]]
        data = N.c_[data, u]
        data = N.c_[data, y[:,len(self._model.x):len(self._model.x)+len(self._model.w)]]
        
        io.export_result_dymola(self._model,data)
        

    def f_DAE(self, t, y, yd, sw=None):
        """
        The residual function for an DAE problem.
        """
        #Moving data to the model
        self._model.t = t
        self._model.x = y[0:len(self._model.x)]
        self._model.w = y[len(self._model.x):len(y)]
        self._model.dx = yd[0:len(self._model.dx)]

        #Evaluating the residual function
        residual = N.array([.0]*len(y))
        self._model.jmimodel.dae_F(residual)
        
        return residual
        



class IDA_wrapper(object):
    pass
    
    
class CVode_wrapper(object):
    pass
