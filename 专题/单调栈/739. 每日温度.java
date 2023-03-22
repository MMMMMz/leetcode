class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) stack.pop();
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.add(i);
        }
        return res;
    }
}
