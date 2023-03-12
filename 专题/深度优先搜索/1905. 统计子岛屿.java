class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int res = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid1[i][j] == 0 && grid2[i][j] == 1){
                    dfs(grid2, i, j, m, n);
                }
            }
        }

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid2[i][j] == 1){
                    dfs(grid2, i, j, m, n);
                    res++;
                }
            }
        }
        return res;
    }

     void dfs(int[][] grid, int i, int j, int m, int n){
        if(i < 0 || j < 0 || i == m || j == n){
            return;
        }
        if(grid[i][j] == 0){
            return;
        }
        if(grid[i][j] == 1){
            grid[i][j] = 0;
        }

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] dir : dirs){
            dfs(grid, i + dir[0], j + dir[1], m, n);
        }
    }
}
