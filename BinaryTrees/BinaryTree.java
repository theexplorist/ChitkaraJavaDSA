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
		root = construct();// 2k
	}

	private Node construct() {
		// TODO Auto-generated method stub

		// 1.user se input
		// 2. tree banate jaenge
		int v = s.nextInt();
		if (v == -1) {
			return null;
		}
		Node nn = new Node(v);

		nn.left = construct();// left subtree de dia
		nn.right = construct();// right subtree de dia
		return nn;
	}

	public void display() {

		display(root);
	}

	private void display(Node root) {

		if (root == null) {
			return;
		}
		String str = "";
		if (root.left != null) {
			str += root.left.val;
		} else {
			str += '_';
		}

		str += " -> " + root.val + " <- ";

		if (root.right != null) {
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

		if (root == null) {
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

		if (root == null) {
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

		if (root == null) {
			return;
		}

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + " ");
	}

	private boolean pathSum(Node root, int targetSum, int cSum) {
		// TODO Auto-generated method stub

		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			if (cSum + root.val == targetSum) {
				return true;
			}
		}
		boolean leftAns = pathSum(root.left, targetSum, cSum + root.val);
		boolean rightAns = pathSum(root.right, targetSum, cSum + root.val);
		return leftAns || rightAns;
	}

	public int countNodes() {
		// TODO Auto-generated method stub

		return countNodes(root);
	}

	private int countNodes(Node root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return 0;
		}

		int leftA = countNodes(root.left);
		int rightA = countNodes(root.right);

		int total = leftA + rightA + 1;
		return total;
	}

	private int height(Node root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return 0;
		}
		int leftH = height(root.left);
		int rightH = height(root.right);

		int totalH = Math.max(leftH + 1, rightH + 1);
		return totalH;
	}

	private int diameter(Node root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return 0;
		}
		int leftH = height(root.left);
		int rightH = height(root.right);

		int rootDia = leftH + rightH;

		int leftDia = diameter(root.left);
		int rightDia = diameter(root.right);

		int maxDia = Math.max(rootDia, Math.max(leftDia, rightDia));
		return maxDia;
	}

	class Pair {
		int dia;
		int ht;

		public Pair(int dia, int ht) {
			this.dia = dia;
			this.ht = ht;
		}
	}

	private Pair diameterOpt(Node root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return new Pair(0, 0);
		}

		Pair leftPair = diameterOpt(root.left);
		Pair rightPair = diameterOpt(root.right);

		// apna kaam - apna dia, apni ht
		int leftHt = leftPair.ht;
		int rightHt = rightPair.ht;

		int apnaDia = leftHt + rightHt;
		int apniHt = Math.max(leftHt, rightHt) + 1;
		int finalDia = Math.max(apnaDia, Math.max(leftPair.dia, rightPair.dia));

		return new Pair(finalDia, apniHt);
	}

	public boolean isBalanced(Node root) {

		if(root == null) {
			return true;
		}
		int leftH = height(root.left);
		int rightH = height(root.right);
		
		boolean isRootBalanced = (Math.abs(leftH - rightH) <= 1);
		boolean isLeftBalanced = isBalanced(root.left);
		boolean isRighBalanced = isBalanced(root.right);
		return isRootBalanced && isLeftBalanced && isRighBalanced;
	}
	
	class Pair2 {
		boolean isBal;
		int ht;

		public Pair2(boolean isBal, int ht) {
			this.isBal = isBal;
			this.ht = ht;
		}
	}
	
	private Pair2 isBalancedOpt(Node root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return new Pair2(true, 0);
		}
		
		Pair2 leftPair = isBalancedOpt(root.left);
		Pair2 rightPair = isBalancedOpt(root.right);
		
		int leftHt = leftPair.ht;
		int rightHt = rightPair.ht;
		
		boolean apnaBalance = (Math.abs(leftHt - rightHt) <= 1);
		int apniHt = Math.max(leftHt, rightHt) + 1;
		
		
		boolean finalBal = apnaBalance && leftPair.isBal && rightPair.isBal;
		return new Pair2(finalBal, apniHt);
	}
}
