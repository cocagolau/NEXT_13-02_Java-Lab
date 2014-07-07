package abstractex;

public abstract class Vehicle {

	public abstract double clacFuelEfficiency();
	public abstract double clacTripDistance();
	public abstract void calcAmountOfFuelNeeds();
	
	public final double calFuelNeeds()
	{
		return clacTripDistance() / clacFuelEfficiency();
	}
	
}