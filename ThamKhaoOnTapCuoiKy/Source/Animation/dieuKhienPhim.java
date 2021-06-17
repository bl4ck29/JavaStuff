import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class dieuKhienPhim extends JFrame implements KeyListener {
	
	int width = 100;
	int height = 100;
	int x = 20;
	int y = 40;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(y>=35) {
				y -= 5;
				repaint();
			}
			else {
				JOptionPane.showMessageDialog(null, "Đã chạm khung màn hình");
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(y<= 485) {
				y += 5;
				repaint();
			}
			else {
				JOptionPane.showMessageDialog(null, "Đã chạm khung màn hình");
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(x>=15) {
				x -= 5;
				repaint();
			}
			else {
				JOptionPane.showMessageDialog(null, "Đã chạm khung màn hình");
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(x<=490) {
				x += 5;
				repaint();
			}
			else {
				JOptionPane.showMessageDialog(null, "Đã chạm khung màn hình");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dieuKhienPhim c = new dieuKhienPhim();
		c.setVisible(true);
	}
	
	public dieuKhienPhim() {
		addKeyListener(this);
		setFocusable(true);
		
		setTitle("Điều khiển bằng phím");
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.YELLOW);
		g.fillOval(x, y , width, height);
	}
}
