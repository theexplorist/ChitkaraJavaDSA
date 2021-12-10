package DP6;

import java.util.Arrays;

public class LongestIncreasingPathInMatrix {

public int longestIncreasingPath(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = Integer.MIN_VALUE;
        for(int cr = 0; cr < m; cr++) {
            for(int cc = 0; cc < n; cc++) {
                ans = Math.max(ans, sol(matrix, cr, cc, m - 1, n - 1, -1, new boolean[m][n], dp));
            }
        }
        return ans;
    }
    
    private static int sol(int[][] grid, int cr, int cc, int er, int ec, int prev, boolean[][] vis, int[][] dp) {
		// TODO Auto-generated method stub

		if(cr < 0 || cc < 0 || cr > er || cc > ec  || vis[cr][cc] || prev >= grid[cr][cc]) {
			return 0;
		}
		
        if(dp[cr][cc] != -1) {
            return dp[cr][cc];
        }
		vis[cr][cc] = true;
		//4 choices
		
		//Up
		int c1 = sol(grid, cr - 1, cc, er, ec, grid[cr][cc], vis, dp);
		//Down
		int c2 = sol(grid, cr + 1, cc, er, ec, grid[cr][cc], vis, dp);
		//Left
		int c3 = sol(grid, cr, cc - 1, er, ec,  grid[cr][cc], vis, dp);
		//right
		int c4 = sol(grid, cr, cc + 1, er, ec,  grid[cr][cc], vis, dp);
		
		int path = Math.max(Math.max(c1, c2), Math.max(c3, c4)) + 1;
		vis[cr][cc] = false; //manual undo of heap  changes -> backtracking
        dp[cr][cc] = path;
		return path;
	}
}
