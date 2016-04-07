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

# References:
#     http://www.python.org/doc/2.5.2/lib/module-ctypes.html
#     http://starship.python.net/crew/theller/ctypes/tutorial.html
#     http://www.scipy.org/Cookbook/Ctypes 
"""
Module containing the JMI interface Python wrappers.
"""

import os
import sys
import logging
import platform as PL

import ctypes as ct
from ctypes import byref
import numpy as N
import numpy.ctypeslib as Nct
import tempfile
import shutil
import _ctypes
import atexit
from lxml import etree

from pyjmi.common import xmlparser
from pyjmi.common.core import ModelBase, unzip_unit, get_platform_suffix, get_files_in_archive, rename_to_tmp, load_DLL

from pyjmi.common.io import ResultDymolaTextual, ResultDymolaBinary
from pyjmi.common.core import TrajectoryLinearInterpolation

from pyjmi.common.io import VariableNotFoundError as jmiVariableNotFoundError

#Check to see if pyfmi is installed so that we also catch the error generated
#from that package
try:
    from pyfmi.common.io import VariableNotFoundError as fmiVariableNotFoundError
    VariableNotFoundError = (jmiVariableNotFoundError, fmiVariableNotFoundError)
except ImportError:
    VariableNotFoundError = jmiVariableNotFoundError

int = N.int32
N.int = N.int32

# ================================================================
#                         CONSTANTS
# ================================================================

"""Use symbolic evaluation of derivatives (if available)."""
JMI_DER_SYMBOLIC = 1
"""Use automatic differentiation (CppAD) to evaluate derivatives."""
JMI_DER_CPPAD = 2
"""Use automatic differentiation (CAD) to evaluate derivatives."""
JMI_DER_CAD = 4
"""Use finite differentiation (FD) to evaluate derivatives."""
JMI_DER_FD = 8


"""Sparse evaluation of derivatives."""
JMI_DER_SPARSE = 1
"""Dense evaluation (column major) of derivatives"""
JMI_DER_DENSE_COL_MAJOR = 2
"""Dense evaluation (row major) of derivatives."""
JMI_DER_DENSE_ROW_MAJOR = 4

"""Print evaluation errors on screen"""
JMI_DER_CHECK_SCREEN_ON = 1
"""Interrupt when evaluation error is found""" 
JMI_DER_CHECK_SCREEN_OFF = 2

"""Flags for evaluation of Jacobians w.r.t. parameters in the p vector
"""
"""Evaluate derivatives w.r.t. independent constants, \f$c_i\f$."""
JMI_DER_CI = 1
"""Evaluate derivatives w.r.t. dependent constants, \f$c_d\f$."""
JMI_DER_CD = 2
"""Evaluate derivatives w.r.t. independent parameters, \f$p_i\f$."""
JMI_DER_PI = 4
"""Evaluate derivatives w.r.t. dependent constants, \f$p_d\f$."""
JMI_DER_PD = 8

"""Flags for evaluation of Jacobians w.r.t. variables in the v vector
"""
"""Evaluate derivatives w.r.t. free parameters, \f$\p_opt\f$."""
JMI_DER_P_OPT = 8192
"""Evaluate derivatives w.r.t. derivatives, \f$\dot x\f$."""
JMI_DER_DX = 16
"""Evaluate derivatives w.r.t. differentiated variables, \f$x\f$."""
JMI_DER_X = 32
"""Evaluate derivatives w.r.t. inputs, \f$u\f$."""
JMI_DER_U = 64
"""Evaluate derivatives w.r.t. algebraic variables, \f$w\f$."""
JMI_DER_W = 128
"""Evaluate derivatives w.r.t. time, \f$t\f$."""
JMI_DER_T = 256

"""Flags for evaluation of Jacobians w.r.t. variables in the q vector.
"""
"""Evaluate derivatives w.r.t. derivatives at time points,
\f$\dot x_p\f$.
"""
JMI_DER_DX_P = 512
"""Evaluate derivatives w.r.t. differentiated variables at time points,
\f$x_p\f$.
"""
JMI_DER_X_P = 1024
"""Evaluate derivatives w.r.t. inputs at time points, \f$u_p\f$.
"""
JMI_DER_U_P = 2048
"""Evaluate derivatives w.r.t. algebraic variables at time points,
\f$w_p\f$.
"""
JMI_DER_W_P = 4096

"""Evaluate derivatives w.r.t. all variables, \f$z\f$."""
JMI_DER_ALL = JMI_DER_CI | JMI_DER_CD | JMI_DER_PI | JMI_DER_PD | \
              JMI_DER_DX | JMI_DER_X | JMI_DER_U | JMI_DER_W | \
              JMI_DER_T | JMI_DER_DX_P | JMI_DER_X_P | JMI_DER_U_P | \
              JMI_DER_W_P


"""Evaluate derivatives w.r.t. all variables in \f$p\f$."""
JMI_DER_ALL_P = JMI_DER_CI | JMI_DER_CD | JMI_DER_PI | JMI_DER_PD

"""Evaluate derivatives w.r.t. all variables in \f$v\f$."""
JMI_DER_ALL_V = JMI_DER_DX | JMI_DER_X | JMI_DER_U | JMI_DER_W | \
                JMI_DER_T

"""Evaluate derivatives w.r.t. all variables in \f$q\f$."""
JMI_DER_ALL_Q = JMI_DER_DX_P | JMI_DER_X_P | JMI_DER_U_P | JMI_DER_W_P

"""No scaling. """
JMI_SCALING_NONE =1

"""Scale real variables by multiplying incoming variables in residual
functions by the scaling factors in jmi_t->variable_scaling_factors  """
JMI_SCALING_VARIABLES =2

# ================================================================
#                    ERROR HANDLING / EXCEPTIONS
# ================================================================
class JMIException(Exception):
    """ 
    A JMI exception.
    """
    pass

class IpoptException(Exception):
    """ 
    An exception caused by Ipopt failing.
    """
    pass

def fail_error_check(message):
    """ 
    A ctypes errcheck that always fails.
    """
    
    def fail(errmsg):
        raise JMIException(errmsg)
    
    return lambda x, y, z: fail(message)

# ================================================================
#                             CTYPES
# ================================================================

"""Defines the JMI jmi_real_t C-type.

This type is usually a double.

"""
c_jmi_real_t = ct.c_double


# ================================================================
#                         LOW LEVEL INTERFACE
# ================================================================

def _from_address(address, nbytes, dtype=float):
    """ 
    Converts a C-array to a numpy.array.
    
    Borrowed from:
    http://mail.scipy.org/pipermail/numpy-discussion/2009-March/041323.html
    """
    class Dummy(object): pass

    d = Dummy()
    bytetype = N.dtype(N.uint8)

    d.__array_interface__ = {
         'data' : (address, False),
         'typestr' : bytetype.str,
         'descr' : bytetype.descr,
         'shape' : (nbytes,),
         'strides' : None,
         'version' : 3
    }   

    return N.asarray(d).view(dtype)


class _PointerToNDArrayConverter:
    """
    A callable class used by the function _returns_ndarray(...) to convert 
    result from a DLL function pointer to an array.
    """
    def __init__(self, shape, dtype, ndim=1, order=None):
        """ 
        Set meta data about the array the returned pointer is pointing to.
        
        Parameters::
        
            shape -- 
                A tuple containing the shape of the array.
                
            dtype -- 
                The data type that the function result points to.
                
            ndim  -- 
                The optional number of dimensions that the result returns.
                
            order -- 
                The same order parameter as can be used in numpy.array(...).
                Default: None
        """
        assert ndim >= 1
        
        self._shape = shape
        self._dtype = dtype
        self._order = order
        
        if ndim is 1:
            self._num_elmnts = shape
            try:
                # If shape is specified as a tuple
                self._num_elmnts = shape[0]
            except TypeError:
                pass
        else:
            assert len(shape) is ndim
            for number in shape:
                assert number >= 1
            self._num_elmnts = reduce(lambda x,y: x*y, self.shape)
        
    def __call__(self, ret, func, params):
        
        if ret is None:
            raise JMIException("The function returned NULL.")
            
        #ctypes_arr_type = C.POINTER(self._num_elmnts * self._dtype)
        #ctypes_arr = ctypes_arr_type(ret)
        #narray = N.asarray(ctypes_arr)
        
        pointer = ct.cast(ret, ct.c_void_p)
        address = pointer.value
        nbytes = ct.sizeof(self._dtype) * self._num_elmnts
        
        numpy_arr = _from_address(address, nbytes, self._dtype)
        
        return numpy_arr


def _returns_ndarray(dll_func, dtype, shape, ndim=1, order=None):
    """ 
    Sets automatic conversion to ndarray of DLL function results.
    """
    
    # Defining conversion function (actually a callable class)
    conv_function = _PointerToNDArrayConverter(shape=shape,
                                               dtype=dtype,
                                               ndim=ndim,
                                               order=order)
    
    dll_func.restype = ct.POINTER(dtype)
    dll_func.errcheck = conv_function

def _translate_value_ref(valueref):
    """ 
    Translate a ValueReference into variable type and index in z-vector.
    
    Uses a value reference which is a 32 bit unsigned int to get type of 
    variable and index in vector using the protocol: bit 0-28 is index, 29-31 
    is primitive type.
        
    Parameters::
    
        valueref -- 
            The value reference to translate.
            
    Returns::
        
        Primitive type and index in the corresponding vector as integers.
    """
    indexmask = 0x0FFFFFFF
    ptypemask = 0xF0000000
    index = valueref & indexmask
    ptype = (valueref & ptypemask) >> 28
    return (index,ptype)

# list of temporary dll filenames and handles
_temp_dlls = []

def _cleanup():
    """ 
    Remove all temporary dll files from file system on interpreter termination.
    
    Helper function which removes all temporary dll files from the file system 
    which have been created by the JMIModel constructor and have not been 
    deleted when Python interpreter is terminated.
    
    Uses the class attribute _temp_dlls which holds a list of all temporary dll 
    file names and handles created during the Python session. 
    """
    for tmp in _temp_dlls:
        tmpfile = tmp.get('name')
        if os.path.exists(tmpfile) and os.path.isfile(tmpfile):
            if sys.platform == 'win32':
                _ctypes.FreeLibrary(tmp.get('handle'))
            #else:
            #    _ctypes.dlclose(tmp.get('handle'))
            os.remove(tmpfile)

# _cleanup registered to run on termination       
atexit.register(_cleanup)

def strip_der(name):
    (before,sep,after) = name.partition('der(')
    (var_name,sep,after) = after.partition(')')
    return before + var_name

def der_name(name):
    (before,sep,after) = name.rpartition('.')
    return before + '.der(' + after + ')'


# ================================================================
#                        HIGH LEVEL INTERFACE
# ================================================================

class JMUModel(ModelBase):
    """ 
    High-level interface to a JMIModel. 
    """
    
    def __init__(self, jmu_name):
        """ 
        Create a jmi.JMUModel. 
        
        Create a JMU Model object. Load generated binary file, set default 
        values from the model variables XML file, set dependent parameters and 
        initialize AD.
        
        Parameters::
        
            jmu_name --
                Whole name of JMU file, including path.
        """
        # Check that the file referenced by jmu_name has the correct file-ending
        ext = os.path.splitext(jmu_name)[1]
        if ext != ".jmu":
            raise JMIException("JMUModel must be instantiated with an JMU (.jmu) file.")
        
        # unzip unit and get files in archive
        path, jmu_name = os.path.split(jmu_name)
        self._jmufiles = unzip_jmu(archive=jmu_name, path=path)
        self._xml_name = self._jmufiles['model_desc']
        
        # Parse XML and set model name (needed when creating temp bin file name)
        self._parse_xml_md(self._xml_name)
        self._modelid = self.get_identifier()
        self._modelname = self.get_name()
        
        # DELETE HERE
        # extract XML values file from JMU and parse
        #self._xml_values_name = os.path.join(self._jmufiles['resources_dir'], self._modelid+'_values.xml')
        #self._parse_xml_values(self._xml_values_name)
        
        #Retrieve, rename and load the binary
        suffix = get_platform_suffix()
        if os.path.exists(os.path.join(self._jmufiles['binaries_dir'], self._modelid + suffix)):
            dllname = self._modelid + suffix
        else:
            dllname = self._modelname + suffix
            
        lib_name = self._jmufiles['binary'] = rename_to_tmp(dllname, self._jmufiles['binaries_dir'])
        self.jmimodel = JMIModel(lib_name, self._jmufiles['binaries_dir'])

        # init arrays (variables and offsets) with sizes and values
        self._init_arrays()
        
        #n_p_opt set in _setDefaultValuesFromMetadata() -> _set_p_opt_indices()
        self._n_p_opt=0
        
        self._init_variables()
        self.jmimodel.initAD()

        if self._n_z.value <= 1: # The time variable is always present
            raise JMIException("Model contains no variables.")

    def _init_variables(self):
        self._set_scaling_factors()
        self._set_start_values()
        
        # set optimizataion interval, time points and optimization 
        # indices
        if self._is_optimica():
            self._set_opt_interval()
            self._set_timepoints()
            self._set_p_opt_indices()
            
        self._set_dependent_parameters()

    def _init_arrays(self):
        # sizes of all arrays
        self._n_real_ci = ct.c_int()
        self._n_real_cd = ct.c_int()
        self._n_real_pi = ct.c_int()
        self._n_real_pd = ct.c_int()
        self._n_integer_ci = ct.c_int()
        self._n_integer_cd = ct.c_int()
        self._n_integer_pi = ct.c_int()
        self._n_integer_pd = ct.c_int()
        self._n_boolean_ci = ct.c_int()
        self._n_boolean_cd = ct.c_int()
        self._n_boolean_pi = ct.c_int()
        self._n_boolean_pd = ct.c_int()
        self._n_real_dx = ct.c_int()
        self._n_real_x  = ct.c_int()
        self._n_real_u  = ct.c_int()
        self._n_real_w  = ct.c_int()
        self._n_tp = ct.c_int()
        self._n_real_d = ct.c_int()
        self._n_integer_d = ct.c_int()
        self._n_integer_u = ct.c_int()
        self._n_boolean_d = ct.c_int()
        self._n_boolean_u = ct.c_int()
        self._n_outputs = ct.c_int()
        self._n_sw = ct.c_int()
        self._n_sw_init = ct.c_int()
        self._n_guards = ct.c_int()
        self._n_guards_init = ct.c_int()
        self._n_z  = ct.c_int()
        
        self.get_sizes()

        # offsets
        self._offs_real_ci = ct.c_int()
        self._offs_real_cd = ct.c_int()
        self._offs_real_pi = ct.c_int()
        self._offs_real_pd = ct.c_int()
        self._offs_integer_ci = ct.c_int()
        self._offs_integer_cd = ct.c_int()
        self._offs_integer_pi = ct.c_int()
        self._offs_integer_pd = ct.c_int()
        self._offs_boolean_ci = ct.c_int()
        self._offs_boolean_cd = ct.c_int()
        self._offs_boolean_pi = ct.c_int()
        self._offs_boolean_pd = ct.c_int()
        self._offs_real_dx = ct.c_int()
        self._offs_real_x  = ct.c_int()
        self._offs_real_u  = ct.c_int()
        self._offs_real_w  = ct.c_int()
        self._offs_t = ct.c_int()
        self._offs_real_dx_p = ct.c_int()
        self._offs_real_x_p = ct.c_int()
        self._offs_real_u_p = ct.c_int()
        self._offs_real_w_p = ct.c_int()
        self._offs_real_d = ct.c_int()
        self._offs_integer_d = ct.c_int()
        self._offs_integer_u = ct.c_int()
        self._offs_boolean_d = ct.c_int()
        self._offs_boolean_u = ct.c_int()        
        self._offs_sw = ct.c_int()
        self._offs_sw_init = ct.c_int()
        self._offs_guards = ct.c_int()
        self._offs_guards_init = ct.c_int()
        self._offs_pre_real_dx = ct.c_int()
        self._offs_pre_real_x  = ct.c_int()
        self._offs_pre_real_u  = ct.c_int()
        self._offs_pre_real_w  = ct.c_int()
        self._offs_pre_real_d = ct.c_int()
        self._offs_pre_integer_d = ct.c_int()
        self._offs_pre_integer_u = ct.c_int()
        self._offs_pre_boolean_d = ct.c_int()
        self._offs_pre_boolean_u = ct.c_int()
        self._offs_pre_sw = ct.c_int()
        self._offs_pre_sw_init = ct.c_int()
        self._offs_pre_guards = ct.c_int()
        self._offs_pre_guards_init = ct.c_int()

        self.get_offsets()

    def has_cppad_derivatives(self):
        """ 
        Check if there is support for CppAD derivatives.
        
        Returns::
        
            True if there is support for CppAD derivatives, otherwise False.
        """
        return bool(self.jmimodel.with_cppad_derivatives())

    def has_cad_derivatives(self):
        """ 
        Check if there is support for CAD derivatives.
        
        Returns::
        
            True if there is support for CAD derivatives, otherwise False.
        """
        return bool(self.jmimodel.with_cad_derivatives())

    def reset(self):
        """ 
        Reset the internal states of the DLL.
        
        Calling this function is equivalent to reopening the model.
        """
        self._init_variables()
        
        #self._setDefaultValuesFromMetadata()
        #self._set_iparam_values
        #self._set_dependent_parameters
        
    def _reset_jmimodel_typedefs(self):
        """ 
        Type c-functions could not be set before.
        """
        self.jmimodel._dll.jmi_opt_set_p_opt_indices.argtypes = [
            ct.c_void_p, 
            ct.c_int,
            Nct.ndpointer(
                dtype=ct.c_int,
                ndim=1,
                shape=self._n_p_opt,
                flags='C')]
        self.jmimodel._dll.jmi_opt_get_p_opt_indices.argtypes = [
            ct.c_void_p,
            Nct.ndpointer(
                dtype=ct.c_int,
                ndim=1,
                shape=self._n_p_opt,
                flags='C')]
        
    def _parse_xml_md(self, fname):
        # xml file has been unzipped from JMU and is located in the 
        # tempdir specified by core.get_temp_location()
        self._set_XMLDoc(xmlparser.ModelDescription(fname))
        
    #def _parse_xml_values(self, fname):
        ## xml file has been unzipped from JMU and is located in the 
        ## tempdir specified by core.get_temp_location()
        #self._set_XMLValuesDoc(xmlparser.IndependentParameters(fname))
               
    #def _setDefaultValuesFromMetadata(self, libname=None, path=None):
        #""" 
        #Load metadata saved in XML files.
        
        #Meta data can be things like time points, initial states, initial cost 
        #etc.
        #"""
        #self._set_scaling_factors()
        #self._set_jmi_start_values()
        
        ##self._set_start_attributes()
        
        ## set independent parameter values
        ##TA BORT 
        ##self._set_iparam_values()

        ## set optimizataion interval, time points and optimization 
        ## indices
        #if self._is_optimica():
            #self._set_opt_interval()
            #self._set_timepoints()
            #self._set_p_opt_indices()
        
    def _is_optimica(self):
        """ 
        Find out if model is compiled with OptimicaCompiler. 
        """
        return self._get_XMLDoc().get_opt_starttime()!=None

    def _set_scaling_factors(self):
        """ 
        Set scaling factors from XML file.
        """
        xmldoc = self._get_XMLDoc()
        nominal_attr = xmldoc.get_variable_nominal_attributes(
            include_alias=False)
        
        #Real variables vector
        sc = self.variable_scaling_factors
        
        for attr in nominal_attr:
            (i, ptype) = _translate_value_ref(attr[0])
            
            value = attr[1]
            if(ptype == 0 and value != None):
                # Only set scaling factors for Reals
                sc[i] = N.abs(value)
        
        #keys = nominal_attr.keys()
        #keys.sort(key=str)

        #for key in keys:
            #value_ref = xmldoc.get_valueref(key)
            #value = nominal_attr.get(key)
            
            #(i, ptype) = _translate_value_ref(value_ref)
            #if(ptype == 0):
                ## Only set scaling factors for Reals
                #sc[i] = value
              
    def _set_dependent_parameters(self):
        """
        Sets the dependent parameters of the model.
        """
        self.jmimodel.init_eval_parameters()
