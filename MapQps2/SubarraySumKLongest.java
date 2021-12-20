package MapQps2;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumKLongest {

	private static void sol(int[] arr, int k) {
		// TODO Auto-generated method stub

		int sum = 0;
		//int l = -1, r = -1;
		int maxL = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			
			//case 1
			if(sum == k) {//sum[0, i] = 0 
				int currL = i + 1;
				maxL = Math.max(maxL, currL);
			} else if(map.containsKey(sum - k)) { //case 2 -> repeating sum case
				
//				l = map.get(sum) + 1;
//				r = i;
//				int currL = r - l + 1;
				
				int currL = i - map.get(sum - k);
				maxL = Math.max(maxL, currL);
			} 
			
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
		} 
		
		System.out.println(maxL);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
