class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] preSum = new int[m][n];
        int res = 0;
        for(int i = 0 ; i < n ; i++){
            if(matrix[0][i] == '1'){
                preSum[0][i] = 1;
            }
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 1 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == '1'){
                    preSum[i][j] = preSum[i - 1][j] + 1;
                }
            }
        }

        for(int i = 0 ; i < m ; i++){
            int[] left = new int[n];
            int[] right = new int[n];
            for(int j = 0 ; j < n ; j++){
                while(!stack.isEmpty() && preSum[i][stack.peek()] >= preSum[i][j]){
                    stack.pop();
                }
                left[j] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(j); 
            }
            stack.clear();
            for(int j = n - 1 ; j >= 0 ; j--){
                while(!stack.isEmpty() && preSum[i][stack.peek()] >= preSum[i][j]){
                    stack.pop();
                }
                right[j] = stack.isEmpty() ? n : stack.peek();
                stack.push(j); 
            }

            stack.clear();
            for(int j = 0 ; j < n ; j++){
                int width = Math.min(preSum[i][j], right[j] - left[j] - 1);
                res = Math.max(res, width * width);
            }
        }
        return res;
    }
}
