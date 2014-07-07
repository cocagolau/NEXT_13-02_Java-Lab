package simulation;

import java.io.File;
import java.io.IOException;

import strategy.RoutingStrategy;

import element.Station;

public class Start {

	public static final String CUSTOMER_INFO_PATH = "final_data" + File.separator + "customerInfo.txt";
	public static final String TRAIN_MAP_PATH = "final_data" + File.separator + "trainMap.txt";
	public static final String TEST_REPORT_PATH = "final_data" + File.separator + "testReport.txt";
	public static final String REPORT_PATH = "final_data" + File.separator + "report";
	public static final String STRATEGY_PACKAGE_NAME = "strategy.";
	public static final String fileFormat = ".txt";

	public static final int TRAIN_ALLOCATION_TIME = 5;
	public static final int NUMBER_OF_STAFF = 3;
	
	public static boolean flag = false;
	public static int presentTime = 0;
	public static long startTime;
	public static long elapsedTime;
	
	
	private String formatter = " %2d. %s";
	
	private int selectStrategy() {
		int strategyNumber = 0;
		System.out.println ("-- RoutingStrategy --");
		for (int i=1; i<4; i++)
			System.out.println (String.format(formatter, i, RoutingStrategy.select(i)));
		
		System.out.println ();
		System.out.print ("Select RoutingStrategy Number : ");
		
		try { strategyNumber = System.in.read() - 48; }
		catch (IOException ioe) { ioe.printStackTrace(); }				
		catch (Exception e) { e.printStackTrace(); }
		
		return strategyNumber;
	}
	
	
	
	public static void main (String[] args) {
		Start start = new Start();
		int strategyNumber = start.selectStrategy();
		Station station = Station.create(Start.CUSTOMER_INFO_PATH, strategyNumber);
		
		Start.startTime = System.currentTimeMillis();
		while (!Start.flag) {
			station.executeSimulation();
			Start.presentTime++;
		}
		
		System.out.println ();
		System.out.println("Station Simulation Complete [" + RoutingStrategy.select(strategyNumber) +"]");
	}
}