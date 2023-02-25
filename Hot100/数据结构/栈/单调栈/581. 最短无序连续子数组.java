class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(i);
        }
        stack.clear();
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && nums[i] <= nums[stack.peek()]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.add(i);
        }

        int leftRes = 0;
        int rightRes = 0;
        for(int i = 0 ; i < n ; i++){
            if(left[i] != -1 || right[i] != n){
                leftRes = i;
                break;
            }
        }
        for(int i = n - 1 ; i >= 0 ; i--){
            if(right[i] != n || left[i] != -1){
                rightRes = i;
                break;
            }
        }
        return rightRes - leftRes == 0 ? 0 : rightRes - leftRes + 1;
    }
}
