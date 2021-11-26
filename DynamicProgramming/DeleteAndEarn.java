package DynamicProgramming;

import java.util.Arrays;

public class DeleteAndEarn {

	public int deleteAndEarn(int[] arr) {

		int maxVal = Integer.MIN_VALUE;
		for (int e : arr) {
			maxVal = Math.max(maxVal, e);
		}

		int[] houses = new int[maxVal + 1];
		for (int e : arr) {
			houses[e] += e;
		}

		int[] cache = new int[houses.length + 1];
		Arrays.fill(cache, -1);
		return sol(houses, houses.length, cache);
	}

	private static int sol(int[] houses, int n, int[] cache) {
		// TODO Auto-generated method stub

		if (n <= 0) {
			return 0;
		}

		if (cache[n] != -1) {
			return cache[n];
		}
		int rob = sol(houses, n - 2, cache) + houses[n - 1];
		int dontRob = sol(houses, n - 1, cache);

		return cache[n] = Math.max(rob, dontRob);
	}
}
