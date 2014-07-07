package element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import map.Region;

import element.Customer;

import junit.framework.TestCase;

public class WaitingLineTest extends TestCase{

	WaitingLine waitingLine;
	List<Customer> customers1, customers2, customers3;
	List<Customer> allCustomers;
	static final int NUMBER_OF_STAFF = 3;
	
	public void setUp() {
		waitingLine = new WaitingLine();
		allCustomers = new ArrayList<Customer>();
		customers1 = new ArrayList<Customer>();
		customers2 = new ArrayList<Customer>();
		customers3 = new ArrayList<Customer>();
		
		// start
		customers1.add(Customer.create( 1, "customer1", 0, 1, Region.Name.Seoul, Region.Name.Deajeon)); // 1
		customers1.add(Customer.create( 2, "customer2", 0, 2, Region.Name.Seoul, Region.Name.Deajeon)); // 2
		customers1.add(Customer.create( 3, "customer2", 0, 3, Region.Name.Seoul, Region.Name.Deajeon)); // 3
		customers1.add(Customer.create( 4, "customer2", 0, 1, Region.Name.Seoul, Region.Name.Deajeon)); // 1
		
		// after 1min 
		customers2.add(Customer.create( 5, "customer2", 1, 1, Region.Name.Seoul, Region.Name.Deajeon)); // 2
		
		// after 2min		
		customers3.add(Customer.create( 6, "customer2", 2, 6, Region.Name.Seoul, Region.Name.Deajeon)); // 8
		customers3.add(Customer.create( 7, "customer2", 2, 7, Region.Name.Seoul, Region.Name.Deajeon)); // 9
		customers3.add(Customer.create( 8, "customer2", 2, 3, Region.Name.Seoul, Region.Name.Deajeon)); // 5
		customers3.add(Customer.create( 9, "customer2", 2, 1, Region.Name.Seoul, Region.Name.Deajeon)); // 3
		customers3.add(Customer.create(10, "customer2", 2, 1, Region.Name.Seoul, Region.Name.Deajeon)); // 3
	}

	public void testPutInLine() {
		waitingLine.enQueue(customers1);
		waitingLine.sortWaitingLine();
		assertEquals (4, waitingLine.size());
		
		waitingLine.enQueue(customers2);
		waitingLine.sortWaitingLine();
		assertEquals (5, waitingLine.size());
	}
	
	public void testSortList() {
		allCustomers.addAll(customers1);
		allCustomers.addAll(customers2);
		allCustomers.addAll(customers3);
		Collections.sort(allCustomers);
		
		waitingLine.enQueue(customers1);
		waitingLine.sortWaitingLine();
		waitingLine.enQueue(customers2);
		waitingLine.sortWaitingLine();
		waitingLine.enQueue(customers3);
		waitingLine.sortWaitingLine();
		
		int i = 0;
		Iterator<Customer> ir = waitingLine.iterator();
		while (ir.hasNext())
			assertEquals (allCustomers.get(i++), ir.next());
	}
		
	public void testGetInLine() {
		List<Customer> goTicketing;
		waitingLine.enQueue(customers1);  // 0분에 도착, 시작하자말자 고객 추가
		waitingLine.sortWaitingLine();
		
		goTicketing = waitingLine.deQueue(3);  // 고객 추가되자마자 staff가 빈맠큼 ticketing, 최대 3명까지
		assertEquals (3, goTicketing.size());
		
		assertEquals (customers1.get(0), goTicketing.get(0));
		assertEquals (1, goTicketing.get(0).getExpectedFinishTimeOfTicketing());
		
		assertEquals (customers1.get(3), goTicketing.get(1));
		assertEquals (1, goTicketing.get(1).getExpectedFinishTimeOfTicketing());
		
		assertEquals (customers1.get(1), goTicketing.get(2));
		assertEquals (2, goTicketing.get(2).getExpectedFinishTimeOfTicketing());

	}

}
