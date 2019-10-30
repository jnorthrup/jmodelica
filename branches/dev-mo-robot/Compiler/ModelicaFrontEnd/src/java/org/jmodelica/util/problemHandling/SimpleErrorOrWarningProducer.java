package org.jmodelica.util.problemHandling;

import org.jmodelica.api.problemHandling.ProblemKind;
import org.jmodelica.api.problemHandling.ProblemSeverity;

/**
 * Convenience class which takes a string message on construction, an
 * optional list of format arguments when invoked and produces either 
 * an error or a warning.
 */
public class SimpleErrorOrWarningProducer extends ProblemProducer<ReporterNode> {

    private final String message;

    public SimpleErrorOrWarningProducer(String identifier, ProblemKind kind, String message) {
        super(identifier, kind);
        this.message = message;
    }

    /**
     * Create an error or warning according to this producer.
     * 
     * @param src    the reporting node
     * @param error  if true, produce an error, otherwise a warning
     * @param args   any arguments for the error message
     */
    public void invoke(ReporterNode src, boolean error, Object ... args) {
        ProblemSeverity severity = error ? ProblemSeverity.ERROR : ProblemSeverity.WARNING;
        invoke(src, severity, message, args);
    }

    @Override
    public String description() {
        return message;
    }

    @Override
    public ProblemSeverity severity() {
        return null;
    }

}
