package guiStuff;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.HashSet;

public abstract class GuiElement {
	
	public abstract void paint(Graphics2D g);
	
	protected abstract boolean reactToClick(Point2D p);

}
