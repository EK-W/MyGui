package guiStuff;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class ButtonElement extends VisualElement{
	private String name;
	private ButtonEvent event;
	
	public ButtonElement(Rectangle2D bounds, String name, boolean enabled, ButtonEvent event){
		super(bounds, enabled);
		this.name = name;
		this.event = event;
	}

	@Override
	public void paint(Graphics2D g) {
		g.setStroke(new BasicStroke(1));
		g.setColor(new Color(0.95f, 0.95f, 0.95f));
		//Fills background
		g.fill(bounds);
		//Draws the name string at the ~center of the button
		g.setColor(Color.black);
		g.drawString(name, (int)bounds.getBounds().getCenterX() - (g.getFontMetrics().stringWidth(name) / 2), 
				(int) bounds.getBounds().getCenterY() + (g.getFontMetrics().getAscent() / 2));
		//Draws outline
		g.draw(bounds);
	}

	@Override
	protected boolean reactToClick(Point2D p) {
		//This is better cuz it only has to do bounds.contains(p) once. Returning bounds.contains(p) would probably be slower
		if(bounds.contains(p)){
			activate();
			return true;
		}
		return false;
	}

	@Override
	protected void activate() {
		event.execute();
	}
	
}
