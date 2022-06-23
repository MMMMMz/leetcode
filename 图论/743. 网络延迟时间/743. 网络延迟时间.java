class Solution {


    class State{
        int id;
        int distFromStart;

        public State(int id, int distFromStart){
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    
    public int[] dijkstra(int start, List<int[]>[] graph){
        int distTo[] = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);

        distTo[start] = 0;

        Queue<State> pq = new PriorityQueue<>((a,b)->{return a.distFromStart - b.distFromStart;});
        pq.offer(new State(start, 0));

        while(!pq.isEmpty()){
            State curState = pq.poll();
            int curNodeId = curState.id;
            int curDistFromStart = curState.distFromStart;

            if(curDistFromStart > distTo[curNodeId]){
                continue;
            }

            for(int neighbor[] : graph[curNodeId]){
                int nextNodeId = neighbor[0];
                int distToNextNode = distTo[curNodeId] + neighbor[1];

                if(distTo[nextNodeId] > distToNextNode){
                    distTo[nextNodeId] = distToNextNode;
                    pq.offer(new State(nextNodeId, distToNextNode));
                }
            }
        }

        return distTo;
    }

    public List<int[]>[] buildGraph(int[][] times, int n ){
        List<int[]>[] graph = new LinkedList[n];

        for(int i = 0 ; i < n ; i++)
        {
            graph[i] = new LinkedList();
        }

        for(int edge[] : times){
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        return graph;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = buildGraph(times, n + 1);

        int distTo[] = dijkstra(k, graph);
        int res = 0;
        for(int i = 1 ; i < distTo.length ; i++)
        {
            if(distTo[i] == Integer.MAX_VALUE){
                return -1;
            }

            res = Math.max(res, distTo[i]);
        }

        return res;
    }
}
