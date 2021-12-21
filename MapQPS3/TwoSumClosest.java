package MapQPS3;

public class TwoSumClosest {

	private static int sol(int[] arr, int t) {
		// TODO Auto-generated method stub

		int l = 0, r = arr.length - 1;
		int closestS = arr[0] + arr[1];
		while(l < r) {
			int currS = arr[l] + arr[r];
			if(Math.abs(t - currS) < Math.abs(t - closestS)) {
				closestS = currS;
			}
			
			if(currS < t) {
				l++;
			} else {
				r--;
			}
			
		}
		
		return closestS;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {2, 5, 6, 8, 15};
		System.out.println(sol(arr, 11));
	}

}
