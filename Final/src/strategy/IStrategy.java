package strategy;

import element.WaitingLine;

public interface IStrategy {
	public void sendToStaff(WaitingLine waitingLine);
}
