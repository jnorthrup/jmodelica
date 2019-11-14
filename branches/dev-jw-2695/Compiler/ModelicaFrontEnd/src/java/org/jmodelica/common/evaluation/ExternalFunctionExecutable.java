package org.jmodelica.common.evaluation;

abstract class ExternalFunctionExecutable {
    
    public abstract ProcessBuilder createProcessBuilder();
    
    public abstract void remove();
}
