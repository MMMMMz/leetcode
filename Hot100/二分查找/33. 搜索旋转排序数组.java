class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] - nums[0] >= 0){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(target <= nums[right] && target > nums[mid]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
