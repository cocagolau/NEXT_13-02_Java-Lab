package lesson13.thread;

class InterruptTest extends Thread {
	
	public void run() {
		for (int i=0; i<100; i++)
			System.out.println( i+1 + "count before entering non-runnable state.." );
		
		try {
			sleep (1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class InterruptMain {

	public static void main (String[] args) {
		InterruptTest it = new InterruptTest();
		it.start();
		it.interrupt();
	}
}
