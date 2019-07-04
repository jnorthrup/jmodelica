#!/usr/bin/env python 
# -*- coding: utf-8 -*-

# Copyright (C) 2014 Modelon AB
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU Lesser General Public License as published by
# the Free Software Foundation, version 3 of the License.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
# GNU Lesser General Public License for more details.
#
# You should have received a copy of the GNU Lesser General Public License
# along with this program. If not, see <http://www.gnu.org/licenses/>.
"""
Module containing the FMI interface Python wrappers.
"""
import collections
from collections import OrderedDict
import itertools
from operator import attrgetter
import numpy as np
from numpy.compat import asbytes

cimport numpy as np
cimport fmil_import as FMIL
from cpython cimport array

import functools
import marshal
import fmi
import sys

python3_flag = True if sys.hexversion > 0x03000000 else False

cpdef decode(x):
    if python3_flag:
        return x.decode()
    else:
        return x

cpdef encode(x):
    if python3_flag:
        if isinstance(x, str):
            return x.encode()
        else:
            return x
    else:
        return x.encode("utf-8")

def enable_caching(obj):
    @functools.wraps(obj, ('__name__', '__doc__'))
    def memoizer(*args, **kwargs):
        cache = args[0].cache #First argument is the self object
        key = (obj, marshal.dumps(args[1:]), marshal.dumps(kwargs))
        
        if len(cache) > 1000: #Remove items from cache in case it grows large
            cache.popitem()

        if key not in cache:
            cache[key] = obj(*args, **kwargs)
        return cache[key]
        
    return memoizer

cpdef cpr_seed(dependencies, list column_keys):
    cdef int i=0,j=0,k=0
    cdef int n_col = len(column_keys)#len(dependencies.keys())
    cdef dict columns_taken# = {key: 1 for key in dependencies.keys() if len(dependencies[key]) == 0}
    cdef dict groups = {}
    cdef dict column_dict = {}
    cdef dict column_keys_dict = {}
    cdef dict data_index = {}

    row_keys_dict    = {s:i for i,s in enumerate(dependencies.keys())}
    column_keys_dict = {s:i for i,s in enumerate(column_keys)}
    column_dict      = {i:[] for i,s in enumerate(column_keys)}
    for i,dx in enumerate(dependencies.keys()):
        for x in dependencies[dx]:
            column_dict[column_keys_dict[x]].append(dx)
    columns_taken = {key: 1 for key in column_dict.keys() if len(column_dict[key]) == 0}
    
    k = 0
    kd = 0
    data_index = {}
    data_index_with_diag = {}
    for i in range(n_col):
        if python3_flag:
            data_index[i] = list(range(k, k + len(column_dict[i])))
        else:
            data_index[i] = range(k, k + len(column_dict[i]))
        k = k + len(column_dict[i])
        
        data_index_with_diag[i] = []
        diag_added = False
        for x in column_dict[i]:
            ind = row_keys_dict[x]
            if ind < i:
                data_index_with_diag[i].append(kd)
                kd = kd + 1
            else:
                if ind == i:
                    diag_added = True
                if not diag_added:
                    kd = kd + 1
                    diag_added = True
                data_index_with_diag[i].append(kd)
                kd = kd + 1
        if not diag_added:
            kd = kd + 1 
    
    nnz = k
    nnz_with_diag = kd
    
    k = 0
    for i in range(n_col):
        if columns_taken.has_key(i):
            continue
            
        # New group
        groups[k] = ([i], column_dict[i][:], [row_keys_dict[x] for x in column_dict[i]], [i]*len(column_dict[i]), data_index[i], data_index_with_diag[i])
        
        for j in range(i+1, n_col):
            if columns_taken.has_key(j):
                continue
            
            intersect = frozenset(groups[k][1]).intersection(column_dict[j])
            if not intersect:
                
                #structure
                # - [0] - variable indexes
                # - [1] - variable names
                # - [2] - matrix rows
                # - [3] - matrix columns
                # - [4] - position in data vector (CSC format)
                # - [5] - position in data vector (with diag) (CSC format)
                
                groups[k][0].append(j)
                groups[k][1].extend(column_dict[j])
                groups[k][2].extend([row_keys_dict[x] for x in column_dict[j]])
                groups[k][3].extend([j]*len(column_dict[j]))
                groups[k][4].extend(data_index[j])
                groups[k][5].extend(data_index_with_diag[j])
                columns_taken[j] = 1
            
        k = k + 1
    
    groups["groups"] = list(groups.keys())
    groups["nnz"] = nnz
    groups["nnz_with_diag"] = nnz_with_diag
    
    return groups

