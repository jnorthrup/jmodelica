package org.jmodelica.common.evaluation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.jmodelica.common.evaluation.ExternalProcessMultiCache.External;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Type;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Value;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Variable;
import org.jmodelica.util.EnvironmentUtils;
import org.jmodelica.util.SystemUtil;
import org.jmodelica.util.ccompiler.CCompilerDelegator;
import org.jmodelica.util.exceptions.CcodeCompilationException;
import org.jmodelica.util.logging.ModelicaLogger;

public class ExternalProcessCacheImpl<K extends Variable<V, T>, V extends Value, T extends Type<V>, E extends External<K>> extends ExternalProcessCache<K, V, T, E> {

    /**
     * Maps external functions names to compiled executables.
     */
    private final Map<String, ExternalFunction<K, V>> cachedExternals = new HashMap<String, ExternalFunction<K, V>>();

    /**
     * Keeps track of all living processes, least recently used first.
     */
    private final LinkedHashSet<ExternalFunction<K, V>> livingCachedExternals = new LinkedHashSet<ExternalFunction<K, V>>();

    private final ExternalFunctionCompiler<K, E> mc;

    public ExternalProcessCacheImpl(ExternalFunctionCompiler<K, E> mc) {
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
        
        if (ext.library() != null && ext.library().length == 1) {
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
    
    private static ArrayList<String> builtinExternalFunctions = new ArrayList<String>() {{
        add("ModelicaStrings_substring");
        add("ModelicaStrings_length");
        add("ModelicaStrings_skipWhiteSpace");
        add("ModelicaStrings_compare");
    }};
    
    private static ArrayList<String> supportedSignatures = new ArrayList<String>() {{
        add("d+d,d,");
        add("d+i,");
        add("d+i,d,d,");
        add("s+s,i,i,");
        add("i+s,");
        add("i+s,i,");
        add("i+s,s,i,");
        add("i+i,i,");
        add("void+i,d,d,*R[d,d,d,d,d,d,d,d,d,d,d,],");
        add("void+d,d,*d,");
    }};
    
    public boolean canUseEvaluator(E ext, ArrayList<String> arguments) {
        if (!ext.dynamicEvaluatorEnabled()) {
            return false;
        }
        
        String sharedLibrary = getSharedLibrary(ext);
        String functionName  = ext.getName();
        String outputArguments = ext.functionReturnArgSerialized();
        String inputArguments  = ext.functionArgsSerialized();
        
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
                return FailedExternalFunction.<K,V,T,E>failedEval(mc, ext, "Missing ModelicaCompiler", false);
            }
            try {
                long time = System.currentTimeMillis();
                String executable = null;
                ArrayList<String> arguments = new ArrayList<String>();
                String debugMsg = "";
                ExternalFunctionExecutable extFunctionExecutable;
                if (canUseEvaluator(ext, arguments)) {
                    String jmHome = System.getenv("JMODELICA_HOME");
                    String bits = getPlatform().contains("64") && SystemUtil.isWindows() ? "64" : "";
                    executable = jmHome + File.separator + "bin" + bits + File.separator + "jmi_evaluator" + SystemUtil.executableExtension();
                    
                    arguments.add(0, executable); /* Needs to be first */
                    
                    extFunctionExecutable = new ExternalFunctionExecutableDynamic(arguments);
                    
                    debugMsg = "Succesfully connected external function '" + ext.getName() + "' to the evaluator '"
                            + executable + "' with outputs: '" + ext.functionReturnArgSerialized() + "' and inputs: '" + ext.functionArgsSerialized() + "'";
                } else {
                    executable = mc.compileExternal(ext);
                    
                    extFunctionExecutable = new ExternalFunctionExecutableGenerated(executable);
                    
                    debugMsg = "Succesfully compiled external function '" + ext.getName() + "' to executable '"
                            + executable + "' code for evaluation";
                }
                
                if (ext.processLimit() > 0) {
                    ef = new MappedExternalFunction<K,V,T,E>(mc, ext, extFunctionExecutable, livingCachedExternals);
                } else {
                    ef = new ExternalFunctionImpl<K,V,T,E>(mc, ext, extFunctionExecutable);
                }
                time = System.currentTimeMillis() - time;
                mc.log().debug(debugMsg +", time: " + time + "ms");
            } catch (FileNotFoundException e) {
                ef = FailedExternalFunction.<K,V,T,E>failedEval(mc, ext, "c-code generation failed '" + e.getMessage() + "'", true);
                mc.log().debug(ef.getMessage());
            } catch (CcodeCompilationException e) {
                ef = FailedExternalFunction.<K,V,T,E>failedEval(mc, ext, "c-code compilation failed '" + e.getMessage() + "'", true);
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

}
