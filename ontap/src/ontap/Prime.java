package ontap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Prime extends JFrame {
	JTextArea content;
	JTextField txt;
	JButton btnResult, btnPrint, btnClear;
	public static void main(String[] args) {
		Prime obj = new Prime();
		obj.setVisible(true);
	}
	
	public Prime() {
		setTitle("Check prime");
		setSize(350, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel lbl = new JLabel(java.util.Calendar.getInstance().getTime().toLocaleString());
		lbl.setBounds(10, 10, 200, 30);
		
		txt = new JTextField();
		txt.setBounds(230, 10, 100, 30);
		
		btnResult = new JButton("Result");
		btnResult.setBounds(10, 50, 100, 30);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(230, 50, 100, 30);
		
		btnPrint = new JButton("Print");
		btnPrint.setBounds(120, 50, 100, 30);
		
		content = new JTextArea();
		content.setBounds(10, 100, 320, 50);
		content.setEditable(false);
		
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == btnResult) {
					if(!txt.getText().isEmpty()) {
						try {
							int num = Integer.parseInt(txt.getText());
							if(IsPrime(num) == true) {content.setText("La SNT");}
							else {content.setText("Khong la SNT");}
						}
						catch(java.lang.NumberFormatException NumberFormatException) {
							content.setText("Nhap vao mot so nguyen to");
						}
					}
					else {content.setText("Nhap vao mot so nguyen");}
				}
				
				if(arg0.getSource() == btnClear) {
					content.setText("");
					txt.setText("");
				}
				
				if(arg0.getSource() == btnPrint) {
					if(!txt.getText().isEmpty()) {
						try {
							int num = Integer.parseInt(txt.getText());
							ArrayList<Integer> lst = new ArrayList<Integer>();
							for(int i=0; i<num;i++) {
								if(IsPrime(i)) {lst.add(i);}
							}
							content.setText(lst.toString());
						}
						catch(java.lang.NumberFormatException NumberFormatException) {
							content.setText("Nhap vao mot so nguyen");
						}
					}
					else {content.setText("Nhap vap mot so nguyen");}
				}
			}
			
		};
		
		btnResult.addActionListener(action);
		btnClear.addActionListener(action);
		btnPrint.addActionListener(action);
		
		getContentPane().add(lbl);
		getContentPane().add(btnResult);
		getContentPane().add(btnClear);
		getContentPane().add(btnPrint);
		getContentPane().add(txt);
		getContentPane().add(content);
	}
	
	private Boolean IsPrime(int num) {
		if(num<=0) {return false;}
		else if(num == 1) {return true;}
		else if(num == 2) {return true;}
		else {
			for(int i=2; i<=Math.sqrt(num);i++) {
				if(num%i==0){return false;}
			}
		}
		return true;
	}
}
