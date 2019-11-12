package model;

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
	private int pointer;
	
	/**
	 * 
	 * @param data
	 */
	public Node(T data){
		content = data;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public int getPointer() {
		return pointer;
	}

	public void setPointer(int pointer) {
		this.pointer = pointer;
	}
	
}
