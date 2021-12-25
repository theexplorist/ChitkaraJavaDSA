package Graph2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDic {

	public static String alienOrder(String[] words) {

		int[] indegree = new int[26];
		Map<Character, List<Character>> adJlist = new HashMap<>();
		for (String word : words) {
			for (char cc : word.toCharArray()) {
				adJlist.putIfAbsent(cc, new ArrayList<>());
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];// wrt
			String word2 = words[i + 1];// wrf
			if(word1.startsWith(word2) && word1.length() > word2.length()) {
				return "";
			}

			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					List<Character> neighbours = adJlist.get(word1.charAt(j));
					neighbours.add(word2.charAt(j));
					adJlist.put(word1.charAt(j), neighbours);
					indegree[word2.charAt(j) - 'a']++;
					break;
				}
			}

		}

		// topological sorting
		Queue<Character> bfs = new LinkedList<>();
		for (char v : adJlist.keySet()) {
			if (indegree[v - 'a'] == 0) {
				bfs.add(v);
			}
		}

		System.out.println(bfs);
		StringBuilder sb = new StringBuilder();
		while (!bfs.isEmpty()) {
			char front = bfs.poll();
			//System.out.print(front);
			sb.append(front);

			List<Character> neighbours = adJlist.get(front);
			for (char neighbour : neighbours) {
				indegree[neighbour - 'a']--;
				if (indegree[neighbour - 'a'] == 0)
					bfs.add(neighbour);
			}
		}
		//
		//System.out.println(Arrays.toString(indegree));
		//System.out.println(adJlist);
		return sb.toString().length() < adJlist.size() ? "" : sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] words = { "z", "x", "z", "ab"};
		System.out.println(alienOrder(words));
	}

}
