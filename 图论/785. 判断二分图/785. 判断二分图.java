class Solution {

    boolean color[];
    boolean visited[];
    boolean res = true;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];

        for(int i = 0 ; i < n ; i++)
        {
            if(!visited[i]){
                dfs(graph, i);
            }
        }

        return res;
    }

    void dfs(int[][] graph, int s){
        if(visited[s] || !res){
            return;
        }

        visited[s] = true;

        for(int neighbor : graph[s]){
            if(!visited[neighbor]){
                color[neighbor] = !color[s];
                dfs(graph, neighbor);
            } else {
                if(color[s] == color[neighbor]){
                    res = false;
                }
            }
        }
    }

}
