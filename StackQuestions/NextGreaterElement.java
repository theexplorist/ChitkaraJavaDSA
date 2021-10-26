package StackQuestions;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ht = {7, 1, 2, 1, 3, 0};
		Stack<Integer> st = new Stack<>();
		
		int[] nge = new int[ht.length];
		st.push(0);
		
		for(int curr = 1; curr < ht.length; curr++) {
			
			while(!st.isEmpty() && ht[st.peek()] < ht[curr]) {
				nge[st.pop()] = ht[curr];
			}
			st.push(curr);
		}
		
		while(!st.isEmpty()) {
			nge[st.pop()] = -1;
			//System.out.println(st.pop() + " ka nge hai " + -1);
		}
		
		for(int i = 0; i < ht.length; i++) {
			System.out.println(ht[i] + " ka nge hai " + nge[i]);
		}
	}

}
