
package Graph4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Graph4.DSUOptimised.EdgeList.Edge;

public class DSUOptimised {

	static class EdgeList {
		class Edge {
			int u, v, weight;

			public Edge(int u, int v, int weight) {
				// TODO Auto-generated constructor stub
				this.u = u;
				this.v = v;
				this.weight = weight;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "[" + u + "," + v + "," + weight + "]";
			}
		}

		int numV;
		List<Edge> edgeList;

		public EdgeList(int numV) {
			// TODO Auto-generated constructor stub
			this.numV = numV;
			this.edgeList = new ArrayList<>();
		}

		private void addEdge(int u, int v, int wt) {
			// TODO Auto-generated method stub

			edgeList.add(new Edge(u, v, wt));

		}
	}

	private static int find(int u, int[] parent) {// O(n)//path compression
		// TODO Auto-generated method stub

		if (parent[u] == -1) {
			return u;
		}
		return parent[u] = find(parent[u], parent);
	}

	private static void unionBySetSize(int u, int v, int[]parent, int[] rank) {
		// TODO Auto-generated method stub

		int godFatherU = find(u, parent);
		int godFatherV = find(v, parent);

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

	
	private static int kruskalsAlgorithm(List<Edge> edgeList, int[] parent, int[] rank) {
		// TODO Auto-generated method stub
		
		//Step - 1 -> sort the edges on the basis of weight
		
		Collections.sort(edgeList, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {//o1 -> curr, o2 -> curr + 1
				// TODO Auto-generated method stub
				return o1.weight - o2.weight;
			}
		});
		
		//step - 2 iterate over edgelist
		
		int cost = 0;
		for(Edge currEdge : edgeList) {
			int u = currEdge.u;
			int v = currEdge.v;
			int wt = currEdge.weight;
			
			int godFatherU = find(u, parent);
			int godFatherV = find(v, parent);
			
			if(godFatherU != godFatherV) {
				unionBySetSize(godFatherU, godFatherV, parent, rank);
				cost += wt;
			}
		}
		

		return cost;
	}

	public static void main(String[] args) {
//		int numV = 7;
//		int[][] edgeList = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 4, 5 }, { 5, 6 }, {6, 4} };
//		DSUOptimised dsu = new DSUOptimised(numV);
//		System.out.println(dsu.detectCycle(edgeList));

		EdgeList graph = new EdgeList(5);
		graph.addEdge(0, 3, 2);
		graph.addEdge(0, 4, 12);
		graph.addEdge(3, 2, 2);
		graph.addEdge(4, 2, 7);
		graph.addEdge(3, 1, 6);
		graph.addEdge(1, 2, 1);
		
		int[] parent = new int[5];
		Arrays.fill(parent, -1);
		int[] rank = new int[5];
		Arrays.fill(rank, 1);
		System.out.println(graph.edgeList);
		System.out.println(kruskalsAlgorithm(graph.edgeList, parent, rank));
		System.out.println(graph.edgeList);

	}
}
