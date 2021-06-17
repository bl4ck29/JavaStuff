package tuan8_Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;

import javax.swing.Action;

public class SignIn {

	private JFrame frame;
	private JTextField tbxEmail;
	private JTextField tbxPass;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn();
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
	public SignIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 555, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(25, 33, 100, 40);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPass.setBounds(25, 109, 100, 40);
		frame.getContentPane().add(lblPass);
		
		tbxEmail = new JTextField();
		tbxEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tbxEmail.setBounds(163, 34, 300, 40);
		frame.getContentPane().add(tbxEmail);
		tbxEmail.setColumns(10);
		
		tbxPass = new JTextField();
		tbxPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tbxPass.setColumns(10);
		tbxPass.setBounds(163, 109, 300, 40);
		frame.getContentPane().add(tbxPass);
		
		JButton BtnSignIn = new JButton("Sign in");
		BtnSignIn.setAction(action);
		BtnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BtnSignIn.setBounds(149, 196, 250, 40);
		frame.getContentPane().add(BtnSignIn);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Sign in");
			putValue(SHORT_DESCRIPTION, "Sign in with email and password");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				File file = new File("D:\\register.ini");
				if(file.isFile()) {
					InputStream input = new FileInputStream(file);
					byte[] data = input.readAllBytes();
					String content = new String(data);
					String[] arr = content.split("\n");
					for (String acc: arr) {
						if (acc.contains(tbxEmail.getText()) && acc.contains(tbxPass.getText())) {
							JOptionPane.showMessageDialog(null, "Dang nhap thanh cong");
							frame.dispose();
							break;
						}
						else {
							JOptionPane.showMessageDialog(null, "Tai khoan khong dung");
							frame.dispose();
							break;
						}
					}
					input.close();
				}
				else {
					Register rg = new Register();
					rg.main(new String[] {"a", "b"});
				}
			}
			catch(Exception err) {
				err.getStackTrace();
			}
		}
	}
}
