package DP5;

public class KnightDialer {

	int[] rC = { -1, -2, -2, -1, 1, 2, 2, 1 };
	int[] cC = { -2, -1, 1, 2, -2, -1, 1, 2 };
    public int knightDialer(int n) {
        
        int[][][] dp = new int[4][3][n  + 1];
        
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int ans = 0;
        for(int r = 0; r < 4; r++) {
            for(int c = 0; c < 3; c++) {
//                 if((r == 3 && c == 0) || (r == 3 && c == 2)) {
                    
//                 } else {
                    
//                 }
                ans = (ans + sol2(r, c, n - 1, dp)) % 1000000007;
            }
        }
       return ans;
    }
    
    private int sol2(int row, int col, int n, int[][][] dp) {
		// TODO Auto-generated method stub

		if (row < 0 || col < 0 || row >= 4 || col >= 3 || (row == 3 && col == 0) || (row == 3 && col == 2)) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}

        if(dp[row][col][n] != -1) {
            return dp[row][col][n];
        }
		int ct = 0;
		for (int i = 0; i < 8; i++) {
			ct = (ct + sol2(row + rC[i], col + cC[i], n - 1, dp)) % 1000000007;
		}

		return dp[row][col][n] = ( ct % 1000000007);
	}
    
    /*
	private int sol(int row, int col, int n) {
		// TODO Auto-generated method stub

		if (row < 0 || col < 0 || row >= 4 || col >= 3 || (row == 3 && col == 0) || (row == 3 && col == 2)) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		int c1 = sol(row - 1, col - 2, n - 1);
		int c2 = sol(row - 2, col - 1, n - 1);
		int c3 = sol(row - 2, col + 1, n - 1);
		int c4 = sol(row - 1, col + 2, n - 1);
		int c5 = sol(row + 1, col - 2, n - 1);
		int c6 = sol(row + 2, col - 1, n - 1);
		int c7 = sol(row + 2, col + 1, n - 1);
		int c8 = sol(row + 1, col + 2, n - 1);

		return c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8;
	}

	private int sol2(int row, int col, int n) {
		// TODO Auto-generated method stub

		if (row < 0 || col < 0 || row >= 4 || col >= 3 || (row == 3 && col == 0) || (row == 3 && col == 2)) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
//		int c1 = sol(row - 1, col - 2, n - 1); i = 0
//		int c2 = sol(row - 2, col - 1, n - 1); i = 1
//		int c3 = sol(row - 2, col + 1, n - 1); i = 2
//		int c4 = sol(row - 1, col + 2, n - 1); i = 3
//		int c5 = sol(row + 1, col - 2, n - 1); i = 4
//		int c6 = sol(row + 2, col - 1, n - 1); i = 5
//		int c7 = sol(row + 2, col + 1, n - 1); i = 6
//		int c8 = sol(row + 1, col + 2, n - 1); i = 7

		int ct = 0;
		for (int i = 0; i < 8; i++) {
			ct = (ct + sol2(row + rC[i], col + cC[i], n - 1)) % 1000000007;
		}

		return ct % 1000000007;
	}
*/
	

}
