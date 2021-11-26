package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {

	private static int sol(int[] houses, int n, int[] cache) {
		// TODO Auto-generated method stub

		if(n <= 0) {
			return 0;
		}
		
		if(cache[n] != -1) {
			return cache[n];
		}
		int rob = sol(houses, n - 2, cache) + houses[n - 1];
		int dontRob = sol(houses, n - 1, cache);
		
		return cache[n] = Math.max(rob, dontRob);
	}
	//curr -> 1D
	private static int sol(int[] houses, int curr, int n, int[]cache) {
		// TODO Auto-generated method stub

		if(curr >= n) {
			return 0;
		}
		
		if(cache[curr] != -1) {
			return cache[curr];
		}
		int rob = sol(houses, curr + 2, n, cache) + houses[curr];
		int dontRob = sol(houses, curr + 1, n, cache);
		
		return cache[curr] = Math.max(rob, dontRob);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] houses = {5, 1, 3, 6};
		int n = 4;
		
		int[] cache = new int[n + 1];
		Arrays.fill(cache, -1);
		System.out.println(sol(houses, n, cache));
	}

}
