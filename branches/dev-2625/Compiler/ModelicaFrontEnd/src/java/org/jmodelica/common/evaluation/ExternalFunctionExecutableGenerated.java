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
        // The first attempt to delete may fail if the process has not terminated yet.
        // Possibly not necessary since LiveExternalFunction.destroyProcess() now calls ProcessCommunicator.teardown().
        if (!success) {
            try {
                Thread.sleep(10); // Sleep some arbitrary duration to give the process time to die.
            } catch (InterruptedException e) {
                // Ignore
            }
            success = file.delete();
        }
    }
}
