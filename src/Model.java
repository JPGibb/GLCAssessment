import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;

public class Model {
	
	private Controller ctrl;
	
	private int nextUId = 1000;
	private int nextSId = 1000;
	
	// Creates empty arraylist of type user
	private ArrayList<User> lstUser = new ArrayList<User>();
	
	// Creates empty arraylist of type Stock
	private ArrayList<Stock> lstStock = new ArrayList<Stock>();
	
	// Creates empty arraylist of type Admin
	private ArrayList<Admin>lstAdmin = new ArrayList<Admin>();
	
	public Model() {
		
	}
	
	public Model(Controller c) {
		ctrl = c;
		
		deserializeData("data");
		
	}
	
	public void serializeData(String fileName) {
		try {
				fileName += ".ser";
				FileOutputStream fileOut =  new FileOutputStream(fileName);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(lstUser);
				out.writeObject(lstStock);
				out.writeObject(lstAdmin);
				
				fileOut.close();
				out.close();
			}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void deserializeData(String fileName) {
		try {
				fileName += ".ser";
				FileInputStream fileIn = new FileInputStream(fileName);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				lstUser = (ArrayList<User>) in.readObject();
				lstStock = (ArrayList<Stock>) in.readObject();
				lstAdmin = (ArrayList<Admin>) in.readObject();
				
				fileIn.close();
				in.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			generateUsers();
			generateStock();
			serializeData("data");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void generateUsers() {
		//Generate full users
		//Creates a new FullUser object and adds it to the lstUsers arraylist
		lstUser.add(new FullUser("Adam","Zapel", "1234", nextUId));
		nextUId++;
		lstUser.add(new FullUser("Sophie", "Push", "Cat", nextUId));
		nextUId++;
		lstUser.add(new FullUser("Samuel", "Garcia", "Secure1234", nextUId));
		nextUId++;
		
		//Generate casual users
		//Creates a new CasualUser object and adds it to the lstUser arraylist
		lstUser.add(new CasualUser("Joseph", "Wilson", "1999Shepard", nextUId));
		nextUId++;
		lstUser.add(new CasualUser("Daniel", "Johnson", "", nextUId));
		nextUId++;
		lstUser.add(new CasualUser("Matthew", "Williams", "Matt243", nextUId));
		nextUId++;
		
		//Generate staff users
		//Creates a new Staff object and adds it to the lstUser arraylist
		lstUser.add(new Staff("James", "Davis", "12345", nextUId));
		nextUId++;
		lstUser.add(new Staff("Max", "Power", "MrPlow", nextUId));
		nextUId++;
		lstUser.add(new Staff("Axl", "Rosa", "AxRose10", nextUId));
		nextUId++;
		//Generate admin user
		//Creates a new Admin object and adds it to the lstAdmin arraylist
		lstAdmin.add(new Admin("Adam", "West", "Chocolate"));
		
	}
	
	public void generateStock() {
		//Generate Books
		//Creates a new Book object and adds it to the lstStock arraylist
		lstStock.add(new Book("Hunger Games", "Fight to the death","700", 12.70, nextSId));
		nextSId++;
		lstStock.add(new Book("The Witcher", "Steel for humans, silver for monsters","1124", 25.50, nextSId));
		nextSId++;
		lstStock.add(new Book("Maze Runner", "Book","5289", 12.70, nextSId));
		nextSId++;
		
		//Generate Journals
		//Creates a new Journal object and adds it to the lstStock arraylist
		lstStock.add(new Journal("Magnets how do they work", "One of lifes great mysteries","214", 20, 1, nextSId));
		nextSId++;
		lstStock.add(new Journal("A brief history of the universe", "From the Big Bang onwards","594", 25.5, 10, nextSId));
		nextSId++;
		lstStock.add(new Journal("Java for dummies", "Coffee is recommended","845", 12, 2, nextSId));
		nextSId++;
		
		//Generate Videos
		//Creates a new Video object and adds it to the lstStock arraylist
		lstStock.add(new Video("Star Wars", "In a galaxy far far away","Hard Platic", "mp4", 120, 5.90, nextSId));
		nextSId++;
		lstStock.add(new Video("Planet earth", "And here we see a documentary in it natural habitat","Hard plastic","avi", 240, 10.50, nextSId));
		nextSId++;
		lstStock.add(new Video("Maze Runner", "Movie","Plastc sleve", "mp4", 100, 10.20, nextSId));
		nextSId++;
		
		//Generate CDs
		//Creates a new CD object and adds it to the lstStock arraylist
		lstStock.add(new CD("Kamikaze", "Crashing into everything","Small Hard Plastic","Eminem","Music album", 10, 45, 15, nextSId));
		nextSId++;
		lstStock.add(new CD("Roald Dahl: Greatest work", "A collection of audio books","Plasitc sleve","Roald Dahl", "Audio Book", 4, 240, 25.50, nextSId));
		nextSId++;
		lstStock.add(new CD("Whale sounds", "Relaxing whale sounds","Small Hard Plastic", "National Geographic", "Relaxation",5, 120, 12.70, nextSId));
	}
	
	public void generateLoans() {
		ctrl.createNewLoan(1000, 1000, true);
		ctrl.createNewLoan(1002, 1005, true);
		ctrl.createNewLoan(1000, 1006, true);
		ctrl.createNewLoan(1006, 1008, true);
	}
	
	public ArrayList<User> getUsers(){
		return lstUser;
	}
	
	public ArrayList<Admin> getAdmin(){
		return lstAdmin;
	}
	
	public ArrayList<Stock> getStock(){
		return lstStock;
	}
	
	public void setController(Controller c) {
		ctrl = c;
	}
	
	public int getUserSize() {
		int size = 0;
		
		size += lstUser.size();
		size += lstAdmin.size();
		
		return size;
	}
	
	public void resetUsers() {
		lstUser.clear();
		lstAdmin.clear();
	}
	
	public int getStockSize() {
		return lstStock.size();
	}
	
	public void resetStock() {
		lstStock.clear();
	}
	
	public int getNumberLoans() {
		int size = 0;
		
		Iterator<User> it = lstUser.iterator();
		while(it.hasNext()) {
			User u = it.next();
				size += u.getNumberLoans();
			}
		
		return size;
	}
	
	public void resetLoans() {
		Iterator<User> it = lstUser.iterator();
		while(it.hasNext()) {
			User u = it.next();
				u.resetLoans();
			}
	}
	
	public void checkstock() {
		Iterator<Stock> it = lstStock.iterator();
		while(it.hasNext()) {
			Stock s = it.next();
				System.out.println(s.isAvaliable());
			}
	}
}
