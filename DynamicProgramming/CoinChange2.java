package DynamicProgramming;

import java.util.Arrays;

public class CoinChange2 {

public int change(int amount, int[] coins) {
        
        int n = coins.length;
        int[][] cache = new int[amount + 1][n + 1];//amount * n
		for(int[] row : cache) {
			Arrays.fill(row, -1);
		}
        
        return change(amount, n, coins, cache);
        
    }
    
    //n, amount -> 2D
    public int change(int amount, int n, int[] coins, int[][] cache) {
        
        if(amount == 0) {
            return 1;
        }
        
        if(n == 0) {
            return 0;
        }
        
        if(cache[amount][n] != -1) {
            return cache[amount][n];
        }
        int pick = 0;
        if(coins[n - 1] <= amount) {
            pick = change(amount - coins[n - 1], n, coins, cache);
        }
        
        int dontPick = change(amount, n - 1, coins, cache);
        
        return  cache[amount][n] = pick + dontPick;
    }
}