#        pd_tmp = N.zeros(self._n_real_pd.value)
#        pd = N.zeros(self._n_real_pd.value)
#        for i in range(self._n_real_pd.value):
#            self.set_real_pd(pd)
#            self.jmimodel.init_Fp(pd_tmp)
#            pd[i] = pd_tmp[i]
#            pd_tmp[:] = pd
#        self.set_real_pd(pd)

    def _set_start_values(self):
        """
        Sets the default start values of the model.
        """
        self.jmimodel.set_start_values()

    def _set_xml_start_values(self, p_opt_start, dx_start, x_start, u_start, 
        w_start):
        """ 
        Set start values from the XML meta data file. 
        
        Parameters::
        
            p_opt_start -- 
                The optimized parameters start value vector.
                
            dx_start -- 
                The derivatives start value vector.
                
            x_start -- 
                The states start value vector.
                
            u_start -- 
                The input start value vector.
                
            w_start -- 
                The algebraic variables start value vector.
        """
        
        xmldoc = self._get_XMLDoc()

        sc = self.jmimodel.get_variable_scaling_factors()

        # p_opt: free variables
        startattributes = xmldoc.get_p_opt_start(include_alias=False)
        n_p_opt = self.jmimodel.opt_get_n_p_opt()
        if n_p_opt > 0:
            p_opt_indices = N.zeros(n_p_opt, dtype=int)
        
            self.jmimodel.opt_get_p_opt_indices(p_opt_indices)
            p_opt_indices = p_opt_indices.tolist()
            
            for attr in startattributes:
                if attr[1] != None:
                    (z_i, ptype) = _translate_value_ref(attr[0])
                    i_pi = z_i - self._offs_real_pi.value
                    i_pi_opt = p_opt_indices.index(i_pi)
                    if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                        p_opt_start[i_pi_opt] = attr[1]/sc[z_i]
                    else:
                        #p_opt_start[i_pi_opt] = values.get(name)
                        p_opt_start[i_pi_opt] = attr[1]
                        
        # dx: derivative
        startattributes = xmldoc.get_dx_start(include_alias=False)
        for attr in startattributes:
            if attr[1] != None:
                (z_i, ptype) = _translate_value_ref(attr[0])
                i_dx = z_i - self._offs_real_dx.value
                if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                    dx_start[i_dx] = attr[1]/sc[z_i]
                else:
                    dx_start[i_dx] = attr[1]
        
        # x: differentiate
        startattributes = xmldoc.get_x_start(include_alias=False)
        for attr in startattributes:
            if attr[1] != None:
                (z_i, ptype) = _translate_value_ref(attr[0])
                i_x = z_i - self._offs_real_x.value
                if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                    x_start[i_x] = attr[1]/sc[z_i]
                else:
                    x_start[i_x] = attr[1]

        # u: input
        startattributes = xmldoc.get_u_start(include_alias=False)
        for attr in startattributes:
            if attr[1] != None:
                (z_i, ptype) = _translate_value_ref(attr[0])
                if ptype==0: # Only Reals supported here
                    i_u = z_i - self._offs_real_u.value
                    if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                        u_start[i_u] = attr[1]/sc[z_i]
                    else:
                        u_start[i_u] = attr[1]
        
        # w: algebraic
        startattributes = xmldoc.get_w_start(include_alias=False)
        for attr in startattributes:
            if attr[1]:
                (z_i, ptype) = _translate_value_ref(attr[0])
                i_w = z_i - self._offs_real_w.value
                if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                    w_start[i_w] = attr[1]/sc[z_i]
                else:
                    w_start[i_w] = attr[1]
                
    def _set_initial_values(self, p_opt_init, dx_init, x_init, u_init, 
        w_init):
        """ 
        Set initial guess values from the XML meta data file. 
        
        Parameters::
        
            p_opt_init -- 
                The optimized parameters initial guess vector.
                
            dx_init -- 
                The derivatives initial guess vector.
                
            x_init -- 
                The states initial guess vector.
                
            u_init -- 
                The input initial guess vector.
                
            w_init -- 
                The algebraic variables initial guess vector.
        """
        
        xmldoc = self._get_XMLDoc()

        sc = self.jmimodel.get_variable_scaling_factors()

        # p_opt: free variables
        initialguesses = xmldoc.get_p_opt_initial_guess(include_alias=False)
        n_p_opt = self.jmimodel.opt_get_n_p_opt()
        if n_p_opt > 0:
            p_opt_indices = N.zeros(n_p_opt, dtype=int)
        
            self.jmimodel.opt_get_p_opt_indices(p_opt_indices)
            p_opt_indices = p_opt_indices.tolist()
            
            for guess in initialguesses:
                if guess[1] != None:
                    (z_i, ptype) = _translate_value_ref(guess[0])
                    i_pi = z_i - self._offs_real_pi.value
                    i_pi_opt = p_opt_indices.index(i_pi)
                    if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                        p_opt_init[i_pi_opt] = guess[1]/sc[z_i]
                    else:
                        p_opt_init[i_pi_opt] = guess[1]

        # dx: derivative
        initialguesses = xmldoc.get_dx_initial_guess(include_alias=False)
        for guess in initialguesses:
            if guess[1] != None:
                (z_i, ptype) = _translate_value_ref(guess[0])
                i_dx = z_i - self._offs_real_dx.value
                if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                    dx_init[i_dx] = guess[1]/sc[z_i]
                else:
                    dx_init[i_dx] = guess[1]
        
        # x: differentiate
        initialguesses = xmldoc.get_x_initial_guess(include_alias=False)
        for guess in initialguesses:
            if guess[1] != None:
                (z_i, ptype) = _translate_value_ref(guess[0])
                i_x = z_i - self._offs_real_x.value
                if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                    x_init[i_x] = guess[1]/sc[z_i]
                else:
                    x_init[i_x] = guess[1]

        # u: input
        initialguesses = xmldoc.get_u_initial_guess(include_alias=False)
        for guess in initialguesses:
            if guess[1] != None:
                (z_i, ptype) = _translate_value_ref(guess[0])
                if ptype==0: # Only Reals supported here
                    i_u = z_i - self._offs_real_u.value
                    if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                        u_init[i_u] = guess[1]/sc[z_i]
                    else:
                        u_init[i_u] = guess[1]
        
        # w: algebraic
        initialguesses = xmldoc.get_w_initial_guess(include_alias=False)
        for guess in initialguesses:
            if guess[1] != None:
                (z_i, ptype) = _translate_value_ref(guess[0])
                i_w = z_i - self._offs_real_w.value
                if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                    w_init[i_w] = guess[1]/sc[z_i]
                else:
                    w_init[i_w] = guess[1]

    def _set_lb_values(self, p_opt_lb, dx_lb, x_lb, u_lb, w_lb):
        """ 
        Set lower bounds from the XML meta data file. 
        
        Parameters::
        
            p_opt_lb -- 
                The optimized parameters lower bounds vector.
                
            dx_lb -- 
                The derivatives lower bounds vector.
                
            x_lb -- 
                The states lower bounds vector.
                
            u_lb -- 
                The input lower bounds vector.
                
            w_lb -- 
                The algebraic variables lower bounds vector.
        """
        
        xmldoc = self._get_XMLDoc()

        sc = self.jmimodel.get_variable_scaling_factors()

        # p_opt: free variables
        lowerbounds = xmldoc.get_p_opt_min(include_alias=False)
        n_p_opt = self.jmimodel.opt_get_n_p_opt()
        if n_p_opt > 0:
            p_opt_indices = N.zeros(n_p_opt, dtype=int)
        
            self.jmimodel.opt_get_p_opt_indices(p_opt_indices)
            p_opt_indices = p_opt_indices.tolist()
            
            for lb in lowerbounds:
                if lb[1] != None:
                    (z_i, ptype) = _translate_value_ref(lb[0])
                    i_pi = z_i - self._offs_real_pi.value
                    i_pi_opt = p_opt_indices.index(i_pi)
                    if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                        p_opt_lb[i_pi_opt] = lb[1]/sc[z_i]
                    else:
                        p_opt_lb[i_pi_opt] = lb[1]

        # dx: derivative
        lowerbounds = xmldoc.get_dx_min(include_alias=False)
        for lb in lowerbounds:
            if lb[1] != None:
                (z_i, ptype) = _translate_value_ref(lb[0])
                i_dx = z_i - self._offs_real_dx.value
                if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                    dx_lb[i_dx] = lb[1]/sc[z_i]
                else:
                    dx_lb[i_dx] = lb[1]

        # x: differentiate
        lowerbounds = xmldoc.get_x_min(include_alias=False)
        for lb in lowerbounds:
            if lb[1] != None:
                (z_i, ptype) = _translate_value_ref(lb[0])
                i_x = z_i - self._offs_real_x.value
                if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                    x_lb[i_x] = lb[1]/sc[z_i]
                else:
                    x_lb[i_x] = lb[1]

        # u: input
        lowerbounds = xmldoc.get_u_min(include_alias=False)
        for lb in lowerbounds:
            if lb[1] != None:
                (z_i, ptype) = _translate_value_ref(lb[0])
                if ptype==0: # Only reals supported here
                    i_u = z_i - self._offs_real_u.value
                    if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                        u_lb[i_u] = lb[1]/sc[z_i]
                    else:
                        u_lb[i_u] = lb[1]

        # w: algebraic
        lowerbounds = xmldoc.get_w_min(include_alias=False)
        for lb in lowerbounds:
            if lb[1] != None:
                (z_i, ptype) = _translate_value_ref(lb[0])
                i_w = z_i - self._offs_real_w.value
                if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                    w_lb[i_w] = lb[1]/sc[z_i]
                else:
                    w_lb[i_w] = lb[1]

    def _set_ub_values(self, p_opt_ub, dx_ub, x_ub, u_ub, w_ub):
        """ 
        Set upper bounds from the XML meta data file. 
        
        Parameters::
        
            p_opt_ub -- 
                The optimized parameters upper bounds vector.
                
            dx_ub -- 
                The derivatives upper bounds vector.
                
            x_ub -- 
                The states upper bounds vector.
                
            u_ub -- 
                The input upper bounds vector.
                
            w_ub -- 
                The algebraic variables upper bounds vector.
        """        
        xmldoc = self._get_XMLDoc()

        sc = self.jmimodel.get_variable_scaling_factors()

        # p_opt: free variables
        upperbounds = xmldoc.get_p_opt_max(include_alias=False)
        n_p_opt = self.jmimodel.opt_get_n_p_opt()
        if n_p_opt > 0:
            p_opt_indices = N.zeros(n_p_opt, dtype=int)
        
            self.jmimodel.opt_get_p_opt_indices(p_opt_indices)
            p_opt_indices = p_opt_indices.tolist()
            
            for ub in upperbounds:
                if ub[1] != None:
                    (z_i, ptype) = _translate_value_ref(ub[0])
                    i_pi = z_i - self._offs_real_pi.value
                    i_pi_opt = p_opt_indices.index(i_pi)
                    if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                        p_opt_ub[i_pi_opt] = ub[1]/sc[z_i]
                    else:
                        p_opt_ub[i_pi_opt] = ub[1]

        # dx: derivative
        upperbounds = xmldoc.get_dx_max(include_alias=False)
        for ub in upperbounds:
            if ub[1] != None:
                (z_i, ptype) = _translate_value_ref(ub[0])
                i_dx = z_i - self._offs_real_dx.value
                if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                    dx_ub[i_dx] = ub[1]/sc[z_i]
                else:
                    dx_ub[i_dx] = ub[1]

        # x: differentiate
        upperbounds = xmldoc.get_x_max(include_alias=False)
        for ub in upperbounds:
            if ub[1] != None:
                (z_i, ptype) = _translate_value_ref(ub[0])
                i_x = z_i - self._offs_real_x.value
                if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                    x_ub[i_x] = ub[1]/sc[z_i]
                else:
                    x_ub[i_x] = ub[1]
            
        # u: input
        upperbounds = xmldoc.get_u_max(include_alias=False)
        for ub in upperbounds:
            if ub[1] != None:
                (z_i, ptype) = _translate_value_ref(ub[0])
                if ptype==0: # Only Reals supported here
                    i_u = z_i - self._offs_real_u.value
                    if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                        u_ub[i_u] = ub[1]/sc[z_i]
                    else:
                        u_ub[i_u] = ub[1]
                    
        # w: algebraic
        upperbounds = xmldoc.get_w_max(include_alias=False)
        for ub in upperbounds:
            if ub[1] != None:
                (z_i, ptype) = _translate_value_ref(ub[0])
                i_w = z_i - self._offs_real_w.value
                if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0:
                    w_ub[i_w] = ub[1]/sc[z_i]
                else:
                    w_ub[i_w] = ub[1]

    def _set_lin_values(self, p_opt_lin, dx_lin, x_lin, u_lin, w_lin, 
        dx_tp_lin, x_tp_lin, u_tp_lin, w_tp_lin):
        """ 
        Set linearity information from the XML meta data file. 
        
        For the linearity vectors, a "1" indicates that the variable appears 
        linearly and a "0" otherwise. The same convention is used for the linear 
        time point vectors. 
        
        For the linear time point vectors, the information about the first time 
        point is stored in the first n positions in the vector, where n is equal 
        to the number of parameters/derivatives/states/inputs or variables, 
        followed by the second time point and so on for all time points.
                
        Parameters::
        
            p_opt_lin -- 
                The optimized parameters linear information vector.
                
            dx_lin -- 
                The derivatives linear information vector.
                
            x_lin -- 
                The states linear information vector.
                
            u_lin -- 
                The input linear information vector.
                
            w_lin -- 
                The algebraic variables linear information vector.
                
            dx_tp_lin -- 
                The derivatives linear time point vector.
                
            x_tp_lin -- 
                The states linear time point vector.
                
            u_tp_lin -- 
                The input linear time point vector.
                
            w_tp_lin -- 
                The algebraic variables linear time point vector.
        """
        xmldoc = self._get_XMLDoc()
        
        # p_opt: free variables
        islinears = xmldoc.get_p_opt_islinear(include_alias=False)
        n_p_opt = self.jmimodel.opt_get_n_p_opt()
        if n_p_opt > 0:
            p_opt_indices = N.zeros(n_p_opt, dtype=int)
        
            self.jmimodel.opt_get_p_opt_indices(p_opt_indices)
            p_opt_indices = p_opt_indices.tolist()

            for lin in islinears:
                if lin[1] != None:
                    (z_i, ptype) = _translate_value_ref(lin[0])
                    i_pi = z_i - self._offs_real_pi.value
                    i_pi_opt = p_opt_indices.index(i_pi)
                    p_opt_lin[i_pi_opt] = int(lin[1])

        # dx: derivative
        islinears = xmldoc.get_dx_islinear(include_alias=False)
        for lin in islinears:
            if lin[1] != None:
                (z_i, ptype) = _translate_value_ref(lin[0])
                i_dx = z_i - self._offs_real_dx.value
                dx_lin[i_dx] = int(lin[1])
        
        # x: differentiate
        islinears = xmldoc.get_x_islinear(include_alias=False)
        for lin in islinears:
            if lin[1] != None:
                (z_i, ptype) = _translate_value_ref(lin[0])
                i_x = z_i - self._offs_real_x.value
                x_lin[i_x] = int(lin[1])
            
        # u: input
        islinears = xmldoc.get_u_islinear(include_alias=False)
        for lin in islinears:
            if lin[1] != None:
                (z_i, ptype) = _translate_value_ref(lin[0])
                if ptype==0: # Only Reals supported here
                    i_u = z_i - self._offs_real_u.value
                    u_lin[i_u] = int(lin[1])
                
        # w: algebraic
        islinears = xmldoc.get_w_islinear(include_alias=False)
        for lin in islinears:
            if lin[1] != None:
                (z_i, ptype) = _translate_value_ref(lin[0])
                if ptype==0: # Only Reals supported here
                    i_w = z_i - self._offs_real_w.value
                    w_lin[i_w] = int(lin[1])

        # number of timepoints
        no_of_tp = self._n_tp.value

        # timepoints dx: derivative
        time_variables = xmldoc.get_dx_linear_timed_variables(
            include_alias=False)
        
        for tp in range(no_of_tp):
            for tv in time_variables:
                if tv[1] != []:
                    (z_i, ptype) = _translate_value_ref(tv[0])
                    i_dx = z_i - self._offs_real_dx.value
                    dx_tp_lin[i_dx+tp*len(time_variables)] = int(tv[1][tp])
        
        # timepoints x: differentiate
        time_variables = xmldoc.get_x_linear_timed_variables(
            include_alias=False)
        
        for tp in range(no_of_tp):
            for tv in time_variables:
                if tv[1] != []:
                    (z_i, ptype) = _translate_value_ref(tv[0])
                    i_x = z_i - self._offs_real_x.value
                    x_tp_lin[i_x+tp*len(time_variables)] = int(tv[1][tp])
            
        # timepoints u: input
        time_variables = xmldoc.get_u_linear_timed_variables(
            include_alias=False)
        
        for tp in range(no_of_tp):
            for tv in time_variables:
                if tv[1] != []:
                    (z_i, ptype) = _translate_value_ref(tv[0])
                    if ptype==0: # Only reals supported here
                        i_u = z_i - self._offs_real_u.value
                        u_tp_lin[i_u+tp*len(time_variables)] = int(tv[1][tp])
        
        # timepoints w: algebraic
        time_variables = xmldoc.get_w_linear_timed_variables(
            include_alias=False)

        for tp in range(no_of_tp):
            for tv in time_variables:
                if tv[1] != []:
                    (z_i, ptype) = _translate_value_ref(tv[0])
                    i_w = z_i - self._offs_real_w.value
                    w_tp_lin[i_w+tp*len(time_variables)] = int(tv[1][tp])
    
    def get_value_reference(self, variablename):
        """ 
        Get the value reference of the variable given the variable name.
        
        Parameters::
        
            variablename --
                The name of the variable for which the value reference should be 
                found.
                
        Returns::
        
            Value reference of the specific variable.
            
        Raises::
        
            XMLException if variable was not found.
        """
        return self._get_XMLDoc().get_value_reference(variablename)
    
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
        return self._get_XMLDoc().get_variability(variablename)

    def get_variable_names(self, include_alias=True):
        """ 
        Get the names of all variables in the model.

        Parameters::
        
            include_alias -- 
                If True then include all alias variables if False then only the 
                names of the non-alias variables will be returned.
                Default: True

        Returns::
        
            List of tuples containing value references and names respectively.
        """
        return self._get_XMLDoc().get_variable_names(include_alias)


    def is_negated_alias(self, variablename):
        """ 
        Find out if variable is a negated alias or not. 
        
        Parameters::
        
            variablename -- 
                The name of the variable.
                
        Returns::
        
            True if the variable is a negated alias, otherwise False.
        
        Raises::
        
            XMLException if variable is not found in XML document.
        """
        return self._get_XMLDoc().is_negated_alias(variablename)

    #def get_variable_description(self, variablename):
        #""" Return the description of a variable. """
        #xmldoc = self._get_XMLDoc2()
        #return xmldoc.get_variable_description(variablename)

    def get_dx_variable_names(self, include_alias=True):
        """ 
        Get the names of the derivatives in the model.

        Parameters::
        
            include_alias --
                If True then include all alias variables if False then only the 
                names of the non-alias variables will be returned.
                Default: True

        Returns::
        
            List of tuples containing value reference and name respectively.
            
        Raises::
        
            XMLException if variable is not found in XML document.
        """
        return self._get_XMLDoc().get_dx_variable_names(include_alias)

    def get_x_variable_names(self, include_alias=True):
        """ 
        Get the names of the differentiated_variables in the model.

        Parameters::
        
            include_alias --
                If True then include all alias variables if False then only the 
                names of the non-alias variables will be returned.
                Default: True

        Returns::
        
            List of tuples containing value reference and name respectively.
            
        Raises::
        
            XMLException if variable is not found in XML document.
        """
        return self._get_XMLDoc().get_x_variable_names(include_alias)

    def get_u_variable_names(self, include_alias=True):
        """ 
        Get the names of the inputs in the model.

        Parameters::
        
            include_alias --
                If True then include all alias variables if False then only the 
                names of the non-alias variables will be returned.
                Default: True

        Returns::
        
            List of tuples containing value reference and name respectively.
            
        Raises::
        
            XMLException if variable is not found in XML document.
        """
        return self._get_XMLDoc().get_u_variable_names(include_alias)

    def get_w_variable_names(self, include_alias=True):
        """ 
        Get the names of the algebraic variables in the model.

        Parameters::
        
            include_alias --
                If True then include all alias variables if False then only the 
                names of the non-alias variables will be returned.
                Default: True

        Returns::
        
            List of tuples containing value reference and name respectively.
            
        Raises::
        
            XMLException if variable is not found in XML document.
        """
        return self._get_XMLDoc().get_w_variable_names(include_alias)

    def get_p_opt_variable_names(self, include_alias=True):
        """ 
        Get the names of the optimized parameters in the model.

        Parameters::
        
            include_alias --
                If True then include all alias variables if False then only the 
                names of the non-alias variables will be returned.
                Default: True

        Returns:
        
            List of tuples containing value reference and name respectively.
            
        Raises::
        
            XMLException if variable is not found in XML document.
        """
        return self._get_XMLDoc().get_p_opt_variable_names(include_alias)


    def get_variable_descriptions(self, include_alias=True):
        """ 
        Extract the descriptions of the variables in a model.

        Parameters::
        
            include_alias --
                If True then include all alias variables if False then only the 
                descriptions of the non-alias variables will be returned.
                Default: True

        Returns::
        
            List of tuples containing value reference and description 
            respectively.
            
        Raises::
        
            XMLException if variable is not found in XML document.
        """
        return self._get_XMLDoc().get_variable_descriptions(include_alias)

    def get_sizes(self):
        """ 
        Get the sizes of all variable vectors.
        
        Returns::
        
            A list of the sizes of the variable vectors.
        """
        self.jmimodel.get_sizes(self._n_real_ci,
                                self._n_real_cd,
                                self._n_real_pi,
                                self._n_real_pd,
                                self._n_integer_ci,
                                self._n_integer_cd,
                                self._n_integer_pi,
                                self._n_integer_pd,
                                self._n_boolean_ci,
                                self._n_boolean_cd,
                                self._n_boolean_pi,
                                self._n_boolean_pd,
                                self._n_real_dx,
                                self._n_real_x,
                                self._n_real_u,
                                self._n_real_w,
                                self._n_tp,
                                self._n_real_d,
                                self._n_integer_d,
                                self._n_integer_u,
                                self._n_boolean_d,
                                self._n_boolean_u,
                                self._n_outputs,
                                self._n_sw,
                                self._n_sw_init,
                                self._n_guards,
                                self._n_guards_init,
                                self._n_z)

        l = [self._n_real_ci.value, self._n_real_cd.value, \
             self._n_real_pi.value, self._n_real_pd.value, \
             self._n_integer_ci.value, self._n_integer_cd.value, \
             self._n_integer_pi.value, self._n_integer_pd.value, \
             self._n_boolean_ci.value, self._n_boolean_cd.value, \
             self._n_boolean_pi.value, self._n_boolean_pd.value, \
             self._n_real_dx.value, self._n_real_x.value, \
             self._n_real_u.value, self._n_real_w.value, \
             self._n_real_d.value, \
             self._n_integer_d.value, self._n_integer_u.value,\
             self._n_boolean_d.value, self._n_boolean_u.value,\
             self._n_outputs.value,
             self._n_tp.value, self._n_sw.value,
             self._n_sw_init.value, self._n_guards.value,
             self._n_guards_init.value,self._n_z.value]
        return l
    
    def get_offsets(self):
        """ 
        Get all offsets for the variable types in the z vector.
        
        Returns::
        
            A list of the offsets for the variable types in the z vector.
        """
        
        self.jmimodel.get_offsets(self._offs_real_ci,
                                  self._offs_real_cd,
                                  self._offs_real_pi,
                                  self._offs_real_pd,
                                  self._offs_integer_ci,
                                  self._offs_integer_cd,
                                  self._offs_integer_pi,
                                  self._offs_integer_pd,
                                  self._offs_boolean_ci,
                                  self._offs_boolean_cd,
                                  self._offs_boolean_pi,
                                  self._offs_boolean_pd,
                                  self._offs_real_dx,
                                  self._offs_real_x,
                                  self._offs_real_u,
                                  self._offs_real_w,
                                  self._offs_t,
                                  self._offs_real_dx_p,
                                  self._offs_real_x_p,
                                  self._offs_real_u_p,
                                  self._offs_real_w_p,
                                  self._offs_real_d,
                                  self._offs_integer_d,
                                  self._offs_integer_u,
                                  self._offs_boolean_d,
                                  self._offs_boolean_u,
                                  self._offs_sw,
                                  self._offs_sw_init,
                                  self._offs_guards,
                                  self._offs_guards_init,
                                  self._offs_pre_real_dx,
                                  self._offs_pre_real_x,
                                  self._offs_pre_real_u,
                                  self._offs_pre_real_w,
                                  self._offs_pre_real_d,
                                  self._offs_pre_integer_d,
                                  self._offs_pre_integer_u,
                                  self._offs_pre_boolean_d,
                                  self._offs_pre_boolean_u,
                                  self._offs_pre_sw,
                                  self._offs_pre_sw_init,
                                  self._offs_pre_guards,
                                  self._offs_pre_guards_init)
        
        l = [self._offs_real_ci.value, self._offs_real_cd.value, \
             self._offs_real_pi.value, self._offs_real_pd.value, \
             self._offs_integer_ci.value, self._offs_integer_cd.value, \
             self._offs_integer_pi.value, self._offs_integer_pd.value, \
             self._offs_boolean_ci.value, self._offs_boolean_cd.value, \
             self._offs_boolean_pi.value, self._offs_boolean_pd.value, \
             self._offs_real_dx.value, self._offs_real_x.value, \
             self._offs_real_u.value, self._offs_real_w.value, \
             self._offs_t.value, self._offs_real_dx_p.value, \
             self._offs_real_x_p.value, self._offs_real_u_p.value, \
             self._offs_real_w_p.value, \
             self._offs_real_d.value, \
             self._offs_integer_d.value, self._offs_integer_u.value,\
             self._offs_boolean_d.value, self._offs_boolean_u.value,\
             self._offs_sw.value,
             self._offs_sw_init.value,
             self._offs_guards.value,
             self._offs_guards_init.value,
             self._offs_pre_real_dx.value, self._offs_pre_real_x.value, \
             self._offs_pre_real_u.value, self._offs_pre_real_w.value, \
             self._offs_pre_real_d.value, \
             self._offs_pre_integer_d.value, self._offs_pre_integer_u.value,\
             self._offs_pre_boolean_d.value, self._offs_pre_boolean_u.value,\
             self._offs_pre_sw.value,
             self._offs_pre_sw_init.value,
             self._offs_pre_guards.value,
             self._offs_pre_guards_init.value]
        return l

    def get_n_tp(self):
        """ 
        Get the number of time points in the model.
        
        Returns::
        
            The number of time points.
        """
        
        self.jmimodel.get_n_tp(self._n_tp)
        return self._n_tp.value

    def _get_real_ci(self):
        return self.jmimodel.get_real_ci()
        
    def _set_real_ci(self, real_ci):
        self.jmimodel._real_ci[:] = real_ci
        
    real_ci = property(_get_real_ci, _set_real_ci, doc = 
    """
    Property for accessing the real independent constants vector.
    """)

    def _get_real_cd(self):
        return self.jmimodel.get_real_cd()

    def _set_real_cd(self, real_cd):
        self.jmimodel._real_cd[:] = real_cd
        
    real_cd = property(_get_real_cd, _set_real_cd, doc = 
    """
    Property for accessing the dependent real constants vector.
    """)
    
    def _get_real_pi(self):
        return self.jmimodel.get_real_pi()
        
    def _set_real_pi(self, real_pi):
        self.jmimodel._real_pi[:] = real_pi
        
    real_pi = property(_get_real_pi, _set_real_pi, doc = 
    """
    Property for accessing the real independent parameters vector.
    """)

    def _get_real_pd(self):
        return self.jmimodel._real_pd
        
    def _set_real_pd(self, real_pd):
        self.jmimodel._real_pd[:] = real_pd
        
    real_pd = property(_get_real_pd, _set_real_pd, doc = 
    """
    Property for accessing the real dependent parameters vector.
    """)

    def _get_integer_ci(self):
        return self.jmimodel.get_integer_ci()
        
    def _set_integer_ci(self, integer_ci):
        self.jmimodel._integer_ci[:] = integer_ci
        
    integer_ci = property(_get_integer_ci, _set_integer_ci, doc = 
    """
    Property for accessing the integer independent constants vector.
    """)

    def _get_integer_cd(self):
        return self.jmimodel.get_integer_cd()

    def _set_integer_cd(self, integer_cd):
        self.jmimodel._integer_cd[:] = integer_cd
        
    integer_cd = property(_get_integer_cd, _set_integer_cd, doc = 
    """
    Property for accessing the dependent integer constants vector.
    """)
    
    def _get_integer_pi(self):
        return self.jmimodel.get_integer_pi()
        
    def _set_integer_pi(self, integer_pi):
        self.jmimodel._integer_pi[:] = integer_pi
        
    integer_pi = property(_get_integer_pi, _set_integer_pi, doc = 
    """
    Property for accessing the integer independent parameters vector.
    """)

    def _get_integer_pd(self):
        return self.jmimodel._integer_pd
        
    def _set_integer_pd(self, integer_pd):
        self.jmimodel._integer_pd[:] = integer_pd
        
    integer_pd = property(_get_integer_pd, _set_integer_pd, doc = 
    """
    Property for accessing the integer dependent parameters vector.
    """)

    def _get_boolean_ci(self):
        return self.jmimodel.get_boolean_ci()
        
    def _set_boolean_ci(self, boolean_ci):
        self.jmimodel._boolean_ci[:] = boolean_ci
        
    boolean_ci = property(_get_boolean_ci, _set_boolean_ci, doc = 
    """
    Property for accessing the integer independent constants vector.
    """)

    def _get_boolean_cd(self):
        return self.jmimodel.get_boolean_cd()

    def _set_boolean_cd(self, boolean_cd):
        self.jmimodel._boolean_cd[:] = boolean_cd
        
    boolean_cd = property(_get_boolean_cd, _set_boolean_cd, doc = 
    """
    Property for accessing the dependent boolean constants vector.
    """)
    
    def _get_boolean_pi(self):
        return self.jmimodel.get_boolean_pi()
        
    def _set_boolean_pi(self, boolean_pi):
        self.jmimodel._boolean_pi[:] = boolean_pi
        
    boolean_pi = property(_get_boolean_pi, _set_boolean_pi, doc = 
    """
    Property for accessing the boolean independent parameters vector.
    """)

    def _get_boolean_pd(self):
        return self.jmimodel._boolean_pd
        
    def _set_boolean_pd(self, boolean_pd):
        self.jmimodel._boolean_pd[:] = boolean_pd
        
    boolean_pd = property(_get_boolean_pd, _set_boolean_pd, doc = 
    """
    Property for accessing the boolean dependent parameters vector.
    """)

    def _get_real_dx(self):
        return self.jmimodel.get_real_dx()
        
    def _set_real_dx(self, real_dx):
        self.jmimodel._real_dx[:] = real_dx
        
    real_dx = property(_get_real_dx, _set_real_dx, doc = 
    """
    Property for accessing the real derivatives vector.
    """)

    def _get_real_x(self):
        return self.jmimodel.get_real_x()
        
    def _set_real_x(self, real_x):
        self.jmimodel._real_x[:] = real_x
        
    real_x = property(_get_real_x, _set_real_x, doc = 
    """
    Property for accessing the real differentiated variables vector.
    """)

    def _get_real_u(self):
        return self.jmimodel.get_real_u()
        
    def _set_real_u(self, real_u):
        self.jmimodel._real_u[:] = real_u
        
    real_u = property(_get_real_u, _set_real_u, doc = 
    """
    Property for accessing the real inputs vector.
    """)

    def _get_real_w(self):
        return self.jmimodel.get_real_w()
        
    def _set_real_w(self, real_w):
        self.jmimodel._real_w[:] = real_w
        
    real_w = property(_get_real_w, _set_real_w, doc = 
    """
    Property for accessing the real algebraic variables vector.
    """)

    def _get_t(self):
        return self.jmimodel.get_t()
        
    def _set_t(self, t):
        self.jmimodel._t[:] = t
        
    t = property(_get_t, _set_t, doc = 
    """
    Property for accessing the time value.
    """)

    def get_real_dx_p(self, i):
        """ 
        Get the real derivatives variables vector corresponding to the i:th time 
        point.
        
        Parameters::
        
            i --
                Point in time.
                
        Returns::
        
            A reference to the real derivatives variables vector for time point 
            i.
        """
        return self.jmimodel.get_real_dx_p(i)
        
    def set_real_dx_p(self, real_dx_p, i):
        """ 
        Set the derivatives variables vector corresponding to the i:th time 
        point.
        
        Parameters::
            
            real_dx_p --
                The new real derivatives variables vector for time point i.
                
            i --
                Point in time.
        """
        _real_dx_p = self.jmimodel.get_real_dx_p(i)
        _real_dx_p[:] = real_dx_p

    def get_real_x_p(self, i):
        """ 
        Get the real differentiated variables vector corresponding to the i:th 
        time point.
        
        Parameters::
        
            i --
                Point in time.
                
        Returns::
        
            A reference to the real differentiated variables vector for time 
            point i.
        """
        return self.jmimodel.get_real_x_p(i)
        
    def set_real_x_p(self, real_x_p, i):
        """ 
        Set the real differentiated variables vector corresponding to the i:th 
        time point. 

        Parameters::
            
            real_x_p --
                The new real differentiated variables vector for time point i.
                
            i --
                Point in time.
        """
        _real_x_p = self.jmimodel.get_real_x_p(i)
        _real_x_p[:] = real_x_p

    def get_real_u_p(self, i):
        """ 
        Get the real inputs vector corresponding to the i:th time point.
        
        Parameters::
        
            i --
                Point in time.
                
        Returns::
        
            A reference to the real inputs variables vector for time point i.
        """
        return self.jmimodel.get_real_u_p(i)
        
    def set_real_u_p(self, real_u_p, i):
        """ 
        Set the real inputs vector corresponding to the i:th time point.
        
        Parameters::
        
            real_u_p --
                The new real inputs variables vector for time point i.
                
            i --
                Point in time.
        
        """
        _real_u_p = self.jmimodel.get_real_u_p(i)
        _real_u_p[:] = real_u_p
        
    def get_real_w_p(self, i):
        """ 
        Get the real algebraic variables vector corresponding to the i:th time 
        point.
        
        Parameters::
        
            i --
                Point in time.
                
        Returns::
        
            A reference to the real algebraic variables vector for time point i.
        """
        return self.jmimodel.get_real_w_p(i)
        
    def set_real_w_p(self, real_w_p, i):
        """ 
        Set the real algebraic variables vector corresponding to the i:th time 
        point.
        
        Parameters::
        
            real_w_p --
                The new real algebraic variables vector for time point i.
                
            i --
                Point in time.
        """
        _real_w_p = self.jmimodel.get_real_w_p(i)
        _real_w_p[:] = real_w_p

    def _get_real_d(self):
        return self.jmimodel.get_real_d()
        
    def _set_real_d(self, real_d):
        self.jmimodel._real_d[:] = real_d
        
    real_d = property(_get_real_d, _set_real_d, doc = 
    """
    Property for accessing the real discrete variables vector.
    """)

    def _get_integer_d(self):
        return self.jmimodel.get_integer_d()
        
    def _set_integer_d(self, integer_d):
        self.jmimodel._integer_d[:] = integer_d
        
    integer_d = property(_get_integer_d, _set_integer_d, doc = 
    """
    Property for accessing the integer discrete variables vector.
    """)

    def _get_integer_u(self):
        return self.jmimodel.get_integer_u()
        
    def _set_integer_u(self, integer_u):
        self.jmimodel._integer_u[:] = integer_u
        
    integer_u = property(_get_integer_u, _set_integer_u, doc = 
    """
    Property for accessing the integer input variables vector.
    """)

    def _get_boolean_d(self):
        return self.jmimodel.get_boolean_d()
        
    def _set_boolean_d(self, boolean_d):
        self.jmimodel._boolean_d[:] = boolean_d
        
    boolean_d = property(_get_boolean_d, _set_boolean_d, doc = 
    """
    Property for accessing the boolean discrete variables vector.
    """)

    def _get_boolean_u(self):
        return self.jmimodel.get_boolean_u()
        
    def _set_boolean_u(self, boolean_u):
        self.jmimodel._boolean_u[:] = boolean_u
        
    boolean_u = property(_get_boolean_u, _set_boolean_u, doc = 
    """
    Property for accessing the boolean input variables vector.
    """)

    def _get_sw(self):
        return self.jmimodel.get_sw()
        
    def _set_sw(self, sw):
        self.jmimodel._sw[:] = sw
        
    sw = property(_get_sw, _set_sw, doc = 
    """
    Property for accessing the switch function vector of the DAE. A switch value 
    of 1 corresponds to true and 0 corresponds to false.
    """)

    def _get_sw_init(self):
        return self.jmimodel.get_sw_init()
        
    def _set_sw_init(self, sw_init):
        self.jmimodel._sw_init[:] = sw_init
        
    sw_init = property(_get_sw_init, _set_sw_init, doc = 
    """
    Property for accessing the switch function vector of the DAE initialization 
    system. A switch value of 1 corresponds to true and 0 corresponds to false.
    """)

    def _get_variable_scaling_factors(self):
        return self.jmimodel.get_variable_scaling_factors()
        
    def _set_variable_scaling_factors(self, variable_scaling_factors):
        self.jmimodel._variable_scaling_factors[:] = variable_scaling_factors
        
    variable_scaling_factors = property(_get_variable_scaling_factors, 
        _set_variable_scaling_factors, doc = 
    """
    Property for accessing the variable scaling vector of the DAE initialization 
    system. The scaling variable vector has the same size as the z vector: 
    scaling factors for booleans, integers and switches are ignored.
    """)

    def get_scaling_method(self):
        """ 
        Get the scaling_method. Valid values are JMI_SCALING_NONE and 
        JMI_SCALING_VARIABLES.
        
        Returns::
        
            The scaling method currently used.
        """
        return self.jmimodel.get_scaling_method()
        
    def _get_z(self):
        return self.jmimodel.get_z()
        
    def _set_z(self, z):
        self.jmimodel._z[:] = z
        
    z = property(_get_z, _set_z, doc = 
    """
    Property for accessing the z vector. (The vector containing all parameters, 
    variables and point-wise evalutated variables vector.
    """)
    
    def initialize(self, algorithm='IpoptInitializationAlg', options={}):
        """ 
        Compact function for model initialization.
            
        The initialization method depends on which algorithm is used, this can 
        be set with the function argument 'algorithm'. Options for the algorithm 
        are passed as option classes or as pure dicts. See 
        JMUModel.initialize_options for more details.
            
        The default algorithm for this function is IpoptInitializationAlg. 
            
        Parameters::
            
            algorithm --
                The algorithm which will be used for the initialization is 
                specified by passing the algorithm class as string or class 
                object in this argument. 'algorithm' can be any class which 
                implements the abstract class AlgorithmBase (found in 
                algorithm_drivers.py). In this way it is possible to write own 
                algorithms and use them with this function.
                Default: 'IpoptInitializationAlg'
                
            options -- 
                The options that should be used in the algorithm. For details on 
                the options do:
                
                    >> myModel = JMUModel(...)
                    >> opts = myModel.initialize_options()
                    >> opts?

                Valid values are: 
                    - A dict which gives IpoptInitializationAlgOptions with 
                      default values on all options except the ones listed in 
                      the dict. Empty dict will thus give all options with 
                      default values.
                    - An options object.
                Default: Empty dict

        Returns::
            
            Result object, subclass of algorithm_drivers.ResultBase.
        """
        return self._exec_algorithm('pyjmi.jmi_algorithm_drivers',
                                    algorithm,
                                    options)

    def initialize_options(self, algorithm='IpoptInitializationAlg'):
        """ 
        Get an instance of the initialize options class, prefilled with default 
        values. If called without argument then the options class for the 
        default initialization algorithm will be returned.
        
        Parameters::
        
            algorithm --
                The algorithm for which the options class should be fetched. 
                Possible values are: 'IpoptInitializationAlg', 'KInitSolveAlg'.
                Default: 'IpoptInitializationAlg'
                
        Returns::
        
            Options class for the algorithm specified with default values.
        """
        return self._default_options('pyjmi.jmi_algorithm_drivers', algorithm)
        
    def simulate(self, 
                 start_time=0.0,
                 final_time=1.0,
                 input=(),
                 algorithm='AssimuloAlg', 
                 options={}):
        """
        Simulation of a model.
            
        The simulation method depends on which algorithm is used, which can be 
        set by the function argument 'algorithm'. Options for the simulation 
        algorithm are passed as option classes or as pure dicts. See 
        JMUModel.simulate_options for more details.
            
        The default algorithm for this function is AssimuloAlg. 
            
        Parameters::
        
            start_time --
                Start time for the simulation.
                Default: 0.0
                
            final_time --
                Final time for the simulation.
                Default: 1.0
                
            input --
                Input signal for the simulation. The input should be a 2-tuple 
                consisting of first the names of the input variable(s) and then 
                the data matrix or a function. If a data matrix, the first 
                column should be a time vector and then the variable vectors as
                columns. If instead a function, the argument should correspond
                to time and the output the variable data. See the users-guide 
                for examples.
                Default: Empty tuple.
                
            algorithm --
                The algorithm that will be used for the simulation is specified 
                by passing the algorithm class as string or class object in this 
                argument. 'algorithm' can be any class which implements the 
                abstract class AlgorithmBase which is found in the module 
                pyjmi.common.algorithm_drivers. In this way it is possible to write 
                custom algorithms and use them with this function.
                Default: 'AssimuloAlg'
                
            options -- 
                The options to be used in the algorithm. For details on 
                available options do:
                
                    >> myModel = JMUModel(...)
                    >> opts = myModel.simulate_options()
                    >> opts?

                Valid values are: 
                - A dict that overrides some or all of the default values 
                  provided by AssimuloAlgOptions. An empty dict will thus give 
                  all options with default values.
                - A AssimuloAlgOptions object.
                Default: Empty dict
            
        Returns::
            
            A result object, subclass of algorithm_drivers.ResultBase.
        """
        print "WARNING: Support for simulation of JMUs is to be discontinued. The recommended simulation framework is now the FMI, see the users-guide."
        return self._exec_simulate_algorithm(start_time, 
                                             final_time, 
                                             input,
                                             'pyjmi.jmi_algorithm_drivers',
                                             algorithm,
                                             options)

    def simulate_options(self, algorithm='AssimuloAlg'):
        """ 
        Get an instance of the simulate options class, prefilled with default 
        values. If called without argument then the options class for the 
        default simulation algorithm will be returned.

        Parameters::
        
            algorithm --
                The algorithm for which the options class should be fetched. 
                Possible values are: 'AssimuloAlg', 'AssimuloFMIAlg'.
                Default: 'AssimuloAlg'
                
        Returns::
        
            Options class for the algorithm specified with default values.
        """
        return self._default_options('pyjmi.jmi_algorithm_drivers', algorithm)
        
    def optimize(self, 
                 algorithm='CollocationLagrangePolynomialsAlg', 
                 options={}):
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
                - 'CollocationLagrangePolynomialsAlg'. This algorithm is based 
                  on direct collocation on finite elements and the algorithm 
                  IPOPT is used to obtain a numerical solution to the problem.
                Default: 'CollocationLagrangePolynomialsAlg'
                
            options -- 
                The options that should be used in the algorithm. The options
                documentation can be retrieved from an options object:
                
                    >>> myModel = JMUModel(...)
                    >>> opts = myModel.optimize_options()
                    >>> opts?

                Valid values are: 
                - A dict that overrides some or all of the default values
                  provided by CollocationLagrangePolynomialsAlgOptions. An empty
                  dict will thus give all options with default values.
                - A CollocationLagrangePolynomialsAlgOptions object.
                Default: Empty dict
            
        Returns::
            
            A result object, subclass of algorithm_drivers.ResultBase.
        """
        return self._exec_algorithm('pyjmi.jmi_algorithm_drivers',
                                    algorithm,
                                    options)

    def optimize_options(self, algorithm='CollocationLagrangePolynomialsAlg'):
        """
        Returns an instance of the optimize options class containing options 
        default values. If called without argument then the options class for 
        the default optimization algorithm will be returned.
        
        Parameters::
        
            algorithm --
                The algorithm for which the options class should be returned. 
                Possible values are: 'CollocationLagrangePolynomialsAlg'.
                Default: 'CollocationLagrangePolynomialsAlg'
                
        Returns::
        
            Options class for the algorithm specified with default values.
        """
        return self._default_options('pyjmi.jmi_algorithm_drivers', algorithm)

    def initialize_from_data(self,res,time=0.0):
        """
        Initialize the JMUModel from a result data object. All
        variables, but not the parametes, in the model are initialized
        with variable values extracted from the data at a time instant
        specified by the argument time. Linear interpolation is used
        to compute the variable values from the trajectory data.

        Parameters::
            res --
                A result data object of the class
                pyjmi.common.io.(ResultDymolaTextual/ResultDymolaBinary 
                or containing either.
            time --
                The time at which variable values are extracted from
                the result data.

        Limitations::
            Only real variables are initialized.
            
        """
        #Check to see if the "res" contains any result data, if so interpret
        #res.result_data as the intended input. This as to allow direct passing
        #of a simulation result where the actual simulation result are stored in
        #"result_data"
        if hasattr(res, "result_data"):
            res = res.result_data
            
        if not hasattr(res, "get_column"):
            raise JMIException("Unknown input object to function.")

        # Obtain the names
        names = self.get_dx_variable_names(include_alias=False)
        dx_names=[]
        for name in sorted(names):
            dx_names.append(name[1])

        names = self.get_x_variable_names(include_alias=False)
        x_names=[]
        for name in sorted(names):
            x_names.append(name[1])


        names = self.get_u_variable_names(include_alias=False)
        u_names=[]
        for name in sorted(names):
            u_names.append(name[1])

        names = self.get_w_variable_names(include_alias=False)
        w_names=[]
        for name in sorted(names):
            w_names.append(name[1])
    
        # Initialize variable names
        # Loop over all the names

        for name in dx_names:
            try:
                #print(name)
                traj = res.get_variable_data(name)
                if N.ndim(traj.x)>0:
                    traj_li = TrajectoryLinearInterpolation(traj.t,N.transpose(N.array([traj.x])))
                    self.set(name,traj_li.eval(time))
                else:
                    self.set(name,traj.x)
            except VariableNotFoundError:
                var_name = strip_der(name)
                print var_name
                found = False
                (alias_names,neg) = self.get_aliases_for_variable(var_name)
                print alias_names
                for n in alias_names:
                    d_name = der_name(n)
                    try:
                        traj = res.get_variable_data(d_name)
                        if N.ndim(traj.x)>0:
                            traj_li = TrajectoryLinearInterpolation(traj.t,N.transpose(N.array([traj.x])))
                            self.set(name,traj_li.eval(time))
                        else:
                            self.set(name,traj.x)
                            found = True
                    except VariableNotFoundError:
                        print "Did not find " + d_name
                if not found:
                    print "Warning: Could not find trajectory for derivative variable " + name
        for name in x_names:
            try:
                #print(name)
                traj = res.get_variable_data(name)
                if N.ndim(traj.x)>0:
                    traj_li = TrajectoryLinearInterpolation(traj.t,N.transpose(N.array([traj.x])))
                    self.set(name,traj_li.eval(time))
                else:
                    self.set(name,traj.x)
            except:
                print "Warning: Could not find trajectory for state variable " + name
        for name in u_names:
            try:
                #print(name)
                traj = res.get_variable_data(name)
                if N.ndim(traj.x)>0:
                    traj_li = TrajectoryLinearInterpolation(traj.t,N.transpose(N.array([traj.x])))
                    self.set(name,traj_li.eval(time))
                else:
                    self.set(name,traj.x)
            except:
                print "Warning: Could not find trajectory for input variable " + name

        for name in w_names:
            try:
                #print(name)
                traj = res.get_variable_data(name)
                if N.ndim(traj.x)>0:
                    traj_li = TrajectoryLinearInterpolation(traj.t,N.transpose(N.array([traj.x])))
                    self.set(name,traj_li.eval(time))
                else:
                    self.set(name,traj.x)
            except:
                print "Warning: Could not find trajectory for algebraic variable " + name

    
    def _get_XMLDoc(self):
        """ 
        Get the XMLDoc for the model variables XML file. 
        """
        return self._xmldoc
    
    def _set_XMLDoc(self, doc):
        """ 
        Set the XMLDoc for model variables XML file. 
        """
        self._xmldoc = doc

    #def _get_XMLValuesDoc(self):
        #""" 
        #Get the XMLDoc for independent parameter values. 
        #"""
        #return self._xmlvaluesdoc
    
    #def _set_XMLValuesDoc(self, doc):
        #""" 
        #Set the XMLDoc for independent parameter values. 
        #"""
        #self._xmlvaluesdoc = doc
       
    #def _set_start_attributes(self):
        #""" 
        #Set start attributes for all variables. The start attributes are fetched 
        #together with the corresponding valueReferences from the XMLDoc 
        #instance. The valueReferences are mapped to which primitive type vector 
        #and index in vector each start value belongs to using the protocol 
        #implemented in _translateValueRef.
        #"""
        #xmldoc = self._get_XMLDoc()
        #start_attr = xmldoc.get_variable_start_attributes(include_alias=False)
        
        ##Real variables vector
        #z = self.z
        #sc = self.variable_scaling_factors

        ## First reset the start values
        #for i in range(len(z)):
            #z[i] = 0
        
        #for attr in start_attr:
            #(i, ptype) = _translate_value_ref(attr[0])
            #value = attr[1]
            
            #if value != None: # if no start attr is set then value is None
                #if ptype == 0:
                    ## Primitive type is Real
                    #if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0: 
                        #z[i] = value/sc[i]
                    #else:
                        #z[i] = value
                #elif(ptype == 1):
                    ## Primitive type is Integer
                    #z[i] = value
                #elif(ptype == 2):
                    ## Primitive type is Boolean
                    #z[i] = value
                #elif(ptype == 3):
                    ## Primitive type is String
                    #pass
                #else:
                    #raise JMIException("Unknown type: index=" + str(i) + ", type=" + str(ptype))
    
    #def _set_iparam_values(self, xml_values_doc=None):
        #""" 
        #Set the values for the independent parameters. 
        #"""
        #if not xml_values_doc:
            #xml_values_doc = self._get_XMLValuesDoc()
        #values = xml_values_doc.get_iparam_values() #{variablename:value}
        #xmldoc = self._get_XMLDoc()
       
        #z = self.z
        #sc = self.variable_scaling_factors

        #for name in values.keys():
            #value = values.get(name)
            ##value_ref = variables.get(name)
            #(i, ptype) = _translate_value_ref(xmldoc.get_value_reference(name))

            #if(ptype == 0):
                ## Primitive type is Real
                #if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0: 
                    #z[i] = value/sc[i]
                #else:
                    #z[i] = value
            #elif(ptype == 1):
                ## Primitive type is Integer
                #z[i] = value
            #elif(ptype == 2):
                ## Primitive type is Boolean
                #z[i] = value
            #elif(ptype == 3):
                ## Primitive type is String
                #pass
            #else:
                #raise JMIException("Unknown type")
            
    def _set_opt_interval(self):
        """ 
        Set the optimization intervals (if Optimica). 
        """
        xmldoc = self._get_XMLDoc()
        
        starttime = xmldoc.get_opt_starttime()
        starttimefree = xmldoc.get_opt_starttime_free()
        finaltime = xmldoc.get_opt_finaltime()
        finaltimefree = xmldoc.get_opt_finaltime_free()
        if starttime!=None and finaltime!=None:
            self.jmimodel.opt_set_optimization_interval(starttime, 
                int(starttimefree), finaltime, int(finaltimefree))
        else:
            raise Exception("Optimica model needs a start and final time\
                but no start or final time could be found in XML file.")

    def _set_timepoints(self):       
        """ 
        Set the optimization timepoints (if Optimica). 
        """
        xmldoc = self._get_XMLDoc()
        start =  xmldoc.get_opt_starttime()
        final = xmldoc.get_opt_finaltime()
        points = []
        for point in xmldoc.get_opt_timepoints():
            norm_point = (point - start) / (final-start)
            points.append(norm_point)         
        self.jmimodel.set_tp(N.array(points))   
        
    def _set_p_opt_indices(self):
        """ 
        Set the optimization parameter indices (if Optimica). 
        """
        xmldoc = self._get_XMLDoc()
        refs = xmldoc.get_p_opt_value_reference()
        
        if len(refs) > 0:
            n_p_opt = 0
            p_opt_indices = []
            refs.sort(key=int)            
            for ref in refs:
                (z_i, ptype) = _translate_value_ref(ref)
                p_opt_indices.append(z_i - self._offs_real_pi.value)
                n_p_opt = n_p_opt +1
            self._n_p_opt = n_p_opt
            self.jmimodel.opt_set_p_opt_indices(n_p_opt,N.array(
                p_opt_indices,dtype=int))

    def get_identifier(self):
        """ 
        Return the model identifier, name of binary model file and prefix in 
        the C-function names of the model. 
        
        Returns::
        
            The model identifier.
        """
        return self._get_XMLDoc().get_model_identifier()
    
    def get_name(self):
        """
        Return the model name as used in the modeling environment. 
        
        Returns::
        
            The model name.
        """
        return self._get_XMLDoc().get_model_name()

    def _get(self, name):
        """
        Helper method to model.get. Get the value of a variable or parameter 
        given the name.
        
        Parameters::
        
            name -- 
                The name of the variable or parameter.
                
        Raises::
        
            Exception if name not present in model.
        """
        
        xmldoc = self._get_XMLDoc()
        valref = xmldoc.get_value_reference(name.strip())
        sc = self.variable_scaling_factors
        value = None
        if valref != None:
            (z_i, ptype) = _translate_value_ref(valref)
            if xmldoc.is_negated_alias(name):
                if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0 and \
                    ptype==0: 
                    value = -(self.z[z_i])*sc[z_i]
                else:
                    value = -self.z[z_i]
            else:
                if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0 and \
                    ptype==0: 
                    value = (self.z[z_i])*sc[z_i]
                else:
                    value = self.z[z_i]
        else:
            raise Exception("Parameter or variable "+name.strip()+" could not be\
             found in model.")
        return value
        
    def _set(self, name, value, recompute_dependent_parameters=True):
        """ 
        Set the value of a parameter or variable given a name. If an independent 
        parameter is set, the dependent parameters are recomputed if 
        recompute_dependent_parameters is set to True.

        Parameters::
        
            name -- 
                The name of the variable or parameter.
                
            value -- 
                The new parameter or variable value.
                
            recompute_dependent_parameters -- 
                If True, dependent parameters are recomputed if an independent 
                parameter is set.
                Default: True
                
        Raises::
        
            Exception if name not present in model or if variable can not be 
            set.
        """
        
        xmldoc = self._get_XMLDoc()
        valref = xmldoc.get_value_reference(name)
        sc = self.variable_scaling_factors
        if valref != None:
            if xmldoc.is_constant(name):
               raise Exception(
                "%s is a constant, it can not be modified." %name)
            (z_i, ptype) = _translate_value_ref(valref)
            if xmldoc.is_negated_alias(name):
                if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0 and \
                    ptype==0: 
                    self.z[z_i] = -(value)/sc[z_i]
                else:
                    self.z[z_i] = -(value)
            else:
                if self.get_scaling_method() & JMI_SCALING_VARIABLES > 0 and \
                    ptype==0: 
                    self.z[z_i] = (value)/sc[z_i]
                else:
                    self.z[z_i] = (value)

            if recompute_dependent_parameters and \
                   z_i>=self._offs_real_pi and \
                   z_i<self._offs_real_pd:
                self._set_dependent_parameters()
                
        else:
            raise Exception("Parameter or variable "+name+" could not be found \
                in model.")
    
    #def load_parameters_from_XML(self, filename=''):
        #""" 
        #Reset the pi vector with values from the XML file created when the model 
        #was compiled. If an XML file other than this should be used instead, set 
        #the filename of the file to load.
        
        #Parameters::
        
            #filename -- 
                #The name of XML file that should be loaded.
                #Default: Empty string.
        
        #Raises::
        
            #IOError if file could not be found.
        #"""
        #if filename:
            #if os.path.exists(filename):
                #self._parse_xml_values(filename)
            #else:
                #raise IOError("The file: "+filename+" could not be found.")
        #else:
            #self._parse_xml_values(self._xml_values_name)
            
        #self._set_iparam_values(self._get_XMLValuesDoc())
        
    #def write_parameters_to_XML(self, filename=''):
        #""" 
        #Write parameter values (real, integer, boolean supported) in the pi 
        #vector to XML. The default behaviour is to overwrite the XML file 
        #created when model was compiled. To write to a new file, set the file 
        #name of the new file to write to. 
        
        #Parameters::
        
            #filename -- 
                #The filename of the XML file that the parameter vector should be 
                #written to.
                #Default: Empty string.
        #"""       
        ## get xmldoc and z-vector
        #xmldoc = self._get_XMLDoc()
        #z = self.z
        
        ## create temp XMLValuesDoc from the xml values file for writing 
        ## the new parameters to
        #temp_doc = xmlparser.IndependentParameters(self._xml_values_name)
        
        ## get all parameters
        #parameters = temp_doc.get_all_parameters()
        
        #for p in parameters:
            ##get value reference
            #name = p.get_name()
            
            ##get index in z-vector
            #index, type = _translate_value_ref(
                #xmldoc.get_value_reference(name)) 
            
            ## set value in xml values doc for name = name 
            ## to value from z-vector
            #if type == 2:
                ##is boolean
                #p.set_value((bool(z[index])))
            #else:
                #p.set_value(z[index])
            
        ## finally, write to file
        #if filename:
            ## create directory if it does not exist
            #dir = os.path.dirname(filename)
            #if dir and not os.path.exists(dir):
                #os.mkdir(dir)
            #temp_doc.write_to_file(filename)
        #else:
            #temp_doc.write_to_file(self._xml_values_name)
            
    def get_aliases_for_variable(self, variable):
        """ 
        Get a list of all alias variables belonging to the aliased variable 
        passed as argument to the function along with a list of booleans 
        indicating whether the alias variable should be negated or not.
        
        Parameters::
            
            variable --
                The aliased variable. 
            
        Returns::
                
                Tuple of lists, the first containing the names of the alias 
                variables, the second containing booleans for each alias 
                variable indicating whether the variable is a negated variable 
                or not.
                
                Tuple of empty lists if the variable has no alias variables. 
                
                None if variable cannot be found in model.
        """
        return self._get_XMLDoc().get_aliases_for_variable(variable)
            
    def opt_interval_starttime_free(self):
        """ 
        Evaluate if the optimization start time is free.
        
        Returns::
        
            True if optimization start time is free, False otherwise.
        """
        start_time, start_time_free, final_time, final_time_free = \
                                  self.jmimodel.opt_get_optimization_interval()
        return start_time_free==1
        
    def opt_interval_starttime_fixed(self):
        """ 
        Evaluate if the optimization start time is fixed.
        
        Returns::
        
            True if the optimization start time is fixed, False otherwise.
        """
        return not self.opt_interval_starttime_free()
            
    def opt_interval_finaltime_free(self):
        """ 
        Evaluate if the optimization final time is free.
        
        Returns::
        
            True if the optimization final time is free, False otherwise.
        """
        start_time, start_time_free, final_time, final_time_free = \
                                  self.jmimodel.opt_get_optimization_interval()
        return final_time_free==1
        
    def opt_interval_finaltime_fixed(self):
        """ 
        Evaluate if the optimization final time is fixed.
        
        Returns::
        
            True if the optimization final time is fixed, False otherwise.
        """
        return not self.opt_interval_finaltime_free()
        
    def opt_interval_get_start_time(self):
        """ 
        Get the start time of the optimization interval.
        
        Returns::
        
            The start time of the optimization interval.
        """
        start_time, start_time_free, final_time, final_time_free = \
                                  self.jmimodel.opt_get_optimization_interval()
        return start_time
        
    def opt_interval_get_final_time(self):
        """ 
        Get the final time of the optimization interval.
        
        Returns::
        
            The final time of the optimization interval.
        """
        start_time, start_time_free, final_time, final_time_free = \
                                  self.jmimodel.opt_get_optimization_interval()
        return final_time
        
    def eval_ode_f(self):
        """ 
        Evaluate an ODE.
        
        The ODE is of the form:
          dx = f(x, t, ...)
        
        The input variables to f are expected to be set BEFORE calling this 
        function. The calculated dx can be accessed in two ways:
         1. By accessing is through the member Model.dx; or
         2. By using return value of this function which is the same.
         
        Returns::
        
            Model.dx on success.
            
        Raises:: 
        
            JMIException evaluation failed.
        """
        self.jmimodel.ode_f()
        return self.real_dx
        
    def opt_eval_J(self):
        """ 
        Get the evaluted optimization cost function, J.
        
        All values (such as u, u_p, x_p etc.) are expected to be set before
        calling this function.
        
        Returns::
        
            The optimization cost function J.
        """
        return self.jmimodel.opt_J()
        
    def opt_eval_jac_J(self, independent_variables, mask=None):
        """ 
        Evaluate the jacobian of the cost function.
        
        Parameters::
        
            independent_variables -- 
                The variables witch the jacobian will be based on.
                
            mask -- 
                If only some independent variables should be 
                (re)evaluated.
                Default: None
                                 
        Please refer to the JMI documentation for more info.
        """
        assert self._n_z.value != 0
        if mask is None:
            mask = N.ones(self._n_z.value, dtype=int)
        
        n_cols, n_nz = self.jmimodel.opt_dJ_dim(JMI_DER_CPPAD,
                                                JMI_DER_DENSE_ROW_MAJOR,
                                                independent_variables, mask)
        jac = N.zeros(n_nz, dtype=c_jmi_real_t)
        
        self.jmimodel.opt_dJ(JMI_DER_CPPAD, JMI_DER_DENSE_ROW_MAJOR,
                             independent_variables, mask, jac)
        return jac.reshape( (1, len(jac)) )


class JMIModel(object):
    """
    A JMI Model loaded from a binary file.
    """
    
    def __init__(self, libname, path='.', is_jmu = True):
        """ 
        Create a pyjmi.jmi.JMUModel object from a binary file.
        """
        suffix = get_platform_suffix()
        if is_jmu:
            dllname = libname.split(os.sep)[-1]
            dllname = dllname[:-len(suffix)]
            self._dll = load_DLL(dllname, path)
            self._tempfname = libname
        else:
           # create temp dll
            fhandle,self._tempfname = tempfile.mkstemp(suffix=suffix, 
                dir=get_temp_location())
            shutil.copyfile(os.path.join(path,libname+suffix),self._tempfname)
            os.close(fhandle)
            fname = self._tempfname.split(os.sep)
            fname = fname[len(fname)-1]
            
            #load temp dll
            self._dll = load_DLL(fname, get_temp_location())

        # save dll file name so that it can be deleted when python
        # exits if not before
        _temp_dlls.append({'handle':self._dll._handle,'name':self._tempfname})
        
        self._jmi = ct.c_voidp()
        assert self._dll.jmi_new(byref(self._jmi)) == 0, \
               "jmi_new returned non-zero"
        assert self._jmi.value is not None, \
               "jmi struct not returned correctly"
               
        # set c-function type definitions used in JMIModel
        self._set_jmimodel_typedefs()
        
        # The actual array. These must must not be reset (only changed)
        # as they are pointing to a shared memory space used by
        # both the JMI DLL and us. Therefore Python properties are used
        # to ensure that they aren't reset, only modified.
        self._real_ci = self._dll.jmi_get_real_ci(self._jmi)
        self._real_cd = self._dll.jmi_get_real_cd(self._jmi)
        self._real_pi = self._dll.jmi_get_real_pi(self._jmi)
        self._real_pd = self._dll.jmi_get_real_pd(self._jmi)
        self._integer_cd = self._dll.jmi_get_integer_cd(self._jmi)
        self._integer_ci = self._dll.jmi_get_integer_ci(self._jmi)
        self._integer_pd = self._dll.jmi_get_integer_pd(self._jmi)
        self._integer_pi = self._dll.jmi_get_integer_pi(self._jmi)        
        self._boolean_cd = self._dll.jmi_get_boolean_cd(self._jmi)
        self._boolean_ci = self._dll.jmi_get_boolean_ci(self._jmi)
        self._boolean_pd = self._dll.jmi_get_boolean_pd(self._jmi)
        self._boolean_pi = self._dll.jmi_get_boolean_pi(self._jmi)        
        self._real_dx = self._dll.jmi_get_real_dx(self._jmi)
        self._real_x = self._dll.jmi_get_real_x(self._jmi)
        self._real_u = self._dll.jmi_get_real_u(self._jmi)
        self._real_w = self._dll.jmi_get_real_w(self._jmi)
        self._t = self._dll.jmi_get_t(self._jmi)
        self._real_d = self._dll.jmi_get_real_d(self._jmi);
        self._integer_d = self._dll.jmi_get_integer_d(self._jmi);
        self._integer_u = self._dll.jmi_get_integer_u(self._jmi);
        self._boolean_d = self._dll.jmi_get_boolean_d(self._jmi);
        self._boolean_u = self._dll.jmi_get_boolean_u(self._jmi);        
        self._sw = self._dll.jmi_get_sw(self._jmi)
        self._sw_init = self._dll.jmi_get_sw_init(self._jmi)
        self._z = self._dll.jmi_get_z(self._jmi)
        self._variable_scaling_factors = self._dll.jmi_get_variable_scaling_factors(self._jmi)
        
        #self.initAD()

      # Alternative constructor where a JMUModel is created from
      # a dll and an instantiated jmi_t struct
#     def __init__(self,dll,jmi):
#         self._dll = dll
#         self._jmi = jmi

#         # set c-function type definitions used in JMIModel
#         self._set_jmimodel_typedefs()
      
#         # The actual array. These must must not be reset (only changed)
#         # as they are pointing to a shared memory space used by
#         # both the JMI DLL and us. Therefore Python properties are used
#         # to ensure that they aren't reset, only modified.
#         self._real_ci = self._dll.jmi_get_real_ci(self._jmi)
#         self._real_cd = self._dll.jmi_get_real_cd(self._jmi)
#         self._real_pi = self._dll.jmi_get_real_pi(self._jmi)
#         self._real_pd = self._dll.jmi_get_real_pd(self._jmi)
#         self._integer_cd = self._dll.jmi_get_integer_cd(self._jmi)
#         self._integer_ci = self._dll.jmi_get_integer_ci(self._jmi)
#         self._integer_pd = self._dll.jmi_get_integer_pd(self._jmi)
#         self._integer_pi = self._dll.jmi_get_integer_pi(self._jmi)        
#         self._boolean_cd = self._dll.jmi_get_boolean_cd(self._jmi)
#         self._boolean_ci = self._dll.jmi_get_boolean_ci(self._jmi)
#         self._boolean_pd = self._dll.jmi_get_boolean_pd(self._jmi)
#         self._boolean_pi = self._dll.jmi_get_boolean_pi(self._jmi)        
#         self._real_dx = self._dll.jmi_get_real_dx(self._jmi)
#         self._real_x = self._dll.jmi_get_real_x(self._jmi)
#         self._real_u = self._dll.jmi_get_real_u(self._jmi)
#         self._real_w = self._dll.jmi_get_real_w(self._jmi)
#         self._t = self._dll.jmi_get_t(self._jmi)
#         self._real_d = self._dll.jmi_get_real_d(self._jmi);
#         self._integer_d = self._dll.jmi_get_integer_d(self._jmi);
#         self._integer_u = self._dll.jmi_get_integer_u(self._jmi);
#         self._boolean_d = self._dll.jmi_get_boolean_d(self._jmi);
#         self._boolean_u = self._dll.jmi_get_boolean_u(self._jmi);        
#         self._sw = self._dll.jmi_get_sw(self._jmi)
#         self._sw_init = self._dll.jmi_get_sw_init(self._jmi)
#         self._z = self._dll.jmi_get_z(self._jmi)
#         self._variable_scaling_factors = self._dll.jmi_get_variable_scaling_factors(self._jmi)

        
    def _set_jmimodel_typedefs(self):
        """ 
        Type c-functions from JMI used by JMIModel.
        """
        # Initialize the global variables used throughout the tests.
        n_real_ci = ct.c_int()
        n_real_cd = ct.c_int()
        n_real_pi = ct.c_int()
        n_real_pd = ct.c_int()
        n_integer_ci = ct.c_int()
        n_integer_cd = ct.c_int()
        n_integer_pi = ct.c_int()
        n_integer_pd = ct.c_int()
        n_boolean_ci = ct.c_int()
        n_boolean_cd = ct.c_int()
        n_boolean_pi = ct.c_int()
        n_boolean_pd = ct.c_int()
        n_real_dx = ct.c_int()
        n_real_x  = ct.c_int()
        n_real_u  = ct.c_int()
        n_real_w  = ct.c_int()
        n_tp = ct.c_int()
        n_real_d  = ct.c_int()
        n_integer_d  = ct.c_int()
        n_integer_u  = ct.c_int()
        n_boolean_d  = ct.c_int()
        n_boolean_u  = ct.c_int()
        n_outputs = ct.c_int()
        n_sw = ct.c_int()
        n_sw_init = ct.c_int()
        n_guards = ct.c_int()
        n_guards_init = ct.c_int()
        n_z  = ct.c_int()
        assert self._dll.jmi_get_sizes(self._jmi,
                                       byref(n_real_ci),
                                       byref(n_real_cd),
                                       byref(n_real_pi),
                                       byref(n_real_pd),
                                       byref(n_integer_ci),
                                       byref(n_integer_cd),
                                       byref(n_integer_pi),
                                       byref(n_integer_pd),
                                       byref(n_boolean_ci),
                                       byref(n_boolean_cd),
                                       byref(n_boolean_pi),
                                       byref(n_boolean_pd),
                                       byref(n_real_dx),
                                       byref(n_real_x),
                                       byref(n_real_u),
                                       byref(n_real_w),
                                       byref(n_tp),
                                       byref(n_real_d),
                                       byref(n_integer_d),
                                       byref(n_integer_u),
                                       byref(n_boolean_d),
                                       byref(n_boolean_u),
                                       byref(n_outputs),
                                       byref(n_sw),
                                       byref(n_sw_init),
                                       byref(n_guards),
                                       byref(n_guards_init),
                                       byref(n_z)) \
        is 0, \
               "getting sizes failed"
           
        # Setting return type to numpy.array for some functions
        int_res_funcs = [(self._dll.jmi_get_real_ci, n_real_ci.value),
                         (self._dll.jmi_get_real_cd, n_real_cd.value),
                         (self._dll.jmi_get_real_pi, n_real_pi.value),
                         (self._dll.jmi_get_real_pd, n_real_pd.value),
                         (self._dll.jmi_get_integer_ci, n_integer_ci.value),
                         (self._dll.jmi_get_integer_cd, n_integer_cd.value),
                         (self._dll.jmi_get_integer_pi, n_integer_pi.value),
                         (self._dll.jmi_get_integer_pd, n_integer_pd.value),
                         (self._dll.jmi_get_boolean_ci, n_boolean_ci.value),
                         (self._dll.jmi_get_boolean_cd, n_boolean_cd.value),
                         (self._dll.jmi_get_boolean_pi, n_boolean_pi.value),
                         (self._dll.jmi_get_boolean_pd, n_boolean_pd.value),
                         (self._dll.jmi_get_real_dx, n_real_dx.value),
                         (self._dll.jmi_get_real_x, n_real_x.value),
                         (self._dll.jmi_get_real_u, n_real_u.value),
                         (self._dll.jmi_get_real_w, n_real_w.value),
                         (self._dll.jmi_get_t, 1),
                         (self._dll.jmi_get_real_dx_p, n_real_dx.value),
                         (self._dll.jmi_get_real_x_p, n_real_x.value),
                         (self._dll.jmi_get_real_u_p, n_real_u.value),
                         (self._dll.jmi_get_real_w_p, n_real_w.value),
                         (self._dll.jmi_get_real_d, n_real_d.value),
                         (self._dll.jmi_get_integer_d, n_integer_d.value),
                         (self._dll.jmi_get_integer_u, n_integer_u.value),
                         (self._dll.jmi_get_boolean_d, n_boolean_d.value),
                         (self._dll.jmi_get_boolean_u, n_boolean_u.value),
                         (self._dll.jmi_get_sw, n_sw.value),
                         (self._dll.jmi_get_sw_init, n_sw_init.value),
                         (self._dll.jmi_get_variable_scaling_factors, n_z.value),
                         (self._dll.jmi_get_z, n_z.value)]

        for (func, length) in int_res_funcs:
            _returns_ndarray(func, c_jmi_real_t, length, order='C')
            
        #===============================================   
        # The return types for these functions are set in jmi.py's
        # function load_DLL(...)
#        ci     = self._dll.jmi_get_ci(self._jmi);
#        cd     = self._dll.jmi_get_cd(self._jmi);
#        pi     = self._dll.jmi_get_pi(self._jmi);
#        pd     = self._dll.jmi_get_pd(self._jmi);
#        dx     = self._dll.jmi_get_dx(self._jmi);
#        x      = self._dll.jmi_get_x(self._jmi);
#        u      = self._dll.jmi_get_u(self._jmi);
#        w      = self._dll.jmi_get_w(self._jmi);
#        t      = self._dll.jmi_get_t(self._jmi);
#        sw     = self._dll.jmi_get_sw(self._jmi);
#        sw_init     = self._dll.jmi_get_sw_init(self._jmi);
#        z      = self._dll.jmi_get_z(self._jmi)        
        #===============================================
        
        # Setting parameter types
        # creation, initialization and destruction
        self._dll.jmi_ad_init.argtypes = [ct.c_void_p]
        self._dll.jmi_delete.argtypes = [ct.c_void_p]
    
        # setters and getters
        self._dll.jmi_get_sizes.argtypes = [ct.c_void_p,
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),                                            
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int)]   
        self._dll.jmi_get_offsets.argtypes = [ct.c_void_p,
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int),
                                              ct.POINTER(ct.c_int)]
        self._dll.jmi_get_n_tp.argtypes = [ct.c_void_p,
                                           ct.POINTER(ct.c_int)]    
        self._dll.jmi_set_tp.argtypes = [ct.c_void_p,
                                         Nct.ndpointer(dtype=c_jmi_real_t,
                                                       ndim=1,
                                                       shape=n_tp.value,
                                                       flags='C')]
        self._dll.jmi_get_tp.argtypes = [ct.c_void_p,
                                         Nct.ndpointer(dtype=c_jmi_real_t,
                                                       ndim=1,
                                                       shape=n_tp.value,
                                                       flags='C')]
        self._dll.jmi_get_z.argtypes    = [ct.c_void_p]
        self._dll.jmi_get_real_ci.argtypes   = [ct.c_void_p]
        self._dll.jmi_get_real_cd.argtypes   = [ct.c_void_p]
        self._dll.jmi_get_real_pi.argtypes   = [ct.c_void_p]
        self._dll.jmi_get_real_pd.argtypes   = [ct.c_void_p]
        self._dll.jmi_get_integer_ci.argtypes   = [ct.c_void_p]
        self._dll.jmi_get_integer_cd.argtypes   = [ct.c_void_p]
        self._dll.jmi_get_integer_pi.argtypes   = [ct.c_void_p]
        self._dll.jmi_get_integer_pd.argtypes   = [ct.c_void_p]
        self._dll.jmi_get_boolean_ci.argtypes   = [ct.c_void_p]
        self._dll.jmi_get_boolean_cd.argtypes   = [ct.c_void_p]
        self._dll.jmi_get_boolean_pi.argtypes   = [ct.c_void_p]
        self._dll.jmi_get_boolean_pd.argtypes   = [ct.c_void_p]
        self._dll.jmi_get_real_dx.argtypes   = [ct.c_void_p]
        self._dll.jmi_get_real_x.argtypes    = [ct.c_void_p]
        self._dll.jmi_get_real_u.argtypes    = [ct.c_void_p]
        self._dll.jmi_get_real_w.argtypes    = [ct.c_void_p]
        self._dll.jmi_get_t.argtypes    = [ct.c_void_p]
        self._dll.jmi_get_real_dx_p.argtypes = [ct.c_void_p, ct.c_int]
        self._dll.jmi_get_real_x_p.argtypes  = [ct.c_void_p, ct.c_int]
        self._dll.jmi_get_real_u_p.argtypes  = [ct.c_void_p, ct.c_int]
        self._dll.jmi_get_real_w_p.argtypes  = [ct.c_void_p, ct.c_int]

        self._dll.jmi_get_real_d.argtypes   = [ct.c_void_p]
        self._dll.jmi_get_integer_d.argtypes   = [ct.c_void_p]
        self._dll.jmi_get_integer_u.argtypes   = [ct.c_void_p]
        self._dll.jmi_get_boolean_d.argtypes   = [ct.c_void_p]
        self._dll.jmi_get_boolean_u.argtypes   = [ct.c_void_p]
        self._dll.jmi_get_output_vrefs.argtypes   = [ct.c_void_p,
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                       ndim=1,
                                                       shape=n_outputs.value,
                                                       flags='C')]  
                
        self._dll.jmi_get_sw.argtypes  = [ct.c_void_p]
        self._dll.jmi_get_sw_init.argtypes  = [ct.c_void_p]

        self._dll.jmi_get_variable_scaling_factors.argtypes  = [ct.c_void_p]

        self._dll.jmi_get_scaling_method.argtypes  = [ct.c_void_p]

        # ODE interface
        self._dll.jmi_ode_f.argtypes  = [ct.c_void_p]
        self._dll.jmi_ode_df.argtypes = [ct.c_void_p,
                                         ct.c_int,
                                         ct.c_int,
                                         ct.c_int,
                                         Nct.ndpointer(dtype=ct.c_int,
                                                       ndim=1,
                                                       shape=n_z.value,
                                                       flags='C'),
                                         Nct.ndpointer(dtype=c_jmi_real_t,
                                                       ndim=1,
                                                       flags='C')]    
        self._dll.jmi_ode_df_n_nz.argtypes = [ct.c_void_p,
                                              ct.c_int,
                                              ct.POINTER(ct.c_int)]
        self._dll.jmi_ode_df_nz_indices.argtypes = [ct.c_void_p,
                                                    ct.c_int,
                                                    ct.c_int,
                                                    Nct.ndpointer(dtype=ct.c_int,
                                                                  ndim=1,
                                                                  shape=n_z.value,
                                                                  flags='C'),
                                                    Nct.ndpointer(dtype=ct.c_int,
                                                                  ndim=1,
                                                                  flags='C'),
                                                    Nct.ndpointer(dtype=ct.c_int,
                                                                  ndim=1,
                                                                  flags='C')]
        self._dll.jmi_ode_df_dim.argtypes = [ct.c_void_p,
                                             ct.c_int,
                                             ct.c_int,
                                             ct.c_int,
                                             Nct.ndpointer(dtype=ct.c_int,
                                                           ndim=1,
                                                           shape=n_z.value,
                                                           flags='C'),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int)]    

        self._dll.jmi_ode_derivatives.argtypes = [ct.c_void_p]
        self._dll.jmi_ode_derivatives_dir_der.argtypes = [ct.c_void_p,
                                                  Nct.ndpointer(dtype=c_jmi_real_t,
                                                           ndim=1,
                                                           flags='C')]
        self._dll.jmi_ode_outputs.argtypes = [ct.c_void_p]
        self._dll.jmi_ode_initialize.argtypes = [ct.c_void_p]
        self._dll.jmi_ode_guards.argtypes = [ct.c_void_p]
        self._dll.jmi_ode_guards_init.argtypes = [ct.c_void_p]
        self._dll.jmi_ode_next_time_event.argtypes = [ct.c_void_p,ct.POINTER(c_jmi_real_t)]
    
        # DAE interface
        self._dll.jmi_dae_get_sizes.argtypes = [ct.c_void_p,
                                                ct.POINTER(ct.c_int),
                                                ct.POINTER(ct.c_int)]
        n_eq_F = ct.c_int()
        n_eq_R = ct.c_int()
        assert self._dll.jmi_dae_get_sizes(self._jmi,
                                     byref(n_eq_F),byref(n_eq_R)) \
               is 0, \
               "getting DAE sizes failed"        
         
        self._dll.jmi_dae_F.argtypes = [ct.c_void_p,
                                        Nct.ndpointer(dtype=c_jmi_real_t,
                                                      ndim=1,
                                                      shape=n_eq_F.value,
                                                      flags='C')]
        self._dll.jmi_dae_dF.argtypes = [ct.c_void_p,
                                         ct.c_int,
                                         ct.c_int,
                                         ct.c_int,
                                         Nct.ndpointer(dtype=ct.c_int,
                                                        ndim=1,
                                                        shape=n_z.value,
                                                        flags='C'),
                                         Nct.ndpointer(dtype=c_jmi_real_t,
                                                       ndim=1,
                                                       flags='C')] 
        self._dll.jmi_dae_dF_n_nz.argtypes = [ct.c_void_p,
                                              ct.c_int,
                                              ct.POINTER(ct.c_int)]    
        self._dll.jmi_dae_dF_nz_indices.argtypes = [ct.c_void_p,
                                                    ct.c_int,
                                                    ct.c_int,
                                                    Nct.ndpointer(dtype=ct.c_int,
                                                                  ndim=1,
                                                                  shape=n_z.value,
                                                                  flags='C'),
                                                    Nct.ndpointer(dtype=ct.c_int,
                                                                  ndim=1,
                                                                  flags='C'),
                                                    Nct.ndpointer(dtype=ct.c_int,
                                                                  ndim=1,
                                                                  flags='C')]                    
        self._dll.jmi_dae_dF_dim.argtypes = [ct.c_void_p, 
                                             ct.c_int, 
                                             ct.c_int,
                                             ct.c_int,
                                             Nct.ndpointer(dtype=ct.c_int,
                                                           ndim=1,
                                                           shape=n_z.value,
                                                           flags='C'),
                                            ct.POINTER(ct.c_int),
                                            ct.POINTER(ct.c_int)]   
        self._dll.jmi_dae_directional_dF.argtypes = [ct.c_void_p,
        											ct.c_int,
                                         Nct.ndpointer(dtype=c_jmi_real_t,
                                                       ndim=1,
                                                       flags='C'),
                                         Nct.ndpointer(dtype=c_jmi_real_t,
                                                       ndim=1,
                                                       flags='C'),
                                         Nct.ndpointer(dtype=c_jmi_real_t,
                                                       ndim=1,
                                                       flags='C')]
        self._dll.jmi_dae_derivative_checker.argtypes = [ct.c_void_p,
                                                         ct.c_int,
                                                         ct.c_int,
                                                         ct.c_int,
                                                         Nct.ndpointer(dtype=ct.c_int,
                                                                  ndim=1,
                                                                  shape=n_z.value,
                                                                  flags='C')]
        self._dll.jmi_dae_R.argtypes = [ct.c_void_p,
                                        Nct.ndpointer(dtype=c_jmi_real_t,
                                                      ndim=1,
                                                      shape=n_eq_R.value,
                                                      flags='C')]        
        # DAE initialization interface
        self._dll.jmi_init_get_sizes.argtypes = [ct.c_void_p,
                                                 ct.POINTER(ct.c_int),
                                                 ct.POINTER(ct.c_int),
                                                 ct.POINTER(ct.c_int),
                                                 ct.POINTER(ct.c_int)]
        n_eq_F0 = ct.c_int()
        n_eq_F1 = ct.c_int()
        n_eq_Fp = ct.c_int()
        n_eq_R0 = ct.c_int()
        assert self._dll.jmi_init_get_sizes(self._jmi, byref(n_eq_F0), byref(n_eq_F1),
                                            byref(n_eq_Fp), byref(n_eq_R0)) \
                                            is 0, \
                                            "getting DAE init sizes failed"         
                                                
        self._dll.jmi_init_F0.argtypes = [ct.c_void_p,
                                          Nct.ndpointer(dtype=c_jmi_real_t,
                                                        ndim=1,
                                                        shape=n_eq_F0.value,
                                                        flags='C')]
        self._dll.jmi_init_dF0.argtypes = [ct.c_void_p,
                                           ct.c_int,
                                           ct.c_int,
                                           ct.c_int,
                                           Nct.ndpointer(dtype=ct.c_int,
                                                         ndim=1,
                                                         shape=n_z.value,
                                                         flags='C'),
                                           Nct.ndpointer(dtype=c_jmi_real_t,
                                                         ndim=1,
                                                         flags='C')]
        self._dll.jmi_init_dF0_n_nz.argtypes = [ct.c_void_p,
                                                ct.c_int,
                                                ct.POINTER(ct.c_int)]
        self._dll.jmi_init_dF0_nz_indices.argtypes = [ct.c_void_p,
                                                      ct.c_int,
                                                      ct.c_int,
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                                    ndim=1,
                                                                    shape=n_z.value,
                                                                    flags='C'),
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                                    ndim=1,
                                                                    flags='C'),
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                                    ndim=1,
                                                                    flags='C')]
        self._dll.jmi_init_dF0_dim.argtypes = [ct.c_void_p,
                                               ct.c_int,
                                               ct.c_int,
                                               ct.c_int,
                                               Nct.ndpointer(dtype=ct.c_int,
                                                             ndim=1,
                                                             shape=n_z.value,
                                                             flags='C'),
                                               ct.POINTER(ct.c_int),
                                               ct.POINTER(ct.c_int)]
        self._dll.jmi_init_F1.argtypes = [ct.c_void_p,
                                          Nct.ndpointer(dtype=c_jmi_real_t,
                                                        ndim=1,
                                                        shape=n_eq_F1.value,
                                                        flags='C')]
        self._dll.jmi_init_dF1.argtypes = [ct.c_void_p,
                                           ct.c_int,
                                           ct.c_int,
                                           ct.c_int,
                                           Nct.ndpointer(dtype=ct.c_int,
                                                         ndim=1,
                                                         shape=n_z.value,
                                                         flags='C'),
                                           Nct.ndpointer(dtype=c_jmi_real_t,
                                                         ndim=1,
                                                         flags='C')]
        self._dll.jmi_init_dF1_n_nz.argtypes = [ct.c_void_p,
                                                ct.c_int,
                                                ct.POINTER(ct.c_int)]
        self._dll.jmi_init_dF1_nz_indices.argtypes = [ct.c_void_p,
                                                      ct.c_int,
                                                      ct.c_int,
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                                    ndim=1,
                                                                    shape=n_z.value,
                                                                    flags='C'),
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                                    ndim=1,
                                                                    flags='C'),
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                                    ndim=1,
                                                                    flags='C')]
        self._dll.jmi_init_dF1_dim.argtypes = [ct.c_void_p,
                                               ct.c_int,
                                               ct.c_int,
                                               ct.c_int,
                                               Nct.ndpointer(dtype=ct.c_int,
                                                             ndim=1,
                                                             shape=n_z.value,
                                                             flags='C'),
                                               ct.POINTER(ct.c_int),
                                               ct.POINTER(ct.c_int)]
        self._dll.jmi_init_Fp.argtypes = [ct.c_void_p,
                                          Nct.ndpointer(dtype=c_jmi_real_t,
                                                        ndim=1,
                                                        shape=n_eq_Fp.value,
                                                        flags='C')]
        self._dll.jmi_init_dFp.argtypes = [ct.c_void_p,
                                           ct.c_int,
                                           ct.c_int,
                                           ct.c_int,
                                           Nct.ndpointer(dtype=ct.c_int,
                                                         ndim=1,
                                                         shape=n_z.value,
                                                         flags='C'),
                                           Nct.ndpointer(dtype=c_jmi_real_t,
                                                         ndim=1,
                                                         flags='C')]
        self._dll.jmi_init_dFp_n_nz.argtypes = [ct.c_void_p,
                                                ct.c_int,
                                                ct.POINTER(ct.c_int)]
        self._dll.jmi_init_dFp_nz_indices.argtypes = [ct.c_void_p,
                                                      ct.c_int,
                                                      ct.c_int,
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                                    ndim=1,
                                                                    shape=n_z.value,
                                                                    flags='C'),
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                                    ndim=1,
                                                                    flags='C'),
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                                    ndim=1,
                                                                    flags='C')]
        self._dll.jmi_init_dFp_dim.argtypes = [ct.c_void_p, 
                                               ct.c_int, 
                                               ct.c_int,
                                               ct.c_int,
                                               Nct.ndpointer(dtype=ct.c_int,
                                                             ndim=1,
                                                             shape=n_z.value,
                                                             flags='C'),
                                               ct.POINTER(ct.c_int),
                                               ct.POINTER(ct.c_int)]

        self._dll.jmi_init_eval_parameters.argtypes = [ct.c_void_p]

        self._dll.jmi_set_start_values.argtypes = [ct.c_void_p]

        self._dll.jmi_init_R0.argtypes = [ct.c_void_p,
                                          Nct.ndpointer(dtype=c_jmi_real_t,
                                                        ndim=1,
                                                        shape=n_eq_R0.value,
                                                        flags='C')]    
        # Optimization interface
        self._dll.jmi_opt_set_optimization_interval.argtypes = [ct.c_void_p,
                                                                c_jmi_real_t,
                                                                ct.c_int,
                                                                c_jmi_real_t,
                                                                ct.c_int]    
        self._dll.jmi_opt_get_optimization_interval.argtypes = [ct.c_void_p,
                                                                ct.POINTER(c_jmi_real_t),
                                                                ct.POINTER(ct.c_int),
                                                                ct.POINTER(c_jmi_real_t),
                                                                ct.POINTER(ct.c_int)]
        self._dll.jmi_opt_set_p_opt_indices.argtypes = [ct.c_void_p,
                                                        ct.c_int,
                                                        Nct.ndpointer(dtype=ct.c_int,
                                                                      ndim=1,
                                                                      flags='C')]    
        self._dll.jmi_opt_get_n_p_opt.argtypes = [ct.c_void_p,
                                                  ct.POINTER(ct.c_int)]    
        self._dll.jmi_opt_get_p_opt_indices.argtypes = [ct.c_void_p,
                                                        Nct.ndpointer(dtype=ct.c_int,
                                                                      ndim=1,
                                                                      flags='C')]                                                 
        self._dll.jmi_opt_get_sizes.argtypes = [ct.c_void_p,
                                                ct.POINTER(ct.c_int),
                                                ct.POINTER(ct.c_int),
                                                ct.POINTER(ct.c_int),
                                                ct.POINTER(ct.c_int),
                                                ct.POINTER(ct.c_int),
                                                ct.POINTER(ct.c_int),
                                                ct.POINTER(ct.c_int)]    
        self._dll.jmi_opt_J.argtypes = [ct.c_void_p,
                                        Nct.ndpointer(dtype=c_jmi_real_t,
                                                      ndim=1,
                                                      shape=1,
                                                      flags='C')]   
        self._dll.jmi_opt_dJ.argtypes = [ct.c_void_p,
                                         ct.c_int,
                                         ct.c_int,
                                         ct.c_int,
                                         Nct.ndpointer(dtype=ct.c_int,
                                                       ndim=1,
                                                       shape=n_z.value,
                                                       flags='C'),
                                         Nct.ndpointer(dtype=c_jmi_real_t,
                                                       ndim=1,
                                                       flags='C')]   
        self._dll.jmi_opt_dJ_n_nz.argtypes = [ct.c_void_p,
                                              ct.c_int,
                                              ct.POINTER(ct.c_int)]    
        self._dll.jmi_opt_dJ_nz_indices.argtypes = [ct.c_void_p,
                                                    ct.c_int,
                                                    ct.c_int,
                                                    Nct.ndpointer(dtype=ct.c_int,
                                                                  ndim=1,
                                                                  shape=n_z.value,
                                                                  flags='C'),
                                                    Nct.ndpointer(dtype=ct.c_int,
                                                                  ndim=1,
                                                                  flags='C'),
                                                    Nct.ndpointer(dtype=ct.c_int,
                                                                  ndim=1,
                                                                  flags='C')]    
        self._dll.jmi_opt_dJ_dim.argtypes = [ct.c_void_p,
                                             ct.c_int,
                                             ct.c_int,
                                             ct.c_int,
                                             Nct.ndpointer(dtype=ct.c_int,
                                                           ndim=1,
                                                           shape=n_z.value,
                                                           flags='C'),
                                             ct.POINTER(ct.c_int),
                                             ct.POINTER(ct.c_int)]

        n_eq_J = ct.c_int()
        n_eq_L = ct.c_int()
        n_eq_Ffdp = ct.c_int()
        n_eq_Ceq = ct.c_int()
        n_eq_Cineq = ct.c_int()
        n_eq_Heq = ct.c_int()
        n_eq_Hineq = ct.c_int()
        assert self._dll.jmi_opt_get_sizes(self._jmi, byref(n_eq_J), byref(n_eq_L), byref(n_eq_Ffdp), byref(n_eq_Ceq),
                                           byref(n_eq_Cineq),
                                           byref(n_eq_Heq), byref(n_eq_Hineq)) \
               is 0, \
               "getting optimization function sizes failed"

        self._dll.jmi_opt_Ffdp.argtypes = [ct.c_void_p,
                                          Nct.ndpointer(dtype=c_jmi_real_t,
                                                        ndim=1,
                                                        shape=n_eq_Ffdp.value,
                                                        flags='C')]    
        self._dll.jmi_opt_dFfdp.argtypes = [ct.c_void_p,
                                           ct.c_int,
                                           ct.c_int,
                                           ct.c_int,
                                           Nct.ndpointer(dtype=ct.c_int,
                                                         ndim=1,
                                                         shape=n_z.value,
                                                         flags='C'),
                                           Nct.ndpointer(dtype=c_jmi_real_t,
                                                         ndim=1,
                                                         flags='C')]  
        self._dll.jmi_opt_dFfdp_n_nz.argtypes = [ct.c_void_p,
                                                ct.c_int,
                                                ct.POINTER(ct.c_int)]   
        self._dll.jmi_opt_dFfdp_nz_indices.argtypes = [ct.c_void_p,
                                                      ct.c_int,
                                                      ct.c_int,
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                                    ndim=1,
                                                                    shape=n_z.value,
                                                                    flags='C'),
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                                    ndim=1,
                                                                    flags='C'),
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                                    ndim=1,
                                                                    flags='C')]
        self._dll.jmi_opt_dFfdp_dim.argtypes = [ct.c_void_p,
                                               ct.c_int,
                                               ct.c_int,
                                               ct.c_int,
                                               Nct.ndpointer(dtype=ct.c_int,
                                                             ndim=1,
                                                             shape=n_z.value,
                                                             flags='C'),
                                               ct.POINTER(ct.c_int),
                                               ct.POINTER(ct.c_int)]    
         
        self._dll.jmi_opt_Ceq.argtypes = [ct.c_void_p,
                                          Nct.ndpointer(dtype=c_jmi_real_t,
                                                        ndim=1,
                                                        shape=n_eq_Ceq.value,
                                                        flags='C')]    
        self._dll.jmi_opt_dCeq.argtypes = [ct.c_void_p,
                                           ct.c_int,
                                           ct.c_int,
                                           ct.c_int,
                                           Nct.ndpointer(dtype=ct.c_int,
                                                         ndim=1,
                                                         shape=n_z.value,
                                                         flags='C'),
                                           Nct.ndpointer(dtype=c_jmi_real_t,
                                                         ndim=1,
                                                         flags='C')]  
        self._dll.jmi_opt_dCeq_n_nz.argtypes = [ct.c_void_p,
                                                ct.c_int,
                                                ct.POINTER(ct.c_int)]   
        self._dll.jmi_opt_dCeq_nz_indices.argtypes = [ct.c_void_p,
                                                      ct.c_int,
                                                      ct.c_int,
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                                    ndim=1,
                                                                    shape=n_z.value,
                                                                    flags='C'),
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                                    ndim=1,
                                                                    flags='C'),
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                                    ndim=1,
                                                                    flags='C')]
        self._dll.jmi_opt_dCeq_dim.argtypes = [ct.c_void_p,
                                               ct.c_int,
                                               ct.c_int,
                                               ct.c_int,
                                               Nct.ndpointer(dtype=ct.c_int,
                                                             ndim=1,
                                                             shape=n_z.value,
                                                             flags='C'),
                                               ct.POINTER(ct.c_int),
                                               ct.POINTER(ct.c_int)]    
        self._dll.jmi_opt_Cineq.argtypes = [ct.c_void_p,
                                            Nct.ndpointer(dtype=c_jmi_real_t,
                                                          ndim=1,
                                                          shape=n_eq_Cineq.value,
                                                          flags='C')]    
        self._dll.jmi_opt_dCineq.argtypes = [ct.c_void_p,
                                             ct.c_int,
                                             ct.c_int,
                                             ct.c_int,
                                             Nct.ndpointer(dtype=ct.c_int,
                                                           ndim=1,
                                                           shape=n_z.value,
                                                           flags='C'),
                                             Nct.ndpointer(dtype=c_jmi_real_t,
                                                           ndim=1,
                                                           flags='C')]   
        self._dll.jmi_opt_dCineq_n_nz.argtypes = [ct.c_void_p,
                                                  ct.c_int,
                                                  ct.POINTER(ct.c_int)]    
        self._dll.jmi_opt_dCineq_nz_indices.argtypes = [ct.c_void_p,
                                                        ct.c_int,
                                                        ct.c_int,
                                                        Nct.ndpointer(dtype=ct.c_int,
                                                                      ndim=1,
                                                                      shape=n_z.value,
                                                                      flags='C'),
                                                        Nct.ndpointer(dtype=ct.c_int,
                                                                      ndim=1,
                                                                      flags='C'),
                                                        Nct.ndpointer(dtype=ct.c_int,
                                                                      ndim=1,
                                                                      flags='C')]    
        self._dll.jmi_opt_dCineq_dim.argtypes = [ct.c_void_p,
                                                 ct.c_int,
                                                 ct.c_int,
                                                 ct.c_int,
                                                 Nct.ndpointer(dtype=ct.c_int,
                                                               ndim=1,
                                                               shape=n_z.value,
                                                               flags='C'),
                                                 ct.POINTER(ct.c_int),
                                                 ct.POINTER(ct.c_int)]    
        self._dll.jmi_opt_Heq.argtypes = [ct.c_void_p,
                                          Nct.ndpointer(dtype=c_jmi_real_t,
                                                        ndim=1,
                                                        shape=n_eq_Heq.value,
                                                        flags='C')]    
        self._dll.jmi_opt_dHeq.argtypes = [ct.c_void_p,
                                           ct.c_int,
                                           ct.c_int,
                                           ct.c_int,
                                           Nct.ndpointer(dtype=ct.c_int,
                                                         ndim=1,
                                                         shape=n_z.value,
                                                         flags='C'),
                                           Nct.ndpointer(dtype=c_jmi_real_t,
                                                         ndim=1,
                                                         flags='C')]    
        self._dll.jmi_opt_dHeq_n_nz.argtypes = [ct.c_void_p,
                                                ct.c_int,
                                                ct.POINTER(ct.c_int)]    
        self._dll.jmi_opt_dHeq_nz_indices.argtypes = [ct.c_void_p,
                                                      ct.c_int,
                                                      ct.c_int,
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                                    ndim=1,
                                                                    shape=n_z.value,
                                                                    flags='C'),
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                                    ndim=1,
                                                                    flags='C'),
                                                      Nct.ndpointer(dtype=ct.c_int,
                                                                    ndim=1,
                                                                    flags='C')]    
        self._dll.jmi_opt_dHeq_dim.argtypes = [ct.c_void_p,
                                               ct.c_int,
                                               ct.c_int,
                                               ct.c_int,
                                               Nct.ndpointer(dtype=ct.c_int,
                                                             ndim=1,
                                                             shape=n_z.value,
                                                             flags='C'),
                                               ct.POINTER(ct.c_int),
                                               ct.POINTER(ct.c_int)]    
        self._dll.jmi_opt_Hineq.argtypes = [ct.c_void_p,
                                            Nct.ndpointer(dtype=c_jmi_real_t,
                                                          ndim=1,
                                                          shape=n_eq_Hineq.value,
                                                          flags='C')]    
        self._dll.jmi_opt_dHineq.argtypes = [ct.c_void_p,
                                             ct.c_int,
                                             ct.c_int,
                                             ct.c_int,
                                             Nct.ndpointer(dtype=ct.c_int,
                                                           ndim=1,
                                                           shape=n_z.value,
                                                           flags='C'),
                                             Nct.ndpointer(dtype=c_jmi_real_t,
                                                           ndim=1,
                                                           flags='C')]   
        self._dll.jmi_opt_dHineq_n_nz.argtypes = [ct.c_void_p,
                                                  ct.c_int,
                                                  ct.POINTER(ct.c_int)]   
        self._dll.jmi_opt_dHineq_nz_indices.argtypes = [ct.c_void_p,
                                                        ct.c_int,
                                                        ct.c_int,
                                                        Nct.ndpointer(dtype=ct.c_int,
                                                                      ndim=1,
                                                                      shape=n_z.value,
                                                                      flags='C'),
                                                        Nct.ndpointer(dtype=ct.c_int,
                                                                      ndim=1,
                                                                      flags='C'),
                                                        Nct.ndpointer(dtype=ct.c_int,
                                                                      ndim=1,
                                                                      flags='C')]    
        self._dll.jmi_opt_dHineq_dim.argtypes = [ct.c_void_p,
                                                 ct.c_int,
                                                 ct.c_int,
                                                 ct.c_int,
                                                 Nct.ndpointer(dtype=ct.c_int,
                                                               ndim=1,
                                                               shape=n_z.value,
                                                               flags='C'),
                                                 ct.POINTER(ct.c_int),
                                                 ct.POINTER(ct.c_int)]   

        self._dll.jmi_with_cad_derivatives.argtypes = [ct.c_void_p]   

                 
    def initAD(self):
        """ 
        Initialize the Algorithmic Differential package.
        
        Raises:: 
        
            JMIException on failure.
        """
        if self._dll.jmi_ad_init(self._jmi) is not 0:
            raise JMIException("Could not initialize AD.")
            
    def with_cppad_derivatives(self):
        """ 
        Check if there is support for CppAD derivatives or not.
        
        Returns::
        
            1 if there is CppAD support, 0 otherwise.
        """
        return self._dll.jmi_with_cppad_derivatives()

    def with_cad_derivatives(self):
        """ 
        Check if there is support for CAD derivatives or not.
        
        Returns::
        
            1 if there is CAD support, 0 otherwise.
        """
        return self._dll.jmi_with_cad_derivatives(self._jmi)
               
    def __del__(self):
        """ 
        DLL load cleanup function.
        
        Freeing jmi data structure. Removing handle and deleting temporary DLL 
        file if possible.
        """
        import sys
        
        if sys.platform == 'win32':
            pass
        else:
            try:
                assert self._dll.jmi_delete(self._jmi) == 0, \
                       "jmi_delete failed"
                if os.path.exists(self._tempfname) and os.path.isfile(self._tempfname):
                    if sys.platform == 'win32':
                        _ctypes.FreeLibrary(self._dll._handle)
                    os.remove(self._tempfname)
            except AttributeError:
                # Error caused if constructor crashes
                pass
               
    def get_sizes(self, n_real_ci, n_real_cd, n_real_pi, n_real_pd, 
        n_integer_ci, n_integer_cd, n_integer_pi, n_integer_pd, n_boolean_ci, 
        n_boolean_cd, n_boolean_pi, n_boolean_pd, n_real_dx, n_real_x, n_real_u, 
        n_real_w, n_tp, n_real_d, n_integer_d, n_integer_u, n_boolean_d, 
        n_boolean_u,n_outputs,n_sw, n_sw_init, n_guards, n_guards_init, n_z):
        """ 
        Get the sizes of the variable vectors.
        
        Parameters::
        
            The sizes of the variable vectors (return variables).
        """
        
        retval = self._dll.jmi_get_sizes(self._jmi,
                                         byref(n_real_ci),
                                         byref(n_real_cd),
                                         byref(n_real_pi),
                                         byref(n_real_pd),
                                         byref(n_integer_ci),
                                         byref(n_integer_cd),
                                         byref(n_integer_pi),
                                         byref(n_integer_pd),
                                         byref(n_boolean_ci),
                                         byref(n_boolean_cd),
                                         byref(n_boolean_pi),
                                         byref(n_boolean_pd),
                                         byref(n_real_dx),
                                         byref(n_real_x),
                                         byref(n_real_u),
                                         byref(n_real_w),
                                         byref(n_tp),
                                         byref(n_real_d),
                                         byref(n_integer_d),
                                         byref(n_integer_u),
                                         byref(n_boolean_d),
                                         byref(n_boolean_u),
                                         byref(n_outputs),
                                         byref(n_sw),
                                         byref(n_sw_init),
                                         byref(n_guards),
                                         byref(n_guards_init),
                                         byref(n_z))
        if retval is not 0:
            raise JMIException("Getting sizes failed.")
            
    def get_offsets(self, offs_real_ci, offs_real_cd, offs_real_pi, 
        offs_real_pd, offs_integer_ci, offs_integer_cd, offs_integer_pi, 
        offs_integer_pd, offs_boolean_ci, offs_boolean_cd, offs_boolean_pi, 
        offs_boolean_pd, offs_real_dx, offs_real_x, offs_real_u, offs_real_w, 
        offs_t, offs_real_dx_p, offs_real_x_p, offs_real_u_p, offs_real_w_p, 
        offs_real_d,offs_integer_d,offs_integer_u, offs_boolean_d, 
        offs_boolean_u, offs_sw, offs_sw_init, offs_guards, offs_guards_init,
        offs_pre_real_dx, offs_pre_real_x, offs_pre_real_u, offs_pre_real_w, 
        offs_pre_real_d,offs_pre_integer_d,offs_pre_integer_u, offs_pre_boolean_d, 
        offs_pre_boolean_u, offs_pre_sw, offs_pre_sw_init, offs_pre_guards, offs_pre_guards_init):
        """ 
        Get the offsets for the variable types in the z vector.
        
        Parameters::
        
            The offsets for all varibles in the z vector (return variables).
        """
        retval = self._dll.jmi_get_offsets(self._jmi,
                                           byref(offs_real_ci),
                                           byref(offs_real_cd),
                                           byref(offs_real_pi),
                                           byref(offs_real_pd),
                                           byref(offs_integer_ci),
                                           byref(offs_integer_cd),
                                           byref(offs_integer_pi),
                                           byref(offs_integer_pd),
                                           byref(offs_boolean_ci),
                                           byref(offs_boolean_cd),
                                           byref(offs_boolean_pi),
                                           byref(offs_boolean_pd),
                                           byref(offs_real_dx),
                                           byref(offs_real_x),
                                           byref(offs_real_u),
                                           byref(offs_real_w),
                                           byref(offs_t),
                                           byref(offs_real_dx_p),
                                           byref(offs_real_x_p),
                                           byref(offs_real_u_p),
                                           byref(offs_real_w_p),
                                           byref(offs_real_d),
                                           byref(offs_integer_d),
                                           byref(offs_integer_u),
                                           byref(offs_boolean_d),
                                           byref(offs_boolean_u),
                                           byref(offs_sw),
                                           byref(offs_sw_init),
                                           byref(offs_guards),
                                           byref(offs_guards_init),
                                           byref(offs_pre_real_dx),
                                           byref(offs_pre_real_x),
                                           byref(offs_pre_real_u),
                                           byref(offs_pre_real_w),
                                           byref(offs_pre_real_d),
                                           byref(offs_pre_integer_d),
                                           byref(offs_pre_integer_u),
                                           byref(offs_pre_boolean_d),
                                           byref(offs_pre_boolean_u),
                                           byref(offs_pre_sw),
                                           byref(offs_pre_sw_init),
                                           byref(offs_pre_guards),
                                           byref(offs_pre_guards_init))


                                           
        if retval is not 0:
            raise JMIException("Getting offsets failed.")
            
    def get_n_tp(self,n_tp):
        """ 
        Get the number of time points in the model.
        
        Parameters::
        
            n_tp --
                The number of time points (return variable).
        """
        
        retval = self._dll.jmi_get_n_tp(self._jmi, byref(n_tp))
        if retval is not 0:
            raise JMIException("Getting number of time points in the model \
                failed.")

    def set_tp(self, tp):
        """ 
        Set the vector of time points.
        
        Parameters::
        
            The new vector of time points.

        """
        if self._dll.jmi_set_tp(self._jmi, tp) is not 0:
            raise JMIException("Setting vector of time points failed.")
        
    def get_tp(self, tp):
        """ 
        Get the vector of time points.
        
        Parameters::
        
            The vector of time points (return variable).
        """
        if self._dll.jmi_get_tp(self._jmi, tp) is not 0:
            raise JMIException("Getting vector of time points failed.")
    
    def get_z(self):
        """ 
        Get the vector containing all parameters, variables and point-wise 
        evalutated variables vector.
        
        Returns::
        
            A reference to the z-vector.
        """
        return self._z
    
    def get_real_ci(self):
        """ 
        Get the real independent constants vector.
        
        Returns::
        
            A reference to the real independent constants vector.
        """
        return self._real_ci
    
    def get_real_cd(self):
        """ 
        Get the real dependent constants vector.
        
        Returns::
        
            A reference to the real dependent constants vector.
        """
        return self._real_cd
    
    def get_real_pi(self):
        """ 
        Get the real independent parameters vector.
        
        Returns::
        
            A reference to the real independent parameters vector.
        """
        return self._real_pi
        
    def get_real_pd(self):
        """ 
        Get the real dependent parameters vector.
        
        Returns::
        
            A reference to the real dependent parameters vector.
        """
        return self._real_pd

    def get_integer_ci(self):
        """ 
        Get the integer independent constants vector.
        
        Returns::
        
            A reference to the integer independent constants vector.
        """
        return self._integer_ci
    
    def get_integer_cd(self):
        """ 
        Get the integer dependent constants vector.
        
        Returns::
        
            A reference to the integer dependent constants vector.
        """
        return self._integer_cd
    
    def get_integer_pi(self):
        """ 
        Get the integer independent parameters vector.
        
        Returns::
        
            A reference to the integer independent parameters vector.
        """
        return self._integer_pi
        
    def get_integer_pd(self):
        """ 
        Get the integer dependent parameters vector.
        
        Returns::
        
            A reference to the integer dependent parameters vector.
        """
        return self._integer_pd

    def get_boolean_ci(self):
        """ 
        Get the boolean independent constants vector.
        
        Returns::
        
            A reference to the boolean independent constants vector.
        """
        return self._boolean_ci
    
    def get_boolean_cd(self):
        """ 
        Get the boolean dependent constants vector.
        
        Returns::
        
            A reference to the boolean dependent constants vector.
        """
        return self._boolean_cd
    
    def get_boolean_pi(self):
        """ 
        Get the boolean independent parameters vector.
        
        Returns::
        
            A reference to the boolean independent parameters vector.
        """
        return self._boolean_pi
        
    def get_boolean_pd(self):
        """ 
        Get the boolean dependent parameters vector.
        
        Returns::
        
            A reference to the boolean dependent parameters vector.
        """
        return self._boolean_pd

    def get_real_dx(self):
        """ 
        Get the real derivatives vector.
        
        Returns::
        
            A reference to the real derivatives vector.
        """
        return self._real_dx 
    
    def get_real_x(self):
        """ 
        Get the real differentiated variables vector.
        
        Returns::
        
            A reference to the real differentiated variables vector.
        """
        return self._real_x
        
    def get_real_u(self):
        """ 
        Get the real inputs vector.
        
        Returns::
        
            A reference to the real inputs variables vector.
        """
        return self._real_u
        
    def get_real_w(self):
        """ 
        Get the real algebraic variables vector.
        
        Returns::
        
            A reference to the real algebraic variables vector.
        """
        return self._real_w

    def get_t(self):
        """ 
        Get the time value.
        
        Returns::
        
            The time value, a NumPy array of length 1.
        """
        return self._t

    def get_real_dx_p(self, i):
        """ 
        Get the real derivatives variables vector corresponding to the i:th time 
        point.
        
        Parameters::
        
            i --
                The time point.
                
        Returns::
        
            A reference to the real derivatives variables vector for time point 
            i.
        """
        return self._dll.jmi_get_real_dx_p(self._jmi,i)

    def get_real_x_p(self, i):
        """ 
        Get the real differentiated variables vector corresponding to the i:th 
        time point.
        
        Parameters::
        
            i --
                The time point.
                
        Returns::
        
            A reference to the real differentiated variables vector for time 
            point i.
        """
        return self._dll.jmi_get_real_x_p(self._jmi, i)

    def get_real_u_p(self, i):
        """ 
        Get the real inputs vector corresponding to the i:th time point.
        
        Parameters::
        
            i --
                The time point.
                
        Returns::
        
            A reference to the real inputs variables vector for time point i.
        """
        return self._dll.jmi_get_real_u_p(self._jmi, i)

    def get_real_w_p(self, i):
        """ 
        Get the real algebraic variables vector corresponding to the i:th time 
        point.
        
        Parameters::
        
            i --
                The time point.
                
        Returns::
        
            A reference to the real algebraic variables vector for time point i.
        """
        return self._dll.jmi_get_real_w_p(self._jmi, i) 

    def get_real_d(self):
        """ 
        Get the real discrete variable vector.
        
        Returns::
        
            A reference to the real discrete variables vector.
        """
        return self._real_d

    def get_integer_d(self):
        """ 
        Get the integer variable vector.
        
        Returns::
        
            A reference to the integer variables vector.
        """
        return self._integer_d

    def get_integer_u(self):
        """ 
        Get the integer input vector.
        
        Returns::
        
            A reference to the integer input variables vector.
        """
        return self._integer_u

    def get_boolean_d(self):
        """
        Get the boolean variable vector.
        
        Returns::
        
            A reference to the boolean variables vector.
        """
        return self._boolean_d

    def get_boolean_u(self):
        """ 
        Get the boolean input vector.
        
        Returns::
        
            A reference to the boolean input variables vector.
        """
        return self._boolean_u

    def get_output_vrefs(self, output_vrefs):
        """ 
        Get the value references of the outputs.
        
        Parameters::
        
            output_vrefs --         
                A list of value references for the outputs (Output variable).
        """
        if self._dll.jmi_get_output_vrefs(self._jmi,output_vrefs) is not 0:
            raise JMIException("Retrieving output value references failed.")

    def get_sw(self):
        """ 
        Get the switching function vector of the DAE. A switch value of 1 
        corresponds to true and 0 corresponds to false.
        
        Returns::
        
            A reference to the switch function vector of the DAE.
        """
        return self._sw

    def get_sw_init(self):
        """ 
        Get the switching function vector of the DAE initialization system. A 
        switch value of 1 corresponds to true and 0 corresponds to false.
        
        Returns::
        
            A reference to the switch function vector of the DAE initialization.
        """
        return self._sw_init

    def get_variable_scaling_factors(self):
        """ 
        Get the variable scaling factor vector.
        
        Returns::
        
            A reference to the variable scaling factor vector.
        """
        return self._variable_scaling_factors

    def get_scaling_method(self):
        """ 
        Get the scaling method. Valid values are JMI_SCALING_NONE and 
        JMI_SCALING_VARIABLES.
        
        Returns::
        
            The scaling method currently used.
        """
        return self._dll.jmi_get_scaling_method(self._jmi);
    
    def ode_f(self):
        """ 
        Evalutate the right hand side of the ODE.
        
        The results is saved to the internal states and can be accessed by 
        accessing 'my_model.real_x'.
        """
        if self._dll.jmi_ode_f(self._jmi) is not 0:
            raise JMIException("Evaluating ODE failed.")
        
    def ode_df(self, eval_alg, sparsity, independent_vars, mask, jac):
        """ 
        Evaluate the Jacobian of the right hand side of the ODE.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity --
               Output format of the Jacobian. Use JMI_DER_SPARSE, 
               JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
               
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            jac --
                The Jacobian. (Return variable)
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        if self._dll.jmi_ode_df(self._jmi, eval_alg, sparsity, independent_vars, 
            mask, jac) is not 0:
            raise JMIException("Evaluation of Jacobian failed.")
    
    def ode_df_n_nz(self, eval_alg):
        """ 
        Get the number of non-zeros in the Jacobian of the right hand side of 
        the ODE.
        
        Parameters::
        
            eval_alg --
                For which Jacobian the number of non-zero elements should be 
                returned: Symbolic (JMI_DER_SYMBOLIC) or CppAD (JMI_DER_CPPAD).
                
        Returns::
        
            The number of non-zero Jacobian entries.
        """
        n_nz = ct.c_int()
        if self._dll.jmi_ode_df_n_nz(self._jmi, eval_alg, byref(n_nz)) is not 0:
            raise JMIException("Getting number of non-zeros failed.")
        return int(n_nz.value)
    
    def ode_df_nz_indices(self, eval_alg, independent_vars, mask, row, col):
        """ 
        Get the row and column indices of the non-zero elements in the Jacobian 
        of the right hand side of the ODE.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            row --
                Row indices of the non-zeros in the Jacobian. (Return variable)
                
            col --
                Column indices of the non-zeros in the Jacobian. (Return 
                variable)
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        if self._dll.jmi_ode_df_nz_indices(self._jmi, eval_alg, 
            independent_vars, mask, row, col) is not 0:
            raise JMIException("Getting row and column indices failed.")
    
    def ode_df_dim(self, eval_alg, sparsity, independent_vars, mask):
        """ 
        Get the number of columns and non-zero elements in the Jacobian of the 
        right hand side of the ODE.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity --
                Output format of the Jacobian. Use JMI_DER_SPARSE, 
                JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
       
        Returns::
        
            Tuple with number of columns and non-zeros resp. of the resulting 
            Jacobian.
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        df_n_cols = ct.c_int()
        df_n_nz = ct.c_int()
        if self._dll.jmi_ode_df_dim(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, byref(df_n_cols), byref(df_n_nz)) is not 0:
            raise JMIException("Getting number of columns and non-zero \
            elements failed.")        
        return int(df_n_cols.value), int(df_n_nz.value)

    def ode_derivatives(self):
        """ 
        Compute the derivatives of the ODE.
        """
        if self._dll.jmi_ode_derivatives(self._jmi) is not 0:
            raise JMIException("Evaluation of ODE derivatives failed")

    def ode_derivatives_dir_der(self, dv):
        """ 
        Compute the directional derivative of the ODE.

        Parameters::
        
            dv --
                The seed vector
        """
        if self._dll.jmi_ode_derivatives_dir_der(self._jmi, dv) is not 0:
            raise JMIException("Evaluation of the ODE directional derivatives failed")

    def ode_outputs(self):
        """ 
        Compute the outputs of the ODE.
        """
        if self._dll.jmi_ode_outputs(self._jmi) is not 0:
            raise JMIException("Evaluation of ODE outputs failed")

    def ode_initialize(self):
        """ 
        Initialize the ODE.
        """
        if self._dll.jmi_ode_initialize(self._jmi) is not 0:
            raise JMIException("Initialization of the ODE failed")

    def ode_guards(self):
        """ 
        Evaluate the guard expressions of the ODE.
        """
        if self._dll.jmi_ode_guards(self._jmi) is not 0:
            raise JMIException("Evaluation of ODE guards failed")

    def ode_guards_init(self):
        """ 
        Evaluate the guard expressions of the initial equations.
        """
        if self._dll.jmi_ode_guards_init(self._jmi) is not 0:
            raise JMIException("Evaluation of guard expressions in the initial equations failed")

    def ode_next_time_event(self):
        """ 
        Compute the next time event.
        """
        n_t_ev = c_jmi_real_t()
        if self._dll.jmi_ode_next_time_event(self._jmi,byref(n_t_ev)) is not 0:
            raise JMIException("Evaluation of next time event failed")
        return n_t_ev.value

    def dae_get_sizes(self):
        """ 
        Get the number of equations of the DAE.
        
        Returns::
        
            The number of equations of the DAE.
        """
        n_eq_F = ct.c_int()
        n_eq_R = ct.c_int()
        if self._dll.jmi_dae_get_sizes(self._jmi, byref(n_eq_F), 
            byref(n_eq_R)) is not 0:
            raise JMIException("Getting number of equations failed.")
        return n_eq_F.value, n_eq_R.value
    
    def dae_F(self, res):
        """ 
        Evaluates the DAE residual.
        
        Parameters::
        
            res --
                DAE residual vector. (Return variable)
        """
        if self._dll.jmi_dae_F(self._jmi, res) is not 0:
            raise JMIException("Evaluating the DAE residual failed.")

    def dae_dF(self, eval_alg, sparsity, independent_vars, mask, jac):
        """ 
        Evaluate the Jacobian of the DAE residual function.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity --
                Output format of the Jacobian. Use JMI_DER_SPARSE, 
                JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            jac --
                The Jacobian. (Return variable)
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        if self._dll.jmi_dae_dF(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, jac) is not 0:
            raise JMIException("Evaluating the Jacobian failed.")
    
    def dae_dF_n_nz(self, eval_alg):
        """ 
        Get the number of non-zeros in the full DAE residual Jacobian.

        Parameters::
        
            eval_alg --
                For which Jacobian the number of non-zero elements should be 
                returned: Symbolic (JMI_DER_SYMBOLIC) or CppAD (JMI_DER_CPPAD).
                
        Returns::
        
            The number of non-zero Jacobian entries.
        """
        n_nz = ct.c_int()
        if self._dll.jmi_dae_dF_n_nz(self._jmi, eval_alg, byref(n_nz)) is not 0:
            raise JMIException("Getting the number of non-zeros failed.")
        return int(n_nz.value)
    
    def dae_dF_nz_indices(self, eval_alg, independent_vars, mask, row, col):
        """ 
        Get the row and column indices of the non-zero elements in the DAE 
        residual Jacobian.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            row --
                Row indices of the non-zeros in the DAE residual Jacobian. 
                (Return variable)
                
            col --
                Column indices of the non-zeros in the DAE residual Jacobian. 
                (Return variable)
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        if self._dll.jmi_dae_dF_nz_indices(self._jmi, eval_alg, 
            independent_vars, mask, row, col) is not 0:
            raise JMIException("Getting the row and column indices failed.")
    
    def dae_dF_dim(self, eval_alg, sparsity, independent_vars, mask):
        """ 
        Get the number of columns and non-zero elements in the Jacobian of the 
        DAE residual.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity --
                Output format of the Jacobian. Use JMI_DER_SPARSE, 
                JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
        
        Returns::
        
            Tuple with number of columns and non-zeros resp. of the resulting 
            Jacobian.
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        dF_n_cols = ct.c_int()
        dF_n_nz = ct.c_int()
        if self._dll.jmi_dae_dF_dim(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, byref(dF_n_cols), byref(dF_n_nz)) is not 0:
            raise JMIException("Returning the number of columns and \
            non-zero elements failed.")        
        return int(dF_n_cols.value), int(dF_n_nz.value)

    def dae_directional_dF(self, eval_alg, res, dF, dz):
        """ 
        Evaluate the directional derivative of the DAE residual function.

        The directional derivative is defined as

            dF = dF/dz * dz

        where dF/dz is the Jacobian of the residual function F, dF
        is the directional derivative and dz is the seed vector.
        
        
        Parameters::
        	eval_alg --
        		JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                JMI_DER_CAD to evaluate the Jacobian using CAD
                JMI_DER_FD to evaluate using finite differences
        
            res --
                DAE residual vector. The size of res is equal to the number
                of equations in the DAE residual. (Return variable)

            dF --
                The directional derivative of the DAE residual function.
                The size of res is equal to the number of equations in the
                DAE residual. (Return variable)

            dz --
                The seed vector. The size of dz is equal to 2*n_x + n_u + n_w.

        """
        if self._dll.jmi_dae_directional_dF(self._jmi, eval_alg, res, dF, dz) is not 0:
            raise JMIException("Evaluating the directional derivative failed.")

    def dae_derivative_checker(self, sparsity, independent_vars, screen_use, mask):
        """
		Compare the evaluated CAD derivative with the FD evaluation
		
		Parameters::
			sparsity --
            	Compare the result with different jacobian formats: JMI_DER_SPARSE, 
                JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
			independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
		"""
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass
        if self._dll.jmi_dae_derivative_checker(self._jmi, sparsity, independent_vars, screen_use, mask) is not 0:
            raise JMIException("Comparing the jacobians failed")

    def dae_R(self, res):
        """ 
        Evaluate the DAE event indicators.
        
        Parameters::
        
            res -- 
                DAE residual vector. (Return variable)
        """
        if self._dll.jmi_dae_R(self._jmi, res) is not 0:
            raise JMIException("Evaluating DAE event indicators.")
        
    def init_get_sizes(self):
        """ 
        Get the number of equations in the DAE initialization functions.
        
        Returns::
        
            The number of equations in F0, F1 and Fp resp.
        """
        n_eq_f0 = ct.c_int()
        n_eq_f1 = ct.c_int()
        n_eq_fp = ct.c_int()
        n_eq_r0 = ct.c_int()
        if self._dll.jmi_init_get_sizes(self._jmi, byref(n_eq_f0), 
            byref(n_eq_f1), byref(n_eq_fp), byref(n_eq_r0)) is not 0:
            raise JMIException("Getting the number of equations failed.")
        return n_eq_f0.value, n_eq_f1.value, n_eq_fp.value, n_eq_r0.value
    
    def init_F0(self, res):
        """ 
        Evaluate the F0 residual function of the initialization system.
        
        Parameters::
        
            res -- 
                The residual of F0. (Return variable)
        """
        if self._dll.jmi_init_F0(self._jmi, res) is not 0:
            raise JMIException("Evaluating the F0 residual function failed.")
        
    def init_dF0(self, eval_alg, sparsity, independent_vars, mask, jac):
        """ 
        Evaluate the Jacobian of the DAE initialization residual function F0.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity --
                Output format of the Jacobian. Use JMI_DER_SPARSE, 
                JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            jac --
                The Jacobian. (Return variable)
        """
        
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        if self._dll.jmi_init_dF0(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, jac) is not 0:
            raise JMIException("Evaluating the Jacobian failed.")
    
    def init_dF0_n_nz(self, eval_alg):
        """ 
        Get the number of non-zeros in the full Jacobian of the DAE 
        initialization residual function F0.
        
        Parameters::
        
            eval_alg --
                For which Jacobian the number of non-zero elements should be 
                returned: Symbolic (JMI_DER_SYMBOLIC) or CppAD (JMI_DER_CPPAD).
                
        Returns::
        
            The number of non-zero Jacobian entries in the full Jacobian.
        """
        n_nz = ct.c_int()
        if self._dll.jmi_init_dF0_n_nz(self._jmi, eval_alg, byref(n_nz)) is not 0:
            raise JMIException("Getting the number of non-zeros failed.")
        return int(n_nz.value)
    
    def init_dF0_nz_indices(self, eval_alg, independent_vars, mask, row, col):
        """ 
        Get the row and column indices of the non-zero elements in the Jacobian 
        of the DAE initialization residual function F0.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            row --
                Row indices of the non-zeros in the Jacobian. (Return 
                variable)
            col --
                Column indices of the non-zeros in the Jacobian. (Return 
                variable)
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass       
        if self._dll.jmi_init_dF0_nz_indices(self._jmi, eval_alg, 
            independent_vars, mask, row, col) is not 0:
            raise JMIException("Getting the row and column indices failed.")
    
    def init_dF0_dim(self, eval_alg, sparsity, independent_vars, mask):
        """ 
        Get the number of columns and non-zero elements in the Jacobian of the 
        DAE initialization residual function F0.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity --
               Output format of the Jacobian. Use JMI_DER_SPARSE, 
               JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
               
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.

        Returns::
        
            Tuple with number of columns and non-zeros resp. of the resulting 
            Jacobian.
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        dF0_n_cols = ct.c_int()
        dF0_n_nz = ct.c_int()
        if self._dll.jmi_init_dF0_dim(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, byref(dF0_n_cols), byref(dF0_n_nz)) is not 0:
            raise JMIException("Returning the number of columns and \
            non-zero elements failed.")             
        return int(dF0_n_cols.value), int(dF0_n_nz.value)

    def init_F1(self, res):
        """ 
        Evaluate the F1 residual function of the initialization system.
        
        Parameters::
        
            res -- 
                The residual of F1. (Return variable)
        """
        if self._dll.jmi_init_F1(self._jmi, res) is not 0:
            raise JMIException("Evaluating the F1 residual function failed.")            
        
    def init_dF1(self, eval_alg, sparsity, independent_vars, mask, jac):
        """ 
        Evaluate the Jacobian of the DAE initialization residual function F1.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity --
               Output format of the Jacobian. Use JMI_DER_SPARSE, 
               JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
               
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            jac --
                The Jacobian. (Return variable)
        """
        
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        if self._dll.jmi_init_dF1(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, jac) is not 0:
            raise JMIException("Evaluating the Jacobian failed.")
    
    def init_dF1_n_nz(self, eval_alg):
        """ 
        Get the number of non-zeros in the full Jacobian of the DAE 
        initialization residual function F1.
        
        Parameters::
        
            eval_alg --
                For which Jacobian the number of non-zero elements should be 
                returned: Symbolic (JMI_DER_SYMBOLIC) or CppAD (JMI_DER_CPPAD).
                
        Returns::
        
            The number of non-zero Jacobian entries in the full Jacobian.
        """
        n_nz = ct.c_int()
        if self._dll.jmi_init_dF1_n_nz(self._jmi, eval_alg, byref(n_nz)) is not 0:
            raise JMIException("Getting the number of non-zeros failed.")
        return int(n_nz.value)
    
    def init_dF1_nz_indices(self, eval_alg, independent_vars, mask, 
        row, col):
        """ 
        Get the row and column indices of the non-zero elements in the Jacobian 
        of the DAE initialization residual function F1.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            row --
                Row indices of the non-zeros in the Jacobian. (Return variable)
                
            col --
                Column indices of the non-zeros in the Jacobian. (Return 
                variable)
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass
        
        if self._dll.jmi_init_dF1_nz_indices(self._jmi, eval_alg, 
            independent_vars, mask, row, col) is not 0:
            raise JMIException("Getting the row and column indices failed.")
    
    def init_dF1_dim(self, eval_alg, sparsity, independent_vars, mask):
        """ 
        Get the number of columns and non-zero elements in the Jacobian of the 
        DAE initialization residual function F1.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity --
               Output format of the Jacobian. Use JMI_DER_SPARSE, 
               JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
               
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.

        Returns::
            
            Tuple with number of columns and non-zeros resp. of the resulting 
            Jacobian.
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        dF1_n_cols = ct.c_int()
        dF1_n_nz = ct.c_int()
        if self._dll.jmi_init_dF1_dim(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, byref(dF1_n_cols), byref(dF1_n_nz)) is not 0:
            raise JMIException("Getting the number of columns and \
            non-zero elements failed.")        
        return int(dF1_n_cols.value), int(dF1_n_nz.value)
 
    def init_Fp(self, res):
        """ 
        Evaluate the Fp residual function of the initialization system.
      
        Parameters::
        
            res --
                The residual of Fp. (Return variable)
        """
        raise JMIException("The init_Fp function is no longer supported.")
        if self._dll.jmi_init_Fp(self._jmi, res) is not 0:
            raise JMIException("Evaluating the Fp residual function failed.")
      
    def init_dFp(self, eval_alg, sparsity, independent_vars, mask, jac):
        """ 
        Evaluate the Jacobian of the DAE initialization residual function F1.
      
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity --
               Output format of the Jacobian. Use JMI_DER_SPARSE, 
               JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
               
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
              
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            jac --
                The Jacobian. (Return variable)
        """
        raise JMIException("The init_Fp function is no longer supported.")
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass
      
        if self._dll.jmi_init_dFp(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, jac) is not 0:
            raise JMIException("Evaluating the Jacobian failed.")
  
    def init_dFp_n_nz(self, eval_alg):
        """ 
        Get the number of non-zeros in the full Jacobian of the DAE 
        initialization residual function Fp.
      
        Parameters::
        
            eval_alg --
                For which Jacobian the number of non-zero elements should be 
                returned: Symbolic (JMI_DER_SYMBOLIC) or CppAD (JMI_DER_CPPAD).
              
        Returns::
        
            The number of non-zero Jacobian entries in the full Jacobian.
        """
        raise JMIException("The init_Fp function is no longer supported.")
        n_nz = ct.c_int()
        if self._dll.jmi_init_dFp_n_nz(self._jmi, eval_alg, byref(n_nz)) is not 0:
            raise JMIException("Getting the number of non-zeros failed.")
        return int(n_nz.value)
  
    def init_dFp_nz_indices(self, eval_alg, independent_vars, mask, row, col):
        """ 
        Get the row and column indices of the non-zero elements in the Jacobian 
        of the DAE initialization residual function Fp.
      
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
              
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            row --
                Row indices of the non-zeros in the Jacobian. (Return variable)
                
            col --
                Column indices of the non-zeros in the Jacobian. (Return 
                variable)
        """
        raise JMIException("The init_Fp function is no longer supported.")
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        if self._dll.jmi_init_dFp_nz_indices(self._jmi, eval_alg, 
            independent_vars, mask, row, cols) is not 0:
            raise JMIException("Getting the row and column indices failed.")
  
    def init_dFp_dim(self, eval_alg, sparsity, independent_vars, mask):
        """ 
        Get the number of columns and non-zero elements in the Jacobian of the 
        DAE initialization residual function Fp.
      
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity --
                Output format of the Jacobian. Use JMI_DER_SPARSE, 
                JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
              
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
        Returns::
        
            Tuple with number of columns and non-zeros resp. of the resulting 
            Jacobian.
        """
        raise JMIException("The init_Fp function is no longer supported.")
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        dFp_n_cols = ct.c_int()
        dFp_n_nz = ct.c_int()
        if self._dll.jmi_init_dFp_dim(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, byref(dF_n_cols), byref(dF_n_nz)) is not 0:
            raise JMIException("Getting the number of columns and \
            non-zero elements failed.")        
        return int(dFp_n_cols.value), int(dFp_n_nz.value)

    def init_eval_parameters(self):
        """ 
        Compute the dependent parameters.
        """
        if self._dll.jmi_init_eval_parameters(self._jmi) is not 0:
            raise JMIException("Evaluation of parameters failed")

    def set_start_values(self):
        """ 
        Set the start values.
        """
        if self._dll.jmi_set_start_values(self._jmi) is not 0:
            raise JMIException("Setting the start values failed")

    def init_R0(self, res):
        """ 
        Evaluate the DAE initialization event indicators.
        
        Parameters::
        
            res --
                DAE residual vector. (Return variable)
        """
        if self._dll.jmi_init_R0(self._jmi, res) is not 0:
            raise JMIException("Evaluating the DAE initialization event \
            indicators.")
    
    def opt_set_optimization_interval(self, start_time, start_time_free, 
        final_time, final_time_free):
        """ 
        Set the optimization interval.
        
        Parameters::
        
            start_time -- 
                Start time of optimization interval.
                
            start_time_free -- 
                0 if start time should be fixed or 1 if free.
                
            final_time -- 
                Final time of optimization interval.
                
            final_time_free -- 
                0 if final time should be fixed or 1 if free.
        """
        if self._dll.jmi_opt_set_optimization_interval(self._jmi, 
            start_time, start_time_free, final_time, final_time_free) is not 0:
            raise JMIException("Setting the optimization interval failed.")
        
    def opt_get_optimization_interval(self):
        """ 
        Get the optimization interval.
        
        Returns::
        
            Tuple with start time of optimization interval, 0 if start time is 
            fixed and 1 if free, final time of optimization interval, 0 if final 
            time is fixed and 1 if free, respectively. 
        """
        start_time = ct.c_double()
        start_time_free = ct.c_int()
        final_time = ct.c_double()
        final_time_free = ct.c_int()
        if self._dll.jmi_opt_get_optimization_interval(self._jmi, 
            byref(start_time), byref(start_time_free), byref(final_time), 
            byref(final_time_free)) is not 0:
            raise JMIException("Getting the optimization interval failed.")
        return start_time.value, start_time_free.value, final_time.value, final_time_free.value
        
    def opt_set_p_opt_indices(self, n_p_opt, p_opt_indices):
        """ 
        Specify optimization parameters for the model.
        
        Parameters::
        
            n_p_opt -- 
                Number of parameters to be optimized.
                
            p_opt_indices -- 
                Indices of parameters to be optimized in pi vector.
        """
        if self._dll.jmi_opt_set_p_opt_indices(self._jmi, n_p_opt, 
            p_opt_indices) is not 0:
            raise JMIException("Specifing optimization parameters failed.")
        
    def opt_get_n_p_opt(self):
        """ 
        Get the number of optimization parameters.
        
        Returns::
        
            The number of optimization parameters.
        """
        n_p_opt = ct.c_int()
        if self._dll.jmi_opt_get_n_p_opt(self._jmi, byref(n_p_opt)) is not 0:
            raise JMIException("Getting the number of optimization \
            parameters failed.")
        return int(n_p_opt.value)
        
    def opt_get_p_opt_indices(self, p_opt_indices):
        """ 
        Get the optimization parameter indices.
        
        Parameters::
        
            p_opt_indices -- 
                Indices of parameters to be optimized. (Return variable)
        """
        if self._dll.jmi_opt_get_p_opt_indices(self._jmi, p_opt_indices) is not 0:
            raise JMIException("Getting the optimization parameters failed.")
        
    def opt_get_sizes(self):
        """ 
        Get the sizes of the optimization functions.
        
        Returns::
        
            Tuple with number of equations in the J, L, Ffdp, Ceq, Cineq, Heq 
            and Hineq residual respectively. 
        """
        n_eq_J = ct.c_int()
        n_eq_L = ct.c_int()
        n_eq_Ffdp = ct.c_int()
        n_eq_Ceq = ct.c_int()
        n_eq_Cineq = ct.c_int()
        n_eq_Heq = ct.c_int()
        n_eq_Hineq = ct.c_int()
        if self._dll.jmi_opt_get_sizes(self._jmi, byref(n_eq_J), \
            byref(n_eq_L), byref(n_eq_Ffdp), byref(n_eq_Ceq), \
            byref(n_eq_Cineq), byref(n_eq_Heq), byref(n_eq_Hineq)) is not 0:
            raise JMIException("Getting the sizes of the optimization \
            functions failed.")
        return n_eq_J.value, n_eq_L.value, n_eq_Ffdp.value, \
        n_eq_Ceq.value, n_eq_Cineq.value, n_eq_Heq.value, \
        n_eq_Hineq.value

    def opt_Ffdp(self, res):
        """ 
        Evaluate the residual of the free dependent parameter residuals Ffdp.
        
        Parameters::
        
            res -- 
                The residual. (Return variable)
        """
        if self._dll.jmi_opt_Ffdp(self._jmi, res) is not 0:
            raise JMIException("Evaluation of the residual of the free \
            dependent parameter residual Ffdp failed.")
        
    def opt_dFfdp(self, eval_alg, sparsity, independent_vars, mask, jac):
        """ 
        Evaluate the Jacobian of the free dependent parameter residual Ffdp.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity -- 
                Output format of the Jacobian. Use JMI_DER_SPARSE, 
                JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            jac --
                The Jacobian. (Return variable)
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass
        
        if self._dll.jmi_opt_dFfdp(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, jac) is not 0:
            raise JMIException("Evaluation of the Jacobian of the \
            equality path constraint Ffdp failed.")
        
    def opt_dFfdp_n_nz(self, eval_alg):
        """ 
        Get the number of non-zeros in the full Jacobian of the free dependent 
        parameter residual Ffdp.
        
        Parameters::
        
            eval_alg -- 
                For which Jacobian the number of non-zero elements should be 
                returned: Symbolic (JMI_DER_SYMBOLIC) or CppAD (JMI_DER_CPPAD).
                
        Returns::
        
            The number of non-zero entries in the full Jacobian.
        """
        n_nz = ct.c_int()
        if self._dll.jmi_opt_dFfdp_n_nz(self._jmi, eval_alg, byref(n_nz)) is not 0:
            raise JMIException("Getting the number of non-zeros failed.")
        return int(n_nz.value)
        
    def opt_dFfdp_nz_indices(self, eval_alg, independent_vars, mask, row, col):
        """ 
        Get the row and column indices of the non-zero elements in the Jacobian 
        of the free dependent parameter residual Ffdp.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            row --
                Row indices of the non-zeros in the Jacobian. (Return variable)
                
            col --
                Column indices of the non-zeros in the Jacobian. (Return 
                variable)
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        if self._dll.jmi_opt_dFfdp_nz_indices(self._jmi, eval_alg, 
            independent_vars, mask, row, col) is not 0:
            raise JMIException("Getting the row and column indices failed.")
        
    def opt_dFfdp_dim(self, eval_alg, sparsity, independent_vars, mask):
        """ 
        Compute the number of columns and non-zero elements in the Jacobian of 
        the free dependent parameter residual Ffdp.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity -- 
                Output format of the Jacobian. Use JMI_DER_SPARSE, 
                JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
        
        Returns::
        
            Tuple with number of columns and non-zeros resp. of the resulting 
            Jacobian.
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass
        
        dFfdp_n_cols = ct.c_int()
        dFfdp_n_nz = ct.c_int()
        if self._dll.jmi_opt_dFfdp_dim(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, byref(dFfdp_n_cols), byref(dFfdp_n_nz)) is not 0:
            raise JMIException("Computing the number of columns and \
            non-zero elements failed.")
        return int(dFfdp_n_cols.value), int(dFfdp_n_nz.value)

    def opt_J(self):
        """ 
        Evaluate the cost function J. 
        """
        J = N.zeros(1, dtype=c_jmi_real_t)
        if self._dll.jmi_opt_J(self._jmi, J) is not 0:
            raise JMIException("Evaluation of J failed.")
        return J[0]
        
    def opt_dJ(self, eval_alg, sparsity, independent_vars, mask, jac):
        """ 
        Evaluate the gradient of the cost function.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity --
                Output format of the Jacobian. Use JMI_DER_SPARSE, 
                JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            jac --
                The gradient. (Return variable)
        """
        
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        if self._dll.jmi_opt_dJ(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, jac) is not 0:
            raise JMIException("Evaluation of the gradient of the cost \
            function failed.")
        
    def opt_dJ_n_nz(self, eval_alg):
        """ 
        Get the number of non-zeros in the gradient of the cost function J.
        
        Parameters::
        
            eval_alg --
                For which Jacobian the number of non-zero elements should be 
                returned: Symbolic (JMI_DER_SYMBOLIC) or CppAD (JMI_DER_CPPAD).
                
        Returns::
        
            The number of non-zero entries in the full gradient.
        """
        n_nz = ct.c_int()
        if self._dll.jmi_opt_dJ_n_nz(self._jmi, eval_alg, byref(n_nz)) is not 0:
            raise JMIException("Getting the number of non-zeros failed.")
        return int(n_nz.value)
        
    def opt_dJ_nz_indices(self, eval_alg, independent_vars, mask, row, col):
        """ 
        Get the row and column indices of the non-zero elements in the gradient 
        of the cost function J.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            row --
                Row indices of the non-zeros in the gradient. (Return variable)
                
            col --
                Column indices of the non-zeros in the gradient. (Return 
                variable)
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        if self._dll.jmi_opt_dJ_nz_indices(self._jmi, eval_alg, 
            independent_vars, mask, row, col) is not 0:
            raise JMIException("Getting the row and column indices failed.")
        
    def opt_dJ_dim(self, eval_alg, sparsity, independent_vars, mask):
        """ 
        Compute the number of columns and non-zero elements in the gradient of 
        the cost function.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity -- 
                Output format of the Jacobian. Use JMI_DER_SPARSE, 
                JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
        
        Returns::
        
            Tuple with number of columns and non-zeros resp. of the resulting 
            Jacobian.
        """
        
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass
        
        dJ_n_cols = ct.c_int()
        dJ_n_nz = ct.c_int()
        if self._dll.jmi_opt_dJ_dim(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, byref(dJ_n_cols), byref(dJ_n_nz)) is not 0:
            raise JMIException("Computing the number of columns and \
            non-zero elements failed.")
        return int(dJ_n_cols.value), int(dJ_n_nz.value)
        
    def opt_Ceq(self, res):
        """ 
        Evaluate the residual of the equality path constraint Ceq.
        
        Parameters::
        
            res -- 
                The residual. (Return variable)
        """
        if self._dll.jmi_opt_Ceq(self._jmi, res) is not 0:
            raise JMIException("Evaluation of the residual of the \
            equality path constraint Ceq failed.")
        
    def opt_dCeq(self, eval_alg, sparsity, independent_vars, mask, jac):
        """ 
        Evaluate the Jacobian of the equality path constraint Ceq.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity -- 
                Output format of the Jacobian. Use JMI_DER_SPARSE, 
                JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            jac --
                The Jacobian. (Return variable)
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass
        
        if self._dll.jmi_opt_dCeq(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, jac) is not 0:
            raise JMIException("Evaluation of the Jacobian of the \
            equality path constraint Ceq failed.")
        
    def opt_dCeq_n_nz(self, eval_alg):
        """ 
        Get the number of non-zeros in the full Jacobian of the equality path 
        constraint Ceq.
        
        Parameters::
        
            eval_alg --
                For which Jacobian the number of non-zero elements should be 
                returned: Symbolic (JMI_DER_SYMBOLIC) or CppAD (JMI_DER_CPPAD).
                
        Returns::
        
            The number of non-zero entries in the full Jacobian.
        """
        n_nz = ct.c_int()
        if self._dll.jmi_opt_dCeq_n_nz(self._jmi, eval_alg, byref(n_nz)) is not 0:
            raise JMIException("Getting the number of non-zeros failed.")
        return int(n_nz.value)
        
    def opt_dCeq_nz_indices(self, eval_alg, independent_vars, mask, row, col):
        """ 
        Get the row and column indices of the non-zero elements in the Jacobian 
        of the equality path constraint residual Ceq.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            row --
                Row indices of the non-zeros in the Jacobian. (Return variable)
                
            col --
                Column indices of the non-zeros in the Jacobian. (Return 
                variable)
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        if self._dll.jmi_opt_dCeq_nz_indices(self._jmi, eval_alg, 
            independent_vars, mask, row, col) is not 0:
            raise JMIException("Getting the row and column indices failed.")
        
    def opt_dCeq_dim(self, eval_alg, sparsity, independent_vars, mask):
        """ 
        Compute the number of columns and non-zero elements in the Jacobian of 
        the equality path constraint residual function Ceq.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity -- 
                Output format of the Jacobian. Use JMI_DER_SPARSE, 
                JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
        
        Returns::
        
            Tuple with number of columns and non-zeros resp. of the resulting 
            Jacobian.
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass
        
        dCeq_n_cols = ct.c_int()
        dCeq_n_nz = ct.c_int()
        if self._dll.jmi_opt_dCeq_dim(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, byref(dCeq_n_cols), byref(dCeq_n_nz)) is not 0:
            raise JMIException("Computing the number of columns and \
            non-zero elements failed.")
        return int(dCeq_n_cols.value), int(dCeq_n_nz.value)
        
    def opt_Cineq(self, res):
        """ 
        Evaluate the residual of the inequality path constraint Cineq.
        
        Parameters::
        
            res -- 
                The residual. (Return variable)
        """
        if self._dll.jmi_opt_Cineq(self._jmi, res) is not 0:
            raise JMIException("Evaluating the residual of the \
            inequality path constraint Cineq failed.")
        
    def opt_dCineq(self, eval_alg, sparsity, independent_vars, mask, jac):
        """ 
        Evaluate the Jacobian of the inequality path constraint Cineq.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity -- 
                Output format of the Jacobian. Use JMI_DER_SPARSE, 
                JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            jac --
                The Jacobian. (Return variable)
        """
        
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass
        
        if self._dll.jmi_opt_dCineq(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, jac) is not 0:
            raise JMIException("Evaluating the Jacobian of the \
            inequality path constraint Cineq failed.")
        
    def opt_dCineq_n_nz(self, eval_alg):
        """ 
        Get the number of non-zeros in the full Jacobian of the inequality path 
        constraint Cineq.
        
        Parameters::
        
            eval_alg --
                For which Jacobian the number of non-zero elements should be 
                returned: Symbolic (JMI_DER_SYMBOLIC) or CppAD (JMI_DER_CPPAD).
                
        Returns::
        
            The number of non-zero entries in the full Jacobian.
        """
        n_nz = ct.c_int()
        if self._dll.jmi_opt_dCineq_n_nz(self._jmi, eval_alg, byref(n_nz)) is not 0:
            raise JMIException("Getting the number of non-zeros failed.")
        return int(n_nz.value)
        
    def opt_dCineq_nz_indices(self, eval_alg, independent_vars, mask, row, col):
        """ 
        Get the row and column indices of the non-zero elements in the Jacobian 
        of the inequality path constraint residual Cineq.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (JMI_DER_DX or JMI_DER_X).
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            row --
                Row indices of the non-zeros in the Jacobian. (Return variable)
                
            col --
                Column indices of the non-zeros in the Jacobian. (Return 
                variable)
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        if self._dll.jmi_opt_dCineq_nz_indices(self._jmi, eval_alg, 
            independent_vars, mask, row, col) is not 0:
            raise JMIException("Getting the row and column indices failed.")
        
    def opt_dCineq_dim(self, eval_alg, sparsity, independent_vars, mask):
        """ 
        Compute the number of columns and non-zero elements in the Jacobian of 
        the inequality path constraint residual function Cineq.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity -- 
                Output format of the Jacobian. Use JMI_DER_SPARSE, 
                JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
        
        Returns::
        
            Tuple with number of columns and non-zeros resp. of the resulting 
            Jacobian.
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        dCineq_n_cols = ct.c_int()
        dCineq_n_nz = ct.c_int()
        if self._dll.jmi_opt_dCineq_dim(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, byref(dCineq_n_cols), 
            byref(dCineq_n_nz)) is not 0:
            raise JMIException("Computing the number of columns and \
            non-zero elements failed.")
        return int(dCineq_n_cols.value), int(dCineq_n_nz.value)

    def opt_Heq(self, res):
        """ 
        Evaluate the residual of the equality point constraint Heq.
        
        Parameters::
        
            res -- 
                The residual. (Return variable)
        """
        if self._dll.jmi_opt_Heq(self._jmi, res) is not 0:
            raise JMIException("Evaluating the residual of the equality point \
            constraint Heq failed.")
        
    def opt_dHeq(self, eval_alg, sparsity, independent_vars, mask, jac):
        """ 
        Evaluate the Jacobian of the equality point constraint Heq.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity -- 
                Output format of the Jacobian. Use JMI_DER_SPARSE, 
                JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            jac --
                The Jacobian. (Return variable)
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        if self._dll.jmi_opt_dHeq(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, jac) is not 0:
            raise JMIException("Evaluating the Jacobian of the equality point \
            constraint Heq failed.")
        
    def opt_dHeq_n_nz(self, eval_alg):
        """ 
        Get the number of non-zeros in the full Jacobian of the equality point 
        constraint Heq.
        
        Parameters::
        
            eval_alg --
                For which Jacobian the number of non-zero elements should be 
                returned: Symbolic (JMI_DER_SYMBOLIC) or CppAD (JMI_DER_CPPAD).
                
        Returns::
        
            The number of non-zero entries in the full Jacobian.
        """
        n_nz = ct.c_int()
        if self._dll.jmi_opt_dHeq_n_nz(self._jmi, eval_alg, byref(n_nz)) is not 0:
            raise JMIException("Getting the number of non-zeros failed.")
        return int(n_nz.value)
        
    def opt_dHeq_nz_indices(self, eval_alg, independent_vars, mask, row, col):
        """ 
        Get the row and column indices of the non-zero elements in the Jacobian 
        of the equality point constraint residual Heq.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            row --
                Row indices of the non-zeros in the Jacobian. (Return variable)
                
            col --
                Column indices of the non-zeros in the Jacobian. (Return 
                variable)
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        if self._dll.jmi_opt_dHeq_nz_indices(self._jmi, eval_alg, 
            independent_vars, mask, row, col) is not 0:
            raise JMIException("Getting the row and column indices failed.")
        
    def opt_dHeq_dim(self, eval_alg, sparsity, independent_vars, mask):
        """ 
        Compute the number of columns and non-zero elements in the Jacobian of 
        the equality point constraint residual function Heq.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity -- 
                Output format of the Jacobian. Use JMI_DER_SPARSE, 
                JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
        
        Returns::
        
            Tuple with number of columns and non-zeros resp. of the resulting 
            Jacobian.
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        dHeq_n_cols = ct.c_int()
        dHeq_n_nz = ct.c_int()
        if self._dll.jmi_opt_dHeq_dim(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, byref(dHeq_n_cols), 
            byref(dHeq_n_nz)) is not 0:
            raise JMIException("Computing the number of columns and \
            non-zero elements failed.")
        return int(dHeq_n_cols.value), int(dHeq_n_nz.value)

    def opt_Hineq(self, res):
        """ 
        Evaluate the residual of the inequality point constraint Hineq.
        
        Parameters::
        
            res -- 
                The residual. (Return variable)
        """
        if self._dll.jmi_opt_Hineq(self._jmi, res) is not 0:
            raise JMIException("Evaluating the residual of the inequality point \
            constraint Hineq failed.")
        
    def opt_dHineq(self, eval_alg, sparsity, independent_vars, mask, jac):
        """ 
        Evaluate the Jacobian of the inequality point constraint Hineq.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity -- 
                Output format of the Jacobian. Use JMI_DER_SPARSE, 
                JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            jac --
                The Jacobian. (Return variable)
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass        
        if self._dll.jmi_opt_dHineq(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, jac) is not 0:
            raise JMIException("Evaluating the Jacobian of the inequality point \
            constraint Hineq failed.")
        
    def opt_dHineq_n_nz(self, eval_alg):
        """ 
        Get the number of non-zeros in the full Jacobian of the inequality point 
        constraint Hineq.
        
        Parameters::
        
            eval_alg --
                For which Jacobian the number of non-zero elements should be 
                returned: Symbolic (JMI_DER_SYMBOLIC) or CppAD (JMI_DER_CPPAD).
                
        Returns::
        
            The number of non-zero entries in the full Jacobian.
        """
        n_nz = ct.c_int()
        if self._dll.jmi_opt_dHineq_n_nz(self._jmi, eval_alg, byref(n_nz)) is not 0:
            raise JMIException("Getting the number of non-zeros failed.")
        return int(n_nz.value)
        
    def opt_dHineq_nz_indices(self, eval_alg, independent_vars, mask, row, col):
        """ 
        Get the row and column indices of the non-zero elements in the Jacobian 
        of the inequality point constraint residual Hineq.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
                
            row --
                Row indices of the non-zeros in the Jacobian. (Return variable)
                
            col --
                Column indices of the non-zeros in the Jacobian. (Return 
                variable)
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass
        
        if self._dll.jmi_opt_dHineq_nz_indices(self._jmi, eval_alg, 
            independent_vars, mask, row, col) is not 0:
            raise JMIException("Getting the row and column indices failed.")
        
    def opt_dHineq_dim(self, eval_alg, sparsity, independent_vars, mask):
        """ 
        Compute the number of columns and non-zero elements in the Jacobian of 
        the inequality point constraint residual function Hineq.
        
        Parameters::
        
            eval_alg -- 
                JMI_DER_SYMBOLIC to evaluate a symbolic Jacobian or 
                JMI_DER_CPPAD to evaluate the Jacobian by means of CppAD.
                
            sparsity -- 
                Output format of the Jacobian. Use JMI_DER_SPARSE, 
                JMI_DER_DENSE_COL_MAJOR, or JMI_DER_DENS_ROW_MAJOR.
                
            independent_vars -- 
                Indicates which columns of the full Jacobian should be evaluated 
                (for example JMI_DER_DX or JMI_DER_X).
                
                Can either be a list of columns or a bitmask of the columns 
                or:ed (|) together. Using a list is prefered as it is more 
                Pythonesque.
                
            mask --
                Vector containing ones for the Jacobian columns that should be 
                included in the Jacobian and zeros for those which should not.
        
        Returns::
        
            Tuple with number of columns and non-zeros resp. of the resulting 
            Jacobian.
        """
        try:
            independent_vars = reduce(lambda x,y: x | y, independent_vars)
        except TypeError:
            pass
        
        dF_n_cols = ct.c_int()
        dF_n_nz = ct.c_int()
        if self._dll.jmi_opt_dHineq_dim(self._jmi, eval_alg, sparsity, 
            independent_vars, mask, byref(dHineq_n_cols), byref(dHineq_n_nz)) is not 0:
            raise JMIException("Computing the number of columns and \
            non-zero elements failed.")
        return int(dHineq_n_cols.value), int(dHineq_n_nz.value)

