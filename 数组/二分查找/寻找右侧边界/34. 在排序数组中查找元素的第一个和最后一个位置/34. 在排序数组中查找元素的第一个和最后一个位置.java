class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                right = mid - 1;
            } else if(nums[mid] > target){
                right = right - 1;
            } else {
                left = mid + 1;
            }
        }
        if(left < nums.length && nums[left] == target){
            res[0] = left;
        } else {
            res[0] = -1;
        }

        left = 0;
        right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                left = mid + 1;
            } else if(nums[mid] > target){
                right = right - 1;
            } else {
                left = mid + 1;
            }
        }
        if(left - 1 >= 0 && nums[left - 1] == target){
            res[1] = left - 1;
        } else {
            res[1] = -1;
        }

        return res;
    }
}
