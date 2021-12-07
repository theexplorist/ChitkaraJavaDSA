package DP5;

public class BS4 {

	public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][k];
        
        for(int i = 0; i <= prices.length; i++) {
            for(int j = 0; j < 2; j++) {
                for(int l = 0; l < k; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        
        return sol(prices, 0, 1, 0, dp, k);
    }
    
    public int sol(int[] prices, int curr, int buy, int k, int[][][] dp, int total) {

		if(k == total|| curr == prices.length) {//atmost 2 transaction
			return 0;
		}
        
        if(dp[curr][buy][k] != -1) {
            return dp[curr][buy][k];
        }
		if(buy == 1) { //buy the stock
			
			int c1 = sol(prices, curr + 1, 0, k, dp, total) - prices[curr];//buy kia curr
			int c2 = sol(prices, curr + 1, buy, k, dp, total);//shayad agle din buy
			
			return dp[curr][buy][k] = Math.max(c1, c2);
		} else { //sell - buy = 0
			int c1 = sol(prices, curr + 1, 1, k + 1, dp, total) + prices[curr];//sell kia curr , increment transaction
			int c2 = sol(prices, curr + 1, buy, k, dp, total);//abhi ni agle din shayad sell
			
			return dp[curr][buy][k] = Math.max(c1, c2);
		}
	}
}
