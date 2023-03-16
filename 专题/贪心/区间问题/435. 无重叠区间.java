class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[1] - b[1]));
        int res = 1;
        int end = intervals[0][1];
        for(int[] interval : intervals){
            int start = interval[0];
            if(start >= end){
                end = interval[1];
                res++;
            }
        }
        return intervals.length - res;
    }
}
