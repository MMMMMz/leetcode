class Solution {
    public int[] twoSum(int[] nums, int target) {

        //最大的加最小的都比target大，所以最大的数舍弃；最小的加最大的都比target小，所以最小的舍弃
        int[] res = new int[2];
        int slow = 0;
        int fast = nums.length - 1;
        while(slow < fast)
        {
            if(nums[slow] + nums[fast] == target){
                return new int[]{nums[slow], nums[fast]};
            }
            
            if(nums[fast] + nums[slow]> target){
                fast--;
            } else{
                slow++;
            }
            
        }

         return null;
    }
}
