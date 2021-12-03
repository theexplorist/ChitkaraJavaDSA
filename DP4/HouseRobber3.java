package DP4;

import java.util.Map;

public class HouseRobber3 {

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

	public int rob(TreeNode root, Map<TreeNode, Integer> dp) {

		if(root == null) {
			return 0;
		}
		
		if(dp.containsKey(root)) {
			return dp.get(root);
		}
		int with = root.val;

		if (root.left != null) {
			with += rob(root.left.left, dp);
			with += rob(root.left.right, dp);
		}
		
		if(root.right != null) {
			with += rob(root.right.left, dp);
			with += rob(root.right.right, dp );
		}
		
		int without = 0;
		
		without += rob(root.left, dp);
		without += rob(root.right, dp);
		int ans = Math.max(with, without);
		dp.put(root, ans);
				
		return ans;
	}
}
