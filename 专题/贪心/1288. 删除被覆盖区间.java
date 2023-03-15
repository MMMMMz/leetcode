class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        List<int[]> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(!list.isEmpty() && list.get(list.size() - 1)[0] <= intervals[i][0] && intervals[i][1] <= list.get(list.size() - 1)[1]){
                continue;
            } else {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        return list.size();
    }
}
