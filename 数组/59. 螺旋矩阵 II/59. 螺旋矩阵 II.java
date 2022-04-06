class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        int count = 1;
        while(count <= n * n)
        {
            if(up <= down){
                for(int i = left ; i <= right ; i++)
                {
                    res[up][i] = count;
                    count++;
                }
                up++;
            }

            if(left <= right)
            {
                for(int i = up ; i <= down ; i++)
                {
                    res[i][right] = count;
                    count++;
                }
                right--;
            }
            if(up <= down)
            {
                for(int i = right ; i >= left ; i--)
                {
                    res[down][i] = count;
                    count++;
                }
                down--;
            }
            if(left <= right)
            {
                for(int i = down ; i >= up ; i--)
                {
                    res[i][left] = count;
                    count++;
                }
                left++;
            }
        }

        return res;
    }
}
