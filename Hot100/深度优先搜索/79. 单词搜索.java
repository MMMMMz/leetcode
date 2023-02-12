class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(dfs(board, visited, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, boolean[][] visited, String word, int m, int n, int k){
        if(board[m][n] != word.charAt(k)) return false;
        if(k == word.length() - 1) return true;
        visited[m][n] = true;
        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        boolean res = false;
        for(int[] dir : dirs){
            int newx = m + dir[0];
            int newy = n + dir[1];
            if(newx < board.length && newy < board[0].length && newx >= 0 && newy >= 0){
                if(!visited[newx][newy]){
                    res = dfs(board, visited, word, newx, newy, k + 1);
                    if(res) break;
                }
            }
        }
        visited[m][n] = false;
        return res;
    }
}
