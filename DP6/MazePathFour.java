package DP6;

public class MazePathFour {

	private static void sol(int cr, int cc, int er, int ec, String path, boolean[][] vis) {
		// TODO Auto-generated method stub

		if(cr < 0 || cc < 0 || cr > er || cc > ec  || vis[cr][cc]) {
			return;
		}
		
		if(cr == er && cc == ec) {
			System.out.println(path);
			return;
		}
		
		vis[cr][cc] = true;
		//4 choices
		
		//Up
		sol(cr - 1, cc, er, ec, path + 'U', vis);
		//Down
		sol(cr + 1, cc, er, ec, path + 'D', vis);
		//Left
		sol(cr, cc - 1, er, ec, path + 'L', vis);
		//right
		sol(cr, cc + 1, er, ec, path + 'R', vis);
		vis[cr][cc] = false; //manual undo of heap  changes -> backtracking
		//return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int m = 3;
		int n = 3;
		sol(0, 0, m - 1, n - 1, "", new boolean[m][n]);
	}

}
