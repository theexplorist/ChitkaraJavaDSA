
public class GlobalLocalDemo {

	static int yashbeer = 5;
	
	private static void india() {
		// TODO Auto-generated method stub

		int yashbeer = 7;//local ko prioritise
		System.out.println(yashbeer);
		System.out.println(GlobalLocalDemo.yashbeer);
	}
	
	private static void australlia() {
		// TODO Auto-generated method stub
		System.out.println(yashbeer);
	}
	
	
	private static void england() {
		// TODO Auto-generated method stub
		System.out.println(yashbeer);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(yashbeer);
//		england();
//		yashbeer = 4;
		india();
		england();
	}

	
}
