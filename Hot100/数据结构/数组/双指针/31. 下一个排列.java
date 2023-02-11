class Solution {
    public void nextPermutation(int[] nums) {
        int left = nums.length - 2;
        int right = nums.length - 1;
        while(left >= 0){
            if(nums[left] < nums[left + 1]) break;
            left--;
        }
 
        if(left >= 0){
            while(right > 0){
                if(nums[right] > nums[left]) break;
                right--;
            }
            swap(nums, left, right);
        }
        reverse(nums, left + 1);
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int[] nums, int i){
        int j = nums.length - 1;
        while(i < j){
            swap(nums, i, j);
            ++i;
            --j;
        }
    }
}
