package element;

import java.util.ArrayList;
import java.util.List;

import map.Region;

import simulation.Start;

import junit.framework.TestCase;

public class StationMasterTest extends TestCase{
	
	StationMaster stationMaster;
	List<Customer> customers;
	
	public void setUp () {
		setCustomers();
		stationMaster = StationMaster.analyze(customers, 1);
	}
	
	private void setCustomers () {
		customers = new ArrayList<Customer>();
		for (int i=1; i<=50; i++) {
			customers.add(Customer.create(i, "cus"+i, 0, 1, Region.Name.Seoul, Region.Name.Deajeon));
		}
	}
	
	public void testArrivedAtDestination() {
		for (Customer customer : customers)
			assertTrue (customer.arrivedAtDestination());
	}
	
	
	public void testReport () {
		stationMaster.report(Start.TEST_REPORT_PATH);
	}
}
