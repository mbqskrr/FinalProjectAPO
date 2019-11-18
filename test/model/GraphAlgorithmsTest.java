package model;

//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class GraphAlgorithmsTest {
	
	private IGraph<String> graph;
	
	@Test
	void setUpScenary() {
		graph = new AdjacencyMatrix<String>();
		graph.addVertex("Cali");
		graph.addVertex("Yumbo");
		graph.addVertex("Jamundi");
		graph.addVertex("Buenaventura");
		graph.addVertex("Tulua");
		graph.addEdge("Cali", "Yumbo", 15);
		graph.addEdge("Cali", "Jamundi", 11);
		graph.addEdge("Yumbo", "Jamundi", 12);
		graph.addEdge("Yumbo", "Buenaventura", 14);
		graph.addEdge("Yumbo", "Tulua", 1);
		graph.addEdge("Jamundi", "Buenaventura", 3);
		graph.addEdge("Buenaventura", "Tulua", 2);
	}

	@Test
	void floydWarshallTest() {
		setUpScenary();
		GraphAlgorithms.floydWarshall(graph);
		assertEquals(16, graph.weightMatrix()[4][0]); 
		assertNotEquals(Double.MAX_VALUE, graph.weightMatrix()[0][4]);
		assertEquals(14, graph.weightMatrix()[3][0]); 
		assertNotEquals(Double.MAX_VALUE, graph.weightMatrix()[0][3]);
		assertEquals(3, graph.weightMatrix()[1][3]);
		assertNotEquals(14, graph.weightMatrix()[3][1]);
		assertEquals(6, graph.weightMatrix()[1][2]);
		assertNotEquals(12, graph.weightMatrix()[3][0]);
		assertEquals(5, graph.weightMatrix()[2][4]);
		assertNotEquals(Double.MAX_VALUE, graph.weightMatrix()[4][2]);
	}

}
