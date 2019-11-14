#
#	Copyright (C) 2019 Modelon AB
#
#	This program is free software: you can redistribute it and/or modify
#	it under the terms of the GNU General Public License version 3 as published 
#	by the Free Software Foundation, or optionally, under the terms of the 
#	Common Public License version 1.0 as published by IBM.
#
#	This program is distributed in the hope that it will be useful,
#	but WITHOUT ANY WARRANTY; without even the implied warranty of
#	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#	GNU General Public License, or the Common Public License, for more details.
#
#	You should have received copies of the GNU General Public License
#	and the Common Public License along with this program.  If not, 
#	see <http://www.gnu.org/licenses/> or 
#	<http://www.ibm.com/developerworks/library/os-cpl.html/> respectively.

# Minimum required version of CMake
CMAKE_MINIMUM_REQUIRED(VERSION 2.8)
IF(COMMAND CMAKE_POLICY)
  CMAKE_POLICY(SET CMP0003 NEW)
ENDIF(COMMAND CMAKE_POLICY)

# Set CMake project name
PROJECT(SUPERLU)

if(NOT SUPERLU_INSTALL_DIR)
set(SUPERLU_INSTALL_DIR )
endif(NOT SUPERLU_INSTALL_DIR)

if(MSVC)
    ADD_DEFINITIONS(/D __OPENMP)
    set(SUPERLU_SUFFIX _OPENMP)
else()
    set(SUPERLU_SUFFIX )
endif()

if(NOT USE_CBLAS)
    find_package(BLAS REQUIRED)
    if (BLAS_FOUND)
        message (STATUS "BLAS_INCLUDE_DIRS=${BLAS_INCLUDE_DIRS}")
        message (STATUS "BLAS_LIBRARIES=${BLAS_LIBRARIES}")
    endif() 
    add_definitions(-DUSE_VENDOR_BLAS)
else()
    add_subdirectory(cblas)
    set(BLAS_LIBRARIES superlu_cblas)
endif(NOT USE_CBLAS)


add_subdirectory(src)

