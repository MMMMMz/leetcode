class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList();
        HashMap<Character, Integer> windows = new HashMap();
        HashMap<Character, Integer> needs = new HashMap();

        int left = 0, right = 0;
        int valid = 0;
        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();

        for(char c : pCharArray) needs.put(c, needs.getOrDefault(c, 0) + 1);

        while(right < sCharArray.length)
        {
            char c = sCharArray[right];
            right++;
            if(needs.containsKey(c)){
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if(windows.get(c).equals(needs.get(c))){
                    valid++;
                }
            }

            if(right - left >= pCharArray.length)
            {
                if(valid == needs.size()) res.add(left);
                char d = sCharArray[left];
                left++;

                if(needs.containsKey(d)){
                    if(windows.get(d).equals(needs.get(d))){
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }

        return res;
    }
}
