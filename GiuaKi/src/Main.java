import java.util.List;
import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<NhanVien> lstNhanVien = new ArrayList<>();
		Nhap(lstNhanVien, 2, sc);
		InDanhSach(lstNhanVien, "GD");
		Write(lstNhanVien);
		Sort(lstNhanVien);
		for(NhanVien i : lstNhanVien) {System.out.println(i.ToString());}
	}
	
	static void Nhap(List<NhanVien> lst, int SoLuong, Scanner sc) {
		for(int i=0; i<SoLuong; i++) {
			System.out.print("Nhap ma so: ");
			String ms = sc.nextLine().strip();
			System.out.print("Nhap ten: ");
			String ten = sc.nextLine().strip();
			System.out.print("Nhap chuc vu: ");
			String chucvu = sc.nextLine().strip();
			System.out.print("Nhap dia chi: ");
			String diachi = sc.nextLine().strip();
			int luong = 0;
			while(luong <= 0 ) {
				System.out.print("Nhap luong: ");
				luong = Integer.parseInt(sc.nextLine());
			}
			lst.add(new NhanVien(ms, ten, chucvu, diachi, luong));
		}
	}
	
	static void InDanhSach(List<NhanVien> lst, String chucvu) {
		for(NhanVien nv : lst) {
			if(nv.ChucVu.contentEquals(chucvu)) {System.out.println(nv.ToString());}
		}
	}
	
	static void Sort(List<NhanVien> lst) {
		for(int i=0; i < lst.size(); i++) {
			for (int j=0; j<lst.size(); j++) {
				if(lst.get(i).Luong < lst.get(j).Luong) {
					NhanVien temp = lst.get(i);
					lst.set(i, lst.get(j));
					lst.set(j, temp);
				}
			}
		}
	}
	
	static void Write(List<NhanVien> lst) {
		File file = new File("DanhSach.txt");
		try {
			OutputStream output = new FileOutputStream(file);
			for(NhanVien nv : lst) {
				String content = nv.ToString()+"\n";
				output.write(content.getBytes());
			}
			output.close();
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
}
