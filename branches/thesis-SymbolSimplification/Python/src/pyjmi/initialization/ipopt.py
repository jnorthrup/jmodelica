#!/usr/bin/env python
# -*- coding: utf-8 -*-

#    Copyright (C) 2014 Modelon AB
#
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, version 3 of the License.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#    You should have received a copy of the GNU General Public License
#    along with this program.  If not, see <http://www.gnu.org/licenses/>.
""" 
The IPOPT solver module. 
"""
import ctypes as ct
from ctypes import byref
import numpy as N
import numpy.ctypeslib as Nct

from pyjmi.jmi import JMIException, IpoptException, _translate_value_ref, _returns_ndarray
from pyjmi.jmi import JMI_DER_CPPAD
from pyjmi.jmi_io import export_result_dymola as jmi_io_export_result_dymola

int = N.int32
N.int = N.int32

c_jmi_real_t = ct.c_double

class InitializationOptimizer(object):
    """ 
    An interface to the NLP solver Ipopt. 
    """
    
    def __init__(self, nlp_init):
        """ 
        Class for solving a DAE initialization problem my means of optimization 
        using IPOPT.
        
        Parameters::
        
            nlp_init -- 
                The NLPInitialization object.
        """
        
        self._nlp_init = nlp_init
        self._ipopt_init = ct.c_voidp()
        
        self._set_initOpt_typedefs()
        
        try:
            assert self._nlp_init._jmi_model._dll.jmi_init_opt_ipopt_new(
                byref(self._ipopt_init), self._nlp_init._jmi_init_opt) == 0, \
                   "jmi_init_opt_ipopt_new returned non-zero"
        except AttributeError as e:
            raise JMIException(
                "Can not create InitializationOptimizer object. \ "
                "Please recompile model with target='ipopt")
        
        assert self._ipopt_init.value is not None, \
               "jmi struct not returned correctly"
               
    def _set_initOpt_typedefs(self):
        try:
            self._nlp_init._jmi_model._dll.jmi_init_opt_ipopt_new.argtypes = [
                ct.c_void_p,
                ct.c_void_p]
            self._nlp_init._jmi_model._dll.jmi_init_opt_ipopt_solve.argtypes = [
                ct.c_void_p]
            self._nlp_init._jmi_model._dll.jmi_init_opt_ipopt_set_string_option.argtypes = [
                ct.c_void_p,
                ct.c_char_p,
                ct.c_char_p]
            self._nlp_init._jmi_model._dll.jmi_init_opt_ipopt_set_int_option.argtypes = [
                ct.c_void_p,
                ct.c_char_p,
                ct.c_int]
            self._nlp_init._jmi_model._dll.jmi_init_opt_ipopt_set_num_option.argtypes = [
                ct.c_void_p,
                ct.c_char_p,
                c_jmi_real_t]
            self._nlp_init._jmi_model._dll.jmi_init_opt_ipopt_get_statistics.argtypes = [
                ct.c_void_p,
                ct.POINTER(ct.c_int),
                ct.POINTER(ct.c_int),
                ct.POINTER(c_jmi_real_t),
                ct.POINTER(c_jmi_real_t)]

        except AttributeError as e:
            pass
               
    def init_opt_ipopt_solve(self):
        """ 
        Solve the NLP problem.
        """
        if self._nlp_init._jmi_model._dll.jmi_init_opt_ipopt_solve(self._ipopt_init) > 1:
            raise JMIException("Solving IPOPT failed.")
        
        # Check return status from Ipopt and raise exception if not ok
        (return_status, nbr_iters, obj_final, tot_exec_time) = self.init_opt_ipopt_get_statistics()
        # Return code should be one of (taken from IpReturnCodes.inc):
        # 0: IP_SOLVE_SUCCEEDED
        # 1: IP_ACCEPTABLE_LEVEL
        # 6: IP_FEASIBLE_POINT_FOUND
        if return_status not in (0, 1, 6):
            raise IpoptException("Ipopt failed with return code: " + str(return_status) + \
                                 " Please see Ipopt documentation for more information.")
    
    def init_opt_ipopt_set_string_option(self, key, val):
        """ 
        Set an Ipopt string option.
        
        Parameters::
        
            key -- 
                The name of the option.
            val -- 
                The value of the option.
        """
        if self._nlp_init._jmi_model._dll.jmi_init_opt_ipopt_set_string_option(
            self._ipopt_init, key, val) is not 0:
            raise JMIException(
                "The Ipopt string option " + key + " is unknown")
        
    def init_opt_ipopt_set_int_option(self, key, val):
        """ 
        Set an Ipopt integer option.
        
        Parameters::
        
            key -- 
                The name of the option.
            val -- 
                The value of the option.
        """        
        if self._nlp_init._jmi_model._dll.jmi_init_opt_ipopt_set_int_option(
            self._ipopt_init, key, val) is not 0:
            raise JMIException(
                "The Ipopt integer option " + key + " is unknown")

    def init_opt_ipopt_set_num_option(self, key, val):
        """ 
        Set an Ipopt double option.
        
        Parameters::
        
            key -- 
                The name of the option.
            val -- 
                The value of the option.
        """
        if self._nlp_init._jmi_model._dll.jmi_init_opt_ipopt_set_num_option(
            self._ipopt_init, key, val) is not 0:
            raise JMIException(
                "The Ipopt real option " + key + " is unknown")

    def init_opt_ipopt_get_statistics(self):
        """ 
        Get statistics from the last optimization run.

        Returns::
        
            return_status -- 
                The return status from IPOPT.
                
            nbr_iter -- 
                The number of iterations. 
                
            objective -- 
                The final value of the objective function.
                
            total_exec_time -- 
                The execution time.
        """
        return_code = ct.c_int()
        iters = ct.c_int()
        objective = c_jmi_real_t()
        exec_time = c_jmi_real_t()
        if self._nlp_init._jmi_model._dll.jmi_init_opt_ipopt_get_statistics(
            self._ipopt_init,
            byref(return_code),
            byref(iters),
            byref(objective),
            byref(exec_time)) is not 0:
            raise JMIException(
                "Error when retrieve statistics - optimization problem may not be solved.")
        return (return_code.value,iters.value,objective.value,exec_time.value)

