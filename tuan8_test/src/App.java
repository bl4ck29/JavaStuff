import javax.swing.*;

import java.io.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class App extends JFrame{
    private JTable tblList;
	private JTextField tbxID;
	private JTextField tbxName;
	private JTextField tbxDOB;
    private JTextField tbxContactInfo;
    private JScrollPane scroll;
    private File file = new File("D:/JavaPrject/tuan8_baitap/List.txt");
	private String[] cols = {"Student ID", "Student name", "Date of birth" ,"Contact info"};
    public static void main(String[] args) throws Exception {
        App app = new App();
        app.setVisible(true);
    }
    public App(){
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
        
        JButton btnLoad = new JButton("Load");
        btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnLoad.setBounds(610, 53, 100, 30);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdd.setBounds(610, 120, 100, 30);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEdit.setBounds(610, 194, 100, 30);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelete.setBounds(610, 271, 100, 30);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnExit.setBounds(610, 486, 100, 30);
        
        JButton btnBack = new JButton("|<");
		btnBack.setBounds(398, 311, 85, 21);
		
		JButton btnNext = new JButton(">|");
        btnNext.setBounds(493, 311, 85, 21);
        
        JButton btnSave = new JButton("Save");
		btnSave.setBounds(398, 460, 85, 21);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(493, 460, 85, 21);

        Object[][] data = LoadStudentList();
		tblList = new JTable(data, cols);
		scroll = new JScrollPane(tblList);
		scroll.setBounds(0, 53, 600, 200);
        add(scroll);

        
        ActionListener action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent act){
                if (act.getSource() == btnLoad){
                    JFileChooser chooser = new JFileChooser();
                    int result = chooser.showOpenDialog(null);
                    if(result == JFileChooser.APPROVE_OPTION){
                        file = new File(chooser.getSelectedFile().getAbsolutePath());
                        remove(scroll);
                        tblList = new JTable(LoadStudentList(), cols);
                        JScrollPane scroll = new JScrollPane(tblList);
                        scroll.setBounds(0, 53, 600, 200);
                        add(scroll);
                    }
                }

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
                        ReloadWindow();
					}
                }
                
                if(act.getSource() == btnEdit) {
					if(tblList.getSelectedRowCount() == 1) {
						int row_pos = tblList.getSelectedRow();
						tbxID.setText(tblList.getModel().getValueAt(row_pos, 0).toString());
						tbxName.setText(tblList.getModel().getValueAt(row_pos, 1).toString());
						tbxDOB.setText(tblList.getModel().getValueAt(row_pos, 2).toString());
                        tbxContactInfo.setText(tblList.getModel().getValueAt(row_pos, 3).toString());
                        ReloadWindow();
					}
					else { JOptionPane.showMessageDialog(null, "Only select one row");}
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
                    ReloadWindow();
				}

            }
        };
        
        btnLoad.addActionListener(action);
        add(btnLoad);

        btnEdit.addActionListener(action);
        add(btnEdit);

        btnAdd.addActionListener(action);
        add(btnAdd);

        btnDelete.addActionListener(action);
        add(btnDelete);

        btnNext.addActionListener(action);
        add(btnNext);

        btnBack.addActionListener(action);
        add(btnBack);

        btnExit.addActionListener(action);
        add(btnExit);

        btnSave.addActionListener(action);
        add(btnSave);

        btnCancel.addActionListener(action);
        add(btnCancel);
    }

    private Object[][] LoadStudentList(){
        try{
            InputStream inp = new FileInputStream(file);
            byte[] data = inp.readAllBytes();
            inp.close();
            String[] listStudents = (new String(data)).split("\n");
            Object[][] tableData = new Object[listStudents.length][cols.length];
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
        return new Object[0][0];       
    }

    private String[] ReadList(){
        try {
			InputStream inp = new FileInputStream(file);
			byte[] data = inp.readAllBytes();
			String[] content = (new String(data)).split("\n");
			inp.close();
			return content;
		}catch(Exception err) {err.getStackTrace();}
		return null;
    }

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

    private void ReloadWindow(){
        remove(scroll);
        tblList = new JTable(LoadStudentList(), cols);
        scroll = new JScrollPane(tblList);
        scroll.setBounds(0, 53, 600, 200);
        add(scroll);
    }
}
