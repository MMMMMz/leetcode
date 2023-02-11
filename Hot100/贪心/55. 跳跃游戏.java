class Solution {
    public boolean canJump(int[] nums) {
        int maxDistance = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(maxDistance >= i){   //表示这个格子可以达到
                maxDistance = Math.max(maxDistance, nums[i] + i);
            }
        }
        return maxDistance >= nums.length - 1? true : false;
    }
}
