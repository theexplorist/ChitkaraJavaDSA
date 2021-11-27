package DynamicProgramming2;

public class MinPathSum {

	private static int sol(int[][] cost, int cr, int cc, int er, int ec) {
		// TODO Auto-generated method stub

		if(cr > er || cc > ec) {
			return Integer.MAX_VALUE;
		}
		if(cr == er && cc == ec) {
			return cost[er][ec];
		}
		int c1 = sol(cost, cr, cc + 1, er, ec);
		int c2 = sol(cost, cr + 1, cc, er, ec);
		
		return Math.min(c1, c2) + cost[cr][cc];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
