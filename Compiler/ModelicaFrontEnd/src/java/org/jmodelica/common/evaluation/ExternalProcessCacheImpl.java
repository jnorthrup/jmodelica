package org.jmodelica.common.evaluation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Compiler;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.External;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Type;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Value;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Variable;
import org.jmodelica.util.EnvironmentUtils;
import org.jmodelica.util.SystemUtil;
import org.jmodelica.util.ccompiler.CCompilerDelegator;
import org.jmodelica.util.exceptions.CcodeCompilationException;
import org.jmodelica.util.logging.ModelicaLogger;
import org.jmodelica.util.values.ConstantEvaluationException;

public class ExternalProcessCacheImpl<K extends Variable<V, T>, V extends Value, T extends Type<V>, E extends External<K>> extends ExternalProcessCache<K, V, T, E> {

    /**
     * Maps external functions names to compiled executables.
     */
    private Map<String, ExternalFunction<K, V>> cachedExternals = new HashMap<String, ExternalFunction<K, V>>();

    /**
     * Keeps track of all living processes, least recently used first.
     */
    private LinkedHashSet<ExternalFunction<K, V>> livingCachedExternals = new LinkedHashSet<ExternalFunction<K, V>>();

    private Compiler<K, E> mc;

    public ExternalProcessCacheImpl(Compiler<K, E> mc) {
        this.mc = mc;
    }

    ModelicaLogger log() {
        return mc.log();
    }
    
    private String getPlatform() {
        return CCompilerDelegator.reduceBits(EnvironmentUtils.getJavaPlatform(), 
                mc.getCCompiler().getTargetPlatforms());
    }
    
    private String getSharedLibrary(External<K> ext) {
        String sharedLib = "";
        String extLibrary = "";
        
        if (ext.library().length == 1) {
            extLibrary = ext.library()[0];
        } else {
            return sharedLib;
        }
        
        HashSet<String> externalLibraryDirectories = new HashSet<String>();
        externalLibraryDirectories.add(ext.libraryDirectory());
        Set<String> expandedLibDirs = mc.getCCompiler().expandCompilerSpecificLibraryPaths(mc.log(), ext.myOptions(), 
                                                   externalLibraryDirectories, getPlatform());
        
        for (String dir : expandedLibDirs) {
            File testlib1 = new File(dir, extLibrary + SystemUtil.sharedLibraryExtension());
            File testlib2 = new File(dir, "lib" + extLibrary + SystemUtil.sharedLibraryExtension());
            
            if (testlib1.exists() && !testlib1.isDirectory()) {
                sharedLib = testlib1.toString();
                break;
            }
            if (testlib2.exists() && !testlib2.isDirectory()) {
                sharedLib = testlib2.toString();
                break;
            }
        }
        
        return sharedLib;
    }
    
    private String getOutputArguments(E ext) {
        String output = ext.functionArgsSerialized(true);
        if (output.equals("")) {
            return "void";
        }
        return output;
    }
    
    private String getInputArguments(E ext) {
        return ext.functionArgsSerialized(false);
    }
    
    private static ArrayList<String> builtinExternalFunctions = new ArrayList<String>() {{
        add("ModelicaStrings_substring");
        add("ModelicaStrings_length");
        add("ModelicaStrings_skipWhiteSpace");
    }};
    
    private static ArrayList<String> supportedSignatures = new ArrayList<String>() {{
        add("d+d,d,");
        add("d+i,");
        add("d+i,d,d,");
        add("s+s,i,i,");
        add("i+s,");
        add("i+s,i,");
        add("void+i,d,d,*R[d,d,d,d,d,d,d,d,d,d,d,],");
        add("void+d,d,*d,");
    }};
    
