import java.io.Serializable;

public class Fine implements Serializable{
	
	//Declaring attributes
	private double fineAmount;
		
	//Sets the value of fineAmount to passed parameter f
	public void setFine(double f) {
		fineAmount = f;
	}
	
	//Returns fineAmount as a double
	public double getFine() {
		return fineAmount;
	}
	
}
