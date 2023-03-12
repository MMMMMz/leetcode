class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = '.';
            }
        }
        backtrack(res, board, 0, n);
        return res;
       
    }

    void backtrack(List<List<String>> res, char[][] board, int i, int n){
        if(i == n){
            List<String> temp = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                temp.add(new String(board[j]));
            }
            res.add(temp);
            return;
        }

        for(int j = 0 ; j < n ; j++){
            if(isValid(board, i, j)){
                board[i][j] = 'Q';
                backtrack(res, board, i + 1, n);
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
