package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

	static class Node {
		int r, c, val;
		public Node(int r, int c, int val) {
			// TODO Auto-generated constructor stub
			this.r = r;
			this.c = c;
			this.val = val;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return val + "";
		}
	}
	
	public static void main(String[] args) {
		int[][] arr = {{1, 10, 11, 15}, {2, 4, 9}, {5, 6, 8, 16}, {3, 7, 12, 13}};
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
		});
		
		for(int r = 0; r < arr.length; r++) {
			pq.add(new Node(r, 0, arr[r][0]));
		}
		
		System.out.println(pq);
		
		while(!pq.isEmpty()) {
			Node top = pq.remove();
			int r = top.r;
			int c = top.c;
			System.out.print(top.val + " ");
			
			if(c + 1 < arr[r].length)
			pq.add(new Node(r, c + 1, arr[r][c + 1]));
		}
		
		System.out.println(pq);
	}
}
