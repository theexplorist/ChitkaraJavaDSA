package DynamicProg3;

public class MinFallingPathSum2 {

	public int minFallingPathSum(int[][] matrix) {

		int ans = Integer.MAX_VALUE;
		for (int cc = 0; cc < matrix.length; cc++) {

			ans = Math.min(ans, sol(matrix, 0, cc, matrix.length - 1, matrix.length - 1));
		}
		return ans;
	}

	public int sol(int[][] grid, int cr, int cc, int er, int ec) {

		if (cr == er) {
			return grid[cr][cc];
		}

		int ans = Integer.MAX_VALUE;
		for (int col = 0; col < grid.length; col++) {
			if (cc != col) {
				ans = Math.min(ans, sol(grid, cr + 1, col, er, ec));
			}
		}

		return ans + grid[cr][cc];
	}
}
