package ui;

import java.util.ArrayList;

public class Graph {
	
	private ArrayList<Node>nodes;
	
	public Graph() {
		nodes = new ArrayList<Node>();
	}
	
	public void add(double x,double u) {
		nodes.add(new Node(x,u));
	}
	
	

}
