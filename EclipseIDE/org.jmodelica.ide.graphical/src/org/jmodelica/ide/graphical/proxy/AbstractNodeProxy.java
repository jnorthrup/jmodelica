package org.jmodelica.ide.graphical.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.jmodelica.icons.Layer;
import org.jmodelica.icons.Observable;
import org.jmodelica.icons.primitives.GraphicItem;
import org.jmodelica.ide.graphical.proxy.cache.CachedInstClassDecl;
import org.jmodelica.ide.graphical.proxy.cache.CachedInstComponentDecl;
import org.jmodelica.ide.graphical.proxy.cache.CachedInstExtends;
import org.jmodelica.ide.graphical.proxy.cache.CachedInstNode;
import org.jmodelica.modelica.compiler.InstNode;

public abstract class AbstractNodeProxy extends Observable {

	protected abstract CachedInstComponentDecl getInstComponentDecl(
			String componentName);

	protected abstract CachedInstClassDecl getClassDecl();

	protected abstract CachedInstComponentDecl getComponentDecl();

	protected abstract CachedInstNode getASTNode();

	abstract protected Map<String, ComponentProxy> getComponentMap();

	abstract protected void setParameterValue(Stack<String> path, String value);

	protected abstract String buildDiagramName();

	public abstract AbstractDiagramProxy getDiagram();

	public abstract Layer getLayer();

	public String getClassName() {
		return "booo";// TODO return getClassDecl().syncGetClassIconName();
	}

	public String getQualifiedClassName() {
		return "fooo";// TODO getClassDecl().syncQualifiedName();
	}

	public String getComponentName() {
		CachedInstComponentDecl componentDecl = getComponentDecl();
		if (componentDecl != null)
			return componentDecl.syncName();
		else
			return null;
	}

	public String getQualifiedComponentName() {
		CachedInstComponentDecl componentDecl = getComponentDecl();
		if (componentDecl != null)
			return componentDecl.syncQualifiedName();
		else
			return null;
	}

	protected abstract boolean inDiagram();

	public List<GraphicItem> getGraphics() {
		List<GraphicItem> graphics = new ArrayList<GraphicItem>();
		collectGraphics(getASTNode(), graphics, inDiagram());
		return graphics;
	}

	protected static void collectGraphics(CachedInstNode node,
			List<GraphicItem> graphics, boolean inDiagram) {
		for (CachedInstExtends ie : node.syncGetInstExtendss()) {
			collectGraphics(ie, graphics, inDiagram);
		}
		if (inDiagram)
			graphics.addAll(node.syncGetDiagramLayer().getGraphics());
		else
			graphics.addAll(node.syncGetIconLayer().getGraphics());
	}

	public List<ComponentProxy> getComponents() {
		List<ComponentProxy> components = new ArrayList<ComponentProxy>();
		collectComponents(getASTNode(), components);
		return components;
	}

	private void collectComponents(CachedInstNode node,
			List<ComponentProxy> components) {
		for (CachedInstExtends ie : node.syncGetInstExtendss()) {
			collectComponents(ie, components);
		}
		for (CachedInstComponentDecl icd : node.syncGetInstComponentDecls()) {
			boolean isConnector = icd.syncIsConnector();
			boolean inDiagram = inDiagram();
			if (!inDiagram && !isConnector)
				continue;
			if (!icd.syncIsIconRenderable())
				continue;
			String mapName = buildMapName(icd.syncQualifiedName(), isConnector,
					inDiagram && isConnector);
			ComponentProxy component = getComponentMap().get(mapName);
			if (component == null) {
				if (isConnector && inDiagram)
					component = new DiagramConnectorProxy(icd, icd.syncName(),
							this);
				else if (isConnector && !inDiagram)
					component = new IconConnectorProxy(icd, icd.syncName(),
							this);
				else
					component = new ComponentProxy(icd, icd.syncName(), this);
				getComponentMap().put(mapName, component);
			}
			components.add(component);
		}
	}

	public String getParameterValue(String parameter) {
		// return getASTNode().syncLookupParameterValue(parameter); //TODO
		return "666";
	}

	protected static String buildMapName(String qualifiedName,
			boolean isConnector, boolean inDiagram) {
		String name = qualifiedName;
		if (!isConnector)
			return name;
		name += ":connector";
		if (inDiagram)
			name += ":diagram";
		else
			name += ":icon";
		return name;
	}
}
