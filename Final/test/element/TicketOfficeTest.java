package element;

import java.util.ArrayList;
import java.util.List;

import simulation.Start;
import utility.Parser;

import map.MapParser;
import map.Region;
import map.TrainMap;

import junit.framework.TestCase;

public class TicketOfficeTest extends TestCase{
	
	TicketOffice ticketOffice;
	List<Customer> customers1, customers2, customers3;
	List<Customer> allCustomers;
	
	TrainMap tMap;
	MapParser mapParser;
	
	public void setUp() {
		mapParser = new MapParser(Start.TRAIN_MAP_PATH, Parser.Separator.TAP);
		tMap = TrainMap.create(mapParser.getToRegionList(), mapParser.getCreations());
		ticketOffice = new TicketOffice(3, Start.NUMBER_OF_STAFF, tMap);
		
		allCustomers = new ArrayList<Customer>();
		customers1 = new ArrayList<Customer>();
		customers2 = new ArrayList<Customer>();
		customers3 = new ArrayList<Customer>();
		setupCustomers();
	}
	
	private void setupCustomers () {
		// start
		customers1.add(Customer.create( 1, "customer1", 0, 1, Region.Name.Seoul, Region.Name.Deajeon)); // 1
		customers1.add(Customer.create( 2, "customer2", 0, 2, Region.Name.Seoul, Region.Name.Deajeon)); // 2
		customers1.add(Customer.create( 3, "customer3", 0, 3, Region.Name.Seoul, Region.Name.Deajeon)); // 3
		customers1.add(Customer.create( 4, "customer4", 0, 1, Region.Name.Seoul, Region.Name.Deajeon)); // 1
		
		// after 1min
		customers2.add(Customer.create( 5, "customer5", 1, 1, Region.Name.Seoul, Region.Name.Deajeon)); // 2
		
		// after 2min		
		customers3 = new ArrayList<Customer>();
		customers3.add(Customer.create( 6, "customer6", 2, 6, Region.Name.Seoul, Region.Name.Deajeon)); // 8
		customers3.add(Customer.create( 7, "customer7", 2, 7, Region.Name.Seoul, Region.Name.Deajeon)); // 9
		customers3.add(Customer.create( 8, "customer8", 2, 3, Region.Name.Seoul, Region.Name.Deajeon)); // 5
		customers3.add(Customer.create( 9, "customer9", 2, 1, Region.Name.Seoul, Region.Name.Deajeon)); // 3
		customers3.add(Customer.create(10, "customer10", 2, 1, Region.Name.Seoul, Region.Name.Deajeon)); // 3
		
		allCustomers.addAll(customers1);
		allCustomers.addAll(customers2);
		allCustomers.addAll(customers3);
	}

	public void testProcess() {
		
		//presentTime = 0;
		Start.presentTime = 0;
		ticketOffice.process(customers1);
		assertEquals(1, ticketOffice.size());
		assertEquals(0, ticketOffice.getMovementList().size());

		//after a minute // 1
		Start.presentTime++;
		ticketOffice.process(customers2);
		assertEquals(0, ticketOffice.size());
		assertEquals(2, ticketOffice.getMovementList().size());
		
		//after a minute // 2
		Start.presentTime++;
		ticketOffice.process(customers3);
		assertEquals(3, ticketOffice.size());
		assertEquals(2, ticketOffice.getMovementList().size());
				
		//after a minute // 3
		Start.presentTime++;
		ticketOffice.process();
		assertEquals(1, ticketOffice.size());
		assertEquals(2, ticketOffice.getMovementList().size());
		
		//after a minute // 4
		Start.presentTime++;
		ticketOffice.process();
		assertEquals(0, ticketOffice.size());
		assertEquals(1, ticketOffice.getMovementList().size());
		
		//after a minute // 5
		Start.presentTime++;
		ticketOffice.process();
		assertEquals(0, ticketOffice.size());
		assertEquals(0, ticketOffice.getMovementList().size());
		
		//after a minute // 6
		Start.presentTime++;
		ticketOffice.process();
		assertEquals(0, ticketOffice.size());
		assertEquals(1, ticketOffice.getMovementList().size());
		
		//after a minute // 7
		Start.presentTime++;
		ticketOffice.process();
		assertEquals(0, ticketOffice.size());
		assertEquals(0, ticketOffice.getMovementList().size());
		
		//after a minute // 8
		Start.presentTime++;
		ticketOffice.process();
		assertEquals(0, ticketOffice.size());
		assertEquals(0, ticketOffice.getMovementList().size());
		
		//after a minute // 9
		Start.presentTime++;
		ticketOffice.process();
		assertEquals(0, ticketOffice.size());
		assertEquals(1, ticketOffice.getMovementList().size());
		
		//after a minute // 10
		Start.presentTime++;
		ticketOffice.process();
		assertEquals(0, ticketOffice.size());
		assertEquals(0, ticketOffice.getMovementList().size());
		
		//after a minute // 11
		Start.presentTime++;
		ticketOffice.process();
		assertEquals(0, ticketOffice.size());
		assertEquals(1, ticketOffice.getMovementList().size());
		
		
		Staff.flag = true;
		
	}

}
