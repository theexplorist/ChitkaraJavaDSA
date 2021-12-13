package MapInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Collection<Integer> c = new Stack<>();
//		//Collection<Integer> c1 = new HashMap<>();
//		
//		Map<Integer, Integer> m = new HashMap<>();
//		HashMap<Integer, Integer> m1 = new HashMap<>();
		//country vs pop
		Map<String, Integer> map = new LinkedHashMap<>();//Insertion order is preserved
		System.out.println(map);
		
		//1.put(k, v) - Insert
		
		map.put("India", 200);
		System.out.println(map);
		
		map.put("India", 400); //overwrite/update
		System.out.println(map);
		
		//2.get(K) - gets value corresponding to a key, if not present returns null
		//It is not safe
		System.out.println(map.get("USA"));//null -> can cause npe
		
		//3.containsKey(k) -> true if k is present else false
		
		System.out.println(map.containsKey("India"));
		System.out.println(map.containsKey("Pak"));
		
		//get safety
		
		if(map.containsKey("USA")) {
			System.out.println(map.get("USA"));
		} else {
			System.out.println("USA abhi map mein ni hai");
		}
		
		map.put("USA", 100);
		map.put("NZ", 50);
		
		System.out.println(map);//insertion order is not preserved in hashmap
		//4. getOrDefault(k, default value)
		System.out.println(map.getOrDefault("India", 0)); //runs get because key is present
		
		//get safety 2
		
		System.out.println(map.getOrDefault("UK", 0));//runs default because key is not present
		
	//	map.put("ABC", null);
//		System.out.println(map);
		//System.out.println(map.getOrDefault("ABC", 0));
		
		//5. putIfAbsent(k, v)
		map.putIfAbsent("India", 500); //prevents updations
		System.out.println(map.get("India"));
		
		//6. Size()
		
		System.out.println(map.size());
		
		List<Integer> l = new ArrayList<>();
		
		for(int e : l) {
			System.out.println(e);
		}
		
		int[] arr = new int[5];
		for(int e : arr) {
			System.out.println(e);
		}
		
		Set<Integer> s = new HashSet<>();
		for(int e : s) {
			
		}
		
		var a = 5;
		var b = "Hello";
		//7. keySet()
		System.out.println(map.keySet());
		for(String key : map.keySet()) {
			System.out.println(key + "->" + map.get(key));
		}
		
		//8. entrySet()
		System.out.println(map.entrySet());
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			//System.out.println(entry);
			//9. getKey()
			System.out.println(entry.getKey() + "->" + entry.getValue());
			//10. getValue()
			//System.out.println(entry.getValue());
		}
		
		//11. values()
		System.out.println(map.values());
		for(int value : map.values()) {
			
		}
	}

}
