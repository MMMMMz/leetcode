class Solution {
    public int maxSubArray(int[] nums) {
       int n = nums.length;
       int[] preSum = new int[n + 1];
       preSum[0] = 0;
       for(int i = 1 ; i <= n ; i++)
       {
           preSum[i] = preSum[i - 1] + nums[i - 1];
       }
       int res = Integer.MIN_VALUE;
       int minVal = Integer.MAX_VALUE;

       for(int i = 1 ; i <= n ; i++)
       {
           minVal = Math.min(minVal, preSum[i - 1]);
           res = Math.max(res, preSum[i] - minVal);
       }

       return res;
    }
}