class NLPInitialization(object):
    """ 
    NLP interface for a DAE initialization optimization problem.    
    """    
    def __init__(self, model, stat = 0):
        """ 
        Constructor where main data structure is created. 
        
        Initial guesses, lower and upper bounds and linearity information is set 
        for optimized parameters, derivatives, states, inputs and algebraic 
        variables. These values are taken from the XML files created at 
        compilation.
        
        Parameters::
        
            model -- 
                The pyjmi.jmi.JMUModel object.
        """
        self._jmi_init_opt = ct.c_voidp() 
        self._model = model
        self._jmi_model = model.jmimodel

        self._n_p_free = 0
        self._p_free_indices = N.ones(self._n_p_free,dtype=int)

        self._n_p_opt=model.jmimodel.opt_get_n_p_opt()

        # Initialization
        _p_opt_start = N.zeros(self._n_p_opt) 
        _p_free_start = N.zeros(self._n_p_free) # Not supported
        _dx_start = N.zeros(model._n_real_dx.value)
        _x_start = N.zeros(model._n_real_x.value)
        _u_start = N.zeros(model._n_real_u.value)
        _w_start = N.zeros(model._n_real_w.value)
    
        # Bounds
        _p_opt_lb = N.zeros(self._n_p_opt) 
        _p_free_lb = -1.0e20*N.ones(self._n_p_free) # Not supported
        _dx_lb = -1.0e20*N.ones(model._n_real_dx.value)
        _x_lb = -1.0e20*N.ones(model._n_real_x.value)
        _u_lb = -1.0e20*N.ones(model._n_real_u.value)
        _w_lb = -1.0e20*N.ones(model._n_real_w.value)

        _p_opt_ub = N.zeros(self._n_p_opt) 
        _p_free_ub = 1.0e20*N.ones(self._n_p_free)
        _dx_ub = 1.0e20*N.ones(model._n_real_dx.value)
        _x_ub = 1.0e20*N.ones(model._n_real_x.value)
        _u_ub = 1.0e20*N.ones(model._n_real_u.value)
        _w_ub = 1.0e20*N.ones(model._n_real_w.value)


        # Bounds
        _p_opt_lb = -1.0e20*N.ones(self._n_p_opt)
        _dx_lb = -1.0e20*N.ones(model._n_real_dx.value)
        _x_lb = -1.0e20*N.ones(model._n_real_x.value)
        _u_lb = -1.0e20*N.ones(model._n_real_u.value)
        _w_lb = -1.0e20*N.ones(model._n_real_w.value)
        
        _p_opt_ub = 1.0e20*N.ones(self._n_p_opt)
        _dx_ub = 1.0e20*N.ones(model._n_real_dx.value)
        _x_ub = 1.0e20*N.ones(model._n_real_x.value)
        _u_ub = -1.0e20*N.ones(model._n_real_u.value)
        _w_ub = 1.0e20*N.ones(model._n_real_w.value)

        if stat==0:
            self._model._set_xml_start_values(
                _p_opt_start, _dx_start, _x_start, _u_start, _w_start)
        else:
            self._model._set_initial_values(
                _p_opt_start, _dx_start, _x_start, _u_start, _w_start)
        self._model._set_lb_values(_p_opt_lb, _dx_lb, _x_lb, _u_lb, _w_lb)
        self._model._set_ub_values(_p_opt_ub, _dx_ub, _x_ub, _u_ub, _w_ub)

        # Overwrite input values with the ones set in the model: the
        # user may have set these. Should be done for all variables?
        for i in range(len(_u_start)):
            _u_start[i] = self._model.jmimodel.get_real_u()[i]
                    
        _linearity_information_provided = 1;
        _p_opt_lin = N.ones(model._n_p_opt,dtype=int)
        _p_free_lin = N.ones(0,dtype=int)
        _dx_lin = N.ones(model._n_real_dx.value,dtype=int)
        _x_lin = N.ones(model._n_real_x.value,dtype=int)
        _u_lin = N.ones(model._n_real_u.value,dtype=int)        
        _w_lin = N.ones(model._n_real_w.value,dtype=int)
        _dx_tp_lin = N.ones(model._n_real_dx.value*model._n_tp.value,dtype=int)
        _x_tp_lin = N.ones(model._n_real_x.value*model._n_tp.value,dtype=int)
        _u_tp_lin = N.ones(model._n_real_u.value*model._n_tp.value,dtype=int)        
        _w_tp_lin = N.ones(model._n_real_w.value*model._n_tp.value,dtype=int)

        self._model._set_lin_values(_p_opt_lin, _dx_lin, _x_lin, _u_lin, _w_lin, 
                                    _dx_tp_lin, _x_tp_lin, _u_tp_lin, _w_tp_lin)

        # Modify the linearity information in the case of initialization.
        # All states and algebraics with fixed=false end up in the
        # quadratic cost function in the initialization problem and
        # are thus non-linear.

        if stat==0:
            # x: differentiated variables
            fixeds = self._model._xmldoc.get_x_fixed(include_alias=False)
            for fix in fixeds:
                if fix[1] == False:
                    (z_i, ptype) = _translate_value_ref(fix[0])
                    i_x = z_i - self._model._offs_real_x.value
                    _x_lin[i_x] = 0
                            
            # w: algebraic
            fixeds = self._model._xmldoc.get_w_fixed(include_alias=False)
            for fix in fixeds:
                if fix[1] == False:
                    (z_i, ptype) = _translate_value_ref(fix[0])
                    i_w = z_i - self._model._offs_real_w.value
                    _w_lin[i_w] = 0
        
        self._set_typedef_init_opt_new()
