package DoubleEndedQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Demo {

	public static void main(String[] args) {
		Deque<Integer> q = new ArrayDeque<>();
		
		q.addFirst(10);
		q.addFirst(20);
		q.addFirst(30);
		q.addLast(40);
		System.out.println(q);
		System.out.println(q.getFirst());
		System.out.println(q.getLast());
		
		System.out.println(q.removeFirst());//30
		System.out.println(q.removeLast());//40
		
		System.out.println(q);
		q.isEmpty();
		q.size();
	}
}
