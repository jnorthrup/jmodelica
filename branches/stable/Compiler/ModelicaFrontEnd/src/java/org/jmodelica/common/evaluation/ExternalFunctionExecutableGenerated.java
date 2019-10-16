package org.jmodelica.common.evaluation;

import java.io.File;

class ExternalFunctionExecutableGenerated extends ExternalFunctionExecutable {
    private String executable;
    
    public ExternalFunctionExecutableGenerated(String executable) {
        this.executable = executable;
    }
    
    @Override
    public ProcessBuilder createProcessBuilder() {
        return new ProcessBuilder(executable);
    }
    
    @Override
    public void remove() {
        new File(executable).delete();
    }
}
