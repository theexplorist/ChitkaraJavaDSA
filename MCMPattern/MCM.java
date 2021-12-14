package MCMPattern;

public class MCM {

	private static int sol(int[] arr, int l, int r) {
		// TODO Auto-generated method stub

		if(l >= r) {
			return 0;
		}
		
		int mincost = Integer.MAX_VALUE;
		for(int part = l; part < r; part++) {
			int p1 = sol(arr, l, part);
			int p2 = sol(arr, part + 1, r);
			
			int cost = p1 + p2 + arr[l - 1] * arr[part] * arr[r];
			mincost = Math.min(mincost, cost);
		}
		
		return mincost;
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		
		System.out.println(sol(arr, 1, arr.length - 1));
	}
}
