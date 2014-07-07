package abstractex;

public class RiverBarge extends Vehicle{
	
	private static double amountOfFuelNeeds = 0.0;
	private double distance;
	private double efficiency;
	
	public RiverBarge (double distance, double efficiency) {
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
		RiverBarge.amountOfFuelNeeds += calFuelNeeds();
	}
	
	public static double getAmountOfFuelNeeds () {
		return RiverBarge.amountOfFuelNeeds;
	}

}