class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]));
        List<int[]> list = new ArrayList<>();
        for(int i = 0 ; i < intervals.length ; i++){
            
            if(list.size() != 0 && find(intervals[i], list) != -1){
                list.get(find(intervals[i], list))[1] = intervals[i][1];
            } else{
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        return list.size();
    }

    int find(int[] inter, List<int[]> list){
        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i)[1] <= inter[0]){
                return i;
            }
        }
        return -1;
    }
}