    public boolean canUseEvaluator(E ext, ArrayList<String> arguments) {
        if (!(ext.myOptions().getBooleanOption("external_constant_dynamic_evaluator"))) {
            return false;
        }
        
        /* External objects not supported at the moment */
        for (K eo : ext.externalObjectsToSerialize()) {
            return false;
        }
        
        String sharedLibrary = getSharedLibrary(ext);
        String functionName  = ext.getName();
        String outputArguments = getOutputArguments(ext);
        String inputArguments  = getInputArguments(ext);
        
        if (sharedLibrary.equals("")) {
            if (builtinExternalFunctions.contains(functionName)) {
                sharedLibrary = "NoSharedLibrary";
            } else {
                mc.log().debug("Could not find a shared library containing '" + functionName + "'. Disabling use of the evaluator...");
                return false;
            }
        }
        
        if (!supportedSignatures.contains(outputArguments+"+"+inputArguments)) {
            mc.log().debug("The function signature, outputs '" + outputArguments + "', inputs '" + inputArguments + "', is not supported. Disabling use of the evaluator...");
            return false;
        }
        
        arguments.add(sharedLibrary);
        arguments.add(functionName);
        arguments.add(outputArguments);
        arguments.add(inputArguments);

        return true;
    }
    
    @Override
    public ExternalFunction<K, V> getExternalFunction(E ext) {
        ExternalFunction<K, V> ef = cachedExternals.get(ext.getName());
        if (ef == null) {
            if (mc == null) {
                return failedEval(ext, "Missing ModelicaCompiler", false);
            }
            try {
                long time = System.currentTimeMillis();
                String executable = null;
                ArrayList<String> arguments = new ArrayList<String>();
                String debugMsg = "";
                if (canUseEvaluator(ext, arguments)) {
                    String jmHome = System.getenv("JMODELICA_HOME");
                    String bits = getPlatform().contains("64") && SystemUtil.isWindows() ? "64" : "";
                    executable = jmHome + File.separator + "bin" + bits + File.separator + "jmi_evaluator" + SystemUtil.executableExtension();
                    
                    arguments.add(0, executable); /* Needs to be first */
                    
                    debugMsg = "Succesfully connected external function '" + ext.getName() + "' to the evaluator '"
                            + executable + "' with outputs: '" + getOutputArguments(ext) + "' and inputs: '" + getInputArguments(ext) + "'";
                } else {
                    executable = mc.compileExternal(ext);
                    debugMsg = "Succesfully compiled external function '" + ext.getName() + "' to executable '"
                            + executable + "' code for evaluation";
                }
                arguments = arguments.size() == 0 ? null : arguments; /* Can likely be made better...*/
                if (ext.shouldCacheProcess()) {
                    ef = new MappedExternalFunction(ext, executable, arguments);
                } else {
                    ef = new CompiledExternalFunction(ext, executable, arguments);
                }
                time = System.currentTimeMillis() - time;
                mc.log().debug(debugMsg +", time: " + time + "ms");
            } catch (FileNotFoundException e) {
                ef = failedEval(ext, "c-code generation failed '" + e.getMessage() + "'", true);
                mc.log().debug(ef.getMessage());
            } catch (CcodeCompilationException e) {
                ef = failedEval(ext, "c-code compilation failed '" + e.getMessage() + "'", true);
                mc.log().debug(ef.getMessage());
                e.printStackTrace(new PrintStream(mc.log().debugStream()));
            }
            cachedExternals.put(ext.getName(), ef);
        }
        return ef;
    }

    @Override
    public void removeExternalFunctions() {
        for (ExternalFunction<K, V> ef : cachedExternals.values()) {
            ef.remove();
        }
        cachedExternals.clear();
    }

    @Override
    public void destroyProcesses() {
        for (ExternalFunction<K, V> ef : new ArrayList<ExternalFunction<K, V>>(livingCachedExternals)) {
            ef.destroyProcess();
        }
    }

    @Override
    protected void tearDown() {
        destroyProcesses();
        removeExternalFunctions();
    }

    @Override
    public ExternalFunction<K, V> failedEval(External<?> ext, String msg, boolean log) {
        return new FailedExternalFunction(failedEvalMsg(ext.getName(), msg), log);
    }

