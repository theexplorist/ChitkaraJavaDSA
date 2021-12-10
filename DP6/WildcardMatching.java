package DP6;

import java.util.Arrays;

public class WildcardMatching {

	public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        //?  -> single non empty character
        //* -> 0(empty) or more characters 
        return sol(s, p, s.length(), p.length(), dp) == 1 ? true : false;
    }
    
    private int sol(String s, String p, int n, int m, int[][] dp) {
		// TODO Auto-generated method stub

		if(n == 0) {
			if(m == 0) {
				return 1;
			}
			
			// n == 0 but m != 0, s is empty but p is not empty
			if(p.charAt(m - 1) != '*') {
				return 0;
			} else {
				return dp[n][m] =  sol(s, p, n, m - 1, dp);
			}
		}
		
		if(m == 0) {//s not empty but p is empty
			return 0;
		}
        
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
		if(s.charAt(n - 1) == p.charAt(m - 1) || p.charAt(m - 1) == '?') {
			return dp[n][m] = sol(s, p, n - 1, m - 1, dp);
		} else if(p.charAt( m - 1) == '*') {
			int c1 = sol(s, p, n - 1, m, dp); //match -> 1
			int c2 = sol(s, p, n, m - 1, dp); //no match -> 1
			
			return dp[n][m] = Math.max(c1, c2); //or ka matlab is max in integer
		} else {
			return 0;
		}
	}

}
