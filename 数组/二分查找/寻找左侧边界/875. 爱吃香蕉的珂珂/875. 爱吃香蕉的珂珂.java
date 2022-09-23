class Solution {

    public long getHours(int k, int[] piles)
    {
        long hours = 0;
        for(int i = 0 ; i < piles.length ; i++)
        {
            hours += piles[i] / k;
            if(piles[i] % k != 0){
                hours++;
            }
        }
        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int c : piles){
            if(c > right) right = c;
        }

        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            long hours = getHours(mid, piles);
            if(hours <= h){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
