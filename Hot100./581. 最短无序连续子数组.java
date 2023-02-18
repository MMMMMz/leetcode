class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int resLeft = 0;
        int resRight = 0;
        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]) stack.pop();
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        for(int i = 0 ; i < n ; i++){
            if(left[i] != -1 || right[i] != n){
                resLeft = i;
                break;
            }
        }
        for(int i = n - 1 ; i >= 0 ; i--){
            if(left[i] != -1 || right[i] != n){
                resRight = i;
                break;
            }
        }
        return resRight - resLeft == 0 ? 0 : resRight - resLeft + 1;
    }
}
