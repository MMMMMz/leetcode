class Solution {

    class State{
        int x;
        int y;
        int effortFromStart;

        public State(int x, int y, int effortFromStart){
            this.x = x;
            this.y = y;
            this.effortFromStart = effortFromStart;
        }
    }

    int dirs[][] = new int[][]{{-1, 0},{1, 0},{0, -1},{0, 1}};
    List<int[]> adj(int martix[][], int x, int y){
        int m = martix.length;
        int n = martix[0].length;

        List<int[]> neighbors = new ArrayList();
        for(int dir[] : dirs){
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(nx >= m || nx < 0 || ny >= n || ny < 0){
                continue;
            }

            neighbors.add(new int[]{nx, ny});
        }

        return neighbors;
    }

    int dijkstra(int endX, int endY, int[][] heights){
        int m = heights.length;
        int n = heights[0].length;

        int effortTo[][] = new int[m][n];
        for(int i = 0 ; i < m ; i++)
        {
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }

        effortTo[0][0] = 0;

        Queue<State> pq = new PriorityQueue<>((a, b) -> {return a.effortFromStart - b.effortFromStart; });

        pq.offer(new State(0, 0, 0));

        while(!pq.isEmpty()){
            State curNode = pq.poll();
            int curX = curNode.x;
            int curY = curNode.y;
            int curEffortFromStart = curNode.effortFromStart;

            if(curX == endX && curY == endY){
                return curEffortFromStart;
            }

            if(curEffortFromStart > effortTo[curX][curY]){
                continue;
            }

            for(int neighbor[] : adj(heights, curX, curY)){
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                int effortToNextNode = Math.max(effortTo[curX][curY], Math.abs(heights[curX][curY] - heights[nextX][nextY]));

                if(effortTo[nextX][nextY] > effortToNextNode){
                    effortTo[nextX][nextY] = effortToNextNode;
                    pq.offer(new State(nextX, nextY, effortToNextNode));
                }
            }
        }
        return -1;
    }
    public int minimumEffortPath(int[][] heights) {
        int endX = heights.length - 1;
        int endY = heights[0].length - 1;

        return dijkstra(endX, endY, heights);
    }
}
