package Graph3;

import java.util.Arrays;

public class DSUUnoptimised {

	int V;
	private int[] parent;

	public DSUUnoptimised(int V) {
		// TODO Auto-generated constructor stub
		parent = new int[V];
		Arrays.fill(parent, -1);
	}

	private int find(int u) {// O(n)
		// TODO Auto-generated method stub

		if (parent[u] == -1) {
			return u;
		}
		return find(parent[u]);
	}

	private void union(int u, int v) {// O(n)
		// TODO Auto-generated method stub

		// step - 1 gf(u), gf(v)
		// step - 2 gf(u) != gf(v) -> p[gf(u)] = gf(v)
		int godFatherU = find(u);
		int godFatherV = find(v);

		if (godFatherU != godFatherV) {
			parent[godFatherU] = godFatherV;
		}
	}

	private boolean detectCycle(int[][] edgeList) {
		// TODO Auto-generated method stub

		for(int r = 0; r < edgeList.length; r++) {//r rows * O(n) -> O(rn)
			int u = edgeList[r][0];
			int v = edgeList[r][1];
			
			//step - 1 gf(u) and gf(v)
			int godFatherU = find(u);
			int godFatherV = find(v);
			
			//step - 2 gf(u) != gf(v) -> union
			//step - 3 gf(u) == gf(v) -> return cycle hai
			if(godFatherU != godFatherV) {
				union(godFatherU, godFatherV);
			} else {
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		int numV = 7;
		int[][] edgeList = { { 0, 1 }, { 1, 2 }, { 2, 3 }, {4, 5}, {5, 6} };
		DSUUnoptimised dsu = new DSUUnoptimised(numV);
		System.out.println(dsu.detectCycle(edgeList));

	}
}
