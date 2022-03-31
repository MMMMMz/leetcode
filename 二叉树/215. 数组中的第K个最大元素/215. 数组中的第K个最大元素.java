class Solution {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        int low = 0;
        int high = nums.length - 1;
        k = nums.length - k;
        while(low <= high)
        {
            int p = partition(nums, low, high);
            if(p < k){
                low = p + 1;
            } else if(p > k){
                high = p - 1;
            } else {
                return nums[p];
            }
        }
        return 0;
    }

    int partition(int[] nums, int low, int high)
    {
        int pivot = nums[low];
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
        Random random = new Random();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++)
        {
            int r = i + random.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
