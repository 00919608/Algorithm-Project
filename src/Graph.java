import java.util.ArrayList;
/**
 * 
 * @author Tyrell Friend, Tyre King, Sam Allison
 * @verison 2018-3-17
 *
 */
public class Graph {

	private String[][] a;
	/**
	 * 
	 * @param a
	 * string[][], set global string[][] a to parameter pass into graph constructor
	 */
	Graph(String[][] a) {
		this.a = a;
	}
	/**
	 * 
	 * @param v
	 * string v is a vertex
	 * @return
	 * returns adjacent vertices of vertex v
	 */
	public ArrayList<String> getEdgeList(String v) {
		ArrayList<String> graphList2 = new ArrayList<String>();
		graphList2.clear();

		for (int i = 0; i < a.length; ++i) {
			if (v == a[i][0]) {
				int q = i;
				for (int j = 1; j < a[q].length; ++j) {
					if(a[q][j] == null) {
					}
					else {
						graphList2.add(a[q][j]);
					}
				}
			}
		}
		return graphList2;
	}
	/**
	 * 
	 * @return
	 * returns an ArrayList of strings of the vertices in the graph
	 */
	public ArrayList<String> getVertices() {
		ArrayList<String> graphList = new ArrayList<String>();
		for (int i = 0; i < a.length; ++i) {
			graphList.add(a[i][0]);
		}
		return graphList;
	}
	@Override
	/**
	 * @return
	 * return String representation of the graph
	 */
	public String toString() {
		String b = "";
		String c = "";
		String d = "" + '\n';
		for(int i = 0; i < a.length; ++i) {
			for(int j = 1; j < a[i].length; ++j) {
				    if(a[i][j] != null) {
				    	c += a[i][j] + " ";
				    }
			}
			b += a[i][0] + ":" + c;
			b = b + d;
			c = "";
		}
		return b;
	}
}
