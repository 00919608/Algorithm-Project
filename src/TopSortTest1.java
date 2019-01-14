import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

//import org.junit.Test;


public class TopSortTest1 {

	@Test
	public void Graph1(){
		String[] [] graphin = {{"c1", "c3"},{"c2","c3"},
				{"c3", "c4", "c5"},
				{"c4", "c5"}, {"c5"}};
		Graph g = new Graph(graphin );
		TopSort t = new TopSort( );
		ArrayList<String> actual = t.dfsTopSort(g);
		ArrayList<String> expected = new ArrayList<String> (Arrays.asList("c2", "c1", "c3", "c4", "c5"));
		System.out.println("Graph 1: ");
		System.out.print(g.toString());
		System.out.print("Sorted Graph: ");
		for(int i = 0; i < actual.size(); ++i) {
			System.out.print(actual.get(i) + " ");
		}
		System.out.println("");
		System.out.print("Expected: ");
		for(int i = 0; i < expected.size(); ++i) {
			System.out.print(expected.get(i) + " ");
		}
		for(int i = 0; i < 2; ++i) {
			System.out.println("");
		}
		assertEquals("dfs should be c2, c1, c3, c4, c5", expected, actual);
	}
	
	@Test
	public void Graph2() {
		String[] [] graphin = {{"c1", "c3"},
				{"c3", "c4", "c5"},
				{"c4", "c5"}, {"c5"}};
		Graph g = new Graph(graphin );
		TopSort t = new TopSort( );
		ArrayList<String> actual = t.dfsTopSort(g);
		ArrayList<String> expected = new ArrayList<String> (Arrays.asList("c1", "c3", "c4", "c5"));
		System.out.println("Graph 2: ");
		System.out.print(g.toString());
		System.out.print("Sorted Graph: ");
		for(int i = 0; i < actual.size(); ++i) {
			System.out.print(actual.get(i) + " ");
		}
		System.out.println("");
		System.out.print("Expected: ");
		for(int i = 0; i < expected.size(); ++i) {
			System.out.print(expected.get(i) + " ");
		}
		for(int i = 0; i < 2; ++i) {
			System.out.println("");
		}
		assertEquals("dfs should be c1, c3, c4, c5", expected, actual);
	}
	
	@Test
	public void Graph3() {
		String[][] graphin = { { "c1", "c3" }, { "c3", "c4", "c5" }, { "c4", "c1", "c5" }, { "c5" } };

		Graph g = new Graph(graphin);
		TopSort t = new TopSort();
		ArrayList<String> actual = t.dfsTopSort(g);
		ArrayList<String> expected = null;
		System.out.println("Graph 3: ");
		System.out.print(g.toString());
		System.out.print("Sorted Graph: ");
		if (actual == null) {
			System.out.println("null");
		} else {

			for (int i = 0; i < actual.size(); ++i) {
				System.out.print(actual.get(i) + " ");
			}
			System.out.println("");
			System.out.print("Expected: " + expected);
			for (int i = 0; i < 2; ++i) {
				System.out.println("");
			}
		}
		if (expected == null)
			System.out.print("Expected: null");
		
		for (int i = 0; i < 2; ++i) {
			System.out.println("");
		}

		assertEquals("dfs should be null", expected, actual);
	}
	
	@Test
	public void Graph4() {
		String[] [] graphin = {{"c1", "c3"},{"c2","c3"},
				{"c3", "c4", "c5"},
				{"c4", "c5"}, {"c5"}, {"c6", "c7"}, {"c7"}};

		Graph g = new Graph(graphin );
		TopSort t = new TopSort( );
		ArrayList<String> actual = t.dfsTopSort(g);
		ArrayList<String> expected =  new ArrayList<String> (Arrays.asList("c6", "c7", "c2", "c1", "c3", "c4", "c5")); 
		System.out.println("Graph 4: ");
		System.out.print(g.toString());
		System.out.print("Sorted Graph: ");
		for(int i = 0; i < actual.size(); ++i) {
			System.out.print(actual.get(i) + " ");
		}
		System.out.println("");
		System.out.print("Expected: ");
		for(int i = 0; i < expected.size(); ++i) {
			System.out.print(expected.get(i) + " ");
		}
		for(int i = 0; i < 2; ++i) {
			System.out.println("");
		}
		assertEquals("dfs should be c6, c7, c2, c1, c3, c4, c5", expected, actual);
	}

