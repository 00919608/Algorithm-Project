import java.util.ArrayList;
/**
 * @author Tyrell Friend, Tyre King,Sam Allison
 * @version 2018-3-17
 */
public class DAGGen {
	/**
	 * @return
	 * returns arrayList of string[][] arrays
	 * which a represent DAG graph
	 */
	public ArrayList<String[][]> dagMe() {
		String[][] a = {{"c1","c2"},{"c2"},{"c3","c2","c1"},{"c4","c2"},{"c5","c2"}};
		String[][] b = {{"c1","c2"},{"c2"},{"c3","c2"},{"c4","c2","c1"},{"c5","c2"}};
		String[][] c = {{"c1","c2"},{"c2"},{"c3","c2"},{"c4","c2","c1"},{"c5","c2"},{"c6","c2"}};
		String[][] d =  {{"c1","c3"},{"c2","c3"},{"c3"},{"c4","c3","c1"},{"c5","c3"}};
		String[][] e = {{"c1","c4"},{"c2","c4"},{"c3","c4","c6"},{"c4"},{"c5","c4"},{"c6","c4"}};
		String[][] f = {{"c1","c5"},{"c2","c5"},{"c3","c5"},{"c4","c5"},{"c5"},{"c6","c5","c3"}};
		String[][] g = {{"c1","c2"},{"c2"},{"c3","c2"},{"c4","c2","c1"},{"c5","c2"},{"c6","c2"},{"c7","c2"}};
		String[][] h = {{"c1","c2"},{"c2"},{"c3","c2"},{"c4","c2","c1"},{"c5","c2"},{"c6","c2"},{"c7","c2"}};
		String[][] i = {{"c1","c2"},{"c2"},{"c3","c2"},{"c4","c2","c1"},{"c5","c2"},{"c6","c2"},{"c7","c2"}};
		String[][] j =	{{"c1","c3"},{"c2","c3"},{"c3"},{"c4","c3"},{"c5","c2","c7"},{"c6","c3"},{"c7","c3"}};
		
		ArrayList<String[][]> v = new ArrayList<String[][]>();
		v.add(a);
		v.add(b);
		v.add(c);
		v.add(d);
		v.add(e);
		v.add(f);
		v.add(g);
		v.add(h);
		v.add(i);
		v.add(j);
		return v;
	}
	/**
	 * @return
	 * returns arrayList of string[][] arrays
	 * which a represent a cyclic directed graph
	 */
	public ArrayList<String[][]> nonDagMe(){
		ArrayList<String[][]> v = new ArrayList<String[][]>();
		String[][] k = {{"c1","c2"},{"c2","c1"},{"c3"},{"c4","c3"},{"c5","c2","c7"},{"c6","c3"},{"c7","c3"}};
		String[][] l =  {{"c1","c2"},{"c2","c1"},{"c3","c4"},{"c4","c3"},{"c5","c2","c7"},{"c6","c3"},{"c7","c3"}};
		String[][] m = {{"c1","c2"},{"c2","c5"},{"c3"},{"c4","c3"},{"c5","c2","c7"},{"c6","c3"},{"c7","c3"}};
		v.add(k);
		v.add(l);
		v.add(m);
		return v;
	}
	public static void main(String [] args) {
		DAGGen a = new DAGGen();
		TopSort d = new TopSort();
		ArrayList<String[][]> b = a.dagMe();
		for (int i = 0; i < b.size(); i++) {
			System.out.println("i : "+i);
			Graph c = new Graph(b.get(i));
			System.out.println(c.toString());
			d.dfsTopSort(c);
			System.out.println("underneith is source top sort");
			d.sourceTopSort(c);
		}
		
		
		System.out.println("end of dags");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("start of nondags");
		
		
		DAGGen g = new DAGGen();
		TopSort k = new TopSort();
		ArrayList<String[][]> f = g.nonDagMe();
		for(int i = 0; i <f.size(); i++) {
			System.out.println(i);
			Graph c = new Graph(f.get(i));
			System.out.println(c.toString());
			k.dfsTopSort(c);
			System.out.println("underneith is source top sort");
			k.sourceTopSort(c);
		}
	}

}