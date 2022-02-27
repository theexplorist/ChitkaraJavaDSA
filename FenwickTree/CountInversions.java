package FenwickTree;

import java.util.Arrays;

public class CountInversions {

	// 1 to r
	private static int querySum(int[] fenwickTree, int r) {
		// TODO Auto-generated method stub

		int sum = 0;
		while (r > 0) {
			sum += fenwickTree[r];
			r = r - range(r);
		}

		return sum;
	}

	private static int range(int index) {
		// TODO Auto-generated method stub

		return index & (-index);
	}

	// build and update both(single - O(logn)
	private static void buildTree(int n, int index, int val, int[] fenwickTree) {
		// TODO Auto-generated method stub

		while (index <= n) {
			fenwickTree[index] += val;
			index = index + range(index);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {10, 8, 6, 1};
		
		int max = Integer.MIN_VALUE;
		
		for(int e : arr) {
			max = Math.max(e, max);
		}
		
		int[] fT = new int[max + 1];
		
		int ans = 0;
		for(int j = 0; j < arr.length; j++) {
			//sum[arr[j] + 1, max] = sum[1, max] - sum[1, arr[j]]
			
			ans += querySum(fT, max) - querySum(fT, arr[j]);
			buildTree(fT.length, arr[j], 1, fT);
		}
		System.out.println(Arrays.toString(fT));
		System.out.println(ans);
	}

}
