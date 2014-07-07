package strategy;

import java.util.List;

import element.Customer;
import element.Staff;
import element.WaitingLine;

import simulation.Start;
import utility.Util;

public class RandomAllocation extends RoutingStrategy {

	public RandomAllocation(List<Staff> staffList) {
		super(staffList);
	}

	@Override
	public void sendToStaff(WaitingLine waitingLine) {
		setRestingStaffList();
		List<Integer> randomNumbers = Util.randomizeTo (waitingLine.size(), Start.NUMBER_OF_STAFF);
		int i=0;
		for (Customer customer : waitingLine.deQueueAll()) {
			staffList.get(randomNumbers.get(i++)).put(customer);
		}
	}
}
