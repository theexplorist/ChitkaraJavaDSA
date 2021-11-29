package Trees29Nov;

public class DistributeCoins {


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
	
	class Solution {
	    int moves;
	    public int distributeCoins(TreeNode root) {
	        moves = 0;
	        distributeCoinsR(root);
	        return moves;
	    }
	    
	    public int distributeCoinsR(TreeNode root) {
	        
	        if(root == null) {
	            return 0;
	        }
	        
	        
	        int left =  distributeCoinsR(root.left);
	        int right = distributeCoinsR(root.right);
	        
	        moves += Math.abs(left) + Math.abs(right);
	        return root.val + left + right - 1;
	    }
	}
}
