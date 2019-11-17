package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GraphAlgorithmsTest {
	
	IGraph<String> graph;
	
	@Test
	void setUpScenary() {
		graph = new AdjacencyList<String>();
		graph.weightMatrix();
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
