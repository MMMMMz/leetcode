class Solution {
    int[] preSum;
    Random rand = new Random();

    public Solution(int[] w) {
        preSum = new int[w.length + 1];
        for(int i = 1 ; i <= w.length ; i++)
        {
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
    }
    
    public int pickIndex() {
        int n = preSum.length;
        int target = rand.nextInt(preSum[n - 1]) + 1;
        int left = 0, right = n - 1;
        while(left <= right)
        {
            int mid = left - (left - right) / 2;
            if(preSum[mid] == target){
                right = mid - 1;
            } else if(preSum[mid] > target){
                right = right - 1;
            } else if(preSum[mid] < target){
                left = mid + 1;
            }
        }

        return left - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
