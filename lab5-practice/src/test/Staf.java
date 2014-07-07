package test;


public class Staf extends Thread{
	
	private Object monitor;
	private boolean flag = false;
	private int num;
	
	public Staf (Object monitor) {
		this.monitor = monitor;
	}
	public void put (int num) {
		this.num = num;				
	}
	
	public void run() {
		
		while (!flag) {
			synchronized (monitor) {
				try { monitor.wait(); }
				catch (InterruptedException e) { e.printStackTrace(); }
			}
			if (num == 1)
				num = 0;
		}
	}
	
	public int getResult () {
		return num;
	}	
	
	public void setFlag() {
		if (ThreadRun.count >= 3)
			flag = true;
	}

}
