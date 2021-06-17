
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.text.StyledEditorKit.BoldAction;

import java.nio.charset.StandardCharsets;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Students extends JPanel {
boolean test=false;
String filename;

Object[][] data = {
		
};

	

public void paint(Graphics g) {
	// TODO Auto-generated method stub
	this.setLayout(null);
	
	int width = 90;
	int height = 40;
	
	JLabel label1 = new JLabel();
	label1.setText("STUDENT MANAGEMENT");
	label1.setForeground(Color.blue);
	label1.setFont(new Font("Time New Roman", Font.BOLD, 20));
	label1.setBounds(220, 0, 300, 90);
	add(label1);
	//-------------------------------------
	

	String[] cols = {"Student ID"," Student Name", "D.O.B", "Contact Info"};
	JTable myTable = new JTable(data, cols);
	JScrollPane scroll = new JScrollPane(myTable);
	myTable.setSelectionBackground(Color.YELLOW);
	scroll.setBounds(10, 60, 600, 180);
	add(scroll);
	//-------------------------
	
	JButton btLoad = new JButton("Load");
	btLoad.setBounds(615, 60, width, height);
	add(btLoad);
	
	JButton btAdd = new JButton("Add New");
	btAdd.setBounds(615, 105, width, height);
	add(btAdd);
	
	JButton btEdit = new JButton("Edit");
	btEdit.setBounds(615, 150, width, height);
	add(btEdit);
	
	JButton btDel = new JButton("Delete");
	btDel.setBounds(615, 195, width, height);
	add(btDel);
	//-------------------------------------
	
	JLabel label2= new JLabel();
	label2.setText("ADD NEW STUDENT");
	label2.setForeground(Color.red);
	label2.setFont(new Font("Time New Roman", Font.BOLD, 22));
	label2.setBounds(240, 225, 400, 100);
	add(label2);
	
	JButton btFirst = new JButton("|<");
	btFirst.setBounds(500, 243, 50, 25);
	add(btFirst);
	
	JButton btEnd = new JButton(">|");
	btEnd.setBounds(557, 243, 50, 25);
	add(btEnd);
	//--------------------------------------
	
	JLabel ID = new JLabel();
	ID.setText("Student ID");
	ID.setFont(new Font("Time New Roman" , Font.BOLD, 16));
	ID.setBounds(50, 280, 400, 100);
	add(ID);
	
	JTextField txtID = new JTextField();
	txtID.setBounds(210, 310, 300, height);
	add(txtID);
	
	JLabel Name= new JLabel();
	Name.setText("Student Name");
	Name.setFont(new Font("Time New Roman", Font.BOLD, 16));
	Name.setBounds(50, 325, 400, 100);
	add(Name);
	
	JTextField txtName =new JTextField();
	txtName.setBounds(210, 355, 300, height);
	add(txtName);
	
	JLabel DOB = new JLabel();
	DOB.setText("Date Of Birth");
	DOB.setFont(new Font("Time New Roman" , Font.BOLD, 16));
	DOB.setBounds(50, 370, 400, 100);
	add(DOB);
	
	MaskFormatter mask = null;
	try {
		mask = new MaskFormatter("##/##/####");
		mask.setPlaceholderCharacter('_');
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	JFormattedTextField txtDOB = new JFormattedTextField(mask);
	txtDOB.setBounds(210, 400, 300, height);
	add(txtDOB);
	
	JLabel Info= new JLabel();
	Info.setText("Contact Information");
	Info.setFont(new Font("Time New Roman", Font.BOLD, 16));
	Info.setBounds(50, 410, 400, 100);
	add(Info);
	
	JTextField txtInfo =new JTextField();
	txtInfo.setBounds(210, 445, 300, height);
	add(txtInfo);
	//----------------------------------
	
	JButton btSave = new JButton("Save");
	btSave.setBounds(240, 505, width, height);
	add(btSave);
	
	JButton btCancel = new JButton("Cancel");
	btCancel.setBounds(380, 505, width, height);
	add(btCancel);
	
	JButton btExit = new JButton("Exit");
	btExit.setBounds(615, 555, width, height);
	add(btExit);
	
    DefaultTableModel model = new DefaultTableModel();
    model.setDataVector(data, cols);
    myTable.setModel(model);

	
	ActionListener myListener = new ActionListener() {
	

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//LoadData
			if(e.getSource()==btLoad) {
				String content = "";
                JFileChooser file = new JFileChooser();
                var result = file.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    model.setRowCount(0);
                    filename = file.getSelectedFile().getAbsolutePath();
                    try {
                        content = new String(Files.readAllBytes(Paths.get(filename)));
                    } catch (IOException er) {
                        er.printStackTrace();
                    }
                }
                String[] split = content.split(",");
                try {
                    for (int i = 0; i < split.length; i += 4) {
                        model.addRow(new Object[]{split[i], split[i + 1], split[i + 2], split[i + 3]});
                    }
                } catch (Exception ex) {

                }
			}
			//SaveData
			else if(e.getSource() == btSave) {
				if(txtID.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Student ID not be empty");
						test = false;
				}
				else {
					test=true;
				}
				if(txtName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Student Name not be empty");
					test = false;
				}
				else {
					test=true;
				}
				if(txtDOB.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Day Of Birth not be empty");
					test = false;
				}
				else {
					test=true;
				}
				if(txtInfo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Contact Information not be empty");
					test = false;
				}
				else {
					test=true;
				}
				if(test == true) {
					int select = myTable.getSelectedRow();
					if(select >= 0 ){
						model.setValueAt(txtID.getText(), select, 0);
						model.setValueAt(txtName.getText(), select, 1);
						model.setValueAt(txtDOB.getText(), select, 2);
						model.setValueAt(txtInfo.getText(), select, 3);
						txtID.setText("");
						txtName.setText("");
						txtDOB.setText("");
						txtInfo.setText("");
					}
					else {
						model.addRow(new Object[] {
								txtID.getText(), 
								txtName.getText(), 
								txtDOB.getText(), 
								txtInfo.getText()});
						txtID.setText("");
						txtName.setText("");
						txtDOB.setText("");
						txtInfo.setText("");
					}
					}
				}
			//Addnew
			else if(e.getSource()== btAdd) {
				txtID.setText("");
				txtName.setText("");
				txtDOB.setText("");
				txtInfo.setText("");
				
				txtID.setEditable(true);
				txtName.setEditable(true);
				txtDOB.setEditable(true);
				txtInfo.setEditable(true);
				txtID.requestFocusInWindow();
			}
			//EditRow
			else if(e.getSource() ==btEdit) {
				int edit= myTable.getSelectedRow();
				if(edit < 0) {
					JOptionPane.showMessageDialog(null, 
							"Please choose a row to edit!!", "Warning!!",JOptionPane.DEFAULT_OPTION);
				}
				else {
					txtID.setEditable(false);
					txtName.setEditable(true);
					txtDOB.setEditable(true);
					txtInfo.setEditable(true);
					txtID.setText((String) model.getValueAt(edit, 0));
					txtName.setText((String) model.getValueAt(edit, 1));
					txtDOB.setText((String) model.getValueAt(edit, 2));
					txtInfo.setText((String) model.getValueAt(edit, 3));
				}
			}
			//ExitSystem
			else if(e.getSource()==btExit) {
				ArrayList<String> arrlist = new ArrayList<String>();
				int result = JOptionPane.showConfirmDialog(null, "Do you want exit?", 
						"WARNING!", JOptionPane.OK_CANCEL_OPTION);
				if(result == JOptionPane.OK_OPTION) {
					 for (int i = 0; i < model.getRowCount(); i++) {
                         arrlist.add((String) model.getValueAt(i, 0));
                         arrlist.add((String) model.getValueAt(i, 1));
                         arrlist.add((String) model.getValueAt(i, 2));
                         arrlist.add((String) model.getValueAt(i, 3));
                     }
                         File f = new File(filename);
                         f.delete();
                         try {
                             File Write = new File(filename);
                             Write.createNewFile();
                             FileWriter myWriter = new FileWriter(Write);
                             for (int j = 0; j < arrlist.size(); j++) {
                                 myWriter.write(arrlist.get(j) + ",");
                             }
                             myWriter.close();
                         } catch (IOException ex) {
                             System.out.println("An error occurred.");
                             ex.printStackTrace();
                         }
					System.exit(0);
				}
			}
			//Cancel
			else if(e.getSource()==btCancel) {
				txtID.setText("");
				txtName.setText("");
				txtDOB.setText("");
				txtInfo.setText("");
				txtID.requestFocusInWindow();
			}
			//DeleteRow
			else if(e.getSource()==btDel) {
				int del= myTable.getSelectedRow();
				if(del < 0) {
					JOptionPane.showMessageDialog(null, 
							"Please select a line to delete!", "Warning!!!",JOptionPane.DEFAULT_OPTION);
				}
				else {
					int result=JOptionPane.showConfirmDialog(null,
							"Do you want delete this row?", "Warning!!", JOptionPane.OK_CANCEL_OPTION);
					if(result == JOptionPane.OK_OPTION) {
						model.removeRow(del);
					}
				}
			}
			//TopTable
			else if(e.getSource() == btFirst) {
				myTable.setRowSelectionInterval(0, 0);
			}
			//EndTable
			else if(e.getSource() == btEnd) {
				int end = myTable.getRowCount()-1;
				myTable.setRowSelectionInterval(end, end);
			}
		}
	};
	btExit.addActionListener(myListener);
	btLoad.addActionListener(myListener);
	btCancel.addActionListener(myListener);
	btDel.addActionListener(myListener);
	btFirst.addActionListener(myListener);
	btEnd.addActionListener(myListener);
	btAdd.addActionListener(myListener);
	btEdit.addActionListener(myListener);
	btSave.addActionListener(myListener);
	
	super.paint(g);
}
}
