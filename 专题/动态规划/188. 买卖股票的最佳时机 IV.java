class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2 * k];
        for(int i = 0 ; i < k ; i++){
            dp[0][i * 2] = -prices[0];
        }

        for(int i = 1 ; i < n ; i++){
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            for(int j = 1 ; j < k ; j++){
                dp[i][j * 2] = Math.max(dp[i - 1][j * 2], dp[i - 1][j * 2 - 1] - prices[i]);
                dp[i][j * 2 + 1] = Math.max(dp[i - 1][j * 2 + 1], dp[i - 1][j * 2] + prices[i]);
            }
        }

        return dp[n - 1][k * 2 - 1];

    }
}
