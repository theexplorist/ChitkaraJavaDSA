package DynamicProgramming2;

public class LCS {

	private static int sol(String s, String t, int currS, int currT) {
		// TODO Auto-generated method stub

		if(currS == s.length() || currT == t.length()) {
			return 0;
		}
		if(s.charAt(currS) == t.charAt(currT)) {
			return sol(s, t, currS + 1, currT + 1) + 1;
		} else {
			int c1 = sol(s, t, currS + 1, currT);
			int c2 = sol(s, t, currS, currT + 1);
			return Math.max(c1, c2);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "ace";
		String t = "aec";
		System.out.println(sol(s, t, 0, 0));
	}

}
