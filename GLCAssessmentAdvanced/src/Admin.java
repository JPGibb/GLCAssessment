import java.util.ArrayList;
import java.io.Serializable;

public class Admin implements Serializable{
	
	//Declaring attributes
	
	//Static attribute is shared between all instances of the class
	private static int nextAdminId = 1000;
	
	private int adminId;
	private String firstName;
	private String surname;
	private String password;
	private ArrayList<Login> lstLogin = new ArrayList<Login>();
	
	//Class constructor method
	public Admin(String fn, String s, String p) {
		firstName = fn;
		surname = s;
		password = p;
		adminId = nextAdminId;
		nextAdminId++;
	}

	//Returns the adminId as an integer
	public int getId() {
		return adminId;
	}
	
	//Returns the password as a string, for testing purposes
	public String getPassword() {
		return password;
	}
	
	//Creates a new login for the user
	public void createLogin() {
		lstLogin.add(new Login());
	}
	
	//Returns the details of the user as a string
	public String getDetails() {
		return "First name: " + firstName + " Surname: " + surname;
	}
}
