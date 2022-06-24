class Solution {

    class State{
        int x;
        int y;
        int distFromStart;

        public State(int x, int y, int distFromStart){
            this.x = x;
            this.y = y;
            this.distFromStart = distFromStart;
        }
    }

    int dirs[][] = new int[][]{{0, 1},{0, -1},{1, 0},{-1, 0}};

    List<int[]> getNeighbors(int[][] martix, int x, int y){
        int m = martix.length;
        int n = martix[0].length;

        List<int[]> neighbors = new ArrayList<>();

        for(int dir[] : dirs){
            int x2 = x + dir[0];
            int y2 = y + dir[1];
            if(x2 >= 0 && x2 < m && y2 >= 0 && y2 < n){
                neighbors.add(new int[]{x2, y2});
            }
        }

        return neighbors;
    }

    int dijkstra(int[][] martix, int endX, int endY)
    {
        int m = martix.length;
        int n = martix[0].length;

        int distTo[][] = new int[m][n];
        for(int i = 0 ; i < m ; i++)
        {
            Arrays.fill(distTo[i], Integer.MAX_VALUE);
        }
        

        distTo[0][0] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> { return a.distFromStart - b.distFromStart; });
        pq.add(new State(0,0,0));

        while(!pq.isEmpty()){
            State cur = pq.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curDistFromStart = cur.distFromStart;

            if(curX == endX && curY ==endY){
                return curDistFromStart;
            }
            if(curDistFromStart > distTo[curX][curY]){
                continue;
            }

            for(int neighbor[] : getNeighbors(martix, curX, curY)){
                int neighborX = neighbor[0];
                int neighborY = neighbor[1];

                int distToNeighbor = Math.max(distTo[curX][curY], Math.abs(martix[neighborX][neighborY] - martix[curX][curY]));
                if(distTo[neighborX][neighborY] > distToNeighbor){
                    distTo[neighborX][neighborY] = distToNeighbor;
                    pq.add(new State(neighborX, neighborY, distToNeighbor));
                }
            }
        }
        return -1;
    }

    public int minimumEffortPath(int[][] heights) {
        return dijkstra(heights, heights.length - 1, heights[0].length - 1);
    }
}