cimport cython
@cython.boundscheck(False)
@cython.wraparound(False)
cdef double quad_err(np.ndarray[double, ndim=1] sim, np.ndarray[double, ndim=1] est, int n):
#def quad_err(sim, est, int n):
    cdef double s = 0
    for i in range(n):
        s += (sim[i]-est[i])**2
    
    return s

cpdef parameter_estimation_f(y, parameters, measurments, model, input, options):
    cdef double err = 0
    cdef int n
    
    model.reset()
    
    for i,parameter in enumerate(parameters):
        model.set(parameter, y[i]*options["scaling"][i])
    
    # Simulate model response with new parameter values
    res = model.simulate(measurments[1][0,0], final_time=measurments[1][-1,0], input=input, options=options["simulate_options"])

    n = measurments[1].shape[0]
    for i,parameter in enumerate(measurments[0]):
        err += quad_err(res[parameter], measurments[1][:,i+1], n)

    return 1.0/n*err**(0.5)
    
cpdef list convert_array_names_list_names(np.ndarray names):
    cdef int max_length = names.shape[0]
    cdef int nbr_items  = len(names[0])
    cdef int i,j = 0
    cdef char *tmp = <char*>FMIL.calloc(max_length,sizeof(char))
    cdef list output = []
    cdef bytes py_str

    for i in range(nbr_items):
        for j in range(max_length):
            try:
                tmp[j] = ord(names[j,i])
            except ValueError:
                break

        py_str = tmp[:j]
        output.append(py_str)
    
    FMIL.free(tmp)
    
    return output

@cython.boundscheck(False)
@cython.wraparound(False)
cpdef list convert_array_names_list_names_int(np.ndarray[int, ndim=2] names):
    cdef int max_length = names.shape[0]
    cdef int nbr_items  = names.shape[1]
    cdef int i,j = 0,ch, py3
    cdef char *tmp = <char*>FMIL.calloc(max_length,sizeof(char))
    cdef list output = []
    cdef bytes py_str
    
    if python3_flag:
        py3 = 1
    else:
        py3 = 0

    for i in range(nbr_items):
        for j in range(max_length):
            ch = names[j,i]
            if ch==0:
                break
            else:
                tmp[j] = ch
        
        py_str = tmp[:j]
        if j == max_length - 1:
            if py3:
                py_str = py_str.replace(b" ", b"")
            else:
                py_str = py_str.replace(" ", "")
        output.append(py_str)
    
    FMIL.free(tmp)
    
    return output

