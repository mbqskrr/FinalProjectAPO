package model.matrixRepresentation;

/**
 * 
 * @author W-7
 *
 */
public class WeightMatrix {
	private int[][] matrix;
	private int capacity;
	
	/**
	 * Principal contructor
	 * @param capacity number of vertices
	 */
	public WeightMatrix(int capacity) {
		this.capacity = capacity;
		matrix = new int [capacity][capacity];
	}
	
	/**
	 * Empty constructor
	 */
	public WeightMatrix() {
		
	}

	public int getCapacity() {
		return capacity;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
