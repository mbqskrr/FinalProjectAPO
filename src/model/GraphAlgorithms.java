package model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import model.IGraph;

public class GraphAlgorithms<T> {
	
	private static int[] cost;
	private static boolean[] F;
	
	/**
	 * Performs a breadth-first search to traverse a graph
	 * @param <T> Abstract data type that represent a vertex within the graph
	 * @param g Graph which is going to be traversed
	 * @param v Vertex where it's going to start the BFS
	 * @return A list with a resultant order due to a BFS
	 */
	public static <T> List<T> bfs(IGraph<T> g, T node){
		return traversal(g, node, new Stack<T>());
	}
	
	/**
	 * Performs a depth-first search to traverse a graph
	 * @param <T> Abstract data type that represent a vertex within the graph
	 * @param g Graph which is going to be traversed
	 * @param v Vertex where it's going to start the DFS
	 * @return A list with a resultant order due to a DFS
	 */
	public static <T> List<T> dfs (IGraph<T> g, T node){
		return traversal(g, node, new model.Queue<T>());
	}

	/**
	 * This method will traverse the graph given a data structure. This will perform  BFS or DFS, given the case.
	 * @param g The graph to be traversed.
	 * @param node The vertex from which the traversal will begin.
	 * @param ds The data structure to be used in this traversal. Either a Stack for a DFS or a Queue for BFS.<br>
	 * <pre> ds Must be empty.
	 * @return A List with the resulting traversal performed on the given graph from the given vertex.
	 */
	private static <T> List<T> traversal(IGraph<T> g, T node, ICollection<T> ds){
		List<T> trav = new ArrayList<>();
		//Invariant: Each algorithm adds the given element first. 
		T vertex = node;
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
				List<T> adjacents = g.vertexAdjacent(vertex);
				ds.addAll(adjacents);
			}
		}
		return trav;
	}
	
	/**
<<<<<<< HEAD
	 * minimum path given a vertex of origin towards all others
	 * @param origin
	 * @param g
=======
	 *This method allows to use a Dijkstra algorithm by the matrix matrix
	 * @param origin The starting node
	 * @param weights the weights matrix
	 * @param g the graph
>>>>>>> edf5fbf03ad03ac5cb0c7b44d74d1bdebd9a8a86
	 */
	public static<T> void dijkstra(T origin, IGraph<T> g) {
		double[][] weights = g.weightMatrix(); 
		int index = g.getIndex(origin); 
		int n = g.getVertexSize();
		cost = new int[n];
		F = new boolean[n];
		for (int i = 0; i < n; i++) {
			F[i] = false;
			cost[i] = (int) weights[index][i];
		}
		F[index] = true;
		cost[index] = 0;
		//steps to mark the n-1 vertices
		for (int k = 0; k < n; k++) {
			int v = minimun(n);
			F[v] = true;
			//update distance of unmarked vertices
			for (int i = 0; i < n; i++) {
				if(!F[i]) {
					if (cost[v] + weights[v][i] < cost[i]) {
						cost[i] = (int) (cost[v] + weights[v][i]);
					}
				}
			}
		}
	}
	
	/**
	 * select unmarked vertex shorter distance
	 * @return v
	 */
	private static int minimun(int n) {
		int max = Integer.MAX_VALUE;
		int v = 1;
		for (int j = 0; j < n; j++) {
			if (!F[j] && (cost[j] <= max)) {
				max = cost[j];
				v = j;
			}
		}
		return v;
	}
	
	/**
	 * Implementation of FloydWarshall algorithm
	 * @param g
	 * @return the minimum paths between every vertex
	 */
	public static <T> double[][] floydWarshall(IGraph<T> g) {
		double[][] weightsMatrix = g.weightMatrix();
		for (int i = 0; i < weightsMatrix.length; i++) {
			for (int j = 0; j < weightsMatrix.length; j++) {
				for (int k = 0; k < weightsMatrix.length; k++) {
					if (weightsMatrix[j][i] + weightsMatrix[i][k] < weightsMatrix[j][k]) {
						weightsMatrix[j][k] = weightsMatrix[j][i] + weightsMatrix[i][k];
					}
				}
			}
		}
		return weightsMatrix;
	}
	
	public static <T> List<T> prim(T node){
		return null;
	}
	
	public static <T> List<T> kruskal(PriorityQueue<Double> sortedEdges){
		//PriorityQueue<T> q = new PriorityQueue<T>();
		
		return null;
	}

	public static int[] getCost() {
		return cost;
	}
	
}
