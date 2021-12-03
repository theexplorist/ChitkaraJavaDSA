package DP4;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//key -> countryName(String) -> unique
		//value -> Population(Integer)
		Map<String, Integer> popMap = new HashMap<>();
		
		popMap.put("India", 300);
		System.out.println(popMap);
		popMap.put("India", 400);
		System.out.println(popMap);
		
		//value get -> arr[index]
		//value get corresponding to "India"
		int pop = popMap.get("India");
		System.out.println(pop);
		
		
		System.out.println(popMap.get("Sri Lanka"));
	}

}
