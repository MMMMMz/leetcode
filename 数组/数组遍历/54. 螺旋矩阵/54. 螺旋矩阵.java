class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0;
        int left = 0;
        int low = m - 1;
        int right = n - 1;

        while(res.size() < m * n)
        {
            if(up <= low){
                for(int i = left ; i <= right ; i++)
                {
                    res.add(matrix[up][i]);
                }
                up++;
            }
            
            if(right >= left){
                for(int i = up ; i <= low ; i++)
                {
                    res.add(matrix[i][right]);
                }
                right--;
            }
            if(low >= up){
                for(int i = right ; i >= left ; i--)
                {
                    res.add(matrix[low][i]);
                }
                low--;
            }
            if(left <= right){
                for(int i = low ; i >= up ; i--)
                {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
