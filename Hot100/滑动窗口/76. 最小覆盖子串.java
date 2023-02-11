class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        String res = s + t;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while(check(window, map)){
                char d = s.charAt(left);
                window.put(d, window.get(d) - 1);
                res = (res.length() > (right - left) ? s.substring(left, right) : res);
                left++;
            }
        }
        return res.equals(s + t) ? "" : res;
    }
    boolean check(Map<Character, Integer> window, Map<Character, Integer> map){
            Set<Character> keys = map.keySet();
            for(char c : keys){
                if(!window.containsKey(c)) return false;
                if(window.get(c) < map.get(c)) return false;
            }
            return true;
    }
        
}
