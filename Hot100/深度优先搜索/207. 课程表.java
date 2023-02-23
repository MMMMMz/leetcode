class Solution {

    boolean[] visited;
    boolean[] onPath;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for(int i = 0 ; i < numCourses ; i++){
            if(dfs(graph, i)){
                return false;
            }
        }
        return true;
    }
    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new List[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            graph[i] = new LinkedList<>();
        }
        for(int[] edge : prerequisites){
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }

    boolean dfs(List<Integer>[] graph, int index){
        if(onPath[index]){
            return true;
        }
        if(visited[index]){
            return false;
        }
        visited[index] = true;
        onPath[index] = true;
        boolean res = false;
        for(int i = 0 ; i < graph[index].size() ; i++){
            res = dfs(graph, graph[index].get(i));
            if(res) break;
        }
        onPath[index] = false;

        return res;
    }
}
