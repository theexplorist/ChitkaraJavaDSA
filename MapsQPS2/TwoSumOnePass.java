package MapsQPS2;

import java.util.HashMap;
import java.util.Map;

public class TwoSumOnePass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {2, 7, 11, 15};
		
		Map<Integer, Integer> map = new HashMap<>();
		//key - arr[i], value - i
		int target = 14;
		
		int[] ans = new int[2];
		
		for(int i = 0; i < arr.length; i++) {
			int curr = arr[i];
			int diff  = target - curr;
			
			if(map.containsKey(diff)) {
				ans[0] = map.get(diff);
				ans[1] = i;
				break;
			}
			
			map.put(arr[i], i);
		}
	}

}
