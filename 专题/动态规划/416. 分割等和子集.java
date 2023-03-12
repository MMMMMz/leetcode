class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= target ; j++){
                dp[i][j] = dp[i - 1][j];
                if(nums[i - 1] == j){
                    dp[i][j] = true;
                    continue;
                }
                if(j - nums[i - 1] >= 0){
                     dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][target];
    }
}
