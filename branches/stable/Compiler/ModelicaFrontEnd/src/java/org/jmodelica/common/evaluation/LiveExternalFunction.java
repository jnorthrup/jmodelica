package org.jmodelica.common.evaluation;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Map;

import org.jmodelica.common.evaluation.ExternalProcessMultiCache.External;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Type;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Value;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Variable;
import org.jmodelica.util.values.ConstantEvaluationException;

/**
 * Represents a (possible) living external function process.
 */
class LiveExternalFunction<K extends Variable<V, T>, V extends Value, T extends Type<V>, E extends External<K>> implements ExternalFunction<K, V> {

    private final ExternalFunctionCompiler<K,E> compiler;
    private final MappedExternalFunction<K,V,T,E> map;
    private final LinkedHashSet<ExternalFunction<K, V>> livingCachedExternals;
    private final int externalConstantEvaluationMaxProc;
    protected ProcessCommunicator<V, T> com;

    public LiveExternalFunction(ExternalFunctionCompiler<K,E> compiler, MappedExternalFunction<K,V,T,E> map,
            LinkedHashSet<ExternalFunction<K, V>> livingCachedExternals, int externalConstantEvaluationMaxProc) {
        super();
        this.compiler = compiler;
        this.map = map;
        this.livingCachedExternals = livingCachedExternals;
        this.externalConstantEvaluationMaxProc = externalConstantEvaluationMaxProc;
    }

    @Override
    public String getMessage() {
        return map.getMessage();
    }

    @Override
    public int evaluate(External<K> ext, Map<K, V> values, int timeout) throws IOException {
        compiler.log().debug("Evaluating live external function: " + ext.getName());
        try {
            ready(ext, values, timeout);
            long time = System.currentTimeMillis();
            map.evaluate(ext, values, timeout, com);
            time = System.currentTimeMillis() - time;
            compiler.log().debug("Finished evaluating live external function, time: " + time + "ms");
        } catch (ProcessCommunicator.AbortConstantEvaluationException e) {
            // TODO What does this mean?
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
            com = map.createProcessCommunicator();
            long time2 = System.currentTimeMillis();
            // Send external object constructor inputs
            map.setup(ext, values, timeout, com);
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
            try {
                com.teardown(100); // TODO Should we check the return value? 
            } catch (IOException e) {
                // TODO Do we need to do anything here?
            }
            com.destroy(); // TODO Do we still need to call destroy() if teardown is successful?
            com = null;
        }
    }

    @Override
    public void remove() {
        // Removing this executable is handled by surrounding MappedExternalFunction
        throw new UnsupportedOperationException();
    }
}