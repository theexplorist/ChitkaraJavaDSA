package BinaryTree20Nov;

public class BinaryTreeLC {

	class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}

		if (root1.val != root2.val) {
			return false;
		}

		boolean comp1 = flipEquiv(root1.left, root2.right);
		boolean comp2 = flipEquiv(root1.right, root2.left);
		boolean comp3 = flipEquiv(root1.left, root2.left);
		boolean comp4 = flipEquiv(root1.right, root2.right);
		return (comp1 && comp2) || (comp3 && comp4);
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(TreeNode t1, TreeNode t2) {

		if (t1 == null && t2 == null) {
			return true;
		}

		if (t1 == null || t2 == null) {
			return false;
		}

		if (t1.val != t2.val) {
			return false;
		}

		boolean ans1 = isSymmetric(t1.right, t2.left);
		boolean ans2 = isSymmetric(t1.left, t2.right);

		return ans1 && ans2;
	}

	public TreeNode sufficientSubset(TreeNode root, int limit) {

		return pathSum(root, limit, 0) == false ? null : root;
	}

	public boolean pathSum(TreeNode root, int limit, int cSum) {

		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			if (cSum + root.val < limit) {
				return false;
			}

			return true;
		}
		boolean leftAns = pathSum(root.left, limit, cSum + root.val);
		boolean rightAns = pathSum(root.right, limit, cSum + root.val);
		if (leftAns == false && rightAns == false) {
			return false;
		}

		if (leftAns == false) {
			root.left = null;
		}

		if (rightAns == false) {
			root.right = null;
		}

		return true;

	}

	public TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return null;
		}

		TreeNode lSubtree = invertTree(root.left);
		TreeNode rSubTree = invertTree(root.right);
		root.left = rSubTree;
		root.right = lSubtree;
		return root;
	}

}
