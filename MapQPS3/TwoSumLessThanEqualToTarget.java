package MapQPS3;

public class TwoSumLessThanEqualToTarget {

	private static int sol(int[] arr, int target) {
		// TODO Auto-generated method stub

		int l = 0;
		int r = arr.length - 1;
		
		int count = 0;
		while(l < r) {
			if(arr[l] + arr[r] <= target) {
				count += (r - l);
				l++;
			} else {
				r--;
			}
		}
		
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {2, 5, 6, 8, 15};
		System.out.println(sol(arr, 10));
	}

}
