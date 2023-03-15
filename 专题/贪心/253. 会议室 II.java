class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        List<Integer> list = new ArrayList<>();
        int maxLen = 0;
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        int res = 0;
        int cur = 0;
        for(int[] interval : intervals){
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
        }
        for(int key : map.keySet()){
            list.add(key);
        }
        Collections.sort(list);

        for(int key : list){
            cur += map.get(key);
            res = Math.max(res, cur);
        }
        cur = 0;
        int begin = 0;
        int end = 0;
        for(int key : list){
            cur += map.get(key);
            if(cur == res){
                begin = key;
            } 
            if(map.get(key) < 0 && cur - map.get(key) == res)
             {
                end = key;
                maxLen += (end - begin);
                begin = end;
            }
        }
        System.out.println(maxLen);
        return res;
    }
}
