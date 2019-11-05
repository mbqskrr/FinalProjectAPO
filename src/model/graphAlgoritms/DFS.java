package model.graphAlgoritms;

import java.util.List;
import java.util.Stack;

import model.Node;

/**
 * DFS algorithm with neighbours list 
 * @author Manuel Balanta
 * Universidad ICESI
 *
 */
public class DFS <T>{
	
	/**
	 * Empty constructor
	 */
	public DFS() {
		
	}

	/**
	 * 
	 * @param node
	 */
	@SuppressWarnings("unchecked")
	public void recursiveDFS(Node<T> node) {
		List<T> neighbours = node.getNeighbours();
		node.setVistied(true);
		for (int i = 0; i < neighbours.size(); i++) {
			Node<T> n = (Node<T>) neighbours.get(i);
			if (n != null && !n.isVistied()) {
				recursiveDFS(n);
			}
		}
	}
	
	/**
	 * 
	 * @param node
	 */
	public void iterativeDFS(Node<T> node) {
		Stack<Node<T>> s = new Stack<Node<T>>();
		s.push(node);
		while (!s.isEmpty()) {
			Node<T> element = s.pop();
			if (!element.isVistied()) {
				element.setVistied(true);
			}
			List<T> neighbours = element.getNeighbours();
			for (int i = 0; i < neighbours.size(); i++) {
				@SuppressWarnings("unchecked")
				Node<T> n = (Node<T>) neighbours.get(i);
				if(n!=null && !n.isVistied()){
					s.push(n);
				}
			}
		}
	}
}
