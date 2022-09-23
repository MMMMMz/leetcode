class Solution {

    int getDays(int[] weights, int k){
        int days = 1;
        int temp = k;

        for(int i = 0 ; i < weights.length ; i++)
        {
            if(temp - weights[i] < 0){
                days++;
                temp = k;
            }
            temp -= weights[i];
        }

        return days;
    }

    public int shipWithinDays(int[] weights, int days) {

        int left = 1;
        int right = 0;
        for(int t : weights){
            //left最小应该能将最大的在一天运过去
            left = Math.max(left, t);
            right = right + t;
        }
        while(left <= right){

            int mid = left + (right - left) / 2;
            int day = getDays(weights, mid);
            if(day <= days){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
