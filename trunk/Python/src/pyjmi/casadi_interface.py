#!/usr/bin/env python 
# -*- coding: utf-8 -*-

#    Copyright (C) 2011 Modelon AB
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
Module containing the CasADi interface Python wrappers.
"""

import os.path
import numpy as N

try:
    import casadi
except:
    pass

from pyfmi.fmi import unzip_fmux
from pyjmi.common.core import BaseModel, get_temp_location
from pyjmi.common import xmlparser
from pyjmi.common.xmlparser import XMLException

def convert_casadi_der_name(name):
    n = name.split('der_')[1]
    qnames = n.split('.')
    n = ''
    for i in range(len(qnames)-1):
        n = n + qnames[i] + '.'
    return n + 'der(' + qnames[len(qnames)-1] + ')' 

class CasadiModel(BaseModel):
    
    """
    This class represents a dynamic optimization problem to be solved by an
    optimization algorithm using CasADi.
    
    Parameters::
        
        name --
            Optimica class name.
            Type: str
        
        path --
            Path to optimica file.
            Type: str
            Default: '.'
        
        verbose --
            Whether to enable verbose output from the XML parsing.
            Type: bool
            Default: True
    """
    
    def __init__(self, name, path='.', verbose=True):
        
        # Create temp binary
        self._fmuxnames = unzip_fmux(archive=name, path=path)
        self._tempxml = self._fmuxnames['model_desc']
        
        # Load model description
        self.xmldoc = xmlparser.ModelDescription(self._tempxml)
        
        # Load CasADi interface
        self._load_xml_to_casadi(self._tempxml, verbose)
        
        self._ode_conversion = False
    
    def simulate(self):
        raise NotImplementedError('Simulation of CasadiModel objects is not ' +
                                  'supported.')
    
    def simulate_options(self, algorithm):
        raise NotImplementedError('Simulation of CasadiModel objects is not ' +
                                  'supported.')
    
    def initialize(self):
        raise NotImplementedError('Initialization of CasadiModel objects is ' +
                                  'not supported.')
    
    def initialize_options(self, algorithm):
        raise NotImplementedError('Initialization of CasadiModel objects is ' +
                                  'not supported.')
    
    def set(self, names, values, update_dependent=True):
        """
        Set the values of independent parameters and recompute dependents.
        
        Parameters::
            
            names -- 
                The names of the parameters to set.
                Type: string or list of strings
                
            values -- 
                The new parameter values.
                Type: float or list of floats
            
            update_dependent --
                Whether to update dependent parameter values afterwards.
                Default: True
                Type: bool
        
        Raises::
            
            XMLException if name not present in model or if variable is not an
            independent parameter.
        
        Example::
            
            CasadiModel.set('damper.d', 1.1)
            CasadiModel.set(['damper.d', 'gear.a'], [1.1, 10])
        
        Limitations::
            
            New parameter values only affect equations. Attributes like min and
            nominal that depend on parameters are not updated. These instead
            use the parameter values set at compile time.
        """
        if isinstance(names, basestring):
            self._set(names, values)
        else:
            for (name, value) in zip(names, values):
                self._set(name, value)
        if update_dependent:
            casadi.updateDependent(self.ocp)
    
    def _set(self, name, value):
        """ 
        Set the value of an independent parameter and recompute dependents.
        
        Parameters::
            
            name -- 
                The name of the parameter to set.
                Type: string
                
            value -- 
                The new parameter value.
                Type: float
        
        Raises::
            
            XMLException if name not present in model or if variable is not an
            independent parameter.
        """
        try:
            variable = self.ocp.variable(name)
        except RuntimeError:
            raise XMLException("Could not find variable: " + name)
        if variable.getVariability() != casadi.PARAMETER:
            raise XMLException(name + " is not a parameter.")
        if variable.getFree():
            raise XMLException(name + " is a free parameter.")
        if variable.getCategory() == casadi.CAT_DEPENDENT_PARAMETER:
            raise XMLException(name + " is a dependent parameter.")
        variable.setStart(value)
    
    def get(self, names):
        """
        Get the values of non-free parameters and constants.
        
        Parameters::
            
            names -- 
                The name of the parameters or constants to get.
                Type: string or list of strings
        
        Returns::
            
            values --
                Parameter or constant values.
                Type: float or list of floats
        
        Raises::
            
            XMLException if name not present in model or if variable is not a
            non-free parameter or a constant.
        
        Example::
            
            CasadiModel.get('damper.d')
            CasadiModel.get(['damper.d', 'gear.a'])
        """
        if isinstance(names, basestring):
            return self._get(names)
        else:
            return [self._get(name) for name in names]
    
    def _get(self, name):
        """
        Get the value of a non-free parameter or a constant.
        
        Parameters::
            
            name -- 
                The name of the parameter or constant to get.
                Type: string
        
        Returns::
            
            value --
                Parameter or constant value.
                Type: float
        
        Raises::
            
            XMLException if name not present in model or if variable is not a
            non-free parameter or a constant.
        
        Example::
            
            CasadiModel.get('damper.d')
            CasadiModel.get(['damper.d', 'gear.a'])
        """
        try:
            variable = self.ocp.variable(name)
        except RuntimeError:
            raise XMLException("Could not find variable: " + name)
        if (variable.getVariability() != casadi.PARAMETER and
            variable.getVariability() != casadi.CONSTANT):
            raise XMLException(name + " is neither a parameter nor a " +
                               "constant.")
        if variable.getFree():
            raise XMLException(name + " is a free parameter.")
        return variable.getStart()
    
    def get_model_description(self):
        return self.xmldoc
    
    def get_name(self):
        """
        Returns the model name.
        """
        return self.xmldoc.get_model_name()
    
    def get_identifier(self):
        """
        Returns the model identifier.
        """
        return self.xmldoc.get_model_identifier()
    
    def _default_options(self, algorithm):
        """ 
        Help method. Gets the options class for the algorithm specified in 
        'algorithm'.
        """
        base_path = 'pyjmi.jmi_algorithm_drivers'
        algdrive = __import__(base_path)
        algdrive = getattr(algdrive, 'jmi_algorithm_drivers')
        algorithm = getattr(algdrive, algorithm)
        return algorithm.get_default_options()
    
    def optimize_options(self, algorithm='LocalDAECollocationAlg'):
        """
        Returns an instance of the optimize options class containing options 
        default values. If called without argument then the options class for 
        the default optimization algorithm will be returned.
        
        Parameters::
        
            algorithm --
                The algorithm for which the options class should be returned. 
                Possible values are: 'LocalDAECollocationAlg' and
                'CasadiPseudoSpectralAlg'
                Default: 'LocalDAECollocationAlg'
                
        Returns::
        
            Options class for the algorithm specified with default values.
        """
        return self._default_options(algorithm)    
    
    def optimize(self, algorithm='LocalDAECollocationAlg', options={}):
        """
        Solve an optimization problem.
            
        Parameters::
            
            algorithm --
                The algorithm which will be used for the optimization is 
                specified by passing the algorithm class name as string or class 
                object in this argument. 'algorithm' can be any class which 
                implements the abstract class AlgorithmBase (found in 
                algorithm_drivers.py). In this way it is possible to write 
                custom algorithms and to use them with this function.

                The following algorithms are available:
                - 'LocalDAECollocationAlg'. This algorithm is based on direct
                  collocation on finite elements and the algorithm IPOPT is
                  used to obtain a numerical solution to the problem.
                - 'CasadiPseudoSpectralAlg'
                Default: 'LocalDAECollocationAlg'
                
            options -- 
                The options that should be used in the algorithm. The options
                documentation can be retrieved from an options object:
                
                    >>> myModel = CasadiModel(...)
                    >>> opts = myModel.optimize_options(algorithm)
                    >>> opts?

                Valid values are: 
                - A dict that overrides some or all of the algorithm's default
                  values. An empty dict will thus give all options with default
                  values.
                - An Options object for the corresponding algorithm, e.g.
                  LocalDAECollocationAlgOptions for LocalDAECollocationAlg.
                Default: Empty dict
            
        Returns::
            
            A result object, subclass of algorithm_drivers.ResultBase.
        """
        return self._exec_algorithm('pyjmi.jmi_algorithm_drivers',
                                    algorithm, options)
    
    def get_casadi_ocp(self):
        return self.ocp
    
    def get_n_x(self):
        return self.n_x
    
    def get_n_p(self):
        return self.n_p
    
    def get_n_u(self):
        return self.n_u
    
    def get_n_w(self):
        return self.n_w
    
    def set_min(self, names, values):
        """
        Set the minimum value of variables.
        
        Parameters::
            
            names -- 
                The names of the variables to set new minimum values for.
                Type: string or list of strings
                
            values -- 
                The new minimum values.
                Type: float or list of floats
        
        Raises::
            
            XMLException if name not present in model.
        """
        if isinstance(names, basestring):
            self._set_min(names, values)
        else:
            for (name, value) in zip(names, values):
                self._set_min(name, value)
    
    def _set_min(self, name, value):
        """ 
        Set the minimum value of a variable.
        
        Parameters::
            
            name -- 
                The names of the variable to set new minimum value for.
                Type: string
                
            value -- 
                The new minimum value.
                Type: float
        
        Raises::
            
            XMLException if name not present in model.
        """
        try:
            variable = self.ocp.variable(name)
        except RuntimeError:
            raise XMLException("Could not find variable: " + name)
        variable.setMin(value)
    
    def set_max(self, names, values):
        """
        Set the maximum value of variables.
        
        Parameters::
            
            names -- 
                The names of the variables to set new maximum values for.
                Type: string or list of strings
                
            values -- 
                The new maximum values.
                Type: float or list of floats
        
        Raises::
            
            XMLException if name not present in model.
        """
        if isinstance(names, basestring):
            self._set_max(names, values)
        else:
            for (name, value) in zip(names, values):
                self._set_max(name, value)
    
    def _set_max(self, name, value):
        """ 
        Set the maximum value of a variable.
        
        Parameters::
            
            name -- 
                The names of the variable to set new maximum value for.
                Type: string
                
            value -- 
                The new maximum value.
                Type: float
        
        Raises::
            
            XMLException if name not present in model.
        """
        try:
            variable = self.ocp.variable(name)
        except RuntimeError:
            raise XMLException("Could not find variable: " + name)
        variable.setMax(value)
    
    def get_dx(self):
        return self.dx
    
    def get_x(self):
        return self.x
    
    def get_u(self):
        return self.u
    
    def get_w(self):
        return self.w
    
    def get_p(self):
        return self.p
    
    def get_t(self):
        return self.t
    
    def get_variability(self, variablename):
        """ 
        Get variability of variable. 
            
        Parameters::
            
            variablename --
                The name of the variable.
                    
        Returns::
        
            The variability of the variable, CONTINUOUS(0), CONSTANT(1), 
            PARAMETER(2) or DISCRETE(3).

        Raises::
        
            XMLException if variable was not found.
        """
        return self.xmldoc.get_variability(variablename)
    
    def get_pd_val(self):
        """
        Get non-free parameter values.
        
        Returns::
        
            List of 3-tuples (a, b, c), where
                
                a is parameter name (string)
                b is value reference number (int)
                c is parameter value (float64)
        """
        pd_vals_fcn = casadi.SXFunction(
                [[]], [[p.getStart() for p in self._parameters]])
        pd_vals_fcn.init()
        pd_vals_fcn.evaluate()
        pd_vals = pd_vals_fcn.output().toArray().reshape(-1)
        
        pd = []
        for i in xrange(len(pd_vals)):
            p = self._parameters[i]
            name = p.getName()
            if not name == "startTime" and not name == "finalTime":
                pd += [(name, p.getValueReference(), pd_vals[i])]
        return pd
    
    def get_sf(self):
        """
        Returns a nested dictionary of scaling factors.
        
        The dictionary has the following nested structure:
        
            sf[var_type][var_index] = var_sf
        """
        return self.sf
    
    def get_vr_map(self):
        """
        Returns a nested dictionary mapping value references.
        
        The dictionary has the following nested structure:
        
            vr_map[vr] = (var_index, var_type)
        """
        return self.vr_map
    
    def get_initial(self, update_expressions=True):
        """
        Get DAE initial equation residual expressions.
        
        Parameters::
            
            update_expressions --
                Whether to update OCP expressions using current parameter
                values.
        
        Returns::
            
            init_F0 --
                DAE initial equation residual.
                Type: SX
        """
        if update_expressions:
            self.update_expressions()
        return self.initial
    
    def get_ode(self, update_expressions=True):
        """
        Get differential equation residual expressions.
        
        Parameters::
            
            update_expressions --
                Whether to update OCP expressions using current parameter
                values.
        
        Returns::
            
            ode --
                Differential equation residual.
                Type: SX
        """
        if update_expressions:
            self.update_expressions()
        return self.ode
    
    def get_alg(self, update_expressions=True):
        """
        Get algebraic equation residual expressions.
        
        Parameters::
            
            update_expressions --
                Whether to update OCP expressions using current parameter
                values.
        
        Returns::
            
            alg --
                Algebraic equation residual.
                Type: SX
        """
        if update_expressions:
            self.update_expressions()
        return self.alg
    
    def get_path(self, update_expressions=True):
        """
        Get path constraint expressions.
        
        Parameters::
            
            update_expressions --
                Whether to update OCP expressions using current parameter
                values.
        
        Returns::
            
            path --
                Path constraint expressions.
                Type: SX
        """
        if update_expressions:
            self.update_expressions()
        return self.path
    
    def get_point(self, update_expressions=True, variable_scaling=True):
        """
        Get point constraint expressions.
        
        Parameters::
            
            update_expressions --
                Whether to update OCP expressions using current parameter
                values.
        
        Returns::
            
            point --
                Point constraint expressions.
                Type: SX
        """
        if update_expressions:
            self.update_expressions()
        return self.point
    
    def get_mterm(self, update_expressions=True):
        """
        Get Mayer cost expression.
        
        Parameters::
            
            update_expressions --
                Whether to update OCP expressions using current parameter
                values.
        
        Returns::
            
            mterm --
                Mayer cost expression.
                Type: SX
        """
        if update_expressions:
            self.update_expressions()
        return self.mterm
    
    def get_lterm(self, update_expressions=True, variable_scaling=True):
        """
        Get Lagrange term expression.
        
        Parameters::
            
            update_expressions --
                Whether to update OCP expressions using current parameter
                values.
        
        Returns::
            
            lterm --
                Lagrange term expression.
                Type: SX
        """
        if update_expressions:
            self.update_expressions()
        return self.lterm
    
    def get_opt_ode_L(self):
        return self.opt_ode_L
    
    def get_opt_ode_J(self):
        return self.opt_ode_J    
    
    def get_ode_F(self):
        return self.ode_F
    
    def get_ode_F0(self):
        return self.ode_F0
    
    def update_expressions(self):
        """
        Update OCP expressions using current parameter values.
        """
        ocp_expressions = [self.ocp.initial, self.ocp.ode, self.ocp.alg,
                           self.ocp.path, self.ocp.point, self.ocp.mterm,
                           self.ocp.lterm]
        parameters = [p.var() for p in self._parameters]
        parameter_values = [p.getStart() for p in self._parameters]
        [self.initial,
         self.ode,
         self.alg,
         self.path,
         self.point,
         self.mterm,
         self.lterm] = casadi.substitute(ocp_expressions, parameters,
                                         parameter_values)
    
    def _load_xml_to_casadi(self, xml, verbose):
        # Create a symbolic OCP
        self.ocp = casadi.SymbolicOCP()
        options = {}
        options["verbose"] = verbose
        options["sort_equations"] = False
        options["eliminate_dependent"] = False
        self.ocp.parseFMI(xml, options)
        casadi.updateDependent(self.ocp)
        
        # Store list of non-free parameters
        self._parameters = ([pi for pi in self.ocp.pi] +
                            [pd for pd in self.ocp.pd])
        
        # Check the absence of multiple Mayer and Lagrange terms
        if self.ocp.lterm.numel() > 1:
            raise NotImplementedError("Multiple Lagrange terms are not " +
                                      "supported.")
        if self.ocp.mterm.numel() > 1:
            raise NotImplementedError("Multiple Mayer terms are not " +
                                      "supported.")
        
        # Identify variables
        names = {'x': self.xmldoc.get_x_variable_names,
                 'u': self.xmldoc.get_u_variable_names,
                 'w': self.xmldoc.get_w_variable_names,
                 'p_opt': self.xmldoc.get_p_opt_variable_names}
        variables = {}
        variables['x'] = self.ocp.x
        variables['u'] = self.ocp.u
        variables['w'] = self.ocp.z
        variables['p_opt'] = self.ocp.pf
        
        # Make sure the variables appear in value reference order
        var_vectors = {}
        for var_type in names:
            var_dict = dict((repr(v), v) for v in variables[var_type])
            name_dict = dict((x[0], x[1]) for x in names[var_type](False))
            if var_type == 'p_opt':
                free_times = 0
                if self.xmldoc.get_opt_finaltime_free():
                    free_times += 1
                if self.xmldoc.get_opt_starttime_free():
                    free_times += 1
                var_vectors[var_type] = casadi.VariableVector(len(var_dict) -
                                                              free_times)
            else:
                var_vectors[var_type] = casadi.VariableVector(len(var_dict))
            i = 0
            for vr in sorted(name_dict):
                if (name_dict[vr] == "finalTime" or
                    name_dict[vr] == "startTime"):
                    continue
                var_vectors[var_type][i] = var_dict[name_dict[vr]]
                i = i + 1
        self._var_vectors = var_vectors
        
        # Create symbolic variables
        self.dx = casadi.der(var_vectors['x'])
        self.x = casadi.var(var_vectors['x'])
        self.u = casadi.var(var_vectors['u'])
        self.w = casadi.var(var_vectors['w'])
        self.t = self.ocp.t
        self.p = casadi.var(var_vectors['p_opt'])
        sym_vars = {'dx': self.dx,
                    'x': self.x,
                    'u': self.u,
                    'w': self.w,
                    'p_opt': self.p}
        
        # Create maps from value reference to CasADi variable index and type
        vr_map = {}
        get_vr = self.xmldoc.get_value_reference
        for vt in sym_vars.keys():
            i = 0
            for v in sym_vars[vt]:
                var_name = str(v)
                if vt == "dx":
                    var_name = convert_casadi_der_name(var_name)
                vr_map[get_vr(var_name)] = (i, vt)
                i = i + 1
        self.vr_map = vr_map
        
        # Count variables
        self.n_x = len(self.x)
        self.n_u = len(self.u)
        self.n_w = len(self.w)
        self.n_p = len(self.p)
        
        # Create scaling factors
        sf = {}
        sf['dx'] = N.ones(self.n_x)
        sf['x'] = N.ones(self.n_x)
        sf['u'] = N.ones(self.n_u)
        sf['w'] = N.ones(self.n_w)
        sf['p_opt'] = N.ones(self.n_p)
        
        # Get nominal values for scaling
        nominal = {}
        nominal['dx'] = self.xmldoc.get_x_nominal(include_alias=False)
        nominal['x'] = self.xmldoc.get_x_nominal(include_alias=False)
        nominal['u'] = self.xmldoc.get_u_nominal(include_alias=False)
        nominal['w'] = self.xmldoc.get_w_nominal(include_alias=False)
        nominal['p_opt'] = self.xmldoc.get_p_opt_nominal(include_alias=False)
        
        # Set nominal values as scaling factors
        for var_type in nominal.keys():
            for (vr, val) in nominal[var_type]:
                if val is not None:
                    sf[var_type][vr_map[vr][0]] = N.abs(val)
        self.sf = sf
    
    def _convert_to_ode(self):
        if not self._ode_conversion:
            self._ode_conversion = True
            self.ocp.makeExplicit()
            self.update_expressions()
            
            if len(self.ocp.z) > 0 or self.ocp.ode.empty():
                raise RuntimeError("Unable to reformulate as ODE.")
            
            t0 = self.ocp.variable('startTime').getStart()
            tf = self.ocp.variable('finalTime').getStart()
            
            self.ocp_ode_inputs = []
            self.ocp_ode_inputs += list(self.p)
            self.ocp_ode_inputs += list(self.x)
            self.ocp_ode_inputs += list(self.u)
            self.ocp_ode_inputs += [self.t]
            
            self.ocp_ode_init_inputs = []
            self.ocp_ode_init_inputs += list(self.p)
            self.ocp_ode_init_inputs += list(self.x)
            self.ocp_ode_init_inputs += [self.t]
            
            
            self.ode_F = casadi.SXFunction([self.ocp_ode_inputs],
                                           [self.ode])
            self.ode_F.init()
            
            # The initial equations
            self.ode_F0 = casadi.SXFunction([self.ocp_ode_init_inputs],
                                            [self.initial])
            self.ode_F0.init()
            
            # The Lagrange cost function
            if self.lterm.numel() > 0:
                self.opt_ode_L = casadi.SXFunction([self.ocp_ode_inputs],
                                                   [[self.lterm[0]]])
                self.opt_ode_L.init()
            else:
                self.opt_ode_L = None
            
            # The Mayer cost function
            if self.mterm.numel() > 0:
                self.ocp_ode_mterm_inputs = []
                self.ocp_ode_mterm_inputs += list(self.p)
                self.ocp_ode_mterm_inputs += [
                        x.atTime(tf, True) for x in self.ocp.x]
                self.ocp_ode_mterm_inputs += [self.t]
                self.opt_ode_J = casadi.SXFunction(
                        [self.ocp_ode_mterm_inputs], [[self.mterm[0]]])
                self.opt_ode_J.init()
            else:
                self.opt_ode_J = None
            
            # Boundary Constraints
            self.opt_ode_Cineq = [] #Inequality
            self.opt_ode_C = [] #Equality
            # Modify equality constraints to be on type g(x)=0 (instead of g(x)=a)
            lb = N.array(self.ocp.point_min, dtype=N.float)
            ub = N.array(self.ocp.point_max, dtype=N.float)
            for i in range(len(ub)):
                if lb[i] == ub[i]: #The constraint is an equality
                    self.opt_ode_C += [self.point[i] -
                                       self.ocp.point_max[i]]
                    #self.ocp.cfcn_ub[i] = casadi.SX(0.0)
                    #self.ocp.cfcn_lb[i] = casadi.SX(0.0)
                else: #The constraint is an inequality
                    if   lb[i] == -N.inf:
                        self.opt_ode_Cineq += [(1.0) * self.point[i] -
                                               self.ocp.point_max[i]]
                    elif ub[i] == N.inf:
                        self.opt_ode_Cineq += [(-1.0) * self.point[i] +
                                               self.ocp.point_min[i]]
                    else:
                        self.opt_ode_Cineq += [(1.0) * self.point[i] -
                                               self.ocp.point_max[i]]
                        self.opt_ode_Cineq += [(-1.0) * self.point[i] +
                                               self.ocp.point_min[i]]
            
            self.ocp_ode_boundary_inputs = []
            self.ocp_ode_boundary_inputs += list(self.p)
            self.ocp_ode_boundary_inputs += [x.atTime(t0, True) for
                                             x in self.ocp.x]
            self.ocp_ode_boundary_inputs += [x.atTime(tf, True) for
                                             x in self.ocp.x]
            self.opt_ode_C = casadi.SXFunction(
                    [self.ocp_ode_boundary_inputs], [self.opt_ode_C])
            self.opt_ode_C.init()
            self.opt_ode_Cineq = casadi.SXFunction(
                    [self.ocp_ode_boundary_inputs], [self.opt_ode_Cineq])
            self.opt_ode_Cineq.init()
            
            ##############################
            ### Scaling not supported! ###
            ##############################
            #~ if self.scale_variables:
                #~ # Scale model
                #~ # Get nominal values for scaling
                #~ x_nominal = self.xmldoc.get_x_nominal(include_alias = False)
                #~ u_nominal = self.xmldoc.get_u_nominal(include_alias = False)
                #~ 
                #~ for vr, val in x_nominal:
                    #~ if val != None:
                        #~ self.x_sf[self.x_vr_map[vr]] = N.abs(val)
                #~ 
                #~ for vr, val in u_nominal:
                    #~ if val != None:
                        #~ self.u_sf[self.u_vr_map[vr]] = N.abs(val)
                #~ 
                #~ # Create new, scaled variables
                #~ self.x_scaled = self.x_sf*self.x
                #~ self.u_scaled = self.u_sf*self.u
                #~ 
                #~ self.ocp_ode_inputs_scaled = []
                #~ self.ocp_ode_inputs_scaled += list(self.p)
                #~ self.ocp_ode_inputs_scaled += list(self.x_scaled)
                #~ self.ocp_ode_inputs_scaled += list(self.u_scaled)
                #~ self.ocp_ode_inputs_scaled += [self.t]
                #~ 
                #~ self.ocp_ode_init_inputs_scaled = []
                #~ self.ocp_ode_init_inputs_scaled += list(self.p)
                #~ self.ocp_ode_init_inputs_scaled += list(self.x_scaled)
                #~ self.ocp_ode_init_inputs_scaled += [self.t]
                #~ 
                #~ self.ocp_ode_mterm_inputs_scaled = []
                #~ self.ocp_ode_mterm_inputs_scaled += list(self.p)
                #~ self.ocp_ode_mterm_inputs_scaled += [
                        #~ self.x_sf[ind] * x.atTime(tf, True) for
                        #~ (ind, x) in enumerate(tuple(self.ocp.x))+tuple(self.ocp.z)]
                #~ self.ocp_ode_mterm_inputs_scaled += [self.t]
                #~ 
                #~ # Substitute scaled variables
                #~ self.ode_F = list(self.ode_F.eval(
                        #~ [self.ocp_ode_inputs_scaled])[0])
                #~ self.ode_F0 = list(self.ode_F0.eval(
                        #~ [self.ocp_ode_init_inputs_scaled])[0])
                #~ if self.opt_ode_J != None:
                    #~ self.opt_ode_J = list(self.opt_ode_J.eval(
                            #~ [self.ocp_ode_mterm_inputs_scaled])[0])
                #~ if self.opt_L!=None:
                    #~ self.opt_ode_L = list(self.opt_ode_L.eval(
                            #~ [self.ocp_ode_inputs_scaled])[0])
                #~ 
                #~ self.ode_F = casadi.SXFunction([self.ocp_ode_inputs], [self.ode_F])
                #~ self.ode_F0 = casadi.SXFunction([self.ocp_ode_init_inputs], 
                                                #~ [self.ode_F0])
                #~ 
                #~ if self.opt_ode_J != None:
                    #~ self.opt_ode_J = casadi.SXFunction([self.ocp_ode_mterm_inputs],
                                                       #~ [[self.opt_ode_J]])
                #~ if self.opt_ode_J != None:
                    #~ self.opt_ode_L = casadi.SXFunction([self.ocp_ode_inputs],
                                                       #~ [[self.opt_ode_L]])
