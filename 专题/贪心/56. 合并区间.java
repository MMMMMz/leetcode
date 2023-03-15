class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        for(int i = 0 ; i < n ; i++){
            if(!list.isEmpty() && list.get(list.size() - 1)[1] >= intervals[i][0]){
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
            } else {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }

        return list.toArray(new int[list.size() - 1][]);
    }
}
