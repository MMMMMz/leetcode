class Solution {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    void traverse(int[][] graph, int s, LinkedList<Integer> path){
        path.add(s);

        int n = graph.length;
        if(s == n - 1){
            //此处注意使用一个新的list，因为旧的一直在被修改
            res.add(new LinkedList(path));
        }
        for(int v : graph[s]){
            traverse(graph, v, path);
        }

        path.removeLast();
    }
}
