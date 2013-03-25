package org.jmodelica.ide.actions;

import org.jmodelica.ide.editor.ICurrentClassListener;
import org.jmodelica.ide.outline.cache.CachedClassDecl;

public abstract class CurrentClassAction extends ConnectedTextsAction implements
		ICurrentClassListener {

	protected CachedClassDecl currentClass;

	public CurrentClassAction() {
		super();
		setTexts(getNewText(null));
		setEnabled(false);
	}

	public void setCurrentClass(CachedClassDecl currentClass) {
		if (currentClass != this.currentClass) {
			this.currentClass = currentClass;
			setTexts(getNewText(currentClass));
			setEnabled(currentClass != null);
		}
	}

	protected abstract String getNewText(CachedClassDecl currentClass);

}