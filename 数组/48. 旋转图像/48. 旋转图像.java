class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;  //先镜像对称然后逆转每一行

        for(int i = 0 ; i < len ; i++)
        {
            for(int j = i ; j < len ; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int[] row : matrix) reverse(row);
    }

    void reverse(int[] row)
    {
        int i = 0;
        int j = row.length - 1;
        while(i < j)
        {
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            j--;
            i++;
        }
    }
}
