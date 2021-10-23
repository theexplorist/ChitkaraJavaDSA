package Stacks;

import java.util.Stack;

public class JavaStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ClassName objName = new ClassName();
		Stack<Integer> st = new Stack<>();
//		st.push(1);
//		st.push("hello");
//		
//		while(!st.isEmpty()) {
//			int poppedValue = (int) st.pop();
//			System.out.println(poppedValue);
//		}
		//st.peek();
		if(!st.isEmpty()) {
			System.out.println(st.pop());
		}
		
		System.out.println(st.isEmpty());
		st.push(10);
		st.push(20);
		st.push(30);
		
		while(!st.isEmpty()) {
			System.out.println(st.pop());
		}
		System.out.println(st.size());
		System.out.println(st);
		st.pop();
		System.out.println(st);
//		int poppedValue = st.pop();//top element ko delete or deleted value ko return
//		System.out.println(poppedValue);
		System.out.println(st.pop());
		System.out.println(st);
		
		System.out.println(st.isEmpty());
		//int topValue = st.peek();
		//System.out.println(topValue);
		//System.out.println(st.peek());//no deletion just return the topmost 
	}

}
