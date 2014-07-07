package element;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import simulation.Start;
import strategy.RoutingStrategy;

public class StationMaster {
	private List<Customer> customers;
	private BufferedWriter bw = null;
	static final String TOP_SUBJECT = " [Java-Lab:Final]                       Station Ticketing Simulation";
	static final String TOP_MENU1 = "         고       객        정       보          |      티 켓 팅  정 보     |    열   차    정   보    |";
	static final String TOP_MENU2 = "  ID |   NAME   | 출 발 역  | 도 착 역  |도착시간| 티켓팅 |대기시간|소요시간|대기시간|출발시간|도착시간|";
	
	static final String BOTTOM_MENU1_1 = "                                                 |%5s |%7d |        |%7d |                 |";
	static final String BOTTOM_MENU1_2 = "                                                 |%5s |   %.2f |        |   %.2f |                 |";
	static final String BOTTOM_MENU2 = "          부       가       정       보          -------------------------------------                 |";
	static final String BOTTOM_SIGNATURE = "   core:%2dea. / %.4f sec.                                        Written by Dec7. / (서동규/131036)";

	static final String LINE_SEPARATOR = "--------------------------------------------------------------------------------------------------------";
	
	
	private final String stringFormat = "%4d |%7s |%10s |%10s |%7d |%7d |%7d |%7d |%7d |%7d |%7d |%d";
	private int totalWaitingTimeOfTicketing;
	private int totalWaitingTimeAtPlatform;
	private double averageWaitingTimeOfTicketing;
	private double averageWaitingTimeAtPlatform;
	private String strategyName;
	
	// private constructor
	private StationMaster (List<Customer> customers, int strategyNumber) {
		this.customers = customers;
		this.strategyName = RoutingStrategy.select(strategyNumber);
		setArrivedAtDestination(customers);
	}
	
	private String appendNewLine(String s) {
		return s + System.lineSeparator();
	}
	
	private void setArrivedAtDestination(List<Customer> customers) {
		for (Customer customer : customers)
			customer.setArrivedAtDestination();
	}

	// factory
	public static StationMaster analyze (List<Customer> customers, int strategyNumber) {
		return new StationMaster(customers, strategyNumber);
	}

	public void report(String reportPath) {

		try {
			bw = new BufferedWriter (new FileWriter (reportPath+"-"+strategyName+Start.fileFormat));
			writeTopMenu(bw);
			writeContents(bw);
			wirteBottomMenu(bw);
		}
		catch (IOException ioe) { ioe.printStackTrace(); }
		catch (Exception e) { e.printStackTrace(); }
		
		finally {
			try { bw.close(); }
			catch (IOException ioe) { ioe.printStackTrace(); }
		}
		
	}
	
	private void writeTopMenu(BufferedWriter bw) throws IOException {
		bw.write(appendNewLine(StationMaster.TOP_SUBJECT + "     [" + strategyName +"]"));
//		bw.write(String.format(appendNewLine(StationMaster.TOP_DATE),Calendar.DAY_OF_YEAR,Calendar.DAY_OF_MONTH,0));
		bw.write(appendNewLine(StationMaster.LINE_SEPARATOR));
		bw.write(appendNewLine(StationMaster.TOP_MENU1));
		bw.write(appendNewLine(StationMaster.LINE_SEPARATOR));
		bw.write(appendNewLine(StationMaster.TOP_MENU2));
		bw.write(appendNewLine(StationMaster.LINE_SEPARATOR));
		bw.flush();
	}

	private void writeContents(BufferedWriter bw) throws IOException{
		for (Customer customer : customers) {
			addElement(customer);
			bw.write(String.format(appendNewLine(stringFormat), customer.getId(), customer.getName(), customer.getDepartureStation(), customer.getArrivalStation(), customer.getArrivalTimeAtTicketOffice(), customer.getActualTimeOfTicketing(), customer.getWaitingTimeOfTicketing(), customer.getTimeRequiredForTicketing(), customer.getWaitingTimeAtPlatform(), customer.getDepartureTimeOfTrain(), customer.getArrivalTimeOfTrain(), customer.getTravelTime()));
			bw.flush();
		}
	}
	
	private void wirteBottomMenu(BufferedWriter bw) throws IOException {
		averageElement();  //Bottom_Menu1_2 에서 사용되고 있음
		
		bw.write(appendNewLine(StationMaster.LINE_SEPARATOR));
		bw.write(String.format(appendNewLine(StationMaster.BOTTOM_MENU1_1),"합 계",getTotalWaitingTimeOfTicketing(), getTotalWaitingTimeAtPlatform()));
		bw.write(appendNewLine(StationMaster.BOTTOM_MENU2));
		bw.write(String.format(appendNewLine(StationMaster.BOTTOM_MENU1_2),"평 균",getAverageWaitingTimeOfTicketing(), getAverageWaitingTimeAtPlatform()));
		bw.write(appendNewLine(StationMaster.LINE_SEPARATOR));
		bw.write(String.format(appendNewLine(StationMaster.BOTTOM_SIGNATURE),Start.NUMBER_OF_STAFF,Start.elapsedTime/1000.0));
		bw.flush();
	}


	private void averageElement() {
		averageWaitingTimeOfTicketing();
		averageWaitingTimeAtPlatform();
	}

	private void addElement(Customer customer) {
		addWaitingTimeOfTicketing(customer);
		addWaitingTimeAtPlatform(customer);
	}
	

	
	private double getAverageWaitingTimeAtPlatform() {
		return averageWaitingTimeAtPlatform;		
	}
	private double getAverageWaitingTimeOfTicketing() {
		return averageWaitingTimeOfTicketing;
	}
	
	private void averageWaitingTimeAtPlatform() {
		averageWaitingTimeAtPlatform = (double)getTotalWaitingTimeAtPlatform() / customers.size();		
	}
	private void averageWaitingTimeOfTicketing() {
		averageWaitingTimeOfTicketing = (double)getTotalWaitingTimeOfTicketing() / customers.size();
	}
	
	private int getTotalWaitingTimeAtPlatform() {
		return totalWaitingTimeAtPlatform;
	}
	private int getTotalWaitingTimeOfTicketing() {
		return totalWaitingTimeOfTicketing;
	}
	
	private void addWaitingTimeAtPlatform(Customer customer) {
		totalWaitingTimeAtPlatform += customer.getWaitingTimeAtPlatform();
	}
	private void addWaitingTimeOfTicketing(Customer customer) {
		totalWaitingTimeOfTicketing += customer.getWaitingTimeOfTicketing();
	}


}
