package tuan8_Swing;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MyPanel extends JPanel {
	public void paint(Graphics g) {
		this.setLayout(null);
		int w = 100;
		int h = 30;
		
		//Label
		JLabel lbl = new JLabel();
		lbl.setText("Cao Khanh Viet");
		lbl.setBounds(0, 0, w, h);
		add(lbl);
		
		//Button
		JButton btn = new JButton("Change text color");
		btn.setBounds(100, 0, 150, h);
		add(btn);
		btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(null, "Vui long chon mau nen", btn.getForeground());
				lbl.setForeground(color);
			}
		});
		
		//Label text font
		String[] font = {"Bold", "Plain", "Italic"};
		JComboBox cbxFont = new JComboBox(font);
		cbxFont.setSelectedIndex(0);
		cbxFont.setBounds(0, 40, 100, 30);
		add(cbxFont);
		cbxFont.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				String petname = (String)cb.getSelectedItem();
				String lbl_text = lbl.getText();
				lbl.setText(" ");
				if(petname == "Bold") {
					lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
				}
				else if(petname == "Italic") {
					lbl.setFont(new Font("Tahoma", Font.ITALIC, 12));
				}
				else if(petname == "Plain") {
					lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
				}
				lbl.setText(lbl_text);
			}
		});
		
		
		//TextField
		JTextField tbxName = new JTextField();
		tbxName.setBounds(300, 0, w, h);
		add(tbxName);
		
		
		//RadioButton
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rbtMale = new JRadioButton("Male", true);
		rbtMale.setBounds(0, 70, 100, 20);
		JRadioButton rbtFemale = new JRadioButton("Female", false);
		rbtFemale.setBounds(100, 70, 100, 20);
		JRadioButton rbtNS = new JRadioButton("Not specified", false);
		rbtNS.setBounds(200, 70, 150, 20);
		bg.add(rbtMale);
		bg.add(rbtFemale);
		bg.add(rbtNS);
		add(rbtMale);
		add(rbtFemale);
		add(rbtNS);
		
		
		//Checkbox
		JCheckBox ckxJava = new JCheckBox("Java");
		ckxJava.setBounds(0, 100, 100, 30);
		JCheckBox ckxC = new JCheckBox("C");
		ckxC.setBounds(100, 100, 100, 30);
		JCheckBox ckxPython = new JCheckBox("Python");
		ckxPython.setBounds(200, 100, 100, 30);
		add(ckxJava);
		add(ckxC);
		add(ckxPython);
		
		
		//Table
		Object[][] data = {{1, "Nguyen Van A", 7.5}, {2, "Nguyen Van B", 8}, {3, "Nguyen Van C", 6}, {4, "Nguyen Van D", 9}, {5, "Nguyen Van E", 4.5}};
		String[] cols = {"STT", "Ho va ten", "Diem"};
		JTable myTable = new JTable(data, cols);
		JScrollPane scroll = new JScrollPane(myTable);
		scroll.setBounds(0, 150, 300, 150);
		add(scroll);
		
		
		//Combobox
		this.setLayout(null);
		String[] data_Tinh = {"HCM", "Ha noi", "Khanh Hoa", "Can Tho", "Phu Quoc"};
		JComboBox cbxTinh = new JComboBox(data_Tinh);
		cbxTinh.setSelectedIndex(2);
		cbxTinh.setBounds(400, 0, 100, 30);
		add(cbxTinh);
		cbxTinh.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				String petname = (String)cb.getSelectedItem();
				JOptionPane.showMessageDialog(null, petname);
			}
		});
		
		
		//JSplitPane
		String[] option1 = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};
		JComboBox cbxAnimal = new JComboBox(option1);
		String[] option2 = {"Car", "Motorcycle", "Airplane", "Boat"};
		JComboBox cbxTrans = new JComboBox(option2);
		
		Panel panel1 = new Panel();
		panel1.add(cbxAnimal);
		Panel panel2 = new Panel();
		panel2.add(cbxTrans);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, panel2);
		splitPane.setPreferredSize(new Dimension(400, 300));
		splitPane.setDividerLocation(100);
		
		super.paint(g);
	}
}
