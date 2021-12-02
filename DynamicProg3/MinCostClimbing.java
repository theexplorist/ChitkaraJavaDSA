package DynamicProg3;

public class MinCostClimbing {

	private static int sol(int[] cost, int curr, int n) {
		// TODO Auto-generated method stub

		if(curr >= n) {
			return 0;
		}
		int c1 = sol(cost, curr + 1, n);
		int c2 = sol(cost, curr + 2, n);
		
		return Math.min(c1, c2) + cost[curr];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] cost = {10, 15, 20};
		
		int s0 = sol(cost, 0, cost.length);
		int s1 = sol(cost, 1, cost.length);
		
		System.out.println(Math.min(s0, s1));
	}

}
