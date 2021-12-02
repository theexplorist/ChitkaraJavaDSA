package DynamicProg3;

public class MinFallingPathSum1 {

public int minFallingPathSum(int[][] matrix) {
        
        int ans = Integer.MAX_VALUE;
        for(int cc = 0; cc < matrix.length; cc++) {
            ans = Math.min(ans, sol(matrix, 0, cc, matrix.length - 1, matrix.length - 1));
        }
        return ans;
    }
    
    public int sol(int[][] matrix, int cr, int cc, int er, int ec) {
        
        if(cr > er || cc > ec || cc < 0) {
            return Integer.MAX_VALUE;
        }
        
        if(cr == er) {
            return matrix[cr][cc];
        }
        
        int c1 = sol(matrix, cr + 1, cc - 1, er, ec);
        int c2 = sol(matrix, cr + 1, cc, er, ec);
        int c3 = sol(matrix, cr + 1, cc + 1, er, ec);
        
        return Math.min(c1, Math.min(c2, c3)) + matrix[cr][cc];
    }
}
