class Solution {

    boolean[][] visited;

    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1'){
                    res++;
                    traverse(grid, i, j);
                }
            }
        }
        return res;
    }

    void traverse(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n){
            return;
        }
        if(visited[i][j] || grid[i][j] == '0'){
            return;
        }
         visited[i][j] = true;
         grid[i][j] = '0';
         int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for(int[] dir : dirs){
            traverse(grid, i + dir[0], j + dir[1]);
        }
    }
}
