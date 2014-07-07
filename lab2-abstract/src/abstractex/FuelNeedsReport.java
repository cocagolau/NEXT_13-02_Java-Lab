package abstractex;

import java.io.PrintStream;

public class FuelNeedsReport {

	public static final String NEWLINE = System.getProperty ("line.separator");
	Company company = Company.getInstance();
	
	public FuelNeedsReport() {
		calcFuelNeeds();
	}
	
	public String generateText() {
		
		StringBuilder report = new StringBuilder();
		report.append("## Fuel Needs Report ##" + NEWLINE + NEWLINE);
		report.append("Truck Needs : " + getTruckNeeds() + NEWLINE);
		report.append("Barge Needs : " + getBargeNeeds() + NEWLINE);
		report.append("Total Needs : " + getTotalNeeds() + NEWLINE);
		report.append(NEWLINE + "#######################" + NEWLINE);
		
		return report.toString();
	}
	
	public void generateText(PrintStream out) {
		System.out.print (generateText());	
	}

	public void calcFuelNeeds() {
		for (int i=0; i<company.getNumOfVehicles(); i++) {
			company.getVehicle(i).calcAmountOfFuelNeeds();
		}
	}

	public double getTruckNeeds() {
		return Truck.getAmountOfFuelNeeds();
	}
	
	public double getBargeNeeds() {
		return RiverBarge.getAmountOfFuelNeeds();
	}


	public double getTotalNeeds() {
		return getTruckNeeds() + getBargeNeeds();
	}
}
