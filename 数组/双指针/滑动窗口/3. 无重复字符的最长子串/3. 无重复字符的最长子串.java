class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> windows = new HashMap<>();
        int res = 0;
        int left = 0;
        int right = 0;

        while(right < s.length())
        {
            char c = s.charAt(right);
            right++;
            windows.put(c, windows.getOrDefault(c, 0) + 1);

            while(windows.get(c) > 1){
                char d = s.charAt(left);
                left++;
                windows.put(d, windows.get(d) - 1);
            }
            
            res = Math.max(res, right - left);
        }

        return res;
    }
}
