package guiStuff;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class InputElement extends VisualElement{
	private String name;
	private String text;

	private InputEvent event;
	
	//The InputElement currently accepting input
	private static InputElement open = null;
	
	
	public InputElement(String name, Rectangle2D bounds, boolean enabled, InputEvent event){
		super(bounds, enabled);
		this.name = name;
		this.text = "";
		this.event = event;
	}
	
	public InputElement(String name, String text, Rectangle2D bounds, boolean enabled, InputEvent event){
		super(bounds, enabled);
		this.name = name;
		this.text = text;
		this.event = event;
	}
	
	@Override
	public void paint(Graphics2D g) {
		g.setStroke(new BasicStroke(1));
		g.setColor(new Color(0.95f, 0.95f, 0.95f));
		g.fill(bounds);
		g.setColor(Color.black);
		g.drawString(name + text, (int)bounds.getBounds().getCenterX() - (g.getFontMetrics().stringWidth(name + text) / 2), 
				(int) bounds.getBounds().getCenterY() + (g.getFontMetrics().getAscent() / 2));
		g.draw(bounds);
	}

	@Override
	protected boolean reactToClick(Point2D p) {
		setOpenForInput(this, bounds.contains(p));
		return(bounds.contains(p));
	}

	@Override
	protected void activate() {
		event.execute(text);
	}

	@Override
	protected void setEnabled(boolean enabled) {
		Panel.setEnabled(this, enabled);
		if(!enabled)
			setOpenForInput(this, false);
	}
	
	public String getText(){
		return text;
	}

	public static void setOpenForInput(InputElement element, boolean setToOpen){
		if(element == null){
			throw new NullPointerException();
		}
		if(setToOpen){
			if(open != null && open != element){
				setOpenForInput(open, false);
			}
			open = element;
		}else{
			//Will execute if the element is open. If the element weren't open, there's no point in closing it.
			if(element == open){
				open.activate();
				open = null;
			}
		}
	}
	
	public static void sendKeyEvent(KeyEvent e){
		if(open == null)
			return;
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			if(open.text.length() > 0){
				open.text = open.text.substring(0, open.text.length() - 1);
			}
		}else if(e.getKeyCode() == KeyEvent.VK_ENTER){
			setOpenForInput(open, false);
		}else if(e.getKeyChar() != KeyEvent.VK_UNDEFINED){
			open.text += e.getKeyChar();
		}
	}
}
