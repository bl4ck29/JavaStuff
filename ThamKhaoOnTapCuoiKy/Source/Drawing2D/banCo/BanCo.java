import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.print.attribute.standard.Copies;
import javax.swing.JComponent;

public class BanCo extends JComponent {
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		int height = 70,width = 70;
		int x = 20,y = 20;
		Graphics2D graphic = (Graphics2D)g;
		//Dong 1
		Rectangle rectw1_1 = new Rectangle(x, y, width, height);
		graphic.draw(rectw1_1);
		Rectangle rectb1_1 = new Rectangle(x+width, y, width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb1_1);
		Rectangle rectw1_2 = new Rectangle(x+(width*2), y, width, height);
		graphic.draw(rectw1_2);
		Rectangle rectb1_2 = new Rectangle(x+(width*3), y, width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb1_2);
		Rectangle rectw1_3 = new Rectangle(x+(width*4), y, width, height);
		graphic.draw(rectw1_3);
		Rectangle rectb1_3 = new Rectangle(x+(width*5), y, width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb1_3);
		Rectangle rectw1_4 = new Rectangle(x+(width*6), y, width, height);
		graphic.draw(rectw1_4);
		Rectangle rectb1_4 = new Rectangle(x+(width*7), y, width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb1_4);
		
		//Dong 2
		Rectangle rectb2_1 = new Rectangle(x, y+height, width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb2_1);
		Rectangle rectw2_1 = new Rectangle(x+width, y+height, width, height);
		graphic.draw(rectw2_1);
		Rectangle rectb2_2 = new Rectangle(x+(width*2), y+height, width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb2_2);
		Rectangle rectw2_2 = new Rectangle(x+(width*3), y+height, width, height);
		graphic.draw(rectw2_2);
		Rectangle rectb2_3 = new Rectangle(x+(width*4), y+height, width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb2_3);
		Rectangle rectw2_3 = new Rectangle(x+(width*5), y+height, width, height);
		graphic.draw(rectw2_3);
		Rectangle rectb2_4 = new Rectangle(x+(width*6), y+height, width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb2_4);
		Rectangle rectw2_4 = new Rectangle(x+(width*7), y+height, width, height);
		graphic.draw(rectw2_4);
		
		//Dong 3
		Rectangle rectw3_1 = new Rectangle(x, y+(height*2), width, height);
		graphic.draw(rectw3_1);
		Rectangle rectb3_1 = new Rectangle(x+width, y+(height*2), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb3_1);
		Rectangle rectw3_2 = new Rectangle(x+(width*2), y+(height*2), width, height);
		graphic.draw(rectw3_2);
		Rectangle rectb3_2 = new Rectangle(x+(width*3), y+(height*2), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb3_2);
		Rectangle rectw3_3 = new Rectangle(x+(width*4), y+(height*2), width, height);
		graphic.draw(rectw3_3);
		Rectangle rectb3_3 = new Rectangle(x+(width*5), y+(height*2), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb3_3);
		Rectangle rectw3_4 = new Rectangle(x+(width*6), y+(height*2), width, height);
		graphic.draw(rectw3_4);
		Rectangle rectb3_4 = new Rectangle(x+(width*7), y+(height*2), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb3_4);
		
