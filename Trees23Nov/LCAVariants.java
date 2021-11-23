package Trees23Nov;

public class LCAVariants {

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
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node parent;
	};
	public Node lowestCommonAncestor(Node p, Node q) {
        Node temp = p;
        Node root = getRoot(temp);
        
        System.out.println(root.val);
        return lca1(root, p, q);
    }
    
    public Node getRoot(Node temp) {
        
        while(temp.parent != null) {
            temp = temp.parent;
        }
        
        return temp;
    }
    
    private Node lca1(Node root, Node p, Node q) {
		// TODO Auto-generated method stub

		if(root == null) {
			return null;
		}
		if(root.val == p.val || root.val == q.val) {
			return root;
		}
		
		Node leftAns = lca1(root.left, p, q);
		Node rightAns = lca1(root.right, p, q);
		
		if(leftAns != null && rightAns != null) {
			return root;
		}
		
		if(leftAns == null) {
			return rightAns;
		}
		
		return leftAns;
	}
    
    boolean pExist;
    boolean qExist;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pExist = false;
        qExist = false;
        
        TreeNode lca = lCAHelper(root, p, q);
        return pExist && qExist ? lca : null;
    }
    
    public TreeNode lCAHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
			return null;
		}
		
		TreeNode leftAns = lCAHelper(root.left, p, q);
		TreeNode rightAns = lCAHelper(root.right, p, q);
		
        if(root.val == p.val) {
            pExist = true;
            return root;
        }
        
        if(root.val == q.val) {
            qExist = true;
            return root;
        }
        
		if(leftAns != null && rightAns != null) {
			return root;
		}
		
		if(leftAns == null) {
			return rightAns;
		}
		
		return leftAns;
    }
}
