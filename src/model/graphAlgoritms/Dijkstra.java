package model.graphAlgoritms;

import model.matrixRepresentation.WeightMatrix;

/**
 * Class that implement Dijkstra algorithm
 * @author W-7
 *
 * @param <T>
 */
public class Dijkstra<T> {
	private int[][] weights;
	private int[] last; // last vertex on the path
	private int[] cost; // minims cost
	private boolean[] F;
	private int n; //number og vertices
	private int origin;
	
	/**
	 * Constructor method
	 * @param wm weghts matrix
	 * @param o origin vertex
	 */
	public Dijkstra(WeightMatrix wm, int o) {
		n = wm.getCapacity();
		origin = o;
		weights = wm.getMatrix(); 
		last = new int[n];
		cost = new int[n];
		F = new boolean[n];
	}
	
	/**
	 * minimum path given a vertex of origin towards all others
	 */
	public void minimalPath() {
		for (int i = 0; i < n; i++) {
			F[i] = false;
			cost[i] = weights[origin][i];
			last[i] = origin;
		}
		F[origin] = true;
		cost[origin] = 0;
		int v = minimun();
		F[v] = true;
		//update distance of unmarked vertices
		for (int i = 1; i < n; i++) {
			if(!F[i]) {
				if (cost[v] + weights[v][i] < cost[i]) {
					cost[i] = cost[v] + weights[v][i];
					last[i] = v;
				}
			}
		}
	}
	
	/**
	 * select unmarked vertex shorter distance
	 * @return v
	 */
	private int minimun() {
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
	
}
