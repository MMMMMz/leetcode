class Solution {

    int res = 0;
    int now = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j, m, n);
                    res = Math.max(res, now);
                    now = 0;
                }
            }
        }
        return res;
    }

    void dfs(int[][] grid, int i, int j, int m, int n){
        if(i < 0 || j < 0 || i == m || j ==n){
            return;
        }
        if(grid[i][j] == 0){
            return;
        }
        if(grid[i][j] == 1){
            now++;
            grid[i][j] = 0;
        }

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] dir : dirs){
            dfs(grid, i + dir[0], j + dir[1], m, n);
        }
    }
}
