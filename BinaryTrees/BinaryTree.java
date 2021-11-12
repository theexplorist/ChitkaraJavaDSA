package BinaryTrees;

import java.util.Scanner;

public class BinaryTree {

	private Scanner s = new Scanner(System.in);
	private class Node {
		int val;
		Node left;
		Node right;
		
		public Node(int val) {
			this.val = val;
		}
	}
	
	private Node root;
	
	public BinaryTree() {
		root = construct();//2k
	}
	
	private Node construct() {
		// TODO Auto-generated method stub

		//1.user se input
		//2. tree banate jaenge
		int v = s.nextInt();
		if(v == -1) {
			return null;
		}
		Node nn = new Node(v);
		
		nn.left = construct();//left subtree de dia
		nn.right = construct();//right subtree de dia
		return nn;
	}
	
	public void display() {
		
		display(root);
	}
	
	private void display(Node root) {
		
		if(root == null) {
			return;
		}
		String str = "";
		if(root.left != null) {
			str += root.left.val;
		} else {
			str += '_';
		}
		
		str += " -> " + root.val + " <- ";
		
		if(root.right != null) {
			str += root.right.val;
		} else {
			str += '_';
		}
		
		System.out.println(str);
		
		display(root.left);
		display(root.right);
	}
	
	public void preOrder() {
		// TODO Auto-generated method stub

		preOrder(root);
	}
	
	private void preOrder(Node root) {
		// TODO Auto-generated method stub

		if(root == null) {
			return;
		}
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void inOrder() {
		// TODO Auto-generated method stub

		inOrder(root);
	}
	
	private void inOrder(Node root) {
		// TODO Auto-generated method stub

		if(root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}
	
	public void postOrder() {
		// TODO Auto-generated method stub

		postOrder(root);
	}
	
	private void postOrder(Node root) {
		// TODO Auto-generated method stub

		if(root == null) {
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + " ");
	}
}
