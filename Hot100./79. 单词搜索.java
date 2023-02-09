class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(dfs(board, word, visited, 0, i, j)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, boolean[][] visited, int k, int m, int n)
    {
        if(board[m][n] != word.charAt(k)){
            return false;
        } 
        if(k == word.length() - 1){
            return true;
        }
        visited[m][n] = true;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for(int[] dir : dirs)
        {
            int i = m + dir[0];
            int j = n + dir[1];
            if(i < board.length && j < board[0].length && i >= 0 && j >= 0){
                if(!visited[i][j]){
                    boolean flag = dfs(board, word, visited, k + 1, i, j);
                    if(flag){
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[m][n] = false;
        return result;
    }
}
