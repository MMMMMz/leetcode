class Solution {


    class UF{
        int count;
        int size[];
        int parent[];

        public UF(int n){
            this.count = n;
            size = new int[n];
            parent = new int[n];
            
            for(int i = 0 ; i < n ; i++)
            {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);

            if(rootP == rootQ){
                return;
            }

            if(size[rootP] > size[rootQ]){
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }

            count--;
        }

        public boolean connected(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);

            return rootP == rootQ;
        }

        public int find(int x){
            while(x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public int count(){
            return count;
        }
    }

    public int minimumCost(int n, int[][] connections) {
        UF uf = new UF(n + 1);
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));

        int mst = 0;
        for(int edge[] : connections){
            if(uf.connected(edge[0], edge[1])){
                continue;
            }

            mst += edge[2];
            uf.union(edge[0], edge[1]);
        }

        return uf.count == 2 ? mst : -1;
    }
}
