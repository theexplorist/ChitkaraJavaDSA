package StackQuestions;

import java.util.Arrays;
import java.util.Stack;

public class PreviousGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ht = { 0, 1, 2, 1, 3, 7 };

		Stack<Integer> st = new Stack<>();
		st.push(0);
		int[] pge = new int[ht.length];
		pge[0] = -1;

		for (int curr = 1; curr < ht.length; curr++) {

			while (!st.isEmpty() && ht[st.peek()] <= ht[curr]) {
				st.pop();
			}

			if (!st.isEmpty())
				pge[curr] = ht[st.peek()];
			else
				pge[curr] = -1;
			st.push(curr);
		}

		
		System.out.println(Arrays.toString(pge));
	}

}
