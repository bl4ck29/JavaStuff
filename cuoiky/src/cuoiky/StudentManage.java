package cuoiky;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.*;

public class StudentManage {
	private JFrame frame;
	private JTable table;
	private JScrollPane scroll ;
	private File file = new File("register.ini");
	private String[] cols = {"ID", "Name", "Date of birth", "Contact info"}; 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManage window = new StudentManage(new String[0][0]);
					window.frame.setVisible(true);
				}
				catch (Exception e) {e.printStackTrace();}
			}
		});
	}
	
	public StudentManage(String[][] data) {
		try {if(file.isFile()) {file.createNewFile();}}
		catch(Exception err) {err.getStackTrace();}
		initialize(data);
	}
	private void initialize(String[][] lstStudent) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable(lstStudent, cols);
		scroll = new JScrollPane(table);
		scroll.setBounds(10, 10, 800, 300);
		frame.getContentPane().add(scroll);
		
		JLabel lblID = new JLabel("Student ID:");
		lblID.setBounds(200, 350, 100, 20);
		frame.getContentPane().add(lblID);
		
		JLabel lblName = new JLabel("Student name:");
		lblName.setBounds(200, 380, 100, 20);
		frame.getContentPane().add(lblName);
		
		JLabel lblDOB = new JLabel("Date of birth:");
		lblDOB.setBounds(200, 410, 100, 20);
		frame.getContentPane().add(lblDOB);
		
		JLabel lblInfo = new JLabel("Contact info:");
		lblInfo.setBounds(200, 440, 100, 20);
		frame.getContentPane().add(lblInfo);
		
		JTextField tbxID = new JTextField();
		tbxID.setBounds(350, 350, 150, 20);
		frame.getContentPane().add(tbxID);
		tbxID.setColumns(10);
		
		JTextField tbxName = new JTextField();
		tbxName.setBounds(350, 380, 150, 20);
		frame.getContentPane().add(tbxName);
		tbxName.setColumns(10);
		
		JTextField tbxDOB = new JTextField();
		tbxDOB.setBounds(350, 410, 150, 20);
		tbxDOB.setText("dd/mm/yyyy");
		frame.getContentPane().add(tbxDOB);
		tbxDOB.setColumns(10);
		
		JTextField tbxInfo = new JTextField();
		tbxInfo.setBounds(350, 440, 150, 20);
		frame.getContentPane().add(tbxInfo);
		tbxInfo.setColumns(10);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(850, 10, 100, 30);
		frame.getContentPane().add(btnLoad);
		
		JButton btnAdd = new JButton("Add new");
		btnAdd.setBounds(850, 50, 100, 30);
		frame.getContentPane().add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(850, 90, 100, 30);
		frame.getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(850, 130, 100, 30);
		frame.getContentPane().add(btnDelete);
		
		JButton btnBack = new JButton("|<");
		btnBack.setBounds(700, 320, 50, 30);
		frame.getContentPane().add(btnBack);
		
		JButton btnNext = new JButton(">|");
		btnNext.setBounds(760, 320, 50, 30);
		frame.getContentPane().add(btnNext);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(300, 470, 100, 30);
		frame.getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(410, 470, 100, 30);
		frame.getContentPane().add(btnCancel);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(850, 500, 100, 30);
		frame.getContentPane().add(btnExit);
		
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Button load
				if(arg0.getSource() == btnLoad) {
					ReloadForm();
				}
				//Button add
				if(arg0.getSource() == btnAdd) {
					String id = tbxID.getText();
					String name = tbxName.getText();
					String dob = CheckDate(tbxDOB.getText());
					String info = tbxInfo.getText();
					if(id.isEmpty() || name.isEmpty() || dob.isEmpty() || info.isEmpty()){
						JOptionPane.showMessageDialog(null, "Please dont left any field empty");
					}
					else {
						String str = id+","+name+","+dob+","+info+"\n";
						Boolean  res = Write(str);
						if (res) {
							JOptionPane.showMessageDialog(null, "Successfully");
							ReloadForm();
						}
						else {JOptionPane.showMessageDialog(null, "Something went wrong");}
					}
				}
				//Button edit
				if(arg0.getSource() == btnEdit) {
					if(table.getSelectedRowCount() == 1) {
						int row_pos = table.getSelectedRow();
						tbxID.setText(table.getModel().getValueAt(row_pos, 0).toString());
						tbxName.setText(table.getModel().getValueAt(row_pos, 1).toString());
						tbxDOB.setText(table.getModel().getValueAt(row_pos, 2).toString());
						tbxInfo.setText(table.getModel().getValueAt(row_pos, 3).toString());
					}
					else { JOptionPane.showMessageDialog(null, "Only select one row");}
				}
				//Button save
				if(arg0.getSource() == btnSave) {
					int row_pos = table.getSelectedRow();
					if(row_pos <0) {JOptionPane.showMessageDialog(null, "Please select one row");}
					if(tbxID.getText().isEmpty() || tbxName.getText().isEmpty() || tbxDOB.getText().isEmpty() || tbxInfo.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Please dont left any field empty");
					}
					else {
						String[][] data = LoadStudentList();
						data[row_pos][0] = tbxID.getText();
						data[row_pos][1] = tbxName.getText();
						data[row_pos][2] = tbxDOB.getText();
						data[row_pos][3] = tbxInfo.getText();
						Write(data);
						tbxID.setText("");
						tbxName.setText("");
						tbxDOB.setText("");
						tbxInfo.setText("");
						ReloadForm();
					}
				}
				//Button delete
				if(arg0.getSource() == btnDelete) {
					try {
						int row_pos = table.getSelectedRow();
						if (row_pos > table.getModel().getRowCount() || row_pos <0) {JOptionPane.showMessageDialog(null, "Please select in the table");}
						else {
							String id = table.getModel().getValueAt(row_pos, 0).toString();
							String name = table.getModel().getValueAt(row_pos, 1).toString();
							String dob = table.getModel().getValueAt(row_pos, 2).toString();
							String info = table.getModel().getValueAt(row_pos, 3).toString();
							String str = id+","+name+","+dob+","+info+"\n";
							InputStream inp = new FileInputStream(file);
							String data = new String(inp.readAllBytes());
							data = data.replaceAll(str, "");
							inp.close();
							OutputStream out = new FileOutputStream(file);
							out.write(data.getBytes());
							out.close();
							JOptionPane.showMessageDialog(null, "Successfully");
							ReloadForm();
						}
					}
					catch(Exception err) {err.getStackTrace();}
				}
				//Button back
				if(arg0.getSource() == btnBack) {
					int row_pos = table.getSelectedRow();
					if(row_pos == -1) { row_pos = table.getRowCount();}
					if(row_pos > 0) { row_pos -= 1;}
					table.setRowSelectionInterval(row_pos, row_pos);
					
					tbxID.setText(table.getModel().getValueAt(row_pos, 0).toString());
					tbxName.setText(table.getModel().getValueAt(row_pos, 1).toString());
					tbxDOB.setText(table.getModel().getValueAt(row_pos, 2).toString());
					tbxInfo.setText(table.getModel().getValueAt(row_pos, 3).toString());
				}
				//Button next
				if(arg0.getSource() == btnNext) {
					int row_pos = table.getSelectedRow();
					if(row_pos < table.getRowCount()-1) { row_pos += 1;}
					table.setRowSelectionInterval(row_pos, row_pos);
					
					tbxID.setText(table.getModel().getValueAt(row_pos, 0).toString());
					tbxName.setText(table.getModel().getValueAt(row_pos, 1).toString());
					tbxDOB.setText(table.getModel().getValueAt(row_pos, 2).toString());
					tbxInfo.setText(table.getModel().getValueAt(row_pos, 3).toString());
				}
				// Button exit
				if(arg0.getSource() == btnExit) {
					int res = JOptionPane.showConfirmDialog(null, "Close the work zone???", "Alert", 0);
					if(res == JOptionPane.OK_OPTION) {System.exit(0);}
				}
				//Button cancel
				if(arg0.getSource() == btnCancel) {
					tbxID.setText("");
					tbxName.setText("");
					tbxDOB.setText("");
					tbxInfo.setText("");
				}
			}
		};
		
		btnLoad.addActionListener(action);
		btnAdd.addActionListener(action);
		btnEdit.addActionListener(action);
		btnDelete.addActionListener(action);
		btnBack.addActionListener(action);
		btnNext.addActionListener(action);
		btnSave.addActionListener(action);
		btnExit.addActionListener(action);
		btnCancel.addActionListener(action);
		tbxDOB.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {tbxDOB.setText("");}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}	
		});
	}
	// Load list of student from file register.ini
	public String[][] LoadStudentList() {
		try {
			InputStream inp = new FileInputStream(file);
			String[] data = new String(inp.readAllBytes()).split("\n");
			String[][] result = new String[data.length][4];
			for (int row=0; row<data.length; row++) {
				String[] info = data[row].split(",");
				for (int col=0; col<info.length; col++) {
					result[row][col] = info[col];
				}
			}
			inp.close();
			return result;
		}
		catch(Exception err) {err.getStackTrace();}
		return new String[0][0];
	}
	// Write one student's profile to file register.ini
	public Boolean Write(String str) {
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(str);
			bw.close();
			return true;
		}
		catch(Exception err) {err.getStackTrace();}
		return false;
	}
	// Write list of student to file register.ini
	public void Write(String[][] data) {
		try {
			OutputStream out = new FileOutputStream(file);
			for(int row=0;row<data.length; row++) {
				String info = "";
				for(int col=0; col<data[row].length; col++) {
					if(col==data[row].length-1) {info += data[row][col] + "\n";}
					else {info += data[row][col] + ",";}
				}
				out.write(info.getBytes());
			}
			out.close();
		}
		catch(Exception err) {err.getStackTrace();}
	}
	// Check if the date is in form
	public String CheckDate(String date) {
		if(date.matches("../../....")) {
			return date;
		}
		return "00/00/0000";
	}
	// Reaload form
	public void ReloadForm() {
		StudentManage new_frame = new StudentManage(LoadStudentList());
		frame.dispose();
		new_frame.frame.setVisible(true);
	}
}