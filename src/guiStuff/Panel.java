package guiStuff;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashSet;

public class Panel{
	protected static ArrayList<GuiElement> enabledElements = new ArrayList<GuiElement>();
	
	public static void setEnabled(GuiElement element, boolean enabled) {
		if(enabled && !enabledElements.contains(element)){
			enabledElements.add(element);
		}else if(!enabled && enabledElements.contains(element)){
			enabledElements.remove(element);
		}
	}
	
	public static void paint(Graphics2D g) {
		for(int i = 0; i < enabledElements.size(); i++){
			enabledElements.get(i).paint(g);
		}
	}

	public static  boolean reactToClick(Point2D p) {
		for(int i = 0; i < enabledElements.size(); i++){
			if(enabledElements.get(i).reactToClick(p)){
				return true;
			}
		}
		return false;
	}

}
