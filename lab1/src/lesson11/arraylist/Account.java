package lesson11.arraylist;

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
			System.out.println("�ܰ� ����!");
		}
		else{
			balance -= amount;
		}
	}
	
	public void deposit(float amount)
	{
		if(amount <= 0){
			System.out.println(amount +"�δ� �ԱݺҰ�");
		}
		else{
			balance += amount;
		}
	}
	@Override
	public String toString() {
		return accountName + "���� ���¹�ȣ��" + accountNumber + "�̸�, + " +
				"���� �ܰ��" + balance + "�Դϴ�.";
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
