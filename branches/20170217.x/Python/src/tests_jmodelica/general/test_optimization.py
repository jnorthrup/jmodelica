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
import matplotlib.pyplot as plt
import numpy as N
import os.path

from pyjmi.initialization.ipopt import InitializationOptimizer
from pyjmi.initialization.ipopt import NLPInitialization
from pymodelica.compiler import compile_jmu
from pyjmi.jmi import JMUModel
from pyjmi.common.io import ResultDymolaTextual
from pyjmi.optimization.ipopt import NLPCollocationLagrangePolynomials
from pyjmi.optimization.ipopt import CollocationOptimizer
from tests_jmodelica.general.base_simul import *
from tests_jmodelica import testattr, get_files_path

class TestOptimization(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        mofile = os.path.join(get_files_path(), 'Modelica', 'VDP.mop')
        OptimizationTest.setup_class_base(mofile, 'VDP_pack.VDP_Opt', 
                options = {'state_start_values_fixed': True})

    @testattr(ipopt = True)
    def setUp(self):
        n_e = 50
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        self.setup_base(opt_options={'n_e':n_e, 
                                     'hs':hs, 
                                     'n_cp':n_cp,
                                     'IPOPT_options':{'max_iter': 500}})
        self.run()

    @testattr(ipopt = True)
    def test_cost_end(self):
        self.assert_end_value('cost', 2.3469089e+01)


class TestIfExp(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base(
                'IfExpTest.mop', 'IfExpTest')

    @testattr(ipopt = True)
    def setUp(self):
        n_e = 50
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        self.setup_base(opt_options={'n_e':n_e, 
                                     'hs':hs, 
                                     'n_cp':n_cp,
                                     'IPOPT_options':{'max_iter': 500}})
        self.run()

    @testattr(ipopt = True)
    def test_cost_end(self):
        self.assert_end_value('cost', 1.0590865e+00)

class TestFreeInitialConditions(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base(
            'FreeInitialConditions.mop', 'FreeInitialConditions')

    @testattr(ipopt = True)
    def setUp(self):
        n_e = 50
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        
        self.setup_base(opt_options={'n_e':n_e,
                                     'hs':hs,
                                     'n_cp':n_cp})
        self.run()

    @testattr(ipopt = True)
    def test_cost_end(self):
        self.assert_end_value('cost', 1.9179767e+01)

class TestBlockingFactors(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base(
            'BlockingTest.mop', 'BlockingTest')

    @testattr(ipopt = True)
    def setUp(self):
        self.load_expected_data('BlockingTest_result.txt')
        n_e = 50
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        blocking_factors = N.array([5,10,5,3])
        self.setup_base(opt_options = {'n_e':n_e,
                                       'hs':hs,
                                       'n_cp':n_cp,
                                       'blocking_factors':blocking_factors,
                                       'IPOPT_options':{'max_iter': 500},
                                       'init_traj':self.expected})
        self.run()

    @testattr(ipopt = True)
    def test_cost_end(self):
        self.assert_end_value('cost', 8.1819533e-01)

    @testattr(ipopt = True)
    def test_trajectories(self):
        self.assert_all_trajectories(
            ['x[1]', 'x[2]', 'w1', 'w2', 'w3', 'w4'])

class TestWriteScaledResult(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base(
                'ScaledResult.mop', 'ScaledResult.Scaled2',
                    options={"enable_variable_scaling":True})

    @testattr(stddist = True)
    def setUp(self):
        self.setup_base(opt_options={'write_scaled_result':True})
        self.run()
        self.load_expected_data('ScaledResult_Scaled2_result.txt')

    @testattr(stddist = True)
    def test_trajectories(self):
        self.assert_all_trajectories(['x', 'y', 'u', 'der(x)'])


class TestTerminalConstraintNominal(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base(
            'TerminalConstraintTest.mop', 'TerminalConstraintTest',options={'enable_variable_scaling':True})

    @testattr(ipopt = True)
    def setUp(self):
        n_e = 50
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        self.setup_base(opt_options = {'n_e':n_e,
                                       'hs':hs,
                                       'n_cp':n_cp,
                                       'IPOPT_options':{'max_iter': 500}})
        self.run()
        self.load_expected_data('TerminalConstraintTest_result.txt')

    @testattr(ipopt = True)
    def test_trajectories(self):
        self.assert_all_trajectories(['x', 'v', 'u'])

class TestMeshInterpolationResult(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base(
            'DI_opt.mop', 'DI_opt')

    @testattr(ipopt = True)
    def setUp(self):
        n_e = 8
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        self.setup_base(opt_options = {'n_e':n_e,
                                       'hs':hs,
                                       'n_cp':n_cp,
                                       'result_mode':'mesh_interpolation',
                                       'result_mesh':N.linspace(-0.1,2.2,50),
                                       'IPOPT_options':{'max_iter': 500}})
        self.run()
        self.load_expected_data('DI_opt_mesh_interpolation_result.txt')

    @testattr(ipopt = True)
    def test_trajectories(self):
        self.assert_all_trajectories(['x', 'v', 'w1', 'w2', 'u', 'cost'])

class TestIntegersNBooleanParameters(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base(
            'ArrayIntBoolPars_Opt.mop', 'ArrayIntBoolPars_Opt')

    @testattr(ipopt = True)
    def setUp(self):
        n_e = 50
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        self.setup_base(opt_options = {'n_e':n_e,
                                       'hs':hs,
                                       'n_cp':n_cp,
                                       'IPOPT_options':{'max_iter': 500}})
        self.run()
        self.load_expected_data('ArrayIntBoolPars_Opt_result.txt')

    @testattr(ipopt = True)
    def test_trajectories(self):
        self.assert_all_trajectories(['B', 'N', 'x[1]'])

class TestNominal(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base(
            'NominalTest.mop', 'NominalTests.NominalOptTest2',
            options={"enable_variable_scaling":True})

    @testattr(ipopt = True)
    def setUp(self):
        n_e = 50
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        self.setup_base(opt_options = {'n_e':n_e,
                                       'hs':hs,
                                       'n_cp':n_cp,
                                       'IPOPT_options':{'max_iter': 500}})
        self.run()
        self.load_expected_data('NominalTests_NominalOptTest2_result.txt')

    @testattr(ipopt = True)
    def test_trajectories(self):
        self.assert_all_trajectories(['x', 'der(x)', 'u'])

    @testattr(ipopt = True)
    def test_initialization_from_data(self):
        n_e = 50
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        
        nlp = NLPCollocationLagrangePolynomials(self.model, n_e, hs, n_cp)
        nlp.set_initial_from_dymola(self.expected,hs,0,1)
        nlp.export_result_dymola()
        self.data = ResultDymolaTextual(
            "NominalTests_NominalOptTest2_result.txt")
        self.assert_all_trajectories(['x', 'der(x)', 'u'])

class TestFunction1(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base(
            'FunctionAR_opt.mop', 'FunctionAR.UnknownArray1')

    @testattr(disabled = True)
    def setUp(self):
        n_e = 50
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        self.setup_base(rel_tol=1.0e-2, 
                        abs_tol=1.0e-2,
                        opt_options = {'n_e':n_e,
                                       'hs':hs,
                                       'n_cp':n_cp,
                                       'IPOPT_options':{'max_iter': 500}})
        self.run()
        self.load_expected_data('UnknownArray.txt')

    @testattr(disabled = True)
    def test_trajectories(self):
        vars = ['x[%d]' % i for i in range(1, 4)]
        self.assert_all_trajectories(vars, same_span=True)
 
class TestFunction2(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base(
            'FunctionAR_opt.mop', 'FunctionAR.FuncRecord1')

    @testattr(ipopt = True)
    def setUp(self):
        n_e = 20
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        self.setup_base(rel_tol=1.0e-2, 
                        opt_options = {'n_e':n_e,
                                       'hs':hs,
                                       'n_cp':n_cp,
                                       'IPOPT_options':{'max_iter': 500}})
        self.run()
        self.load_expected_data('FuncRecord.txt')

    @testattr(ipopt = True)
    def test_trajectories(self):
        self.assert_all_trajectories(['x', 'r.a'], same_span=True)
   
class TestStaticOptimizationDependentParameters:

    @classmethod
    def setUpClass(cls):
        curr_dir = os.path.dirname(os.path.abspath(__file__));
        mofile = os.path.join(get_files_path(), 'Modelica', 'StaticOptimizationTest.mop')
        compile_jmu("StaticOptimizationTest.StaticOptimizationTest2", mofile)
        cls.model = JMUModel("StaticOptimizationTest_StaticOptimizationTest2.jmu")
        cls.nlp = NLPInitialization(cls.model,stat=1)
        cls.ipopt_nlp = InitializationOptimizer(cls.nlp)

    @testattr(ipopt = True)
    def setUp(self):
        self.ipopt_nlp.init_opt_ipopt_solve();
        self.nlp.export_result_dymola()
        self.res = ResultDymolaTextual(
            "StaticOptimizationTest_StaticOptimizationTest2_result.txt")

    @testattr(ipopt = True)
    def test_parameter_value(self):
        k = self.res.get_variable_data("k")
        assert k.x[0] == 1.1

    @testattr(ipopt = True)
    def test_initialization_from_model(self):
        self.model.set("k",-1)
        self.nlp.init_opt_set_initial_from_model()
        assert self.nlp.init_opt_get_x()[0] == -1

class TestOptInitBlockingFactors:
    @classmethod
    def setUpClass(cls):
        cls.curr_dir = os.path.dirname(os.path.abspath(__file__));
        mofile = os.path.join(get_files_path(), 'Modelica', 
                'BlockingError.mop')

        m = compile_jmu("BlockingInitPack.M_init", mofile)
        cls.model = JMUModel(m)
        
        m = compile_jmu("BlockingInitPack.M_Opt",mofile)
        cls.opt_model = JMUModel(m)
        
    @testattr(ipopt = True)
    def setUp(self):
        resfile = os.path.join(get_files_path(), 'Results', 
            'BlockingInitPack_M_init_result.txt')
        self.res_init = ResultDymolaTextual(resfile)

        self.n_e = 5 # Number of elements 
        self.hs = N.ones(self.n_e)*1./self.n_e # Equidistant points
        self.n_cp = 3; # Number of collocation points in each element

        # Blocking factors for control parametrization
        blocking_factors=N.ones(self.n_e,dtype=N.int)

        self.nlp = NLPCollocationLagrangePolynomials(self.opt_model,
            self.n_e,self.hs,self.n_cp,blocking_factors)

        self.nlp.set_initial_from_dymola(self.res_init, self.hs, 0., 10.)

        self.nlp.export_result_dymola("qwe.txt")

        self.res_init2 = ResultDymolaTextual('qwe.txt')


    @testattr(ipopt = True)
    def test_initialization(self):


        m_x1_1 = self.res_init.get_variable_data("m.x[1]").x
        m_x1_2 = self.res_init2.get_variable_data("m.x[1]").x
        
        m_x2_1 = self.res_init.get_variable_data("m.x[2]").x
        m_x2_2 = self.res_init2.get_variable_data("m.x[2]").x
        
        m_y_1 = self.res_init.get_variable_data("m.y").x
        m_y_2 = self.res_init2.get_variable_data("m.y").x
        
        u_1 = self.res_init.get_variable_data("u").x
        u_2 = self.res_init2.get_variable_data("u").x
        
        (n_x, n_g, n_h, dg_n_nz, dh_n_nz) = self.nlp.opt_coll_get_dimensions()
        
        x_init = N.zeros(n_x)
        self.nlp.opt_coll_get_initial(x_init)
        
        nbr_dx = self.nlp._model._n_real_dx.value
        nbr_x  = self.nlp._model._n_real_x.value
        nbr_u  = self.nlp._model._n_real_u.value
        nbr_w  = self.nlp._model._n_real_w.value
        
        offs1 = nbr_dx + nbr_x + nbr_u + nbr_w
        offs2 = offs1 - 1
        #print nbr_dx, nbr_x, nbr_u, nbr_w, offs1, offs2
        offs_x_el_junc = offs1 + offs2*self.n_e*self.n_cp + self.n_e
        
        x_el_junc = N.zeros((self.n_e,3))
        
        for i in range(self.n_e):
            x_el_junc[i,:] = x_init[offs_x_el_junc + i*3:offs_x_el_junc + (i+1)*3]

        t_f = 10.

        t_x_el_junc = N.linspace(0,t_f,self.n_e+1)
        t_x_el_junc = t_x_el_junc[1:]

        offs_dx_p = offs1 + offs2*self.n_e*self.n_cp + 4*self.n_e
        offs_x_p = offs_dx_p + nbr_dx
        offs_u_p = offs_x_p + nbr_x
        offs_w_p = offs_u_p + nbr_u

        n_tp = 10
        
        dx_p = N.zeros((n_tp,nbr_dx))
        x_p  = N.zeros((n_tp,nbr_x))
        u_p  = N.zeros((n_tp,nbr_u))
        w_p  = N.zeros((n_tp,nbr_w))
        
        for i in range(n_tp):
            dx_p[i,:] = x_init[offs_dx_p + i*offs1:offs_dx_p + i*offs1 + nbr_dx]
            x_p[i,:]  = x_init[offs_x_p  + i*offs1:offs_x_p  + i*offs1 + nbr_x]
            u_p[i,:]  = x_init[offs_u_p  + i*offs1:offs_u_p  + i*offs1 + nbr_u]
            w_p[i,:]  = x_init[offs_w_p  + i*offs1:offs_w_p  + i*offs1 + nbr_w]

        t_tp = N.linspace(1,10,10)

        h=N.zeros(n_h)
        self.nlp.opt_coll_h(h)
        #print N.max(N.abs(h))

#         plt.figure(3)
#         plt.clf()
#         plt.plot(m_x1_1.t,m_x1_1.x)
#         plt.plot(m_x1_2.t,m_x1_2.x)
#         plt.plot(t_x_el_junc,x_el_junc[:,1],'x')
#         plt.plot(t_tp,x_p[:,1],'o')
#         plt.title("x[1]")
#         plt.grid()
#         plt.show()
        
#         plt.figure(4)
#         plt.clf()
#         plt.plot(m_x2_1.t,m_x2_1.x)
#         plt.plot(m_x2_2.t,m_x2_2.x)
#         plt.plot(t_x_el_junc,x_el_junc[:,2],'x')
#         plt.plot(t_tp,x_p[:,2],'o')
#         plt.title("x[2]")
#         plt.grid()
#         plt.show()

#         plt.figure(5)
#         plt.clf()
#         plt.plot(m_y_1.t,m_y_1.x)
#         plt.plot(m_y_2.t,m_y_2.x)
#         plt.plot(t_tp,w_p[:,0],'o')
#         plt.title("y")
#         plt.grid()
#         plt.show()
        
#         plt.figure(6)
#         plt.clf()
#         plt.plot(m_u_1.t,m_u_1.x)
#         plt.plot(m_u_2.t,m_u_2.x)
#         plt.plot(t_tp,u_p[:,0],'o')
#         plt.title("u")
#         plt.grid()
#         plt.show()


        m_x1_2_res = N.array([ 1.        ,  0.96503702,  0.80699964,  0.81708186,  0.82968423,
                               0.73425843,  0.4641878 ,  0.30274918, -0.22539661, -0.45405707,
                               -0.47988416, -0.25883339,  0.07728009,  0.22367095,  0.49688434,
                               0.42028466])
        
        m_x2_2_res = N.array([ 1.        ,  0.77648496,  0.75474237,  0.86572509,  0.85523243,
                               0.47651669, -0.02410645, -0.24417425, -0.68431665, -0.61607295,
                               -0.48363351,  0.15624317,  0.56793272,  0.66948745,  0.56283272,
                               0.14759305])
        
        u_2_res = N.array([ 0.        ,  0.30515581,  0.30515581,  0.30515581,  0.73893649,
                              0.73893649,  0.73893649, -0.920168  , -0.920168  , -0.920168  ,
                              0.0269131 ,  0.0269131 ,  0.0269131 ,  0.89776804,  0.89776804,
                              0.89776804])
        
        m_y_2_res = N.array([ 2.        ,  1.74152198,  1.56174201,  1.68280695,  1.68491666,
                              1.21077512,  0.44008136,  0.05857493, -0.90971326, -1.07013001,
                              -0.96351767, -0.10259022,  0.64521281,  0.8931584 ,  1.05971706,
                              0.56787771])
        
        x_el_junc_res = N.array([[  3.91403795,   0.81708186,   0.86572509],
                                 [  6.38519639,   0.4641878 ,  -0.02410645],
                                 [  8.53595865,  -0.45405707,  -0.61607295],
                                 [  9.99351048,   0.07728009,   0.56793272],
                                 [ 11.69233416,   0.42028466,   0.14759305]])
        
        dx_p_res = N.array([[ 1.89614716, -0.13108396,  0.13906756],
                            [ 2.24392408,  0.04864298,  0.04357222],
                            [ 1.05980345, -0.15348176, -0.49911689],
                            [ 0.78887658, -0.48829925, -0.73269738],
                            [ 1.29975129, -0.52999439, -0.34773495],
                            [ 0.66373748, -0.16201457,  0.33665916],
                [ 0.56780963,  0.31891731,  0.70407499],
                            [ 1.30735387,  0.49065263,  0.42142531],
                            [ 0.81705525,  0.20439241, -0.24969127],
                            [ 0.49438075, -0.27269124, -0.69161393]])
        
        x_p_res = N.array([[  1.71039492,   0.83348678,   0.70240363],
                           [  3.91403795,   0.81708186,   0.86572509],
                           [  5.61520049,   0.79371837,   0.64023676],
                           [  6.38519639,   0.4641878 ,  -0.02410645],
                           [  7.48469697,  -0.08119087,  -0.61118532],
                           [  8.53595865,  -0.45405707,  -0.61607295],
                           [  9.01802285,  -0.36600637,  -0.04708865],
                           [  9.99351048,   0.07728009,   0.56793272],
                           [ 11.15957068,   0.45741668,   0.66180933],
                           [ 11.69233416,   0.42028466,   0.14759305]])
        
        u_p_res = N.array([[ 0.84147098],
                           [ 0.90929742],
                           [ 0.14112001],
                           [-0.75680257],
                           [-0.95892497],
                           [-0.27941585],
                           [ 0.6569871 ],
                           [ 0.98935824],
                           [ 0.41211848],
                           [-0.54402111]])
        
        w_p_res = N.array([[ 1.53589041,  0.84147098],
                           [ 1.68280695,  0.90929742],
                           [ 1.43395513,  0.14112001],
                           [ 0.44008136, -0.75680257],
                           [-0.69237618, -0.95892497],
                           [-1.07013001, -0.27941585],
                           [-0.41309502,  0.6569871 ],
                           [ 0.64521281,  0.98935824],
                           [ 1.11922602,  0.41211848],
                           [ 0.56787771, -0.54402111]])
        
        assert N.sum(N.abs(m_x1_2-m_x1_2_res))<1e-3
        assert N.sum(N.abs(m_x2_2-m_x2_2_res))<1e-3
        assert N.sum(N.abs(u_2-u_2_res))<1e-3
        assert N.sum(N.abs(m_y_2-m_y_2_res))<1e-3
        
        assert N.sum(N.abs(x_el_junc-x_el_junc_res))<1e-3
        
        assert N.sum(N.abs(dx_p-dx_p_res))<1e-3
        assert N.sum(N.abs(x_p-x_p_res))<1e-3
        assert N.sum(N.abs(u_p-u_p_res))<1e-3
        assert N.sum(N.abs(w_p-w_p_res))<1e-3
        
        optimizer = CollocationOptimizer(self.nlp)
        optimizer.opt_coll_ipopt_solve()

class TestLagrangeCost1(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base('LagrangeCost.mop',
            'LagrangeCost.OptTest1')

    @testattr(ipopt = True)
    def setUp(self):
        n_e = 50
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        self.setup_base(opt_options = {'n_e':n_e,
                                       'hs':hs,
                                       'n_cp':n_cp,
                                       'IPOPT_options':{'max_iter': 500}})
        self.run()
        self.load_expected_data('LagrangeCost_OptTest1_result.txt')

    @testattr(ipopt = True)
    def test_trajectories(self):
        self.assert_all_trajectories(['sys.x[1]', 'sys.x[2]', 'u', 'sys.y'])

class TestLagrangeCost2(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base('LagrangeCost.mop',
            'LagrangeCost.OptTest1')

    @testattr(ipopt = True)
    def setUp(self):
        n_e = 50
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        b_f = 3*N.ones(10)
        self.setup_base(opt_options = {'n_e':n_e,
                                       'hs':hs,
                                       'n_cp':n_cp,
                                       'blocking_factors':b_f,
                                       'IPOPT_options':{'max_iter': 500}})
        self.run()
        self.load_expected_data('LagrangeCost_OptTest1_bf_result.txt')

    @testattr(ipopt = True)
    def test_trajectories(self):
        self.assert_all_trajectories(['sys.x[1]', 'sys.x[2]', 'u', 'sys.y'])

class TestLagrangeCost3(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base('LagrangeCost.mop',
            'LagrangeCost.OptTest4')

    @testattr(ipopt = True)
    def setUp(self):
        n_e = 50
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        self.setup_base(opt_options = {'n_e':n_e,
                                       'hs':hs,
                                       'n_cp':n_cp,
                                       'IPOPT_options':{'max_iter': 500}})
        self.run()
        self.load_expected_data('LagrangeCost_OptTest4_result.txt')

    @testattr(ipopt = True)
    def test_trajectories(self):
        self.assert_all_trajectories(['sys.x[1]', 'sys.x[2]', 'u', 'sys.y'])

class TestLagrangeCost4(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base('LagrangeCost.mop',
            'LagrangeCost.OptTest4')

    @testattr(ipopt = True)
    def setUp(self):
        n_e = 50
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        b_f = 3*N.ones(10)
        self.setup_base(opt_options = {'n_e':n_e,
                                       'hs':hs,
                                       'n_cp':n_cp,
                                       'blocking_factors':b_f,
                                       'IPOPT_options':{'max_iter': 500}})
        self.run()
        self.load_expected_data('LagrangeCost_OptTest4_bf_result.txt')

    @testattr(ipopt = True)
    def test_trajectories(self):
        self.assert_all_trajectories(['sys.x[1]', 'sys.x[2]', 'u', 'sys.y'])

class TestDependentParametersInCollocation(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base('DependentParameterTest2.mop',
            'DependentParameterTest2')

    @testattr(ipopt = True)
    def setUp(self):
        n_e = 30
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        b_f = N.ones(n_e)
        self.setup_base(opt_options={'n_e':n_e,
                                     'hs':hs,
                                     'n_cp':n_cp,
                                     'blocking_factors':b_f,
                                     'IPOPT_options':{'max_iter': 500}})
        
        self.run()
        self.load_expected_data('DependentParameterTest2_result.txt')

    @testattr(ipopt = True)
    def test_trajectories(self):
        self.assert_all_trajectories(['x', 'u', 'p1', 'p2', 'p4'])

class TestMinTimeProblem1(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base(
            'MinTimeProblems.mop', 'MinTimeProblems.MinTimeProblem1')

    @testattr(ipopt = True)
    def setUp(self):
        n_e = 50
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        b_f = []
        self.setup_base(opt_options={'n_e':n_e,
                                     'hs':hs,
                                     'n_cp':n_cp,
                                     'blocking_factors':b_f})
        self.run()
        self.load_expected_data('MinTimeProblems_MinTimeProblem1_result.txt')

    @testattr(ipopt = True)
    def test_trajectories(self):
        self.assert_all_trajectories(['x', 'dx', 'u'])

class TestMinTimeProblem2(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base(
            'MinTimeProblems.mop', 'MinTimeProblems.MinTimeProblem2')

    @testattr(ipopt = True)
    def setUp(self):
        n_e = 50
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        b_f = []
        self.setup_base(opt_options={'n_e':n_e,
                                     'hs':hs,
                                     'n_cp':n_cp,
                                     'blocking_factors':b_f})
        self.run()
        self.load_expected_data('MinTimeProblems_MinTimeProblem2_result.txt')

    @testattr(ipopt = True)
    def test_trajectories(self):
        self.assert_all_trajectories(['x', 'dx', 'u'])

class TestMinTimeProblem3(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base(
            'MinTimeProblems.mop', 'MinTimeProblems.MinTimeProblem3')

    @testattr(ipopt = True)
    def setUp(self):
        n_e = 50
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        b_f = []
        self.setup_base(opt_options={'n_e':n_e,
                                     'hs':hs,
                                     'n_cp':n_cp,
                                     'blocking_factors':b_f})
        self.run()
        self.load_expected_data('MinTimeProblems_MinTimeProblem3_result.txt')

    @testattr(ipopt = True)
    def test_trajectories(self):
        self.assert_all_trajectories(['x', 'dx', 'u'])

class TestMinTimeProblem4(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base(
            'MinTimeProblems.mop', 'MinTimeProblems.MinTimeProblem4')

    @testattr(ipopt = True)
    def setUp(self):
        n_e = 50
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        b_f = []
        self.setup_base(opt_options={'n_e':n_e,
                                     'hs':hs,
                                     'n_cp':n_cp,
                                     'blocking_factors':b_f})
        self.run()
        self.load_expected_data('MinTimeProblems_MinTimeProblem4_result.txt')

    @testattr(ipopt = True)
    def test_trajectories(self):
        self.assert_all_trajectories(['sys.x1', 'sys.x2', 'u'])


class TestMinTimeProblem5(OptimizationTest):

    @classmethod
    def setUpClass(cls):
        OptimizationTest.setup_class_base(
            'MinTimeProblems.mop', 'MinTimeProblems.MinTimeProblem5')

    @testattr(ipopt = True)
    def setUp(self):
        n_e = 50
        hs = N.ones(n_e)*1./n_e
        n_cp = 3
        b_f = []
        self.setup_base(opt_options={'n_e':n_e,
                                     'hs':hs,
                                     'n_cp':n_cp,
                                     'blocking_factors':b_f})
        self.run()
        self.load_expected_data('MinTimeProblems_MinTimeProblem5_result.txt')

    @testattr(ipopt = True)
    def test_trajectories(self):
        self.assert_all_trajectories(['sys.x1', 'sys.x2', 'u'])


class TestMinTimeProblemInit:

    @classmethod
    def setUpClass(clf):
        clf.curr_dir = os.path.dirname(os.path.abspath(__file__));
        clf.jn = compile_jmu('MinTimeInit',clf.curr_dir + '/../files/Modelica/MinTimeInit.mop')
        clf.m = JMUModel(clf.jn)


    @testattr(ipopt = True)
    def setUp(self):
        self.res = self.m.optimize()

        if False:
            x = self.res['x']
            v = self.res['v']
            dx = self.res['der(x)']
            dv = self.res['der(v)']
            u = self.res['u']
            t = self.res['time']
            
            plt.figure(1)
            plt.clf()
            plt.subplot(2,1,1)
            plt.plot(t,x)
            plt.hold(True)
            plt.plot(t,v)
            plt.plot(t,dx)
            plt.plot(t,dv)
            plt.grid(True)
            plt.subplot(2,1,2)
            plt.plot(t,u)
            plt.grid(True)
            plt.show()

    @testattr(ipopt = True)
    def test_init(self):

        m = JMUModel(self.jn)

        # Create a new collocation object
        n_e = 30
        coll = NLPCollocationLagrangePolynomials(m,n_e, N.ones(n_e)/n_e, 3)

        # Initialize with optimization result
        coll.set_initial_from_dymola(self.res.result_data,N.array([]),0,1)

        # Write initial point to file
        coll.export_result_dymola('Init_res.txt')

        # Load result
        res_init = ResultDymolaTextual('Init_res.txt')

        # Load test fixture
        res_init_fix = ResultDymolaTextual(self.curr_dir + '/../files/Results/MinTimeInit_init_fix.txt')

        # Extract trajectories
        dx = res_init.get_variable_data('der(x)')
        dv = res_init.get_variable_data('der(v)')
        x = res_init.get_variable_data('x')
        v = res_init.get_variable_data('v')
        u = res_init.get_variable_data('u')

        dx_fix = res_init_fix.get_variable_data('der(x)')
        dv_fix = res_init_fix.get_variable_data('der(v)')
        x_fix = res_init_fix.get_variable_data('x')
        v_fix = res_init_fix.get_variable_data('v')
        u_fix = res_init_fix.get_variable_data('u')

        # Comparison tests
        N.testing.assert_array_almost_equal(dx_fix.x,dx.x)
        N.testing.assert_array_almost_equal(dv_fix.x,dv.x)
        N.testing.assert_array_almost_equal(x_fix.x,x.x)
        N.testing.assert_array_almost_equal(v_fix.x,v.x)
        N.testing.assert_array_almost_equal(u_fix.x,u.x)

        if False:
            plt.figure(1)
            plt.subplot(2,1,1)
            plt.plot(x.t,x.x,'r')
            plt.hold(True)
            plt.plot(v.t,v.x,'r')
            plt.grid(True)
            plt.subplot(2,1,2)
            plt.plot(u.t,u.x,'r')
            plt.grid(True)

