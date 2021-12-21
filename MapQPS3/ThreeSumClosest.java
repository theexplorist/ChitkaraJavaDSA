package MapQPS3;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] arr, int t) {

		Arrays.sort(arr);
		int closestS = arr[0] + arr[1] + arr[2];
		for (int i = 0; i < arr.length - 2; i++) {
			int l = i + 1, r = arr.length - 1;
			// int closestS = arr[0] + arr[1] + arr[2];
			while (l < r) {
				int currS = arr[i] + arr[l] + arr[r];
				if (Math.abs(t - currS) < Math.abs(t - closestS)) {
					closestS = currS;
				}

				if (currS < t) {
					l++;
				} else {
					r--;
				}

			}
		}

		return closestS;
	}
}
