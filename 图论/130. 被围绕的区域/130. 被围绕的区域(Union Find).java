class Solution {

    class UF{
        int count;  //表示连通分量个数
        int parent[];   //表示每个节点的父节点是谁

        public UF(int n){
            this.count = n;
            parent = new int[n];

            for(int i = 0 ; i < n ; i++)
            {
                parent[i] = i;
            }
        }

        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);

            if(rootP == rootQ){
                return;
            }

            parent[rootP] = rootQ;
            count--;
        }

        public boolean connected(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);

            return rootP == rootQ;
        }

        public int find(int x){
            if(x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int count(){
            return count;
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        UF uf = new UF(m * n + 1);

        int dummy = m * n;
        for(int i = 0 ; i < m ; i++)
        {
            if(board[i][0] == 'O'){
                uf.union(dummy, i * n);
            }
            if(board[i][n - 1] == 'O'){
                uf.union(dummy, i * n + n - 1);
            }
        }

        for(int i = 0 ; i < n ; i++)
        {
            if(board[0][i] == 'O'){
                uf.union(dummy, i);
            }
            if(board[m - 1][i] == 'O'){
                uf.union(dummy, (m - 1) * n + i);
            }
        }

        int d[][] = new int[][]{{1, 0},{-1, 0},{0, -1},{0, 1}};

        for(int i = 1 ; i < m - 1; i++)
        {
            for(int j = 1 ; j < n - 1;j++)
            {
                if(board[i][j] == 'O'){
                    for(int k = 0 ; k < 4 ; k++)
                    {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if(board[x][y] == 'O'){
                            uf.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }

        for(int i = 1 ; i < m - 1 ; i++)
            for(int j = 1 ; j < n - 1 ; j++)
            {
                if(!uf.connected(dummy, i * n + j)){
                    board[i][j] = 'X';
                }
            }
    }
}
