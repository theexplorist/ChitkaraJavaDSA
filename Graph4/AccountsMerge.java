package Graph4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {

	static class DSUUnoptimised {
		int V;
		private int[] parent;

		public DSUUnoptimised(int V) {
			// TODO Auto-generated constructor stub
			parent = new int[V];
			Arrays.fill(parent, -1);
		}

		private int find(int u) {// O(n)
			// TODO Auto-generated method stub

			if (parent[u] == -1) {
				return u;
			}
			return find(parent[u]);
		}

		private void union(int u, int v) {// O(n)
			// TODO Auto-generated method stub

			// step - 1 gf(u), gf(v)
			// step - 2 gf(u) != gf(v) -> p[gf(u)] = gf(v)
			int godFatherU = find(u);
			int godFatherV = find(v);

			if (godFatherU != godFatherV) {
				parent[godFatherU] = godFatherV;
			}
		}

	}

	public List<List<String>> accountsMerge(List<List<String>> accounts) {

		DSUUnoptimised dsu = new DSUUnoptimised(accounts.size());
		Map<String, Integer> emailImmParent = new HashMap<>();
		for (int v = 0; v < accounts.size(); v++) {
			List<String> currAcc = accounts.get(v);
			for (int i = 1; i < currAcc.size(); i++) {
				String currMail = currAcc.get(i);

				if (!emailImmParent.containsKey(currMail)) {
					emailImmParent.put(currMail, v);
				} else {
					dsu.union(v, emailImmParent.get(currMail));
				}

			}
		}
		
		System.out.println(emailImmParent);
		
		Map<Integer, List<String>> emailClubbed = new HashMap<>();
		for(String email : emailImmParent.keySet()) {
			int immParent = emailImmParent.get(email);
			int godfather = dsu.find(immParent);
			
			List<String> emails = emailClubbed.getOrDefault(godfather, new ArrayList<>());
			emails.add(email);
			Collections.sort(emails);
			emailClubbed.put(godfather, emails);
		}
		
		System.out.println(emailClubbed);
		
		List<List<String>> ans = new ArrayList<>();
		for(int v : emailClubbed.keySet()) {
			String accountName = accounts.get(v).get(0);
			List<String> emails = emailClubbed.get(v);
			emails.add(0, accountName);
			ans.add(emails);
		}
		return ans;
	}

}
