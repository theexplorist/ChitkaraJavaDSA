package BST20_22Nov;

public class BSTLeetCode {

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
	int sum;
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        bstToGstR(root);
        return root;
    }
    
    
    public void bstToGstR(TreeNode root) {
       
        if(root == null) {
            return;
        }
        
        bstToGstR(root.right);
        
        root.val = root.val + sum;
        sum = root.val;
        
        bstToGstR(root.left);
    }
    
    int sum1;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum1 = 0;
        rangeSumBSTR(root, low, high);
        return sum1;
    }
    
    public void rangeSumBSTR(TreeNode root, int low, int high) {
        
        if(root == null) {
            return;
        }
        if(root.val < low) {
            rangeSumBSTR(root.right, low, high);
        } else if(root.val > high) {
            rangeSumBSTR(root.left, low, high);
        } else {
           
             rangeSumBSTR(root.left, low, high);
             sum1 += root.val;
             System.out.print(root.val + " ");
             rangeSumBSTR(root.right, low, high);
        }
    }
}
