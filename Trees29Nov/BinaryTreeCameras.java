package Trees29Nov;

public class BinaryTreeCameras {


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
	    
	    int camera = 0;
	    public int minCameraCover(TreeNode root) {
	        camera = 0;
	        return minCameraCoverR(root).equals("leaf") ? camera + 1 : camera;
	    }
	    
	    public String minCameraCoverR(TreeNode root) {
	        
	        if(root == null) {
	            return "monitored_without_cam";
	        }
	        
	        String left = minCameraCoverR(root.left);
	        String right = minCameraCoverR(root.right);
	        
	        if(left.equals("leaf") || right.equals("leaf")) {
	            camera++;
	            return "with_camera_monitored";
	        }
	        
	        if(left.equals("monitored_without_cam") && right.equals("monitored_without_cam")) {
	            return "leaf";
	        }
	        
	        return "monitored_without_cam";
	    }
	    
	}
}
