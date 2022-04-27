class Solution {

    int getDay(int x, int nums[]){
        int days = 0;
        int count = 0;
        int len = nums.length;
        while(count < len){
            int temp = x;
            while(count < len){
                if(temp < nums[count]) break;
                else temp -= nums[count];
                count++;
            }
            days++;
        }
        return days;
    }

    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;
        for(int c : nums){
            left = Math.max(left, c);
            right += c;
        }

        while(left <= right)
        {
            int mid = left - (left - right) / 2;
            if(getDay(mid, nums) <= m){
                right = mid - 1;
            } else {
                left = left + 1;
            }
        }
        return left;
    }
}
