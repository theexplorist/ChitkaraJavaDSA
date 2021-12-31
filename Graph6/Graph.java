package Graph6;

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

	private boolean cycleDetectDFS(int src, int parent, Set<Integer> vis) {
		// TODO Auto-generated method stub

		vis.add(src);
		
		boolean hasCycle = false;
		for(int neighbour : this.adjList.getOrDefault(src, new ArrayList<>())) {
			if (!vis.contains(neighbour)) {
				hasCycle = cycleDetectDFS(neighbour, src, vis);
				//agar cycle detect ho chuki to aage neighbours check mt kro
				if(hasCycle)
				return hasCycle;
			} else if(neighbour != parent) {
				return true;
			}
		}
		
		return hasCycle;
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

	private boolean hasCycle(int src) {
		// TODO Auto-generated method stub

		Set<Integer> vis = new HashSet<>();
		
		return cycleDetectDFS(src, src, vis);
	}
	
	private boolean bfscycle(int src) {
		// TODO Auto-generated method stub
		int[] parent = new int[V];
		for(int i = 0; i < V; i++) {
			parent[i] = i;
		}
		Queue<Integer> bfs = new LinkedList<>();
		bfs.add(src);
		Set<Integer> vis = new HashSet<>();
		vis.add(src);
		
		while(!bfs.isEmpty()) {
			int front = bfs.poll();
			
			for(int neighbour : adjList.getOrDefault(front, new ArrayList<>())) {
				if(!vis.contains(neighbour)) {
					bfs.add(neighbour);
				    vis.add(neighbour);
				    parent[neighbour] = front;
				} else if(neighbour != parent[front]) {//revisit or parent bhi ni
					return true;
				}
			}
		}
		return false;

	}
	
	private boolean isTree(int src) {
		// TODO Auto-generated method stub
		int[] parent = new int[V];
		for(int i = 0; i < V; i++) {
			parent[i] = i;
		}
		Queue<Integer> bfs = new LinkedList<>();
		bfs.add(src);
		Set<Integer> vis = new HashSet<>();
		vis.add(src);
		
		while(!bfs.isEmpty()) {
			int front = bfs.poll();
			
			for(int neighbour : adjList.getOrDefault(front, new ArrayList<>())) {
				if(!vis.contains(neighbour)) {
					bfs.add(neighbour);
				    vis.add(neighbour);
				    parent[neighbour] = front;
				} else if(neighbour != parent[front]) {//revisit or parent bhi ni
					return false;
				}
			}
		}
		//yahan cycle ni hai
		//check kro conn hai bhi?
		return vis.size() == V;
	}
	public static void main(String[] args) {
//		Graph g = new Graph(5);
//		g.addEdge(0, 1, true);
//		g.addEdge(1, 2, true);
//		g.addEdge(2, 0, true);
//		//g.addEdge(3, 0, true);
//		g.addEdge(4, 5, true);
		//g.addEdge(1, 4, true);
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
//		g.display();
//		System.out.println(g.isTree(0));
		//g.connectedComponenets();
		int n = 5;
		int[][] edgeList = {{0,1},{0,2},{0,3},{1,4}};
		
		Graph g = new Graph(n);
		
		for(int i = 0; i < edgeList.length; i++) {
			int u = edgeList[i][0];
			int v = edgeList[i][1];
			
			g.addEdge(u, v, true);
		}
	}
}
