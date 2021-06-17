package ontap;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TrafficSignal extends JFrame implements KeyListener{
	private int x = 50;
	private int y = 50;
	private int r = 100;
	private Color red = Color.RED;
	private Color green = Color.GRAY;
	private Color yellow = Color.GRAY;
	private Color sta = Color.RED;
	private JLabel lbl;
	public static void main(String[] args) {
		TrafficSignal obj = new TrafficSignal();
		obj.setVisible(true);
	}
	public TrafficSignal() {
		setTitle("Traffic signal");
		setSize(200, 400);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		lbl = new JLabel(java.util.Calendar.getInstance().getTime().toLocaleString());
		lbl.setBounds(10, 330, 150, 30);
		getContentPane().add(lbl);
		addKeyListener(this);
		Timer time = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Change();
			}
		});
		time.start();
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(red);
		g.fillOval(x, y, r, r);
		
		g.setColor(green);
		g.fillOval(x, y+r, r, r);
		
		g.setColor(yellow);
		g.fillOval(x, y+2*r, r, r);
	}
	public void Change() {
		if(sta == Color.RED) {
			red = Color.GRAY;
			green = Color.GREEN;
			sta = Color.GREEN;
		}
		else if(sta == Color.GREEN) {
			green = Color.gray;
			yellow = Color.yellow;
			sta = Color.YELLOW;
		}
		else if (sta == Color.YELLOW) {
			yellow = Color.GRAY;
			red = Color.RED;
			sta = Color.red;
		}
		lbl.setText(java.util.Calendar.getInstance().getTime().toLocaleString());
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {if(arg0.getKeyCode() == KeyEvent.VK_SPACE) {Change();}}
	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
}
