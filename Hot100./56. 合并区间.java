class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0] - b[0]));
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        for(int i = 0 ; i < n; i++)
        {   
            int left = intervals[i][0];
            int right = intervals[i][1];
            if(list.size() == 0 || list.get(list.size() - 1)[1] < left){
                list.add(new int[]{left, right});
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], right);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
