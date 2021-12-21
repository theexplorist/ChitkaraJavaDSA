package MapQPS3;

import java.util.HashMap;
import java.util.Map;

public class LongConsSeq {

	public int longestConsecutive(int[] nums) {

		if (nums.length < 1) {
			return 0;
		}
		Map<Integer, Boolean> map = new HashMap<>();
		// kya arr[i] starting hai seq ka?

		for (int e : nums) {
			map.put(e, true);
		}

		int maxL = 0;
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i] - 1)) {
				map.put(nums[i], false);
			} else {
				int currL = 1;

				while (map.containsKey(nums[i] + currL)) {
					currL++;
				}

				maxL = Math.max(maxL, currL);
			}
		}

//         //System.out.println(map);

//         for(int i = 0; i < nums.length; i++) {
//             if(map.get(nums[i]) == true) {//seq starting from nums[i], then calc the length
//                 int currL = 1;

//                 while(map.containsKey(nums[i] + currL)) {
//                     currL++;
//                 }

//                 maxL = Math.max(maxL, currL);
//             }
//         }
		return maxL;
	}
	
	
}
