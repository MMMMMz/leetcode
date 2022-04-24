class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> windows = new HashMap();
        HashMap<Character, Integer> needs = new HashMap();

        for(char c : t.toCharArray()) needs.put(c, needs.getOrDefault(c, 0) + 1);

        int left = 0;
        int right = 0;
        int valid = 0;  // 窗口中满足needs要求的字符数量
        int start = 0, len = 999999;
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        while(right < sCharArray.length)
        {
            char c = sCharArray[right];
            right++;
            //进行数据更新
            if(needs.containsKey(c)){
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if(windows.get(c).equals(needs.get(c))){
                    valid++;
                }
            }
            

            while(valid == needs.size()){
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                char d = sCharArray[left];
                left++;
                //进行数据更新
                if(needs.containsKey(d)){
                    if(windows.get(d).equals(needs.get(d))){
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }
        // System.out.print(start +" " +len);
        // 返回最小覆盖子串
        return (len == 999999) ? "" : s.substring(start, start + len);
    }
}