		//Dong 4
		Rectangle rectb4_1 = new Rectangle(x, y+(height*3), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb4_1);
		Rectangle rectw4_1 = new Rectangle(x+width, y+(height*3), width, height);
		graphic.draw(rectw4_1);
		Rectangle rectb4_2 = new Rectangle(x+(width*2), (y+height*3), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb4_2);
		Rectangle rectw4_2 = new Rectangle(x+(width*3), y+(height*3), width, height);
		graphic.draw(rectw4_2);
		Rectangle rectb4_3 = new Rectangle(x+(width*4), y+(height*3), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb4_3);
		Rectangle rectw4_3 = new Rectangle(x+(width*5), y+(height*3), width, height);
		graphic.draw(rectw4_3);
		Rectangle rectb4_4 = new Rectangle(x+(width*6), y+(height*3), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb4_4);
		Rectangle rectw4_4 = new Rectangle(x+(width*7), y+(height*3), width, height);
		graphic.draw(rectw4_4);
		//Dong 5
		Rectangle rectw5_1 = new Rectangle(x, (y+height*4), width, height);
		graphic.draw(rectw5_1);
		Rectangle rectb5_1 = new Rectangle(x+width, (y+height*4), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb5_1);
		Rectangle rectw5_2 = new Rectangle(x+(width*2), (y+height*4), width, height);
		graphic.draw(rectw5_2);
		Rectangle rectb5_2 = new Rectangle(x+(width*3), (y+height*4), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb5_2);
		Rectangle rectw5_3 = new Rectangle(x+(width*4),  (y+height*4), width, height);
		graphic.draw(rectw5_3);
		Rectangle rectb5_3 = new Rectangle(x+(width*5),  (y+height*4), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb5_3);
		Rectangle rectw5_4 = new Rectangle(x+(width*6), (y+height*4), width, height);
		graphic.draw(rectw5_4);
		Rectangle rectb5_4 = new Rectangle(x+(width*7), (y+height*4), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb5_4);
		
		//Dong 6
		Rectangle rectb6_1 = new Rectangle(x,  (y+height*5), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb6_1);
		Rectangle rectw6_1 = new Rectangle(x+width, (y+height*5), width, height);
		graphic.draw(rectw6_1);
		Rectangle rectb6_2 = new Rectangle(x+(width*2), (y+height*5), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb6_2);
		Rectangle rectw6_2 = new Rectangle(x+(width*3), (y+height*5), width, height);
		graphic.draw(rectw6_2);
		Rectangle rectb6_3 = new Rectangle(x+(width*4),  (y+height*5), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb6_3);
		Rectangle rectw6_3 = new Rectangle(x+(width*5), (y+height*5), width, height);
		graphic.draw(rectw6_3);
		Rectangle rectb6_4 = new Rectangle(x+(width*6), (y+height*5), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb6_4);
		Rectangle rectw6_4 = new Rectangle(x+(width*7), (y+height*5), width, height);
		graphic.draw(rectw6_4);
		
		//Dong 7
		Rectangle rectw7_1 = new Rectangle(x, y+(height*6), width, height);
		graphic.draw(rectw7_1);
		Rectangle rectb7_1 = new Rectangle(x+width, y+(height*6), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb7_1);
		Rectangle rectw7_2 = new Rectangle(x+(width*2), y+(height*6), width, height);
		graphic.draw(rectw7_2);
		Rectangle rectb7_2 = new Rectangle(x+(width*3), y+(height*6), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb7_2);
		Rectangle rectw7_3 = new Rectangle(x+(width*4), y+(height*6), width, height);
		graphic.draw(rectw7_3);
		Rectangle rectb7_3 = new Rectangle(x+(width*5), y+(height*6), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb7_3);
		Rectangle rectw7_4 = new Rectangle(x+(width*6), y+(height*6), width, height);
		graphic.draw(rectw7_4);
		Rectangle rectb7_4 = new Rectangle(x+(width*7), y+(height*6), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb7_4);
		
		//Dong 8
		Rectangle rectb8_1 = new Rectangle(x, y+(height*7), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb8_1);
		Rectangle rectw8_1 = new Rectangle(x+width, y+(height*7), width, height);
		graphic.draw(rectw8_1);
		Rectangle rectb8_2 = new Rectangle(x+(width*2), (y+height*7), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb8_2);
		Rectangle rectw8_2 = new Rectangle(x+(width*3), y+(height*7), width, height);
		graphic.draw(rectw8_2);
		Rectangle rectb8_3 = new Rectangle(x+(width*4), y+(height*7), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb8_3);
		Rectangle rectw8_3 = new Rectangle(x+(width*5), y+(height*7), width, height);
		graphic.draw(rectw8_3);
		Rectangle rectb8_4 = new Rectangle(x+(width*6), y+(height*7), width, height);
		graphic.setColor(Color.BLACK);
		graphic.fill(rectb8_4);
		Rectangle rectw8_4 = new Rectangle(x+(width*7), y+(height*7), width, height);
		graphic.draw(rectw8_4);
	}
}
