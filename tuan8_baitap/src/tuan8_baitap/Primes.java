package tuan8_baitap;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.Action;

public class Primes {

	private JFrame frame;
	private JTextField tbxNhap;
	private JTextArea txtResult;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Primes window = new Primes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Primes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 254);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNhap = new JLabel("Nhap vao mot so nguyen");
		lblNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhap.setBounds(20, 20, 200, 30);
		frame.getContentPane().add(lblNhap);
		
		tbxNhap = new JTextField();
		tbxNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbxNhap.setBounds(240, 20, 100, 30);
		frame.getContentPane().add(tbxNhap);
		tbxNhap.setColumns(10);
		
		JButton btnResult = new JButton("Result");
		btnResult.setAction(action);
		btnResult.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnResult.setBounds(20, 60, 150, 30);
		frame.getContentPane().add(btnResult);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setAction(action_1);
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.setBounds(190, 60, 150, 30);
		frame.getContentPane().add(btnClear);
		
		txtResult = new JTextArea();
		txtResult.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtResult.setBounds(20, 100, 320, 101);
		frame.getContentPane().add(txtResult);
		txtResult.setColumns(10);

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Result");
			putValue(SHORT_DESCRIPTION, "Check if the number is prime");
		}
		public void actionPerformed(ActionEvent e) {
			int num = Integer.parseInt(tbxNhap.getText());
			String primes ="";
			for (int i = 1; i<= num;i++) {
				if(IsPrime(i)) {
					primes += " "+i;
				}
			}
			txtResult.setText(primes);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Clear");
			putValue(SHORT_DESCRIPTION, "Clear the result box");
		}
		public void actionPerformed(ActionEvent e) {
			txtResult.setText("");
			tbxNhap.setText("");
		}
	}
	private Boolean IsPrime(int num) {
		if(num == 1 || num == 2) {return true;}
		else {
			for (int i = 2; i <= (int)Math.sqrt(num); i++) {
				if(num % i == 0) {return false;}
			}
		}
		return true;
	}
}
