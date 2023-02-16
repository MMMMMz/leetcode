class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while(right - left > p.length() - 1){
                if(check(map, window)) res.add(left);
                char d = s.charAt(left);
                window.put(d, window.get(d) - 1);
                left++;
            }
        }
        return res;
    }

    boolean check(Map<Character, Integer> map, Map<Character, Integer> window){
        for(Character key : map.keySet()){
            if(!map.get(key).equals(window.get(key))){
                return false;
            }
        }
        return true;
    }
}
