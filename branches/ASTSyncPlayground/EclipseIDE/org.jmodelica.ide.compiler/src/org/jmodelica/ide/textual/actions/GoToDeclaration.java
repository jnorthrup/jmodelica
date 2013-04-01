package org.jmodelica.ide.textual.actions;

import org.eclipse.jface.action.Action;
import org.jmodelica.ide.IDEConstants;
import org.jmodelica.ide.OffsetDocument;
import org.jmodelica.ide.helpers.EclipseUtil;
import org.jmodelica.ide.helpers.Maybe;
import org.jmodelica.ide.helpers.hooks.IASTEditor;
import org.jmodelica.ide.namecomplete.Lookup;
import org.jmodelica.ide.textual.editor.Editor;
import org.jmodelica.modelica.compiler.ASTNode;
import org.jmodelica.modelica.compiler.InstNode;

public class GoToDeclaration extends Action {

	protected final Editor editor;

	protected ASTNode<?> fRoot;

	public GoToDeclaration(Editor editor) {

		super();
		super.setActionDefinitionId("JModelicaIDE.GoToDeclarationCommand");
		super.setId(IDEConstants.ACTION_FOLLOW_REFERENCE_ID);
		this.editor = editor;
		this.fRoot = null;
	}

	public void run() {

		// not initialised, or not able to create AST.

		if (fRoot == null)
			return;

		Maybe<InstNode> iNode = new Lookup(fRoot)
				.declarationFromAccessAt(new OffsetDocument(editor.document(),
						editor.selection().getOffset()));

		if (iNode.isNothing())
			return;

		String pathToDecl = iNode.value().retrieveFileName();

		try {

			IASTEditor ed = EclipseUtil.getModelicaEditorForFile(
					EclipseUtil.getFileForPath(pathToDecl).value()).value();
			ed.selectNode(iNode.value() != null, iNode.value()
					.containingFileName(), iNode.value().getSelectionNode()
					.offset(), iNode.value().getSelectionNode().length());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateAST(ASTNode<?> root) {
		this.fRoot = root;
	}

}
