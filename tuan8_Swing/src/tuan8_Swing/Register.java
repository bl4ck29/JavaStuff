package tuan8_Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.Action;

public class Register {
	private JFrame frmRegister;
	private JTextField tbxFN;
	private JTextField tbxLN;
	private JTextField tbxEmail;
	private final Action action = new SwingAction();
	private JTextField tbxPass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frmRegister.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegister = new JFrame();
		frmRegister.getContentPane().setBackground(new Color(153, 153, 153));
		frmRegister.setBackground(Color.LIGHT_GRAY);
		frmRegister.setTitle("Register");
		frmRegister.setBounds(100, 100, 613, 289);
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegister.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(20, 30, 100, 40);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmRegister.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 80, 100, 40);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmRegister.getContentPane().add(lblEmail);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setBounds(20, 130, 100, 40);
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmRegister.getContentPane().add(lblPass);
		
		tbxFN = new JTextField();
		tbxFN.setBounds(140, 31, 176, 40);
		tbxFN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tbxFN.setForeground(Color.GRAY);
		tbxFN.setText("First name");
		tbxFN.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {	
				if(tbxFN.getText().equals("First name")) {
					tbxFN.setText("");
				}
				tbxFN.setForeground(Color.BLACK);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		frmRegister.getContentPane().add(tbxFN);
		tbxFN.setColumns(10);
		
		tbxLN = new JTextField();
		tbxLN.setBounds(362, 31, 172, 40);
		tbxLN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tbxLN.setForeground(Color.GRAY);
		tbxLN.setText("Last name");
		tbxLN.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(tbxLN.getText().equals("Last name")) {
					tbxLN.setText("");
				}
				tbxLN.setForeground(Color.BLACK);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		tbxLN.setColumns(10);
		frmRegister.getContentPane().add(tbxLN);
		
		tbxEmail = new JTextField();
		tbxEmail.setBounds(140, 80, 394, 40);
		tbxEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tbxEmail.setColumns(10);
		frmRegister.getContentPane().add(tbxEmail);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(237, 202, 172, 40);
		btnRegister.setAction(action);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmRegister.getContentPane().add(btnRegister);
		
		JLabel lblAlert = new JLabel("8 characters min, number, symbols, upper, lower case inclued");
		lblAlert.setBounds(140, 185, 391, 13);
		frmRegister.getContentPane().add(lblAlert);
		
		tbxPass = new JTextField();
		tbxPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tbxPass.setColumns(10);
		tbxPass.setBounds(140, 130, 394, 40);
		frmRegister.getContentPane().add(tbxPass);
	}
	
	//When click register
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Register");
			putValue(SHORT_DESCRIPTION, "Register now");
		}
		public void actionPerformed(ActionEvent e) {
			if(CheckPassword(tbxPass.getText())) {
				String info = tbxFN.getText() + " " + tbxLN.getText() + " " + tbxEmail.getText() + " " + tbxPass.getText();
				String content = "";
				try {
					File file = new File("D:\\register.ini");
					if(! file.isFile()) { file.createNewFile();}
					else {
						InputStream input = new FileInputStream(file);
						byte[] data = input.readAllBytes();
						content = new String(data);
						content +="\n";
						input.close();
					}
					content += info;
					OutputStream output = new FileOutputStream(file);
					output.write(content.getBytes());
					output.close();
					
					tbxFN.setText("");
					tbxLN.setText("");
					tbxEmail.setText("");
					tbxPass.setText("");
				}
				catch(Exception err) { err.getStackTrace();}
			}
			else { JOptionPane.showMessageDialog(null, "Mat khau chua dung yeu cau"); tbxPass.setText("Nhap lai mat khau");}
		}
	}
	
	//Check the password
	public Boolean CheckPassword(String pass) {
		if(pass.length() < 8) { return false;}
		else {
			int[] check = {0, 0, 0};
			for(String i : pass.split("")) {
				if("abcdefghijklmnopqrstuvwxyz".contains(i)) {check[0] +=1;}
				else if("1234567890".contains(i)) { check[1] +=1;}
				else {check[2] +=1;}
			}
			if (check[0] !=0 && check[1] !=0 & check[2] !=0) { return true;}
		}
		return false;
	}
}
