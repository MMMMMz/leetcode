class Solution {

    boolean[] visited;
    boolean[] color;
    boolean res;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        res = true;
        visited = new boolean[n];
        color = new boolean[n];

        List<Integer>[] graph = buildGraph(n, dislikes);
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                bfs(graph, i);
                if(!res){
                    return res;
                }
            }
        }

        return res;
    }

    void bfs(List<Integer>[] graph, int index){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0 ; i < len ; i++){
                int cur = queue.poll();
                if(visited[cur]){
                    continue;
                }

                visited[cur] = true;
                for(int node : graph[cur]){
                    if(visited[node]){
                        if(color[cur] == color[node]){
                            res = false;
                            return;
                        }
                    } else {
                        color[node] = !color[cur];
                        queue.offer(node);
                    }
                }
            }
        }
    }

    List<Integer>[] buildGraph(int n, int[][]dislikes){
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : dislikes){
            graph[edge[0] - 1].add(edge[1] - 1);
            graph[edge[1] - 1].add(edge[0] - 1);
        }

        return graph;
    }
}
