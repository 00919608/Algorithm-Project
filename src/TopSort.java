import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.HashMap;

/**
 * 
 * @author Tyrell Friend, Tyre King, Sam Allison
 *
 */
public class TopSort {
	private HashMap<String, Integer> treeMap = new HashMap<String, Integer>();
	private Stack<String> stack = new Stack<String>();
	private Stack<String> inOrder = new Stack<String>();
	private ArrayList<String> a = new ArrayList<String>();
	private ArrayList<String> allEdgeList = new ArrayList<String>();
	private int count = 0;

	/**
	 * 
	 * @param b
	 *            Graph Object
	 * @return returns ArraysList that is a topological sorted depth first search of
	 *         the graph
	 */
	public ArrayList<String> dfsTopSort(Graph b) {
		long time = System.nanoTime();
		for (int i = 0; i < b.getVertices().size(); ++i) {
			treeMap.put(b.getVertices().get(i), 0);
		}
		for (int i = 0; i < b.getVertices().size(); ++i) {
			if (treeMap.get(b.getVertices().get(i)) == 0) {
				dfs(b.getVertices().get(i), b);
			}
		}
		time = time - System.nanoTime();
		time = time * -1;
		// System.out.println("dfsTopsort");
		// System.out.println(time);
		// System.out.println();
		if (compareVericesToAllEdgeLists(b) == null) {
			return null;
		}
		return addArrayList(inOrder);
	}

	/**
	 * @param a
	 *            Stack of strings
	 * @return returns a ArrayList of strings by popping strings off the stack and
	 *         adding them to ArrayList
	 */
	public ArrayList<String> addArrayList(Stack<String> a) {
		while (!a.isEmpty()) {
			this.a.add(a.pop());
		}
		return this.a;

	}

	/**
	 * 
	 * @param vertex
	 *            vertex from the graph
	 * @param b
	 *            Graph Object
	 */
	public void dfs(String vertex, Graph b) {
		count += 1;
		treeMap.replace(vertex, count);
		stack.push(vertex);
		for (int i = 0; i < b.getEdgeList(vertex).size(); ++i) {
			if (treeMap.get(b.getEdgeList(vertex).get(i)) == 0) {
				dfs(b.getEdgeList(vertex).get(i), b);
			}
		}
		inOrder.push(stack.pop());
	}

	/**
	 * 
	 * @param b
	 *            Graph Object
	 * @return returns ArrayList<String> which is representation of a Topological
	 *         sorted removal of Graph B
	 */
	public ArrayList<String> sourceTopSort(Graph b) {
		return compareVericesToAllEdgeLists(b);
	}

	/**
	 * 
	 * @param b
	 *            Graph Object
	 * @return returns ArrayList<String> of Topological sorted removal of Graph and
	 *         eliminates edges as the vertices removed
	 */
	public ArrayList<String> compareVericesToAllEdgeLists(Graph b) {
		long time = System.nanoTime();

		ArrayList<String> vertices = new ArrayList<String>();
		for (int i = 0; i < b.getVertices().size(); i++) {
			vertices.add(b.getVertices().get(i));
		}

		ArrayList<String> returnedList = new ArrayList<String>();
		ArrayList<String> allEdges = addAllEdgeLists(b);
		Boolean inList = false;
		int count = 0;
		while (vertices.size() != 0) {
			for (int i = 0; i < b.getVertices().size(); i++) {
				for (int j = 0; j < allEdges.size(); j++) {
					if (b.getVertices().get(i) == allEdges.get(j)) {
						inList = true;
						count++;
						if (count > b.getVertices().size()) {
							return null;
						}
						break;
					}
				}
				if (inList == false) {
					if (vertices.size() == 0) {

					} else {
						returnedList.add(vertices.remove(count));
						count = 0;
						for (int k = 0; k < b.getEdgeList(b.getVertices().get(i)).size(); ++k) {
							if (allEdges.size() == 0) {

							} else
								allEdges.remove(k);
						}
					}
				} else {
					inList = false;
				}

			}
		}

		// time = time - System.nanoTime();
		// time = time * -1;
		// System.out.println("sourceTopSort");
		// System.out.println(time);
		// System.out.println();

		return returnedList;
	}

	/**
	 * 
	 * @param b
	 *            Graph Object
	 * @return returns ArrayList<String> of strings of all the edges in the graph
	 */
	public ArrayList<String> addAllEdgeLists(Graph b) {
		for (int i = 0; i < b.getVertices().size(); ++i) {
			for (int j = 0; j < b.getEdgeList(b.getVertices().get(i)).size(); ++j) {
				allEdgeList.add(b.getEdgeList(b.getVertices().get(i)).get(j));
			}
		}
		return allEdgeList;
	}

}
