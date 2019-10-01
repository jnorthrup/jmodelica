package org.jmodelica.common.evaluation;

import java.util.ArrayList;

class DynamicExternalFunctionExecutable extends ExternalFunctionExecutable {
    private ArrayList<String> executable;
    
    public DynamicExternalFunctionExecutable(ArrayList<String> executable) {
        this.executable = executable;
    }
    
    @Override
    public ProcessBuilder createProcessBuilder() {
        return new ProcessBuilder(executable);
    }
    @Override
    public void remove() {
        // Do not remove the dynamic executable
    }
}
