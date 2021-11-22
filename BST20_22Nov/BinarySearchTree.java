package BST20_22Nov;

public class BinarySearchTree {

	private class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}
	}

	private Node root;

	public void construct(int[] arr) {
		// TODO Auto-generated method stub

		root = construct(arr, 0, arr.length - 1);// 2k
	}

	public int min() {
		// TODO Auto-generated method stub

		return min(root);
	}

	private int min(Node root) {
		// TODO Auto-generated method stub

//		if(root == null) {
//			
//		}
		if (root.left == null) {
			return root.val;
		}
		return min(root.left);
	}

	public int max() {
		// TODO Auto-generated method stub

		return max(root);
	}

	private int max(Node root) {
		// TODO Auto-generated method stub

//		if(root == null) {
//			
//		}
		if (root.right == null) {
			return root.val;
		}
		return max(root.right);
	}

	private Node construct(int[] arr, int l, int r) {
		// TODO Auto-generated method stub

		if (l > r) {
			return null;
		}
		int mid = (l + r) / 2;
		Node nn = new Node(arr[mid]);
		nn.left = construct(arr, l, mid - 1);
		nn.right = construct(arr, mid + 1, r);

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

	public boolean search(int val) {
		// TODO Auto-generated method stub

		return search(root, val);
	}

	private boolean search(Node root, int val) {
		// TODO Auto-generated method stub

		if (root == null) {
			return false;
		}

		if (val > root.val) {
			// right
			return search(root.right, val);
		} else if (val < root.val) {
			// left
			return search(root.left, val);
		} else {
			return true;
		}
	}

	public Node insertIntoBST(Node root, int val) {

		if(root == null) {
			Node nn = new Node(val);
			root = nn;
		} else {
			insert(root, val);
		}
		
		return root;
	}

	private void insert(Node root, int val) {
		// TODO Auto-generated method stub
		if (val < root.val) {
			// left mein insert
			if (root.left != null) {
				insert(root.left, val);
			} else {
				Node nn = new Node(val);
				root.left = nn;
			}
		} else if (val > root.val) {
			// right mein insert
			if (root.right != null) {
				insert(root.right, val);
			} else {
				Node nn = new Node(val);
				root.right = nn;
			}
		}
	}
	
	
}
