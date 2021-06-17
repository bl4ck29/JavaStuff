import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class dongHo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dongHo window = new dongHo();
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
	public dongHo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lb = new JLabel("Đồng Hồ");
		lb.setBounds(150, 20, 150, 45);
		lb.setForeground(Color.RED);
		lb.setFont(new Font("Time New Roman" , Font.BOLD, 35));
		frame.getContentPane().add(lb);
		
		JLabel lbt = new JLabel();
		lbt.setBounds(150, 99, 300, 45);
		lbt.setFont(new Font("Time New Roman", Font.BOLD, 35));
		frame.getContentPane().add(lbt);
		
		Timer time = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				String t1 = sdf.format(cal.getTime());
				lbt.setText(t1);
			}
		});
		time.start();
		
	}
}
