class Solution {
    public int lengthOfLIS(int[] nums) {
       int n = nums.length;
       int[] top = new int[n];
       int piles = 0;
       for(int i = 0 ; i < n ; i++)
       {
           int poker = nums[i];
           int left = 0;
           int right = piles;

           while(left < right)
           {
               int mid = (left + right) / 2;
               if(top[mid] > poker){
                   right = mid;
               } else if(top[mid] < poker){
                   left = mid + 1;
               } else {
                   right = mid;
               }
           }
           
           if(left == piles){
               piles++;
           }
           top[left] = poker;
       }

       return piles;
    }
}
