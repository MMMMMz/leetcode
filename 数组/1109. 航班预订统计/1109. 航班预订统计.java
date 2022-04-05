class Solution {

    int[] nums;
    int[] diff;
    public int[] corpFlightBookings(int[][] bookings, int n) {
        nums = new int[n];
        diff = new int[n];
        diff[0] = nums[0];
        for(int[] booking : bookings)
        {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            increment(i, j, val);
        }
        return result();
    }

    void increment(int i, int j, int val)
    {
        diff[i] += val;
        if(j + 1 < diff.length)    diff[j + 1] -= val;

    }

    int[] result()
    {   
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for(int i = 1; i < diff.length ; i++)
        {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

}
