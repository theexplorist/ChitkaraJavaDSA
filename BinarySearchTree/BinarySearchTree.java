package BinarySearchTree;

public class BinarySearchTree {

	private class Node {
		int val;
		Node left;
		Node right;
	}

	private Node root; // null

	public void construct(int[] sortedArray) {
		// TODO Auto-generated method stub

		this.root = construct(sortedArray, 0, sortedArray.length - 1);
	}

	private Node construct(int[] sortedArray, int l, int r) {
		// TODO Auto-generated method stub

		if (l > r) {
			return null;
		}
		int mid = (l + r) / 2;// arr[mid]
		Node nn = new Node();
		nn.val = sortedArray[mid];

		nn.left = construct(sortedArray, l, mid - 1);
		nn.right = construct(sortedArray, mid + 1, r);

		return nn;
	}

	public boolean search(int val) {
		// TODO Auto-generated method stub

		return search(root, val);
	}

	private boolean search(Node root, int val) {
		// TODO Auto-generated method stub

		if (root == null) {
			return false;
		}

		if (root.val < val) {
			return search(root.right, val);
		} else if (root.val > val) {
			return search(root.left, val);
		} else {// equal
			return true;
		}
	}

	public void display() {
		// TODO Auto-generated method stub
		display(root);
	}

	private void display(Node parent) {
		// TODO Auto-generated method stub
		if (parent == null) {
			return;
		}

		String str = "";
		// agar left child hai to str mein append krdo
		if (parent.left != null) {
			str += parent.left.val;
		} else {
			str += '_';
		}

		str += " -> " + parent.val + " <- ";

		// agar right child hai to str mein append krdo
		if (parent.right != null) {
			str += parent.right.val;
		} else {
			str += '_';
		}

		System.out.println(str);

		display(parent.left);
		display(parent.right);
	}

	public void insert(int val) {
		// TODO Auto-generated method stub

		if (root == null) {
			Node nn = new Node();
			nn.val = val;
			root = nn;
		} else {
			insert(root, val);
		}
	}

	private void insert(Node root, int val) {
		// TODO Auto-generated method stub

		if (val < root.val) {

			if (root.left != null) {
				insert(root.left, val);
			} else {
				Node nn = new Node();
				nn.val = val;
				root.left = nn;
			}
		} else if (root.val < val) {
			if (root.right != null) {
				insert(root.right, val);
			} else {
				Node nn = new Node();
				nn.val = val;
				root.right = nn;
			}
		}
	}

	public int max() {
		// TODO Auto-generated method stub

		return max(root);
	}

	private int max(Node root) {
		// TODO Auto-generated method stub

		if (root != null && root.right == null) {
			return root.val; // rightmost node ki value//max
		}

		return max(root.right);
	}

	public int min() {
		// TODO Auto-generated method stub

		return min(root);
	}

	private int min(Node root) {
		// TODO Auto-generated method stub

		if (root != null && root.left == null) {
			return root.val; // lefttmost node ki value//max
		}

		return min(root.left);
	}

	public void delete(int val) {
		// TODO Auto-generated method stub

		delete(root, val);
	}

	private Node delete(Node root, int val) {
		// TODO Auto-generated method stub

		if (root == null) {
			return null;
		}

		if (val < root.val) {
			root.left = delete(root.left, val);
		} else if (root.val < val) {
			root.right = delete(root.right, val);
		} else {// equal
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.right == null) {
				return root.left;
			} else if (root.left == null) {
				return root.right;
			} else {
				int inOrderSuccessor = min(root.right);
				root.val = inOrderSuccessor;
				root.right = delete(root.right, inOrderSuccessor);
			}
		}

		return root;
	}

	public boolean isValidBST(Node root) {

		return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBst(Node root, int minR, int maxR) { //use long while submitting on leetcode
		// TODO Auto-generated method stub

		if(root == null) {
			return true;
		}
		
		if(root.val >= maxR || root.val <= minR) {
			return false;
		}
		
		boolean isLeftBSt = isBst(root.left, minR, root.val);
		boolean isRightBst = isBst(root.right, root.val, maxR);
		
		return isLeftBSt && isRightBst;
	}
	
}
