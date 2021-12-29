package Graph4;

import java.util.Arrays;

public class RedundantConnection {

	static class DSUUnoptimised {

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

		private int[] detectCycle(int[][] edgeList) {
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
					union(godFatherU, godFatherV);
				} else {
					return new int[] {u, v};
				}
			}

			return null;
		}
	}

	public int[] findRedundantConnection(int[][] edges) {

		DSUUnoptimised dsu = new DSUUnoptimised(edges.length + 1);
		return dsu.detectCycle(edges);
	}

}
