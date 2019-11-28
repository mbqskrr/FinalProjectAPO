package ui;

public class Path {
	
	private String n1;
	
	private String n2;
	
	private double weight;

	public Path(String n1, String n2, double weight) {
		this.n1 = n1;
		this.n2 = n2;
		this.weight = weight;
	}
	public Path(String n1, String n2) {
		this.n1 = n1;
		this.n2 = n2;
	}
	public String getN1() {
		return n1;
	}
	public void setN1(String n1) {
		this.n1 = n1;
	}

	public String getN2() {
		return n2;
	}
	public double getWeight() {
		return weight;
	}

	

}
