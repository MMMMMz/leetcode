class Solution {

    boolean hasCycle;
    boolean[] visited;
    boolean[] onPath;
    List<Integer> postOrder;
    int[] res;

    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new List[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int edge[] : prerequisites){
            graph[edge[1]].add(edge[0]);
        }

        return graph;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        res = new int[numCourses];
        postOrder = new ArrayList<>();
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for(int i = 0 ; i < numCourses ; i++)
        {
            traverse(graph, i);
        }
        if(hasCycle){
            return new int[]{};
        }
        Collections.reverse(postOrder);
        for(int i = 0 ; i < numCourses ; i++)
        {
            res[i] = postOrder.get(i);
        }
        return res;
    }

    void traverse(List<Integer>[] graph, int s){
        if(onPath[s]){
            hasCycle = true;
        }
        if(visited[s] || hasCycle){
            return;
        }

        visited[s] = true;
        onPath[s] = true;
        for(int v : graph[s]){
            traverse(graph, v);
        }
        postOrder.add(s);
        onPath[s] = false;
    }
}
