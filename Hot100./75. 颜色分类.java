class Solution {
    public void sortColors(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void sort(int[] nums, int left, int right)
    {
        if(left > right) return;
        int p = partition(nums, left, right);
        sort(nums, left, p - 1);
        sort(nums, p + 1, right);
    }

    int partition(int[] nums, int left, int right)
    {
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        while(i <= j)
        {
            while(i < right && nums[i] <= pivot) i++;
            while(j > left && nums[j] > pivot) j--;
            if(i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }
}