#        try:       
        assert model.jmimodel._dll.jmi_init_opt_new(
            byref(self._jmi_init_opt), 
            model.jmimodel._jmi,
            self._n_p_free,self._p_free_indices,
            _p_opt_start, 
            _p_free_start, 
            _dx_start, 
            _x_start,
            _w_start,
            _p_opt_lb, 
            _p_free_lb, 
            _dx_lb, 
            _x_lb,
            _w_lb,
            _p_opt_ub, 
            _p_free_ub, 
            _dx_ub, 
            _x_ub, 
            _w_ub, 
            _linearity_information_provided, 
            _p_opt_lin, 
            _p_free_lin, 
            _dx_lin, 
            _x_lin, 
            _w_lin, 
            JMI_DER_CPPAD,stat) is 0, \
                " jmi_opt_lp_new returned non-zero."
        #        except AttributeError as e:
#             raise JMIException("Can not create NLPInitialization object.")
        assert self._jmi_init_opt.value is not None, \
            "jmi_init_opt struct has not returned correctly."
            
        self._set_nlpInit_typedefs()

    def _set_typedef_init_opt_new(self):
        try:
            self._jmi_model._dll.jmi_init_opt_new.argtypes = [
                ct.c_void_p,                          # jmi_init_opt_new
                ct.c_void_p,                          # jmi 
                ct.c_int,                             # n_p_free
                Nct.ndpointer(dtype=ct.c_int,         # p_free_indices
                                    ndim=1,
                                    flags='C'),
                Nct.ndpointer(dtype=c_jmi_real_t,     # p_opt_init
                                    ndim=1,
                                    flags='C'),
                Nct.ndpointer(dtype=c_jmi_real_t,     # p_free_init
                                    ndim=1,
                                    flags='C'),
                Nct.ndpointer(dtype=c_jmi_real_t,     # dx_init
                                    ndim=1,
                                    shape=self._model._n_real_dx.value,
                                    flags='C'),
                Nct.ndpointer(dtype=c_jmi_real_t,     # x_init
                                    ndim=1,
                                    shape=self._model._n_real_x.value,
                                    flags='C'),
                Nct.ndpointer(dtype=c_jmi_real_t,     # w_init
                                    ndim=1,
                                    shape=self._model._n_real_w.value,
                                    flags='C'),
                Nct.ndpointer(dtype=c_jmi_real_t,     # p_opt_lb
                                    ndim=1,
                                    flags='C'),
                Nct.ndpointer(dtype=c_jmi_real_t,     # p_free_lb
                                    ndim=1,
                                    flags='C'),
                Nct.ndpointer(dtype=c_jmi_real_t,     # dx_lb
                                    ndim=1,
                                    shape=self._model._n_real_dx.value,
                                    flags='C'),
                Nct.ndpointer(dtype=c_jmi_real_t,     # x_lb
                                    ndim=1,
                                    shape=self._model._n_real_x.value,
                                    flags='C'),
                Nct.ndpointer(dtype=c_jmi_real_t,     # w_lb
                                    ndim=1,
                                    shape=self._model._n_real_w.value,
                                    flags='C'),
                Nct.ndpointer(dtype=c_jmi_real_t,     # p_opt_ub
                                    ndim=1,
                                    flags='C'),
                Nct.ndpointer(dtype=c_jmi_real_t,     # p_free_ub
                                    ndim=1,
                                    flags='C'),
                Nct.ndpointer(dtype=c_jmi_real_t,     # dx_ub
                                    ndim=1,
                                    shape=self._model._n_real_dx.value,
                                    flags='C'),
                Nct.ndpointer(dtype=c_jmi_real_t,     # x_ub
                                    ndim=1,
                                    shape=self._model._n_real_x.value,
                                    flags='C'),
                Nct.ndpointer(dtype=c_jmi_real_t,     # w_ub
                                    ndim=1,
                                    shape=self._model._n_real_w.value,
                                    flags='C'),
                                    ct.c_int,   # linearity_information_provided
                Nct.ndpointer(dtype=ct.c_int,         # p_opt_lin
                                    ndim=1,
                                    flags='C'),
                Nct.ndpointer(dtype=ct.c_int,         # p_free_lin
                                    ndim=1,
                                    flags='C'),
                Nct.ndpointer(dtype=ct.c_int,         # dx_lin
                                    ndim=1,
                                    shape=self._model._n_real_dx.value,
                                    flags='C'),
                Nct.ndpointer(dtype=ct.c_int,         # x_lin
                                    ndim=1,
                                    shape=self._model._n_real_x.value,
                                    flags='C'),
                Nct.ndpointer(dtype=ct.c_int,         # w_lin
                                    ndim=1,
                                    shape=self._model._n_real_w.value,
                                    flags='C'),
                ct.c_int,                             # der_eval_alg
                ct.c_int]                             # stat            
        except AttributeError as e:
            pass
            
    def _set_nlpInit_typedefs(self):
        try:
            self._jmi_model._dll.jmi_init_opt_delete.argtypes = [ct.c_void_p]
            self._jmi_model._dll.jmi_init_opt_get_dimensions.argtypes = [
                ct.c_void_p,
                ct.POINTER(ct.c_int),
                ct.POINTER(ct.c_int),
                ct.POINTER(ct.c_int)]    
            self._jmi_model._dll.jmi_init_opt_get_x.argtypes =[ct.c_void_p]
            
            n_real_x = ct.c_int()
            n_h = ct.c_int()
            dh_n_nz = ct.c_int()
            assert self._jmi_model._dll.jmi_init_opt_get_dimensions(
                self._jmi_init_opt, byref(n_real_x), byref(n_h), byref(dh_n_nz)) \
            is 0, \
               "getting NLP problem dimensions failed"        

            self._jmi_model._dll.jmi_init_opt_get_initial.argtypes = [
                ct.c_void_p,
                Nct.ndpointer(dtype=c_jmi_real_t,
                                    ndim=1,
                                    shape=n_real_x.value,
                                    flags='C')]            
            self._jmi_model._dll.jmi_init_opt_set_initial.argtypes =  [
                ct.c_void_p,
                Nct.ndpointer(dtype=c_jmi_real_t,
                                    ndim=1,
                                    shape=n_real_x.value,
                                    flags='C')]    
            self._jmi_model._dll.jmi_init_opt_get_bounds.argtypes = [
                ct.c_void_p,
                Nct.ndpointer(dtype=c_jmi_real_t,
                                    ndim=1,
                                    shape=n_real_x.value,
                                    flags='C'),
                Nct.ndpointer(dtype=c_jmi_real_t,
                                    ndim=1,
                                    shape=n_real_x.value,
                                    flags='C')]
            self._jmi_model._dll.jmi_init_opt_set_bounds.argtypes = [
                ct.c_void_p,
                Nct.ndpointer(dtype=c_jmi_real_t,
                                    ndim=1,
                                    shape=n_real_x.value,
                                    flags='C'),
                Nct.ndpointer(dtype=c_jmi_real_t,
                                    ndim=1,
                                    shape=n_real_x.value,
                                    flags='C')]
            self._jmi_model._dll.jmi_init_opt_f.argtypes = [
                ct.c_void_p,
                Nct.ndpointer(dtype=c_jmi_real_t,
                                    ndim=1,
                                    shape=1,
                                    flags='C')]
            self._jmi_model._dll.jmi_init_opt_df.argtypes = [
                ct.c_void_p,
                Nct.ndpointer(dtype=c_jmi_real_t,
                                    ndim=1,
                                    shape=n_real_x.value,
                                    flags='C')]
            self._jmi_model._dll.jmi_init_opt_h.argtypes = [
                ct.c_void_p,
                Nct.ndpointer(dtype=c_jmi_real_t,
                                    ndim=1,
                                    shape=n_h.value,
                                    flags='C')]
            self._jmi_model._dll.jmi_init_opt_dh.argtypes = [
                ct.c_void_p,
                Nct.ndpointer(dtype=c_jmi_real_t,
                                    ndim=1,
                                    shape=dh_n_nz.value,
                                    flags='C')]
            self._jmi_model._dll.jmi_init_opt_dh_nz_indices.argtypes = [
                ct.c_void_p,
                Nct.ndpointer(dtype=ct.c_int,
                                    ndim=1,
                                    shape=dh_n_nz.value,
                                    flags='C'),
                Nct.ndpointer(dtype=ct.c_int,
                                    ndim=1,
                                    shape=dh_n_nz.value,
                                    flags='C')]
            self._jmi_model._dll.jmi_init_opt_set_initial_from_model.argtypes = [
                ct.c_void_p]
            
            #dll.jmi_opt_sim_write_file_matlab.argtypes = [ct.c_void_p,
            #                                              ct.c_char_p]
            #dll.jmi_opt_sim_get_result.argtypes = [ct.c_void_p,
            #                                       Nct.ndpointer(dtype=c_jmi_real_t,
            #                                                     ndim=1,
            #                                                     flags='C'),
            #                                       Nct.ndpointer(dtype=c_jmi_real_t,
            #                                                     ndim=1,
            #                                                     flags='C'),
            #                                       Nct.ndpointer(dtype=c_jmi_real_t,
            #                                                     ndim=1,
            #                                                     flags='C'),
            #                                       Nct.ndpointer(dtype=c_jmi_real_t,
            #                                                     ndim=1,
            #                                                     flags='C'),
            #                                       Nct.ndpointer(dtype=c_jmi_real_t,
            #                                                     ndim=1,
            #                                                     flags='C'),
            #                                       Nct.ndpointer(dtype=c_jmi_real_t,
            #                                                     ndim=1,
            #                                                     flags='C')]
            _returns_ndarray(self._jmi_model._dll.jmi_init_opt_get_x, 
                c_jmi_real_t, n_real_x.value, order='C')
        except AttributeError as e:
            pass
        
    def init_opt_get_dimensions(self):
        """ 
        Get the number of variables and the number of constraints in the 
        problem.
        
        Returns::
        
            Tuple with the number of variables in the NLP problem, equality 
            constraints, and non-zeros in the Jacobian of the equality 
            constraints respectively. 
        """
        n_real_x = ct.c_int()
        n_h = ct.c_int()
        dh_n_nz = ct.c_int()
        if self._jmi_model._dll.jmi_init_opt_get_dimensions(
            self._jmi_init_opt, byref(n_real_x), 
            byref(n_h), byref(dh_n_nz)) is not 0:
            raise JMIException(
                "Getting the number of variables and constraints failed.")
        return n_real_x.value, n_h.value, dh_n_nz.value 
        
    def init_opt_get_x(self):
        """ 
        Get the x vector of the NLP. 
        
        Returns::
        
            The x vector of the NLP.
        """
        return self._jmi_model._dll.jmi_init_opt_get_x(self._jmi_init_opt)

    def init_opt_get_initial(self, x_init):
        """ 
        Get the initial point of the NLP.
        
        Parameters::
        
            x_init -- 
                The initial guess vector. (Return variable)
        """
        if self._jmi_model._dll.jmi_init_opt_get_initial(
            self._jmi_init_opt, x_init) is not 0:
            raise JMIException("Getting the initial point failed.")

    def init_opt_set_initial(self, x_init):
        """ 
        Set the initial point of the NLP.

        Parameters::
        
            x_init --
                The initial guess vector.
        """
        if self._jmi_model._dll.jmi_init_opt_set_initial(
            self._jmi_init_opt, x_init) is not 0:
            raise JMIException("Setting the initial point failed.")
 
    def init_opt_get_bounds(self, x_lb, x_ub):
        """ 
        Get the upper and lower bounds of the optimization variables.
        
        Parameters::
        
            x_lb -- 
                The lower bounds vector. (Return variable)
                
            x_ub -- 
                The upper bounds vector. (Return variable)
        """
        if self._jmi_model._dll.jmi_init_opt_get_bounds(
            self._jmi_init_opt, x_lb, x_ub) is not 0:
            raise JMIException(
                "Getting upper and lower bounds of the optimization variables failed.")

    def init_opt_set_bounds(self, x_lb, x_ub):
        """ 
        Set the upper and lower bounds of the optimization variables.
        
        Parameters::
        
            x_lb -- 
                The lower bounds vector. (Return variable)
                
            x_ub -- 
                The upper bounds vector. (Return variable)
        """
        if self._jmi_model._dll.jmi_init_opt_set_bounds(
            self._jmi_init_opt, x_lb, x_ub) is not 0:
            raise JMIException(
                "Getting upper and lower bounds of the optimization variables failed.")

    def init_opt_f(self, f):
        """ 
        Get the cost function value at a given point in search space.
        
        Parameters::
        
            f -- 
                The value of the cost function. (Return variable)
        """
        if self._jmi_model._dll.jmi_init_opt_f(self._jmi_init_opt, f) is not 0:
            raise JMIException("Getting the cost function failed.")
        
    def init_opt_df(self, df):
        """ 
        Get the gradient of the cost function value at a given point in search 
        space.
        
        Parameters::
        
            df -- 
                The value of the gradient of the cost function. (Return 
                variable)
        """
        if self._jmi_model._dll.jmi_init_opt_df(self._jmi_init_opt, df) is not 0:
            raise JMIException(
                "Getting the gradient of the cost function value failed.")
               
    def init_opt_h(self, res):
        """ 
        Get the residual of the equality constraints h.
        
        Parameters::
        
            res -- 
                The residual of the equality constraints. (Return variable)
        """
        if self._jmi_model._dll.jmi_init_opt_h(
            self._jmi_init_opt, res) is not 0:
            raise JMIException(
                "Getting the residual of the equality constraints failed.")
        
    def init_opt_dh(self, jac):
        """ 
        Get the Jacobian of the residual of the equality constraints.
        
        Parameters::
        
            jac -- 
                The Jacobian of the residual of the equality constraints. 
                (Return variable)
        """
        if self._jmi_model._dll.jmi_init_opt_dh(
            self._jmi_init_opt, jac) is not 0:
            raise JMIException(
                "Getting the Jacobian of the residual of the equality constraints.")
        
    def init_opt_dh_nz_indices(self, irow, icol):
        """ 
        Get the indices of the non-zeros in the equality constraint Jacobian.
        
        Parameters::
        
            irow -- 
                The row indices of the non-zero entries in the Jacobian of the 
                residual of the equality constraints. (Return variable)
                
            icol -- 
                The column indices of the non-zero entries in the Jacobian of 
                the residual of the equality constraints. (Return variable)
        """
        if self._jmi_model._dll.jmi_init_opt_dh_nz_indices(
            self._jmi_init_opt, irow, icol) is not 0:
            raise JMIException(
                "Getting the indices of the non-zeros in the equality constraint Jacobian failed.")

    def init_opt_set_initial_from_model(self):
        """ 
        Set the initial point of the NLP based on values in the JMI model.
        """
        if self._jmi_model._dll.jmi_init_opt_set_initial_from_model(
            self._jmi_init_opt) is not 0:
            raise JMIException("Could not set initial point from model.")

    def export_result_dymola(self, file_name='', format='txt', 
        write_scaled_result = False):
        """ 
        Export the initialization result in Dymola format. 

        Parameters::
        
            file_name --
                Name of the result file.
                Default: Empty string.
                
            format --
                A string equal either to 'txt' for output to Dymola textual 
                format or 'mat' for output to Dymola binary Matlab format.
                Default: 'txt'
                
            write_scaled_result --
                Set this parameter to True to write the result to file without
                taking scaling into account. If the value of scaled is False,
                then the variable scaling factors of the model are used to 
                reproduced the unscaled variable values.
                Default: False

        Limitations::
        
            Only format='txt' is currently supported.
        """

        n_dx = self._model._n_real_dx.value
        n_x = self._model._n_real_x.value
        n_u = self._model._n_real_u.value
        n_w = self._model._n_real_w.value

        # Create data matrix
        data = N.zeros((1,1+n_dx+ \
                        n_x + \
                        n_u + \
                        n_w))
        data[0,:] = self._model.t
        data[0,1:1+n_dx] = self._model.real_dx
        data[0,1+n_dx:1+n_dx + n_x] = self._model.real_x
        data[0,1+n_dx + n_x:1+n_dx + n_x + n_u] = self._model.real_u
        data[0,1+n_dx + n_x + n_u: \
             1+n_dx + n_x + \
             n_u + n_w] = self._model.real_w
                        
        # Write result
        jmi_io_export_result_dymola(self._model,data, file_name=file_name, 
            format=format, scaled = write_scaled_result)

