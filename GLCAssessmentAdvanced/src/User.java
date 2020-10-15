import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

//Abstract class cannot be instantiated
public abstract class User implements DisplayDetails, Serializable {
	
	//Declaring attributes
	//Static attributes are shared between all instances of the class
	//Protected access modifier allows the attributes to only be access from methods within this class or from with classes that inherit from this one
	
	protected int nextUserId = 1000;
	
	protected int userId;
	protected String password = null;
	protected String firstName = null;
	protected String surname = null;
	protected String address = null;
	protected String town = null;
	protected String postcode;
	protected int phoneNo;
	protected LocalDate dob;
	
	protected ArrayList<Login> lstLogin = new ArrayList<Login>();
	protected ArrayList<Loan> lstLoan = new ArrayList<Loan>();
	
	//Returns the dob  of the user as a string
	public String getDob() {
		return	"This users date of birth is " + dob.toString();	
	}
	
	//Sets the password to value of the passed parameter p
	public void setPassword(String p) {
		password = p;
	}
	
	//Searches all the loan for the user
	//If the matching loan is found it is returned, otherwise null will be returned
	public Loan searchLoans(int lid) {
		boolean found = false;
		Iterator<Loan> it = lstLoan.iterator();
		while(it.hasNext() && found == false) {
			Loan l = it.next();
				if(l.getLoanId() == lid) {
					return l;
				}				
			}
		return null;
	}
	
	//Returns the details of the user as a string
	public String getDetails() {
		return "User ID: " + userId + " Name: " + firstName + " " + surname;
	}
	
	//Returns the userId as a string
	public int getUId() {
		return userId;
	}
	
	//Returns the password as a string, for testing purposes
	public String getPassword() {
		return password;
	}
	
	//Creates a new login for the user
	public void createLogin() {
		lstLogin.add(new Login());
	}
	
	//Returns the first loan for the user, for testing purposes
	public String getLogin() {
		Login l = lstLogin.get(0);
		return l.getLoginInfo();
	}
	
	//Creates a new loan  for the user
	public void createLoan(Stock s) {
		lstLoan.add(new Loan(s.getStockId()));
	}
	
	//Returns the last loan for the user, if no loans exist null is returned
	public Loan getLastLoan() {
		for(int i = lstLoan.size() - 1; i >= 0; i++) {
			if(lstLoan.get(i) != null) {
				return lstLoan.get(i);
			}
		}
		return null;
	}
	
	//Creates and returns the string variable message that contains all the information for every loan for the user
	public String getAllLoans() {
		String message = null;
		
		Iterator<Loan> it = lstLoan.iterator();
		message = "";
		while(it.hasNext()) {
			Loan l = it.next();
				message += l.getDetails();
				message += "\n\r";
		}				
		return message;
	}
	
	public int getNumberLoans() {
		return lstLoan.size();
	}
	
	//Sets the first name of the user to passed parameter f
	public void setFirstName(String f) {
		firstName = f;
	}
	
	//Sets the surname to the passed parameter s
	public void setSurname(String s) {
		surname = s;
	}
	
	public void resetLoans() {
		lstLoan.clear();
	}
}
