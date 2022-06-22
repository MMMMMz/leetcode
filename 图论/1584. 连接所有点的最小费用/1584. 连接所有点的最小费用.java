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
                size[i] = 1;
            }
        }

        public int find(int x){
            while(x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean connected(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);

            return rootP == rootQ;
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
        }

        public int count(){
            return count;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        UF uf = new UF(points.length);
        List<int []> edges = new ArrayList();
        int mst = 0;
        for(int i = 0 ; i < points.length ; i++)
        {
            for(int j = i + 1 ; j < points.length ; j++)
            {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                edges.add(new int[]{
                    i, j, Math.abs(x1 - x2) + Math.abs(y1 - y2)
                });
            }
        }
            Collections.sort(edges, (a, b) -> (a[2] - b[2]));

            for(int edge[] : edges){
                if(uf.connected(edge[0], edge[1])){
                    continue;
                }

                mst += edge[2];
                uf.union(edge[0], edge[1]);   
            }
        

        return mst;
    }
}
