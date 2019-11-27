package ui;

public class Node {

	private final static double RADIUS = 20;
	private double x;
	private double y;
	private double r;
	private int id;
	
	public Node(double newX, double newY,int newId) {
		x = newX;
		y = newY;
		r = RADIUS;
		id = newId;
	}
	
	
	public Node(double newX, double newY) {
		x = newX;
		y = newY;
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	public int getId() {
		return id;
	}
}