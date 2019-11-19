package org.jmodelica.util.problemHandling;

import org.jmodelica.api.problemHandling.ProblemKind;
import org.jmodelica.api.problemHandling.ProblemSeverity;

/**
 * Convenience class which takes a string message on construction, an
 * optional list of format arguments when invoked and produces a warning.
 */
public class SimpleWarningProducer extends SimpleProblemProducer {

    public SimpleWarningProducer(String identifier, ProblemKind kind, String message) {
        super(identifier, kind, ProblemSeverity.WARNING, message);
    }

}
