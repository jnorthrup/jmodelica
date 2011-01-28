#!/usr/bin/env python 
# -*- coding: utf-8 -*-

# Copyright (C) 2010 Modelon AB
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
from jmodelica.jmi import compile_jmu

from jmodelica.io import ResultDymolaTextual

from jmodelica.optimization.casadi_collocation import XMLOCP
from jmodelica.optimization.casadi_collocation import RadauCollocator

def run_demo(with_plots=True):
    """
    Demonstrate how to solve a dynamic optimization problem based on a Van der 
    Pol oscillator system.
    """

    curr_dir = os.path.dirname(os.path.abspath(__file__));

    jn = compile_jmu("VDP_pack.VDP_Opt2", curr_dir+"/files/VDP.mop",compiler_options={'generate_xml_equations':True})

    #xml_file_name = unzip_unit(archive='./CSTR_CSTR_Opt2.jmu')[1]
    os.system("unzip ./VDP_pack_VDP_Opt2.jmu")
    xmlmodel = XMLOCP("modelDescription.xml")
    be_colloc = RadauCollocator(xmlmodel,50,3)
    be_colloc.solve()
    be_colloc.write_result()

    res = ResultDymolaTextual('VDP_pack.VDP_Opt2'+'_result.txt')

    # Extract variable profiles
    x1 = res.get_variable_data('x1')
    x2 = res.get_variable_data('x2')
    u = res.get_variable_data('u')
    cost = res.get_variable_data('cost')
    
    #assert N.abs(cost.x[-1] - 2.3469089e+01) < 1e-3, \
    #        "Wrong value of cost function in vdp.py"  

    if with_plots:
        # Plot
        plt.figure(1)
        plt.clf()
        plt.subplot(311)
        plt.plot(x1.t,x1.x)
        plt.grid()
        plt.ylabel('x1')
        
        plt.subplot(312)
        plt.plot(x2.t,x2.x)
        plt.grid()
        plt.ylabel('x2')
        
        plt.subplot(313)
        plt.plot(cost.t,cost.t)
        plt.grid()
        plt.ylabel('u')
        plt.xlabel('time')
        plt.show()

if __name__ == "__main__":
    run_demo()

