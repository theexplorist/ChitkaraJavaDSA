package StackQps2;

import java.util.Arrays;
import java.util.Stack;

public class NumberOfValidSubarrays {

	public int validSubarrays(int[] ht) {
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

		System.out.println(Arrays.toString(nse));

		int sum = 0;

		for (int i = 0; i < ht.length; i++) {
			sum += (nse[i] - i);
		}
		return sum;
	}
}
