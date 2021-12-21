package MapQPS3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public List<List<Integer>> fourSum(int[] arr, int t) {

		Arrays.sort(arr);
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < arr.length - 3; i++) {

			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < arr.length - 2; j++) {
				if (j > i + 1 && arr[j] == arr[j - 1]) {
					continue;
				}
				int l = j + 1, r = arr.length - 1;
				while (l < r) {
					if (arr[i] + arr[j] + arr[l] + arr[r] == t) {
						ans.add(Arrays.asList(arr[i], arr[j], arr[l], arr[r]));
						System.out.println(arr[i] + " " + arr[j] + " " + arr[l] + " " + arr[r]);
						l++;
						r--;
						while (l < r && arr[l] == arr[l - 1]) {
							l++;
						}
					} else if (arr[i] + arr[j] + arr[l] + arr[r] < t) {
						l++;
					} else {
						r--;
					}
				}
			}
		}

		return ans;
	}
}
