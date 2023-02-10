class Solution {
    public int numTrees(int n) {
        //卡特兰数Cn = Cn-1 * (4n-2)/n+1
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2 ; i <= n ; i++)
        {
            for(int j = 1 ; j <= i ; j++)
            {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
    
}
