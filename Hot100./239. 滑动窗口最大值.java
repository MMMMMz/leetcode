class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[1]-a[1]));
        int[] res = new int[n - k + 1];
        int index = 0;
        for(int i = 0 ; i < n ; i++){
            pq.offer(new int[]{i, nums[i]});
            if(i >= k - 1){
                while(pq.peek()[0] <= i - k) pq.poll();
                res[index++] = pq.peek()[1];
            }
        }
        return res;
    }
}
