package ontap;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.io.*;

public class Notepad extends JFrame {
	private JTextArea content;
	private final Action OpenFile = new OpenFile();
	private final Action Close = new Close();
	private final Action BackColor = new BackColor();
	private final Action ForeColor = new ForeColor();
	public static void main(String[] args) {
		Notepad  obj = new Notepad();
		obj.setVisible(true);
	}
	public Notepad() {
		JMenuBar mnuBar = new JMenuBar();
		
		JMenu mnuFile = new JMenu("File");
		
		JMenu mnuFormat = new JMenu("Format");
		
		JMenuItem mnuOpen = new JMenuItem("Open file");
		mnuOpen.setAction(OpenFile);
		JMenuItem mnuClose = new JMenuItem("Close");
		mnuClose.setAction(Close);
		JMenuItem mnuBackColor = new JMenuItem("Change background color");
		mnuBackColor.setAction(BackColor);
		JMenuItem mnuForeColor = new JMenuItem("Change foreground color");
		mnuForeColor.setAction(ForeColor);
		content = new JTextArea();
		JScrollPane scroll = new JScrollPane(content);
		
		mnuFile.add(mnuOpen);
		mnuFile.add(mnuClose);
		mnuFormat.add(mnuBackColor);
		mnuFormat.add(mnuForeColor);
		mnuBar.add(mnuFile);
		mnuBar.add(mnuFormat);
		getContentPane().add(scroll);
		
		setTitle("Notepad");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setJMenuBar(mnuBar);
	}
	private class OpenFile extends AbstractAction{
		public OpenFile() {
			putValue(NAME, "Open file");
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser chooser = new JFileChooser();
			int res = chooser.showOpenDialog(null);
			if(res == JFileChooser.APPROVE_OPTION) {
				String path =  chooser.getSelectedFile().getAbsolutePath();
				File file = new File(path);
				try {
					InputStream inp = new FileInputStream(file);
					byte[] data = inp.readAllBytes();
					inp.close();
					String text = new String(data);
					content.setText(text);
				}
				catch(Exception err) { err.getStackTrace();}
			}
		}
	}
	private class Close extends AbstractAction{
		public Close() {
			putValue(NAME, "Close");
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int res = JOptionPane.showConfirmDialog(null, "Leave the workplace ???", "Alert", 1);
			if(res == JOptionPane.OK_OPTION) {
				System.exit(0);
			}
		}
	}
	private class BackColor extends AbstractAction{
		public BackColor() {
			putValue(NAME, "Change background color");
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Color color = JColorChooser.showDialog(null, "Chooser background color", content.getBackground());
			content.setBackground(color);
		}
	}
	private class ForeColor extends AbstractAction{
		public ForeColor() {
			putValue(NAME, "Change foreground color");
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Color color = JColorChooser.showDialog(null, "Chooser background color", content.getForeground());
			content.setForeground(color);
		}
	}
}
