class Solution {

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
       List<Integer>[] graph = buildGraph(numCourses, prerequisites);
       int[] indegree = new int[numCourses];
       for(int[] edge : prerequisites){
           indegree[edge[0]]++;
       }

       Queue<Integer> q = new LinkedList<>();
       for(int i = 0 ; i < numCourses ; i++)
       {
           if(indegree[i] == 0){
               q.offer(i);
           }
       }

       int count = 0;
       while(!q.isEmpty()){
           int cur = q.poll();
           count++;
           for(int next : graph[cur]){
               indegree[next]--;
               if(indegree[next] == 0){
                   q.offer(next);
               }
           }
       }

       return count == numCourses;
    }

  
}
