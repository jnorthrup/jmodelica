package org.jmodelica.util.ccompiler;

/**
 * Describes how allocation of an element is performed in runtime
 * @author jonathan.kampe
 *
 */
public enum Dynamicity {
    STATIC("STATIC"),
    STACK("STAT"),
    HEAP("DYNA");
    
    private String dyn;
    
    private Dynamicity(String dyn) {
        this.dyn = dyn;
    }
    
    public String toString() {
        return dyn;
    }
    
}
