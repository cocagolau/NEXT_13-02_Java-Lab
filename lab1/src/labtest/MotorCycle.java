package labtest;

public class MotorCycle {
	private int id;
	private int speed;
	private String name;
	
	public MotorCycle () {}
	
	public MotorCycle (int id) {
		this (id, 300);
	}
	
	public MotorCycle (int id, int speed) {
		this (id, speed, "Rooney");
	}
	
	public MotorCycle (int id, int speed, String name) {
		this.id = id;
		this.speed = speed;
		this.name = name;
	}
	
	
	
	public void setData (int id, int speed) {
		this.id = id;
		this.speed = speed;
	}
	
	public void drive () {
		System.out.println ("번호 : " + id);
		System.out.println ("속도 : " + speed);
	}
	
	public MotorCycle returnThis() {
		return this;
	}
}