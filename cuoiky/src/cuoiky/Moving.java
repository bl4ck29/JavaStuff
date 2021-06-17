package cuoiky;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Moving extends JFrame implements KeyListener{
	private int x = 200;
	private int y = 200;
	private int r = 100;
	public static void main(String[] args) {
		Moving obj = new Moving();
		obj.setVisible(true);
	}
	public Moving() {
		setTitle("Moving circle");
		setSize(500, 500);
		setLocationRelativeTo(null);
		addKeyListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.fillOval(x, y, r, r);
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(x>=0 && x<=800) {
			if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {x -= 10;}
			if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) {x += 10;}
		}
		else if(x<0) {x =0;}
		else if(x >800) {x = 800;}
		
		if(y>=0 && y<=800) {
			if(arg0.getKeyCode() == KeyEvent.VK_UP) {y -=10;}
			if(arg0.getKeyCode() == KeyEvent.VK_DOWN) {y += 10;}
		}
		else if(y<0) {y =0;}
		else if(y >800) {y = 800;}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}
}
