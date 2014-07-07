package javalab_test;

import javalab.Circle;
import javalab.Rectangle;
import javalab.Shape;
import javalab.Triangle;
import junit.framework.TestCase;

public class ShapeTest extends TestCase{
	
	public void testShape () {
		Shape s;
		s = new Circle();
		assertTrue (s instanceof Circle);
		assertEquals ("draw Circle", s.draw());
		
		s = new Rectangle();
		assertTrue (s instanceof Rectangle);
		assertEquals ("draw Rectangle", s.draw());
		
		s = new Triangle();
		assertTrue (s instanceof Triangle);
		assertEquals ("draw Triangle", s.draw());
		
	}
	
	public void testShape1 () {
		
		Shape s = new Shape();
		assertEquals ("draw Circle", s.drawShape(new Circle()));
		assertEquals ("draw Rectangle", s.drawShape(new Rectangle()));
		assertEquals ("draw Triangle", s.drawShape(new Triangle()));
	}

}
