class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int pre = 0;
        map.put(0, 1);
        for(int i = 0 ; i < nums.length ; i++){
            pre += nums[i];
            if(map.containsKey(pre - k)){
                res += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return res;
    }
}
