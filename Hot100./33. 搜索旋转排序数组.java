class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int n = nums.length;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[0] <= nums[mid]){
                if(target >= nums[0] && target < nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[n - 1]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
