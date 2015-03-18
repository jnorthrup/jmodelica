#!/usr/bin/env python 
# -*- coding: utf-8 -*-

# Copyright (C) 2015 Modelon AB
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

"""Tests warm starting optimization functionality for the casadi_collocation module."""

import os
from collections import OrderedDict
import numpy as N
from tests_jmodelica import testattr, get_files_path
from pyjmi import transfer_optimization_problem
from pyjmi.optimization.casadi_collocation import ExternalData

def set_warm_start_options(solver, push=1e-4, mu_init=1e-1):    
    solver.set_solver_option('IPOPT', 'warm_start_init_point', 'yes')
    solver.set_solver_option('IPOPT', 'mu_init', mu_init)

    solver.set_solver_option('IPOPT', 'warm_start_bound_push', push)
    solver.set_solver_option('IPOPT', 'warm_start_mult_bound_push', push)
    solver.set_solver_option('IPOPT', 'warm_start_bound_frac', push)
    solver.set_solver_option('IPOPT', 'warm_start_slack_bound_frac', push)
    solver.set_solver_option('IPOPT', 'warm_start_slack_bound_push', push)

def result_distance(res1, res2, names):
    assert N.array_equal(res1['time'], res2['time'])
    return max([N.max(N.abs(res1[name] - res2[name])) for name in names])

@testattr(casadi = True)
def test_warm_start():
    file_path = os.path.join(get_files_path(), 'Modelica', 'VDP.mop')
    op = transfer_optimization_problem("VDP_pack.VDP_Opt2", file_path)

    opts = op.optimize_options()
    var_names = ('x1', 'x2', 'u')
    
    
    # Optimize without going through prepare_optimization
    op.set('p1', 1) # Should already be set to 1
    res1c = op.optimize(options=opts)
    assert res1c.final('p1') == 1
    
    op.set('p1', 2)
    res2c = op.optimize(options=opts)
    assert res2c.final('p1') == 2

    # Make sure that the parameter changes have an effect
    assert result_distance(res1c, res2c, var_names) > 1e-2

    
    # Optimize through prepare_optimization
    solver = op.prepare_optimization(options=opts)
    assert solver.get('p1') == 2 # Should reflect setting in op when prepare_optimization was done

    solver.set('p1', 1)
    assert solver.get('p1') == 1
    res1w = solver.optimize()
    assert res1w.final('p1') == 1
    assert result_distance(res1c, res1w, var_names) < 1e-6
    res1w_stats = res1w.get_solver_statistics()
 
    solver.set('p1', 2)
    assert solver.get('p1') == 2
    solver.set_warm_start(True)    
    set_warm_start_options(solver, push = 1e-5)

    res2w = solver.optimize()
    assert res2w.final('p1') == 2
    assert result_distance(res2c, res2w, var_names) < 1e-6

    res2w2 = solver.optimize()
    assert res2w2.final('p1') == 2
    assert result_distance(res2c, res2w2, var_names) < 1e-6

    # Check that the results haven't changed
    assert result_distance(res1c, res1w, var_names) < 1e-6
    assert result_distance(res2c, res2w, var_names) < 1e-6
    assert result_distance(res2c, res2w2, var_names) < 1e-6
    assert res1w_stats == res1w.get_solver_statistics()
    
    # Check that warm starting helps convergence speed
    # Warm starting should not need too many iterations
    assert res2w.get_solver_statistics()[1] < 40
    # Warm starting from the right result should need very few iterations
    assert res2w2.get_solver_statistics()[1] < 4

def check_changed_input(model_name, signal_name, ext_data_constructor, eliminate_algebraics=False,
        result_mode='collocation_points'):
    file_path = os.path.join(get_files_path(), 'Modelica', 'DisturbedIntegrator.mop')
    
    if eliminate_algebraics:
        compiler_options={'equation_sorting':True, 'automatic_tearing':False}
    else:
        compiler_options={}
    op = transfer_optimization_problem(model_name, file_path, compiler_options=compiler_options)    
    if eliminate_algebraics:
        op.eliminateAlgebraics()

    var_names = ('x', 'u', 'xdot')

    input1 = OrderedDict()
    data1 = N.vstack([[0, 1], [0, 1]])
    input1[signal_name] = data1
    opts1 = op.optimize_options()
    opts1['external_data'] = ext_data_constructor(input1)
    opts1['result_mode'] = result_mode

    input2 = OrderedDict()
    data2 = N.vstack([[0, 1], [1, 0]])
    input2[signal_name] = data2
    opts2 = op.optimize_options()
    opts2['external_data'] = ext_data_constructor(input2)
    opts2['result_mode'] = result_mode

    solver = op.prepare_optimization(options=opts1)
    res1 = solver.optimize()

    solver.set_external_variable_data(signal_name, data2)
    res2b = solver.optimize()

    res2 = op.optimize(options=opts2)

    assert result_distance(res1, res2, var_names) > 1e-2
    assert result_distance(res2, res2b, var_names) < 1e-6

@testattr(casadi = True)
def test_change_eliminated_input(eliminate_algebraics=False, result_mode='collocation_points'):
    check_changed_input('DisturbedIntegrator', 'w',
        (lambda input:ExternalData(eliminated=input)),
        eliminate_algebraics, result_mode)

@testattr(casadi = True)
def test_change_constrained_input(eliminate_algebraics=False):
    check_changed_input('DisturbedIntegrator', 'w',
        (lambda input:ExternalData(constr_quad_pen=input, Q = N.atleast_2d(1))),
        eliminate_algebraics)

@testattr(casadi = True)
def test_change_quad_pen_input(eliminate_algebraics=False):
    check_changed_input('Integrator', 'u',
        (lambda input:ExternalData(quad_pen=input, Q = N.atleast_2d(1))),
        eliminate_algebraics)

@testattr(casadi = True)
def test_change_eliminated_input_with_elim():
    test_change_eliminated_input(True)
@testattr(casadi = True)
def test_change_constrained_input_with_elim():
    test_change_constrained_input(True)
@testattr(casadi = True)
def test_change_quad_pen_input_with_elim():
    test_change_quad_pen_input(True)

@testattr(casadi = True)
def test_change_eliminated_input_element_interpolation():
    test_change_eliminated_input(result_mode = 'element_interpolation')
@testattr(casadi = True)
def test_change_eliminated_input_mesh_points():
    test_change_eliminated_input(result_mode = 'mesh_points')
