package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class LeetcodeBT {

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

	int maxKitneDekhLiye = 0;

	public List<Integer> rightSideView(TreeNode root) {

		rightSideViewR(root, 1);
		return null;
	}

	public void rightSideViewR(TreeNode root, int clvl) {

		if (root == null) {
			return;
		}

		if (maxKitneDekhLiye < clvl) {
			System.out.println(root.val);
			maxKitneDekhLiye = clvl;
		}
		// System.out.println(root.val);
		rightSideViewR(root.left, clvl + 1);
		rightSideViewR(root.right, clvl + 1);

	}

	public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> curr = new ArrayList<>();
		pathSum2(root, targetSum, curr, ans, 0);
		return ans;
	}

	public void pathSum2(TreeNode root, int targetSum, List<Integer> curr, List<List<Integer>> ans, int cSum) {

		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			if (cSum + root.val == targetSum) {
				curr.add(root.val);// [5, 4, 11, 2]
				ans.add(new ArrayList<>(curr));
				curr.remove(curr.size() - 1);
				return;
			}
		}
		curr.add(root.val);
		pathSum2(root.left, targetSum, curr, ans, cSum + root.val);
		pathSum2(root.right, targetSum, curr, ans, cSum + root.val);
		curr.remove(curr.size() - 1);
	}

	int ans;

	public int pathSum(TreeNode root, int targetSum) {
		ans = 0;

		pathSumH(root, targetSum);
		return ans;

	}

	public void pathSumH(TreeNode root, int targetSum) {
		if (root == null) {
			return;
		}
		pathSumRec(root, targetSum, 0);

		pathSumH(root.left, targetSum);
		pathSumH(root.right, targetSum);

	}

	public void pathSumRec(TreeNode root, int targetSum, int cSum) {

		if (root == null) {
			return;
		}

		if (cSum + root.val == targetSum) {
			ans++;
			// return;
		}

		pathSumRec(root.left, targetSum, cSum + root.val);
		pathSumRec(root.right, targetSum, cSum + root.val);
	}

public int minDepth(TreeNode root) {
        
        int ans = minDepthR(root);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    
    public int minDepthR(TreeNode root) {
        
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        
        if(root.left == null && root.right == null) {
            return 1;
        }
        int leftD = minDepthR(root.left);
        int rightD = minDepthR(root.right);
        
        int myAns = Math.min(leftD, rightD) + 1;
        
        return myAns;
       // return 0;
    }
}
