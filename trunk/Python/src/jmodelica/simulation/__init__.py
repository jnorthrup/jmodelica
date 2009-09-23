#!/usr/bin/env python 
# -*- coding: utf-8 -*-
"""Contains code used for simulation of models.

This currently only includes an interface to SUNDIALS.
"""
__all__ = ['sundials']


class SimulationException(Exception):
    """ A simulation exception. """
    pass

class Simulator(object):
    """An object oriented interface for simulating JModelica.org models."""
    
    def __init__(self, model=None, start_time=None, final_time=None,
                 time_step=0.2, return_last=False, verbosity=0):
        
        # Setting members
        self._model = model
        
        # Setting defaults
        self.set_return_last(return_last)
        self.set_time_step(time_step)
        self.set_verbosity(verbosity)
        if start_time is not None:
            self._start_time = start_time
        elif model.opt_interval_starttime_fixed():
            self._start_time = model.opt_interval_get_start_time()
        else:
            self._start_time = None
        if final_time is not None:
            self._final_time = final_time
        elif model.opt_interval_finaltime_fixed() and final_time is None:
            self._final_time = model.opt_interval_get_final_time()
        else:
            self._final_time = None
            
        if self._final_time is not None and self._start_time is not None and \
            self._start_time >= self._final_time:
                raise SimulationException('Start time must be before '
                                                  'end time.')
        
                
                     
    def set_time_step(self, time_step):
        """Sets the time step returned by self.get_solution()."""
        if time_step <= 0:
            raise SimulationException("Time step size must be "
                                              "positive.")
        self._time_step = time_step
        
    def get_time_step(self):
        """Returns the time step returned by self.get_solution()."""
        return self._time_step
        
    time_step = property(get_time_step, set_time_step, 
                         doc="The time step size when SUNDIALS should return.")
    
    
    def set_model(self, model):
        """Set the model on which the simulation should be done on.
        
        The model needs to be of type jmodelica.jmi.Model.
        """
        if model is None:
            raise SimulationException("model must not be none")
            
        if self.get_sensitivity_analysis():
            # A new model will require a new sensivity indices class will have
            # to be reinitialized.
            self._set_sensitivity_indices(_SensivityIndices(model))
            
        self._model = model
        
    def get_model(self):
        """Returns the model on which the simulation is being done."""
        return self._model
        
    model = property(get_model, set_model, doc="The model to simulate.")
    
    def set_return_last(self, return_last):
        """Set this to True if only the last time point should be returned
           after simulation by self.get_solution(). False otherwise.
        """
        if return_last==1 or return_last==True:
            self._return_last = True
        elif return_last==0 or return_last==False:
            self._return_last = False
        else:
            raise SimulationException("return_last must be either "
                                              "True, False, 1 or 0.")
                                              
    def get_return_last(self):
        """Returns True if only the last time point should be returned
           after simulation by self.get_solution(), False otherwise.
        """
        return self._return_last
        
    return_last = property(get_return_last, set_return_last,
                           doc="True if only the last time point should be "
                               "returned after simulation by "
                               "self.get_solution(). False otherwise.")
     
    def get_start_time(self):
        """Returns the simulation start time"""
        return self._start_time
        
    def get_final_time(self):
        """Returns the simulation end time"""
        return self._final_time
     
    def set_simulation_interval(self, start_time, final_time):
        """Set the interval through the simulation will be made."""
        if start_time >= final_time:
            raise SimulationException("start time must be earlier "
                                              "than the final time.")
        self._start_time = start_time
        self._final_time = final_time
        
    def get_simulation_interval(self):
        """Return the simulation interval.
        
        The simulation interval consists of a tuple: (start_time, final_time).
        """
        return self._start_time, self._final_time
     
    # Verbosity levels
    QUIET = 0
    WHISPER = 1
    NORMAL = 2
    LOUD = 3
    SCREAM = 4
    VERBOSE_VALUES = [QUIET, WHISPER, NORMAL, LOUD, SCREAM]
    def get_verbosity(self):
        """Return the verbosity of the simulator."""
        return self._verbosity
        
    def set_verbosity(self, verbosity):
        """Specify how much output should be given: 0 <= verbosity <= 4.
        
        The verbosity levels can also be specified using the constants:
         * SundialsOdeSimulator.QUIET
         * SundialsOdeSimulator.WHISPER
         * SundialsOdeSimulator.NORMAL
         * SundialsOdeSimulator.LOUD
         * SundialsOdeSimulator.SCREAM
         
        If the verbosity level is set to something not within the interval, an
        error is raised.
        """
        if verbosity not in self.VERBOSE_VALUES:
            raise SimulationException("invalid verbosity value")
        self._verbosity = verbosity
        
    verbosity = property(get_verbosity, set_verbosity,
                         doc="How explicit the output should be")
    
    
