package ontap;

import java.util.ArrayList;

public class Main {
	public static ArrayList<Student> lst = new ArrayList<Student>();

	public static void main(String[] args) {
		Add("187", "Cao", "12/12/1212", "pasdo12d");
		Add("123", "Khanh", "13/12/1212", "caokhanhviet");
		Sort();
		PrintList();
	}
	
	public static void Add(String ID, String Name, String DOB, String Contact) {
		lst.add(new Student(ID, Name, DOB, Contact));
	}
	
	public static void PrintList() {
		for(Student std : lst) {
			System.out.println(std.toString());
		}
	}
	
	public static void FindDOB(String DOB) {
		for(Student std : lst) {
			if(std.DOB.equals(DOB)) {
				System.out.println(std.toString());
			}
		}
	}
	
	public static void Sort() {
		for(int i=0; i<lst.size(); i++) {
			for(int j=0; j<lst.size();j++) {
				int msi = Integer.parseInt(lst.get(i).ID);
				int msj = Integer.parseInt(lst.get(j).ID);
				if(msi < msj) {
					Student temp = lst.get(i);
					lst.set(i, lst.get(j));
					lst.set(j, temp);
				}
			}
		}
	}
}
