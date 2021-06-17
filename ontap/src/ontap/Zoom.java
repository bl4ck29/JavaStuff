package ontap;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Zoom extends JFrame{
	private int x = 100;
	private int y = 100;
	private int r = 100;
	private final Action ZoomIn = new ZoomIn();
	private final Action ZoomOut = new ZoomOut();
	public static void main(String[] args) {
		Zoom obj = new Zoom();
		obj.setVisible(true);
	}
	public Zoom() {
		setTitle("Zoom");
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		JButton btnIn = new JButton("Zoom in");
		btnIn.setBounds(10, 10, 100, 30);
		btnIn.setAction(ZoomIn);
		
		JButton btnOut = new JButton("Zoom out");
		btnOut.setBounds(10, 50, 100, 30);
		btnOut.setAction(ZoomOut);
		
		getContentPane().add(btnIn);
		getContentPane().add(btnOut);
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.drawOval(x,  y, r, r);
	}
	
	private class ZoomIn extends AbstractAction{
		public ZoomIn() {putValue(NAME, "Zoom in");}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			r += 10;
			repaint();
		}
	}
	
	private class ZoomOut extends AbstractAction{
		public ZoomOut() {putValue(NAME, "Zoom out");}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			r -= 10;
			repaint();
		}
	}
}
