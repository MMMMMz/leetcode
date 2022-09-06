class Solution {

    int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix[0].length;
        int res = Integer.MAX_VALUE;
        memo = new int[n][n];
        for(int i = 0 ; i < n ; i++)
        {
            Arrays.fill(memo[i], 66666);
        }
        for(int j = 0 ; j < n ; j++)
        {
            res = Math.min(res, dp(matrix, n - 1, j));
        }
        return res;

    }

    int min(int a, int b, int c){
        return Math.min(a, Math.min(b,c));
    }

    int dp(int matrix[][], int i, int j){
        if(i < 0 || j < 0 || j >= matrix.length){
            return 9999;
        }
        if(i == 0){
            return matrix[0][j];
        }
        if(memo[i][j] != 66666){
            return memo[i][j];
        }

        memo[i][j] = matrix[i][j] + min(dp(matrix, i - 1, j - 1), dp(matrix, i - 1, j), dp(matrix, i - 1, j + 1));
        return memo[i][j];
    }

}
