package MapQPS3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < arr.length - 2; i++) {
			
			if(i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			int l = i + 1, r = arr.length - 1;
			while(l < r) {
				if(arr[i] + arr[l] + arr[r] == 0) {
                    ans.add(Arrays.asList(arr[i], arr[l], arr[r]));
					//System.out.println(arr[i] + " " + arr[l] + " " + arr[r]);
					l++;
					r--;
					while(l < r && arr[l] == arr[l - 1]) {
						l++;
					}
				} else if(arr[i] + arr[l] + arr[r] < 0) {
					l++;
				} else {
					r--;
				}
			}
		}
        
        return ans;
    }

	public static void main(String[] args) {
		int[] arr = { -3, -3, 0, 6 };
		
	}
}
