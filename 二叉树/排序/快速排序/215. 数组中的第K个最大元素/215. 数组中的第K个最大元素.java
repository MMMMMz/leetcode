class Solution {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        int n = nums.length;
        k = n - k;
        int low = 0;
        int hig = n - 1;
        while(low <= hig)
        {
            int p = partition(nums, low, hig);
            if(p < k){
                low = p + 1;
            } else if(p > k){
                hig = p - 1;
            } else {
                return nums[p];
            }
        }

        return -1;
    }

    int partition(int[] nums, int low, int hig){
        int pivot = nums[low];
        int i = low + 1;
        int j = hig;
        while(i <= j){
            while(i < hig && nums[i] <= pivot){
                i++;
            }
            while(j > low && nums[j] > pivot){
                j--;
            }
            if(i >= j){
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    void shuffle(int[] nums){
        Random rand = new Random();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++)
        {
            int r = i + rand.nextInt(n - i);
            swap(nums, r, i);
        }
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
