import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class hinhDong extends JFrame {

	int x =20;
	int y= 40;
	
	Random rd = new Random();
	int cx = rd.nextInt(30);
	int cy = rd.nextInt(30);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hinhDong c = new hinhDong();
		c.setVisible(true);
	}
	public hinhDong() {
		setTitle("Chuyển động");
		setSize(800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Timer time = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(x <20) {
					cx = -cx;
				}
				if(y <38) {
					cy = -cy;
				}
				if(x > 685) {
					cx = -cx;
				}
				if(y >685) {
					cy = -cy;
				}
					x = x + cx;
					y = y + cy;
					repaint();

			}
		});
		time.start();
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.BLUE);
		g.fillOval(x, y, 100, 100);
	}
}
