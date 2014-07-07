package strategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import element.Staff;

import simulation.Start;


public abstract class RoutingStrategy  implements IStrategy{
	
	protected List<Staff> restingStaffList = null;
	protected List<Staff> staffList;
	
	protected RoutingStrategy (List<Staff> staffList) {
		this.staffList = staffList;
	}
	public static RoutingStrategy design (int code, List<Staff> staffList) {
		String className = RoutingStrategy.select(code);
		
		Class[] paramTypes = { List.class };
		Object[] args = { staffList };
		Class klass;
		RoutingStrategy strategy = null;
		try {
			klass = Class.forName(Start.STRATEGY_PACKAGE_NAME+className);
			Constructor cons = klass.getConstructor(paramTypes);
			strategy = (RoutingStrategy) cons.newInstance(args);
		}
		catch (ClassNotFoundException cnfe) { cnfe.printStackTrace(); }
		catch (NoSuchMethodException nsme) { nsme.printStackTrace(); }
		catch (SecurityException se) { se.printStackTrace(); }
		catch (InstantiationException ie) { ie.printStackTrace(); }
		catch (IllegalAccessException iae) { iae.printStackTrace(); }
		catch (IllegalArgumentException iaee) { iaee.printStackTrace(); }
		catch (InvocationTargetException ite) { ite.printStackTrace(); }
	
		return strategy;
	}
	
	protected void setRestingStaffList() {
		restingStaffList = new ArrayList<Staff>();
		for (Staff staff : staffList) {
			if (staff.isResting())
				restingStaffList.add(staff);
		}
	}
	protected int getNumberOfRestingStaff() {
		if (restingStaffList == null) return Start.NUMBER_OF_STAFF;
		return restingStaffList.size();
	}
	
	
	
	public static String select (int number) {
		if (number == 1)
			return "RoundRobbin";
		else if (number == 2)
			return "RandomAllocation";
		else
			return "LeastQueueWaiting";
	}
	

}


