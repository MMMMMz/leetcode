class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        // Arrays.sort(coins);
        if(amount == 0){
            return 1;
        }
        for(int i = 0 ; i < n ; i++){
            if(coins[0] == 1){
                 dp[i][1] = 1;
            }
           
            dp[i][0] = 1;
        }
        for(int i = 2 ; i <= amount ; i++){
            if(i % coins[0] == 0){
                dp[0][i] = 1;
            }
        }
        
        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j <= amount ; j++){
                if(coins[i] <= j){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                
            }
        }

        return dp[n - 1][amount];
    }
}
