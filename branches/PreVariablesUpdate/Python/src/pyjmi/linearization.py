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

import numpy as N

import pyjmi.jmi as jmi

int = N.int32
N.int = N.int32

def linearize_dae(model):
    """ 
    Linearize a DAE represented by a pyjmi.jmi.JMUModel object. The DAE is 
    represented by

      F(dx,x,u,w,t) = 0

    and the linearized model is given by

      E*dx = A*x + B*u + F*w + g

    where E, A, B, F and g are constant coefficient matrices. The linearization 
    is done around the current values of the dx, x, u, w, and t values in the 
    JMUModel object.

    The matrices are computed by evaluating Jacobians with the AD package CppAD 
    which provides derivatives with machine precision. (That is, no numerical 
    finite differences are used in the linearization.)
    
    Parameters::
    
        model --
            The jmi.JMUModel object representing the model.

    Returns::
    
        E -- 
            n_eq_F x n_dx matrix corresponding to dF/ddx.
            
        A -- 
            n_eq_F x n_x matrix corresponding to -dF/dx.
            
        B -- 
            n_eq_F x n_u matrix corresponding to -dF/du.
            
        F -- 
            n_eq_F x n_w matrix corresponding to -dF/dw.
            
        g -- 
            n_eq_F x 1 matrix corresponding to F(dx0,x0,u0,w0,t0)
            
        state_names -- 
            Names of the differential variables.
            
        input_names -- 
            Names of the input variables.
            
        algebraic_names -- 
            Names of the algebraic variables.
            
        dx0 -- 
            Derivative variable vector around which the linearization is done.
            
        x0 -- 
            Differential variable vector around which the linearization is done.
            
        u0 -- 
            Input variable vector around which the linearization is done.
            
        w0 -- 
            Algebraic variable vector around which the linearization is done.
            
        t0 -- 
            Time for which the linearization is done.  

    Limitations::
    
        Currently only dense matrix format supported. Sparse format to be added.
    """
    n_x = model._n_real_x.value
    n_u = model._n_real_u.value
    n_w = model._n_real_w.value
    n_z = model._n_z.value
    n_eq = n_x+n_w
    sc = model.jmimodel.get_variable_scaling_factors()
    
    if model.jmimodel.get_scaling_method() == jmi.JMI_SCALING_VARIABLES:
        sc_dx = []
        for var in model.get_dx_variable_names():
            if not model._get_XMLDoc().is_alias(var[1]):
                sc_dx.append(var[0])
        sc_dx = N.diag([1.0/sc[jmi._translate_value_ref(ref)[0]] for ref in sorted(set(sc_dx))])
        sc_x = []
        for var in model.get_x_variable_names():
            if not model._get_XMLDoc().is_alias(var[1]):
                sc_x.append(var[0])
        sc_x = N.diag([1.0/sc[jmi._translate_value_ref(ref)[0]] for ref in sorted(set(sc_x))])
        sc_w = []
        for var in model.get_w_variable_names():
            if not model._get_XMLDoc().is_alias(var[1]):
                sc_w.append(var[0])
        sc_w = N.diag([1.0/sc[jmi._translate_value_ref(ref)[0]] for ref in sorted(set(sc_w))])
        sc_u = []
        for var in model.get_u_variable_names():
            if not model._get_XMLDoc().is_alias(var[1]):
                sc_u.append(var[0])
        sc_u = N.diag([1.0/sc[jmi._translate_value_ref(ref)[0]] for ref in sorted(set(sc_u))])
    else:
        sc_dx = N.diag([1.0]*n_x)
        sc_x = N.diag([1.0]*n_x)
        sc_w = N.diag([1.0]*n_w)
        sc_u = N.diag([1.0]*n_u)
    #sc_dx = N.diag([sc[jmi._translate_value_ref(ref)[0]] for ref in sorted(set([var[0] for var in model.get_dx_variable_names()]))])
    #sc_x  = N.diag([sc[jmi._translate_value_ref(ref)[0]] for ref in sorted(set([var[0] for var in model.get_x_variable_names()]))])
    #sc_w  = N.diag([sc[jmi._translate_value_ref(ref)[0]] for ref in sorted(set([var[0] for var in model.get_w_variable_names()]))])
    #sc_u  = N.diag([sc[jmi._translate_value_ref(ref)[0]] for ref in sorted(set([var[0] for var in model.get_u_variable_names()]))])
    
    E = N.zeros((n_eq*n_x))

    model.jmimodel.dae_dF(jmi.JMI_DER_CPPAD,
                          jmi.JMI_DER_DENSE_ROW_MAJOR,
                          jmi.JMI_DER_DX,
                          N.ones(n_z,dtype=int),
                          E)
    
    E = N.dot(N.reshape(E,(n_eq,n_x)),sc_dx)
    
    A = N.zeros((n_eq*n_x))
    
    model.jmimodel.dae_dF(jmi.JMI_DER_CPPAD,
                          jmi.JMI_DER_DENSE_ROW_MAJOR,
                          jmi.JMI_DER_X,
                          N.ones(n_z,dtype=int),
                          A)
    
    A = N.dot(-N.reshape(A,(n_eq,n_x)),sc_x)
    
    B = N.zeros((n_eq*n_u))
    
    model.jmimodel.dae_dF(jmi.JMI_DER_CPPAD,
                          jmi.JMI_DER_DENSE_ROW_MAJOR,
                          jmi.JMI_DER_U,
                          N.ones(n_z,dtype=int),
                          B)
    
    B = N.dot(-N.reshape(B,(n_eq,n_u)),sc_u)
    
    F = N.zeros((n_eq*n_w))
    
    model.jmimodel.dae_dF(jmi.JMI_DER_CPPAD,
                          jmi.JMI_DER_DENSE_ROW_MAJOR,
                          jmi.JMI_DER_W,
                          N.ones(n_z,dtype=int),
                          F)
    
    F = N.dot(-N.reshape(F,(n_eq,n_w)),sc_w)
    
    g = N.zeros(n_eq)
    
    model.jmimodel.dae_F(g)
    
    g = -N.transpose(N.matrix(g))

    state_names = model.get_x_variable_names(include_alias=False)
    #state_names = sorted([(v,k) for k,v in state_names.items()])
    state_names = sorted(state_names)
    state_names = [state_names[i][1] for i in range(len(state_names))]
    algebraic_names = model.get_w_variable_names(include_alias=False)
    #algebraic_names = sorted([(v,k) for k,v in algebraic_names.items()])
    algebraic_names = sorted(algebraic_names)
    algebraic_names = [algebraic_names[i][1] for i in range(len(algebraic_names))]
    input_names = model.get_u_variable_names(include_alias=False)
    input_names = sorted(input_names)
    #input_names = sorted([(v,k) for k,v in input_names.items()])
    input_names = [input_names[i][1] for i in range(len(input_names))]

    dx0 = N.zeros(n_x)
    x0 = N.zeros(n_x)
    u0 = N.zeros(n_u)
    w0 = N.zeros(n_w)
    t0 = N.zeros(1)

    dx0[:] = model.jmimodel.get_real_dx()*1/N.diag(sc_dx)#model.variable_scaling_factors[model._offs_real_dx.value:model._offs_real_dx.value+n_x]
    x0[:] = model.jmimodel.get_real_x()*1/N.diag(sc_x)#model.variable_scaling_factors[model._offs_real_x.value:model._offs_real_x.value+n_x]
    u0[:] = model.jmimodel.get_real_u()*1/N.diag(sc_u)#*model.variable_scaling_factors[model._offs_real_u.value:model._offs_real_u.value+n_u]
    w0[:] = model.jmimodel.get_real_w()*1/N.diag(sc_w)#*model.variable_scaling_factors[model._offs_real_w.value:model._offs_real_w.value+n_w]
    t0[:] = model.jmimodel.get_t()
    t0 = t0[0]
    
    return E,A,B,F,g,state_names,input_names,algebraic_names,dx0,x0,u0,w0,t0

