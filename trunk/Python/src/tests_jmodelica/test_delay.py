#!/usr/bin/env python 
# -*- coding: utf-8 -*-

# Copyright (C) 2014 Modelon AB
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

"""Tests for delay simulation."""

import numpy as N

from tests_jmodelica.general.base_simul import *
from tests_jmodelica import testattr, get_files_path


compiler_options={'compliance_as_warning':True}

path_to_mos = os.path.join(get_files_path(), 'Modelica')
path_to_mo  = os.path.join(path_to_mos, 'TestDelay.mo')

def compile_and_load(class_name):
    fmu_name = compile_fmu(class_name, path_to_mo, compiler_options=compiler_options)
    return load_fmu(fmu_name) 

def simulate(fmu, final_time, maxh = None):
    opts = fmu.simulate_options()      
    opts['solver'] = 'CVode'           
    if maxh is not None:
        opts['CVode_options']['maxh'] = maxh

    res = fmu.simulate(final_time = final_time, options = opts)
    return res

def compile_and_simulate(class_name, final_time, maxh = None):    
    fmu = compile_and_load(class_name)
    return simulate(fmu, final_time, maxh)

def assert_close(x, y, abstol):
    assert len(x) == len(y)
    d = N.abs(x-y).max()
    assert d <= abstol, ("Signals differ by " + str(d) + " which is more than abstol = " + str(abstol) )


@testattr(stddist = True)
def test_delay_time():
    res = compile_and_simulate('TestDelayTime', final_time = 5, maxh = 0.5)
    t, x = res['time'], res['x']
    x_expected = N.maximum(0, t-1)
    assert_close(x, x_expected, 1e-8)

@testattr(stddist = True)
def test_delay_quadratic():
    fmu = compile_and_load('TestDelayQuadratic')
    res = simulate(fmu, final_time = 5, maxh = 0.5)
    t, x = res['time'], res['x']
    x_expected = N.maximum(0, t-1)**2 + 1

    assert_close(x, x_expected, 1e-3)

    fmu.reset()
    res = simulate(fmu, final_time = 5, maxh = 1/2.5)
    t, x = res['time'], res['x']
    x_expected = N.maximum(0, t-1)**2 + 1

    assert_close(x, x_expected, 0.1)

@testattr(stddist = True)
def test_integrate_delayed_time():
    res = compile_and_simulate('TestIntegrateDelayedTime', final_time = 5)
    t, x = res['time'], res['x']
    x_expected = N.maximum(0, t-1)**2/2
    assert_close(x, x_expected, 1e-4)

@testattr(stddist = True)
def test_integrate_delayed_quadratic():
    res = compile_and_simulate('TestIntegrateDelayedQuadratic', final_time = 5)
    t, x = res['time'], res['x']
    x_expected = N.maximum(0,t-1)**3/3
    assert_close(x, x_expected, 0.2)

@testattr(stddist = True)
def test_sinusoid():
    res = compile_and_simulate('TestSinusoid', final_time = 20)
    t, x = res['time'], res['x']
    x_expected = 1.03*N.cos((t+0.35)*N.pi/2)
    inds = (t >= 0.5)
    assert_close(x[inds], x_expected[inds], 0.1)

@testattr(stddist = True)
def test_sinusoid_noevent():
    # Check that we get the same answer as above with noEvent
    res = compile_and_simulate('TestSinusoidNoEvent', final_time = 20)
    t, x = res['time'], res['x']
    x_expected = 1.03*N.cos((t+0.35)*N.pi/2)
    inds = (t >= 0.5)
    assert_close(x[inds], x_expected[inds], 0.1)

@testattr(stddist = True)
def test_short_delay():
    fmu = compile_and_load('TestShortDelay')
    fmu.set('d', 1e-3)
    res = simulate(fmu, final_time = 5)
    t, x = res['time'], res['x']
    x_expected = N.exp(-t)

    assert_close(x, x_expected, 1e-3)
    assert len(t) < 200

    fmu.reset()
    fmu.set('d', 0)
    res = simulate(fmu, final_time = 5)
    t, x = res['time'], res['x']
    x_expected = N.exp(-t)

    assert_close(x, x_expected, 1e-3)
    assert len(t) < 200

@testattr(stddist = True)
def test_sinusoid():
    res = compile_and_simulate('TestCommute', final_time = 10, maxh = 1/5.5)
    t, x_delay, delay_x = res['time'], res['x_delay'], res['delay_x']
    x_expected = N.cos(N.maximum(0,t-1))
    assert_close(x_delay, x_expected, 1e-2)
    assert_close(delay_x, x_expected, 1e-2)

