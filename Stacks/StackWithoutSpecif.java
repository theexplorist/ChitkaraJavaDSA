package Stacks;

//ctrl/cmd + shift + 0
import java.util.Stack;

public class StackWithoutSpecif {

	public static void main(String[] args) {
		
		Stack st = new Stack();
		st.push(1);
		st.push("hello");
		System.out.println(st);
		
		while(!st.isEmpty()) {
			var poppedValue = st.pop();
			System.out.println(poppedValue);
		}
	}
}
