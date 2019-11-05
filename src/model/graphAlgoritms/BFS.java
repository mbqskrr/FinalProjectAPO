package model.graphAlgoritms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import model.Node;
/**
 * 
 * @author W-7
 *
 * @param <T>
 */
public class BFS <T>{
	private Queue<Node<T>> q;
	
	/**
	 * 
	 */
	public BFS() {
		q = new LinkedList<Node<T>>();
	}
	
	/**
	 * 
	 * @param node
	 */
	public void breadthFirstSearch(Node<T> node) {
		q.offer(node);
		node.setVistied(true);
		while (!q.isEmpty()) {
			Node<T> element = q.poll();
			List<T> neighbours = element.getNeighbours();
			for (int i = 0; i < neighbours.size(); i++) {
				@SuppressWarnings("unchecked")
				Node<T> n = (Node<T>) neighbours.get(i);
				if (n != null && !n.isVistied()) {
					q.offer(n);
					n.setVistied(true);
				}
			}
		}
	}
}
