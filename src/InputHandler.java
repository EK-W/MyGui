import guiStuff.ButtonElement;
import guiStuff.InputElement;
import guiStuff.OrganizationalDropdown;
import guiStuff.Panel;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class InputHandler implements KeyListener, MouseListener, MouseMotionListener{
	int mouseButtonPressed;
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseButtonPressed = e.getButton();
		if(e.getButton() == 1){
			Panel.reactToClick(e.getPoint());
		}else if(e.getButton() == 3){
			ButtonElement fuck = new ButtonElement(new Rectangle(0, 0, 100, 100), "Fuck", true, () -> System.out.println("fuck"));
			ButtonElement shit = new ButtonElement(new Rectangle(0, 0, 100, 100), "Shit", true, () -> System.out.println("shit"));
			OrganizationalDropdown curseMenu = new OrganizationalDropdown(e.getPoint(), new Dimension(150, 50), fuck, shit);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(mouseButtonPressed == e.getButton()){
			mouseButtonPressed = -1;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		InputElement.sendKeyEvent(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
