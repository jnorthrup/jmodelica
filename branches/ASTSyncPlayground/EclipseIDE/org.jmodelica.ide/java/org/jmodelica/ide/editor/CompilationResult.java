package org.jmodelica.ide.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.jastadd.ed.core.model.IASTChangeEvent;
import org.jmodelica.modelica.compiler.ASTNode;

/**
 * Represents the result of a compilation.
 * @author philip
 *
 */
public abstract class CompilationResult {

protected ASTNode<?> root;

public ASTNode<?> root() {
    return root;
}

/**
 * ReconcilingStrategy for changes re. this compilation
 * @return ReconcilingStrategy for this kind of compilation
 */
public abstract IReconcilingStrategy compilationStrategy();

/**
 * Update according to changes in the ASTRegistry
 * @param projChanged Updated project
 * @param keyChanged Updated key 
 */
public abstract void update(IProject projChanged, String keyChanged);

/**
 * See {@link CompilationResult.update(IProject, String)}
 * @param projChanged
 */
public abstract void update(IProject projChanged);

/**
 * Returns true iff. compilation had errors
 * @return true iff. compilation had errors 
 */
public boolean failed() {
    return root == null || root.isError();
}

/**
 * Remove listeners etc.
 * @param editor editor containing concerned file 
 */
public abstract void dispose(Editor editor);

/**
 * Recompile locally, not looking at other resources in the workspace. 
 * @param doc editor document
 * @param file input file
 */
public abstract void recompileLocal(IDocument doc, IFile file);

public abstract void update(IASTChangeEvent e);


}