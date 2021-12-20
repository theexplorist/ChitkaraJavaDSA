package MapsQPS2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderLeetcode {
	class Solution {
		class TreeNode {

			int val;
			TreeNode left;
			TreeNode right;

			TreeNode() {
			}

			TreeNode(int val) {
				this.val = val;
			}

			TreeNode(int val, TreeNode left, TreeNode right) {
				this.val = val;
				this.left = left;
				this.right = right;
			}
		}

		class Pair {
			TreeNode node;
			int vLvl;
			int hLvl;

			public Pair(TreeNode node, int vLvl, int hLvl) {
				this.node = node;
				this.vLvl = vLvl;
				this.hLvl = hLvl;
			}
		}

		class Lvl {
			int val;
			int hLvl;

			public Lvl(int val, int hLvl) {
				this.val = val;
				this.hLvl = hLvl;
			}

			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return this.val + "";
			}
		}

		public List<List<Integer>> verticalTraversal(TreeNode root) {

			Queue<Pair> bfs = new LinkedList<>();

			bfs.add(new Pair(root, 0, 0));
			Map<Integer, List<Lvl>> map = new TreeMap<>();
			while (!bfs.isEmpty()) {
				Pair front = bfs.poll();
				TreeNode curr = front.node;
				int vLvl = front.vLvl;
				int hLvl = front.hLvl;
				List<Lvl> list = map.getOrDefault(vLvl, new ArrayList<>());
				list.add(new Lvl(curr.val, hLvl));

				map.put(vLvl, list);
				if (curr.left != null) {
					bfs.add(new Pair(curr.left, vLvl - 1, hLvl + 1));
				}

				if (curr.right != null) {
					bfs.add(new Pair(curr.right, vLvl + 1, hLvl + 1));
				}
			}

			List<List<Integer>> ans = new ArrayList<>();
			for (List<Lvl> l : map.values()) {
				Collections.sort(l, new Comparator<Lvl>() {

					@Override
					public int compare(Solution.Lvl o1, Solution.Lvl o2) {
						// TODO Auto-generated method stub
						if (o1.hLvl == o2.hLvl)
							return o1.val - o2.val;
						return 0;
					}
				});

				List<Integer> res = new ArrayList<>();
				for (Lvl e : l) {
					res.add(e.val);
				}

				ans.add(res);
				System.out.println(res);
			}

			return ans;
		}
	}
}
