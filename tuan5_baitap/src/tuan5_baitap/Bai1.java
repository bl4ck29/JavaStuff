package tuan5_baitap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Bai1 {
	public static void main(String[] args) {
		//1
		File file = new File("D:/187it23616");
		file.mkdir();
		
		//2
		file = new File(file.toString()+"/taptin.txt");
		
		//3
		String content = "1, 8, 9, 3, 9, 2, 4, 7, 5, 10";
		Write(file, content);
		
		String data = Read(file);
		String[] lstContent = data.split(",");
		
		//4, 5, 6
		int[] lstNum = new int[lstContent.length];
		int chan=0, le=0;
		for (int i=0; i<lstContent.length; i++) {
			int num = Integer.parseInt(lstContent[i].strip());
			lstNum[i] = num;
			if (num % 2 ==0){chan += num;}
			else {le += num;}
		}
		System.out.println("Tong cac so chan: "+chan+"\nTong cac so le: "+le+"\nTong cac so: "+(chan+le));
		
		//7
		System.out.print("Cac so nguyen to: ");
		for (int i : lstNum) {
			if(isPrime(i)) {System.out.print(i+" ");}
		}
		System.out.println();
		
		//8, 9
		int[] result = FindMinAndMax(lstNum);
		System.out.println("So nho nhat la: "+result[0]+"\nSo lon nhat la: "+result[1]);
		
		//10
		System.out.print("So chinh phuong: ");
		for(int i : lstNum) {
			double num = Math.sqrt(i);
			if(num- (int)num == 0) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
		
		//11
		lstNum = Sort(lstNum, false);
		for(int i : lstNum) {System.out.print(i+" ");}
		
		//12
		content = "";
		for(int i : lstNum) {content += (i+" ");}
		file = new File("D:/187it23616/ketqua.txt");
		Write(file, content);
	}
	
	public static void Write(File file, String content) {
		if(file.isFile()) {System.out.println("The file's name is already existed");}
		else {
			try {
				OutputStream output = new FileOutputStream(file);
				output.write(content.getBytes());
				output.close();
			}
			catch(Exception e) {System.out.println("Can not write the content");}
		}
	}
	
	public static String Read(File file) {
		try {
			InputStream input = new FileInputStream(file);
			byte[] data = input.readAllBytes();
			input.close();
			return new String(data);
		}
		catch(Exception e) {return " ";}
	}
	
	public static Boolean isPrime(int num) {
		if(num < 2) {return false;}
		if(num == 2) {return true;}
		else {
			for(int i=2; i<=Math.sqrt(num); i++) {
				if(num % i == 0) {return false;}
			}
		}
		return true;
	}
	
	public static int[] FindMinAndMax(int[] lst) {
		int min = lst[0], max = lst[0];
		for (int i : lst) {
			if (i < min) {min = i;}
			if (i > max) {max = i;}
		}
		return new int[] {min, max};
	}
	
	public static int[] Sort(int[] lst, Boolean tang) {
		for(int i=0; i<lst.length; i++) {
			for(int j=0; j<lst.length; j++) {
				if(tang) {
					if(lst[i] > lst[j]) {
						int temp = lst[i];
						lst[i] = lst[j];
						lst[j] = temp;
					}
				}
				else {
					if(lst[i] < lst[j]) {
						int temp = lst[i];
						lst[i] = lst[j];
						lst[j] = temp;
					}
				}
			}
		}
		return lst;
	}
}