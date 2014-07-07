package inheritance;

import junit.framework.TestCase;
import java.util.ArrayList;

public class InheritanceTest extends TestCase{
	
	public void testManager() {
		
		/*Manager manager = new Manager("hoho");
		
		manager.department = "person";
		
		assertEquals("hoho", manager.getName());
		assertEquals("person", manager.getDepartment());
		
//		assertEquals ("name : haha, salary : 0.0", manager.getDetail());
		assertEquals ("name : hoho, salary : 0.0, dept : person", manager.getDetail());*/
	
		
		Employee e = new Employee ("tom");
		System.out.println (e.getDetail());
		assertEquals (10, e.i);
		
		Manager m = new Manager("Ed");
		System.out.println (m.getDetail());
		assertEquals (20, m.i);
		
		
		// oop 의 매우 중요한 성격, 상위 클레스로 하위 클레스를 생성할 수 있음., java만 이럼.
		Employee m2 = new Manager ("jam");
		System.out.println (m2.getDetail());
		assertEquals (10, m2.i);
	}
	
	public void testShape () {
		
		Shape s = new Circle ();
		assertEquals("Circle", s.draw());
		
		s = new Rectangle ();
		assertEquals ("Rectangle", s.draw());
		
		s = new Triangle ();
		assertEquals ("Triangle", s.draw());
		
	}
	
	public void testDrawShape(){
		Shape s = new Shape();
		assertEquals("draw Circle", s.drawShape(new Circle()));
		assertEquals("draw Triangle", s.drawShape(new Triangle()));
		assertEquals("draw Rectangle", s.drawShape(new Rectangle()));
	}
	
	public void testShapeList() {
		
		ArrayList<Shape> list = new ArrayList<Shape>();
		
		Circle c = new Circle();
		Triangle t = new Triangle();
		Rectangle r = new Rectangle();
		
		list.add(c);
		list.add(t);
		list.add(r);
		
		for (int i=0; i<list.size(); i++) {
			Shape s1 = list.get(i);
			
			if (s1 instanceof Circle) {
				Circle c1 = (Circle)s1;
				assertSame (c, c1);
			}
			
			else if (s1 instanceof Triangle) {
				Triangle t1 = (Triangle)s1;
				assertSame (t, t1);
			}
			else {
				Rectangle r1 = (Rectangle)s1;
				assertSame (r, r1);
			}
		}
		
	}
	
	
	
}
