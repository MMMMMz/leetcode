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
                bfs(graph, i);
            }
        }

        return res;
    }

void bfs(int[][] graph, int s){
    Queue<Integer> q = new LinkedList<>();
    visited[s] = true;
    q.add(s);

    while(!q.isEmpty())
    {
        int cur = q.poll();
        for(int neighbor : graph[cur]){
            if(!visited[neighbor]){
                visited[neighbor] = true;
                color[neighbor] = !color[cur];
                q.add(neighbor);
            } else {
                if(color[cur] == color[neighbor]){
                    res = false;
                    return;
                }
            }
        }
    }
}

}
