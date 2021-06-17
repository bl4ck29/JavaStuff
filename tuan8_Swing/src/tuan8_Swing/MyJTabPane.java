package tuan8_Swing;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MyJTabPane extends JTabbedPane {
	@Override
	public void paint(Graphics g) {
		JTabbedPane tabs = new JTabbedPane();
		tabs.add("Tab1", CreatePanel("Day la Tab 1"));
		tabs.add("Tab2", CreatePanel("Day la Tab 2"));
		tabs.setBounds(10, 0, 600, 500);
		add(tabs);
		
		super.paint(g);
	}
	private JPanel CreatePanel(String title) {
		JPanel p = new JPanel();
		p.add(new Label(title));
		p.setLayout(new GridLayout(1, 1));
		return p;
	}
}
