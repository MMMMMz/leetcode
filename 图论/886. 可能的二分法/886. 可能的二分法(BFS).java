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
                bfs(graph, i);
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

    void bfs(List<Integer>[] graph, int s){
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int neighbor : graph[cur]){
                if(!visited[neighbor]){
                    color[neighbor] = !color[cur];
                    visited[neighbor] = true;
                    q.add(neighbor);
                } else {
                    if(color[neighbor] == color[cur]){
                        res = false;
                        return;
                    }
                }
            }
        }
    }
}
