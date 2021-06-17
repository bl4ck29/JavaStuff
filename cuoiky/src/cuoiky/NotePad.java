package cuoiky;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.*;
public class NotePad extends JFrame {
	JMenuBar mnuBar;
	JMenu mnuFile, mnuFormat;
	JMenuItem mnuOpen, mnuClose, mnuBackColor, mnuForeColor;
	JTextArea txtContent;
	JScrollPane scroll;
	public NotePad() {
		setTitle("Notepad");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		mnuBar = new JMenuBar();
		mnuFile = new JMenu("File");
		mnuFormat = new JMenu("Format");
		mnuOpen = new JMenuItem("Open file");
		mnuClose = new JMenuItem("Close");
		mnuBackColor = new JMenuItem("Change bachground color");
		mnuForeColor = new JMenuItem("Change forground color");
		
		mnuFile.add(mnuOpen);
		mnuFile.add(mnuClose);
		mnuFormat.add(mnuBackColor);
		mnuFormat.add(mnuForeColor);
		mnuBar.add(mnuFile);
		mnuBar.add(mnuFormat);
		
		setJMenuBar(mnuBar);
		
		txtContent = new JTextArea();
		scroll = new JScrollPane(txtContent);
		getContentPane().add(scroll);
		
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == mnuOpen) {
					JFileChooser open = new JFileChooser();
					int result = open.showOpenDialog(null);
					if(result == JFileChooser.APPROVE_OPTION) {
						try {
							File file = new File(open.getSelectedFile().getAbsolutePath());
							InputStream inp = new FileInputStream(file);
							byte[] data = inp.readAllBytes();
							String content = new String(data);
							txtContent.setText(content);
							inp.close();
						}
						catch(Exception err) {err.getStackTrace();}
					}
				}
				else if(arg0.getSource() == mnuClose) {
					int result = JOptionPane.showConfirmDialog(null, "Close the current file?", "Alert", JOptionPane.OK_CANCEL_OPTION);
					if(result == JOptionPane.OK_OPTION) {System.exit(0);}
				}
				else if(arg0.getSource() == mnuBackColor) {
					Color color = JColorChooser.showDialog(null, "Chooser the background color", txtContent.getBackground());
					txtContent.setBackground(color);
				}
				else if (arg0.getSource() == mnuForeColor) {
					Color color = JColorChooser.showDialog(null, "Chooser text's color", txtContent.getForeground());
					txtContent.setForeground(color);
				}
			}
		};
		mnuOpen.addActionListener(listener);
		mnuClose.addActionListener(listener);
		mnuBackColor.addActionListener(listener);
		mnuForeColor.addActionListener(listener);
	}
	public static void main(String[] args) {
		NotePad note = new NotePad();
		note.setVisible(true);
	}
}
