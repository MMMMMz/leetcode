class Solution {
    public int[] twoSum(int[] nums, int target) {

        //最大的加最小的都比target大，所以最大的数舍弃；最小的加最大的都比target小，所以最小的舍弃


        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap();

        for(int i = 0 ; i < nums.length ; i++)
        {
            map.put(nums[i],nums[i]);
        }

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(map.containsKey(target - nums[i])){
                res[0] = nums[i];
                res[1] = target - nums[i];
                break;
            }
        }

        return res;
    }
}
