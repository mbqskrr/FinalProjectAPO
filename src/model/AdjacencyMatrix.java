package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class AdjacencyMatrix<T> implements IGraph<T>{
	
	 /**
     * The length of the matrix when using the default Constructor.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The rate at which the matrix's length increases as it becomes full.
     */
    private static final double GROWTH_FACTOR = 1.5;

    /**
     * The last index in the matrix at which a vertex exists.
     */
    private int size; //logic size

    /**
     * Indicates whether the graph represented by the matrix is directed.
     */
    private boolean isDirected;

    /**
     * The matrix itself.
     */
    private double[][] adjacencyMatrix;

    /**
     * The associated matrix containing the weight of all edged between nodes in the graph.
     */
    private double[][] adjacencyMatrixWeight;

    /**
     * A Map that accesses any vertex in the graph through its index in the matrix.
     */
    private Map<Integer, T> vertices;

    /**
     * A Map that uses any vertex as a key to access its corresponding index in the matrix.
     */
    private Map<T, Integer> verticesIndices;

    /**
     * A Set that contains ordered non-duplicate Integers of empty row/columns in the matrix whose values are lesser
     * than the logical size.
     */
    private NavigableSet<Integer> emptySlots = new TreeSet<>();

    /**
     * Constructs a new, empty matrix of double values of default length, along with two Map objects that interconnect
     * vertices to their indices in the matrix and indices in the matrix to their vertices.
     */
    public AdjacencyMatrix() {
        initialize(DEFAULT_CAPACITY);
    }

    /**
     * Constructs a new, empty matrix of double values of default length, along with two Map objects that interconnect
     * vertices to their indices in the matrix and indices in the matrix to their vertices. The graph represented by the
     * matrix is directed if id is true.
     *
     * @param id a boolean that indicates the graph is directed when true.
     */
    public AdjacencyMatrix(boolean id) {
        initialize(DEFAULT_CAPACITY);
        isDirected = id;
    }

    /**
     * Constructs a new, empty matrix of double values of default length, along with two Map objects that interconnect
     * vertices to their indices in the matrix and indices in the matrix to their vertices.
     *
     * @param capacity the initial size of the adjacency matrix
     */
    public AdjacencyMatrix(int capacity) {
        initialize(capacity);
    }

    /**
     * Constructs a new, empty matrix of double values of default length, along with two Map objects that interconnect
     * vertices to their indices in the matrix and indices in the matrix to their vertices. The graph represented by the
     * matrix is directed if id is true.
     *
     * @param id       a boolean that indicates the graph is directed when true.
     * @param capacity the initial size of the adjacency matrix
     */
    public AdjacencyMatrix(boolean id, int capacity) {
        initialize(capacity);
        isDirected = id;
    }

    /**
     * Auxiliary method used by the Constructor to set values to the class' fields. Creates the adjacency matrix.
     *
     * @param capacity the initial size of the adjacency matrix
     */
    private void initialize(int capacity) {
        isDirected = false;
        size = 0;
        adjacencyMatrix = new double[capacity][capacity];
        vertices = new HashMap<>();
        verticesIndices = new HashMap<>();
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

	public int getIndex(T vertex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T search(T A) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T search(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
