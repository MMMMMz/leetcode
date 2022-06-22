class Solution {

    class UF{
        int count;
        int parent[];
        int size[];

        public UF(int n){
            this.count = n;
            parent = new int[n];
            size = new int[n];

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

    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for(int edge[] : edges){
            if(uf.connected(edge[0], edge[1])){
                return false;
            }
            uf.union(edge[0], edge[1]);
        }

        return uf.count == 1;
    }
}
