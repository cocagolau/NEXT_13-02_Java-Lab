package element;

import java.util.List;
import utility.Clock;

public abstract class Department {
	protected final boolean LIMITED;
	protected final int QUOTA;
	protected WaitingLine waitingLine = new WaitingLine();
	protected Clock clock = new Clock();
	
	
	// constructor
	public Department() {
		this.QUOTA = -1; // unlimited Quota
		this.LIMITED = false;
	}
	public Department(int quota) {
		this.QUOTA = quota;	
		this.LIMITED = true;
	}

	// abstract
	protected abstract void processingRegardOfTimePassed();
	protected abstract void processingRegardlessOfTime();
	
	// process
	public void process(List<Customer> customers){
		putInLine(customers);
		process();
	}
	public void process() {
		if (clock.isPassTime()) {
			processingRegardOfTimePassed();
			clock.updateTime();
		}
		processingRegardlessOfTime();		
	}
	

	// waitingLine
	protected void putInLine(List<Customer> customers) {
		waitingLine.enQueue(customers);
	}
	protected synchronized List<Customer> getInLine (int number) {
		return waitingLine.deQueue(number);
	}
	
	//size
	int size() {
		return waitingLine.size();
	}
	
}
