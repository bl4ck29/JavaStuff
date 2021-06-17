package ontap;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import javax.swing.*;

public class ManageStudent extends JFrame implements MouseListener{
	protected JTextField tbxID;
	protected JTextField tbxName;
	protected JTextField tbxDOB;
	protected JTextField tbxContact;
	protected JTable lstStudents;
	protected JButton btnLoad;
	protected JButton btnAdd;
	protected JButton btnEdit;
	protected JButton btnDelete;
	protected JButton btnSave;
	protected JButton btnCancel;
	protected JButton btnBack;
	protected JButton btnNext;
	protected JButton btnExit;
	
	protected File file = new File("register.ini");
	protected String[] cols = {"MSSV", "Ten", "Ngay sinh", "Dia chi lien lac"};
	
	private final Action btnLoad_Click = new btnLoad_Click();
	private final Action btnAdd_Click = new btnAdd_Click();
	private final Action btnEdit_Click = new btnEdit_Click();
	private final Action btnDelete_Click = new btnDelete_Click();
	private final Action btnBack_Click = new btnBack_Click();
	private final Action btnNext_Click = new btnNext_Click();
	private final Action btnSave_Click = new btnSave_Click();
	private final Action btnCancel_Click = new btnCancel_Click();
	private final Action btnExit_Click = new btnExit_Click();
	
	public static void main(String[] args) {
		ManageStudent obj = new ManageStudent(new String[0][0]);
		obj.setVisible(true);
	}
	public ManageStudent(String[][] lst) {
		// Setup frame
		setTitle("Mange student app");
		setSize(800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		//Frame component
		JLabel lblAppName = new JLabel("MANGE STUDENTS");
		lblAppName.setForeground(Color.BLUE);
		lblAppName.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAppName.setBounds(275, 10, 250, 40);
		
		JLabel lblID = new JLabel("MSSV:");
		lblID.setBounds(10, 270, 70, 30);
		
		tbxID = new JTextField();
		tbxID.setBounds(150, 270, 150, 30);
		
		JLabel lblName = new JLabel("Ho va ten:");
		lblName.setBounds(10, 310, 70, 30);
		
		tbxName = new JTextField();
		tbxName.setBounds(150, 310, 150, 30);
		
		JLabel lblDOB = new JLabel("Ngay sinh:");
		lblDOB.setBounds(10, 350, 70, 30);
		
		tbxDOB = new JTextField();
		tbxDOB.setBounds(150, 350, 150, 30);
		tbxDOB.setText("dd/mm/yyyy");
		// When click, clear the text field
		tbxDOB.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseClicked(MouseEvent arg0) {tbxDOB.setText("");}
		}); 
		
		JLabel lblContact = new JLabel("Thong tin lien he:");
		lblContact.setBounds(10, 390, 100, 30);
		
		tbxContact = new JTextField();
		tbxContact.setBounds(150, 390, 150, 30);
		
		lstStudents = new JTable(lst, cols);
		JScrollPane scroll = new JScrollPane(lstStudents);
		scroll.setBounds(10, 60, 600, 200);
		lstStudents.addMouseListener(this);
		
		btnLoad = new JButton();
		btnLoad.setBounds(620, 60, 100, 30);
		btnLoad.setAction(btnLoad_Click);
		
		btnAdd = new JButton();
		btnAdd.setBounds(620, 100, 100, 30);
		btnAdd.setAction(btnAdd_Click);
		
		btnEdit = new JButton();
		btnEdit.setBounds(620, 140, 100, 30);
		btnEdit.setAction(btnEdit_Click);
		
		btnDelete = new JButton();
		btnDelete.setBounds(620, 180, 100, 30);
		btnDelete.setAction(btnDelete_Click);
		
		btnExit = new JButton();
		btnExit.setBounds(620, 390, 100, 30);
		btnExit.setAction(btnExit_Click);
		
		btnBack = new JButton();
		btnBack.setBounds(400, 270, 100, 30);
		btnBack.setAction(btnBack_Click);
		
		btnNext = new JButton();
		btnNext.setBounds(510, 270, 100, 30);
		btnNext.setAction(btnNext_Click);
		
