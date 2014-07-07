package abstractex;

import java.util.ArrayList;

public class Company {
	
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private static final Company company = new Company();
	private Company() {}
	
	
	public static final Company getInstance() {
		return company;
	}

//	public ArrayList<Vehicle> getVehicles () {
//		return this.vehicles;
//	}
	
	public void addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}

	public int getNumOfVehicles () {
		return this.vehicles.size();
	}
	
	public Vehicle getVehicle (int index) {
		return this.vehicles.get(index);
	}
}
