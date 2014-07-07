package lesson11.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class AccountManagementArrayList {
	
	private ArrayList<Account> accounts;
	
	public AccountManagementArrayList (int size) {
		accounts = new ArrayList(size);
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
