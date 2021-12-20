package MapsQPS2;

import java.util.HashMap;
import java.util.Map;

public class TwoSumTwoPass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//buildingO(n) and searchingO(n) = O(2n)
		
		int[] arr = {2, 7, 11, 15};
		Map<Integer, Integer> map = new HashMap<>();
		//key - arr[i], value - i
		int target = 14;
		for(int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
		
		int[] ans = new int[2];
		for(int i = 0; i < arr.length; i++) {
			int curr = arr[i];
			int diff = target - curr;
			if(map.containsKey(diff) && i != map.get(diff)) {
				int index  = map.get(diff);
				ans[0] = i;
				ans[1] = index;
				//System.out.println(i + " " + index);
				break;
			}
		}
		
		
	}

}
