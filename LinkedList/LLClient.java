package LinkedList;

public class LLClient {

	public static void main(String[] args) throws Exception {
//		LinkedList ll = new LinkedList();
//		
//		//ll.getFirst();
//		//System.out.println(ll.head);
//		ll.addAtFirst(10);
//		ll.addAtFirst(20);
//		ll.addAtFirst(30);
//		ll.addAtLast(60);
//		//ll.addAtLast(70);
//		ll.display();
////		System.out.println(ll.getFirst());
////		System.out.println(ll.getLast());
////		System.out.println(ll.size());
////		
////		System.out.println(ll.getAtIndex(1));
////		System.out.println(ll.deleteAtIndex(0));
////		System.out.println(ll.deleteAtIndex(ll.size() - 1));
//		//System.out.println(ll.midPointVal());
//		System.out.println(ll.cycleDetection());
//		ll.cycleCreate();
//		System.out.println(ll.cycleDetection());
//		//ll.display();
		
		LinkedList a = new LinkedList();
		LinkedList b = new LinkedList();
		
		a.addAtLast(1);
		a.addAtLast(2);
		a.addAtLast(4);
		a.addAtLast(6);
		
		b.addAtLast(0);
		b.addAtLast(3);
		b.addAtLast(5);
		b.addAtLast(7);
		
		LinkedList c = a.mergeTwoSortedLL(a, b);
		c.display();
	}

}