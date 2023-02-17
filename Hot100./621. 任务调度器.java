class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int total = 0;
        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > max){
                max = map.get(c);
            }
        }

        for(char key : map.keySet()){
            if(map.get(key) == max){
                ++total;
            }
        }

        return Math.max(tasks.length, (n + 1) * (max - 1) + total);
    }
}
