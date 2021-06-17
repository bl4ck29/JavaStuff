package tuan8_baitap;

import java.awt.EventQueue;
import java.io.*;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class ManageStudent extends JFrame{
	private JTable tblList;
	private JTextField tbxID;
	private JTextField tbxName;
	private JTextField tbxDOB;
	private JTextField tbxContactInfo;
	private File file = new File("register.ini");
	private String[] cols = {"Student ID", "Student name", "Date of birth" ,"Contact info"};

	public static void main(String[] args) {
		ManageStudent app = new ManageStudent();
		app.setVisible(true);
	}

	public ManageStudent() {
		setSize(800, 600);
        setTitle("Student Management");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(315, 0, 200, 40);
		add(lblNewLabel);
		
		JLabel lblID = new JLabel("Student ID");
		lblID.setBounds(225, 341, 60, 20);
		add(lblID);
		
		JLabel lblName = new JLabel("Student Name");
		lblName.setBounds(225, 370, 100, 20);
		add(lblName);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth");
		lblDateOfBirth.setBounds(225, 398, 100, 20);
		add(lblDateOfBirth);
		
		JLabel lblContactInfo = new JLabel("Contact info");
		lblContactInfo.setBounds(225, 427, 100, 20);
		add(lblContactInfo);
		
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLoad.setBounds(610, 55, 100, 30);
		add(btnLoad);
		
		JButton btnBack = new JButton("|<");
		btnBack.setBounds(398, 311, 85, 21);
		add(btnBack);
		
		JButton btnNext = new JButton(">|");
		btnNext.setBounds(493, 311, 85, 21);
		add(btnNext);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(398, 460, 85, 21);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(493, 460, 85, 21);
		add(btnCancel);
		
		tbxID = new JTextField();
		tbxID.setBounds(331, 338, 199, 20);
		add(tbxID);
		tbxID.setColumns(10);
		
		tbxName = new JTextField();
		tbxName.setColumns(10);
		tbxName.setBounds(331, 367, 199, 20);
		add(tbxName);
		
		tbxDOB = new JTextField();
		tbxDOB.setColumns(10);
		tbxDOB.setBounds(331, 395, 199, 20);
		add(tbxDOB);
		
		tbxContactInfo = new JTextField();
		tbxContactInfo.setColumns(10);
		tbxContactInfo.setBounds(331, 424, 199, 20);
		add(tbxContactInfo);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdd.setBounds(610, 120, 100, 30);
		add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEdit.setBounds(610, 194, 100, 30);
		add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelete.setBounds(610, 271, 100, 30);
		add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExit.setBounds(610, 486, 100, 30);
		add(btnExit);
		
		tblList = new JTable(LoadStudentList(), cols);
		tblList.setBounds(10, 53, 568, 248);
		JScrollPane scroll = new JScrollPane(tblList);
		scroll.setBounds(10, 50, 550, 200);
		add(scroll);
		
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				//Load from file
				if (act.getSource() == btnLoad){
                    remove(scroll);
                    tblList = new JTable(LoadStudentList(), cols);
                    JScrollPane scroll = new JScrollPane(tblList);
                    scroll.setBounds(10, 50, 550, 200);
                    add(scroll);
                }
				
				//Add student to file
				if(act.getSource() == btnAdd) {
					if(tbxID.getText().isBlank() || tbxName.getText().isBlank() || tbxDOB.getText().isBlank() || tbxContactInfo.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Please do not leave any fields blank");
					}
					else {
						String data = "";
						String[] content = ReadList();
						for(String item : content) { data += item + "\n";}
						String info = tbxID.getText().strip() + "," + tbxName.getText().strip() + "," + tbxDOB.getText().strip() + "," + tbxContactInfo.getText().strip();
						data += info;
						WriteContent(data);
						JOptionPane.showMessageDialog(null, "Successfully");
		
					}
				}
				
				//Edit student profile
				if(act.getSource() == btnEdit) {
					if(tblList.getSelectedRowCount() == 1) {
						int row_pos = tblList.getSelectedRow();
						tbxID.setText(tblList.getModel().getValueAt(row_pos, 0).toString());
						tbxName.setText(tblList.getModel().getValueAt(row_pos, 1).toString());
						tbxDOB.setText(tblList.getModel().getValueAt(row_pos, 2).toString());
						tbxContactInfo.setText(tblList.getModel().getValueAt(row_pos, 3).toString());
					}
					else { JOptionPane.showMessageDialog(null, "Only select one row");}
				}
				
				//Delete student from list
				if(act.getSource() == btnDelete) {
					int row_pos = tblList.getSelectedRow();
					String[] lst = ReadList();
					lst[row_pos] = "";
					WriteContent(lst);
	
				}
				
				//Exit
				if(act.getSource() == btnExit) {
					int respone = JOptionPane.showConfirmDialog(null, "Do you want to leave?", "Alert", 1);
					if(respone == JOptionPane.OK_OPTION){ System.exit(0);}
				}
				
				//Cancel the edition
				if(act.getSource() == btnCancel) {
					tbxID.setText("");
					tbxName.setText("");
					tbxDOB.setText("");
					tbxContactInfo.setText("");
				}
				
				//Button next
				if(act.getSource() == btnNext) {
					int row_pos = tblList.getSelectedRow();
					if(row_pos < tblList.getRowCount()-1) { row_pos += 1;}
					tblList.setRowSelectionInterval(row_pos, row_pos);
					
					tbxID.setText(tblList.getModel().getValueAt(row_pos, 0).toString());
					tbxName.setText(tblList.getModel().getValueAt(row_pos, 1).toString());
					tbxDOB.setText(tblList.getModel().getValueAt(row_pos, 2).toString());
					tbxContactInfo.setText(tblList.getModel().getValueAt(row_pos, 3).toString());
				}
				
				//Button back
				if(act.getSource() == btnBack) {
					int row_pos = tblList.getSelectedRow();
					if(row_pos == -1) { row_pos = tblList.getRowCount();}
					if(row_pos > 0) { row_pos -= 1;}
					tblList.setRowSelectionInterval(row_pos, row_pos);
					
					tbxID.setText(tblList.getModel().getValueAt(row_pos, 0).toString());
					tbxName.setText(tblList.getModel().getValueAt(row_pos, 1).toString());
					tbxDOB.setText(tblList.getModel().getValueAt(row_pos, 2).toString());
					tbxContactInfo.setText(tblList.getModel().getValueAt(row_pos, 3).toString());
				}
				
				//Button save
				if(act.getSource() == btnSave) {
					int row_pos = tblList.getSelectedRow();
					String[] lst = ReadList();
					String profile = tbxID.getText() +","+ tbxName.getText() +","+ tbxDOB.getText() +","+ tbxContactInfo.getText();
					lst[row_pos] = profile;
					WriteContent(lst);
	
				}
			}
		};
		
		btnLoad.addActionListener(action);
		btnAdd.addActionListener(action);
		btnEdit.addActionListener(action);
		btnDelete.addActionListener(action);
		btnExit.addActionListener(action);
		btnCancel.addActionListener(action);
		btnNext.addActionListener(action);
		btnBack.addActionListener(action);
		btnSave.addActionListener(action);
	}
	
	//Read list of student from file
	private String[] ReadList() {
		try {
			InputStream inp = new FileInputStream(file);
			byte[] data = inp.readAllBytes();
			String[] content = (new String(data)).split("\n");
			inp.close();
			return content;
		}catch(Exception err) {err.getStackTrace();}
		return null;
	}
	
	//Write the student just addedd to file
	private void WriteContent(String content) {
		try {
			OutputStream out = new FileOutputStream(file);
			out.write(content.getBytes());
			out.close();
		}catch(Exception err) {err.getStackTrace();}
	}
	
	//Write the list of students to file
	private void WriteContent(String[] content) {
		try {
			String data = "";
			for( String std : content) { 
				if (std != "") { data += std + "\n";}
			}
			WriteContent(data);
		}
		catch(Exception e) { e.getStackTrace();}
	}
	
	//Form load
	private String[][] LoadStudentList(){
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File file = new File(chooser.getSelectedFile().getAbsolutePath());
            try{
                InputStream inp = new FileInputStream(file);
                byte[] data = inp.readAllBytes();
                inp.close();
                String[] listStudents = (new String(data)).split("\n");
                String[][] tableData = new String[listStudents.length][cols.length];
                for(int row=0; row<listStudents.length; row++){
                    String[] info = listStudents[row].split(",");
                    for(int col=0; col<info.length; col++){
                        tableData[row][col] = info[col];
                    }
                }
                return tableData;
            }
            catch(IOException err_FileNotFoundException) {
                err_FileNotFoundException.getStackTrace();
            }
        }
        return new String[0][0];       
    }
}
