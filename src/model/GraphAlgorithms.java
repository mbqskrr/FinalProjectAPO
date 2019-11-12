package model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import collections.ICollection;
import model.IGraph;

public class GraphAlgorithms<T> {
	
	private List<Node<T>>[] path;
	private int[] cost;
	private boolean[] F;
	private List<Node<T>>[][] pathMatrix;
	
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
	
	/**
	 * minimum path given a vertex of origin towards all others
	 * @param origin
	 * @param weights
	 * @param g
	 */
	public void dijkstra(Node<T> origin, double[][] weights, IGraph<T> g) {
		int n = weights.length;
		for (int i = 0; i < n; i++) {
			F[i] = false;
			cost[i] = (int) weights[origin.getPointer()][i];
			path[i].add(origin);
		}
		F[origin.getPointer()] = true;
		cost[origin.getPointer()] = 0;
		int v = minimun(weights);
		F[v] = true;
		//update distance of unmarked vertices
		for (int i = 1; i < n; i++) {
			if(!F[i]) {
				if (cost[v] + weights[v][i] < cost[i]) {
					cost[i] = (int) (cost[v] + weights[v][i]);
					Node<T> nodeV = g.search(v);
					path[i].add(nodeV);
				}
			}
		}
	}
	
	/**
	 * select unmarked vertex shorter distance
	 * @return v
	 */
	private int minimun(double[][] weights) {
		int n = weights.length;
		int max = Integer.MAX_VALUE;
		int v = 1;
		for (int i = 1; i < n; i++) {
			if (!F[i] && (cost[i] <= max)) {
				max = cost[i];
				v = i;
			}
		}
		return v;
	}
	
	/**
	 * Implementation of FloydWarshall algorithm
	 * @param weightsMatrix
	 * @return the minimum paths between every vertex
	 */
	public double[][] minimaPaths(double[][] weightsMatrix, IGraph<T> g) {
		for (int i = 0; i < weightsMatrix.length; i++) {
			for (int j = 0; j < weightsMatrix.length; j++) {
				for (int k = 0; k < weightsMatrix.length; k++) {
					if (weightsMatrix[j][i] + weightsMatrix[i][k] < weightsMatrix[j][k]) {
						weightsMatrix[j][k] = weightsMatrix[j][i] + weightsMatrix[i][k];
						Node<T> nodeI = g.search(i);
						pathMatrix[j][k].add(nodeI);
					}
				}
			}
		}
		return weightsMatrix;
	}
	
	public List<Node<T>> prim(Node<T> node){
		return null;
	}
	
	public List<Node<T>> kruskal(PriorityQueue<Double> sortedEdges){
		return null;
	}

	public List<Node<T>>[][] getPathMatrix() {
		return pathMatrix;
	}
	
}
