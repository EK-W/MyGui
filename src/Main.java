import guiStuff.ButtonElement;
import guiStuff.InputElement;
import guiStuff.Panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;


public class Main extends JFrame implements ActionListener{
	private static final InputHandler inputHandler = new InputHandler();
	public static void main(String[] args) {
		Main m = new Main();
	}

	private static final int WIDTH = 1200;
	private static final int HEIGHT = 900;
	
	Timer animate;
	
	public Main(){
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setFocusable(true);
		this.setVisible(true);
		this.addKeyListener(inputHandler);
		this.addMouseListener(inputHandler);
		this.addMouseMotionListener(inputHandler);
		animate = new Timer(50, this);
		animate.start();
		InputElement e = new InputElement("BoopMessage: ", "boop", new Rectangle(50, 50, 150, 150), true, (String str) -> {});
		ButtonElement b = new ButtonElement(new Rectangle(50, 200, 150, 150), "Boop", true, () -> System.out.println(e.getText()));
		
	}

	public void paint(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		Panel.paint((Graphics2D)g);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
		
	}
}
