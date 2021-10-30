package DoubleEndedQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxInWindowOfSizeK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1, 4, 2, 5, 8, 7};
		int k = 3;
		Deque<Integer> q = new ArrayDeque<>();
		
		for(int i = 0; i < nums.length; i++) {
			while(!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
				q.removeLast();
			}
			q.addLast(i);
			
			if(q.getFirst() == i - k) {//q.size() > k
				q.removeFirst();
			}
			if(i >= k - 1) {
				System.out.println(nums[q.getFirst()]);
			}
		}
	}

}
