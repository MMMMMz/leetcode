class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] preSum = new int[nums.length + 1];
        int res = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        preSum[0] = 0;
        for(int i = 1 ; i <= nums.length ; i++)
        {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for(int i = 1 ; i <= nums.length ; i++)
        {
            minVal = Math.min(minVal, preSum[i - 1]);
            res = Math.max(res, preSum[i] - minVal);
        }

        return res;
    }
}
