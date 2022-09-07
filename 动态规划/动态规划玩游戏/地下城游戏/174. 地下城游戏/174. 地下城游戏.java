class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] < 0 ? -dungeon[m - 1][n - 1] + 1 : 1;

        for(int i = m - 2 ; i >= 0 ; i--){
            int res = dp[i + 1][n - 1] - dungeon[i][n - 1];
            dp[i][n - 1] = res <= 0 ? 1 : res;
        }

        for(int j = n - 2 ; j >= 0 ; j--){
            int res = dp[m - 1][j + 1] - dungeon[m - 1][j];
            dp[m - 1][j] = res <= 0 ? 1 : res;
        }

        for(int i = m - 2; i >= 0 ; i--)
        {
            for(int j = n - 2; j >= 0 ; j--)
            {
                if(dp[i][j] == 0){
                    int res = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                    dp[i][j] = res <= 0 ? 1 : res;
                }
                
            }
        }

        return dp[0][0];
    }
}
