//extends keyword means that the class inherits methods and attributes of another class
//In this case FullUser inherits from the User class
public class FullUser extends User {
	
	//Class constructor
	//The constructor is overloaded and is passed parameters
	public FullUser(String fn, String s, String pw, int uid) {
		userId = uid;
		firstName = fn;
		surname = s;
		password = pw;
		//nextUserId++;
	}
	
	
}
