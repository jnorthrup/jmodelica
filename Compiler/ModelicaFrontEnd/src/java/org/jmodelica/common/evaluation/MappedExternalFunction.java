package org.jmodelica.common.evaluation;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import org.jmodelica.common.evaluation.ExternalProcessMultiCache.External;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Type;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Value;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Variable;
import org.jmodelica.util.values.ConstantEvaluationException;

/**
 * A CompiledExternalFunction which can cache several processes with external
 * object constructor only called once.
 */
class MappedExternalFunction<K extends Variable<V, T>, V extends Value, T extends Type<V>, E extends External<K>> extends ExternalFunctionImpl<K,V,T,E> {

    private Map<String, ExternalFunction<K, V>> lives = new HashMap<>();

    private LinkedHashSet<ExternalFunction<K, V>> livingCachedExternals;
    private final int externalConstantEvaluationMaxProc;

    public MappedExternalFunction(ExternalFunctionCompiler<K,E> compiler, External<K> ext, ExternalFunctionExecutable extFunctionExecutable, LinkedHashSet<ExternalFunction<K, V>> livingCachedExternals) {
        super(compiler, ext, extFunctionExecutable);
        this.livingCachedExternals = livingCachedExternals;
        externalConstantEvaluationMaxProc = ext.processLimit();
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
                ef = FailedExternalFunction.<K,V,T,E>failedEval(compiler, ext, " error starting process '" + e.getMessage() + "'", true);
            } catch (ConstantEvaluationException e) {
                lef.destroyProcess();
                ef = FailedExternalFunction.<K,V,T,E>failedEval(compiler, ext, " error starting process '" + e.getMessage() + "'", true);
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
            compiler.log().debug("Evaluating live external function: " + ext.getName());
            try {
                ready(ext, values, timeout);
                long time = System.currentTimeMillis();
                MappedExternalFunction.this.evaluate(ext, values, timeout, com);
                time = System.currentTimeMillis() - time;
                compiler.log().debug("Finished evaluating live external function, time: " + time + "ms");
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
                compiler.log().debug("Setup live external function: " + ext.getName()
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
