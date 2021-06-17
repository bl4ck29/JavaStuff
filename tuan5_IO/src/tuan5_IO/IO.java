package tuan5_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class IO {
	public static void main(String[] args) {
		File file = new File("D:\\TestFile.txt");
		if (file.isFile()) {
			try {
				InputStream input = new FileInputStream(file);
				System.out.println("Available byte in the file: "+ input.available());
				byte[] array = new byte[input.available()];
				input.read(array);
				String data = new String(array);
				System.out.println(data);
				input.close();
			}
			catch(Exception e) {e.getStackTrace();}
		}
		else {System.out.println("File does not exist");}
		
		String data = "Trong dam gi dep bang sen";
		file = new File("D:\\TestOutput.txt");
		try {
			OutputStream out = new FileOutputStream("D:\\TestOutput.txt");
			byte[] dataByte = data.getBytes();
			out.write(dataByte);
			System.out.println("Data is written to the file.");
			out.close();
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		String[] paths;
		try {
			file = new File("D:\\");
			paths = file.list();
			for(String path : paths) {
				System.out.println(path);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