def linear_dae_to_ode(E_dae,A_dae,B_dae,F_dae,g_dae):
    """ 
    Transform a linear constant coefficient index-1 DAE to ODE form. The DAE is 
    given by the system

      E_dae*dx = A_dae*x + B_dae*u + F_dae*w + g_dae

    where the matrix [E_dae,F_dae] is assumed to have full rank.

    The DAE is transformed into the ODE system

      dx = A*x + B*u + g
       w = H*x + M*u + q
       
    Parameters::
    
        E_dae -- 
        
        A_dae -- 
        
        B_dae -- 
        
        F_dae -- 
        
        g_dae -- 

    Returns::
    
        A -- 
            n_x x n_x matrix of constant coefficients.
            
        B -- 
            n_x x n_u matrix of constant coefficients.
            
        g -- 
            n_x x 1 matrix of constant coefficients.
            
        H -- 
            n_w x n_x matrix of constant coefficients.
            
        M -- 
            n_w x n_u matrix of constant coefficients.
            
        q -- 
            n_w x 1 matrix of constant coefficients
        
    Limitations::
    
        Outputs in the Modelica model are currently not taken into account - all 
        algebraic variables are provided as outputs. 
    """
    
    n_x = N.size(A_dae,1)
    n_u = N.size(B_dae,1)
    n_w = N.size(F_dae,1)

    EE = N.hstack((E_dae,-F_dae))
    AH = N.linalg.solve(EE,A_dae)
    BM = N.linalg.solve(EE,B_dae)
    gq = N.linalg.solve(EE,g_dae)

    A = AH[0:n_x,:]
    H = AH[n_x:,:]
    B = BM[0:n_x,:]
    M = BM[n_x:,:]
    g = gq[0:n_x,:]
    q = gq[n_x:,:]

    return A,B,g,H,M,q

