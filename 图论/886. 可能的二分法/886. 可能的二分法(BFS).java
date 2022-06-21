class Solution {

    boolean visited[];
    boolean color[];
    boolean res = true;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer> graph[] = buildGraph(n, dislikes);
        visited = new boolean[n+1];
        color = new boolean[n+1];

        for(int i = 1 ; i < n + 1 ; i++){
            if(!visited[i]){
                traverse(graph, i);
            }
        }

        return res;
    }

    void traverse(List<Integer>[] graph, int s){
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

    List<Integer>[] buildGraph(int n, int[][] dislikes){
        List<Integer> graph[] = new LinkedList[n + 1];

        for(int i = 1 ; i < n + 1 ; i++)
        {
            graph[i] = new LinkedList();
        }

       for(int edge[] : dislikes){
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }

        return graph;
    }
}
