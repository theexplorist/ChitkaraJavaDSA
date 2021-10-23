package Stacks;
//import java.util.Stack;
public class StackClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //Stack<Integer> st1 = new Stack<>();
		Stack st = new Stack(5); //Capacity = 5

		System.out.println(st.size());
		System.out.println(st.isEmpty());
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.display();
		System.out.println(st.size());
		System.out.println(st.isEmpty());
		System.out.println(st.pop());
		st.display();
		System.out.println(st.size());
	}

}
