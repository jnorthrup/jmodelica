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

from tests_jmodelica import testattr
class TestAssimuloImports:
    def _err_msg(self, exception):
        return "Exception raised during import:\n{}: {}".format(type(exception).__name__, str(exception))
    
    def _test_import(self, modulename):
        try:
            __import__(modulename)
        except Exception as e:
            return True, e
        return False, None

    @testattr(stddist_full = True)
    def test_import_lib_glimda(self):
        """Test import assimulo.lib.glimda"""
        raised_exception, exception = self._test_import("assimulo.lib.glimda")
        assert not raised_exception, self._err_msg(exception)

    @testattr(stddist_full = True)
    def test_import_lib_dasp3dp(self):
        """Test import assimulo.lib.dasp3dp"""
        raised_exception, exception = self._test_import("assimulo.lib.dasp3dp")
        assert not raised_exception, self._err_msg(exception)

    @testattr(stddist_full = True)
    def test_import_lib_odassl(self):
        """Test import assimulo.lib.odassl"""
        raised_exception, exception = self._test_import("assimulo.lib.odassl")
        assert not raised_exception, self._err_msg(exception)

    @testattr(stddist_full = True)
    def test_import_lib_odepack(self):
        """Test import assimulo.lib.odepack"""
        raised_exception, exception = self._test_import("assimulo.lib.odepack")
        assert not raised_exception, self._err_msg(exception)

    @testattr(stddist_full = True)
    def test_import_lib_radar5(self):
        """Test import assimulo.lib.radar5"""
        raised_exception, exception = self._test_import("assimulo.lib.radar5")
        assert not raised_exception, self._err_msg(exception)
    
    @testattr(stddist_full = True)
    def test_import_lib_dopri5(self):
        """Test import assimulo.lib.dopri5"""
        raised_exception, exception = self._test_import("assimulo.lib.dopri5")
        assert not raised_exception, self._err_msg(exception)

    @testattr(stddist_full = True)
    def test_import_lib_radau5(self):
        """Test import assimulo.lib.radau5"""
        raised_exception, exception = self._test_import("assimulo.lib.radau5")
        assert not raised_exception, self._err_msg(exception)

    @testattr(stddist_full = True)
    def test_import_lib_radau_core(self):
        """Test import assimulo.lib.radau_core"""
        raised_exception, exception = self._test_import("assimulo.lib.radau_core")
        assert not raised_exception, self._err_msg(exception)

    @testattr(stddist_full = True)
    def test_import_lib_rodas(self):
        """Test import assimulo.lib.rodas"""
        raised_exception, exception = self._test_import("assimulo.lib.rodas")
        assert not raised_exception, self._err_msg(exception)

    @testattr(stddist_full = True)
    def test_import_runge_kutta(self):
        """Test import assimulo.solvers.dasp3"""
        raised_exception, exception = self._test_import("assimulo.solvers.dasp3")
        assert not raised_exception, self._err_msg(exception)

    @testattr(stddist_full = True)
    def test_import_euler(self):
        """Test import assimulo.solvers.euler"""
        raised_exception, exception = self._test_import("assimulo.solvers.euler")
        assert not raised_exception, self._err_msg(exception)

    @testattr(stddist_full = True)
    def test_import_sundials(self):
        """Test import assimulo.solvers.glimda"""
        raised_exception, exception = self._test_import("assimulo.solvers.glimda")
        assert not raised_exception, self._err_msg(exception)

    @testattr(stddist_full = True)
    def test_import_(self):
        """Test import assimulo.solvers.kinsol"""
        raised_exception, exception = self._test_import("assimulo.solvers.kinsol")
        assert not raised_exception, self._err_msg(exception)
    
    @testattr(stddist_full = True)
    def test_import_solvers_odassl(self):
        """Test import assimulo.solvers.odassl"""
        raised_exception, exception = self._test_import("assimulo.solvers.odassl")
        assert not raised_exception, self._err_msg(exception)
    
    @testattr(stddist_full = True)
    def test_import_solvers_odepack(self):
        """Test import assimulo.solvers.odepack"""
        raised_exception, exception = self._test_import("assimulo.solvers.odepack")
        assert not raised_exception, self._err_msg(exception)
    
    @testattr(stddist_full = True)
    def test_import_solvers_radar5(self):
        """Test import assimulo.solvers.radar5"""
        raised_exception, exception = self._test_import("assimulo.solvers.radar5")
        assert not raised_exception, self._err_msg(exception)
    
    @testattr(stddist_full = True)
    def test_import_solvers_radau5(self):
        """Test import assimulo.solvers.radau5"""
        raised_exception, exception = self._test_import("assimulo.solvers.radau5")
        assert not raised_exception, self._err_msg(exception)
    
    @testattr(stddist_full = True)
    def test_import_solvers_rosenbrock(self):
        """Test import assimulo.solvers.rosenbrock"""
        raised_exception, exception = self._test_import("assimulo.solvers.rosenbrock")
        assert not raised_exception, self._err_msg(exception)
    
    @testattr(stddist_full = True)
    def test_import_solvers_runge_kutta(self):
        """Test import assimulo.solvers.runge_kutta"""
        raised_exception, exception = self._test_import("assimulo.solvers.runge_kutta")
        assert not raised_exception, self._err_msg(exception)
    
    @testattr(stddist_full = True)
    def test_import_solvers_sundials(self):
        """Test import assimulo.solvers.sundials"""
        raised_exception, exception = self._test_import("assimulo.solvers.sundials")
        assert not raised_exception, self._err_msg(exception)