    public static String failedEvalMsg(String name, String msg) {
        return "Failed to evaluate external function '" + name + "', " + msg;
    }

    private class FailedExternalFunction implements ExternalFunction<K, V> {
        private String msg;
        private boolean log;

        public FailedExternalFunction(String msg, boolean log) {
            this.msg = msg;
            this.log = log;
        }

        @Override
        public String getMessage() {
            return msg;
        }

        @Override
        public int evaluate(External<K> ext, Map<K, V> values, int timeout) throws IOException {
            if (log) {
                log().debug("Evaluating failed external function: " + ext.getName());
            }
            throw new ConstantEvaluationException(null, getMessage());
        }

        @Override
        public void destroyProcess() {
            // Do nothing
        }

        @Override
        public void remove() {
            // Do nothing
        }
    }

    /**
     * Represents an external function that has been compiled successfully.
     */
    private class CompiledExternalFunction implements ExternalFunction<K, V> {
        protected String executable;
        protected ArrayList<String> arguments;
        protected ProcessBuilder processBuilder;
        private String msg;

        public CompiledExternalFunction(External<K> ext, String executable, ArrayList<String> arguments) {
            this.executable = executable;
            this.arguments = arguments;
            this.processBuilder = createProcessBuilder(ext);
            this.msg = "Succesfully compiled external function '" + ext.getName() + "'";
        }

        @Override
        public String getMessage() {
            return msg;
        }

        protected ProcessCommunicator<V, T> createProcessCommunicator() throws IOException {
            return new ProcessCommunicator<V, T>(mc, processBuilder.start());
        }

