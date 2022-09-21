class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        int[] diff = new int[length];
        int[] res = new int[length];
        diff[0] = nums[0];
        

        for(int i = 1 ; i < length ; i++)
        {
            diff[i] = nums[i] - nums[i - 1];
        }

        for(int i = 0 ; i < updates.length ; i++)
        {
            int start = updates[i][0];
            int end = updates[i][1];
            int incre = updates[i][2];

            diff[start] += incre;
            if(end + 1 < length){
                 diff[end + 1] -= incre;
            }
        }
        res[0] = diff[0];
        for(int i = 1 ; i < length ; i++)
        {
            res[i] =  res[i - 1] + diff[i];
        }

        return res;
    }
}
