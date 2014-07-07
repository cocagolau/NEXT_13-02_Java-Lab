package lesson11.stack;

import junit.framework.TestCase;

public class AccountStackTest extends TestCase{
	public void testStack() {
		Account acc1 = new Account(15000,"123456_1", "james");
		Account acc2 = new Account(25000,"123456_2", "edward");
		Account acc3 = new Account(35000,"123456_3", "tomas");
		
		AccountStack accountStack = new AccountStack(10);
		
		accountStack.push(acc1);
		accountStack.push(acc2);
		accountStack.push(acc3);
		
		assertEquals(acc3, accountStack.pop());
		assertEquals(acc2, accountStack.pop());
		assertEquals(acc1, accountStack.pop());
	}
}