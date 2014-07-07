package test;

import java.util.ArrayList;
import java.util.List;

public class ThreadRun {
	
	private int[] list = {1,1,1};
	private List<Integer> result = new ArrayList<Integer>();
	
	private List<Staf> stafList = new ArrayList<Staf>();
	private Object monitor = new Object(); 
	private int total = 0;
	static int count = 0;

		
	public void createStaf() {
		if (stafList.size() != 0) {
			Staf staf;
			for (int i=0; i<3; i++) {
				staf = new Staf(monitor);
				stafList.add(staf);
				staf.start();
			}
		}
	}
	public void putStaf() {
		int i=0;
		for (Staf staf : stafList) {
			staf.put(list[i++]);
		}
	}
	
	
	public void workStaf() {
		synchronized (monitor) {
			monitor.notifyAll();
		}
		for (Staf staf : stafList) {
			try {
				staf.join();			
				result.add(staf.getResult());
				ThreadRun.count++;
			} catch (InterruptedException e) {
				e.printStackTrace();
				// do-nothing
			}
		}
	}
	
	public List<Integer> getResult() {
		return result;
	}
	
	public int getCount() {
		return count;
	}

}
