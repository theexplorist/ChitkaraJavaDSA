package Graph3;

import java.util.Arrays;

public class DSUOptimised {

	int V;
	private int[] parent;
	private int[] rank;

	private int[] height;
	public DSUOptimised(int V) {
		// TODO Auto-generated constructor stub
		parent = new int[V];
		rank = new int[V];
		height = new int[V];
		Arrays.fill(parent, -1);
		Arrays.fill(rank, 1);
		Arrays.fill(height, 1);
	}

	private int find(int u) {// O(n)//path compression
		// TODO Auto-generated method stub

		if (parent[u] == -1) {
			return u;
		}
		return parent[u] = find(parent[u]);
	}

	private void unionBySetSize(int u, int v) {
		// TODO Auto-generated method stub

		int godFatherU = find(u);
		int godFatherV = find(v);

		if (godFatherU != godFatherV) {

			if (rank[godFatherU] < rank[godFatherV]) {
				// v will be parent of u
				parent[godFatherU] = godFatherV;
				// (u + v) -> v, to v set ki rank update
				rank[godFatherV] += rank[godFatherU];
			} else {
				// u will be parent of v
				parent[godFatherV] = godFatherU;
				// (u + v) -> u, to u set ki rank update
				rank[godFatherU] += rank[godFatherV];
			}
		}
	}

	private void unionByHeight(int u, int v) {
		// TODO Auto-generated method stub

		int godFatherU = find(u);
		int godFatherV = find(v);

		if (godFatherU != godFatherV) {
			
			if(height[godFatherU] < height[godFatherV]) {
				//v will be parent
				parent[godFatherU] = godFatherV;
			} else if(height[godFatherV] < height[godFatherU]) {
				//u will be parent
				parent[godFatherV] = godFatherU;
			} else {
				//both are possible
				parent[godFatherU] = godFatherV;
				//(u + v) = v
				height[v]++;
			}
		}
	}
	

	private boolean detectCycle(int[][] edgeList) {
		// TODO Auto-generated method stub

		for (int r = 0; r < edgeList.length; r++) {// r rows * O(n) -> O(rn)
			int u = edgeList[r][0];
			int v = edgeList[r][1];

			// step - 1 gf(u) and gf(v)
			int godFatherU = find(u);
			int godFatherV = find(v);

			// step - 2 gf(u) != gf(v) -> union
			// step - 3 gf(u) == gf(v) -> return cycle hai
			if (godFatherU != godFatherV) {
				unionBySetSize(godFatherU, godFatherV);
			} else {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int numV = 7;
		int[][] edgeList = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 4, 5 }, { 5, 6 }, {6, 4} };
		DSUOptimised dsu = new DSUOptimised(numV);
		System.out.println(dsu.detectCycle(edgeList));

	}
}
