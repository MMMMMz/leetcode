class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int numClass = 0;
        int max = 0;
        for(char c : map.keySet()){
            max = Math.max(max, map.get(c));
        }
        for(char c : map.keySet()){
            if(map.get(c) == max){
                ++numClass;
            }
        }

        return Math.max(tasks.length, (max - 1) * (n + 1) + numClass);
    }
}
