class Solution {

    int[] nums;
    int[] diff;

    public boolean carPooling(int[][] trips, int capacity) {
        nums = new int[1001];
        diff = new int[1001];
        diff[0] = nums[0];
        for(int[] trip : trips)
        {
            int i = trip[1];
            int j = trip[2] - 1;
            int val = trip[0];

            increment(i, j, val);
        }

        int[] res = result();
        for(int i = 0 ; i < res.length ; i++)
        {
            if(res[i] > capacity) return false;
        }

        return true;
    }

    void increment(int i, int j, int val)
    {
        diff[i] += val;
        if(j + 1 < diff.length) diff[j +  1] -= val;
    }

    int[] result()
    {
        int[] res = new int[1001];
        res[0] = diff[0];
        for(int i = 1 ; i < res.length ; i++)
        {
            res[i] = res[i - 1] + diff[i]; 
        }
        return res;
    }
}
