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
	void setUpScenary1() {
		graph = new AdjacencyMatrix<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addEdge("A", "C", 4);
		graph.addEdge("A", "E", 3);
		graph.addEdge("B", "D", 3);
		graph.addEdge("B", "E", 4);
		graph.addEdge("C", "D", 7);
		graph.addEdge("C", "E", 2);
		graph.addEdge("D", "E", 8);
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
	
	@Test
	void dijkstraTest() {
		setUpScenary1();
		GraphAlgorithms.dijkstra("D", graph);
		assertEquals(7, GraphAlgorithms.getCost()[4]);
		assertEquals(0, GraphAlgorithms.getCost()[3]);
		assertEquals(7, GraphAlgorithms.getCost()[2]);
		assertEquals(3, GraphAlgorithms.getCost()[1]);
		assertEquals(10, GraphAlgorithms.getCost()[0]);
	}

}
