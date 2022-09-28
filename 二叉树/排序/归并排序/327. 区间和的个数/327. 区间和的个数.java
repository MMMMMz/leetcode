class Solution {

    int lower;
    int upper;
    long[] temp;
    long[] preSum;
    int res;

    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        temp = new long[nums.length + 1];
        preSum = new long[nums.length + 1];

        for(int i = 1 ; i < nums.length + 1; i++)
        {
            preSum[i] = preSum[i - 1] + (long)nums[i - 1];
        }

        mergeSort(preSum, 0, nums.length);

        return res;
    }

    void mergeSort(long[] nums, int low, int high)
    {
        if(low == high){
            return;
        }

        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    void merge(long[] nums, int low, int mid, int high){
        for(int i = low ; i <= high ; i++)
        {
            temp[i] = nums[i];
        }

        int start = mid + 1;
        int end = mid + 1;
        for(int i = low ; i <= mid ; i++)
        {
            while(start <= high && nums[start] - nums[i] < lower){
                start++;
            }   
            while(end <= high && nums[end] - nums[i] <= upper){
                end++;
            }
            res += (end - start);
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
