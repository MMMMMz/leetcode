class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        double[] res = new double[queries.size()];
        for(List<String> list : equations){
            for(String str : list){
                if(!map.containsKey(str)){
                    map.put(str, count++);
                }
            }
        }
        UF uf = new UF(map.size());
        for(int i = 0 ; i < equations.size() ; i++){
            uf.union(map.get(equations.get(i).get(0)), map.get(equations.get(i).get(1)), values[i]);
        }
            
        for(int i = 0 ; i < queries.size() ; i++){
            String str1 = queries.get(i).get(0);
            String str2 = queries.get(i).get(1);  
            if(!map.containsKey(str1) || !map.containsKey(str2)){
                res[i] = -1.0d;
                continue;
            }
            if(uf.connected(map.get(str1), map.get(str2))){
                res[i] = uf.getWeights(map.get(str1)) / uf.getWeights(map.get(str2));
            } else {
                res[i] = -1.0d;
            }
        }
        return res;
    }

    class UF{
        int[] parent;
        double[] weights;

        UF(int n){
            parent = new int[n];
            weights = new double[n];
            for(int i = 0 ; i < n ; i++){
                parent[i] = i;
                weights[i] = 1.0d;
            }
        }

        public double getWeights(int x){
            return weights[x];
        }

        private int find(int x){
            if(parent[x] != x){
                int orParent = parent[x];
                parent[x] = find(parent[x]);
                weights[x] *= weights[orParent];
            }
            return parent[x];
        }

        public boolean connected(int p, int q){
            return find(p) == find(q);
        }

        public void union(int p, int q, double val){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ){
                return;
            }

            parent[rootP] = rootQ;
            weights[rootP] = weights[q] * val / weights[p];
        }
    }
}
