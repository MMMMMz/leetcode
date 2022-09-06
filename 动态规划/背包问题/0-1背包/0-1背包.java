int knapsack(int W, int N, int[] wt, int[] val) {
  int[][] dp = new int[N][W];
  
  for(int i = 1 ; i <= N ; i++)
  {
    for(int j = 1 ; j <= W ; j++)
    {
      if(j - wt[i - 1] < 0)
      {
        dp[i][j] = dp[i - 1][j];
      } else {
        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1] + val[i - 1]);
      }
    }
  }
}
