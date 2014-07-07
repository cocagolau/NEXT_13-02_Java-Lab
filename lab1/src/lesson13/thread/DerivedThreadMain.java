package lesson13.thread;


class PriorityThread extends Thread {
	public void run() {
		int i = 0;
		System.out.println (this.getName());
		System.out.print ("Priority: " + this.getPriority() + " start \t");
		
		while (i<10000) {
			i = i + 1;
			try {
				this.sleep(1);
			}
			catch (Exception e) {
				System.out.println (e);
			}
		}
		System.out.println (this.getName());
		System.out.print ("Priority: " + this.getPriority() + " end \t");
	}
}

public class DerivedThreadMain{
	public static void main(String[] args){
		System.out.println("Start");

		for (int i=Thread.MIN_PRIORITY; i<=Thread.MAX_PRIORITY; i++) {
			PriorityThread pt = new PriorityThread();
			pt.setPriority(i);
			pt.start();
		}
		System.out.println("end");
	}
}
