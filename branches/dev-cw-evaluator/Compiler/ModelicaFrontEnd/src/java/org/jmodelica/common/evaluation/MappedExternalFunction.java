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

    private final Map<String, ExternalFunction<K, V>> lives = new HashMap<>();

    private final LinkedHashSet<ExternalFunction<K, V>> livingCachedExternals;
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
            LiveExternalFunction<K,V,T,E> lef = new LiveExternalFunction<>(compiler, this, livingCachedExternals, externalConstantEvaluationMaxProc);
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

}
