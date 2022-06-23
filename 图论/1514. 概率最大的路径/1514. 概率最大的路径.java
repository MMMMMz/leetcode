class Solution {

    class State{
        int id;
        double probFromStart;

        public State(int id, double probFromStart){
            this.id = id;
            this.probFromStart = probFromStart;
        }
    }

     List<double[]>[] buildGraph(int n, int[][] edges, double[] succProb){
         List<double[]>[] graph = new LinkedList[n];
         for(int i = 0 ; i < n ; i++)
         {
             graph[i] = new LinkedList<>();
         }
        
        for(int i = 0 ; i < edges.length ; i++)
        {
            graph[edges[i][0]].add(new double[]{(double) edges[i][1], succProb[i]});
            graph[edges[i][1]].add(new double[]{(double) edges[i][0], succProb[i]});
        }
         

         return graph;
     }

    double dijkstra(int start, int end, List<double[]>[] graph){
        double probTo[] = new double[graph.length];
        Arrays.fill(probTo, -1);
        probTo[start] = 1;

        Queue<State> pq = new PriorityQueue<>((a, b) -> { return Double.compare(b.probFromStart, a.probFromStart); });
        pq.offer(new State(start, 1));

        while(!pq.isEmpty()){
            State cur = pq.poll();
            int curId = cur.id;
            double curProbFromStart = cur.probFromStart;

            if(curId == end){
                return curProbFromStart;
            }

            if(curProbFromStart < probTo[curId]){
                continue;
            }

            for(double neighbor[] : graph[curId]){
                int nextId = (int)neighbor[0];
                double probToNext = probTo[curId] * neighbor[1];

                if(probTo[nextId] < probToNext){
                    probTo[nextId] = probToNext;
                    pq.offer(new State(nextId, probToNext));
                }
            }
        }

        return 0.0;
    }


    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        List<double[]>[] graph = buildGraph(n, edges, succProb);

        return dijkstra(start, end, graph);
    }
}
