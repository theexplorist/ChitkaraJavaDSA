package Heaps;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	static class Person {
		int age;
		String name;
		int id;
		
		public Person(int age, String name, int id) {
			// TODO Auto-generated constructor stub
			this.age = age;
			this.name = name;
			this.id = id;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name + "";
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Default min heap 
		//PriorityQueue<Integer> h = new PriorityQueue<>();
		//max heap
		PriorityQueue<Integer> h = new PriorityQueue<>(Collections.reverseOrder());
		h.add(10);
		h.add(20);
		h.add(30);
		h.add(5);
		h.add(3);
		
		System.out.println(h);
		System.out.println(h.remove());
		System.out.println(h.peek());
		System.out.println(h);
		
		PriorityQueue<Person> pq = new PriorityQueue<>(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				//return o1.name.compareTo(o2.name);//min o1 - o2
				return o2.name.compareTo(o1.name);//max o2 - o1
			}
		});
		pq.add(new Person(10, "ram", 2));
		pq.add(new Person(20, "mohan", 1));
		pq.add(new Person(30, "shyam", 3));
		pq.add(new Person(5, "john", 0));
		pq.add(new Person(3, "abc", 5));
		System.out.println(pq);
	}

}
