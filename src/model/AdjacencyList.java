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
	private Map<Node<T>, Integer> vertices;	
	
	/**
	 * A list for each Vertex within the graph which has a list with all its adjacent Vertices 
	 */
	private List<List<Node<T>>> adjacencyLists;
	
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
		adjacencyLists = new ArrayList<List<Node<T>>>();
		vertices = new HashMap<Node<T>, Integer>();
	}

	@Override
	public boolean addVertex(Node<T> node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addEdge(Node<T> A, Node<T> B) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdge(Node<T> A, Node<T> B, double l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeVertex(Node<T> node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeEdge(Node<T> A, Node<T> B) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<T> vertexAdjacent(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean areConnected(Node<T> A, Node<T> B) {
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

	@SuppressWarnings("rawtypes")
	@Override
	public int getIndex(Node vertex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Node<T> search(Node<T> A) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<T> search(int pointer) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<Node<T>, Integer> getVertices() {
		return vertices;
	}

	public List<List<Node<T>>> getAdjacencyLists() {
		return adjacencyLists;
	}

}
