package DynamicProgramming2;

import java.util.List;

public class Triangles {

	private static int sol(List<List<Integer>> triangle, int cr, int cc) {
		// TODO Auto-generated method stub

		if(cr == triangle.size()) {
			return Integer.MAX_VALUE;
		}
		int c1 = sol(triangle, cr + 1, cc);
		int c2 = sol(triangle, cr + 1, cc + 1);
		
		return Math.min(c1, c2) + triangle.get(cr).get(cc);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
