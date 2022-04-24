class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int res = 0;
        HashMap<Character, Integer> windows = new HashMap();
        char[] sCharArray = s.toCharArray();
        while(right < sCharArray.length)
        {
            char c = sCharArray[right];
            right++;
            windows.put(c, windows.getOrDefault(c, 0) + 1);

            while(windows.get(c) > 1)
            {
                char d = sCharArray[left];
                left++;
                windows.put(d, windows.get(d) - 1);
            }

            res = Math.max(res, right - left);
        }

        return res;
    }
}
