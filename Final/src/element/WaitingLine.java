package element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// queue
public class WaitingLine {
	private List<Customer> waitingLine = new ArrayList<Customer>();
	
	// put
	public void enQueue(Customer customer) {
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(customer);
		enQueue(customers);
	}
	public void enQueue(List<Customer> customers) {
		waitingLine.addAll(customers);
	}
	
	
	// get
	public Customer priority() {
		return waitingLine.get(0);
	}
	public List<Customer> deQueueAll() {
		return deQueue(this.waitingLine.size());
	}
	public List<Customer> deQueue (int number) {
		// 만약 남은 매표소 직원이 대기인원보다 많다고 하더라도 오류가 나지 않도록 보호
		if (number > waitingLine.size())
			number = waitingLine.size();
		
		List<Customer> movementList = new ArrayList<Customer>();
		for (int i=0; i<number; i++)
			movementList.add(waitingLine.remove(0));
		
		return movementList;		
	}
	

	public Iterator<Customer> iterator() {
		return waitingLine.iterator();
	}
	public int size() {
		return waitingLine.size();
	}
	public void init() {
		waitingLine = new ArrayList<Customer>();
	}
	public void sortWaitingLine() {
		Collections.sort(waitingLine);
	}
}
