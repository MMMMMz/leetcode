class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] right = new int[n];
        int[] res = new int[n];
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for(int i = 0 ; i < n ; i++){
            res[i] = (right[i] != n ? right[i] - i: 0);
        }
        
        return res;
    }
}
