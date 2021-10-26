package StackQuestions;

import java.util.Stack;

//ctrl/cmd + shift + f
//ctrl + shift + O
public class FormMinimumNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 
		
//		String str = "546";
//		int s = Integer.parseInt(str);
		
//		char c = '1';
//		int cc = c - '0';
		String inp = "IDIIIIDD";

		Stack<Integer> st = new Stack<>();
		for (int i = 0; i <= inp.length(); i++) {
			st.push(i + 1);
			
			if(i == inp.length() || inp.charAt(i) == 'I') {
				while(!st.isEmpty()) {
					System.out.print(st.pop());
				}
			}
		}
	}

}
