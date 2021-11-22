package BST20_22Nov;

public class BSTClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTree bst = new BinarySearchTree();
		int[] arr = {10, 30, 35, 40, 50};
		
		bst.construct(arr);
		bst.display();
		System.out.println(bst.min());
	}

}
