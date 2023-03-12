class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return res;
    }

    void dfs(char[][] grid, int i, int j, int m, int n){
        if(i < 0 || j < 0 || i == m || j == n){
            return;
        }
        if(grid[i][j] == '0'){
            return;
        }
        if(grid[i][j] == '1'){
            grid[i][j] = '0';
        }

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] dir : dirs){
            dfs(grid, i + dir[0], j + dir[1], m, n);
        }
    }
}
