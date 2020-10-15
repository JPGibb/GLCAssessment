import java.time.LocalDate;

public class Staff extends User {
	public Staff(String f, String s, String p, int uid) {
		firstName = f;
		surname = s;
		password = p;
		userId = uid;
		//nextUserId++;
		
	}	
}
