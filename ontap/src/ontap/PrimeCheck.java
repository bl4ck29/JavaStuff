package ontap;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

public class PrimeCheck extends JFrame {
	private JTextArea content;
	private JTextField txt;
	private Action IsPrime = new Prime();
	private Action Clear = new Clear();
	private Action PrintPrime = new PrintPrime();
	
	public static void main(String[] args) {
		PrimeCheck obj = new PrimeCheck();
		obj.setVisible(true);
	}
	
	public PrimeCheck() {
		setTitle("Check prime");
		setSize(350, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel lbl = new JLabel(java.util.Calendar.getInstance().getTime().toLocaleString());
		lbl.setFont(new Font("Tahloma", Font.BOLD, 15));
		lbl.setForeground(Color.BLUE);
		lbl.setBounds(10, 10, 200, 30);
		
		txt = new JTextField();
		txt.setBounds(230, 10, 100, 30);
		
		JButton btnResult = new JButton("Result");
		btnResult.setBounds(10, 50, 100, 30);
		btnResult.setAction(IsPrime);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(120, 50, 100, 30);
		btnPrint.setAction(PrintPrime);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(230, 50, 100, 30);
		btnClear.setAction(Clear);
		
		content = new JTextArea();
		content.setBounds(10, 100, 320, 50);
		content.setEditable(false);
		
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
			for (int i=2; i<=Math.sqrt(num); i++) {
				if (num % i == 0) {return false;}
			}
		}
		return true;
	}
	
	private class Prime extends AbstractAction{
		public Prime() {putValue(NAME, "Result");}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(!txt.getText().isEmpty()) {
				try {
					int num = Integer.parseInt(txt.getText());
					if(IsPrime(num) == true) {content.setText("La SNT");}
					else {content.setText("Khong la SNT");}
				}
				catch(java.lang.NumberFormatException NumberFormatException){
					content.setText("Nhap vao mot so nguyen");
				}
			}
			else {content.setText("Nhap vao mot so nguyen");}
		}
	}
	
	private class Clear extends AbstractAction{
		public Clear() {putValue(NAME, "Clear");}
		@Override
		public void actionPerformed(ActionEvent arg0) {content.setText(""); txt.setText("");}
		
	}
	
	private class PrintPrime extends AbstractAction{
		public PrintPrime() {putValue(NAME, "Print");}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(!txt.getText().isEmpty()) {
				try {
					int num = Integer.parseInt(txt.getText());
					ArrayList<Integer>  lst = new ArrayList<Integer>();
					for(int i=0; i< num; i++) {
						if(IsPrime(i)) {lst.add(i);}
					}
					content.setText(lst.toString());
				}
				catch(java.lang.NumberFormatException NumberFormatException){
					content.setText("Nhap vao mot so nguyen");
				}
			}
			else {content.setText("Nhap vao mot so nguyen");}
		}
	}
}
