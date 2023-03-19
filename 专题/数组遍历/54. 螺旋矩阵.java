class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;
        while(res.size() < m * n){
            if(up <= down){
                for(int i = left ; i <= right ; i++){
                    res.add(matrix[up][i]);
                }
                up++;
            }
            if(left <= right){
                for(int i = up ; i <= down ; i++){
                    res.add(matrix[i][right]);
                }
                right--;
            }
            if(up <= down){
                for(int i = right ; i >= left ; i--){
                    res.add(matrix[down][i]);
                }
                down--;
            }
            if(left <= right){
                for(int i = down ; i >= up ; i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
       
        return res;
    }
}
