package DynamicProgramming;

import java.util.Arrays;

public class Knapsack01 {

	//curr, capacity -> 2D
	private static int sol(int[] price, int[] weight, int n, int curr, int capacity, int[][] cache) {
		// TODO Auto-generated method stub

		if(capacity == 0 || curr == n) {
			return 0;
		}
		if(cache[curr][capacity] != -1) {
			return cache[curr][capacity];
		}
		int pick = 0; 
		
		if(weight[curr] <= capacity) {
			pick = sol(price, weight, n, curr + 1, capacity - weight[curr], cache) + price[curr];
		} 
		
		int dontPick = sol(price, weight, n, curr + 1, capacity, cache);
		
		return cache[curr][capacity] = Math.max(pick, dontPick);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] wt = {1, 2, 3, 2, 2};
		int[] price = {8, 4, 0, 5, 3};
		
		int n  = 5, cap = 4;
		
		int[][] cache = new int[n + 1][cap + 1];//curr(n) * capacity(cap)
		for(int[] row : cache) {
			Arrays.fill(row, -1);
		}
		System.out.println(sol(price, wt, n, 0, cap, cache));
	}

}
