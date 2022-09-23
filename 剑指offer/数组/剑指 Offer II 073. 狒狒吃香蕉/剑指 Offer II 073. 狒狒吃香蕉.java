class Solution {

    int getHours(int[] piles, int k){
        int hours = 0;
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
        int right = -1;
        
        for(int t : piles){
            if(t > right){
                right = t;
            }
        }

        while(left <= right){
            int mid = left + (right - left) / 2;
            int hours = getHours(piles, mid);

            if(hours <= h){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
