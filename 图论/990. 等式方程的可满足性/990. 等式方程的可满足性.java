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

    
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);

        for(String eq : equations){
            if(eq.charAt(1) == '='){
                uf.union(eq.charAt(0) - 'a', eq.charAt(3) - 'a');
            }
        }

        for(String eq : equations){
            if(eq.charAt(1) == '!'){
                if(uf.connected(eq.charAt(0) - 'a', eq.charAt(3) - 'a')){
                    return false;
                }
            }
        }
        return true;
    }
}
