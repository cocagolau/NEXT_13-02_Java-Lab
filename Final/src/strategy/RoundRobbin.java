package strategy;

import java.util.List;

import element.Customer;
import element.Staff;
import element.WaitingLine;

import simulation.Start;


public class RoundRobbin extends RoutingStrategy {

	public RoundRobbin(List<Staff> staffList) {
		super(staffList);
	}

	@Override
	public void sendToStaff(WaitingLine waitingLine) {
		setRestingStaffList();
		int i=0;
		for (Customer customer : waitingLine.deQueueAll()) {
			staffList.get(i++%Start.NUMBER_OF_STAFF).put(customer);
		}
	}

}
