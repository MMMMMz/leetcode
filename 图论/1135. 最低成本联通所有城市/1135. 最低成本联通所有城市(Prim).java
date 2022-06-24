class Solution {

    class Prim{
        List<int[]> graph[];
        int cost = 0;
        boolean inMST[];
        PriorityQueue<int[]> pq;

        public Prim(List<int[]>[] graph){
            this.graph = graph;
            int n = graph.length;
            inMST = new boolean[n];
            pq = new PriorityQueue<>((a, b) -> {return a[1] - b[1]; });

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
            //类似于BFS，遍历临边加入优先级队列
            for(int edge[] : graph[s]){
                //若该条边不在队列中，则将其加入，后面每次选权值最小的边
                if(!inMST[edge[0]]){
                    pq.add(edge);
                }
            }
        }

        int getCost(){
            return cost;
        }

        //判断是否包含全部节点
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

    List<int[]>[] buildGraph(int n, int[][] connections){
        List<int[]> graph[] = new LinkedList[n];

        for(int i = 0 ; i < n ; i++)
        {
            graph[i] = new LinkedList<>();
        }

        for(int edge[] : connections){
            graph[edge[0] - 1].add(new int[]{edge[1] - 1, edge[2]});
            graph[edge[1] - 1].add(new int[]{edge[0] - 1, edge[2]});
        }
        return graph;
    }

    public int minimumCost(int n, int[][] connections) {
         List<int[]> graph[] = buildGraph(n, connections);
         Prim prim = new Prim(graph);

         return prim.allConnected() ? prim.getCost() : -1;
    }
}
