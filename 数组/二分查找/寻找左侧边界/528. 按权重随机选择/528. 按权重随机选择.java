class Solution {

    int total;
    int[] preSum;

    public Solution(int[] w) {
        int n = w.length;
        preSum = new int[n];
        preSum[0] = w[0];
        for(int i = 1 ; i < n ; i++)
        {
            preSum[i] = preSum[i - 1] + w[i];
        }

        total = Arrays.stream(w).sum();
    }
    
    public int pickIndex() {
        int target = (int) (Math.random() * total) + 1;
        int left = 0;
        int right = preSum.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(preSum[mid] >= target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
