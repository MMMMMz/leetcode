class Solution {

    int getDays(int x, int[] weights){
        int days = 0;
        int len = weights.length;
        int count = 0;
        while(count < len){
            int temp = x;
            while(count < len){
                if(temp < weights[count]){
                    break;
                } else {
                    temp -= weights[count];
                }
                count++;
            }
            days++;
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 1;
        int right = 0;
        for(int w : weights){
            left = Math.max(left, w);
            right += w;
        } 

        while(left <= right){
            int mid = left - (left - right) / 2;
            if(getDays(mid, weights) <= days){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
