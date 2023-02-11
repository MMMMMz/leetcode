class Solution {
    public int maxSubArray(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for(int i = 1 ; i <= nums.length ; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int minVal = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 1 ; i <= nums.length ; i++){
            minVal = Math.min(minVal, preSum[i - 1]);   //得从0开始
            max = Math.max(max, preSum[i] - minVal);
        }
        return max;
    }
}
