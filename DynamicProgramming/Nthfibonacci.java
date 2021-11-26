package DynamicProgramming;

import java.util.Arrays;

public class Nthfibonacci {

	private static long nthFib(int n, long[] cache) {
		// TODO Auto-generated method stub

		if(n == 0 || n == 1) {
			return n;
		}
		
		if(cache[n] != -1) { //repeated or overlapping subproblem(recursion ni maarni)
			return cache[n];
		}
		//rec works - 2
		long fibN_1 = nthFib(n - 1, cache);
		long fibN_2 = nthFib(n - 1, cache);
		
		//my work
		long fibN = fibN_1 + fibN_2;
		//cache[n] = fibN;
		return cache[n] = fibN;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 50;
		long[] cache = new long[n + 1];
		Arrays.fill(cache, -1);
		System.out.println(nthFib(n, cache));
	}

}
