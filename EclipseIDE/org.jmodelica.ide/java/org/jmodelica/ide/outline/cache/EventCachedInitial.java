package org.jmodelica.ide.outline.cache;

import org.jastadd.ed.core.model.ASTChangeEvent;
import org.jastadd.ed.core.model.IASTChangeEvent;

public class EventCachedInitial extends ASTChangeEvent {
	private CachedASTNode cachedRoot;

	public EventCachedInitial(CachedASTNode cachedRoot) {
		super(IASTChangeEvent.CACHED_CHILDREN, IASTChangeEvent.FILE_LEVEL,
				null, null, null);
		this.cachedRoot = cachedRoot;
	}

	public CachedASTNode getCachedRoot() {
		return cachedRoot;
	}
}