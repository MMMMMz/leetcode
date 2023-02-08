class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1){
            return;
        }
        int i, j;
        for(i = nums.length - 2 ; i >= 0 ; i--)
        {
            if(nums[i] < nums[i + 1]){
                break;
            }
        }
        if(i >= 0){
            for(j = nums.length - 1 ; j > 0 ; j--){
                if(nums[j] > nums[i]){
                    break;
                }
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int[] nums, int left){
        int right = nums.length - 1;
        while(left < right){
            swap(nums, left, right);
            ++left;
            --right;
        }
    }
}
