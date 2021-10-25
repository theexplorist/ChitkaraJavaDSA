package BinarySearchTree;

public class BSTClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {10, 20, 30, 40, 50, 60, 70};
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.construct(arr);
		System.out.println(bst.search(10));
		//bst.display();
		//System.out.println(bst.max());
		System.out.println("***********************");
//		for(int val : arr) {
//			bst.insert(val);
//		}
//		//bst.insert(35);
//		bst.display();
	}

}
