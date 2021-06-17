import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class denGiaoThong extends JFrame {

	int width = 120;
	int height = 120;
	private Color denDo = Color.RED;
	private Color denVang = Color.YELLOW;
	private Color denXanh = Color.GREEN;
	String trangthai = "xanh";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		denGiaoThong c = new denGiaoThong();
		c.setVisible(true);
	}

	
	public denGiaoThong() {
		setTitle("Ðèn Giao Thông");
		setSize(250, 460);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Timer thoigian = new Timer(5000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				doimau();
			}
		});
		thoigian.start();
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(denDo);
		g.fillOval(65, 50, width, height);
		g.setColor(Color.BLACK);
		g.drawOval(65, 50, width, height);
		
		g.setColor(denVang);
		g.fillOval(65, 180, width, height);
		g.setColor(Color.BLACK);
		g.drawOval(65, 180, width, height);
		
		g.setColor(denXanh);
		g.fillOval(65, 310, width, height);
		g.setColor(Color.BLACK);
		g.drawOval(65, 310, width, height);
	}
	
	public void doimau() {
		denDo= Color.GRAY;
		denVang= Color.GRAY;
		denXanh= Color.GRAY;
		if(trangthai.equals("xanh")) {
			denVang = Color.YELLOW;
			trangthai = "vang";
		}
		else if(trangthai.equals("vang")) {
			denDo = Color.RED;
			trangthai = "do";
		}
		else if (trangthai.equals("do")) {
			denXanh = Color.GREEN;
			trangthai = "xanh";
		}
		repaint();
	}

}
