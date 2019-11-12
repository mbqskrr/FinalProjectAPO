package model;

import java.util.ArrayList;
import java.util.List;
import collections.ICollection;
import model.IGraph;

public class GraphAlgorithms<T> {
	
	
	
	/**
	 * Performs a breadth-first search to traverse a graph
	 * @param <V> Abstract data type that represent a vertex within the graph
	 * @param g Graph which is going to be traversed
	 * @param v Vertex where it's going to start the BFS
	 * @return A list with a resultant order due to a BFS
	 */
	public List<Node<T>> bfs(IGraph<Node<T>> g, Node<T> node){
		return traversal(g, node, new collections.Stack<Node<T>>());
	}
	
	/**
	 * Performs a depth-first search to traverse a graph
	 * @param <V> Abstract data type that represent a vertex within the graph
	 * @param g Graph which is going to be traversed
	 * @param v Vertex where it's going to start the DFS
	 * @return A list with a resultant order due to a DFS
	 */
	public List<Node<T>> dfs (IGraph<Node<T>> g, Node<T> node){
		return traversal(g, node, new collections.Queue<Node<T>>());
	}

	/**
	 * This method will traverse the graph given a data structure. This will perform  BFS or DFS, given the case.
	 * @param g The graph to be traversed.
	 * @param node The vertex from which the traversal will begin.
	 * @param ds The data structure to be used in this traversal. Either a Stack for a DFS or a Queue for BFS.<br>
	 * <pre> ds Must be empty.
	 * @return A List with the resulting traversal performed on the given graph from the given vertex.
	 */
	private List<Node<T>> traversal(IGraph<Node<T>> g, Node<T> node, ICollection<Node<T>> ds){
		List<Node<T>> trav = new ArrayList<>();
		//Invariant: Each algorithm adds the given element first. 

		Node<T> vertex = node;
		ds.add(vertex);
		
		boolean[] visited = new boolean[g.getVertexSize()];
		
		//Invariant: While the traversal occurs, the given DS to be used will have, at least, one element.
		while(!ds.isEmpty()) {
			 //Invariant: Element added is always retired from the DS
			vertex = ds.poll();
			int indexV = g.getIndex(vertex);
			
			if(!visited[indexV]) {
				trav.add(vertex);
				visited[indexV] = true;
				
				List<Node<T>> adjacents = g.vertexAdjacent(vertex);
				ds.addAll(adjacents);
			}
		}
		return trav;
	}
}
