class Solution {

    boolean res = true;
    boolean color[];
    boolean visited[];

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];
        for(int i = 0 ; i < n ; i++)
        {
            if(!visited[i]){
                traverse(graph, i);
            }
        }

        return res;
    }

    void traverse(int[][] graph, int s){
        
        if(!res){
            return;
        }

        visited[s] = true;
        for(int neighbor : graph[s]){
            if(!visited[neighbor]){
                color[neighbor] = !color[s];
                traverse(graph, neighbor);
            } else {
                if(color[neighbor] == color[s]){
                    res = false;
                }
            }
        }
    }
}