@testattr(stddist = True)
def test_repeating_events():
    fmu = compile_and_load('TestRepeatingEvents')

    for (k, d) in enumerate([1.0, N.nextafter(1.0, 0), N.nextafter(1.0, 2)]):
        if k > 0: fmu.reset()

        fmu.set('d', d)
        res = simulate(fmu, final_time = 5.5, maxh = 1/2.5)  
        t, x = res['time'], res['x']
        x_expected = N.mod(t, d)
        (inds,) = N.nonzero(N.diff(t) == 0)
        x_expected[inds] = d
        x_expected[inds+1] = 0

        assert_close(t[inds], [1,2,3,4,5], 1e-15)
        assert_close(x, x_expected, 1e-8)

@testattr(stddist = True)
def test_repeat_noevent():
    res = compile_and_simulate('TestRepeatNoEvent', final_time = 5.5, maxh = 1/10.5)
    t, x = res['time'], res['x']
    x_expected = N.mod(t, 1)
    (inds,) = N.nonzero(N.diff(t) == 0)
    x_expected[inds] = 1
    x_expected[inds+1] = 0

    assert len(inds) == 1
    assert N.abs(t[inds]-[1]) <= 1e-8
    assert sum(N.abs(x-x_expected) > 1e-8) <= 6

@testattr(stddist = True)
def test_variably_delayed_time():
    res = compile_and_simulate('TestVariablyDelayedTime', final_time = 5, maxh = 0.1)
    t, x = res['time'], res['x']
    x_expected = N.maximum(0,t-(N.sin(5*t)*0.5+0.5))
    assert_close(x, x_expected, 1e-8)

@testattr(stddist = True)
def test_state_dependent_delay_time():
    res = compile_and_simulate('TestStateDependentDelay', final_time = 0.75, maxh = 0.1)
    t, x = res['time'], res['x']
    x_expected = 1-t
    x_expected2 = t-2+2*N.exp(0.5-t)
    x_expected[t > 0.5] = x_expected2[t > 0.5]
    assert_close(x, x_expected, 1e-3)

@testattr(stddist = True)
def test_delay_starting_at_zero():
    res = compile_and_simulate('TestDelayStartingAtZero', final_time = 5, maxh = 0.1)
    t, x = res['time'], res['x']
    x_expected = N.exp(-t)
    assert_close(x, x_expected, 1e-2)

@testattr(stddist = True)
def test_delay_starting_at_zero_no_event():
    # Check that we get the same answer as above with noEvent
    res = compile_and_simulate('TestDelayStartingAtZeroNoEvent', final_time = 5, maxh = 0.1)
    t, x = res['time'], res['x']
    x_expected = N.exp(-t)
    assert_close(x, x_expected, 1e-2)

@testattr(stddist = True)
def test_variable_delay_events():
    res = compile_and_simulate('TestVariableDelayEvents', final_time = 4, maxh = 0.1)
    t, x = res['time'], res['x']
    (inds,) = N.nonzero(N.diff(t) == 0)
    x_expected = t-(N.cos(5*t)+1) > 1
    x_expected[inds]   = x_expected[inds-1]
    x_expected[inds+1] = x_expected[inds+2]
    print x_expected+0
    print N.asarray(x, dtype=int)
    print t
    assert_close(x, x_expected, 1e-12)
    assert_close(t[inds], N.array([ 1., 1.64366485, 2.24956004, 2.67833465]), 1e-7)

@testattr(stddist = True)
def test_delay_going_to_zero():
    res = compile_and_simulate('TestDelayGoingToZero', final_time = 2, maxh = 0.1)
    t, x = res['time'], res['x']
    x_expected = 0.22981923*N.exp(1-t)    
    assert_close(x[t >= 1], x_expected[t >= 1], 1e-3)

@testattr(stddist = True)
def test_zeno_repeat():
    res = compile_and_simulate('TestZenoRepeat', final_time = 2, maxh = 0.1)
    t, x = res['time'], res['x']
    (sw,)=N.nonzero(N.diff(t) == 0)
    (nosw,)=N.nonzero(N.diff(t) > 0)
    assert all((x==0) | (x == 1))
    assert all(x[nosw]==x[nosw+1])
    assert all((x[sw]!=x[sw+1]) | (N.abs(t[sw]-1)<1e-7))
    tau = 1-t[sw]
    assert_close(tau[1:], N.sqrt(0.5)*tau[0:-1], 1e-7)

@testattr(stddist = True)
def test_zeno_repeat_noevent():
    res = compile_and_simulate('TestZenoRepeatNoEvent', final_time = 0.75, maxh = 1/20.5)
    t, x = res['time'], res['x']
    xe1 = N.mod(N.log2(1-(t-1e-8)),1) > 0.5;
    xe2 = N.mod(N.log2(1-(t+1e-8)),1) > 0.5;
    (inds,) = N.nonzero(N.diff(t) == 0)

    assert_close(t[inds], [0, 1-N.sqrt(0.5)], 1e-7)
    assert all(N.minimum(xe1, xe2) <= x)
    assert all(x <= N.maximum(xe1, xe2))
