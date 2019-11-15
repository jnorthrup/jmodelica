#!/usr/bin/env python 
# -*- coding: utf-8 -*-

# Copyright (C) 2019 Modelon AB
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

""" 
Test module for testing the core module. 
"""

import os, os.path
import sys
import numpy as np

from tests_jmodelica import testattr, get_files_path
from pyfmi.common.core import *


class Test_TrajectoryConstantInterpolationExtrapolation:
    
    def _assert(self, result, expected, assert_index, n_asserts):
        err_msg = "Failed in assert {} of {}, got {} instead of {}".format(result, expected, assert_index, n_asserts)
        assert result == expected, err_msg

    @testattr(stddist_full = True)
    def test_one_dimensional(self):
        t = np.array([1,2,3,4,5])
        x = np.array([[2,2.5,4,5,9]]).transpose()
        
        interp = TrajectoryConstantInterpolationExtrapolation(t,x)
        
        n_tests = 16
        self._assert(interp.eval(0)[:,0], 2.0, 1, n_tests)
        self._assert(interp.eval(6)[:,0], 9.0, 2, n_tests)
        self._assert(interp.eval(1.5)[:,0], 2.0, 3, n_tests)
        self._assert(interp.eval(2.6)[:,0], 2.5, 4, n_tests)
        
        self._assert(interp.eval([0, 1.5, 2.6, 6])[0,0], 2.0, 5, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[1,0], 2.0, 6, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[2,0], 2.5, 7, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[3,0], 9.0, 8, n_tests)
        
        #Change mode
        interp.set_mode("Backward")
        
        self._assert(interp.eval(0)[:,0], 2.0, 9, n_tests)
        self._assert(interp.eval(6)[:,0], 9.0, 10, n_tests)
        self._assert(interp.eval(1.5)[:,0], 2.5, 11, n_tests)
        self._assert(interp.eval(2.6)[:,0], 4.0, 12, n_tests)
        
        self._assert(interp.eval([0, 1.5, 2.6, 6])[0,0], 2.0, 13, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[1,0], 2.5, 14, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[2,0], 4.0, 15, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[3,0], 9.0, 16, n_tests)
        
    @testattr(stddist_full = True)
    def test_two_dimensional(self):
        t = np.array([1,2,3,4,5])
        x = np.array([[2,2.5,4,5,9], [1,1.5,3,4,8]]).transpose()
        
        interp = TrajectoryConstantInterpolationExtrapolation(t,x)
        
        n_tests = 31
        self._assert(interp.eval(0)[0,0], 2.0, 1, n_tests)
        self._assert(interp.eval(6)[0,0], 9.0, 2, n_tests)
        self._assert(interp.eval(1.5)[0,0], 2.0, 3, n_tests)
        self._assert(interp.eval(2.6)[0,0], 2.5, 3, n_tests)
        self._assert(interp.eval(0)[0,1], 1.0, 4, n_tests)
        self._assert(interp.eval(6)[0,1], 8.0, 5, n_tests)
        self._assert(interp.eval(1.5)[0,1], 1.0, 6, n_tests)
        self._assert(interp.eval(2.6)[0,1], 1.5, 7, n_tests)
        
        self._assert(interp.eval([0, 1.5, 2.6, 6])[0,0], 2.0, 8, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[1,0], 2.0, 9, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[2,0], 2.5, 10, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[3,0], 9.0, 11, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[0,1], 1.0, 12, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[1,1], 1.0, 13, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[2,1], 1.5, 14, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[3,1], 8.0, 15, n_tests)
        
        #Change mode
        interp.set_mode("Backward")
        
        self._assert(interp.eval(0)[0,0], 2.0, 16, n_tests)
        self._assert(interp.eval(6)[0,0], 9.0, 17, n_tests)
        self._assert(interp.eval(1.5)[0,0], 2.5, 18, n_tests)
        self._assert(interp.eval(2.6)[0,0], 4.0, 19, n_tests)
        self._assert(interp.eval(0)[0,1], 1.0, 20, n_tests)
        self._assert(interp.eval(6)[0,1], 8.0, 21, n_tests)
        self._assert(interp.eval(1.5)[0,1], 1.5, 22, n_tests)
        self._assert(interp.eval(2.6)[0,1], 3.0, 23, n_tests)
        
        self._assert(interp.eval([0, 1.5, 2.6, 6])[0,0], 2.0, 24, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[1,0], 2.5, 25, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[2,0], 4.0, 26, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[3,0], 9.0, 27, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[0,1], 1.0, 28, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[1,1], 1.5, 29, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[2,1], 3.0, 30, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[3,1], 8.0, 31, n_tests)


