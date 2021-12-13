package MapInterface;

import java.util.HashMap;
import java.util.Map;

public class FreqMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 1, 1, 1000, 1000, 2, 1000 };
		Map<Integer, Integer> map = new HashMap<>();

		for (int e : arr) {
//			if(!map.containsKey(e)) {
//				map.put(e, 1);
//			} else {
//				int value = map.get(e);//get
//				value++;//inc
//				map.put(e, value);//map update
//				//map.put(e, map.get(e) + 1);
//			}

			int value = map.getOrDefault(e, 0);
			value++;
			map.put(e, value);
		}

		System.out.println(map);
	}

}
