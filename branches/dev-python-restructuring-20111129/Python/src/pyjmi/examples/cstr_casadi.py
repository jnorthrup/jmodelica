#!/usr/bin/env python 
# -*- coding: utf-8 -*-

# Copyright (C) 2011 Modelon AB
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, version 3 of the License.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program. If not, see <http://www.gnu.org/licenses/>.

# Import library for path manipulations
import os.path

# Import numerical libraries
import numpy as N
import matplotlib.pyplot as plt

# Import the JModelica.org Python packages
from jmodelica.compiler import compile_fmux
from pyjmi.casadi_interface import CasadiModel

def run_demo(with_plots=True):
    """
    Demonstrate how to optimize a CSTR using CasadiRadau2.
    """
    # Compile and load model
    curr_dir = os.path.dirname(os.path.abspath(__file__));
    jn = compile_fmux("CSTR.CSTR_Opt2", curr_dir+"/files/CSTR.mop")
    model = CasadiModel(jn)
    
    # Set algorithm options
    opts = model.optimize_options(algorithm="LocalDAECollocationAlg")
    opts['graph'] = "SX"
    
    # Optimize
    res = model.optimize(algorithm="LocalDAECollocationAlg", options=opts)
    
    # Extract variable profiles
    c = res['cstr.c']
    T = res['cstr.T']
    Tc = res['cstr.Tc']
    time = res['time']
    
    # Plot
    if with_plots:    
        plt.figure(1)
        plt.clf()
        plt.subplot(3, 1, 1)
        plt.plot(time, c)
        plt.grid(True)
        
        plt.subplot(3, 1, 2)
        plt.plot(time, T)
        plt.grid(True)
        
        plt.subplot(3, 1, 3)
        plt.plot(time, Tc)
        plt.grid(True)
        plt.show()

if __name__=="__main__":
    run_demo()
