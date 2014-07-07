package javalab_test;

import javalab.Manager;
import junit.framework.TestCase;

public class test extends TestCase {
	
	public void testEmpolyee () {
		
		Manager man = new Manager();
		man.setName ("Seo");
		man.setSalary (1000.0);
		man.setDepartment ("personal");
		
		System.out.println (man.getDetails());
	}
	
	public void testManager() {
		Manager manager = new Manager();
		manager.name = "Lee";
		manager.department = "personal";
		assertEquals("Lee", manager.getName());
		assertEquals("name : Lee, salary : 0.0, department : personal", manager.getDetails());
	}
	
	public void testM () {
		Manager[] man = new Manager[10];
		for (int i=0; i<10; i++) {
			man[i] = new Manager();
		}
		man[0].setName("A");
		man[0].setSalary(1);
		man[0].setDepartment("a");
		
		man[1].setName("B");
		man[1].setSalary(2);
		man[1].setDepartment("b");
		
		man[2].setName("C");
		man[2].setSalary(3);
		man[2].setDepartment("c");
		
		man[3].setName("D");
		man[3].setSalary(4);
		man[3].setDepartment("d");
		
		man[4].setName("E");
		man[4].setSalary(5);
		man[4].setDepartment("e");
		
		man[5].setName("F");
		man[5].setSalary(6);
		man[5].setDepartment("f");
		
		man[6].setName("G");
		man[6].setSalary(7);
		man[6].setDepartment("g");
		
		man[7].setName("H");
		man[7].setSalary(8);
		man[7].setDepartment("h");
		
		man[8].setName("I");
		man[8].setSalary(9);
		man[8].setDepartment("i");
		
		man[9].setName("J");
		man[9].setSalary(10);
		man[9].setDepartment("j");
		
		for (int i=0; i<10; i++) {
			System.out.println(man[i].getDetails());
		}
		
	}

}
