package tuan8_baitap;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class LoadList extends JFrame {
	public static void main(String[] args) {
		LoadList ll = new LoadList();
		ll.setVisible(true);
	}
	public LoadList() {
		setSize(300, 300);
		setTitle("Load list");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		String[] cols = {"STT", "Ho ten", "Diem"};
		JTable table = new JTable(LoadFile(), cols);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 300, 300);
		getContentPane().add(scroll);
		
	}
	public String[][] LoadFile(){
		try {
			File file = new File("D:\\JavaProject\\tuan8_baitap\\List.txt");
			InputStream inp = new FileInputStream(file);
			byte[] data = inp.readAllBytes();
			String lst = new String(data);
			String[] list = lst.split("\n");
			String[][] table_data = new String[list.length][3];
			for(int i =0; i<list.length; i++) {
				String[] info = list[i].split(",");
				for (int j=0; j< info.length; j++) { table_data[i][j] = info[j];}
			}
			inp.close();
			return table_data;
		}
		catch(Exception e) {e.getStackTrace();}
		return new String[0][0];
	}
}
