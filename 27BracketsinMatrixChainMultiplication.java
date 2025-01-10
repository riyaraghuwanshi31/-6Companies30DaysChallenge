
class Solution {
    static String matrixChainOrder(int arr[]) {
        // code here
         int n = arr.length;
        
        // dp[i][j] will store the minimum number of multiplications needed to multiply matrices i to j
        int[][] dp = new int[n - 1][n - 1];
        
        // split[i][j] will store the index of matrix at which the split occurs
        int[][] split = new int[n - 1][n - 1];
        
        // Length of the chain
        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                
                // Try all possible positions for the split
                for (int k = i; k < j; k++) {
                    int q = dp[i][k] + dp[k + 1][j] + arr[i] * arr[k + 1] * arr[j + 1];
                    if (q < dp[i][j]) {
                        dp[i][j] = q;
                        split[i][j] = k;
                    }
                }
            }
        }
        
        // Return the optimal multiplication order as a string
        return constructOrder(split, 0, n - 2);
    }
    
    
     private static String constructOrder(int[][] split, int i, int j) {
        if (i == j) {
            return String.valueOf((char) ('A' + i));
        } else {
            String left = constructOrder(split, i, split[i][j]);
            String right = constructOrder(split, split[i][j] + 1, j);
            return "(" + left + right + ")";
        }
    }

}
