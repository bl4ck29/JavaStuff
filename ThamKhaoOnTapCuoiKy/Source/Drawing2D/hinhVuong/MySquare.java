import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class MySquare extends JComponent {
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		MyFrame frame = new MyFrame();
		int height = 400;
		int width = 400;
		int x= (frame.getWidth()/2)-(width/2)-5;
		int y= (frame.getHeight()/2)-(height/2)-20;
		
		Graphics2D graphic = (Graphics2D)g;
		Rectangle square= new Rectangle(x, y ,width ,height);
		
		graphic.setColor(Color.RED);
		graphic.fill(square);
	}
}
