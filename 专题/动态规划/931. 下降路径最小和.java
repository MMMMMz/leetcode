class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < n ; i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int left = Integer.MAX_VALUE;
                int mid =  dp[i - 1][j];
                int right = Integer.MAX_VALUE;
                if(j - 1 >= 0){
                    left = dp[i - 1][j - 1];
                }
                if(j + 1 < n){
                    right = dp[i - 1][j + 1];
                }
                dp[i][j] = matrix[i][j] + Math.min(left, Math.min(mid, right));
                
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            res = Math.min(res, dp[m - 1][i]);
        }
        return res;
    }
}