class Test_TrajectoryLinearInterpolationExtrapolation:
    
    def _assert(self, result, expected, assert_index, n_asserts):
        err_msg = "Failed in assert {} of {}, got {} instead of {}".format(result, expected, assert_index, n_asserts)
        assert result == expected, err_msg
    
    @testattr(stddist_full = True)
    def test_one_dimensional(self):
        
        t = np.array([1,2,3,4,5])
        x = np.array([[2,2.5,4,5,9]]).transpose()
        
        interp = TrajectoryLinearInterpolationExtrapolation(t,x)
        n_tests = 8
        self._assert(interp.eval(0)[:,0], 1.5, 1, n_tests)
        self._assert(interp.eval(6)[:,0], 13.0, 2, n_tests)
        self._assert(interp.eval(1.5)[:,0], 2.25, 3, n_tests)
        np.testing.assert_almost_equal(interp.eval(2.6)[:,0], 3.4)
        
        self._assert(interp.eval([0, 1.5, 2.6, 6])[0,0], 1.5, 5, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[1,0], 2.25, 6, n_tests)
        np.testing.assert_almost_equal(interp.eval([0, 1.5, 2.6, 6])[2,0], 3.4)
        np.testing.assert_almost_equal(interp.eval([0, 1.5, 2.6, 6])[3,0],13.0)
        
    @testattr(stddist_full = True)
    def test_two_dimensional(self):
        t = np.array([1,2,3,4,5])
        x = np.array([[2,2.5,4,5,9], [1,1.5,3,4,8]]).transpose()
        
        interp = TrajectoryLinearInterpolationExtrapolation(t,x)
        
        n_tests = 16
        self._assert(interp.eval(0)[:,0], 1.5, 1, n_tests)
        self._assert(interp.eval(6)[:,0], 13.0, 1, n_tests)
        self._assert(interp.eval(1.5)[:,0], 2.25, 1, n_tests)
        np.testing.assert_almost_equal(interp.eval(2.6)[:,0],3.4)
        self._assert(interp.eval(0)[:,1], 0.5, 1, n_tests)
        self._assert(interp.eval(6)[:,1], 12.0, 1, n_tests)
        self._assert(interp.eval(1.5)[:,1], 1.25, 1, n_tests)
        np.testing.assert_almost_equal(interp.eval(2.6)[:,1],2.4)
        
        self._assert(interp.eval([0, 1.5, 2.6, 6])[0,0], 1.5, 1, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[1,0], 2.25, 1, n_tests)
        np.testing.assert_almost_equal(interp.eval([0, 1.5, 2.6, 6])[2,0],3.4)
        np.testing.assert_almost_equal(interp.eval([0, 1.5, 2.6, 6])[3,0],13.0)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[0,1], 0.5, 1, n_tests)
        self._assert(interp.eval([0, 1.5, 2.6, 6])[1,1], 1.25, 1, n_tests)
        np.testing.assert_almost_equal(interp.eval([0, 1.5, 2.6, 6])[2,1],2.4)
        np.testing.assert_almost_equal(interp.eval([0, 1.5, 2.6, 6])[3,1],12.0)
