class Solution {

    int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return res;
    }

    void backtrack(int[] nums, int target, int index, int sum){
        if(index == nums.length){
            if(sum == target){
                res++;
            }
            return;
        }
        backtrack(nums, target, index + 1, sum + nums[index]);
        backtrack(nums, target, index + 1, sum - nums[index]);
    }
}
