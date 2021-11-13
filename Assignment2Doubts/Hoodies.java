package Assignment2Doubts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Hoodies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);

		List<Queue<Integer>> qL = new ArrayList<>();
		Queue<Integer> order = new LinkedList<>();
		for (int i = 0; i <= 4; i++) {
			qL.add(new LinkedList<>());
		}

		System.out.println(qL);

		int q = s.nextInt();

		while (q-- != 0) {
			char ch = s.next().charAt(0);

			if (ch == 'E') {
				int courseN = s.nextInt();
				int rollN = s.nextInt();
				Queue<Integer> qu = qL.get(courseN);
				qu.add(rollN);
				if (!order.contains(courseN)) {
					order.add(courseN);
				}
			} else {

				int queueNumber = order.peek();
				Queue<Integer> qu = qL.get(queueNumber);
				System.out.println(queueNumber + " " + qu.remove());

				if (qu.isEmpty()) {
					order.remove();
				}
			}
		}
	}

}
