#Copyright (C) 2013 Modelon AB

#This program is free software: you can redistribute it and/or modify
#it under the terms of the GNU General Public License as published by
#the Free Software Foundation, version 3 of the License.

#This program is distributed in the hope that it will be useful,
#but WITHOUT ANY WARRANTY; without even the implied warranty of
#MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#GNU General Public License for more details.

#You should have received a copy of the GNU General Public License
#along with this program.  If not, see <http://www.gnu.org/licenses/>.

import os
import sys
import platform
from casadi import *
from modelicacasadi_wrapper import *
JVM_SET_UP=False


def transfer_model(model, class_name, file_name=[],
                   compiler_options={}, compiler_log_level='warning'):
    """ 
    Compiles and transfers a model to the ModelicaCasADi interface. 
    
    A destination model object and model class name must be passed, all other arguments have default values. 
    The different scenarios are:
    
    * Only class_name is passed: 
        - Class is assumed to be in MODELICAPATH.
    
    * class_name and file_name is passed:
        - file_name can be a single path as a string or a list of paths 
          (strings). The paths can be file or library paths.
    
    Library directories can be added to MODELICAPATH by listing them in a 
    special compiler option 'extra_lib_dirs', for example:
    
        compiler_options = 
            {'extra_lib_dirs':['c:\MyLibs1','c:\MyLibs2']}
        
    Other options for the compiler should also be listed in the compiler_options 
    dict.
    
        
    Parameters::

        model --
            A blank Model to be populated.
    
        class_name -- 
            The name of the model class.
            
        file_name -- 
            A path (string) or paths (list of strings) to model files and/or 
            libraries.
            Default: Empty list.
                        
        compiler_options --
            Options for the compiler.
            Note that MODELICAPATH is set to the standard for this
            installation if not given as an option.
            Default: Empty dict.
            
        compiler_log_level --
            Set the logging for the compiler. Valid options are:
            'warning'/'w', 'error'/'e', 'info'/'i' or 'debug'/'d'. 
            Default: 'warning'

    """
    _ensure_jvm()
    if isinstance(file_name, basestring):
        file_vec = [file_name]
    else: 
        file_vec = file_name
    _transfer_modelica(model, class_name, _generate_StringVector(file_vec),
                       _get_options(compiler_options), compiler_log_level)

def transfer_optimization_problem(ocp, class_name, file_name=[],
                                  compiler_options={}, compiler_log_level='warning'):
    """ 
    Compiles and transfers an optimization problem to the ModelicaCasADi interface. 
    
    A destination problem object and model class name must be passed, all other arguments have default values. 
    The different scenarios are:
    
    * Only class_name is passed: 
        - Class is assumed to be in MODELICAPATH.
    
    * class_name and file_name is passed:
        - file_name can be a single path as a string or a list of paths 
          (strings). The paths can be file or library paths.
    
    Library directories can be added to MODELICAPATH by listing them in a 
    special compiler option 'extra_lib_dirs', for example:
    
        compiler_options = 
            {'extra_lib_dirs':['c:\MyLibs1','c:\MyLibs2']}
        
    Other options for the compiler should also be listed in the compiler_options 
    dict.
    
        
    Parameters::
    
        ocp --
            A blank OptimizationProblem to be populated.

        class_name -- 
            The name of the model class.
            
        file_name -- 
            A path (string) or paths (list of strings) to model files and/or 
            libraries.
            Default: Empty list.

        compiler_options --
            Options for the compiler.
            Note that MODELICAPATH is set to the standard for this
            installation if not given as an option.
            Default: Empty dict.
            
        compiler_log_level --
            Set the logging for the compiler. Valid options are:
            'warning'/'w', 'error'/'e', 'info'/'i' or 'debug'/'d'. 
            Default: 'warning'

    """
    _ensure_jvm()
    if isinstance(file_name, basestring):
        file_vec = [file_name]
    else: 
        file_vec = file_name
    return _transfer_optimica(ocp, class_name, _generate_StringVector(file_vec),
                              _get_options(compiler_options), compiler_log_level)

def _ensure_jvm():
    global JVM_SET_UP
    if not JVM_SET_UP:
        setUpJVM()
        JVM_SET_UP=True

def _generate_StringVector(file_vec):
    string_file_vec = StringVector()
    for f_i in file_vec:
        string_file_vec.push_back(f_i)
    return string_file_vec

def _transfer_modelica(model, class_name, files, options, log_level):
    return modelicacasadi_wrapper._transferModelicaModel(model, class_name, files, options, log_level)
    
def _transfer_optimica(ocp, class_name, files, options, log_level):
    return modelicacasadi_wrapper._transferOptimizationProblem(ocp, class_name, files, options, log_level)


def _get_options(compiler_options):
    """
    Generate an instance of the CompilerOptionsWrapper class
    for ModelicaCasADi. 

    Note that MODELICAPATH is set to the standard for this
    installation if not given as an option.

    Parameters::

        compiler_options --
            A dict of options where the key specifies which option to modify 
            and the value the new value for the option.

    Returns::

        CompilerOptionsWrapper --
            
    """
    options_wrapper = CompilerOptionsWrapper()

    if not compiler_options.has_key("MODELICAPATH"):
        options_wrapper.addStringOption("MODELICAPATH", os.path.join(os.environ['JMODELICA_HOME'],'ThirdParty','MSL'))
    else:
        options_wrapper.addStringOption("MODELICAPATH", compiler_options["MODELICAPATH"])

    # set compiler options
    for key, value in compiler_options.iteritems():
        if isinstance(value, bool):
            options_wrapper.setBooleanOption(key, value)
        elif isinstance(value, basestring):
            options_wrapper.setStringOption(key,value)
        elif isinstance(value, int):
            options_wrapper.setIntegerOption(key,value)
        elif isinstance(value, float):
            options_wrapper.setRealOption(key,value)
        elif isinstance(value, list):
            options_wrapper.setStringOption(key, _list_to_string(value))
    return options_wrapper

def _which_compiler(files, selection_mode='auto'):
    # if selection_mode is 'auto' - detect file suffix
    if selection_mode == 'auto':
        comp = 'MODELICA'
        for f in files:
            basename, ext = os.path.splitext(f)
            if ext == '.mop':
                comp = 'OPTIMICA'
                break
    else:
        if selection_mode.lower() == 'modelica':
            comp = 'MODELICA'
        elif selection_mode.lower() == 'optimica':
            comp = 'OPTIMICA'
        else:
            print ("Invalid compiler selected: %s using OptimicaCompiler instead." %(selection_mode))
            comp = 'OPTIMICA'      
    return comp     

def _list_to_string(item_list):
    """
    Helper function that takes a list of items, which are typed to str and 
    returned as a string with the list items separated by platform dependent 
    path separator. For example: 
        (platform = win)
        item_list = [1, 2, 3]
        return value: '1;2;3'
    """
    ret_str = ''
    for l in item_list:
        ret_str =ret_str+str(l)+os.pathsep
    return ret_str
