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
	private boolean vistied;
	private List<T> neighbours;
	
	/**
	 * 
	 * @param data
	 */
	public Node(T data){
		content = data;
		neighbours = new ArrayList<T>();
	}
	
	/**
	 * 
	 * @param neighbourNode
	 */
	public void addNeighbours(T neighbourNode) {
		this.neighbours.add(neighbourNode);
	}

	public List<T> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<T> neighbours) {
		this.neighbours = neighbours;
	}

	public void setVistied(boolean vistied) {
		this.vistied = vistied;
	}

	public boolean isVistied() {
		return vistied;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
	
}
