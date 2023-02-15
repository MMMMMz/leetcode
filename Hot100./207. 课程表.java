class Solution {

    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            traverse(graph, i);
        }
        return !hasCycle;
    }

    void traverse(List<Integer>[] graph, int index){
        if(onPath[index]){
            hasCycle = true;
        }
        if(visited[index] || hasCycle) return;
        visited[index] = true;
        onPath[index] = true;
        for(int i = 0 ; i < graph[index].size() ; i++){
            traverse(graph, graph[index].get(i));
        }
        onPath[index] = false;
    }


    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : prerequisites){
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }
}
