class Solution {

    boolean hasCycle;
    boolean[] visited;
    boolean[] onPath;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph =buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for(int i = 0 ; i < numCourses ; i++){
            if(!visited[i]){
                 dfs(graph, i);
            }
        }

        return !hasCycle;
    }

    void dfs(List<Integer>[] graph, int index){
        
        if(onPath[index] || hasCycle){
            hasCycle = true;
            return;
        }
        if(visited[index]){
            return;
        }
       
        onPath[index] = true;
        visited[index] = true;
        for(int i = 0 ; i < graph[index].size() ; i++){
            dfs(graph, graph[index].get(i));
        }
         onPath[index] = false;
    }



    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new LinkedList[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            graph[i] = new LinkedList<>();
        }

        for(int[] edge : prerequisites){
            graph[edge[1]].add(edge[0]);
        }

        return graph;
    }
}
