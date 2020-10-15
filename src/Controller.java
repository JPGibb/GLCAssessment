import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

//The Controller class
public class Controller {
	
	//Creates an instance of the Model class
	private Model dataModel = new Model(this);
		
	//Creates a reference to the current user that is logged in, value will be null until a FullUser, Staff or CasualUser login
	private User currentUser;
	
	
	// Constructor method for the controller class, constructor methods are called when an instance of the class is created
	public Controller() {
		
//		dataModel.generateUsers();
//		dataModel.generateStock();
		
		
		showLoginScreen();	
	}
	
	// Searches the lstStock arraylist to find the stock item with a matching id
	// If a matching item is found a reference to it will be returned, otherwise null will be returned
	private Stock searchStockId(int sId){
		
		//Creates a boolean variable called found and assigns it the value of false
		boolean found = false;
		
		ArrayList<Stock> stock = dataModel.getStock();
		//Creates an iterator for the lstStock arraylist of the type stock
		//The iterator will be used to iterate through all the items in the arraylist 
		Iterator<Stock> it = stock.iterator();
		
		//A while loop that will run indefinitely until the specified condition is no longer met
		//Unlike a do while loop, a regular while loop is not guaranteed to run at all as the conditional statement is check before the code is executed
		while(it.hasNext() && found == false) {
			Stock s = it.next();
			if(s.getStockId() == sId) {
				return s;
			}
		}
		return null;		
	}
	
	//Searches the lstUser arraylist for a user with a matching id
	// If a matching user is found then a reference to it will be returned, otherwise null will be returned
	public User searchUserId(int uId) {
				
		boolean found = false;
		ArrayList<User> user = dataModel.getUsers();
		Iterator<User> it = user.iterator();
		while(it.hasNext() && found == false) {
			User u = it.next();
			if(u.getUId() == uId) {
				return u;
			}
		}
		//System.out.println("Unable to find that user");
		return null;		
	}
		
	public boolean validateLogin(int id, String pass) {
		int uId = id;
		String pw = pass;
		
		ArrayList<User> users = dataModel.getUsers();
		boolean found = false;
		Iterator<User> it = users.iterator();
		while(it.hasNext() && found == false) {
			User u = it.next();
			if(u.getUId() == uId) {
				found = true;
				if(u.getPassword().toString().equals(pw.toString())) {
					u.createLogin();
					currentUser = u;
					openUserMenu();
					return true;
					
				} else {
					return false;
				}
			}
		}
		
		return false;
	}
	
	public boolean validateAdminLogin(int id, String pass) {
		
		int uId = id;
		String pw = pass;
		
		ArrayList<Admin> admin = dataModel.getAdmin();
		boolean found = false;
		Iterator<Admin> it = admin.iterator();
		while(it.hasNext() && found == false) {
			Admin a = it.next();
			if(a.getId() == uId) {
				found = true;
				if(a.getPassword().toString().equals(pw.toString())) {
					a.createLogin();
					openAdminMenu();
					return true;
					
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public String getAllLoansForUser() {
		String message = null;	
		message = currentUser.getAllLoans();
		
		return message;
	}
	
	private void showLoginScreen() {
		LoginScreen loginFrame = new LoginScreen();
		loginFrame.setTitle("Login");
		loginFrame.setController(this);
		loginFrame.setVisible(true);
	}
	
	public void openUserMenu() {
		UserMenu menu = new UserMenu();
		menu.setTitle("User Menu");
		menu.setController(this);
		menu.setVisible(true);
	}
	
	public void openAdminMenu() {
		AdminMenu am = new AdminMenu();
		am.setTitle("Admin menu");
		am.setController(this);
		am.setVisible(true);
	}
	
	public void openDisplayInfoScreen() {
		DisplayInfoScreen frame = new DisplayInfoScreen();
		frame.setTitle("Display Info");
		frame.setController(this);
		frame.setVisible(true);
	}
	
	public void openCreateLoanScreen() {
		CreateLoanScreen frame = new CreateLoanScreen();
		frame.setTitle("Create new loan");
		frame.setController(this);
		frame.setVisible(true);
	}
	
	public void logout() {
		showLoginScreen();
		currentUser = null;
	}
	
	public String listAllUsers() {
		String message = "";
		
		ArrayList<User> users = dataModel.getUsers();
		
		Iterator<User> it = users.iterator();
		message += "Users!\n\r";
		while(it.hasNext()) {
			User u = it.next();
			message += "The user id for " + u.getDetails() + " is: " + u.getUId() + "\n\r";
			} 
		
		message += "Admins!\n\r";
		ArrayList<Admin> admin = dataModel.getAdmin();
		Iterator<Admin> ait = admin.iterator();
		while(ait.hasNext() ) {
			Admin a = ait.next();
			message += "The user id for " + a.getDetails() + " is: " + a.getId() + "\n\r";
			}
		
		return message;
	}
	
	public String listAllStock() {
		String message = "";
		
		boolean foundStock = false;
		ArrayList<Stock> stock = dataModel.getStock();
		Iterator<Stock> sIt = stock.iterator();
		while(sIt.hasNext() && foundStock == false) {
			Stock s = sIt.next();
			message += "==================================\n\r";
			message += s.getDetails() + "\n\r";
			//System.out.println(s.getDetails());
			}
		message += "==================================\n\r";
		
		return message;
	}
	
	public String listAllLoans(){
		String message = null;
		
		ArrayList<User> users = dataModel.getUsers();
			
		ArrayList<Stock> stock = dataModel.getStock();
	
		Iterator<User> it = users.iterator();
		//message += "Listing all loans";
		while(it.hasNext()) {
			User u = it.next();
			
			String l = null;
			l = u.getAllLoans();
			if(!l.isEmpty() ) {
				message += "\n\r=====================================";
				message += "\n\rThe user id " + u.getUId() + "\n\r" + u.getAllLoans();
				message += "=====================================";
			}
		}
		
		return message;
	}
	
	public boolean createNewLoan(int userId, int stockId, boolean shouldSerialize) {
		User u = searchUserId(userId);
		Stock s = searchStockId(stockId);
		
		
		if(u != null) {
				if(s != null){
					if(s.isAvaliable()) {
						
						u.createLoan(s);
						s.setAvaliable(false);
						if(shouldSerialize){
							dataModel.serializeData("data");
						}
						//Loan created returning true to CreateLoanScreen
						return true;
					} else {
						//Stock item is not available returning false to CreateLoanScreen
						System.out.println("Stock item is not available returning false to CreateLoanScreen");
						return false;
					}
				}
				else {
					//Stock item not found returning false to CreateLoanScreen
					System.out.println("Stock item not found returning false to CreateLoanScreen");
					return false;
				}
		}else {
			//User not found returning false to CreateLoanScreen
			System.out.println("User not found returning false to CreateLoanScreen");
			return false;
		}
	}

	public Model getModel() {
		return dataModel;
	}
	
	public void setModel(Model m) {
		dataModel = m;
	}
}
