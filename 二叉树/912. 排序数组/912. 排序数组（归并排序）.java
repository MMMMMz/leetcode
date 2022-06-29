class Solution {

    int[] temp;

    public int[] sortArray(int[] nums) {

        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    void sort(int[] nums, int low, int hig){
        if(low == hig){
            return;
        }

        int mid = low + (hig - low) / 2;
        sort(nums, low, mid);
        sort(nums, mid + 1, hig);
        merge(nums, low, mid, hig);
    }

    void merge(int[] nums, int low, int mid, int hig){
        for(int i = low ; i <= hig ; i++)
        {
            temp[i] = nums[i];
        }

        int i = low;
        int j = mid + 1;
        for(int p = low ; p <= hig ; p++)
        {
            if(i == mid + 1){
                nums[p] = temp[j++];
            } else if(j == hig + 1){
                nums[p] = temp[i++];
            } else if(temp[i] > temp[j]){
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }
}
