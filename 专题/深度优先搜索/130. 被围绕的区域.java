class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0 ; i < m ; i++){
            dfs(board, m, n, i, 0, 'O','#');
            dfs(board, m, n, i, n - 1, 'O','#');
        }

        for(int i = 0 ; i < n ; i++){
            dfs(board, m, n, 0, i, 'O','#');
            dfs(board, m, n, m - 1, i, 'O','#');
        }
        for(int i = 1 ; i < m - 1; i++){
            for(int j = 1 ; j < n - 1; j++){
                if(board[i][j] == 'O'){
                    dfs(board, m, n, i, j, 'O', 'X');
                }
            }
        }

       for(int i = 0 ; i < m ; i++){
           for(int j = 0 ; j < n ; j++){
               if(board[i][j] == '#'){
                   board[i][j] = 'O';
               }
           }
       }
    }

    void dfs(char[][] board, int m, int n, int i, int j, char c, char change){
        if(i < 0 || j < 0 || i == m || j == n){
            return;
        }

        if(board[i][j] != c){
            return;
        }

        board[i][j] = change;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] dir : dirs){
            dfs(board, m, n, i + dir[0], j + dir[1], c, change);
        }
    }
}
