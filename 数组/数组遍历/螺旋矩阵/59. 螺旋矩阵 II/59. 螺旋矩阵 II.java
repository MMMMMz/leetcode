class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int up = 0;
        int left = 0;
        int low = n - 1;
        int right = n - 1;
        int num = 1;

        while(num <= n * n)
        {
            if(up <= low){
                for(int i = left ; i <= right ; i++)
                {
                    res[up][i] = num++;
                }
                up++;
            }

            if(right >= left){
                for(int i = up ; i <= low ; i++)
                {
                    res[i][right] = num++;
                }
                right--;
            }

            if(low >= up){
                for(int i = right ; i >= left ; i--)
                {
                    res[low][i] = num++;
                }
                low--;
            }

            if(left <= right){
                for(int i = low ; i >= up ; i--)
                {
                    res[i][left] = num++;
                }
                left++;
            }
        }

         return res;
    }
}
