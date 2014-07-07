package abstractex;

public class Truck extends Vehicle{
	
	private static double amountOfFuelNeeds = 0.0;
	private double distance;
	private double efficiency;
	
	public Truck (double distance, double efficiency) {
		this.distance = distance;
		this.efficiency = efficiency;
	}
	
	public double clacFuelEfficiency() {
		return this.efficiency;
	}
	public double clacTripDistance() {
		return this.distance;
	}
	
	public void calcAmountOfFuelNeeds() {
		Truck.amountOfFuelNeeds += calFuelNeeds();
	}
	
	public static double getAmountOfFuelNeeds () {
		return Truck.amountOfFuelNeeds;
	}

}
