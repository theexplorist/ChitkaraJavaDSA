package Queue;

public class QueueClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		QueueUsingArrays q = new QueueUsingArrays();
		
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		System.out.println(q.dequeue());
		q.enqueue(40);
		q.enqueue(50);
		System.out.println(q.dequeue());
		q.enqueue(60);
		q.enqueue(70);
		
		q.display();
		System.out.println(q.getfront());
	}

}
