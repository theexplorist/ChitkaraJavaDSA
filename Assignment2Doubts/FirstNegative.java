package Assignment2Doubts;

import java.util.ArrayDeque;
import java.util.Deque;

public class FirstNegative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int k = 3;
		Deque<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < nums.length; i++) {
			while (!q.isEmpty() && nums[q.getLast()] >= 0) {
				q.removeLast();
			}
			q.addLast(i);

			if (q.getFirst() == i - k) {// q.size() > k
				q.removeFirst();
			}
			if (i >= k - 1) {
				if(nums[q.getFirst()] < 0)
				System.out.print(nums[q.getFirst()] + " ");
				else
					System.out.println(0 + " ");
			}
		}
	}

}
