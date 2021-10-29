package StackQps2;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {

	private static int histogram(int[] ht) {
		// TODO Auto-generated method stub

		Stack<Integer> st = new Stack<>();

		int[] nse = new int[ht.length];
		st.push(0);

		for (int curr = 1; curr < ht.length; curr++) {

			while (!st.isEmpty() && ht[st.peek()] > ht[curr]) {
				nse[st.pop()] = curr;
			}
			st.push(curr);
		}

		while (!st.isEmpty()) {
			nse[st.pop()] = ht.length;
			// System.out.println(st.pop() + " ka nge hai " + -1);
		}

		st = new Stack<>();
		st.push(0);
		int[] pse = new int[ht.length];
		pse[0] = -1;

		for (int curr = 1; curr < ht.length; curr++) {

			while (!st.isEmpty() && ht[st.peek()] >= ht[curr]) {
				st.pop();
			}

			if (!st.isEmpty())
				pse[curr] = st.peek();
			else
				pse[curr] = -1;
			st.push(curr);
		}

		// System.out.println(Arrays.toString(pse));
		// System.out.println(Arrays.toString(nse));

		int maxArea = Integer.MIN_VALUE;

		for (int i = 0; i < ht.length; i++) {
			int area = ht[i] * (nse[i] - pse[i] - 1);
			maxArea = Math.max(maxArea, area);
		}

		return maxArea;
	}

	public static int maximalRectangle(char[][] matrix) {

		int maxAns = Integer.MIN_VALUE;
		int[] ht = new int[matrix[0].length];
		
		for(int r = 0; r < matrix.length; r++) {
			for(int c = 0; c < matrix[0].length; c++) {
				if(matrix[r][c] == '1') {
					//add 1 to ht
					ht[c] = ht[c] + 1;
				} else {
					ht[c] = 0;
				}
			}
			
			System.out.println(Arrays.toString(ht));
			int area = histogram(ht);
			maxAns = Math.max(maxAns, area);
		}
		
		return maxAns;
	}
}
