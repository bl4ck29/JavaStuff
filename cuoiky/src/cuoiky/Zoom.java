package cuoiky;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Zoom extends JFrame {
	JButton btnZoomIn;
	JButton btnZoomOut;
	int x= 150;
	int y = 150;
	int r = 200;
	public Zoom() {
		setTitle("Zoom");
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		btnZoomIn = new JButton("Zoom in");
		btnZoomIn.setBounds(20, 20, 100, 30);
		
		btnZoomOut = new JButton("Zoom out");
		btnZoomOut.setBounds(20, 60, 100, 30);
		
		ActionListener action = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == btnZoomIn) {
					r += 10;
					repaint();
				}
				else if(arg0.getSource() == btnZoomOut) {
					r -= 10;
					repaint();
				}
			}
		};
		
		btnZoomIn.addActionListener(action);
		btnZoomOut.addActionListener(action);
		
		getContentPane().add(btnZoomIn);
		getContentPane().add(btnZoomOut);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.red);
		g.drawOval(x,  y,  r,  r);
	}
	public static void main(String[] args) {
		Zoom object = new Zoom();
		object.setVisible(true);
	}
}
