import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;

public class MyCircle extends JComponent {
	protected void paintComponent (Graphics g) {
		FrameCircle frame_rect = new FrameCircle();
		int height = 500;
		int width = 500;
		int x = (frame_rect.getWidth()/2)-(width/2)-5;
		int y = (frame_rect.getHeight()/2)-(height/2)-20;
		
		
		g.setColor(Color.GREEN);
		g.fillOval(x, y, width, height);
		
	}
}
