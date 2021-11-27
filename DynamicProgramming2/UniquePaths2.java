package DynamicProgramming2;

import java.util.Arrays;

public class UniquePaths2 {

	public int uniquePathsWithObstacles(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;
		int[][] cache = new int[m][n];
		for (int[] row : cache) {
			Arrays.fill(row, -1);
		}
		return uniquePathsR(grid, m - 1, n - 1, cache);
	}

	public int uniquePathsR(int[][] grid, int m, int n, int[][] cache) {

		if (m < 0 || n < 0 || grid[m][n] == 1) {
			return 0;
		}

		if (m == 0 && n == 0) {
			return 1;
		}

		if (cache[m][n] != -1) {
			return cache[m][n];
		}
		int c1 = uniquePathsR(grid, m, n - 1, cache);
		int c2 = uniquePathsR(grid, m - 1, n, cache);

		return cache[m][n] = c1 + c2;
	}
}
