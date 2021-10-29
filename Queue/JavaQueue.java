package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class JavaQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> q = new LinkedList<>();
		//System.out.println(q.remove()); remove throws exception while poll throws null
//		System.out.println(q);
//		
//		q.add(10);
//		q.add(20);
//		q.add(30);
//		
//		System.out.println(q);
//		System.out.println(q.poll());//10
//		System.out.println(q);
//		q.add(40);
//		System.out.println(q);
//		System.out.println(q.isEmpty());
//		System.out.println(q.size());
//		System.out.println(q.peek());//front element hi dega
		for(int i = 0; i < Long.MAX_VALUE; i++) {
			q.add(1);
		}
		System.out.println(q);
	}

}
