package tuan6_baitap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SmileyApp  extends JPanel{
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.fillOval(10, 10, 200, 200);
		g.setColor(Color.BLACK);
		g.fillOval(55, 65, 30, 30);
		g.fillOval(135, 65, 30, 30);
		
		g.fillOval(50, 110, 120, 60);
		
		g.setColor(Color.YELLOW);
		g.fillRect(50,110,120,30);
		g.fillOval(50, 120, 120, 40);
		
		g.setColor(Color.BLACK);
		g.drawRect(100, 100, 100, 100);
		
		g.drawOval(100, 100, 100, 100);
		
		g.drawRoundRect(100, 100, 100, 100, 40, 40);
		//draw T
		g.drawRect(10, 10, 50, 20);
		g.drawRect(25, 30, 20, 50);
		//draw I
		g.drawRect(80, 10, 20, 70);
		//draw rect
		g.drawRect(120, 10, 70, 70);
		//draw L
		g.drawRect(200, 10, 20, 50);
		g.drawRect(200, 60, 50, 20);
		
		g.drawRect(0, 0, 300, 300);
		g.drawRect(100, 100, 100, 100);
	}
	
	public static void main(String[] args) {
		SmileyApp smile = new SmileyApp();
		JFrame app = new JFrame("Mat cuoi");
		app.add(smile, BorderLayout.CENTER);
		app.setSize(300, 300);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}
