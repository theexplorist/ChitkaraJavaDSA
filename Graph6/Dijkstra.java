package Graph6;

public class Dijkstra {

	private static void sol(int[][] graph, int src) {
		// TODO Auto-generated method stub
		
		boolean[] vis = new boolean[graph.length];
		vis[src] = true;
		//vis = {0}, 
		//unvis = {1, 2, 3, 4}
		
		int[] dis = new int[graph.length];
		for(int i = 0; i < graph.length; i++) {
			dis[i] = graph[src][i];//dis[i] matlab hai src se i ka distance
		} 
		
		dis[src] = 0;
		System.out.println("Node  chosen is " + src);
		for(int i = 1; i < graph.length; i++) {
			int minDist = Integer.MAX_VALUE;
			int targetV = -1;
			for(int v = 0; v < graph.length; v++) {
				if(!vis[v] && minDist > dis[v]) {
					targetV = v;
					minDist = dis[v];
				}
			}
			
			System.out.println("Node  chosen is " + targetV);
			vis[targetV] = true;
			
			for(int v = 0; v < graph.length; v++) {
				if(!vis[v] && graph[targetV][v] != Integer.MAX_VALUE &&  dis[v] > dis[targetV] + graph[targetV][v]) {
					dis[v] = dis[targetV] + graph[targetV][v];
				}
			}
		}
		
		for(int i = 0; i < graph.length; i++) {
			System.out.println("dis of " + i + " from " + src + " is " + dis[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] conn = { { 0, 5, 10, 0, 0 }, { 5, 0, 3, 11, 0 }, { 10, 3, 0, 2, 0 }, { 0, 11, 2, 0, 3 },
				{ 0, 0, 0, 3, 0 } };
		
		for (int r = 0; r < conn.length; r++) {
			for (int c = 0; c < conn[0].length; c++) {

				if (conn[r][c] == 0) {
					conn[r][c] = Integer.MAX_VALUE;
				}
			}
		}
		
		sol(conn, 1);
	}

}
