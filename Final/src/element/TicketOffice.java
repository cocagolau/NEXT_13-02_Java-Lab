package element;

import java.util.ArrayList;
import java.util.List;

import strategy.RoutingStrategy;

import map.TrainMap;

public class TicketOffice extends Department{

	private RoutingStrategy routingStrategy;
	private List<Staff> staffList = new ArrayList<Staff>();
	private List<Customer> movementList = new ArrayList<Customer>();
	private TrainMap tMap;
	
	public static int count = 0;
	
	
	// constructor	
	public TicketOffice(int strategyCode, int quota, TrainMap tMap) {
		super(quota);
		this.tMap = tMap;
		this.routingStrategy = RoutingStrategy.design(strategyCode, staffList);
	}

	
	// doneList
	public List<Customer> getMovementList() {
		return movementList;
	}

	// processing	
	@Override
	protected void processingRegardOfTimePassed(){
		try {
			List<Customer> customers;
			movementList = new ArrayList<Customer>();
			
			synchronized (tMap) {
				tMap.notifyAll();
			}
			
			if (TicketOffice.count < 50)
				Thread.sleep(0,100);
			else {
				if (!Staff.flag)
					Staff.flag = true;
			}
			
			for (Staff staff : staffList) {
//				staff.work();
				customers = staff.getDone();
				if (customers != null) {
					movementList.addAll(customers);
					count += customers.size();
				}
			}
		}
		catch (InterruptedException e) { e.printStackTrace(); }
	}

	@Override
//	protected synchronized void processingRegardlessOfTime() {
	protected void processingRegardlessOfTime() {
		employStaff(super.QUOTA);
		routingStrategy.sendToStaff(super.waitingLine);
	}
	
	private void employStaff(int number) {
		if (staffList.size() == 0) {
			for (int i=0; i<number; i++) {
				Staff staff = new Staff(tMap);
				staffList.add(staff);
				staff.start();
			}
		}
	}
}
