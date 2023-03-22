class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
       
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]) stack.pop();
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.add(i);
        }
        for(int i = 0 ; i < n ; i++){
            if(right[i] != n){
                res[i] = nums[right[i]];
            } else {
                int flag = 0;
               for(int j = 0 ; j < i ; j++){
                   if(nums[j] > nums[i]){
                       flag = 1;
                       res[i] = nums[j];
                       break;
                   }
               }
               if(flag == 0){
                   res[i] = -1;
               }
            }
        }
        return res;
    }
}
