package cuoiky;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class TrafficSignal extends JFrame implements KeyListener{
	private int x = 50;
	private int y = 50;
	private int r = 100;
	private Color red = Color.RED;
	private Color green = Color.GRAY;
	private Color yellow = Color.GRAY;
	Color gray = Color.GRAY;
	private Color status = Color.RED;
	public static void main(String[] args) {
		TrafficSignal obj = new TrafficSignal();
		obj.setVisible(true);
	}
	public TrafficSignal() {
		setTitle("Den giao thong");
		setSize(200, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		addKeyListener(this);
		setFocusable(true);
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(red);
		g.fillOval(x,  y,  r,  r);
		
		g.setColor(green);
		g.fillOval(50, y+r, r, r);
		
		g.setColor(yellow);
		g.fillOval(x,  y+2*r,  r,  r);
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_SPACE) {
			if (status == Color.RED) {
				green = Color.GREEN;
				red = Color.GRAY;
				status = Color.GREEN;
				repaint();
			}
			else if(status == Color.GREEN) {
				green = Color.GRAY;
				yellow = Color.yellow;
				status = Color.YELLOW;
				repaint();
			}
			else if(status == Color.YELLOW) {
				yellow = Color.GRAY;
				red = Color.RED;
				status = Color.RED;
				repaint();
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
}