		btnSave = new JButton();
		btnSave.setBounds(400, 310, 100, 30);
		btnSave.setAction(btnSave_Click);
		
		btnCancel = new JButton();
		btnCancel.setBounds(510, 310, 100, 30);
		btnCancel.setAction(btnCancel_Click);
		
		// Add component to the frame
		getContentPane().add(lblAppName);
		getContentPane().add(lblID);
		getContentPane().add(tbxID);
		getContentPane().add(lblName);
		getContentPane().add(tbxName);
		getContentPane().add(lblDOB);
		getContentPane().add(tbxDOB);
		getContentPane().add(lblContact);
		getContentPane().add(tbxContact);
		getContentPane().add(btnLoad);
		getContentPane().add(btnAdd);
		getContentPane().add(btnEdit);
		getContentPane().add(btnDelete);
		getContentPane().add(btnExit);
		getContentPane().add(btnSave);
		getContentPane().add(btnCancel);
		getContentPane().add(btnBack);
		getContentPane().add(btnNext);
		
		getContentPane().add(scroll);
	}
	
	//Load student list from file
	private String[][] LoadStudentList() {
		try {
			InputStream inp = new FileInputStream(file);
			byte[] data = inp.readAllBytes();
			inp.close();
			String[] content = new String(data).split("\n");
			String[][] lst =  new String[content.length][cols.length];
			for(int row=0; row<content.length; row++) {
				String[] info = content[row].split(",");
				for(int col=0; col<cols.length; col++) {
					lst[row][col] = info[col];
				}
			}
			return lst;
		}
		catch(Exception err) {return new String[0][0];}
	}
	
	//Check the format of date
	protected String CheckDate(String date) {
		if(date.matches("../../....")) {return date;}
		return "00/00/0000";
	}
	
	// Button Load 
	private class btnLoad_Click extends AbstractAction{
		public btnLoad_Click() {putValue(NAME, "Load");}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ManageStudent obj = new ManageStudent(LoadStudentList());
			dispose();
			obj.setVisible(true);
		}
	}
	
	//Button Add
	private class btnAdd_Click extends AbstractAction{
		public btnAdd_Click() {putValue(NAME, "Add");}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String id = tbxID.getText();
			String name = tbxName.getText();
			String dob=  CheckDate(tbxDOB.getText());
			String contact = tbxContact.getText();
			if(!id.isEmpty() || !name.isEmpty() || !dob.isEmpty() || !contact.isEmpty()) {
				String info = id + "," + name + "," + dob + "," + contact + "\n";
				try {
					FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(info);
					bw.close();
				}
				catch(Exception err) {JOptionPane.showMessageDialog(null, "Something went wrong");}
			}
			else {JOptionPane.showMessageDialog(null, "Please dont leave any field empty");}
		}
	}
	
	//Button Edit
	private class btnEdit_Click extends AbstractAction{
		public btnEdit_Click() {putValue(NAME, "Edit");}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int row_pos = lstStudents.getSelectedRow();
			if (row_pos >= 0 && lstStudents.getSelectedRowCount() == 1) {
				tbxID.setText(lstStudents.getModel().getValueAt(row_pos, 0).toString());
				tbxName.setText(lstStudents.getModel().getValueAt(row_pos, 1).toString());
				tbxDOB.setText(lstStudents.getModel().getValueAt(row_pos, 2).toString());
				tbxContact.setText(lstStudents.getModel().getValueAt(row_pos, 3).toString());
			}
			else {JOptionPane.showMessageDialog(null, "Please select one row");}
		}
	}
	
	
	//Button Delete
	private class btnDelete_Click extends AbstractAction{
		public btnDelete_Click() {putValue(NAME, "Delete");}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				InputStream inp = new FileInputStream(file);
				String content = new String(inp.readAllBytes());
				inp.close();
				
				int row_pos = lstStudents.getSelectedRow();
				if (row_pos >=0 && lstStudents.getSelectedRowCount() == 1) {
					String id = lstStudents.getModel().getValueAt(row_pos, 0).toString();
					String name = lstStudents.getModel().getValueAt(row_pos, 1).toString();
					String dob=  lstStudents.getModel().getValueAt(row_pos, 2).toString();
					String contact = lstStudents.getModel().getValueAt(row_pos, 3).toString();
					String info = id + "," + name + "," + dob + "," + contact + "\n";
					content = content.replace(info, "");
					
					OutputStream out = new FileOutputStream(file);
					out.write(content.getBytes());
					out.close();
					JOptionPane.showMessageDialog(null, "Successfully");
				}
				else {JOptionPane.showMessageDialog(null, "Something went wrong");}
			}
			catch(Exception err) {err.getStackTrace();}
		}
	}
	
	
	//Button Back
	private class btnBack_Click extends AbstractAction{
		public btnBack_Click() {putValue(NAME, "|<");}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int row_pos = lstStudents.getSelectedRow();
			if(lstStudents.getSelectedRowCount() != 1) {lstStudents.setRowSelectionInterval(0, 0);}
			else if(row_pos < 0) { JOptionPane.showMessageDialog(null, "Please select one row");}
			else {
				if(row_pos >0) {
					row_pos -= 1;
					lstStudents.setRowSelectionInterval(row_pos, row_pos);
				}
			}
		}
	}
	
	
	//Button Next
	private class btnNext_Click extends AbstractAction{
		public btnNext_Click() {putValue(NAME, ">|");}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int row_pos = lstStudents.getSelectedRow();
			if(lstStudents.getSelectedRowCount() != 1) {lstStudents.setRowSelectionInterval(0, 0);}
			else if(row_pos < 0) { JOptionPane.showMessageDialog(null, "Please select one row");}
			else {
				if(row_pos < lstStudents.getRowCount() - 1) {
					row_pos += 1;
					lstStudents.setRowSelectionInterval(row_pos, row_pos);
				}
			}
		}
	}
	
	
	//Button Save
	private class btnSave_Click extends AbstractAction{
		public btnSave_Click() {putValue(NAME, "Save");}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int row_pos = lstStudents.getSelectedRow();
			if(row_pos > 0) {
				try {					
					String[][] lst = LoadStudentList();
					
					String id = tbxID.getText();
					String name = tbxName.getText();
					String dob=  CheckDate(tbxDOB.getText());
					String contact = tbxContact.getText();
					if(!id.isEmpty() || !name.isEmpty() || !dob.isEmpty() || !contact.isEmpty()) {
						lst[row_pos][0] = id;
						lst[row_pos][1] = name;
						lst[row_pos][2] = dob;
						lst[row_pos][3] = contact;
						
						OutputStream out = new FileOutputStream(file);
						for(String[] text : lst) {
							String info = text[0] + "," + text[1] + "," + text[2] + "," + text[3] + "\n";
							out.write(info.getBytes());
						}
						out.close();
					}
				}
				catch(Exception err) {JOptionPane.showMessageDialog(null, "Something went wrong");}
			}
		}
	}
	
	
	//Button Cancel
	private class btnCancel_Click extends AbstractAction{
		public btnCancel_Click() {putValue(NAME, "Cancel");}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			tbxID.setText("");
			tbxName.setText("");
			tbxDOB.setText("dd/mm/yyyy");
			tbxContact.setText("");
		}
	}
	
	//Button Exit
	private class btnExit_Click extends AbstractAction{
		public btnExit_Click() {putValue(NAME, "Exit");}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int res = JOptionPane.showConfirmDialog(null, "Do you really want to leave?", "Alert", 1);
			if(res == JOptionPane.OK_OPTION) {System.exit(0);}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int pos = lstStudents.getSelectedRow();
		if(lstStudents.getSelectedRowCount() > 1) {JOptionPane.showMessageDialog(null, "Please selecte only one row");}
		else if(pos>=0 && pos<lstStudents.getRowCount()) {
			tbxID.setText(lstStudents.getModel().getValueAt(pos, 0).toString());
			tbxName.setText(lstStudents.getModel().getValueAt(pos, 1).toString());
			tbxDOB.setText(lstStudents.getModel().getValueAt(pos, 2).toString());
			tbxContact.setText(lstStudents.getModel().getValueAt(pos, 3).toString());
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
