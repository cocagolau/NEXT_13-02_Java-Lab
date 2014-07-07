package element;

import java.util.ArrayList;
import java.util.List;

import map.Region;

import junit.framework.TestCase;

public class TrainTest extends TestCase{
	
	Train train;
	List<Customer> customers1;
	List<Customer> customers2;
	
	public void setUp() {
		train = new Train();
		
		customers1 = new ArrayList<Customer>();

		customers1.add(Customer.create(1, "customer1", 0, 1, Region.Name.Seoul, Region.Name.Deajeon));
		customers1.add(Customer.create(2, "customer2", 0, 2, Region.Name.Seoul, Region.Name.Deajeon));
		customers1.add(Customer.create(3, "customer2", 0, 3, Region.Name.Seoul, Region.Name.Deajeon));
		
		customers2 = new ArrayList<Customer>();
		customers2.add(Customer.create(1, "customer1", 1, 1, Region.Name.Seoul, Region.Name.Deajeon));
		customers2.add(Customer.create(2, "customer2", 2, 1, Region.Name.Seoul, Region.Name.Deajeon));
	}
	
	public void testDepartFor () {
		train.put(customers1);
		train.departFor();
		assertEquals (3, train.getVolumeOfTraffic());
		for (Customer customer : customers1)
			assertTrue (customer.pullOutOfStation());
		
		train.put(customers2);
		train.departFor();
		assertEquals (5, train.getVolumeOfTraffic());
		for (Customer customer : customers2)
			assertTrue (customer.pullOutOfStation());
		
		
	}

}
