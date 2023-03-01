class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int n = nums.length;
        for(int num : nums){
            sum += num;
        }
        int neg = (sum - target) / 2;
        if(sum - target < 0 || (sum - target) % 2 != 0){
            return 0;
        }
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j <= neg ; j++){
                    dp[i][j] = dp[i - 1][j];
                    if(j - nums[i - 1] >= 0){
                        dp[i][j] += dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
        
        return dp[n][neg];
    }
}
