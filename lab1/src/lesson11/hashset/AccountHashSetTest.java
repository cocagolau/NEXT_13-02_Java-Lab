package lesson11.hashset;

import junit.framework.TestCase;

public class AccountHashSetTest extends TestCase{
	public void testArrayList() {
		AccountManagementHashSet accountManagement = new AccountManagementHashSet(10);
		
		Account account1 = new Account(15000, "12341", "Tomas");
		Account account2 = new Account(25000, "12342", "James");
		Account account3 = new Account(35000, "12343", "Edward");
		Account account4 = new Account(45000, "12343", "Percy");
		
		accountManagement.insertAccount(account1);
		accountManagement.insertAccount(account2);
		accountManagement.insertAccount(account3);
		accountManagement.insertAccount(account4);
		
		accountManagement.setDeposit(50000, "12341");
		accountManagement.setDeposit(50000, "12342");
		accountManagement.setDeposit(50000, "12343");
		
		assertEquals(65000.0f, account1.getBalance());
		assertEquals(75000.0f, account2.getBalance());
		assertEquals(85000.0f, account3.getBalance());
	}
}