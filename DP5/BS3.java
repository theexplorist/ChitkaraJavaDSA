package DP5;

public class BS3 {

	public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][2];
        
        for(int i = 0; i < dp.length; i++) {
            dp[i][0][0] = -1;
            dp[i][0][1] = -1;
            dp[i][1][0] = -1;
            dp[i][1][1] = -1;
        }
        return sol(prices, 0, 1, 0, dp);//k(transaction) = 0
    }
    
     public int sol(int[] prices, int curr, int buy, int k, int[][][] dp) {

		if(k == 2|| curr == prices.length) {//atmost 2 transaction
			return 0;
		}
        
        if(dp[curr][buy][k] != -1) {
            return dp[curr][buy][k];
        }
		if(buy == 1) { //buy the stock
			
			int c1 = sol(prices, curr + 1, 0, k, dp) - prices[curr];//buy kia curr
			int c2 = sol(prices, curr + 1, buy, k, dp);//shayad agle din buy
			
			return dp[curr][buy][k] = Math.max(c1, c2);
		} else { //sell - buy = 0
			int c1 = sol(prices, curr + 1, 1, k + 1, dp) + prices[curr];//sell kia curr , increment transaction
			int c2 = sol(prices, curr + 1, buy, k, dp);//abhi ni agle din shayad sell
			
			return dp[curr][buy][k] = Math.max(c1, c2);
		}
	}
}
