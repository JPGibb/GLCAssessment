import java.time.LocalDate;
import java.io.Serializable;

public class Loan implements Serializable{	
	
	//Declaring attributes
	private LocalDate loanDate;
	private int stockId;
	private static int nextLoanId = 1000;
	private int loanId;
	private Fine loanFine;
	private Boolean isReturned = false;
	
	//Constructor for the class
	public Loan(int s) {
		stockId = s;
		loanId = nextLoanId;
		nextLoanId++;
		loanFine = new Fine();		
		loanDate = LocalDate.now();
	}
	
	//Returns the loanId as an int
	public int getLoanId() {
		return loanId;
	}
		
	//Returns the fine for the loan
	public Fine getFine() {
		return loanFine;
	}
	
	//Returns the id of the stock item that was taken out on loan
	public int getStockId() {
		return stockId;
	}
	
	//Retunrs the details of the loan as a string
	public String getDetails() {
		return "Loan Id: " + loanId + "\n\rStock Id: " + stockId + " \n\rDate of loan: " + loanDate + "\n\r Has the loan been returned?: " + isReturned + " \n\rFine owed: " + loanFine.getFine();
	}
	
	//Returns the date that the loan was created
	public LocalDate getDate() {
		return loanDate;
	}
	
	//Returns the fine for the loan as a double
	public double getFineAmount() {
		return loanFine.getFine();
	}
	
	//Returns true or false based on whether the loan has been returned or not
	public boolean isReturned() {
		return isReturned;
	}
	
	//Records the return of the loan, setting a fine if necessary
	public void recordReturn(double f) {
		if(f > 0) {
			//loanFine = new Fine(f);
			loanFine.setFine(f);
		}
		isReturned = true;
	}
	
}
