class Solution {

    class Pair{
        int id;
        int val;

        public Pair(int id, int val){
            this.id = id;
            this.val = val;
        }
    }

    Pair temp[];
    int count[];

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> res = new LinkedList<>();
        temp = new Pair[n];
        count = new int[n];
        Pair arr[] = new Pair[n];
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = new Pair(i, nums[i]);
        }

        sort(arr, 0, n - 1);
        for(int c : count){
            res.add(c);
        }
        return res;
    }

    void sort(Pair[] arr, int low, int hig){
        if(low == hig){
            return;
        }
        int mid = low + (hig - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, hig);
        merge(arr, low, mid, hig);
    }

    void merge(Pair[] arr, int low, int mid, int hig){
        for(int i = low ; i <= hig ; i++){
            temp[i] = new Pair(arr[i].id, arr[i].val);
        }

        int i = low;
        int j = mid + 1;
        for(int p = low ; p <=hig ; p++)
        {
            if(i == mid + 1){
                arr[p] = temp[j++];
            } else if(j == hig + 1){
                arr[p] = temp[i++];
                count[arr[p].id] += j - (mid + 1);
            } else if(temp[i].val > temp[j].val){
                arr[p] = temp[j++];
                
            } else {
                arr[p] = temp[i++];
                count[arr[p].id] += j - (mid + 1);
            }
        }
    }
}
