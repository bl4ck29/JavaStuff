import javax.swing.JFrame;

public class MainJ extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainJ c= new MainJ();
		c.setVisible(true);
	}
	public MainJ(){
		setTitle("Student Management");
		setSize(730, 680);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Students obj= new Students();
		this.add(obj);
		
		setLocationRelativeTo(null);
	}

}
