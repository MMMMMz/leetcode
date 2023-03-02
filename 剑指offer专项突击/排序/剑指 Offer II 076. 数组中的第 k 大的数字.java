class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int target = n - k;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int p = partition(nums, left, right);
            if(p == target){
                return nums[p];
            } else if(p < target){
                left = p + 1;
            } else {
                right = p - 1;
            }
        }
        return 0;
    }
    
    int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        while(i <= j){
            while(i < right && nums[i] <= pivot) i++;
            while(j > left && nums[j] > pivot) j--;
            if(i >= j){
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
