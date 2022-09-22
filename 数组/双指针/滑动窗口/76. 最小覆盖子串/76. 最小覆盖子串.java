class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> windows = new HashMap<>();
        int left = 0;
        int right = 0;
        int start = 0;
        int len = 99999;
        int valid = 0;

        for(int i = 0 ; i < t.length() ; i++){
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        while(right < s.length())
        {
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if(windows.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while(valid == need.size()){
                if(right - left < len){
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(windows.get(d).equals(need.get(d))){
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
                
            }
        }

        return len == 99999 ? "" : s.substring(start, start + len);
    }
}
