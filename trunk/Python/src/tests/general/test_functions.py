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

from tests.general.base_simul import *
from tests import testattr

class TestFunction1(SimulationTest):
    """
    Basic test of Modelica functions.
    """

    @classmethod
    def setUpClass(cls):
        SimulationTest.setup_class_base('FunctionTests.mo', 
            'FunctionTests.FunctionTest1')

    @testattr(assimulo = True)
    def setUp(self):
        self.setup_base(start_time=0.0, final_time=2.0, time_step=0.01)
        self.run()
        self.load_expected_data('FunctionTest1+2_res.txt')

    @testattr(assimulo = True)
    def test_trajectories(self):
        """
        Test that results match the expected ones.
        """
        self.assert_all_trajectories(['pi', 'tau', 'gpi', 'gtau'])


class TestFunction2(SimulationTest):
    """
    Test of Modelica functions with arrays.
    """

    @classmethod
    def setUpClass(cls):
        SimulationTest.setup_class_base('FunctionTests.mo', 
            'FunctionTests.FunctionTest2')

    @testattr(assimulo = True)
    def setUp(self):
        self.setup_base(start_time=0.0, final_time=2.0, time_step=0.01)
        self.run()
        self.load_expected_data('FunctionTest1+2_res.txt')

    @testattr(assimulo = True)
    def test_trajectories(self):
        """
        Test that results match the expected ones.
        """
        self.assert_all_trajectories(['pi', 'tau', 'gpi', 'gtau'])


class TestIntegerArg1(SimulationTest):
    """
    Test of Modelica functions with Integer variables.
    """

    @classmethod
    def setUpClass(cls):
        SimulationTest.setup_class_base('FunctionTests.mo', 
            'FunctionTests.IntegerArg1')

    @testattr(assimulo = True)
    def setUp(self):
        self.setup_base(start_time=0.0, final_time=0.1, time_step=0.01)
        self.run()

    @testattr(assimulo = True)
    def test_result(self):
        """
        Test that results match the expected ones.
        """
        self.assert_end_value('x', 4.0)
