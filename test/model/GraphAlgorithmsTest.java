package model;

import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GraphAlgorithmsTest {
	
	IGraph<String> graph;
	
	@Test
	void setUpScenary() {
		graph = new AdjacencyMatrix<String>(false, 5);
		graph.addVertex("Cali");
		graph.addVertex("Yumbo");
		graph.addVertex("Jamundi");
		graph.addVertex("Buenaventura");
		graph.addVertex("Tulua");
		graph.addEdge("Cali", "Yumbo", 15);
		graph.addEdge("Cali", "Jamudi", 11);
		graph.addEdge("Yumbo", "Jamundi", 12);
		graph.addEdge("Yumbo", "Buenaventura", 14);
		graph.addEdge("Yumbo", "Tulua", 1);
		graph.addEdge("Jamundi", "Buenaventura", 3);
		graph.addEdge("Buenaventura", "Tulua", 2);
	}

	@Test
	void floydWarshallTest() {
		setUpScenary();
		//double[][] wm = graph.weightMatrix();
		GraphAlgorithms.floydWarshall(graph);
		
		assertTrue("No se está ejecutando el algoritmo correctamente", graph.weightMatrix()[0][1] == 15);
	}

}
