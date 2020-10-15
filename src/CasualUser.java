
public class CasualUser extends User {
	public CasualUser(String fn, String s, String pw) {
		firstName = fn;
		surname = s;
		password = pw;
		userId = nextUserId;
		nextUserId++;
	}
	
	public CasualUser(String fn, String s, String pw, int uid) {
		firstName = fn;
		surname = s;
		password = pw;
		userId = uid;
		//nextUserId++;
	}
	
}
