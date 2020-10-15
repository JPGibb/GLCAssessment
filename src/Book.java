
public class Book extends Stock{
	
	//Declaring attributes
	private String isbn;
	
	//Class constructors
	public Book(String name, String desc, String bn, double c, int nextSId) {
		stockId = nextSId;
		//nextStockId++;
		itemName = name;
		itemDescription  = desc;
		cost = c;
		isbn = bn;
		itemType = "Book";
	}
}
