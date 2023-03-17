class Solution {
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for(int[] edge : edges){
            uf.union(edge[0], edge[1]);
        }

        return uf.count();
    }

    class UF{
        int count;
        int[] parent;

        public UF(int n){
            parent = new int[n];
            for(int i = 0 ; i < n ; i++){
                parent[i] = i;
            }
            count = n;
        }

        int find(int x){
            if(x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ){
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }

        int count(){
            return count;
        }
        
    }
}
