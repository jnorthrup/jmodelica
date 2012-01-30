package org.jmodelica.icons.drawing;

import org.jmodelica.icons.Icon;
import org.jmodelica.icons.parts.Component;
import org.jmodelica.icons.parts.coord.Extent;
import org.jmodelica.icons.parts.primitives.Bitmap;
import org.jmodelica.icons.parts.primitives.Color;
import org.jmodelica.icons.parts.primitives.FilledShape;
import org.jmodelica.icons.parts.primitives.Line;
import org.jmodelica.icons.parts.primitives.Text;

public interface GraphicsInterface {
	public abstract void drawLine(Line l);
	public abstract void drawText(Text t, Icon icon);
	public abstract void drawShape(FilledShape s);
	public abstract void drawBitmap(Bitmap b);
	public abstract void setTransformation(Component comp, Extent extent);
	public abstract void saveTransformation();
	public abstract void resetTransformation();
	public abstract void setColor(Color color);
	public abstract void setBackgroundColor(Color color);
}