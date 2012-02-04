#!/usr/bin/env python 
# -*- coding: utf-8 -*-

#    Copyright (C) 2009 Modelon AB
#
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, version 3 of the License.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#    You should have received a copy of the GNU General Public License
#    along with this program.  If not, see <http://www.gnu.org/licenses/>.
"""
Module for writing optimization and simulation results to file.
"""
from operator import itemgetter
import array
import codecs

import numpy as N
import scipy.io

import xmlparser

class Trajectory:
    """
    Class for storing a time series.
    """
    
    def __init__(self,t,x):
        """
        Constructor for the Trajectory class.

        Parameters::
        
            t --
                Abscissa of the trajectory.
            x --
                The ordinate of the trajectory.

        """
        self.t = t
        self.x = x

class ResultDymolaTextual:
    """ 
    Class representing a simulation or optimization result loaded from a Dymola 
    binary file.
    """

    def __init__(self,fname):
        """
        Load a result file written on Dymola textual format.

        Parameters::
        
            fname --
                Name of file.
        """
        fid = codecs.open(fname,'r','utf-8')
        
        result  = [];
     
        # Read Aclass section
        nLines = self._find_phrase(fid, 'char Aclass')

        nLines = int(nLines[0])
        Aclass = []
        for i in range(0,nLines):
            Aclass.append(fid.readline().strip())
        self.Aclass = Aclass

        # Read name section
        nLines = self._find_phrase(fid, 'char name')

        nLines = int(nLines[0])
        name = []
        for i in range(0,nLines):
            name.append(fid.readline().strip().replace(" ",""))
        self.name = name
     
        # Read description section  
        nLines = self._find_phrase(fid, 'char description') 

        nLines = int(nLines[0])
        description = []
        for i in range(0,nLines):
            description.append(fid.readline().strip())
        self.description = description

        # Read dataInfo section
        nLines = self._find_phrase(fid, 'int dataInfo')

        nCols = nLines[2].partition(')')
        nLines = int(nLines[0])
        nCols = int(nCols[0])
        dataInfo = []
        for i in range(0,nLines):
            info = fid.readline().split()
            dataInfo.append(map(int,info[0:nCols]))
        self.dataInfo = N.array(dataInfo)

        # Find out how many data matrices there are
        nData = 0
        for i in range(0,nLines):
            if dataInfo[i][0] > nData:
                nData = dataInfo[i][0]
                
        self.data = []
        for i in range(0,nData): 
            l = fid.readline()
            tmp = l.partition(' ')
            while tmp[0]!='float' and tmp[0]!='double' and l!='':
                l = fid.readline()
                tmp = l. partition(' ')
            if l=='':
                raise JIOError('The result does not seem to be of a supported format.')
            tmp = tmp[2].partition('(')
            nLines = tmp[2].partition(',')
            nCols = nLines[2].partition(')')
            nLines = int(nLines[0])
            nCols = int(nCols[0])
            data = []
            for i in range(0,nLines):
                info = []
                while len(info) < nCols:
                    l = fid.readline()
                    info.extend(l.split())
                try:
                    data.append(map(float,info[0:nCols]))
                except ValueError: #Handle 1.#INF's and such
                    data.append(map(robust_float,info[0:nCols]))
                del(info)
            self.data.append(N.array(data))
            
    def _find_phrase(self,fid, phrase):
        l = fid.readline()
        tmp = l.partition('(')
        while tmp[0]!=phrase and l!='':
            l = fid.readline()
            tmp = l. partition('(')
        if l=='':
            raise JIOError("The result does not seem to be of a supported format.")
        return tmp[2].partition(',')

    def get_variable_index(self,name): 
        """
        Retrieve the index in the name vector of a given variable.
        
        Parameters::
        
            name --
                Name of variable.
        
        Returns::
        
            In integer index.
        """
        try:
            return self.name.index(name)
        except ValueError, ex:
            raise VariableNotFoundError("Cannot find variable " +
                                        name + " in data file.")
            
    def get_variable_data(self,name):
        """
        Retrieve the data sequence for a variable with a given name.
        
        Parameters::
        
            name --
                Name of the variable.

        Returns::
        
            A Trajectory object containing the time vector and the data vector 
            of the variable.
        """
        if name == 'time':
            #return self.data[1][:,0]
            return Trajectory(self.data[1][:,0],self.data[1][:,0])
        else:
            varInd  = self.get_variable_index(name)
            dataInd = self.dataInfo[varInd][1]
            factor = 1
            if dataInd<0:
                factor = -1
                dataInd = -dataInd -1
            else:
                dataInd = dataInd - 1
            dataMat = self.dataInfo[varInd][0]-1
            # Take into account that the 'Time' variable has data matrix index 0,
            # which means that it is
            if dataMat<0:
                dataMat = 0
            return Trajectory(
                self.data[dataMat][:,0],factor*self.data[dataMat][:,dataInd])
            #if dataMat == 0:
            #    return factor*self.data[dataMat][0,dataInd]
            #else:
            #    return factor*self.data[dataMat][:,dataInd]
        
    def is_variable(self, name):
        """
        Returns True if the given name corresponds to a time-varying variable.
        
        Parameters::
        
            name -- 
                Name of the variable/parameter/constant
                
        Returns::
        
            True if the variable is time-varying.
        """
        if name == 'time':
            return True
        varInd  = self.get_variable_index(name)
        dataMat = self.dataInfo[varInd][0]-1
        if dataMat<0:
            dataMat = 0
        
        if dataMat == 0:
            return False
        else:
            return True
            
    def is_negated(self, name):
        """
        Returns True if the given name corresponds to a negated result vector.
        
        Parameters::
        
            name -- 
                Name of the variable/parameter/constant.
                
        Returns::
        
            True if the result should be negated
        """
        varInd  = self.get_variable_index(name)
        dataInd = self.dataInfo[varInd][1]
        if dataInd<0:
            return True
        else:
            return False
    
    def get_column(self, name):
        """
        Returns the column number in the data matrix where the values of the 
        variable are stored.
        
        Parameters::
        
            name -- 
                Name of the variable/parameter/constant.
            
        Returns::
        
            The column number.
        """
        if name == 'time':
            return 0

        if not self.is_variable(name):
            raise VariableNotTimeVarying("Variable " +
                                        name + " is not time-varying.")
        varInd  = self.get_variable_index(name)
        dataInd = self.dataInfo[varInd][1]
        factor = 1
        if dataInd<0:
            factor = -1
            dataInd = -dataInd -1
        else:
            dataInd = dataInd - 1
            
        return dataInd
        
    def get_data_matrix(self):
        """
        Returns the result matrix.
        
        Returns::
        
            The result data matrix.
        """
        return self.data[1]

    def shift_time(self,time_shift):
        """
        Shift the time vector using a fixed offset.

        Parameters::
            time_shift --
                The time shift offset.
        """
        for i in range(len(self.data)):
            for j in range(N.shape(self.data[i])[0]):
                self.data[i][j,0] = self.data[i][j,0] + time_shift

    def append(self, res):
        """
        Append another simulation result. The time vector of the appended
        trajectories is shifted so that the appended trajectories appears
        after the original result trajectories.

        Parameters::
            res --
                A simulation result object of type DymolaResultTextual.
        """
        n_points = N.size(res.data[1],0)
        time_shift = self.data[1][-1,0]
        self.data[1] = N.vstack((self.data[1],res.data[1]))
        self.data[1][n_points:,0] = self.data[1][n_points:,0] + time_shift 

