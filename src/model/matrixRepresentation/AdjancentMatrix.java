package model.matrixRepresentation;

public class AdjancentMatrix {
	
	private int vertex;
	
	private int[][]matrix;
	
	public AdjancentMatrix(int n) {
		n = vertex;
		matrix = new int[n][n];
		for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                matrix[i][j] = 0;
            }
		}
	}
	/**
	 *This method add an edge between two vertex
	 * @param i This represent the first vertex
	 * @param j This represent the second vertex
	 */
	public void add(int i, int j){
	        matrix[i][j] += 1;
	}
	
	/**
	 * THis method remove an edge from the matrix
	 * @param i This represent the first vertex
	 * @param j This represent the second vertex
	 */
	public void remove(int i, int j){
        if(matrix[i][j]>0)
            matrix[i][j] -= 1;
    }
    
	/**
	 * This method show the matrix
	 */
    public String show(){
    	String r = "";
    	int n = matrix.length;
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                r = matrix[i][j] + "  ";        
            }
            r = "";
        }
       return r; 
    }

}
