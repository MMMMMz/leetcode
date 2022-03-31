class Solution {
    public int[] sortArray(int[] nums) {
        shuffle(nums);
        qucickSort(nums, 0 , nums.length - 1);
        return nums;
    }
    void qucickSort(int[] nums, int low, int high){
        if(low >= high) return;
        int p = partition(nums, low, high);
        qucickSort(nums, low, p - 1);
        qucickSort(nums, p + 1, high);
    }

    int partition(int[] nums, int low, int high){
        int pivot  = nums[low];
        int i = low + 1;
        int j = high;
        while(i <= j)
        {
            while(i < high && nums[i] <= pivot) i++;
            while(j > low && nums[j] > pivot) j--;
            if(i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    void shuffle(int[] nums)
    {
        Random rand = new Random();
        for(int i = 0 ; i < nums.length ; i++)
        {
            int r  = i + rand.nextInt(nums.length - i);
            swap(nums, i, r);
        }
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
