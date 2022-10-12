class Solution {

    boolean hasCycle;
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
        res = new int[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        int[] indgree = new int[numCourses];
        for(int[] edge : prerequisites){
            indgree[edge[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++)
        {
            if(indgree[i] == 0){
                q.offer(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            res[count++] = cur;
            for(int next : graph[cur]){
                indgree[next]--;
                if(indgree[next] == 0){
                    q.offer(next);
                }
            }
        }
        if(numCourses != count){
            return new int[]{};
        }
        return res;
    }

}
