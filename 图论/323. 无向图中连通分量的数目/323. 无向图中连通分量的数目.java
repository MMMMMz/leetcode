class Solution {

        class UF{
        //连通分量个数
        int count;
        //每个节点的父节点
        int parent[];
        //重量
        int size[];

    public UF(int count){
        this.count = count;
        parent = new int[count];
        size = new int[count];
        for(int i = 0 ; i < count ; i++)
        {
            parent[i] = i;
            size[i] = 1;
        }
    }

        void union(int p, int q){
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

            //连通分量变少
            count--;
        }

        //查找某个节点的根节点，并压缩路径
        int find(int x){
            if(x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        //判断节点p和q是否连通
        boolean connected(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);

            return rootP == rootQ;
        }

        //返回连通分量的个数
        int count(){
            return count;
        }
    }

    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for(int edge[] : edges){
            uf.union(edge[0], edge[1]);
        }

        return uf.count();
    }
}
