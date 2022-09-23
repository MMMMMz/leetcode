class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int res1 = -1;
        int res2 = -1;

        while(left <= right){
            int mid = left + (right - left ) / 2;
            if(nums[mid] == target){
               right = mid - 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if(left < nums.length){
            if(nums[left] == target){
                res1 = left;
            }   
        }
        

        left = 0;
        right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left ) / 2;
            if(nums[mid] == target){
               left = mid + 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if(left - 1 >= 0){
            if(nums[left - 1] == target){
                res2 = left - 1;
            }
        }
        
        if(res1 == -1 && res2 == -1){
            return 0;
        }
        return res2 - res1 + 1;
    }
}
