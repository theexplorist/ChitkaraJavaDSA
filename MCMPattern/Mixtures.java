package MCMPattern;

public class Mixtures {

	private static int colorComb(int[] colors, int l, int r) {
		// TODO Auto-generated method stub

		int sum = 0;
		for(int i = l; i <= r; i++) {
			sum += colors[i];
		}
		
		return sum % 100;
	}
	
	private static int sol(int[] colors, int l, int r) {
		// TODO Auto-generated method stub

		if(l >= r) {
			return 0;
		}
		int minCost = Integer.MAX_VALUE;
		for(int part = l; part < r; part++) {
			int p1  = sol(colors, l, part);
			int p2 = sol(colors, part + 1, r);
			
			int indCost = colorComb(colors, l, part) * colorComb(colors, part + 1, r);
			int cost = p1 + p2 + indCost;
			
			minCost = Math.min(minCost, cost);
		}
		
		return minCost;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {40, 60, 20};
		
		System.out.println(sol(arr, 0, arr.length - 1));
	}

}
