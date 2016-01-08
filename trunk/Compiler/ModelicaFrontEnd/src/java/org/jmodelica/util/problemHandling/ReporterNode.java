package org.jmodelica.util.problemHandling;

import org.jmodelica.util.OptionRegistry;

/**
 * A interface that all problem reporting nodes should fulfill. In reality
 * this is implemented by ASTNode and the interface is needed since ASTnode
 * isn't visible from the utils package. It also means that references of this
 * type shouldn't be saved in classes which are meant to be serialized!
 */
public interface ReporterNode {
    public int beginLine();
    public int endLine();
    public int beginColumn();
    public int endColumn();
    public String fileName();
    public String errorComponentName();
    public void reportProblem(Problem problem);
    public OptionRegistry myOptions();
    public boolean inDisabledComponent();
}
