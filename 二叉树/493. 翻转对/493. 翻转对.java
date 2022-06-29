class Solution {

    int temp[];
    int count = 0;

    public int reversePairs(int[] nums) {
        int n = nums.length;
        temp = new int[n];
        sort(nums, 0, n - 1);
        return count;
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
        int end = mid + 1;
        for(int i = low ; i <= hig ; i++)
        {
            temp[i] = nums[i];
        }

        for(int i = low ; i <= mid ; i++)
        {
            while(end <= hig && (long) nums[i] > (long) 2 * nums[end]){
                end++;
            }

            count += end - (mid + 1);
        }

        int i = low;
        int j = mid + 1;
        for(int p = low ; p <= hig ; p++)
        {
            if(i == mid + 1){
                nums[p] = temp[j++];
            } else if(j == hig + 1){
                nums[p] = temp[i++];
            } else if(temp[i] > temp[j]){   //是对temp数组进行排序然后放入nums数组
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }
}
