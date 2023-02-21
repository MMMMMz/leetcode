class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = nums[0];
        min[0] = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            max[i] = Math.max(nums[i], Math.max(max[i - 1] * nums[i], nums[i] * min[i - 1]));
            min[i] = Math.min(nums[i], Math.min(max[i - 1] * nums[i], nums[i] * min[i - 1]));
        }

        for(int i = 1 ; i < nums.length ; i++){
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
