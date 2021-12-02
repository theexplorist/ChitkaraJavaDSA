package DynamicProg3;

import java.util.Arrays;

public class DominoAndTrominoTilling {

	 public int numTilings(int n) {
	        int[][] dp = new int[n + 1][3];
	        
	        for(int[] row : dp) {
	            Arrays.fill(row, -1);
	        }
	        return sol(n, 0, dp);
	    }
	    
	    public int sol(int n, int flag, int[][] dp) {
	        
	        if(n == 0 && flag == 0) {
	            return 1;
	        } 
	        
	        if(n <= 0) {
	            return 0;
	        }
	        
	        if(dp[n][flag] != -1) {
	            return dp[n][flag];
	        }
	        long ways = 0;
	        if(flag == 0) {
	            ways += sol(n - 1, 0, dp);
	            
	            ways += sol(n - 2, 0, dp);
	            ways += sol(n - 1, 1, dp);
	            ways += sol(n - 1, 2, dp);
	                        
	        } else if(flag == 1) {
	            ways += sol(n - 2, 0, dp);
	            ways += sol(n - 1, 2, dp);
	        } else {
	            ways += sol(n - 2, 0, dp);
	            ways += sol(n - 1, 1, dp);
	        }
	        
	        return dp[n][flag] = (int)(ways % 1000000007);
	    }
}
