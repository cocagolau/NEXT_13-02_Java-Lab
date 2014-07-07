package inheritance;

abstract class Unit {
	int x;
	int y;
	
	public void stop() {
		System.out.println ("stop");
	}
	
	public abstract void move ();
}

class Marine extends Unit {
	public void move() {
		System.out.println ("M move");
	}
}

class Tank extends Unit {
	public void move() {
		System.out.println ("T move");
	}
}


public class UnitTest {
	
	public static void main (String[] args) {
		Unit[] units = new Unit[2];
		
		units[0] = new Marine();
		units[1] = new Tank();
		
		for (int i=0; i<units.length; i++) {
			units[i].move();
		}
	}

}
