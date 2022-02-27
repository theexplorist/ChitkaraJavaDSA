package FenwickTree;

import java.util.Arrays;
import java.util.Scanner;

public class FenwickTree {

	//1 to r
	private static int querySum(int[] fenwickTree, int r) {
		// TODO Auto-generated method stub

		int sum = 0;
		while(r > 0) {
			sum += fenwickTree[r];
			r = r - range(r);
		}
		
		return sum;
	}
	private static int range(int index) {
		// TODO Auto-generated method stub

		return index & (-index);
	}
	
	//build and update both(single - O(logn)
	private static void buildTree(int n, int index, int val, int[] fenwickTree) {
		// TODO Auto-generated method stub

		while(index <= n) {
			fenwickTree[index] += val;
			index = index + range(index);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n + 1];
		
		int[] fenwickTree = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			
			int el = s.nextInt();
			arr[i] = el;
		}
		
		for(int i = 1; i <= n; i++) {
			//O(nlogn) 
			buildTree(n, i, arr[i], fenwickTree);
		}
		
		System.out.println(Arrays.toString(fenwickTree));
		
		//sum(1 to 15)
		int a = querySum(fenwickTree, 15);
		System.out.println(a);
		//sum(1 to 6)
		int b = querySum(fenwickTree, 6);
		System.out.println(b);
		//sum(7, 15)
		System.out.println(a - b);
		
		buildTree(n, 1, 2, fenwickTree);
		System.out.println(Arrays.toString(fenwickTree));
	}

}
