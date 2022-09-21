class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        int[] res = new int[n];

        for(int i = 0 ; i < bookings.length ; i++)
        {
            int start = bookings[i][0];
            int end = bookings[i][1];
            int incre = bookings[i][2];

            diff[start - 1] += incre;
            if(end < n){
                diff[end] -= incre;
            }
        }

        res[0] = diff[0];
        for(int i = 1 ; i < n ; i++)
        {
            res[i] = res[i - 1]  + diff[i];
        }

        return res;
    }
}
