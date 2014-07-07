package map;


import element.Customer;
import element.Staff;
import simulation.Start;
import utility.Parser;

import map.TrainMap;
import junit.framework.TestCase;

public class TrainMapTest extends TestCase{
	
	TrainMap tMap;
	MapParser mapParser;
	Region.Name name = Region.Name.Seoul;
	
	Staff staff;
	Customer customer1, customer2, customer3, customer4, customer5, customer6, customer7;
	
	public void setUp() {
		mapParser = new MapParser(Start.TRAIN_MAP_PATH, Parser.Separator.TAP);
		tMap = TrainMap.create(mapParser.getToRegionList(), mapParser.getCreations());
		
		customer1 = Customer.create(1, "customer1", 1, 1, Region.Name.Seoul, Region.Name.Deajeon);
		customer2 = Customer.create(1, "customer1", 1, 1, Region.Name.Asan, Region.Name.Deajeon);
		customer3 = Customer.create(1, "customer1", 1, 1, Region.Name.Chuncheon, Region.Name.Deajeon);
		customer4 = Customer.create(1, "customer1", 1, 1, Region.Name.Deajeon, Region.Name.Seoul);
		customer5 = Customer.create(1, "customer1", 1, 1, Region.Name.Wonju, Region.Name.Deajeon);
		customer6 = Customer.create(1, "customer1", 1, 1, Region.Name.Gwangju, Region.Name.Deajeon);
		customer7 = Customer.create(1, "customer1", 1, 1, Region.Name.Kyungju, Region.Name.Deajeon);
		staff = new Staff(tMap);
	}
	
}
