package DynamicProgramming2;

import java.util.Arrays;

public class UniquePaths1 {

public int uniquePaths(int m, int n) {
        
        int[][] cache = new int[m][n];
        for(int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return uniquePathsR(m - 1, n - 1, cache);
    }
    
     public int uniquePathsR(int m, int n, int[][] cache) {
        
         if(m == 0 && n == 0) {
             return 1;
         }
         
         if(m < 0 || n < 0) {
             return 0;
         }
         
         if(cache[m][n] != -1) {
             return cache[m][n];
         }
         int c1 = uniquePathsR(m, n - 1, cache);
         int c2 = uniquePathsR(m - 1, n, cache);
         
         return cache[m][n] = c1 + c2;
    }
}
