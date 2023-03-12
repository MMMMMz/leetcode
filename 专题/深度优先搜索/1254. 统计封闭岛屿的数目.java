class Solution {
    public int closedIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0 ; i < m ; i++){
            dfs(grid, i, 0, m, n);
            dfs(grid, i, n - 1, m, n);
        }
        for(int i = 0 ; i < n ; i++){
            dfs(grid, 0, i, m , n);
            dfs(grid, m - 1, i, m , n);
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 0){
                    dfs(grid, i, j, m, n);
                    res++;
                }
            }
        }
        return res;
    }

    void dfs(int[][] grid, int i, int j, int m, int n){
        if(i < 0 || j < 0 || i == m || j == n){
            return ;
        }
        if(grid[i][j] == 1){
            return;
        }
        if(grid[i][j] == 0){
            grid[i][j] = 1;
        }

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] dir : dirs){
            dfs(grid, i + dir[0], j + dir[1], m, n);
        }
    }
}
