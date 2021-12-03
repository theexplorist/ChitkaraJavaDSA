package DP4;

public class HouseRobber2 {

	private int sol(int[] cost, int curr, boolean robbed0th, int n) {
		// TODO Auto-generated method stub

		//curr = 0, curr = n - 1
		int rob = 0;
		if(curr == 0) {
			rob = cost[curr] + sol(cost, curr + 2, true, n); 
		} else if(curr == n - 1) {
			if(!robbed0th) {
				rob = cost[curr] + sol(cost, curr + 2, robbed0th, n);
			}
		} else {
			rob = cost[curr] + sol(cost, curr + 2, robbed0th, n);
		}
		
		int dontRob = sol(cost, curr + 1, robbed0th, n);
		
		return Math.max(rob, dontRob);
	}
}
