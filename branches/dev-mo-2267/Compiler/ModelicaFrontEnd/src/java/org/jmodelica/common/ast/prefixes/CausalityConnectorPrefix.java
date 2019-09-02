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
    
    public boolean inputCausality(boolean causalPorts) {
        if (causalPorts) {
            return this == INPUT || this == FLOW || this == INSTREAM;
        }
        return this == INPUT;
    }
    
    public boolean outputCausality(boolean causalPorts) {
        if (causalPorts) {
            return this == OUTPUT || this == POTENTIAL || this == STREAM;
        }
        return this == OUTPUT;
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
