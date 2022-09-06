class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if((sum < Math.abs(target)) || (target + sum) % 2 != 0){
            return 0;
        }
        return subsets(nums, (target + sum) / 2);
    }

    int subsets(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for(int i = 0; i < nums.length ; i++)
        {
            for(int j = sum ; j >= 0 ; j--)
            {
                if(j >= nums[i]){
                    dp[j] = dp[j] + dp[j - nums[i]];
                } 
            }
        }

        return dp[sum];
    }

}
