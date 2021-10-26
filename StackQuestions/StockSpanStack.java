package StackQuestions;

import java.util.Stack;

public class StockSpanStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> st = new Stack<>();

		int[] ht = { 1, 2, 4, 3, 5 };

		int[] span = new int[ht.length];
		
		span[0] = 1;
		
		st.push(0);
		
		for(int curr = 1; curr < ht.length; curr++) {
			
			while(!st.isEmpty() && ht[st.peek()]  < ht[curr]) {
				//pop
				
				st.pop();
			}
			
			span[curr] = st.isEmpty() ? curr + 1 : curr - st.peek();
			st.push(curr);//aage move krne se pehle khud ko stack mein
		}
		
		for(int sp : span) {
			System.out.print(sp + " ");
		}
	}

}
