class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
      
    }

    int rob(int[] nums, int start, int end){
        int n = nums.length;
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);

        for(int i = start + 2; i <= end ; i++){
            int temp = second;
            second = Math.max(first + nums[i], temp);
            first = temp;
        }

        return second;
    }
}