@cython.boundscheck(False)
@cython.wraparound(False)
cpdef prepare_data_info(np.ndarray[int, ndim=2] data_info, list sorted_vars, model):
    cdef int index_fixed    = 1
    cdef int index_variable = 1
    cdef int i, alias, data_type, variability
    cdef int last_data_matrix = -1, last_index = -1
    cdef int FMI_NEGATED_ALIAS = fmi.FMI_NEGATED_ALIAS
    cdef int FMI_PARAMETER = fmi.FMI_PARAMETER, FMI_CONSTANT = fmi.FMI_CONSTANT
    cdef int FMI_REAL = fmi.FMI_REAL, FMI_INTEGER = fmi.FMI_INTEGER
    cdef int FMI_ENUMERATION = fmi.FMI_ENUMERATION, FMI_BOOLEAN = fmi.FMI_BOOLEAN 
    cdef list param_real = [], param_int = [], param_bool = []
    cdef list varia_real = [], varia_int = [], varia_bool = []
    last_vref = -1
    
    for i in range(1, len(sorted_vars)+1):
        var = sorted_vars[i-1]
        data_info[2,i] = 0
        data_info[3,i] = -1
        
        alias = -1 if var.alias == FMI_NEGATED_ALIAS else 1
        
        if last_vref == var.value_reference:
            data_info[0,i] = last_data_matrix
            data_info[1,i] = alias*last_index
        else:
            variability = var.variability
            last_vref   = var.value_reference
            data_type   = var.type
            
            if variability == FMI_PARAMETER or variability == FMI_CONSTANT:
                last_data_matrix = 1
                index_fixed = index_fixed + 1
                last_index = index_fixed
                
                if data_type == FMI_REAL:
                    param_real.append(last_vref)
                elif data_type == FMI_INTEGER or data_type == FMI_ENUMERATION:
                    param_int.append(last_vref)
                elif data_type == FMI_BOOLEAN:
                    param_bool.append(last_vref)
                else:
                    raise fmi.FMUException("Unknown type detected for variable %s when writing the results."%var.name)
            else:
                last_data_matrix = 2
                index_variable = index_variable + 1
                last_index = index_variable
                
                if data_type == FMI_REAL:
                    varia_real.append(last_vref)
                elif data_type == FMI_INTEGER or data_type == FMI_ENUMERATION:
                    varia_int.append(last_vref)
                elif data_type == FMI_BOOLEAN:
                    varia_bool.append(last_vref)
                else:
                    raise fmi.FMUException("Unknown type detected for variable %s when writing the results."%var.name)
            
            data_info[1,i] = alias*last_index
            data_info[0,i] = last_data_matrix
        
    data_info[0,0] = 0; data_info[1, 0] = 1; data_info[2, 0] = 0; data_info[3, 0] = -1
    
    data = np.append(np.append(np.append(model.time, model.get_real(param_real)),model.get_real(param_int)),model.get_real(param_bool))
    
    return data, varia_real, varia_int, varia_bool

cpdef convert_str_list(list data):
    cdef int length = 0
    cdef int items = len(data)
    cdef int i,j, tmp_length, k
    cdef char *output
    cdef char *tmp
    cdef bytes py_string
    
    for i in range(items):
        data[i] = encode(data[i])
        j = len(data[i])
        if j+1 > length:
            length = j+1
    
    output = <char*>FMIL.calloc(items*length,sizeof(char))
    
    for i in range(items):
        tmp = data[i]
        tmp_length = len(tmp)
        k = i*length
        
        FMIL.memcpy(&output[k], tmp, tmp_length)
        #FMIL.memset(&output[k+tmp_length], ' ', length-tmp_length) #Adding padding, seems to be necessary :(
    
    py_string = output[:items*length]
    
    FMIL.free(output)
    
    return length, py_string

cpdef convert_sorted_vars_name_desc(list sorted_vars):
    cdef int items = len(sorted_vars)
    cdef int i, name_length_trial, desc_length_trial, kd, kn
    cdef list desc = [encode("Time in [s]")]
    cdef list name = [encode("time")]
    cdef int name_length = len(name[0])
    cdef int desc_length = len(desc[0])
    cdef char *desc_output
    cdef char *name_output
    cdef char *ctmp_name
    cdef char *ctmp_desc
    
    for i in range(items):
        var = sorted_vars[i]
        tmp_name = encode(var.name)
        tmp_desc = encode(var.description)
        name.append(tmp_name)
        desc.append(tmp_desc)
        
        name_length_trial = len(tmp_name)
        desc_length_trial = len(tmp_desc)
        
        if name_length_trial+1 > name_length:
             name_length = name_length_trial + 1
        if desc_length_trial+1 > desc_length:
             desc_length = desc_length_trial + 1
    
    desc_output = <char*>FMIL.calloc((items+1)*desc_length,sizeof(char))
    name_output = <char*>FMIL.calloc((items+1)*name_length,sizeof(char))
    
    for i in range(items+1):
        ctmp_name = name[i]
        ctmp_desc = desc[i]
        
        name_length_trial = len(ctmp_name)
        desc_length_trial = len(ctmp_desc)
        kn = i*name_length
        kd = i*desc_length
        
        FMIL.memcpy(&name_output[kn], ctmp_name, name_length_trial)
        FMIL.memcpy(&desc_output[kd], ctmp_desc, desc_length_trial)
    
    py_desc_string = desc_output[:(items+1)*desc_length]
    py_name_string = name_output[:(items+1)*name_length]
    
    FMIL.free(name_output)
    FMIL.free(desc_output)
    
    return name_length, py_name_string, desc_length, py_desc_string
    

