package DP5;

public class BS2 {

	public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
       return sol(prices, 0, 1, dp);
    }
    
    public int sol(int[] prices, int curr, int buy, int[][] dp) {

		if(curr == prices.length) {
			return 0;
		}
        
        if(dp[curr][buy] != -1) {
            return dp[curr][buy];
        }
		if(buy == 1) { //buy the stock
			
			int c1 = sol(prices, curr + 1, 0, dp) - prices[curr];//buy kia curr
			int c2 = sol(prices, curr + 1, buy, dp);//shayad agle din buy
			
			return dp[curr][buy] = Math.max(c1, c2);
		} else { //sell - buy = 0
			int c1 = sol(prices, curr + 1, 1, dp) + prices[curr];//sell kia curr 
			int c2 = sol(prices, curr + 1, buy, dp);//abhi ni agle din shayad sell
			
			return dp[curr][buy] = Math.max(c1, c2);
		}
	}
}
