class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        int res = 0;
        preSum[0] = 0;
        for(int i = 1 ; i < nums.length + 1 ; i++)
        {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for(int i = 1 ; i < nums.length + 1; i++)
        {
            for(int j = 0 ; j < i ; j++)
            {
                if(preSum[i] - preSum[j] == k) res++;
            }
        }

        return res;
    }
}
