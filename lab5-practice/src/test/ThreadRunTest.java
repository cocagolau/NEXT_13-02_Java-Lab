package test;

import java.util.List;

import junit.framework.TestCase;

public class ThreadRunTest extends TestCase {
	
	ThreadRun tRun = new ThreadRun();
	List<Integer> result;
	
	public void testMain() {
		tRun.createStaf();
		tRun.putStaf();
		tRun.workStaf();
		
		result = tRun.getResult();
		for (Integer i : result)
			System.out.print(i+", ");
	}

}
