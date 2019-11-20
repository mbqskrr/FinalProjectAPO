package model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import model.IGraph;

public class GraphAlgorithms<T> {
	
	private static double[] cost;
	private static boolean[] F;
	
	/**
	 * Performs a breadth-first search to traverse a graph
	 * @param <T> Abstract data type that represent a vertex within the graph
	 * @param g Graph which is going to be traversed
	 * @param v Vertex where it's going to start the BFS
	 * @return A list with a resultant order due to a BFS
	 */
	public static <T> List<T> bfs(IGraph<T> g, T node){
		return traversal(g, node, new model.Queue<T>());
	}
	
	/**
	 * Performs a depth-first search to traverse a graph
	 * @param <T> Abstract data type that represent a vertex within the graph
	 * @param g Graph which is going to be traversed
	 * @param v Vertex where it's going to start the DFS
	 * @return A list with a resultant order due to a DFS
	 */
	public static <T> List<T> dfs (IGraph<T> g, T node){
		return traversal(g, node, new model.Stack<T>());
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
	 *This method allows to use a Dijkstra algorithm by the matrix matrix
	 * @param origin The starting node
	 * @param g the graph
	 */
	public static<T> void dijkstra(T origin, IGraph<T> g) {
		double[][] weights = g.weightMatrix(); 
		int index = g.getIndex(origin); 
		int n = g.getVertexSize();
		cost = new double[n];
		F = new boolean[n];
		for (int i = 0; i < n; i++) {
			F[i] = false;
			cost[i] = weights[index][i];
		}
		F[index] = true;
		cost[index] = 0;
		//steps to mark the n-1 vertices
		for (int k = 0; k < n; k++) {
			int v = minimum(n);
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
	 * @return v the minimum cost in the array
	 */
	private static int minimum(int n) {
		double max = Integer.MAX_VALUE;
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
	 * @param g the graph
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
	
	public static <T> int prim(T node, IGraph<T> graph){
		double[][] weights = graph.weightMatrix();
		int n = graph.getVertexSize();
		int index = graph.getIndex(node);
		int minLength = 0;
		int z;
		double min;
		double[] cost = new double[n];
		int[] closer = new int[n];
		boolean[] W = new boolean[n];
		for (int i = 0; i < n; i++) {
			W[i] = false;
		}
		W[index] = true;
		for (int i = 0; i < n; i++) {
			if (i != index) {
				cost[i] = weights[index][i];
				closer[i] = 0;
			}
		}
		for (int i = 0; i < n; i++) {
			if (i != index) {
				min = cost[1];
				z = 1;
				for (int j = 0; j < n; j++) {
					if (j != index) {
						if (cost[j] < min) {
							min = cost[j];
							z = j;
						}
					}
				}
				minLength += min;
				W[z] = true;
				cost[z] = Integer.MAX_VALUE;
				for (int j = 0; j < n; j++) {
					if (j != index) {
						if (weights[z][j] < cost[j] && !W[j]) {
							cost[j] = weights[z][j];
							closer[j] = z;
						}
					}
				}
			}
		}
		return minLength;
	}
	
	public static <T> List<T> kruskal(PriorityQueue<Double> sortedEdges){
		
		return null;
	}

	public static double[] getCost() {
		return cost;
	}
	
}
