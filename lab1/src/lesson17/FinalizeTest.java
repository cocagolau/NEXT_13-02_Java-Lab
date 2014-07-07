package lesson17;

import java.io.FileWriter;
import java.io.IOException;

public class FinalizeTest {
	
	String filename;
	FileWriter fw = null;
	FinalizeTest (String filename) throws IOException {
		fw = new FileWriter(filename);
	}
	
	public void writeData (String date) throws IOException {
		fw.write(date);
		fw.flush();
	}
	
	
	
	@Override
	protected void finalize() throws Throwable {
		if(fw!=null) {
			fw.close();
		}
		Thread t = Thread.currentThread();
		System.out.println("finalize(): " + t);
		super.finalize();
	}

	public static void main (String[] args) throws IOException, InterruptedException {
		{
			FinalizeTest ft = new FinalizeTest("final.dat");
			ft.writeData("hello");
			Thread t = Thread.currentThread();
			System.out.println("main(): " + t);	
			ft = null;
		}
		
		System.gc();
		Thread.sleep(100);
	}

}
