package tuan8_Swing;

import javax.swing.JFrame;

public class Control extends JFrame {
	public Control() {
		setTitle("Control thong dung");;
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MyPanel mp = new MyPanel();
		MyJTabPane tabs = new MyJTabPane();
		this.add(mp);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		Control c = new Control();
		c.setVisible(true);
	}
}
