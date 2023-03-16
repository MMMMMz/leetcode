class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<Integer>[] adj = buildGraph(graph);
        List<List<Integer>> res = new ArrayList<>();
        dfs(adj, 0, new ArrayList<>(), res, n - 1);

        return res;
    }

    void dfs(List<Integer>[] adj, int index, List<Integer> buffer, List<List<Integer>> res, int n){
        buffer.add(index);
        if(index == n){
            res.add(new ArrayList<>(buffer));
            return;
        }
        for(int i = 0 ; i < adj[index].size() ; i++){
           
            dfs(adj, adj[index].get(i), buffer, res, n);
            buffer.remove(buffer.size() - 1);
        }
    }

    List<Integer>[] buildGraph(int[][] graph){
        int n = graph.length;
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < graph[i].length ; j++){
                adj[i].add(graph[i][j]);
            }
        }

        return adj;
    }
}
