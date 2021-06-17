import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.event.*;

public class SlideShow extends JFrame{

	private JPanel contentPane;
	private JFrame frame;
	private JButton btLoad;
	private JLabel lbTitle, lbImage;
	private JTable table;
	private JScrollPane scroll;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SlideShow frame = new SlideShow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SlideShow() {
		setTitle("SlideShow");
		setBounds(100, 100, 800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Object[][] data = {};
		String[] col = {"Tên File Ảnh"};
		table = new JTable(data,col);	
		table.setSelectionBackground(Color.GREEN);
		scroll = new JScrollPane(table);
		scroll.setBounds(10, 96, 770, 180);
		getContentPane().add(scroll);
		
		model = new DefaultTableModel();
		model.setDataVector(data, col);
		table.setModel(model);
		
		btLoad = new JButton("Chọn tệp chứa ảnh");
		btLoad.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
				docFile();
				}
		});
		btLoad.setBounds(285, 50, 220, 40);
		btLoad.setForeground(Color.RED);
		btLoad.setFont(new Font("Time New Roman", Font.BOLD, 18));
		contentPane.add(btLoad);
		
		lbTitle = new JLabel("Trình đọc ảnh");
		lbTitle.setBounds(295, 0, 250, 40);
		lbTitle.setForeground(Color.BLUE);
		lbTitle.setFont(new Font("Time New Roman", Font.BOLD, 30));
		contentPane.add(lbTitle);
		
		lbImage = new JLabel("Hình ảnh");
		lbImage.setBounds(10, 286, 770, 377);
		lbImage.setFont(new Font("Time New Roman", Font.BOLD, 18));
		lbImage.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbImage);
	
		table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoadImage(evt);
            }
        });
		
	}

	public void docFile() {
		JFileChooser file = new JFileChooser();
		file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = file.showOpenDialog(null);
		if(result == JFileChooser.APPROVE_OPTION) {
			model.setRowCount(0);
			String duongdan = file.getSelectedFile().getAbsolutePath();
			File thumuc = new File(duongdan);
		      Object[] tentep = thumuc.listFiles();
		      for(int i=0; i<tentep.length; i++) {
		    	  model.addRow(new String [] {tentep[i].toString()});
		      }

		}
	}
	private void LoadImage (java.awt.event.MouseEvent evt) {
		int row = table.getSelectedRow();
		String filename = table.getModel().getValueAt(row, 0).toString();
		ImageIcon imgicon = new ImageIcon(
				new ImageIcon(filename).getImage().getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_SMOOTH));
		lbImage.setIcon(imgicon);
}
}