	/*@Test
	public void testDFS1() {
		String[] [] graphin = {{"c1", "c3"},{"c2","c3"},
				{"c3", "c4", "c5"},
				{"c4", "c5"}, {"c5"}};
		Graph g = new Graph(graphin );
		TopSort t = new TopSort( );
		ArrayList<String> actual = t.dfsTopSort(g);
		ArrayList<String> expected = new ArrayList<String> (Arrays.asList("c2", "c1", "c3", "c4", "c5")); 
		assertEquals("dfs should be c2, c1, c3, c4, c5", expected, actual);
	}
	
	@Test
	public void testDFS2() {
		String[] [] graphin = {{"c1", "c3"},
				{"c3", "c4", "c5"},
				{"c4", "c5"}, {"c5"}};
		Graph g = new Graph(graphin );
		TopSort t = new TopSort( );
		ArrayList<String> actual = t.dfsTopSort(g);
		ArrayList<String> expected = new ArrayList<String> (Arrays.asList("c1", "c3", "c4", "c5")); 
		assertEquals("dfs should be c1, c3, c4, c5", expected, actual);
	}
	
	@Test
	public void testDFS3() {
		String[] [] graphin = {{"c1", "c3"},
				{"c3", "c4", "c5"},
				{"c4", "c1", "c5"}, {"c5"}};
		Graph g = new Graph(graphin );
		TopSort t = new TopSort( );
		ArrayList<String> actual = t.dfsTopSort(g);
		ArrayList<String> expected = null;
		assertEquals("dfs should be null; graph has a cycle", expected, actual);
	}
	
	@Test
	public void testDFS4() {
		String[] [] graphin = {{"c1", "c3"},{"c2","c3"},
				{"c3", "c4", "c5"},
				{"c4", "c5"}, {"c5"}, {"c6", "c7"}, {"c7"}};
		Graph g = new Graph(graphin );
		TopSort t = new TopSort( );
		ArrayList<String> actual = t.dfsTopSort(g);
		ArrayList<String> expected = new ArrayList<String> (Arrays.asList("c6", "c7", "c2", "c1", "c3", "c4", "c5")); 
		assertEquals("dfs should be c6, c7, c2, c1, c3, c4, c5", expected, actual);
	}
	
	@Test
	public void testSource1() {
		String[] [] graphin = {{"c1", "c3"},{"c2","c3"},
				{"c3", "c4", "c5"},
				{"c4", "c5"}, {"c5"}};
		Graph g = new Graph(graphin );
		TopSort t = new TopSort( );
		ArrayList<String> actual = t.sourceTopSort(g);
		ArrayList<String> expected = new ArrayList<String> (Arrays.asList("c1", "c2", "c3", "c4", "c5")); 
		assertEquals("source should be c1, c2, c3, c4, c5", expected, actual);
	}
	
	@Test
	public void testSource2() {
		String[] [] graphin = {{"c1", "c3"},
				{"c3", "c4", "c5"},
				{"c4", "c5"}, {"c5"}};
		Graph g = new Graph(graphin );
		TopSort t = new TopSort( );
		ArrayList<String> actual = t.sourceTopSort(g);
		ArrayList<String> expected = new ArrayList<String> (Arrays.asList("c1", "c3", "c4", "c5")); 
		assertEquals("source should be c1, c3, c4, c5", expected, actual);
	}
	
	@Test
	public void testSource3() {
		String[] [] graphin = {{"c1", "c3"},
				{"c3", "c4", "c5"},
				{"c4", "c1", "c5"}, {"c5"}};
		Graph g = new Graph(graphin );
		TopSort t = new TopSort( );
		ArrayList<String> actual = t.sourceTopSort(g);
		ArrayList<String> expected = null;
		assertEquals("source should be null; graph has a cycle", expected, actual);
	}
	
	@Test
	public void testSource4() {
		String[] [] graphin = {{"c1", "c3"},{"c2","c3"},
				{"c3", "c4", "c5"},
				{"c4", "c5"}, {"c5"}, {"c6", "c7"}, {"c7"}};
		Graph g = new Graph(graphin );
		System.out.print(g.toString());
		System.out.println("");
		TopSort t = new TopSort( );
		ArrayList<String> actual = t.sourceTopSort(g);
		ArrayList<String> expected = new ArrayList<String> (Arrays.asList( "c1", "c2","c3", "c4", "c5", "c6", "c7")); 
		assertEquals("source should be c1, c2, c3, c4, c5, c6, c7", expected, actual);
	}*/

}