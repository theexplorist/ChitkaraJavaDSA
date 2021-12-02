package DynamicProg3;

public class TillingProblem {

	private static int sol(int n) {
		// TODO Auto-generated method stub

		if(n < 0) {
			return 0;
		}
		if(n == 0) {
			return 1;
		}
		int c1 = sol(n - 1);
		int c2 = sol(n - 2);
		
		return c1 + c2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(sol(4));
	}

}
