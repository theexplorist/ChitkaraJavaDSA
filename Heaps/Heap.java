package Heaps;

import java.util.ArrayList;
import java.util.List;

public class Heap {

	List<Integer> nodes;

	public Heap() {
		// TODO Auto-generated constructor stub
		this.nodes = new ArrayList<>();
		nodes.add(Integer.MIN_VALUE);
	}

	private void add(int val) {//log n
		// TODO Auto-generated method stub

		// 1. insert at the last of nodes list
		nodes.add(val);
		// 2. upheapify
		int ci = nodes.size() - 1;
		int parentI = ci / 2;
		// nodes[pi] > nodes[ci] -> swap
		while (ci > 1 && nodes.get(parentI) > nodes.get(ci)) {
			// swap
//			int temp = arr[parentI];
//			arr[parentI] = arr[ci];
//			arr[ci] = temp

			int temp = nodes.get(parentI);
			nodes.set(parentI, nodes.get(ci));
			nodes.set(ci, temp);
			ci = parentI;
			parentI = parentI / 2;
		}
	}

	private void remove() {//log n
		// TODO Auto-generated method stub
		// 1. swap last and 1st index val

		int temp = nodes.get(1);
		nodes.set(1, nodes.get(nodes.size() - 1));
		nodes.set(nodes.size() - 1, temp);

		// 2 . remove the last node
		nodes.remove(nodes.size() - 1);

		// 3. down heapify
		downHeapify(1);
	}

	private int get() {
		// TODO Auto-generated method stub

		return nodes.get(1);
	}
	private boolean isEmpty() {
		// TODO Auto-generated method stub

		return nodes.size() == 1;	//ek -inf pehle hi hai 0th ind pr
	}
	private void downHeapify(int ci) {//log n
		// TODO Auto-generated method stub

		int minI = ci;
		int lC = 2 * ci;
		int rC = 2 * ci + 1;

		// comparison step to find min
		if (lC < nodes.size() && nodes.get(minI) > nodes.get(lC)) {
			minI = lC;
		}

		if (rC < nodes.size() && nodes.get(minI) > nodes.get(rC)) {
			minI = rC;
		}

		// swap minI and cI
		if (minI != ci) {//agar hum last node pr hain to rukna hai
			int temp = nodes.get(ci);
			nodes.set(ci, nodes.get(minI));
			nodes.set(minI, temp);
			// rec call
			downHeapify(minI);
		}

	}

	public static void main(String[] args) {
		Heap h = new Heap();
		h.add(10);
		h.add(20);
		h.add(30);
		h.add(5);
		h.add(3);

		System.out.println(h.nodes);
		h.remove();
		h.remove();
		System.out.println(h.nodes);
		if(!h.isEmpty()) {
			System.out.println(h.get());
		}
	}
}
