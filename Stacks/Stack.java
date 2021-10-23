package Stacks;

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
	
	public void push(int value) {
		// TODO Auto-generated method stub
		if(isFull()) {
			System.err.println("Full hai bhai!");
			return;
		}
		this.tos++;
		data[tos] = value;
	}
	
	public int pop() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.err.println("Khaali hai bhai!");
			return -1;
		}
		int temp = data[tos];
		data[tos] = 0;
		tos--;
		return temp;
	}
	
	public int peek() {
		// TODO Auto-generated method stub

		if(isEmpty()) {
			System.err.println("Khaali hai bhai!");
			return -1;
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
