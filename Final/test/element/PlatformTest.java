package element;

import java.util.ArrayList;
import java.util.List;

import map.Region;

import simulation.Start;

import junit.framework.TestCase;

public class PlatformTest extends TestCase{

	Platform platform;
	List<Customer> customers1, customers2, customers3, customers4, customers5, customers6;

	public void setUp () {
		platform = new Platform();
		customers1 = new ArrayList<Customer>();
		customers1.add(Customer.create(1, "customer1", 0, 1, Region.Name.Seoul, Region.Name.Deajeon));
		customers1.add(Customer.create(2, "customer2", 0, 1, Region.Name.Seoul, Region.Name.Deajeon));
		customers1.add(Customer.create(3, "customer3", 0, 1, Region.Name.Seoul, Region.Name.Deajeon));
		
		customers2 = new ArrayList<Customer>();
		customers2.add(Customer.create(4, "customer4", 0, 2, Region.Name.Seoul, Region.Name.Deajeon));
		customers2.add(Customer.create(5, "customer5", 0, 2, Region.Name.Seoul, Region.Name.Deajeon));
		
		customers3 = new ArrayList<Customer>();
		customers3.add(Customer.create(6, "customer6", 0, 3, Region.Name.Seoul, Region.Name.Deajeon));
		customers3.add(Customer.create(7, "customer7", 0, 1, Region.Name.Seoul, Region.Name.Deajeon));
		
		customers4 = new ArrayList<Customer>();
		
		customers4.add(Customer.create(8, "customer8", 0, 4, Region.Name.Seoul, Region.Name.Deajeon));
		customers4.add(Customer.create(9, "customer9", 0, 3, Region.Name.Seoul, Region.Name.Deajeon));
		
		customers5 = new ArrayList<Customer>();
		customers5.add(Customer.create(10, "customer10", 0, 7, Region.Name.Seoul, Region.Name.Deajeon));
		customers5.add(Customer.create(11, "customer11", 0, 7, Region.Name.Seoul, Region.Name.Deajeon));
		
		customers6 = new ArrayList<Customer>();
		customers6.add(Customer.create(12, "customer12", 0, 7, Region.Name.Seoul, Region.Name.Deajeon));
		customers6.add(Customer.create(13, "customer13", 0, 7, Region.Name.Seoul, Region.Name.Deajeon));

	}
	
	public void testProcess() {
		// 1
		Start.presentTime = 1;
		platform.process(customers1);
		assertEquals(3, platform.size());
		assertFalse (platform.hasTrain());
		
		// 2
		Start.presentTime ++;
		platform.process(customers2);
		assertEquals(5, platform.size());
		assertFalse (platform.hasTrain());
		
		// 3
		Start.presentTime ++;
		platform.process(customers3);
		assertEquals(7, platform.size());
		assertFalse (platform.hasTrain());
		
		// 4
		Start.presentTime ++;
		platform.process(customers4);
		assertEquals(9, platform.size());
		assertFalse (platform.hasTrain());
		
		// 5
		Start.presentTime ++;
		platform.process(customers5);		
		assertEquals(2, platform.size());
		assertTrue (platform.hasTrain());
		
		// 6
		Start.presentTime ++;
		platform.process(customers6);
		assertEquals(4, platform.size());
		assertFalse (platform.hasTrain());
		
		// 7
		Start.presentTime ++;
		platform.process();
		assertEquals(4, platform.size());
		assertFalse (platform.hasTrain());
		
		// 8
		Start.presentTime ++;
		platform.process();
		assertEquals(4, platform.size());
		assertFalse (platform.hasTrain());
		
		// 9
		Start.presentTime ++;
		platform.process();
		assertEquals(4, platform.size());
		assertFalse (platform.hasTrain());
		
		// 10
		Start.presentTime ++;
		platform.process();
		assertEquals(0, platform.size());
		assertTrue (platform.hasTrain());
		
	}

}
