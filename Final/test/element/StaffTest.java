package element;

import simulation.Start;
import utility.Parser;
import map.MapParser;
import map.Region;
import map.TrainMap;
import element.Customer;
import junit.framework.TestCase;

public class StaffTest extends TestCase{
	
	Staff staff;
	Customer customer1, customer2;
	
	TrainMap tMap;
	MapParser mapParser;
	
	
	public void setUp() {
		mapParser = new MapParser(Start.TRAIN_MAP_PATH, Parser.Separator.TAP);
		tMap = TrainMap.create(mapParser.getToRegionList(), mapParser.getCreations());
		
		customer1 = Customer.create(1, "customer1", 1, 1, Region.Name.Seoul, Region.Name.Deajeon);
		customer2 = Customer.create(2, "customer2", 1, 2, Region.Name.Seoul, Region.Name.Deajeon);
		staff = new Staff(tMap);
	}
	
	public void testStaff() {
		
		// 0
		Start.presentTime = 1;
		assertEquals (0, staff.getDone().size());
		assertTrue (staff.isResting());
		
		staff.put(customer1);
		staff.put(customer2);
		assertFalse (staff.isResting());
		assertFalse (customer1.leftWaitingLine());
		assertFalse (customer2.leftWaitingLine());
		// 도착시간
		assertEquals (1, customer1.getArrivalTimeAtTicketOffice());
		assertEquals (1, customer2.getArrivalTimeAtTicketOffice());
		// 도착시간
		assertEquals (0, customer1.getActualTimeOfTicketing());
		assertEquals (0, customer2.getActualTimeOfTicketing());
		// 티킷팅 대기시간
		assertEquals (0, customer1.getWaitingTimeOfTicketing());
		assertEquals (0, customer2.getWaitingTimeOfTicketing());
		// 티킷팅 완료
		assertFalse (customer1.doneWithTicketing());
		assertFalse (customer2.doneWithTicketing());
		
		// 1
		Start.presentTime++;
		staff.run();
		assertFalse (staff.isResting());
		assertTrue (customer1.leftWaitingLine());
		assertFalse (customer2.leftWaitingLine());
		assertEquals (customer1, staff.getDone().get(0));
		// 도착시간
		assertEquals (1, customer1.getArrivalTimeAtTicketOffice());
		assertEquals (1, customer2.getArrivalTimeAtTicketOffice());
		// 도착시간
		assertEquals (1, customer1.getActualTimeOfTicketing());
		assertEquals (0, customer2.getActualTimeOfTicketing());
		// 티킷팅 대기시간
		assertEquals (0, customer1.getWaitingTimeOfTicketing());
		assertEquals (0, customer2.getWaitingTimeOfTicketing());
		// 티킷팅 완료
		assertTrue (customer1.doneWithTicketing());
		assertFalse (customer2.doneWithTicketing());
		
		
		// 2
		Start.presentTime++;
		staff.run();
		assertFalse (staff.isResting());
		assertTrue (customer1.leftWaitingLine());
		assertTrue (customer2.leftWaitingLine());
		assertEquals (0, staff.getDone().size());
		// 도착시간
		assertEquals (1, customer1.getArrivalTimeAtTicketOffice());
		assertEquals (1, customer2.getArrivalTimeAtTicketOffice());
		// 도착시간
		assertEquals (1, customer1.getActualTimeOfTicketing());
		assertEquals (2, customer2.getActualTimeOfTicketing());
		// 티킷팅 대기시간
		assertEquals (0, customer1.getWaitingTimeOfTicketing());
		assertEquals (0, customer2.getWaitingTimeOfTicketing());
		// 티킷팅 완료
		assertTrue (customer1.doneWithTicketing());
		assertFalse (customer2.doneWithTicketing());
		
		// 3
		Start.presentTime++;
		staff.run();
		assertTrue (staff.isResting());
		assertTrue (customer1.leftWaitingLine());
		assertTrue (customer2.leftWaitingLine());
		assertEquals (customer2, staff.getDone().get(0));
		// 도착시간
		assertEquals (1, customer1.getArrivalTimeAtTicketOffice());
		assertEquals (1, customer2.getArrivalTimeAtTicketOffice());
		// 도착시간
		assertEquals (1, customer1.getActualTimeOfTicketing());
		assertEquals (2, customer2.getActualTimeOfTicketing());
		// 티킷팅 대기시간
		assertEquals (0, customer1.getWaitingTimeOfTicketing());
		assertEquals (1, customer2.getWaitingTimeOfTicketing());
		// 티킷팅 완료
		assertTrue (customer1.doneWithTicketing());
		assertTrue (customer2.doneWithTicketing());
	}

}
