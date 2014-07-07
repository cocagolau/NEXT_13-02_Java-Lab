package utility;

import simulation.Start;

public class Clock {

	private int finalUpdateTime = 0;
	
	public boolean isPassTime() {
		return (Start.presentTime > getFinalUpdateTime());
	}
	public int getFinalUpdateTime() {
		return finalUpdateTime;
	}
	public void updateTime() {
		finalUpdateTime = Start.presentTime;
	}
}
