package MapQPS3;

public class TwoSumUniquePairs {

	private static int sol(int[] arr, int target) {
		// TODO Auto-generated method stub

		int l = 0, r = arr.length - 1;
		int count = 0;
		while(l < r) {
			if(arr[l] + arr[r] == target) {
				System.out.println(arr[l] + " " + arr[r]);
				l++;
				r--;
				count++;
				while(l < r && arr[l] == arr[l - 1]) {
					l++;
				}
			} else if(arr[l] + arr[r] < target) {
				l++;
			} else {
				r--;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {2, 2, 3, 24, 25, 25};
		System.out.println(sol(arr, 27));
	}

}
