package org.jmodelica.common.evaluation;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.jmodelica.common.evaluation.ExternalProcessMultiCache.External;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Type;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Value;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Variable;
import org.jmodelica.util.EnvironmentUtils;
import org.jmodelica.util.ccompiler.CCompilerDelegator;

/**
 * Represents an external function that has been compiled successfully.
 */
class ExternalFunctionImpl<K extends Variable<V, T>, V extends Value, T extends Type<V>, E extends External<K>> implements ExternalFunction<K, V> {
    ExternalFunctionCompiler<K, E> compiler;
    ExternalFunctionExecutable extFunctionExecutable;
    ProcessBuilder processBuilder;
    private String msg;

    public ExternalFunctionImpl(ExternalFunctionCompiler<K, E> compiler, External<K> ext, ExternalFunctionExecutable extFunctionExecutable) {
        this.compiler = compiler;
        this.extFunctionExecutable = extFunctionExecutable;
        this.processBuilder = createProcessBuilder(ext);
        this.msg = "Succesfully compiled external function '" + ext.getName() + "'";
    }

    @Override
    public String getMessage() {
        return msg;
    }

    protected ProcessCommunicator<V, T> createProcessCommunicator() throws IOException {
        return new ProcessCommunicator<V, T>(compiler, processBuilder.start());
    }

    @Override
    public int evaluate(External<K> ext, Map<K, V> values, int timeout) throws IOException {
        compiler.log().debug("Evaluating compiled external function: " + ext.getName());
        ProcessCommunicator<V, T> com = null;
        try {
            com = createProcessCommunicator();
            setup(ext, values, timeout, com);
            evaluate(ext, values, timeout, com);
            return com.teardown(timeout);
        } finally {
            if (com != null) {
                com.destroy();
            }
        }
    }

    public void setup(External<K> ext, Map<K, V> values, int timeout, ProcessCommunicator<V, T> com)
            throws IOException {
        com.startTimer(timeout);
        com.accept("START");
        for (K eo : ext.externalObjectsToSerialize()) {
            com.put(values.containsKey(eo) ? values.get(eo) : eo.ceval(), eo.type());
        }
        com.accept("READY");
        com.cancelTimer();
    }

    public void evaluate(External<K> ext, Map<K, V> values, int timeout, ProcessCommunicator<V, T> com)
            throws IOException {
        com.startTimer(timeout);
        com.check("EVAL");

        for (K arg : ext.functionArgsToSerialize()) {
            com.put(values.containsKey(arg) ? values.get(arg) : arg.ceval(), arg.type());
        }
        com.accept("CALC");
        com.accept("DONE");
        for (K cvd : ext.varsToDeserialize()) {
            values.put(cvd, com.get(cvd.type()));
        }
        com.accept("READY");
        com.cancelTimer();
    }

    @Override
    public void destroyProcess() {
        // Do nothing
    }

    @Override
    public void remove() {
        extFunctionExecutable.remove();
    }

    private ProcessBuilder createProcessBuilder(External<K> ext) {
        ProcessBuilder pb = extFunctionExecutable.createProcessBuilder();
        Map<String, String> env = pb.environment();
        if (env.keySet().contains("Path")) {
            env.put("PATH", env.get("Path"));
            env.remove("Path");
        }
        pb.redirectErrorStream(true);
        if (ext.libraryDirectory() != null) {
            // Update environment in case of shared library
            String platform = CCompilerDelegator.reduceBits(EnvironmentUtils.getJavaPlatform(),
                    compiler.getCCompiler().getTargetPlatforms());
            File f = new File(ext.libraryDirectory(), platform);
            String libLoc = f.isDirectory() ? f.getPath() : ext.libraryDirectory();
            appendPath(env, libLoc, platform);
        }
        return pb;
    }

    /**
     * Append a library location <code>libLoc</code> to the path variable in
     * environment <code>env</code>.
     */
    private void appendPath(Map<String, String> env, String libLoc, String platform) {
        String sep = platform.startsWith("win") ? ";" : ":";
        String var = platform.startsWith("win") ? "PATH" : "LD_LIBRARY_PATH";
        String res = env.get(var);
        if (res == null) {
            res = libLoc;
        } else {
            res = res + sep + libLoc;
        }
        env.put(var, res);
    }
}