class ResultDymolaBinary:
    """ 
    Class representing a simulation or optimization result loaded from a Dymola 
    binary file.
    """

    def __init__(self,fname):
        """
        Load a result file written on Dymola binary format.

        Parameters::
        
            fname --
                Name of file.
        """
        self.raw = scipy.io.loadmat(fname,chars_as_strings=False)
        name = self.raw['name']
        self.name = [
            array.array(
                'u',
                name[:,i].tolist()).tounicode().rstrip().replace(" ","") \
                for i in range(0,name[0,:].size)]
        description = self.raw['description']
        self.description = [
            array.array(
                'u',
                description[:,i].tolist()).tounicode().rstrip() \
                for i in range(0,description[0,:].size)]
        
    def get_variable_index(self,name): 
        """
        Retrieve the index in the name vector of a given variable.
        
        Parameters::
        
            name --
                Name of variable.

        Returns::
        
            In integer index.
        """
        try:
            return self.name.index(name)
        except ValueError, ex:
            raise VariableNotFoundError("Cannot find variable " +
                                        name + " in data file.")
       
    def get_variable_data(self,name):
        """
        Retrieve the data sequence for a variable with a given name.
        
        Parameters::
        
            name --
                Name of the variable.

        Returns::
        
            A Trajectory object containing the time vector and the data vector 
            of the variable.
        """
        if name == 'time':
            #return self.raw['data_%d'%2][0,:]
            return Trajectory(self.raw['data_%d'%2][0,:],self.raw['data_%d'%2][0,:])
        else:
            varInd  = self.get_variable_index(name)
            dataInd = self.raw['dataInfo'][1][varInd]
            dataMat = self.raw['dataInfo'][0][varInd]
            factor = 1
            if dataInd<0:
                factor = -1
                dataInd = -dataInd -1
            else:
                dataInd = dataInd - 1
            
            # Take into account that the 'Time' variable has data matrix index 0
                
            if dataMat<1:
                dataMat = 1
            return Trajectory(self.raw['data_%d'%dataMat][0,:],factor*self.raw['data_%d'%dataMat][dataInd,:])
            
            #if dataMat == 1:
            #    return factor*self.raw['data_%d'%dataMat][dataInd,0]
            #else:
            #    return factor*self.raw['data_%d'%dataMat][dataInd,:]
    
    def is_variable(self, name):
        """
        Returns True if the given name corresponds to a time-varying variable.
        
        Parameters::
        
            name -- 
                Name of the variable/parameter/constant.
                
        Returns::
        
            True if the variable is time-varying.
        """
        if name == 'time':
            return True
        varInd  = self.get_variable_index(name)
        dataMat = self.raw['dataInfo'][0][varInd]
        if dataMat<1:
            dataMat = 1
        
        if dataMat == 1:
            return False
        else:
            return True
            
    def is_negated(self, name):
        """
        Returns True if the given name corresponds to a negated result vector.
        
        Parameters::
        
            name -- 
                Name of the variable/parameter/constant.
                
        Returns::
        
            True if the result should be negated
        """
        varInd  = self.get_variable_index(name)
        dataInd = self.raw['dataInfo'][1][varInd]
        if dataInd<0:
            return True
        else:
            return False
    
    def get_column(self, name):
        """
        Returns the column number in the data matrix where the values of the 
        variable are stored.
        
        Parameters::
        
            name -- 
                Name of the variable/parameter/constant.
            
        Returns::
        
            The column number.
        """
        if name == 'time':
            return 0
        
        if not self.is_variable(name):
            raise VariableNotTimeVarying("Variable " +
                                        name + " is not time-varying.")
        varInd  = self.get_variable_index(name)
        dataInd = self.raw['dataInfo'][1][varInd]
        factor = 1
        if dataInd<0:
            factor = -1
            dataInd = -dataInd -1
        else:
            dataInd = dataInd - 1
            
        return dataInd
    
    def get_data_matrix(self):
        """
        Returns the result matrix.
                
        Returns::
        
            The result data matrix.
        """
        return self.raw['data_%d'%2]
        
