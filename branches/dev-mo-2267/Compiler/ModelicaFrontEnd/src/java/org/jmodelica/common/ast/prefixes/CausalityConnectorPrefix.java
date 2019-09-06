package org.jmodelica.common.ast.prefixes;

// TODO Rename class
public enum CausalityConnectorPrefix {

    NONE(""),
    INPUT("input"),
    OUTPUT("output"),
    POTENTIAL("potential"),
    FLOW("flow"),
    STREAM("stream"),
    INSTREAM("inStream");
    
    private String toString;
    
    private CausalityConnectorPrefix(String toString) {
        this.toString = toString;
    }
    
    public boolean isNone() {
        return this == NONE;
    }
    
    public boolean isInStream() {
        return this == INSTREAM;
    }
    
    public interface CausalPortsEvaluator {
        boolean useCausalPorts();
    }
    
    /**
     * We use a {@link CausalPortsEvaluator} here instead of an evaluated boolean
     * to reduce the number of calls to useCausalPorts().
     * Replace with a Predicate when updating to Java 8.
     */
    public boolean inputCausality(CausalPortsEvaluator evaluator) {
        if (this == INPUT) {
            return true;
        }
        if (this == FLOW || this == INSTREAM) {
            return evaluator.useCausalPorts();
        }
        return false;
    }
    
    public boolean outputCausality(CausalPortsEvaluator evaluator) {
        if (this == OUTPUT) {
            return true;
        }
        if (this == POTENTIAL || this == STREAM) {
            return evaluator.useCausalPorts();
        }
        return false;
    }
    
    public boolean isConnectorPrefix() {
        return this == POTENTIAL || this == FLOW || this == STREAM || this == INSTREAM;
    }
    
    @Override
    public String toString() {
        return toString;
    }
    
    public VisibilityType functionVisibility() {
        return isNone() ? VisibilityType.PROTECTED : VisibilityType.PUBLIC;
    }
    
}
