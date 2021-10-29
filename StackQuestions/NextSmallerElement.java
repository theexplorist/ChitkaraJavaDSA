package StackQuestions;

import java.util.Stack;

public class NextSmallerElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ht = {1, 4, 2, 5, 3};//5 + 1 + 3 + 1 + 1
		Stack<Integer> st = new Stack<>();
		
		int[] nse = new int[ht.length];
		st.push(0);
		
		for(int curr = 1; curr < ht.length; curr++) {
			
			while(!st.isEmpty() && ht[st.peek()] > ht[curr]) {
				nse[st.pop()] = curr;
			}
			st.push(curr);
		}
		
		while(!st.isEmpty()) {
			nse[st.pop()] = ht.length;
			//System.out.println(st.pop() + " ka nge hai " + -1);
		}
		
	
	}

}
