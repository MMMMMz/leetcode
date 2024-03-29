class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 1 ; i <= n ; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        map.put(0, 1);
        for(int i = 1 ; i <= n ; i++){

            if(map.containsKey(preSum[i] - k)){
                res += map.get(preSum[i] - k);
            }
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        
        return res;
    }
}
