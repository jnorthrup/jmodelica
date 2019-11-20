package org.jmodelica.common.evaluation;

import java.io.IOException;
import java.util.Map;

import org.jmodelica.common.LogContainer;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.External;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Type;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Value;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.Variable;
import org.jmodelica.util.values.ConstantEvaluationException;

public class FailedExternalFunction<K extends Variable<V, T>, V extends Value, T extends Type<V>, E extends External<K>> implements ExternalFunction<K, V> {
    private LogContainer logContainer;
    private String msg;
    private boolean log;

    public FailedExternalFunction(LogContainer logContainer, String msg, boolean log) {
        this.logContainer = logContainer;
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
            logContainer.log().debug("Evaluating failed external function: " + ext.getName());
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
    
    public static <K extends Variable<V, T>, V extends Value, T extends Type<V>, E extends External<K>> ExternalFunction<K, V> failedEval(LogContainer logContainer, External<?> ext, String msg, boolean log) {
        return new FailedExternalFunction<K,V,T,E>(logContainer, failedEvalMsg(ext.getName(), msg), log);
    }

    public static String failedEvalMsg(String name, String msg) {
        return "Failed to evaluate external function '" + name + "', " + msg;
    }
}
