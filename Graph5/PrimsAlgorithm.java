package Graph5;

public class PrimsAlgorithm {

	private static void primsMST(int[][] conn) {
		// TODO Auto-generated method stub
		boolean[] vis = new boolean[conn.length];
		vis[0] = true;

		// vis = {0}
		// unvis = {1, 2, 3, 4, 5, 6, 7, 8}

		int cost = 0;
		for (int v = 1; v < conn.length; v++) {
			int s = 0, e = 0;
			// s -> vis, e -> unvis

			for (int i = 0; i < conn.length; i++) {
				if (vis[i]) {//i = 0, i = 3, i = 4
					for (int j = 0; j < conn.length; j++) {

						if(!vis[j] && conn[i][j] < conn[s][e]) {
							s = i;
							e = j;
						}
					}
				}

			}
			
			System.out.println("chosen edge is : " + s + " " + e);
			vis[e] = true;

			cost += conn[s][e];
		}
		System.out.println(cost);

	}

	public static void main(String[] args) {
		int[][] conn = { { 0, 3, 0, 2, 0, 0, 0, 0, 4 }, // 0 //9*9
				{ 3, 0, 0, 0, 0, 0, 0, 4, 0 }, // 1
				{ 0, 0, 0, 6, 0, 1, 0, 2, 0 }, // 2
				{ 2, 0, 6, 0, 1, 0, 0, 0, 0 }, // 3
				{ 0, 0, 0, 1, 0, 0, 0, 0, 8 }, // 4
				{ 0, 0, 1, 0, 0, 0, 8, 0, 0 }, // 5
				{ 0, 0, 0, 0, 0, 8, 0, 0, 0 }, // 6
				{ 0, 4, 2, 0, 0, 0, 0, 0, 0 }, // 7
				{ 4, 0, 0, 0, 8, 0, 0, 0, 0 } // 8
		};

		for (int r = 0; r < conn.length; r++) {
			for (int c = 0; c < conn[0].length; c++) {

				if (conn[r][c] == 0) {
					conn[r][c] = Integer.MAX_VALUE;
				}
			}
		}

//		for(int r = 0; r < conn.length; r++) {
//			for(int c = 0; c < conn[0].length; c++) {
//				
//				System.out.print(conn[r][c] + " ");
//			}
//			System.out.println();
//		}
		
		primsMST(conn);
	}

}
