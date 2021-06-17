package tuan8_baitap;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Zoom extends JFrame {
	int x = 150;
	int y = 150;
	int r = 200;
	private final Action zoomIn = new SwingAction();
	private final Action zoomOut = new SwingAction_1();
	JLabel lbl;
	public static void main(String[] args) {
		Zoom zoom = new Zoom();
		zoom.setVisible(true);
	}
	public Zoom() {
		setSize(400, 400);
		setTitle("Zoom");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JButton btnIn = new JButton("Zoom in");
		btnIn.setBounds(20, 20, 100, 30);
		btnIn.setAction(zoomIn);
		getContentPane().add(btnIn);
		
		JButton btnOut = new JButton("Zoom out");
		btnOut.setBounds(20, 60, 100, 30);
		btnOut.setAction(zoomOut);
		getContentPane().add(btnOut);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.red);
		g.drawOval(x,  y,  r,  r);
	}
	private class SwingAction extends AbstractAction{
		public SwingAction() {
			putValue(NAME, "Zoom in");
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			r += 10;
			repaint();
		}
	}
	private class SwingAction_1 extends AbstractAction{
		public SwingAction_1() {
			putValue(NAME, "Zoom out");
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			r -= 10;
			repaint();
		}
	}
}