def linearize_ode(model):
    """ 
    Linearize a DAE represented by a pyjmi.jmi.JMUModel object. The DAE is 
    represented by

      F(dx,x,u,w,t) = 0

    and the linearized model is given by

      dx = A*x + B*u + g
       w = H*x + M*u + q

    The linearization is performed performed by first linearizing the DAE using 
    pyjmi.linearization.linearize_dae and the resulting linear DAE is then 
    transformed into an ODE by the function 
    pyjmi.linearization.linear_dae_to_ode.

    Notice that the conversion into ODE form works only if the linear DAE has 
    index 1.
    
    Parameters::
    
        model --
            The jmi.JMUModel object representing the model.

    Returns::
    
        A -- 
            n_x x n_x matrix of constant coefficients.
            
        B -- 
            n_x x n_u matrix of constant coefficients.
            
        g -- 
            n_x x 1 matrix of constant coefficients.
            
        H -- 
            n_w x n_x matrix of constant coefficients.
            
        M -- 
            n_w x n_u matrix of constant coefficients.
            
        q -- 
            n_w x 1 matrix of constant coefficients.
            
        state_names -- 
            Names of the differential variables.
            
        input_names -- 
            Names of the input variables.
            
        algebraic_names -- 
            Names of the algebraic variables.
            
        dx0 -- 
            Derivative variable vector around which the linearization is done.
            
        x0 -- 
            Differential variable vector around which the linearization is done.
            
        u0 -- 
            Input variable vector around which the linearization is done.
            
        w0 -- 
            Algebraic variable vector around which the linearization is done.
            
        t0 -- 
            Time for which the linearization is done.  

    Limitations::
    
        Outputs in the Modelica model are currently not taken into account - all 
        algebraic variables are provided as outputs.         
    """

    E_dae_jmi,A_dae_jmi,B_dae_jmi,F_dae_jmi,g_dae_jmi,\
    state_names,input_names,algebraic_names,\
    dx0,x0,u0,w0,t0 = linearize_dae(model)

    A,B,g,H,M,q = linear_dae_to_ode(
        E_dae_jmi,A_dae_jmi,B_dae_jmi,F_dae_jmi,g_dae_jmi)

    return A,B,g,H,M,q,state_names,input_names,algebraic_names,dx0,x0,u0,w0,t0
