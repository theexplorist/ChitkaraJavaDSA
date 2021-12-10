package DP6;

public class ArithmeticSlices {

	int ap;
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length == 1 || nums.length == 2) {
            return 0;
        }
        ap = 0;
        sol(nums, 0);
        return ap;
    }
    
    private int sol(int[] a, int i) {
		// TODO Auto-generated method stub

		if(i == a.length - 2) {
			return 0;
		}
		int ans = 0;
		if(a[i + 2] - a[i + 1] == a[i + 1] - a[i]) {
			ans = sol(a, i + 1) + 1;
            ap += ans;
		} else {
			sol(a, i + 1);
		}
		
		return ans;
	}
}
