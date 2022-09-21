class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        int[] res = new int[1001];

        for(int i = 0 ; i < trips.length ; i++)
        {
            int incre = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2];

            nums[start] -= incre;
            nums[end] += incre;
        }

       res[0] = nums[0];
       for(int i = 1 ; i < nums.length ; i++)
       {
           if(res[0] + capacity < 0){
               return false;
           }
           res[i] = res[i - 1] + nums[i];
           if(res[i] + capacity < 0){
               return false;
           }
       }
       
       return true;
    }
}
