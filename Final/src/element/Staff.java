package element;

import java.util.ArrayList;
import java.util.List;

import utility.Dijkstra;
import map.TrainMap;


public class Staff extends Thread{
//public class Staff{

	private Dijkstra dijkstra;
	private WaitingLine waitingLine = new WaitingLine();
	private boolean resting = false;
	public static boolean flag = false;
	private List<Customer> doneList = null;
	
	private Customer priority = null;
	private int processingTime = 0;
	private TrainMap tMap;
	
	
	public Staff(TrainMap tMap) {
		this.tMap = tMap;
		dijkstra = new Dijkstra(tMap);
	}

	public void put(Customer customer) {
		setWorking();
		waitingLine.enQueue(customer);
	}
	
	public List<Customer> getDone() {
		List<Customer> tempList;
		if (doneList == null)
			tempList = new ArrayList<Customer>();
		else
			tempList = doneList;
		doneList = null;
		
		return tempList;
	}
	
	public boolean isResting() {
		if (waitingLine.size() == 0) resting = true;
		return resting;
	}
	
	
	private void setWorking() {
		if (resting)
			resting = false;
	}
	
	public void run() {
		while (!Staff.flag) {
			try {
				synchronized (tMap) {
					tMap.wait();
				}
				work();
			}
			catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
	
	
	
	private void work() {  // 일단.. 1분단위 설정
//	public void work() {  // 일단.. 1분단위 설정
		if (priority == null) {
			if (!isResting()) {
				setWorking();
				priority = waitingLine.priority();
				priority.leaveWaitingLine();
				processingTime = 0;
			}
		}
		if (priority != null) {  // 우선자 존재
			// 1분단위 실행
			processingTime++;
			if (!priority.hasTravelTime()) {
				int travelTime;
				synchronized (tMap) {
					travelTime = dijkstra.getShortestDistance(priority.getDepartureStation(), priority.getArrivalStation());
				}
				priority.setTravelTime(travelTime);
//				priority.setTravelTime(dijkstra.getShortestDistance(priority.getDepartureStation(), priority.getArrivalStation()));
			}
			if (processingTime >= priority.getTimeRequiredForTicketing()) {
				priority.setWaitingTimeOfTicketing();
				priority.setDoneWithTicketing();
				doneList = waitingLine.deQueue(1);
				// priority init
				priority = null;
			}
		}
	}
	


}
