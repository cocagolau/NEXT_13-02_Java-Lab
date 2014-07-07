package inheritance;

public class Shape {
	public String draw() {
		return "Shape";
	}

	public String drawShape(Shape shape) {
		return "draw " + shape.draw();
	}
}
