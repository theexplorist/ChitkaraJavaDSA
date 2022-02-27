package StringAlgo;
import java.util.Arrays;

public class ManacherAlgo {

	private static String processS(String s) {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder();
		sb.append('^');
		for(int i = 0; i < s.length(); i++) {
			sb.append('#');
			sb.append(s.charAt(i));
		}
		
		sb.append("#$");
		
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "abacabb";
		
		String p = processS(s);
		int c = 0, r = 0;
		int[] orbit = new int[p.length()];
		int maxOrbitIn = 1;
		for(int i = 1; i <= p.length() - 2; i++) {
			
			int iDash = 2 * c - i;
			
			orbit[i] = i < r ? Math.min(orbit[iDash], r - i) : 0;
			while(p.charAt(i - 1 - orbit[i]) == p.charAt(i + 1 + orbit[i])) {
				orbit[i]++;
			}
			
			if(orbit[i] > orbit[maxOrbitIn]) {
				maxOrbitIn = i;
			}
			
			c = maxOrbitIn;
			r = maxOrbitIn + orbit[maxOrbitIn];
//			if(i + orbit[i] > r) {
//				c = i;
//				r = i + orbit[i];
//			}
		}
		
		System.out.println(Arrays.toString(orbit));
		System.out.println(orbit[maxOrbitIn]);
		int start = maxOrbitIn - orbit[maxOrbitIn];
		String lPP = p.substring(start, maxOrbitIn + orbit[maxOrbitIn] + 1);
		
		StringBuilder ans = new StringBuilder();
		
		for(int i = 0; i < lPP.length(); i++) {
			if(lPP.charAt(i) != '#') {
				ans.append(lPP.charAt(i));
			}
		}
		
		System.out.println(ans.toString());
	}

}
