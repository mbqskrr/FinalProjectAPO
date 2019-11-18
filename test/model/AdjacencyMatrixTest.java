package model;

//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdjacencyMatrixTest {
	
	private AdjacencyMatrix<String> g;
	
	@Test
	void setUpScenary() {
		g = new AdjacencyMatrix<String>();
	}
	
	@Test
	void setUpScenary1() {
		g = new AdjacencyMatrix<String>();
		g.addVertex("Cali");
		g.addVertex("Yumbo");
	}

	@Test
	void addVertexTest() {
		setUpScenary();
		assertEquals(true, g.addVertex("Cali"));
		assertEquals(true, g.addVertex("Yumbo"));
	}
	
	@Test
	void addEdgeTest() {
		setUpScenary1();		
		g.addEdge("Yumbo", "Cali", 3.8);
		assertEquals(true, g.areConnected("Yumbo", "Cali"));
	}
	
	@Test
	void addEdgeTest1() {
		setUpScenary();
		g.addVertex("Madrid");
		g.addVertex("Barcelona");
		g.addEdge("Madrid", "Barcelona");
		assertEquals(true, g.areConnected("Madrid", "Barcelona"));
	}
	
	@Test
	void searchTest() {
		setUpScenary1();
		assertEquals(true, g.search("Yumbo"));
		assertEquals(true, g.search("Cali"));
	}

}
