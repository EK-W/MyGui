package guiStuff;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class OrganizationalDropdown extends OrganizationalElement{
	VisualElement[] elements;
	Rectangle2D bounds;
	
	public OrganizationalDropdown(Point2D location, Dimension elementSize, VisualElement... elements){
		this.elements = elements;
		for(int i = 0; i < this.elements.length; i++){
			this.elements[i].bounds = new Rectangle((int)location.getX(), (int)location.getY() + (i * elementSize.height), 
					(int)elementSize.getWidth(),(int) elementSize.getHeight());
			this.elements[i].setEnabled(false);
		}
		this.bounds = new Rectangle2D.Double(location.getX(), location.getY(), elementSize.getWidth(), elementSize.getHeight() * elements.length);
		Panel.setEnabled(this, true);
	}
	
	@Override
	public void paint(Graphics2D g) {
		for(VisualElement i: elements){
			i.paint(g);
		}
	}

	@Override
	protected boolean reactToClick(Point2D p) {
		if(bounds.contains(p)){
			for(VisualElement i: elements){
				if(i.reactToClick(p))
					return true;
			}
		} else{
			Panel.setEnabled(this, false);
		}
		return false;
	}

}