cpdef convert_scalarvariable_name_to_str(list data):
    cdef int length = 0
    cdef int items = len(data)
    cdef int i,j, tmp_length, k
    cdef char *output
    cdef char *tmp
    cdef bytes py_string
    
    for i in range(items):
        j = len(data[i].name)
        if j+1 > length:
            length = j+1
    
    output = <char*>FMIL.calloc(items*length,sizeof(char))
    
    for i in range(items):
        py_byte_string = data[i].name#.encode("latin-1")
        tmp = py_byte_string
        tmp_length = len(tmp)
        k = i*length
        
        FMIL.memcpy(&output[k], tmp, tmp_length)
        #FMIL.memset(&output[k+tmp_length], ' ', length-tmp_length) #Adding padding, seems to be necessary :(
    
    py_string = output[:items*length]
    
    FMIL.free(output)
    
    return length, py_string#.encode("latin-1")

"""
class Graph:
    
    def __init__(self, edges):
        self.edges   = edges
        self.nodes   = set(node for node in itertools.chain(*edges))
        self.lowlink = dict([node, -1] for node in self.nodes)
        self.number  = dict([node, -1] for node in self.nodes)
        self.index = 0
        self.stack = []
        self.connected_components = []
        
    def _strongly_connected_components(self, node):
        self.lowlink[node] = self.index
        self.number[node]  = self.index
        
        self.index = self.index + 1
        self.stack.append(node)
        
        for v,w in (edge for edge in self.edges if edge[0] == node):
            if self.number[w] < 0: #Not numbered
                self._strongly_connected_components(w)
                self.lowlink[node] = min(self.lowlink[node], self.lowlink[w])
            elif self.number[w] < self.number[v]:
                if w in self.stack:
                    self.lowlink[node] = min(self.lowlink[node], self.number[w])
                    
        if self.lowlink[node] == self.number[node]:
            #node is the root of a component
            #Start new strong component
            self.connected_components.append([])
            while self.stack and self.number[self.stack[-1]] >= self.number[node]:
                self.connected_components[-1].append(self.stack.pop())
                
    def strongly_connected_components(self):
        for node in self.nodes:
            if self.number[node] < 0:
                self._strongly_connected_components(node)
        return self.connected_components
"""
class OrderedSet(collections.MutableSet):

    def __init__(self, iterable=None):
        self.end = end = [] 
        end += [None, end, end]         # sentinel node for doubly linked list
        self.map = {}                   # key --> [key, prev, next]
        if iterable is not None:
            self |= iterable

    def __len__(self):
        return len(self.map)

    def __contains__(self, key):
        return key in self.map

    def add(self, key):
        if key not in self.map:
            end = self.end
            curr = end[1]
            curr[2] = end[1] = self.map[key] = [key, curr, end]

    def discard(self, key):
        if key in self.map:        
            key, prev, next = self.map.pop(key)
            prev[2] = next
            next[1] = prev

    def __iter__(self):
        end = self.end
        curr = end[2]
        while curr is not end:
            yield curr[0]
            curr = curr[2]

    def __reversed__(self):
        end = self.end
        curr = end[1]
        while curr is not end:
            yield curr[0]
            curr = curr[1]

    def pop(self, last=True):
        if not self:
            raise KeyError('set is empty')
        key = self.end[1][0] if last else self.end[2][0]
        self.discard(key)
        return key

    def __repr__(self):
        if not self:
            return '%s()' % (self.__class__.__name__,)
        return '%s(%r)' % (self.__class__.__name__, list(self))

    def __eq__(self, other):
        if isinstance(other, OrderedSet):
            return len(self) == len(other) and list(self) == list(other)
        return set(self) == set(other)

GRAPH_INPUT  = 0
GRAPH_OUTPUT = 1
GRAPH_SCC    = 2

