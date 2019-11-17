package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyList<T> implements IGraph<T>{
	
	/**
	 * Map with all the vertices within the graph.
	 * Key of the map is the Vertex and Value is the position of the vertex in the adjacencyList
	 */
	private Map<T, Integer> vertices;	
	
	/**
	 * A list for each Vertex within the graph which has a list with all its adjacent Vertices 
	 */
	private List<List<T>> adjacencyLists;
	
	/**
	 * Property that say if a graph is directed or not
	 */
	private boolean isDirected;
	
	/**
	 * Basic constructor that is initialized with default values
	 */
	public AdjacencyList() {
		initialize();
	}

	/**
	 * Constructor that gets the value for "isDirected" attribute.
	 * True if the graph is Directed or false if it's Indirected
	 * @param id value to set "isDirected"
	 */
	public AdjacencyList(boolean id) {
		initialize();
		isDirected = id;
	}
	
	/**
	 * Initializes all the data structures for this graph.
	 * Set "isDirected" attribute in false
	 */
	private final void initialize() {
		isDirected = false;
		adjacencyLists = new ArrayList<List<T>>();
		vertices = new HashMap<T, Integer>();
	}

	@Override
	public boolean addVertex(T node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addEdge(T A, T B) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdge(T A, T B, double l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeVertex(T node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeEdge(T A, T B) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> vertexAdjacent(T node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean areConnected(T A, T B) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double[][] weightMatrix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDirected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getVertexSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isWeighted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getIndex(T vertex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T search(T A) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<T, Integer> getVertices() {
		return vertices;
	}

	public List<List<T>> getAdjacencyLists() {
		return adjacencyLists;
	}

	@Override
	public T search(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
