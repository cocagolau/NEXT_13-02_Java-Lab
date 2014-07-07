package element;

import java.util.List;

public class Train {
	
	private List<Customer> customers;
	private int volumeOfTraffic = 0;
	
	
	public void put(List<Customer> customers) {
		this.customers = customers;		
	}
	
	public void departFor() {
		for (Customer customer : customers) {
			customer.setPullOutOfStation();
			customer.setWaitingTimeAtPlatform();
			customer.setArrivedAtDestination();			
			volumeOfTraffic ++;
		}
	}
	
	public int getVolumeOfTraffic () {
		return volumeOfTraffic;
	}


}
