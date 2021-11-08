package LinkedList;

public class LinkedList {

	class Node {
		int val;
		Node next;// address of next Node

		public Node(int val) {
			this.val = val;
		}
	}

	private Node head;// ye aapki 1st node ka address store krke rakhta hai

	public int size() {
		// TODO Auto-generated method stub

		int ct = 0;
		Node i = head;
		while (i != null) {
			ct++;
			i = i.next;
		}

		return ct;
	}

	public void display() {
		// TODO Auto-generated method stub

		Node i = head;
		while (i != null) {
			System.out.print(i.val + "->");
			i = i.next;
		}

		System.out.println();
	}

	public void addAtFirst(int val) {
		// TODO Auto-generated method stub

		Node nn = new Node(val);
		nn.next = head;
		head = nn;
	}

	public void addAtLast(int val) throws Exception {
		// TODO Auto-generated method stub

		Node nn = new Node(val);
		if (head == null) {
			addAtFirst(val);
		} else {
			Node curr = getNodeAtIndex(size() - 1);
			curr.next = nn;
		}
	}

	public int getFirst() throws Exception {
		// TODO Auto-generated method stub

		if (head == null) {
			throw new Exception("Linked list khaali hai!");
		}
		return head.val;// null.val
	}

	public int getLast() throws Exception {
		// TODO Auto-generated method stub

		if (head == null) {
			throw new Exception("Linked list khaali hai!");
		}
		Node i = head;
		while (i.next != null) {
			i = i.next;
		}

		return i.val;
	}

	public int getAtIndex(int idx) throws Exception {
		// TODO Auto-generated method stub

		if (head == null) {
			throw new Exception("Linked list khaali hai!");
		}

		if (idx < 0 || idx >= size()) {
			throw new Exception("Galat index hai bhai!");
		}
		Node i = head;
		for (int it = 1; it <= idx; it++) {
			i = i.next;
		}

		return i.val;
	}

	public void addAtIndex(int value, int idx) throws Exception {
		// TODO Auto-generated method stub

		if (idx < 0 || idx > size()) {
			throw new Exception("Galat index hai bhai!");
		}

		if (idx == 0) {
			addAtFirst(value);
		} else if (idx == size()) {
			addAtLast(value);
		} else {
			Node nn = new Node(value);
			Node idx_1N = getNodeAtIndex(idx - 1);
			Node idxN = getNodeAtIndex(idx);

			idx_1N.next = nn;
			nn.next = idxN;
		}
	}

	public Node getNodeAtIndex(int idx) throws Exception {
		// TODO Auto-generated method stub

		if (head == null) {
			throw new Exception("Linked list khaali hai!");
		}

		if (idx < 0 || idx >= size()) {
			throw new Exception("Galat index hai bhai!");
		}
		Node i = head;
		for (int it = 1; it <= idx; it++) {
			i = i.next;
		}

		return i;// node ka address
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub

		return head == null;
	}

	public int deleteFirst() throws Exception {
		// TODO Auto-generated method stub

		if (this.isEmpty()) {
			throw new Exception("Khaali hai LinkedList!");
		}
		Node i = head;
		head = head.next;
		i.next = null;
		return i.val;
	}

	public int deleteLast() throws Exception {
		// TODO Auto-generated method stub

		if (size() == 1) {
			return deleteFirst();
		} else {
			Node last_1 = getNodeAtIndex(this.size() - 2);
			Node last = last_1.next;
			int temp = last.val;
			last_1.next = null;
			return temp;
		}
	}

	public int deleteAtIndex(int idx) throws Exception {
		// TODO Auto-generated method stub

		if (this.isEmpty()) {
			throw new Exception("Khaali hai LinkedList!");
		}
		
		if(idx >= size()) {
			throw new Exception("Galat Index!");
		}
		if (idx == 0) {
			return deleteFirst();
		} else {
			Node idx_1 = getNodeAtIndex(idx - 1);
			Node idxN = idx_1.next;
			Node idxPlus1 = idx_1.next.next;
			idxN.next = null;
			idx_1.next = idxPlus1;
			return idxN.val;
		}
	}
	
	public void reverseActual() throws Exception {
		// TODO Auto-generated method stub

		if(this.isEmpty()) {
			throw new Exception("Empty hai!");
		}
		Node prev = null;
		Node curr = head;
		
		while(curr != null) {
			Node currNext = curr.next;
			curr.next = prev;
			prev = curr;
			curr = currNext;
		}
		
		head = prev;
	}
	
	public int midPointVal() {
		// TODO Auto-generated method stub

		return midPointNode().val;
	}
	
	public Node midPointNode() {
		// TODO Auto-generated method stub

		Node s = head;
		Node f = head;
		
		while(f != null && f.next != null) {
			
			s = s.next;
			f = f.next.next;//f -> last node, f.next = null, null.next = npe
		}
		
		return s;
	}

}
