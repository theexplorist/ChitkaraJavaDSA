package StackQps2;

import java.util.Stack;

public class CelebrityProblem {

	public static void main(String[] args) {

		int[][] arr = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			st.push(i);
		}

		while (st.size() != 1) {
			int banda1 = st.pop();
			int banda2 = st.pop();

			// kya b1 , b2 ko jaanta hai? arr[b1][b2] = 1
			if (arr[banda1][banda2] == 1) {
				st.push(banda2);
			} else {
				// ni jaanta b1 b2 ko
				st.push(banda1);
			}
		}

		int potentialCeleb = st.pop();
		// check kro ki ye celeb hai ya ni
		// System.out.println(st);

		for (int c = 0; c < arr.length; c++) {
			if (arr[potentialCeleb][c] == 1) {
				System.out.println("No celebrity!");
				return;
			}
		}

		for (int r = 0; r < arr.length; r++) {
			if (r != potentialCeleb && arr[r][potentialCeleb] == 0) {
				System.out.println("No celebrity!");
				return;
			}
		}

		System.out.println(potentialCeleb);
	}
}
