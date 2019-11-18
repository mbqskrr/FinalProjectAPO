package model;

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
	}
	
	@Test
	void addEdgeTest() {
		fail("Not yet implemented");
		assertTrue(null, true);
	}
	
	@Test
	void searchTest() {
		setUpScenary1();
		assertEquals(true, g.search("Cali"));
	}

}
