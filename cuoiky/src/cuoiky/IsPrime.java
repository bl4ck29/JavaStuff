package cuoiky;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class IsPrime extends JFrame {
	JButton btnResult;
	JButton btnClear;
	JLabel lbl;
	JTextArea txt;
	JTextField tbx;
	
	public IsPrime() {
		setTitle("Prime");
		setSize(300, 200);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		lbl = new JLabel("Nhap vao mot so nguyen: ");
		lbl.setBounds(10, 10, 200, 20);
		
		tbx = new JTextField();
		tbx.setBounds(220, 10, 50, 20);
		
		btnResult = new JButton("Result");
		btnResult.setBounds(10, 40, 100, 20);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(170, 40, 100, 20);
		
		txt = new JTextArea();
		txt.setBounds(10, 70, 260, 80);
		
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == btnResult) {
					String text = "";
					int num = Integer.parseInt(tbx.getText());
					if(Prime(num)) {
						text += "La so nguyen to";
					}
					else {
						text += "Khong la so nguyen to";
					}
					text += "\n" + PrintPrime(num).toString();
					txt.setText(text);
				}
				else if(arg0.getSource() == btnClear) {
					txt.setText("");
					tbx.setText("");
				}
			}
		};
		btnResult.addActionListener(action);
		btnClear.addActionListener(action);
		
		getContentPane().add(btnResult);
		getContentPane().add(btnClear);
		getContentPane().add(lbl);
		getContentPane().add(tbx);
		getContentPane().add(txt);
	}
	public Boolean Prime(int number) {
		if(number<=0) {return false;}
		else if(number <=2) {return true;}
		else {
			for(int i=2; i<=Math.sqrt(number); i++) {
				if(number % i== 0){return false;}
			}
		}
		return true;
	}
	public ArrayList<Integer> PrintPrime(int number) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i<=number; i++) {
			if(Prime(i)==true) {arr.add(i);}
		}
		return arr;
	}
	public static void main(String[] args) {
		IsPrime object = new IsPrime();
		object.setVisible(true);
	}
}
