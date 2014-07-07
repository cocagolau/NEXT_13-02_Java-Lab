package lesson13.thread;

class TerminateThread extends Thread {
	private boolean flag = false;
	
	public void run() {
		int count = 0;
		System.out.println ("Start");
		
		while (!flag) {
			try {
				this.sleep(100);
			}
			catch (InterruptedException e){
				
			}
		}
		System.out.println ("End");
	}
	
	public void setFlag (boolean flag) {
		this.flag = flag;
	}
}


public class TerminateThreadMain {

}
