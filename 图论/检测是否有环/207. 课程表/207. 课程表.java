class Solution {

    boolean res;
    boolean visited[];
    boolean onPath[];

    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new List[numCourses];
        for(int i = 0 ; i < numCourses ; i++)
        {
            graph[i] = new LinkedList<>();
        }

        for(int[] edge : prerequisites){
            graph[edge[1]].add(edge[0]);
        }

        return graph;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for(int i = 0 ; i < numCourses ; i++)
        {
            traverse(graph, i);
        }
        
        return !res;
    }

    void traverse(List<Integer>[] graph, int s){
        if(onPath[s]){
            res = true;
        }

        if(visited[s] || res){
            return;
        }

        visited[s] = true;
        onPath[s] = true;

        for(int v : graph[s]){
            traverse(graph, v);
        }

        onPath[s] = false;
    }
}
