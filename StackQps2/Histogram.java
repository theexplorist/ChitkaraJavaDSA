package StackQps2;

import java.util.Arrays;
import java.util.Stack;

public class Histogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ht = { 2, 1, 5, 6, 2, 3 };
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
		
		System.out.println(Arrays.toString(pse));
		System.out.println(Arrays.toString(nse));
		
		int maxArea = Integer.MIN_VALUE;
		
		for(int i = 0; i < ht.length; i++) {
			int area = ht[i] * (nse[i] - pse[i] - 1);
			maxArea = Math.max(maxArea, area);
		}
		
		System.out.println(maxArea);
	}

}
