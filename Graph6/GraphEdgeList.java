package Graph6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphEdgeList {

	class Edge {
		int u, v, wt;

		public Edge(int u, int v, int wt) {
			this.u = u;
			this.v = v;
			this.wt = wt;
		}
	}

	int numV;
	List<Edge> edgeList;

	public GraphEdgeList(int numV) {
		// TODO Auto-generated constructor stub
		this.numV = numV;
		this.edgeList = new ArrayList<>();
	}

	private void addEdge(int u, int v, int wt) {
		// TODO Auto-generated method stub

		edgeList.add(new Edge(u, v, wt));
	}

	private void sol(int src) {
		// TODO Auto-generated method stub
		int[] dis = new int[numV];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[src] = 0;
		for (int iter = 1; iter <= numV - 1; iter++) {

			for (Edge edge : edgeList) {
				// u se start or v pe end
				if (dis[edge.u] != Integer.MAX_VALUE && dis[edge.v] > dis[edge.u] + edge.wt) {
					dis[edge.v] = dis[edge.u] + edge.wt;
				}
			}

		}
		
		for (Edge edge : edgeList) {
			// u se start or v pe end
			if (dis[edge.u] != Integer.MAX_VALUE && dis[edge.v] > dis[edge.u] + edge.wt) {
				System.out.println("Kyun negativity faila raha hai!");
				break;
			}
		}

		for (int i = 0; i < numV; i++) {
			System.out.println("dis of " + i + " from " + src + " is " + dis[i]);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GraphEdgeList g = new GraphEdgeList(6);
		g.addEdge(0, 1, 10);
		g.addEdge(0, 2, 20);
		g.addEdge(1, 3, 20);
		g.addEdge(2, 4, 15);
		g.addEdge(1, 4, 15);
		g.addEdge(3, 5, 30);
		g.addEdge(4, 5, 10);
		g.addEdge(4, 0, -30);
		g.sol(0);

	}

}
