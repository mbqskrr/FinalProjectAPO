package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the node class for the graph
 * @author A00355202
 * @version 1.0
 * Universidad ICESI
 * @param <T>
 */
public class Node<T> {
	/**
	 * This represent the content of the node
	 */
	private T content;
	private List<T> neighbours;
	
	public Node(T data){
		content = data;
		neighbours = new ArrayList<T>();
	}
	
	public void addNeighbours(T neighbourNode) {
		this.neighbours.add(neighbourNode);
	}

	public List<T> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<T> neighbours) {
		this.neighbours = neighbours;
	}

}
