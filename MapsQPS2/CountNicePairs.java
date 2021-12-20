package MapsQPS2;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairs {

	public int rev(int x) {
		int c = 0;
		while (x != 0) {
			int r = x % 10;
			c = c * 10 + r;
			x = x / 10;
		}
		return c;
	}

	private void sol(int[] arr) {
		// TODO Auto-generated method stub

		//diff(arr[i] - rev(arr[i]) vs count
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			int curr = arr[i];
			int diff = curr - rev(curr);
			
			if(map.containsKey(diff)) {
				count += map.get(diff);
			}
			
			map.put(diff, map.getOrDefault(diff, 0) + 1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
