package element;

import java.util.List;
import simulation.Start;

public class Platform extends Department {

	private Train train = null;
	private boolean hasTrain = false;
	
	private int volumeOfTraffic = 0;
	private int offset = 0;
	
	// constructor	
	public Platform() {
		super();
	}
	
	// waitingLine
	@Override
	public void putInLine(List<Customer> customers) {
		for (Customer customer : customers)
			customer.setArrivedAtPlatform();
		super.putInLine(customers);
	}
	@Override
	protected List<Customer> getInLine(int number) {
		return super.getInLine(waitingLine.size()-offset);
	}
	

	//processing	
	@Override
	public void process(List<Customer> customers) {
		offset = customers.size();
		super.process(customers);
	}
	@Override
	protected void processingRegardOfTimePassed() {
		if (isAllocatedTime())			
			setTrain();
		else
			train = null;		
	}
	@Override
	protected void processingRegardlessOfTime() {
		if (hasTrain())
			sendToTrain(getInLine(offset));  // 대기라인의 모든 사람을 가져오기
		offset = 0;	
	}	

	private void sendToTrain(List<Customer> customers) {
		train.put(customers);
		train.departFor();
	}


	// time
	private boolean isAllocatedTime() {
		return ( (Start.presentTime % Start.TRAIN_ALLOCATION_TIME) == 0 );
	}
	
	// train
	public int getVolumeOfTraffic() {
		if (hasTrain())	volumeOfTraffic += train.getVolumeOfTraffic();
		return volumeOfTraffic;
	}
	private void setTrain() {
		train = new Train();
		hasTrain = true;
	}
	boolean hasTrain() {
		if (train == null) hasTrain = false;
		return hasTrain;		
	}

}
