from pymodelica import compile_fmu
from pyfmi import load_fmu

from tests_jmodelica import testattr, get_files_path
import os, numpy as np


"""Test discrete inputs using boolean inputs
    Test is using two different models that are supposed
    to generate the same result. The result from each model
    is compared to the values in a reference file.
"""


def get_results(model_name):
    rtol = 1e-6
    atol = rtol
    ncp = 500
    libpaths = [os.path.join(get_files_path(), 'Modelica', 'DiscreteInputTestModels.mo')]
    n = compile_fmu(model_name,
                    libpaths,
                    jvm_args='-Xmx6g')

    m = load_fmu(n)

    start = 0.400
    stop = 0.405

    m.initialize(start_time=start, tolerance=rtol)
    m.event_update()
    m.enter_continuous_time_mode()

    opts = m.simulate_options()

    opts["initialize"] = False
    opts["CVode_options"]["rtol"] = rtol
    opts["CVode_options"]["atol"] = atol
    opts['ncp'] = ncp

    ts = []
    inp = [True]
    results = []
    m.set("Bool_A", True)

    for h in np.linspace(start, stop, 21)[:-1]:
        ts.append(h)
        inp.append(not inp[-1])
        
        m.enter_event_mode()
        m.set("Bool_B", inp[-1])
        m.event_update()
        m.enter_continuous_time_mode()
        res_jm = m.simulate(h, h+0.00025, options=opts)
        
        results.extend(res_jm["Real_B"])
    
    return results


def get_reference_data(path_to_reference_data):
    ref_values = []
    with open(path_to_reference_data, 'r') as f:
        ref_values = f.readlines()

    # remove all newlines and convert elements to float since they are strings
    ref_values = map(lambda s: s.strip(), ref_values)
    ref_values = [float(x) for x in ref_values]
    return ref_values

@testattr(stddist_full = True)
def test_model_without_edge(self):
    model_name = 'DiscreteInputTestModels.myTestModel'
    results_no_edge = get_results(model_name)

    path_to_reference_data = os.path.join(get_files_path(), 'Modelica', 'DiscreteInputTestValues.txt')
    ref_values = get_reference_data(path_to_reference_data)

    assert np.amax(np.array(ref_values) - results_no_edge) == 0.0

@testattr(stddist_full = True)
def test_model_with_edge(self):
    model_name = 'DiscreteInputTestModels.myTestModelEdge'
    results_with_edge = get_results(model_name)

    path_to_reference_data = os.path.join(get_files_path(), 'Modelica', 'DiscreteInputTestValues.txt')
    ref_values = get_reference_data(path_to_reference_data)

    assert np.amax(np.array(ref_values) - results_with_edge) == 0.0

