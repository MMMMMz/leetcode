class Solution {

    int[][] dpTable;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix[0].length;
        int res = Integer.MAX_VALUE;
        dpTable = new int[n][n];
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                dpTable[i][j] = matrix[i][j];
            }
        }
        dp(matrix);
        for(int j = 0 ; j < n ; j++)
        {
            res = Math.min(res, dpTable[n - 1][j]);
        }
        return res;

    }

    int min(int a, int b, int c){
        return Math.min(a, Math.min(b,c));
    }

    void dp(int matrix[][]){
        for(int m = 1 ; m < matrix.length ; m++)
        {
            for(int n = 0 ; n < matrix.length ; n++)
            {
               if(n - 1 < 0){
                dpTable[m][n] = Math.min(dpTable[m - 1][n], dpTable[m - 1][n + 1]) + dpTable[m][n];
               } else if(n + 1 == matrix.length){
                dpTable[m][n] = Math.min(dpTable[m - 1][n - 1], dpTable[m - 1][n]) + dpTable[m][n];
               } else {
                dpTable[m][n] = min(dpTable[m - 1][n - 1], dpTable[m - 1][n], dpTable[m - 1][n + 1]) + dpTable[m][n];
               }
            }
        }
    }

}
