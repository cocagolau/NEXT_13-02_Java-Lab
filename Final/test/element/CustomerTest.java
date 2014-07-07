package element;

import java.io.File;

import map.Region;

import element.Customer;

import junit.framework.TestCase;

public class CustomerTest extends TestCase{

	File customerInfo;
	int id1;
	int id2;
	String name1;
	String name2;
	int arrivalTime;
	int processingTime;
	Region.Name departureStation;
	Region.Name arrivalStation;
		
	
	public void testCreateCustomer() {
		id1 = 1;
		id2 = 1;
		name1 = "customer1";
		name2 = "customer2";
		arrivalTime = 1;
		processingTime = 1;
		departureStation = Region.Name.Seoul;
		arrivalStation = Region.Name.Deajeon;
	
		Customer customer1 = Customer.create(id1, name1, arrivalTime, processingTime, departureStation, arrivalStation);
		Customer customer2 = Customer.create(id2, name2, arrivalTime, processingTime, departureStation, arrivalStation);
	
		assertEquals (id1, customer1.getId());
		assertEquals (id2, customer2.getId());
		
	}
	

}
