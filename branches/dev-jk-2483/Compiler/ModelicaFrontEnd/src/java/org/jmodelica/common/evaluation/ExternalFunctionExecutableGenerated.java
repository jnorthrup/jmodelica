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
        File file = new File(executable);
        boolean success = file.delete();
        if (!success) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // Ignore
            }
            success = file.delete();
        }
    }
}
