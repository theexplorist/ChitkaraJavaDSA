package Graph2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {

	static class Graph {

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

		private int[] indegree() {
			// TODO Auto-generated method stub
			int[] indegree = new int[V];
			for (int v = 0; v < V; v++) {
				List<Integer> neighbours = adjList.getOrDefault(v, new ArrayList<>());
				for (int neighbour : neighbours) {
					indegree[neighbour]++;
				}
			}

			return indegree;
		}

		public boolean canFinish(int numCourses, int[][] prerequisites) {
			int[] indegree = indegree();
			Queue<Integer> bfs = new LinkedList<>();
			for (int v = 0; v < V; v++) {
				if (indegree[v] == 0) {
					bfs.add(v);
				}
			}

			int count = 0;
			while (!bfs.isEmpty()) {
				int front = bfs.poll();
				System.out.print(front + " ");

				count++;
				List<Integer> neighbours = adjList.getOrDefault(front, new ArrayList<>());
				for (int neighbour : neighbours) {
					indegree[neighbour]--;
					if (indegree[neighbour] == 0) {
						bfs.add(neighbour);
					}
				}
			}
			System.out.println(count);
			return count == numCourses;
		}
	}
	
	public static void main(String[] args) {
		int numCourses = 4;
		int[][] pre = {{2, 0}, {2, 1}, {3, 2}};
		Graph g = new Graph(numCourses);
		
		for(int i = 0; i < pre.length; i++) {
			g.addEdge(pre[i][1], pre[i][0], false);
		}
		
		g.display();
		System.out.println(g.canFinish(numCourses, pre));
		
	}
}