class Graph:
    
    def __init__(self, edges, graph_info):
        self.edges   = edges
        self.nodes   = OrderedSet(node for node in itertools.chain(*edges))
        self.lowlink = dict([node, -1] for node in self.nodes)
        self.number  = dict([node, -1] for node in self.nodes)
        self.index = 0
        self.stack = []
        self.connected_components = []
        self.graph_info = graph_info
        self._unknown_index = 31415926
        
    def _dfs(self, start_node):
        self.visited_nodes[start_node] = None
        
        for v, w in (edge for edge in self.edges if edge[0] == start_node):
            if not self.visited_nodes.has_key(w):
                self._dfs(w)
                
    def dfs(self, start_node):
        self.visited_nodes = {}
        self._dfs(start_node)
        
        return self.visited_nodes
        
    def join_output_trees(self, connected_components):
        #Reverse order
        connected_components = connected_components[::-1]
        
        trees = {}
        joined_nodes = {}
        
        for node in connected_components:
            if len(node) > 1:
                continue
            node = node[0]
            if self.graph_info[node]["type"] == GRAPH_OUTPUT:
                model = self.graph_info[node]["model"]
                if not trees.has_key(model):
                    trees[model] = OrderedDict()
                    trees[model][node] = self.dfs(node)
                    joined_nodes[node] = [node]
                else:
                    included = False
                    #spanning_tree = self.dfs(node)
                    for out in trees[model].keys():
                        if trees[model][out].has_key(node): #Node is in a previouos spanning tree (cannot join them)
                            pass
                        else:
                            print "Joining: ", out, node
                            joined_nodes[out].append(node)
                            trees[model][out].update(self.dfs(node)) #Can be needed if they are not in the same tree
                            included = True
                            break
                    if not included:
                        joined_nodes[node] = [node]
                        trees[model][node] = self.dfs(node)# spanning_tree
        return trees, joined_nodes
    
    def simple_loop(self, start_node): #Must be output
        visited_nodes = {}
        loop = False
        
        stack = [w for v,w in (edge for edge in self.edges if edge[0] == start_node and self.graph_info[edge[1]]["model"] != self.graph_info[edge[0]]["model"])]
        while stack and not loop:
            e = stack.pop()
            if not visited_nodes.has_key(e):
                visited_nodes[v] = None
                for v,w in (edge for edge in self.edges if edge[0] == e):
                    if w == start_node:
                        loop = True
                        break
                    stack.append(w)
        
        return loop
        
    def _strongly_connected_components(self, node):
        self.lowlink[node] = self.index
        self.number[node]  = self.index
        
        self.index = self.index + 1
        self.stack.append(node)
        
        for v,w in (edge for edge in self.edges if edge[0] == node):
            if self.number[w] < 0: #Not numbered
                self._strongly_connected_components(w)
                self.lowlink[node] = min(self.lowlink[node], self.lowlink[w])
            elif self.number[w] < self.number[v]:
                if w in self.stack:
                    self.lowlink[node] = min(self.lowlink[node], self.number[w])
                    
        if self.lowlink[node] == self.number[node]:
            #node is the root of a component
            #Start new strong component
            self.connected_components.append([])
            while self.stack and self.number[self.stack[-1]] >= self.number[node]:
                self.connected_components[-1].append(self.stack.pop())
                
    def strongly_connected_components(self):
        self.lowlink = dict([node, -1] for node in self.nodes)
        self.number  = dict([node, -1] for node in self.nodes)
        self.index = 0
        self.stack = []
        self.connected_components = []
        
        for node in self.nodes:
            if self.number[node] < 0:
                self._strongly_connected_components(node)
        return self.connected_components
        
    def group_node(self, list connected_component):
        nodes = self.nodes
        edges = self.edges
        
        output = True
        for node in connected_component:
            if self.graph_info[node]["type"] != GRAPH_OUTPUT:
                output = False
                break
        model = True
        for node in connected_component[1:]:
            if self.graph_info[node]["model"] != self.graph_info[connected_component[0]]["model"]:
                model = False
                self._unknown_index = self._unknown_index + 1
                break
        
        new_node = "+".join(connected_component)
        nodes.add(new_node)
        self.graph_info[new_node] = {"type": GRAPH_OUTPUT if output else GRAPH_SCC, "model": self.graph_info[connected_component[0]]["model"] if model else self._unknown_index}
        for j,edge in enumerate(edges):
            if edge[0] in connected_component and edge[1] in connected_component:
                edges[j] = (None, None) #Necessary to remove the current edges
            elif edge[0] in connected_component:
                edges[j] = (new_node, edge[1])
            elif edge[1] in connected_component:
                edges[j] = (edge[0], new_node)
        for node in connected_component:
            nodes.discard(node)
            self.graph_info.pop(node)
        
        #Get unique list
        self.edges = list(OrderedSet([x for x in edges if x != (None,None)]))
        
        return new_node
            
    def tear_node(self, node):
        #Remove edges that belong to node (is output) and that are connected to outputs in the same model
        for j, edge in enumerate(self.edges):
            if (edge[0] == node or edge[1] == node) and self.graph_info[edge[0]]["model"] == self.graph_info[edge[1]]["model"]:
                self.edges[j] = (None, None)
        
        #Get unique list
        self.edges = list(OrderedSet([x for x in self.edges if x != (None,None)]))
        
    def group_connected_components(self, connected_components):
        #Update edges and nodes
        for i,conn in enumerate(connected_components):
            if len(conn) > 1:
                self.group_node(conn)
                connected_components[i] = ["+".join(conn)]
        
    def add_edges_between_outputs(self):
        for node in self.nodes:
            if self.graph_info[node]["type"] == GRAPH_OUTPUT:
                model = self.graph_info[node]["model"]
                for companion_output in self.graph_info[model]["outputs"]:
                    try:
                        self.graph_info[companion_output] #Node is still available? i.e. not in a SCC
                        if node != companion_output: #No edge to itself
                            self.edges.append((node, companion_output))
                    except:
                        pass
        self.edges = list(OrderedSet(self.edges))
        
    def tear_graph(self, connected_components):
        torn_graph = False
        #Update edges and nodes
        for i,conn in enumerate(connected_components):
            if len(conn) > 1: #More than one node
                same_model = True
                model = self.graph_info[conn[0]]["model"]
                for node in conn:
                    if model != self.graph_info[node]["model"]:
                        same_model = False
                        break
                if same_model: #Component complete, only outputs from the same model
                    self.group_node(conn)
                else:
                    torn_graph = True
                    #Needs tearing
                    choices = {}
                    for node in conn:
                        if self.graph_info[node]["type"] == GRAPH_OUTPUT: #Possible choice
                            try:
                                choices[self.graph_info[node]["model"]].append(node) #Weight (external)
                            except KeyError:
                                choices[self.graph_info[node]["model"]] = [node] #Weight (external)
                    valid_choices = {}
                    for model in choices.keys():
                        if len(choices[model]) > 1: #There are nodes that are possible choices for tearing here
                            for node in choices[model]:
                                if self.simple_loop(node): #Produces a loop? At least one node does
                                    valid_choices[node] = 0 #Zero weight
                    for edge in self.edges:
                        try:
                            if self.graph_info[edge[1]]["model"] != self.graph_info[edge[0]]["model"]:
                                valid_choices[edge[0]] += 1
                        except KeyError:
                            pass
                    torn_node = valid_choices.keys()[0]
                    for node in valid_choices.keys():
                        if valid_choices[node] > valid_choices[torn_node]: #If the weight is greater
                            torn_node = node
                            
                    print "Variable to tear: ", torn_node
                    self.tear_node(torn_node)
        
        return torn_graph
        
    def _check_feed_through(self, nodes):
        feed_through = False
        
        for node in nodes:
            for edge in self.edges:
                if edge[0] == node: #This node is connected to an output
                    feed_through = True
                    break
            if feed_through:
                break
        return feed_through
        
    def prepare_graph(self):
        connected_components_first = {}
        connected_components_second = {}
        for node in self.nodes:
            potential = True
            potential_second = False
            if self.graph_info[node]["type"] == GRAPH_OUTPUT:
                model = self.graph_info[node]["model"]
                list_of_connections = []
                for edge in self.edges:
                    if edge[1] == node: #The node is in a direct feed-through
                        potential = False
                    if edge[0] == node: #This node is connected to somewhere
                        list_of_connections.append(edge[1])
                if len(list_of_connections) > 0:
                    potential_second = not self._check_feed_through(list_of_connections)
                #print "Potential: ", potential, node, list_of_connections
                if potential:
                    if connected_components_first.has_key(model):
                        connected_components_first[model].append(node)
                    else:
                        connected_components_first[model] = [node]
                elif potential_second:
                    if connected_components_second.has_key(model):
                        connected_components_second[model].append(node)
                    else:
                        connected_components_second[model] = [node]
        for model in connected_components_first.keys():
            if len(connected_components_first[model]) > 1:
                self.group_node(connected_components_first[model])
        for model in connected_components_second.keys():
            if len(connected_components_second[model]) > 1:
                self.group_node(connected_components_second[model])
        
    def split_components(self, connected_components):
        blocks = []
        for scc in connected_components:
            if isinstance(scc, list): #The scc is a list of components
                blocks.append([])
                for node in scc:
                    blocks[-1].extend(node.split("+"))
            else:
                blocks.append([scc.split("+")])
        
        return blocks
        
    def compute_evaluation_order_old(self):
        SCCs = self.strongly_connected_components()
        
        #print SCCs
        self.group_connected_components(SCCs) #Group the SCCs
        self.add_edges_between_outputs() #Add edges between outputs
        
        while True:
            SCCs = self.strongly_connected_components()
            #print SCCs
            torn = self.tear_graph(SCCs)
            if not torn:
                break
        
        return self.split_components(SCCs)
        
    def compute_evaluation_order(self):
        self.prepare_graph()
        SCCs = self.strongly_connected_components()[::-1]
        #print "Initial SCCs: ", SCCs
        #self.group_connected_components(SCCs) #Group the SCCs
        
        i = 0
        while i < len(SCCs):
            f = SCCs[i]
            b = 0
            #print "Start: ", i, SCCs
            if len(f) == 1 and self.graph_info[f[0]]["type"] == GRAPH_OUTPUT:
                for j in range(i-1):
                    e = SCCs[j]
                    if len(e) == 1 and self.graph_info[e[0]]["type"] == GRAPH_OUTPUT and \
                        self.graph_info[e[0]]["model"] == self.graph_info[f[0]]["model"] and \
                        f[0] not in self.dfs(e[0]).keys():
                            SCCs[j] = [self.group_node(f+e)]
                            SCCs.pop(i)
                            b = 1
                            break
            #print "Middle: ", i, SCCs
            if b == 0:
                i = i +1
            if len(f) > 1:
                #print "Outside: ", i, f
                self.group_node(f)
            #print "End: ", i, SCCs
        
        return self.split_components(self.strongly_connected_components())
        
    def grouped_order(self, connected_components):
        #Update edges and nodes
        self.group_connected_components(connected_components)
        
        roots = []
        for node in self.nodes:
            for edge in self.edges:
                if edge[1] == node: #Not root node
                    break
            else:
                roots.append(node)
        
        graph = {node:[] for node in self.nodes}
        for edge in self.edges:
            graph[edge[0]].append(edge[1])
        
        def set_levels(queue, level):
            new_queue = []
            for ite in queue:
                levels[ite] = level
                new_queue.extend(graph[ite])
            return new_queue
        
        queue = []
        level = 0
        levels = {}
        for root in roots:
            levels[root] = 0
            queue.extend(graph[root])
        while len(queue) > 0:
            level = level + 1
            queue = set_levels(queue, level)

        grouped_connected_components = [[] for i in range(level+1)]
        for node in levels:
            grouped_connected_components[levels[node]].extend(node.split("+"))
        grouped_connected_components.reverse()
        
        return grouped_connected_components
        
    def dump_graph_dot(self, filename, custom_syntax=False):
        """
            digraph {
            node [texmode = "math"];
            u12 -> y12 -> u23 -> y13 -> u21 -> y11 -> u12 -> y22;
            u11 -> y21 -> u22 -> y12;
            y22 -> u13 -> y23;
            u11 [label="u_1^{[1]}", pos="-0.9,4!"];
            u12;// [label="u_1^{[2]}"];
            u22 [label="u_2^{[2]}"];
            u21 [label="u_2^{[1]}"];
            u13;// [label="u_1^{[3]}"];
            u23 [label="u_2^{[3]}"];
            y11 [label="y_1^{[1]}"];
            y21 [label="y_2^{[1]}"];
            y12 [label="y_1^{[2]}"];
            y22;// [label="y_2^{[2]}"];
            y13 [label="y_1^{[3]}"];
            y23;// [label="y_2^{[3]}"];
        }
        """
        with open(filename, 'w') as f:
            f.write('digraph { \n node [texmode = "math"]; \n splines="curved"; \n')
            for edge in self.edges:
                f.write(' "%s" -> "%s" \n'%(edge[0], edge[1]))
            for node in self.nodes:
                if custom_syntax:
                    label=""
                    for n in node.split("+"):
                        spl = n.split("|")
                        label = label+"%s_%s^{[%s]}, "%(spl[0],spl[1],spl[2])
                    label = label[:-2]
                    f.write(' "%s" [color=none, label="%s"] \n'%(node, label))
                else:
                    f.write(' "%s" [color=none, label="%s"] \n'%(node, node))
            f.write('}')

