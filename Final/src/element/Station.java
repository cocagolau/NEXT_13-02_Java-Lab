package element;

import java.util.ArrayList;
import java.util.List;

import map.MapParser;
import map.TrainMap;

import simulation.Start;
import utility.Clock;
import utility.Parser;
import utility.Util;

public class Station {
		
	private TicketOffice ticketOffice;
	private Platform platform;
	private TrainMap tMap;
	private MapParser mapParser;
	private Clock clock;
	private int strategyNumber;
	
	private List<Customer> customerInfo;
	private List<Customer> movementList;
		
	private boolean isToMoveToPlatform = false;
	private boolean finishedInfo = false;
	private int departedCustomer = 0;
	
	
	
	//private constructor
	private Station (String infoPath, int strategyNumber) {
		this.strategyNumber = strategyNumber;
		mapParser = new MapParser(Start.TRAIN_MAP_PATH, Parser.Separator.TAP);
		tMap = TrainMap.create(mapParser.getToRegionList(), mapParser.getCreations());
		ticketOffice = new TicketOffice(strategyNumber, Start.NUMBER_OF_STAFF, tMap);
		platform = new Platform();
		clock = new Clock();
		
		
		setCustomerInfo(
			new Parser(infoPath, Parser.Separator.TAP) {
				@Override
				protected Object createObject(String[] split) {
					return
						Customer.create(
							Integer.parseInt(split[0]),
							String.valueOf(split[1]),
							Integer.parseInt(split[2]),
							Integer.parseInt(split[3]), 
							Util.Region(String.valueOf(split[4])),
							Util.Region(String.valueOf(split[5]))
						);
				}
				@Override
				protected List createList(String[] split) {
					return null;
				}					
			}
		); 
	}

	// factory
	public static Station create(String infoPath, int strategyNumber) {
		return new Station (infoPath, strategyNumber);
	}
	
	// execute
	public void executeSimulation() {
		processInOffice();		// 1
		processAtPlatform();	// 2
		makeReport();			// 3
	}
	

	// 1
	private void processInOffice() {
		if (!finishedInfo())	
			ticketOffice.process(getLatestCustomerInfo());
		else
			ticketOffice.process();		
	}
	private boolean finishedInfo() {
		if (!finishedInfo && departedCustomer>=50)
			finishedInfo = true;
		return finishedInfo;
	}
	
	
	// 2
	private void processAtPlatform() {
		updateMovementList();
		if (isToMoveToPlatform())
			platform.process(movementList);
		else
			platform.process();	
	}
	private void updateMovementList() {
		if (clock.isPassTime()) {
			movementList = ticketOffice.getMovementList();
			clock.updateTime();
		}
	}
	private boolean isToMoveToPlatform() {
		if (movementList == null)
			this.isToMoveToPlatform = false;
		else if (movementList.size() > 0)
			this.isToMoveToPlatform = true;
		
		return this.isToMoveToPlatform;
	}
	
	
	// 3
	private void makeReport () {
		if (platform.getVolumeOfTraffic() >= customerInfo.size()) {
			Start.elapsedTime = System.currentTimeMillis() - Start.startTime;
			StationMaster.analyze(customerInfo, strategyNumber).report(Start.REPORT_PATH);
			Start.flag = true;
		}
	}

	

	
	// etc.
	private void setCustomerInfo(Parser parser) {
		customerInfo = parser.getCreations();
	}
	private List<Customer> getLatestCustomerInfo() {
		List<Customer> subList = new ArrayList<Customer>();
		for (Customer customer : customerInfo)
			if (customer.getArrivalTimeAtTicketOffice() == Start.presentTime)
				subList.add(customer);
		return subList;		
	}
	

}
