import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class Tests {

	
	//Test the pre-population of users functionality, should pass
	@Test
	void testPrepopulateUsersShouldPass() {
		Model dataModel = new Model();
		
		dataModel.generateUsers();
		
		int currentSize = dataModel.getUserSize();
		
		dataModel.resetUsers();
		System.out.println("User size is: " + currentSize);
		
		assertEquals(10, currentSize);
	}
	
	//Test the pre-population of users functionality,  should fail
	@Test
	void testPrepopulateUsersShouldFail() {
		Model dataModel = new Model();
		
		dataModel.generateUsers();
		
		int currentSize = dataModel.getUserSize();
		
		dataModel.resetUsers();
		System.out.println("User size is: " + currentSize);
		
		assertEquals(11, currentSize);
	}
	
	//Test pre-population of stock functionality, should pass
	@Test
	void testPrepopulateStockShouldPass() {
		Model dataModel = new Model();
		
		dataModel.generateStock();
		
		int currentSize = dataModel.getStockSize();
		
		dataModel.resetStock();
		System.out.println("Stock size is: " + currentSize);
		
		assertEquals(12, currentSize);
	}
	
	//Test pre-population of stock functionality, should fail
	@Test
	void testPrepopulateStockShouldFail() {
		Model dataModel = new Model();
		
		dataModel.generateStock();
		
		int currentSize = dataModel.getStockSize();
		
		dataModel.resetStock();
		System.out.println("Stock size is: " + currentSize);
		
		assertEquals(11, currentSize);
	}
	
	//Test pre-population of loans functionality, should pass
	@Test
	void testPopulateLoanShouldPass(){
		Model dataModel = new Model();
		Controller ctrl = new Controller();
		ctrl.setModel(dataModel);
		dataModel.setController(ctrl);
		
		dataModel.generateUsers();
		dataModel.generateStock();
		
		dataModel.generateLoans();
		int currentSize = dataModel.getNumberLoans();
		
		dataModel.resetUsers();
		dataModel.resetStock();
		dataModel.resetLoans();
		assertEquals(4, currentSize);
	}
	
	//Test pre-population of loans functionality, should fail
	@Test
	void testPopulateLoanShouldFail(){
		Model dataModel = new Model();
		Controller ctrl = new Controller();
		ctrl.setModel(dataModel);
		dataModel.setController(ctrl);
		
		dataModel.generateUsers();
		dataModel.generateStock();
		
		dataModel.generateLoans();
		
		int currentSize = dataModel.getNumberLoans();
		
		dataModel.resetUsers();
		dataModel.resetStock();
		dataModel.resetLoans();
		assertEquals(3, currentSize);
	}

	
	//Test login functionality, should pass
	@Test
	void testLoginShouldPass() {
		Model dataModel = new Model();
		Controller ctrl = new Controller();
		ctrl.setModel(dataModel);
		dataModel.setController(ctrl);
		
		dataModel.generateUsers();

		boolean success = ctrl.validateLogin(1000, "1234");
		
		dataModel.resetUsers();
		assertEquals(true, success);
	}
	
	//Test login functionality, should fail
	@Test
	void testLoginShouldFail() {
		Model dataModel = new Model();
		Controller ctrl = new Controller();
		ctrl.setModel(dataModel);
		dataModel.setController(ctrl);
		
		dataModel.generateUsers();

		boolean success = ctrl.validateLogin(1000, "123");
		
		dataModel.resetUsers();
		assertEquals(true, success);
	}
		
	//Test get all users functionality, should pass
	@Test
	void testGetAllUsersShouldPass() {
		Model dataModel = new Model();
		Controller ctrl = new Controller();
		ctrl.setModel(dataModel);
		dataModel.setController(ctrl);
		
		dataModel.generateUsers();
		
		ArrayList<User> users = dataModel.getUsers();
		ArrayList<Admin> admin = dataModel.getAdmin();
		
		int currentSize = users.size() + admin.size();
		System.out.println("Number of users: " + currentSize);
		
		dataModel.resetUsers();
		assertEquals(10, currentSize);
	}
	
	//Test get all users functionality, should fail
	@Test
	void testGetAllUsersShouldFail() {
		Model dataModel = new Model();
		Controller ctrl = new Controller();
		ctrl.setModel(dataModel);
		dataModel.setController(ctrl);
		
		dataModel.generateUsers();
		
		ArrayList<User> users = dataModel.getUsers();
		ArrayList<Admin> admin = dataModel.getAdmin();
		
		int currentSize = users.size() + admin.size();
		System.out.println("Number of users: " + currentSize);
		
		dataModel.resetUsers();
		assertEquals(11, currentSize);
		
	}
	
	//Test get all stock functionality, should pass
	@Test
	void getAllStockShouldPass() {
		Model dataModel = new Model();
		Controller ctrl = new Controller();
		ctrl.setModel(dataModel);
		dataModel.setController(ctrl);
		
		dataModel.generateStock();
		
		ArrayList<Stock> stock = dataModel.getStock();
		
		int currentSize = stock.size();
		
		dataModel.resetStock();
		assertEquals(12, currentSize);
	}
	
	//Test get all stock functionality, should fail
	@Test
	void getAllStockShouldFail() {
		Model dataModel = new Model();
		Controller ctrl = new Controller();
		ctrl.setModel(dataModel);
		dataModel.setController(ctrl);
		
		dataModel.generateStock();
		
		ArrayList<Stock> stock = dataModel.getStock();
		
		int currentSize = stock.size();
		
		dataModel.resetStock();
		assertEquals(10, currentSize);
	}
	
	//Test get all loans functionality, should pass
	@Test
	void getAllLoansShouldPass() {
		Model dataModel = new Model();
		Controller ctrl = new Controller();
		ctrl.setModel(dataModel);
		dataModel.setController(ctrl);
		
		dataModel.generateUsers();
		dataModel.generateStock();
		dataModel.generateLoans();
		
		String message = null;
		message = ctrl.listAllLoans();
		
		dataModel.resetLoans();
		dataModel.resetUsers();
		dataModel.resetStock();
		assertNotEquals(null, message);
	}
	
	//Test get all loans functionality, should fail
	@Test
	void getAllLoansShouldFail() {
		Model dataModel = new Model();
		Controller ctrl = new Controller();
		ctrl.setModel(dataModel);
		dataModel.setController(ctrl);
		
		dataModel.generateUsers();
		dataModel.generateStock();
		dataModel.generateLoans();
		
		String message = null;
		message = ctrl.listAllLoans();
		
		dataModel.resetLoans();
		dataModel.resetUsers();
		dataModel.resetStock();
		assertEquals(null, message);
	}
	
	//Test record loan functionality, should pass
	@Test
	void testRecordLoanShouldPass() {
		Model dataModel = new Model();
		Controller ctrl = new Controller();
		ctrl.setModel(dataModel);
		dataModel.setController(ctrl);
		
		dataModel.generateUsers();
		dataModel.generateStock();
		
		ctrl.createNewLoan(1000, 1000, false);
		
		User u = ctrl.searchUserId(1000);
		Loan loan = u.getLastLoan();
		
		dataModel.resetUsers();
		dataModel.resetStock();
		assertNotEquals(null, loan);
	}
	
	//Test record loan functionality, should fail
	@Test
	void testRecordLoanShouldFail() {
		Model dataModel = new Model();
		Controller ctrl = new Controller();
		ctrl.setModel(dataModel);
		dataModel.setController(ctrl);
		
		dataModel.generateUsers();
		dataModel.generateStock();
		
		ctrl.createNewLoan(100, 1000, false);
		
		User u = ctrl.searchUserId(1000);
		Loan loan = u.getLastLoan();
		
		dataModel.resetUsers();
		dataModel.resetStock();
		assertNotEquals(null, loan);
	}
	
	//Test get all loans for a single user, should pass
	@Test
	void testGetAllLoansForUserShouldPass() {
		Model dataModel = new Model();
		Controller ctrl = new Controller();
		ctrl.setModel(dataModel);
		dataModel.setController(ctrl);
		
		dataModel.generateUsers();
		dataModel.generateStock();
		dataModel.generateLoans();
		
		User u = ctrl.searchUserId(1000);
		
		String message = null;
		message = u.getAllLoans();
		
		assertNotEquals(null, message);
	}
	
	//Test get all loans for a single user, should fail
	@Test
	void testGetAllLoansForUserShouldFail() {
		Model dataModel = new Model();
		Controller ctrl = new Controller();
		ctrl.setModel(dataModel);
		dataModel.setController(ctrl);
		
		dataModel.generateUsers();
		dataModel.generateStock();
		dataModel.generateLoans();
		
		User u = ctrl.searchUserId(1000);
		
		String message = null;
		message = u.getAllLoans();
		
		assertEquals(null, message);
	}
	
	//Test serialisation of data functionality, should pass
	@Test
	void testSerializeDataShouldPass() {
		Model dataModel = new Model();
		Controller ctrl = new Controller();
		ctrl.setModel(dataModel);
		dataModel.setController(ctrl);
		
		dataModel.generateUsers();
		dataModel.generateStock();
		dataModel.generateLoans();
		
		ArrayList<User> users = dataModel.getUsers();
		ArrayList<Admin> admin = dataModel.getAdmin();
		ArrayList<Stock> stock = dataModel.getStock();
		
		dataModel.serializeData("testData");
		dataModel.deserializeData("testData");
		
		ArrayList<User> afterUsers = dataModel.getUsers();
		ArrayList<Admin> afterAdmin = dataModel.getAdmin();
		ArrayList<Stock> afterStock = dataModel.getStock();
		
		boolean success = false;
		
		if(users.size() == afterUsers.size() && admin.size() == afterAdmin.size() && stock.size() == afterStock.size()){
			success = true;
		}
		assertTrue(success);
	}
}
