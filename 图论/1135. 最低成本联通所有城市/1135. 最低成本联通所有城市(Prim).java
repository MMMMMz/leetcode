class Solution {


    class Prim{
       PriorityQueue<int[]> pq;
       boolean inMST[];
       int weightSum = 0;
       List<int[]>[] graph;

       public Prim(List<int[]>[] graph){
           this.graph = graph;
           this.pq = new PriorityQueue<>((a, b) -> {
            // 按照边的权重从小到大排序
            return a[2] - b[2];
        });
           int n = graph.length;
           inMST = new boolean[n];
           inMST[0] = true;
           cut(0);

           while(!pq.isEmpty()){
               int edge[] = pq.poll();
               int to = edge[1];
               int weight = edge[2];
               if(!inMST[to]){
                  weightSum += weight;
                  inMST[to] = true;
                  cut(to);
               }
           }
       }

        public void cut(int s){
            for(int edge[] : graph[s]){
                if(!inMST[edge[1]]){
                    pq.offer(edge);
                }  
            }
        }

        public int getWeightSum(){
            return weightSum;
        }

        public boolean allConnected(){
            for(int i = 0 ; i < inMST.length ; i++)
            {
                if(!inMST[i]){
                    return false;
                }
            }
            return true;
        }

    }

    public List<int[]>[] buildGraph(int n, int[][] connections){
        List<int[]> graph[] = new LinkedList[n];
        for(int i = 0 ; i < n ; i++)
        {
            graph[i] = new LinkedList();
        }

        for(int edge[] : connections)
        {
            graph[edge[0] - 1].add(new int[]{edge[0] - 1, edge[1] - 1, edge[2]});
            graph[edge[1] - 1].add(new int[]{edge[1] - 1, edge[0] - 1, edge[2]});
        }

        return graph;
    }

    public int minimumCost(int n, int[][] connections) {
      List<int[]>[] graph = buildGraph(n, connections);
      Prim prim = new Prim(graph);

      if(prim.allConnected()){
          return prim.getWeightSum();
      }
      return -1;
    }
}
