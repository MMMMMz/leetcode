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
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;
        
        
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = sum ; j >= 0 ; j--)
            {
                if(j - nums[i] >= 0){
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }
}
