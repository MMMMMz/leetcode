class Solution {
    public int[] sortArray(int[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    void sort(int[] nums, int low, int hig){
        if(low >= hig){
            return;
        }

        int p = partition(nums, low, hig);
        sort(nums, low, p - 1);
        sort(nums, p + 1, hig);
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
        for(int i = 0 ; i < n ; i++){
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