class ResultWriter():
    """ 
    Base class for writing results to file. 
    """
    
    def write_header():
        """ 
        The header is intended to be used for writing general information about 
        the model. This is intended to be called once.
        """
        pass
        
    def write_point():
        """ 
        This method does the writing of the actual result. 
        """
        pass
        
    def write_finalize():
        """ 
        The finalize method can be used to for instance close the file.
        """
        pass
        

class ResultWriterDymola(ResultWriter):
    """ 
    Export an optimization or simulation result to file in Dymola's result file 
    format.
    """
    def __init__(self, model, format='txt'):
        """
        Export an optimization or simulation result to file in Dymolas result 
        file format.

        Parameters::
        
            model --
                A FMIModel object.
            
            format --
                A text string equal either to 'txt' for textual format or 'mat' 
                for binary Matlab format.
                Default: 'txt'

        Limitations::
        
            Currently only textual format is supported.
        """
        self.model = model
        
        if format!='txt':
            raise JIOError('The format is currently not supported.')
        
        #Internal values
        self._file_open = False
        self._npoints = 0
        
    
    def write_header(self, file_name=''):
        """
        Opens the file and writes the header. This includes the information 
        about the variables and a table determining the link between variables 
        and data.
        
        Parameters::
        
            file_name --
                If no file name is given, the name of the model (as defined by 
                FMUModel.get_identifier()) concatenated with the string '_result' is 
                used. A file suffix equal to the format argument is then 
                appended to the file name.
                Default: Empty string.
        """
        if file_name=='':
            file_name=self.model.get_identifier() + '_result.txt'

        # Open file
        f = codecs.open(file_name,'w','utf-8')
        self._file_open = True
        
        # Write header
        f.write('#1\n')
        f.write('char Aclass(3,11)\n')
        f.write('Atrajectory\n')
        f.write('1.1\n')
        f.write('\n')
        
        # all lists that we need for later
        vrefs_alias = []
        vrefs_noalias = []
        vrefs = []
        names_alias = []
        names_noalias = []
        names = []
        aliases_alias = []
        aliases = []
        descriptions_alias = []
        descriptions = []
        variabilities_alias = []
        variabilities_noalias = []
        variabilities = []
        types_alias = []
        types_noalias = []
        types = []
        
        for var in self.model._md.get_model_variables():
            ftype = var.get_fundamental_type()
            if not isinstance(ftype,xmlparser.String) and \
                not isinstance(ftype,xmlparser.Enumeration):
                    if var.get_alias() == xmlparser.NO_ALIAS:
                        vrefs_noalias.append(var.get_value_reference())
                        names_noalias.append(var.get_name())
                        aliases.append(var.get_alias())
                        descriptions.append(var.get_description())
                        variabilities_noalias.append(var.get_variability())
                        types_noalias.append(
                            xmlparser._translate_fundamental_type(ftype))
                    else:
                        vrefs_alias.append(var.get_value_reference())
                        names_alias.append(var.get_name())
                        aliases_alias.append(var.get_alias())
                        descriptions_alias.append(var.get_description())
                        variabilities_alias.append(var.get_variability())
                        types_alias.append(
                            xmlparser._translate_fundamental_type(ftype))
                        
        # need to save these no alias lists for later
        vrefs = vrefs_noalias[:]
        names = names_noalias[:]
        types = types_noalias[:]
        variabilities = variabilities_noalias[:]
        
        # merge lists
        vrefs.extend(vrefs_alias)
        names.extend(names_alias)
        aliases.extend(aliases_alias)
        descriptions.extend(descriptions_alias)
        variabilities.extend(variabilities_alias)
        types.extend(types_alias)
        
        # zip to list of tuples and sort - non alias variables are now
        # guaranteed to be first in list
        names_noalias = sorted(zip(
            tuple(vrefs_noalias), 
            tuple(names_noalias)), 
            key=itemgetter(0))
        variabilities_noalias = sorted(zip(
            tuple(vrefs_noalias), 
            tuple(variabilities_noalias)), 
            key=itemgetter(0))
        types_noalias = sorted(zip(
            tuple(vrefs_noalias), 
            tuple(types_noalias)), 
            key=itemgetter(0))
        names = sorted(zip(
            tuple(vrefs), 
            tuple(names)), 
            key=itemgetter(0))
        aliases = sorted(zip(
            tuple(vrefs), 
            tuple(aliases)), 
            key=itemgetter(0))
        descriptions = sorted(zip(
            tuple(vrefs), 
            tuple(descriptions)), 
            key=itemgetter(0))
        variabilities = sorted(zip(
            tuple(vrefs), 
            tuple(variabilities)), 
            key=itemgetter(0))
        types = sorted(zip(
            tuple(vrefs), 
            tuple(types)), 
            key=itemgetter(0))
        
        num_vars = len(names)

        # Find the maximum name and description length
        max_name_length = len('Time')
        max_desc_length = len('Time in [s]')
        
        for i in range(len(names)):
            name = names[i][1]
            desc = descriptions[i][1]
            
            if (len(name)>max_name_length):
                max_name_length = len(name)
                
            if (len(desc)>max_desc_length):
                max_desc_length = len(desc)

        f.write('char name(%d,%d)\n' % (num_vars+1, max_name_length))
        f.write('time\n')

        for name in names:
            f.write(name[1] +'\n')

        f.write('\n')

        # Write descriptions       
        f.write('char description(%d,%d)\n' % (num_vars + 1, max_desc_length))
        f.write('Time in [s]\n')

        # Loop over all variables, not only those with a description
        for desc in descriptions:
            f.write(desc[1] +'\n')
                
        f.write('\n')

        # Write data meta information
        
        f.write('int dataInfo(%d,%d)\n' % (num_vars + 1, 4))
        f.write('0 1 0 -1 # time\n')
        
        list_of_continuous_states = N.append(self.model._save_cont_valueref[0], 
            self.model._save_cont_valueref[1])
        list_of_continuous_states = N.append(list_of_continuous_states, 
            self.model._save_cont_valueref[2]).tolist()
        list_of_continuous_states = dict(zip(list_of_continuous_states, 
            xrange(len(list_of_continuous_states))))
        valueref_of_continuous_states = []
        
        cnt_1 = 1
        cnt_2 = 1
        n_parameters = 0
        datatable1 = False
        for i, name in enumerate(names):
            if aliases[i][1] == 0: # no alias
                if variabilities[i][1] == xmlparser.PARAMETER or \
                    variabilities[i][1] == xmlparser.CONSTANT:
                    cnt_1 += 1
                    n_parameters += 1
                    f.write('1 %d 0 -1 # ' % cnt_1 + name[1]+'\n')
                    datatable1 = True
                else:
                    cnt_2 += 1
                    valueref_of_continuous_states.append(
                        list_of_continuous_states[name[0]])
                    f.write('2 %d 0 -1 # ' % cnt_2 + name[1] +'\n')
                    datatable1 = False
                
            elif aliases[i][1] == 1: # alias
                if datatable1:
                    f.write('1 %d 0 -1 # ' % cnt_1 + name[1]+'\n')
                else:
                    f.write('2 %d 0 -1 # ' % cnt_2 + name[1] +'\n')
            else:
                if datatable1:
                    f.write('1 -%d 0 -1 # ' % cnt_1 + name[1]+'\n')
                else:
                    f.write('2 -%d 0 -1 # ' % cnt_2 + name[1] +'\n')

        f.write('\n')

        # Write data
        # Write data set 1
        f.write('float data_1(%d,%d)\n' % (2, n_parameters + 1))
        f.write("%.14E" % self.model.time)
        str_text = ''
        
        # write constants and parameters
        for i, name in enumerate(names_noalias):
            if variabilities_noalias[i][1] == xmlparser.CONSTANT or \
                variabilities_noalias[i][1] == xmlparser.PARAMETER:
                    if types_noalias[i][1] == xmlparser.REAL:
                        str_text = str_text + (
                            " %.14E" % (self.model.get_real([name[0]])))
                    elif types_noalias[i][1] == xmlparser.INTEGER:
                        str_text = str_text + (
                            " %.14E" % (self.model.get_integer([name[0]])))
                    elif types_noalias[i][1] == xmlparser.BOOLEAN:
                        str_text = str_text + (
                            " %.14E" % (float(
                                self.model.get_boolean([name[0]])[0])))
                        
        f.write(str_text)
        f.write('\n')
        self._point_last_t = f.tell()
        f.write("%s" % ' '*28)
        f.write(str_text)

        f.write('\n\n')
        
        self._nvariables = len(valueref_of_continuous_states)+1
        
        
        f.write('float data_2(')
        self._point_npoints = f.tell()
        f.write(' '*(14+4+14))
        f.write('\n')
        
        #f.write('%s,%d)\n' % (' '*14, self._nvariables))
        
        self._file = f
        self._data_order = valueref_of_continuous_states
        
    def write_point(self, data=None):
        """ 
        Writes the current status of the model to file. If the header has not 
        been written previously it is written now. If data is specified it is 
        written instead of the current status.
        
        Parameters::
            
                data --
                    A one dimensional array of variable trajectory data. data 
                    should consist of information about the status in the order 
                    specified by FMUModel.save_time_point()
                    Default: None
        """
        f = self._file
        data_order = self._data_order

        #If data is none, store the current point from the model
        if data==None:
            #Retrieves the time-point
            [r,i,b] = self.model.save_time_point()
            data = N.append(N.append(N.append(self.model.time,r),i),b)

        #Write the point
        str_text = (" %.14E" % data[0])
        for j in xrange(self._nvariables-1):
            str_text = str_text + (" %.14E" % (data[1+data_order[j]]))
        f.write(str_text+'\n')
        
        #Update number of points
        self._npoints+=1

    def write_finalize(self):
        """ 
        Finalize the writing by filling in the blanks in the created file. The 
        blanks consists of the number of points and the final time (in data set 
        1). Also closes the file.
        """
        #If open, finalize and close
        if self._file_open:
            
            f = self._file
            
            f.seek(self._point_last_t)
            
            f.write('%.14E'%self.model.time)
            
            f.seek(self._point_npoints)
            f.write('%d,%d)' % (self._npoints, self._nvariables))
            #f.write('%d'%self._npoints)
            f.seek(-1,2)
            #Close the file
            f.write('\n')
            f.close()
            self._file_open = False
    
    
class JIOError(Exception):
    """ 
    Base class for exceptions specific to this module.
    """
    
    def __init__(self, message):
        """ 
        Create new error with a specific message. 
        
        Parameters::
        
            message --
                The error message.
        """
        self.message = message
        
    def __str__(self):
        """ 
        Print error message when class instance is printed.
         
        Overrides the general-purpose special method such that a string 
        representation of an instance of this class will be the error message.
        """
        return self.message


class VariableNotFoundError(JIOError):
    """ 
    Exception that is thrown when a variable is not found in a data file.
    """
    pass
    
class VariableNotTimeVarying(JIOError):
    """
    Exception that is thrown when a column is asked for a parameter/constant.
    """
    pass 
    
def robust_float(value):
    """
    Function for robust handling of float values such as INF and NAN.
    """
    try:
        return float(value)
    except ValueError:
        if value.startswith("1.#INF"):
            return float(N.inf)
        elif value.startswith("-1.#INF"):
            return float(-N.inf)
        elif value.startswith("1.#QNAN") or value.startswith("-1.#IND"):
            return float(N.nan)
        else:
            raise ValueError
