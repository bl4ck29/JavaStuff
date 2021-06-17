import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class RegisterForm extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JTextField phone;
	private JTextField note;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm frame = new RegisterForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public RegisterForm() throws ParseException {
		setTitle("Register Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLabel title = new JLabel("Register Form");
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		title.setBounds(311, 10, 142, 38);
		layeredPane.add(title);
		
		JLabel lblNewLabel = new JLabel("Full name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(21, 72, 98, 43);
		layeredPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		name.setBounds(128, 72, 241, 38);
		layeredPane.add(name);
		name.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail.setBounds(21, 195, 98, 43);
		layeredPane.add(lblEmail);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(395, 72, 98, 43);
		layeredPane.add(lblNewLabel_1_1);
		
		JLabel lblnote = new JLabel("Note:");
		lblnote.setForeground(new Color(0, 0, 0));
		lblnote.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblnote.setBounds(21, 294, 98, 43);
		layeredPane.add(lblnote);
		
		JRadioButton male = new JRadioButton("Male");
		male.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		male.setBounds(193, 146, 98, 21);
		male.setSelected(false);
		layeredPane.add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		female.setBounds(388, 146, 105, 21);
		female.setSelected(false);
		layeredPane.add(female);
		
		email = new JTextField();
		email.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		email.setColumns(10);
		email.setBounds(128, 197, 517, 38);
		layeredPane.add(email);
		
		MaskFormatter number = new MaskFormatter("[VN]08.########");
		phone = new JFormattedTextField(number);
		phone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		phone.setColumns(10);
		phone.setBounds(456, 72, 189, 38);
		layeredPane.add(phone);
		
		note = new JTextField();
		note.setHorizontalAlignment(SwingConstants.LEFT);
		note.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		note.setBounds(128, 257, 517, 145);
		layeredPane.add(note);
		
		male.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(male.isSelected())
					female.setSelected(false);
			}
		});
		
		female.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(female.isSelected())
					male.setSelected(false);
			}
		});
		
		JButton regis = new JButton("Register");
		regis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (name.getText().equalsIgnoreCase(""))
						JOptionPane.showMessageDialog(layeredPane, "Please fill your name!");
					else if (phone.getText().equalsIgnoreCase(""))
						JOptionPane.showMessageDialog(null, "Please fill your phone!");
					else if (email.getText().equalsIgnoreCase(""))
						JOptionPane.showMessageDialog(null, "Please fill your email!");
					else if (male.isSelected() == false && female.isSelected() == false )
						JOptionPane.showMessageDialog(null, "Please choose your gender!");
					else{
						if(male.isSelected())
							JOptionPane.showMessageDialog(null, "Full name: " + name.getText() + "     "
																+ "Phone: " + phone.getText() + "\n"
																+ "Gender: " + male.getText() + "\n"
																+ "Email: " + email.getText() + "\n" 
																+ "Note: " + note.getText());
						else
							JOptionPane.showMessageDialog(null, "Full name: " + name.getText() + "     "
																+ "Phone: " + phone.getText() + "\n"
																+ "Gender: " + female.getText() + "\n"
																+ "Email: " + email.getText() + "\n" 
																+ "Note: " + note.getText());
					}
				
				}
		});
		regis.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		regis.setBounds(324, 412, 110, 31);
		layeredPane.add(regis);
	}
}
