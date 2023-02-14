class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        if(nums.length == 3){
            return Math.max(nums[0] + nums[2], nums[1]);
        }
        int[] dp = new int[nums.length];
        int res = 0;
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = dp[0] + nums[2];
        for(int i = 3 ; i < nums.length ; i++){
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }
        for(int num : dp){
            if(res < num){
                res = num;
            }
        }
        return res;
    }
}
