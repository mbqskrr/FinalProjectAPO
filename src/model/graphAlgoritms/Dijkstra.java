package model.graphAlgoritms;

import model.matrixRepresentation.WeightMatrix;

/**
 * 
 * @author W-7
 *
 * @param <T>
 */
public class Dijkstra<T> {
	private int[][] weights;
	private int[] last; // último vértice en el camino
	private int[] cost; // coste mínimo
	private boolean[] F;
	private int n; //numero de vertices
	private int origen;
	
	public Dijkstra(WeightMatrix gm, int o) {
		n = gm.getCapacity();
		origen = o;
		last = new int[n];
		cost = new int[n];
		F = new boolean[n];
	}
	
	public void minimalPath() {
		for (int i = 0; i < n; i++) {
			F[i] = false;
			cost[i] = weights[origen][i];
			last[i] = origen;
		}
		F[origen] = true;
		cost[origen] = 0;
		int v = minimun();
	}

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