def unzip_jmu(archive, path='.'):
    """
    Unzip a JMU.
    
    Looks for a model description XML file, a binaries directory and a resources 
    directory and returns the result in a dict with the key:value pairs:
            - root : Root of archive (same as path)
            - model_desc : XML description of model (required)
            - image : Image file of model icon (optional)
            - documentation_dir : Directory containing the model documentation (optional)
            - sources_dir : Directory containing source files (optional)
            - binaries_dir : Directory containing the binaries (required)
            - resources_dir : Directory containing resources needed by the model (optional)
    
    
     If the model_desc and/or binaries_dir are not found, 
     an exception will be raised.
    
    Parameters::
        
        archive --
            The archive file name.
            
        path --
            The path to the archive file.
            Default: Current directory.
            
    Raises::
    
        IOError if any file is missing in the JMU.
    """
    tmpdir = unzip_unit(archive, path)
    jmu_files = get_files_in_archive(tmpdir)
    
    # check if all obligatory (but the binary) files have been found during unzip
    if jmu_files['model_desc'] == None:
        raise IOError('ModelDescription.xml not found in JMU archive: '+str(archive))
    
    if jmu_files['binaries_dir'] == None:
        raise IOError('binaries directory not found in JMU archive: '+str(archive))
    
    return jmu_files
    
