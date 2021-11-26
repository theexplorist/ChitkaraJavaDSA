package DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs {

	public static int climbStairs(int n, int[] cache) {

		if(n == 0) {
			return 1;
		}
		
		if(n < 0) {
			return 0;
		}
		
		if(cache[n] != -1) {
			return cache[n];
		}
		int c1 = climbStairs(n - 1, cache);
		int c2 = climbStairs(n - 2, cache);
		
		return cache[n] = c1 + c2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 45;
		int[] cache = new int[n + 1];
		Arrays.fill(cache, -1);
		
		System.out.println(climbStairs(n, cache));
	}

}
