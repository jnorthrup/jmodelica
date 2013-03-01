/*******************************************************************************
 * Copyright (c) 2000, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.jmodelica.ide.graphical.edit;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.Request;

public class NativeDropRequest extends Request {

	private Object data;
	private Point point;

	public static final String ID = "$Native Drop Request";//$NON-NLS-1$

	public NativeDropRequest() {
		super(ID);
	}

	public NativeDropRequest(Object type) {
		super(type);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public Point getPoint() {
		return point;
	}
	
	public void setPoint(Point point) {
		this.point = point;
	}

}
