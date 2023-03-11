class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            preSum[i] = preSum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }
        map.put(0, 0);
        for(int i = 1 ; i <= n ; i++){
            if(map.containsKey(preSum[i])){
                ans = Math.max(ans, (i - map.get(preSum[i])));
            } else {
                map.put(preSum[i], i);
            }
        }

        return ans;
    }
}
