package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
		assertEquals(true, g.addVertex("Tumaco"));
	}
	
	@Test
	void addEdgeTest() {
		setUpScenary1();		
		g.addEdge("Yumbo", "Cali", 3.8);
		assertEquals(true, g.areConnected("Yumbo", "Cali"));
		g.addVertex("Jamundi");
		g.addEdge("Jamundi", "Cali", 100);
		assertTrue("No se encontró la arista", g.areConnected("Jamundi", "Cali"));
	}
	
	@Test
	void addEdgeTest1() {
		setUpScenary();
		g.addVertex("Madrid");
		g.addVertex("Barcelona");
		g.addVertex("Fuenlabrada");
		g.addEdge("Madrid", "Barcelona");
		assertEquals(true, g.areConnected("Madrid", "Barcelona"));
		assertFalse("Encuenta una arista que no esta", g.areConnected("Madrid", "Fuenlabrada"));
	}
	
	@Test
	void searchTest() {
		setUpScenary1();
		assertEquals(true, g.search("Yumbo"));
		assertEquals(true, g.search("Cali"));
		assertFalse("Encuentra un vertice que no esta", g.search("Tumaco"));
	}

}
