package guiStuff;

import java.awt.Shape;

public abstract class VisualElement extends GuiElement{
	protected Shape bounds;
	
	public VisualElement(Shape bounds, boolean enabled){
		this.bounds = bounds;
		Panel.setEnabled(this, enabled );
	}
	
	protected abstract void activate();
	
	protected void setEnabled(boolean enabled){
		Panel.setEnabled(this, enabled);
	}
}
