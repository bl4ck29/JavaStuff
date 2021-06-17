package ontap;

public class Student {
	String ID, Name, DOB, Contact;
	public Student(String ID, String Name, String DOB, String Contact) {
		this.ID = ID;
		this.Name = Name;
		this.DOB = DOB;
		this.Contact = Contact;
	}
	public String toString() {
		return (this.ID+"-"+this.Name+"-"+this.DOB+"-"+this.Contact);
	}
}
