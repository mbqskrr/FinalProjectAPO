package ui;

public class Path {
	
	private Node n1;
	
	private Node n2;
	
	private double weight;

	public Path(Node n1, Node n2, double weight) {
		super();
		this.n1 = n1;
		this.n2 = n2;
		this.weight = weight;
	}

	public Node getN1() {
		return n1;
	}

	public Node getN2() {
		return n2;
	}

	public double getWeight() {
		return weight;
	}
	
	

}
