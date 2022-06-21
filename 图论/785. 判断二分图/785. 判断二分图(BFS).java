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
        Queue<Integer> q = new LinkedList();

        visited[s] = true;
        q.offer(s);
        while(!q.isEmpty() && res){
            int cur = q.poll();
            for(int neighbor : graph[cur]){
                if(!visited[neighbor]){
                    color[neighbor] = !color[cur];
                    visited[neighbor] = true;
                    q.offer(neighbor);
                } else {
                    if(color[neighbor] == color[cur]){
                        res = false;
                    }
                }
            }     
        }
    }
}
