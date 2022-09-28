class Solution {

    class Pair{
        int val;
        int index;

        Pair(int val, int index){
            this.val = val;
            this.index = index;
        }
    }

    List<Integer> res;
    Pair[] temp;
    Pair[] pair;
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        res = new ArrayList<>();
        temp = new Pair[nums.length];
        pair = new Pair[nums.length];
        count = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++)
        {
            pair[i] = new Pair(nums[i], i);
        }
        mergeSort(pair, 0, nums.length - 1);
        for(int c : count){
            res.add(c);
        }
        return res;
    }

    void mergeSort(Pair[] nums, int low, int high){
        if(low == high){
            return;
        }

        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    void merge(Pair[] nums, int low, int mid, int high)
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
                count[nums[p].index] += j - (mid + 1);
            } else if(temp[i].val > temp[j].val){
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
                count[nums[p].index] += j - (mid + 1);
            }
        }
    }
}
