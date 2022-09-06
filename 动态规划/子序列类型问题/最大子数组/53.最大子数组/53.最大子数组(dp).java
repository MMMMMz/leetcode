class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1 ; i < n ; i++)
        {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int res = -10001;
        for(int i = 0 ; i < n ; i++)
        {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
