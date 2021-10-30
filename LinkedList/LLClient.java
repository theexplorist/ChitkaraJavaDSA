package LinkedList;

public class LLClient {

	public static void main(String[] args) throws Exception {
		LinkedList ll = new LinkedList();
		ll.addAtLast(50);
		//ll.getFirst();
		//System.out.println(ll.head);
		ll.addAtFirst(10);
		ll.addAtFirst(20);
		ll.addAtFirst(30);
		ll.addAtLast(60);
		ll.display();
		System.out.println(ll.getFirst());
		System.out.println(ll.getLast());
		System.out.println(ll.size());
		
		System.out.println(ll.getAtIndex(1));
	}

}
