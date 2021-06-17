package tuan5_baitap;
import java.util.Scanner;

public class Bai2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String content = Nhap(sc);
		String[] lstContent = content.split(" ");
		
		//1 So tu trong chuoi
		System.out.println("So tu trong chuoi: "+lstContent.length);
		
		//2 In ra chuoi hoa
		Convert(content, true);
		
		//3 In ra chuoi thuong
		Convert(content, false);
		
		//4 Tim ky tu n
		System.out.print("Nhap ky tu can tim: ");
		String n = sc.nextLine();
		System.out.println("Co "+Count_Character(lstContent, n)+" ky tu "+n+" trong chuoi");
		
		int[] count = Count(lstContent);
		//5 Dem ky tu hoa
		System.out.println("Co "+count[1]+" ky tu hoa trong chuoi");
		
		//6 Dem ky tu thuong
		System.out.println("Co "+count[2]+" ky tu hoa trong chuoi");
		
		//7 Dem ky tu so
		System.out.println("Co "+count[0]+" ky tu so trong chuoi");
		
		//8 Dem ky tu khoang trang
		System.out.println("Co "+(lstContent.length - 1)+" ky tu khoang trang trong chuoi");
		
		//9 Loai bo khang trang dau va cuoi
		System.out.println(content.strip());
		
		sc.close();
	}
	
	static String Nhap(Scanner sc) {
		System.out.print("Nhap vao 1 chuoi: ");
		return sc.nextLine().strip();
	}
	
	static void Convert(String str, Boolean upper) {
		if(upper) {System.out.println( str.toUpperCase());}
		else {System.out.println( str.toLowerCase());}
	}
	
	static int Count_Character(String[] lstContent, String n) {
		int count = 0;
		for(String i : lstContent) {
			for(String j : i.split("")) {
				if(j.contains(n)){count ++;}
			}
		}
		return count;
	}
	
	static int[] Count(String[] lstContent) {
		int[] count = new  int[3];
		for(String i : lstContent) {
			for(String j : i.split("")) {
				try {
					Integer.parseInt(j);
					count[0] ++;
				}
				catch(java.lang.NumberFormatException err){
					if(j.contentEquals(j.toUpperCase())) {count[1]++;}
					else {count[2]++;}
				}
			}
		}
		return count;
	}
}