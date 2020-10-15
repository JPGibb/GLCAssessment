import java.time.LocalDate;
import java.io.Serializable;
import java.util.Random;

public class Login implements Serializable{
	
	//Declaring attributes
	private LocalDate loginDate;
	private LocalDate loginTime;
	private LocalDate logoutTime;
	private int computerId;
	
	Random r = new Random();
	
	//Constructor method for the class
	public Login() {
		loginDate = LocalDate.now();
		computerId = r.nextInt(100) + 1;
	}
	
	//Returns the login date and computer id for the object as a string
	public String getLoginInfo() {
		return "Login Date: " + loginDate + "\n\rComputer Id: " + computerId;
	}
}
