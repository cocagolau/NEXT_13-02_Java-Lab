package lesson11.hashset;

import java.util.HashSet;
import java.util.Iterator;

public class AccountManagementHashSet {
	
	private HashSet<Account> accounts;
	
	public AccountManagementHashSet (int size) {
		accounts = new HashSet<Account>();
	}
	
	public void insertAccount(Account account) {
		accounts.add(account);
	}

	public void setDeposit(float deposit, String accountNumber) {
		Account tempAccount;
		Iterator ir = accounts.iterator();
		while (ir.hasNext()) {
			tempAccount = (Account)ir.next();
			if (accountNumber == tempAccount.getAccountNumber())
				tempAccount.deposit(deposit);
		}
	}
	

}
