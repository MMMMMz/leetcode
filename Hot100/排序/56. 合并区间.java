class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> list = new ArrayList<>();
        for(int[] nums : intervals){
            if(list.size() == 0 || list.get(list.size() - 1)[1] < nums[0]){
                list.add(new int[]{nums[0], nums[1]});
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], nums[1]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
