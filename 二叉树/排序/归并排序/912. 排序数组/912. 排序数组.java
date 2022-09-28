class Solution {

    int[] temp;

    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    void mergeSort(int[] nums, int low, int high)
    {
        if(low == high){
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    void merge(int[] nums, int low, int mid, int high)
    {
        for(int i = low ; i <= high ; i++)
        {
            temp[i] = nums[i];
        }
        
        int i = low;
        int j = mid + 1;
        for(int p = low ; p <= high ; p++)
        {
            if(i == mid + 1){
                nums[p] = temp[j++];
            } else if(j == high + 1){
                nums[p] = temp[i++];
            } else if(temp[i] > temp[j]){
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }
}
