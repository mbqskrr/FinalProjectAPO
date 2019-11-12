package model.graphAlgoritms;


/**
 * Class that implement FloydWarshall algorithm
 * @author Manuel Balanta
 * Universidad ICESI
 */
public class FloydWarshall {
	public int[][] pathMatrix;
	
	/**
	 * Constructor that initialize the path matrix
	 * @param wm weights matrix
	 */
	public FloydWarshall(int wm) {
		pathMatrix = new int [wm][wm];
	}
	
	/**
	 * Empty constructor
	 */
	public FloydWarshall() {
		
	}
	
	/**
	 * Implementation of FloydWarshall algorithm
	 * @param weightsMatrix
	 * @return the minimum paths between every vertex
	 */
	public int[][] minimaPaths(int[][] weightsMatrix) {
		for (int i = 0; i < weightsMatrix.length; i++) {
			for (int j = 0; j < weightsMatrix.length; j++) {
				for (int k = 0; k < weightsMatrix.length; k++) {
					if (weightsMatrix[j][i] + weightsMatrix[i][k] < weightsMatrix[j][k]) {
						weightsMatrix[j][k] = weightsMatrix[j][i] + weightsMatrix[i][k];
						pathMatrix[j][k] = i;
					}
				}
			}
		}
		return weightsMatrix;
	}

	public int[][] getPathMatrix() {
		return pathMatrix;
	}
}
