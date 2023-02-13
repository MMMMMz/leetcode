class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] preSum = new int[m][n];
        int res = 0;
        for(int i = 0 ; i < n ; i++){
            preSum[0][i] = matrix[0][i] - '0';
        }
        for(int i = 1 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                preSum[i][j] = matrix[i][j] - '0' == 0 ? 0 : preSum[i - 1][j] + 1;
            }
        }
        int[] left = new int[n];
        int[] right = new int[n];
        
        for(int i = 0 ; i < m ; i++){
            Deque<Integer> stack = new ArrayDeque<>();
            for(int j = 0 ; j < n ; j++){
                while(!stack.isEmpty() && preSum[i][stack.peek()] >= preSum[i][j]) stack.pop();
                left[j] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(j);
            }
            stack.clear();
            for(int j = n - 1 ; j >= 0 ; j--){
                while(!stack.isEmpty() && preSum[i][stack.peek()] >= preSum[i][j]) stack.pop();
                right[j] = stack.isEmpty() ? n : stack.peek();
                stack.push(j);
            }
            for(int j = 0 ; j < n ; j++){
                res = Math.max(res, preSum[i][j] * (right[j] - left[j] - 1));
            }
        }
        
        return res;
    }
}