        @Override
        public int evaluate(External<K> ext, Map<K, V> values, int timeout) throws IOException {
            log().debug("Evaluating compiled external function: " + ext.getName());
            ProcessCommunicator<V, T> com = null;
            try {
                com = createProcessCommunicator();
                setup(ext, values, timeout, com);
                evaluate(ext, values, timeout, com);
                return teardown(timeout, com);
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
            for (K cvd : ext.varsToDeserialize())
                values.put(cvd, com.get(cvd.type()));
            com.accept("READY");
            com.cancelTimer();
        }

        public int teardown(int timeout, ProcessCommunicator<V, T> com) throws IOException {
            com.startTimer(timeout);
            com.check("EXIT");
            com.accept("END");
            int result = com.end();
            com.cancelTimer();
            // log().debug("SUCCESS TEARDOWN");
            return result;
        }

        @Override
        public void destroyProcess() {
            // Do nothing
        }

        @Override
        public void remove() {
            if (arguments == null) {
                new File(executable).delete();
            }
        }

        private ProcessBuilder createProcessBuilder(External<K> ext) {
            ProcessBuilder pb;
            if (arguments == null) {
                pb = new ProcessBuilder(executable);
            } else {
                pb = new ProcessBuilder(arguments);
            }
            Map<String, String> env = pb.environment();
            if (env.keySet().contains("Path")) {
                env.put("PATH", env.get("Path"));
                env.remove("Path");
            }
            pb.redirectErrorStream(true);
            if (ext.libraryDirectory() != null) {
                // Update environment in case of shared library
                String platform = CCompilerDelegator.reduceBits(EnvironmentUtils.getJavaPlatform(),
                        mc.getCCompiler().getTargetPlatforms());
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
            if (res == null)
                res = libLoc;
            else
                res = res + sep + libLoc;
            env.put(var, res);
        }
    }

    /**
     * A CompiledExternalFunction which can cache several processes with external
     * object constructor only called once.
     */
    private class MappedExternalFunction extends CompiledExternalFunction {

        private Map<String, ExternalFunction<K, V>> lives = new HashMap<>();

        private final int externalConstantEvaluationMaxProc;

        public MappedExternalFunction(External<K> ext, String executable, ArrayList<String> arguments) {
            super(ext, executable, arguments);
            externalConstantEvaluationMaxProc = ext.myOptions()
                    .getIntegerOption("external_constant_evaluation_max_proc");
        }

        /**
         * Find a LiveExternalFunction based on the external object of this external
         * function. Start a new process if not up already. Failure to set up (call
         * constructor) will cache and return a Failed external function.
         */
        private ExternalFunction<K, V> getActual(External<K> ext, Map<K, V> values, int timeout) {
            Variable<V, T> cvd = ext.cachedExternalObject();
            String name = cvd == null ? "" : cvd.ceval().getMarkedExternalObject();
            ExternalFunction<K, V> ef = lives.get(name);
            if (ef == null) {
                LiveExternalFunction lef = new LiveExternalFunction();
                try {
                    lef.ready(ext, values, timeout);
                    ef = lef;
                } catch (IOException e) {
                    lef.destroyProcess();
                    ef = failedEval(ext, " error starting process '" + e.getMessage() + "'", true);
                } catch (ConstantEvaluationException e) {
                    lef.destroyProcess();
                    ef = failedEval(ext, " error starting process '" + e.getMessage() + "'", true);
                }
                lives.put(name, ef);
            }
            return ef;
        }

        @Override
        public int evaluate(External<K> ext, Map<K, V> values, int timeout) throws IOException {
            return getActual(ext, values, timeout).evaluate(ext, values, timeout);
        }

        @Override
        public void destroyProcess() {
            for (ExternalFunction<K, V> ef : lives.values()) {
                ef.destroyProcess();
            }
            lives.clear();
        }

        /**
         * Represents a (possible) living external function process.
         */
        private class LiveExternalFunction implements ExternalFunction<K, V> {

            protected ProcessCommunicator<V, T> com;

            public LiveExternalFunction() {
                super();
            }

            @Override
            public String getMessage() {
                return MappedExternalFunction.this.getMessage();
            }

            @Override
            public int evaluate(External<K> ext, Map<K, V> values, int timeout) throws IOException {
                log().debug("Evaluating live external function: " + ext.getName());
                try {
                    ready(ext, values, timeout);
                    long time = System.currentTimeMillis();
                    MappedExternalFunction.this.evaluate(ext, values, timeout, com);
                    time = System.currentTimeMillis() - time;
                    log().debug("Finished evaluating live external function, time: " + time + "ms");
                } catch (ProcessCommunicator.AbortConstantEvaluationException e) {

                } catch (ConstantEvaluationException e) {
                    destroyProcess();
                    throw e;
                } catch (IOException e) {
                    destroyProcess();
                    throw e;
                }
                return 0;
            }

            /**
             * Make sure process is ready for evaluation call.
             */
            protected void ready(External<K> ext, Map<K, V> values, int timeout) throws IOException {
                if (com == null) {
                    long time1 = System.currentTimeMillis();
                    // Start process if not live.
                    com = createProcessCommunicator();
                    long time2 = System.currentTimeMillis();
                    // Send external object constructor inputs
                    MappedExternalFunction.this.setup(ext, values, timeout, com);
                    long time3 = System.currentTimeMillis();
                    log().debug("Setup live external function: " + ext.getName()
                              + ", createProcessCommunicator() time: " + (time2 - time1)
                              + "ms, setup time: " + (time3 - time2) + "ms");
                }

                // Mark as most recently used
                livingCachedExternals.remove(this);
                livingCachedExternals.add(this);

                // If we are over the allowed number of cached processes
                // we kill the least recently used.
                if (livingCachedExternals.size() > externalConstantEvaluationMaxProc) {
                    livingCachedExternals.iterator().next().destroyProcess();
                }
            }

            @Override
            public void destroyProcess() {
                if (com != null) {
                    livingCachedExternals.remove(this);
                    com.destroy();
                    com = null;
                }
            }

            @Override
            public void remove() {
                // Removing this executable is handled by surrounding MappedExternalFunction
                throw new UnsupportedOperationException();
            }
        }
    }
}
