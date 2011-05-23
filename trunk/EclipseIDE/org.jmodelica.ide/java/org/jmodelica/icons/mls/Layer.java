package org.jmodelica.icons.mls;
import java.util.ArrayList;



public class Layer {
	
	private CoordinateSystem coordinateSystem;
	private ArrayList<GraphicItem> graphics;
	
	public static Layer NO_LAYER = new Layer();
		
	/**
	 * 
	 * @param graphics The list of graphic items that make up the components's 
	 * graphical representation in the layer.
	 */
	public Layer(CoordinateSystem coordinateSystem, ArrayList<GraphicItem> graphics) {
		this.coordinateSystem = coordinateSystem;
		this.graphics = graphics;
	}
	
	public Layer(CoordinateSystem coordinateSystem) {
		this.graphics = new ArrayList<GraphicItem>();
		this.coordinateSystem = coordinateSystem;
	}
	
	private Layer() {
		this.coordinateSystem = null;
		this.graphics = null;
	}
	
	public CoordinateSystem getCoordinateSystem() {
		return coordinateSystem;
	}
	
	public ArrayList<GraphicItem> getGraphics() {
		return graphics;
	}
	
	public void setGraphics(ArrayList<GraphicItem> graphics) {
		this.graphics = graphics;
	}
	
	public String toString() {
		String s = "coordinateSystem = " + coordinateSystem + "\ngraphics: " + graphics;
//		int index = 0;
//		for (GraphicItem item : graphics) {
//			s += "\nitem " + index + " = " + item.toString();
//			index++;
//		}
		return s;
	}
}