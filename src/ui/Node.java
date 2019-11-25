package ui;

public class Node {

	private final static double RADIUS = 20;
	private double x;
	private double y;
	private double r;
	private String id;
	
	public Node(double newX, double newY,String newId) {
		x = newX;
		y = newY;
		r = RADIUS;
		id = newId;
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		return ""+getId()+" "+getX()+" "+getY();
	}
	public void setId(String id) {
		this.id = id;
	}
}