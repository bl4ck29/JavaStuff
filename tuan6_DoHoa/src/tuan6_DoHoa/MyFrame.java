package tuan6_DoHoa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MyFrame extends JFrame implements KeyListener{
	int x=200;
	int y=200;
	int w=100;
	int h =100;
	public MyFrame() {
		setTitle("Main window");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		addKeyListener(this);
		setFocusable(true);
	}
	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame();
		myFrame.setVisible(true);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.green);
		g.fillOval(x, y, w, h);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(x>=0 && x<=800 && y>=0 && y<=600) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_LEFT) {x-=10;}
			if(key == KeyEvent.VK_RIGHT) {x+=10;}
			if(key == KeyEvent.VK_UP) {y-=10;}
			if(key == KeyEvent.VK_DOWN) {y+=10;}
		}
		if(x<=0) {x=0;}
		if(y<=0) {y=0;}
		if(x>=800) {x=800;}
		if(y>=600) {y=600;}
		repaint();
	}
	
	@Override
	public void keyTyped(KeyEvent e) { }
	
	@Override
	public void keyReleased(KeyEvent e) { }
}
