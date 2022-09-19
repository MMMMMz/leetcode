class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int slow = 0;
        int fast = nums.length - 1;
        while(slow < fast)
        {
            if(nums[slow] + nums[fast] == target){
                res[0] = nums[slow];
                res[1] = nums[fast];
                break;
            }
            
            if(nums[fast] + nums[slow]> target){
                fast--;
            } else{
                slow++;
            }
            
        }

        return res;
    }
}
