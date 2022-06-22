class Solution {

    class Prim{

        boolean inMST[];
        int sumWeight = 0;
        List<int[]> graph[];
        PriorityQueue<int[]> pq;

        public void cut(int s){
            for(int edge[] : graph[s]){
                if(!inMST[edge[1]]){
                    pq.offer(edge);
                }
            }
        }

        public int getSumWeight(){
            return sumWeight;
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

        public Prim(List<int[]> graph[]){
            this.graph = graph;
            inMST = new boolean[graph.length];
            pq = new PriorityQueue<>((a, b) -> { return a[2] - b[2]; });

            inMST[0] = true;
            cut(0);

            while(!pq.isEmpty()){
                int edge[] = pq.poll();
                if(!inMST[edge[1]]){
                    sumWeight += edge[2];
                    inMST[edge[1]] = true;
                    cut(edge[1]);
                }
            }
        }

    }

    public List<int[]>[] buildGraph(int[][] points){
        int n = points.length;
        List<int[]> graph[] = new LinkedList[n];
        for(int i = 0 ; i < n ; i++)
        {
            graph[i] = new LinkedList();
        }

        for(int i = 0 ; i < n ; i++)
        {
            for(int j = i + 1 ; j < n ; j++)
            {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int weight = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                graph[i].add(new int[]{i, j, weight});
                graph[j].add(new int[]{j, i, weight});
            }
        }

        return graph;
    }

    public int minCostConnectPoints(int[][] points) {
        List<int[]>[] graph = buildGraph(points);
        Prim prim = new Prim(graph);

        return prim.getSumWeight();
    }
}
