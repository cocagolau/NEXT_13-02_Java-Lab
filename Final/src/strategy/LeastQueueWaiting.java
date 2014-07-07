package strategy;

import java.util.List;

import element.Customer;
import element.Staff;
import element.WaitingLine;


public class LeastQueueWaiting extends RoutingStrategy {
	
	public LeastQueueWaiting (List<Staff> staffList) {
		super(staffList);
	}
	
	@Override
	public void sendToStaff(WaitingLine waitingLine) {
		setRestingStaffList();
		waitingLine.sortWaitingLine();
		int i=0;
		for (Customer customer : waitingLine.deQueue(getNumberOfRestingStaff())) {
			restingStaffList.get(i++).put(customer);
		}
	}

}
