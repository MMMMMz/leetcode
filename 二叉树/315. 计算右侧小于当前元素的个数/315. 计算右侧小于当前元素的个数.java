class Solution {
    class Pair{
        int id;
        int val;
        Pair(int id, int val){
            this.val = val;
            this.id = id;
        }
    }
    int[] count;
    Pair[] temp;
    public List<Integer> countSmaller(int[] nums) {
        int numsLength = nums.length;
        List<Integer> res = new ArrayList();
        count = new int[numsLength];
        Pair[] arr = new Pair[numsLength];
        temp = new Pair[numsLength];
        for(int i = 0 ; i < numsLength ; i++)
        {
            arr[i] = new Pair(i, nums[i]);
        }
        mergeSort(arr, 0, numsLength - 1);
        for(int i = 0 ; i < count.length ; i++)
            res.add(count[i]);
        return res;
    }

    void mergeSort(Pair[] arr, int low, int high){
        if(low == high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    void merge(Pair[] arr, int low, int mid, int high){
        for(int i = low ; i <= high ; i++) temp[i] = arr[i];
        int i = low, j = mid + 1;
        for(int p = low ; p <= high ; p++)
        {
            if(i == mid + 1){
                arr[p] = temp[j++];
            }else if(j == high + 1){
                arr[p] = temp[i++];
                count[arr[p].id] += j - mid - 1;
            } else if(temp[i].val <= temp[j].val){
                arr[p] = temp[i++];
                count[arr[p].id] += j - mid - 1;
            } else {
                arr[p] = temp[j++];
            }
        }
    }
}
