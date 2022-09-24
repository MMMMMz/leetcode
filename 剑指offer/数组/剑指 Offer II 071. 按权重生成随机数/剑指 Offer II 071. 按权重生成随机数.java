class Solution {

    int[] preSum;
    int total;

    public Solution(int[] w) {

        preSum = new int[w.length];
        preSum[0] = w[0];
        for(int i = 1 ; i < w.length ; i++)
        {
            preSum[i] = preSum[i - 1] + w[i];
        }

        total = preSum[w.length - 1];
    }
    
    public int pickIndex() {
        int target = (int)(Math.random() * total) + 1;
        int left = 0;
        int right = preSum.length;

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
