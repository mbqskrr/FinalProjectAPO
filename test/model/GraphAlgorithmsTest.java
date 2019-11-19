package model;

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
	void setUpScenary2(){
		graph = new AdjacencyMatrix<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("H");
		graph.addVertex("I");
		graph.addVertex("J");
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("A", "D");
		graph.addEdge("B", "E");
		graph.addEdge("B", "F");
		graph.addEdge("C", "G");
		graph.addEdge("C", "H");
		graph.addEdge("G", "I");
		graph.addEdge("G", "J");
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
	
	@Test
	void bfsTest() {
		setUpScenary2();
		assertEquals("A", GraphAlgorithms.bfs(graph, "A").get(0));
		assertEquals("B", GraphAlgorithms.bfs(graph, "A").get(1));
		assertEquals("C", GraphAlgorithms.bfs(graph, "A").get(2));
		assertEquals("D", GraphAlgorithms.bfs(graph, "A").get(3));
		assertEquals("E", GraphAlgorithms.bfs(graph, "A").get(4));
		assertEquals("F", GraphAlgorithms.bfs(graph, "A").get(5));
		assertEquals("G", GraphAlgorithms.bfs(graph, "A").get(6));
		assertEquals("H", GraphAlgorithms.bfs(graph, "A").get(7));
		assertEquals("I", GraphAlgorithms.bfs(graph, "A").get(8));
		assertEquals("J", GraphAlgorithms.bfs(graph, "A").get(9));
		
		IGraph<Integer> g = new AdjacencyMatrix<Integer>();
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addVertex(6);
		g.addVertex(7);
		g.addVertex(8);
		g.addVertex(9);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 5);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		g.addEdge(3, 5);
		g.addEdge(3, 6);
		g.addEdge(5, 4);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(1, 2);
		g.addEdge(4, 7);
		g.addEdge(4, 8);
		g.addEdge(6, 7);
		g.addEdge(6, 9);
		g.addEdge(7, 8);
		g.addEdge(7, 9);
		g.addEdge(8, 9);
		assertEquals(1, GraphAlgorithms.bfs(g, 1).get(0));
		assertEquals(2, GraphAlgorithms.bfs(g, 1).get(1));
		assertEquals(3, GraphAlgorithms.bfs(g, 1).get(2));
		assertEquals(5, GraphAlgorithms.bfs(g, 1).get(3));
		assertEquals(4, GraphAlgorithms.bfs(g, 1).get(4));
		assertEquals(6, GraphAlgorithms.bfs(g, 1).get(5));
		assertEquals(7, GraphAlgorithms.bfs(g, 1).get(6));
		assertEquals(8, GraphAlgorithms.bfs(g, 1).get(7));
		assertEquals(9, GraphAlgorithms.bfs(g, 1).get(8));
	}
	
	@Test
	void dfsTest() {
		setUpScenary2();
		assertEquals("A", GraphAlgorithms.dfs(graph, "A").get(0));
		assertEquals("D", GraphAlgorithms.dfs(graph, "A").get(1));
		assertEquals("C", GraphAlgorithms.dfs(graph, "A").get(2));
		assertEquals("H", GraphAlgorithms.dfs(graph, "A").get(3));
		assertEquals("G", GraphAlgorithms.dfs(graph, "A").get(4));
		assertEquals("J", GraphAlgorithms.dfs(graph, "A").get(5));
		assertEquals("I", GraphAlgorithms.dfs(graph, "A").get(6));
		assertEquals("B", GraphAlgorithms.dfs(graph, "A").get(7));
		assertEquals("F", GraphAlgorithms.dfs(graph, "A").get(8));
		assertEquals("E", GraphAlgorithms.dfs(graph, "A").get(9));
		
		IGraph<Integer> g = new AdjacencyMatrix<Integer>();
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 5);
		g.addEdge(2, 4);
		assertEquals(1, GraphAlgorithms.dfs(g, 1).get(0));
		assertEquals(5, GraphAlgorithms.dfs(g, 1).get(1));
		assertEquals(3, GraphAlgorithms.dfs(g, 1).get(2));
		assertEquals(2, GraphAlgorithms.dfs(g, 1).get(3));
		assertEquals(4, GraphAlgorithms.dfs(g, 1).get(4));
	}

}
