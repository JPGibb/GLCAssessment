
public class Journal extends Stock {
	
	//Declaring attributes
	private String issn;
	private int issueNumber;
	
	//Class constructor
	public Journal(String t, String desc, String is, double c, int in, int nextSId ) {
		stockId = nextSId;
		//nextStockId++;
		itemName = t;
		itemDescription = desc;
		issn = is;
		cost = c;
		issueNumber = in;
		itemType = "Journal";
	}
}
