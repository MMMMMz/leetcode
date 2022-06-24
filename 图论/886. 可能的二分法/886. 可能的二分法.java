class Solution {

    boolean visited[];
    boolean color[];
    boolean res = true;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer> graph[] = buildGraph(n, dislikes);
        visited = new boolean[n + 1];
        color = new boolean[n + 1];
        for(int i = 1 ; i < n ; i++){
            if(!visited[i]){
                dfs(graph, i);
            }
        }

        return res;
    }

    List<Integer>[] buildGraph(int n, int[][] dislikes){
        List<Integer> graph[] = new LinkedList[n + 1];

        for(int i = 1 ; i < n + 1; i++)
        {
            graph[i] = new LinkedList<>();
        }

        for(int edges[] : dislikes){
            graph[edges[0]].add(edges[1]);
            graph[edges[1]].add(edges[0]);
        }

        return graph;
    }

    void dfs(List<Integer>[] graph, int s){
        if(visited[s] || !res){
            return;
        }

        visited[s] = true;
        for(int neighbor : graph[s]){
            if(!visited[neighbor]){
                color[neighbor] = !color[s];
                dfs(graph, neighbor);
            } else {
                if(color[neighbor] == color[s]){
                    res = false;
                }
            }
        }
    }
}
