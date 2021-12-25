package Graph2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {

	// vertex vs list of neighbours
	int V;
	Map<Integer, List<Integer>> adjList;

	public Graph(int V) {
		// TODO Auto-generated constructor stub
		this.V = V;
		this.adjList = new HashMap<>();
	}

	// u and v mein edge banaega
	// isBidir = true, u -> v, v -> u | false, u -> v
	private void addEdge(int u, int v, boolean isBidir) {
		// TODO Auto-generated method stub

		// u = 1, v = 2
		// 1 -> 2
		List<Integer> neighbourU = adjList.getOrDefault(u, new ArrayList<>());
		neighbourU.add(v);
		adjList.put(u, neighbourU);

		if (isBidir) {
			// v -> u
			// 2 -> 1

			List<Integer> neighbourV = adjList.getOrDefault(v, new ArrayList<>());
			neighbourV.add(u);
			adjList.put(v, neighbourV);
		}
	}

	private void display() {
		// TODO Auto-generated method stub

		// number of keys/vertices
		// int numVertices = adjList.size();

		for (int vertex : adjList.keySet()) {
			// vertex -> []
			System.out.println(vertex + "->" + adjList.get(vertex));
		}

	}

	private void bFS(int src) {
		// TODO Auto-generated method stub

		Queue<Integer> q = new LinkedList<>();
		Set<Integer> vis = new HashSet<>();
		q.add(src);
		vis.add(src);

		while (!q.isEmpty()) {
			int front = q.poll();
			System.out.print(front + " ");

			List<Integer> neighbourList = adjList.getOrDefault(front, new ArrayList<>());

			for (int neighbour : neighbourList) {
				if (!vis.contains(neighbour)) {
					q.add(neighbour);
					vis.add(neighbour);
				}
			}
		}
	}

	private void SSSP(int src) {
		// TODO Auto-generated method stub

		Map<Integer, Integer> dis = new HashMap<>();
		for (int v = 1; v <= V; v++) {
			dis.put(v, Integer.MAX_VALUE);
		}

		dis.put(src, 0);
		Queue<Integer> q = new LinkedList<>();
		q.add(src);

		while (!q.isEmpty()) {
			int front = q.poll();
			List<Integer> neighbourList = adjList.getOrDefault(front, new ArrayList<>());
			for (int neighbour : neighbourList) {
				if (dis.get(neighbour) == Integer.MAX_VALUE) {
					q.add(neighbour);
					int frontKaDis = dis.get(front);
					int neighbourKaDis = frontKaDis + 1;
					dis.put(neighbour, neighbourKaDis);
					System.out
							.println("Vertex " + neighbour + " is at a distance of " + neighbourKaDis + " from " + src);
				}
			}
		}
	}

	public void dfsHelper(int src) {
		// TODO Auto-generated method stub
		dfs(src, new HashSet<>());
	}

	private void dfs(int src, Set<Integer> vis) {
		// TODO Auto-generated method stub

		System.out.print(src + " ");
		vis.add(src);

		List<Integer> neighbours = adjList.getOrDefault(src, new ArrayList<>());

		for (int neighbour : neighbours) {
			if (!vis.contains(neighbour)) {
				dfs(neighbour, vis);
			}
		}
	}

	private void bFSConn(int src, Set<Integer> vis) {
		// TODO Auto-generated method stub

		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		vis.add(src);

		while (!q.isEmpty()) {
			int front = q.poll();
			System.out.print(front + " ");

			List<Integer> neighbourList = adjList.getOrDefault(front, new ArrayList<>());

			for (int neighbour : neighbourList) {
				if (!vis.contains(neighbour)) {
					q.add(neighbour);
					vis.add(neighbour);
				}
			}
		}
	}
	private void connectedComponenets() {
		// TODO Auto-generated method stub

		Set<Integer> vis = new HashSet<>();
		int count = 1;
		for(int v = 1; v <= V; v++) {
			if(!vis.contains(v)) {
				
				System.out.print("CC " + count + " -> ");
				
				bFSConn(v, vis);
				count++;
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		Graph g = new Graph(10);
		g.addEdge(1, 2, true);// undirected(bidir) edge
		g.addEdge(1, 3, true);
		g.addEdge(2, 4, true);
		g.addEdge(3, 4, true);
		g.addEdge(3, 5, true);
		g.addEdge(5, 6, true);
		g.addEdge(7, 8, true);
		g.addEdge(9, 10, true);
		//g.addEdge(6, 7, false);
//		// g.addEdge(8, 9, true);
//		g.display();
//		g.SSSP(4);
//		g.addEdge(0, 1, true);
//		g.addEdge(0, 3, true);
//		g.addEdge(0, 8, true);
//		
//		g.addEdge(1, 7, true);
//		g.addEdge(2, 3, true);
//		g.addEdge(2, 5, true);
//		g.addEdge(2, 7, true);
//		g.addEdge(5, 6, true);
//		g.addEdge(3, 4, true);
//		g.addEdge(4, 8, true);
		//g.addEdge(9, 10, true);
		g.display();
		g.connectedComponenets();
	}
}
