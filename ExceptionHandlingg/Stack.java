package ExceptionHandlingg;

public class Stack {

	private int[] data; //
	private int tos;
	
	public Stack() {
		// TODO Auto-generated constructor stub
		this.data = new int[5];//default capacity of stack is 5 
		this.tos = -1;
	}
	
	public Stack(int capacity) {
		this.data = new int[capacity];
		this.tos = -1;
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return this.tos + 1;
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size() == 0;
	}
	
	public boolean isFull() {
		// TODO Auto-generated method stub

		return size() == data.length;//size == capacity
	}
	
	public void push(int value) throws Exception {
		// TODO Auto-generated method stub
		if(isFull()) {
			throw new Exception("Full hai bhai!");
		}
		this.tos++;
		data[tos] = value;
	}
	
	public int pop() throws Exception {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new Exception("Stack khaali hai!");
		}
		int temp = data[tos];
		data[tos] = 0;
		tos--;
		return temp;
	}
	
	public int peek() throws Exception {
		// TODO Auto-generated method stub

		if(isEmpty()) {
			throw new Exception("Stack khaali hai!");
		}
		int temp = data[tos];
		return temp;
	}
	
	public void display() {
		// TODO Auto-generated method stub

		for(int i = tos; i >= 0; i--) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
}
