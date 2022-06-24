class Solution {

    class Prim{
        int cost = 0;
        List<int[]> graph[];
        boolean inMST[];
        PriorityQueue<int[]> pq;
        
        public Prim(List<int[]>[] graph){
            this.graph = graph;
            int n = graph.length;
            inMST = new boolean[n];
            pq = new PriorityQueue<>((a, b) -> { return a[1] - b[1]; });

            inMST[0] = true;
            cut(0);

            while(!pq.isEmpty()){
                int cur[] = pq.poll();

                if(!inMST[cur[0]]){
                    cost += cur[1];
                    inMST[cur[0]] = true;
                    cut(cur[0]);
                }
            }
        }

        void cut(int s){
            for(int edge[] : graph[s]){
                if(!inMST[edge[0]]){
                    pq.add(edge);
                }
            }
        }

        int getCost(){
            return cost;
        }

        boolean allConnected(){
            for(int i = 0 ; i < inMST.length ; i++)
            {
                if(!inMST[i]){
                    return false;
                }
            }

            return true;
        }
    }

    List<int[]>[] buildGraph(int[][] points){
        int n = points.length;
        List<int[]> graph[] = new LinkedList[n];

        for(int i = 0 ; i < n ; i++)
        {
            graph[i] = new LinkedList<>();
        }

        for(int i = 0 ; i < n ; i++)
        {
            for(int j = i + 1 ; j < n ; j++)
            {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dis = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                graph[i].add(new int[]{j, dis});
                graph[j].add(new int[]{i, dis});
            }
        }
        return graph;
    }

    public int minCostConnectPoints(int[][] points) {
        List<int[]> graph[] = buildGraph(points);
        Prim prim = new Prim(graph);

        return prim.getCost();
    }   
}
