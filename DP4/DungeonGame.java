package DP4;

public class DungeonGame {

	private static int sol(int[][] cost, int cr, int cc, int er, int ec) {
		// TODO Auto-generated method stub

		if(cr > er || cc > ec) {
			return Integer.MAX_VALUE;
		}
		if(cr == er && cc == ec) {
			return (cost[cr][cc] >= 0) ? 1 : Math.abs(cost[cr][cc]) + 1;
		}
		int c1 = sol(cost, cr + 1, cc, er, ec);//down
		int c2 = sol(cost, cr, cc + 1, er, ec);//right
		
		int initialAm = Math.min(c1, c2) - cost[cr][cc];
		
		return initialAm > 0 ? initialAm : 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
