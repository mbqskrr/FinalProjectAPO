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
	private Queue<Node> q;
	private ArrayList<Node> nodes = new ArrayList<Node>();
	
	/**
	 * 
	 */
	public BFS() {
		q = new LinkedList<Node>();
	}
	
	/**
	 * 
	 * @param node
	 */
	public void breadthFirstSearch(Node<T> node) {
		q.offer(node);
		node.setVistied(true);
		while (!q.isEmpty()) {
			Node element = q.poll();
			List<T> neigbours = element.getNeighbours();
			for (int i = 0; i < neigbours.size(); i++) {
				Node n = (Node) neigbours.get(i);
				if (n != null && !n.isVistied()) {
					q.offer(n);
					n.setVistied(true);
				}
			}
		}
	}
}
