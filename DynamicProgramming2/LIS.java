package DynamicProgramming2;

import java.util.Arrays;

public class LIS {

	private static int sol(int[] arr, int prev, int curr, int n, int[][] cache) {
		// TODO Auto-generated method stub

		if(curr == n) {
			return 0;
		}
		
		if(cache[curr][prev + 1] != -1) {
			return cache[curr][prev + 1];
		}
		int inc = 0;
		
		if(prev == -1 || arr[prev] < arr[curr]) {
			inc = sol(arr, curr, curr + 1, n, cache) + 1;
		}
		
		int exc = sol(arr, prev, curr + 1, n, cache);
		
		return cache[curr][prev + 1] = Math.max(inc, exc);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {0, 1, 0, 3, 2, 3};
		int[][] cache = new int[arr.length + 1][arr.length + 1];
		for(int[] row : cache) {
			Arrays.fill(row, -1);
		}
		System.out.println(sol(arr, -1, 0, arr.length, cache));
	}

}
