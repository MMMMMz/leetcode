class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new int[]{};
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];

        int up = 0;
        int left = 0;
        int low = m - 1;
        int right = n - 1;
        int count = 0;

        while(count < m * n){
            if(up <= low){
                for(int i = left ; i <= right ; i++)
                {
                    res[count++] = matrix[up][i];
                }
                up++;
            }

            if(right >= left){
                for(int i = up ; i <= low ; i++)
                {
                    res[count++] = matrix[i][right];
                }
                right--;
            }

            if(low >= up){
                for(int i = right ; i >= left ; i--)
                {
                    res[count++] = matrix[low][i];
                }
                low--;
            }

            if(left <= right)
            {
                for(int i = low ; i >= up ; i--)
                {
                    res[count++] = matrix[i][left];
                }
                left++;
            }
        }

        return res;
    }
}