"""
cdef class FastPointSave:
    cdef np.ndarray real_var_ref, 
    cdef np.ndarray int_var_ref, 
    cdef np.ndarray bool_var_ref
    cdef np.ndarray data_order
    cdef np.ndarray _cache
    cdef int nvariables
    cdef object model
    cdef list cache
    cdef np.ndarray data
    cdef int rs, ris, ribs, used_length_cache
    
    def __init__(self, model, np.ndarray[np.uint32_t, ndim=1, mode='c'] real_var_ref, 
                              np.ndarray[np.uint32_t, ndim=1, mode='c'] int_var_ref, 
                              np.ndarray[np.uint32_t, ndim=1, mode='c'] bool_var_ref, 
                              np.ndarray[np.int32_t, ndim=1, mode='c']  data_order, int nvariables):
        
        self.real_var_ref = real_var_ref
        self.int_var_ref  = int_var_ref
        self.bool_var_ref = bool_var_ref
        self.data_order   = data_order
        self.model = model
        self.nvariables = nvariables
        self.cache = range(nvariables-1)
        #self.data = range(nvariables-1)
        self.data = np.empty(nvariables)
        self._cache = np.empty(nvariables-1)
        
        self.rs = self.real_var_ref.size
        self.ris = self.real_var_ref.size+self.int_var_ref.size
        self.ribs = self.real_var_ref.size+self.int_var_ref.size+self.bool_var_ref.size

    def save_point(self):
            cdef int k,j,l
            
            cdef np.ndarray correct_order
            cdef np.ndarray[double, ndim=1, mode='c'] r
            cdef np.ndarray[int,    ndim=1, mode='c'] i
            cdef np.ndarray b

            #Retrieves the time-point
            r = self.model.get_real(self.real_var_ref)
            i = self.model.get_integer(self.int_var_ref)
            b = self.model.get_boolean(self.bool_var_ref)
            
            for k in range(self.rs):
                self.data[k] = r[k]
            for k in range(self.rs, self.ris):
                self.data[k] = i[k-self.rs]
            for k in range(self.ris, self.ribs):
                self.data[k] = b[k-self.ris]
            
            return self._create_string(self.data)
    
    cpdef _create_string(self, np.ndarray[double, ndim=1, mode='c'] data):
        cdef int j, used_length_cache, cn = 0
        cdef char temp_str[4094]
        cdef char* temp_str_ptr = &temp_str[0]
        
        used_length_cache = 0
        for j in range(0, self.nvariables-5, 5):
        #    self.cache[j] = " %.14E"%self.data[self.data_order[j]]
            #temp_str_ptr += FMIL.sprintf(temp_str_ptr, " %.14E", <double>data[self.data_order[j]])
            #cn += FMIL.snprintf(temp_str_ptr+cn, 4094, " %.14E", <double>data[self.data_order[j]])
            cn += FMIL.snprintf(temp_str_ptr+cn, 4094, " %.14E %.14E %.14E %.14E %.14E", 
                                                <double>data[self.data_order[j]],
                                                <double>data[self.data_order[j+1]],
                                                <double>data[self.data_order[j+2]],
                                                <double>data[self.data_order[j+3]],
                                                <double>data[self.data_order[j+4]])
            if j > 0 and not (j) % 150:
                self.cache[used_length_cache] = temp_str
                used_length_cache += 1
                cn = 0
                temp_str_ptr = &temp_str[0]
        else:
            for j in range(j, self.nvariables-1):
                cn += FMIL.snprintf(temp_str_ptr+cn, 4094, " %.14E", <double>data[self.data_order[j]])
        if j % 150:
            self.cache[used_length_cache] = temp_str[:cn]
            used_length_cache += 1
            
        return self._join_string(used_length_cache)
    
    cpdef _join_string(self, int used_length_cache):
        cdef int j
        
        return "%.14E "%self.model.time + ' '.join(self.cache[:used_length_cache])

        
        
"""


