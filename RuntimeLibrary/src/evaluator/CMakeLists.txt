#    Copyright (C) 2014 Modelon AB

#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License version 3 as published
#    by the Free Software Foundation, or optionally, under the terms of the
#    Common Public License version 1.0 as published by IBM.

#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License, or the Common Public License, for more details.

#    You should have received copies of the GNU General Public License
#    and the Common Public License along with this program.  If not,
#    see <http://www.gnu.org/licenses/> or
#    <http://www.ibm.com/developerworks/library/os-cpl.html/> respectively.

# NOTE: CMake 2.8.6 is required since this is the version used in development.
# The script is KNOWN NOT TO WORK WITH 2.8.3 and below (ExternalProject 
# interface changes). CMake 2.8.4 and 2.8.5 are not tested.
cmake_minimum_required (VERSION 2.8.6 FATAL_ERROR)

if(NOT TOP_SRC)    
    set(TOP_SRC ${CMAKE_CURRENT_SOURCE_DIR}/../../../)
    message(STATUS "TOP_SRC was not defined, using ${TOP_SRC}")
endif()

set(EvaluatorSources
    jmi_evaluator.c
)

set(EvaluatorSourcesUtil
    jmi_evaluator_util.c
    jmi_evaluator_util.h
)

#Build jmi_evaluator_util library
add_library(jmi_evaluator_util STATIC ${EvaluatorSourcesUtil})
if(NOT MSVC)
    set_target_properties(jmi_evaluator_util PROPERTIES COMPILE_FLAGS "-Wall -g -std=c89 -pedantic -O2")
endif()

#Build evaluator executable
set (EVALUATOR_LIBS ${EVALUATOR_LIBS} jmi_evaluator_util jmi ModelicaExternalC)

include_directories(${STANDARD_HEADER_SRC})
add_executable(jmi_evaluator ${EvaluatorSources})
if(NOT MSVC)
    set_target_properties(jmi_evaluator PROPERTIES COMPILE_FLAGS "-Wall -g -std=c89 -pedantic -O2")
    IF (NOT WIN32)
        set (EVALUATOR_LIBS ${EVALUATOR_LIBS} dl)
    endif()
endif()
target_link_libraries (jmi_evaluator  ${EVALUATOR_LIBS})

#Install the libraries
if (NOT MSVC)
    install(TARGETS jmi_evaluator DESTINATION "${RTLIB_BIN_DIR}")
    install(TARGETS jmi_evaluator_util DESTINATION "${RTLIB_LIB_DIR}")
endif()

#Install header files
install(DIRECTORY "${CMAKE_CURRENT_SOURCE_DIR}/"
        DESTINATION "${RTLIB_INCLUDE_DIR}"
        FILES_MATCHING PATTERN "*.h")
