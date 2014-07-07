package element;

import map.Region;
import simulation.Start;

public class Customer implements Comparable<Customer>{
	
	private int id;
	private String name;
	private int arrivalTimeAtTicketOffice;
	private int timeRequiredForTicketing;
	private Region.Name departureStation;
	private Region.Name arrivalStation;
	
	// staff ¿¬»ê
	private boolean leftWaitingLine = false;
	private boolean doneWithTicketing = false;
	private int actualStartTimeOfTicketing = 0;
	private int     waitingTimeOfTicketing = 0;
	
	// in waitingLine
	//// checking
	public boolean leftWaitingLine() {
		return leftWaitingLine;
	}
	public void leaveWaitingLine() {
		if (!leftWaitingLine()) {
			leftWaitingLine = true;
			setActualStartTimeOfTicketing();
		}
	}
	////actualStartTimeOfTicketing
	private void setActualStartTimeOfTicketing() {
		actualStartTimeOfTicketing = Start.presentTime-1;
	}
	public int getActualTimeOfTicketing() {
		return actualStartTimeOfTicketing;
	}
	//// ticketing time
	public void setWaitingTimeOfTicketing() {
		if (!doneWithTicketing())
			waitingTimeOfTicketing = getActualTimeOfTicketing() - getArrivalTimeAtTicketOffice();
	}
	
	public int getWaitingTimeOfTicketing() {
		return waitingTimeOfTicketing;
	}
	
	
	//// done
	public boolean doneWithTicketing() {
		return doneWithTicketing;
	}
	public void setDoneWithTicketing() {
		doneWithTicketing = true;
	}
	//--------------
	
	

	private boolean arrivedAtPlatform = false;
	private boolean pullOutOfStation = false;
	private boolean arrivedAtDestination = false;
	
	private int travelTime;
	private boolean hasTravelTime = false;
	
	private int expectedFinishTimeOfTicketing;
	
	
	private int arrivalTimeAtPlatform;
	private int waitingTimeAtPlatform;
	
	private int departureTimeOfTrain;
	private int   arrivalTimeOfTrain;
	
	
	// private constructor
	private Customer (int id, String name, int arrivalTimeAtTicketOffice, int timeRequiredForTicketing, Region.Name departureStation, Region.Name arrivalStation) {
		this.id = id;
		this.name = name;
		this.arrivalTimeAtTicketOffice = arrivalTimeAtTicketOffice;
		this.timeRequiredForTicketing = timeRequiredForTicketing;
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		
		this.expectedFinishTimeOfTicketing = arrivalTimeAtTicketOffice + timeRequiredForTicketing;
	}

	//factory
	public static Customer create(int id, String name, int arrivalTime, int ticketingTime, Region.Name departureStation, Region.Name arrivalStation) {
		return new Customer(id, name, arrivalTime, ticketingTime, departureStation, arrivalStation);
	}
	
	@Override
	public int compareTo(Customer that) {
		     if (this.getExpectedFinishTimeOfTicketing() < that.getExpectedFinishTimeOfTicketing()) return -1;
		else if (this.getExpectedFinishTimeOfTicketing() > that.getExpectedFinishTimeOfTicketing()) return  1;
		else {
			     if (this.getId() < that.getId()) return -1;
			else if (this.getId() > that.getId()) return  1;
		}
		return 0;
	}
	

	//// travelTime
	public boolean hasTravelTime() {
		return hasTravelTime;
	}
	public void setTravelTime(int travelTime) {
		if (!hasTravelTime()) {
			this.travelTime = travelTime;
		}
	}
	public int getTravelTime() {
		return travelTime;
	}
	
	// ticketing At TicketOffice
	//// checking
	//// expectedFinishTimeOfTicketing
//	public void updateExpectedFinishTimeOfTicketing(int supplementaryTime) {
//		if (!leftWaitingLine)
//			expectedFinishTimeOfTicketing += supplementaryTime;		
//	}
	public int getExpectedFinishTimeOfTicketing() {
		return expectedFinishTimeOfTicketing;
	}

	

	// waiting At Platform
	//// checking
	public void setArrivedAtPlatform() {
		if(!arrivedAtPlatform) {
			arrivedAtPlatform = true;
			arrivalTimeAtPlatform = Start.presentTime;
		}
	}
	//// boarding
	public void setWaitingTimeAtPlatform() {
		waitingTimeAtPlatform = departureTimeOfTrain - arrivalTimeAtPlatform;
	}
	public int getWaitingTimeAtPlatform() {
		return waitingTimeAtPlatform;
	}
	
	
	// train
	//// checking
	public boolean pullOutOfStation() {
		return pullOutOfStation;
	}
	public void setPullOutOfStation() {
		if (!pullOutOfStation) {
			pullOutOfStation = true;
			departureTimeOfTrain = Start.presentTime;
		}
	}
	
	// travel
	//// checking
	public boolean arrivedAtDestination() {
		return arrivedAtDestination;
	}
	public void setArrivedAtDestination() {
		if (!arrivedAtDestination) {
			arrivedAtDestination = true;
			arrivalTimeOfTrain = Start.presentTime + travelTime;
		}
	}
	
	public int getDepartureTimeOfTrain() {
		return departureTimeOfTrain;
	}
	public int getArrivalTimeOfTrain() {
		return arrivalTimeOfTrain;
	}
	
	
	
	/////
	int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getArrivalTimeAtTicketOffice() {
		return arrivalTimeAtTicketOffice;
	}
	public int getTimeRequiredForTicketing() {
		return timeRequiredForTicketing;
	}
	public Region.Name getDepartureStation() {
		return departureStation;
	}
	public Region.Name getArrivalStation() {
		return arrivalStation;
	}

}
