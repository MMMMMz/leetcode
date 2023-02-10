class Solution {
    public int longestConsecutive(int[] nums) {
       HashSet<Integer> set = new HashSet<>();
       for(int num : nums){
           set.add(num);
       }
       int res = 0;
       for(int num : set){
           if(!set.contains(num - 1)){
               int cur = num;
               int curLen = 0;

               while(set.contains(cur + 1)){
                   ++cur;
                   ++curLen;
               }
               res = Math.max(res, curLen + 1);
           }
       }

       return res;
    }
}
