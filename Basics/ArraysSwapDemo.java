
public class ArraysSwapDemo {

	//global scope
	static int[] yashbeer = {4, 4, 4, 4}; 
	static int[] navjot = {3, 3, 3};
	
	
	private static void swap2() {
		// TODO Auto-generated method stub

		int[] temp = navjot;
		navjot = yashbeer;
		yashbeer = temp;
	}
	private static void swap1(int[] yashbeer, int[] navjot) {
		// TODO Auto-generated method stub

		int[] temp = navjot;
		navjot = yashbeer;
		yashbeer = temp;
		System.out.println("*********************");
		System.out.println("yashbeer ka address " + yashbeer);
		System.out.println("navjot ka address " + navjot);
		System.out.println("*********************");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] yashbeer = {4, 4, 4, 4};
//		int[] navjot = {3, 3, 3};
		
		System.out.println("yashbeer ka address " + yashbeer);
		System.out.println("navjot ka address " + navjot);
//		swap1(yashbeer, navjot);
		swap2();
		System.out.println("yashbeer ka address " + yashbeer);
		System.out.println("navjot ka address " + navjot);
	}

}
