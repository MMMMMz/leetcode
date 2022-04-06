class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new LinkedList();
        int up = 0;
        int left = 0;
        int right = n - 1;
        int low = m - 1;

        while(res.size() < n * m)
        {
            if(up <= low)
            {
                for(int j = left ; j <= right ; j++) res.add(matrix[up][j]);
                up++;
            }

            if(left <= right)
            {
                for(int j = up ; j <= low ; j++) res.add(matrix[j][right]);
                right--;
            }

            if(up <= low)
            {
                for(int j = right ; j >= left ; j--) res.add(matrix[low][j]);
                low--;
            }

            if(left <= right)
            {
                for(int j = low ; j >= up ; j--) res.add(matrix[j][left]);
                left++;
            }
        }

        return res;
    }

}
