import java.io.Serializable;

public abstract class Stock implements DisplayDetails, Serializable{
	
	//Declaring attributes
	protected int nextStockId = 1000;
	protected int stockId;
	protected double cost;
	protected String itemName;
	protected String itemDescription;
	protected Boolean avaliable = true;
	protected String itemType;
		
	//Returns the stockId as an int
	public int getStockId() {
		return stockId;
	}
	
	//Returns the cost as a double
	public double getCost() {
		return cost;
	}
	
	//Returns the item name as a string
	public String getName() {
		return itemName;
	}
	
	//Returns the description as a string
	public String getDesc() {
		return itemDescription;
	}
	
	//Returns whether the item is available as a boolean
	public Boolean isAvaliable() {
		return avaliable;
	}
	
	//Sets the value of available to passed parameter a
	public void setAvaliable(Boolean a) {
		avaliable = a;
	}
	
	//Returns the details of the item as a string
	public String getDetails() {
		return "Item Stock ID: " + stockId + "\n\rItem name: " + itemName + "\n\rItem type: " + itemType + "\n\rItem description: " + itemDescription;
	}
	
	//Sets the item name to passed parameter n
	public void setName(String n) {
		itemName = n;
	}
	
	//Sets the item description to the passed parameter d
	public void setDesc(String d) {
		itemDescription = d;
	}
	
	//Sets the cost of the item to passed parameter c
	public void setCost(double c) {
		cost = c;
	}
}
