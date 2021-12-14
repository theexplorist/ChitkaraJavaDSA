package MapQps1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	private static List<List<String>> sol2(String[] arr) {
		// TODO Auto-generated method stub

		Map<String, List<String>> map = new HashMap<>();
		for(String str : arr) {
			StringBuilder sb = new StringBuilder();
			//str = "eat"
			int[] freq = new int[26];
			for(int i = 0; i < str.length(); i++) {
				char cc = str.charAt(i);
				int index = cc - 'a';
				freq[index]++;
			}
			
			for(int i = 0; i < 26; i++) {
				sb.append(freq[i]);
			}
		    //System.out.println(sb.toString());
			
			String sortString = Arrays.toString(freq);
			
			List<String> valueList = map.getOrDefault(sortString, new ArrayList<>());
			valueList.add(str);
			map.put(sortString, valueList);
		}
		
		System.out.println(map.values());
		List<List<String>> ans = new ArrayList<>();
		ans.addAll(map.values());
		return ans;
	}
	private static List<List<String>> sol(String[] arr) {
		// TODO Auto-generated method stub

		Map<String, List<String>> map = new HashMap<>();
		for(String str : arr) {
			//str = "eat"
			char[] strArr = str.toCharArray();//['e', 'a', 't']
			Arrays.sort(strArr);
			String sortStr = new String(strArr); //"aet"
			
//			if(map.containsKey(sortStr)) {
//				List<String> valueList = map.get(sortStr);
//				valueList.add(str);
//				map.put(sortStr, valueList);
//			} else {
//				List<String> valueList = new ArrayList<>();
//				valueList.add(str);
//				map.put(sortStr, valueList);
//			}
			
			List<String> valueList = map.getOrDefault(sortStr, new ArrayList<>());
			valueList.add(str);
			map.put(sortStr, valueList);
		}
		
		//System.out.println(map.values());
		List<List<String>> ans = new ArrayList<>();
		ans.addAll(map.values());
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] arr = {"aet", "eat","tea","tan","ate","nat","bat"};
		sol2(arr);
	}

}
