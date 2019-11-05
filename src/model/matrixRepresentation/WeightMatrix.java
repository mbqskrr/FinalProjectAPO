package model.matrixRepresentation;

public class WeightMatrix {
	private int[][] matrix;
	private int capacity;
	
	public WeightMatrix(int capacity) {
		this.capacity = capacity;
		matrix = new int [capacity][capacity];
	}
	
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
