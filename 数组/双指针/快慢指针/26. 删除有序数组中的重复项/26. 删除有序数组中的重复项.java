class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        //使用快慢指针，重复的元素一定是相邻的
        while(fast < nums.length)
        {
            if(nums[fast] != nums[slow]){
                 slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
        }
            fast++;
        }

        return slow + 1;
    }
}
