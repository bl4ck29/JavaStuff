package tuan8_baitap;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.*;

public class Notepad extends JFrame {
	JMenuBar mnuBar;
	JMenu mnuFile, mnuFormat;
	JMenuItem mnuOpen, mnuExit, mnuBackgroundColor, mnuFontColor;
	JTextArea txtContent;
	JScrollPane scroll;
	public static void main(String[] args) {
		Notepad  np = new Notepad();
		np.setVisible(true);
	}
	public Notepad() {
		setSize(700, 700);
		setTitle("Notepad");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		mnuOpen = new JMenuItem("Open");
		mnuExit = new JMenuItem("Exit");
		mnuBackgroundColor = new JMenuItem("Change background color");
		mnuFontColor = new JMenuItem("Change font color");
		mnuFile = new JMenu("File");
		mnuFormat = new JMenu("Format");
		mnuBar = new JMenuBar();
		txtContent = new JTextArea();
		scroll = new JScrollPane(txtContent);
		
		
		mnuFile.add(mnuOpen);
		mnuFile.add(mnuExit);
		mnuFormat.add(mnuBackgroundColor);
		mnuFormat.add(mnuFontColor);
		mnuBar.add(mnuFile);
		mnuBar.add(mnuFormat);
		getContentPane().add(scroll);
		setJMenuBar(mnuBar);
		
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == mnuOpen) {
					JFileChooser fileChooser = new JFileChooser();
					int result = fileChooser.showOpenDialog(null);
					if(result == JFileChooser.APPROVE_OPTION) {
						File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
						try {
							InputStream input = new FileInputStream(file);
							byte[] data = input.readAllBytes();
							txtContent.setText(new String(data));
							input.close();
						}
						catch(Exception err) {
							err.getStackTrace();
						}
					}
				}
				else if(e.getSource() == mnuExit) {
					int result = JOptionPane.showConfirmDialog(null, "Do you want to close??");
					if(result == JOptionPane.OK_OPTION) {
						System.exit(0);
					}
				}
				else if(e.getSource() == mnuBackgroundColor) {
					Color color = JColorChooser.showDialog(null, "Chon mau nen", txtContent.getBackground());
					txtContent.setBackground(color);
				}
				else if (e.getSource() == mnuFontColor) {
					Color color = JColorChooser.showDialog(null, "Chon mau chu", txtContent.getForeground());
					txtContent.setForeground(color);
				}
			}
		};
		mnuOpen.addActionListener(action);
		mnuExit.addActionListener(action);
		mnuBackgroundColor.addActionListener(action);
		mnuFontColor.addActionListener(action);
	}
}
