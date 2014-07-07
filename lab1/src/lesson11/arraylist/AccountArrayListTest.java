package lesson11.arraylist;

import junit.framework.TestCase;
import lesson11.hashset.AccountManagementHashSet;

public class AccountArrayListTest extends TestCase{
	public void testHashSet() {
		AccountManagementArrayList accountManagement = new AccountManagementArrayList(10);
		
		Account account1 = new Account(15000, "12341", "Tomas");
		Account account2 = new Account(25000, "12342", "James");
		Account account3 = new Account(35000, "12343", "Edward");
		
		accountManagement.insertAccount(account1);
		accountManagement.insertAccount(account2);
		accountManagement.insertAccount(account3);
		
		accountManagement.setDeposit(50000, "12341");
		accountManagement.setDeposit(50000, "12342");
		accountManagement.setDeposit(50000, "12343");
		
		assertEquals(65000.0f, account1.getBalance());
		assertEquals(75000.0f, account2.getBalance());
		assertEquals(85000.0f, account3.getBalance());
	}
}