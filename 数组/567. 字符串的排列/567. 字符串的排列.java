class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> windows = new HashMap();
        HashMap<Character, Integer> needs = new HashMap();

        int left = 0, right = 0;
        int start = 0, len = 999999;
        int valid = 0;
        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();

        for(char c : s1CharArray) needs.put(c, needs.getOrDefault(c, 0) + 1);

        while(right < s2CharArray.length)
        {
            char c = s2CharArray[right];
            right++;
            if(needs.containsKey(c)){
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if(windows.get(c).equals(needs.get(c))){
                    valid++;
                }
            }

            //判断窗口左侧何时进行缩小
            while(right - left >= s1CharArray.length)
            {
                if(valid == needs.size()) return true;
                char d = s2CharArray[left];
                left++;
                if(needs.containsKey(d)){
                    if(needs.get(d).equals(windows.get(d))){
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }
        return false;
    }
}
