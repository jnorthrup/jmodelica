package org.jmodelica.ide.sync;

import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

import org.eclipse.core.resources.IFile;
import org.jastadd.ed.core.model.IASTChangeListener;

public class ChangePropagationController {
	private static ChangePropagationController controller;

	// Each file has a Tree where listeners register against the file ast nodes.
	// TODO synchronize when handling listeners
	private HashMap<IFile, LibraryNode> listenerTrees = new HashMap<IFile, LibraryNode>();

	private ChangePropagationController() {
	}

	public static synchronized ChangePropagationController getInstance() {
		if (controller == null)
			controller = new ChangePropagationController();
		return controller;
	}

	public void addListener(ListenerObject listObj, IFile file,
			Stack<String> nodePath) {
		LibraryNode root = listenerTrees.get(file);
		if (root == null) {
			root = new LibraryNode(null);
			listenerTrees.put(file, root);
		}
		Stack<String> copy = new Stack<String>();
		if (nodePath != null) {
			copy.setSize(nodePath.size());
			Collections.copy(copy, nodePath);
		}
		LibraryVisitor visitor = new LibraryVisitor();
		visitor.addListener(root, copy, listObj);
	}

	/**
	 * 
	 * @param changeType
	 *            ASTChangeEvent.type
	 * @param file
	 * @param srcNode
	 * @param nodePath
	 */
	public synchronized void handleNotifications(int changeType, IFile file,
			Stack<ASTPathPart> nodePath) {
		LibraryNode libroot = listenerTrees.get(file);
		if (libroot != null) {
			LibraryVisitor visitor = new LibraryVisitor();
			Stack<ASTPathPart> copy = new Stack<ASTPathPart>();
			copy.setSize(nodePath.size());
			Collections.copy(copy, nodePath);
			visitor.handleChangedNode(file, changeType, libroot, copy);
		}
	}

	public boolean removeListener(IASTChangeListener listener, IFile file,
			Stack<ASTPathPart> nodePath) {
		LibraryNode root = listenerTrees.get(file);
		if (root != null) {
			Stack<ASTPathPart> copy = new Stack<ASTPathPart>();
			if (nodePath != null) {
				copy.setSize(nodePath.size());
				Collections.copy(copy, nodePath);
			}
			LibraryVisitor visitor = new LibraryVisitor();
			return visitor.removeListener(root, copy, listener);
		}
		return false;
	}
}