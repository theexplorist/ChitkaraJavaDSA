package Queue;

public class QueueUsingArrays {

	int[] data;
	int front;
	int size;
	public QueueUsingArrays() {
		// TODO Auto-generated constructor stub
		this.data = new int[5];//capacity
		this.front = 0;
		size = 0;
	}
	
	public QueueUsingArrays(int capacity) {
		// TODO Auto-generated constructor stub
		this.data = new int[capacity];//capacity
		this.front = 0;
		size = 0;
	}
	
	public void enqueue(int item) throws Exception {
		// TODO Auto-generated method stub

		if(size == this.data.length) {
			throw new Exception("Queue full hai!");
		}
		int idx = front + size;
		idx = idx % data.length;
		data[idx] = item;
		size++;
	}
	//ctrl + spacebar
	public int dequeue() throws Exception {
		// TODO Auto-generated method stub

		if(this.isEmpty()) {
			throw new Exception("Queue khaali hai!");
		}
		int temp = data[front];
		data[front] = 0;
		size--;
		front++;
		front = front % data.length;
		return temp;
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub

		return this.size == 0;
	}
	
	public int getfront() throws Exception {
		// TODO Auto-generated method stub

		if(this.isEmpty()) {
			throw new Exception("Queue khaali hai!");
		}
		int temp = data[front];
		return temp;
	}
	public void display() {
		// TODO Auto-generated method stub

		for(int i = 0; i < data.length; i++) {
			int idx = i + front;
			idx = idx % data.length;
			System.out.print(data[idx] + " ");
		}
		
		System.out.println();
	}
}
