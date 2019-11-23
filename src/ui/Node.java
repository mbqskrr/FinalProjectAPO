package ui;

public class Node {

	private final static double RADIUS = 20;
	private double x;
	private double y;
	private double r;
	
	public Node(double newX, double newY) {
		x = newX;
		y = newY;
		r = RADIUS;
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}