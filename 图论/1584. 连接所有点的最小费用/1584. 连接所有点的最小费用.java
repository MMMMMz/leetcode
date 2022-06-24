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

    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new LinkedList<>();
        int n = points.length;
        int cost = 0;
        UF uf = new UF(n);
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = i + 1 ; j < n ; j++)
            {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                edges.add(new int[]{i, j, Math.abs(x1 - x2) + Math.abs(y1 - y2 )});
            }
        }

        Collections.sort(edges, (a, b) -> {return a[2] - b[2]; });

        for(int edge[] : edges){
            if(!uf.connected(edge[0], edge[1])){
                cost += edge[2];
                uf.union(edge[0], edge[1]);
            }
        }

        return cost;
    }
}
