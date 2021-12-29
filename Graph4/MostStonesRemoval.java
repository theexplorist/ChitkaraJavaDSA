package Graph4;

import java.util.Arrays;

public class MostStonesRemoval {

	// static int numComp;
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
			return parent[u] = find(parent[u]);
		}

		private int union(int u, int v) {// O(n)
			// TODO Auto-generated method stub

			// step - 1 gf(u), gf(v)
			// step - 2 gf(u) != gf(v) -> p[gf(u)] = gf(v)
			int godFatherU = find(u);
			int godFatherV = find(v);

			// v ko u ka parent
			if (godFatherU != godFatherV) {
				parent[godFatherU] = godFatherV;
				return 1;//1 union ho gya hai

			}

			return 0;//abhi union ni hua j, i mein
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
					union(godFatherU, godFatherV);
				} else {
					return true;
				}
			}

			return false;
		}
	}

	public int removeStones(int[][] stones) {

		int numComp = stones.length;
		DSUUnoptimised dsu = new DSUUnoptimised(stones.length);
		for (int i = 0; i < stones.length - 1; i++) {
			for (int j = i + 1; j < stones.length; j++) {
				int[] v1 = stones[i]; // {0, 0}, r = 0, c = 0
				int[] v2 = stones[j]; // {0, 2}, r = 0, c = 2

				// union krne ki 2 condns
				// ya to row equal ya to col
				// gf(v1) != gf(v2)

				if (v1[0] == v2[0] || v1[1] == v2[1]) {

//					int godFatherV1 = dsu.find(i);//i = 0 means vertex 0
//					int godFatherV2 = dsu.find(j);//j = 1 means vertex 1
//					
//					if(godFatherV1 != godFatherV2) {
//						
//						
//						dsu.union(godFatherV2, godFatherV1);//dsu.union(j, i) -> yaani i ko j ka parent
//					}

					
					numComp = numComp - dsu.union(j, i);
				}
			}
		}
		
		return stones.length - numComp;
	}
}
