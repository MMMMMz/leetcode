class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] nums : matrix){
            if(binarySearch(nums, target)){
                return true;
            }
        }
        return false;
    }

    boolean binarySearch(int[] nums, int target){
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return true;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
