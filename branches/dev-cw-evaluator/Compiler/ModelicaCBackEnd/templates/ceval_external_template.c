/*
    Copyright (C) 2015-2018 Modelon AB

    This program is free software: you can redistribute it and/or modify
    it under the terms of the Common Public License as published by
    IBM, version 1.0 of the License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY. See the Common Public License for more details.

    You should have received a copy of the Common Public License
    along with this program. If not, see
    <http://www.ibm.com/developerworks/library/os-cpl.html/>.
*/

#include "jmi_evaluator_util.h"

$ECE_external_includes$
 
/* Used record definitions */
$ECE_record_definitions$

/* Main */
int main(int argc, const char* argv[])
{
    /* Size buffer for reading array dimensions */
    int d[25];
    
    /* Indices for parsing/printing vars, dimensions */
    size_t vi,di;
    
$ECE_decl$
$ECE_setup_decl$

    JMCEVAL_setup(); /* This needs to happen first */

    JMCEVAL_check("START");
    if (JMCEVAL_try()) {
        JMI_DYNAMIC_INIT()
        /* Init phase */
$ECE_setup_init$
        JMI_DYNAMIC_FREE()
    } else {
        JMCEVAL_failed();
    }
    
    JMCEVAL_check("READY");
    while (JMCEVAL_cont("EVAL\n")) {
        JMI_DYNAMIC_INIT()
$ECE_calc_decl$
$ECE_calc_init$
        JMCEVAL_check("CALC");
        if (JMCEVAL_try()) {
            /* Calc phase */
$ECE_calc$
        } else {
            JMCEVAL_failed();
        }
$ECE_calc_free$
        JMI_DYNAMIC_FREE()
        JMCEVAL_check("READY");
    }

    if (JMCEVAL_try()) {
        /* End phase */
$ECE_free$
$ECE_setup_free$
    } else {
        JMCEVAL_failed();
    }
    JMCEVAL_check("END");
    return 0;
}

