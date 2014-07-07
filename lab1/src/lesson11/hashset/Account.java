package lesson11.hashset;

public class Account {
	private float balance;
	private String accountNumber;
	private String accountName;
	
	public Account(){}
	public Account(float balance, String accountNumber, String accountName)
	{
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
	}
	
	
	public void withdraw(float amount)
	{
		if(amount > balance){
			System.out.println("잔고 부족!");
		}
		else{
			balance -= amount;
		}
	}
	
	public void deposit(float amount)
	{
		if(amount <= 0){
			System.out.println(amount +"로는 입금불가");
		}
		else{
			balance += amount;
		}
	}
	@Override
	public String toString() {
		return accountName + "님의 계좌번호는" + accountNumber + "이며, + " +
				"현재 잔고는" + balance + "입니다.";
	}
	
	@Override
	public int hashCode() {
		return getAccountNumber().hashCode();
	}
	@Override
	public boolean equals(Object object) {
		Account that = (Account)object;
		return this.getAccountNumber().equals(that.getAccountNumber());
	}
	
	public float getBalance()
	{
		return balance;
	}
	
	public String getAccountNumber()
	{
		return accountNumber;
	}
	
	public String getAccountName()
	{
		return accountName;
		
	}
}
