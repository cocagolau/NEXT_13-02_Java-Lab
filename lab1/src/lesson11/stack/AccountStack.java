package lesson11.stack;

public class AccountStack implements AccountStackImpl {
	
	private int index = 0;
	private int size = 0;
	private Account[] accounts;
	
	public AccountStack (int size) {
		this.size = size;
		accounts = new Account[10];
	}

	@Override
	public void push(Account account) {
		if (account == null) return;
		
		if (!isFull()) {
			accounts[index++] = account;
			return;
		}
		
		// Need to create operation when stack is Full
		
	}

	@Override
	public Account pop() {
		Account tempAccount;
		
		if (!isEmpty()) {
			tempAccount = accounts[--index];
			accounts[index+1] = null;
			return tempAccount;
		}
		
		return null;
	}

	@Override
	public Account peek() {
		return accounts[index-1];
	}
	
	private boolean isEmpty() {		
		return index == 0;
	}
	
	private boolean isFull() {
		return index >= size;
	}

}
