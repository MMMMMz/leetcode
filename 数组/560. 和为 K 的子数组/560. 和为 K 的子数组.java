class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSum = new HashMap();
        int res = 0;
        preSum.put(0, 1);   //前缀和为0的有一组
        int nowSum = 0;
        for(int i = 0 ; i < nums.length; i++)
        {
            nowSum += nums[i];
            int temp = nowSum - k;

            if(preSum.containsKey(temp))    res += preSum.get(temp);

            preSum.put(nowSum, preSum.getOrDefault(nowSum, 0) + 1);
        }

        return res;
    }
}
