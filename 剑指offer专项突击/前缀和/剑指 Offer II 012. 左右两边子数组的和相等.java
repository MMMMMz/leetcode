class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int[] preSum = new int[n + 1];
        for(int i = 1; i <= n ; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for(int i = 1 ; i <= n ; i++){
            if(preSum[i - 1] == preSum[n] - preSum[i]){
                return i - 1;
            }
        }
        return -1;
    }
}
