class Solution {

    int res = 0;

    public int totalNQueens(int n) {
        char[][]board = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(board[i], '.');
        }
        
        backtrack(board, n, 0);
        return res;
    }

    void backtrack(char[][] board, int n, int i){
        if(i == n){
            res++;
            return;
        }
        for(int j = 0 ; j < n ; j++){
            if(isValid(board, i, j)){
                board[i][j] = 'Q';
                backtrack(board, n, i + 1);
                board[i][j] = '.';
            }
        }
    }


    boolean isValid(char[][] board, int i, int j){
        int n = board.length;
        for(int k = 0 ; k < i ; k++){
            if(board[k][j] == 'Q'){
                return false;
            }
        }
        for(int k = 0 ; k < i ; k++){
            if(j + (i - k) < n && board[k][j + (i - k)] == 'Q'){
                return false;
            }
            if(j - (i - k) >= 0 && board[k][j - (i - k)] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
