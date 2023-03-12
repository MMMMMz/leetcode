class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    res++;
                    bfs(grid, i, j, m, n, visited);
                }
            }
        }
        return res;
    }

    void bfs(char[][] grid, int i, int j, int m, int n, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int[][] dirs = new int[][]{{0 ,1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()){
            for(int k = 0 ; k < queue.size() ; k++){
                int[] cur = queue.poll();
                
                grid[cur[0]][cur[1]] = 0;
                for(int[] dir : dirs){
                    int newI = cur[0] + dir[0];
                    int newJ = cur[1] + dir[1];
                    if(!check(newI, newJ, m, n)){
                        continue;
                    }
                    if(grid[newI][newJ] == '1' && !visited[newI][newJ]){
                        queue.add(new int[]{newI, newJ});
                        visited[newI][newJ] = true;
                    }
                }
            }
        }
    }

    boolean check(int i, int j, int m, int n){
        if(i < 0 || j < 0 || i == m || j == n){
            return false;
        }
        return true;
    }
}
